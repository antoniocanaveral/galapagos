package com.besixplus.sii.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.soap.SOAPFaultException;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.json.JSONArray;
import org.json.JSONException;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.objects.Cgg_res_adjunto_temporal;

/**
 * CLASE Cgg_jur_proceso_judicial
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_proceso_judicial POR MEDIO DE SERVICIOS WEB.
 *
 * @autor BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_jur_proceso_judicial implements Serializable{

	private static final long serialVersionUID = 1958995846;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_jur_proceso_judicial.
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON.
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA JURIDICA.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	 * @param inCjpju_numero NUMERO SECUENCIAL UNICO DEL PROCESO JUDICIAL.
	 * @param inCjpju_tipo_proceso TIPO DE PROCESO
0 - DEMANDA PLANTEADA
1 - DEMANDA RECIBIDA.
	 * @param inCjpju_tipo_adversario TIPO DE ADVERSARIO
0 - PERSONA NATURAL
1 - PERSONA JURIDICA.
	 * @param inCjpju_fecha_inicio FECHA DE INICIO DEL PROCESO.
	 * @param inCjpju_fecha_finalizacion FECHA DE FINALIZACION DEL PROCESO.
	 * @param inCjpju_estado_ejecucion ESTADO DE LA EJECUCION DEL PROCESO
0 - PLANTEADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO.
	 * @param inCjpju_responsable PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO.
	 * @param inCjpju_observacion OBSERVACIONES DEL ACUERDO - HISTORIAL JSON.
	 * @param inCjadp_adjunto IDENTIFICATIVO DE ADJUNTO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCjpju_numero")String inCjpju_numero,
			@WebParam(name="inCjpju_tipo_proceso")int inCjpju_tipo_proceso,
			@WebParam(name="inCjpju_tipo_adversario")int inCjpju_tipo_adversario,
			@WebParam(name="inCjpju_fecha_inicio")java.util.Date inCjpju_fecha_inicio,
			@WebParam(name="inCjpju_fecha_finalizacion")java.util.Date inCjpju_fecha_finalizacion,
			@WebParam(name="inCjpju_estado_ejecucion")int inCjpju_estado_ejecucion,
			@WebParam(name="inCjpju_responsable")String inCjpju_responsable,
			@WebParam(name="inCjpju_observacion")String inCjpju_observacion,
			@WebParam(name="inCjadp_adjunto")String inCjadp_adjunto

	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_proceso_judicial obj = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			obj.setCJPJU_CODIGO("KEYGEN");
			obj.setCCTN_CODIGO(inCctn_codigo);
			obj.setCRPJR_CODIGO(inCrpjr_codigo);
			obj.setCRPER_CODIGO(inCrper_codigo);
			obj.setCJPJU_NUMERO(inCjpju_numero);
			obj.setCJPJU_TIPO_PROCESO(inCjpju_tipo_proceso);
			obj.setCJPJU_TIPO_ADVERSARIO(inCjpju_tipo_adversario);
			obj.setCJPJU_FECHA_INICIO(inCjpju_fecha_inicio);
			obj.setCJPJU_FECHA_FINALIZACION(inCjpju_fecha_finalizacion);
			obj.setCJPJU_ESTADO_EJECUCION(inCjpju_estado_ejecucion);
			obj.setCJPJU_RESPONSABLE(inCjpju_responsable);
			obj.setCJPJU_OBSERVACION(inCjpju_observacion);
			obj.setCJPJU_ESTADO(true);
			obj.setCJPJU_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
			obj.setCJPJU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
			res = new com.besixplus.sii.db.Cgg_jur_proceso_judicial(obj).insert(con);
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			org.json.JSONArray cjadp_Adjunto = new org.json.JSONArray(inCjadp_adjunto);
			//com.besixplus.sii.objects.Cgg_jur_adjunto_proceso obj_adj = new com.besixplus.sii.objects.Cgg_jur_adjunto_proceso();


			//Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();			
			//adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);

			if(!res.equals("true"))
					throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				else{
				
			com.besixplus.sii.objects.Cgg_jur_adjunto_proceso obj_adj = new com.besixplus.sii.objects.Cgg_jur_adjunto_proceso();
				for (int i = 0 ; i < cjadp_Adjunto.length(); i++){
					if(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_CODIGO").toString().equals("KEYGEN")){
						obj_adj.setCJADP_CODIGO("KEYGEN");
						obj_adj.setCJPJU_CODIGO(obj.getCJPJU_CODIGO());
						obj_adj.setCJADP_DESCRIPCION(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_DESCRIPCION").toString());
						obj_adj.setCJHTP_FECHA_REGISTRO(inCjpju_fecha_inicio);
						obj_adj.setCJADP_NOMBRE_ADJUNTO(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_NOMBRE_ADJUNTO").toString());
						
						Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
						adjuntoTemporal.setCRATE_CODIGO(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CRATE_DATA").toString());//(("CRATE_CODIGO"));
						adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
						
						obj_adj.setCJADP_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());
						obj_adj.setCJADP_ESTADO(true);
						obj_adj.setCJADP_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						obj_adj.setCJADP_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_jur_adjunto_proceso(obj_adj).insert(con);
					}
					if(!res.equals("true"))
						break;
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_proceso_judicial.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_proceso_judicial.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_proceso_judicial.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_proceso_judicial.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_proceso_judicial.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_jur_proceso_judicial.
	 * @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGSITRO DE PERSONA JURIDICA
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	 * @param inCjpju_numero NUMERO SECUENCIAL UNICO DEL PROCESO JUDICIAL
	 * @param inCjpju_tipo_proceso TIPO DE PROCESO
0 - DEMANDA PLANTEADA
1 - DEMANDA RECIBIDA
	 * @param inCjpju_tipo_adversario TIPO DE ADVERSARIO
0 - PERSONA NATURAL
1 - PERSONA JURIDICA
	 * @param inCjpju_fecha_inicio FECHA DE INICIO DEL PROCESO
	 * @param inCjpju_fecha_finalizacion FECHA DE FINALIZACION DEL PROCESO
	 * @param inCjpju_estado_ejecucion ESTADO DE LA EJECUCION DEL PROCESO
0 - PLANTEADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	 * @param inCjpju_responsable PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	 * @param inCjpju_observacion OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	 * @param inCjadp_adjunto IDENTIFICATIVO DE ADJUNTO PROCESO.
	 * @param inCjadjp_eliminar ADJUNTO DE PROCESO A ELIMINAR.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCjpju_codigo")String inCjpju_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCjpju_numero")String inCjpju_numero,
			@WebParam(name="inCjpju_tipo_proceso")int inCjpju_tipo_proceso,
			@WebParam(name="inCjpju_tipo_adversario")int inCjpju_tipo_adversario,
			@WebParam(name="inCjpju_fecha_inicio")java.util.Date inCjpju_fecha_inicio,
			@WebParam(name="inCjpju_fecha_finalizacion")java.util.Date inCjpju_fecha_finalizacion,
			@WebParam(name="inCjpju_estado_ejecucion")int inCjpju_estado_ejecucion,
			@WebParam(name="inCjpju_responsable")String inCjpju_responsable,
			@WebParam(name="inCjpju_observacion")String inCjpju_observacion,
			@WebParam(name="inCjadp_adjunto")String inCjadp_adjunto,
			@WebParam(name="inCjadjp_eliminar")String inCjadjp_eliminar

	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_proceso_judicial obj = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			obj.setCJPJU_CODIGO(inCjpju_codigo);
			obj.setCCTN_CODIGO(inCctn_codigo);
			obj.setCRPJR_CODIGO(inCrpjr_codigo);
			obj.setCRPER_CODIGO(inCrper_codigo);
			obj.setCJPJU_NUMERO(inCjpju_numero);
			obj.setCJPJU_TIPO_PROCESO(inCjpju_tipo_proceso);
			obj.setCJPJU_TIPO_ADVERSARIO(inCjpju_tipo_adversario);
			obj.setCJPJU_FECHA_INICIO(inCjpju_fecha_inicio);
			obj.setCJPJU_FECHA_FINALIZACION(inCjpju_fecha_finalizacion);
			obj.setCJPJU_ESTADO_EJECUCION(inCjpju_estado_ejecucion);
			obj.setCJPJU_RESPONSABLE(inCjpju_responsable);
			obj.setCJPJU_OBSERVACION(inCjpju_observacion);
			obj.setCJPJU_ESTADO(true);
			obj.setCJPJU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
			res = new com.besixplus.sii.db.Cgg_jur_proceso_judicial(obj).update(con);

			org.json.JSONArray cjadp_Adjunto = new org.json.JSONArray(inCjadp_adjunto);
			com.besixplus.sii.objects.Cgg_jur_adjunto_proceso obj_adj = new com.besixplus.sii.objects.Cgg_jur_adjunto_proceso();
			JSONArray cjadjp_eliminar = new JSONArray(inCjadjp_eliminar);

			Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();			
			adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);

			if(res.equals("true")){
				for (int i = 0 ; i < cjadp_Adjunto.length(); i++){
					if(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_CODIGO").toString().equals("KEYGEN")){
						obj_adj.setCJADP_CODIGO("KEYGEN");
						obj_adj.setCJPJU_CODIGO(obj.getCJPJU_CODIGO());
						obj_adj.setCJADP_DESCRIPCION(((org.json.JSONObject)cjadp_Adjunto.get(i)).get("CJADP_DESCRIPCION").toString());
						obj_adj.setCJHTP_FECHA_REGISTRO(inCjpju_fecha_inicio);
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
						System.out.println(cjadjp_eliminar.get(i).toString());
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_jur_proceso_judicial EN UNA ESTRUCTURA JSON o XML.
	 * @param inCjpju_codigo cjpju_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCjpju_codigo")String inCjpju_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_proceso_judicial tmpObj = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();
		tmpObj.setCJPJU_CODIGO(inCjpju_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_jur_proceso_judicial(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_jur_proceso_judicial>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_jur_proceso_judicial.
	 * @param inCjpju_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCjpju_codigo")String inCjpju_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_proceso_judicial tmpObj = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();
		tmpObj.setCJPJU_CODIGO(inCjpju_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_jur_proceso_judicial(tmpObj).delete(con);
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
	/**
	 * GENERA UN NUMERO PARA EL REGISTRO EN LA TABLA Cgg_jur_proceso_judicial.	
	 * @return UN NUMERO GENERADO 	
	 * 	*/
	@WebMethod
	public String numeroProcesoJudicial(		
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_jur_proceso_judicial tmpObj = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();
		String numeroProcesJudicial;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			numeroProcesJudicial = com.besixplus.sii.db.Cgg_jur_proceso_judicial.numeroProceso(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return numeroProcesJudicial;
		return null;
	}
	/**
	 * SELECCIONA EL NOMBRE DEL RESPONSABLE PARA EL PROCESO TABLA Cgg_jur_proceso_judicial.	
	 * @return String
	 * 	*/
	@WebMethod
	public String responsableProcesoJudicial(			
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_jur_proceso_judicial tmpObj = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();
		String responsable;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());// );
			responsable = com.besixplus.sii.db.Cgg_jur_proceso_judicial.responsableProceso(con, tmpRequest.getUserPrincipal().getName());
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return responsable;
		return null;
	}


	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_proceso_judicial EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPageProceso(
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_proceso_judicial.selectCountProceso(con, keyword,tmpRequest.getUserPrincipal().getName());
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_proceso_judicial.selectAllProceso(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * SELECCIONA EL NOMBRE DEL RESPONSABLE PARA EL PROCESO TABLA Cgg_jur_proceso_judicial.	
	 * @return String
	 * 	*/
	@WebMethod
	public String responsableJudicial(			
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_jur_proceso_judicial tmpObj = new com.besixplus.sii.objects.Cgg_jur_proceso_judicial();
		String responsable;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());// );
			responsable = com.besixplus.sii.db.Cgg_jur_proceso_judicial.responsableJuridico(con, tmpRequest.getUserPrincipal().getName());
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return responsable;
		return null;
	}

}