package com.besixplus.sii.ws;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
* CLASE Cgg_res_adjunto
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_adjunto POR MEDIO DE SERVICIOS WEB.
*
* @autor BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_adjunto implements Serializable{

	private static final long serialVersionUID = 1214997617;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_adjunto.
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO PERSONA.
	* @param inCrinf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME.
	* @param inCrnot_codigo IDENTIFICATIVO UNICO DE REGISTRO NOTIFICACION.
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES.
	* @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO GARANTIA.
	* @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO.
	* @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE.
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION.
	* @param inCrrqt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE REQUISITO DE TRAMITE.
	* @param inCradj_contenido DESCRIPCION DEL CONTENIDO DEL ARCHIVO.
	* @param inCradj_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO.
	* @param inCradj_observacion OBSERVACION DEL ARCHIVO ADJUNTO.
	* @param inCradj_archivo_adjunto ARCHIVO DIGITAL ANEXO .
	* @param inCradj_fecha_registro FECHA DE REGISTRO DEL ARCHIVO EN EL SISTEMA.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCrper_codigo")String inCrper_codigo,
		@WebParam(name="inCrinf_codigo")String inCrinf_codigo,
		@WebParam(name="inCrnot_codigo")String inCrnot_codigo,
		@WebParam(name="inCrres_codigo")String inCrres_codigo,
		@WebParam(name="inCrdpt_codigo")String inCrdpt_codigo,
		@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
		@WebParam(name="inCrtpt_codigo")String inCrtpt_codigo,
		@WebParam(name="inCrssc_codigo")String inCrssc_codigo,
		@WebParam(name="inCrrqt_codigo")String inCrrqt_codigo,
		@WebParam(name="inCradj_contenido")String inCradj_contenido,
		@WebParam(name="inCradj_nombre_adjunto")String inCradj_nombre_adjunto,
		@WebParam(name="inCradj_observacion")String inCradj_observacion,
		@WebParam(name="inCradj_archivo_adjunto")String inCradj_archivo_adjunto,
		@WebParam(name="inCradj_fecha_registro")java.util.Date inCradj_fecha_registro
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_adjunto obj = new com.besixplus.sii.objects.Cgg_res_adjunto();
		obj.setCRADJ_CODIGO("KEYGEN");
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRINF_CODIGO(inCrinf_codigo);
		obj.setCRNOT_CODIGO(inCrnot_codigo);
		obj.setCRRES_CODIGO(inCrres_codigo);
		obj.setCRDPT_CODIGO(inCrdpt_codigo);
		obj.setCRSEG_CODIGO(inCrseg_codigo);
		obj.setCRTPT_CODIGO(inCrtpt_codigo);
		obj.setCRSSC_CODIGO(inCrssc_codigo);
		obj.setCRRQT_CODIGO(inCrrqt_codigo);
		obj.setCRADJ_CONTENIDO(inCradj_contenido);
		obj.setCRADJ_NOMBRE_ADJUNTO(inCradj_nombre_adjunto);
		obj.setCRADJ_OBSERVACION(inCradj_observacion);
		obj.setCRADJ_ARCHIVO_ADJUNTO(org.jboss.util.Base64.decode(inCradj_archivo_adjunto));
		obj.setCRADJ_FECHA_REGISTRO(inCradj_fecha_registro);
		obj.setCRADJ_ESTADO(true);
		obj.setCRADJ_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRADJ_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_adjunto(obj).insert(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_adjunto EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_res_adjunto.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_adjunto EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_adjunto.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_adjunto.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_adjunto.
	* @param inCradj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO PERSONA
	* @param inCrinf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
	* @param inCrnot_codigo IDENTIFICATIVO UNICO DE REGISTRO NOTIFICACION
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO GARANTIA
	* @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	* @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	* @param inCrrqt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE REQUISITO DE TRAMITE
	* @param inCradj_contenido DESCRIPCION DEL CONTENIDO DEL ARCHIVO
	* @param inCradj_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCradj_observacion OBSERVACION DEL ARCHIVO ADJUNTO
	* @param inCradj_archivo_adjunto ARCHIVO DIGITAL ANEXO 
	* @param inCradj_fecha_registro FECHA DE REGISTRO DEL ARCHIVO EN EL SISTEMA
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCradj_codigo")String inCradj_codigo,
		@WebParam(name="inCrper_codigo")String inCrper_codigo,
		@WebParam(name="inCrinf_codigo")String inCrinf_codigo,
		@WebParam(name="inCrnot_codigo")String inCrnot_codigo,
		@WebParam(name="inCrres_codigo")String inCrres_codigo,
		@WebParam(name="inCrdpt_codigo")String inCrdpt_codigo,
		@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
		@WebParam(name="inCrtpt_codigo")String inCrtpt_codigo,
		@WebParam(name="inCrssc_codigo")String inCrssc_codigo,
		@WebParam(name="inCrrqt_codigo")String inCrrqt_codigo,
		@WebParam(name="inCradj_contenido")String inCradj_contenido,
		@WebParam(name="inCradj_nombre_adjunto")String inCradj_nombre_adjunto,
		@WebParam(name="inCradj_observacion")String inCradj_observacion,
		@WebParam(name="inCradj_archivo_adjunto")String inCradj_archivo_adjunto,
		@WebParam(name="inCradj_fecha_registro")java.util.Date inCradj_fecha_registro
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_adjunto obj = new com.besixplus.sii.objects.Cgg_res_adjunto();
		obj.setCRADJ_CODIGO(inCradj_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRINF_CODIGO(inCrinf_codigo);
		obj.setCRNOT_CODIGO(inCrnot_codigo);
		obj.setCRRES_CODIGO(inCrres_codigo);
		obj.setCRDPT_CODIGO(inCrdpt_codigo);
		obj.setCRSEG_CODIGO(inCrseg_codigo);
		obj.setCRTPT_CODIGO(inCrtpt_codigo);
		obj.setCRSSC_CODIGO(inCrssc_codigo);
		obj.setCRRQT_CODIGO(inCrrqt_codigo);
		obj.setCRADJ_CONTENIDO(inCradj_contenido);
		obj.setCRADJ_NOMBRE_ADJUNTO(inCradj_nombre_adjunto);
		obj.setCRADJ_OBSERVACION(inCradj_observacion);
		obj.setCRADJ_ARCHIVO_ADJUNTO(org.jboss.util.Base64.decode(inCradj_archivo_adjunto));
		obj.setCRADJ_FECHA_REGISTRO(inCradj_fecha_registro);
		obj.setCRADJ_ESTADO(true);
		obj.setCRADJ_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_adjunto(obj).update(con);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_adjunto EN UNA ESTRUCTURA JSON o XML.
	* @param inCradj_codigo IDENTIFICATIVO UNICO DE ADJUNTO.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return String REGISTRO SELECCIONADO.
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCradj_codigo")String inCradj_codigo,
		@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_adjunto tmpObj = new com.besixplus.sii.objects.Cgg_res_adjunto();
		tmpObj.setCRADJ_CODIGO(inCradj_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_adjunto(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto>();
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
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_res_adjunto QUE ESTAN ASOCIADOS CON VEHICULO.
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return String REGISTRO SELECCIONADO.
	*/
	@WebMethod
	public String selectCGG_VEH_VEHICULO(
		@WebParam(name="inCvveh_codigo")String inCvveh_codigo,
		@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_adjunto tmpObj = new com.besixplus.sii.objects.Cgg_res_adjunto();
		tmpObj.setCVVEH_CODIGO(inCvveh_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			ArrayList<LinkedHashMap<String, Object>> tmpArray = new com.besixplus.sii.db.Cgg_res_adjunto(tmpObj).selectCGG_VEH_VEHICULO(con);
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_res_adjunto.
	* @param inCradj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCradj_codigo")String inCradj_codigo
	) throws SOAPException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_adjunto tmpObj = new com.besixplus.sii.objects.Cgg_res_adjunto();
		tmpObj.setCRADJ_CODIGO(inCradj_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_adjunto(tmpObj).delete(con);
			con.close();
			if(!outResult.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(outResult, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}

	/**
	 * Selecciona todos los registro de la tabla adjunto en base a su clave foranea de la tabla seguimiento de manera recursiva.
	 * La recursividad a este punto selecciona todos los adjuntos del seguimiento actual y de los seguimientos padres de este seguimiento. Si el seguimiento padre tiene padre entonces la recursivida alcanza todos esos padres hasta llegar al nodo inicial recogiendo todos los adjuntos encontrados.
	 * @param inCrseg_codigo Codigo de seguimiento.
	 * @param format Cadena de datos del formato deseado de salida de la consulta.
	 * @return Cadena de datos en formato establecido.
	 */
	@WebMethod
	public String selectCGG_RES_SEGUIMIENTO1(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="format")String format
	){
				HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
				HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_adjunto objAdjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
		Cgg_res_seguimiento seguimiento = new Cgg_res_seguimiento();
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
			
			seguimiento.setCRSEG_CODIGO(inCrseg_codigo);
			seguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(seguimiento).select(con);
			if(seguimiento.getCRSEG_CODIGO() != null &&
				seguimiento.getCRSEG_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
				seguimiento.getCRSEG_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){
				objAdjunto.setCRSEG_CODIGO(seguimiento.getCRSEG_CODIGO());
				obj = new com.besixplus.sii.db.Cgg_res_adjunto(objAdjunto).selectAdjuntoTramite(con, seguimiento.getCRTRA_CODIGO());
				tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
				outCadena = tmpFormat.getData();
			}else{
				obj = null;
			}					
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
	 * Seleccion los adjuntos de un seguimiento de manera recursiva por el seguimiento. Si el seguimiento tiene un padre la funcion recorre cursivamente hasta el padre para realizar las mismas acciones.
	 * @param inCrseg_codigo Codigo de seguimiento.
	 * @param inConnection Conexion de datos abierta y valida.
	 * @return Coleccion de adjuntos de seguimiento extraido recurvisamente.
	 */
	@Deprecated
	private ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> selectAdjuntoPadre(
			String inCrseg_codigo,			
			Connection inConnection
	){

		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> colNovedad = null;
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> colTmpNovedad = null;

		Cgg_res_seguimiento objSeguimiento = new Cgg_res_seguimiento();
		objSeguimiento.setCRSEG_CODIGO(inCrseg_codigo);
		objSeguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).select(inConnection);
		if(objSeguimiento != null &&
				objSeguimiento.getCRSEG_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
				objSeguimiento.getCRSEG_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

			com.besixplus.sii.objects.Cgg_res_adjunto tmpAdjunto= new com.besixplus.sii.objects.Cgg_res_adjunto();
			tmpAdjunto.setCRSEG_CODIGO(inCrseg_codigo);

			colNovedad = new com.besixplus.sii.db.Cgg_res_adjunto(tmpAdjunto).selectCGG_RES_SEGUIMIENTO1(inConnection);

			if(objSeguimiento.getCGG_CRSEG_CODIGO()!=null &&
					objSeguimiento.getCGG_CRSEG_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
					objSeguimiento.getCGG_CRSEG_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){
				colTmpNovedad = this.selectAdjuntoPadre(objSeguimiento.getCGG_CRSEG_CODIGO(), inConnection);				
				colNovedad.addAll(colTmpNovedad);
			}							
		}else{
			colNovedad=null;
		}
		return colNovedad;		
	}
	
	
	

}