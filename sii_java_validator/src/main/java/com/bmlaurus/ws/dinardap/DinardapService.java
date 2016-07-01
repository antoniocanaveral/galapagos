package com.bmlaurus.ws.dinardap;

import com.bmlaurus.ws.service.ConnectionUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    protected String numeroIdentificacion;
    protected Map<String,Object> resultMap;
    protected Map instituciones;
    protected Map datosPrincipales;
    protected int serviceType;
    protected String serviceName;

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

    public DinardapService(int serviceType, String numeroIdentificacion) {
        this.serviceType = serviceType;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    private String populateService(){
        ConnectionUtils utils = new ConnectionUtils();
        String result = CALL_ERROR;
        try {
            result =  utils.getFichaGeneral(numeroIdentificacion,serviceType);
            resultMap = new Gson().fromJson(result, Map.class);
            instituciones = (Map) resultMap.get(KEY_INSTITUCIONES);
            datosPrincipales = (Map) instituciones.get(KEY_DATOS_PRINCIPALES);
            serviceName = (String) instituciones.get(KEY_NOMBRE);
        } catch (IOException e) {
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
            List<Map> registros = (List<Map>) datosPrincipales.get("registros");
            for(Map record: registros){
                try {
                    if(record.get("valor")!=null) {
                        Field field = this.getClass().getDeclaredField(record.get("campo").toString());
                        setFieldValue(field,record.get("valor").toString());
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            return CALL_OK;
        }
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

    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }
}
