package com.besixplus.sii.ws;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.misc.CGGEnumerators;
import com.besixplus.sii.misc.CGGEnumerators.LONGITUDCLAVEPRIMARIA;
import com.besixplus.sii.objects.Cgg_res_seguimiento;

/**
 * CLASE Cgg_res_novedad_notificacion
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_novedad_notificacion POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_novedad_notificacion implements Serializable{

	private static final long serialVersionUID = 293118865;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_novedad_notificacion.
	 * @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO.
	 * @param inCrnov_fecha_registro FECHA DE REGISTRO DE LA NOVEDAD.
	 * @param inCrnov_descripcion DESCRIPCION DE LA NOVEDAD.
	 * @param inCrnov_tipo TIPO DE NOVEDAD - NOTIFICACION
0 Comentario
1 Notificacion.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="inCrnov_fecha_registro")java.util.Date inCrnov_fecha_registro,
			@WebParam(name="inCrnov_descripcion")String inCrnov_descripcion,
			@WebParam(name="inCrnov_tipo")int inCrnov_tipo
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_novedad_notificacion obj = new com.besixplus.sii.objects.Cgg_res_novedad_notificacion();
		obj.setCRNOV_CODIGO("KEYGEN");
		obj.setCRSEG_CODIGO(inCrseg_codigo);
		obj.setCRNOV_FECHA_REGISTRO(inCrnov_fecha_registro);
		obj.setCRNOV_DESCRIPCION(inCrnov_descripcion);
		obj.setCRNOV_TIPO(inCrnov_tipo);
		obj.setCRNOV_ESTADO(true);
		obj.setCRNOV_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRNOV_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_novedad_notificacion(obj).insert(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_novedad_notificacion EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_res_novedad_notificacion.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_novedad_notificacion EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_res_novedad_notificacion.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_novedad_notificacion.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_novedad_notificacion EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_novedad_notificacion.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_novedad_notificacion.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_novedad_notificacion.
	 * @param inCrnov_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	 * @param inCrnov_fecha_registro FECHA DE REGISTRO DE LA NOVEDAD
	 * @param inCrnov_descripcion DESCRIPCION DE LA NOVEDAD
	 * @param inCrnov_tipo TIPO DE NOVEDAD - NOTIFICACION
0 Comentario
1 Notificacion
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrnov_codigo")String inCrnov_codigo,
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="inCrnov_fecha_registro")java.util.Date inCrnov_fecha_registro,
			@WebParam(name="inCrnov_descripcion")String inCrnov_descripcion,
			@WebParam(name="inCrnov_tipo")int inCrnov_tipo
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_novedad_notificacion obj = new com.besixplus.sii.objects.Cgg_res_novedad_notificacion();
		obj.setCRNOV_CODIGO(inCrnov_codigo);
		obj.setCRSEG_CODIGO(inCrseg_codigo);
		obj.setCRNOV_FECHA_REGISTRO(inCrnov_fecha_registro);
		obj.setCRNOV_DESCRIPCION(inCrnov_descripcion);
		obj.setCRNOV_TIPO(inCrnov_tipo);
		obj.setCRNOV_ESTADO(true);
		obj.setCRNOV_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_novedad_notificacion(obj).update(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_novedad_notificacion EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrnov_codigo crnov_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrnov_codigo")String inCrnov_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_novedad_notificacion tmpObj = new com.besixplus.sii.objects.Cgg_res_novedad_notificacion();
		tmpObj.setCRNOV_CODIGO(inCrnov_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_novedad_notificacion(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_novedad_notificacion.
	 * @param inCrnov_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrnov_codigo")String inCrnov_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_novedad_notificacion tmpObj = new com.besixplus.sii.objects.Cgg_res_novedad_notificacion();
		tmpObj.setCRNOV_CODIGO(inCrnov_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_res_novedad_notificacion(tmpObj).delete(con);
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
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_novedad_notificacion.
	 * @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO.
	 * @param inCrnov_fecha_registro FECHA DE REGISTRO DE LA NOVEDAD.
	 * @param inCrnov_descripcion DESCRIPCION DE LA NOVEDAD.
	 * @param inCrnov_tipo TIPO DE NOVEDAD - NOTIFICACION
0 Comentario
1 Notificacion.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert1(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,			
			@WebParam(name="inCrnov_descripcion")String inCrnov_descripcion,
			@WebParam(name="inCrnov_tipo")int inCrnov_tipo
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_novedad_notificacion obj = new com.besixplus.sii.objects.Cgg_res_novedad_notificacion();
		obj.setCRNOV_CODIGO("KEYGEN");
		obj.setCRSEG_CODIGO(inCrseg_codigo);
		obj.setCRNOV_FECHA_REGISTRO(new Date());
		obj.setCRNOV_DESCRIPCION(inCrnov_descripcion);
		obj.setCRNOV_TIPO(inCrnov_tipo);
		obj.setCRNOV_ESTADO(true);
		obj.setCRNOV_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRNOV_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_novedad_notificacion(obj).insert(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}

	/**
	 * Seleccion la informacion de novedad notificacion recursivamente entre todos los seguimientos padres de este seguimiento.
	 * @param inCrseg_codigo Codigo de seguimiento.
	 * @param format Cadena de datos de formato de salida JSON/XML
	 * @return Cadena de datos en formato especificado.
	 */
	@WebMethod	
	public String selectCGG_RES_SEGUIMIENTO(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="format")String format
	){
//		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
//		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_novedad_notificacion notificacion = new com.besixplus.sii.objects.Cgg_res_novedad_notificacion();
		Cgg_res_seguimiento seguimiento = new Cgg_res_seguimiento();
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		Connection con = null;
		try{
			con = ManagerConnection.getConnection();
//			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
//				con.close();
//				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
//				return null;
//			}	
			con.setAutoCommit(false);
			seguimiento.setCRSEG_CODIGO(inCrseg_codigo);
			seguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(seguimiento).select(con);
			if(seguimiento.getCRSEG_CODIGO() != null &&
				seguimiento.getCRSEG_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
				seguimiento.getCRSEG_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){
				notificacion.setCRSEG_CODIGO(seguimiento.getCRSEG_CODIGO());
				obj = new com.besixplus.sii.db.Cgg_res_novedad_notificacion(notificacion).selectNovedadTramite(con, seguimiento.getCRTRA_CODIGO());
				tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
				outCadena = tmpFormat.getData();
			}else{
				obj = null;
			}
			con.setAutoCommit(true);
			con.close();		
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
//			try {
//				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		if (obj != null)
			return outCadena.toString();
		return null;
	}
	
	/**
	 * Seleccion las novedades de un seguimiento de manera recursiva por el seguimiento. Si el seguimiento tiene un padre la funcion recorre cursivamente hasta el padre para realizar las mismas acciones.
	 * @param inCrseg_codigo Codigo de seguimiento.
	 * @param inConnection Conexion de datos abierta y valida.
	 * @return Coleccion de novedades de seguimiento extraido recurvisamente.
	 */
	@Deprecated
	private ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> selectNovedadNotificacionPadre(
			String inCrseg_codigo,			
			Connection inConnection
			){
		
		ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> colNovedad = null;
		ArrayList<com.besixplus.sii.objects.Cgg_res_novedad_notificacion> colTmpNovedad = null;
		
		Cgg_res_seguimiento objSeguimiento = new Cgg_res_seguimiento();
		objSeguimiento.setCRSEG_CODIGO(inCrseg_codigo);
		objSeguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).select(inConnection);
		if(objSeguimiento != null &&
				objSeguimiento.getCRSEG_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
				objSeguimiento.getCRSEG_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){
			
			com.besixplus.sii.objects.Cgg_res_novedad_notificacion tmpNovedad= new com.besixplus.sii.objects.Cgg_res_novedad_notificacion();
			tmpNovedad.setCRSEG_CODIGO(inCrseg_codigo);
			
			colNovedad = new com.besixplus.sii.db.Cgg_res_novedad_notificacion(tmpNovedad).selectCGG_RES_SEGUIMIENTO1(inConnection);
			
			if(objSeguimiento.getCGG_CRSEG_CODIGO()!=null &&
					objSeguimiento.getCGG_CRSEG_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
					objSeguimiento.getCGG_CRSEG_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){
				colTmpNovedad = this.selectNovedadNotificacionPadre(objSeguimiento.getCGG_CRSEG_CODIGO(), inConnection);				
				colNovedad.addAll(colTmpNovedad);
			}							
		}else{
			colNovedad=null;
		}
		return colNovedad;		
	}

}