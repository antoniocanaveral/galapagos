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
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.misc.CGGEnumerators;
import com.besixplus.sii.misc.CGGEnumerators.LONGITUDCLAVEPRIMARIA;
import com.besixplus.sii.objects.Cgg_res_seguimiento;

/**
 * CLASE Cgg_res_informe_seguimiento
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_informe_seguimiento POR MEDIO DE SERVICIOS WEB.
 *
 * @autor BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_informe_seguimiento implements Serializable{

	private static final long serialVersionUID = 678251558;

	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_informe_seguimiento.
	 * @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO.
	 * @param inCrsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SECCION.
	 * @param inCrise_numero_informe NUMERO DE INFORME DE SEGUIMIENTO DE RESPUESTA AL SEGUIMIENTO.
	 * @param inCrise_fecha_informe FECHA DE REALIZACION DEL INFORME DE SEGUIMIENTO.
	 * @param inCrise_asunto_informe ASUNTO DEL INFORME SE SEGUIMIENTO.
	 * @param inCrise_extracto_informe RESUMEN DEL CONTENIDO DEL INFORME DE SEGUIMIENTO.
	 * @param inCrise_descripcion_adjunto DESCRIPCION DE LOS DOCUMENTOS DIGITALIZADOS ADJUNTOS EN EL SEGUIMIENTO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="inCrsec_codigo")String inCrsec_codigo,
			@WebParam(name="inCrise_numero_informe")String inCrise_numero_informe,
			@WebParam(name="inCrise_fecha_informe")java.util.Date inCrise_fecha_informe,
			@WebParam(name="inCrise_asunto_informe")String inCrise_asunto_informe,
			@WebParam(name="inCrise_extracto_informe")String inCrise_extracto_informe,
			@WebParam(name="inCrise_descripcion_adjunto")String inCrise_descripcion_adjunto
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_informe_seguimiento obj = new com.besixplus.sii.objects.Cgg_res_informe_seguimiento();
		obj.setCRISE_CODIGO("KEYGEN");
		obj.setCRSEG_CODIGO(inCrseg_codigo);
		obj.setCRSEC_CODIGO(inCrsec_codigo);
		obj.setCRISE_NUMERO_INFORME(inCrise_numero_informe);
		obj.setCRISE_FECHA_INFORME(inCrise_fecha_informe);
		obj.setCRISE_ASUNTO_INFORME(inCrise_asunto_informe);
		obj.setCRISE_EXTRACTO_INFORME(inCrise_extracto_informe);
		obj.setCRISE_DESCRIPCION_ADJUNTO(inCrise_descripcion_adjunto);
		obj.setCRISE_ESTADO(true);
		obj.setCRISE_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRISE_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_informe_seguimiento(obj).insert(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_informe_seguimiento EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_res_informe_seguimiento.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_informe_seguimiento EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_res_informe_seguimiento.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_informe_seguimiento.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_informe_seguimiento EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_informe_seguimiento.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_informe_seguimiento.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_informe_seguimiento.
	 * @param inCrise_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME DE SEGUIMIENTO
	 * @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	 * @param inCrsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SECCION
	 * @param inCrise_numero_informe NUMERO DE INFORME DE SEGUIMIENTO DE RESPUESTA AL SEGUIMIENTO
	 * @param inCrise_fecha_informe FECHA DE REALIZACION DEL INFORME DE SEGUIMIENTO
	 * @param inCrise_asunto_informe ASUNTO DEL INFORME SE SEGUIMIENTO
	 * @param inCrise_extracto_informe RESUMEN DEL CONTENIDO DEL INFORME DE SEGUIMIENTO
	 * @param inCrise_descripcion_adjunto DESCRIPCION DE LOS DOCUMENTOS DIGITALIZADOS ADJUNTOS EN EL SEGUIMIENTO
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrise_codigo")String inCrise_codigo,
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="inCrsec_codigo")String inCrsec_codigo,
			@WebParam(name="inCrise_numero_informe")String inCrise_numero_informe,
			@WebParam(name="inCrise_fecha_informe")java.util.Date inCrise_fecha_informe,
			@WebParam(name="inCrise_asunto_informe")String inCrise_asunto_informe,
			@WebParam(name="inCrise_extracto_informe")String inCrise_extracto_informe,
			@WebParam(name="inCrise_descripcion_adjunto")String inCrise_descripcion_adjunto
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_informe_seguimiento obj = new com.besixplus.sii.objects.Cgg_res_informe_seguimiento();
		obj.setCRISE_CODIGO(inCrise_codigo);
		obj.setCRSEG_CODIGO(inCrseg_codigo);
		obj.setCRSEC_CODIGO(inCrsec_codigo);
		obj.setCRISE_NUMERO_INFORME(inCrise_numero_informe);
		obj.setCRISE_FECHA_INFORME(inCrise_fecha_informe);
		obj.setCRISE_ASUNTO_INFORME(inCrise_asunto_informe);
		obj.setCRISE_EXTRACTO_INFORME(inCrise_extracto_informe);
		obj.setCRISE_DESCRIPCION_ADJUNTO(inCrise_descripcion_adjunto);
		obj.setCRISE_ESTADO(true);
		obj.setCRISE_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_informe_seguimiento(obj).update(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_informe_seguimiento EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrise_codigo crise_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrise_codigo")String inCrise_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_informe_seguimiento tmpObj = new com.besixplus.sii.objects.Cgg_res_informe_seguimiento();
		tmpObj.setCRISE_CODIGO(inCrise_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_informe_seguimiento(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_informe_seguimiento.
	 * @param inCrise_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME DE SEGUIMIENTO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrise_codigo")String inCrise_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_informe_seguimiento tmpObj = new com.besixplus.sii.objects.Cgg_res_informe_seguimiento();
		tmpObj.setCRISE_CODIGO(inCrise_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_res_informe_seguimiento(tmpObj).delete(con);
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
	 * Seleccion la informacion de informe de seguimiento recursivamente entre todos los seguimientos padres de este seguimiento.
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
		ArrayList<HashMap<String,Object>> obj = null;
		Cgg_res_seguimiento seguimiento = new Cgg_res_seguimiento();
		com.besixplus.sii.objects.Cgg_res_informe_seguimiento informe = new com.besixplus.sii.objects.Cgg_res_informe_seguimiento();
		
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		Connection con =null;
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
				informe.setCRSEG_CODIGO(seguimiento.getCRSEG_CODIGO());
				obj = new com.besixplus.sii.db.Cgg_res_informe_seguimiento(informe).selectInformeTramite(con, seguimiento.getCRTRA_CODIGO());
				tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
				outCadena = tmpFormat.getData();
			}else{
				obj = null;
			}
			con.close();
		}catch(SQLException inException){
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
	 * Seleccion los informes de un seguimiento de manera recursiva por el seguimiento. Si el seguimiento tiene un padre la funcion recorre cursivamente hasta el padre para realizar las mismas acciones.
	 * @param inCrseg_codigo Codigo de seguimiento.
	 * @param inConnection Conexion de datos abierta y valida.
	 * @return Coleccion de informes de seguimiento extraido recurvisamente.
	 */
	@SuppressWarnings("unused")
	private ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> selectInformePadre(
			String inCrseg_codigo,			
			Connection inConnection
			){
		
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> colNovedad = null;
		ArrayList<com.besixplus.sii.objects.Cgg_res_informe_seguimiento> colTmpNovedad = null;
		
		Cgg_res_seguimiento objSeguimiento = new Cgg_res_seguimiento();
		objSeguimiento.setCRSEG_CODIGO(inCrseg_codigo);
		objSeguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).select(inConnection);
		if(objSeguimiento != null &&
				objSeguimiento.getCRSEG_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
				objSeguimiento.getCRSEG_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){
			
			com.besixplus.sii.objects.Cgg_res_informe_seguimiento tmpInforme= new com.besixplus.sii.objects.Cgg_res_informe_seguimiento();
			tmpInforme.setCRSEG_CODIGO(inCrseg_codigo);
			
			colNovedad = new com.besixplus.sii.db.Cgg_res_informe_seguimiento(tmpInforme).selectCGG_RES_SEGUIMIENTO1(inConnection);
			
			if(objSeguimiento.getCGG_CRSEG_CODIGO()!=null &&
					objSeguimiento.getCGG_CRSEG_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
					objSeguimiento.getCGG_CRSEG_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){
				colTmpNovedad = this.selectInformePadre(objSeguimiento.getCGG_CRSEG_CODIGO(), inConnection);				
				colNovedad.addAll(colTmpNovedad);
			}							
		}else{
			colNovedad=null;
		}
		return colNovedad;		
	}


}