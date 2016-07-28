package com.bmlaurus.db;

import com.besixplus.sii.db.ManagerConnection;
import com.bmlaurus.objects.ResidenciaBeneficiario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acanaveral on 28/7/16.
 */
public class ResidenciaBeneficiarioData {
    private List<ResidenciaBeneficiario> beneficiarios;


    //Auspiciante
    private String inCrper_codigo;

    public ResidenciaBeneficiarioData(String inCrper_codigo) {
        this.inCrper_codigo = inCrper_codigo;
    }

    public List<ResidenciaBeneficiario> selectBeneficiarios(){
        beneficiarios =  new ArrayList<>();
        Connection conn = ManagerConnection.getConnection();
        String strSql = "select per.crper_codigo,per.crper_num_doc_identific,per.crper_nombres, per.crper_apellido_paterno, per.crper_apellido_materno,per.crper_fecha_nacimiento, per.cpais_codigo, per.cgg_cpais_codigo,per.crper_genero, per.crper_numero_residencia," +
                "   ptst.crtst_descripcion as tipo, tst.crtst_descripcion, res.crtst_codigo, res.crrsd_numero, res.crrsd_fecha_inicio, res.crrsd_fecha_caducidad" +
                "   from sii.cgg_res_residencia res" +
                "   join sii.cgg_res_tramite tra on (tra.crtra_codigo = res.crtra_codigo and res.crrsd_vigente = true)" +
                "   join sii.cgg_res_persona per on res.crper_codigo = per.crper_codigo" +
                "   join sii.cgg_res_tipo_solicitud_tramite tst on res.crtst_codigo = tst.crtst_codigo" +
                "   left join sii.cgg_res_tipo_solicitud_tramite ptst on tst.cgg_crtst_codigo = ptst.crtst_codigo" +
                "   where tra.crper_codigo = ? or crpjr_codigo = ? " +
                "   and crrsd_vigente";
        try{
            PreparedStatement stmt=null;
            ResultSet results=null;
            stmt = conn.prepareStatement(strSql);
            stmt.setString(1,inCrper_codigo);
            stmt.setString(2,inCrper_codigo);
            results = stmt.executeQuery();
            while(results.next()) {
                ResidenciaBeneficiario beneficiario = new ResidenciaBeneficiario();
                beneficiario.setCRPER_CODIGO(results.getString(1));
                beneficiario.setCRPER_NUM_DOC_IDENTIFIC(results.getString(2));
                beneficiario.setCRPER_NOMBRES(results.getString(3));
                beneficiario.setCRPER_APELLIDO_PATERNO(results.getString(4));
                beneficiario.setCRPER_APELLIDO_MATERNO(results.getString(5));
                beneficiario.setCRPER_FECHA_NACIMIENTO(results.getDate(6));
                beneficiario.setCPAIS_CODIGO(results.getString(7));
                beneficiario.setCGG_CPAIS_CODIGO(results.getString(8));
                beneficiario.setCRPER_GENERO(results.getInt(9));
                beneficiario.setCRPER_NUMERO_RESIDENCIA(results.getString(10));
                //
                beneficiario.setCRTST_MOTIVO_DESCRIPCION(results.getString(11));
                beneficiario.setCRTST_TIPO_DESCRIPCION(results.getString(12));
                beneficiario.setCRTST_CODIGO(results.getString(13));
                beneficiario.setCRRSD_NUMERO(results.getString(14));
                beneficiario.setCRRSD_FECHA_INICIO(results.getDate(15));
                beneficiario.setCRRSD_FECHA_CADUCIDAD(results.getDate(16));

                beneficiarios.add(beneficiario);
            }
            results.close();
            stmt.close();
            conn.close();
        }catch (SQLException e) {
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
        }

        return beneficiarios;
    }
}
