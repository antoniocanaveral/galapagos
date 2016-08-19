package com.bmlaurus.Util;

import com.bmlaurus.Util.constantes.Constantes;
import com.bmlaurus.virtual.VirtualCache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by User on 8/2/16.
 */
public class MensajeriaPropertiesManager {

    private static Properties properties = null;
    private static Logger logger = Logger.getLogger("MensajeriaPropertiesManager");

    static {
        if (properties == null) {
            loadPropertiesFile();
        }
    }

    private static void loadPropertiesFile() {
        properties  = VirtualCache.getConfig(VirtualCache.PROP_INTEGRATION_CONF);
    }


    public static String getActiveMqPort() {
        String activeMqPort = null;
        if (properties != null) {
            activeMqPort = properties.getProperty(Constantes.ACTIVEMQ_PORT);
        }
        return activeMqPort;
    }

    public static String getOriginIp() {
        String value = null;
        if (properties != null) {
            value = properties.getProperty(Constantes.ORIGEN);
        }
        return value;
    }

    public static String getDestinyIp() {
        String value = null;
        if (properties != null) {
            value = properties.getProperty(Constantes.DESTINO);
        }
        return value;
    }

    public static Long getRedeliveryDelay(Long redeliveryDelay) {
        if (properties != null) {
            try {
                String redeliveryDelayStr = properties.getProperty(Constantes.REDELIVERY_DELAY);
                redeliveryDelay = Long.parseLong(redeliveryDelayStr);
            }
            catch(Exception e){
                //do nothing.
                logger.log(Level.SEVERE,"NO SE PUEDE OBTENER EL TIMEOUT DE CAMEL DEBERIA ESTAN EN EL PROPERTIES",e);
            }

        }
        return redeliveryDelay;
    }

    public static int getMaximumDeliveries(int maximumDeliveries) {
        if (properties != null) {
            try {
                String maximuDeliveriesStr = properties.getProperty(Constantes.MAXIMUM_REDELIVERIES);
                maximumDeliveries = Integer.parseInt(maximuDeliveriesStr);
            }
            catch(Exception e){
                //do nothing.
                logger.log(Level.SEVERE,"NO SE PUEDE OBTENER EL TIMEOUT DE CAMEL DEBERIA ESTAN EN EL PROPERTIES",e);
            }

        }
        return maximumDeliveries;
    }


    public static  HashMap<String, List<String>> getClasesMetodosIntegrados() {
        HashMap<String, List<String>> value = null;
        if (properties != null) {
            String valueStr = properties.getProperty(Constantes.CLASES_METODOS_INTEGRADOS);
            value = generateMapMethod(valueStr);
        }
        return value;
    }

    private static HashMap<String, List<String>> generateMapMethod(String archivoLinea) {
        HashMap<String, List<String>> mapMethod = new HashMap<>();
        if (archivoLinea != null && !archivoLinea.isEmpty()) {
            String[] classArray = archivoLinea.split("//");
            if (classArray != null && classArray.length > 0) {
                for (String classMethod : classArray) {
                    String[] classMethodArray = classMethod.split("=");
                    if (classMethodArray != null && classMethodArray.length == 2) {
                        String className = classMethodArray[0];
                        String methodsStr = classMethodArray[1];
                        if (!className.isEmpty() && !methodsStr.isEmpty()) {
                            List<String> methodList = new ArrayList<String>();
                            String[] methodArray = methodsStr.split("/");
                            if (methodArray != null && methodArray.length > 0) {
                                for(String methodName:methodArray){
                                    methodList.add(methodName);
                                }
                            }
                            mapMethod.put(className,methodList );
                        }
                    }
                }
            }
        }
        return mapMethod;
    }


    public static String getHomePath() throws Exception {
        String armadaHome = getEnv(Constantes.SII_HOME);
        if (armadaHome == null) {
            armadaHome = System.getProperty("armada.home");
        }
        if (armadaHome == null || armadaHome.length() <= 0) {
            throw new Exception("No se encontro la carpeta de armada home");
        }

        return armadaHome + getFileSeparator();
    }


    private static String getEnv(String name) {
        return System.getenv(name);
    }

    private static String getFileSeparator() {
        return File.separator;
    }

}
