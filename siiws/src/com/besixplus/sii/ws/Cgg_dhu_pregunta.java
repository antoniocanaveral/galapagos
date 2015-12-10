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


/**
 * CLASE Cgg_dhu_pregunta
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_pregunta POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_dhu_pregunta implements Serializable{

	private static final long serialVersionUID = 1807042339;

	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_pregunta.
	 * @param inCdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA.
	 * @param inCdprg_preguntas IDENTIFICATIVO UNICO DE REGISTRO DE PREGUNTAS_RESPUESTAS.
	 * @param inCdprg_tipo IDENTIFICATIVO UNICO DE REGISTRO DE RESPUESTA.
	 * @param inCdprg_descripcion DESCRIPCION DE LA PREGUNTA.
	 * @param inCdprg_cuantificable ESTADO QUE DETERMINA SI LA PREGUNTA SE PUEDE CUANTIFICAR.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCdcat_codigo")String inCdcat_codigo,
			@WebParam(name="inCdprg_preguntas")String inCdprg_preguntas,
			@WebParam(name="inCdprg_tipo")int inCdprg_tipo	
	){

		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_pregunta obj = new com.besixplus.sii.objects.Cgg_dhu_pregunta();
		String res = "true";
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}			
			org.json.JSONArray preguntasJson = new org.json.JSONArray(inCdprg_preguntas);
			for (int i = 0 ; i < preguntasJson.length(); i++){	
				//obj.setCDPRG_CODIGO("KEYGEN");
				if((((org.json.JSONObject)preguntasJson.get(i)).get("CDPRG_CODIGO").toString()).equals("KEYGEN")){
					obj.setCDPRG_CODIGO("KEYGEN");
				}else{
					obj.setCDPRG_CODIGO(((org.json.JSONObject)preguntasJson.get(i)).get("CDPRG_CODIGO").toString());
				}
				obj.setCDCAT_CODIGO(inCdcat_codigo);
				obj.setCDPRG_DESCRIPCION(((org.json.JSONObject)preguntasJson.get(i)).get("CDPRG_DESCRIPCION").toString());
				if(inCdprg_tipo == 0){
					obj.setCDPRG_CUANTIFICABLE(true);
					obj.setCDPRG_MULTIPLE(false);
				}else{
					if(inCdprg_tipo == 1){
						obj.setCDPRG_CUANTIFICABLE(true);
						obj.setCDPRG_MULTIPLE(true);
					}else{
						obj.setCDPRG_CUANTIFICABLE(false);
						obj.setCDPRG_MULTIPLE(false);
					}
				}
				//obj.setCDPRG_MULTIPLE(Boolean.valueOf(((org.json.JSONObject)preguntasJson.get(i)).get("CDPRG_MULTIPLE").toString()));
				obj.setCDPRG_ESTADO(true);
				obj.setCDPRG_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
				obj.setCDPRG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
				res = new com.besixplus.sii.db.Cgg_dhu_pregunta(obj).insert(con);				
			}
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_dhu_pregunta.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_pregunta EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_dhu_pregunta.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_pregunta.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);

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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_beca EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_dhu_pregunta.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_pregunta.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_dhu_pregunta.
	 * @param inCdprg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	 * @param inCdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
	 * @param inCdprg_preguntas IDENTIFICATIVO UNICO DE REGISTRO DE PREGUNTAS
	 * @param inEliCdprg_preguntas VERIFICA SI SE ELIMINA O NO LA PREGUNTA. 
	 * @param inCdprg_tipo TIPO DE PREGUNTA.
	 * @param inCdprg_descripcion DESCRIPCION DE LA PREGUNTA
	 * @param inCdprg_cuantificable ESTADO QUE DETERMINA SI LA PREGUNTA SE PUEDE CUANTIFICAR
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCdprg_codigo")String inCdprg_codigo,
			@WebParam(name="inCdcat_codigo")String inCdcat_codigo,
			@WebParam(name="inCdprg_preguntas")String inCdprg_preguntas,
			@WebParam(name="inEliCdprg_preguntas")String inEliCdprg_preguntas,
			@WebParam(name="inCdprg_tipo")int inCdprg_tipo	
	){
		String res = "true";
		Boolean resEli = true; 
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_pregunta obj = new com.besixplus.sii.objects.Cgg_dhu_pregunta();

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			org.json.JSONArray preguntasJson = new org.json.JSONArray(inCdprg_preguntas);
			@SuppressWarnings("unused")
			org.json.JSONArray eliCdprg_preguntas = new org.json.JSONArray(inEliCdprg_preguntas);
			/*for (int i = 0 ; i < eliCdprg_preguntas.length(); i++){	
				obj.setCDPRG_CODIGO(((org.json.JSONObject)eliCdprg_preguntas.get(i)).get("CDPRG_CODIGO").toString());
				resEli = new com.besixplus.sii.db.Cgg_dhu_pregunta(obj).deletePregunta(con);

			}*/	
			if (resEli==true){
				for (int i = 0 ; i < preguntasJson.length(); i++){	
					System.out.println(((org.json.JSONObject)preguntasJson.get(i)).get("CDPRG_CODIGO").toString());
					if((((org.json.JSONObject)preguntasJson.get(i)).get("CDPRG_CODIGO").toString()).equals("KEYGEN")){
						obj.setCDPRG_CODIGO("KEYGEN");
					}else{
						obj.setCDPRG_CODIGO(((org.json.JSONObject)preguntasJson.get(i)).get("CDPRG_CODIGO").toString());
					}
						obj.setCDCAT_CODIGO(inCdcat_codigo);
						obj.setCDPRG_DESCRIPCION(((org.json.JSONObject)preguntasJson.get(i)).get("CDPRG_DESCRIPCION").toString());
						if(inCdprg_tipo == 0){
							obj.setCDPRG_CUANTIFICABLE(true);
							obj.setCDPRG_MULTIPLE(false);
						}else{
							if(inCdprg_tipo == 1){
								obj.setCDPRG_CUANTIFICABLE(true);
								obj.setCDPRG_MULTIPLE(true);
							}else{
								obj.setCDPRG_CUANTIFICABLE(false);
								obj.setCDPRG_MULTIPLE(false);
							}
						}
						/*obj.setCDPRG_CUANTIFICABLE(Boolean.valueOf(((org.json.JSONObject)preguntasJson.get(i)).get("CDPRG_CUANTIFICABLE").toString()));
						obj.setCDPRG_MULTIPLE(Boolean.valueOf(((org.json.JSONObject)preguntasJson.get(i)).get("CDPRG_MULTIPLE").toString()));*/
						obj.setCDPRG_ESTADO(true);
						obj.setCDPRG_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						obj.setCDPRG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_dhu_pregunta(obj).insert(con);
					
				}
			}			
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_dhu_pregunta EN UNA ESTRUCTURA JSON o XML.
	 * @param inCdprg_codigo IDENTIFICATIVO UNICO DE PREGUNTA.	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCdprg_codigo")String inCdprg_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_pregunta tmpObj = new com.besixplus.sii.objects.Cgg_dhu_pregunta();
		tmpObj.setCDPRG_CODIGO(inCdprg_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_dhu_pregunta(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_dhu_pregunta.
	 * @param inCdprg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCdprg_codigo")String inCdprg_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_pregunta tmpObj = new com.besixplus.sii.objects.Cgg_dhu_pregunta();
		tmpObj.setCDPRG_CODIGO(inCdprg_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_dhu_pregunta(tmpObj).delete(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_dhu_pregunta EN UNA ESTRUCTURA JSON o XML.
	 * @param inCdcat_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CATEGORIA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inCdprg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PREGUNTA.
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String selectCategoria(
			@WebParam(name="inCdcat_codigo")String inCdcat_codigo,
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_pregunta> obj = null;
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
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_pregunta.selectCGG_DHU_CATEGORIA(con,inCdcat_codigo);

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