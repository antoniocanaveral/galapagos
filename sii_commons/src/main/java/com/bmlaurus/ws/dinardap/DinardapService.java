package com.bmlaurus.ws.dinardap;

import com.bmlaurus.ws.service.ConnectionUtils;
import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by acanaveral on 29/6/16.
 */
public abstract class DinardapService {

    //Elementos para Manejo de errores
    public static String KEY_ERROR_CODE         = "errorCode";
    public static String KEY_ERROR_DESCRIPTION  = "errorDescription";
    //Elementos del WS
    public static String KEY_MENSAJE            = "mensaje";
    public static String KEY_CODIGO_PAQUETE     = "codigoPaquete";
    public static String KEY_INSTITUCIONES      = "instituciones";
    public static String KEY_DATOS_PRINCIPALES  = "datosPrincipales";
    public static String KEY_NOMBRE             = "nombre";
    public static String KEY_DETALLE            = "detalle";

    public static int SERVICE_RC        = 234;
    public static int SERVICE_CNE       = 235;
    public static int SERVICE_SNRM      = 236;
    public static int SERVICE_SRI       = 237;
    public static int SERVICE_SENESCYT  = 238;
    public static int SERVICE_SERCOP    = 239;
    public static int SERVICE_IESS      = 240;
    public static int SERVICE_ME        = 241;
    public static int SERVICE_SUPER     = 242;
    public static int SERVICE_ANT       = 243;

    public static String CALL_OK    = "OK";
    public static String CALL_ERROR = "ERROR";
    public static String SERVICE_ERROR = "No es posible establecer una conexión con el servicio";

    protected String numeroIdentificacion;

    protected transient Map<String,Object> resultMap;
    protected transient Map instituciones;
    protected transient Map datosPrincipales;
    protected transient Map detalle;
    protected int serviceType;
    protected String serviceName;
    protected String resultStaus;

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getResultStaus() {
        return resultStaus;
    }

    public DinardapService(int serviceType, String numeroIdentificacion) {
        this.serviceType = serviceType;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    private String populateService(){
        ConnectionUtils utils = new ConnectionUtils();
        String result = CALL_ERROR;
        resultStaus = CALL_ERROR;
        try {
            result =  utils.getFichaGeneral(numeroIdentificacion,serviceType);
            resultMap = new Gson().fromJson(result, Map.class);
            instituciones = (Map) resultMap.get(KEY_INSTITUCIONES);
            if(instituciones!=null) {
                datosPrincipales = (Map) instituciones.get(KEY_DATOS_PRINCIPALES);
                detalle = (Map) instituciones.get(KEY_DETALLE);
                serviceName = (String) instituciones.get(KEY_NOMBRE);
            }else{
                //Debe haber un error
                System.err.println(result);
                result = CALL_ERROR;
                resultStaus = CALL_ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * Llama al servicio y llena los mapas
     * */
    public String callService(){
        return populateService();
    }

    /**
     * Llama al servicio y llena los campos del Objeto que lo invoca.
     * */
    public String callServiceAsObject() {
        String result = populateService();
        if(!result.equals(CALL_ERROR)){
            if(datosPrincipales!=null) {
                List<Map> registros = (List<Map>) datosPrincipales.get("registros");
                for (Map record : registros) {
                    try {
                        if (record.get("valor") != null) {
                            Field field = this.getClass().getDeclaredField(record.get("campo").toString());
                            setFieldValue(field, record.get("valor").toString());
                        }
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }
                //Llenamos el detalle
                if (detalle != null && detalle.size() > 0) {
                    try {
                        List<Map> records;
                        if (detalle.get("items") instanceof List)
                            records = (List<Map>) detalle.get("items");
                        else {
                            List record = new ArrayList();
                            record.add(detalle.get("items"));
                            records = record;
                        }
                        String className = null;
                        List detalles = new ArrayList();
                        for (Map pair : records) {
                            List<Map> items = (List<Map>) pair.get("registros");
                            className = pair.get("nombre").toString().replace(" ", "");
                            try {
                                Class clazz = Class.forName("com.bmlaurus.ws.dinardap." + className.trim());
                                Object refItems = clazz.newInstance();
                                for (Map record : items) {
                                    try {
                                        if (record.get("valor") != null) {
                                            Field field = refItems.getClass().getDeclaredField(record.get("campo").toString());
                                            String setterName = "set" + capitalize(field.getName());
                                            Method setter = refItems.getClass().getDeclaredMethod(setterName, String.class);
                                            setter.invoke(refItems, record.get("valor").toString());
                                        }
                                    } catch (NoSuchFieldException e) {
                                        e.printStackTrace();
                                    } catch (NoSuchMethodException e) {
                                        e.printStackTrace();
                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    }
                                }
                                detalles.add(refItems);
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }

                        Field field = this.getClass().getDeclaredField(className);
                        setFieldArrayValue(field, detalles);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                resultStaus = CALL_OK;
                return CALL_OK;
            }else{
                resultStaus = CALL_ERROR;
                return CALL_ERROR;
            }
        }
        resultStaus = CALL_ERROR;
        return CALL_ERROR;
    }

    private void setFieldValue(Field field,String value){
        String setterName = "set"+capitalize(field.getName());
        try {
            Method setter = this.getClass().getDeclaredMethod(setterName,String.class);
            setter.invoke(this,value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void setFieldArrayValue(Field field,List value){
        String setterName = "set"+capitalize(field.getName());
        try {
            Method setter = this.getClass().getDeclaredMethod(setterName,List.class);
            setter.invoke(this,value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
