package com.besixplus.sii.objects;

/**
 * CLASE Cgg_tct_catalogo
 * TABLA: TCT CATALOGO
 * DESCRIPCION:ALMACENA INFORMACION DE LOS DISTINTOS CATALOGOS PARA TCT QUE PUEDEN LLEVARSE EN EL SISTEMA
 * ABREVIATURA:CAT*/
 
public class Cgg_catalogo {

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     */
    private String mycdcata_codigo;
    /**
     * NOMBRE DEL TCT CATEGORIA
     */
    private String mycdcata_descripcion;

    /**
     * CONSTRUCTOR DE LA CLASE Cgg_tct_categoria
     */
    public Cgg_catalogo(){}
    /**
     * CONSTRUCTOR DE LA CLASE Cgg_tct_categoria
     * @param inTctcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     * @param inTctcat_nombre NOMBRE DEL TCT CATEGORIA
     */
    public Cgg_catalogo(
            String incdcata_codigo,
            String incdcata_descripcion
    ){
        this.setCDCATA_CODIGO(incdcata_codigo);
        this.setCDCATA_DESCRIPCION(incdcata_descripcion);
    }

    /**
     * ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     * @param inTctcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     */
    public void setCDCATA_CODIGO(String incdcata_codigo){
        this.mycdcata_codigo = incdcata_codigo;
    }
    /**
     * OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     * @return String IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     */
    public String getCDCATA_CODIGO(){
        return this.mycdcata_codigo;
    }

    /**
     * ESTABLECE NOMBRE DEL TCT CATEGORIA
     * @param inTctcat_nombre NOMBRE DEL TCT CATEGORIA
     */
    public void setCDCATA_DESCRIPCION(String incdcata_descripcion){
        this.mycdcata_descripcion = incdcata_descripcion;
    }
    /**
     * OBTIENE NOMBRE DEL TCT CATEGORIA
     * @return String NOMBRE DEL TCT CATEGORIA
     */
    public String getCDCATA_DESCRIPCION(){
        return this.mycdcata_descripcion;
    }
}
