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
 * CLASE Cgg_jur_acuerdo
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_jur_acuerdo POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_jur_acuerdo implements Serializable{

	private static final long serialVersionUID = 1785117716;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_jur_acuerdo.
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ADMINISTRA LA INFORMACION.
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA CON QUIEN SE CELEBRA EL ACUERDO.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA CON QUIEN SE CELEBRA EL ACUERDO.
	 * @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO REPRESENTANTE LEGAL CGG.
	 * @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO.
	 * @param inCjtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION.
	 * @param inCainf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA.
	 * @param inCjacu_anio ANIO EN EL QUE SE REALIZA EL ACUERDO.
	 * @param inCjacu_numero NUMERO SECUENCIAL UNICO DEL ACUERDO.
	 * @param inCjacu_objeto OBJETO O MOTIVO DEL ACUERDO.
	 * @param inCjacu_descripcion NO ESPECIFICADO.
	 * @param inCjacu_jurisdiccion_ambito LUGAR DONDE SE EJECUTARA EL ACUERDO O AMBITO GEOGRAFICO DEL ACUERDO.
	 * @param inCjacu_fecha_suscripcion FECHA DE SUSCRIPCION O FIRMA DEL ACUERDO.
	 * @param inCjacu_institucion_firma INSTITUCIONES QUE FIRMARON EN EL ACUERDO EN FORMATO JSON YA QUE SON UNA O VARIAS.
	 * @param inCjacu_fecha_inicio FECHA DE INICIO DEL ACUERDO.
	 * @param inCjacu_responsable PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO.
	 * @param inCjacu_partida_presupuestaria NUMERO DE PARTIDA PRESUPUESTARIA QUE RESPALDA EL CONVENIO.
	 * @param inCjacu_costo COSTO ASIGNADO PARA LA EJECUCION DEL ACUERDO.
	 * @param inCjacu_tiempo TIEMPO DE DURACION DEL ACUERDO EN DIAS.
	 * @param inCjacu_estado_ejecucion ESTADO DE LA EJECUCION DEL ACUERDO
0 - FIRMADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO.
	 * @param inCjacu_fecha_finalizacion FECHA DE FINALIZACION DEL ACUERDO.
	 * @param inCjacu_observacion OBSERVACIONES DEL ACUERDO - HISTORIAL JSON.
	 * @param inCjacu_tipo TIPO DE ACUERDO
0 - CONVENIO
1 - CONTRATO.
	 * @param inCjacu_tipo_persona TIPO DE FIGURA LEGAL CON QUIEN SE CELEBRA EL CONVENIO/ CONTRATO
0 - NATURAL
1 - JURIDICO.
	 * @param inCjacu_adendum INDICA SI EL ACUERDO TIENE UN ADENDUM.
	 * @param inCjacu_fecha_adendum NO ESPECIFICADO.
	 * @param inCjacu_objeto_adendum NO ESPECIFICADO.
	 * @param inCjadj_adjunto ADJUNTO DE DOCUMENTO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(		
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,		
			@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
			@WebParam(name="inCjtpr_codigo")String inCjtpr_codigo,
			@WebParam(name="inCainf_codigo")String inCainf_codigo,
			@WebParam(name="inCgg_cusu_codigo")String inCgg_cusu_codigo,			
			@WebParam(name="inCjacu_anio")java.math.BigDecimal inCjacu_anio,
			@WebParam(name="inCjacu_numero")String inCjacu_numero,
			@WebParam(name="inCjacu_objeto")String inCjacu_objeto,
			@WebParam(name="inCjacu_descripcion")String inCjacu_descripcion,
			@WebParam(name="inCjacu_jurisdiccion_ambito")String inCjacu_jurisdiccion_ambito,
			@WebParam(name="inCjacu_fecha_suscripcion")java.util.Date inCjacu_fecha_suscripcion,
			@WebParam(name="inCjacu_institucion_firma")String inCjacu_institucion_firma,
			@WebParam(name="inCjacu_fecha_inicio")java.util.Date inCjacu_fecha_inicio,
			@WebParam(name="inCjacu_responsable")String inCjacu_responsable,
			@WebParam(name="inCjacu_partida_presupuestaria")String inCjacu_partida_presupuestaria,
			@WebParam(name="inCjacu_costo")java.math.BigDecimal inCjacu_costo,
			@WebParam(name="inCjacu_tiempo")int inCjacu_tiempo,
			@WebParam(name="inCjacu_estado_ejecucion")int inCjacu_estado_ejecucion,
			@WebParam(name="inCjacu_fecha_finalizacion")java.util.Date inCjacu_fecha_finalizacion,
			@WebParam(name="inCjacu_observacion")String inCjacu_observacion,
			@WebParam(name="inCjacu_tipo")int inCjacu_tipo,
			@WebParam(name="inCjacu_tipo_persona")int inCjacu_tipo_persona,
			@WebParam(name="inCjacu_adendum")boolean inCjacu_adendum,
			@WebParam(name="inCjacu_fecha_adendum")java.util.Date inCjacu_fecha_adendum,
			@WebParam(name="inCjacu_objeto_adendum")String inCjacu_objeto_adendum,
			@WebParam(name="inCjadj_adjunto")String inCjadj_adjunto

	) throws SOAPException{
		String res = "true";
		String codigoGrupTurisUsu;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);//tmpRequest.getUserPrincipal().getName()
			codigoGrupTurisUsu= com.besixplus.sii.db.Cgg_tct_grupo_turista.selecUsuario(con,tmpRequest.getUserPrincipal().getName());
			com.besixplus.sii.objects.Cgg_jur_acuerdo obj = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
			obj.setCJACU_CODIGO("KEYGEN");
			obj.setCUSU_CODIGO(codigoGrupTurisUsu);
			obj.setCRPJR_CODIGO(inCrpjr_codigo);
			obj.setCRPER_CODIGO(inCrper_codigo);
			obj.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
			obj.setCSCTP_CODIGO(inCsctp_codigo);
			obj.setCJTPR_CODIGO(inCjtpr_codigo);
			obj.setCAINF_CODIGO(inCainf_codigo);
			obj.setCJACU_ANIO(inCjacu_anio);
			obj.setCJACU_NUMERO(inCjacu_numero);
			obj.setCJACU_OBJETO(inCjacu_objeto);
			obj.setCJACU_DESCRIPCION(inCjacu_descripcion);
			obj.setCJACU_JURISDICCION_AMBITO(inCjacu_jurisdiccion_ambito);
			obj.setCJACU_FECHA_SUSCRIPCION(inCjacu_fecha_suscripcion);
			obj.setCJACU_INSTITUCION_FIRMA(inCjacu_institucion_firma);
			obj.setCJACU_FECHA_INICIO(inCjacu_fecha_inicio);
			obj.setCJACU_RESPONSABLE(inCjacu_responsable);
			obj.setCJACU_PARTIDA_PRESUPUESTARIA(inCjacu_partida_presupuestaria);
			obj.setCJACU_COSTO(inCjacu_costo);
			obj.setCJACU_TIEMPO(inCjacu_tiempo);
			obj.setCJACU_ESTADO_EJECUCION(inCjacu_estado_ejecucion);
			obj.setCJACU_FECHA_FINALIZACION(inCjacu_fecha_finalizacion);
			obj.setCJACU_OBSERVACION(inCjacu_observacion);
			obj.setCJACU_TIPO(inCjacu_tipo);
			obj.setCJACU_TIPO_PERSONA(inCjacu_tipo_persona);
			obj.setCJACU_ADENDUM(inCjacu_adendum);
			obj.setCJACU_FECHA_ADENDUM(inCjacu_fecha_adendum);
			obj.setCJACU_OBJETO_ADENDUM(inCjacu_objeto_adendum);
			obj.setCJACU_ESTADO(true);
			obj.setCJACU_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
			obj.setCJACU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
			res = new com.besixplus.sii.db.Cgg_jur_acuerdo(obj).insert(con);

			org.json.JSONArray cjadj_Adjunto = new org.json.JSONArray(inCjadj_adjunto);
			


			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			else{
				com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo obj_adj = new com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo();
				for (int i = 0 ; i < cjadj_Adjunto.length(); i++){
					obj_adj.setCJADA_CODIGO("KEYGEN");
					obj_adj.setCJACU_CODIGO(obj.getCJACU_CODIGO());
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_acuerdo.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_acuerdo.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_acuerdo.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_acuerdo.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_acuerdo.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_jur_acuerdo.
	 * @param inCjacu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ADMINISTRA LA INFORMACION
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA CON QUIEN SE CELEBRA EL ACUERDO
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA CON QUIEN SE CELEBRA EL ACUERDO
	 * @param inCgg_cusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO REPRESENTANTE LEGAL CGG
	 * @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	 * @param inCjtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
	 * @param inCainf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
	 * @param inCjacu_anio ANIO EN EL QUE SE REALIZA EL ACUERDO
	 * @param inCjacu_numero NUMERO SECUENCIAL UNICO DEL ACUERDO
	 * @param inCjacu_objeto OBJETO O MOTIVO DEL ACUERDO
	 * @param inCjacu_descripcion NO ESPECIFICADO
	 * @param inCjacu_jurisdiccion_ambito LUGAR DONDE SE EJECUTARA EL ACUERDO O AMBITO GEOGRAFICO DEL ACUERDO
	 * @param inCjacu_fecha_suscripcion FECHA DE SUSCRIPCION O FIRMA DEL ACUERDO
	 * @param inCjacu_institucion_firma INSTITUCIONES QUE FIRMARON EN EL ACUERDO EN FORMATO JSON YA QUE SON UNA O VARIAS
	 * @param inCjacu_fecha_inicio FECHA DE INICIO DEL ACUERDO
	 * @param inCjacu_responsable PERSONA ENCARGADA DE LA SUPERVISION DEL ACUERDO
	 * @param inCjacu_partida_presupuestaria NUMERO DE PARTIDA PRESUPUESTARIA QUE RESPALDA EL CONVENIO
	 * @param inCjacu_costo COSTO ASIGNADO PARA LA EJECUCION DEL ACUERDO
	 * @param inCjacu_tiempo TIEMPO DE DURACION DEL ACUERDO EN DIAS
	 * @param inCjacu_estado_ejecucion ESTADO DE LA EJECUCION DEL ACUERDO
0 - FIRMADO
1 - EN PROCESO
2 - FINALIZADO
3 - SUSPENDIDO
	 * @param inCjacu_fecha_finalizacion FECHA DE FINALIZACION DEL ACUERDO
	 * @param inCjacu_observacion OBSERVACIONES DEL ACUERDO - HISTORIAL JSON
	 * @param inCjacu_tipo TIPO DE ACUERDO
0 - CONVENIO
1 - CONTRATO
	 * @param inCjacu_tipo_persona TIPO DE FIGURA LEGAL CON QUIEN SE CELEBRA EL CONVENIO/ CONTRATO
0 - NATURAL
1 - JURIDICO
	 * @param inCjacu_adendum INDICA SI EL ACUERDO TIENE UN ADENDUM
	 * @param inCjacu_fecha_adendum NO ESPECIFICADO
	 * @param inCjacu_objeto_adendum NO ESPECIFICADO
	 * @param inCjadj_adjunto ADJUNTO DE DOCUMENTOS.
	 * @param inCjadja_eliminar ADJUNTO A ELIMINAR.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCjacu_codigo")String inCjacu_codigo,		
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,		
			@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
			@WebParam(name="inCjtpr_codigo")String inCjtpr_codigo,
			@WebParam(name="inCainf_codigo")String inCainf_codigo,
			@WebParam(name="inCgg_cusu_codigo")String inCgg_cusu_codigo,
			@WebParam(name="inCjacu_anio")java.math.BigDecimal inCjacu_anio,
			@WebParam(name="inCjacu_numero")String inCjacu_numero,
			@WebParam(name="inCjacu_objeto")String inCjacu_objeto,
			@WebParam(name="inCjacu_descripcion")String inCjacu_descripcion,
			@WebParam(name="inCjacu_jurisdiccion_ambito")String inCjacu_jurisdiccion_ambito,
			@WebParam(name="inCjacu_fecha_suscripcion")java.util.Date inCjacu_fecha_suscripcion,
			@WebParam(name="inCjacu_institucion_firma")String inCjacu_institucion_firma,
			@WebParam(name="inCjacu_fecha_inicio")java.util.Date inCjacu_fecha_inicio,
			@WebParam(name="inCjacu_responsable")String inCjacu_responsable,
			@WebParam(name="inCjacu_partida_presupuestaria")String inCjacu_partida_presupuestaria,
			@WebParam(name="inCjacu_costo")java.math.BigDecimal inCjacu_costo,
			@WebParam(name="inCjacu_tiempo")int inCjacu_tiempo,
			@WebParam(name="inCjacu_estado_ejecucion")int inCjacu_estado_ejecucion,
			@WebParam(name="inCjacu_fecha_finalizacion")java.util.Date inCjacu_fecha_finalizacion,
			@WebParam(name="inCjacu_observacion")String inCjacu_observacion,
			@WebParam(name="inCjacu_tipo")int inCjacu_tipo,
			@WebParam(name="inCjacu_tipo_persona")int inCjacu_tipo_persona,
			@WebParam(name="inCjacu_adendum")boolean inCjacu_adendum,
			@WebParam(name="inCjacu_fecha_adendum")java.util.Date inCjacu_fecha_adendum,
			@WebParam(name="inCjacu_objeto_adendum")String inCjacu_objeto_adendum,
			@WebParam(name="inCjadj_adjunto")String inCjadj_adjunto,
			@WebParam(name="inCjadja_eliminar")String inCjadja_eliminar

	) throws SOAPException{
		String res = "true";
		String codigoGrupTurisUsu;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);

		com.besixplus.sii.objects.Cgg_jur_acuerdo obj = new com.besixplus.sii.objects.Cgg_jur_acuerdo();

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			codigoGrupTurisUsu= com.besixplus.sii.db.Cgg_tct_grupo_turista.selecUsuario(con,tmpRequest.getUserPrincipal().getName());
			obj.setCJACU_CODIGO(inCjacu_codigo);
			obj.setCUSU_CODIGO(codigoGrupTurisUsu);
			obj.setCRPJR_CODIGO(inCrpjr_codigo);
			obj.setCRPER_CODIGO(inCrper_codigo);
			obj.setCGG_CUSU_CODIGO(inCgg_cusu_codigo);
			obj.setCSCTP_CODIGO(inCsctp_codigo);
			obj.setCJTPR_CODIGO(inCjtpr_codigo);
			obj.setCAINF_CODIGO(inCainf_codigo);
			obj.setCJACU_ANIO(inCjacu_anio);
			obj.setCJACU_NUMERO(inCjacu_numero);
			obj.setCJACU_OBJETO(inCjacu_objeto);
			obj.setCJACU_DESCRIPCION(inCjacu_descripcion);
			obj.setCJACU_JURISDICCION_AMBITO(inCjacu_jurisdiccion_ambito);
			obj.setCJACU_FECHA_SUSCRIPCION(inCjacu_fecha_suscripcion);
			obj.setCJACU_INSTITUCION_FIRMA(inCjacu_institucion_firma);
			obj.setCJACU_FECHA_INICIO(inCjacu_fecha_inicio);
			obj.setCJACU_RESPONSABLE(inCjacu_responsable);
			obj.setCJACU_PARTIDA_PRESUPUESTARIA(inCjacu_partida_presupuestaria);
			obj.setCJACU_COSTO(inCjacu_costo);
			obj.setCJACU_TIEMPO(inCjacu_tiempo);
			obj.setCJACU_ESTADO_EJECUCION(inCjacu_estado_ejecucion);
			obj.setCJACU_FECHA_FINALIZACION(inCjacu_fecha_finalizacion);
			obj.setCJACU_OBSERVACION(inCjacu_observacion);
			obj.setCJACU_TIPO(inCjacu_tipo);
			obj.setCJACU_TIPO_PERSONA(inCjacu_tipo_persona);
			obj.setCJACU_ADENDUM(inCjacu_adendum);
			obj.setCJACU_FECHA_ADENDUM(inCjacu_fecha_adendum);
			obj.setCJACU_OBJETO_ADENDUM(inCjacu_objeto_adendum);
			obj.setCJACU_ESTADO(true);
			obj.setCJACU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
			res = new com.besixplus.sii.db.Cgg_jur_acuerdo(obj).update(con);

			org.json.JSONArray cjadj_Adjunto = new org.json.JSONArray(inCjadj_adjunto);
			//org.json.JSONArray cjadja_eliminar = new org.json.JSONArray();			
			JSONArray cjadja_eliminar = new JSONArray(inCjadja_eliminar);
			
			com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo obj_adj = new com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo();

			Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();			
			adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);

			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			else{

				for (int i = 0 ; i < cjadj_Adjunto.length(); i++){
					if(((org.json.JSONObject)cjadj_Adjunto.get(i)).get("CJADA_CODIGO").toString().equals("KEYGEN")){
						obj_adj.setCJADA_CODIGO("KEYGEN");
						obj_adj.setCJACU_CODIGO(obj.getCJACU_CODIGO());
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
			if(res.equals("true"))
				con.commit();
			else
				con.rollback();
			con.setAutoCommit(true);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_jur_acuerdo EN UNA ESTRUCTURA JSON o XML.
	 * @param inCjacu_codigo cjacu_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCjacu_codigo")String inCjacu_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_acuerdo tmpObj = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
		tmpObj.setCJACU_CODIGO(inCjacu_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_jur_acuerdo(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_jur_acuerdo>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_jur_acuerdo.
	 * @param inCjacu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ACUERDO DE CONTRATO O CONVENIO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCjacu_codigo")String inCjacu_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_jur_acuerdo tmpObj = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
		tmpObj.setCJACU_CODIGO(inCjacu_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_jur_acuerdo(tmpObj).delete(con);
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
	public String numeroContrato(		
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_jur_acuerdo tmpObj = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
		String numeroContratoAcuerdo;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			numeroContratoAcuerdo = com.besixplus.sii.db.Cgg_jur_acuerdo.numeroAcuerdoContrato(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return numeroContratoAcuerdo;
		return null;
	}
	/**
	 * GENERA UN NUMERO PARA EL REGISTRO EN LA TABLA Cgg_jur_proceso_judicial.	
	 * @return UN NUMERO GENERADO 	
	 * 	*/
	@WebMethod
	public String numeroConvenio(		
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_jur_acuerdo tmpObj = new com.besixplus.sii.objects.Cgg_jur_acuerdo();
		String numeroConvenioAcuerdo;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());			
			numeroConvenioAcuerdo = com.besixplus.sii.db.Cgg_jur_acuerdo.numeroAcuerdoConvenio(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return numeroConvenioAcuerdo;
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_jur_acuerdo EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPageAcuerdo(
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_acuerdo.selectCountAcuerdo(con, keyword,tmpRequest.getUserPrincipal().getName());
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_jur_acuerdo.selectAllAcuerdo(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_usuario EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA de usuarios internos.
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
	public String selectPageUsuarioInterno(
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
			tmpCount = com.besixplus.sii.db.Cgg_jur_acuerdo.selectCountUsuarioInterno(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_jur_acuerdo.selectAllUsuarioInterno(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
}