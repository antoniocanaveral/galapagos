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
* CLASE Cgg_res_denuncia
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_denuncia POR MEDIO DE SERVICIOS WEB.
*
* @autor BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_denuncia implements Serializable{

	private static final long serialVersionUID = 1315874501;

	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_denuncia.
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	* @param inCrden_anio ANIO DE LA DENUNCIA.
	* @param inCrden_numero NUMERO DE LA DENUNCIA.
	* @param inCrden_fecha_recepcion FECHA DE RECEPCION DE LA  DENUNCIA.
	* @param inCrden_numero_doc_ident NUMERO DE DOCUMENTO DE IDENTIFICACION DEL DENUNCIANTE.
	* @param inCrden_nombres NOMBRES DEL DENUNCIANTE.
	* @param inCrden_apellidos APELLIDOS DEL DENUNCIANTE.
	* @param inCrden_descripcion MOTIVO DE LA DENUNCIA.
	* @param inCrden_contacto PARA CORREO ELECTRONICO O NUMERO TELEFONICO DEL DENUNCIANTE.
	* @param inCrden_tipo TIPO DE DENUNCIA
RESIDENCIA ->   0
GESTION EMPLEO ->  1.
	* @param inCrden_denuncia ESTADO QUE DETERMINA EL ORIGEN DE LA INFORMACION
DENUNCIA/SUGERENCIA.
	* @param inCrden_seguimiento CAMPO DE REGISTRO DE SEGUIMIENTO DE LA DENUNCIA.
	* @param inCrden_estado_denuncia ESTADO DEL REGISTRO, RECOGE INFORMACION PARA DETERMINAR SI ESTA:
REGISTRADA
REVISADA
DESCARTADA.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCusu_codigo")String inCusu_codigo,
		@WebParam(name="inCrden_anio")String inCrden_anio,
		@WebParam(name="inCrden_numero")String inCrden_numero,
		@WebParam(name="inCrden_fecha_recepcion")java.util.Date inCrden_fecha_recepcion,
		@WebParam(name="inCrden_numero_doc_ident")String inCrden_numero_doc_ident,
		@WebParam(name="inCrden_nombres")String inCrden_nombres,
		@WebParam(name="inCrden_apellidos")String inCrden_apellidos,
		@WebParam(name="inCrden_descripcion")String inCrden_descripcion,
		@WebParam(name="inCrden_contacto")String inCrden_contacto,
		@WebParam(name="inCrden_tipo")int inCrden_tipo,
		@WebParam(name="inCrden_denuncia")boolean inCrden_denuncia,
		@WebParam(name="inCrden_seguimiento")String inCrden_seguimiento,
		@WebParam(name="inCrden_estado_denuncia")int inCrden_estado_denuncia
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_denuncia obj = new com.besixplus.sii.objects.Cgg_res_denuncia();
		obj.setCRDEN_CODIGO("KEYGEN");
		obj.setCUSU_CODIGO(inCusu_codigo);
		obj.setCRDEN_ANIO(inCrden_anio);
		obj.setCRDEN_NUMERO(inCrden_numero);
		obj.setCRDEN_FECHA_RECEPCION(inCrden_fecha_recepcion);
		obj.setCRDEN_NUMERO_DOC_IDENT(inCrden_numero_doc_ident);
		obj.setCRDEN_NOMBRES(inCrden_nombres);
		obj.setCRDEN_APELLIDOS(inCrden_apellidos);
		obj.setCRDEN_DESCRIPCION(inCrden_descripcion);
		obj.setCRDEN_CONTACTO(inCrden_contacto);
		obj.setCRDEN_TIPO(inCrden_tipo);
		obj.setCRDEN_DENUNCIA(inCrden_denuncia);
		obj.setCRDEN_SEGUIMIENTO(inCrden_seguimiento);
		obj.setCRDEN_ESTADO_DENUNCIA(inCrden_estado_denuncia);
		obj.setCRDEN_ESTADO(true);
		obj.setCRDEN_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRDEN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_denuncia(obj).insert(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_denuncia EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_res_denuncia.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_denuncia EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_res_denuncia.selectCount(con, keyword,"0");
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_denuncia.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword,"0");
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_denuncia EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	* @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	* @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	* @param keyword CRITERIO DE BUSQUEDA.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @param inTipo IDENTIFICA EL TIPO DE ESPECIE.
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	@WebMethod
	public String selectPageDirect(
		@WebParam(name="start")int start,
		@WebParam(name="limit")int limit,
		@WebParam(name="sort")String sort,
		@WebParam(name="dir")String dir,
		@WebParam(name="keyword")String keyword,
		@WebParam(name="format")String format,
		@WebParam(name="inTipo")String inTipo
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
			tmpCount = com.besixplus.sii.db.Cgg_res_denuncia.selectCount(con, keyword,inTipo);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_denuncia.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword,inTipo);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_denuncia.
	* @param inCrden_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrden_anio ANIO DE LA DENUNCIA
	* @param inCrden_numero NUMERO DE LA DENUNCIA
	* @param inCrden_fecha_recepcion FECHA DE RECEPCION DE LA  DENUNCIA
	* @param inCrden_numero_doc_ident NUMERO DE DOCUMENTO DE IDENTIFICACION DEL DENUNCIANTE
	* @param inCrden_nombres NOMBRES DEL DENUNCIANTE
	* @param inCrden_apellidos APELLIDOS DEL DENUNCIANTE
	* @param inCrden_descripcion MOTIVO DE LA DENUNCIA
	* @param inCrden_contacto PARA CORREO ELECTRONICO O NUMERO TELEFONICO DEL DENUNCIANTE
	* @param inCrden_tipo TIPO DE DENUNCIA
RESIDENCIA ->   0
GESTION EMPLEO ->  1
	* @param inCrden_denuncia ESTADO QUE DETERMINA EL ORIGEN DE LA INFORMACION
DENUNCIA/SUGERENCIA
	* @param inCrden_seguimiento CAMPO DE REGISTRO DE SEGUIMIENTO DE LA DENUNCIA
	* @param inCrden_estado_denuncia ESTADO DEL REGISTRO, RECOGE INFORMACION PARA DETERMINAR SI ESTA:
REGISTRADA
REVISADA
DESCARTADA
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCrden_codigo")String inCrden_codigo,
		@WebParam(name="inCusu_codigo")String inCusu_codigo,
		@WebParam(name="inCrden_anio")String inCrden_anio,
		@WebParam(name="inCrden_numero")String inCrden_numero,
		@WebParam(name="inCrden_fecha_recepcion")java.util.Date inCrden_fecha_recepcion,
		@WebParam(name="inCrden_numero_doc_ident")String inCrden_numero_doc_ident,
		@WebParam(name="inCrden_nombres")String inCrden_nombres,
		@WebParam(name="inCrden_apellidos")String inCrden_apellidos,
		@WebParam(name="inCrden_descripcion")String inCrden_descripcion,
		@WebParam(name="inCrden_contacto")String inCrden_contacto,
		@WebParam(name="inCrden_tipo")int inCrden_tipo,
		@WebParam(name="inCrden_denuncia")boolean inCrden_denuncia,
		@WebParam(name="inCrden_seguimiento")String inCrden_seguimiento,
		@WebParam(name="inCrden_estado_denuncia")int inCrden_estado_denuncia
	){
		boolean res = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_denuncia obj = new com.besixplus.sii.objects.Cgg_res_denuncia();
		obj.setCRDEN_CODIGO(inCrden_codigo);
		obj.setCUSU_CODIGO(inCusu_codigo);
		obj.setCRDEN_ANIO(inCrden_anio);
		obj.setCRDEN_NUMERO(inCrden_numero);
		obj.setCRDEN_FECHA_RECEPCION(inCrden_fecha_recepcion);
		obj.setCRDEN_NUMERO_DOC_IDENT(inCrden_numero_doc_ident);
		obj.setCRDEN_NOMBRES(inCrden_nombres);
		obj.setCRDEN_APELLIDOS(inCrden_apellidos);
		obj.setCRDEN_DESCRIPCION(inCrden_descripcion);
		obj.setCRDEN_CONTACTO(inCrden_contacto);
		obj.setCRDEN_TIPO(inCrden_tipo);
		obj.setCRDEN_DENUNCIA(inCrden_denuncia);
		obj.setCRDEN_SEGUIMIENTO(inCrden_seguimiento);
		obj.setCRDEN_ESTADO_DENUNCIA(inCrden_estado_denuncia);
		obj.setCRDEN_ESTADO(true);
		obj.setCRDEN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_denuncia(obj).update(con);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_denuncia EN UNA ESTRUCTURA JSON o XML.
	* @param inCrden_codigo IDENTIFICATIVO UNICO DE DENUNCIA.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return String REGISTRO SELECCIONADO.
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCrden_codigo")String inCrden_codigo,
		@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_denuncia tmpObj = new com.besixplus.sii.objects.Cgg_res_denuncia();
		tmpObj.setCRDEN_CODIGO(inCrden_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_denuncia(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_denuncia>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_res_denuncia.
	* @param inCrden_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCrden_codigo")String inCrden_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_denuncia tmpObj = new com.besixplus.sii.objects.Cgg_res_denuncia();
		tmpObj.setCRDEN_CODIGO(inCrden_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_res_denuncia(tmpObj).delete(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_denuncia EN UNA ESTRUCTURA JSON o XML.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	@WebMethod
	public String numeroDenuncia(
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_denuncia tmpObj = new com.besixplus.sii.objects.Cgg_res_denuncia();
		String numeroden;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			numeroden = com.besixplus.sii.db.Cgg_res_denuncia.geneNumDenuncia(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return numeroden;
		return null;
	}
	/**
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_denuncia.
	* @param inCrden_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCrden_anio ANIO DE LA DENUNCIA
	* @param inCrden_numero NUMERO DE LA DENUNCIA
	* @param inCrden_fecha_recepcion FECHA DE RECEPCION DE LA  DENUNCIA
	* @param inCrden_numero_doc_ident NUMERO DE DOCUMENTO DE IDENTIFICACION DEL DENUNCIANTE
	* @param inCrden_nombres NOMBRES DEL DENUNCIANTE
	* @param inCrden_apellidos APELLIDOS DEL DENUNCIANTE
	* @param inCrden_descripcion MOTIVO DE LA DENUNCIA
	* @param inCrden_contacto PARA CORREO ELECTRONICO O NUMERO TELEFONICO DEL DENUNCIANTE
	* @param inCrden_tipo TIPO DE DENUNCIA
RESIDENCIA ->   0
GESTION EMPLEO ->  1
	* @param inCrden_denuncia ESTADO QUE DETERMINA EL ORIGEN DE LA INFORMACION
DENUNCIA/SUGERENCIA
	* @param inCrden_seguimiento CAMPO DE REGISTRO DE SEGUIMIENTO DE LA DENUNCIA
	* @param inCrden_estado_denuncia ESTADO DEL REGISTRO, RECOGE INFORMACION PARA DETERMINAR SI ESTA:
REGISTRADA
REVISADA
DESCARTADA
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String updateDenunciaEstado(
		@WebParam(name="inCrden_codigo")String inCrden_codigo,
		@WebParam(name="inCrden_estado_denuncia")int inCrden_estado_denuncia
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_denuncia obj = new com.besixplus.sii.objects.Cgg_res_denuncia();
		obj.setCRDEN_CODIGO(inCrden_codigo);
		obj.setCRDEN_ESTADO_DENUNCIA(inCrden_estado_denuncia);
		obj.setCRDEN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_denuncia(obj).updateDenunciaNot(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return (res);
	}
	/**
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_denuncia EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	* @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	* @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	* @param keyword CRITERIO DE BUSQUEDA.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	@WebMethod
	public String selectPagePersonaDenuncia(
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
			tmpCount = com.besixplus.sii.db.Cgg_res_denuncia.selectCountDenuncia(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_denuncia.selectPersonaDenuncia(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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