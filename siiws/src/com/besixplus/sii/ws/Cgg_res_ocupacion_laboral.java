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
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import com.besixplus.sii.db.ManagerConnection;

/**
* CLASE Cgg_res_ocupacion_laboral
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_ocupacion_laboral POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_ocupacion_laboral implements Serializable{

	private static final long serialVersionUID = 979994115;

	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_ocupacion_laboral.
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE TIENE UNA OCUPACION LABORAL.
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE ACTUA COMO EMPLEADOR.
	* @param inCgcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO.
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO.
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA .
	* @param inCrocl_tipo TIPO DE OCUPACION LABORAL
0 -  PUBLICA
1 - PRIVADA
2 - PROPIA
3 - OTROS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCrper_codigo")String inCrper_codigo,
		@WebParam(name="inCgg_crper_codigo")String inCgg_crper_codigo,
		@WebParam(name="inCgcrg_codigo")String inCgcrg_codigo,
		@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
		@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
		@WebParam(name="inCrocl_tipo")int inCrocl_tipo
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_ocupacion_laboral obj = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
		obj.setCROCL_CODIGO("KEYGEN");
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		obj.setCGCRG_CODIGO(inCgcrg_codigo);
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCROCL_TIPO(inCrocl_tipo);
		obj.setCROCL_ESTADO(true);
		obj.setCROCL_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCROCL_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_ocupacion_laboral(obj).insert(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_res_ocupacion_laboral.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_ocupacion_laboral EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_res_ocupacion_laboral.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_ocupacion_laboral.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_ocupacion_laboral.
	* @param inCrocl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OCUPACION LABORAL
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE TIENE UNA OCUPACION LABORAL
	* @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA QUE ACTUA COMO EMPLEADOR
	* @param inCgcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA 
	* @param inCrocl_tipo TIPO DE OCUPACION LABORAL
0 -  PUBLICA
1 - PRIVADA
2 - PROPIA
3 - OTROS
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCrocl_codigo")String inCrocl_codigo,
		@WebParam(name="inCrper_codigo")String inCrper_codigo,
		@WebParam(name="inCgg_crper_codigo")String inCgg_crper_codigo,
		@WebParam(name="inCgcrg_codigo")String inCgcrg_codigo,
		@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
		@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
		@WebParam(name="inCrocl_tipo")int inCrocl_tipo
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_ocupacion_laboral obj = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
		obj.setCROCL_CODIGO(inCrocl_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		obj.setCGCRG_CODIGO(inCgcrg_codigo);
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCROCL_TIPO(inCrocl_tipo);
		obj.setCROCL_ESTADO(true);
		obj.setCROCL_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_ocupacion_laboral(obj).update(con);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_ocupacion_laboral EN UNA ESTRUCTURA JSON o XML.
	* @param inCrocl_codigo crocl_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @return String REGISTRO SELECCIONADO.
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCrocl_codigo")String inCrocl_codigo,
		@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_ocupacion_laboral tmpObj = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
		tmpObj.setCROCL_CODIGO(inCrocl_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_ocupacion_laboral(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_ocupacion_laboral>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_res_ocupacion_laboral.
	* @param inCrocl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OCUPACION LABORAL
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCrocl_codigo")String inCrocl_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_ocupacion_laboral tmpObj = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
		tmpObj.setCROCL_CODIGO(inCrocl_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_res_ocupacion_laboral(tmpObj).delete(con);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_ocupacion_laboral EN UNA ESTRUCTURA JSON o XML.
	* @param inCrper_codigo inCrper_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return String REGISTRO SELECCIONADO.
	*/
	@WebMethod
	public String selectOcupacionPersona(
		@WebParam(name="inCrper_codigo")String inCrper_codigo,
		@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_ocupacion_laboral tmpObj = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
		tmpObj.setCROCL_CODIGO(inCrper_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			ArrayList<HashMap<String,Object>> tmpArray = new ArrayList<HashMap<String,Object>>();
			tmpArray = com.besixplus.sii.db.Cgg_res_ocupacion_laboral.selectOcupacionPersonaDirect(con, inCrper_codigo);
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

}