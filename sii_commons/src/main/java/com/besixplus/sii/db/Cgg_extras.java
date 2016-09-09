package com.besixplus.sii.db;

import com.besixplus.sii.objects.Cgg_res_carnet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * CONTIENE VARIOS METODOS DE ACCESO A LA BASE DE DATOS.
 * 
 * @author BESIXPLUS CIA. LTDA.
 *
 */
public class Cgg_extras {
	/**
	 * OBTIENE INFORMACION DE LA RESIDENCIA VIGENTE DE UNA PERSONA.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCRPER_CODIGO CODIGO DE LA PERSONA.
	 * @return
	 */
	public HashMap<String, Object> selectResidencia(Connection inConnection, String inCRPER_CODIGO){
		HashMap<String, Object> outResidencia = null;
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_SELECT_RESIDENCIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCRPER_CODIGO);
			stmSelect.execute();
			ResultSet tmpRes = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = tmpRes.getMetaData().getColumnCount();
			while(tmpRes.next()){
				outResidencia = new HashMap<String, Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(tmpRes.getObject(i) != null)
						outResidencia.put(tmpRes.getMetaData().getColumnName(i).toUpperCase(), tmpRes.getObject(i));
			}
			tmpRes.close();
			stmSelect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outResidencia;
	}
	
	/**
	 * EJECUTA LA FUNCION QUE SE ENCARGA DEL CIERRE DE RESIDENCIAS CADUCADAS.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return
	 */
	public String residenciaMonitor(Connection inConnection){
		String outResult = "true";
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{call SII.F_RESIDENCIA_MONITOR() }");
			stmSelect.execute();
			stmSelect.close();
		} catch (SQLException e) {
			StringWriter tmpWriter = new StringWriter();
			PrintWriter tmpPW = new PrintWriter(tmpWriter);
			e.printStackTrace();
			e.printStackTrace(tmpPW);
			outResult = tmpWriter.toString();
			tmpPW.close();
			try {
				tmpWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return outResult;
	}

	/**
	 * EJECUTA LA FUNCION QUE SE ENCARGA DE LIMPIAR TCTs NO UTILIZADOS.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @return
	 */
	public String limpiarTCT(Connection inConnection){
		String outResult = "true";
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{call SII.F_CGG_ELIMINAR_TCT_CADUCADO() }");
			stmSelect.execute();
			stmSelect.close();
		} catch (SQLException e) {
			StringWriter tmpWriter = new StringWriter();
			PrintWriter tmpPW = new PrintWriter(tmpWriter);
			e.printStackTrace();
			e.printStackTrace(tmpPW);
			outResult = tmpWriter.toString();
			tmpPW.close();
			try {
				tmpWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return outResult;
	}
	
	/**
	* SELECCIONA EL CARNET VIGENTE DE UNA PERSONA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA.
	* @return com.besixplus.sii.objects.Cgg_res_carnet OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public com.besixplus.sii.objects.Cgg_res_carnet selectCarnet(
		java.sql.Connection inConnection,
		String inCrrsd_codigo
	){
		Cgg_res_carnet outCarnet = null;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_SELECT_CARNET(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,inCrrsd_codigo);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while(results.next()){
				LinkedHashMap<String,Object> tmpObj = new LinkedHashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				
				outCarnet = new Cgg_res_carnet();
				outCarnet.setCRCNT_CODIGO(tmpObj.get("CRCNT_CODIGO").toString());
				outCarnet.setCRCOM_CODIGO(tmpObj.get("CRCOM_CODIGO")!=null?tmpObj.get("CRCOM_CODIGO").toString():null);
				outCarnet.setCRADJ_CODIGO(tmpObj.get("CRADJ_CODIGO")!=null?tmpObj.get("CRADJ_CODIGO").toString():null);
				outCarnet.setCRRSD_CODIGO(tmpObj.get("CRRSD_CODIGO")!=null?tmpObj.get("CRRSD_CODIGO").toString():null);
				outCarnet.setCRCNT_SERIE(tmpObj.get("CRCNT_SERIE").toString());
				outCarnet.setCRCNT_MOTIVO(tmpObj.get("CRCNT_MOTIVO")!=null?Integer.valueOf(tmpObj.get("CRCNT_MOTIVO").toString()):null);
				outCarnet.setCRCNT_FECHA_EMISION(tmpObj.get("CRCNT_FECHA_EMISION")!=null?(Date) tmpObj.get("CRCNT_FECHA_EMISION"):null);
				outCarnet.setCRCNT_FECHA_APROBACION(tmpObj.get("CRCNT_FECHA_APROBACION")!=null?(Date) tmpObj.get("CRCNT_FECHA_APROBACION"):null);
				outCarnet.setCRCNT_FECHA_CADUCIDAD(tmpObj.get("CRCNT_FECHA_CADUCIDAD")!=null?(Date) tmpObj.get("CRCNT_FECHA_CADUCIDAD"):null);
				outCarnet.setCRCNT_FECHA_DEPOSITO(tmpObj.get("CRCNT_FECHA_DEPOSITO")!=null?(Date) tmpObj.get("CRCNT_FECHA_DEPOSITO"):null);
				outCarnet.setCRCNT_CARNET_IMPRESO(tmpObj.get("CRCNT_CARNET_IMPRESO")!=null?Boolean.valueOf(tmpObj.get("CRCNT_CARNET_IMPRESO").toString()):null);
				outCarnet.setCRCNT_VALOR(tmpObj.get("CRCNT_VALOR")!=null?(BigDecimal) tmpObj.get("CRCNT_VALOR"):null);
				outCarnet.setCRCNT_OBSERVACION(tmpObj.get("CRCNT_OBSERVACION")!=null?(String) tmpObj.get("CRCNT_OBSERVACION"):null);
				outCarnet.setCRCNT_ESTADO(tmpObj.get("CRCNT_ESTADO")!=null?Boolean.valueOf(tmpObj.get("CRCNT_ESTADO").toString()):null);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCarnet;
	}
	/**
	 * SELECCION LA FASE DEL TRAMITE PARA VOTACION DE COMITE.
	 * @param inConnection CONEXION A LA BASE DE DATOS.
	 * @param inCRTRA_CODIGO CODIGO DEL TRAMITE
	 * @return
	 */
	public HashMap<String,String> selectFaseComite(Connection inConnection, String inCRTRA_CODIGO){
		HashMap<String,String> outFaseCodigo = new HashMap<String, String>();
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_S_FASE_COMITE(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inCRTRA_CODIGO);
			stmSelect.execute();
			ResultSet tmpRes = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = tmpRes.getMetaData().getColumnCount();
			while(tmpRes.next()){
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(tmpRes.getObject(i) != null)
						outFaseCodigo.put(tmpRes.getMetaData().getColumnName(i).toUpperCase(), tmpRes.getObject(i).toString());
			}
			tmpRes.close();
			stmSelect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outFaseCodigo;
	}
	
	/**
	 * Ejecuta la funcion para buscar y almanacenar a los turistas y transeuntes que exeden los dias permitidos de estadia.
	 * @param inConnection Conexion de datos.
	 */
	public void ExcedidoDiasMonitor(Connection inConnection){
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{call SII.F_EXCEDIDO_DIAS_MONITOR() }");
			stmSelect.execute();
			stmSelect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ejecuta la funcion para buscar y almanacenar a los turistas y transeuntes que exeden los dias permitidos de estadia con una fecha en particular para la creacion de indices de gerencial.
	 * @param inConnection Conexion de datos.
	 */
	public void ExcedidoDiasIndiceMonitor(Connection inConnection){
		try {
			CallableStatement stmSelect = inConnection.prepareCall("{call SII.F_EXCEDIDO_DIAS_INDICE_MONITOR() }");
			stmSelect.execute();
			stmSelect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
