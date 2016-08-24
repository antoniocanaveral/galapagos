package com.bmlaurus.camel;


import com.bmlaurus.Util.MensajeriaPropertiesManager;
import com.bmlaurus.Util.constantes.Constantes;
import com.bmlaurus.camel.processor.ConsumeProcessor;
import com.bmlaurus.camel.processor.ErrorProcessor;
import com.bmlaurus.invoker.BackEndInvokerVoParameter;
import com.bmlaurus.virtual.VirtualCache;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by User on 8/2/16.
 */
@Startup
@Singleton
public class CamelSingleton {

    private static Logger logger = Logger.getLogger("CamelSingleton");

    CamelContext camelContext;
    private String ACTIVE_MQ_PORT = "61616";
    private int maximumRedeliveries = -1;
    private long redeliveryDelay = 100L;
    private ProducerTemplate template;
    private String ipOrigen = null;
    private String ipDestino = null;
    private HashMap<String, List<String>> mapClassMethod = null;

    @PostConstruct
    void init() {
        Properties config = VirtualCache.getConfig(VirtualCache.PROP_INTEGRATION_CONF);
        if(config!=null && Boolean.valueOf(config.getProperty("ENABLE_INTEGRATION"))) {
            ACTIVE_MQ_PORT = MensajeriaPropertiesManager.getActiveMqPort();
            maximumRedeliveries = MensajeriaPropertiesManager.getMaximumDeliveries(maximumRedeliveries);
            redeliveryDelay = MensajeriaPropertiesManager.getRedeliveryDelay(redeliveryDelay);
            ipOrigen = MensajeriaPropertiesManager.getOriginIp();
            ipDestino = MensajeriaPropertiesManager.getDestinyIp();

            mapClassMethod = MensajeriaPropertiesManager.getClasesMetodosIntegrados();

            try {
                camelContext = new DefaultCamelContext();
                ConsumeProcessor consumeProcessor = new ConsumeProcessor();
                ErrorProcessor errorProcessor = new ErrorProcessor(MensajeriaPropertiesManager.getHomePath());
                template = camelContext.createProducerTemplate();
                camelContext.addComponent(Constantes.ACTIVEMQ_ORIGEN, ActiveMQComponent.activeMQComponent(generateMqDestination(ipOrigen, ACTIVE_MQ_PORT)));
                camelContext.addComponent(Constantes.ACTIVEMQ_DESTINO, ActiveMQComponent.activeMQComponent(generateMqDestination(ipDestino, ACTIVE_MQ_PORT)));
                camelContext.addRoutes(createErrorRoute(errorProcessor));
                camelContext.addRoutes(createRoute());
                camelContext.addRoutes(createConsumerRoute(consumeProcessor));
                camelContext.start();

            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error al inicializar el camel", e);
                throw new RuntimeException("FAVOR INICIALIZAR LOS VALORES DE CAMEL CORRECTAMENTE,");
            }
        }
    }


    private String generateMqDestination(String ip, String port){
        StringBuilder destination= new StringBuilder("tcp://");
        destination.append(ip);
        destination.append(":");
        destination.append(port);
        return destination.toString();
    }

    private RouteBuilder createErrorRoute(final ErrorProcessor errorProcessor) {
        RouteBuilder routeBuilder = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(Constantes.ERRORS_ENDPOINT).log("NO SE ENVIO EL MENSAJE:").process(errorProcessor).to(Constantes.ACTIVEMQ_ORIGEN + ":dead_msgs");
            }
        };
        return routeBuilder;
    }

    private RouteBuilder createRoute() {
        RouteBuilder routeBuilder = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                errorHandler(deadLetterChannel(Constantes.ERRORS_ENDPOINT)
                        .maximumRedeliveries(maximumRedeliveries).redeliveryDelay(redeliveryDelay));
                from(Constantes.SEDA_ENDPOINT).to(Constantes.ACTIVEMQ_DESTINO + ":queue:QUEUE.WS").end();
            }
        };
        return routeBuilder;
    }


    private RouteBuilder createConsumerRoute(final ConsumeProcessor consumeProcessor) {
        RouteBuilder routeBuilder = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(Constantes.ACTIVEMQ_ORIGEN + ":queue:QUEUE.WS").process(consumeProcessor).end();
            }
        };
        return routeBuilder;
    }

    public void camelSendMsg(BackEndInvokerVoParameter parameter) {
        try {
            HashMap<String, Object> headers = new HashMap<String, Object>();
            headers.put(Constantes.HEADER_SOAP_CLASSNAME,parameter.getSoapClassName());
            headers.put(Constantes.HEADER_SOAP_METHODNAME,parameter.getSoapMethodName());
            template.sendBodyAndHeaders(Constantes.SEDA_ENDPOINT, parameter, headers);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al enviar el mensaje", e);
        }
    }

    @PreDestroy
    public void destroy(){
        try {
            if(camelContext!=null)
                camelContext.stop();
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"",e);
        }
    }


    public HashMap<String, List<String>> getClasesMetodosIntegrados(){
        if(mapClassMethod == null){
            mapClassMethod = MensajeriaPropertiesManager.getClasesMetodosIntegrados();
        }
        return mapClassMethod;
    }
}
