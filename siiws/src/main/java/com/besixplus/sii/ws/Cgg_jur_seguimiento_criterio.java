package com.besixplus.sii.ws;

import java.util.ArrayList;
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

import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.misc.CGGEnumerators;
import com.besixplus.sii.misc.CGGEnumerators.LONGITUDCLAVEPRIMARIA;
import com.besixplus.sii.objects.Cgg_res_seguimiento;

/**
 * CLASE Cgg_jur_seguimiento_criterio
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_seguimiento_criterio POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_jur_seguimiento_criterio implements Serializable{

	private static final long serialVersionUID = 370827241;

	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_jur_seguimiento_criterio.
	 * @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO.
	 * @param inCjcri_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CRITERIO JURIDICO.
	 * @param inCjsgc_respuesta RESPUESTA DEL CRITERIO
SI / NO.
	 * @param inCjsgc_justificacion RAZON QUE RESPALDA LA RESPUESTA.
	 * @param inCjsgc_observacion NO ESPECIFICADO.
	 * @param inCjsgc_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO.
	 * @param inCjsgc_adjunto ARCHIVO DIGITAL ANEXO AL CRITERIO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="inCjcri_codigo")String inCjcri_codigo,
			@WebParam(name="inCjsgc_respuesta")boolean inCjsgc_respuesta,
			@WebParam(name="inCjsgc_justificacion")String inCjsgc_justificacion,
			@WebParam(name="inCjsgc_observacion")String inCjsgc_observacion,
			@WebParam(name="inCjsgc_nombre_adjunto")String inCjsgc_nombre_adjunto,
			@WebParam(name="inCjsgc_adjunto")String inCjsgc_adjunto
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio obj = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
		obj.setCJSGC_CODIGO("KEYGEN");
		obj.setCRSEG_CODIGO(inCrseg_codigo);
		obj.setCJCRI_CODIGO(inCjcri_codigo);
		obj.setCJSGC_RESPUESTA(inCjsgc_respuesta);
		obj.setCJSGC_JUSTIFICACION(inCjsgc_justificacion);
		obj.setCJSGC_OBSERVACION(inCjsgc_observacion);
		obj.setCJSGC_NOMBRE_ADJUNTO(inCjsgc_nombre_adjunto);
		obj.setCJSGC_ADJUNTO(com.besixplus.sii.mail.Base64.decode(inCjsgc_adjunto));
		obj.setCJSGC_ESTADO(true);
		obj.setCJSGC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCJSGC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(obj).insert(con);
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
		return res;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_seguimiento_criterio EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_jur_seguimiento_criterio.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
			return outCadena.toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_seguimiento_criterio EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_seguimiento_criterio.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_seguimiento_criterio.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_seguimiento_criterio EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_seguimiento_criterio.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_seguimiento_criterio.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_jur_seguimiento_criterio.
	 * @param inCjsgc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO CRITERIO
	 * @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	 * @param inCjcri_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CRITERIO JURIDICO
	 * @param inCjsgc_respuesta RESPUESTA DEL CRITERIO
SI / NO
	 * @param inCjsgc_justificacion RAZON QUE RESPALDA LA RESPUESTA
	 * @param inCjsgc_observacion NO ESPECIFICADO
	 * @param inCjsgc_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	 * @param inCjsgc_adjunto ARCHIVO DIGITAL ANEXO AL CRITERIO
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCjsgc_codigo")String inCjsgc_codigo,
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="inCjcri_codigo")String inCjcri_codigo,
			@WebParam(name="inCjsgc_respuesta")boolean inCjsgc_respuesta,
			@WebParam(name="inCjsgc_justificacion")String inCjsgc_justificacion,
			@WebParam(name="inCjsgc_observacion")String inCjsgc_observacion,
			@WebParam(name="inCjsgc_nombre_adjunto")String inCjsgc_nombre_adjunto,
			@WebParam(name="inCjsgc_adjunto")String inCjsgc_adjunto
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio obj = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
		obj.setCJSGC_CODIGO(inCjsgc_codigo);
		obj.setCRSEG_CODIGO(inCrseg_codigo);
		obj.setCJCRI_CODIGO(inCjcri_codigo);
		obj.setCJSGC_RESPUESTA(inCjsgc_respuesta);
		obj.setCJSGC_JUSTIFICACION(inCjsgc_justificacion);
		obj.setCJSGC_OBSERVACION(inCjsgc_observacion);
		obj.setCJSGC_NOMBRE_ADJUNTO(inCjsgc_nombre_adjunto);
		obj.setCJSGC_ADJUNTO(com.besixplus.sii.mail.Base64.decode(inCjsgc_adjunto));
		obj.setCJSGC_ESTADO(true);
		obj.setCJSGC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(obj).update(con);
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
		return res;
	}

	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_jur_seguimiento_criterio EN UNA ESTRUCTURA JSON o XML.
	 * @param inCjsgc_codigo cjsgc_codigo.
	 * @param format Cadena en formato XML/JSON.
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCjsgc_codigo")String inCjsgc_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio tmpObj = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
		tmpObj.setCJSGC_CODIGO(inCjsgc_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
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
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}

	/**
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_jur_seguimiento_criterio.
	 * @param inCjsgc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO CRITERIO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCjsgc_codigo")String inCjsgc_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio tmpObj = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
		tmpObj.setCJSGC_CODIGO(inCjsgc_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(tmpObj).delete(con);
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
		return new Boolean(outResult).toString();
	}

	/**
	 * Selecciona todos los criterios juridicos a cumplirse para un seguimiento deacuerdo a su fase. 
	 * La consulta selecciona en base al codigo de seguimiento cuando se edita informacion y a la fase cuando la informacion es nueva registrarse.
	 * La seleccion interna realiza un left join con la informacion de las tablas seguimiento, seguimiento_criterio, criterio y fase.
	 * @param inCrfas_codigo Codigo de fase.
	 * @param inCrseg_codigo Codigo de seguimiento.
	 * @param format Cadena de formato de salida JSON/XML.
	 * @return Cadena en formato de salida especificado con informacion de los criterios juridicos de un seguimiento.
	 */
	@WebMethod
	public String selectSEGUIMIENTO_CRITERIO(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="inCrfas_codigo")String inCrfas_codigo,
			@WebParam(name="format")String format
	){
		//		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;		
		try{
			Connection con = ManagerConnection.getConnection();
			//			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
			//				con.close();
			//				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
			//				return null;
			//			}			
			//con.setAutoCommit(!ManagerConnection.isDeployed());
			con.setAutoCommit(false);
			obj = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio().selectSEGUIMIENTO_CRITERIO(inCrfas_codigo,inCrseg_codigo,con);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			//			try {
			//				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			//			} catch (IOException e) {
			//				e.printStackTrace();
			//			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			//			try {
			//				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			//			} catch (IOException e) {
			//				e.printStackTrace();
			//			}
			return inException.getMessage();
		}
		if (obj != null)			
			return outCadena.toString();							
		return null;
	}

	/**
	 * Inserta todo los criterios a cumplirse de un seguimiento por su fase relacionada.
	 * @param inCrseg_codigo Codigo de seguimientos. 
	 * @param inCjsgc_criterios Cadena de texto con informacion en formato JSON de los criterios del seguimiento.
	 * @return true/false.
	 */
	@Deprecated
	@WebMethod
	public String insertarCriterios(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,		
			@WebParam(name="inCjsgc_criterios")String inCjsgc_criterios		
	){		
		String flagCriterioSeguimiento = "true";
		boolean flagDeleteCriterioSeguimiento = true;
		//		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);		

		try{
			Connection con = ManagerConnection.getConnection();
			//			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
			//				con.close();
			//				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
			//				return null;
			//			}
			con.setAutoCommit(false);
			Cgg_res_seguimiento objSeguimiento = new Cgg_res_seguimiento();
			objSeguimiento.setCRSEG_CODIGO(inCrseg_codigo);
			objSeguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).select(con);
			if(objSeguimiento != null &&
					objSeguimiento.getCRSEG_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue()&&
					objSeguimiento.getCRSEG_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

				com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio objSeguimientoCriterio1 = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
				objSeguimientoCriterio1.setCRSEG_CODIGO(objSeguimiento.getCRSEG_CODIGO());				
				flagDeleteCriterioSeguimiento = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(objSeguimientoCriterio1).deleteCGG_RES_SEGUIMIENTO(con);

				if(flagDeleteCriterioSeguimiento==true){
					org.json.JSONArray jsColCriterio = new org.json.JSONArray(inCjsgc_criterios);				
					for(int i =0;i<jsColCriterio.length();i++){

						JSONObject joCriterio = jsColCriterio.getJSONObject(i);

						com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio objSeguimientoCriterio = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
						objSeguimientoCriterio.setCJSGC_CODIGO("KEYGEN");
						objSeguimientoCriterio.setCRSEG_CODIGO(inCrseg_codigo);
						objSeguimientoCriterio.setCJCRI_CODIGO(joCriterio.getString("CJCRI_CODIGO"));

						boolean flagRespuesta = false;
						try{
							flagRespuesta  = joCriterio.getBoolean("CJSGC_RESPUESTA");
						}catch(Exception ex){
							flagRespuesta = false;
						}						
						objSeguimientoCriterio.setCJSGC_RESPUESTA(flagRespuesta);
						objSeguimientoCriterio.setCJSGC_JUSTIFICACION(joCriterio.getString("CJSGC_JUSTIFICACION"));
						objSeguimientoCriterio.setCJSGC_OBSERVACION(joCriterio.getString("CJSGC_OBSERVACION"));
						objSeguimientoCriterio.setCJSGC_ESTADO(true);
						//						objSeguimientoCriterio.setCJSGC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						//						objSeguimientoCriterio.setCJSGC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						flagCriterioSeguimiento = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(objSeguimientoCriterio).insert(con);
						if(flagCriterioSeguimiento.equalsIgnoreCase("true")==false){
							break;
						}									
					}

					if(flagCriterioSeguimiento.equalsIgnoreCase("true")==true){
						con.commit();
					}else{
						con.rollback();
						flagCriterioSeguimiento = "false";
					}						
				}else{
					con.rollback();
					flagCriterioSeguimiento = "false";
				}					
			}else{
				con.rollback();
				flagCriterioSeguimiento = "false";
			}

			//			if(!flagCriterioSeguimiento.equals("true"))
			//				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, flagCriterioSeguimiento);
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			//			try {
			//				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			//			} catch (IOException e) {
			//				e.printStackTrace();
			//			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			//			try {
			//				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			//			} catch (IOException e) {
			//				e.printStackTrace();
			//			}
			return inException.getMessage();
		}
		return flagCriterioSeguimiento;
	}

	/**Elimina el documento adjunto de un registro de seguimiento criterio especificado.
	 * @param inCjsgc_codigo Codigo de seguimiento criterio.
	 * @return Verdadero/False/Error en la ejecucion del servicio.
	 */
	@WebMethod
	public String deleteAdjuntoCriterio(
			@WebParam(name="inCjsgc_codigo")String inCjsgc_codigo
	){
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio tmpObj = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
		tmpObj.setCJSGC_CODIGO(inCjsgc_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			tmpObj = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(tmpObj).select(con);
			if(tmpObj.getCJSGC_CODIGO() != null &&
					tmpObj.getCJSGC_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue()&&
					tmpObj.getCJSGC_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

				tmpObj.setCJSGC_NOMBRE_ADJUNTO(null);
				tmpObj.setCJSGC_ADJUNTO(null);

				outResult = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(tmpObj).update(con);
				if(outResult.equalsIgnoreCase("true")){
					con.commit();
				}else{
					con.rollback();
				}
			}else{
				outResult = "false";
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
		return outResult;
	}

	/**
	 * Inserta un registro en la tabla Cgg_jur_seguimiento_criterio con la diferencia que no solicita informacion del adjunto.
	 * @param inCrseg_codigo Codigo de seguimiento. 
	 * @param inCjcri_codigo Codigo de criterio.
	 * @param inCjsgc_respuesta Respuesta del criterio <code>true/false</code>.
	 * @param inCjsgc_justificacion Justificacion del criterio.
	 * @param inCjsgc_observacion Observacion del criterio.
	 * @return <code>true/false</code> en la ejecucion del metodo.
	 */
	@WebMethod
	public String insert1(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="inCjcri_codigo")String inCjcri_codigo,
			@WebParam(name="inCjsgc_respuesta")boolean inCjsgc_respuesta,
			@WebParam(name="inCjsgc_justificacion")String inCjsgc_justificacion,
			@WebParam(name="inCjsgc_observacion")String inCjsgc_observacion			
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio obj = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
		obj.setCJSGC_CODIGO("KEYGEN");
		obj.setCRSEG_CODIGO(inCrseg_codigo);
		obj.setCJCRI_CODIGO(inCjcri_codigo);
		obj.setCJSGC_RESPUESTA(inCjsgc_respuesta);
		obj.setCJSGC_JUSTIFICACION(inCjsgc_justificacion);
		obj.setCJSGC_OBSERVACION(inCjsgc_observacion);		
		obj.setCJSGC_ESTADO(true);
		obj.setCJSGC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCJSGC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(obj).insert(con);
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
		return res;
	}

	/**
	 * Actualiza un registro de criterio de seguimiento sin informacion del adjunto.
	 * @param inCjsgc_codigo Codigo de criterio de seguimiento.
	 * @param inCrseg_codigo Codigo de seguimiento. 
	 * @param inCjcri_codigo Codigo de criterio.
	 * @param inCjsgc_respuesta Respuesta de criterio.
	 * @param inCjsgc_justificacion Justificacion del criterio. 
	 * @param inCjsgc_observacion Observacion del criterio.
	 * @return <code>true/false</code> en la ejecucion del metodo.
	 */
	@WebMethod
	public String update1(
			@WebParam(name="inCjsgc_codigo")String inCjsgc_codigo,
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="inCjcri_codigo")String inCjcri_codigo,
			@WebParam(name="inCjsgc_respuesta")boolean inCjsgc_respuesta,
			@WebParam(name="inCjsgc_justificacion")String inCjsgc_justificacion,
			@WebParam(name="inCjsgc_observacion")String inCjsgc_observacion
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio obj = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
		obj.setCJSGC_ESTADO(true);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			obj.setCJSGC_CODIGO(inCjsgc_codigo);
			obj = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(obj).select(con);			
			if(obj.getCJSGC_CODIGO()!=null&&
					obj.getCJSGC_CODIGO().trim().length()>=LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
					obj.getCJSGC_CODIGO().trim().length()<=LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

				obj.setCJSGC_RESPUESTA(inCjsgc_respuesta);
				obj.setCJSGC_JUSTIFICACION(inCjsgc_justificacion);
				obj.setCJSGC_OBSERVACION(inCjsgc_observacion);						
				obj.setCJSGC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

				res = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(obj).update(con); 
				con.commit();
			}else{
				res = "false";
				con.rollback();
			}

			if(!res.equals("true"))
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_seguimiento_criterio EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectPageDirectJuridico(
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_seguimiento_criterio.selectCountJuridico(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_seguimiento_criterio.selectAllDirectJuridico(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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

}