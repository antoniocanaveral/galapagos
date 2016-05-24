package com.besixplus.sii.objects;

/**
 * CLASE Cgg_tct_categoria
 * TABLA: TCT CATEGORIA
 * DESCRIPCION:ALMACENA INFORMACION DE LAS DISTINTAS CATEGORIAS PARA TCT QUE PUEDEN LLEVARSE EN EL SISTEMA
 * ABREVIATURA:TCTCAT
 */
public class Cgg_tct_categoria {

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     */
    private String myTctcat_codigo;
    /**
     * NOMBRE DEL TCT CATEGORIA
     */
    private String myTctcat_nombre;

    /**
     * CONSTRUCTOR DE LA CLASE Cgg_tct_categoria
     */
    public Cgg_tct_categoria(){}
    /**
     * CONSTRUCTOR DE LA CLASE Cgg_tct_categoria
     * @param inTctcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     * @param inTctcat_nombre NOMBRE DEL TCT CATEGORIA
     */
    public Cgg_tct_categoria(
            String inTctcat_codigo,
            String inTctcat_nombre
    ){
        this.setTCTCAT_CODIGO(inTctcat_codigo);
        this.setTCTCAT_NOMBRE(inTctcat_nombre);
    }

    /**
     * ESTABLECE IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     * @param inTctcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     */
    public void setTCTCAT_CODIGO(String inTctcat_codigo){
        this.myTctcat_codigo = inTctcat_codigo;
    }
    /**
     * OBTIENE IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     * @return String IDENTIFICATIVO UNICO DE REGISTRO DE TCT CATEGORIA
     */
    public String getTCTCAT_CODIGO(){
        return this.myTctcat_codigo;
    }

    /**
     * ESTABLECE NOMBRE DEL TCT CATEGORIA
     * @param inTctcat_nombre NOMBRE DEL TCT CATEGORIA
     */
    public void setTCTCAT_NOMBRE(String inTctcat_nombre){
        this.myTctcat_nombre = inTctcat_nombre;
    }
    /**
     * OBTIENE NOMBRE DEL TCT CATEGORIA
     * @return String NOMBRE DEL TCT CATEGORIA
     */
    public String getTCTCAT_NOMBRE(){
        return this.myTctcat_nombre;
    }
}
