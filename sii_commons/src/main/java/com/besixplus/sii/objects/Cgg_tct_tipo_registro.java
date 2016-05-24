package com.besixplus.sii.objects;

/**
 * CLASE Cgg_tct_tipo_registro
 * TABLA: TCT TIPO REGISTRO
 * DESCRIPCION:ALMACENA INFORMACION DE LOS DISTINTOS TIPOS DE REGISTROS QUE PUEDEN LLEVARSE EN EL SISTEMA
 * ABREVIATURA:TCTTR
 */
public class Cgg_tct_tipo_registro {

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TCT TIPO REGSITRO
     */
    private String myTcttr_codigo;
    /**
     * NOMBRE DEL TCT TIPO REGSITRO
     */
    private String myTcttr_nombre;

    /**
     * CONSTRUCTOR DE LA CLASE Cgg_tct_tipo_registro
     */
    public Cgg_tct_tipo_registro(){}
    /**
     * CONSTRUCTOR DE LA CLASE Cgg_tct_tipo_registro
     * @param inTcttr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT TIPO REGISTRO
     * @param inTcttr_nombre NOMBRE DEL TCT TIPO REGISTRO
     */
    public Cgg_tct_tipo_registro(
            String inTcttr_codigo,
            String inTcttr_nombre
    ){
        this.setTCTTR_CODIGO(inTcttr_codigo);
        this.setTCTTR_NOMBRE(inTcttr_nombre);
    }

    /**
     * ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TCT TIPO REGISTRO
     * @param inTcttr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT TIPO REGISTRO
     */
    public void setTCTTR_CODIGO(String inTcttr_codigo){
        this.myTcttr_codigo = inTcttr_codigo;
    }
    /**
     * OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TCT TIPO REGISTRO
     * @return String IDENTIFICATIVO UNICO DE REGISTRO DE TCT TIPO REGISTRO
     */
    public String getTCTTR_CODIGO(){
        return this.myTcttr_codigo;
    }

    /**
     * ESTABLECE NOMBRE DEL TCT TIPO REGISTRO
     * @param inTcttr_nombre NOMBRE DEL TCT TIPO REGISTRO
     */
    public void setTCTTR_NOMBRE(String inTcttr_nombre){
        this.myTcttr_nombre = inTcttr_nombre;
    }
    /**
     * OBTIENE NOMBRE DEL TCT TIPO REGISTRO
     * @return String NOMBRE DEL TCT TIPO REGISTRO
     */
    public String getTCTTR_NOMBRE(){
        return this.myTcttr_nombre;
    }
}
