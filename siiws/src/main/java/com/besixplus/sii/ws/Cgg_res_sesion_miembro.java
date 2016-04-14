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
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;

/**
* CLASE Cgg_res_sesion_miembro
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_sesion_miembro POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_sesion_miembro implements Serializable{

	private static final long serialVersionUID = 920668869;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_sesion_miembro.
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION.
	* @param inCrmbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO ASISTENTE.
	* @param inCgg_crmbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO TITULAR .
	* @param inCrsmb_presidente DETERMINAR EL PRESIDENTE DE LA SESION.
	* @param inCrsmb_presente DETERMINA SI EL MIEMBRO SE ENCUENTRA PRESENTE EN LA SESION.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCrssc_codigo")String inCrssc_codigo,
		@WebParam(name="inCrmbc_codigo")String inCrmbc_codigo,
		@WebParam(name="inCgg_crmbc_codigo")String inCgg_crmbc_codigo,
		@WebParam(name="inCrsmb_presidente")boolean inCrsmb_presidente,
		@WebParam(name="inCrsmb_presente")boolean inCrsmb_presente
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_sesion_miembro obj = new com.besixplus.sii.objects.Cgg_res_sesion_miembro();
		obj.setCRSMB_CODIGO("KEYGEN");
		obj.setCRSSC_CODIGO(inCrssc_codigo);
		obj.setCRMBC_CODIGO(inCrmbc_codigo);
		obj.setCGG_CRMBC_CODIGO(inCgg_crmbc_codigo);
		obj.setCRSMB_PRESIDENTE(inCrsmb_presidente);
		obj.setCRSMB_PRESENTE(inCrsmb_presente);
		obj.setCRSMB_ESTADO(true);
		obj.setCRSMB_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRSMB_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_sesion_miembro(obj).insert(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return res;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_sesion_miembro EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_res_sesion_miembro.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_sesion_miembro EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	* @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	* @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	* @param keyword CRITERIO DE BUSQUEDA.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMITE 
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	@WebMethod
	public String selectPage(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCrcom_codigo")String inCrcom_codigo
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
				tmpCount = com.besixplus.sii.db.Cgg_res_sesion_miembro.selectCount(con, keyword,inCrcom_codigo);
				con.setAutoCommit(!ManagerConnection.isDeployed());
				obj = com.besixplus.sii.db.Cgg_res_sesion_miembro.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inCrcom_codigo);
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_sesion_miembro EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_sesion_miembro.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_sesion_miembro.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_sesion_miembro.
	* @param inCrsmb_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION
	* @param inCrmbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO ASISTENTE
	* @param inCgg_crmbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MIEMBRO TITULAR 
	* @param inCrsmb_presidente DETERMINAR EL PRESIDENTE DE LA SESION
	* @param inCrsmb_presente DETERMINA SI EL MIEMBRO SE ENCUENTRA PRESENTE EN LA SESION
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCrsmb_codigo")String inCrsmb_codigo,
		@WebParam(name="inCrssc_codigo")String inCrssc_codigo,
		@WebParam(name="inCrmbc_codigo")String inCrmbc_codigo,
		@WebParam(name="inCgg_crmbc_codigo")String inCgg_crmbc_codigo,
		@WebParam(name="inCrsmb_presidente")boolean inCrsmb_presidente,
		@WebParam(name="inCrsmb_presente")boolean inCrsmb_presente
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_sesion_miembro obj = new com.besixplus.sii.objects.Cgg_res_sesion_miembro();
		obj.setCRSMB_CODIGO(inCrsmb_codigo);
		obj.setCRSSC_CODIGO(inCrssc_codigo);
		obj.setCRMBC_CODIGO(inCrmbc_codigo);
		obj.setCGG_CRMBC_CODIGO(inCgg_crmbc_codigo);
		obj.setCRSMB_PRESIDENTE(inCrsmb_presidente);
		obj.setCRSMB_PRESENTE(inCrsmb_presente);
		obj.setCRSMB_ESTADO(true);
		obj.setCRSMB_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_sesion_miembro(obj).update(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return res;
	}


	/**
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_sesion_miembro EN UNA ESTRUCTURA JSON o XML.
	* @param inCrsmb_codigo crsmb_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @return String REGISTRO SELECCIONADO.
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCrsmb_codigo")String inCrsmb_codigo,
		@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_sesion_miembro tmpObj = new com.besixplus.sii.objects.Cgg_res_sesion_miembro();
		tmpObj.setCRSMB_CODIGO(inCrsmb_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_sesion_miembro(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_miembro>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_res_sesion_miembro.
	* @param inCrsmb_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCrsmb_codigo")String inCrsmb_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_sesion_miembro tmpObj = new com.besixplus.sii.objects.Cgg_res_sesion_miembro();
		tmpObj.setCRSMB_CODIGO(inCrsmb_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_res_sesion_miembro(tmpObj).delete(con);
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_sesion_miembro EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	* @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	* @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	* @param keyword CRITERIO DE BUSQUEDA.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMITE
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	@WebMethod
	public String selectSesion(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCrcom_codigo")String inCrcom_codigo
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
				tmpCount = com.besixplus.sii.db.Cgg_res_sesion_miembro.selectCountSesion(con, keyword,inCrcom_codigo);
				con.setAutoCommit(!ManagerConnection.isDeployed());
				obj = com.besixplus.sii.db.Cgg_res_sesion_miembro.selectAllSesion(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inCrcom_codigo);
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

}