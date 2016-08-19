package com.besixplus.sii.objects;

/**
 * CLASE Cgg_tct_catalogo
 * TABLA: TCT CATALOGO
 * DESCRIPCION:ALMACENA INFORMACION DE LOS DISTINTOS CATALOGOS PARA TCT QUE PUEDEN LLEVARSE EN EL SISTEMA
 * ABREVIATURA:CAT*/
 
public class Cgg_isla_hotel {

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     */
    private String mycdisho_codigo;
    /**
     * NOMBRE DEL TCT CATEGORIA
     */
    private String mycdisho_nombre;

    /**
     * CONSTRUCTOR DE LA CLASE Cgg_tct_categoria
     */
    public Cgg_isla_hotel(){}
    /**
     * CONSTRUCTOR DE LA CLASE Cgg_tct_categoria
     * @param inTctcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     * @param inTctcat_nombre NOMBRE DEL TCT CATEGORIA
     */
    public Cgg_isla_hotel(
            String incdisho_codigo,
            String incdisho_nombre
    ){
        this.setCDISHO_CODIGO(incdisho_codigo);
        this.setCDISHO_NOMBRE(incdisho_nombre);
    }

    /**
     * ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     * @param inTctcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     */
    public void setCDISHO_CODIGO(String incdisho_codigo){
        this.mycdisho_codigo = incdisho_codigo;
    }
    /**
     * OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     * @return String IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     */
    public String getCDISHO_CODIGO(){
        return this.mycdisho_codigo;
    }

    /**
     * ESTABLECE NOMBRE DEL TCT CATEGORIA
     * @param inTctcat_nombre NOMBRE DEL TCT CATEGORIA
     */
    public void setCDISHO_NOMBRE(String incdisho_nombre){
        this.mycdisho_nombre = incdisho_nombre;
    }
    /**
     * OBTIENE NOMBRE DEL TCT CATEGORIA
     * @return String NOMBRE DEL TCT CATEGORIA
     */
    public String getCDISHO_NOMBRE(){
        return this.mycdisho_nombre;
    }
}
