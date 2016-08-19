package com.bmlaurus.camel.processor;

import com.bmlaurus.invoker.BackEndInvokerVoParameter;
import com.bmlaurus.invoker.BackendInvoker;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsumeProcessor implements Processor {

    private static final Logger logger = Logger.getLogger(ConsumeProcessor.class.getName());
   private BackendInvoker backendInvoker = new BackendInvoker();

    public void process(Exchange exchange) throws Exception {
        try {
            String routeId = exchange.getFromRouteId();
            BackEndInvokerVoParameter param =(BackEndInvokerVoParameter) exchange.getIn().getBody();
            logger.info("EL MENSAJE FUE CONSUMIDO RUTA :" + routeId + "SE INVOCARA A: "+ param.getSoapClassName() + " METODO:  "+ param.getSoapMethodName());
            String backendWsResult = backendInvoker.invokeBackendWs(param);
            logger.info("RESULTADO DE LA LLAMADA AL WS: "+backendWsResult);
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"",e);
        }
    }
}