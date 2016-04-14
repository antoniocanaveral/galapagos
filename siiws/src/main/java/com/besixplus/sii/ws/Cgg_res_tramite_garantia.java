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
* CLASE Cgg_res_tramite_garantia
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_tramite_garantia POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_tramite_garantia implements Serializable{

	private static final long serialVersionUID = 517870110;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_tramite_garantia.
	* @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA.
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE.
	* @param inCrgrt_codigo CODIGO IDENTIFICATIVO DE REGISTRO.
	* @param inCrtgr_fecha_soli_devol FECHA CUANDO SE SOLICITO LA DEVOLUCION DE LA GARANTIA.
	* @param inCrtgr_fecha_devolucion FECHA CUANDO SE HIZO EFECTIVA LA DEVOLUCION.
	* @param inCrtgr_devuelto SI LA GARANTIA ESTA DEVUELTA.
	* @param inCrtgr_estado_asignacion ESTADO DE LA ASIGNACION DE LA GARANTIA AL TRAMITE.
0 - ASIGNADO
1 - AUTORIZADO DEVOLUCION
2 - DEVUELTO.
	* @param inCrtgr_fecha_insert FECHA DE CREACION DEL REGISTRO.
	* @param inCrtgr_usuario_insert USUARIO QUE CREO EL REGISTRO.
	* @param inCrtgr_fecha_update FECHA DE ACTUALIZACION DEL REGISTRO.
	* @param inCrtgr_usuario_update USUARIO QUE ACTUALIZO EL REGISTRO.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCrdpt_codigo")String inCrdpt_codigo,
		@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
		@WebParam(name="inCrgrt_codigo")String inCrgrt_codigo,
		@WebParam(name="inCrtgr_fecha_soli_devol")java.util.Date inCrtgr_fecha_soli_devol,
		@WebParam(name="inCrtgr_fecha_devolucion")java.util.Date inCrtgr_fecha_devolucion,
		@WebParam(name="inCrtgr_devuelto")boolean inCrtgr_devuelto,
		@WebParam(name="inCrtgr_estado_asignacion")int inCrtgr_estado_asignacion,
		@WebParam(name="inCrtgr_fecha_insert")java.util.Date inCrtgr_fecha_insert,
		@WebParam(name="inCrtgr_usuario_insert")String inCrtgr_usuario_insert,
		@WebParam(name="inCrtgr_fecha_update")java.util.Date inCrtgr_fecha_update,
		@WebParam(name="inCrtgr_usuario_update")String inCrtgr_usuario_update
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tramite_garantia obj = new com.besixplus.sii.objects.Cgg_res_tramite_garantia();
		obj.setCRTGR_CODIGO("KEYGEN");
		obj.setCRDPT_CODIGO(inCrdpt_codigo);
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCRGRT_CODIGO(inCrgrt_codigo);
		obj.setCRTGR_FECHA_SOLI_DEVOL(inCrtgr_fecha_soli_devol);
		obj.setCRTGR_FECHA_DEVOLUCION(inCrtgr_fecha_devolucion);
		obj.setCRTGR_DEVUELTO(inCrtgr_devuelto);
		obj.setCRTGR_ESTADO_ASIGNACION(inCrtgr_estado_asignacion);
		obj.setCRTGR_ESTADO(true);
		obj.setCRTGR_USUARIO_INSERT(inCrtgr_usuario_insert);
		obj.setCRTGR_USUARIO_UPDATE(inCrtgr_usuario_update);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_tramite_garantia(obj).insert(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tramite_garantia EN UNA ESTRUCTRA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_tramite_garantia.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_tramite_garantia EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_tramite_garantia.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_tramite_garantia.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_tramite_garantia.
	* @param inCrtgr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE GARANTIA
	* @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @param inCrgrt_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	* @param inCrtgr_fecha_soli_devol FECHA CUANDO SE SOLICITO LA DEVOLUCION DE LA GARANTIA
	* @param inCrtgr_fecha_devolucion FECHA CUANDO SE HIZO EFECTIVA LA DEVOLUCION
	* @param inCrtgr_devuelto SI LA GARANTIA ESTA DEVUELTA
	* @param inCrtgr_estado_asignacion ESTADO DE LA ASIGNACION DE LA GARANTIA AL TRAMITE.
0 - ASIGNADO
1 - AUTORIZADO DEVOLUCION
2 - DEVUELTO
	* @param inCrtgr_fecha_insert FECHA DE CREACION DEL REGISTRO
	* @param inCrtgr_usuario_insert USUARIO QUE CREO EL REGISTRO
	* @param inCrtgr_fecha_update FECHA DE ACTUALIZACION DEL REGISTRO
	* @param inCrtgr_usuario_update USUARIO QUE ACTUALIZO EL REGISTRO
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCrtgr_codigo")String inCrtgr_codigo,
		@WebParam(name="inCrdpt_codigo")String inCrdpt_codigo,
		@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
		@WebParam(name="inCrgrt_codigo")String inCrgrt_codigo,
		@WebParam(name="inCrtgr_fecha_soli_devol")java.util.Date inCrtgr_fecha_soli_devol,
		@WebParam(name="inCrtgr_fecha_devolucion")java.util.Date inCrtgr_fecha_devolucion,
		@WebParam(name="inCrtgr_devuelto")boolean inCrtgr_devuelto,
		@WebParam(name="inCrtgr_estado_asignacion")int inCrtgr_estado_asignacion,
		@WebParam(name="inCrtgr_fecha_insert")java.util.Date inCrtgr_fecha_insert,
		@WebParam(name="inCrtgr_usuario_insert")String inCrtgr_usuario_insert,
		@WebParam(name="inCrtgr_fecha_update")java.util.Date inCrtgr_fecha_update,
		@WebParam(name="inCrtgr_usuario_update")String inCrtgr_usuario_update
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tramite_garantia obj = new com.besixplus.sii.objects.Cgg_res_tramite_garantia();
		obj.setCRTGR_CODIGO(inCrtgr_codigo);
		obj.setCRDPT_CODIGO(inCrdpt_codigo);
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCRGRT_CODIGO(inCrgrt_codigo);
		obj.setCRTGR_FECHA_SOLI_DEVOL(inCrtgr_fecha_soli_devol);
		obj.setCRTGR_FECHA_DEVOLUCION(inCrtgr_fecha_devolucion);
		obj.setCRTGR_DEVUELTO(inCrtgr_devuelto);
		obj.setCRTGR_ESTADO_ASIGNACION(inCrtgr_estado_asignacion);
		obj.setCRTGR_ESTADO(true);
		obj.setCRTGR_USUARIO_UPDATE(inCrtgr_usuario_update);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_tramite_garantia(obj).update(con);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_tramite_garantia EN UNA ESTRUCTURA JSON o XML.
	* @param inCrtgr_codigo crtgr_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCrtgr_codigo")String inCrtgr_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tramite_garantia tmpObj = new com.besixplus.sii.objects.Cgg_res_tramite_garantia();
		tmpObj.setCRTGR_CODIGO(inCrtgr_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_tramite_garantia(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_tramite_garantia>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_res_tramite_garantia.
	* @param inCrtgr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE GARANTIA
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCrtgr_codigo")String inCrtgr_codigo
	) throws SOAPException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tramite_garantia tmpObj = new com.besixplus.sii.objects.Cgg_res_tramite_garantia();
		tmpObj.setCRTGR_CODIGO(inCrtgr_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_tramite_garantia(tmpObj).delete(con);
			con.close();
			if(!outResult.equals("true")){
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(outResult, new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}
	
	/**
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_tramite_garantia EN UNA ESTRUCTURA JSON o XML.
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE 
	* @param inCrtgr_codigo crtgr_codigo
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectPendientes(
		@WebParam(name="inCrtra_codigo")String inCrtra_codigo
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		int outResult = 0;
		com.besixplus.sii.objects.Cgg_res_tramite_garantia tmpObj = new com.besixplus.sii.objects.Cgg_res_tramite_garantia();
		tmpObj.setCRTRA_CODIGO(inCrtra_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_tramite_garantia(tmpObj).selectPendientes(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return String.valueOf(outResult);
	}

	/**
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_tramite_garantia EN UNA ESTRUCTURA JSON o XML.
	* @param inCrdpt_codigo inCrdpt_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).  
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectCGG_RES_DEPOSITO_GARANTIA(
		@WebParam(name="inCrdpt_codigo")String inCrdpt_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tramite_garantia tmpObj = new com.besixplus.sii.objects.Cgg_res_tramite_garantia();
		tmpObj.setCRDPT_CODIGO(inCrdpt_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			ArrayList<HashMap<String,Object>> tmpArray = new com.besixplus.sii.db.Cgg_res_tramite_garantia(tmpObj).selectCGG_RES_DEPOSITO_GARANTIA(con);
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
	 * Selecciona las garantias de un tramite.
	 * @param inCrtra_codigo Codigo de tramite.
	 * @param format Tipo de formato de salida JSON/XML.
	 * @return Cadena de datos en formato especificado.
	 * @throws SOAPException
	 */
	@WebMethod
	public String selectCGG_RES_TRAMITE_GARANTIA(
		@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tramite_garantia tmpObj = new com.besixplus.sii.objects.Cgg_res_tramite_garantia();
		tmpObj.setCRTRA_CODIGO(inCrtra_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			ArrayList<HashMap<String,Object>> tmpArray = new com.besixplus.sii.db.Cgg_res_tramite_garantia(tmpObj).selectCGG_RES_TRAMITE_GARANTIA(con);
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
	
}