package com.bmlaurus.alfresco.model;

import com.bmlaurus.alfresco.db.SiiDataLoader;
import com.bmlaurus.alfresco.integration.SiiFileResult;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by acanaveral on 26/5/16.
 */
public class SiiModelFile implements Serializable{

    private static final long serialVersionUID = 4847214993952598944L;

    public static final String DOCUMENT_TYPE_PERSONALES = "D:sii:personales";
    public static final String DOCUMENT_TYPE_RESPALDO = "D:sii:respaldo";

    private String code;
    private String cgg_ecm_metadata_code;
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

    //Propiedades avanzadas
    private boolean insertable;
    private boolean updateable;
    private boolean mandatory;
    private String visible_role;
    private String editable_role;

    //Contenido
    private SiiFileResult fileResult;

    public SiiModelFile(String code, String cgg_ecm_metadata_code, String fileName, String fileDescription, String documentType, String fileRepository
            , boolean overrideName, boolean estado, String usuario_insert, String usuario_update, boolean insertable, boolean updateable, boolean mandatory
            , String visible_role, String editable_role) {
        this.code = code;
        this.cgg_ecm_metadata_code = cgg_ecm_metadata_code;
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.documentType = documentType;
        this.fileRepository = fileRepository;
        this.overrideName = overrideName;
        this.estado = estado;
        this.usuario_insert = usuario_insert;
        this.usuario_update = usuario_update;
        this.editable_role = editable_role;
        this.visible_role = visible_role;
        this.mandatory = mandatory;
        this.updateable = updateable;
        this.insertable = insertable;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCgg_ecm_metadata_code() {
        return cgg_ecm_metadata_code;
    }

    public void setCgg_ecm_metadata_code(String cgg_ecm_metadata_code) {
        this.cgg_ecm_metadata_code = cgg_ecm_metadata_code;
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

    public boolean isInsertable() {
        return insertable;
    }

    public void setInsertable(boolean insertable) {
        this.insertable = insertable;
    }

    public boolean isUpdateable() {
        return updateable;
    }

    public void setUpdateable(boolean updateable) {
        this.updateable = updateable;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public String getVisible_role() {
        return visible_role;
    }

    public void setVisible_role(String visible_role) {
        this.visible_role = visible_role;
    }

    public String getEditable_role() {
        return editable_role;
    }

    public void setEditable_role(String editable_role) {
        this.editable_role = editable_role;
    }

    public SiiFileResult getFileResult() {
        return fileResult;
    }

    public void setFileResult(SiiFileResult fileResult) {
        this.fileResult = fileResult;
    }

    public String resolveFileRepository(Connection conn, String table_name, String recordID){
        if(this.getFileRepository()!=null){
            try {
                return SiiDataLoader.repoResolver(conn,table_name,recordID,getFileRepository());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public boolean save(Connection conn){
        boolean result = false;
        try {
            PreparedStatement pstmt = conn.prepareCall("SELECT code FROM cgg_ecm_file WHERE code = ?");
            pstmt.setString(1,code);
            ResultSet rs = pstmt.executeQuery();
            String strSQL = null;
            PreparedStatement statement;
            if(rs!=null && rs.next()){
                rs.close();
                pstmt.close();
                //Empezamos con la persistencia
                //UPDATE
                strSQL = "UPDATE sii.cgg_ecm_file SET cgg_ecm_metadata_code=?, file_name=?, file_description=?, document_type=?, file_repository=?," +
                        "            override_name=?, estado=?, usuario_insert=?, usuario_update=? ,insertable=?, updateable=?, mandatory=?," +
                        "            visible_role=?, editable_role=?" +
                        "WHERE code = ?";
                statement = conn.prepareStatement(strSQL);
                statement.setString(1, cgg_ecm_metadata_code);
                statement.setString(2, fileName);
                statement.setString(3, fileDescription);
                statement.setString(4, documentType);
                statement.setString(5, fileRepository);
                statement.setBoolean(6, overrideName);
                statement.setBoolean(7, estado);
                statement.setString(8, usuario_insert);
                statement.setString(9, usuario_update);
                statement.setBoolean(10,insertable);
                statement.setBoolean(11,updateable);
                statement.setBoolean(12,mandatory);
                statement.setString(13,visible_role);
                statement.setString(14,editable_role);
                //
                statement.setString(15,code);
            }else{//INSERT
                strSQL = "INSERT INTO sii.cgg_ecm_file (code, cgg_ecm_metadata_code, file_name, file_description, document_type, file_repository," +
                        "            override_name, estado, usuario_insert, usuario_update," +
                        "            insertable, updateable, mandatory, visible_role, editable_role)" +
                        "    VALUES (?, ?, ?, ?, ?, ?," +
                        "            ?, ?, ?, ?,?,?,?,?,?);";
                statement = conn.prepareStatement(strSQL);
                statement.setString(1,code);
                statement.setString(2, cgg_ecm_metadata_code);
                statement.setString(3, fileName);
                statement.setString(4, fileDescription);
                statement.setString(5, documentType);
                statement.setString(6, fileRepository);
                statement.setBoolean(7, overrideName);
                statement.setBoolean(8, estado);
                statement.setString(9, usuario_insert);
                statement.setString(10, usuario_update);
                statement.setBoolean(11,insertable);
                statement.setBoolean(12,updateable);
                statement.setBoolean(13,mandatory);
                statement.setString(14,visible_role);
                statement.setString(15,editable_role);

                statement.execute();
                statement.close();

                strSQL = "INSERT INTO sii.cgg_ecm_file_index(" +
                        "            cgg_ecm_file_code, cgg_ecm_index_definition_code)" +
                        "    VALUES (?, 'IDX_IDN');";
                statement = conn.prepareStatement(strSQL);
                statement.setString(1,code);
            }
            statement.execute();
            statement.close();
            result=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
