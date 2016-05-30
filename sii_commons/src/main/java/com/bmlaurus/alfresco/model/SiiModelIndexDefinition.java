package com.bmlaurus.alfresco.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by acanaveral on 26/5/16.
 */
public class SiiModelIndexDefinition implements Serializable {

    private static final long serialVersionUID = 7258424703897064170L;

    private String code;
    private String name;
    private String description;
    private List<SiiModelIndexItem> itemList;
    //Standard
    private boolean estado;
    private String usuario_insert;
    private String usuario_update;

    public SiiModelIndexDefinition(String code, String name, String description, boolean estado, String usuario_insert, String usuario_update) {
        this.code = code;
        this.name = name;
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SiiModelIndexItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<SiiModelIndexItem> itemList) {
        this.itemList = itemList;
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
