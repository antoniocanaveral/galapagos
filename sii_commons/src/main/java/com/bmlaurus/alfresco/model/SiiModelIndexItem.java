package com.bmlaurus.alfresco.model;

import java.io.Serializable;

/**
 * Created by acanaveral on 26/5/16.
 */
public class SiiModelIndexItem implements Serializable {

    private static final long serialVersionUID = -76040559978996940L;

    private String code;
    private String itemName;
    private String itemDataType;
    private String itemLabel;
    private boolean isMandatory;
    //Standard
    private boolean estado;
    private String usuario_insert;
    private String usuario_update;


    public SiiModelIndexItem(String code, String itemName, String itemDataType, String itemLabel, boolean isMandatory, boolean estado, String usuario_insert, String usuario_update) {
        this.code = code;
        this.itemName = itemName;
        this.itemDataType = itemDataType;
        this.itemLabel = itemLabel;
        this.isMandatory = isMandatory;
        this.estado = estado;
        this.usuario_insert = usuario_insert;
        this.usuario_update = usuario_update;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDataType() {
        return itemDataType;
    }

    public void setItemDataType(String itemDataType) {
        this.itemDataType = itemDataType;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUsuario_insert() {
        return usuario_insert;
    }

    public void setUsuario_insert(String usuario_insert) {
        this.usuario_insert = usuario_insert;
    }

    public String getUsuario_update() {
        return usuario_update;
    }

    public void setUsuario_update(String usuario_update) {
        this.usuario_update = usuario_update;
    }
}
