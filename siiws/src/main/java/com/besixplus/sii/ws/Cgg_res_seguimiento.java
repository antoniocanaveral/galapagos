package com.besixplus.sii.ws;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.misc.CGGEnumerators;
import com.besixplus.sii.misc.CGGEnumerators.*;
import com.besixplus.sii.objects.Cgg_res_fase;
import com.besixplus.sii.objects.Cgg_res_novedad_notificacion;
import com.besixplus.sii.objects.Cgg_res_tramite;
import com.besixplus.sii.objects.ServerResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * CLASE Cgg_res_seguimiento
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_seguimiento POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_seguimiento implements Serializable{

	private static final long serialVersionUID = 1496025058;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_seguimiento.
	 * @param inCgg_crseg_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	 * @param inCrfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASE DE SEGUIMIENTO.
	 * @param inCgg_crfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASE ANTERIOR.
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO.
	 * @param inCrseg_descripcion DESCRIPCION DEL SEGUIMIENTO.
	 * @param inCrseg_estado_atencion VALORES QUE PUEDE TOMAR UN SEGUIMIENTO
0 - RECIBIDO
1 - REVISADO
2 - DISTRIBUIDO
3 - PENDIENTE
4 - DESPACHADO
5 - FINALIZADO 
6 - INHABILITADO.
	 * @param inCrseg_observacion DATOS DE INTERES APUNTADOS EN EL SEGUIMIENTO  - HISTORIAL FORMATO JSON.
	 * @param inCrseg_tipo_respuesta VALORES FINALES RESULTADO DEL SEGUIMIENTO
-1 - INDETERMINADO
0 - NEGADO
1 - APROBADO
.
	 * @param inCrseg_tipo_actividad ACTIVIDAD SUGERIDA EN EL SEGUIMIENTO ANTERIOR.
	 * @param inCrseg_fecha_recepcion FECHA DE RECEPCION DEL SEGUIMIENTO.
	 * @param inCrseg_fecha_revision FECHA DE REVISION DEL SEGUIMIENTO.
	 * @param inCrseg_fecha_despacho FECHA DE ATENCION Y DESPACHO DEL TRAMITE GENERANDO UN NUEVO SEGUIMIENTO.
	 * @param inCrseg_estado_hijo ESTADO DE LAS RESPUESTAS DE LOS NODOS HIJOS
-1 - SIN HIJOS
0 - SIN RESPUESTAS
1 - RESPUESTA PARCIAL
2 - RESPUESTA TOTAL.
	 * @param inCrseg_fecha_reapertura FECHA DE REAPERTURA DEL SEGUIMIENTO.
	 * @param inCrseg_veces_revision NUMERO DE VECES QUE SE HA REVISADO EL SEGUIMIENTO.
	 * @param inCrseg_numero NUMERO ASIGNADO AL SEGUIMIENTO.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCgg_crseg_codigo")String inCgg_crseg_codigo,
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="inCrfas_codigo")String inCrfas_codigo,
			@WebParam(name="inCgg_crfas_codigo")String inCgg_crfas_codigo,
			@WebParam(name="inCusu_codigo")String inCusu_codigo,
			@WebParam(name="inCrseg_descripcion")String inCrseg_descripcion,
			@WebParam(name="inCrseg_estado_atencion")int inCrseg_estado_atencion,
			@WebParam(name="inCrseg_observacion")String inCrseg_observacion,
			@WebParam(name="inCrseg_tipo_respuesta")int inCrseg_tipo_respuesta,
			@WebParam(name="inCrseg_tipo_actividad")String inCrseg_tipo_actividad,
			@WebParam(name="inCrseg_fecha_recepcion")java.util.Date inCrseg_fecha_recepcion,
			@WebParam(name="inCrseg_fecha_revision")java.util.Date inCrseg_fecha_revision,
			@WebParam(name="inCrseg_fecha_despacho")java.util.Date inCrseg_fecha_despacho,
			@WebParam(name="inCrseg_estado_hijo")int inCrseg_estado_hijo,
			@WebParam(name="inCrseg_fecha_reapertura")java.util.Date inCrseg_fecha_reapertura,
			@WebParam(name="inCrseg_veces_revision")java.math.BigDecimal inCrseg_veces_revision,
			@WebParam(name="inCrseg_numero")java.math.BigDecimal inCrseg_numero
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_seguimiento obj = new com.besixplus.sii.objects.Cgg_res_seguimiento();
		obj.setCRSEG_CODIGO("KEYGEN");
		obj.setCGG_CRSEG_CODIGO(inCgg_crseg_codigo);
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCRFAS_CODIGO(inCrfas_codigo);
		obj.setCGG_CRFAS_CODIGO(inCgg_crfas_codigo);
		obj.setCUSU_CODIGO(inCusu_codigo);
		obj.setCRSEG_DESCRIPCION(inCrseg_descripcion);
		obj.setCRSEG_ESTADO_ATENCION(inCrseg_estado_atencion);
		obj.setCRSEG_OBSERVACION(inCrseg_observacion);
		obj.setCRSEG_TIPO_RESPUESTA(inCrseg_tipo_respuesta);
		obj.setCRSEG_TIPO_ACTIVIDAD(inCrseg_tipo_actividad);
		obj.setCRSEG_FECHA_RECEPCION(inCrseg_fecha_recepcion);
		obj.setCRSEG_FECHA_REVISION(inCrseg_fecha_revision);
		obj.setCRSEG_FECHA_DESPACHO(inCrseg_fecha_despacho);
		obj.setCRSEG_ESTADO_HIJO(inCrseg_estado_hijo);
		obj.setCRSEG_FECHA_REAPERTURA(inCrseg_fecha_reapertura);
		obj.setCRSEG_VECES_REVISION(inCrseg_veces_revision);
		obj.setCRSEG_NUMERO(inCrseg_numero);
		obj.setCRSEG_ESTADO(true);
		obj.setCRSEG_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRSEG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_seguimiento(obj).insert(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_seguimiento EN UNA ESTRUCTRA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_res_seguimiento.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_seguimiento EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_res_seguimiento.selectCount(con);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_seguimiento.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_seguimiento EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_seguimiento.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_seguimiento.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_seguimiento.
	 * @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	 * @param inCgg_crseg_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCrfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASE DE SEGUIMIENTO
	 * @param inCgg_crfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASE ANTERIOR
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	 * @param inCrseg_descripcion DESCRIPCION DEL SEGUIMIENTO
	 * @param inCrseg_estado_atencion VALORES QUE PUEDE TOMAR UN SEGUIMIENTO
0 - RECIBIDO
1 - REVISADO
2 - DISTRIBUIDO
3 - PENDIENTE
4 - DESPACHADO
5 - FINALIZADO 
6 - INHABILITADO
	 * @param inCrseg_observacion DATOS DE INTERES APUNTADOS EN EL SEGUIMIENTO  - HISTORIAL FORMATO JSON
	 * @param inCrseg_tipo_respuesta VALORES FINALES RESULTADO DEL SEGUIMIENTO
-1 - INDETERMINADO
0 - NEGADO
1 - APROBADO

	 * @param inCrseg_tipo_actividad ACTIVIDAD SUGERIDA EN EL SEGUIMIENTO ANTERIOR
	 * @param inCrseg_fecha_recepcion FECHA DE RECEPCION DEL SEGUIMIENTO
	 * @param inCrseg_fecha_revision FECHA DE REVISION DEL SEGUIMIENTO
	 * @param inCrseg_fecha_despacho FECHA DE ATENCION Y DESPACHO DEL TRAMITE GENERANDO UN NUEVO SEGUIMIENTO
	 * @param inCrseg_estado_hijo ESTADO DE LAS RESPUESTAS DE LOS NODOS HIJOS
-1 - SIN HIJOS
0 - SIN RESPUESTAS
1 - RESPUESTA PARCIAL
2 - RESPUESTA TOTAL
	 * @param inCrseg_fecha_reapertura FECHA DE REAPERTURA DEL SEGUIMIENTO
	 * @param inCrseg_veces_revision NUMERO DE VECES QUE SE HA REVISADO EL SEGUIMIENTO
	 * @param inCrseg_numero NUMERO ASIGNADO AL SEGUIMIENTO
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="inCgg_crseg_codigo")String inCgg_crseg_codigo,
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="inCrfas_codigo")String inCrfas_codigo,
			@WebParam(name="inCgg_crfas_codigo")String inCgg_crfas_codigo,
			@WebParam(name="inCusu_codigo")String inCusu_codigo,
			@WebParam(name="inCrseg_descripcion")String inCrseg_descripcion,
			@WebParam(name="inCrseg_estado_atencion")int inCrseg_estado_atencion,
			@WebParam(name="inCrseg_observacion")String inCrseg_observacion,
			@WebParam(name="inCrseg_tipo_respuesta")int inCrseg_tipo_respuesta,
			@WebParam(name="inCrseg_tipo_actividad")String inCrseg_tipo_actividad,
			@WebParam(name="inCrseg_fecha_recepcion")java.util.Date inCrseg_fecha_recepcion,
			@WebParam(name="inCrseg_fecha_revision")java.util.Date inCrseg_fecha_revision,
			@WebParam(name="inCrseg_fecha_despacho")java.util.Date inCrseg_fecha_despacho,
			@WebParam(name="inCrseg_estado_hijo")int inCrseg_estado_hijo,
			@WebParam(name="inCrseg_fecha_reapertura")java.util.Date inCrseg_fecha_reapertura,
			@WebParam(name="inCrseg_veces_revision")java.math.BigDecimal inCrseg_veces_revision,
			@WebParam(name="inCrseg_numero")java.math.BigDecimal inCrseg_numero
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_seguimiento obj = new com.besixplus.sii.objects.Cgg_res_seguimiento();
		obj.setCRSEG_CODIGO(inCrseg_codigo);
		obj.setCGG_CRSEG_CODIGO(inCgg_crseg_codigo);
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCRFAS_CODIGO(inCrfas_codigo);
		obj.setCGG_CRFAS_CODIGO(inCgg_crfas_codigo);
		obj.setCUSU_CODIGO(inCusu_codigo);
		obj.setCRSEG_DESCRIPCION(inCrseg_descripcion);
		obj.setCRSEG_ESTADO_ATENCION(inCrseg_estado_atencion);
		obj.setCRSEG_OBSERVACION(inCrseg_observacion);
		obj.setCRSEG_TIPO_RESPUESTA(inCrseg_tipo_respuesta);
		obj.setCRSEG_TIPO_ACTIVIDAD(inCrseg_tipo_actividad);
		obj.setCRSEG_FECHA_RECEPCION(inCrseg_fecha_recepcion);
		obj.setCRSEG_FECHA_REVISION(inCrseg_fecha_revision);
		obj.setCRSEG_FECHA_DESPACHO(inCrseg_fecha_despacho);
		obj.setCRSEG_ESTADO_HIJO(inCrseg_estado_hijo);
		obj.setCRSEG_FECHA_REAPERTURA(inCrseg_fecha_reapertura);
		obj.setCRSEG_VECES_REVISION(inCrseg_veces_revision);
		obj.setCRSEG_NUMERO(inCrseg_numero);
		obj.setCRSEG_ESTADO(true);
		obj.setCRSEG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_seguimiento(obj).update(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_seguimiento EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrseg_codigo crseg_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_seguimiento tmpObj = new com.besixplus.sii.objects.Cgg_res_seguimiento();
		tmpObj.setCRSEG_CODIGO(inCrseg_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_seguimiento(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_seguimiento.
	 * @param inCrseg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_seguimiento tmpObj = new com.besixplus.sii.objects.Cgg_res_seguimiento();
		tmpObj.setCRSEG_CODIGO(inCrseg_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_res_seguimiento(tmpObj).delete(con);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_seguimiento EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format Cadena de formato de salida JSON/XML.
	 * @param inCrtst_codigo CODIGO DE TIPO DE SOLICITUD DE TRAMITE
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectPageDirect1(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo
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
			tmpCount = new com.besixplus.sii.db.Cgg_res_seguimiento().selectCount1(con, keyword, tmpRequest.getUserPrincipal().getName(), inCrtst_codigo);
			obj = com.besixplus.sii.db.Cgg_res_seguimiento.selectAllDirect1(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inCrtst_codigo);						
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_seguimiento EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format Cadena de formato de salida JSON/XML.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectPageDirectVeh(
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
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpCount = new com.besixplus.sii.db.Cgg_res_seguimiento().selectCountVeh(con, keyword, tmpRequest.getUserPrincipal().getName());
			obj = com.besixplus.sii.db.Cgg_res_seguimiento.selectAllDirectVeh(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);						
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

	/**Establece a estado revisado por una unica vez un seguimiento a estado revisado. 
	 * @param inCrseg_codigo Codigo de seguimiento.
	 * @return Verdadero / falso en el cambio de estado del seguimiento.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String revisionSeguimiento(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo		
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_seguimiento objSeguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}					
			con.setAutoCommit(false);
			objSeguimiento.setCRSEG_CODIGO(inCrseg_codigo);
			objSeguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).select(con);
			if(objSeguimiento != null&&
					objSeguimiento.getCRSEG_CODIGO()!=null &&
					objSeguimiento.getCRSEG_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue()&&
					objSeguimiento.getCRSEG_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

				if(objSeguimiento.getCRSEG_ESTADO_ATENCION() == CGGEnumerators.ESTADOATENCION.RECIBIDO.getValue()){
					objSeguimiento.setCRSEG_ESTADO_ATENCION(CGGEnumerators.ESTADOATENCION.REVISADO.getValue());	
					objSeguimiento.setCRSEG_FECHA_REVISION(new Date());
					objSeguimiento.setCRSEG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());					
					res = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).update(con);
					con.commit();
				}				
			}else{
				res = "false";
			}
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}
	
	/**
	 * Despacha un seguimiento hacia la fase siguiente establecida por el proceso al que corresponde la solicitud de tramite.
	 * El seguimiento especificado actual cambia a estado Despachado en espera de que sus hijos en cualquier momento respondan los seguimientos enviados.
	 * @param inConnection Conexion a base de datos.
	 * @param inCrseg_codigo Codigo de seguimiento desde donde se envia.
	 * @param inTipo_atencion Tipo de envio del seguimiento si es de tipo Despacho a otra fase padre o Distribucion a fases hijas.
	 * @param inCrseg_seguimiento Cadena de texto en formato JSON de las fases a las cuales fue despachado el seguimiento actual.
	 * @param inCrseg_tipo_respuesta Tipo de respuesta que se ha dado al seguimiento seguimiento.
	 * @param inUserName Nombre de usuario de la sesion.
	 * @return Respondedor de aplicacion.
	 */
	@WebMethod (exclude=true) 
	public ServerResponse enviarSeguimiento(
			Connection inConnection,
			String inCrseg_codigo,
			int inTipo_atencion,
			String inCrseg_seguimiento,
			int inCrseg_tipo_respuesta,
			String inUserName
	){
		//System.out.println(inCrseg_codigo+ " " + inTipo_atencion + " " + inCrseg_seguimiento + " " + inCrseg_tipo_respuesta);
		String outResult = "true";
		String tmpMsg;
		JSONArray objJsonFasesSeguimiento=null;
		Cgg_res_fase objFaseDespacho = null,objFaseSeguimiento = null;
		com.besixplus.sii.objects.Cgg_res_seguimiento objSeguimientoHijo = null;
		String flagSeguimientoHijo = "true";
		Cgg_res_novedad_notificacion objNotificacionSeguimiento = null;
		String tipoAtencion = "";		
		Cgg_res_tramite tramite = new Cgg_res_tramite();
		String flagEstadoTramite = "true";
		ServerResponse appResponse = new ServerResponse();
		com.besixplus.sii.objects.Cgg_res_seguimiento objSeguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();
		try{			
			objSeguimiento.setCRSEG_CODIGO(inCrseg_codigo);
			objSeguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).select(inConnection);
			if(objSeguimiento != null&&
					objSeguimiento.getCRSEG_CODIGO()!=null &&
					objSeguimiento.getCRSEG_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue()&&
					objSeguimiento.getCRSEG_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

				objFaseSeguimiento=new Cgg_res_fase();
				objFaseSeguimiento.setCRFAS_CODIGO(objSeguimiento.getCRFAS_CODIGO());
				objFaseSeguimiento = new com.besixplus.sii.db.Cgg_res_fase(objFaseSeguimiento).select(inConnection); 				

				if(inTipo_atencion==CGGEnumerators.ESTADOATENCION.DESPACHADO.getValue()){
					tipoAtencion = CGGEnumerators.ESTADOATENCION.DESPACHADO.toString();
					objSeguimiento.setCRSEG_ESTADO_ATENCION(CGGEnumerators.ESTADOATENCION.DESPACHADO.getValue());
					objSeguimiento.setCRSEG_TIPO_RESPUESTA(inCrseg_tipo_respuesta);

					//MODIFICACION DEL ESTADO DEL TRAMITE SI LA FASE ESTA HABILITADA PARA MODIFICAR EL TRAMITE.					
					if(objFaseSeguimiento.getCRETT_CODIGO()!=null && 
							objFaseSeguimiento.getCRETT_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
							objFaseSeguimiento.getCRETT_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue() &&
							inCrseg_tipo_respuesta == CGGEnumerators.TIPORESPUESTA.APROBADO.getValue()){
						//PROCESAMIENTO DE RESPUESTA POSITIVA
						tramite.setCRTRA_CODIGO(objSeguimiento.getCRTRA_CODIGO()); 
						tramite = new com.besixplus.sii.db.Cgg_res_tramite(tramite).select(inConnection);

						if(tramite.getCRTRA_CODIGO() != null &&
								tramite.getCRTRA_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
								tramite.getCRTRA_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

							tramite.setCRETT_CODIGO(objFaseSeguimiento.getCRETT_CODIGO());
							tramite.setCRTRA_USUARIO_UPDATE(inUserName);
							flagEstadoTramite = new com.besixplus.sii.db.Cgg_res_tramite(tramite).update(inConnection);							
						}else{
							//TODO: ESTABLECER UN CONTROL POR LA NO EXISTENCIA DE UN TRAMITE.
						}

					}else if(objFaseSeguimiento.getCGG_CRETT_CODIGO()!=null && 
							objFaseSeguimiento.getCGG_CRETT_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
							objFaseSeguimiento.getCGG_CRETT_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue() &&
							inCrseg_tipo_respuesta == CGGEnumerators.TIPORESPUESTA.NEGADO.getValue()){
						//PROCESAMIENTO DE RESPUESTA NEGATIVA
						tramite.setCRTRA_CODIGO(objSeguimiento.getCRTRA_CODIGO()); 
						tramite = new com.besixplus.sii.db.Cgg_res_tramite(tramite).select(inConnection);

						if(tramite.getCRTRA_CODIGO() != null &&
								tramite.getCRTRA_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
								tramite.getCRTRA_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

							tramite.setCRETT_CODIGO(objFaseSeguimiento.getCGG_CRETT_CODIGO());
							//tramite.setCRTRA_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							flagEstadoTramite = new com.besixplus.sii.db.Cgg_res_tramite(tramite).update(inConnection);							
						}else{
							//TODO: ESTABLECER UN CONTROL POR LA NO EXISTENCIA DE UN TRAMITE.
						}						
					}
				}else if(inTipo_atencion==CGGEnumerators.ESTADOATENCION.DISTRIBUIDO.getValue()){
					tipoAtencion = CGGEnumerators.ESTADOATENCION.DISTRIBUIDO.toString();
					objSeguimiento.setCRSEG_ESTADO_ATENCION(CGGEnumerators.ESTADOATENCION.DISTRIBUIDO.getValue());
				}
				objSeguimiento.setCRSEG_FECHA_DESPACHO(new Date());
				objSeguimiento.setCRSEG_ESTADO_HIJO(CGGEnumerators.ESTADORESPUESTA.SINRESPUESTAS.getValue());							

				objSeguimiento.setCRSEG_USUARIO_UPDATE(inUserName);
				outResult = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).update(inConnection);

				if(outResult.equals("true")){
					//VERIFICA SI EXISTE UNA FUNCION POR EJECUTAR
					if(objFaseSeguimiento.getCRFAS_FUNCION_EJECUTA().trim().isEmpty()==false){
						if (objFaseSeguimiento.getCRFAS_EJECUTA_DESPACHO()== true && inTipo_atencion == CGGEnumerators.ESTADOATENCION.DESPACHADO.getValue()){
							tmpMsg = new com.besixplus.sii.db.Cgg_res_seguimiento().ejecutarFuncionSeguimiento(inConnection,objFaseSeguimiento.getCRFAS_FUNCION_EJECUTA(),objSeguimiento.getCRSEG_CODIGO(),inUserName);
							if (!tmpMsg.equalsIgnoreCase("false"))
								appResponse.setMsg(tmpMsg);

						}
						else if(objFaseSeguimiento.getCRFAS_EJECUTA_DESPACHO()== false && inTipo_atencion == CGGEnumerators.ESTADOATENCION.DISTRIBUIDO.getValue())
						{
							tmpMsg = new com.besixplus.sii.db.Cgg_res_seguimiento().ejecutarFuncionSeguimiento(inConnection,objFaseSeguimiento.getCRFAS_FUNCION_EJECUTA(),objSeguimiento.getCRSEG_CODIGO(),inUserName);
							if (!tmpMsg.equalsIgnoreCase("false"))
								appResponse.setMsg(tmpMsg);
						}
					}
				}

				//REGISTRO DE LA NOVEDAD NOTIFICACION PARA EL SEGUIMIENTO PADRE
				objNotificacionSeguimiento = new Cgg_res_novedad_notificacion();
				objNotificacionSeguimiento.setCRNOV_CODIGO("KEYGEN");
				objNotificacionSeguimiento.setCRSEG_CODIGO(objSeguimiento.getCRSEG_CODIGO());
				objNotificacionSeguimiento.setCRNOV_DESCRIPCION("EL TRAMITE FUE "+tipoAtencion+" EL "+ DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date()));
				objNotificacionSeguimiento.setCRNOV_TIPO(TIPONOVEDAD.COMENTARIO.getValue());				
				objNotificacionSeguimiento.setCRNOV_FECHA_REGISTRO(new Date());
				objNotificacionSeguimiento.setCRNOV_ESTADO(true);
				objNotificacionSeguimiento.setCRNOV_USUARIO_INSERT(inUserName);
				objNotificacionSeguimiento.setCRNOV_USUARIO_UPDATE(inUserName);				 				
				new com.besixplus.sii.db.Cgg_res_novedad_notificacion(objNotificacionSeguimiento).insert(inConnection);				

				if(flagEstadoTramite.equalsIgnoreCase("true") && outResult.equalsIgnoreCase("true")){

					objJsonFasesSeguimiento = new JSONArray(inCrseg_seguimiento==null?"[]":inCrseg_seguimiento);

					for(int h=0;h<objJsonFasesSeguimiento.length();h++){							
						JSONObject objJsonFaseDespacho = objJsonFasesSeguimiento.getJSONObject(h);							

						objFaseDespacho = new Cgg_res_fase();
						objFaseDespacho.setCRFAS_CODIGO(objJsonFaseDespacho.getString("CRFAS_CODIGO"));
						objFaseDespacho = new com.besixplus.sii.db.Cgg_res_fase(objFaseDespacho).select(inConnection);

						//TODO: DESCOMENTAR PARA CONTROL DE USUARIO CUANDO HAYA USUARIOS REALES.
						if(objJsonFaseDespacho.getString("CUSU_CODIGO")!=null /*&&  
										objFaseUsuario.getCUSU_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() && 
										objFaseUsuario.getCUSU_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()*/ &&
										objFaseDespacho.getCRFAS_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue()	&&
										objFaseDespacho.getCRFAS_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

							objSeguimientoHijo = new com.besixplus.sii.objects.Cgg_res_seguimiento();																		

							//REGISTRO DE LOS SEGUIMIENTOS HIJOS DE UN SEGUIMIENTO DE UN TRAMITE.
							objSeguimientoHijo.setCRSEG_CODIGO("KEYGEN");

							if(inTipo_atencion==CGGEnumerators.ESTADOATENCION.DESPACHADO.getValue()){
								objSeguimientoHijo.setCGG_CRSEG_CODIGO(null);								
							}else if(inTipo_atencion==CGGEnumerators.ESTADOATENCION.DISTRIBUIDO.getValue()){
								objSeguimientoHijo.setCGG_CRSEG_CODIGO(objSeguimiento.getCRSEG_CODIGO());								 
							}

							objSeguimientoHijo.setCRSEG_ESTADO_ATENCION(ESTADOATENCION.RECIBIDO.getValue());
							objSeguimientoHijo.setCRTRA_CODIGO(objSeguimiento.getCRTRA_CODIGO()); 
							objSeguimientoHijo.setCRFAS_CODIGO(objFaseDespacho.getCRFAS_CODIGO()); 
							objSeguimientoHijo.setCGG_CRFAS_CODIGO(objSeguimiento.getCRFAS_CODIGO()); 
							objSeguimientoHijo.setCUSU_CODIGO(objJsonFaseDespacho.getString("CUSU_CODIGO")); 
							objSeguimientoHijo.setCRSEG_DESCRIPCION(""); 																			
							objSeguimientoHijo.setCRSEG_OBSERVACION(""); 
							objSeguimientoHijo.setCRSEG_TIPO_RESPUESTA(TIPORESPUESTA.INDETERMINADO.getValue()); 
							objSeguimientoHijo.setCRSEG_TIPO_ACTIVIDAD(objFaseDespacho.getCRFAS_TAREA_REALIZA()); 
							objSeguimientoHijo.setCRSEG_FECHA_RECEPCION(new Date()); 
							objSeguimientoHijo.setCRSEG_FECHA_REVISION(null); 
							objSeguimientoHijo.setCRSEG_FECHA_DESPACHO(null); 
							objSeguimientoHijo.setCRSEG_ESTADO_HIJO(ESTADORESPUESTA.SINHIJOS.getValue()); 																										
							objSeguimientoHijo.setCRSEG_VECES_REVISION(new BigDecimal(0)); 
							objSeguimientoHijo.setCRSEG_NUMERO(new BigDecimal(0));
							objSeguimientoHijo.setCRSEG_ESTADO(true);
							objSeguimientoHijo.setCRSEG_USUARIO_INSERT(inUserName);
							objSeguimientoHijo.setCRSEG_USUARIO_UPDATE(inUserName);											

							flagSeguimientoHijo = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimientoHijo).insert(inConnection);

							if(flagSeguimientoHijo.equalsIgnoreCase("true")==false){												
								break;
							}else{

								//REGISTRO DE LA NOVEDAD NOTIFICACION PARA EL SEGUIMIENTO HIJO
								objNotificacionSeguimiento = new Cgg_res_novedad_notificacion();
								objNotificacionSeguimiento.setCRNOV_CODIGO("KEYGEN");
								objNotificacionSeguimiento.setCRSEG_CODIGO(objSeguimientoHijo.getCRSEG_CODIGO());
								objNotificacionSeguimiento.setCRNOV_DESCRIPCION(objJsonFaseDespacho.getString("CRFAS_SUMILLA")==null?"ATENDER, POR FAVOR.":objJsonFaseDespacho.getString("CRFAS_SUMILLA"));
								objNotificacionSeguimiento.setCRNOV_TIPO(TIPONOVEDAD.COMENTARIO.getValue());
								objNotificacionSeguimiento.setCRNOV_FECHA_REGISTRO(new Date());
								objNotificacionSeguimiento.setCRNOV_ESTADO(true);
								objNotificacionSeguimiento.setCRNOV_USUARIO_INSERT(inUserName);
								objNotificacionSeguimiento.setCRNOV_USUARIO_UPDATE(inUserName);

								if(objJsonFaseDespacho.getString("CRFAS_SUMILLA")!= null && 
										objJsonFaseDespacho.getString("CRFAS_SUMILLA").trim().length() >=1){
									String flagSumillaSeguimiento = new com.besixplus.sii.db.Cgg_res_novedad_notificacion(objNotificacionSeguimiento).insert(inConnection);
								}

								//NOTIFICACION A TRAVEZ DE CORREO ELECTRONICO AL USUARIO DEL SEGUIMIENTO Q RECIBIO EL SEGUIMIENTO.
								//TODO: IMPLEMENTAR LA NOTIFICACION POR CORREO ELECTRONICO.
								//Notificador objNotificador = new Notificador(inMail, inAsunto, inContenido, inNombreAdjuntos, inAdjuntos)																								
							}

						}else{
							flagSeguimientoHijo = "false";
							break;											
						}	
						if(flagSeguimientoHijo.equalsIgnoreCase("true")==false){												
							break;
						}										
					}
					if(flagSeguimientoHijo.equalsIgnoreCase("true")==true){										
						inConnection.commit();																												
					}else{
						outResult="NO SE PUDO ALMACENAR EL ENVIO DE SEGUIMIENTO.";
						inConnection.rollback();
					}											
				}else{
					outResult = "NO SE PUDO ACTUALIZAR LA INFORMACION DEL SEGUIMIENTO DE ORIGEN";
					if(!flagEstadoTramite.equalsIgnoreCase("true"))
						outResult = "NO SE PUDO ESCRIBIR EL ESTADO DEL TRAMITE A PARTIR DE LA FASE";
					inConnection.rollback();
				}																								
			}else{				
				outResult = "EL SEGUIMIENTO ESPECIFICADO NO EXISTE.";
				inConnection.rollback();
			}			
			inConnection.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				inConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			outResult = inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				inConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			outResult = inException.getMessage();
		}

		if(outResult.equals("true") )
			appResponse.setSuccess(true);
		else
		{
			appResponse.setSuccess(false);
			appResponse.setMsg(outResult);
		}
		return appResponse;
	}

	/**
	 * Despacha un seguimiento hacia la fase siguiente establecida por el proceso al que corresponde la solicitud de tramite.
	 * El seguimiento especificado actual cambia a estado Despachado en espera de que sus hijos en cualquier momento respondan los seguimientos enviados.
	 * @param inCrseg_codigo Codigo de seguimiento.
	 * @param inTipo_atencion Tipo de envio del seguimiento si es de tipo Despacho a otra fase padre o Distribucion a fases hijas.
	 * @param inCrseg_seguimiento Cadena de texto en formato JSON de las fases a las cuales fue despachado el seguimiento actual.
	 * @param inCrseg_tipo_respuesta Tipo de respuesta que se ha dado al seguimiento seguimiento.
	 * @return Cadena de texto con informacion del despacho del seguimiento.
	 */
	@WebMethod	
	public String enviarSeguimiento(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="inTipo_atencion")int inTipo_atencion,
			@WebParam(name="inCrseg_seguimiento")String inCrseg_seguimiento,
			@WebParam(name="inCrseg_tipo_respuesta")int inCrseg_tipo_respuesta			
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		Connection con = ManagerConnection.getConnection();
		ServerResponse outResponse = new ServerResponse(); 
		try {
			con.setAutoCommit(false);
			outResponse = enviarSeguimiento(con, inCrseg_codigo, inTipo_atencion, inCrseg_seguimiento, inCrseg_tipo_respuesta, tmpRequest.getUserPrincipal().getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new JSONObject(outResponse).toString();
	}

	/**
	 * Retorna el numero de registros de seguimientos del usuario de la sesion.
	 * @return Cadena de datos con el total de registro de seguimiento o con error en el conteo.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectCount1() throws SOAPException{		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();			
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}			
			tmpCount = new com.besixplus.sii.db.Cgg_res_seguimiento().selectCount1(con, "", tmpRequest.getUserPrincipal().getName());			
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}		
		return String.valueOf(tmpCount);
	}

	/**Despacha un seguimiento hijo para cambio de respuesta para su seguimiento padre.
	 * Un seguimiento distribuye a sus hijos el seguimiento de un tramite. Estos hijos son seguimientos hermanos que se encuentran a un mismo nivel, por ende todos tienen que ser atentidos.
	 * Al momento de que cada seguimiento hijo es atendido modifica el tipo de respuestas del seguimiento padre a RESPUESTAPARCIAL, pero si en este metodo se compruba que sus otros seguimientos hermanos ya se hallan DESPACHADOS., 
	 * este finalmente cambia el estado del padre a RESPUESTATOTAL.
	 * El metodo cambia es estado del seguimiento especificado, lee si sus seguimientos hermanos han sido ya atendidos para cambiar el estado del seguimiento padre deacuerdo a lo indicado en la definicion de esta ayuda.
	 * @param inCrseg_codigo Codigo de seguimiento.
	 * @param inCrseg_tipo_respuesta Tipo de respuesta de atencion del seguimiento hijo.
	 * @return Veradero/falso en la ejecucion del servicio.
	 */
	@WebMethod	
	public String despacharSeguimientoHijo(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="inCrseg_tipo_respuesta")int inCrseg_tipo_respuesta			
	){
		String outResult = "true";							
		Cgg_res_novedad_notificacion objNotificacionSeguimiento = null;
		com.besixplus.sii.objects.Cgg_res_seguimiento objSeguimientoPadre = new com.besixplus.sii.objects.Cgg_res_seguimiento();
		ArrayList<com.besixplus.sii.objects.Cgg_res_seguimiento> colSeguimientoHermanos = null;
		int totalHermanos= 0,tmpTotalHermanos =0;		

		//		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_seguimiento objSeguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();		

		try{
			Connection con = ManagerConnection.getConnection();
			//			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
			//				con.close();
			//				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
			//				return null;
			//			}
			con.setAutoCommit(false);

			objSeguimiento.setCRSEG_CODIGO(inCrseg_codigo);
			objSeguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).select(con);
			if(objSeguimiento != null&&
					objSeguimiento.getCRSEG_CODIGO()!=null &&
					objSeguimiento.getCRSEG_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue()&&
					objSeguimiento.getCRSEG_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

				objSeguimiento.setCRSEG_ESTADO_ATENCION(CGGEnumerators.ESTADOATENCION.DESPACHADO.getValue());	
				objSeguimiento.setCRSEG_ESTADO_HIJO(CGGEnumerators.ESTADORESPUESTA.SINRESPUESTAS.getValue());
				objSeguimiento.setCRSEG_TIPO_RESPUESTA(inCrseg_tipo_respuesta);
				objSeguimiento.setCRSEG_FECHA_DESPACHO(new Date());				
				//objSeguimiento.setCRSEG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

				outResult = String.valueOf(new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).update(con));	

				//REGISTRO DE LA NOVEDAD NOTIFICACION PARA EL SEGUIMIENTO PADRE
				objNotificacionSeguimiento = new Cgg_res_novedad_notificacion();
				objNotificacionSeguimiento.setCRNOV_CODIGO("KEYGEN");
				objNotificacionSeguimiento.setCRSEG_CODIGO(objSeguimiento.getCRSEG_CODIGO());
				objNotificacionSeguimiento.setCRNOV_DESCRIPCION("EL TRAMITE FUE "+CGGEnumerators.ESTADOATENCION.DESPACHADO.toString()+" EL "+ DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date()));
				objNotificacionSeguimiento.setCRNOV_TIPO(TIPONOVEDAD.COMENTARIO.getValue());				
				objNotificacionSeguimiento.setCRNOV_FECHA_REGISTRO(new Date());
				objNotificacionSeguimiento.setCRNOV_ESTADO(true);
				//				objNotificacionSeguimiento.setCRNOV_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
				//				objNotificacionSeguimiento.setCRNOV_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());				 				
				new com.besixplus.sii.db.Cgg_res_novedad_notificacion(objNotificacionSeguimiento).insert(con);	


				if(outResult.equalsIgnoreCase("true")==true){

					objSeguimientoPadre.setCRSEG_CODIGO(objSeguimiento.getCGG_CRSEG_CODIGO());
					objSeguimientoPadre = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimientoPadre).select(con);

					colSeguimientoHermanos = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).selectCGG_RES_SEGUIMIENTO(con);
					totalHermanos = colSeguimientoHermanos.size(); 
					for(java.util.Iterator<com.besixplus.sii.objects.Cgg_res_seguimiento> iSeguimientoHermano = colSeguimientoHermanos.iterator();iSeguimientoHermano.hasNext();){
						com.besixplus.sii.objects.Cgg_res_seguimiento objSeguimientoHermano = iSeguimientoHermano.next();

						if(objSeguimientoHermano.getCRSEG_ESTADO_ATENCION() == CGGEnumerators.ESTADOATENCION.DESPACHADO.getValue()){
							tmpTotalHermanos++;
						}

					}

					if(tmpTotalHermanos<totalHermanos){
						objSeguimientoPadre.setCRSEG_ESTADO_HIJO(CGGEnumerators.ESTADORESPUESTA.RESPUESTAPARCIAL.getValue());
					}else if(tmpTotalHermanos==totalHermanos){
						objSeguimientoPadre.setCRSEG_ESTADO_HIJO(CGGEnumerators.ESTADORESPUESTA.RESPUESTATOTAL.getValue());
						objSeguimientoPadre.setCRSEG_ESTADO_ATENCION(CGGEnumerators.ESTADOATENCION.REVISADODISTRIBUIDO.getValue());
					}

					String flagActualizacion = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimientoPadre).update(con);
					if(flagActualizacion.equals("true")){
						con.commit();
						outResult =String.valueOf(flagActualizacion);						
					}else{
						outResult = "NO SE PUDO ACTUALIZAR LA INFORMACION DEL SEGUIMIENTO DE ORIGEN";
						con.rollback();
					}

				}else{
					outResult = "NO SE PUDO ACTUALIZAR LA INFORMACION DEL SEGUIMIENTO DE ORIGEN";
					con.rollback();
				}																								
			}else{				
				outResult = "EL SEGUIMIENTO ESPECIFICADO NO EXISTE.";
				con.rollback();
			}
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return outResult;
	}

	/**
	 * Cambia el estado a pendiente de un seguimiento de un tramite.
	 * El estado pendiente se utiliza cuando por algun motivo el seguimiento sera atendido en un plazo mayor al normal de trabajo como por falta de documentos, o por espera de algun comunicado, entre otras razones.
	 * @param inCrseg_codigo Codigo de seguimiento.
	 * @return Verdadero/false/error en la ejecucion del metodo.
	 */
	@WebMethod	
	public String dejarPendiente(
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo
	){
		String outResult = "true";							
		Cgg_res_novedad_notificacion objNotificacionSeguimiento = null;						

		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_seguimiento objSeguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();		

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);

			objSeguimiento.setCRSEG_CODIGO(inCrseg_codigo);
			objSeguimiento = new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).select(con);
			if(objSeguimiento != null&&
					objSeguimiento.getCRSEG_CODIGO()!=null &&
					objSeguimiento.getCRSEG_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue()&&
					objSeguimiento.getCRSEG_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){

				objSeguimiento.setCRSEG_ESTADO_ATENCION(CGGEnumerators.ESTADOATENCION.PENDIENTE.getValue());	
				objSeguimiento.setCRSEG_ESTADO_HIJO(CGGEnumerators.ESTADORESPUESTA.SINRESPUESTAS.getValue());
				objSeguimiento.setCRSEG_FECHA_DESPACHO(new Date());				
				objSeguimiento.setCRSEG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

				outResult = String.valueOf(new com.besixplus.sii.db.Cgg_res_seguimiento(objSeguimiento).update(con));	

				//REGISTRO DE LA NOVEDAD NOTIFICACION PARA EL SEGUIMIENTO PADRE
				objNotificacionSeguimiento = new Cgg_res_novedad_notificacion();
				objNotificacionSeguimiento.setCRNOV_CODIGO("KEYGEN");
				objNotificacionSeguimiento.setCRSEG_CODIGO(objSeguimiento.getCRSEG_CODIGO());
				objNotificacionSeguimiento.setCRNOV_DESCRIPCION("EL TRAMITE FUE DEJADO "+CGGEnumerators.ESTADOATENCION.PENDIENTE.toString()+" EL "+ DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date()));
				objNotificacionSeguimiento.setCRNOV_TIPO(TIPONOVEDAD.COMENTARIO.getValue());				
				objNotificacionSeguimiento.setCRNOV_FECHA_REGISTRO(new Date());
				objNotificacionSeguimiento.setCRNOV_ESTADO(true);
				objNotificacionSeguimiento.setCRNOV_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
				objNotificacionSeguimiento.setCRNOV_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());				 				
				new com.besixplus.sii.db.Cgg_res_novedad_notificacion(objNotificacionSeguimiento).insert(con);	

				if(outResult.equalsIgnoreCase("true")==true){
					con.commit();
				}else{
					outResult = "NO SE PUDO ACTUALIZAR LA INFORMACION DEL SEGUIMIENTO DE ORIGEN";
					con.rollback();
				}																								
			}else{				
				outResult = "EL SEGUIMIENTO ESPECIFICADO NO EXISTE.";
				con.rollback();
			}
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return outResult;
	}

	/**Obtinene una cadena de datos con informacion de un seguimiento con tramite y tablas relacionadas.
	 * @param inCrseg_codigo Codigo de seguimiento.
	 * @param format Formato de salida JSON|XML.
	 * @return Cadena de datos.
	 */
	@WebMethod
	public String selectSeguimientoTramite(			
			@WebParam(name="inCrseg_codigo")String inCrseg_codigo,
			@WebParam(name="format")String format			
	){
		//		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		com.besixplus.sii.objects.Cgg_res_seguimiento seguimiento = new com.besixplus.sii.objects.Cgg_res_seguimiento();
		try{
			Connection con = ManagerConnection.getConnection();			
			//			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
			//				con.close();
			//				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
			//				return null;
			//			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			seguimiento.setCRSEG_CODIGO(inCrseg_codigo);
			obj = new com.besixplus.sii.db.Cgg_res_seguimiento(seguimiento).selectSeguimientoTramite(con);						
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
		return outCadena.toString();
	}
	
	/**
	 * Retorna el numero de registros de seguimientos del usuario de la sesion.
	 * @return Cadena de datos con el total de registro de seguimiento o con error en el conteo.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectCountNotificacion() throws SOAPException{		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();			
			con.setAutoCommit(false);
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}			
			obj = new com.besixplus.sii.db.Cgg_res_seguimiento().selectCountNotificacion(con, tmpRequest.getUserPrincipal().getName());			
			tmpFormat = new com.besixplus.sii.misc.Formatter("JSON", obj);
			outCadena = tmpFormat.getData();
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}		
		return outCadena.toString();
	}


}