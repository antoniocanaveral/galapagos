package com.bmlaurus.alfresco.model;

import com.bmlaurus.alfresco.integration.SiiFileResult;

import java.io.Serializable;
import java.util.List;

/**
 * Created by acanaveral on 26/5/16.
 */
public class SiiModelFile implements Serializable{

    private static final long serialVersionUID = 4847214993952598944L;

    public static final String DOCUMENT_TYPE_PERSONALES = "D:sii:personales";
    public static final String DOCUMENT_TYPE_RESPALDO = "D:sii:respaldo";

    private String code;
    private String fileName;
    private String fileDescription;
    private String documentType;
    private String fileRepository;
    private boolean overrideName;
    private List<SiiModelIndexDefinition> indexDefinitionList;
    //Standard
    private boolean estado;
    private String usuario_insert;
    private String usuario_update;

    //Contenido
    private SiiFileResult fileResult;

    public SiiModelFile(String code, String fileName, String fileDescription, String documentType, String fileRepository, boolean overrideName, boolean estado, String usuario_insert, String usuario_update) {
        this.code = code;
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.documentType = documentType;
        this.fileRepository = fileRepository;
        this.overrideName = overrideName;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getFileRepository() {
        return fileRepository;
    }

    public void setFileRepository(String fileRepository) {
        this.fileRepository = fileRepository;
    }

    public boolean isOverrideName() {
        return overrideName;
    }

    public void setOverrideName(boolean overrideName) {
        this.overrideName = overrideName;
    }

    public List<SiiModelIndexDefinition> getIndexDefinitionList() {
        return indexDefinitionList;
    }

    public void setIndexDefinitionList(List<SiiModelIndexDefinition> indexDefinitionList) {
        this.indexDefinitionList = indexDefinitionList;
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

    public SiiFileResult getFileResult() {
        return fileResult;
    }

    public void setFileResult(SiiFileResult fileResult) {
        this.fileResult = fileResult;
    }
}
