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
* CLASE Cgg_institucion_educativa
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_institucion_educativa POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_institucion_educativa implements Serializable{

	private static final long serialVersionUID = 1604542753;

	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_institucion_educativa.
	* @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS.
	* @param inCgied_descripcion DESCRIPCION DE LA INSTITUCION EDUCATIVA.
	* @param inCgied_direccion DIRECCION DE UBICACION DE LA INSTITUCION EDUCATIVA.
	* @param inInstitucionContacto_JSON CADENA EN FORMATO JSON QUE CONTIENE LAS FORMAS DE CONTACTO DE UNA INSTITUCION EDUCATIVA
	* @param inCgied_nombre IDENTIFICATIVO UNICO DE ISNTITUCION EDUCATIVA.
	* @param inInstitucionNivelEstudio_JSON CADENA EN FORMATO JSON QUE CONTIENE LOS NIVELES DE ESTUDIO DE UNA INSTITUCION EDUCATIVA.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCpais_codigo")String inCpais_codigo,
		@WebParam(name="inCgied_descripcion")String inCgied_descripcion,
		@WebParam(name="inCgied_direccion")String inCgied_direccion,
		@WebParam(name="inInstitucionContacto_JSON")String inInstitucionContacto_JSON,
		@WebParam(name="inCgied_nombre")String inCgied_nombre,
		@WebParam(name="inInstitucionNivelEstudio_JSON")String inInstitucionNivelEstudio_JSON
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_institucion_educativa obj = new com.besixplus.sii.objects.Cgg_institucion_educativa();
		obj.setCGIED_CODIGO("KEYGEN");
		obj.setCPAIS_CODIGO(inCpais_codigo);
		obj.setCGIED_DESCRIPCION(inCgied_descripcion);
		obj.setCGIED_DIRECCION(inCgied_direccion);
		obj.setCGIED_NOMBRE(inCgied_nombre);
		obj.setCGIED_ESTADO(true);
		obj.setCGIED_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCGIED_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			
			res = new com.besixplus.sii.db.Cgg_institucion_educativa(obj).insert(con);
			if (obj.getCGIED_CODIGO() != "KEYGEN" && res.equals("true"))
			{
				//Insert Institucion Contacto
				org.json.JSONArray objJSON = new org.json.JSONArray(inInstitucionContacto_JSON);
				/*if (objJSON.length()>0)
				{
					res = "false";
				}*/
				for (int i = 0 ; i < objJSON.length(); i++){			
					com.besixplus.sii.objects.Cgg_institucion_contacto objInstitucionContacto = new com.besixplus.sii.objects.Cgg_institucion_contacto();
					objInstitucionContacto.setCINTC_CODIGO("KEYGEN");
					objInstitucionContacto.setCGIED_CODIGO(obj.getCGIED_CODIGO());
					objInstitucionContacto.setCRTCO_CODIGO(((org.json.JSONObject)objJSON.get(i)).get("CRTCO_CODIGO").toString());
					objInstitucionContacto.setCINTC_DESCRIPCION(((org.json.JSONObject)objJSON.get(i)).get("CINTC_DESCRIPCION").toString());
					objInstitucionContacto.setCINTC_CONTACTO(((org.json.JSONObject)objJSON.get(i)).get("CINTC_CONTACTO").toString());
					objInstitucionContacto.setCINTC_ESTADO(true);
					objInstitucionContacto.setCINTC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objInstitucionContacto.setCINTC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());				
					res = new com.besixplus.sii.db.Cgg_institucion_contacto(objInstitucionContacto).insert(con);
				}
				if (res.equals("true"))
				{
					org.json.JSONArray objNivelEstudioJSON = new org.json.JSONArray(inInstitucionNivelEstudio_JSON);
					for (int i = 0 ; i < objNivelEstudioJSON.length(); i++){						
						com.besixplus.sii.objects.Cgg_institucion_nivel objInstitucionNivel = new com.besixplus.sii.objects.Cgg_institucion_nivel();
						objInstitucionNivel.setCGIEN_CODIGO("KEYGEN");
						objInstitucionNivel.setCGNES_CODIGO(((org.json.JSONObject)objNivelEstudioJSON.get(i)).get("CGNES_CODIGO").toString());
						objInstitucionNivel.setCGIED_CODIGO(obj.getCGIED_CODIGO());
						objInstitucionNivel.setCGIEN_ESTADO(true);
						objInstitucionNivel.setCGIEN_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objInstitucionNivel.setCGIEN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_institucion_nivel(objInstitucionNivel).insert(con);					
					}
					if(res.equals("true"))
					{
						con.commit();
						con.setAutoCommit(true);
						con.close();
					}
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
		return res;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_institucion_educativa EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_institucion_educativa.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_institucion_educativa EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_institucion_educativa.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_institucion_educativa.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_institucion_educativa EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_institucion_educativa.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_institucion_educativa.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_institucion_educativa.
	* @param inCgied_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	* @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	* @param inCgied_descripcion DESCRIPCION DE LA INSTITUCION EDUCATIVA
	* @param inCgied_direccion DIRECCION DE UBICACION DE LA INSTITUCION EDUCATIVA
	* @param inInstitucionContacto_JSON CADENA EN FORMATO JSON QUE CONTIENE LAS FORMAS DE CONTACTO DE UNA INSTITUCION EDUCATIVA
	* @param inCgied_nombre NOMBRE DE LA INSTITUCION EDUCATIVA.
	* @param inInstitucionNivelEstudio_JSON CADENA JSON QUE CONTIENE LOS NIVELES DE ESTUDIO DE UNA INSTITUCION EDUCATIVA.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCgied_codigo")String inCgied_codigo,
		@WebParam(name="inCpais_codigo")String inCpais_codigo,
		@WebParam(name="inCgied_descripcion")String inCgied_descripcion,
		@WebParam(name="inCgied_direccion")String inCgied_direccion,
		@WebParam(name="inInstitucionContacto_JSON")String inInstitucionContacto_JSON,
		@WebParam(name="inCgied_nombre")String inCgied_nombre,
		@WebParam(name="inInstitucionNivelEstudio_JSON")String inInstitucionNivelEstudio_JSON
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_institucion_educativa obj = new com.besixplus.sii.objects.Cgg_institucion_educativa();
		obj.setCGIED_CODIGO(inCgied_codigo);
		obj.setCPAIS_CODIGO(inCpais_codigo);
		obj.setCGIED_NOMBRE(inCgied_nombre);
		obj.setCGIED_DESCRIPCION(inCgied_descripcion);
		obj.setCGIED_DIRECCION(inCgied_direccion);
		obj.setCGIED_ESTADO(true);
		obj.setCGIED_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_institucion_educativa(obj).update(con);
			if (obj.getCGIED_CODIGO() != "KEYGEN" && res.equals("true"))
			{
				//Insert Institucion Contacto
				org.json.JSONArray objJSON = new org.json.JSONArray(inInstitucionContacto_JSON);
				/*if (objJSON.length()>0)
				{
					res = "false";
				}*/
				for (int i = 0 ; i < objJSON.length(); i++){			
					com.besixplus.sii.objects.Cgg_institucion_contacto objInstitucionContacto = new com.besixplus.sii.objects.Cgg_institucion_contacto();
					//objInstitucionContacto.setCINTC_CODIGO("KEYGEN");
					objInstitucionContacto.setCGIED_CODIGO(obj.getCGIED_CODIGO());
					objInstitucionContacto.setCRTCO_CODIGO(((org.json.JSONObject)objJSON.get(i)).get("CRTCO_CODIGO").toString());
					objInstitucionContacto.setCINTC_DESCRIPCION(((org.json.JSONObject)objJSON.get(i)).get("CINTC_DESCRIPCION").toString());
					objInstitucionContacto.setCINTC_CONTACTO(((org.json.JSONObject)objJSON.get(i)).get("CINTC_CONTACTO").toString());
					objInstitucionContacto.setCINTC_ESTADO(true);
					objInstitucionContacto.setCINTC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					if(((org.json.JSONObject)objJSON.get(i)).get("CINTC_CODIGO").toString().equals("KEYGEN"))
					{
						objInstitucionContacto.setCINTC_CODIGO("KEYGEN");
						objInstitucionContacto.setCINTC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_institucion_contacto(objInstitucionContacto).insert(con);
					}
					else
					{
						objInstitucionContacto.setCINTC_CODIGO(((org.json.JSONObject)objJSON.get(i)).get("CINTC_CODIGO").toString());
						res = new com.besixplus.sii.db.Cgg_institucion_contacto(objInstitucionContacto).update(con);
					}
				}
				if (res.equals("true"))
				{
					org.json.JSONArray objNivelEstudioJSON = new org.json.JSONArray(inInstitucionNivelEstudio_JSON);
					for (int i = 0 ; i < objNivelEstudioJSON.length(); i++){			
						com.besixplus.sii.objects.Cgg_institucion_nivel objInstitucionNivel = new com.besixplus.sii.objects.Cgg_institucion_nivel();
						objInstitucionNivel.setCGNES_CODIGO(((org.json.JSONObject)objNivelEstudioJSON.get(i)).get("CGNES_CODIGO").toString());
						objInstitucionNivel.setCGIED_CODIGO(obj.getCGIED_CODIGO());
						objInstitucionNivel.setCGIEN_ESTADO(true);
						objInstitucionNivel.setCGIEN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						if(((org.json.JSONObject)objNivelEstudioJSON.get(i)).get("CGIEN_CODIGO").toString().equals("KEYGEN"))
						{
							objInstitucionNivel.setCGIEN_CODIGO("KEYGEN");
							objInstitucionNivel.setCGIEN_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_institucion_nivel(objInstitucionNivel).insert(con);							
						}
						else
						{
							objInstitucionNivel.setCGIEN_CODIGO(((org.json.JSONObject)objNivelEstudioJSON.get(i)).get("CGIEN_CODIGO").toString());
							res = new com.besixplus.sii.db.Cgg_institucion_nivel(objInstitucionNivel).update(con);							
						}						
					}
					if(res.equals("true"))
					{
						con.commit();
						con.setAutoCommit(true);
						con.close();
					}
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
		return res;
	}


	/**
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_institucion_educativa EN UNA ESTRUCTURA JSON o XML.
	* @param inCgied_codigo cgied_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return String REGISTRO SELECCIONADO.
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCgied_codigo")String inCgied_codigo,
		@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_institucion_educativa tmpObj = new com.besixplus.sii.objects.Cgg_institucion_educativa();
		tmpObj.setCGIED_CODIGO(inCgied_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_institucion_educativa(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_institucion_educativa>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_institucion_educativa.
	* @param inCgied_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCgied_codigo")String inCgied_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_institucion_educativa tmpObj = new com.besixplus.sii.objects.Cgg_institucion_educativa();
		tmpObj.setCGIED_CODIGO(inCgied_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_institucion_educativa(tmpObj).delete(con);
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

}