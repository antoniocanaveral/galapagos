package com.besixplus.sii.objects;

/**
 * CLASE Cgg_res_documentacion_solicitada
 * TABLA: TIPO TRAMITE
 * DESCRIPCION:ALMACENA INFORMACION DE LOS DIVERSOS TIPOS DE TRAMITE QUE PUEDEN LLEVARSE EN EL SISTEMA
 * ABREVIATURA:CRDCSL
 */
public class Cgg_res_documentacion_solicitada {

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE DOCUMENTO
     */
    private String myCrdcsl_codigo;
    /**
     * DESCRIPCION DEL DOCUMENTO
     */
    private String myCrdcsl_descripcion;

    /**
     * TIPO DE TRAMITE
     */
    private String myCrdcsl_tipo;

    /**
     * CONSTRUCTOR DE LA CLASE Cgg_res_documentacion_solicitada
     */
    public Cgg_res_documentacion_solicitada(){}
    /**
     * CONSTRUCTOR DE LA CLASE Cgg_res_documentacion_solicitada
     * @param inCrdcsl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE DOCUMENTO
     * @param inCrdcsl_descripcion DESCRIPCION DEL TIPO DE DOCUMENTO
     * @param inCrdcsl_tipo TIPO DE TRAMITE
     */
    public Cgg_res_documentacion_solicitada(
            String inCrdcsl_codigo,
            String inCrdcsl_descripcion,
            String inCrdcsl_tipo
    ){
        this.setCRDCSL_CODIGO(inCrdcsl_codigo);
        this.setCRDCSL_DESCRIPCION(inCrdcsl_descripcion);
        this.setCRDCSL_TIPO(inCrdcsl_tipo);
    }

    /**
     * ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE DOCUMENTO
     * @param inCrdcsl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE DOCUMENTO
     */
    public void setCRDCSL_CODIGO(String inCrdcsl_codigo){
        this.myCrdcsl_codigo= inCrdcsl_codigo;
    }
    /**
     * OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE DOCUMENTO
     * @return String IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE DOCUMENTO
     */
    public String getCRDCSL_CODIGO(){
        return this.myCrdcsl_codigo;
    }

    /**
     * ESTABLECE DESCRICION DEL TIPO DE DOCUMENTO
     * @param inCrdcsl_descripcion DESCRIPCION DEL TIPO DE DOCUMENTO
     */
    public void setCRDCSL_DESCRIPCION(String inCrdcsl_descripcion){
        this.myCrdcsl_descripcion= inCrdcsl_descripcion;
    }
    /**
     * OBTIENE DESCRIPCION DEL TIPO DE DOCUMENTO
     *@return String DESCRIPCION DEL TIPO DE DOCUMENTO
     */
    public String getCRDCSL_DESCRIPCION(){
        return this.myCrdcsl_descripcion;
    }

    /**
     * ESTABLECE TIPO DE TRAMITE DEL TIPO DE DOCUMENTO
     * @param inCrdcsl_tipo TIPO DE TRAMITE DEL TIPO DE DOCUMENTO
     */
    public void setCRDCSL_TIPO(String inCrdcsl_tipo){
        this.myCrdcsl_tipo= inCrdcsl_tipo;
    }
    /**
     * OBTIENE TIPO DE TRAMITE DEL TIPO DE DOCUMENTO
     *@return String TIPO DE TRAMITE DEL TIPO DE DOCUMENTO
     */
    public String getCRDCSL_TIPO(){
        return this.myCrdcsl_tipo;
    }
}
