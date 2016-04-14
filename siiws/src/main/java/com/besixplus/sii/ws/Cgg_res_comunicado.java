package com.besixplus.sii.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.soap.SOAPFaultException;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;

/**
* CLASE Cgg_res_comunicado
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_comunicado POR MEDIO DE SERVICIOS WEB.
*
* @autor BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_comunicado implements Serializable{

	private static final long serialVersionUID = 959430135;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_comunicado.
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES.
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA REMITENTE DEL COMUNICADO.
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA DESTINATARIO DEL COMUNICADO.
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA REMITENTE DEL COMUNICADO.
	* @param inCrcom_destinatario PERSONA QUE RECIBE DEL COMUNICADO.
	* @param inCrcom_asunto ASUNTO DEL COMUNICADO.
	* @param inCrcom_fecha_recepcion FECHA DE RECEPCION DEL COMUNICADO.
	* @param inCrcom_fecha_revision FECHA DE REVISION .
	* @param inCrcom_numero_documento NUMERO DE DOCUMENTO.
	* @param inCrcom_descripcion DETALLE CORTO DEL COMUNICADO.
	* @param inCrcom_observacion OBSERVACION DEL COMUNICADO.
	* @param inCrcom_descripcion_adjunto DESCRIPCION DEL DOCUMENTO ADJUNTO.
	* @param inCrcom_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO.
	* @param inCrcom_remitente PERSONA QUE EMITE EL COMUNICADO.
	* @param inCrcom_adjunto ARCHIVO DIGITAL ANEXO.
	* @param inCrcom_estado_comunicado ESTADO DE LA OPERACION QUE SE REALIZO CON EL COMUNICADO
0.- REGISTRADO
1.- OTROS
.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCrres_codigo")String inCrres_codigo,
		@WebParam(name="inCrper_codigo")String inCrper_codigo,
		@WebParam(name="inCgg_crper_codigo")String inCgg_crper_codigo,
		@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
		@WebParam(name="inCrcom_destinatario")String inCrcom_destinatario,
		@WebParam(name="inCrcom_asunto")String inCrcom_asunto,
		@WebParam(name="inCrcom_fecha_recepcion")java.util.Date inCrcom_fecha_recepcion,
		@WebParam(name="inCrcom_fecha_revision")java.util.Date inCrcom_fecha_revision,
		@WebParam(name="inCrcom_numero_documento")String inCrcom_numero_documento,
		@WebParam(name="inCrcom_descripcion")String inCrcom_descripcion,
		@WebParam(name="inCrcom_observacion")String inCrcom_observacion,
		@WebParam(name="inCrcom_descripcion_adjunto")String inCrcom_descripcion_adjunto,
		@WebParam(name="inCrcom_nombre_adjunto")String inCrcom_nombre_adjunto,
		@WebParam(name="inCrcom_remitente")String inCrcom_remitente,
		@WebParam(name="inCrcom_adjunto")String inCrcom_adjunto,
		@WebParam(name="inCrcom_estado_comunicado")int inCrcom_estado_comunicado
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_comunicado obj = new com.besixplus.sii.objects.Cgg_res_comunicado();
		obj.setCRCOM_CODIGO("KEYGEN");
		obj.setCRRES_CODIGO(inCrres_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCRCOM_DESTINATARIO(inCrcom_destinatario);
		obj.setCRCOM_ASUNTO(inCrcom_asunto);
		obj.setCRCOM_FECHA_RECEPCION(inCrcom_fecha_recepcion);
		obj.setCRCOM_FECHA_REVISION(inCrcom_fecha_revision);
		obj.setCRCOM_NUMERO_DOCUMENTO(inCrcom_numero_documento);
		obj.setCRCOM_DESCRIPCION(inCrcom_descripcion);
		obj.setCRCOM_OBSERVACION(inCrcom_observacion);
		obj.setCRCOM_DESCRIPCION_ADJUNTO(inCrcom_descripcion_adjunto);
		obj.setCRCOM_NOMBRE_ADJUNTO(inCrcom_nombre_adjunto);
		obj.setCRCOM_REMITENTE(inCrcom_remitente);
		obj.setCRCOM_ADJUNTO(com.besixplus.sii.mail.Base64.decode(inCrcom_adjunto));
		obj.setCRCOM_ESTADO_COMUNICADO(inCrcom_estado_comunicado);
		obj.setCRCOM_ESTADO(true);
		obj.setCRCOM_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRCOM_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_comunicado(obj).insert(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_comunicado EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_comunicado.selectAll(con, tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			return outCadena.toString();
		return null;
	}

	/**
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_comunicado EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	* @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	* @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	* @param keyword CRITERIO DE BUSQUEDA.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectPageDirect(
		@WebParam(name="start")int start,
		@WebParam(name="limit")int limit,
		@WebParam(name="sort")String sort,
		@WebParam(name="dir")String dir,
		@WebParam(name="keyword")String keyword,
		@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_comunicado.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_comunicado.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}


	/**
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_comunicado.
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	* @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA REMITENTE DEL COMUNICADO
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA DESTINATARIO DEL COMUNICADO
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA REMITENTE DEL COMUNICADO
	* @param inCrcom_destinatario PERSONA QUE RECIBE DEL COMUNICADO
	* @param inCrcom_asunto ASUNTO DEL COMUNICADO
	* @param inCrcom_fecha_recepcion FECHA DE RECEPCION DEL COMUNICADO
	* @param inCrcom_fecha_revision FECHA DE REVISION 
	* @param inCrcom_numero_documento NUMERO DE DOCUMENTO
	* @param inCrcom_descripcion DETALLE CORTO DEL COMUNICADO
	* @param inCrcom_observacion OBSERVACION DEL COMUNICADO
	* @param inCrcom_descripcion_adjunto DESCRIPCION DEL DOCUMENTO ADJUNTO
	* @param inCrcom_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	* @param inCrcom_remitente PERSONA QUE EMITE EL COMUNICADO
	* @param inCrcom_adjunto ARCHIVO DIGITAL ANEXO
	* @param inCrcom_estado_comunicado ESTADO DE LA OPERACION QUE SE REALIZO CON EL COMUNICADO
0.- REGISTRADO
1.- OTROS

	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCrcom_codigo")String inCrcom_codigo,
		@WebParam(name="inCrres_codigo")String inCrres_codigo,
		@WebParam(name="inCrper_codigo")String inCrper_codigo,
		@WebParam(name="inCgg_crper_codigo")String inCgg_crper_codigo,
		@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
		@WebParam(name="inCrcom_destinatario")String inCrcom_destinatario,
		@WebParam(name="inCrcom_asunto")String inCrcom_asunto,
		@WebParam(name="inCrcom_fecha_recepcion")java.util.Date inCrcom_fecha_recepcion,
		@WebParam(name="inCrcom_fecha_revision")java.util.Date inCrcom_fecha_revision,
		@WebParam(name="inCrcom_numero_documento")String inCrcom_numero_documento,
		@WebParam(name="inCrcom_descripcion")String inCrcom_descripcion,
		@WebParam(name="inCrcom_observacion")String inCrcom_observacion,
		@WebParam(name="inCrcom_descripcion_adjunto")String inCrcom_descripcion_adjunto,
		@WebParam(name="inCrcom_nombre_adjunto")String inCrcom_nombre_adjunto,
		@WebParam(name="inCrcom_remitente")String inCrcom_remitente,
		@WebParam(name="inCrcom_adjunto")String inCrcom_adjunto,
		@WebParam(name="inCrcom_estado_comunicado")int inCrcom_estado_comunicado
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_comunicado obj = new com.besixplus.sii.objects.Cgg_res_comunicado();
		obj.setCRCOM_CODIGO(inCrcom_codigo);
		obj.setCRRES_CODIGO(inCrres_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCRCOM_DESTINATARIO(inCrcom_destinatario);
		obj.setCRCOM_ASUNTO(inCrcom_asunto);
		obj.setCRCOM_FECHA_RECEPCION(inCrcom_fecha_recepcion);
		obj.setCRCOM_FECHA_REVISION(inCrcom_fecha_revision);
		obj.setCRCOM_NUMERO_DOCUMENTO(inCrcom_numero_documento);
		obj.setCRCOM_DESCRIPCION(inCrcom_descripcion);
		obj.setCRCOM_OBSERVACION(inCrcom_observacion);
		obj.setCRCOM_DESCRIPCION_ADJUNTO(inCrcom_descripcion_adjunto);
		obj.setCRCOM_NOMBRE_ADJUNTO(inCrcom_nombre_adjunto);
		obj.setCRCOM_REMITENTE(inCrcom_remitente);
		obj.setCRCOM_ADJUNTO(com.besixplus.sii.mail.Base64.decode(inCrcom_adjunto));
		obj.setCRCOM_ESTADO_COMUNICADO(inCrcom_estado_comunicado);
		obj.setCRCOM_ESTADO(true);
		obj.setCRCOM_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_comunicado(obj).update(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}


	/**
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_comunicado EN UNA ESTRUCTURA JSON o XML.
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE COMITE.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @throws SOAPException 
	* @return String REGISTRO SELECCIONADO.
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCrcom_codigo")String inCrcom_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_comunicado tmpObj = new com.besixplus.sii.objects.Cgg_res_comunicado();
		tmpObj.setCRCOM_CODIGO(inCrcom_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_comunicado(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_comunicado>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}


	/**
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_res_comunicado.
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCrcom_codigo")String inCrcom_codigo
	) throws SOAPException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_comunicado tmpObj = new com.besixplus.sii.objects.Cgg_res_comunicado();
		tmpObj.setCRCOM_CODIGO(inCrcom_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_comunicado(tmpObj).delete(con);
			con.close();
			if(!outResult.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(outResult, new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}

	/**
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_comunicado EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	* @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	* @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	* @param keyword CRITERIO DE BUSQUEDA.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectPageRemitenteAll(
		@WebParam(name="start")int start,
		@WebParam(name="limit")int limit,
		@WebParam(name="sort")String sort,
		@WebParam(name="dir")String dir,
		@WebParam(name="keyword")String keyword,
		@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_comunicado.selectRemitenteCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_comunicado.selectRemitenteAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}
}