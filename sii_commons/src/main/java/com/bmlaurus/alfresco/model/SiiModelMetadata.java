package com.bmlaurus.alfresco.model;

import com.bmlaurus.alfresco.integration.SiiFolderResult;

import java.io.Serializable;
import java.util.List;

/**
 * Created by acanaveral on 26/5/16.
 */
public class SiiModelMetadata implements Serializable{

    private static final long serialVersionUID = 7731771760501150148L;

    private String code;
    private String tableName;
    private String recordID;
    private String filter;

    private String filesRepository;///Usado cuando no es una lista y la entrada es libre.
    private boolean isList;
    private List<SiiModelFile> fileList;
    //Standard
    private boolean estado;
    private String usuario_insert;
    private String usuario_update;

    //Contenido
    private SiiFolderResult folderResult;


    public SiiModelMetadata(String code, String tableName, String recordID, String filter, String filesRepository, boolean isList, boolean estado, String usuario_insert, String usuario_update) {
        this.code = code;
        this.tableName = tableName;
        this.recordID = recordID;
        this.filter = filter;
        this.filesRepository = filesRepository;
        this.isList = isList;
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

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilesRepository() {
        return filesRepository;
    }

    public void setFilesRepository(String filesRepository) {
        this.filesRepository = filesRepository;
    }

    public boolean isList() {
        return isList;
    }

    public void setIsList(boolean isList) {
        this.isList = isList;
    }

    public List<SiiModelFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<SiiModelFile> fileList) {
        this.fileList = fileList;
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

    public SiiFolderResult getFolderResult() {
        return folderResult;
    }

    public void setFolderResult(SiiFolderResult folderResult) {
        this.folderResult = folderResult;
    }
}
