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
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.json.JSONArray;
import org.json.JSONException;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.objects.Cgg_res_adjunto_temporal;

/**
 * CLASE Cgg_jur_historial_acuerdo
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_historial_acuerdo POR MEDIO DE SERVICIOS WEB.
 *
 * @autor BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_jur_historial_acuerdo implements Serializable{

	private static final long serialVersionUID = 692517929;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_jur_historial_acuerdo.
	 * @param inCjacu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO.
	 * @param inCjhac_descripcion DESCRIPCION DEL MOVIMIENTO DEL ACUERDO.
	 * @param inCjhac_responsable NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL ACUERDO.
	 * @param inCjhac_fecha FECHA DE REGISTRO DE OPERACION DEL ACUERDO.
	 * @param inCjadj_adjunto ARCHIVO ADJUNTO DE PROCESO.
	 * @param inCjacu_estado_ejecucion ESTADO DE LA EJECUCION DEL PROCESO
0 - PLANTEADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	 * @param inTmpValorEstado VALOR TEMPORAL DE ESTADO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCjacu_codigo")String inCjacu_codigo,
			@WebParam(name="inCjhac_descripcion")String inCjhac_descripcion,
			@WebParam(name="inCjhac_responsable")String inCjhac_responsable,
			@WebParam(name="inCjhac_fecha")java.util.Date inCjhac_fecha,
			@WebParam(name="inCjadj_adjunto")String inCjadj_adjunto,
			@WebParam(name="inCjacu_estado_ejecucion")int inCjacu_estado_ejecucion,
			@WebParam(name="inTmpValorEstado")String inTmpValorEstado
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_historial_acuerdo obj = new com.besixplus.sii.objects.Cgg_jur_historial_acuerdo();

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}

			
			com.besixplus.sii.objects.Cgg_jur_acuerdo obj_ac = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
			org.json.JSONArray cjadj_Adjunto = new org.json.JSONArray(inCjadj_adjunto);

			con.setAutoCommit(false);//tmpRequest.getUserPrincipal().getName()
			com.besixplus.sii.db.Cgg_tct_grupo_turista.selecUsuario(con,tmpRequest.getUserPrincipal().getName());
			obj.setCJHAC_CODIGO("KEYGEN");
			obj.setCJACU_CODIGO(inCjacu_codigo);
			obj.setCJHAC_DESCRIPCION(inCjhac_descripcion);
			obj.setCJHAC_RESPONSABLE(inCjhac_responsable);
			obj.setCJHAC_FECHA(inCjhac_fecha);
			obj.setCJHAC_ESTADO(true);
			obj.setCJHAC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
			obj.setCJHAC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
			res = new com.besixplus.sii.db.Cgg_jur_historial_acuerdo(obj).insert(con);

			if (inTmpValorEstado.equals("true")){
				obj_ac.setCJACU_CODIGO(inCjacu_codigo);
				obj_ac.setCJACU_ESTADO_EJECUCION(inCjacu_estado_ejecucion);
				obj_ac.setCJACU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
				res = new com.besixplus.sii.db.Cgg_jur_acuerdo(obj_ac).updateEstado(con);
			}

			

			if(res.equals("true")){	
				com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo obj_adj = new com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo();
				for (int i = 0 ; i < cjadj_Adjunto.length(); i++){
					obj_adj.setCJADA_CODIGO("KEYGEN");

					obj_adj.setCJADA_DESCRIPCION(((org.json.JSONObject)cjadj_Adjunto.get(i)).get("CJADA_DESCRIPCION").toString());
					obj_adj.setCJADA_NOMBRE_ADJUNTO(((org.json.JSONObject)cjadj_Adjunto.get(i)).get("CJADA_NOMBRE_ADJUNTO").toString());
					
					Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
					adjuntoTemporal.setCRATE_CODIGO(((org.json.JSONObject)cjadj_Adjunto.get(i)).get("CRATE_DATA").toString());//(("CRATE_CODIGO"));
					adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
					
					obj_adj.setCJADA_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());					
					obj_adj.setCJADA_ESTADO(true);
					obj_adj.setCJADA_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					obj_adj.setCJADA_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_jur_adjunto_acuerdo(obj_adj).insert(con);
					if(!res.equals("true"))
						break;
				}
			}
			if(res.equals("true")){				
				com.besixplus.sii.objects.Cgg_res_adjunto_temporal objTemp = new com.besixplus.sii.objects.Cgg_res_adjunto_temporal();
				for (int i = 0 ; i < cjadj_Adjunto.length(); i++){
					objTemp.setCRATE_CODIGO(((org.json.JSONObject)cjadj_Adjunto.get(i)).get("CRATE_DATA").toString());					
					res = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(objTemp).deleteAdjuntoTemporal(con);
					if(!res.equals("true"))
						break;
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_historial_acuerdo EN UNA ESTRUCTRA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_jur_historial_acuerdo> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_historial_acuerdo.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_historial_acuerdo EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_historial_acuerdo.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_historial_acuerdo.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_historial_acuerdo EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_historial_acuerdo.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_historial_acuerdo.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_jur_historial_acuerdo.
	 * @param inCjhac_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DE ACUERDO
	 * @param inCjacu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	 * @param inCjhac_descripcion DESCRIPCION DEL MOVIMIENTO DEL ACUERDO
	 * @param inCjhac_responsable NOMBRE DEL RESPONSABLE DE ESTE HISTORIAL DEL ACUERDO
	 * @param inCjhac_fecha FECHA DE REGISTRO DE OPERACION DEL ACUERDO
	 * @param inCjadj_adjunto ARCHIVO ADJUNTO DE PROCESO
	 * @param inCjadja_eliminar ARCHIVO ADJUNTO DE PROCESO A ELIMINAR.
	 * @param inCjacu_estado_ejecucion ESTADO DE LA EJECUCION DEL PROCESO
0 - PLANTEADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	 * @param inTmpValorEstado VALOR TEMPORAL DEL ESTADO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCjhac_codigo")String inCjhac_codigo,
			@WebParam(name="inCjacu_codigo")String inCjacu_codigo,
			@WebParam(name="inCjhac_descripcion")String inCjhac_descripcion,
			@WebParam(name="inCjhac_responsable")String inCjhac_responsable,
			@WebParam(name="inCjhac_fecha")java.util.Date inCjhac_fecha,
			@WebParam(name="inCjadj_adjunto")String inCjadj_adjunto,
			@WebParam(name="inCjadja_eliminar")String inCjadja_eliminar,
			@WebParam(name="inCjacu_estado_ejecucion")int inCjacu_estado_ejecucion,
			@WebParam(name="inTmpValorEstado")String inTmpValorEstado
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_historial_acuerdo obj = new com.besixplus.sii.objects.Cgg_jur_historial_acuerdo();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo obj_adj = new com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo();
			com.besixplus.sii.objects.Cgg_jur_acuerdo obj_ac = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
			org.json.JSONArray cjadj_Adjunto = new org.json.JSONArray(inCjadj_adjunto);
			JSONArray cjadja_eliminar = new JSONArray(inCjadja_eliminar);			
			Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();		

			con.setAutoCommit(false);//tmpRequest.getUserPrincipal().getName()
			com.besixplus.sii.db.Cgg_tct_grupo_turista.selecUsuario(con,tmpRequest.getUserPrincipal().getName());
			obj.setCJHAC_CODIGO(inCjhac_codigo);
			obj.setCJACU_CODIGO(inCjacu_codigo);
			obj.setCJHAC_DESCRIPCION(inCjhac_descripcion);
			obj.setCJHAC_RESPONSABLE(inCjhac_responsable);
			obj.setCJHAC_FECHA(inCjhac_fecha);
			obj.setCJHAC_ESTADO(true);
			obj.setCJHAC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());			
			res = new com.besixplus.sii.db.Cgg_jur_historial_acuerdo(obj).update(con);

			
				if (inTmpValorEstado.equals("true")){
					obj_ac.setCJACU_CODIGO(inCjacu_codigo);
					obj_ac.setCJACU_ESTADO_EJECUCION(inCjacu_estado_ejecucion);
					obj_ac.setCJACU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_jur_acuerdo(obj_ac).updateEstado(con);
				}

			adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
			if(res.equals("true")){
				for (int i = 0 ; i < cjadj_Adjunto.length(); i++){
					if(((org.json.JSONObject)cjadj_Adjunto.get(i)).get("CJADA_CODIGO").toString().equals("KEYGEN")){
						obj_adj.setCJADA_CODIGO("KEYGEN");
						obj_adj.setCJADA_DESCRIPCION(((org.json.JSONObject)cjadj_Adjunto.get(i)).get("CJADA_DESCRIPCION").toString());
						obj_adj.setCJADA_NOMBRE_ADJUNTO(((org.json.JSONObject)cjadj_Adjunto.get(i)).get("CJADA_NOMBRE_ADJUNTO").toString());
						obj_adj.setCJADA_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());					
						obj_adj.setCJADA_ESTADO(true);
						obj_adj.setCJADA_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						obj_adj.setCJADA_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_jur_adjunto_acuerdo(obj_adj).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
			}
			if(res.equals("true")){				
				com.besixplus.sii.objects.Cgg_res_adjunto_temporal objTemp = new com.besixplus.sii.objects.Cgg_res_adjunto_temporal();
				for (int i = 0 ; i < cjadj_Adjunto.length(); i++){
					if(((org.json.JSONObject)cjadj_Adjunto.get(i)).get("CJADA_CODIGO").toString().equals("KEYGEN")){
						objTemp.setCRATE_CODIGO(((org.json.JSONObject)cjadj_Adjunto.get(i)).get("CRATE_DATA").toString());					
						res = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(objTemp).deleteAdjuntoTemporal(con);
						if(!res.equals("true"))
							break;
					}
				}
				if (res.equals("true")){
					for (int i = 0 ; i < cjadja_eliminar.length(); i++){						
						obj_adj.setCJADA_CODIGO(cjadja_eliminar.get(i).toString());	
						res = new com.besixplus.sii.db.Cgg_jur_adjunto_acuerdo(obj_adj).deleteAdjuntoAcuerdo(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_jur_historial_acuerdo EN UNA ESTRUCTURA JSON o XML.
	 * @param inCjhac_codigo cjhac_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCjhac_codigo")String inCjhac_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_historial_acuerdo tmpObj = new com.besixplus.sii.objects.Cgg_jur_historial_acuerdo();
		tmpObj.setCJHAC_CODIGO(inCjhac_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_jur_historial_acuerdo(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_jur_historial_acuerdo> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_jur_historial_acuerdo>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_jur_historial_acuerdo.
	 * @param inCjhac_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL HISTORIAL DE ACUERDO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCjhac_codigo")String inCjhac_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_historial_acuerdo tmpObj = new com.besixplus.sii.objects.Cgg_jur_historial_acuerdo();
		tmpObj.setCJHAC_CODIGO(inCjhac_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_jur_historial_acuerdo(tmpObj).delete(con);
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