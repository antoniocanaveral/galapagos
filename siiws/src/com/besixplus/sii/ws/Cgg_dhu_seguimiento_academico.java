package com.besixplus.sii.ws;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * CLASE Cgg_dhu_seguimiento_academico
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_seguimiento_academico POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_dhu_seguimiento_academico implements Serializable{

	private static final long serialVersionUID = 1342335727;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_seguimiento_academico.
	 * @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA.
	 * @param inCdacd_numero_ciclo NUMERO DE CICLO ACADEMICO.
	 * @param inCdacd_fecha_inicio FECHA DE INICIO DEL CICLO.
	 * @param inCdacd_fecha_fin FECHA DE CULMINACION DEL CICLO.
	 * @param inCdacd_observacion INFORMACION ADICIONAL.
	 * @param inCdacd_estado_aprobacion CAMPO QUE INDICA SI EL SEGUIMIENTO ACADEMICO FUE APROBADO VALORES:
			0 - NO APROBADO
			1 - APROBADO
			2 - OTROS.
	 * @param inAdjuntoSeguimiento_JSON CADENA JSON DE ADJUNTO DE SEGUIMIENTO.
	 * @param inAdjuntoCertificado_JSON CADENA JSON DE ADJUNTO DE CERTIFICADO.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCdbec_codigo")String inCdbec_codigo,
			@WebParam(name="inCdacd_numero_ciclo")int inCdacd_numero_ciclo,
			@WebParam(name="inCdacd_fecha_inicio")java.util.Date inCdacd_fecha_inicio,
			@WebParam(name="inCdacd_fecha_fin")java.util.Date inCdacd_fecha_fin,
			@WebParam(name="inCdacd_observacion")String inCdacd_observacion,
			@WebParam(name="inCdacd_estado_aprobacion")int inCdacd_estado_aprobacion,
			@WebParam(name="inAdjuntoSeguimiento_JSON")String inAdjuntoSeguimiento_JSON,
			@WebParam(name="inAdjuntoCertificado_JSON")String inAdjuntoCertificado_JSON
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico obj = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico();
		obj.setCDBEC_CODIGO(inCdbec_codigo);
		obj.setCDACD_CODIGO("KEYGEN");
		obj.setCDACD_NUMERO_CICLO(inCdacd_numero_ciclo);
		obj.setCDACD_FECHA_INICIO(inCdacd_fecha_inicio);
		obj.setCDACD_FECHA_FIN(inCdacd_fecha_fin);
		obj.setCDACD_OBSERVACION(inCdacd_observacion);
		obj.setCDACD_ESTADO_APROBACION(inCdacd_estado_aprobacion);
		obj.setCDACD_ESTADO(true);
		obj.setCDACD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCDACD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			org.json.JSONArray AdjuntoSeguimiento = new org.json.JSONArray(inAdjuntoSeguimiento_JSON);
			org.json.JSONArray AdjuntoCertificado = new org.json.JSONArray(inAdjuntoCertificado_JSON);
			res = new com.besixplus.sii.db.Cgg_dhu_seguimiento_academico(obj).insert(con);


			if(res.equals("true")){
				com.besixplus.sii.objects.Cgg_dhu_beca objBeca = new com.besixplus.sii.objects.Cgg_dhu_beca();
				objBeca.setCDBEC_CODIGO(inCdbec_codigo);			
				objBeca.setCDBEC_ESTADO_APROBACION(2);	
				objBeca.setCDBEC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());			
				res = new com.besixplus.sii.db.Cgg_dhu_beca(objBeca).updateEstadoAprobacionBeca(con);
				//REGISTRO DE ADJUNTO DE SEGUIMENTO BECA.
				/*Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
				adjuntoTemporal.setCRATE_CODIGO(("CRATE_CODIGO"));
				adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);*/
				//////////////////////////////////////
				//Almacenar en la tabla Cgg_dhu_informacion_representan
				com.besixplus.sii.objects.Cgg_dhu_sadjunto objSadjunto = new com.besixplus.sii.objects.Cgg_dhu_sadjunto();
				for (int i = 0 ; i < AdjuntoSeguimiento.length(); i++){
					objSadjunto.setCDSAD_CODIGO("KEYGEN");
					objSadjunto.setCDACD_CODIGO(obj.getCDACD_CODIGO());
					objSadjunto.setCDBCR_CODIGO(null);
					DateFormat fin = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaIngreso = null;	
					System.out.println("VALOR DE LA FECHA adjunto:"+((org.json.JSONObject)AdjuntoSeguimiento.get(i)).get("CDSAD_FECHA_REGISTRO").toString());
					try{
						fechaIngreso = fin.parse(((org.json.JSONObject)AdjuntoSeguimiento.get(i)).get("CDSAD_FECHA_REGISTRO").toString());
					} catch (ParseException e){
						e.printStackTrace();
						fechaIngreso = new Date();
					}					
					objSadjunto.setCDSAD_FECHA_REGISTRO(fechaIngreso);
					objSadjunto.setCDSAD_NOMBRE_ADJUNTO(((org.json.JSONObject)AdjuntoSeguimiento.get(i)).get("CDSAD_NOMBRE_ADJUNTO").toString());
					
					Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
					adjuntoTemporal.setCRATE_CODIGO(((org.json.JSONObject)AdjuntoSeguimiento.get(i)).get("CRATE_DATA").toString());//(("CRATE_CODIGO"));
					adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
					
					objSadjunto.setCDSAD_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());
					objSadjunto.setCDSAD_OBSERVACION(((org.json.JSONObject)AdjuntoSeguimiento.get(i)).get("CDSAD_OBSERVACION").toString());
					objSadjunto.setCDSAD_ESTADO(true);
					objSadjunto.setCDSAD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objSadjunto.setCDSAD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_dhu_sadjunto(objSadjunto).insert(con);
					if(!res.equals("true"))
						break;
				}

				if(res.equals("true")){				
					com.besixplus.sii.objects.Cgg_res_adjunto_temporal objTemp = new com.besixplus.sii.objects.Cgg_res_adjunto_temporal();
					for (int i = 0 ; i < AdjuntoSeguimiento.length(); i++){
						objTemp.setCRATE_CODIGO(((org.json.JSONObject)AdjuntoSeguimiento.get(i)).get("CRATE_DATA").toString());					
						res = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(objTemp).deleteAdjuntoTemporal(con);
					}

					if(res.equals("true")){

						//REGISTRO DE ADJUNTO DE CERTIFICADOS POR TIPO DE BECA.
/*						Cgg_res_adjunto_temporal adjuntoTemporalCert = new Cgg_res_adjunto_temporal();
						adjuntoTemporalCert.setCRATE_CODIGO(("CRATE_CODIGO"));
						adjuntoTemporalCert = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporalCert).select(con);
*/
						//////////////////////////////////////
						//Almacenar en la tabla Cgg_dhu_informacion_representan

						com.besixplus.sii.objects.Cgg_dhu_sadjunto objCertadjunto = new com.besixplus.sii.objects.Cgg_dhu_sadjunto();
						for (int i = 0 ; i < AdjuntoCertificado.length(); i++){
							if(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDSAD_CODIGO").toString().equals("KEYGEN")){
								objCertadjunto.setCDSAD_CODIGO("KEYGEN");
								objCertadjunto.setCDACD_CODIGO(obj.getCDACD_CODIGO());
								objCertadjunto.setCDBCR_CODIGO(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDBCR_CODIGO").toString());
								DateFormat finC= new SimpleDateFormat("yyyy-MM-dd");
								Date fechaIngresoCert = null;
								System.out.println("VALOR DE LA FECHA CRETIFICADO:"+((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDSAD_FECHA_REGISTRO").toString());
								if(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDSAD_FECHA_REGISTRO").toString()!=null){
									try{
										fechaIngresoCert = finC.parse(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDSAD_FECHA_REGISTRO").toString());
									} catch (ParseException e){
										e.printStackTrace();
										fechaIngresoCert = new Date();
									}	
								}
								else{
									fechaIngresoCert = new Date();
								}
								objCertadjunto.setCDSAD_FECHA_REGISTRO(fechaIngresoCert);
								objCertadjunto.setCDSAD_NOMBRE_ADJUNTO(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDSAD_NOMBRE_ADJUNTO").toString());
								
								Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
								adjuntoTemporal.setCRATE_CODIGO(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CRATE_DATA").toString());//(("CRATE_CODIGO"));
								adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
								
								objCertadjunto.setCDSAD_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());
								objCertadjunto.setCDSAD_OBSERVACION(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDSAD_OBSERVACION").toString());
								objCertadjunto.setCDSAD_ESTADO(true);
								objCertadjunto.setCDSAD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
								objCertadjunto.setCDSAD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
								res = new com.besixplus.sii.db.Cgg_dhu_sadjunto(objCertadjunto).insert(con);
								if(!res.equals("true"))
									break;
							}
						}

						if(res.equals("true"))
						{				
							com.besixplus.sii.objects.Cgg_res_adjunto_temporal objTempCert = new com.besixplus.sii.objects.Cgg_res_adjunto_temporal();
							for (int i = 0 ; i < AdjuntoCertificado.length(); i++){
								if(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDSAD_CODIGO").toString().equals("KEYGEN")){
									objTempCert.setCRATE_CODIGO(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CRATE_DATA").toString());					
									res = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(objTempCert).deleteAdjuntoTemporal(con);
									if(!res.equals("true"))
										break;
								}
							}
						}
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
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_academico EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_seguimiento_academico.selectAll(con, tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			return outCadena.toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_academico EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_dhu_seguimiento_academico.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_seguimiento_academico.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_dhu_seguimiento_academico.
	 * @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	 * @param inCdacd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	 * @param inCdacd_numero_ciclo NUMERO DE CICLO ACADEMICO
	 * @param inCdacd_fecha_inicio FECHA DE INICIO DEL CICLO
	 * @param inCdacd_fecha_fin FECHA DE CULMINACION DEL CICLO
	 * @param inCdacd_observacion INFORMACION ADICIONAL
	 * @param inCdacd_estado_aprobacion CAMPO QUE INDICA SI EL SEGUIMIENTO ACADEMICO FUE APROBADO VALORES:
0 - NO APROBADO
1 - APROBADO
2 - OTROS
	 * @param inEliminarAjunto SE VERIFICA LA ELIMINACION DEL REGISTRO.
	 * @param inAdjuntoSeguimiento_JSON CADENA JSON DE ADJUNTO DE SEGUIMIENTO.
	 * @param inAdjuntoCertificado_JSON CADENA JSON DE ADJUNTO DE CERTIFICADO.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCdbec_codigo")String inCdbec_codigo,
			@WebParam(name="inCdacd_codigo")String inCdacd_codigo,
			@WebParam(name="inCdacd_numero_ciclo")int inCdacd_numero_ciclo,
			@WebParam(name="inCdacd_fecha_inicio")java.util.Date inCdacd_fecha_inicio,
			@WebParam(name="inCdacd_fecha_fin")java.util.Date inCdacd_fecha_fin,
			@WebParam(name="inCdacd_observacion")String inCdacd_observacion,
			@WebParam(name="inCdacd_estado_aprobacion")int inCdacd_estado_aprobacion,
			@WebParam(name="inEliminarAjunto")String inEliminarAjunto,
			@WebParam(name="inAdjuntoSeguimiento_JSON")String inAdjuntoSeguimiento_JSON,
			@WebParam(name="inAdjuntoCertificado_JSON")String inAdjuntoCertificado_JSON
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico obj = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico();
		obj.setCDBEC_CODIGO(inCdbec_codigo);
		obj.setCDACD_CODIGO(inCdacd_codigo);
		obj.setCDACD_NUMERO_CICLO(inCdacd_numero_ciclo);
		obj.setCDACD_FECHA_INICIO(inCdacd_fecha_inicio);
		obj.setCDACD_FECHA_FIN(inCdacd_fecha_fin);
		obj.setCDACD_OBSERVACION(inCdacd_observacion);
		obj.setCDACD_ESTADO_APROBACION(inCdacd_estado_aprobacion);
		obj.setCDACD_ESTADO(true);
		obj.setCDACD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_dhu_seguimiento_academico(obj).update(con);
			con.setAutoCommit(false);
			org.json.JSONArray AjuntoSeguimientoBeca = new org.json.JSONArray(inAdjuntoSeguimiento_JSON);
			org.json.JSONArray AdjuntoCertificado = new org.json.JSONArray(inAdjuntoCertificado_JSON);
			JSONArray EliminarAdjunto=  new JSONArray(inEliminarAjunto);

			if(res.equals("true")){


				
				//////////////////////////////////////
				//Almacenar en la tabla Cgg_dhu_informacion_representan
				com.besixplus.sii.objects.Cgg_dhu_sadjunto objSadjunto = new com.besixplus.sii.objects.Cgg_dhu_sadjunto();
				for (int i = 0 ; i < AjuntoSeguimientoBeca.length(); i++){
					if(((org.json.JSONObject)AjuntoSeguimientoBeca.get(i)).get("CDSAD_CODIGO").toString().equals("KEYGEN")){
						objSadjunto.setCDSAD_CODIGO("KEYGEN");
						objSadjunto.setCDACD_CODIGO(obj.getCDACD_CODIGO());
						objSadjunto.setCDBCR_CODIGO(null);
						DateFormat fin = new SimpleDateFormat("yyyy-MM-dd");
						Date fechaIngreso = null;
						try{
							fechaIngreso = fin.parse(((org.json.JSONObject)AjuntoSeguimientoBeca.get(i)).get("CDSAD_FECHA_REGISTRO").toString());
						} catch (ParseException e){
							e.printStackTrace();
							fechaIngreso = new Date();
						}	
						objSadjunto.setCDSAD_FECHA_REGISTRO(fechaIngreso);
						objSadjunto.setCDSAD_NOMBRE_ADJUNTO(((org.json.JSONObject)AjuntoSeguimientoBeca.get(i)).get("CDSAD_NOMBRE_ADJUNTO").toString());
						
						//REGISTRO DE ADJUNTO DE REQUERIMIENTOS DE TRAMITE.
						Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
						adjuntoTemporal.setCRATE_CODIGO(((org.json.JSONObject)AjuntoSeguimientoBeca.get(i)).get("CRATE_DATA").toString());//(("CRATE_CODIGO"));
						adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
						
						objSadjunto.setCDSAD_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());
						objSadjunto.setCDSAD_OBSERVACION(((org.json.JSONObject)AjuntoSeguimientoBeca.get(i)).get("CDSAD_OBSERVACION").toString());
						objSadjunto.setCDSAD_ESTADO(true);
						objSadjunto.setCDSAD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objSadjunto.setCDSAD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_dhu_sadjunto(objSadjunto).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
				if(res.equals("true")){				
					com.besixplus.sii.objects.Cgg_res_adjunto_temporal objTemp = new com.besixplus.sii.objects.Cgg_res_adjunto_temporal();
					for (int i = 0 ; i < AjuntoSeguimientoBeca.length(); i++){
						if(((org.json.JSONObject)AjuntoSeguimientoBeca.get(i)).get("CDSAD_CODIGO").toString().equals("KEYGEN")){
							objTemp.setCRATE_CODIGO(((org.json.JSONObject)AjuntoSeguimientoBeca.get(i)).get("CRATE_DATA").toString());					
							res = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(objTemp).deleteAdjuntoTemporal(con);
							if(!res.equals("true"))
								break;
						}
					}
					if (res.equals("true")){
						for (int i = 0 ; i <EliminarAdjunto.length(); i++){						
							objSadjunto.setCDSAD_CODIGO(EliminarAdjunto.get(i).toString());
							res = new com.besixplus.sii.db.Cgg_dhu_sadjunto(objSadjunto).delete(con);						
							if(!res.equals("true"))
								break;
						}
						if (res.equals("true")){

							//REGISTRO DE ADJUNTO DE CERTIFICADOS POR TIPO DE BECA.
							
							/*Cgg_res_adjunto_temporal adjuntoTemporalCert = new Cgg_res_adjunto_temporal();
							adjuntoTemporalCert.setCRATE_CODIGO(("CRATE_CODIGO"));
							adjuntoTemporalCert = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporalCert).select(con);*/
							
							
							//////////////////////////////////////
							//Almacenar en la tabla Cgg_dhu_informacion_representan

							com.besixplus.sii.objects.Cgg_dhu_sadjunto objCertadjunto = new com.besixplus.sii.objects.Cgg_dhu_sadjunto();
							for (int i = 0 ; i < AdjuntoCertificado.length(); i++){
								if(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDSAD_CODIGO").toString().equals("KEYGEN")){
									objCertadjunto.setCDSAD_CODIGO("KEYGEN");
									objCertadjunto.setCDACD_CODIGO(obj.getCDACD_CODIGO());
									objCertadjunto.setCDBCR_CODIGO(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDBCR_CODIGO").toString());
									DateFormat finC= new SimpleDateFormat("yyyy-MM-dd");
									Date fechaIngresoCert = null;
									//try{
										fechaIngresoCert = finC.parse(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDSAD_FECHA_REGISTRO").toString());
									/*}catch(ParseException e1){
										e1.printStackTrace();
										fechaIngresoCert = new Date();
									}*/
									
									
									
									objCertadjunto.setCDSAD_FECHA_REGISTRO(fechaIngresoCert);
									objCertadjunto.setCDSAD_NOMBRE_ADJUNTO(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDSAD_NOMBRE_ADJUNTO").toString());
									
									//REGISTRO DE ADJUNTO DE REQUERIMIENTOS DE TRAMITE.
									Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
									adjuntoTemporal.setCRATE_CODIGO(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CRATE_DATA").toString());//(("CRATE_CODIGO"));
									
									adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
									
									objCertadjunto.setCDSAD_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());
									
							
									
									objCertadjunto.setCDSAD_OBSERVACION(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDSAD_OBSERVACION").toString());
									objCertadjunto.setCDSAD_ESTADO(true);
									objCertadjunto.setCDSAD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
									objCertadjunto.setCDSAD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
									res = new com.besixplus.sii.db.Cgg_dhu_sadjunto(objCertadjunto).insert(con);
									if(!res.equals("true"))
										break;
								}
							}
							if(res.equals("true")){				
								com.besixplus.sii.objects.Cgg_res_adjunto_temporal objTempCert = new com.besixplus.sii.objects.Cgg_res_adjunto_temporal();
								for (int i = 0 ; i < AdjuntoCertificado.length(); i++){
									if(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CDSAD_CODIGO").toString().equals("KEYGEN")){
										objTempCert.setCRATE_CODIGO(((org.json.JSONObject)AdjuntoCertificado.get(i)).get("CRATE_DATA").toString());					
										res = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(objTempCert).deleteAdjuntoTemporal(con);
										if(!res.equals("true"))
											break;
									}}
							}

						}
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
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(res).toString();
	}


	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_dhu_seguimiento_academico EN UNA ESTRUCTURA JSON o XML.
	 * @param inCdacd_codigo cdacd_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCdacd_codigo")String inCdacd_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico tmpObj = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico();
		tmpObj.setCDACD_CODIGO(inCdacd_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_dhu_seguimiento_academico(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}


	/**
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_dhu_seguimiento_academico.
	 * @param inCdacd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCdacd_codigo")String inCdacd_codigo
	) throws SOAPException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico tmpObj = new com.besixplus.sii.objects.Cgg_dhu_seguimiento_academico();
		tmpObj.setCDACD_CODIGO(inCdacd_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_dhu_seguimiento_academico(tmpObj).delete(con);
			con.close();
			if(!outResult.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(outResult, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return outResult;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_beca EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectBecaSeguimiento(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = new ArrayList<HashMap<String,Object>>();
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_dhu_seguimiento_academico.selectBecaSeguimientoCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_seguimiento_academico.selectBecaSeguimiento(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE PERSONA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectSeguimientoAcademicoBeca(
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
		//tmpObj.setCRPER_CODIGO(inCrper_codigo);
		ArrayList<HashMap<String,Object>> segui = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			segui = com.besixplus.sii.db.Cgg_dhu_seguimiento_academico.selectPersonaBecaSeguimiento(con,inCrper_num_doc_identific);
			//ArrayList<com.besixplus.sii.objects.Cgg_res_persona> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
			//tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, segui);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (segui!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_academico EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPageBeca(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = new ArrayList<HashMap<String,Object>>();
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_dhu_seguimiento_academico.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_seguimiento_academico.selectAllSeguimiento(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_academico EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA. 
	 * @param in_Cdacd_codigo CODIGO DE LA TABLA Cgg_dhu_seguimiento_academico
	 * @param in_Cdbec_codigo CODIGO DE LA TABLA Cgg_tct_registro
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectCertificadoAdjunto(
			@WebParam(name="in_Cdbec_codigo")String in_Cdbec_codigo,
			@WebParam(name="in_Cdacd_codigo")String in_Cdacd_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}			
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_seguimiento_academico.selectCertificadoAdjunto(con,in_Cdbec_codigo, in_Cdacd_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_seguimiento_academico EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA. 
	 * @param in_cdbec_codigo CODIGO IDENTIFICATIVO DE BECA
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectNumeroCiclo(
			@WebParam(name="in_cdbec_codigo")String in_cdbec_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}			
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_seguimiento_academico.selectSeguimientoCiclo(con,in_cdbec_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			return tmpFormat.getData().toString();
		return null;
	}
}