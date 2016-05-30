package com.bmlaurus.alfresco.db;

import com.bmlaurus.alfresco.model.SiiModelFile;
import com.bmlaurus.alfresco.model.SiiModelIndexDefinition;
import com.bmlaurus.alfresco.model.SiiModelIndexItem;
import com.bmlaurus.alfresco.model.SiiModelMetadata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acanaveral on 27/5/16.
 */
public class SiiDataLoader {
    private static List<SiiModelIndexDefinition> indexDefinitions;

    public static SiiModelMetadata getAlfrescoMetadata(java.sql.Connection inConnection, String tableName, String recordId, String filter){
        SiiModelMetadata modelMetadata = null;
        if (tableName!=null && recordId!=null) {
            String strSql = "SELECT * FROM CGG_ECM_METADATA WHERE TABLE_NAME=? AND RECORD_ID=? ";
            if(filter!=null && !filter.isEmpty())
                strSql += " AND FILTER=?";

            PreparedStatement stmt=null;
            ResultSet results=null;
            try {
                stmt = inConnection.prepareStatement(strSql);
                stmt.setString(1,tableName);
                stmt.setString(2,recordId);
                if(filter!=null && !filter.isEmpty())
                    stmt.setString(3,filter);

                results = stmt.executeQuery();
                //Debería devolver solamente 1
                results.next();

                modelMetadata=new SiiModelMetadata(results.getString("CODE"),results.getString("TABLE_NAME"),results.getString("RECORD_ID"),results.getString("FILTER"),
                        results.getString("FILES_REPOSITORY"), results.getBoolean("IS_LIST"), results.getBoolean("ESTADO"),
                        results.getString("USUARIO_INSERT"), results.getString("USUARIO_UPDATE"));

                if(modelMetadata.isList()){
                    //Cargamos la lista de archivos
                    modelMetadata.setFileList(getAlfrescoFiles(inConnection, modelMetadata.getCode()));
                }

                results.close();
                stmt.close();
            } catch (SQLException e) {
                com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
            }
        }
        return modelMetadata;
    }

    private static List<SiiModelFile> getAlfrescoFiles(java.sql.Connection inConnection, String metadataCode){
        List<SiiModelFile> files = null;

        String strSql = "SELECT * FROM CGG_ECM_FILE WHERE CGG_ECM_METADATA_CODE = ?";
        PreparedStatement stmt=null;
        ResultSet results=null;
        try {
            stmt = inConnection.prepareStatement(strSql);
            stmt.setString(1, metadataCode);
            results = stmt.executeQuery();

            while (results.next()){
                SiiModelFile modelFile = new SiiModelFile(results.getString("CODE"),results.getString("FILE_NAME"),results.getString("FILE_DESCRIPTION"),
                        results.getString("FILE_REPOSITORY"),results.getBoolean("OVERRIDE_NAME"),results.getBoolean("ESTADO"),
                        results.getString("USUARIO_INSERT"), results.getString("USUARIO_UPDATE"));
                if(files==null)
                    files = new ArrayList<>();
                //
                modelFile.setIndexDefinitionList(getIndexDefinitions(inConnection,modelFile.getCode()));
                files.add(modelFile);
            }
            results.close();
            stmt.close();
        }catch (SQLException e) {
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }
        return files;
    }

    private static List<SiiModelIndexDefinition> getIndexDefinitions(java.sql.Connection inConnection, String fileCode){
        List<SiiModelIndexDefinition> definitions = new ArrayList<>();
        //Llenamos la lista de indices si esque previamente no se ha echo.
        if(indexDefinitions==null){
            indexDefinitions = new ArrayList<>();
            String strSql = "SELECT * FROM CGG_ECM_INDEX_DEFINITION";
            PreparedStatement stmt=null;
            ResultSet results=null;
            try {
                stmt = inConnection.prepareStatement(strSql);
                results = stmt.executeQuery();

                while (results.next()){
                    SiiModelIndexDefinition indexDefinition = new SiiModelIndexDefinition(results.getString("CODE"),results.getString("INDEX_NAME"),results.getString("INDEX_DESCRIPTION"),
                            results.getBoolean("ESTADO"),results.getString("USUARIO_INSERT"), results.getString("USUARIO_UPDATE"));
                    indexDefinition.setItemList(getIndexItems(inConnection, indexDefinition.getCode()));
                    indexDefinitions.add(indexDefinition);
                }
                results.close();
                stmt.close();
            }catch (SQLException e) {
                com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
            }
        }

        //Buscamos los indices especificos para este archivo.
        String strSQL = "SELECT * FROM CGG_ECM_FILE_INDEX WHERE CGG_ECM_FILE_CODE = ?";
        PreparedStatement stmt=null;
        ResultSet results=null;
        try {
            stmt = inConnection.prepareStatement(strSQL);
            stmt.setString(1,fileCode);
            results = stmt.executeQuery();
            while (results.next()){
                definitions.add(getIndexDefinition(results.getString("CGG_ECM_INDEX_DEFINITION_CODE")));
            }
            results.close();
            stmt.close();
        }catch (SQLException e) {
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }

        return definitions;
    }

    private static List<SiiModelIndexItem> getIndexItems(java.sql.Connection inConnection, String definitionCode){
        List<SiiModelIndexItem> indexItems = null;
        String strSql = "SELECT * FROM CGG_ECM_INDEX_ITEM WHERE CGG_ECM_INDEX_DEFINITION_CODE = ?";
        PreparedStatement stmt=null;
        ResultSet results=null;
        try {
            stmt = inConnection.prepareStatement(strSql);
            stmt.setString(1, definitionCode);
            results = stmt.executeQuery();

            while (results.next()){
                SiiModelIndexItem indexItem = new SiiModelIndexItem(results.getString("CODE"),results.getString("ITEM_NAME"),results.getString("ITEM_DATA_TYPE"),
                        results.getString("ITEM_LABEL"),results.getBoolean("IS_MANDATORY"),
                        results.getBoolean("ESTADO"),results.getString("USUARIO_INSERT"), results.getString("USUARIO_UPDATE"));
                if(indexItems==null)
                    indexItems = new ArrayList<>();

                indexItems.add(indexItem);
            }
            results.close();
            stmt.close();
        }catch (SQLException e) {
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }
        return indexItems;
    }

    private static SiiModelIndexDefinition getIndexDefinition(String definitionCode){
        for(SiiModelIndexDefinition def: indexDefinitions){
            if(def.getCode().equals(definitionCode))
                return def;
        }
        return null;
    }
}
