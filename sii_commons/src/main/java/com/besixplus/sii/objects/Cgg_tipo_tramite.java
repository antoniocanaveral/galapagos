package com.besixplus.sii.objects;

/**
 * CLASE Cgg_tipo_tramite
 * TABLA: TIPO TRAMITE
 * DESCRIPCION:ALMACENA INFORMACION DE LOS DIVERSOS TIPOS DE TRAMITE QUE PUEDEN LLEVARSE EN EL SISTEMA
 * ABREVIATURA:CRTT
 */
public class Cgg_tipo_tramite {

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
     */
    private String myCrtt_codigo;
    /**
     * NOMBRE DEL TIPO DE TRAMITE
     */
    private String myCrtt_nombre;

    /**
     * CONSTRUCTOR DE LA CLASE Cgg_tipo_tramite
     */
    public Cgg_tipo_tramite(){}
    /**
     * CONSTRUCTOR DE LA CLASE Cgg_tipo_tramite
     * @param inCrtt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
     * @param inCrtt_nombre NOMBRE DEL TIPO DE TRAMITE
     */
    public Cgg_tipo_tramite(
            String inCrtt_codigo,
            String inCrtt_nombre
    ){
        this.setCRTT_CODIGO(inCrtt_codigo);
        this.setCRTT_NOMBRE(inCrtt_nombre);
    }

    /**
     * ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
     * @param inCrtt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
     */
    public void setCRTT_CODIGO(String inCrtt_codigo){
        this.myCrtt_codigo = inCrtt_codigo;
    }
    /**
     * OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
     * @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
     */
    public String getCRTT_CODIGO(){
        return this.myCrtt_codigo;
    }

    /**
     * ESTABLECE NOMBRE DEL TIPO DE TRAMITE
     * @param inCrtt_nombre NOMBRE DEL TIPO DE TRAMITE
     */
    public void setCRTT_NOMBRE(String inCrtt_nombre){
        this.myCrtt_nombre = inCrtt_nombre;
    }
    /**
     * OBTIENE NOMBRE DEL TIPO DE TRAMITE
     * @return String NOMBRE DEL TIPO DE TRAMITE
     */
    public String getCRTT_NOMBRE(){
        return this.myCrtt_nombre;
    }
}
