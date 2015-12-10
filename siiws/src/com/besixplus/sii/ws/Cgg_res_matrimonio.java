package com.besixplus.sii.ws;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
/*import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;*/
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.soap.SOAPFaultException;

import com.besixplus.sii.db.ManagerConnection;

/**
 * CLASE Cgg_res_matrimonio
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_matrimonio POR MEDIO DE SERVICIOS WEB.
 *
 * @autor BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_matrimonio implements Serializable{

	private static final long serialVersionUID = 1418115962;

	@Resource WebServiceContext wctx;
	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_matrimonio.
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA.
	* @param inCrmtr_fecha_matrimonio FECHA DE REALIZACION DE MATRIMONIO O UNION DE HECHO.
	* @param inCrmtr_tipo TIPO DE RELACION FORMALIZADA Y LEGALIZADA
MATRIMONIO
UNION DE HECHO.
	* @param inCrmtr_estado_seguimiento ESTADO DEL SEGUIMIENTO REALIZADO AL MATRIMONIO
0.- EN PROCESO
1.- FINALIZADO.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
		@WebParam(name="inCrmtr_fecha_matrimonio")java.util.Date inCrmtr_fecha_matrimonio,
		@WebParam(name="inCrmtr_tipo")int inCrmtr_tipo,
		@WebParam(name="inCrmtr_estado_seguimiento")int inCrmtr_estado_seguimiento
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_matrimonio obj = new com.besixplus.sii.objects.Cgg_res_matrimonio();
		obj.setCRMTR_CODIGO("KEYGEN");
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCRMTR_FECHA_MATRIMONIO(inCrmtr_fecha_matrimonio);
		obj.setCRMTR_TIPO(inCrmtr_tipo);
		obj.setCRMTR_ESTADO_SEGUIMIENTO(inCrmtr_estado_seguimiento);
		obj.setCRMTR_ESTADO(true);
		obj.setCRMTR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRMTR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_matrimonio(obj).insert(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}
	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_matrimonio.
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA.
	* @param inCrmtr_fecha_matrimonio FECHA DE REALIZACION DE MATRIMONIO O UNION DE HECHO.
	* @param inCrmtr_tipo TIPO DE RELACION FORMALIZADA Y LEGALIZADA
		MATRIMONIO
		UNION DE HECHO.
	* @param inCrmtr_estado_seguimiento ESTADO DEL SEGUIMIENTO REALIZADO AL MATRIMONIO
		0.- EN PROCESO
		1.- FINALIZADO.
	* @param inpryu_JSON INFORMACION DE LOS OFICIALES DE SEGUIMIENTO ASIGNADOS AL MATRIMONIO
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */

	@WebMethod
	public String insert1(
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="inCrmtr_fecha_matrimonio")java.util.Date inCrmtr_fecha_matrimonio,
			@WebParam(name="inCrmtr_tipo")int inCrmtr_tipo,
			@WebParam(name="inCrmtr_estado_seguimiento")int inCrmtr_estado_seguimiento,
			@WebParam(name="inpryu_JSON")String inpryu_JSON
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_matrimonio obj = new com.besixplus.sii.objects.Cgg_res_matrimonio();
		obj.setCRMTR_CODIGO("KEYGEN");
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCRMTR_FECHA_MATRIMONIO(inCrmtr_fecha_matrimonio);
		obj.setCRMTR_TIPO(inCrmtr_tipo);
		obj.setCRMTR_ESTADO_SEGUIMIENTO(inCrmtr_estado_seguimiento);
		obj.setCRMTR_ESTADO(true);
		obj.setCRMTR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRMTR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_matrimonio(obj).insert(con);
			// Almacenar los Datos de Tabla de Oficial de Matrimonio
			org.json.JSONArray pryuJSON = new org.json.JSONArray(inpryu_JSON);
			com.besixplus.sii.objects.Cgg_res_oficial_matrimonio obj_pryu;
			for (int i = 0 ; i < pryuJSON.length(); i++){

				obj_pryu = new com.besixplus.sii.objects.Cgg_res_oficial_matrimonio();
				obj_pryu.setCROFM_CODIGO("KEYGEN");
				obj_pryu.setCRMTR_CODIGO(obj.getCRMTR_CODIGO());	
				obj_pryu.setCUSU_CODIGO(((org.json.JSONObject)pryuJSON.get(i)).get("CUSU_CODIGO").toString());	
				obj_pryu.setCROFM_ESTADO(true);
				obj_pryu.setCROFM_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
				obj_pryu.setCROFM_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
				res= new com.besixplus.sii.db.Cgg_res_oficial_matrimonio(obj_pryu).insert(con);				
			}
			// 
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_matrimonio EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_res_matrimonio.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_matrimonio EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_res_matrimonio.selectCount(con, keyword,tmpRequest.getUserPrincipal().getName());
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_res_matrimonio.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			//System.out.println("Aqui " + outCadena);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_matrimonio.
	* @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA
	* @param inCrmtr_fecha_matrimonio FECHA DE REALIZACION DE MATRIMONIO O UNION DE HECHO
	* @param inCrmtr_tipo TIPO DE RELACION FORMALIZADA Y LEGALIZADA
MATRIMONIO
UNION DE HECHO
	* @param inCrmtr_estado_seguimiento ESTADO DEL SEGUIMIENTO REALIZADO AL MATRIMONIO
