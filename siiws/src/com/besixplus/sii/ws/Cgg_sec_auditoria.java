package com.besixplus.sii.ws;

import java.util.ArrayList;
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
* CLASE Cgg_sec_auditoria
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_sec_auditoria POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_sec_auditoria implements Serializable{

	private static final long serialVersionUID = 942960357;

	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_sec_auditoria.
	* @param inCsadt_fecha FECHA DEL CAMBIO DE INFORMACION.
	* @param inCsadt_usuario USUARIO QUE REALIZO LA MODIFICACION.
	* @param inCsadt_ip IP REMOTA DEL USUARIO.
	* @param inCsadt_sesion IDENTIFICADOR DE LA SESION DEL USUARIO.
	* @param inCsadt_tabla NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION.
	* @param inCsadt_operacion TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE).
	* @param inCsadt_dato_antiguo REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS.
	* @param inCsadt_dato_nuevo REGISTRO EN FORMATO XML CON LOS DATOS NUEVOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCsadt_fecha")java.util.Date inCsadt_fecha,
		@WebParam(name="inCsadt_usuario")String inCsadt_usuario,
		@WebParam(name="inCsadt_ip")String inCsadt_ip,
		@WebParam(name="inCsadt_sesion")String inCsadt_sesion,
		@WebParam(name="inCsadt_tabla")String inCsadt_tabla,
		@WebParam(name="inCsadt_operacion")String inCsadt_operacion,
		@WebParam(name="inCsadt_dato_antiguo")String inCsadt_dato_antiguo,
		@WebParam(name="inCsadt_dato_nuevo")String inCsadt_dato_nuevo
	){
		boolean res = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_sec_auditoria obj = new com.besixplus.sii.objects.Cgg_sec_auditoria();
		obj.setCSADT_CODIGO("KEYGEN");
		obj.setCSADT_FECHA(inCsadt_fecha);
		obj.setCSADT_USUARIO(inCsadt_usuario);
		obj.setCSADT_IP(inCsadt_ip);
		obj.setCSADT_SESION(inCsadt_sesion);
		obj.setCSADT_TABLA(inCsadt_tabla);
		obj.setCSADT_OPERACION(inCsadt_operacion);
		obj.setCSADT_DATO_ANTIGUO(inCsadt_dato_antiguo);
		obj.setCSADT_DATO_NUEVO(inCsadt_dato_nuevo);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_sec_auditoria(obj).insert(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sec_auditoria EN UNA ESTRUCTRA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).  
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_sec_auditoria> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_sec_auditoria.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_sec_auditoria EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_sec_auditoria> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_sec_auditoria.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_sec_auditoria.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_sec_auditoria.
	* @param inCsadt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
	* @param inCsadt_fecha FECHA DEL CAMBIO DE INFORMACION
	* @param inCsadt_usuario USUARIO QUE REALIZO LA MODIFICACION
	* @param inCsadt_ip IP REMOTA DEL USUARIO
	* @param inCsadt_sesion IDENTIFICADOR DE LA SESION DEL USUARIO
	* @param inCsadt_tabla NOMBRE DE LA TABLA QUE SUFRIO LA MODIFICACION
	* @param inCsadt_operacion TAREA QUE REALIZO SOBRE LOS DATOS(INSERT, UPDATE, DELETE)
	* @param inCsadt_dato_antiguo REGISTRO EN FORMATO XML CON LOS DATOS ANTIGUOS
	* @param inCsadt_dato_nuevo REGISTRO EN FORMATO XML CON LOS DATOS NUEVOS
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCsadt_codigo")String inCsadt_codigo,
		@WebParam(name="inCsadt_fecha")java.util.Date inCsadt_fecha,
		@WebParam(name="inCsadt_usuario")String inCsadt_usuario,
		@WebParam(name="inCsadt_ip")String inCsadt_ip,
		@WebParam(name="inCsadt_sesion")String inCsadt_sesion,
		@WebParam(name="inCsadt_tabla")String inCsadt_tabla,
		@WebParam(name="inCsadt_operacion")String inCsadt_operacion,
		@WebParam(name="inCsadt_dato_antiguo")String inCsadt_dato_antiguo,
		@WebParam(name="inCsadt_dato_nuevo")String inCsadt_dato_nuevo
	){
		boolean res = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_sec_auditoria obj = new com.besixplus.sii.objects.Cgg_sec_auditoria();
		obj.setCSADT_CODIGO(inCsadt_codigo);
		obj.setCSADT_FECHA(inCsadt_fecha);
		obj.setCSADT_USUARIO(inCsadt_usuario);
		obj.setCSADT_IP(inCsadt_ip);
		obj.setCSADT_SESION(inCsadt_sesion);
		obj.setCSADT_TABLA(inCsadt_tabla);
		obj.setCSADT_OPERACION(inCsadt_operacion);
		obj.setCSADT_DATO_ANTIGUO(inCsadt_dato_antiguo);
		obj.setCSADT_DATO_NUEVO(inCsadt_dato_nuevo);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_sec_auditoria(obj).update(con);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_sec_auditoria EN UNA ESTRUCTURA JSON o XML.
	* @param inCsadt_codigo csadt_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).  
	* @return String REGISTRO SELECCIONADO.
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCsadt_codigo")String inCsadt_codigo,
		@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_sec_auditoria tmpObj = new com.besixplus.sii.objects.Cgg_sec_auditoria();
		tmpObj.setCSADT_CODIGO(inCsadt_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_sec_auditoria(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_sec_auditoria> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_sec_auditoria>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_sec_auditoria.
	* @param inCsadt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AUDITORIA
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCsadt_codigo")String inCsadt_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_sec_auditoria tmpObj = new com.besixplus.sii.objects.Cgg_sec_auditoria();
		tmpObj.setCSADT_CODIGO(inCsadt_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_sec_auditoria(tmpObj).delete(con);
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