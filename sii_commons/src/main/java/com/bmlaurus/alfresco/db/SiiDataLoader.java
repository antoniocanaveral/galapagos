package com.bmlaurus.alfresco.db;

import com.bmlaurus.alfresco.model.SiiModelFile;
import com.bmlaurus.alfresco.model.SiiModelIndexDefinition;
import com.bmlaurus.alfresco.model.SiiModelIndexItem;
import com.bmlaurus.alfresco.model.SiiModelMetadata;
import com.bmlaurus.virtual.VirtualCache;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by acanaveral on 27/5/16.
 */
public class SiiDataLoader {
    private static List<SiiModelIndexDefinition> indexDefinitions;

    public static SiiModelMetadata getAlfrescoMetadata(java.sql.Connection inConnection, String tableName, String filter){
        SiiModelMetadata modelMetadata = null;
        if (tableName!=null) {
            String strSql = "SELECT * FROM CGG_ECM_METADATA WHERE TABLE_NAME=?";
            if(filter!=null && !filter.isEmpty())
                strSql += " AND FILTER=?";

            PreparedStatement stmt=null;
            ResultSet results=null;
            try {
                stmt = inConnection.prepareStatement(strSql);
                stmt.setString(1,tableName);
                if(filter!=null && !filter.isEmpty())
                    stmt.setString(2,filter);

                results = stmt.executeQuery();
                //Debería devolver solamente 1
                if(results.next()) {
                    modelMetadata = new SiiModelMetadata(results.getString("CODE"), results.getString("TABLE_NAME"), results.getString("FILTER"),
                            results.getString("FILES_REPOSITORY"), results.getBoolean("IS_LIST"), results.getBoolean("ESTADO"),
                            results.getString("USUARIO_INSERT"), results.getString("USUARIO_UPDATE"));

                    if (modelMetadata.isList()) {
                        //Cargamos la lista de archivos
                        modelMetadata.setFileList(getAlfrescoFiles(inConnection, modelMetadata.getCode()));
                    }
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
                SiiModelFile modelFile = new SiiModelFile(results.getString("CODE"),results.getString("CGG_ECM_METADATA_CODE"),results.getString("FILE_NAME"),results.getString("FILE_DESCRIPTION"),
                        results.getString("DOCUMENT_TYPE"),results.getString("FILE_REPOSITORY"),results.getBoolean("OVERRIDE_NAME"),results.getBoolean("ESTADO"),
                        results.getString("USUARIO_INSERT"), results.getString("USUARIO_UPDATE"),results.getBoolean("INSERTABLE"),results.getBoolean("UPDATEABLE"),
                        results.getBoolean("MANDATORY"), results.getString("VISIBLE_ROLE"), results.getString("EDITABLE_ROLE"));
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

    public static String repoResolver(Connection conn, String table_name, String recordID, String sourcePath) throws SQLException {
        StringBuffer result = new StringBuffer();
        String strSQL;
        String pkColumn = getPKColumng(conn,table_name);
        if (pkColumn!=null) {
            //Obtengo el registro al que hace referencia el adjunto
            PreparedStatement statement = null;
            strSQL = "SELECT * FROM " + table_name + " WHERE " + pkColumn + "=?";
            statement = conn.prepareStatement(strSQL);
            statement.setString(1,recordID);
            ResultSet rs = statement.executeQuery();
            if(rs!=null && rs.next()) {
                //Evaluamos la cadena que representa el path
                if (sourcePath.startsWith("alfpath.") && sourcePath.endsWith(".path")) {
                    Properties globals = VirtualCache.getConfig(VirtualCache.PROP_ALFRESCO_GLOBALS);
                    if (globals != null)
                        sourcePath = globals.getProperty(sourcePath);
                }
                if(sourcePath!=null){
                    String[] path = sourcePath.split("/");
                    for (String pathItem : path) {
                        if (pathItem.contains("@")) {
                            String[] complex = pathItem.replace("@", "").split(";");
                            if (complex.length > 1) {//resultado de una query
                                String[] linkData = complex[1].split("\\.");
                                String returnField = linkData[1];
                                String tableReference = linkData[0];
                                Object comparator = rs.getObject(complex[0]);
                                if(returnField.startsWith("#")){
                                    String[] subComplex = returnField.replace("#", "").split("!");
                                    returnField = subComplex[0];
                                    Object subBase = evaluateSubQuery(conn,returnField,tableReference,comparator);
                                    if(subBase!=null){
                                        String[] subLinkData = subComplex[1].split("\\$");
                                        returnField = subLinkData[1];
                                        tableReference = subLinkData[0];
                                        result.append(evaluateSubQuery(conn,returnField,tableReference,subBase));
                                    }
                                }else{
                                    result.append(evaluateSubQuery(conn,returnField,tableReference,comparator));
                                }
                            } else {//solo campo
                                result.append(rs.getObject(pathItem.replace("@", "").trim()));
                            }
                        } else
                            result.append(pathItem);

                        result.append("/");
                    }
                }
            }
            rs.close();
            statement.close();
        }
        return result.toString();
    }

    private static Object evaluateSubQuery(Connection conn, String returnField, String tableReference, Object comparator) throws SQLException {
        Object ret = null;
        String strSQLLink = "SELECT " + returnField + " FROM " + tableReference + " WHERE " + getPKColumng(conn, tableReference) + "='" + comparator + "'";
        PreparedStatement linkStatement = conn.prepareStatement(strSQLLink);
        ResultSet linkrs = linkStatement.executeQuery();
        if (linkrs != null && linkrs.next()) {
            ret = linkrs.getObject(1);
        }
        linkrs.close();
        linkStatement.close();
        return ret;
    }

    public static String getPKColumng(Connection conn, String tableName) throws SQLException {
        String pk = null;
        PreparedStatement stmt = null;
        String strSQL = "SELECT a.attname::varchar FROM   pg_index i JOIN   pg_attribute a ON a.attrelid = i.indrelid AND a.attnum = ANY(i.indkey)" +
                "WHERE  i.indrelid = 'sii." + tableName.toLowerCase() + "'::regclass AND i.indisprimary";
        stmt = conn.prepareStatement(strSQL);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet != null && resultSet.next()) {
            pk = resultSet.getString(1);
        }
        resultSet.close();
        stmt.close();
        return pk;
    }
}
