package com.besixplus.sii.ws;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import com.besixplus.sii.db.ManagerConnection;

/**
 * CLASE Cgg_dhu_asistente_curso
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_asistente_curso POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_dhu_asistente_curso implements Serializable{

	private static final long serialVersionUID = 1231564828;

	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_asistente_curso.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	 * @param inCdcur_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CURSO.
	 * @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO.
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	 * @param inCdasc_actividad_realizada ACTIVIDAD QUE SE HALLA REALIZANDO ACTUALMENTE.
	 * @param inCdasc_nota_final NOTA FINAL DEL CURSO RECIBIDO.
	 * @param inCdasc_numero_certificado NUMERO DE CERTIFICADO.
	 * @param inCdasc_fecha_emision_certificado CAMPO QUE REGISTRA LA EMISION DEL CERTIFICADO DEL CURSO.
	 * @param inCdasc_estado_inscripcion ESTADO QUE IDENTIFICA LA INSCRIPCION AL CURSO
			0 - PRE INSCRITO
			1 - INSCRITO

.
	 * @param inCdasc_aprobado ESTADO QUE DETERMINA SI LA PERSONA APROBO EL CURSO
			0 - REPROBADO
			1 - APROBADO
			2 - RETIRADO.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCdcur_codigo")String inCdcur_codigo,
			@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
			@WebParam(name="inCusu_codigo")String inCusu_codigo,
			@WebParam(name="inCdasc_actividad_realizada")String inCdasc_actividad_realizada,
			@WebParam(name="inCdasc_nota_final")java.math.BigDecimal inCdasc_nota_final,
			@WebParam(name="inCdasc_numero_certificado")String inCdasc_numero_certificado,
			@WebParam(name="inCdasc_fecha_emision_certificado")java.util.Date inCdasc_fecha_emision_certificado,
			@WebParam(name="inCdasc_estado_inscripcion")int inCdasc_estado_inscripcion,
			@WebParam(name="inCdasc_aprobado")int inCdasc_aprobado
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_asistente_curso obj = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();
		obj.setCDASC_CODIGO("KEYGEN");
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCDCUR_CODIGO(inCdcur_codigo);
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCUSU_CODIGO(inCusu_codigo);
		obj.setCDASC_ACTIVIDAD_REALIZADA(inCdasc_actividad_realizada);
		obj.setCDASC_NOTA_FINAL(inCdasc_nota_final);
		obj.setCDASC_NUMERO_CERTIFICADO(inCdasc_numero_certificado);
		obj.setCDASC_FECHA_EMISION_CERTIFICADO(inCdasc_fecha_emision_certificado);
		obj.setCDASC_ESTADO_INSCRIPCION(inCdasc_estado_inscripcion);
		obj.setCDASC_APROBADO(inCdasc_aprobado);
		obj.setCDASC_ESTADO(true);
		obj.setCDASC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCDASC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_dhu_asistente_curso(obj).insert(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		//return new Boolean(res).toString();
		return res.toString();
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso EN UNA ESTRUCTRA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_dhu_asistente_curso.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_dhu_asistente_curso.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_asistente_curso.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_dhu_asistente_curso.
	 * @param inCdasc_codigo IDENTIFICATIVO UNICO DE REGISTRO ASISTENTES 
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	 * @param inCdcur_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
	 * @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCdasc_actividad_realizada ACTIVIDAD QUE SE HALLA REALIZANDO ACTUALMENTE
	 * @param inCdasc_nota_final NOTA FINAL DEL CURSO RECIBIDO
	 * @param inCdasc_numero_certificado NUMERO DE CERTIFICADO
	 * @param inCdasc_fecha_emision_certificado CAMPO QUE REGISTRA LA EMISION DEL CERTIFICADO DEL CURSO
	 * @param inCdasc_estado_inscripcion ESTADO QUE IDENTIFICA LA INSCRIPCION AL CURSO
			0 - PRE INSCRITO
			1 - INSCRITO


	 * @param inCdasc_aprobado ESTADO QUE DETERMINA SI LA PERSONA APROBO EL CURSO
			0 - REPROBADO
			1 - APROBADO
			2 - RETIRADO
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCdasc_codigo")String inCdasc_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCdcur_codigo")String inCdcur_codigo,
			@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
			@WebParam(name="inCusu_codigo")String inCusu_codigo,
			@WebParam(name="inCdasc_actividad_realizada")String inCdasc_actividad_realizada,
			@WebParam(name="inCdasc_nota_final")java.math.BigDecimal inCdasc_nota_final,
			@WebParam(name="inCdasc_numero_certificado")String inCdasc_numero_certificado,
			@WebParam(name="inCdasc_fecha_emision_certificado")java.util.Date inCdasc_fecha_emision_certificado,
			@WebParam(name="inCdasc_estado_inscripcion")int inCdasc_estado_inscripcion,
			@WebParam(name="inCdasc_aprobado")int inCdasc_aprobado
	){
		boolean res = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_asistente_curso obj = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();
		obj.setCDASC_CODIGO(inCdasc_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCDCUR_CODIGO(inCdcur_codigo);
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCUSU_CODIGO(inCusu_codigo);
		obj.setCDASC_ACTIVIDAD_REALIZADA(inCdasc_actividad_realizada);
		obj.setCDASC_NOTA_FINAL(inCdasc_nota_final);
		obj.setCDASC_NUMERO_CERTIFICADO(inCdasc_numero_certificado);
		obj.setCDASC_FECHA_EMISION_CERTIFICADO(inCdasc_fecha_emision_certificado);
		obj.setCDASC_ESTADO_INSCRIPCION(inCdasc_estado_inscripcion);
		obj.setCDASC_APROBADO(inCdasc_aprobado);
		obj.setCDASC_ESTADO(true);
		obj.setCDASC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_dhu_asistente_curso(obj).update(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return new Boolean(res).toString();
	}


	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_dhu_asistente_curso EN UNA ESTRUCTURA JSON o XML.
	 * @param inCdasc_codigo cdasc_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCdasc_codigo")String inCdasc_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_asistente_curso tmpObj = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();
		tmpObj.setCDASC_CODIGO(inCdasc_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_dhu_asistente_curso(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_asistente_curso>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}


	/**
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_dhu_asistente_curso.
	 * @param inCdasc_codigo IDENTIFICATIVO UNICO DE REGISTRO ASISTENTES 
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCdasc_codigo")String inCdasc_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_asistente_curso tmpObj = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();
		tmpObj.setCDASC_CODIGO(inCdasc_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_dhu_asistente_curso(tmpObj).delete(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return new Boolean(outResult).toString();
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAistentePage(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = new ArrayList<HashMap<String,Object>>();
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
			tmpCount = com.besixplus.sii.db.Cgg_dhu_asistente_curso.Selectasistentecount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_dhu_asistente_curso.selectAsistente(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
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
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona EN UNA ESTRUCTRA JSON o XML.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAsistenteResidente(
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> per = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			per = com.besixplus.sii.db.Cgg_dhu_asistente_curso.selectAsistenteCurso(con,inCrper_num_doc_identific);
			//ArrayList<com.besixplus.sii.objects.Cgg_res_persona> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
			//tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, per);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (per!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAistenteCursoPage(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = new ArrayList<HashMap<String,Object>>();
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
			tmpCount = com.besixplus.sii.db.Cgg_dhu_asistente_curso.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_dhu_asistente_curso.selectAllAsistenteCurso(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
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
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso EN UNA ESTRUCTRA JSON o XML.
	 * @param inCdcur_codigo IDENTIFICATIVO UNICO DE CURSO.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAsistenteCursoCalificacion(
			@WebParam(name="inCdcur_codigo")String inCdcur_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> per = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			per = com.besixplus.sii.db.Cgg_dhu_asistente_curso.selectAsistenteCalificacion(con,inCdcur_codigo);
			//ArrayList<com.besixplus.sii.objects.Cgg_res_persona> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
			//tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, per);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (per!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso EN UNA ESTRUCTRA JSON o XML.
	 * @param inCdcur_codigo IDENTIFICATIVO UNICO DE CURSO.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAsistenteCursoInscrito(
			@WebParam(name="inCdcur_codigo")String inCdcur_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> per = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			per = com.besixplus.sii.db.Cgg_dhu_asistente_curso.selectAsistenteInscrito(con,inCdcur_codigo);
			//ArrayList<com.besixplus.sii.objects.Cgg_res_persona> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
			//tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, per);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (per!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso EN UNA ESTRUCTRA JSON o XML.
	 * @param inCdcur_codigo IDENTIFICATIVO UNICO DE CURSO.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAsistenteCertificado(
			@WebParam(name="inCdcur_codigo")String inCdcur_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> per = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			per = com.besixplus.sii.db.Cgg_dhu_asistente_curso.selectAsistenteCerti(con,inCdcur_codigo);
			//ArrayList<com.besixplus.sii.objects.Cgg_res_persona> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
			//tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, per);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (per!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_asistente_curso EN UNA ESTRUCTRA JSON o XML.
	 * @param inCdcur_codigo IDENTIFICATIVO UNICO DE CURSO.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAsistenteInscrito(
			@WebParam(name="inCdcur_codigo")String inCdcur_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> per = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			per = com.besixplus.sii.db.Cgg_dhu_asistente_curso.selectAsisInscrito(con,inCdcur_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, per);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (per!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_dhu_asistente_curso.
	 * @param inAsistenteCurso_JSON JSON QUE CONTIENE LOS REGISTRO A SER ACTUALIZADO
     * @param inCdcur_codigo IDENTIFICATIVO UNICO DE CGG_DHU_CURSO
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String updateAsistenteInscripcion(
			@WebParam(name="inAsistenteCurso_JSON")String inAsistenteCurso_JSON,			
			@WebParam(name="inCdcur_codigo")String inCdcur_codigo
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_asistente_curso obj = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();	

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			org.json.JSONArray AsistenteJson = new org.json.JSONArray(inAsistenteCurso_JSON);
			for (int i = 0 ; i < AsistenteJson.length(); i++){
				obj.setCDASC_CODIGO(((org.json.JSONObject)AsistenteJson.get(i)).get("CDASC_CODIGO").toString());		
				obj.setCDASC_ESTADO_INSCRIPCION(Integer.valueOf((((org.json.JSONObject)AsistenteJson.get(i)).get("CDASC_ESTADO_INSCRIPCION")).toString()));
				obj.setCDASC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());			
				res = new com.besixplus.sii.db.Cgg_dhu_asistente_curso(obj).updateEstadoInscrito(con);
			}if(res.equals("true")){
				com.besixplus.sii.objects.Cgg_dhu_curso objcurso = new com.besixplus.sii.objects.Cgg_dhu_curso();
				objcurso.setCDCUR_CODIGO(inCdcur_codigo);			
				objcurso.setCDCUR_ESTADO_CURSO(1);	
				objcurso.setCDCUR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());			
				res = new com.besixplus.sii.db.Cgg_dhu_curso(objcurso).updateEstadoCurso(con);
			}
			if(!res.equals("true")){
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
				con.rollback();
			}else
			{
				con.commit();	
			}
			con.setAutoCommit(true);
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
		return res;

	}
	/**
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_dhu_asistente_curso.
	 * @param inAsistenteCalificacion_JSON JSON QUE CONTIENE LOS REGISTRO A SER ACTUALIZADO
     * @param inCdcur_codigo IDENTIFICATIVO UNICO DE CGG_DHU_CURSO
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String updateAsistenteCalificacion(
			@WebParam(name="inAsistenteCalificacion_JSON")String inAsistenteCalificacion_JSON,			
			@WebParam(name="inCdcur_codigo")String inCdcur_codigo
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_asistente_curso obj = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();	

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			org.json.JSONArray AsistenteCalificacionJson = new org.json.JSONArray(inAsistenteCalificacion_JSON);
			for (int i = 0 ; i < AsistenteCalificacionJson.length(); i++){
				obj.setCDASC_CODIGO(((org.json.JSONObject)AsistenteCalificacionJson.get(i)).get("CDASC_CODIGO").toString());	
				obj.setCDASC_NOTA_FINAL(new java.math.BigDecimal((((org.json.JSONObject)AsistenteCalificacionJson.get(i)).get("CDASC_NOTA_FINAL")).toString()));
				obj.setCDASC_APROBADO(Integer.valueOf((((org.json.JSONObject)AsistenteCalificacionJson.get(i)).get("CDASC_APROBADO")).toString()));
				obj.setCDASC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());			
				res = new com.besixplus.sii.db.Cgg_dhu_asistente_curso(obj).updateAprobadoCurso(con);
			}if(res.equals("true")){
				com.besixplus.sii.objects.Cgg_dhu_curso objcurso = new com.besixplus.sii.objects.Cgg_dhu_curso();
				objcurso.setCDCUR_CODIGO(inCdcur_codigo);	
				objcurso.setCDCUR_FECHA_CULMINACION(new Date());
				objcurso.setCDCUR_ESTADO_CURSO(3);	
				objcurso.setCDCUR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());			
				res = new com.besixplus.sii.db.Cgg_dhu_curso(objcurso).updateEstadoCursoTerminado(con);
			}
			if(!res.equals("true")){
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
				con.rollback();
			}else
			{
				con.commit();	
			}
			con.setAutoCommit(true);
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
		return res;

	}
	/**
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_dhu_asistente_curso.
	 * @param inAsistenteCertificado_JSON JSON QUE CONTIENE LOS REGISTRO A SER ACTUALIZADO
	 * @param inCdcur_codigo IDENTIFICATIVO UNICO DE CGG_DHU_CURSO
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String updateAsistenteCertificado(
			@WebParam(name="inAsistenteCertificado_JSON")String inAsistenteCertificado_JSON,			
			@WebParam(name="inCdcur_codigo")String inCdcur_codigo
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_asistente_curso obj = new com.besixplus.sii.objects.Cgg_dhu_asistente_curso();	

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			org.json.JSONArray AsistenteCertificadoJson = new org.json.JSONArray(inAsistenteCertificado_JSON);
			for (int i = 0 ; i < AsistenteCertificadoJson.length(); i++){
				obj.setCDASC_CODIGO(((org.json.JSONObject)AsistenteCertificadoJson.get(i)).get("CDASC_CODIGO").toString());	
				obj.setCDASC_NUMERO_CERTIFICADO(((org.json.JSONObject)AsistenteCertificadoJson.get(i)).get("CDASC_NUMERO_CERTIFICADO").toString());
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date fechaEmision = null;
				try{
					fechaEmision = df.parse(((org.json.JSONObject)AsistenteCertificadoJson.get(i)).get("CDASC_FECHA_EMISION_CERTIFICADO").toString());
				} catch (ParseException e){
					e.printStackTrace();
					fechaEmision = new Date();
				}	
				obj.setCDASC_FECHA_EMISION_CERTIFICADO(fechaEmision);
				obj.setCDASC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());			
				res = new com.besixplus.sii.db.Cgg_dhu_asistente_curso(obj).updateAprobadoCertificado(con);
			}if(res.equals("true")){
				com.besixplus.sii.objects.Cgg_dhu_curso objcurso = new com.besixplus.sii.objects.Cgg_dhu_curso();
				objcurso.setCDCUR_CODIGO(inCdcur_codigo);			
				objcurso.setCDCUR_ESTADO_CURSO(4);	
				objcurso.setCDCUR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());			
				res = new com.besixplus.sii.db.Cgg_dhu_curso(objcurso).updateEstadoCurso(con);
			}
			if(!res.equals("true")){
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
				con.rollback();
			}else
			{
				con.commit();	
			}
			con.setAutoCommit(true);
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
		return res;

	}
	/**
	 * OBTIENE UN REGISTRO DE LA TABLA Cgg_configuracion EN UNA ESTRUCTRA JSON o XML.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	@WebMethod
	public String numeroAprobacion(
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_configuracion tmpObj = new com.besixplus.sii.objects.Cgg_configuracion();
		String numeroAprobacion;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			numeroAprobacion = com.besixplus.sii.db.Cgg_dhu_asistente_curso.geneNumAprobacion(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return numeroAprobacion;
		return null;
	}
}