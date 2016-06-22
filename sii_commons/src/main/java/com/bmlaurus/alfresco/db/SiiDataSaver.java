package com.bmlaurus.alfresco.db;

import com.bmlaurus.alfresco.model.SiiModelFile;
import com.bmlaurus.alfresco.model.SiiModelMetadata;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acanaveral on 21/6/16.
 */
public class SiiDataSaver {

    private SiiModelMetadata metadata;
    private List<SiiModelFile> modelFiles;
    private String metadataCode;
    private Connection inConnection;
    private String user;

    public SiiDataSaver(java.sql.Connection con, String user, String table_name, String filter,List<SiiModelFile> files){
       //Vemos si existe el ModelMetadata
        inConnection=con;
        this.user = user;
        metadata = SiiDataLoader.getAlfrescoMetadata(inConnection,table_name,filter);
        try {
            if (metadata == null) {
                metadata = new SiiModelMetadata();
                metadata.setTableName(table_name);
                metadata.setFilter(filter);
                metadata.setUsuario_insert(user);
                metadata.setUsuario_update(user);
                metadata.setIsList(true);
                metadata.setEstado(true);
                metadata.setCode(getNewMetadataCode());
            } else
                metadataCode = metadata.getCode();

            List<SiiModelFile> loaded = metadata.getFileList();

            if (files != null && files.size() > 0) {
                modelFiles = new ArrayList<>();
                for (SiiModelFile file : files) {
                    if (file.getCode().equals("KEYGEN")) {
                        file.setCode(getNewFileCode());
                    }
                    file.setCgg_ecm_metadata_code(metadataCode);
                    if(file.getUsuario_insert()==null)
                        file.setUsuario_insert(user);
                    file.setEstado(true);
                    file.setUsuario_update(user);
                    modelFiles.add(file);
                }
            }
        }catch (SQLException e){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }
    }

    private String getNewMetadataCode() throws SQLException {
        String code=null;
        CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.f_keygen(?,?,?) }");
        stmInsert.registerOutParameter(1, Types.VARCHAR);
        stmInsert.setString(2,"Cgg_ECM_Metadata");
        stmInsert.setString(3,"code");
        stmInsert.setString(4,"ECM");
        stmInsert.execute();
        code = stmInsert.getString(1);
        stmInsert.close();
        metadataCode = code;
        return code;
    }

    private String getNewFileCode() throws SQLException{
        String code = null;
        CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.f_keygen(?,?,?) }");
        stmInsert.registerOutParameter(1, Types.VARCHAR);
        stmInsert.setString(2,"Cgg_ECM_File");
        stmInsert.setString(3,"code");
        stmInsert.setString(4,"ECMFL");
        stmInsert.execute();
        code = stmInsert.getString(1);
        stmInsert.close();
        return code;
    }

    public void save(){
        if(metadata.save(inConnection)){
            for(SiiModelFile file: modelFiles){
                file.save(inConnection);
            }
        }
    }
}