0.- EN PROCESO
1.- FINALIZADO
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCrmtr_codigo")String inCrmtr_codigo,
		@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
		@WebParam(name="inCrmtr_fecha_matrimonio")java.util.Date inCrmtr_fecha_matrimonio,
		@WebParam(name="inCrmtr_tipo")int inCrmtr_tipo,
		@WebParam(name="inCrmtr_estado_seguimiento")int inCrmtr_estado_seguimiento
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_matrimonio obj = new com.besixplus.sii.objects.Cgg_res_matrimonio();
		obj.setCRMTR_CODIGO(inCrmtr_codigo);
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCRMTR_FECHA_MATRIMONIO(inCrmtr_fecha_matrimonio);
		obj.setCRMTR_TIPO(inCrmtr_tipo);
		obj.setCRMTR_ESTADO_SEGUIMIENTO(inCrmtr_estado_seguimiento);
		obj.setCRMTR_ESTADO(true);
		obj.setCRMTR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_matrimonio(obj).update(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}

	/**
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_matrimonio.
	* @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE QUE PERMITE HACER EL SEGUIMIENTO DE PAREJA
	* @param inCrmtr_fecha_matrimonio FECHA DE REALIZACION DE MATRIMONIO O UNION DE HECHO
	* @param inCrmtr_tipo TIPO DE RELACION FORMALIZADA Y LEGALIZADA
		MATRIMONIO
		UNION DE HECHO
	* @param inCrmtr_estado_seguimiento ESTADO DEL SEGUIMIENTO REALIZADO AL MATRIMONIO
		0.- EN PROCESO
		1.- FINALIZADO
	* @param inpryu_JSON INFORMACION DE LOS OFICIALES DE SEGUIMIENTO ASIGNADOS AL MATRIMONIO
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String update1(
			@WebParam(name="inCrmtr_codigo")String inCrmtr_codigo,
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="inCrmtr_fecha_matrimonio")java.util.Date inCrmtr_fecha_matrimonio,
			@WebParam(name="inCrmtr_tipo")int inCrmtr_tipo,
			@WebParam(name="inCrmtr_estado_seguimiento")int inCrmtr_estado_seguimiento,
			@WebParam(name="inpryu_JSON")String inpryu_JSON
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_matrimonio obj = new com.besixplus.sii.objects.Cgg_res_matrimonio();		
		obj.setCRMTR_CODIGO(inCrmtr_codigo);
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCRMTR_FECHA_MATRIMONIO(inCrmtr_fecha_matrimonio);
		obj.setCRMTR_TIPO(inCrmtr_tipo);
		obj.setCRMTR_ESTADO_SEGUIMIENTO(inCrmtr_estado_seguimiento);
		obj.setCRMTR_ESTADO(true);
		obj.setCRMTR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_matrimonio(obj).update(con);

			//Borrar oficiales asignados a un Matrimonio.
			new com.besixplus.sii.db.Cgg_res_matrimonio(obj).deleteOficial_Matrimonio(con);

			// Almacenar los Datos de Tabla de Oficial de Matrimonio
			org.json.JSONArray pryuJSON = new org.json.JSONArray(inpryu_JSON);
			com.besixplus.sii.objects.Cgg_res_oficial_matrimonio obj_pryu;
			for (int i = 0 ; i < pryuJSON.length(); i++){

				obj_pryu = new com.besixplus.sii.objects.Cgg_res_oficial_matrimonio();
				obj_pryu.setCROFM_CODIGO("KEYGEN");
				obj_pryu.setCRMTR_CODIGO(obj.getCRMTR_CODIGO());	
				obj_pryu.setCUSU_CODIGO(((org.json.JSONObject)pryuJSON.get(i)).get("CUSU_CODIGO").toString());	
				obj_pryu.setCROFM_ESTADO(true);
				obj_pryu.setCROFM_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
				obj_pryu.setCROFM_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
				res= new com.besixplus.sii.db.Cgg_res_oficial_matrimonio(obj_pryu).insert(con);				
			}			
			// 
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return res;
	}


	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_matrimonio EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrmtr_codigo crmtr_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrmtr_codigo")String inCrmtr_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_matrimonio tmpObj = new com.besixplus.sii.objects.Cgg_res_matrimonio();
		tmpObj.setCRMTR_CODIGO(inCrmtr_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_matrimonio(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_matrimonio>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_matrimonio.
	 * @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrmtr_codigo")String inCrmtr_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_matrimonio tmpObj = new com.besixplus.sii.objects.Cgg_res_matrimonio();
		tmpObj.setCRMTR_CODIGO(inCrmtr_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_res_matrimonio(tmpObj).delete(con);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_oficial_matrimonio EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inCrmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MATRIMONIO
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String deleteOficiales_Matrimonio(
			@WebParam(name="inCrmtr_codigo")String inCrmtr_codigo		
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			
			com.besixplus.sii.objects.Cgg_res_matrimonio tmpOM = new com.besixplus.sii.objects.Cgg_res_matrimonio();
			tmpOM.setCRMTR_CODIGO(inCrmtr_codigo);
			new com.besixplus.sii.db.Cgg_res_matrimonio(tmpOM).deleteOficial_Matrimonio(con);

			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return null;
	}
}