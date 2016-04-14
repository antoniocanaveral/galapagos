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
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import org.json.JSONArray;
import org.json.JSONException;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.objects.Cgg_res_adjunto_temporal;

/**
 * CLASE Cgg_jur_historial_proceso
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_historial_proceso POR MEDIO DE SERVICIOS WEB.
 *
 * @autor BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_jur_historial_proceso implements Serializable{

	private static final long serialVersionUID = 1712622134;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_jur_historial_proceso.
	 * @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL.
	 * @param inCjhtp_descripcion DESCRIPCION DEL MOVIMIENTO DEL PROCESO JUDICIAL.
	 * @param inCjhtp_tipo TIPO DE MOVIMIENTO EN EL PROCESO JUDICIAL
0 - ENTRADA
1 - SALIDA.
	 * @param inCjhtp_responsable NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL PROCESO JUDICIAL.
	 * @param inCjhtp_fecha FECHA DE REGISTRO DE OPERACION EN EL PROCESO JUDICIAL.
	 * @param inCjadp_adjunto ARCHIVO ADJUNTO DE PROCESO.
	 * @param inCjpju_estado_ejecucion_HP ESTADO DE LA EJECUCION DEL PROCESO
0 - PLANTEADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	 * @param inTmpValorEstado TEMPORAL DE VALOR ESTADO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCjpju_codigo")String inCjpju_codigo,
			@WebParam(name="inCjhtp_descripcion")String inCjhtp_descripcion,
			@WebParam(name="inCjhtp_tipo")int inCjhtp_tipo,
			@WebParam(name="inCjhtp_responsable")String inCjhtp_responsable,
			@WebParam(name="inCjhtp_fecha")java.util.Date inCjhtp_fecha,
			@WebParam(name="inCjadp_adjunto")String inCjadp_adjunto,
			@WebParam(name="inCjpju_estado_ejecucion_HP")int inCjpju_estado_ejecucion_HP,
			@WebParam(name="inTmpValorEstado")String inTmpValorEstado

	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_historial_proceso obj = new com.besixplus.sii.objects.Cgg_jur_historial_proceso();

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			
			com.besixplus.sii.objects.Cgg_jur_proceso_judicial obj_pj = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();
			org.json.JSONArray cjadp_Adjunto = new org.json.JSONArray(inCjadp_adjunto);			
			

			con.setAutoCommit(false);
			obj.setCJHTP_CODIGO("KEYGEN");
			obj.setCJPJU_CODIGO(inCjpju_codigo);
			obj.setCJHTP_DESCRIPCION(inCjhtp_descripcion);
			obj.setCJHTP_TIPO(inCjhtp_tipo);
			obj.setCJHTP_RESPONSABLE(inCjhtp_responsable);
			obj.setCJHTP_FECHA(inCjhtp_fecha);
			obj.setCJHTP_ESTADO(true);
			obj.setCJHTP_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
			obj.setCJHTP_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
			res = new com.besixplus.sii.db.Cgg_jur_historial_proceso(obj).insert(con);


			if (res.equals("true")){
				if (inTmpValorEstado.equals("true")){
					obj_pj.setCJPJU_CODIGO(inCjpju_codigo);
					obj_pj.setCJPJU_ESTADO_EJECUCION(inCjpju_estado_ejecucion_HP);
					obj_pj.setCJPJU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_jur_proceso_judicial(obj_pj).updateEstado(con);
				}
			}
			

			
			if(res.equals("true")){
				com.besixplus.sii.objects.Cgg_jur_adjunto_proceso obj_adj = new com.besixplus.sii.objects.Cgg_jur_adjunto_proceso();
				for (int i = 0 ; i < cjadp_Adjunto.length(); i++){
					if(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_CODIGO").toString().equals("KEYGEN")){
						obj_adj.setCJADP_CODIGO("KEYGEN");
						obj_adj.setCJHTP_CODIGO(obj.getCJHTP_CODIGO());
						obj_adj.setCJADP_DESCRIPCION(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_DESCRIPCION").toString());
						obj_adj.setCJHTP_FECHA_REGISTRO(inCjhtp_fecha);
						obj_adj.setCJADP_NOMBRE_ADJUNTO(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_NOMBRE_ADJUNTO").toString());
						
						Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
						adjuntoTemporal.setCRATE_CODIGO(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CRATE_DATA").toString());//(("CRATE_CODIGO"));
						adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
						
						obj_adj.setCJADP_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());
						obj_adj.setCJADP_ESTADO(true);
						obj_adj.setCJADP_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						obj_adj.setCJADP_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_jur_adjunto_proceso(obj_adj).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
			}
			if(res.equals("true")){				
				com.besixplus.sii.objects.Cgg_res_adjunto_temporal objTemp = new com.besixplus.sii.objects.Cgg_res_adjunto_temporal();
				for (int i = 0 ; i < cjadp_Adjunto.length(); i++){
					if(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_CODIGO").toString().equals("KEYGEN")){
						objTemp.setCRATE_CODIGO(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CRATE_DATA").toString());					
						res = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(objTemp).deleteAdjuntoTemporal(con);
					}
				}
				
			}
			if (res.equals("true")){
				con.commit();
			}else{
				con.rollback();
			}
			con.setAutoCommit(true);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_historial_proceso EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_jur_historial_proceso> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_historial_proceso.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_historial_proceso EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_historial_proceso.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_historial_proceso.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_historial_proceso EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_historial_proceso.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_historial_proceso.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_jur_historial_proceso.
	 * @param inCjhtp_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DEL PROCESO JUDICIAL
	 * @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	 * @param inCjhtp_descripcion DESCRIPCION DEL MOVIMIENTO DEL PROCESO JUDICIAL
	 * @param inCjhtp_tipo TIPO DE MOVIMIENTO EN EL PROCESO JUDICIAL
0 - ENTRADA
1 - SALIDA
	 * @param inCjhtp_responsable NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL PROCESO JUDICIAL
	 * @param inCjhtp_fecha FECHA DE REGISTRO DE OPERACION EN EL PROCESO JUDICIAL
	 * @param inCjadp_adjunto ARCHIVO ADJUNTO DE PROCESO.
	 * @param inCjadjp_eliminar ARCHIVO ADJUNTO DE PROCESO A ELIMINAR.
	 * @param inCjpju_estado_ejecucion_HP ESTADO DE LA EJECUCION DEL PROCESO
0 - PLANTEADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	 * @param inTmpValorEstado TEMPORAL DEL VALOR DEL ESTADO
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCjhtp_codigo")String inCjhtp_codigo,
			@WebParam(name="inCjpju_codigo")String inCjpju_codigo,
			@WebParam(name="inCjhtp_descripcion")String inCjhtp_descripcion,
			@WebParam(name="inCjhtp_tipo")int inCjhtp_tipo,
			@WebParam(name="inCjhtp_responsable")String inCjhtp_responsable,
			@WebParam(name="inCjhtp_fecha")java.util.Date inCjhtp_fecha,
			@WebParam(name="inCjadp_adjunto")String inCjadp_adjunto,
			@WebParam(name="inCjadjp_eliminar")String inCjadjp_eliminar,
			@WebParam(name="inCjpju_estado_ejecucion_HP")int inCjpju_estado_ejecucion_HP,
			@WebParam(name="inTmpValorEstado")String inTmpValorEstado
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_historial_proceso obj = new com.besixplus.sii.objects.Cgg_jur_historial_proceso();


		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
						
			com.besixplus.sii.objects.Cgg_jur_adjunto_proceso obj_adj = new com.besixplus.sii.objects.Cgg_jur_adjunto_proceso();
			com.besixplus.sii.objects.Cgg_jur_proceso_judicial obj_pj = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();
			org.json.JSONArray cjadp_Adjunto = new org.json.JSONArray(inCjadp_adjunto);
			JSONArray cjadjp_eliminar = new JSONArray(inCjadjp_eliminar);

			Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();			
			con.setAutoCommit(false);
			obj.setCJHTP_CODIGO(inCjhtp_codigo);
			obj.setCJPJU_CODIGO(inCjpju_codigo);
			obj.setCJHTP_DESCRIPCION(inCjhtp_descripcion);
			obj.setCJHTP_TIPO(inCjhtp_tipo);
			obj.setCJHTP_RESPONSABLE(inCjhtp_responsable);
			obj.setCJHTP_FECHA(inCjhtp_fecha);
			obj.setCJHTP_ESTADO(true);
			obj.setCJHTP_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
			res = new com.besixplus.sii.db.Cgg_jur_historial_proceso(obj).update(con);			

			if (res.equals("true")){
				if (inTmpValorEstado.equals("true")){
					obj_pj.setCJPJU_CODIGO(inCjpju_codigo);
					obj_pj.setCJPJU_ESTADO_EJECUCION(inCjpju_estado_ejecucion_HP);
					obj_pj.setCJPJU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_jur_proceso_judicial(obj_pj).updateEstado(con);
				}
			}
			
			adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);

			if(res.equals("true")){
				for (int i = 0 ; i < cjadp_Adjunto.length(); i++){
					if(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_CODIGO").toString().equals("KEYGEN")){
						obj_adj.setCJADP_CODIGO("KEYGEN");
						obj_adj.setCJHTP_CODIGO(obj.getCJHTP_CODIGO());
						obj_adj.setCJADP_DESCRIPCION(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_DESCRIPCION").toString());
						obj_adj.setCJHTP_FECHA_REGISTRO(inCjhtp_fecha);
						obj_adj.setCJADP_NOMBRE_ADJUNTO(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_NOMBRE_ADJUNTO").toString());
						obj_adj.setCJADP_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());
						obj_adj.setCJADP_ESTADO(true);
						obj_adj.setCJADP_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						obj_adj.setCJADP_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_jur_adjunto_proceso(obj_adj).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
			}
			if(res.equals("true")){				
				com.besixplus.sii.objects.Cgg_res_adjunto_temporal objTemp = new com.besixplus.sii.objects.Cgg_res_adjunto_temporal();
				for (int i = 0 ; i < cjadp_Adjunto.length(); i++){
					if(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_CODIGO").toString().equals("KEYGEN")){
						objTemp.setCRATE_CODIGO(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CRATE_DATA").toString());					
						res = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(objTemp).deleteAdjuntoTemporal(con);
						if(!res.equals("true"))
							break;
					}
				}
				if (res.equals("true")){
					for (int i = 0 ; i < cjadjp_eliminar.length(); i++){
						obj_adj.setCJADP_CODIGO(cjadjp_eliminar.get(i).toString());
						res = new com.besixplus.sii.db.Cgg_jur_adjunto_proceso(obj_adj).deleteAdjuntoProceso(con);
						if(!res.equals("true"))
							break;
					}

				}
			}
			if (res.equals("true")){
				con.commit();
			}else{
				con.rollback();
			}
			con.setAutoCommit(true);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res.toString(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}


	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_jur_historial_proceso EN UNA ESTRUCTURA JSON o XML.
	 * @param inCjhtp_codigo cjhtp_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCjhtp_codigo")String inCjhtp_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_historial_proceso tmpObj = new com.besixplus.sii.objects.Cgg_jur_historial_proceso();
		tmpObj.setCJHTP_CODIGO(inCjhtp_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_jur_historial_proceso(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_jur_historial_proceso> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_jur_historial_proceso>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_jur_historial_proceso.
	 * @param inCjhtp_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DEL PROCESO JUDICIAL
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCjhtp_codigo")String inCjhtp_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_historial_proceso tmpObj = new com.besixplus.sii.objects.Cgg_jur_historial_proceso();
		tmpObj.setCJHTP_CODIGO(inCjhtp_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_jur_historial_proceso(tmpObj).delete(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}

}