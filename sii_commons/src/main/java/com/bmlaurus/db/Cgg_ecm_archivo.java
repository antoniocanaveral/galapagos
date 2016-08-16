package com.bmlaurus.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by acanaveral on 8/8/16.
 */
public class Cgg_ecm_archivo {

    private com.besixplus.sii.objects.Cgg_ecm_archivo objArchivo;

    public Cgg_ecm_archivo(com.besixplus.sii.objects.Cgg_ecm_archivo objArchivo) {
        this.objArchivo = objArchivo;
    }

    public static List<com.besixplus.sii.objects.Cgg_ecm_archivo> selectAll(Connection objCon, String tmpUser){
        String strSQL = "SELECT ecmch_codigo, ecmch_tipo, ecmch_asunto, ecmch_fecha, ecmch_descripcion, \n" +
                "       ecmch_extracto, ecmch_estado, ecmch_usuario_insert, ecmch_fecha_insert, \n" +
                "       ecmch_usuario_update, ecmch_fecha_update, ecmch_updateable \n" +
                "   FROM sii.cgg_ecm_archivo\n" +
                "   WHERE (ECMCH_TIPO <> 'PERS' OR ECMCH_USUARIO_INSERT = ?)\n" +
                "   ORDER BY ECMCH_FECHA_INSERT DESC";

        List<com.besixplus.sii.objects.Cgg_ecm_archivo> archivos = new ArrayList<>();

        try{
            PreparedStatement stmt=null;
            ResultSet results=null;
            stmt = objCon.prepareStatement(strSQL);
            stmt.setString(1,tmpUser);
            results = stmt.executeQuery();

            while(results.next()) {
                com.besixplus.sii.objects.Cgg_ecm_archivo archivo = new com.besixplus.sii.objects.Cgg_ecm_archivo();
                archivo.setECMCH_CODIGO(results.getString(1));
                archivo.setECMCH_TIPO(results.getString(2));
                archivo.setECMCH_ASUNTO(results.getString(3));
                archivo.setECMCH_FECHA(results.getDate(4));
                archivo.setECMCH_DESCRIPCION(results.getString(5));
                archivo.setECMCH_EXTRACTO(results.getString(6));
                archivo.setECMCH_ESTADO(results.getBoolean(7));
                archivo.setECMCH_USUARIO_INSERT(results.getString(8));
                archivo.setECMCH_FECHA_INSERT(results.getDate(9));
                archivo.setECMCH_USUARIO_UPDATE(results.getString(10));
                archivo.setECMCH_FECHA_UPDATE(results.getDate(11));
                archivo.setECMCH_UPDATEABLE(results.getBoolean(12));

                archivos.add(archivo);
            }
            results.close();
            stmt.close();
        }catch (SQLException e) {
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }

        return archivos;
    }

