package com.besixplus.sii.ws;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.mail.ProcessMail;
import com.besixplus.sii.misc.CGGEnumerators;
import com.besixplus.sii.misc.CGGEnumerators.*;
import com.besixplus.sii.objects.Cgg_configuracion;
import com.besixplus.sii.objects.Cgg_res_adjunto;
import com.besixplus.sii.objects.Cgg_res_adjunto_temporal;
import com.besixplus.sii.objects.Cgg_res_fase;
import com.besixplus.sii.objects.Cgg_res_novedad_notificacion;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.besixplus.sii.objects.Cgg_res_proceso;
import com.besixplus.sii.objects.Cgg_res_requisito_tramite;
import com.besixplus.sii.objects.Cgg_res_seguimiento;
import com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite;
import com.besixplus.sii.objects.Cgg_res_tramite_garantia;
import com.besixplus.sii.objects.Cgg_usuario;
import com.besixplus.sii.objects.Cgg_veh_motor;
import com.besixplus.sii.objects.Cgg_veh_vehiculo;
import com.besixplus.sii.objects.Cgg_veh_vehiculo_motor;
import com.besixplus.sii.objects.*;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * CLASE Cgg_res_tramite
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_tramite POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_tramite implements Serializable{

	private static final long serialVersionUID = 1114118020;
	private Messages myErrorMessages = new Messages(Messages.Types.Error);
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_tramite.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE.
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA.
	 * @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO. CAMPO RECURSIVO HACIA LA MISMA TABLA DE PERSONA.
	 * @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO.
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD.
	 * @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO.
	 * @param inCrett_codigo IDENTIFICATIVO UNICO DE REGISTRO ESTADO TRAMITE.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA.
	 * @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR.
	 * @param inCrtra_anio ANIO DE REALIZACION DEL TRAMITE.
	 * @param inCrtra_numero NUMERO SECUENCIAL UNICO DEL TRAMITE, QUE SE RESTABLECE ANUALMENTE..
	 * @param inCrtra_fecha_recepcion FECHA DE RECEPCION DEL TRAMITE.
	 * @param inCrtra_actividad_residencia ACTIVIDAD A REALIZAR EN LA PROVINCIA POR PARTE DEL BENEFICIARIO RESIDENCIA.
	 * @param inCrtra_observacion OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON.
	 * @param inCrtra_dias_permanencia NUMERO DE DIAS AUTORIZADOS PARA PERMANENCIA DE UNA PERSONA.
	 * @param inCrtra_pendiente DETERMINA SI UN TRAMITE YA HA SIDO EVALUADO POR COMITE
VALORES:
0-NO EVALUADO
1-EVALUADO
2-CADUCADO
3-SOLO GUARDADO
4-FINALIZADO
5-OTRO TIPO DE ESTADO.
	 * @param inCrtra_observacion_pendiente JUSTIFICACION DE PORQUE EL TRAMITE QUEDO PENDIENTE.
	 * @param inCrtra_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE.
	 * @param inCrtra_comunicado_radial NUMERO DE COMUNICADO RADIAL QUE PATROCINA EL TRAMITE DE RESIDENCIA TEMPORAL.
	 * @param inCrtra_motivo NUMERO DE ARTICULO QUE MOTIVO LA SOLICITUD DE RESIDENCIA..
	 * @param inCrtra_folio NUMERO DE HOJAS FOLIADAS PARA EL TRAMITE.
	 * @param inCrtra_grupo DETERMINA SI EL TRAMITE PERTENECE A UN GRUPO.
	 * @param inCrtra_orden DETERMINA EL ORDENAMIENTO EN EL INGRESO PARA TRAMITES DE GRUPO.
	 * @param inCrtra_fecha_ingreso FECHA DE INGRESO A LA PROVINCIA DEL BENEFICIARIO.
	 * @param inCrtra_fecha_salida FECHA DE SALIDA DE LA PROVINCIA DEL BENEFICIARIO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCgg_crper_codigo")String inCgg_crper_codigo,
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="inCvveh_codigo")String inCvveh_codigo,
			@WebParam(name="inCrett_codigo")String inCrett_codigo,
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name="inCvmtr_codigo")String inCvmtr_codigo,
			@WebParam(name="inCrtra_anio")java.math.BigDecimal inCrtra_anio,
			@WebParam(name="inCrtra_numero")java.math.BigDecimal inCrtra_numero,
			@WebParam(name="inCrtra_fecha_recepcion")java.util.Date inCrtra_fecha_recepcion,
			@WebParam(name="inCrtra_actividad_residencia")String inCrtra_actividad_residencia,
			@WebParam(name="inCrtra_observacion")String inCrtra_observacion,
			@WebParam(name="inCrtra_dias_permanencia")int inCrtra_dias_permanencia,
			@WebParam(name="inCrtra_pendiente")int inCrtra_pendiente,
			@WebParam(name="inCrtra_observacion_pendiente")String inCrtra_observacion_pendiente,
			@WebParam(name="inCrtra_atencion_cliente")boolean inCrtra_atencion_cliente,
			@WebParam(name="inCrtra_comunicado_radial")String inCrtra_comunicado_radial,
			@WebParam(name="inCrtra_motivo")String inCrtra_motivo,
			@WebParam(name="inCrtra_folio")java.math.BigDecimal inCrtra_folio,
			@WebParam(name="inCrtra_grupo")boolean inCrtra_grupo,
			@WebParam(name="inCrtra_orden")java.math.BigDecimal inCrtra_orden,
			@WebParam(name="inCrtra_fecha_ingreso")java.util.Date inCrtra_fecha_ingreso,
			@WebParam(name="inCrtra_fecha_salida")java.util.Date inCrtra_fecha_salida
			){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_tramite obj = new com.besixplus.sii.objects.Cgg_res_tramite();
		obj.setCRTRA_CODIGO("KEYGEN");
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		obj.setCRPRO_CODIGO(inCrpro_codigo);
		obj.setCRTST_CODIGO(inCrtst_codigo);
		obj.setCVVEH_CODIGO(inCvveh_codigo);
		obj.setCRETT_CODIGO(inCrett_codigo);
		obj.setCISLA_CODIGO(inCisla_codigo);
		obj.setCVMTR_CODIGO(inCvmtr_codigo);
		obj.setCRTRA_ANIO(inCrtra_anio);
		obj.setCRTRA_NUMERO(inCrtra_numero);
		obj.setCRTRA_FECHA_RECEPCION(inCrtra_fecha_recepcion);
		obj.setCRTRA_ACTIVIDAD_RESIDENCIA(inCrtra_actividad_residencia);
		obj.setCRTRA_OBSERVACION(inCrtra_observacion);
		obj.setCRTRA_DIAS_PERMANENCIA(inCrtra_dias_permanencia);
		obj.setCRTRA_PENDIENTE(inCrtra_pendiente);
		obj.setCRTRA_OBSERVACION_PENDIENTE(inCrtra_observacion_pendiente);
		obj.setCRTRA_ATENCION_CLIENTE(inCrtra_atencion_cliente);
		obj.setCRTRA_COMUNICADO_RADIAL(inCrtra_comunicado_radial);
		obj.setCRTRA_MOTIVO(inCrtra_motivo);
		obj.setCRTRA_FOLIO(inCrtra_folio);
		obj.setCRTRA_GRUPO(inCrtra_grupo);
		obj.setCRTRA_ORDEN(inCrtra_orden);
		obj.setCRTRA_FECHA_INGRESO(inCrtra_fecha_ingreso);
		obj.setCRTRA_FECHA_SALIDA(inCrtra_fecha_salida);
		obj.setCRTRA_ESTADO(true);
		obj.setCRTRA_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRTRA_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_tramite(obj).insert(con);
			if(!res.equals("true"))
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		return new Boolean(res).toString();
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tramite EN UNA ESTRUCTRA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
			){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_tramite.selectAll(con, tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			return outCadena.toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_tramite EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectPage(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
			){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_tramite.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_res_tramite.selectAll(con,"noene"/*tmpRequest.getUserPrincipal().getName()*/, start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_tramite EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectPageDirect(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
			){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_tramite.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_tramite.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}


	/**
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_tramite.
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
	 * @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO. CAMPO RECURSIVO HACIA LA MISMA TABLA DE PERSONA
	 * @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	 * @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	 * @param inCrett_codigo IDENTIFICATIVO UNICO DE REGISTRO ESTADO TRAMITE
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
	 * @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	 * @param inCrtra_anio ANIO DE REALIZACION DEL TRAMITE
	 * @param inCrtra_numero NUMERO SECUENCIAL UNICO DEL TRAMITE, QUE SE RESTABLECE ANUALMENTE.
	 * @param inCrtra_fecha_recepcion FECHA DE RECEPCION DEL TRAMITE
	 * @param inCrtra_actividad_residencia ACTIVIDAD A REALIZAR EN LA PROVINCIA POR PARTE DEL BENEFICIARIO RESIDENCIA
	 * @param inCrtra_observacion OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON
	 * @param inCrtra_dias_permanencia NUMERO DE DIAS AUTORIZADOS PARA PERMANENCIA DE UNA PERSONA
	 * @param inCrtra_pendiente DETERMINA SI UN TRAMITE YA HA SIDO EVALUADO POR COMITE
VALORES:
0-NO EVALUADO
1-EVALUADO
2-CADUCADO
3-SOLO GUARDADO
4-FINALIZADO
5-OTRO TIPO DE ESTADO
	 * @param inCrtra_observacion_pendiente JUSTIFICACION DE PORQUE EL TRAMITE QUEDO PENDIENTE
	 * @param inCrtra_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	 * @param inCrtra_comunicado_radial NUMERO DE COMUNICADO RADIAL QUE PATROCINA EL TRAMITE DE RESIDENCIA TEMPORAL
	 * @param inCrtra_motivo NUMERO DE ARTICULO QUE MOTIVO LA SOLICITUD DE RESIDENCIA.
	 * @param inCrtra_folio NUMERO DE HOJAS FOLIADAS PARA EL TRAMITE
	 * @param inCrtra_grupo DETERMINA SI EL TRAMITE PERTENECE A UN GRUPO
	 * @param inCrtra_orden DETERMINA EL ORDENAMIENTO EN EL INGRESO PARA TRAMITES DE GRUPO
	 * @param inCrtra_fecha_ingreso FECHA DE INGRESO A LA PROVINCIA DEL BENEFICIARIO
	 * @param inCrtra_fecha_salida FECHA DE SALIDA DE LA PROVINCIA DEL BENEFICIARIO
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCgg_crper_codigo")String inCgg_crper_codigo,
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="inCvveh_codigo")String inCvveh_codigo,
			@WebParam(name="inCrett_codigo")String inCrett_codigo,
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name="inCvmtr_codigo")String inCvmtr_codigo,
			@WebParam(name="inCrtra_anio")java.math.BigDecimal inCrtra_anio,
			@WebParam(name="inCrtra_numero")java.math.BigDecimal inCrtra_numero,
			@WebParam(name="inCrtra_fecha_recepcion")java.util.Date inCrtra_fecha_recepcion,
			@WebParam(name="inCrtra_actividad_residencia")String inCrtra_actividad_residencia,
			@WebParam(name="inCrtra_observacion")String inCrtra_observacion,
			@WebParam(name="inCrtra_dias_permanencia")int inCrtra_dias_permanencia,
			@WebParam(name="inCrtra_pendiente")int inCrtra_pendiente,
			@WebParam(name="inCrtra_observacion_pendiente")String inCrtra_observacion_pendiente,
			@WebParam(name="inCrtra_atencion_cliente")boolean inCrtra_atencion_cliente,
			@WebParam(name="inCrtra_comunicado_radial")String inCrtra_comunicado_radial,
			@WebParam(name="inCrtra_motivo")String inCrtra_motivo,
			@WebParam(name="inCrtra_folio")java.math.BigDecimal inCrtra_folio,
			@WebParam(name="inCrtra_grupo")boolean inCrtra_grupo,
			@WebParam(name="inCrtra_orden")java.math.BigDecimal inCrtra_orden,
			@WebParam(name="inCrtra_fecha_ingreso")java.util.Date inCrtra_fecha_ingreso,
			@WebParam(name="inCrtra_fecha_salida")java.util.Date inCrtra_fecha_salida
			) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tramite obj = new com.besixplus.sii.objects.Cgg_res_tramite();
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		obj.setCRPRO_CODIGO(inCrpro_codigo);
		obj.setCRTST_CODIGO(inCrtst_codigo);
		obj.setCVVEH_CODIGO(inCvveh_codigo);
		obj.setCRETT_CODIGO(inCrett_codigo);
		obj.setCISLA_CODIGO(inCisla_codigo);
		obj.setCVMTR_CODIGO(inCvmtr_codigo);
		obj.setCRTRA_ANIO(inCrtra_anio);
		obj.setCRTRA_NUMERO(inCrtra_numero);
		obj.setCRTRA_FECHA_RECEPCION(inCrtra_fecha_recepcion);
		obj.setCRTRA_ACTIVIDAD_RESIDENCIA(inCrtra_actividad_residencia);
		obj.setCRTRA_OBSERVACION(inCrtra_observacion);
		obj.setCRTRA_DIAS_PERMANENCIA(inCrtra_dias_permanencia);
		obj.setCRTRA_PENDIENTE(inCrtra_pendiente);
		obj.setCRTRA_OBSERVACION_PENDIENTE(inCrtra_observacion_pendiente);
		obj.setCRTRA_ATENCION_CLIENTE(inCrtra_atencion_cliente);
		obj.setCRTRA_COMUNICADO_RADIAL(inCrtra_comunicado_radial);
		obj.setCRTRA_MOTIVO(inCrtra_motivo);
		obj.setCRTRA_FOLIO(inCrtra_folio);
		obj.setCRTRA_GRUPO(inCrtra_grupo);
		obj.setCRTRA_ORDEN(inCrtra_orden);
		obj.setCRTRA_FECHA_INGRESO(inCrtra_fecha_ingreso);
		obj.setCRTRA_FECHA_SALIDA(inCrtra_fecha_salida);
		obj.setCRTRA_ESTADO(true);
		obj.setCRTRA_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_tramite(obj).update(con);
			con.close();
			if(!res.equalsIgnoreCase("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(res).toString();
	}


	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_tramite EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE TRAMITE.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="format")String format
			) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tramite tmpObj = new com.besixplus.sii.objects.Cgg_res_tramite();
		tmpObj.setCRTRA_CODIGO(inCrtra_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_tramite(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_tramite> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}


	/**
	 * Registra un tramite para la cual realiza una trasacion con informacion de adjuntos, fase, usuario, seguimiento, personal, entre otros.
	 * En caso que no se establezca un seguimiento a despachar a travez del parametro inCrfas_codigo el tramite simplemente solo se guardara.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE.
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA.
	 * @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO. CAMPO RECURSIVO HACIA LA MISMA TABLA DE PERSONA.
	 * @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO.
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD.
	 * @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA.
	 * @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR.
	 * @param inCgg_cvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR.
	 * @param inCgg_cvveh_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO
	 * @param inCrtra_actividad_residencia ACTIVIDAD A REALIZAR EN LA PROVINCIA POR PARTE DEL BENEFICIARIO RESIDENCIA.
	 * @param inCrtra_observacion OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON.
	 * @param inCrtra_dias_permanencia NUMERO DE DIAS AUTORIZADOS PARA PERMANENCIA DE UNA PERSONA.	 
	 * @param inCrtra_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE.
	 * @param inCrtra_comunicado_radial NUMERO DE COMUNICADO RADIAL QUE PATROCINA EL TRAMITE DE RESIDENCIA TEMPORAL.
	 * @param inCrtra_motivo NO ESPECIFICADO.
	 * @param inCrtra_folio NUMERO DE HOJAS FOLIADAS PARA EL TRAMITE.
	 * @param inNuevoBeneficiario Nuevo beneficiario o persona que resibe la residencia en formato JSON.	 
	 * @param inCrfas_codigo Codigo de fase de tramite.
	 * @param inTramiteRequisitos Cadena de datos en formato JSON con informacion de los requisitos cumplidos del tramite.	 * 
	 * @param inCrgts_aplica Cadena de datos en formato JSON de las garantias a cobrarse para este tramite.
	 * @param inAdjuntos Coleccion de documentos adjuntos del tramite.
	 * @param inCrtra_fecha_salida Fecha de caducidad de la residencia si es el caso de la misma.
	 * @param inInfoVehiculos INFORMACION DE VEHICULO
	 * @param inTipoGarantia TIPO DE GARANTIA
	 * @param inRequest 
	 * @param inResponse 
	 * @return null/Cadena de datos en formato json con informacion del numero de tramite y codigo del mismo resgistrados.
	 */	
	public String registrarTramite(
			String inCrper_codigo,
			String inCrpjr_codigo,
			String inCgg_crper_codigo,
			String inCrpro_codigo,
			String inCrtst_codigo,
			String inCvveh_codigo,			
			String inCisla_codigo,
			String inCvmtr_codigo,
			String inCgg_cvmtr_codigo,
			String inCgg_cvveh_codigo,
			String inCrtra_actividad_residencia,
			String inCrtra_observacion,
			int inCrtra_dias_permanencia,
			boolean inCrtra_atencion_cliente,
			String inCrtra_comunicado_radial,
			String inCrtra_motivo,
			java.math.BigDecimal inCrtra_folio,
			String inNuevoBeneficiario,
			String inCrfas_codigo,
			String inTramiteRequisitos,	
			String inCrgts_aplica,
			ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> inAdjuntos,
			Date inCrtra_fecha_salida,
			String inInfoVehiculos,
			JSONObject inTipoGarantia,
			HttpServletRequest inRequest, 
			HttpServletResponse inResponse		
			){

		//String log = "Inicio";		
		String resultado = null;
		String userName = "";
		String [] res = new String[2];		
		String cggCrperCodigo = null;
		Cgg_res_persona objNuevoBeneficiario = null,objTmpBeneficiario = null;
		JSONObject objTmpPersona = null;
		JSONObject tmpFaseDespacho = null;

		JSONArray objJsonRequerimientos = null;
		JSONArray objJsonFasesSeguimientos = null;		
		JSONObject objJsonRequerimientoTramite = null;		
		Cgg_res_requisito_tramite objRequisito = null;
		String flagRequisito = "true";
		Cgg_res_fase objFase = null;
		Cgg_res_fase objFaseDespacho = null;		
		Cgg_res_seguimiento objSeguimientoPadre = null,objSeguimientoHijo = null;
		String flagSeguimientoPadre= "true";
		String flagSeguimientoHijo = "true";
		String flagAdjuntos = "true";
		String flagAdjuntosRequisito = "true";
		Cgg_res_novedad_notificacion objNotificacionSeguimiento = null;
		Cgg_usuario objUsuarioRegistro = new Cgg_usuario();		

		ArrayList<String> codigoAdjuntoRequisito = new ArrayList<String>();
		String tmpMsg = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR INFORMACION DEL BENEFICIARIO DEL TRAMITE.";
		Cgg_configuracion confTramiteRegistro  = null;		

		com.besixplus.sii.objects.Cgg_res_tramite obj = new com.besixplus.sii.objects.Cgg_res_tramite();

		userName = inRequest.getUserPrincipal().getName();

		obj.setCRTRA_CODIGO("KEYGEN");
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		obj.setCRPRO_CODIGO(inCrpro_codigo);
		obj.setCRTST_CODIGO(inCrtst_codigo);
		obj.setCVVEH_CODIGO(inCvveh_codigo);

		obj.setCISLA_CODIGO(inCisla_codigo);	
		obj.setCVMTR_CODIGO(inCvmtr_codigo);
		obj.setCGG_CVMTR_CODIGO(inCgg_cvmtr_codigo);
		obj.setCGG_CVVEH_CODIGO(inCgg_cvveh_codigo);

		//Seccion tomada del servidor o autogenerada.
		obj.setCRTRA_ANIO(new BigDecimal(Calendar.getInstance().get(Calendar.YEAR)));
		obj.setCRTRA_NUMERO(new BigDecimal(0));
		obj.setCRTRA_FECHA_RECEPCION(new Date());
		obj.setCRTRA_FECHA_SALIDA(inCrtra_fecha_salida);


		obj.setCRTRA_ACTIVIDAD_RESIDENCIA(inCrtra_actividad_residencia);
		obj.setCRTRA_OBSERVACION(inCrtra_observacion);
		obj.setCRTRA_DIAS_PERMANENCIA(inCrtra_dias_permanencia);

		obj.setCRTRA_ATENCION_CLIENTE(inCrtra_atencion_cliente);
		obj.setCRTRA_COMUNICADO_RADIAL(inCrtra_comunicado_radial);
		obj.setCRTRA_MOTIVO(inCrtra_motivo);
		obj.setCRTRA_FOLIO(inCrtra_folio);

		//log+="-1";

		try {
			objJsonFasesSeguimientos = new JSONArray(inCrfas_codigo);
			if(objJsonFasesSeguimientos.length()>=1){
				obj.setCRTRA_PENDIENTE(ESTADOPENDIENTETRAMITE.NOEVALUADO.getValue());
			}else{
				obj.setCRTRA_PENDIENTE(ESTADOPENDIENTETRAMITE.SOLOGUARDADO.getValue());
			}

		} catch (JSONException e1) {
			e1.printStackTrace();
			obj.setCRTRA_PENDIENTE(ESTADOPENDIENTETRAMITE.SOLOGUARDADO.getValue());
		}		

		obj.setCRTRA_ESTADO(true);

		obj.setCRTRA_USUARIO_INSERT(userName);
		obj.setCRTRA_USUARIO_UPDATE(userName);

		try{
			Connection objConn= ManagerConnection.getConnection();	
			objConn.setAutoCommit(false);
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(objConn, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), inRequest.getUserPrincipal().getName(), 1)){
				objConn.close();
				inResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}

			objUsuarioRegistro.setCUSU_NOMBRE_USUARIO(userName);
			new com.besixplus.sii.db.Cgg_usuario(objUsuarioRegistro).selectByUsername(objConn);

			//log+="-2";

			if(inNuevoBeneficiario != null && inNuevoBeneficiario.trim().length()>=1){

				//REGISTRO DEL BENEFICIARIO					
				objTmpPersona = new JSONObject(inNuevoBeneficiario);
				objTmpBeneficiario = new Cgg_res_persona();			
				objTmpBeneficiario.setCRPER_NUM_DOC_IDENTIFIC(objTmpPersona.getString("CRPER_NUM_DOC_IDENTIFIC").toUpperCase());				
				objTmpBeneficiario = new com.besixplus.sii.db.Cgg_res_persona(objTmpBeneficiario).selectNumDoc(objConn);
				if(objTmpBeneficiario.getCRPER_CODIGO()!=null && objTmpBeneficiario.getCRPER_CODIGO().trim().length()>=1){										
					cggCrperCodigo = "true";

					//Actualizacion de datos del beneficiario.
					objTmpBeneficiario.setCRECV_CODIGO(objTmpPersona.getString("CRECV_CODIGO"));
					objTmpBeneficiario.setCRDID_CODIGO(objTmpPersona.getString("CRDID_CODIGO"));
					objTmpBeneficiario.setCRPER_NOMBRES(objTmpPersona.getString("CRPER_NOMBRES"));
					objTmpBeneficiario.setCRPER_APELLIDO_PATERNO(objTmpPersona.getString("CRPER_APELLIDO_PATERNO"));
					objTmpBeneficiario.setCRPER_APELLIDO_MATERNO(objTmpPersona.getString("CRPER_APELLIDO_MATERNO"));
					objTmpBeneficiario.setCRPER_NUM_DOC_IDENTIFIC(objTmpPersona.getString("CRPER_NUM_DOC_IDENTIFIC"));
					objTmpBeneficiario.setCRPER_GENERO(objTmpPersona.getInt("CRPER_GENERO"));

					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					Date fechaNacimiento = null;
					try{
						fechaNacimiento = df.parse(objTmpPersona.getString("CRPER_FECHA_NACIMIENTO"));
					} catch (ParseException e){
						e.printStackTrace();
						fechaNacimiento = new Date();
					}
					objTmpBeneficiario.setCRPER_FECHA_NACIMIENTO( fechaNacimiento );
					objTmpBeneficiario.setCRPER_USUARIO_INSERT(userName);
					objTmpBeneficiario.setCRPER_USUARIO_UPDATE(userName);

					new com.besixplus.sii.db.Cgg_res_persona(objTmpBeneficiario).update(objConn);

					objNuevoBeneficiario = new Cgg_res_persona();
					objNuevoBeneficiario.setCRPER_CODIGO(objTmpBeneficiario.getCRPER_CODIGO());

				}else{
					objNuevoBeneficiario = new Cgg_res_persona();
					objNuevoBeneficiario.setCRPER_CODIGO("KEYGEN");
					objNuevoBeneficiario.setCRECV_CODIGO(objTmpPersona.getString("CRECV_CODIGO"));
					objNuevoBeneficiario.setCRDID_CODIGO(objTmpPersona.getString("CRDID_CODIGO"));
					objNuevoBeneficiario.setCRPER_NOMBRES(objTmpPersona.getString("CRPER_NOMBRES"));
					objNuevoBeneficiario.setCRPER_APELLIDO_PATERNO(objTmpPersona.getString("CRPER_APELLIDO_PATERNO"));
					objNuevoBeneficiario.setCRPER_APELLIDO_MATERNO(objTmpPersona.getString("CRPER_APELLIDO_MATERNO"));
					objNuevoBeneficiario.setCRPER_NUM_DOC_IDENTIFIC(objTmpPersona.getString("CRPER_NUM_DOC_IDENTIFIC"));
					objNuevoBeneficiario.setCRPER_GENERO(objTmpPersona.getInt("CRPER_GENERO"));

					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					Date fechaNacimiento = null;
					try{
						fechaNacimiento = df.parse(objTmpPersona.getString("CRPER_FECHA_NACIMIENTO"));
					} catch (ParseException e){
						e.printStackTrace();
						fechaNacimiento = new Date();
					}
					objNuevoBeneficiario.setCRPER_FECHA_NACIMIENTO( fechaNacimiento );
					objNuevoBeneficiario.setCRPER_ESTADO(true);
					objNuevoBeneficiario.setCRPER_USUARIO_INSERT(userName);
					objNuevoBeneficiario.setCRPER_USUARIO_UPDATE(userName);									
					cggCrperCodigo = new com.besixplus.sii.db.Cgg_res_persona(objNuevoBeneficiario).insert(objConn);
				}
				//log+="-3 Beneficiario nuevo";

			}else{
				cggCrperCodigo = "true";
				objNuevoBeneficiario = new Cgg_res_persona();
				objNuevoBeneficiario.setCRPER_CODIGO(inCgg_crper_codigo);
				//log+="-4 Ben Existente";
			}

			//////////////////////////////INGRESO DE VEHICULOS O MOTORES//////////////////////////////
			if(inInfoVehiculos != null && !inInfoVehiculos.trim().isEmpty()){
				tmpMsg = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR INFORMACION DE VEHICULO DEL TRAMITE.";
				JSONObject tmpObject = new JSONObject(inInfoVehiculos);
				///////////////NUEVO//////////////////
				if(tmpObject.getInt("ACCION") == 0){
					Cgg_veh_motor tmpMotor = new Cgg_veh_motor();
					Cgg_veh_vehiculo_motor tmpVehMotor = new Cgg_veh_vehiculo_motor();

					tmpMotor.setCVMTR_CODIGO("KEYGEN");
					tmpMotor.setCVMTR_ANIO_FABRICACION(tmpObject.getInt("FABRICACION"));
					tmpMotor.setCVCMB_CODIGO(tmpObject.getString("CVCMB_CODIGO"));
					tmpMotor.setCVCLN_CODIGO(tmpObject.getString("CVCLN_CODIGO"));
					tmpMotor.setCVMTR_TONELAJE(tmpObject.getInt("CVMTR_TONELAJE"));
					tmpMotor.setCVMTR_ESTADO(true);
					tmpMotor.setCVMTR_ESTADO_FUNCIONAL(true);
					tmpMotor.setCVMTR_SERIE("S/N");
					tmpMotor.setCVMTR_USUARIO_INSERT(userName);
					tmpMotor.setCVMTR_USUARIO_UPDATE(userName);
					cggCrperCodigo = new com.besixplus.sii.db.Cgg_veh_motor(tmpMotor).insert(objConn);

					////////////////////////////////////VEHICULO///////////////////////////////////////
					if(tmpObject.getInt("TIPO") == CGGEnumerators.TipoVehiculoTramite.Vehiculo.getValue() ){
						Cgg_veh_vehiculo tmpVehiculo = new Cgg_veh_vehiculo();
						tmpVehiculo.setCVVEH_CODIGO("KEYGEN");
						tmpVehiculo.setCVCTG_CODIGO(tmpObject.getString("CVCTG_CODIGO"));
						tmpVehiculo.setCVSCT_CODIGO(tmpObject.getString("CVSCT_CODIGO"));
						tmpVehiculo.setCSCTP_CODIGO(tmpObject.getString("CSCTP_CODIGO"));
						tmpVehiculo.setCVVEH_TIPO(tmpObject.getInt("VEHICULO"));
						tmpVehiculo.setCVVEH_ANIO_PRODUCCION(tmpObject.getInt("FABRICACION"));
						tmpVehiculo.setCVVEH_PLACA("S/P");
						tmpVehiculo.setCVVEH_NOMBRE("S/N");
						tmpVehiculo.setCVVEH_ESTADO(true);
						tmpVehiculo.setCVVEH_USUARIO_INSERT(userName);
						tmpVehiculo.setCVVEH_USUARIO_UPDATE(userName);
						cggCrperCodigo = new com.besixplus.sii.db.Cgg_veh_vehiculo(tmpVehiculo).insert(objConn);

						if(cggCrperCodigo.equals("true")){
							tmpVehMotor.setCVVMT_CODIGO("KEYGEN");
							tmpVehMotor.setCVVMT_FECHA(new Date());
							tmpVehMotor.setCVVEH_CODIGO(tmpVehiculo.getCVVEH_CODIGO());
							tmpVehMotor.setCVMTR_CODIGO(tmpMotor.getCVMTR_CODIGO());
							tmpVehMotor.setCVVMT_ESTADO(true);
							tmpVehMotor.setCVVMT_USUARIO_INSERT(userName);
							tmpVehMotor.setCVVMT_USUARIO_UPDATE(userName);
							cggCrperCodigo = new com.besixplus.sii.db.Cgg_veh_vehiculo_motor(tmpVehMotor).insert(objConn);
						}
						obj.setCVVEH_CODIGO(tmpVehiculo.getCVVEH_CODIGO());
						obj.setCVMTR_CODIGO(null);
					}else if(tmpObject.getInt("TIPO") == CGGEnumerators.TipoVehiculoTramite.Motor.getValue()){
						obj.setCVMTR_CODIGO(tmpMotor.getCVMTR_CODIGO());
					}
				}else{
					if(tmpObject.getInt("TIPO") == CGGEnumerators.TipoVehiculoTramite.Vehiculo.getValue()){
						if(obj.getCVVEH_CODIGO().equals("KEYGEN")){
							cggCrperCodigo = "false";
							tmpMsg = myErrorMessages.getMessage("sii.tramite.vehiculo.existente", null);
						}else
							obj.setCVMTR_CODIGO(null);
					}else if(tmpObject.getInt("TIPO") == CGGEnumerators.TipoVehiculoTramite.Motor.getValue() &&
							obj.getCVMTR_CODIGO().equals("KEYGEN")){
						cggCrperCodigo = "false";
						tmpMsg = myErrorMessages.getMessage("sii.tramite.motor.existente", null);
					}	
				}
				//log+="-5 Vehiculo";
			}/*else{
				obj.setCVVEH_CODIGO(null);
				obj.setCVMTR_CODIGO(null);
			}*/
			//////////////////////////////////////////////////////////////////////////////////////////

			if(cggCrperCodigo.equalsIgnoreCase("true")){

				//Consulta del estado inicial de un tramite para su registro.
				confTramiteRegistro = new Cgg_configuracion();								

				if(objJsonFasesSeguimientos.length()>=1){
					confTramiteRegistro.setCGCNF_CONFIGURACION("ESTADO TRAMITE REGISTRADO");
				}else{
					confTramiteRegistro.setCGCNF_CONFIGURACION("ESTADO TRAMITE SOLO GUARDADO");
				}				
				confTramiteRegistro= new com.besixplus.sii.db.Cgg_configuracion(confTramiteRegistro).selectCGCNF_CONFIGURACION(objConn);

				obj.setCRETT_CODIGO(confTramiteRegistro.getCGCNF_VALOR_CADENA());
				obj.setCGG_CRPER_CODIGO(objNuevoBeneficiario.getCRPER_CODIGO());

				//REGISTRO DEL TRAMITE
				res = new com.besixplus.sii.db.Cgg_res_tramite(obj).insert1(objConn);

				/*if(res==null)
					//log+="-6 Registro tramite Res:null";
				else{
					//log+="-6 Registro tramite size:"+String.valueOf(res.length)+"--val:"+res[0];					
				}*/


				if(res != null && res[0]!=null &&
						res[0].trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
						res[0].trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){									
					//log+="-6.1 Registro tramite";
					//REGISTRO O ESTABLECIMIENTO DE LA GARANTIA
					if(inTipoGarantia!=null){
						//log+="-7.1 Inicio Garantia";
						Cgg_res_tramite_garantia tmpTramiteGarantia = new Cgg_res_tramite_garantia();
						tmpTramiteGarantia.setCRTGR_CODIGO("KEYGEN");
						tmpTramiteGarantia.setCRTRA_CODIGO(obj.getCRTRA_CODIGO());
						tmpTramiteGarantia.setCRDPT_CODIGO(inTipoGarantia.getString("CRDPT_CODIGO"));
						tmpTramiteGarantia.setCRGRT_CODIGO(inTipoGarantia.getString("CRGRT_CODIGO"));
						tmpTramiteGarantia.setCRTGR_DEVUELTO(false);
						tmpTramiteGarantia.setCRTGR_ESTADO_ASIGNACION(0);
						tmpTramiteGarantia.setCRTGR_ESTADO(true);
						tmpTramiteGarantia.setCRTGR_USUARIO_INSERT(inRequest.getUserPrincipal().getName());
						tmpTramiteGarantia.setCRTGR_USUARIO_UPDATE(inRequest.getUserPrincipal().getName());
						cggCrperCodigo = new com.besixplus.sii.db.Cgg_res_tramite_garantia(tmpTramiteGarantia).insert(objConn);
						//log+="-7.2 Fin Garantia";
					}
					//log+="-7.3 Leida de requisitos";
					objJsonRequerimientos = new JSONArray(inTramiteRequisitos);							
					int i=0;

					//REGISTRO DE LOS REQUISITOS CUMPLIDOS DEL TRAMITE.
					for(i=0;i<objJsonRequerimientos.length();i++){
						//log+="-7.4 registro de requisitos";
						objJsonRequerimientoTramite = objJsonRequerimientos.getJSONObject(i);

						objRequisito = new Cgg_res_requisito_tramite();
						objRequisito.setCRRQT_CODIGO("KEYGEN");
						objRequisito.setCRTRA_CODIGO(res[0]);								
						objRequisito.setCRSRQ_CODIGO(objJsonRequerimientoTramite.getString("CRSRQ_CODIGO"));
						objRequisito.setCRRQT_CUMPLE(objJsonRequerimientoTramite.getBoolean("CRRQT_CUMPLE"));
						objRequisito.setCRRQT_OBSERVACION(objJsonRequerimientoTramite.getString("CRRQT_OBSERVACION"));
						objRequisito.setCRRQT_ESTADO(true);
						objRequisito.setCRRQT_USUARIO_INSERT(userName);
						objRequisito.setCRRQT_USUARIO_UPDATE(userName);

						flagRequisito = new com.besixplus.sii.db.Cgg_res_requisito_tramite(objRequisito).insert(objConn);
						if(flagRequisito.equalsIgnoreCase("true")==false){
							break;
						}							

						if(objJsonRequerimientoTramite.getString("CRATE_DATA")!= null && objJsonRequerimientoTramite.getString("CRATE_DATA").trim().length() > 0){
							JSONObject jsonAdjuntoTemporal = objJsonRequerimientoTramite.getJSONObject("CRATE_DATA");

							//REGISTRO DE ADJUNTO DE REQUERIMIENTOS DE TRAMITE.
							Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
							adjuntoTemporal.setCRATE_CODIGO(jsonAdjuntoTemporal.getString("CRATE_CODIGO"));
							adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(objConn);

							com.besixplus.sii.objects.Cgg_res_adjunto adjuntoRequisito = new com.besixplus.sii.objects.Cgg_res_adjunto();
							adjuntoRequisito.setCRADJ_CODIGO("KEYGEN");
							adjuntoRequisito.setCRADJ_NOMBRE_ADJUNTO(adjuntoTemporal.getCRATE_NOMBRE());
							adjuntoRequisito.setCRADJ_ARCHIVO_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());
							adjuntoRequisito.setCRADJ_CONTENIDO("application/octet-stream");
							adjuntoRequisito.setCRADJ_ESTADO(true);
							adjuntoRequisito.setCRADJ_FECHA_REGISTRO(new Date());
							adjuntoRequisito.setCRRQT_CODIGO(objRequisito.getCRRQT_CODIGO());
							adjuntoRequisito.setCRADJ_USUARIO_INSERT(userName);
							adjuntoRequisito.setCRADJ_USUARIO_UPDATE(userName);

							flagAdjuntosRequisito = new com.besixplus.sii.db.Cgg_res_adjunto(adjuntoRequisito).insert(objConn);
							if(flagAdjuntosRequisito.equalsIgnoreCase("false")==true){
								break;
							}
							codigoAdjuntoRequisito.add(adjuntoRequisito.getCRADJ_CODIGO());
						}
						//log+="-8 Requerimientos";
					}
					//log+="-8.1 Desicion de requisitos";
					if(flagRequisito.equalsIgnoreCase("true")==true && flagAdjuntosRequisito.equalsIgnoreCase("true")==true ){						

						objFase = new Cgg_res_fase();
						objFase.setCRPRO_CODIGO(inCrpro_codigo);

						objFase = new com.besixplus.sii.db.Cgg_res_fase(objFase).selectFaseInicio(objConn,inCisla_codigo);

						//log+="-8.2 Desicion para fase";

						if(objFase.getCRFAS_CODIGO() != null &&
								objFase.getCRFAS_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue()	&&
								objFase.getCRFAS_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

							//REGISTRO DE SEGUIMIENTO INICIAL DE UN TRAMITE.
							//log+="-8.3";
							objSeguimientoPadre = new Cgg_res_seguimiento();																		

							objSeguimientoPadre.setCRSEG_CODIGO("KEYGEN");
							objSeguimientoPadre.setCGG_CRSEG_CODIGO(null); 
							objSeguimientoPadre.setCRTRA_CODIGO(res[0]); 
							objSeguimientoPadre.setCRFAS_CODIGO(objFase.getCRFAS_CODIGO()); 
							objSeguimientoPadre.setCGG_CRFAS_CODIGO(objFase.getCRFAS_CODIGO()); 
							objSeguimientoPadre.setCUSU_CODIGO(objUsuarioRegistro.getCUSU_CODIGO()); 
							objSeguimientoPadre.setCRSEG_DESCRIPCION("Registro de seguimiento para tr\u00E1mite "+obj.getCRTRA_ANIO().toString()+"-"+res[1]+"."); 														 					
							objSeguimientoPadre.setCRSEG_OBSERVACION(inCrtra_observacion);

							if(objJsonFasesSeguimientos.length()>=1){																
								objSeguimientoPadre.setCRSEG_ESTADO_ATENCION(ESTADOATENCION.DESPACHADO.getValue());
								objSeguimientoPadre.setCRSEG_TIPO_RESPUESTA(TIPORESPUESTA.APROBADO.getValue());															
							}else{
								objSeguimientoPadre.setCRSEG_ESTADO_ATENCION(ESTADOATENCION.RECIBIDO.getValue());
								objSeguimientoPadre.setCRSEG_TIPO_RESPUESTA(TIPORESPUESTA.INDETERMINADO.getValue());
							}

							objSeguimientoPadre.setCRSEG_TIPO_ACTIVIDAD(objFase.getCRFAS_TAREA_REALIZA()); 
							objSeguimientoPadre.setCRSEG_FECHA_RECEPCION(new Date()); 
							objSeguimientoPadre.setCRSEG_FECHA_REVISION(new Date()); 
							objSeguimientoPadre.setCRSEG_FECHA_DESPACHO(new Date()); 
							objSeguimientoPadre.setCRSEG_ESTADO_HIJO(ESTADORESPUESTA.SINRESPUESTAS.getValue()); 
							objSeguimientoPadre.setCRSEG_ESTADO(true); 																	
							objSeguimientoPadre.setCRSEG_VECES_REVISION(new BigDecimal(1)); 
							objSeguimientoPadre.setCRSEG_NUMERO(new BigDecimal(0));
							objSeguimientoPadre.setCUSU_CODIGO(objUsuarioRegistro.getCUSU_CODIGO());
							objSeguimientoPadre.setCRSEG_ESTADO(true);							
							objSeguimientoPadre.setCRSEG_USUARIO_INSERT(userName);
							objSeguimientoPadre.setCRSEG_USUARIO_UPDATE(userName);

							flagSeguimientoPadre = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimientoPadre).insert(objConn);
							//log+="-9 Seguimiento padre";
							if(flagSeguimientoPadre.equalsIgnoreCase("true")==true){
                                ProcessMail mailer = new ProcessMail(objSeguimientoPadre,obj,objFase, objSeguimientoPadre.getCRSEG_TIPO_RESPUESTA());
                                mailer.start();
								if(objJsonFasesSeguimientos.length()==0){
									//REGISTRO DE LA NOVEDAD NOTIFICACION PARA EL SEGUIMIENTO PADRE EN CASO DE SOLO GUARDADO
									objNotificacionSeguimiento = new Cgg_res_novedad_notificacion();
									objNotificacionSeguimiento.setCRNOV_CODIGO("KEYGEN");
									objNotificacionSeguimiento.setCRSEG_CODIGO(objSeguimientoPadre.getCRSEG_CODIGO());
									objNotificacionSeguimiento.setCRNOV_DESCRIPCION("TRAMITE SOLO GUARDADO EL "+DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date()));
									objNotificacionSeguimiento.setCRNOV_TIPO(TIPONOVEDAD.COMENTARIO.getValue());
									objNotificacionSeguimiento.setCRNOV_FECHA_REGISTRO(new Date());
									objNotificacionSeguimiento.setCRNOV_ESTADO(true);
									objNotificacionSeguimiento.setCRNOV_USUARIO_INSERT(userName);
									objNotificacionSeguimiento.setCRNOV_USUARIO_UPDATE(userName);									
									new com.besixplus.sii.db.Cgg_res_novedad_notificacion(objNotificacionSeguimiento).insert(objConn);

								}

								//INSERCION DE ADJUNTO DE REQUERIMIENTOS DE TRAMITE.
								for(Iterator<String> iCodigoAdjunto=codigoAdjuntoRequisito.iterator();iCodigoAdjunto.hasNext();){
									String codigoAdjunto = iCodigoAdjunto.next();
									Cgg_res_adjunto adjuntoRequisito = new Cgg_res_adjunto();
									adjuntoRequisito.setCRADJ_CODIGO(codigoAdjunto); 
									adjuntoRequisito = new com.besixplus.sii.db.Cgg_res_adjunto(adjuntoRequisito).select(objConn);
									adjuntoRequisito.setCRSEG_CODIGO(objSeguimientoPadre.getCRSEG_CODIGO());
									new com.besixplus.sii.db.Cgg_res_adjunto(adjuntoRequisito).update(objConn);
								}

								if(inAdjuntos != null){
									//INSERCION DE ADJUNTO GENERALES
									for(Cgg_res_adjunto objAdjunto : inAdjuntos){

										objAdjunto.setCRADJ_ESTADO(true);
										objAdjunto.setCRSEG_CODIGO(objSeguimientoPadre.getCRSEG_CODIGO());
										objAdjunto.setCRADJ_USUARIO_INSERT(userName);
										objAdjunto.setCRADJ_USUARIO_UPDATE(userName);

										flagAdjuntos = new com.besixplus.sii.db.Cgg_res_adjunto(objAdjunto).insert(objConn);
										if(flagAdjuntos.equalsIgnoreCase("true")== false){
											break;
										}
									}
								}

								//log+="-10 varios adjuntos del seguijmiento padre";

								if(flagAdjuntos.equalsIgnoreCase("true")==true){																			

									objJsonFasesSeguimientos = new JSONArray(inCrfas_codigo);

									if(objJsonFasesSeguimientos.length()>=1){
										for(int h=0;h<objJsonFasesSeguimientos.length();h++){
											tmpFaseDespacho = objJsonFasesSeguimientos.getJSONObject(h);

											objFaseDespacho = new Cgg_res_fase();
											objFaseDespacho.setCRFAS_CODIGO(tmpFaseDespacho.getString("CRFAS_CODIGO"));
											objFaseDespacho = new com.besixplus.sii.db.Cgg_res_fase(objFaseDespacho).select(objConn);

											//TODO: DESCOMENTAR PARA CONTROL DE USUARIO CUANDO HAYA USUARIOS REALES.
											if(tmpFaseDespacho.getString("CUSU_CODIGO")!=null /*&&  
														objFaseUsuario.getCUSU_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() && 
														objFaseUsuario.getCUSU_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()*/ &&
														objFaseDespacho.getCRFAS_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue()	&&
														objFaseDespacho.getCRFAS_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

												objSeguimientoHijo = new Cgg_res_seguimiento();																		

												//REGISTRO DE LOS SEGUIMIENTOS HIJOS DE UN SEGUIMIENTO DE UN TRAMITE.
												objSeguimientoHijo.setCRSEG_CODIGO("KEYGEN");
												objSeguimientoHijo.setCGG_CRSEG_CODIGO(null); 
												objSeguimientoHijo.setCRTRA_CODIGO(res[0]); 
												objSeguimientoHijo.setCRFAS_CODIGO(objFaseDespacho.getCRFAS_CODIGO()); 
												objSeguimientoHijo.setCGG_CRFAS_CODIGO(objFase.getCRFAS_CODIGO()); 
												objSeguimientoHijo.setCUSU_CODIGO(tmpFaseDespacho.getString("CUSU_CODIGO")); 
												objSeguimientoHijo.setCRSEG_DESCRIPCION(""); 
												objSeguimientoHijo.setCRSEG_ESTADO_ATENCION(ESTADOATENCION.RECIBIDO.getValue()); 
												objSeguimientoHijo.setCRSEG_OBSERVACION(""); 
												objSeguimientoHijo.setCRSEG_TIPO_RESPUESTA(TIPORESPUESTA.INDETERMINADO.getValue()); 
												objSeguimientoHijo.setCRSEG_TIPO_ACTIVIDAD(objFaseDespacho.getCRFAS_TAREA_REALIZA()); 
												objSeguimientoHijo.setCRSEG_FECHA_RECEPCION(new Date()); 
												objSeguimientoHijo.setCRSEG_FECHA_REVISION(null); 
												objSeguimientoHijo.setCRSEG_FECHA_DESPACHO(null); 
												objSeguimientoHijo.setCRSEG_ESTADO_HIJO(ESTADORESPUESTA.SINHIJOS.getValue()); 																										
												objSeguimientoHijo.setCRSEG_VECES_REVISION(new BigDecimal(0)); 
												objSeguimientoHijo.setCRSEG_NUMERO(new BigDecimal(0));
												objSeguimientoHijo.setCRSEG_ESTADO(true);

												objSeguimientoHijo.setCRSEG_USUARIO_INSERT(userName);
												objSeguimientoHijo.setCRSEG_USUARIO_UPDATE(userName);											

												flagSeguimientoHijo = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimientoHijo).insert(objConn);

												if(flagSeguimientoHijo.equalsIgnoreCase("true")==false){												
													break;
												}else{

													//REGISTRO DE LA NOVEDAD NOTIFICACION PARA EL SEGUIMIENTO HIJO
													objNotificacionSeguimiento = new Cgg_res_novedad_notificacion();
													objNotificacionSeguimiento.setCRNOV_CODIGO("KEYGEN");
													objNotificacionSeguimiento.setCRSEG_CODIGO(objSeguimientoHijo.getCRSEG_CODIGO());
													objNotificacionSeguimiento.setCRNOV_DESCRIPCION(tmpFaseDespacho.getString("CRFAS_SUMILLA"));
													objNotificacionSeguimiento.setCRNOV_TIPO(TIPONOVEDAD.COMENTARIO.getValue());
													objNotificacionSeguimiento.setCRNOV_FECHA_REGISTRO(new Date());
													objNotificacionSeguimiento.setCRNOV_ESTADO(true);
													objNotificacionSeguimiento.setCRNOV_USUARIO_INSERT(userName);
													objNotificacionSeguimiento.setCRNOV_USUARIO_UPDATE(userName);
													if(tmpFaseDespacho.getString("CRFAS_SUMILLA")!= null && 
															tmpFaseDespacho.getString("CRFAS_SUMILLA").trim().length() >=1){
														String flagSumillaSeguimiento = new com.besixplus.sii.db.Cgg_res_novedad_notificacion(objNotificacionSeguimiento).insert(objConn);
													}												
													//NOTIFICACION A TRAVEZ DE CORREO ELECTRONICO AL USUARIO DEL SEGUIMIENTO Q RECIBIO EL SEGUIMIENTO.
													//TODO: IMPLEMENTAR LA NOTIFICACION POR CORREO ELECTRONICO.
													//Notificador objNotificador = new Notificador(inMail, inAsunto, inContenido, inNombreAdjuntos, inAdjuntos)																								
												}

											}else{
												flagSeguimientoHijo = "false";
												break;											
											}	

											if(flagSeguimientoHijo.equalsIgnoreCase("true")==false){												
												break;
											}										
										}
										//log+="-11 Seguimientos hijos";
									}else{
										flagSeguimientoHijo = "true";
										//res[1]="SOLO GUARDADO";
									}

									if(flagSeguimientoHijo.equalsIgnoreCase("true")==true){										
										objConn.commit();																												
									}else{
										res[0]= null;
										res[1]="SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR LOS SEGUIMIENTOS HIJOS DEL TRAMITE.";
									}
								}else{
									objConn.rollback();
									res[0] = null;
									res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR LOS ADJUNTOS DEL TRAMITE.";
								}
							}else{
								objConn.rollback();
								res[0]= null;
								res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR EL SEGUIMIENTO INICIAL DEL TRAMITE.";
							}																																																																													
						}else{
							objConn.rollback();
							res[0] = null;
							res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE OBTENER INFORMACION DE LA FASE PARA DESPACHO O DE LA FASE INICIAL DEL PROCESO.";
						}

					}else{
						objConn.rollback();
						res[0] = null;
						res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR LOS REQUISITOS DEL TRAMITE.";
					}																																
				}else{
					//log+="-6.n en el else de la desicion";
					objConn.rollback();
					res[0] = null;
					res[1] = res[1] +" SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR EL TRAMITE.";					
				}			
			}else{
				objConn.rollback();
				res[0] = null;
				res[1] = tmpMsg ;
			}
			objConn.setAutoCommit(true);			
			objConn.close();
		}catch(SQLException inEx){					
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inEx);
			res = new String[2];
			res[0] = null;			
			res[1] =inEx.getMessage();						
		}catch (Exception inException){			
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			res = new String[2];
			res[0] = null;			
			res[1] =inException.getMessage();			
		}
		try {
			resultado =new JSONArray(res).toString();
		} catch (JSONException e) {
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			resultado = "false";
		}		
		return resultado;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_tramite EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format Cadena de formato de salida JSON/XML.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectPageDirect1(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
			){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		String userName = tmpRequest.getUserPrincipal().getName();
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();			
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}	
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_res_tramite.selectAllDirect1(con,userName, start, limit, sort, dir, keyword);
			tmpCount = new com.besixplus.sii.db.Cgg_res_tramite().selectCount1(con, keyword,userName); 
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}

	/**
	 * Elimina un tramite de estado solo guardado definitivamente.
	 * @param inCrtra_codigo Codigo de tramite.
	 * @return ServerResponse 
	 */
	@WebMethod
	public String eliminarTramite(
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo
			){

		ServerResponse responser = new ServerResponse(false,"Tramite no fue eliminado",null);

		boolean flagSeguimiento = true;				
		boolean flagNotificacion = true;
		boolean flagTramite = false;
		boolean flagCriterio = false;


		com.besixplus.sii.objects.Cgg_res_tramite tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
		com.besixplus.sii.objects.Cgg_res_seguimiento seguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();
		ArrayList<Cgg_res_seguimiento> coleccionSeguimientoPadre = null;		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_tramite tmpObj = new com.besixplus.sii.objects.Cgg_res_tramite();
		com.besixplus.sii.objects.Cgg_configuracion confTramiteSoloGuardado = new com.besixplus.sii.objects.Cgg_configuracion(); 

		tmpObj.setCRTRA_CODIGO(inCrtra_codigo);
		try{
			Connection objConn = ManagerConnection.getConnection();
			objConn.setAutoCommit(false);			
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(objConn, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				objConn.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}	

			confTramiteSoloGuardado = new Cgg_configuracion();												
			confTramiteSoloGuardado.setCGCNF_CONFIGURACION("ESTADO TRAMITE SOLO GUARDADO");							
			confTramiteSoloGuardado = new com.besixplus.sii.db.Cgg_configuracion(confTramiteSoloGuardado).selectCGCNF_CONFIGURACION(objConn);

			tramite.setCRTRA_CODIGO(inCrtra_codigo);			 
			tramite = new com.besixplus.sii.db.Cgg_res_tramite(tramite).select(objConn);

			if( tramite.getCRTRA_CODIGO() != null &&  
					tramite.getCRTRA_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
					tramite.getCRTRA_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue() &&
					tramite.getCRETT_CODIGO().equalsIgnoreCase(confTramiteSoloGuardado.getCGCNF_VALOR_CADENA())==true
					){

				seguimiento.setCRTRA_CODIGO(inCrtra_codigo);
				seguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(seguimiento).select(objConn);

				coleccionSeguimientoPadre = new com.besixplus.sii.db.Cgg_res_seguimiento(seguimiento).selectSeguimientoPadre(objConn);
				com.besixplus.sii.objects.Cgg_res_seguimiento tmpObjSeguimientoPadre = new com.besixplus.sii.objects.Cgg_res_seguimiento();
				for(java.util.Iterator<Cgg_res_seguimiento> objISeguimientoPadre = coleccionSeguimientoPadre.iterator();objISeguimientoPadre.hasNext();){
					tmpObjSeguimientoPadre = objISeguimientoPadre.next();

					com.besixplus.sii.objects.Cgg_res_novedad_notificacion tmpNovedadNotificacion = new com.besixplus.sii.objects.Cgg_res_novedad_notificacion();					
					tmpNovedadNotificacion.setCRSEG_CODIGO(tmpObjSeguimientoPadre.getCRSEG_CODIGO());

					com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio tmpCriterio = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();										
					tmpCriterio.setCRSEG_CODIGO(tmpObjSeguimientoPadre.getCRSEG_CODIGO());

					flagNotificacion = new com.besixplus.sii.db.Cgg_res_novedad_notificacion(tmpNovedadNotificacion).deleteCGG_RES_SEGUIMIENTO1(objConn);

					flagCriterio = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(tmpCriterio).deleteCGG_RES_SEGUIMIENTO(objConn);

					if(flagNotificacion == true && flagCriterio==true ){
						flagSeguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(tmpObjSeguimientoPadre).delete1(objConn);						
					}else{
						flagSeguimiento = false;
						flagTramite = false;
						responser.setMsg("NO SE PUEDO ELIMINAR LAS NOTIFICACIONES Y/O CRITERIOS ASOCIADOS AL TRAMITE.");
					}
					if(flagSeguimiento == false){
						flagSeguimiento = false;
						flagTramite = false;
						responser.setMsg("NO SE PUDO ELIMINAR EL REGISTRO DE SEGUIMIENTO INICIAL DEL TRAMITE.");
						break;
					}
				}
				if (flagSeguimiento == true){					
					flagTramite = new com.besixplus.sii.db.Cgg_res_tramite(tmpObj).delete1(objConn);
				}else{
					responser.setMsg("NO SE PUDO ELIMINAR EL REGISTRO DE SEGUIMIENTO INICIAL DEL TRAMITE.");
					flagTramite = false;
				}
			}else{
				flagTramite = false;				
				responser.setMsg("TRAMITE NO VALIO O DE ESTADO DIFERENTE A SOLO GUARDADO");
			}
			if(flagTramite == true){
				responser.setMsg("TRAMITE ELIMINADO.");
				objConn.commit();	
			}else{				
				objConn.rollback();
			}
			responser.setSuccess(flagTramite);																								
			objConn.setAutoCommit(true);
			objConn.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			responser.setSuccess(false);
			responser.setMsg(inException.getMessage());
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			responser.setSuccess(false);
			responser.setMsg(inException.getMessage());
		}
		return new JSONObject(responser).toString();
	}

	/**
	 * Registra un tramite para la cual realiza una trasacion con informacion de adjuntos, fase, usuario, seguimiento, personal, entre otros..
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE.
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA.
	 * @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO. CAMPO RECURSIVO HACIA LA MISMA TABLA DE PERSONA.
	 * @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO.
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD.
	 * @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA.
	 * @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR.
	 * @param inCgg_cvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	 * @param inCgg_cvveh_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO
	 * @param inCrtra_actividad_residencia ACTIVIDAD A REALIZAR EN LA PROVINCIA POR PARTE DEL BENEFICIARIO RESIDENCIA.
	 * @param inCrtra_observacion OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON.
	 * @param inCrtra_dias_permanencia NUMERO DE DIAS AUTORIZADOS PARA PERMANENCIA DE UNA PERSONA.	 
	 * @param inCrtra_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE.
	 * @param inCrtra_comunicado_radial NUMERO DE COMUNICADO RADIAL QUE PATROCINA EL TRAMITE DE RESIDENCIA TEMPORAL.
	 * @param inCrtra_motivo NO ESPECIFICADO.
	 * @param inCrtra_folio NUMERO DE HOJAS FOLIADAS PARA EL TRAMITE. 
	 * @param inCrtra_fecha_ingreso  Fecha de ingreso del transeunte.
	 * @param inCrtra_fecha_salida  Fecha de salida del transeunte.
	 * @param inBeneficiarios_JSON  Cadena en ofmrato json de los beneficiarios del tramite.
	 * @param inCrfas_codigo Codigo de fase de tramite.
	 * @param inAdjuntos Coleccion de documentos adjuntos del tramite.
	 * @param inRealPath Ruta para creacion de directorio temporal para la creacion de los adjuntos.
	 * @param inRequest Request de la sesion.
	 * @param inResponse Response de la sesion. 
	 * @return null/Cadena de datos en formato json con informacion del numero de tramite y codigo del mismo resgistrados.
	 */	
	public String registrarTramiteTranseunte(
			boolean ingresoWeb,
			String inCrper_codigo,
			String inCrpjr_codigo,
			String inCgg_crper_codigo,
			String inCrpro_codigo,
			String inCrtst_codigo,
			String inCvveh_codigo,			
			String inCisla_codigo,
			String inCvmtr_codigo,			
			String inCgg_cvmtr_codigo,
			String inCgg_cvveh_codigo,
			String inCrtra_actividad_residencia,
			String inCrtra_observacion,
			int inCrtra_dias_permanencia,
			boolean inCrtra_atencion_cliente,
			String inCrtra_comunicado_radial,
			String inCrtra_motivo,
			java.math.BigDecimal inCrtra_folio,			
			Date inCrtra_fecha_ingreso,
			Date inCrtra_fecha_salida,
			String inBeneficiarios_JSON,
			String inCrfas_codigo,			
			ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> inAdjuntos,
			String inRealPath,
			HttpServletRequest inRequest, 
			HttpServletResponse inResponse
			){
		String tmpSessionID = inRequest.getUserPrincipal().getName();
		String tmpRelativePath = File.separatorChar+tmpSessionID+File.separatorChar+inCgg_crper_codigo;
		String tmpRootSessionFolder = inRealPath+File.separatorChar+tmpRelativePath;
		JSONArray arrayJsonBeneficiarios = null;
		JSONArray arrayJsonFasesSeguimientos = null;
		JSONObject objJsonTmpPersona = null;
		JSONArray objJsonRequerimientos = null;
		JSONObject objJsonRequerimientoTramite = null;
		JSONObject objJsonFaseDespacho = null;
		com.besixplus.sii.objects.Cgg_res_persona objTmpBeneficiario = null;
		com.besixplus.sii.objects.Cgg_res_persona objNuevoBeneficiario = null;
		com.besixplus.sii.objects.Cgg_res_tramite objTramite = null;
		com.besixplus.sii.objects.Cgg_res_requisito_tramite objRequisito = null;
		com.besixplus.sii.objects.Cgg_res_seguimiento objSeguimientoPadre = null;
		com.besixplus.sii.objects.Cgg_res_seguimiento objSeguimientoHijo = null;
		com.besixplus.sii.objects.Cgg_res_fase objFaseInicio =  null;	
		com.besixplus.sii.objects.Cgg_res_fase objFaseDespacho =  null;
		boolean bTmpTramiteGrupo = true; 
		String resultado = null;
		String [] res = new String[2];	
		String flagRequisito = "true";
		String cggCrperCodigo = null;
		String flagSeguimientoPadre = "true";
		String flagSeguimientoHijo = "true";
		String flagAdjuntos = "true";
		Cgg_res_novedad_notificacion objNotificacionSeguimiento = null;
		Cgg_usuario objUsuarioRegistro = new Cgg_usuario();
		Cgg_configuracion confTramiteRegistro = null;
		ArrayList<String> flagGuardar = new ArrayList<String>();

		//	ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> inAdjuntos = null;
		int  numeroTramite = 0;

		try {
			Connection objConn= ManagerConnection.getConnection();	
			objConn.setAutoCommit(false);
			//			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(objConn, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), inRequest.getUserPrincipal().getName(), 1)){
			//				objConn.close();
			//				inResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
			//				return null;
			//			}

			//REGISTRO DEL BENEFICIARIO


			objUsuarioRegistro.setCUSU_NOMBRE_USUARIO(tmpSessionID);
			new com.besixplus.sii.db.Cgg_usuario(objUsuarioRegistro).selectByUsername(objConn);

			//Consulta del estado inicial de un tramite para su registro.
			confTramiteRegistro = new Cgg_configuracion();
			if(ingresoWeb)
				confTramiteRegistro.setCGCNF_CONFIGURACION("ESTADO TRAMITE SOLO GUARDADO");
			else
				confTramiteRegistro.setCGCNF_CONFIGURACION("ESTADO TRAMITE REGISTRADO");
			confTramiteRegistro= new com.besixplus.sii.db.Cgg_configuracion(confTramiteRegistro).selectCGCNF_CONFIGURACION(objConn);

			arrayJsonBeneficiarios = new JSONArray(inBeneficiarios_JSON);

			if(arrayJsonBeneficiarios.length()>=1){
				bTmpTramiteGrupo = true;
			}
			//INGRESO DE TRAMITE POR EL NUMERO DE BENEFICIARIOS ESTABLECIDOS.
			for(int i=0;i<arrayJsonBeneficiarios.length();i++){

				objJsonTmpPersona = arrayJsonBeneficiarios.getJSONObject(i);
				objTmpBeneficiario = new Cgg_res_persona();
				objTmpBeneficiario.setCRPER_NUM_DOC_IDENTIFIC(objJsonTmpPersona.getString("CRPER_NUM_DOC_IDENTIFIC"));
				objTmpBeneficiario = new com.besixplus.sii.db.Cgg_res_persona(objTmpBeneficiario).selectNumDoc(objConn);

				if(objTmpBeneficiario.getCRPER_CODIGO()!=null && objTmpBeneficiario.getCRPER_CODIGO().trim().length()>=1){
					//SI EL BENEFICIARIO EXISTE.
					cggCrperCodigo = "true";

					//Actualizacion de datos del beneficiario.
					if(objJsonTmpPersona.has("CRECV_CODIGO"))
						objTmpBeneficiario.setCRECV_CODIGO(objJsonTmpPersona.getString("CRECV_CODIGO"));
					objTmpBeneficiario.setCRDID_CODIGO(objJsonTmpPersona.getString("CRDID_CODIGO"));
					objTmpBeneficiario.setCRPER_NOMBRES(objJsonTmpPersona.getString("CRPER_NOMBRES"));
					objTmpBeneficiario.setCRPER_APELLIDO_PATERNO(objJsonTmpPersona.getString("CRPER_APELLIDO_PATERNO"));
					objTmpBeneficiario.setCRPER_APELLIDO_MATERNO(objJsonTmpPersona.getString("CRPER_APELLIDO_MATERNO"));
					objTmpBeneficiario.setCRPER_NUM_DOC_IDENTIFIC(objJsonTmpPersona.getString("CRPER_NUM_DOC_IDENTIFIC"));
					objTmpBeneficiario.setCRPER_GENERO(objJsonTmpPersona.getInt("CRPER_GENERO"));

					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					Date fechaNacimiento = null;
					try{
						fechaNacimiento = df.parse(objJsonTmpPersona.getString("CRPER_FECHA_NACIMIENTO"));
					} catch (ParseException e){
						e.printStackTrace();
						fechaNacimiento = new Date();
					}
					objTmpBeneficiario.setCRPER_FECHA_NACIMIENTO( fechaNacimiento );
					//					objTmpBeneficiario.setCRPER_USUARIO_INSERT(inRequest.getUserPrincipal().getName());
					//					objTmpBeneficiario.setCRPER_USUARIO_UPDATE(inRequest.getUserPrincipal().getName());

					new com.besixplus.sii.db.Cgg_res_persona(objTmpBeneficiario).update(objConn);

					objNuevoBeneficiario = new Cgg_res_persona();
					objNuevoBeneficiario.setCRPER_CODIGO(objTmpBeneficiario.getCRPER_CODIGO());
					objNuevoBeneficiario.setCRPER_NUM_DOC_IDENTIFIC(objTmpBeneficiario.getCRPER_NUM_DOC_IDENTIFIC());

				}else{
					//SI EL BENEFICIARIO ES NUEVO.
					objNuevoBeneficiario = new Cgg_res_persona();
					objNuevoBeneficiario.setCRPER_CODIGO("KEYGEN");
					if(objJsonTmpPersona.has("CRECV_CODIGO"))
						objNuevoBeneficiario.setCRECV_CODIGO(objJsonTmpPersona.getString("CRECV_CODIGO"));
					objNuevoBeneficiario.setCRDID_CODIGO(objJsonTmpPersona.getString("CRDID_CODIGO"));
					objNuevoBeneficiario.setCRPER_NOMBRES(objJsonTmpPersona.getString("CRPER_NOMBRES"));
					objNuevoBeneficiario.setCRPER_APELLIDO_PATERNO(objJsonTmpPersona.getString("CRPER_APELLIDO_PATERNO"));
					objNuevoBeneficiario.setCRPER_APELLIDO_PATERNO(objJsonTmpPersona.getString("CRPER_APELLIDO_PATERNO"));
					objNuevoBeneficiario.setCRPER_NUM_DOC_IDENTIFIC(objJsonTmpPersona.getString("CRPER_NUM_DOC_IDENTIFIC"));
					objNuevoBeneficiario.setCRPER_GENERO(objJsonTmpPersona.getInt("CRPER_GENERO"));

					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					Date fechaNacimiento = null;
					try{
						fechaNacimiento = df.parse(objJsonTmpPersona.getString("CRPER_FECHA_NACIMIENTO"));
					} catch (ParseException e){
						e.printStackTrace();
						fechaNacimiento = new Date();
					}
					objNuevoBeneficiario.setCRPER_FECHA_NACIMIENTO(fechaNacimiento);
					objNuevoBeneficiario.setCRPER_ESTADO(true);

					objNuevoBeneficiario.setCRPER_USUARIO_INSERT(tmpSessionID);
					objNuevoBeneficiario.setCRPER_USUARIO_UPDATE(tmpSessionID);
					cggCrperCodigo = new com.besixplus.sii.db.Cgg_res_persona(objNuevoBeneficiario).insert(objConn);
				}
				//Hasta aqui el ingreso de la primera persona

				//INGRESO DE UN TRAMITE PARA EL BENEFICIARIO ACTUAL.
				if(cggCrperCodigo.equalsIgnoreCase("true")) {

					objTramite = new com.besixplus.sii.objects.Cgg_res_tramite();
					objTramite.setCRTRA_CODIGO("KEYGEN");
					objTramite.setCRPER_CODIGO(inCrper_codigo);

					objTramite.setCRPJR_CODIGO(inCrpjr_codigo);
					//objTramite.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
					objTramite.setCGG_CRPER_CODIGO(objNuevoBeneficiario.getCRPER_CODIGO());
					if (inCrpro_codigo == null && inCrtst_codigo != null) {
						Cgg_res_tipo_solicitud_tramite solTramite = new Cgg_res_tipo_solicitud_tramite();
						solTramite.setCRTST_CODIGO(inCrtst_codigo);
						solTramite = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(solTramite).select(objConn);
						inCrpro_codigo = solTramite.getCRPRO_CODIGO();
					}
					objTramite.setCRPRO_CODIGO(inCrpro_codigo);
					objTramite.setCRTST_CODIGO(inCrtst_codigo);
					objTramite.setCVVEH_CODIGO(inCvveh_codigo);

					objTramite.setCRETT_CODIGO(confTramiteRegistro.getCGCNF_VALOR_CADENA());
					objTramite.setCISLA_CODIGO(inCisla_codigo);
					objTramite.setCVMTR_CODIGO(inCvmtr_codigo);
					objTramite.setCGG_CVMTR_CODIGO(inCgg_cvmtr_codigo);
					objTramite.setCGG_CVVEH_CODIGO(inCgg_cvveh_codigo);

					//Seccion tomada del servidor o autogenerada.
					objTramite.setCRTRA_ANIO(new BigDecimal(Calendar.getInstance().get(Calendar.YEAR)));
					objTramite.setCRTRA_NUMERO(new BigDecimal(0));
					objTramite.setCRTRA_FECHA_RECEPCION(new Date());

					objTramite.setCRTRA_ACTIVIDAD_RESIDENCIA(inCrtra_actividad_residencia);
					objTramite.setCRTRA_OBSERVACION(inCrtra_observacion);
					objTramite.setCRTRA_DIAS_PERMANENCIA(inCrtra_dias_permanencia);

					objTramite.setCRTRA_ATENCION_CLIENTE(inCrtra_atencion_cliente);
					objTramite.setCRTRA_COMUNICADO_RADIAL(inCrtra_comunicado_radial);
					objTramite.setCRTRA_MOTIVO(inCrtra_motivo);
					objTramite.setCRTRA_PENDIENTE(ESTADOPENDIENTETRAMITE.NOEVALUADO.getValue());
					objTramite.setCRTRA_FOLIO(inCrtra_folio);

					objTramite.setCRTRA_GRUPO(bTmpTramiteGrupo);
					objTramite.setCRTRA_ORDEN(new BigDecimal(i + 1));
					objTramite.setCRTRA_FECHA_INGRESO(inCrtra_fecha_ingreso);
					objTramite.setCRTRA_FECHA_SALIDA(inCrtra_fecha_salida);
					objTramite.setCRTRA_ESTADO(true);

					objTramite.setCRTRA_USUARIO_INSERT(tmpSessionID);
					objTramite.setCRTRA_USUARIO_UPDATE(tmpSessionID);


					//Declaracion de variables para cada instancia de un tramite.
					String flagAdjuntosRequisito = "true";
					ArrayList<String> codigoAdjuntoRequisito = new ArrayList<String>();

					//REGISTRO DEL TRAMITE
					objTramite.setCRTRA_NUMERO(new BigDecimal(numeroTramite));
					res = new com.besixplus.sii.db.Cgg_res_tramite(objTramite).insert2(objConn);
					numeroTramite = objTramite.getCRTRA_NUMERO().intValue();
					if(!ingresoWeb) {//EJECUTAMOS EL SEGUIMIENTO
						if (res != null) {
							if (objJsonTmpPersona.has("CRPER_REQUISITOS_JSON"))
								objJsonRequerimientos = new JSONArray(objJsonTmpPersona.getString("CRPER_REQUISITOS_JSON"));

							//REGISTRO DE LOS REQUISITOS DEL TRAMITE.
							if (objJsonRequerimientos != null) {
								for (int j = 0; j < objJsonRequerimientos.length(); j++) {

									objJsonRequerimientoTramite = objJsonRequerimientos.getJSONObject(j);

									objRequisito = new Cgg_res_requisito_tramite();
									objRequisito.setCRRQT_CODIGO("KEYGEN");
									objRequisito.setCRTRA_CODIGO(objTramite.getCRTRA_CODIGO());
									objRequisito.setCRSRQ_CODIGO(objJsonRequerimientoTramite.getString("CRSRQ_CODIGO"));
									objRequisito.setCRRQT_CUMPLE(objJsonRequerimientoTramite.getBoolean("CRRQT_CUMPLE"));
									objRequisito.setCRRQT_OBSERVACION(objJsonRequerimientoTramite.getString("CRRQT_OBSERVACION"));
									objRequisito.setCRRQT_ESTADO(true);
									objRequisito.setCRRQT_USUARIO_INSERT(tmpSessionID);
									objRequisito.setCRRQT_USUARIO_UPDATE(tmpSessionID);

									flagRequisito = new com.besixplus.sii.db.Cgg_res_requisito_tramite(objRequisito).insert(objConn);
									if (flagRequisito.equalsIgnoreCase("true") == false) {
										break;
									} else if (objJsonRequerimientoTramite.getString("CRATE_DATA") != null && objJsonRequerimientoTramite.getString("CRATE_DATA").trim().length() > 0) {
										JSONObject jsonAdjuntoTemporal = objJsonRequerimientoTramite.getJSONObject("CRATE_DATA");

										//REGISTRO DE ADJUNTO DE REQUERIMIENTOS DE TRAMITE.
										Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
										adjuntoTemporal.setCRATE_CODIGO(jsonAdjuntoTemporal.getString("CRATE_CODIGO"));
										adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(objConn);

										com.besixplus.sii.objects.Cgg_res_adjunto adjuntoRequisito = new com.besixplus.sii.objects.Cgg_res_adjunto();
										adjuntoRequisito.setCRADJ_CODIGO("KEYGEN");
										adjuntoRequisito.setCRADJ_NOMBRE_ADJUNTO(adjuntoTemporal.getCRATE_NOMBRE());
										adjuntoRequisito.setCRADJ_ARCHIVO_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());
										adjuntoRequisito.setCRADJ_CONTENIDO("application/octet-stream");
										adjuntoRequisito.setCRADJ_ESTADO(true);
										adjuntoRequisito.setCRADJ_FECHA_REGISTRO(new Date());
										adjuntoRequisito.setCRRQT_CODIGO(objRequisito.getCRRQT_CODIGO());
										adjuntoRequisito.setCRADJ_USUARIO_INSERT(tmpSessionID);
										adjuntoRequisito.setCRADJ_USUARIO_UPDATE(tmpSessionID);

										flagAdjuntosRequisito = new com.besixplus.sii.db.Cgg_res_adjunto(adjuntoRequisito).insert(objConn);
										if (flagAdjuntosRequisito.equalsIgnoreCase("false") == true) {
											break;
										}
										codigoAdjuntoRequisito.add(adjuntoRequisito.getCRADJ_CODIGO());
									}
								}
							}

							if (objJsonRequerimientos == null || flagRequisito.equalsIgnoreCase("true")) {
								// SELECCION FASE INICIAL
								objFaseInicio = new Cgg_res_fase();
								objFaseInicio.setCRPRO_CODIGO(inCrpro_codigo);
								objFaseInicio = new com.besixplus.sii.db.Cgg_res_fase(objFaseInicio).selectFaseInicio(objConn, inCisla_codigo);
								if (objFaseInicio.getCRFAS_CODIGO() != null &&
										objFaseInicio.getCRFAS_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
										objFaseInicio.getCRFAS_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()) {

									//REGISTRO DE SEGUIMIENTO INICIAL DE UN TRAMITE.
									objSeguimientoPadre = new Cgg_res_seguimiento();

									objSeguimientoPadre.setCRSEG_CODIGO("KEYGEN");
									objSeguimientoPadre.setCGG_CRSEG_CODIGO(null);
									objSeguimientoPadre.setCRTRA_CODIGO(objTramite.getCRTRA_CODIGO());
									objSeguimientoPadre.setCRFAS_CODIGO(objFaseInicio.getCRFAS_CODIGO());
									objSeguimientoPadre.setCGG_CRFAS_CODIGO(objFaseInicio.getCRFAS_CODIGO());
									objSeguimientoPadre.setCUSU_CODIGO(objUsuarioRegistro.getCUSU_CODIGO());
									objSeguimientoPadre.setCRSEG_DESCRIPCION("Registro de seguimiento para tr\u00E1mite grupal " + objTramite.getCRTRA_ANIO().toString() + "-" + res[1] + "-" + objTramite.getCRTRA_ORDEN() + ".");
									objSeguimientoPadre.setCRSEG_ESTADO_ATENCION(ESTADOATENCION.DESPACHADO.getValue());
									objSeguimientoPadre.setCRSEG_OBSERVACION(inCrtra_observacion);
									objSeguimientoPadre.setCRSEG_TIPO_RESPUESTA(TIPORESPUESTA.APROBADO.getValue());
									objSeguimientoPadre.setCRSEG_TIPO_ACTIVIDAD(objFaseInicio.getCRFAS_TAREA_REALIZA());
									objSeguimientoPadre.setCRSEG_FECHA_RECEPCION(new Date());
									objSeguimientoPadre.setCRSEG_FECHA_REVISION(new Date());
									objSeguimientoPadre.setCRSEG_FECHA_DESPACHO(new Date());
									objSeguimientoPadre.setCRSEG_ESTADO_HIJO(ESTADORESPUESTA.SINRESPUESTAS.getValue());
									objSeguimientoPadre.setCRSEG_ESTADO(true);
									objSeguimientoPadre.setCRSEG_VECES_REVISION(new BigDecimal(1));
									objSeguimientoPadre.setCRSEG_NUMERO(new BigDecimal(0));
									objSeguimientoPadre.setCRSEG_ESTADO(true);

									objSeguimientoPadre.setCRSEG_USUARIO_INSERT(tmpSessionID);
									objSeguimientoPadre.setCRSEG_USUARIO_UPDATE(tmpSessionID);

									flagSeguimientoPadre = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimientoPadre).insert(objConn);

									if (flagSeguimientoPadre.equalsIgnoreCase("true") == true) {

										//INSERCION DE ADJUNTO DE REQUERIMIENTOS DE TRAMITE.
										for (Iterator<String> iCodigoAdjunto = codigoAdjuntoRequisito.iterator(); iCodigoAdjunto.hasNext(); ) {
											String codigoAdjunto = iCodigoAdjunto.next();
											Cgg_res_adjunto adjuntoRequisito = new Cgg_res_adjunto();
											adjuntoRequisito.setCRADJ_CODIGO(codigoAdjunto);
											adjuntoRequisito = new com.besixplus.sii.db.Cgg_res_adjunto(adjuntoRequisito).select(objConn);
											adjuntoRequisito.setCRSEG_CODIGO(objSeguimientoPadre.getCRSEG_CODIGO());
											new com.besixplus.sii.db.Cgg_res_adjunto(adjuntoRequisito).update(objConn);
										}

										//REGISTRO DE ADJUNTOS GENERALES DEL TRAMITE
										if (inAdjuntos != null) {
											for (Cgg_res_adjunto objAdjunto : inAdjuntos) {
												//EL OBJETO ADJUNTO POR DEFECTO ESTA PRECONFIGURADO
												System.out.println(objAdjunto.getCRADJ_CODIGO());
												objAdjunto.setCRADJ_CODIGO("KEYGEN");
												objAdjunto.setCRADJ_ESTADO(true);
												objAdjunto.setCRSEG_CODIGO(objSeguimientoPadre.getCRSEG_CODIGO());
												//objAdjunto.setCRPER_CODIGO(objNuevoBeneficiario.getCRPER_CODIGO());

												flagAdjuntos = new com.besixplus.sii.db.Cgg_res_adjunto(objAdjunto).insert(objConn);
												if (flagAdjuntos.equalsIgnoreCase("true") == false) {
													break;
												}
											}
										}

										//ADJUNTOS DE CADA PERSONA
										if (flagAdjuntos.equalsIgnoreCase("true")) {

											tmpRelativePath = "tmp" + File.separatorChar + tmpSessionID + File.separatorChar + objNuevoBeneficiario.getCRPER_NUM_DOC_IDENTIFIC();
											tmpRootSessionFolder = inRealPath + File.separatorChar + tmpRelativePath;

											ArrayList<Cgg_res_adjunto> objAdjuntoBeneficiario = readBeneficiarioAdjuntos(tmpRootSessionFolder);
											if (objAdjuntoBeneficiario != null) {
												for (Cgg_res_adjunto objAdjunto : objAdjuntoBeneficiario) {
													//EL OBJETO ADJUNTO POR DEFECTO ESTA PRECONFIGURADO
													objAdjunto.setCRADJ_ESTADO(true);
													objAdjunto.setCRSEG_CODIGO(objSeguimientoPadre.getCRSEG_CODIGO());
													//objAdjunto.setCRPER_CODIGO(objNuevoBeneficiario.getCRPER_CODIGO());
													objAdjunto.setCRADJ_USUARIO_INSERT(tmpSessionID);
													objAdjunto.setCRADJ_USUARIO_UPDATE(tmpSessionID);

													flagAdjuntos = new com.besixplus.sii.db.Cgg_res_adjunto(objAdjunto).insert(objConn);
													if (flagAdjuntos.equalsIgnoreCase("true") == false) {
														break;
													}
												}
											}
										}

										if (flagAdjuntos.equalsIgnoreCase("true") == true && inCrfas_codigo != null) {

											arrayJsonFasesSeguimientos = new JSONArray(inCrfas_codigo);

											for (int h = 0; h < arrayJsonFasesSeguimientos.length(); h++) {
												objJsonFaseDespacho = arrayJsonFasesSeguimientos.getJSONObject(h);

												objFaseDespacho = new Cgg_res_fase();
												objFaseDespacho.setCRFAS_CODIGO(objJsonFaseDespacho.getString("CRFAS_CODIGO"));
												objFaseDespacho = new com.besixplus.sii.db.Cgg_res_fase(objFaseDespacho).select(objConn);

												//TODO: DESCOMENTAR PARA CONTROL DE USUARIO CUANDO HAYA USUARIOS REALES.
												if (objJsonFaseDespacho.getString("CUSU_CODIGO") != null /*&&
															objFaseUsuario.getCUSU_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() && 
															objFaseUsuario.getCUSU_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()*/ &&
														objFaseDespacho.getCRFAS_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
														objFaseDespacho.getCRFAS_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()) {

													objSeguimientoHijo = new Cgg_res_seguimiento();

													//REGISTRO DE LOS SEGUIMIENTOS HIJOS DE UN SEGUIMIENTO DE UN TRAMITE.
													objSeguimientoHijo.setCRSEG_CODIGO("KEYGEN");
													objSeguimientoHijo.setCGG_CRSEG_CODIGO(null);
													objSeguimientoHijo.setCRTRA_CODIGO(objTramite.getCRTRA_CODIGO());
													objSeguimientoHijo.setCRFAS_CODIGO(objFaseDespacho.getCRFAS_CODIGO());
													objSeguimientoHijo.setCGG_CRFAS_CODIGO(objFaseInicio.getCRFAS_CODIGO());
													objSeguimientoHijo.setCUSU_CODIGO(objJsonFaseDespacho.getString("CUSU_CODIGO"));
													objSeguimientoHijo.setCRSEG_DESCRIPCION("");
													objSeguimientoHijo.setCRSEG_ESTADO_ATENCION(ESTADOATENCION.RECIBIDO.getValue());
													objSeguimientoHijo.setCRSEG_OBSERVACION("");
													objSeguimientoHijo.setCRSEG_TIPO_RESPUESTA(TIPORESPUESTA.INDETERMINADO.getValue());
													objSeguimientoHijo.setCRSEG_TIPO_ACTIVIDAD(objFaseDespacho.getCRFAS_TAREA_REALIZA());
													objSeguimientoHijo.setCRSEG_FECHA_RECEPCION(new Date());
													objSeguimientoHijo.setCRSEG_FECHA_REVISION(null);
													objSeguimientoHijo.setCRSEG_FECHA_DESPACHO(null);
													objSeguimientoHijo.setCRSEG_ESTADO_HIJO(ESTADORESPUESTA.SINHIJOS.getValue());
													objSeguimientoHijo.setCRSEG_VECES_REVISION(new BigDecimal(0));
													objSeguimientoHijo.setCRSEG_NUMERO(new BigDecimal(0));
													objSeguimientoHijo.setCRSEG_ESTADO(true);

													objSeguimientoHijo.setCRSEG_USUARIO_INSERT(tmpSessionID);
													objSeguimientoHijo.setCRSEG_USUARIO_UPDATE(tmpSessionID);

													flagSeguimientoHijo = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimientoHijo).insert(objConn);

													if (flagSeguimientoHijo.equalsIgnoreCase("true") == false) {
														break;
													} else {

														//REGISTRO DE LA NOVEDAD NOTIFICACION PARA EL SEGUIMIENTO HIJO
														objNotificacionSeguimiento = new Cgg_res_novedad_notificacion();
														objNotificacionSeguimiento.setCRNOV_CODIGO("KEYGEN");
														objNotificacionSeguimiento.setCRSEG_CODIGO(objSeguimientoHijo.getCRSEG_CODIGO());
														objNotificacionSeguimiento.setCRNOV_DESCRIPCION(objJsonFaseDespacho.getString("CRFAS_SUMILLA"));
														objNotificacionSeguimiento.setCRNOV_TIPO(TIPONOVEDAD.COMENTARIO.getValue());
														objNotificacionSeguimiento.setCRNOV_ESTADO(true);
														objNotificacionSeguimiento.setCRNOV_USUARIO_INSERT(tmpSessionID);
														objNotificacionSeguimiento.setCRNOV_USUARIO_UPDATE(tmpSessionID);
														if (objJsonFaseDespacho.getString("CRFAS_SUMILLA") != null &&
																objJsonFaseDespacho.getString("CRFAS_SUMILLA").trim().length() >= 1) {
															String flagSumillaSeguimiento = new com.besixplus.sii.db.Cgg_res_novedad_notificacion(objNotificacionSeguimiento).insert(objConn);
														}
														//NOTIFICACION A TRAVEZ DE CORREO ELECTRONICO AL USUARIO DEL SEGUIMIENTO Q RECIBIO EL SEGUIMIENTO.
														//TODO: IMPLEMENTAR LA NOTIFICACION POR CORREO ELECTRONICO.
														//Notificador objNotificador = new Notificador(inMail, inAsunto, inContenido, inNombreAdjuntos, inAdjuntos)
													}

												} else {
													flagSeguimientoHijo = "false";
													break;
												}

												if (flagSeguimientoHijo.equalsIgnoreCase("true") == false) {
													break;
												}
											}

											flagGuardar.add(flagSeguimientoHijo);

										} else {
											flagGuardar.add("true");
										}/*else{ // NO HAY ERROR SI NO HAY ADJUNTOS
										//ELSE INGRESO ADJUNTOS
										objConn.rollback();
										res[0] = null;
										res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR LOS ADJUNTOS DEL TRAMITE.";
									}*/
									} else {
										//ELSE SEGUIMIENTO DEFAULT
										objConn.rollback();
										res[0] = null;
										res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR EL SEGUIMIENTO INICIAL DEL TRAMITE.";
									}
								} else {
									//SELECCCION FASE - SEGUIMIENTO INICIO
									objConn.rollback();
									res[0] = null;
									res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE OBTENER INFORMACION DE LA FASE PARA DESPACHO O DE LA FASE INICIAL DEL PROCESO.";
								}
							} else {
								// ELSE REQUISITOS
								objConn.rollback();
								res[0] = null;
								res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR LOS REQUISITOS DEL TRAMITE.";
							}
						} else {
							//ELSE TRAMITE
							objConn.rollback();
							res[0] = null;
							res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR EL TRAMITE.";
						}
					}else{
						flagGuardar.add("true");
					}
				}else{
					//ELSE BENFICIARIO -PERSONA
					objConn.rollback();
					res[0] = null;
					res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR INFORMACION DEL BENEFICIARIO DEL TRAMITE.";
				}

			}//FIN DE LA ITERACION DE TRAMITE POR CADA BENEFICIARIO ESPECIFICADO.
			
			boolean finalFlag = true;					
			
			for(Iterator<String> iGuardar = flagGuardar.iterator();iGuardar.hasNext();){
					if(!iGuardar.next().equalsIgnoreCase("true")){
						finalFlag = false;						
					}					
			}
			
			if(flagGuardar.size() == 0){
				finalFlag = false;
			}
						
			if(finalFlag == true){
				objConn.commit();
			}else{
				objConn.rollback();
				res[0] = null;
				res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR LOS SEGUIMIENTO HIJOS DE UN TRAMITE.";
			}
			
			objConn.setAutoCommit(true);			
			objConn.close();

		} catch (JSONException e) {

			res[0] = null;
			res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR EL TRAMITE.";
			e.printStackTrace();
		} catch (SQLException e) {

			res[0] = null;
			res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR EL TRAMITE.";
			e.printStackTrace();
		} catch (Exception e) {

			res[0] = null;
			res[1] = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR EL TRAMITE.";
			e.printStackTrace();
		}
		try {
			resultado =new JSONArray(res).toString();
		} catch (JSONException e) {
			e.printStackTrace();
			resultado = "false";
		}
		return resultado;
	}

	private ArrayList<Cgg_res_adjunto> readBeneficiarioAdjuntos(String inDirectory){
		//System.out.println(tmpRootSessionFolder);
		//
		ArrayList<Cgg_res_adjunto> objColeccionAdjunto =  new ArrayList<Cgg_res_adjunto>();
		File folder = new File(inDirectory);
		File readFile;
		File[] listOfFiles = folder.listFiles();

		try{
			if(listOfFiles != null){									

				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile()) {

						readFile = new File(inDirectory,listOfFiles[i].getName());
						byte[] bFinalFile = new byte[(int) readFile.length()];		       
						FileInputStream fileInputStream = new FileInputStream(readFile);
						//convert file into array of bytes
						fileInputStream.read(bFinalFile);
						fileInputStream.close();

						com.besixplus.sii.objects.Cgg_res_adjunto objAdjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
						objAdjunto.setCRADJ_CODIGO("KEYGEN");
						objAdjunto.setCRADJ_NOMBRE_ADJUNTO(listOfFiles[i].getName());
						objAdjunto.setCRADJ_ARCHIVO_ADJUNTO(bFinalFile);
						objAdjunto.setCRADJ_CONTENIDO("application/octet-stream");
						objAdjunto.setCRADJ_ESTADO(true);
						objAdjunto.setCRADJ_FECHA_REGISTRO(new Date());
						objColeccionAdjunto.add(objAdjunto);
						System.out.println("File " + listOfFiles[i].getName());
					} else if (listOfFiles[i].isDirectory()) {
						System.out.println("Directory " + listOfFiles[i].getName());
					}
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			objColeccionAdjunto = null;
		}

		return objColeccionAdjunto;
	}


	/**Seleccion todos los tramites de residencia del CGG para consulta en modo de paginacion. Este procedimiento no hace distincion por usuario. Los tramites se muestran unificados de todas las islas y de todos los usuarios con sus debidos privilegios de acceso establecidos.
	 * @param start Indice de inicio de registros a consultar.
	 * @param limit Numero de registros a consultar.
	 * @param sort Campo de ordenamiento de la consulta para la paginacion.
	 * @param dir Direccion de consulta del campo de paginacion.
	 * @param keyword Criterio de consulta de informacion
	 * @param format Formato de salida de la consulta JSON / XML.
	 * @return Cadena de texto de datos en formato especificado.
	 */
	@WebMethod
	public String selectPageHistorial(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
			){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();			
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}			
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_res_tramite.selectPageHistorial(con, start, limit, sort, dir, keyword);
			tmpCount = new com.besixplus.sii.db.Cgg_res_tramite().selectPageHistorialCount(con, keyword); 
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}

	/**Devuelve una cadena de datos en formato especificado de nodos de todo el historial de un tramite anidado y recursivamente de todas las fases que conforma un tramite.
	 * @param inCrtra_codigo Codigo de tramite.
	 * @param format Cadena de formato de salida especificado JSON / XML.
	 * @return Cadena de datos en formato especificado de la estructura jerarquica historica de un tramite.
	 */
	@WebMethod
	public String selectHistorialTramite(
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="format")String format			
			){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);

		com.besixplus.sii.objects.Cgg_res_tramite objTramite = null;
		Cgg_res_seguimiento objSeguimiento = null;
		NodoTramite objNodoTramite = new NodoTramite();
		NodoTramite objNodoSeguimiento =null; 		
		String outResultado = null;
		ArrayList<Cgg_res_seguimiento> colSeguimiento = null;
		ArrayList<NodoTramite> colNodoSeguimiento = null;

		try{
			Connection con = ManagerConnection.getConnection();			
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}			
			con.setAutoCommit(false);
			objTramite = new com.besixplus.sii.objects.Cgg_res_tramite();
			objTramite.setCRTRA_CODIGO(inCrtra_codigo);
			objTramite = new com.besixplus.sii.db.Cgg_res_tramite(objTramite).select(con);
			if(objTramite.getCRTRA_CODIGO()!= null &&
					objTramite.getCRTRA_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
					objTramite.getCRTRA_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

				objNodoTramite.setId(objTramite.getCRTRA_CODIGO());
				objNodoTramite.setName("Tr\u00e1mite: "+objTramite.getCRTRA_ANIO()+"-"+objTramite.getCRTRA_NUMERO());

				objNodoTramite.setData(objTramite);

				objSeguimiento = new Cgg_res_seguimiento();
				objSeguimiento.setCRTRA_CODIGO(objTramite.getCRTRA_CODIGO());

				colNodoSeguimiento = new ArrayList<NodoTramite>();

				colSeguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).selectSeguimientoPadre(con);				
				for(Iterator<Cgg_res_seguimiento> iSeguimiento = colSeguimiento.iterator();iSeguimiento.hasNext();){
					String tmpTipoAtencion= "";
					Cgg_res_seguimiento objTmpSeguimiento =iSeguimiento.next(); 					
					objNodoSeguimiento = new NodoTramite();
					objNodoSeguimiento.setId(objTmpSeguimiento.getCRSEG_CODIGO());

					Cgg_res_fase objFase = new Cgg_res_fase();
					objFase.setCRFAS_CODIGO(objTmpSeguimiento.getCRFAS_CODIGO());										
					objFase=new com.besixplus.sii.db.Cgg_res_fase(objFase).select(con);

					Cgg_usuario objUsuario = new Cgg_usuario();
					objUsuario.setCUSU_CODIGO(objTmpSeguimiento.getCUSU_CODIGO());			
					objUsuario = new com.besixplus.sii.db.Cgg_usuario(objUsuario).select(con);

					/*for(TIPORESPUESTA objTipoRespuesta : CGGEnumerators.TIPORESPUESTA.values()){
						if(objTmpSeguimiento.getCRSEG_TIPO_RESPUESTA() == objTipoRespuesta.getValue()){
							tmpTipoRespusta = objTipoRespuesta.toString();
						}
					}*/

					for(ESTADOATENCION objEstadoAtencion : CGGEnumerators.ESTADOATENCION.values()){
						if(objTmpSeguimiento.getCRSEG_ESTADO_ATENCION() == objEstadoAtencion.getValue()){
							tmpTipoAtencion = objEstadoAtencion.toString();
						}
					}

					objNodoSeguimiento.setName(objFase.getCRFAS_NOMBRE().toUpperCase()+"<br>(<i>"+objUsuario.getCUSU_NOMBRE_USUARIO()+"</i>)<br>"+tmpTipoAtencion);
					objNodoSeguimiento.setData(objTmpSeguimiento);

					ArrayList<NodoTramite> objNodoHijo = selectHistorialTramiteRecursivo(objTmpSeguimiento.getCRSEG_CODIGO(), con);
					objNodoSeguimiento.setChildren(objNodoHijo);

					colNodoSeguimiento.add(objNodoSeguimiento);
				}

				objNodoTramite.setChildren(colNodoSeguimiento);				
			}																				
			outResultado = new Gson().toJson(objNodoTramite);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}		
		return outResultado;
	}

	/**
	 *Devuelvo un conjunto de datos de nodo de seguimiento de manera recursiva a utilizarse con el metodo anterior para la extraccion jerarquica de los nodos de historial de un tramite.  
	 * @param inCgg_crseg_codigo Codigo de seguimiento padre.
	 * @param inConnection Conexion de datos abierta.
	 * @return Coleccion de nodos de seguimiento recursivo.
	 */
	private ArrayList<NodoTramite> selectHistorialTramiteRecursivo(String inCgg_crseg_codigo,Connection inConnection){
		ArrayList<NodoTramite> colNodoSeguimiento = new ArrayList<NodoTramite>();
		ArrayList<Cgg_res_seguimiento> colSeguimientoHijo = new ArrayList<Cgg_res_seguimiento>();
		NodoTramite objNodoSeguimiento = null;

		Cgg_res_seguimiento objSeguimientoPadre = new Cgg_res_seguimiento();
		objSeguimientoPadre.setCGG_CRSEG_CODIGO(inCgg_crseg_codigo);

		colSeguimientoHijo = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimientoPadre).selectCGG_RES_SEGUIMIENTO(inConnection);
		for(Iterator<Cgg_res_seguimiento> iSeguimientoHijo = colSeguimientoHijo.iterator();iSeguimientoHijo.hasNext();){			
			String tmpTipoAtencion = "";
			Cgg_res_seguimiento objTmpSeguimiento =iSeguimientoHijo.next(); 												
			objNodoSeguimiento = new NodoTramite();
			objNodoSeguimiento.setId(objTmpSeguimiento.getCRSEG_CODIGO());

			Cgg_res_fase objFase = new Cgg_res_fase();
			objFase.setCRFAS_CODIGO(objTmpSeguimiento.getCRFAS_CODIGO());										
			objFase=new com.besixplus.sii.db.Cgg_res_fase(objFase).select(inConnection);

			Cgg_usuario objUsuario = new Cgg_usuario();
			objUsuario.setCUSU_CODIGO(objTmpSeguimiento.getCUSU_CODIGO());			
			objUsuario = new com.besixplus.sii.db.Cgg_usuario(objUsuario).select(inConnection);

			/*for(TIPORESPUESTA objTipoRespuesta : CGGEnumerators.TIPORESPUESTA.values()){
				if(objTmpSeguimiento.getCRSEG_TIPO_RESPUESTA() == objTipoRespuesta.getValue()){
					tmpTipoRespusta = objTipoRespuesta.toString();
				}
			}*/

			for(ESTADOATENCION objEstadoAtencion : CGGEnumerators.ESTADOATENCION.values()){
				if(objTmpSeguimiento.getCRSEG_ESTADO_ATENCION() == objEstadoAtencion.getValue()){
					tmpTipoAtencion = objEstadoAtencion.toString();
				}
			}

			objNodoSeguimiento.setName(objFase.getCRFAS_NOMBRE().toUpperCase()+"("+objUsuario.getCUSU_NOMBRE_USUARIO()+")<br>"+tmpTipoAtencion);					
			objNodoSeguimiento.setData(objTmpSeguimiento);

			ArrayList<NodoTramite> objNodoHijo = selectHistorialTramiteRecursivo(objTmpSeguimiento.getCRSEG_CODIGO(), inConnection);
			objNodoSeguimiento.setChildren(objNodoHijo);

			colNodoSeguimiento.add(objNodoSeguimiento);
		}						
		return colNodoSeguimiento;		
	}

	/**
	 * Seleciona todos los tramites deacuerdo a un estado e isla especificado.
	 * En caso de no establecerse la isla se selecciona todos los tramites para un estado en particular.
	 * @param start Inicio de la consulta.
	 * @param limit Limite de la consulta.
	 * @param sort Ordenaminto de la consulta.
	 * @param dir Direccion del ordenamiento de la consulta.
	 * @param keyword Palabra clave de busqueda en la consulta.
	 * @param inCisla_codigo Codigo de isla.
	 * @param inCrett_codigo Codigo de tipo de estado de tramite.
	 * @param format Cadena de formato de salida JSON / XMl.
	 * @return Cadena de datos en formto establecido.
	 */
	@WebMethod
	public String selectPageEstadoIsla(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name="inCrett_codigo")String inCrett_codigo,
			@WebParam(name="format")String format
			){
		//		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();			
			//			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
			//				con.close();
			//				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
			//				return null;
			//			}			
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_res_tramite.selectPageEstadoIsla(con, start, limit, sort, dir, keyword,inCisla_codigo,inCrett_codigo);
			tmpCount = new com.besixplus.sii.db.Cgg_res_tramite().selectPageEstadoIslaCount(con, keyword,inCisla_codigo,inCrett_codigo); 
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}


	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_tramite.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE.
	 * @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO. CAMPO RECURSIVO HACIA LA MISMA TABLA DE PERSONA.
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD.
	 * @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA.
	 * @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR.
	 * @param inCrtra_observacion OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON.
	 * @param inCgg_cvveh_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO
	 * @param inCgg_cvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	VALORES:
	0-NO EVALUADO
	1-EVALUADO
	2-CADUCADO
	3-SOLO GUARDADO
	4-FINALIZADO
	5-OTRO TIPO DE ESTADO.
	 * @param inCrtra_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE.
	 * @param inNuevoBeneficiarioJSON NUEVO BENEFICIARIO
	 * @param inContactoPersonaJSON CONTACTOS DE LA PERSONA
	 * @param inInfoVehiculos INFORMACION VEHICULOS
	 * @param inBeneficiarios_JSON ARREGLO DE BENEFICIARIOS
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String registrarTramiteTranseunteLite(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCgg_crper_codigo")String inCgg_crper_codigo,
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name ="inCrtt_codigo")String inCrtt_codigo,
			@WebParam(name="inCrtra_observacion")String inCrtra_observacion,
			@WebParam(name="inCvveh_codigo")String inCvveh_codigo,
			@WebParam(name="inCvmtr_codigo")String inCvmtr_codigo,
			@WebParam(name="inCgg_cvveh_codigo")String inCgg_cvveh_codigo,
			@WebParam(name="inCgg_cvmtr_codigo")String inCgg_cvmtr_codigo,
			@WebParam(name="inCrtra_atencion_cliente")boolean inCrtra_atencion_cliente,
			@WebParam(name="inNuevoBeneficiarioJSON")String inNuevoBeneficiarioJSON,
			@WebParam(name="inContactoPersonaJSON")String inContactoPersonaJSON,
			@WebParam(name="inInfoVehiculos")String inInfoVehiculos,
			@WebParam(name="inBeneficiarios_JSON")String inBeneficiarios_JSON,
			@WebParam(name="inCrtra_fecha_ingreso")String inCrtra_fecha_ingreso,
			@WebParam(name="inCrtra_fecha_salida")String inCrtra_fecha_salida,
			@WebParam(name="inCrtra_actividad_residencia")String inCrtra_actividad_residencia

	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		String outResult = null;

		com.besixplus.sii.objects.Cgg_res_tramite objTramite = new com.besixplus.sii.objects.Cgg_res_tramite();
		objTramite.setCRTRA_CODIGO("KEYGEN");
		objTramite.setCRTRA_FOLIO(BigDecimal.ZERO);
		objTramite.setCRPER_CODIGO(inCrper_codigo);
		objTramite.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		objTramite.setCRTST_CODIGO(inCrtst_codigo);
		objTramite.setCVVEH_CODIGO(inCvveh_codigo);
		objTramite.setCGG_CVVEH_CODIGO(inCgg_cvveh_codigo);
		objTramite.setCGG_CVMTR_CODIGO(inCgg_cvmtr_codigo);
		objTramite.setCISLA_CODIGO(inCisla_codigo);
		objTramite.setCVMTR_CODIGO(inCvmtr_codigo);
		objTramite.setCRTRA_ANIO(new BigDecimal(Calendar.getInstance().get(Calendar.YEAR)));
		objTramite.setCRTRA_NUMERO(new BigDecimal(0));
		objTramite.setCRTRA_FECHA_RECEPCION(new Date());
		objTramite.setCRTRA_OBSERVACION(inCrtra_observacion);
		objTramite.setCRTRA_ATENCION_CLIENTE(inCrtra_atencion_cliente);
		objTramite.setCRTRA_ESTADO(true);
		objTramite.setCRTRA_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		objTramite.setCRTRA_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		try {
			objTramite.setCRTRA_FECHA_INGRESO(sdf.parse(inCrtra_fecha_ingreso));
			objTramite.setCRTRA_FECHA_SALIDA(sdf.parse(inCrtra_fecha_salida));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		objTramite.setCRTRA_ACTIVIDAD_RESIDENCIA(inCrtra_actividad_residencia);

		outResult = new Cgg_res_tramite().registrarTramiteTranseunte(
				true,
				objTramite.getCRPER_CODIGO(),
				objTramite.getCRPJR_CODIGO(),
				objTramite.getCGG_CRPER_CODIGO(),
				objTramite.getCRPRO_CODIGO(),
				objTramite.getCRTST_CODIGO(),
				objTramite.getCVVEH_CODIGO(),
				objTramite.getCISLA_CODIGO(),
				objTramite.getCVMTR_CODIGO(),
				objTramite.getCGG_CVMTR_CODIGO(),
				objTramite.getCGG_CVVEH_CODIGO(),
				objTramite.getCRTRA_ACTIVIDAD_RESIDENCIA(),
				objTramite.getCRTRA_OBSERVACION(),
				objTramite.getCRTRA_DIAS_PERMANENCIA(),
				objTramite.getCRTRA_ATENCION_CLIENTE(),
				objTramite.getCRTRA_COMUNICADO_RADIAL(),
				objTramite.getCRTRA_MOTIVO(),
				objTramite.getCRTRA_FOLIO(),
				objTramite.getCRTRA_FECHA_INGRESO(),
				objTramite.getCRTRA_FECHA_SALIDA(),
				inBeneficiarios_JSON,
				null,
				null,
				null,
				tmpRequest,
				tmpResponse);

		return outResult;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_tramite.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE.
	 * @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO. CAMPO RECURSIVO HACIA LA MISMA TABLA DE PERSONA.
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD.
	 * @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA.
	 * @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR.
	 * @param inCrtra_observacion OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON.
	 * @param inCgg_cvveh_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO
	 * @param inCgg_cvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
VALORES:
0-NO EVALUADO
1-EVALUADO
2-CADUCADO
3-SOLO GUARDADO
4-FINALIZADO
5-OTRO TIPO DE ESTADO.
	 * @param inCrtra_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE.
	 * @param inNuevoBeneficiarioJSON NUEVO BENEFICIARIO
	 * @param inContactoPersonaJSON CONTACTOS DE LA PERSONA
	 * @param inInfoVehiculos INFORMACION VEHICULOS
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String registrarTramiteLite(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCgg_crper_codigo")String inCgg_crper_codigo,
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name ="inCrtt_codigo")String inCrtt_codigo,
			@WebParam(name="inCrtra_observacion")String inCrtra_observacion,
			@WebParam(name="inCvveh_codigo")String inCvveh_codigo,
			@WebParam(name="inCvmtr_codigo")String inCvmtr_codigo,
			@WebParam(name="inCgg_cvveh_codigo")String inCgg_cvveh_codigo,
			@WebParam(name="inCgg_cvmtr_codigo")String inCgg_cvmtr_codigo,
			@WebParam(name="inCrtra_atencion_cliente")boolean inCrtra_atencion_cliente,
			@WebParam(name="inNuevoBeneficiarioJSON")String inNuevoBeneficiarioJSON,
			@WebParam(name="inContactoPersonaJSON")String inContactoPersonaJSON,
			@WebParam(name="inInfoVehiculos")String inInfoVehiculos,
			@WebParam(name="inCrtra_fecha_ingreso")String inCrtra_fecha_ingreso,
			@WebParam(name="inCrtra_fecha_salida")String inCrtra_fecha_salida

			){
		String [] res = new String[2];	
		String flagRes = "true";
		JSONObject objTmpPersona;
		Cgg_res_persona objTmpBeneficiario;
		Cgg_res_persona objNuevoBeneficiario;
		String resultado;
		String cggCrperCodigo;
		String tmpMsg;
		String resContacto = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_tramite obj = new com.besixplus.sii.objects.Cgg_res_tramite();
		obj.setCRTRA_CODIGO("KEYGEN");
		obj.setCRTRA_FOLIO(BigDecimal.ZERO);
		obj.setCRPER_CODIGO(inCrper_codigo);
		//	obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		//	obj.setCRPRO_CODIGO(inCrpro_codigo);
		obj.setCRTST_CODIGO(inCrtst_codigo);
		obj.setCVVEH_CODIGO(inCvveh_codigo);
		obj.setCGG_CVVEH_CODIGO(inCgg_cvveh_codigo);
		obj.setCGG_CVMTR_CODIGO(inCgg_cvmtr_codigo);
		//	obj.setCRETT_CODIGO(inCrett_codigo);
		obj.setCISLA_CODIGO(inCisla_codigo);
		//	obj.setCRDPT_CODIGO(inCrdpt_codigo);
		obj.setCVMTR_CODIGO(inCvmtr_codigo);
		obj.setCRTRA_ANIO(new BigDecimal(Calendar.getInstance().get(Calendar.YEAR)));
		obj.setCRTRA_NUMERO(new BigDecimal(0));
		obj.setCRTRA_FECHA_RECEPCION(new Date());
		//	obj.setCRTRA_ACTIVIDAD_RESIDENCIA(inCrtra_actividad_residencia);
		obj.setCRTRA_OBSERVACION(inCrtra_observacion);
		//	obj.setCRTRA_DIAS_PERMANENCIA(inCrtra_dias_permanencia);
		//	obj.setCRTRA_PENDIENTE(inCrtra_pendiente);
		//	obj.setCRTRA_OBSERVACION_PENDIENTE(inCrtra_observacion_pendiente);
		obj.setCRTRA_ATENCION_CLIENTE(inCrtra_atencion_cliente);
		//	obj.setCRTRA_COMUNICADO_RADIAL(inCrtra_comunicado_radial);
		//	obj.setCRTRA_MOTIVO(inCrtra_motivo);
		//	obj.setCRTRA_FOLIO(inCrtra_folio);
		//	obj.setCRTRA_GRUPO(inCrtra_grupo);
		//	obj.setCRTRA_ORDEN(inCrtra_orden);
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			if(inCrtra_fecha_ingreso!=null && inCrtra_fecha_ingreso.trim().length()>0)
				obj.setCRTRA_FECHA_INGRESO(sdf.parse(inCrtra_fecha_ingreso));
			if(inCrtra_fecha_salida!=null && inCrtra_fecha_salida.trim().length()>0)
				obj.setCRTRA_FECHA_SALIDA(sdf.parse(inCrtra_fecha_salida));
		} catch (ParseException e){
			e.printStackTrace();
		}
		obj.setCRTRA_ESTADO(true);
		obj.setCRTRA_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRTRA_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			//CONSULTA DEL TIPO DE PROCESO PARA EL TIPO DE SOLICITUD DE TRAMITE
			com.besixplus.sii.objects.Cgg_res_proceso objProceso = new Cgg_res_proceso();
			objProceso = new com.besixplus.sii.db.Cgg_res_proceso(objProceso).selectByTipoSolicitudTramite(con, inCrtst_codigo);

			//CONSULTA DEL ESTADO POR DEFECTO PARA UN TRAMITE
			com.besixplus.sii.objects.Cgg_configuracion tmpConf = new com.besixplus.sii.objects.Cgg_configuracion();
			tmpConf.setCGCNF_CODIGO("22");

			tmpConf = new com.besixplus.sii.db.Cgg_configuracion(tmpConf).select(con);
			obj.setCRPRO_CODIGO(objProceso.getCRPRO_CODIGO());
			obj.setCRETT_CODIGO(tmpConf.getCGCNF_VALOR_CADENA());


			if(inNuevoBeneficiarioJSON != null && inNuevoBeneficiarioJSON.trim().length()>=1){
				//REGISTRO DEL BENEFICIARIO					
				objTmpPersona = new JSONObject(inNuevoBeneficiarioJSON);
				objTmpBeneficiario = new Cgg_res_persona();			
				objTmpBeneficiario.setCRPER_NUM_DOC_IDENTIFIC(objTmpPersona.getString("CRPER_NUM_DOC_IDENTIFIC"));				
				objTmpBeneficiario = new com.besixplus.sii.db.Cgg_res_persona(objTmpBeneficiario).selectNumDoc(con);
				if(objTmpBeneficiario.getCRPER_CODIGO()!=null && objTmpBeneficiario.getCRPER_CODIGO().trim().length()>=1){										
					cggCrperCodigo = "true";
					objNuevoBeneficiario = new Cgg_res_persona();
					objNuevoBeneficiario.setCRPER_CODIGO(objTmpBeneficiario.getCRPER_CODIGO());
					//Si queremos hacer update, debe ser aqui.
					//Aplica ahora porque la Dinardap corrige los datos. Comparamos para no matarle a la base cada vez que entra.
					if(!objTmpBeneficiario.getCRPER_APELLIDO_PATERNO().equals(objTmpPersona.getString("CRPER_APELLIDO_PATERNO")) ||
							!objTmpBeneficiario.getCRPER_APELLIDO_MATERNO().equals(objTmpPersona.getString("CRPER_APELLIDO_MATERNO")) ||
							!objTmpBeneficiario.getCRPER_NOMBRES().equals(objTmpPersona.getString("CRPER_NOMBRES"))) {
						objNuevoBeneficiario.setCRDID_CODIGO(objTmpPersona.getString("CRDID_CODIGO"));
						objNuevoBeneficiario.setCRPER_NOMBRES(objTmpPersona.getString("CRPER_NOMBRES"));
						objNuevoBeneficiario.setCRPER_APELLIDO_PATERNO(objTmpPersona.getString("CRPER_APELLIDO_PATERNO"));
						objNuevoBeneficiario.setCRPER_APELLIDO_MATERNO(objTmpPersona.getString("CRPER_APELLIDO_MATERNO"));
						objNuevoBeneficiario.setCRPER_NUM_DOC_IDENTIFIC(objTmpPersona.getString("CRPER_NUM_DOC_IDENTIFIC"));
						objNuevoBeneficiario.setCPAIS_CODIGO(objTmpPersona.getString("CPAIS_CODIGO"));
						objNuevoBeneficiario.setCGG_CPAIS_CODIGO(objTmpPersona.getString("CGG_CPAIS_CODIGO"));
						objNuevoBeneficiario.setCRPER_GENERO(objTmpPersona.getInt("CRPER_GENERO"));
						objNuevoBeneficiario.setCRPER_ATENCION_CLIENTE(inCrtra_atencion_cliente);

						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaNacimiento = null;
						try {
							fechaNacimiento = df.parse(objTmpPersona.getString("CRPER_FECHA_NACIMIENTO"));
						} catch (ParseException e) {
							e.printStackTrace();
							fechaNacimiento = new Date();
						}
						objNuevoBeneficiario.setCRPER_FECHA_NACIMIENTO(fechaNacimiento);
						objNuevoBeneficiario.setCRPER_ESTADO(true);
						objNuevoBeneficiario.setCRPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						cggCrperCodigo = new com.besixplus.sii.db.Cgg_res_persona(objNuevoBeneficiario).update(con);
					}
				}else{
					objNuevoBeneficiario = new Cgg_res_persona();
					objNuevoBeneficiario.setCRPER_CODIGO("KEYGEN");
					//objNuevoBeneficiario.setCRECV_CODIGO(objTmpPersona.getString("CRECV_CODIGO"));
					objNuevoBeneficiario.setCRDID_CODIGO(objTmpPersona.getString("CRDID_CODIGO"));
					objNuevoBeneficiario.setCRPER_NOMBRES(objTmpPersona.getString("CRPER_NOMBRES"));
					objNuevoBeneficiario.setCRPER_APELLIDO_PATERNO(objTmpPersona.getString("CRPER_APELLIDO_PATERNO"));
					objNuevoBeneficiario.setCRPER_APELLIDO_MATERNO(objTmpPersona.getString("CRPER_APELLIDO_MATERNO"));
					objNuevoBeneficiario.setCRPER_NUM_DOC_IDENTIFIC(objTmpPersona.getString("CRPER_NUM_DOC_IDENTIFIC"));
					objNuevoBeneficiario.setCPAIS_CODIGO(objTmpPersona.getString("CPAIS_CODIGO"));
					objNuevoBeneficiario.setCGG_CPAIS_CODIGO(objTmpPersona.getString("CGG_CPAIS_CODIGO"));
					objNuevoBeneficiario.setCRPER_GENERO(objTmpPersona.getInt("CRPER_GENERO"));
					objNuevoBeneficiario.setCRPER_ATENCION_CLIENTE(inCrtra_atencion_cliente);

					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					Date fechaNacimiento = null;
					try{
						fechaNacimiento = df.parse(objTmpPersona.getString("CRPER_FECHA_NACIMIENTO"));
					} catch (ParseException e){
						e.printStackTrace();
						fechaNacimiento = new Date();
					}
					objNuevoBeneficiario.setCRPER_FECHA_NACIMIENTO( fechaNacimiento );
					objNuevoBeneficiario.setCRPER_ESTADO(true);
					objNuevoBeneficiario.setCRPER_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objNuevoBeneficiario.setCRPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					cggCrperCodigo = new com.besixplus.sii.db.Cgg_res_persona(objNuevoBeneficiario).insert(con);
				}

			}else{
				cggCrperCodigo = "true";
				objNuevoBeneficiario = new Cgg_res_persona();
				objNuevoBeneficiario.setCRPER_CODIGO(inCgg_crper_codigo);			
			}
			if (cggCrperCodigo.equals("true"))
			{
				//////////////////////////////INGRESO DE VEHICULOS O MOTORES//////////////////////////////
				if(inInfoVehiculos != null && !inInfoVehiculos.trim().isEmpty()){
					tmpMsg = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR INFORMACION DE VEHICULO DEL TRAMITE.";
					JSONObject tmpObject = new JSONObject(inInfoVehiculos);
					///////////////NUEVO//////////////////
					if(tmpObject.getInt("ACCION") == 0){
						Cgg_veh_motor tmpMotor = new Cgg_veh_motor();
						Cgg_veh_vehiculo_motor tmpVehMotor = new Cgg_veh_vehiculo_motor();

						tmpMotor.setCVMTR_CODIGO("KEYGEN");
						tmpMotor.setCVMTR_ANIO_FABRICACION(tmpObject.getInt("FABRICACION"));
						tmpMotor.setCVCMB_CODIGO(tmpObject.getString("CVCMB_CODIGO"));
						tmpMotor.setCVCLN_CODIGO(tmpObject.getString("CVCLN_CODIGO"));
						tmpMotor.setCVMTR_TONELAJE(tmpObject.getInt("CVMTR_TONELAJE"));
						tmpMotor.setCVMTR_ESTADO(true);
						tmpMotor.setCVMTR_ESTADO_FUNCIONAL(true);
						tmpMotor.setCVMTR_SERIE("S/N");
						tmpMotor.setCVMTR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						tmpMotor.setCVMTR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						cggCrperCodigo = new com.besixplus.sii.db.Cgg_veh_motor(tmpMotor).insert(con);

						////////////////////////////////////VEHICULO///////////////////////////////////////
						if(tmpObject.getInt("TIPO") == CGGEnumerators.TipoVehiculoTramite.Vehiculo.getValue() ){
							Cgg_veh_vehiculo tmpVehiculo = new Cgg_veh_vehiculo();
							tmpVehiculo.setCVVEH_CODIGO("KEYGEN");
							tmpVehiculo.setCVCTG_CODIGO(tmpObject.getString("CVCTG_CODIGO"));
							tmpVehiculo.setCVSCT_CODIGO(tmpObject.getString("CVSCT_CODIGO"));
							tmpVehiculo.setCSCTP_CODIGO(tmpObject.getString("CSCTP_CODIGO"));
							tmpVehiculo.setCVVEH_TIPO(tmpObject.getInt("VEHICULO"));
							tmpVehiculo.setCVVEH_ANIO_PRODUCCION(tmpObject.getInt("FABRICACION"));
							tmpVehiculo.setCVVEH_PLACA("S/P");
							tmpVehiculo.setCVVEH_NOMBRE("S/N");
							tmpVehiculo.setCVVEH_ESTADO(true);
							tmpVehiculo.setCVVEH_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							tmpVehiculo.setCVVEH_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							cggCrperCodigo = new com.besixplus.sii.db.Cgg_veh_vehiculo(tmpVehiculo).insert(con);

							tmpVehMotor.setCVVEH_CODIGO(tmpVehiculo.getCVVEH_CODIGO());
							obj.setCVVEH_CODIGO(tmpVehiculo.getCVVEH_CODIGO());
							obj.setCVMTR_CODIGO(null);
							tmpVehMotor.setCVVMT_FECHA(new Date());
						}else if(tmpObject.getInt("TIPO") == CGGEnumerators.TipoVehiculoTramite.Motor.getValue()){
							tmpVehMotor.setCVVEH_CODIGO(obj.getCVVEH_CODIGO());
							obj.setCVMTR_CODIGO(tmpMotor.getCVMTR_CODIGO());
							tmpVehMotor.setCVVMT_FECHA(null);
						}
						if(cggCrperCodigo.equals("true")){						
							tmpVehMotor.setCVVMT_CODIGO("KEYGEN");
							tmpVehMotor.setCVMTR_CODIGO(tmpMotor.getCVMTR_CODIGO());
							tmpVehMotor.setCVVMT_ESTADO(true);
							tmpVehMotor.setCVVMT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							tmpVehMotor.setCVVMT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							cggCrperCodigo = new com.besixplus.sii.db.Cgg_veh_vehiculo_motor(tmpVehMotor).insert(con);
						}
					}else{
						if(tmpObject.getInt("TIPO") == CGGEnumerators.TipoVehiculoTramite.Vehiculo.getValue()){
							if(obj.getCVVEH_CODIGO().equals("KEYGEN")){
								cggCrperCodigo = "false";
								tmpMsg = myErrorMessages.getMessage("sii.tramite.vehiculo.existente", null);
							}else
								obj.setCVMTR_CODIGO(null);
						}else if(tmpObject.getInt("TIPO") == CGGEnumerators.TipoVehiculoTramite.Motor.getValue() &&
								obj.getCVMTR_CODIGO().equals("KEYGEN")){
							cggCrperCodigo = "false";
							tmpMsg = myErrorMessages.getMessage("sii.tramite.motor.existente", null);
						}	
					}

				}/*else{
					obj.setCVVEH_CODIGO(null);
					obj.setCVMTR_CODIGO(null);
				}*/
				//////////////////////////////////////////////////////////////////////////////////////////
				if (cggCrperCodigo.equals("true"))
				{
					org.json.JSONArray objContactoJSON = new org.json.JSONArray(inContactoPersonaJSON);
					com.besixplus.sii.objects.Cgg_res_persona_contacto objPersonaContacto = new com.besixplus.sii.objects.Cgg_res_persona_contacto();
					objPersonaContacto.setCRPER_CODIGO(obj.getCRPER_CODIGO());
					Boolean tmpResult = false;					
					tmpResult = new com.besixplus.sii.db.Cgg_res_persona_contacto(objPersonaContacto).deleteCGG_RES_PERSONA(con);
					for (int i = 0 ; i < objContactoJSON.length(); i++){			
						objPersonaContacto = new com.besixplus.sii.objects.Cgg_res_persona_contacto();
						objPersonaContacto.setCRPRC_CODIGO("KEYGEN");
						objPersonaContacto.setCRPER_CODIGO(obj.getCRPER_CODIGO());
						objPersonaContacto.setCRTCO_CODIGO(((org.json.JSONObject)objContactoJSON.get(i)).get("CRTCO_CODIGO").toString());
						objPersonaContacto.setCRPRC_DESCRIPCION(((org.json.JSONObject)objContactoJSON.get(i)).get("CRPRC_DESCRIPCION").toString());
						objPersonaContacto.setCRPRC_CONTACTO(((org.json.JSONObject)objContactoJSON.get(i)).get("CRPRC_CONTACTO").toString());
						objPersonaContacto.setCRPRC_ESTADO(true);
						objPersonaContacto.setCRPRC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objPersonaContacto.setCRPRC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						resContacto = new com.besixplus.sii.db.Cgg_res_persona_contacto(objPersonaContacto).insert(con);
					}
					if (resContacto.equals("true"))
					{
						obj.setCGG_CRPER_CODIGO(objNuevoBeneficiario.getCRPER_CODIGO());
						res = new com.besixplus.sii.db.Cgg_res_tramite(obj).insert1(con);
					}
					else
					{
						flagRes = "false";
					}

				}
				else
				{
					flagRes = "false";
				}
			}
			else
			{
				flagRes = "false";
			}
			if(!flagRes.equals("true"))
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, flagRes);
			else
			{
				con.commit();
				con.setAutoCommit(true);
			}
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}

		try {
			resultado =new JSONArray(res).toString();
		} catch (JSONException e) {
			e.printStackTrace();
			resultado = "false";
		}
		return resultado;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_tramite EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inCrtra_codigo CODIGO DEL TRAMITE A CONSULTAR
	 * @param format FORMATO DE SALIDA ESPERADO
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectTramiteSeguimientoStatus(
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="format")String format
			){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_res_tramite.selectTramiteSeguimientoStatus(con, inCrtra_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return outCadena.toString();
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}

	/**
	 * Anula un tramite. El tramite es marcado con estado anulado, cerrado en la fase en la que se encuentre con una sumilla. Se controla estado como que el tramite no este anulado o finalizado.
	 * @param inCrtra_codigo Codigo de tramite.
	 * @param inCrtra_observacion Observacion para el tramite.
	 * @return Estructura de datos JSON de ServerResponse.
	 */	
	@WebMethod
	public String anularTramite(
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="inCrtra_observacion")String inCrtra_observacion
			){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);	

		ServerResponse responser = new ServerResponse(false,"Inicio de proceso","");
		Cgg_configuracion confTramiteAnulado = new Cgg_configuracion();
		Cgg_configuracion confTramiteFinalizado = new Cgg_configuracion();
		String flagTramite = "false";
		String flagSeguimiento = "true";
		Cgg_res_seguimiento seguimiento  = new Cgg_res_seguimiento();
		Cgg_res_seguimiento tmpSeguimiento = null;
		ArrayList<Cgg_res_seguimiento> seguimientos = new ArrayList<Cgg_res_seguimiento>();
		String userName = "klascano";//tmpRequest.getUserPrincipal().getName();

		com.besixplus.sii.objects.Cgg_res_tramite tramite = new com.besixplus.sii.objects.Cgg_res_tramite();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);

			confTramiteAnulado.setCGCNF_CODIGO("19");//TRAMITE ANULADO
			confTramiteAnulado = new com.besixplus.sii.db.Cgg_configuracion(confTramiteAnulado).select(con);

			confTramiteFinalizado.setCGCNF_CODIGO("20");//TRAMITE FINALIZADO
			confTramiteFinalizado = new com.besixplus.sii.db.Cgg_configuracion(confTramiteFinalizado).select(con);

			tramite.setCRTRA_CODIGO(inCrtra_codigo);
			tramite = new com.besixplus.sii.db.Cgg_res_tramite(tramite).select(con);

			//TODO:eliminar la relacion con tramite garantia para soltar las garantias a la anulacion.

			if(tramite.getCRTRA_CODIGO() != null && 
					tramite.getCRTRA_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
					tramite.getCRTRA_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

				if(tramite.getCRETT_CODIGO().equalsIgnoreCase(confTramiteAnulado.getCGCNF_VALOR_CADENA())==true ){
					responser.setSuccess(false);
					responser.setMsg("El tramite ya fue anulado previamente.");
				}else if(tramite.getCRETT_CODIGO().equalsIgnoreCase(confTramiteFinalizado.getCGCNF_VALOR_CADENA())==true){
					responser.setSuccess(false);
					responser.setMsg("El tramite ya fue finalizado previamente.");
				}else{
					//CAMBIO DE ESTADO DE TRAMITE A ANULADO.
					tramite.setCRETT_CODIGO(confTramiteAnulado.getCGCNF_VALOR_CADENA());
					tramite.setCRTRA_PENDIENTE(ESTADOPENDIENTETRAMITE.ANULADO.getValue());
					tramite.setCRTRA_OBSERVACION(tramite.getCRTRA_OBSERVACION()+"("+inCrtra_observacion+").");
					tramite.setCRTRA_USUARIO_UPDATE(userName);				

					flagTramite = new com.besixplus.sii.db.Cgg_res_tramite(tramite).update(con);
					if(flagTramite.equalsIgnoreCase("true")==true){

						seguimiento.setCRTRA_CODIGO(tramite.getCRTRA_CODIGO());
						seguimientos = new com.besixplus.sii.db.Cgg_res_seguimiento(seguimiento).selectCGG_RES_TRAMITE(con);

						for(Iterator<Cgg_res_seguimiento> iSeguimiento = seguimientos.iterator();iSeguimiento.hasNext();){
							tmpSeguimiento = iSeguimiento.next();
							if(tmpSeguimiento.getCRSEG_ESTADO_ATENCION() != ESTADOATENCION.DESPACHADO.getValue() 
									&& tmpSeguimiento.getCRSEG_ESTADO_ATENCION() != ESTADOATENCION.FINALIZADO.getValue()){								

								tmpSeguimiento.setCRSEG_ESTADO_ATENCION(ESTADOATENCION.INHABILITADO.getValue());
								tmpSeguimiento.setCRSEG_USUARIO_UPDATE(userName);
								flagSeguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(tmpSeguimiento).update(con);

								if(flagSeguimiento.equalsIgnoreCase("true")==true){
									Cgg_res_novedad_notificacion notificacion = new Cgg_res_novedad_notificacion();

									notificacion.setCRNOV_CODIGO("KEYGEN");
									notificacion.setCRSEG_CODIGO(seguimiento.getCRSEG_CODIGO());																					
									notificacion.setCRNOV_DESCRIPCION("El tramite fue anulado el "+new SimpleDateFormat("dd/MM/yyyy hh:mm").format(new Date())+" por "+userName);
									notificacion.setCRNOV_TIPO(TIPONOVEDAD.COMENTARIO.getValue());
									notificacion.setCRNOV_FECHA_REGISTRO(new Date());
									notificacion.setCRNOV_ESTADO(true);
									notificacion.setCRNOV_USUARIO_INSERT(userName);
									notificacion.setCRNOV_USUARIO_UPDATE(userName);								
									new com.besixplus.sii.db.Cgg_res_novedad_notificacion(notificacion).insert(con);
								}else{
									break;
								}
							}						
						}

						if(flagSeguimiento.equalsIgnoreCase("true")==true){
							con.commit();
							responser.setSuccess(true);
							responser.setMsg("El tramite fue anulado");
						}else{
							con.rollback();
							responser.setSuccess(true);
							responser.setMsg("No se actualizo el estado de los seguimientos del tramite");
						}
					}else{
						con.rollback();
						responser.setSuccess(false);
						responser.setMsg("Tramite no fue actualizado");
					}	
				}
			}else{
				con.rollback();
				responser.setSuccess(false);
				responser.setMsg("Tramite no existe o este ya fue previamente anulado.");
			}					
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);			
			responser.setSuccess(false);
			responser.setMsg(inException.getMessage());			
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			responser.setSuccess(false);
			responser.setMsg(inException.getMessage());
		}		
		return new JSONObject(responser).toString();
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_tramite EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectTramiteByCode(
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="format")String format
			){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();			
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}			
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_res_tramite.selectTramiteByCode(con, inCrtra_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return outCadena.toString();
			else
				return outCadena.toString();
		return null;
	}

	/**
	 * Establece la fecha de entrada de una persona. Este metodo se utiliza en el caso de establecer previa a la aprobacion de una residencia temporal una residencia como transeunte.
	 * La residencia de tipo transeunte finaliza una vez que el comite da por aprobado su residencia temporal.
	 * @param inCrtra_codigo Codigo de tramite.
	 * @param inCrtra_fecha_ingreso Fecha de ingreso de la persona.
	 * @param inCrett_codigo Codigo de estado de tramite valido para la creacion del transeunte.
	 * @return Objecto con informacion del pedido.
	 * @throws SOAPException
	 */
	@WebMethod
	public String establecerFechaEntradaTranseunte(
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,			
			@WebParam(name="inCrtra_fecha_ingreso")java.util.Date inCrtra_fecha_ingreso,
			@WebParam(name="inCrett_codigo")String inCrett_codigo
			) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tramite obj = new com.besixplus.sii.objects.Cgg_res_tramite();
		ServerResponse appResponser = new ServerResponse(false, "", null);

		obj.setCRTRA_CODIGO(inCrtra_codigo);				
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			obj = new com.besixplus.sii.db.Cgg_res_tramite(obj).select(con);
			if(obj.getCRTRA_CODIGO()!=null 
					&& obj.getCRTRA_CODIGO().trim().length()>=LONGITUDCLAVEPRIMARIA.MINIMO.getValue()
					&& obj.getCRTRA_CODIGO().trim().length()<=LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

				obj.setCRTRA_FECHA_INGRESO(inCrtra_fecha_ingreso);
				obj.setCRTRA_MOTIVO(inCrett_codigo);
				obj.setCRTRA_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());																
				res = new com.besixplus.sii.db.Cgg_res_tramite(obj).update(con);						
				if(res.equalsIgnoreCase("true")==false){
					throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				}else{
					con.commit();
					con.setAutoCommit(true);					
					appResponser.setSuccess(true);
					appResponser.setMsg(obj.getCRTRA_CODIGO());
					appResponser.setObjData(obj);
				}			
			}else{
				appResponser.setSuccess(false);
				appResponser.setMsg("TRAMITE NO VALIDO");
			}				
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new JSONObject(appResponser).toString();
	}

	/**
	 * Actualiza un tramite de residencia. Si el tramite no especifica informacion de garantia, seguimiento y demas, se considera al tramite como solo guardado, caso contrario se despacha.
	 * @param inCrtra_codigo Codigo de tramite.
	 * @param inCrper_codigo Codigo de persona.
	 * @param inCrpjr_codigo Codigo de persona juridica.
	 * @param inCgg_crper_codigo Codigo de beneficiario.
	 * @param inCrpro_codigo Codigo de proceso.
	 * @param inCrtst_codigo Codigo de tipo de solicitud.
	 * @param inCvveh_codigo Codigo de vehiculo.
	 * @param inCisla_codigo Codigo de isla.
	 * @param inCvmtr_codigo Codigo de motor.
	 * @param inCgg_cvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	 * @param inCgg_cvveh_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO
	 * @param inCrtra_actividad_residencia Codigo de cargo de residencia.
	 * @param inCrtra_observacion Observacion del tramite.
	 * @param inCrtra_dias_permanencia Dias de permanencia del tramite.
	 * @param inCrtra_atencion_cliente Registro desde atencion al cliente.
	 * @param inCrtra_comunicado_radial Codigo de comunicado radial.
	 * @param inCrtra_motivo Motivo del tramite.
	 * @param inCrtra_folio Numero de folios del tramite.
	 * @param inNuevoBeneficiario Cadena json con informacion del nuevo beneficiario.
	 * @param inCrfas_codigo Cadena json con informacion de la fase de despacho.
	 * @param inTramiteRequisitos Cadena json con informacion de los requisitos del tramite cumplidos.
	 * @param inCrgts_aplica 
	 * @param inAdjuntos Adjuntos del tramite. 
	 * @param inCrtra_fecha_salida Fecha de salida del beneficiario del tramite.
	 * @param inInfoVehiculos Cadena json con informacion de vehiculos.
	 * @param inTipoGarantia Objeto tipo garantia
	 * @param inRequest Objeto de sesion.
	 * @param inResponse Objeto de sesion.
	 * @return Verdadero/false/error al actualizar un tramite.
	 */
	public String actualizarTramite(
			String inCrtra_codigo,
			String inCrper_codigo,
			String inCrpjr_codigo,
			String inCgg_crper_codigo,
			String inCrpro_codigo,
			String inCrtst_codigo,
			String inCvveh_codigo,			
			String inCisla_codigo,
			String inCvmtr_codigo,
			String inCgg_cvmtr_codigo,
			String inCgg_cvveh_codigo,
			String inCrtra_actividad_residencia,
			String inCrtra_observacion,
			int inCrtra_dias_permanencia,
			boolean inCrtra_atencion_cliente,
			String inCrtra_comunicado_radial,
			String inCrtra_motivo,
			java.math.BigDecimal inCrtra_folio,
			String inNuevoBeneficiario,
			String inCrfas_codigo,
			String inTramiteRequisitos,	
			String inCrgts_aplica,
			ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> inAdjuntos,
			Date inCrtra_fecha_salida,
			String inInfoVehiculos,
			JSONObject inTipoGarantia,
			HttpServletRequest inRequest, 
			HttpServletResponse inResponse		
			){

		String resultado = null;
		String userName = "";
		String res = "";		
		String cggCrperCodigo = null;
		Cgg_res_persona objNuevoBeneficiario = null;

		JSONObject tmpFaseDespacho = null;		
		JSONArray objJsonRequerimientos = null;
		JSONArray objJsonFasesSeguimientos = null;		
		JSONObject objJsonRequerimientoTramite = null;		
		Cgg_res_requisito_tramite objRequisito = null;
		String flagRequisito = "true";
		Cgg_res_fase objFase = null;
		Cgg_res_fase objFaseDespacho = null;		
		Cgg_res_seguimiento objSeguimientoPadre = null,objSeguimientoHijo = null;
		String flagSeguimientoPadre= "true";
		String flagSeguimientoHijo = "true";
		String flagAdjuntos = "true";
		String flagAdjuntosRequisito = "true";
		Cgg_res_novedad_notificacion objNotificacionSeguimiento = null;
		Cgg_usuario objUsuarioRegistro = new Cgg_usuario();

		ArrayList<String> codigoAdjuntoRequisito = new ArrayList<String>();
		String tmpMsg = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR INFORMACION DEL BENEFICIARIO O GARANTIAS DEL TRAMITE.";
		Cgg_configuracion confTramiteRegistro  = null;		
		com.besixplus.sii.objects.Cgg_res_tramite obj = new com.besixplus.sii.objects.Cgg_res_tramite();
		userName = inRequest.getUserPrincipal().getName();
		ServerResponse responser = new ServerResponse(false,"TRAMITE NO ACTUALIZADO",null);

		obj.setCRTRA_CODIGO(inCrtra_codigo);

		try{
			Connection objConn= ManagerConnection.getConnection();	
			objConn.setAutoCommit(false);
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(objConn, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), inRequest.getUserPrincipal().getName(), 1)){
				objConn.close();
				inResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}

			obj = new com.besixplus.sii.db.Cgg_res_tramite(obj).select(objConn);

			if(obj.getCRTRA_CODIGO()!= null &&
					obj.getCRTRA_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
					obj.getCRTRA_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

				obj.setCRPER_CODIGO(inCrper_codigo);
				obj.setCRPJR_CODIGO(inCrpjr_codigo);
				obj.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
				obj.setCRPRO_CODIGO(inCrpro_codigo);
				obj.setCRTST_CODIGO(inCrtst_codigo);
				obj.setCVVEH_CODIGO(inCvveh_codigo);

				obj.setCISLA_CODIGO(inCisla_codigo);	
				obj.setCVMTR_CODIGO(inCvmtr_codigo);
				obj.setCGG_CVMTR_CODIGO(inCgg_cvmtr_codigo);
				obj.setCGG_CVVEH_CODIGO(inCgg_cvveh_codigo);

				obj.setCRTRA_FECHA_SALIDA(inCrtra_fecha_salida);

				obj.setCRTRA_ACTIVIDAD_RESIDENCIA(inCrtra_actividad_residencia);
				obj.setCRTRA_OBSERVACION(inCrtra_observacion);
				obj.setCRTRA_DIAS_PERMANENCIA(inCrtra_dias_permanencia);

				obj.setCRTRA_ATENCION_CLIENTE(inCrtra_atencion_cliente);
				obj.setCRTRA_COMUNICADO_RADIAL(inCrtra_comunicado_radial);
				obj.setCRTRA_MOTIVO(inCrtra_motivo);
				obj.setCRTRA_FOLIO(inCrtra_folio);

				try {
					objJsonFasesSeguimientos = new JSONArray(inCrfas_codigo);

					if(objJsonFasesSeguimientos.length()>=1){
						obj.setCRTRA_PENDIENTE(ESTADOPENDIENTETRAMITE.NOEVALUADO.getValue());
					}else{
						obj.setCRTRA_PENDIENTE(ESTADOPENDIENTETRAMITE.SOLOGUARDADO.getValue());
					}

				} catch (JSONException e1) {
					e1.printStackTrace();
					obj.setCRTRA_PENDIENTE(ESTADOPENDIENTETRAMITE.SOLOGUARDADO.getValue());
				}

				obj.setCRTRA_ESTADO(true);		
				obj.setCRTRA_USUARIO_UPDATE(userName);

				cggCrperCodigo = "true";
				objNuevoBeneficiario = new Cgg_res_persona();
				objNuevoBeneficiario.setCRPER_CODIGO(inCgg_crper_codigo);			

				//////////////////////////////INGRESO DE VEHICULOS O MOTORES//////////////////////////////
				if(inInfoVehiculos != null && !inInfoVehiculos.trim().isEmpty()){
					tmpMsg = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR INFORMACION DE VEHICULO DEL TRAMITE.";
					JSONObject tmpObject = new JSONObject(inInfoVehiculos);
					///////////////NUEVO//////////////////
					if(tmpObject.getInt("ACCION") == 0){
						Cgg_veh_motor tmpMotor = new Cgg_veh_motor();
						Cgg_veh_vehiculo_motor tmpVehMotor = new Cgg_veh_vehiculo_motor();

						tmpMotor.setCVMTR_CODIGO("KEYGEN");
						tmpMotor.setCVMTR_ANIO_FABRICACION(tmpObject.getInt("FABRICACION"));
						tmpMotor.setCVCMB_CODIGO(tmpObject.getString("CVCMB_CODIGO"));
						tmpMotor.setCVCLN_CODIGO(tmpObject.getString("CVCLN_CODIGO"));
						tmpMotor.setCVMTR_TONELAJE(tmpObject.getInt("CVMTR_TONELAJE"));
						tmpMotor.setCVMTR_ESTADO(true);
						tmpMotor.setCVMTR_ESTADO_FUNCIONAL(true);
						tmpMotor.setCVMTR_SERIE("S/N");
						tmpMotor.setCVMTR_USUARIO_INSERT(userName);
						tmpMotor.setCVMTR_USUARIO_UPDATE(userName);
						cggCrperCodigo = new com.besixplus.sii.db.Cgg_veh_motor(tmpMotor).insert(objConn);

						////////////////////////////////////VEHICULO///////////////////////////////////////
						if(tmpObject.getInt("TIPO") == CGGEnumerators.TipoVehiculoTramite.Vehiculo.getValue() ){
							Cgg_veh_vehiculo tmpVehiculo = new Cgg_veh_vehiculo();
							tmpVehiculo.setCVVEH_CODIGO("KEYGEN");
							tmpVehiculo.setCVCTG_CODIGO(tmpObject.getString("CVCTG_CODIGO"));
							tmpVehiculo.setCVSCT_CODIGO(tmpObject.getString("CVSCT_CODIGO"));
							tmpVehiculo.setCSCTP_CODIGO(tmpObject.getString("CSCTP_CODIGO"));
							tmpVehiculo.setCVVEH_TIPO(tmpObject.getInt("VEHICULO"));
							tmpVehiculo.setCVVEH_ANIO_PRODUCCION(tmpObject.getInt("FABRICACION"));
							tmpVehiculo.setCVVEH_PLACA("S/P");
							tmpVehiculo.setCVVEH_NOMBRE("S/N");
							tmpVehiculo.setCVVEH_ESTADO(true);
							tmpVehiculo.setCVVEH_USUARIO_INSERT(userName);
							tmpVehiculo.setCVVEH_USUARIO_UPDATE(userName);
							cggCrperCodigo = new com.besixplus.sii.db.Cgg_veh_vehiculo(tmpVehiculo).insert(objConn);


							obj.setCVVEH_CODIGO(tmpVehiculo.getCVVEH_CODIGO());
							obj.setCVMTR_CODIGO(null);

							if(cggCrperCodigo.equals("true")){						
								tmpVehMotor.setCVVMT_CODIGO("KEYGEN");
								tmpVehMotor.setCVMTR_CODIGO(tmpMotor.getCVMTR_CODIGO());
								tmpVehMotor.setCVVEH_CODIGO(tmpVehiculo.getCVVEH_CODIGO());
								tmpVehMotor.setCVVMT_FECHA(new Date());
								tmpVehMotor.setCVVMT_ESTADO(true);
								tmpVehMotor.setCVVMT_USUARIO_INSERT(userName);
								tmpVehMotor.setCVVMT_USUARIO_UPDATE(userName);
								cggCrperCodigo = new com.besixplus.sii.db.Cgg_veh_vehiculo_motor(tmpVehMotor).insert(objConn);
							}
						}else if(tmpObject.getInt("TIPO") == CGGEnumerators.TipoVehiculoTramite.Motor.getValue()){
							obj.setCVMTR_CODIGO(tmpMotor.getCVMTR_CODIGO());
						}

					}else{
						if(tmpObject.getInt("TIPO") == CGGEnumerators.TipoVehiculoTramite.Vehiculo.getValue()){
							if(obj.getCVVEH_CODIGO().equals("KEYGEN")){
								cggCrperCodigo = "false";
								tmpMsg = myErrorMessages.getMessage("sii.tramite.vehiculo.existente", null);
							}else
								obj.setCVMTR_CODIGO(null);
						}else if(tmpObject.getInt("TIPO") == CGGEnumerators.TipoVehiculoTramite.Motor.getValue() &&
								obj.getCVMTR_CODIGO().equals("KEYGEN")){
							cggCrperCodigo = "false";
							tmpMsg = myErrorMessages.getMessage("sii.tramite.motor.existente", null);
						}	
					}

				}else{
					obj.setCVVEH_CODIGO(null);
					obj.setCVMTR_CODIGO(null);
				}
				//////////////////////////////////////////////////////////////////////////////////////////
				if(inTipoGarantia!= null){
					Cgg_res_tramite_garantia tmpTramiteGarantia = new Cgg_res_tramite_garantia();
					tmpTramiteGarantia.setCRTRA_CODIGO(obj.getCRTRA_CODIGO());
					new com.besixplus.sii.db.Cgg_res_tramite_garantia(tmpTramiteGarantia).deleteCGG_RES_TRAMITE(objConn);

					tmpTramiteGarantia = new Cgg_res_tramite_garantia();
					tmpTramiteGarantia.setCRTGR_CODIGO("KEYGEN");
					tmpTramiteGarantia.setCRTRA_CODIGO(obj.getCRTRA_CODIGO());
					tmpTramiteGarantia.setCRDPT_CODIGO(inTipoGarantia.getString("CRDPT_CODIGO"));														
					tmpTramiteGarantia.setCRGRT_CODIGO(inTipoGarantia.getString("CRGRT_CODIGO"));
					tmpTramiteGarantia.setCRTGR_DEVUELTO(false);
					tmpTramiteGarantia.setCRTGR_ESTADO_ASIGNACION(0);
					tmpTramiteGarantia.setCRTGR_ESTADO(true);
					tmpTramiteGarantia.setCRTGR_USUARIO_INSERT(userName);
					tmpTramiteGarantia.setCRTGR_USUARIO_UPDATE(userName);
					cggCrperCodigo = new com.besixplus.sii.db.Cgg_res_tramite_garantia(tmpTramiteGarantia).insert(objConn);

				}
				if(cggCrperCodigo.equalsIgnoreCase("true")){

					//Consulta del estado inicial de un tramite para su registro.
					confTramiteRegistro = new Cgg_configuracion();								

					if(objJsonFasesSeguimientos.length()>=1){
						confTramiteRegistro.setCGCNF_CONFIGURACION("ESTADO TRAMITE REGISTRADO");
					}else{
						confTramiteRegistro.setCGCNF_CONFIGURACION("ESTADO TRAMITE SOLO GUARDADO");
					}				
					confTramiteRegistro= new com.besixplus.sii.db.Cgg_configuracion(confTramiteRegistro).selectCGCNF_CONFIGURACION(objConn);

					obj.setCRETT_CODIGO(confTramiteRegistro.getCGCNF_VALOR_CADENA());
					obj.setCGG_CRPER_CODIGO(objNuevoBeneficiario.getCRPER_CODIGO());

					//ACTUALIZACION DEL TRAMITE
					res = new com.besixplus.sii.db.Cgg_res_tramite(obj).update(objConn);

					if(res.equalsIgnoreCase("true")==true){									

						objJsonRequerimientos = new JSONArray(inTramiteRequisitos);							
						int i=0;

						//REGISTRO DE LOS REQUISITOS CUMPLIDOS DEL TRAMITE.
						for(i=0;i<objJsonRequerimientos.length();i++){
							objJsonRequerimientoTramite = objJsonRequerimientos.getJSONObject(i);
							objRequisito = new Cgg_res_requisito_tramite();
							objRequisito.setCRRQT_CODIGO("KEYGEN");
							objRequisito.setCRTRA_CODIGO(obj.getCRTRA_CODIGO());								
							objRequisito.setCRSRQ_CODIGO(objJsonRequerimientoTramite.getString("CRSRQ_CODIGO"));
							objRequisito.setCRRQT_CUMPLE(objJsonRequerimientoTramite.getBoolean("CRRQT_CUMPLE"));
							objRequisito.setCRRQT_OBSERVACION(objJsonRequerimientoTramite.getString("CRRQT_OBSERVACION"));
							objRequisito.setCRRQT_ESTADO(true);
							objRequisito.setCRRQT_USUARIO_INSERT(userName);
							objRequisito.setCRRQT_USUARIO_UPDATE(userName);

							flagRequisito = new com.besixplus.sii.db.Cgg_res_requisito_tramite(objRequisito).insert(objConn);
							if(flagRequisito.equalsIgnoreCase("true")==false){
								break;
							}							

							if(objJsonRequerimientoTramite.getString("CRATE_DATA")!= null && objJsonRequerimientoTramite.getString("CRATE_DATA").trim().length() > 0){
								JSONObject jsonAdjuntoTemporal = objJsonRequerimientoTramite.getJSONObject("CRATE_DATA");

								//REGISTRO DE ADJUNTO DE REQUERIMIENTOS DE TRAMITE.
								Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
								adjuntoTemporal.setCRATE_CODIGO(jsonAdjuntoTemporal.getString("CRATE_CODIGO"));
								adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(objConn);

								com.besixplus.sii.objects.Cgg_res_adjunto adjuntoRequisito = new com.besixplus.sii.objects.Cgg_res_adjunto();
								adjuntoRequisito.setCRADJ_CODIGO("KEYGEN");
								adjuntoRequisito.setCRADJ_NOMBRE_ADJUNTO(adjuntoTemporal.getCRATE_NOMBRE());
								adjuntoRequisito.setCRADJ_ARCHIVO_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());
								adjuntoRequisito.setCRADJ_CONTENIDO("application/octet-stream");
								adjuntoRequisito.setCRADJ_ESTADO(true);
								adjuntoRequisito.setCRADJ_FECHA_REGISTRO(new Date());
								adjuntoRequisito.setCRRQT_CODIGO(objRequisito.getCRRQT_CODIGO());
								adjuntoRequisito.setCRADJ_USUARIO_INSERT(userName);
								adjuntoRequisito.setCRADJ_USUARIO_UPDATE(userName);

								flagAdjuntosRequisito = new com.besixplus.sii.db.Cgg_res_adjunto(adjuntoRequisito).insert(objConn);
								if(flagAdjuntosRequisito.equalsIgnoreCase("false")==true){
									break;
								}
								codigoAdjuntoRequisito.add(adjuntoRequisito.getCRADJ_CODIGO());
							}																					
						}

						if(flagRequisito.equalsIgnoreCase("true")==true && flagAdjuntosRequisito.equalsIgnoreCase("true")==true ){						

							objSeguimientoPadre = new Cgg_res_seguimiento();
							objFase = new Cgg_res_fase();

							Cgg_res_seguimiento seguimiento = new Cgg_res_seguimiento();
							seguimiento.setCRTRA_CODIGO(obj.getCRTRA_CODIGO());

							ArrayList<Cgg_res_seguimiento> colSeguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(seguimiento).selectCGG_RES_TRAMITE(objConn); 
							if(colSeguimiento.size() >= 1){
								//SELECCION DE SEGUIMIENTO PADRE PREVIAMENTE REGISTRADO

								objSeguimientoPadre = colSeguimiento.get(0);
								objFase.setCRFAS_CODIGO(objSeguimientoPadre.getCRFAS_CODIGO());

								if(objJsonFasesSeguimientos.length()>=1){
									objSeguimientoPadre.setCRSEG_ESTADO_ATENCION(ESTADOATENCION.DESPACHADO.getValue());
									objSeguimientoPadre.setCRSEG_TIPO_RESPUESTA(TIPORESPUESTA.APROBADO.getValue());
								}
								objSeguimientoPadre.setCRSEG_USUARIO_UPDATE(userName);

								flagSeguimientoPadre = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimientoPadre).update(objConn);

							}else{
								//CREACION DE UN NUEVO SEGUIMIENTO PADRE

								objFase.setCRPRO_CODIGO(inCrpro_codigo);

								objFase = new com.besixplus.sii.db.Cgg_res_fase(objFase).selectFaseInicio(objConn,inCisla_codigo);

								if(objFase.getCRFAS_CODIGO() != null &&
										objFase.getCRFAS_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue()	&&
										objFase.getCRFAS_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

									//REGISTRO DE SEGUIMIENTO INICIAL DE UN TRAMITE.								

									objSeguimientoPadre.setCRSEG_CODIGO("KEYGEN");
									objSeguimientoPadre.setCGG_CRSEG_CODIGO(null); 
									objSeguimientoPadre.setCRTRA_CODIGO(obj.getCRTRA_CODIGO()); 
									objSeguimientoPadre.setCRFAS_CODIGO(objFase.getCRFAS_CODIGO()); 
									objSeguimientoPadre.setCGG_CRFAS_CODIGO(objFase.getCRFAS_CODIGO()); 
									objSeguimientoPadre.setCUSU_CODIGO(objUsuarioRegistro.getCUSU_CODIGO()); 
									objSeguimientoPadre.setCRSEG_DESCRIPCION("Registro de seguimiento para tr\u00E1mite "+obj.getCRTRA_ANIO().toString()+"-"+obj.getCRTRA_NUMERO()+"."); 														 					
									objSeguimientoPadre.setCRSEG_OBSERVACION(inCrtra_observacion);

									objSeguimientoPadre.setCRSEG_ESTADO_ATENCION(ESTADOATENCION.RECIBIDO.getValue());
									objSeguimientoPadre.setCRSEG_TIPO_RESPUESTA(TIPORESPUESTA.INDETERMINADO.getValue());

									objSeguimientoPadre.setCRSEG_TIPO_ACTIVIDAD(objFase.getCRFAS_TAREA_REALIZA()); 
									objSeguimientoPadre.setCRSEG_FECHA_RECEPCION(new Date()); 
									objSeguimientoPadre.setCRSEG_FECHA_REVISION(new Date()); 
									objSeguimientoPadre.setCRSEG_FECHA_DESPACHO(new Date()); 
									objSeguimientoPadre.setCRSEG_ESTADO_HIJO(ESTADORESPUESTA.SINRESPUESTAS.getValue()); 
									objSeguimientoPadre.setCRSEG_ESTADO(true); 																	
									objSeguimientoPadre.setCRSEG_VECES_REVISION(new BigDecimal(1)); 
									objSeguimientoPadre.setCRSEG_NUMERO(new BigDecimal(0));
									objSeguimientoPadre.setCUSU_CODIGO(objUsuarioRegistro.getCUSU_CODIGO());
									objSeguimientoPadre.setCRSEG_ESTADO(true);							
									objSeguimientoPadre.setCRSEG_USUARIO_INSERT(userName);
									objSeguimientoPadre.setCRSEG_USUARIO_UPDATE(userName);

									flagSeguimientoPadre = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimientoPadre).insert(objConn);
								}else{
									flagSeguimientoPadre = "false";									
								}
							}

							if(flagSeguimientoPadre.equalsIgnoreCase("true")==true){

								if(objJsonFasesSeguimientos.length()==0){
									//REGISTRO DE LA NOVEDAD NOTIFICACION PARA EL SEGUIMIENTO PADRE EN CASO DE SOLO GUARDADO
									objNotificacionSeguimiento = new Cgg_res_novedad_notificacion();
									objNotificacionSeguimiento.setCRNOV_CODIGO("KEYGEN");
									objNotificacionSeguimiento.setCRSEG_CODIGO(objSeguimientoPadre.getCRSEG_CODIGO());
									objNotificacionSeguimiento.setCRNOV_DESCRIPCION("TRAMITE SOLO GUARDADO EL "+DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date()));
									objNotificacionSeguimiento.setCRNOV_TIPO(TIPONOVEDAD.COMENTARIO.getValue());
									objNotificacionSeguimiento.setCRNOV_FECHA_REGISTRO(new Date());
									objNotificacionSeguimiento.setCRNOV_ESTADO(true);
									objNotificacionSeguimiento.setCRNOV_USUARIO_INSERT(userName);
									objNotificacionSeguimiento.setCRNOV_USUARIO_UPDATE(userName);									
									new com.besixplus.sii.db.Cgg_res_novedad_notificacion(objNotificacionSeguimiento).insert(objConn);																								
								}

								//INSERCION DE ADJUNTO DE REQUERIMIENTOS DE TRAMITE.
								for(Iterator<String> iCodigoAdjunto=codigoAdjuntoRequisito.iterator();iCodigoAdjunto.hasNext();){
									String codigoAdjunto = iCodigoAdjunto.next();
									Cgg_res_adjunto adjuntoRequisito = new Cgg_res_adjunto();
									adjuntoRequisito.setCRADJ_CODIGO(codigoAdjunto); 
									adjuntoRequisito = new com.besixplus.sii.db.Cgg_res_adjunto(adjuntoRequisito).select(objConn);
									adjuntoRequisito.setCRSEG_CODIGO(objSeguimientoPadre.getCRSEG_CODIGO());
									new com.besixplus.sii.db.Cgg_res_adjunto(adjuntoRequisito).update(objConn);
								}

								if(inAdjuntos != null){
									//INSERCION DE ADJUNTO GENERALES
									for(Cgg_res_adjunto objAdjunto : inAdjuntos){

										objAdjunto.setCRADJ_ESTADO(true);
										objAdjunto.setCRSEG_CODIGO(objSeguimientoPadre.getCRSEG_CODIGO());
										objAdjunto.setCRADJ_USUARIO_INSERT(userName);
										objAdjunto.setCRADJ_USUARIO_UPDATE(userName);

										flagAdjuntos = new com.besixplus.sii.db.Cgg_res_adjunto(objAdjunto).insert(objConn);
										if(flagAdjuntos.equalsIgnoreCase("true")== false){
											break;
										}
									}
								}

								if(flagAdjuntos.equalsIgnoreCase("true")==true){																			

									objJsonFasesSeguimientos = new JSONArray(inCrfas_codigo);

									if(objJsonFasesSeguimientos.length()>=1){
										for(int h=0;h<objJsonFasesSeguimientos.length();h++){
											tmpFaseDespacho = objJsonFasesSeguimientos.getJSONObject(h);

											objFaseDespacho = new Cgg_res_fase();
											objFaseDespacho.setCRFAS_CODIGO(tmpFaseDespacho.getString("CRFAS_CODIGO"));
											objFaseDespacho = new com.besixplus.sii.db.Cgg_res_fase(objFaseDespacho).select(objConn);

											//TODO: DESCOMENTAR PARA CONTROL DE USUARIO CUANDO HAYA USUARIOS REALES.
											if(tmpFaseDespacho.getString("CUSU_CODIGO")!=null /*&&  
													objFaseUsuario.getCUSU_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() && 
													objFaseUsuario.getCUSU_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()*/ &&
													objFaseDespacho.getCRFAS_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue()	&&
													objFaseDespacho.getCRFAS_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

												objSeguimientoHijo = new Cgg_res_seguimiento();																		

												//REGISTRO DE LOS SEGUIMIENTOS HIJOS DE UN SEGUIMIENTO DE UN TRAMITE.
												objSeguimientoHijo.setCRSEG_CODIGO("KEYGEN");
												objSeguimientoHijo.setCGG_CRSEG_CODIGO(null); 
												objSeguimientoHijo.setCRTRA_CODIGO(obj.getCRTRA_CODIGO()); 
												objSeguimientoHijo.setCRFAS_CODIGO(objFaseDespacho.getCRFAS_CODIGO()); 
												objSeguimientoHijo.setCGG_CRFAS_CODIGO(objFase.getCRFAS_CODIGO()); 
												objSeguimientoHijo.setCUSU_CODIGO(tmpFaseDespacho.getString("CUSU_CODIGO")); 
												objSeguimientoHijo.setCRSEG_DESCRIPCION(""); 
												objSeguimientoHijo.setCRSEG_ESTADO_ATENCION(ESTADOATENCION.RECIBIDO.getValue()); 
												objSeguimientoHijo.setCRSEG_OBSERVACION(""); 
												objSeguimientoHijo.setCRSEG_TIPO_RESPUESTA(TIPORESPUESTA.INDETERMINADO.getValue()); 
												objSeguimientoHijo.setCRSEG_TIPO_ACTIVIDAD(objFaseDespacho.getCRFAS_TAREA_REALIZA()); 
												objSeguimientoHijo.setCRSEG_FECHA_RECEPCION(new Date()); 
												objSeguimientoHijo.setCRSEG_FECHA_REVISION(null); 
												objSeguimientoHijo.setCRSEG_FECHA_DESPACHO(null); 
												objSeguimientoHijo.setCRSEG_ESTADO_HIJO(ESTADORESPUESTA.SINHIJOS.getValue()); 																										
												objSeguimientoHijo.setCRSEG_VECES_REVISION(new BigDecimal(0)); 
												objSeguimientoHijo.setCRSEG_NUMERO(new BigDecimal(0));
												objSeguimientoHijo.setCRSEG_ESTADO(true);

												objSeguimientoHijo.setCRSEG_USUARIO_INSERT(userName);
												objSeguimientoHijo.setCRSEG_USUARIO_UPDATE(userName);											

												flagSeguimientoHijo = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimientoHijo).insert(objConn);

												if(flagSeguimientoHijo.equalsIgnoreCase("true")==false){												
													break;
												}else{

													//REGISTRO DE LA NOVEDAD NOTIFICACION PARA EL SEGUIMIENTO HIJO
													objNotificacionSeguimiento = new Cgg_res_novedad_notificacion();
													objNotificacionSeguimiento.setCRNOV_CODIGO("KEYGEN");
													objNotificacionSeguimiento.setCRSEG_CODIGO(objSeguimientoHijo.getCRSEG_CODIGO());
													objNotificacionSeguimiento.setCRNOV_DESCRIPCION(tmpFaseDespacho.getString("CRFAS_SUMILLA"));
													objNotificacionSeguimiento.setCRNOV_TIPO(TIPONOVEDAD.COMENTARIO.getValue());
													objNotificacionSeguimiento.setCRNOV_FECHA_REGISTRO(new Date());
													objNotificacionSeguimiento.setCRNOV_ESTADO(true);
													objNotificacionSeguimiento.setCRNOV_USUARIO_INSERT(userName);
													objNotificacionSeguimiento.setCRNOV_USUARIO_UPDATE(userName);
													if(tmpFaseDespacho.getString("CRFAS_SUMILLA")!= null && 
															tmpFaseDespacho.getString("CRFAS_SUMILLA").trim().length() >=1){
														String flagSumillaSeguimiento = new com.besixplus.sii.db.Cgg_res_novedad_notificacion(objNotificacionSeguimiento).insert(objConn);
													}												
													//NOTIFICACION A TRAVEZ DE CORREO ELECTRONICO AL USUARIO DEL SEGUIMIENTO Q RECIBIO EL SEGUIMIENTO.
													//TODO: IMPLEMENTAR LA NOTIFICACION POR CORREO ELECTRONICO.
													//Notificador objNotificador = new Notificador(inMail, inAsunto, inContenido, inNombreAdjuntos, inAdjuntos)																								
												}

											}else{
												flagSeguimientoHijo = "false";
												break;											
											}	

											if(flagSeguimientoHijo.equalsIgnoreCase("true")==false){												
												break;
											}										
										}
									}else{
										flagSeguimientoHijo = "true";										
									}
									if(flagSeguimientoHijo.equalsIgnoreCase("true")==true){										
										objConn.commit();																												
									}else{										
										res="SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR LOS SEGUIMIENTOS HIJOS DEL TRAMITE.";
									}
								}else{
									objConn.rollback();
									res = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR LOS ADJUNTOS DEL TRAMITE.";
								}
							}else{
								objConn.rollback();
								res = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR EL SEGUIMIENTO INICIAL DEL TRAMITE.";
							}																																																																																				
						}else{
							objConn.rollback();
							res = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR LOS REQUISITOS DEL TRAMITE.";
						}																																
					}else{
						objConn.rollback();
						res = "SE PRESENTO UN PROBLEMA AL MOMENTO DE REGISTRAR EL TRAMITE.";					
					}			
				}else{
					objConn.rollback();
					res = tmpMsg ;
				}
			}else{
				res = "EL TRAMITE NO EXISTE.";
			}

			objConn.setAutoCommit(true);			
			objConn.close();

			responser.setSuccess(true);
			responser.setMsg(res);
			responser.setObjData(obj);

		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			res = inException.getMessage();
			responser.setSuccess(false);
			responser.setMsg(res);
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			res = inException.getMessage();
			responser.setSuccess(false);
			responser.setMsg(res);
		}			
		return responser.getMsg();
	}

	/**
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_tramite.
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String updateAuspiciante(
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo			
			) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tramite obj = new com.besixplus.sii.objects.Cgg_res_tramite();
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCRTRA_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_tramite(obj).updateAuspiciante(con);
			con.close();
			if(!res.equalsIgnoreCase("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}

	@WebMethod
	public String updateIsla(
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="inCisla_codigo")String inCisla_codigo
	) throws SOAPException {
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tramite obj = new com.besixplus.sii.objects.Cgg_res_tramite();
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCISLA_CODIGO(inCisla_codigo);
		obj.setCRTRA_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_tramite(obj).updateIsla(con);
			con.close();
			if(!res.equalsIgnoreCase("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}

}