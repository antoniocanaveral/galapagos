package com.besixplus.sii.ws;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;

/**
 * CLASE Cgg_res_notificacion
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_notificacion POR MEDIO DE SERVICIOS WEB.
 *
 * @autor BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_notificacion implements Serializable{

	private static final long serialVersionUID = 1277965012;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_notificacion.
	 * @param inCrtnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE NOTIFICACION.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	 * @param inCusu_codigo IDENTIFICATIVO DE USUARIO QUE REGISTRO LA NOTIFICACION.
	 * @param inCgg_cusu_codigo IDENTIFICATIVO DE USUARIO ENCARGADO DE REALIZAR LA AUDIENCIA.
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES.
	 * @param inCrden_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DENUNCIA.
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON.
	 * @param inCrosg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION.
	 * @param inCgg_crosg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE REALIZO LA AUDIENCIA.
	 * @param inCrnot_numero_notificacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION.
	 * @param inCrnot_fecha_notificacion FECHA EN QUE SE REALIZO LA NOTIFICACION.
	 * @param inCrnot_lugar_notificacion LUGAR/LOCAL DE LA NOTIFICACION.
	 * @param inCrnot_referencia REFERENCIA DONDE SE ENTREGO LA NOTIFICACION.
	 * @param inCrnot_observacion OBSERVACION DE LA NOTIFICACION.
	 * @param inCrnot_estado_notificacion ESTADO DE LA NOTIFICACION
0 - REGISTRADA
1 - PROCESADA
2 - ANULADA.
	 * @param inCrnot_regularizacion DEFINICION DE EL STATUS MIGRATORIO DE LA PERSONA.
	 * @param inCrnot_fecha_audiencia FECHA DE  AUDIENCIA PARA ANALISIS O JUSTIFICACION DE LA NOTIFICACION.
	 * @param inCrnot_extracto_audiencia RESUMEN DEL CONTENIDO DE LA AUDIENCIA.
	 * @param inCrnot_observacion_audiencia OBSERVACION REGSITRADA EN AL AUDIENCIA.
	 * @param inCrnot_procede_notificacion ESTADO QUE DETERMINA SI SE  APLICA LA NOTIFICACION
SI
NO.
	 * @param inCrnot_descripcion_adjunto_aud DESCRIPCION DEL DOCUMENTO ADJUNTO.
	 * @param inCrnot_nombre_adjunto_audiencia NOMBRE DEL DOCUMENTO ADJUNTO DE LA AUDIENCIA.
	 * @param inCrnot_adjunto_audiencia DOCUMENTO DIGITAL ADJUNTO DE LA AUDIENCIA.
	 * @param inCrnot_fecha_salida_volunt FECHA DE SALIDA VOLUNTARIA COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION.
	 * @param inCrnot_fecha_expulsion FECHA DE EXPULSION COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrtnt_codigo")String inCrtnt_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCusu_codigo")String inCusu_codigo,
			@WebParam(name="inCgg_cusu_codigo")String inCgg_cusu_codigo,
			@WebParam(name="inCrres_codigo")String inCrres_codigo,
			@WebParam(name="inCrden_codigo")String inCrden_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCrosg_codigo")String inCrosg_codigo,
			@WebParam(name="inCgg_crosg_codigo")String inCgg_crosg_codigo,
			@WebParam(name="inCrnot_numero_notificacion")String inCrnot_numero_notificacion,
			@WebParam(name="inCrnot_fecha_notificacion")java.util.Date inCrnot_fecha_notificacion,
			@WebParam(name="inCrnot_lugar_notificacion")String inCrnot_lugar_notificacion,
			@WebParam(name="inCrnot_referencia")String inCrnot_referencia,
			@WebParam(name="inCrnot_observacion")String inCrnot_observacion,
			@WebParam(name="inCrnot_estado_notificacion")int inCrnot_estado_notificacion,
			@WebParam(name="inCrnot_regularizacion")String inCrnot_regularizacion,
			@WebParam(name="inCrnot_fecha_audiencia")java.util.Date inCrnot_fecha_audiencia,
			@WebParam(name="inCrnot_extracto_audiencia")String inCrnot_extracto_audiencia,
			@WebParam(name="inCrnot_observacion_audiencia")String inCrnot_observacion_audiencia,
			@WebParam(name="inCrnot_procede_notificacion")boolean inCrnot_procede_notificacion,
			@WebParam(name="inCrnot_descripcion_adjunto_aud")String inCrnot_descripcion_adjunto_aud,
			@WebParam(name="inCrnot_nombre_adjunto_audiencia")String inCrnot_nombre_adjunto_audiencia,
			@WebParam(name="inCrnot_adjunto_audiencia")String inCrnot_adjunto_audiencia,
			@WebParam(name="inCrnot_fecha_salida_volunt")java.util.Date inCrnot_fecha_salida_volunt,
			@WebParam(name="inCrnot_fecha_expulsion")java.util.Date inCrnot_fecha_expulsion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_notificacion obj = new com.besixplus.sii.objects.Cgg_res_notificacion();
		obj.setCRNOT_CODIGO("KEYGEN");
		obj.setCRTNT_CODIGO(inCrtnt_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCUSU_CODIGO(inCusu_codigo);
		obj.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
		obj.setCRRES_CODIGO(inCrres_codigo);
		obj.setCRDEN_CODIGO(inCrden_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);
		obj.setCROSG_CODIGO(inCrosg_codigo);
		obj.setCGG_CROSG_CODIGO(inCgg_crosg_codigo);
		obj.setCRNOT_NUMERO_NOTIFICACION(inCrnot_numero_notificacion);
		obj.setCRNOT_FECHA_NOTIFICACION(inCrnot_fecha_notificacion);
		obj.setCRNOT_LUGAR_NOTIFICACION(inCrnot_lugar_notificacion);
		obj.setCRNOT_REFERENCIA(inCrnot_referencia);
		obj.setCRNOT_OBSERVACION(inCrnot_observacion);
		obj.setCRNOT_ESTADO_NOTIFICACION(inCrnot_estado_notificacion);
		obj.setCRNOT_ESTADO(true);
		obj.setCRNOT_REGULARIZACION(inCrnot_regularizacion);
		obj.setCRNOT_FECHA_AUDIENCIA(inCrnot_fecha_audiencia);
		obj.setCRNOT_EXTRACTO_AUDIENCIA(inCrnot_extracto_audiencia);
		obj.setCRNOT_OBSERVACION_AUDIENCIA(inCrnot_observacion_audiencia);
		obj.setCRNOT_PROCEDE_NOTIFICACION(inCrnot_procede_notificacion);
		obj.setCRNOT_DESCRIPCION_ADJUNTO_AUD(inCrnot_descripcion_adjunto_aud);
		obj.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(inCrnot_nombre_adjunto_audiencia);
		obj.setCRNOT_ADJUNTO_AUDIENCIA(org.jboss.util.Base64.decode(inCrnot_adjunto_audiencia));
		obj.setCRNOT_FECHA_SALIDA_VOLUNT(inCrnot_fecha_salida_volunt);
		obj.setCRNOT_FECHA_EXPULSION(inCrnot_fecha_expulsion);
		obj.setCRNOT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRNOT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_notificacion(obj).insert(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_notificacion EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_res_notificacion.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_notificacion EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_res_notificacion.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_notificacion.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_notificacion EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_notificacion.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_notificacion.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_notificacion.
	 * @param inCrnot_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NOTIFICACION
	 * @param inCrtnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE NOTIFICACION
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	 * @param inCusu_codigo IDENTIFICATIVO DE USUARIO QUE REGISTRO LA NOTIFICACION
	 * @param inCgg_cusu_codigo IDENTIFICATIVO DE USUARIO ENCARGADO DE REALIZAR LA AUDIENCIA
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	 * @param inCrden_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DENUNCIA
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	 * @param inCrosg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE RALIZO LA NOTIFICACION
	 * @param inCgg_crosg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OFICIAL DE SEGUIMIENTO QUE REALIZO LA AUDIENCIA
	 * @param inCrnot_numero_notificacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION
	 * @param inCrnot_fecha_notificacion FECHA EN QUE SE REALIZO LA NOTIFICACION
	 * @param inCrnot_lugar_notificacion LUGAR/LOCAL DE LA NOTIFICACION
	 * @param inCrnot_referencia REFERENCIA DONDE SE ENTREGO LA NOTIFICACION
	 * @param inCrnot_observacion OBSERVACION DE LA NOTIFICACION
	 * @param inCrnot_estado_notificacion ESTADO DE LA NOTIFICACION
0 - REGISTRADA
1 - PROCESADA
2 - ANULADA
	 * @param inCrnot_regularizacion DEFINICION DE EL STATUS MIGRATORIO DE LA PERSONA
	 * @param inCrnot_fecha_audiencia FECHA DE  AUDIENCIA PARA ANALISIS O JUSTIFICACION DE LA NOTIFICACION
	 * @param inCrnot_extracto_audiencia RESUMEN DEL CONTENIDO DE LA AUDIENCIA
	 * @param inCrnot_observacion_audiencia OBSERVACION REGSITRADA EN AL AUDIENCIA
	 * @param inCrnot_procede_notificacion ESTADO QUE DETERMINA SI SE  APLICA LA NOTIFICACION
SI
NO
	 * @param inCrnot_descripcion_adjunto_aud DESCRIPCION DEL DOCUMENTO ADJUNTO
	 * @param inCrnot_nombre_adjunto_audiencia NOMBRE DEL DOCUMENTO ADJUNTO DE LA AUDIENCIA
	 * @param inCrnot_adjunto_audiencia DOCUMENTO DIGITAL ADJUNTO DE LA AUDIENCIA
	 * @param inCrnot_fecha_salida_volunt FECHA DE SALIDA VOLUNTARIA COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	 * @param inCrnot_fecha_expulsion FECHA DE EXPULSION COMO CONSECUENCIA DE LA APLICACION DE LA RESOLUCION
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrnot_codigo")String inCrnot_codigo,
			@WebParam(name="inCrtnt_codigo")String inCrtnt_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCusu_codigo")String inCusu_codigo,
			@WebParam(name="inCgg_cusu_codigo")String inCgg_cusu_codigo,
			@WebParam(name="inCrres_codigo")String inCrres_codigo,
			@WebParam(name="inCrden_codigo")String inCrden_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCrosg_codigo")String inCrosg_codigo,
			@WebParam(name="inCgg_crosg_codigo")String inCgg_crosg_codigo,
			@WebParam(name="inCrnot_numero_notificacion")String inCrnot_numero_notificacion,
			@WebParam(name="inCrnot_fecha_notificacion")java.util.Date inCrnot_fecha_notificacion,
			@WebParam(name="inCrnot_lugar_notificacion")String inCrnot_lugar_notificacion,
			@WebParam(name="inCrnot_referencia")String inCrnot_referencia,
			@WebParam(name="inCrnot_observacion")String inCrnot_observacion,
			@WebParam(name="inCrnot_estado_notificacion")int inCrnot_estado_notificacion,
			@WebParam(name="inCrnot_regularizacion")String inCrnot_regularizacion,
			@WebParam(name="inCrnot_fecha_audiencia")java.util.Date inCrnot_fecha_audiencia,
			@WebParam(name="inCrnot_extracto_audiencia")String inCrnot_extracto_audiencia,
			@WebParam(name="inCrnot_observacion_audiencia")String inCrnot_observacion_audiencia,
			@WebParam(name="inCrnot_procede_notificacion")boolean inCrnot_procede_notificacion,
			@WebParam(name="inCrnot_descripcion_adjunto_aud")String inCrnot_descripcion_adjunto_aud,
			@WebParam(name="inCrnot_nombre_adjunto_audiencia")String inCrnot_nombre_adjunto_audiencia,
			@WebParam(name="inCrnot_adjunto_audiencia")String inCrnot_adjunto_audiencia,
			@WebParam(name="inCrnot_fecha_salida_volunt")java.util.Date inCrnot_fecha_salida_volunt,
			@WebParam(name="inCrnot_fecha_expulsion")java.util.Date inCrnot_fecha_expulsion
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_notificacion obj = new com.besixplus.sii.objects.Cgg_res_notificacion();
		obj.setCRNOT_CODIGO(inCrnot_codigo);
		obj.setCRTNT_CODIGO(inCrtnt_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCUSU_CODIGO(inCusu_codigo);
		obj.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
		obj.setCRRES_CODIGO(inCrres_codigo);
		obj.setCRDEN_CODIGO(inCrden_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);
		obj.setCROSG_CODIGO(inCrosg_codigo);
		obj.setCGG_CROSG_CODIGO(inCgg_crosg_codigo);
		obj.setCRNOT_NUMERO_NOTIFICACION(inCrnot_numero_notificacion);
		obj.setCRNOT_FECHA_NOTIFICACION(inCrnot_fecha_notificacion);
		obj.setCRNOT_LUGAR_NOTIFICACION(inCrnot_lugar_notificacion);
		obj.setCRNOT_REFERENCIA(inCrnot_referencia);
		obj.setCRNOT_OBSERVACION(inCrnot_observacion);
		obj.setCRNOT_ESTADO_NOTIFICACION(inCrnot_estado_notificacion);
		obj.setCRNOT_ESTADO(true);
		obj.setCRNOT_REGULARIZACION(inCrnot_regularizacion);
		obj.setCRNOT_FECHA_AUDIENCIA(inCrnot_fecha_audiencia);
		obj.setCRNOT_EXTRACTO_AUDIENCIA(inCrnot_extracto_audiencia);
		obj.setCRNOT_OBSERVACION_AUDIENCIA(inCrnot_observacion_audiencia);
		obj.setCRNOT_PROCEDE_NOTIFICACION(inCrnot_procede_notificacion);
		obj.setCRNOT_DESCRIPCION_ADJUNTO_AUD(inCrnot_descripcion_adjunto_aud);
		obj.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(inCrnot_nombre_adjunto_audiencia);
		obj.setCRNOT_ADJUNTO_AUDIENCIA(org.jboss.util.Base64.decode(inCrnot_adjunto_audiencia));
		obj.setCRNOT_FECHA_SALIDA_VOLUNT(inCrnot_fecha_salida_volunt);
		obj.setCRNOT_FECHA_EXPULSION(inCrnot_fecha_expulsion);
		obj.setCRNOT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_notificacion(obj).update(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_notificacion EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrnot_codigo crnot_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrnot_codigo")String inCrnot_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_notificacion tmpObj = new com.besixplus.sii.objects.Cgg_res_notificacion();
		tmpObj.setCRNOT_CODIGO(inCrnot_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_notificacion(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_notificacion>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_notificacion.
	 * @param inCrnot_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NOTIFICACION
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrnot_codigo")String inCrnot_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_notificacion tmpObj = new com.besixplus.sii.objects.Cgg_res_notificacion();
		tmpObj.setCRNOT_CODIGO(inCrnot_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_res_notificacion(tmpObj).delete(con);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectNotificacionConsulta(
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
			tmpCount = com.besixplus.sii.db.Cgg_res_notificacion.selectNotificacionCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_notificacion.selectNotificacionConsulta(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_notificacion EN UNA ESTRUCTURA JSON o XML.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	@WebMethod
	public String numeroNotificacion(		
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_notificacion tmpObj = new com.besixplus.sii.objects.Cgg_res_notificacion();
		String numeronot;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			numeronot = com.besixplus.sii.db.Cgg_res_notificacion.geneNumNotificacion(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return numeronot;
		return null;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_notificacion EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrnot_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NOTIFICACION
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	@WebMethod
	public String tiempoAudiencia(	
			@WebParam(name="inCrnot_codigo")String inCrnot_codigo

	){	
		boolean tiempomax;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_notificacion tmpObj = new com.besixplus.sii.objects.Cgg_res_notificacion();
		tmpObj.setCRNOT_CODIGO(inCrnot_codigo);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tiempomax = new com.besixplus.sii.db.Cgg_res_notificacion(tmpObj).timpoMaximoAudiencia(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return new Boolean(tiempomax).toString();
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona,Cgg_res_movilidad,Cgg_res_residencia EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectNotificacionConsultaNoResidente(
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
			tmpCount = com.besixplus.sii.db.Cgg_res_notificacion.selectNotificacionNoResidenteCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_notificacion.selectNotificacionConsultaNoResidente(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad,cgg_res_residencia,cgg_res_persona EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_num_doc_identific NUMERO DOCUMENTO IDENTIFICATIVO DE PERSONA 
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectPersonaNoResidente(
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		//com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
		//tmpObj.setCRPER_CODIGO(inCrper_codigo);
		ArrayList<HashMap<String,Object>> per = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			per = com.besixplus.sii.db.Cgg_res_notificacion.selectPersonaSelectNoResidente(con,inCrper_num_doc_identific);
			//ArrayList<com.besixplus.sii.objects.Cgg_res_persona> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
			//tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, per);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (per!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona,Cgg_res_movilidad,Cgg_res_residencia EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectResolucionNotificacion(
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
			tmpCount = com.besixplus.sii.db.Cgg_res_notificacion.selectResolucionCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_notificacion.selectResolucion(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona,Cgg_res_oficial_seguimiento EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectOficialJefe(
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
			tmpCount = com.besixplus.sii.db.Cgg_res_notificacion.selectOficialseguimientoCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_notificacion.selectOficialseguimiento(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_muelle.
	 * @param inCrmle_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCrmle_nombre NOMBRE DEL MUELLE
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String updateEstado(
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_notificacion obj = new com.besixplus.sii.objects.Cgg_res_notificacion();

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}	
			res = new com.besixplus.sii.db.Cgg_res_notificacion(obj).updateEstadoNotificacion(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA cgg_res_residencia,cgg_res_persona EN UNA ESTRUCTURA JSON o XML. 
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectPersonaOffline(
			@WebParam(name="format")String format,
			@WebParam(name="in_Canton")String in_Canton
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		//HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		//com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
		//tmpObj.setCRPER_CODIGO(inCrper_codigo);
		ArrayList<HashMap<String,Object>> per = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			/*if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}*/
			//con.setAutoCommit(!ManagerConnection.isDeployed());
			con.setAutoCommit(false);
			per = com.besixplus.sii.db.Cgg_res_notificacion.selectPersonaSelectoff(con, "1",in_Canton);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format,per);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (per!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_OFICIAL_SEGUIMIENTO EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectOficialOffline(
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		//com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
		//tmpObj.setCRPER_CODIGO(inCrper_codigo);
		ArrayList<HashMap<String,Object>> per = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			per = com.besixplus.sii.db.Cgg_res_notificacion.selectOficialSelectoff(con, tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format,per);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (per!= null)
			return tmpFormat.getData().toString();
		return null;
	}
}