    public static ArrayList<HashMap<String,Object>> selectAllDirect(
            java.sql.Connection inConnection,
            String inUserName,
            int inStart,
            int inLimit,
            String inSortFieldName,
            String inDirection,
            String inKeyword
    ){
        ArrayList<HashMap<String,Object>> outCgg_veh_color = new ArrayList<HashMap<String,Object>>();
        try{
            CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ECM_ARCHIVO_SELECT(?,?,?,?,?,?) }");
            stmSelect.registerOutParameter(1, Types.OTHER);
            stmSelect.setString(2, inUserName);
            stmSelect.setInt(3, inStart);
            stmSelect.setInt(4, inLimit);
            stmSelect.setString(5, inSortFieldName);
            stmSelect.setString(6, inDirection);
            stmSelect.setString(7, inKeyword);
            stmSelect.execute();
            ResultSet results = (ResultSet) stmSelect.getObject(1);
            int tmpColumnCount = results.getMetaData().getColumnCount();
            while (results.next()) {
                HashMap<String,Object> tmpObj = new HashMap<String,Object>();
                for (int i = 1 ; i <= tmpColumnCount; i++)
                    if(results.getObject(i) != null)
                        tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
                outCgg_veh_color.add(tmpObj);
            }
            results.close();
            stmSelect.close();
        }catch(SQLException e){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }
        return outCgg_veh_color;
    }

    public static ArrayList<com.besixplus.sii.objects.Cgg_ecm_archivo> selectAll(
            java.sql.Connection inConnection,
            String inUserName,
            int inStart,
            int inLimit,
            String inSortFieldName,
            String inDirection,
            String inKeyword
    ){
        ArrayList<com.besixplus.sii.objects.Cgg_ecm_archivo> outCgg_ecm_archivo = new ArrayList<com.besixplus.sii.objects.Cgg_ecm_archivo>();
        try{
            CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ECM_ARCHIVO_SELECT(?,?,?,?,?,?) }");
            stmSelect.registerOutParameter(1, Types.OTHER);
            stmSelect.setString(2, inUserName);
            stmSelect.setInt(3, inStart);
            stmSelect.setInt(4, inLimit);
            stmSelect.setString(5, inSortFieldName);
            stmSelect.setString(6, inDirection);
            stmSelect.setString(7, inKeyword);
            stmSelect.execute();
            ResultSet results = (ResultSet) stmSelect.getObject(1);
            while (results.next()) {
                com.besixplus.sii.objects.Cgg_ecm_archivo archivo = new com.besixplus.sii.objects.Cgg_ecm_archivo();
                archivo.setECMCH_CODIGO(results.getString(1));
                archivo.setECMCH_TIPO(results.getString(2));
                archivo.setECMCH_ASUNTO(results.getString(3));
                archivo.setECMCH_FECHA(results.getDate(4));
                archivo.setECMCH_DESCRIPCION(results.getString(5));
                archivo.setECMCH_EXTRACTO(results.getString(6));
                archivo.setECMCH_ESTADO(results.getBoolean(7));
                archivo.setECMCH_USUARIO_INSERT(results.getString(8));
                archivo.setECMCH_FECHA_INSERT(results.getDate(9));
                archivo.setECMCH_USUARIO_UPDATE(results.getString(10));
                archivo.setECMCH_FECHA_UPDATE(results.getDate(11));
                archivo.setECMCH_UPDATEABLE(results.getBoolean(12));
                outCgg_ecm_archivo.add(archivo);
            }
            results.close();
            stmSelect.close();
        }catch(SQLException e){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }
        return outCgg_ecm_archivo;
    }


    public com.besixplus.sii.objects.Cgg_ecm_archivo select(Connection objCon){
        String strSQL = "SELECT ecmch_codigo, ecmch_tipo, ecmch_asunto, ecmch_fecha, ecmch_descripcion, \n" +
                "       ecmch_extracto, ecmch_estado, ecmch_usuario_insert, ecmch_fecha_insert, \n" +
                "       ecmch_usuario_update, ecmch_fecha_update, ecmch_updateable \n" +
                "   FROM sii.cgg_ecm_archivo\n" +
                "   WHERE ecmch_codigo = ?\n" +
                "   ORDER BY ECMCH_FECHA_INSERT DESC";

        try{
            PreparedStatement stmt=null;
            ResultSet results=null;
            stmt = objCon.prepareStatement(strSQL);
            stmt.setString(1,objArchivo.getECMCH_CODIGO());
            results = stmt.executeQuery();

            while(results.next()) {
                objArchivo.setECMCH_CODIGO(results.getString(1));
                objArchivo.setECMCH_TIPO(results.getString(2));
                objArchivo.setECMCH_ASUNTO(results.getString(3));
                objArchivo.setECMCH_FECHA(results.getDate(4));
                objArchivo.setECMCH_DESCRIPCION(results.getString(5));
                objArchivo.setECMCH_EXTRACTO(results.getString(6));
                objArchivo.setECMCH_ESTADO(results.getBoolean(7));
                objArchivo.setECMCH_USUARIO_INSERT(results.getString(8));
                objArchivo.setECMCH_FECHA_INSERT(results.getDate(9));
                objArchivo.setECMCH_USUARIO_UPDATE(results.getString(10));
                objArchivo.setECMCH_FECHA_UPDATE(results.getDate(11));
                objArchivo.setECMCH_UPDATEABLE(results.getBoolean(12));
            }
            results.close();
            stmt.close();
        }catch (SQLException e) {
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }

        return objArchivo;
    }


    public String save(Connection objCon){
        String result = "false";
        String strSQL = null;

        try {
            PreparedStatement statement;

            if (objArchivo.getECMCH_CODIGO() == null || objArchivo.getECMCH_CODIGO().equals("KEYGEN")){
                strSQL = "INSERT INTO sii.cgg_ecm_archivo(\n" +
                        "            ecmch_codigo, ecmch_tipo, ecmch_asunto, ecmch_fecha, ecmch_descripcion, \n" +
                        "            ecmch_extracto, ecmch_estado, ecmch_usuario_insert, ecmch_fecha_insert, \n" +
                        "            ecmch_usuario_update, ecmch_fecha_update, ecmch_updateable)\n" +
                        "    VALUES (?, ?, ?, ?, ?, \n" +
                        "            ?, ?, ?, ?, \n" +
                        "            ?, ?, ?)";
                objArchivo.setECMCH_CODIGO(getCode(objCon));
                statement = objCon.prepareStatement(strSQL);
                statement.setString(1,objArchivo.getECMCH_CODIGO());
                statement.setString(2,objArchivo.getECMCH_TIPO());
                statement.setString(3,objArchivo.getECMCH_ASUNTO());
                statement.setDate(4,objArchivo.getECMCH_FECHA());
                statement.setString(5,objArchivo.getECMCH_DESCRIPCION());
                statement.setString(6,objArchivo.getECMCH_EXTRACTO());
                statement.setBoolean(7,objArchivo.isECMCH_ESTADO());
                statement.setString(8,objArchivo.getECMCH_USUARIO_INSERT());
                statement.setDate(9,objArchivo.getECMCH_FECHA_INSERT());
                statement.setString(10,objArchivo.getECMCH_USUARIO_UPDATE());
                statement.setDate(11,objArchivo.getECMCH_FECHA_UPDATE());
                statement.setBoolean(12,objArchivo.isECMCH_UPDATEABLE());
            }else{
                strSQL = "UPDATE sii.cgg_ecm_archivo\n" +
                        "   SET ecmch_tipo=?, ecmch_asunto=?, ecmch_fecha=?, \n" +
                        "       ecmch_descripcion=?, ecmch_extracto=?, ecmch_estado=?,\n" +
                        "       ecmch_usuario_update=?, ecmch_fecha_update=?, \n" +
                        "       ecmch_updateable=?\n" +
                        " WHERE ecmch_codigo=?";

                statement = objCon.prepareStatement(strSQL);
                statement.setString(1,objArchivo.getECMCH_TIPO());
                statement.setString(2,objArchivo.getECMCH_ASUNTO());
                statement.setDate(3,objArchivo.getECMCH_FECHA());
                statement.setString(4,objArchivo.getECMCH_DESCRIPCION());
                statement.setString(5,objArchivo.getECMCH_EXTRACTO());
                statement.setBoolean(6,objArchivo.isECMCH_ESTADO());
                statement.setString(7,objArchivo.getECMCH_USUARIO_UPDATE());
                statement.setDate(8,objArchivo.getECMCH_FECHA_UPDATE());
                statement.setBoolean(9,objArchivo.isECMCH_UPDATEABLE());
                statement.setString(10,objArchivo.getECMCH_CODIGO());
            }

            statement.execute();
            statement.close();
            result = "true";



        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return result;
    }

    public boolean delete(Connection objCon){
        String strSQL = "DELETE FROM sii.cgg_ecm_archivo\n" +
                " WHERE ecmch_codigo=?";

        boolean result=false;
        try{
            PreparedStatement stmt=null;
            stmt = objCon.prepareStatement(strSQL);
            stmt.setString(1,objArchivo.getECMCH_CODIGO());
            stmt.execute();
            stmt.close();
            result=true;
        }catch (SQLException e) {
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }

        return result;
    }


    public static int selectCount(
            java.sql.Connection inConnection,
            String inUserName,
            String inKeyword
    ){
        int outCount = 0;
        if (inKeyword == null || inKeyword.trim().length() == 0 )
            return selectCount(inConnection, inUserName);
        try{
            CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ECM_ARCHIVO_COUNT(?,?) }");
            stmSelect.registerOutParameter(1, Types.INTEGER);
            stmSelect.setString(2, inUserName);
            stmSelect.setString(3, inKeyword);
            stmSelect.execute();
            outCount = stmSelect.getInt(1);
            stmSelect.close();
        }catch(SQLException e){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }
        return outCount;
    }

    public static int selectCount(
            java.sql.Connection inConnection,
            String inUserName
    ){
        int outCount = 0;
        try{
            CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_ECM_ARCHIVO_COUNT(?) }");
            stmSelect.registerOutParameter(1, Types.INTEGER);
            stmSelect.setString(2, inUserName);
            stmSelect.execute();
            outCount = stmSelect.getInt(1);
            stmSelect.close();
        }catch(SQLException e){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }
        return outCount;
    }


    private String getCode(Connection objCon) throws SQLException {
        String code=null;
        CallableStatement stmInsert = objCon.prepareCall("{ ? = call sii.f_keygen(?,?,?) }");
        stmInsert.registerOutParameter(1, Types.VARCHAR);
        stmInsert.setString(2,"Cgg_ECM_Archivo");
        stmInsert.setString(3,"ECMCH_CODIGO");
        stmInsert.setString(4,"ECMCH");
        stmInsert.execute();
        code = stmInsert.getString(1);
        stmInsert.close();
        return code;
    }
}
