package com.besixplus.sii.ws;

import java.util.ArrayList;
import java.util.HashMap;
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
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import org.json.JSONException;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;

/**
 * CLASE Cgg_res_comite
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_comite POR MEDIO DE SERVICIOS WEB.
 *
 * @autor BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_comite implements Serializable{

	private static final long serialVersionUID = 1602485358;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_comite.
	 * @param inCrcom_nombre NOMBRE DEL COMITE.
	 * @param inCrcom_descripcion DESCRIPCION DEL COMITE.
	 * @param inTramiteComite IDENTIFICACION DE LOS TRAMITES DE COMITE.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrcom_nombre")String inCrcom_nombre,
			@WebParam(name="inCrcom_descripcion")String inCrcom_descripcion,
			@WebParam(name="inCrcom_abreviatura")String inCrcom_abreviatura,
			@WebParam(name="inTramiteComite")String inTramiteComite
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_comite obj = new com.besixplus.sii.objects.Cgg_res_comite();
		obj.setCRCOM_CODIGO("KEYGEN");
		obj.setCRCOM_NOMBRE(inCrcom_nombre);
		obj.setCRCOM_DESCRIPCION(inCrcom_descripcion);
		obj.setCRCOM_ABREVIATURA(inCrcom_abreviatura);
		obj.setCRCOM_ESTADO(true);
		obj.setCRCOM_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRCOM_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			con.setAutoCommit(false);
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_comite(obj).insert(con);
			if (res.equals("true")){
				org.json.JSONArray tmpTSTArray = new org.json.JSONArray(inTramiteComite);
				com.besixplus.sii.objects.Cgg_res_tramite_comite tmpObjTramiteComite;
				for (int i = 0 ; i < tmpTSTArray.length(); i++){
					tmpObjTramiteComite = new com.besixplus.sii.objects.Cgg_res_tramite_comite();
					tmpObjTramiteComite.setCRTRC_CODIGO("KEYGEN");
					tmpObjTramiteComite.setCRTST_CODIGO(((org.json.JSONObject)tmpTSTArray.get(i)).get("CRTST_CODIGO").toString());	
					tmpObjTramiteComite.setCRCOM_CODIGO(obj.getCRCOM_CODIGO());	
					tmpObjTramiteComite.setCRTRC_ESTADO(true);
					tmpObjTramiteComite.setCRTRC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					tmpObjTramiteComite.setCRTRC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_res_tramite_comite(tmpObjTramiteComite).insert(con);
					if(!res.equals("true"))
						break;
				}
			}
			if(res.equals("true"))
				con.commit();
			else
				con.rollback();
			con.setAutoCommit(true);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(res).toString();
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_comite EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_comite> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_comite.selectAll(con, tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			return outCadena.toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_comite EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPage(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String, Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_comite.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_comite.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}


	/**
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_comite.
	 * @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCrcom_nombre NOMBRE DEL COMITE
	 * @param inCrcom_descripcion DESCRIPCION DEL COMITE.
	 * @param inTramiteComite IDENTIFICATIVO DE TRAMITES DE COMITE.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrcom_codigo")String inCrcom_codigo,
			@WebParam(name="inCrcom_nombre")String inCrcom_nombre,
			@WebParam(name="inCrcom_descripcion")String inCrcom_descripcion,
			@WebParam(name="inCrcom_abreviatura")String inCrcom_abreviatura,
			@WebParam(name="inTramiteComite")String inTramiteComite
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_comite obj = new com.besixplus.sii.objects.Cgg_res_comite();
		obj.setCRCOM_CODIGO(inCrcom_codigo);
		obj.setCRCOM_NOMBRE(inCrcom_nombre);
		obj.setCRCOM_DESCRIPCION(inCrcom_descripcion);
		obj.setCRCOM_ABREVIATURA(inCrcom_abreviatura);
		obj.setCRCOM_ESTADO(true);
		obj.setCRCOM_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_res_comite(obj).update(con);
			if (res.equals("true")){
				org.json.JSONArray tmpTramiteComite = new org.json.JSONArray(inTramiteComite);
				com.besixplus.sii.objects.Cgg_res_tramite_comite obj_Tramite = new com.besixplus.sii.objects.Cgg_res_tramite_comite();
				obj_Tramite.setCRCOM_CODIGO(inCrcom_codigo);
				res = new com.besixplus.sii.db.Cgg_res_tramite_comite(obj_Tramite).deleteCGG_RES_COMITE(con, false);
				com.besixplus.sii.objects.Cgg_res_tramite_comite tmpObjTramiteComite;
				for (int i = 0 ; i < tmpTramiteComite.length(); i++){
					tmpObjTramiteComite = new com.besixplus.sii.objects.Cgg_res_tramite_comite();
					tmpObjTramiteComite.setCRTRC_CODIGO("KEYGEN");
					tmpObjTramiteComite.setCRTST_CODIGO(((org.json.JSONObject)tmpTramiteComite.get(i)).get("CRTST_CODIGO").toString());	
					tmpObjTramiteComite.setCRCOM_CODIGO(obj.getCRCOM_CODIGO());	
					tmpObjTramiteComite.setCRTRC_ESTADO(true);
					tmpObjTramiteComite.setCRTRC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					tmpObjTramiteComite.setCRTRC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_res_tramite_comite(tmpObjTramiteComite).insert(con);
					if(!res.equals("true"))
						break;
				}				
			}
			if(res.equals("true")){
				con.commit();
			}else{
				con.rollback();
			}
			con.setAutoCommit(true);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(res).toString();
	}


	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_comite EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrcom_codigo IDENTIFICATIVO UNICO DE COMITE.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrcom_codigo")String inCrcom_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_comite tmpObj = new com.besixplus.sii.objects.Cgg_res_comite();
		tmpObj.setCRCOM_CODIGO(inCrcom_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_comite(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_comite> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_comite>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_comite.
	 * @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrcom_codigo")String inCrcom_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_comite tmpObj = new com.besixplus.sii.objects.Cgg_res_comite();
		tmpObj.setCRCOM_CODIGO(inCrcom_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_comite(tmpObj).delete(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.	
	 * @param inCrcom_codigo IDENTIFICATIVO DE COMITE Y CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectSolicitud_Tramite(
			@WebParam(name="inCrcom_codigo")String inCrcom_codigo,
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
			con.setAutoCommit(!ManagerConnection.isDeployed());
			com.besixplus.sii.objects.Cgg_res_comite tmpC = new com.besixplus.sii.objects.Cgg_res_comite();
			tmpC.setCRCOM_CODIGO(inCrcom_codigo);	
			obj = new com.besixplus.sii.db.Cgg_res_comite(tmpC).selectCGG_RES_TIPO_SOLICITUD_TRAMITE(con,inCrcom_codigo);			
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}

}