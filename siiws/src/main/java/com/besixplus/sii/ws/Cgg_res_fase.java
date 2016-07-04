package com.besixplus.sii.ws;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;

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
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CLASE Cgg_res_fase
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_fase POR MEDIO DE SERVICIOS WEB.
 *
 * @autor BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_fase implements Serializable{

	private static final long serialVersionUID = 431568183;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_fase.
	 * @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO.
	 * @param inCrett_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA.
	 * @param inCgg_crett_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA.
	 * @param inCrsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SECCION.
	 * @param inCgg_crfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES.
	 * @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO USUARIO.
	 * @param inCrfas_nombre INFORMACION DE IDENTIFICACION DE LA FASE.
	 * @param inCrfas_orden ORDEN DE EJECUCION DE LA FASE.
	 * @param inCrfas_tarea_realiza TAREA QUE SE REALIZA EN ESTA FASE DEL PROCESO.
	 * @param inCrfas_funcion_ejecuta NOMBRE DE LA FUNCION O PROCEDIMIENTO QUE SE EJECUTARIA EN LA FASE.
	 * @param inCrfas_sube_adjunto ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS.
	 * @param inCrfas_sube_adjunto_requisito ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS DE REQUISITOS.
	 * @param inCrfas_ejecuta_despacho ESTADO QUE DETERMINA SI LA FUNCION SE EJECUTA AL REALIZAR DESPACHO O DISTRIBUCION.
	 * @param inCrfas_atencion_normal ESTADO QUE DETERMINA LA FASE SERA ATENDIDA EN FORMA NORMAL O A TRAVES DE OTRO PROCESO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="inCrett_codigo")String inCrett_codigo,
			@WebParam(name="inCgg_crett_codigo")String inCgg_crett_codigo,
			@WebParam(name="inCrsec_codigo")String inCrsec_codigo,
			@WebParam(name="inCgg_crfas_codigo")String inCgg_crfas_codigo,
			@WebParam(name="inCgg_cusu_codigo")String inCgg_cusu_codigo,
			@WebParam(name="inCrfas_nombre")String inCrfas_nombre,
			@WebParam(name="inCrfas_orden")int inCrfas_orden,
			@WebParam(name="inCrfas_tarea_realiza")String inCrfas_tarea_realiza,
			@WebParam(name="inCrfas_funcion_ejecuta")String inCrfas_funcion_ejecuta,
			@WebParam(name="inCrfas_sube_adjunto")boolean inCrfas_sube_adjunto,
			@WebParam(name="inCrfas_sube_adjunto_requisito")boolean inCrfas_sube_adjunto_requisito,
			@WebParam(name="inCrfas_ejecuta_despacho")boolean inCrfas_ejecuta_despacho,
			@WebParam(name="inCrfas_atencion_normal")boolean inCrfas_atencion_normal
			) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_fase obj = new com.besixplus.sii.objects.Cgg_res_fase();
		obj.setCRFAS_CODIGO("KEYGEN");
		obj.setCRPRO_CODIGO(inCrpro_codigo);
		obj.setCRETT_CODIGO(inCrett_codigo);
		obj.setCGG_CRETT_CODIGO(inCgg_crett_codigo);
		obj.setCRSEC_CODIGO(inCrsec_codigo);
		obj.setCGG_CRFAS_CODIGO(inCgg_crfas_codigo);
		obj.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
		obj.setCRFAS_NOMBRE(inCrfas_nombre);
		obj.setCRFAS_ORDEN(inCrfas_orden);
		obj.setCRFAS_TAREA_REALIZA(inCrfas_tarea_realiza);
		obj.setCRFAS_FUNCION_EJECUTA(inCrfas_funcion_ejecuta);
		obj.setCRFAS_SUBE_ADJUNTO(inCrfas_sube_adjunto);
		obj.setCRFAS_SUBE_ADJUNTO_REQUISITO(inCrfas_sube_adjunto_requisito);
		obj.setCRFAS_EJECUTA_DESPACHO(inCrfas_ejecuta_despacho);
		obj.setCRFAS_ATENCION_NORMAL(inCrfas_atencion_normal);
		obj.setCRFAS_ESTADO(true);
		obj.setCRFAS_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRFAS_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_fase(obj).insert(con);
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
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_fase.
	 * @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO.
	 * @param inCrett_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA.
	 * @param inCgg_crett_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA.
	 * @param inCrsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SECCION.
	 * @param inCgg_crfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES.
	 * @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO USUARIO.
	 * @param inCrfas_nombre INFORMACION DE IDENTIFICACION DE LA FASE.
	 * @param inCrfas_orden ORDEN DE EJECUCION DE LA FASE.
	 * @param inCrfas_tarea_realiza TAREA QUE SE REALIZA EN ESTA FASE DEL PROCESO.
	 * @param inCrfas_funcion_ejecuta NOMBRE DE LA FUNCION O PROCEDIMIENTO QUE SE EJECUTARIA EN LA FASE.
	 * @param inCrfas_sube_adjunto ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS.
	 * @param inCrfas_sube_adjunto_requisito ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS DE REQUISITOS.
	 * @param inFaseUsuario_JSON CADENA JSON DE FASE DE USUARIO. 
	 * @param inFaseCriterio_JSON CADENA JSON DE CRITERIO FASE. 
	 * @param inCrfas_ejecuta_despacho ESTADO QUE DETERMINA SI LA FUNCION SE EJECUTA AL REALIZAR DESPACHO O DISTRIBUCION.
	 * @param inCrfas_atencion_normal ESTADO QUE DETERMINA LA FASE SERA ATENDIDA EN FORMA NORMAL O A TRAVES DE OTRO PROCESO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String insert1(
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="inCrett_codigo")String inCrett_codigo,
			@WebParam(name="inCgg_crett_codigo")String inCgg_crett_codigo,
			@WebParam(name="inCrsec_codigo")String inCrsec_codigo,
			@WebParam(name="inCgg_crfas_codigo")String inCgg_crfas_codigo,
			@WebParam(name="inCgg_cusu_codigo")String inCgg_cusu_codigo,
			@WebParam(name="inCrfas_nombre")String inCrfas_nombre,
			@WebParam(name="inCrfas_orden")int inCrfas_orden,
			@WebParam(name="inCrfas_tarea_realiza")String inCrfas_tarea_realiza,
			@WebParam(name="inCrfas_funcion_ejecuta")String inCrfas_funcion_ejecuta,
			@WebParam(name="inCrfas_sube_adjunto")boolean inCrfas_sube_adjunto,
			@WebParam(name="inCrfas_sube_adjunto_requisito")boolean inCrfas_sube_adjunto_requisito,
			@WebParam(name="inFaseUsuario_JSON")String inFaseUsuario_JSON,
			@WebParam(name="inFaseCriterio_JSON")String inFaseCriterio_JSON,
			@WebParam(name = "inFaseNotificacion_JSON") String inFaseNotificacion_JSON,
			@WebParam(name="inCrfas_ejecuta_despacho")boolean inCrfas_ejecuta_despacho,
			@WebParam(name="inCrfas_atencion_normal")boolean inCrfas_atencion_normal
			){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_fase obj = new com.besixplus.sii.objects.Cgg_res_fase();
		obj.setCRFAS_CODIGO("KEYGEN");
		obj.setCRPRO_CODIGO(inCrpro_codigo);
		obj.setCRETT_CODIGO(inCrett_codigo);
		obj.setCGG_CRETT_CODIGO(inCgg_crett_codigo);
		obj.setCRSEC_CODIGO(inCrsec_codigo);
		obj.setCGG_CRFAS_CODIGO(inCgg_crfas_codigo);
		obj.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
		obj.setCRFAS_NOMBRE(inCrfas_nombre);
		obj.setCRFAS_ORDEN(inCrfas_orden);
		obj.setCRFAS_TAREA_REALIZA(inCrfas_tarea_realiza);
		obj.setCRFAS_FUNCION_EJECUTA(inCrfas_funcion_ejecuta);
		obj.setCRFAS_SUBE_ADJUNTO(inCrfas_sube_adjunto);
		obj.setCRFAS_SUBE_ADJUNTO_REQUISITO(inCrfas_sube_adjunto_requisito);
		obj.setCRFAS_EJECUTA_DESPACHO(inCrfas_ejecuta_despacho);
		obj.setCRFAS_ATENCION_NORMAL(inCrfas_atencion_normal);
		obj.setCRFAS_ESTADO(true);
		obj.setCRFAS_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRFAS_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_res_fase(obj).insert1(con);
			if (obj.getCRFAS_CODIGO() != "KEYGEN" && res.equalsIgnoreCase("true") == true)
			{
				//Insert Fase Usuario
				org.json.JSONArray objJSON = new org.json.JSONArray(inFaseUsuario_JSON);
				if (objJSON.length()>0)
				{
					res = "false";
				}

				for (int i = 0 ; i < objJSON.length(); i++){			
					com.besixplus.sii.objects.Cgg_res_fase_usuario objFaseUsuario = new com.besixplus.sii.objects.Cgg_res_fase_usuario();
					objFaseUsuario.setCRFSU_CODIGO("KEYGEN");
					objFaseUsuario.setCUSU_CODIGO(((org.json.JSONObject)objJSON.get(i)).get("CUSU_CODIGO").toString());
					objFaseUsuario.setCRFAS_CODIGO(obj.getCRFAS_CODIGO());
					objFaseUsuario.setCRFSU_ACTIVO((Boolean.parseBoolean(((org.json.JSONObject)objJSON.get(i)).get("CRFSU_ACTIVO").toString())));
					objFaseUsuario.setCRFSU_ESTADO(true);
					objFaseUsuario.setCRFSU_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objFaseUsuario.setCRFSU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());	
					res = String.valueOf(new com.besixplus.sii.db.Cgg_res_fase_usuario(objFaseUsuario).insert(con));
				}
				//Insert Criterios
				if (res.equalsIgnoreCase("true")==true){
					org.json.JSONArray objCriterioJSON = new org.json.JSONArray(inFaseCriterio_JSON);
					if (objCriterioJSON.length()>0)
					{
						res = "false";
					}
					for (int i = 0 ; i < objCriterioJSON.length(); i++){						
						com.besixplus.sii.objects.Cgg_jur_criterio objFaseCriterio = new com.besixplus.sii.objects.Cgg_jur_criterio();
						objFaseCriterio.setCJCRI_CODIGO("KEYGEN");
						objFaseCriterio.setCRFAS_CODIGO(obj.getCRFAS_CODIGO());
						objFaseCriterio.setCJCRI_REQUERIMIENTO(((org.json.JSONObject)objCriterioJSON.get(i)).get("CJCRI_REQUERIMIENTO").toString());
						objFaseCriterio.setCJCRI_REQUERIDO(Boolean.parseBoolean(((org.json.JSONObject)objCriterioJSON.get(i)).get("CJCRI_REQUERIDO").toString()));
						objFaseCriterio.setCJCRI_ESTADO(true);
						objFaseCriterio.setCJCRI_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objFaseCriterio.setCJCRI_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = String.valueOf(new com.besixplus.sii.db.Cgg_jur_criterio(objFaseCriterio).insert(con));
					}
					if (res.equalsIgnoreCase("true")==true)
					{
						con.commit();
						con.setAutoCommit(true);
						con.close();
					}

					org.json.JSONArray objNotificacionJSON = new org.json.JSONArray(inFaseNotificacion_JSON);
					if (objNotificacionJSON.length()>0)
						res = "false";
					for (int i = 0 ; i < objCriterioJSON.length(); i++){
						com.besixplus.sii.objects.Cgg_not_fase_notificacion objFaseNotificacion = new com.besixplus.sii.objects.Cgg_not_fase_notificacion();
						objFaseNotificacion.setCrpro_codigo(obj.getCRPRO_CODIGO());
						objFaseNotificacion.setCrfas_codigo(obj.getCRFAS_CODIGO());
						objFaseNotificacion.setNtml_codigo(((org.json.JSONObject)objCriterioJSON.get(i)).get("NTML_CODIGO").toString());
						objFaseNotificacion.setNtfn_destinatario(((org.json.JSONObject)objCriterioJSON.get(i)).get("NTFN_DESTINATARIO").toString());
						objFaseNotificacion.setNtfn_estado(true);
						objFaseNotificacion.setNtfn_usuario_insert(tmpRequest.getUserPrincipal().getName());
						objFaseNotificacion.setNtfn_usuario_update(tmpRequest.getUserPrincipal().getName());
						res = String.valueOf(new com.besixplus.sii.db.Cgg_not_fase_notificacion(objFaseNotificacion).insert(con));
					}
					if (res.equalsIgnoreCase("true")==true){
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
		return new Boolean(res).toString();
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
			) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_fase.selectAll(con, tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			return outCadena.toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_fase EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_fase.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_fase.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_fase EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPageDirect(
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
			tmpCount = com.besixplus.sii.db.Cgg_res_fase.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_fase.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}


	/**
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_fase.
	 * @param inCrfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	 * @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	 * @param inCrett_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA
	 * @param inCgg_crett_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA
	 * @param inCrsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SECCION
	 * @param inCgg_crfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	 * @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	 * @param inCrfas_nombre INFORMACION DE IDENTIFICACION DE LA FASE
	 * @param inCrfas_orden ORDEN DE EJECUCION DE LA FASE
	 * @param inCrfas_tarea_realiza TAREA QUE SE REALIZA EN ESTA FASE DEL PROCESO
	 * @param inCrfas_funcion_ejecuta NOMBRE DE LA FUNCION O PROCEDIMIENTO QUE SE EJECUTARIA EN LA FASE
	 * @param inCrfas_sube_adjunto ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS
	 * @param inCrfas_sube_adjunto_requisito ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS DE REQUISITOS
	 * @param inCrfas_ejecuta_despacho ESTADO QUE DETERMINA SI LA FUNCION SE EJECUTA AL REALIZAR DESPACHO O DISTRIBUCION
	 * @param inCrfas_atencion_normal ESTADO QUE DETERMINA LA FASE SERA ATENDIDA EN FORMA NORMAL O A TRAVES DE OTRO PROCESO
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrfas_codigo")String inCrfas_codigo,
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="inCrett_codigo")String inCrett_codigo,
			@WebParam(name="inCgg_crett_codigo")String inCgg_crett_codigo,
			@WebParam(name="inCrsec_codigo")String inCrsec_codigo,
			@WebParam(name="inCgg_crfas_codigo")String inCgg_crfas_codigo,
			@WebParam(name="inCgg_cusu_codigo")String inCgg_cusu_codigo,
			@WebParam(name="inCrfas_nombre")String inCrfas_nombre,
			@WebParam(name="inCrfas_orden")int inCrfas_orden,
			@WebParam(name="inCrfas_tarea_realiza")String inCrfas_tarea_realiza,
			@WebParam(name="inCrfas_funcion_ejecuta")String inCrfas_funcion_ejecuta,
			@WebParam(name="inCrfas_sube_adjunto")boolean inCrfas_sube_adjunto,
			@WebParam(name="inCrfas_sube_adjunto_requisito")boolean inCrfas_sube_adjunto_requisito,
			@WebParam(name="inCrfas_ejecuta_despacho")boolean inCrfas_ejecuta_despacho,
			@WebParam(name="inCrfas_atencion_normal")boolean inCrfas_atencion_normal
			) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_fase obj = new com.besixplus.sii.objects.Cgg_res_fase();
		obj.setCRFAS_CODIGO(inCrfas_codigo);
		obj.setCRPRO_CODIGO(inCrpro_codigo);
		obj.setCRETT_CODIGO(inCrett_codigo);
		obj.setCGG_CRETT_CODIGO(inCgg_crett_codigo);
		obj.setCRSEC_CODIGO(inCrsec_codigo);
		obj.setCGG_CRFAS_CODIGO(inCgg_crfas_codigo);
		obj.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
		obj.setCRFAS_NOMBRE(inCrfas_nombre);
		obj.setCRFAS_ORDEN(inCrfas_orden);
		obj.setCRFAS_TAREA_REALIZA(inCrfas_tarea_realiza);
		obj.setCRFAS_FUNCION_EJECUTA(inCrfas_funcion_ejecuta);
		obj.setCRFAS_SUBE_ADJUNTO(inCrfas_sube_adjunto);
		obj.setCRFAS_SUBE_ADJUNTO_REQUISITO(inCrfas_sube_adjunto_requisito);
		obj.setCRFAS_EJECUTA_DESPACHO(inCrfas_ejecuta_despacho);
		obj.setCRFAS_ATENCION_NORMAL(inCrfas_atencion_normal);
		obj.setCRFAS_ESTADO(true);
		obj.setCRFAS_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_fase(obj).update(con);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_fase.
	 * @param inCrfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	 * @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	 * @param inCrett_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA POSITIVA
	 * @param inCgg_crett_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESTADO DE TRAMITE RESPUESTA NEGATIVA
	 * @param inCrsec_codigo IDENTIFICATIVO UNICO DE REGISTRO SECCION
	 * @param inCgg_crfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	 * @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO USUARIO
	 * @param inCrfas_nombre INFORMACION DE IDENTIFICACION DE LA FASE
	 * @param inCrfas_orden ORDEN DE EJECUCION DE LA FASE
	 * @param inCrfas_tarea_realiza TAREA QUE SE REALIZA EN ESTA FASE DEL PROCESO
	 * @param inCrfas_funcion_ejecuta NOMBRE DE LA FUNCION O PROCEDIMIENTO QUE SE EJECUTARIA EN LA FASE
	 * @param inCrfas_sube_adjunto ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS
	 * @param inCrfas_sube_adjunto_requisito ESTADO QUE DETERMINA LA AUTORIZACION DE SUBIR ARCHIVOS ADJUNTOS DE REQUISITOS
	 * @param inCrfas_ejecuta_despacho ESTADO QUE DETERMINA SI LA FUNCION SE EJECUTA AL REALIZAR DESPACHO O DISTRIBUCION
	 * @param inCrfas_atencion_normal ESTADO QUE DETERMINA LA FASE SERA ATENDIDA EN FORMA NORMAL O A TRAVES DE OTRO PROCESO
	 * @param inFaseUsuario_JSON INFORMACION DE USUARIOS ENCARGADOS DE CUMPLIR CON LA TAREA DE LA FASE - FORMATO JSON
	 * @param inFaseCriterio_JSON INFORMACION DE CRITERIOS A REVISAR EN UNA FASE - FORMATO JSON
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String update1(
			@WebParam(name="inCrfas_codigo")String inCrfas_codigo,
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="inCrett_codigo")String inCrett_codigo,
			@WebParam(name="inCgg_crett_codigo")String inCgg_crett_codigo,
			@WebParam(name="inCrsec_codigo")String inCrsec_codigo,
			@WebParam(name="inCgg_crfas_codigo")String inCgg_crfas_codigo,
			@WebParam(name="inCgg_cusu_codigo")String inCgg_cusu_codigo,
			@WebParam(name="inCrfas_nombre")String inCrfas_nombre,
			@WebParam(name="inCrfas_orden")int inCrfas_orden,
			@WebParam(name="inCrfas_tarea_realiza")String inCrfas_tarea_realiza,
			@WebParam(name="inCrfas_funcion_ejecuta")String inCrfas_funcion_ejecuta,
			@WebParam(name="inCrfas_sube_adjunto")boolean inCrfas_sube_adjunto,
			@WebParam(name="inCrfas_sube_adjunto_requisito")boolean inCrfas_sube_adjunto_requisito,
			@WebParam(name="inCrfas_ejecuta_despacho")boolean inCrfas_ejecuta_despacho,
			@WebParam(name="inCrfas_atencion_normal")boolean inCrfas_atencion_normal,
			@WebParam(name="inFaseUsuario_JSON")String inFaseUsuario_JSON,
			@WebParam(name="inFaseCriterio_JSON")String inFaseCriterio_JSON,
			@WebParam(name = "inFaseNotificacion_JSON") String inFaseNotificacion_JSON
			){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_fase obj = new com.besixplus.sii.objects.Cgg_res_fase();
		obj.setCRFAS_CODIGO(inCrfas_codigo);
		obj.setCRPRO_CODIGO(inCrpro_codigo);
		obj.setCRETT_CODIGO(inCrett_codigo);
		obj.setCGG_CRETT_CODIGO(inCgg_crett_codigo);
		obj.setCRSEC_CODIGO(inCrsec_codigo);
		obj.setCGG_CRFAS_CODIGO(inCgg_crfas_codigo);
		obj.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
		obj.setCRFAS_NOMBRE(inCrfas_nombre);
		obj.setCRFAS_ORDEN(inCrfas_orden);
		obj.setCRFAS_TAREA_REALIZA(inCrfas_tarea_realiza);
		obj.setCRFAS_FUNCION_EJECUTA(inCrfas_funcion_ejecuta);
		obj.setCRFAS_SUBE_ADJUNTO(inCrfas_sube_adjunto);
		obj.setCRFAS_SUBE_ADJUNTO_REQUISITO(inCrfas_sube_adjunto_requisito);
		obj.setCRFAS_EJECUTA_DESPACHO(inCrfas_ejecuta_despacho);
		obj.setCRFAS_ATENCION_NORMAL(inCrfas_atencion_normal);
		obj.setCRFAS_ESTADO(true);
		obj.setCRFAS_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRFAS_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_res_fase(obj).update(con);
			if (res.equalsIgnoreCase("true") == true)
			{
				//Insert Fase Usuario
				org.json.JSONArray objJSON = new org.json.JSONArray(inFaseUsuario_JSON);
				if (objJSON.length()>0)
				{
					res = "false";
				}

				for (int i = 0 ; i < objJSON.length(); i++){			
					com.besixplus.sii.objects.Cgg_res_fase_usuario objFaseUsuario = new com.besixplus.sii.objects.Cgg_res_fase_usuario();

					objFaseUsuario.setCUSU_CODIGO(((org.json.JSONObject)objJSON.get(i)).get("CUSU_CODIGO").toString());
					objFaseUsuario.setCRFAS_CODIGO(obj.getCRFAS_CODIGO());
					objFaseUsuario.setCRFSU_ACTIVO((Boolean.parseBoolean(((org.json.JSONObject)objJSON.get(i)).get("CRFSU_ACTIVO").toString())));
					objFaseUsuario.setCRFSU_ESTADO(true);
					objFaseUsuario.setCRFSU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					if(((org.json.JSONObject)objJSON.get(i)).get("CRFSU_CODIGO").toString().equals("KEYGEN"))
					{
						objFaseUsuario.setCRFSU_CODIGO("KEYGEN");
						objFaseUsuario.setCRFSU_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						res = String.valueOf(new com.besixplus.sii.db.Cgg_res_fase_usuario(objFaseUsuario).insert(con));

					}
					else
					{
						objFaseUsuario.setCRFSU_CODIGO(((org.json.JSONObject)objJSON.get(i)).get("CRFSU_CODIGO").toString());
						res = String.valueOf(new com.besixplus.sii.db.Cgg_res_fase_usuario(objFaseUsuario).update(con));
					}

				}
				//Insert Criterios
				if (res.equalsIgnoreCase("true")==true){
					org.json.JSONArray objCriterioJSON = new org.json.JSONArray(inFaseCriterio_JSON);
					if (objCriterioJSON.length()>0)
					{
						res = "false";
					}
					for (int i = 0 ; i < objCriterioJSON.length(); i++){						
						com.besixplus.sii.objects.Cgg_jur_criterio objFaseCriterio = new com.besixplus.sii.objects.Cgg_jur_criterio();
						objFaseCriterio.setCJCRI_CODIGO("KEYGEN");
						objFaseCriterio.setCRFAS_CODIGO(obj.getCRFAS_CODIGO());
						objFaseCriterio.setCJCRI_REQUERIMIENTO(((org.json.JSONObject)objCriterioJSON.get(i)).get("CJCRI_REQUERIMIENTO").toString());
						objFaseCriterio.setCJCRI_REQUERIDO(Boolean.parseBoolean(((org.json.JSONObject)objCriterioJSON.get(i)).get("CJCRI_REQUERIDO").toString()));
						objFaseCriterio.setCJCRI_ESTADO(true);
						objFaseCriterio.setCJCRI_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						if(((org.json.JSONObject)objCriterioJSON.get(i)).get("CJCRI_CODIGO").toString().equals("KEYGEN"))
						{
							objFaseCriterio.setCJCRI_CODIGO("KEYGEN");
							objFaseCriterio.setCJCRI_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							res = String.valueOf(new com.besixplus.sii.db.Cgg_jur_criterio(objFaseCriterio).insert(con));

						}
						else
						{
							objFaseCriterio.setCJCRI_CODIGO(((org.json.JSONObject)objCriterioJSON.get(i)).get("CJCRI_CODIGO").toString());
							res = String.valueOf(new com.besixplus.sii.db.Cgg_jur_criterio(objFaseCriterio).update(con));
						}

					}
					if (res.equalsIgnoreCase("true")==true)
					{
						con.commit();
						con.setAutoCommit(true);
						con.close();
					}

					//Insert Mensajes
					org.json.JSONArray objNotificacionJSON = new org.json.JSONArray(inFaseNotificacion_JSON);
					if (objNotificacionJSON.length()>0)
						res = "false";
					for (int i = 0 ; i < objCriterioJSON.length(); i++){
						com.besixplus.sii.objects.Cgg_not_fase_notificacion objFaseNotificacion = new com.besixplus.sii.objects.Cgg_not_fase_notificacion();
						objFaseNotificacion.setCrpro_codigo(obj.getCRPRO_CODIGO());
						objFaseNotificacion.setCrfas_codigo(obj.getCRFAS_CODIGO());
						objFaseNotificacion.setNtml_codigo(((org.json.JSONObject)objCriterioJSON.get(i)).get("NTML_CODIGO").toString());
						objFaseNotificacion.setNtfn_destinatario(((org.json.JSONObject)objCriterioJSON.get(i)).get("NTFN_DESTINATARIO").toString());
						objFaseNotificacion.setNtfn_estado(true);
						objFaseNotificacion.setNtfn_usuario_insert(tmpRequest.getUserPrincipal().getName());
						objFaseNotificacion.setNtfn_usuario_update(tmpRequest.getUserPrincipal().getName());
						res = String.valueOf(new com.besixplus.sii.db.Cgg_not_fase_notificacion(objFaseNotificacion).insert(con));
					}
					if (res.equalsIgnoreCase("true")==true){
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
		return new Boolean(res).toString();
	}

	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_fase EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrfas_codigo IDENTIFICATIVO UNICO DE FASE.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrfas_codigo")String inCrfas_codigo,
			@WebParam(name="format")String format
			) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_fase tmpObj = new com.besixplus.sii.objects.Cgg_res_fase();
		tmpObj.setCRFAS_CODIGO(inCrfas_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_fase(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_fase> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}


	/**
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_fase.
	 * @param inCrfas_codigo IDENTIFICATIVO UNICO DE REGISTRO DE FASES
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrfas_codigo")String inCrfas_codigo
			) throws SOAPException{
		String outResult = "false";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_fase tmpObj = new com.besixplus.sii.objects.Cgg_res_fase();
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase> faseHijo = null;
		tmpObj.setCRFAS_CODIGO(inCrfas_codigo);
		tmpObj.setCGG_CRFAS_CODIGO(inCrfas_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			faseHijo = new com.besixplus.sii.db.Cgg_res_fase(tmpObj).selectCGG_RES_FASE(con);
			con.setAutoCommit(true);			
			if(faseHijo.size()==0){
				boolean tmpRes =new com.besixplus.sii.db.Cgg_res_fase(tmpObj).delete(con); 
				outResult = String.valueOf(tmpRes);
			}else{
				outResult = "NO SE PUEDE ELIMINAR FASES QUE TIENEN FASES HIJAS HABILITADAS";
			}
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return outResult;
	}
	/**
	 * Seleccion todas las fases con informacion de usuario de fase de un proceso en base al codigo del mismo especificado.
	 * @param inCrpro_codigo Codigo de proceso.Codigo de isla donde se desea seleccionar las fases de un proceso.
	 * @param inCisla_codigo Codigo de isla donde se desea seleccionar las fases de un proceso.
	 * @param format Cadena de formato de salida XML / JSON.
	 * @return Cadena de datos en formato especificado con informacion de fases y sus usuarios.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectCGG_RES_PROCESO(
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name="format")String format
			) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_fase tmpObj = new com.besixplus.sii.objects.Cgg_res_fase();
		tmpObj.setCRPRO_CODIGO(inCrpro_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));				
			}
			con.setAutoCommit(false);
			ArrayList<HashMap<String, Object>> obj = new com.besixplus.sii.db.Cgg_res_fase(tmpObj).selectCGG_RES_PROCESO1(con,inCisla_codigo);			
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_fase EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrfas_codigo CODIGO DE LA FASE A CONSULTAR
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectFaseContent(
			@WebParam(name="inCrfas_codigo")String inCrfas_codigo,
			@WebParam(name="format")String format
			) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_fase tmpObj = new com.besixplus.sii.objects.Cgg_res_fase();
		tmpObj.setCRFAS_CODIGO(inCrfas_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				//return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			ArrayList<HashMap<String,Object>> obj = null;
			obj = new com.besixplus.sii.db.Cgg_res_fase(tmpObj).selectDirectFase(con);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_fase EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrpro_codigo CODIGO DEL PROCESO PADRE
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectFaseProcesoContent(
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="format")String format
			) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				//return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj =  com.besixplus.sii.db.Cgg_res_fase.selectDirectFaseP(con,inCrpro_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			return tmpFormat.getData().toString();
		return null;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_fase junto con informacion de un texto de sumilla y del usuario encargado de la fase.
	 * @param inCgg_crfas_codigo Codigo de fase padre.
	 * @param inCisla_codigo Codigo de isla.
	 * @param format Cadena de formato de salida de la consulta.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA SEGUN LA TABLA DE PROCESO.
	 * @throws SOAPException
	 */
	@WebMethod
	public String selectCGG_RES_FASE1(
			@WebParam(name="inCgg_crfas_codigo")String inCgg_crfas_codigo,	
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name="format")String format
			) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_fase_hijo> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				//return null;
			}			
			con.setAutoCommit(false);
			com.besixplus.sii.objects.Cgg_res_fase objFase = new com.besixplus.sii.objects.Cgg_res_fase();
			objFase.setCGG_CRFAS_CODIGO(inCgg_crfas_codigo);

			obj = new com.besixplus.sii.db.Cgg_res_fase(objFase).selectCGG_RES_FASE1(con,inCisla_codigo);
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
	 * SELECCIONA VARIOS REGISTRO EN LA TABLA Cgg_res_fase EN UNA ESTRUCTURA JSON o XML COINCIDENTES CON EL PARAMETRO DE CONSULTA 
	 * @param inCrpro_codigo CODIGO DEL PROCESO PADRE
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectParentFase(
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,			
			@WebParam(name="format")String format
			) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				//return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj =  com.besixplus.sii.db.Cgg_res_fase.selectParentFaseByProceso(con,inCrpro_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			return tmpFormat.getData().toString();
		return null;
	}

	/**
	 * ACTUALIZA VARIOS REGISTROS EN LA TABLA Cgg_res_fase.
	 * @param inCrfase_JSON REPRESENTACION DE VARIOS REGISTROS DE FASE EN FORMATO JSON
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update2(
			@WebParam(name="inCrfase_JSON")String inCrfase_JSON
			) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				//return null;
			}
			con.setAutoCommit(false);
			com.besixplus.sii.objects.Cgg_res_fase obj;
			org.json.JSONArray arrayJSON = new org.json.JSONArray(inCrfase_JSON);
			org.json.JSONObject objJSON;
			if (arrayJSON.length()>0)
			{
				for (int i = 0 ; i < arrayJSON.length(); i++){
					obj = new com.besixplus.sii.objects.Cgg_res_fase();
					objJSON = arrayJSON.getJSONObject(i);
					obj.setCRFAS_CODIGO(objJSON.getString("CRFAS_CODIGO"));
					obj.setCRFAS_ORDEN(objJSON.getInt("CRFAS_ORDEN")+1);
					obj.setCRFAS_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res =  new com.besixplus.sii.db.Cgg_res_fase(obj).update1(con);
				}
			}
			if(res.equals("true"))
			{
				con.commit();
				con.setAutoCommit(true);
				con.close();
			}
			else
			{
				con.rollback();
				con.setAutoCommit(true);
				con.close();
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

	/**Selecciona la ultima fase de un proceso.
	 * @param inCrpro_codigo Codgio de proceso.
	 * @param inCisla_codigo IEDNTIFICATIVO UNICO DE ISLA.
	 * @param format Cadena de formato de salida JSON/XML.
	 * @return Cadena de datos en formato especificado.
	 */
	@WebMethod
	public String selectFaseFinalizacion(		
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name="format")String format
			){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_fase tmpObj = new com.besixplus.sii.objects.Cgg_res_fase();
		tmpObj.setCRPRO_CODIGO(inCrpro_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				//return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_fase(tmpObj).selectFaseFinalizacion(con,inCisla_codigo);
			ArrayList<com.besixplus.sii.objects.Cgg_res_fase> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
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
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * Seleccion la fase siguiente de la fase especificado de un proceso.
	 * @param inCrfas_codigo Codigo de fase.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE ISLA.
	 * @param format Cadena de salida de datos en formato JSON/XML.
	 * @return Cadena de datos en formato especificado.
	 */
	@WebMethod
	public String selectFaseSiguiente(		
			@WebParam(name="inCrfas_codigo")String inCrfas_codigo,
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name="format")String format
			){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_fase_hijo tmpObj = new com.besixplus.sii.objects.Cgg_res_fase_hijo();
		com.besixplus.sii.objects.Cgg_res_fase fase = new com.besixplus.sii.objects.Cgg_res_fase();
		fase.setCRFAS_CODIGO(inCrfas_codigo);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				//return null;
			}
			con.setAutoCommit(false);
			tmpObj = new com.besixplus.sii.db.Cgg_res_fase(fase).selectFaseSiguiente(con,inCisla_codigo);
			ArrayList<com.besixplus.sii.objects.Cgg_res_fase_hijo> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase_hijo>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
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
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}


	/**Selecciona la fase inicial de un proceso.
	 * @param inCrpro_codigo Codgio de proceso.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE ISLA.
	 * @param format Cadena de formato de salida JSON/XML.
	 * @return Cadena de datos en formato especificado.
	 */
	@WebMethod
	public String selectFaseInicio(		
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name="format")String format
			){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_fase tmpObj = new com.besixplus.sii.objects.Cgg_res_fase();
		tmpObj.setCRPRO_CODIGO(inCrpro_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				//return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_fase(tmpObj).selectFaseInicio(con,inCisla_codigo);
			ArrayList<com.besixplus.sii.objects.Cgg_res_fase> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_fase>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
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
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}

}