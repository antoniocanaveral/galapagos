package com.besixplus.sii.ws;

import java.io.IOException;
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
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.objects.Cgg_dhu_informacion_representan;
import com.besixplus.sii.objects.Cgg_res_adjunto_temporal;

/**
 * CLASE Cgg_dhu_beca
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_dhu_beca POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_dhu_beca implements Serializable{

	private static final long serialVersionUID = 1201247253;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_dhu_beca.
	 * @param inCdtbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA.
	 * @param inCgesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD.
	 * @param inCgied_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA.
	 * @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS.
	 * @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESONAL.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	 * @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA FUNCIONARIO CGG.
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA DONDE TIENE EL FINANCIAMIENTO
	 * @param inCdbec_numero NUMERO DE LA BECA FORMADO POR LA ABREVIATURA DEL TIPO DE BECA MAS SECUENCIAL.
	 * @param inCdbec_fecha_ingreso FECHA DE INGRESO A LA BECA O CARRERA.
	 * @param inCdbec_funcionario NOMBRE DEL FUNCIONARIO QUE APROBO LA BECA O CARRERA.
	 * @param inCdbec_numero_aprobacion NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA.
	 * @param inCdbec_fecha_inicio FECHA DE INICIO DE LA BECA .
	 * @param inCdbec_fecha_fin FECHA DE FINALIZACION DE LA BECA .
	 * @param inCdbec_numero_convenio NUMERO IDENTIFICADOR DEL CONTRATO O CONVENIO.
	 * @param inCdbec_vsalida_origen ORIGEN DEL VUELO DE SALIDA.
	 * @param inCdbec_vsalida_destino DESTINO DEL VUELO DE SALIDA.
	 * @param inCdbec_vsalida_valor VALOR DEL PASAJE DE SALIDA.
	 * @param inCdbec_vretorno_origen ORIGEN DEL VUELO DE RETORNO.
	 * @param inCdbec_vretorno_destino DESTINO DEL VUELO DE RETORNO.
	 * @param inCdbec_vretorno_valor VALOR DEL PASAJE DE RETORNO.
	 * @param inCdbec_carrera NOMBRE DE LA CARRERA A SEGUIR .
	 * @param inCdbec_tipo_ciclo TIPOS DE CICLIO DE LAS CARRERAS PROFESIONALES
			0 - ANUAL
			1 - SEMESTRAL
			2 - QUIMESTRAL
			3 - OTROS.
	 * @param inCdbec_total_ciclos TOTAL DE CICLIO QUE DEBE CUMPLIR PARA APROBAR LA CARRERA..
	 * @param inCdbec_numero_cuento NUEMRO DE CUENTA PARA EL DEPOSITO DEL DINERO DE LA BECA.
	 * @param inCdbec_numero_aprobacion_modificatorio NUMERO DEL DOCUMENTO DE APROBACION MODIFICATORIO DE LA BECA.
	 * @param inCdbec_numero_contrato_modificatorio NUMERO DEL DOCUMENTO DE CONTRATO MODIFICATORIO DE LA BECA.
	 * @param inCdbec_observacion_contrato_modificatorio INFORMACION ADICIONAL DE CONTRATO MODIFICATORIO DE LA BECA..
	 * @param inCdbec_observacion INFORMACION ADICIONAL.
	 * @param inCdbec_titulo_entregado ESTADO QUE DETERMINA SI LA PERSONA ENTREGO UNA COPIA DE SU TITULO PROFESIONAL.
	 * @param inCdbec_beca_devengada DETERMINA SI UNA BECA YA FUE RECOMPENSADA CON TRABAJO EN LA PROVINCIA.
	 * @param inCdbec_estado_aprobacion CAMPO NUMERICO QUE INDICA LOS ESTADOS DE CONCLUSION DE LAS BECAS:
 			0 - NO CONCLUIDA 
 			1 - CONCLUIDA
 			2 - REPROBADA
 			3 - TERMINADA POR CASO FORTUITO
.
	 * @param inCdbec_valor_reembolso CAMPO QUE SE REGISTRA EL VALOR DE REMBOLSO POR NO CULMINAR LA BECA.
	 * @param inPersonaRepresentante_JSON CADENA JSON DE LA TABLA Cgg_res_persona.
	 * @param inAdjunto_JSON CADENA JSON DE LA TABAL Cgg_dhu_adjunto.
	 * @param inPerfilProfesional_JSON CADENA JSON DE LA TABLA Cgg_gem_perfilprof
	 * @param inCdinr_descripcion DESCRIPCION DEL REPRESENTANTE.
	 * @param inCdinr_tipo_representante IDENTIFICA EL TIPO DE REPRESENTANTE
			0 - PADRE
			1 - MADRE
			2 - REPRESENTANTE LEGAL
			3 - GARANTE
			4 - APODERADO

	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCdtbc_codigo")String inCdtbc_codigo,
			@WebParam(name="inCgesp_codigo")String inCgesp_codigo,
			@WebParam(name="inCgied_codigo")String inCgied_codigo,
			@WebParam(name="inCpais_codigo")String inCpais_codigo,
			@WebParam(name="inCgtpr_codigo")String inCgtpr_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCgg_crper_codigo")String inCgg_crper_codigo,
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCdbec_numero")String inCdbec_numero,
			@WebParam(name="inCdbec_fecha_ingreso")java.util.Date inCdbec_fecha_ingreso,
			@WebParam(name="inCdbec_funcionario")String inCdbec_funcionario,
			@WebParam(name="inCdbec_numero_aprobacion")String inCdbec_numero_aprobacion,
			@WebParam(name="inCdbec_fecha_inicio")java.util.Date inCdbec_fecha_inicio,
			@WebParam(name="inCdbec_fecha_fin")java.util.Date inCdbec_fecha_fin,
			@WebParam(name="inCdbec_numero_convenio")String inCdbec_numero_convenio,
			@WebParam(name="inCdbec_vsalida_origen")String inCdbec_vsalida_origen,
			@WebParam(name="inCdbec_vsalida_destino")String inCdbec_vsalida_destino,
			@WebParam(name="inCdbec_vsalida_valor")java.math.BigDecimal inCdbec_vsalida_valor,
			@WebParam(name="inCdbec_vretorno_origen")String inCdbec_vretorno_origen,
			@WebParam(name="inCdbec_vretorno_destino")String inCdbec_vretorno_destino,
			@WebParam(name="inCdbec_vretorno_valor")java.math.BigDecimal inCdbec_vretorno_valor,
			@WebParam(name="inCdbec_carrera")String inCdbec_carrera,
			@WebParam(name="inCdbec_tipo_ciclo")int inCdbec_tipo_ciclo,
			@WebParam(name="inCdbec_total_ciclos")int inCdbec_total_ciclos,
			@WebParam(name="inCdbec_numero_cuento")String inCdbec_numero_cuento,
			@WebParam(name="inCdbec_numero_aprobacion_modificatorio")String inCdbec_numero_aprobacion_modificatorio,
			@WebParam(name="inCdbec_numero_contrato_modificatorio")String inCdbec_numero_contrato_modificatorio,
			@WebParam(name="inCdbec_observacion_contrato_modificatorio")String inCdbec_observacion_contrato_modificatorio,
			@WebParam(name="inCdbec_observacion")String inCdbec_observacion,
			@WebParam(name="inCdbec_titulo_entregado")boolean inCdbec_titulo_entregado,
			@WebParam(name="inCdbec_beca_devengada")boolean inCdbec_beca_devengada,
			@WebParam(name="inCdbec_estado_aprobacion")int inCdbec_estado_aprobacion,
			@WebParam(name="inCdbec_valor_reembolso")java.math.BigDecimal inCdbec_valor_reembolso,
			@WebParam(name="inPersonaRepresentante_JSON")String inPersonaRepresentante_JSON,
			@WebParam(name="inAdjunto_JSON")String inAdjunto_JSON,
			@WebParam(name="inPerfilProfesional_JSON")String inPerfilProfesional_JSON,
			@WebParam(name="inCdinr_descripcion")String inCdinr_descripcion,
			@WebParam(name="inCdinr_tipo_representante")int inCdinr_tipo_representante
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_dhu_beca obj = new com.besixplus.sii.objects.Cgg_dhu_beca();
		obj.setCDBEC_CODIGO("KEYGEN");
		obj.setCDTBC_CODIGO(inCdtbc_codigo);
		obj.setCGESP_CODIGO(inCgesp_codigo);
		obj.setCGIED_CODIGO(inCgied_codigo);
		obj.setCPAIS_CODIGO(inCpais_codigo);
		obj.setCGTPR_CODIGO(inCgtpr_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCDBEC_NUMERO(inCdbec_numero);
		obj.setCDBEC_FECHA_INGRESO(inCdbec_fecha_ingreso);
		obj.setCDBEC_FUNCIONARIO(inCdbec_funcionario);
		obj.setCDBEC_NUMERO_APROBACION(inCdbec_numero_aprobacion);
		obj.setCDBEC_FECHA_INICIO(inCdbec_fecha_inicio);
		obj.setCDBEC_FECHA_FIN(inCdbec_fecha_fin);
		obj.setCDBEC_NUMERO_CONVENIO(inCdbec_numero_convenio);
		obj.setCDBEC_VSALIDA_ORIGEN(inCdbec_vsalida_origen);
		obj.setCDBEC_VSALIDA_DESTINO(inCdbec_vsalida_destino);
		obj.setCDBEC_VSALIDA_VALOR(inCdbec_vsalida_valor);
		obj.setCDBEC_VRETORNO_ORIGEN(inCdbec_vretorno_origen);
		obj.setCDBEC_VRETORNO_DESTINO(inCdbec_vretorno_destino);
		obj.setCDBEC_VRETORNO_VALOR(inCdbec_vretorno_valor);
		obj.setCDBEC_CARRERA(inCdbec_carrera);
		obj.setCDBEC_TIPO_CICLO(inCdbec_tipo_ciclo);
		obj.setCDBEC_TOTAL_CICLOS(inCdbec_total_ciclos);
		obj.setCDBEC_NUMERO_CUENTO(inCdbec_numero_cuento);
		obj.setCDBEC_NUMERO_APROBACION_MODIFICATORIO(inCdbec_numero_aprobacion_modificatorio);
		obj.setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(inCdbec_numero_contrato_modificatorio);
		obj.setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(inCdbec_observacion_contrato_modificatorio);
		obj.setCDBEC_OBSERVACION(inCdbec_observacion);
		obj.setCDBEC_TITULO_ENTREGADO(inCdbec_titulo_entregado);
		obj.setCDBEC_BECA_DEVENGADA(inCdbec_beca_devengada);
		obj.setCDBEC_ESTADO_APROBACION(inCdbec_estado_aprobacion);
		obj.setCDBEC_VALOR_REEMBOLSO(inCdbec_valor_reembolso);
		obj.setCDBEC_ESTADO(true);
		obj.setCDBEC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCDBEC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			org.json.JSONArray tmpPersonaRepresentante = new org.json.JSONArray(inPersonaRepresentante_JSON);
			org.json.JSONArray PerfilProfesional = new org.json.JSONArray(inPerfilProfesional_JSON);
			org.json.JSONArray AjuntoBeca = new org.json.JSONArray(inAdjunto_JSON);
			res = new com.besixplus.sii.db.Cgg_dhu_beca(obj).insert(con);
			if(res.equals("true")){
				//////////////////////////////////////
				//Almacenar en la tabla Cgg_dhu_informacion_representan
				com.besixplus.sii.objects.Cgg_gem_perfil_prof objProfesionPerfil = new com.besixplus.sii.objects.Cgg_gem_perfil_prof();
				for (int i = 0 ; i < PerfilProfesional.length(); i++){
					//objProfesionPerfil.setCGPPR_CODIGO("KEYGEN");
					objProfesionPerfil.setCGESP_CODIGO(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGESP_CODIGO").toString());
					objProfesionPerfil.setCGTPR_CODIGO(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGTPR_CODIGO").toString());					
					objProfesionPerfil.setCGMDC_CODIGO(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGMDC_CODIGO").toString());
					objProfesionPerfil.setCRPER_CODIGO(inCrper_codigo);
					objProfesionPerfil.setCGIEN_CODIGO(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGIEN_CODIGO").toString());
					objProfesionPerfil.setCGPPR_NIVEL_APROBADO(Integer.valueOf((((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_NIVEL_APROBADO")).toString()));
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaInicio = null;
					try{
						fechaInicio = df.parse(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_FECHA_INICIO").toString());
					} catch (ParseException e){
						e.printStackTrace();
						fechaInicio = new Date();
					}	
					objProfesionPerfil.setCGPPR_FECHA_INICIO(fechaInicio);
					DateFormat di = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaFin = null;
					try{
						fechaFin = di.parse(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_FECHA_FIN").toString());
					} catch (ParseException e){
						e.printStackTrace();
						fechaFin = new Date();
					}	
					objProfesionPerfil.setCGPPR_FECHA_FIN(fechaFin);
					objProfesionPerfil.setCGPPR_CONFIRMADO(Boolean.getBoolean(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_CONFIRMADO").toString()));
					DateFormat dc = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaconfirmado = null;
					try{
						fechaconfirmado = dc.parse(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_FECHA_CONFIRMACION").toString());
					} catch (ParseException e){
						e.printStackTrace();
						fechaconfirmado = new Date();
					}	
					objProfesionPerfil.setCGPPR_FECHA_CONFIRMACION(fechaconfirmado);
					objProfesionPerfil.setCGPPR_PREDETERMINADO(Boolean.getBoolean(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_PREDETERMINADO").toString()));
					objProfesionPerfil.setCGPPR_ESTADO(true);
					objProfesionPerfil.setCGPPR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objProfesionPerfil.setCGPPR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					//resProfesionPerfil = new com.besixplus.sii.db.Cgg_gem_perfil_prof(objProfesionPerfil).insert(con);

					if(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_CODIGO").toString().equals("KEYGEN")){
						objProfesionPerfil.setCGPPR_CODIGO("KEYGEN");
						objProfesionPerfil.setCGPPR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_gem_perfil_prof(objProfesionPerfil).insert(con);
						//objProfesionPerfil.setCGPPR_CODIGO(objProfesionPerfil.getCGPPR_CODIGO());
					}else
					{
						objProfesionPerfil.setCGPPR_CODIGO(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_CODIGO").toString());
						//objProfesionPerfil.setCGPPR_CODIGO(objProfesionPerfil.getCGPPR_CODIGO());
						res= new com.besixplus.sii.db.Cgg_gem_perfil_prof(objProfesionPerfil).update(con);
					}
				}

			}
			if(res.equals("true")){
				//////////////////////////////////////
				//Almacenar en la tabla Cgg_dhu_informacion_representan
				JSONObject tmpRepresentanteJSON = null;
				com.besixplus.sii.objects.Cgg_dhu_informacion_representan objPersonaRepre = new Cgg_dhu_informacion_representan();
				for (int i = 0 ; i < tmpPersonaRepresentante.length(); i++){
					tmpRepresentanteJSON = tmpPersonaRepresentante.getJSONObject(i);
					objPersonaRepre.setCDINR_CODIGO("KEYGEN");
					objPersonaRepre.setCRPER_CODIGO(tmpRepresentanteJSON.getString("CRPER_CODIGO"));
					objPersonaRepre.setCDBEC_CODIGO(obj.getCDBEC_CODIGO());					
					objPersonaRepre.setCDINR_DESCRIPCION(tmpRepresentanteJSON.getString("CDINR_DESCRIPCION"));
					objPersonaRepre.setCDINR_TIPO_REPRESENTANTE(tmpRepresentanteJSON.getInt("CDINR_TIPO_REPRESENTANTE"));
					objPersonaRepre.setCDINR_ESTADO(true);
					objPersonaRepre.setCDINR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objPersonaRepre.setCDINR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_dhu_informacion_representan(objPersonaRepre).insert(con);
				}

			}
			if(res.equals("true")){
				//REGISTRO DE ADJUNTO DE REQUERIMIENTOS DE TRAMITE.
/*				Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
				adjuntoTemporal.setCRATE_CODIGO(("CRATE_CODIGO"));
				adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
			*/
				//////////////////////////////////////
				//Almacenar en la tabla Cgg_dhu_informacion_representan
				com.besixplus.sii.objects.Cgg_dhu_adjunto objAdjuntoBeca = new com.besixplus.sii.objects.Cgg_dhu_adjunto();
				for (int i = 0 ; i < AjuntoBeca.length(); i++){
					objAdjuntoBeca.setCDAD_CODIGO("KEYGEN");
					objAdjuntoBeca.setCDBEC_CODIGO(obj.getCDBEC_CODIGO());
					objAdjuntoBeca.setCDAD_DESCRIPCION(((org.json.JSONObject)AjuntoBeca.get(i)).get("CDAD_DESCRIPCION").toString());					
					objAdjuntoBeca.setCDAD_OBSERVACION(((org.json.JSONObject)AjuntoBeca.get(i)).get("CDAD_OBSERVACION").toString());
					objAdjuntoBeca.setCDAD_NOMBRE_ADJUNTO(((org.json.JSONObject)AjuntoBeca.get(i)).get("CDAD_NOMBRE_ADJUNTO").toString());
					


					Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
					adjuntoTemporal.setCRATE_CODIGO(((org.json.JSONObject)AjuntoBeca.get(i)).get("CRATE_DATA").toString());//(("CRATE_CODIGO"));
					adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
					
					
					
					objAdjuntoBeca.setCDAD_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());
					objAdjuntoBeca.setCDAD_TIPO(Integer.valueOf((((org.json.JSONObject)AjuntoBeca.get(i)).get("CDAD_TIPO")).toString()));
					objAdjuntoBeca.setCDAD_DESCRIPCION_CONTENIDO(((org.json.JSONObject)AjuntoBeca.get(i)).get("CDAD_DESCRIPCION_CONTENIDO").toString());
					objAdjuntoBeca.setCDAD_ESTADO(true);
					objAdjuntoBeca.setCDAD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objAdjuntoBeca.setCDAD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_dhu_adjunto(objAdjuntoBeca).insert(con);
					if(!res.equals("true"))
						break;
				}

			}
			if(res.equals("true")){				
				com.besixplus.sii.objects.Cgg_res_adjunto_temporal objTemp = new com.besixplus.sii.objects.Cgg_res_adjunto_temporal();
				for (int i = 0 ; i < AjuntoBeca.length(); i++){
					objTemp.setCRATE_CODIGO(((org.json.JSONObject)AjuntoBeca.get(i)).get("CRATE_DATA").toString());					
					res = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(objTemp).deleteAdjuntoTemporal(con);
					if(!res.equals("true"))
						break;
				}
			}
			if (res.equals("true")){
				con.commit();
			}else
				con.rollback();
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_dhu_beca EN UNA ESTRUCTRA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> obj = null;
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
			obj = com.besixplus.sii.db.Cgg_dhu_beca.selectAll(con, tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
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
		if (obj != null)
			return outCadena.toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_beca EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> obj = null;
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
			tmpCount = com.besixplus.sii.db.Cgg_dhu_beca.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_beca.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
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
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_beca EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_dhu_beca.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_beca.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
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
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}


	/**
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_dhu_beca.
	 * @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	 * @param inCdtbc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
	 * @param inCgesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	 * @param inCgied_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	 * @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	 * @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESONAL
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	 * @param inCgg_crper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA FUNCIONARIO CGG
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA DONDE TIENE EL FINANCIAMIENTO
	 * @param inCdbec_numero NUMERO DE LA BECA FORMADO POR LA ABREVIATURA DEL TIPO DE BECA MAS SECUENCIAL
	 * @param inCdbec_fecha_ingreso FECHA DE INGRESO A LA BECA O CARRERA
	 * @param inCdbec_funcionario NOMBRE DEL FUNCIONARIO QUE APROBO LA BECA O CARRERA
	 * @param inCdbec_numero_aprobacion NUMERO DEL DOCUMENTO DE APROBACION DE LA BECA
	 * @param inCdbec_fecha_inicio FECHA DE INICIO DE LA BECA 
	 * @param inCdbec_fecha_fin FECHA DE FINALIZACION DE LA BECA 
	 * @param inCdbec_numero_convenio NUMERO IDENTIFICADOR DEL CONTRATO O CONVENIO
	 * @param inCdbec_vsalida_origen ORIGEN DEL VUELO DE SALIDA
	 * @param inCdbec_vsalida_destino DESTINO DEL VUELO DE SALIDA
	 * @param inCdbec_vsalida_valor VALOR DEL PASAJE DE SALIDA
	 * @param inCdbec_vretorno_origen ORIGEN DEL VUELO DE RETORNO
	 * @param inCdbec_vretorno_destino DESTINO DEL VUELO DE RETORNO
	 * @param inCdbec_vretorno_valor VALOR DEL PASAJE DE RETORNO
	 * @param inCdbec_carrera NOMBRE DE LA CARRERA A SEGUIR 
	 * @param inCdbec_tipo_ciclo TIPOS DE CICLIO DE LAS CARRERAS PROFESIONALES
			0 - ANUAL
			1 - SEMESTRAL
			2 - QUIMESTRAL
			3 - OTROS
	 * @param inCdbec_total_ciclos TOTAL DE CICLIO QUE DEBE CUMPLIR PARA APROBAR LA CARRERA.
	 * @param inCdbec_numero_cuento NUEMRO DE CUENTA PARA EL DEPOSITO DEL DINERO DE LA BECA
	 * @param inCdbec_numero_aprobacion_modificatorio NUMERO DE APROBACION DE UN CONTRATO MIDIFICATORIO.
	 * @param inCdbec_numero_contrato_modificatorio NUMERO DE CONTRATO PARA MODIFICAR UNA BECA QUE YA HA SIDO SUSPENDIDA.
	 * @param inCdbec_observacion_contrato_modificatorio INFORMACCION ADICONAL DEL CONTRATO MODIFICATORIO.
	 * @param(name="inCdbec_numero_aprobacion_modificatorio")String inCdbec_numero_aprobacion_modificatorio,
	 * @param(name="inCdbec_numero_contrato_modificatorio")String inCdbec_numero_contrato_modificatorio,
	 * @param(name="inCdbec_observacion_contrato_modificatorio")String inCdbec_observacion_contrato_modificatorio,
	 * @param inCdbec_observacion INFORMACION ADICIONAL
	 * @param inCdbec_titulo_entregado ESTADO QUE DETERMINA SI LA PERSONA ENTREGO UNA COPIA DE SU TITULO PROFESIONAL
	 * @param inCdbec_beca_devengada DETERMINA SI UNA BECA YA FUE RECOMPENSADA CON TRABAJO EN LA PROVINCIA
	 * @param inCdbec_estado_aprobacion CAMPO NUMERICO QUE INDICA LOS ESTADOS DE CONCLUSION DE LAS BECAS:
 			0 - NO CONCLUIDA 
 			1 - CONCLUIDA
 			2 - REPROBADA
 			3 - TERMINADA POR CASO FORTUITO

	 * @param inCdbec_valor_reembolso CAMPO QUE SE REGISTRA EL VALOR DE REMBOLSO POR NO CULMINAR LA BECA
	 * @param inPersonaRepresentante_JSON CADENA JSON DE LA TABLA Cgg_res_persona.
	 * @param inAdjunto_JSON CADENA JSON DE LA TABLA Cgg_dhu_adjunto
	 * @param inPerfilProfesional_JSON CADENA JSON DE LA TABLA Cgg_gem_perfilprof
	 * @param inAdjuntoEliminar ADJUNTO A SER ELIMINADO.
	 * @param inCdinr_descripcion DESCRIPCION DEL REPRESENTANTE.
	 * @param inCdinr_tipo_representante IDENTIFICA EL TIPO DE REPRESENTANTE
			0 - PADRE
			1 - MADRE
			2 - REPRESENTANTE LEGAL
			3 - GARANTE
			4 - APODERADO

	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCdbec_codigo")String inCdbec_codigo,
			@WebParam(name="inCdtbc_codigo")String inCdtbc_codigo,
			@WebParam(name="inCgesp_codigo")String inCgesp_codigo,
			@WebParam(name="inCgied_codigo")String inCgied_codigo,
			@WebParam(name="inCpais_codigo")String inCpais_codigo,
			@WebParam(name="inCgtpr_codigo")String inCgtpr_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCgg_crper_codigo")String inCgg_crper_codigo,
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCdbec_numero")String inCdbec_numero,
			@WebParam(name="inCdbec_fecha_ingreso")java.util.Date inCdbec_fecha_ingreso,
			@WebParam(name="inCdbec_funcionario")String inCdbec_funcionario,
			@WebParam(name="inCdbec_numero_aprobacion")String inCdbec_numero_aprobacion,
			@WebParam(name="inCdbec_fecha_inicio")java.util.Date inCdbec_fecha_inicio,
			@WebParam(name="inCdbec_fecha_fin")java.util.Date inCdbec_fecha_fin,
			@WebParam(name="inCdbec_numero_convenio")String inCdbec_numero_convenio,
			@WebParam(name="inCdbec_vsalida_origen")String inCdbec_vsalida_origen,
			@WebParam(name="inCdbec_vsalida_destino")String inCdbec_vsalida_destino,
			@WebParam(name="inCdbec_vsalida_valor")java.math.BigDecimal inCdbec_vsalida_valor,
			@WebParam(name="inCdbec_vretorno_origen")String inCdbec_vretorno_origen,
			@WebParam(name="inCdbec_vretorno_destino")String inCdbec_vretorno_destino,
			@WebParam(name="inCdbec_vretorno_valor")java.math.BigDecimal inCdbec_vretorno_valor,
			@WebParam(name="inCdbec_carrera")String inCdbec_carrera,
			@WebParam(name="inCdbec_tipo_ciclo")int inCdbec_tipo_ciclo,
			@WebParam(name="inCdbec_total_ciclos")int inCdbec_total_ciclos,
			@WebParam(name="inCdbec_numero_cuento")String inCdbec_numero_cuento,
			@WebParam(name="inCdbec_numero_aprobacion_modificatorio")String inCdbec_numero_aprobacion_modificatorio,
			@WebParam(name="inCdbec_numero_contrato_modificatorio")String inCdbec_numero_contrato_modificatorio,
			@WebParam(name="inCdbec_observacion_contrato_modificatorio")String inCdbec_observacion_contrato_modificatorio,
			@WebParam(name="inCdbec_observacion")String inCdbec_observacion,
			@WebParam(name="inCdbec_titulo_entregado")boolean inCdbec_titulo_entregado,
			@WebParam(name="inCdbec_beca_devengada")boolean inCdbec_beca_devengada,
			@WebParam(name="inCdbec_estado_aprobacion")int inCdbec_estado_aprobacion,
			@WebParam(name="inCdbec_valor_reembolso")java.math.BigDecimal inCdbec_valor_reembolso,
			@WebParam(name="inPersonaRepresentante_JSON")String inPersonaRepresentante_JSON,
			@WebParam(name="inAdjunto_JSON")String inAdjunto_JSON,
			@WebParam(name="inPerfilProfesional_JSON")String inPerfilProfesional_JSON,
			@WebParam(name="inAdjuntoEliminar")String inAdjuntoEliminar,
			@WebParam(name="inCdinr_descripcion")String inCdinr_descripcion,
			@WebParam(name="inCdinr_tipo_representante")int inCdinr_tipo_representante


	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_dhu_beca obj = new com.besixplus.sii.objects.Cgg_dhu_beca();
		obj.setCDBEC_CODIGO(inCdbec_codigo);
		obj.setCDTBC_CODIGO(inCdtbc_codigo);
		obj.setCGESP_CODIGO(inCgesp_codigo);
		obj.setCGIED_CODIGO(inCgied_codigo);
		obj.setCPAIS_CODIGO(inCpais_codigo);
		obj.setCGTPR_CODIGO(inCgtpr_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCGG_CRPER_CODIGO(inCgg_crper_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCDBEC_NUMERO(inCdbec_numero);
		obj.setCDBEC_FECHA_INGRESO(inCdbec_fecha_ingreso);
		obj.setCDBEC_FUNCIONARIO(inCdbec_funcionario);
		obj.setCDBEC_NUMERO_APROBACION(inCdbec_numero_aprobacion);
		obj.setCDBEC_FECHA_INICIO(inCdbec_fecha_inicio);
		obj.setCDBEC_FECHA_FIN(inCdbec_fecha_fin);
		obj.setCDBEC_NUMERO_CONVENIO(inCdbec_numero_convenio);
		obj.setCDBEC_VSALIDA_ORIGEN(inCdbec_vsalida_origen);
		obj.setCDBEC_VSALIDA_DESTINO(inCdbec_vsalida_destino);
		obj.setCDBEC_VSALIDA_VALOR(inCdbec_vsalida_valor);
		obj.setCDBEC_VRETORNO_ORIGEN(inCdbec_vretorno_origen);
		obj.setCDBEC_VRETORNO_DESTINO(inCdbec_vretorno_destino);
		obj.setCDBEC_VRETORNO_VALOR(inCdbec_vretorno_valor);
		obj.setCDBEC_CARRERA(inCdbec_carrera);
		obj.setCDBEC_TIPO_CICLO(inCdbec_tipo_ciclo);
		obj.setCDBEC_TOTAL_CICLOS(inCdbec_total_ciclos);
		obj.setCDBEC_NUMERO_CUENTO(inCdbec_numero_cuento);
		obj.setCDBEC_NUMERO_APROBACION_MODIFICATORIO(inCdbec_numero_aprobacion_modificatorio);
		obj.setCDBEC_NUMERO_CONTRATO_MODIFICATORIO(inCdbec_numero_contrato_modificatorio);
		obj.setCDBEC_OBSERVACION_CONTRATO_MODIFICATORIO(inCdbec_observacion_contrato_modificatorio);
		obj.setCDBEC_OBSERVACION(inCdbec_observacion);
		obj.setCDBEC_TITULO_ENTREGADO(inCdbec_titulo_entregado);
		obj.setCDBEC_BECA_DEVENGADA(inCdbec_beca_devengada);
		obj.setCDBEC_ESTADO_APROBACION(inCdbec_estado_aprobacion);
		obj.setCDBEC_VALOR_REEMBOLSO(inCdbec_valor_reembolso);
		obj.setCDBEC_ESTADO(true);
		obj.setCDBEC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_dhu_beca(obj).update(con);
			org.json.JSONArray PersonaRepresentante = new org.json.JSONArray(inPersonaRepresentante_JSON);
			org.json.JSONArray PerfilProfesional = new org.json.JSONArray(inPerfilProfesional_JSON);
			org.json.JSONArray AjuntoBeca = new org.json.JSONArray(inAdjunto_JSON);
			JSONArray AjuntoEliminarBeca =  new JSONArray(inAdjuntoEliminar);

			if(res.equals("true")){
				//////////////////////////////////////
				//Almacenar en la tabla Cgg_dhu_informacion_representan
				com.besixplus.sii.objects.Cgg_gem_perfil_prof objProfesionPerfil = new com.besixplus.sii.objects.Cgg_gem_perfil_prof();
				for (int i = 0 ; i < PerfilProfesional.length(); i++){
					//objProfesionPerfil.setCGPPR_CODIGO("KEYGEN");
					objProfesionPerfil.setCGESP_CODIGO(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGESP_CODIGO").toString());
					objProfesionPerfil.setCGTPR_CODIGO(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGTPR_CODIGO").toString());					
					objProfesionPerfil.setCGMDC_CODIGO(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGMDC_CODIGO").toString());
					objProfesionPerfil.setCRPER_CODIGO(inCrper_codigo);
					objProfesionPerfil.setCGIEN_CODIGO(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGIEN_CODIGO").toString());
					objProfesionPerfil.setCGPPR_NIVEL_APROBADO(Integer.valueOf((((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_NIVEL_APROBADO")).toString()));
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaInicio = null;
					try{
						fechaInicio = df.parse(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_FECHA_INICIO").toString());
					} catch (ParseException e){
						e.printStackTrace();
						fechaInicio = new Date();
					}	
					objProfesionPerfil.setCGPPR_FECHA_INICIO(fechaInicio);
					DateFormat di = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaFin = null;
					try{
						fechaFin = di.parse(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_FECHA_FIN").toString());
					} catch (ParseException e){
						e.printStackTrace();
						fechaFin = new Date();
					}	
					objProfesionPerfil.setCGPPR_FECHA_FIN(fechaFin);
					objProfesionPerfil.setCGPPR_CONFIRMADO(Boolean.getBoolean(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_CONFIRMADO").toString()));
					DateFormat dc = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaconfirmado = null;
					try{
						fechaconfirmado = dc.parse(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_FECHA_CONFIRMACION").toString());
					} catch (ParseException e){
						e.printStackTrace();
						fechaconfirmado = new Date();
					}	
					objProfesionPerfil.setCGPPR_FECHA_CONFIRMACION(fechaconfirmado);
					objProfesionPerfil.setCGPPR_PREDETERMINADO(Boolean.getBoolean(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_PREDETERMINADO").toString()));
					objProfesionPerfil.setCGPPR_ESTADO(true);
					objProfesionPerfil.setCGPPR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objProfesionPerfil.setCGPPR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					//resProfesionPerfil = new com.besixplus.sii.db.Cgg_gem_perfil_prof(objProfesionPerfil).insert(con);

					if(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_CODIGO").toString().equals("KEYGEN")){
						objProfesionPerfil.setCGPPR_CODIGO("KEYGEN");
						objProfesionPerfil.setCGPPR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_gem_perfil_prof(objProfesionPerfil).insert(con);
						//objProfesionPerfil.setCGPPR_CODIGO(objProfesionPerfil.getCGPPR_CODIGO());
					}else
					{
						objProfesionPerfil.setCGPPR_CODIGO(((org.json.JSONObject)PerfilProfesional.get(i)).get("CGPPR_CODIGO").toString());
						//objProfesionPerfil.setCGPPR_CODIGO(objProfesionPerfil.getCGPPR_CODIGO());
						res = new com.besixplus.sii.db.Cgg_gem_perfil_prof(objProfesionPerfil).update(con);
					}
				}

			}
			if(res.equals("true")){
				//////////////////////////////////////
				//Almacenar en la tabla Cgg_dhu_informacion_representan
				com.besixplus.sii.objects.Cgg_dhu_informacion_representan objPersonaRepre = new com.besixplus.sii.objects.Cgg_dhu_informacion_representan();
				JSONObject tmpRepresentanteJSON = null;
				for (int i = 0 ; i < PersonaRepresentante.length(); i++){
					tmpRepresentanteJSON = PersonaRepresentante.getJSONObject(i);
					objPersonaRepre.setCRPER_CODIGO(((org.json.JSONObject)PersonaRepresentante.get(i)).get("CRPER_CODIGO").toString());
					objPersonaRepre.setCDBEC_CODIGO(obj.getCDBEC_CODIGO());					
					objPersonaRepre.setCDINR_DESCRIPCION(((org.json.JSONObject)PersonaRepresentante.get(i)).get("CDINR_DESCRIPCION").toString());
					objPersonaRepre.setCDINR_TIPO_REPRESENTANTE(tmpRepresentanteJSON.getInt("CDINR_TIPO_REPRESENTANTE"));
					objPersonaRepre.setCDINR_ESTADO(true);
					objPersonaRepre.setCDINR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objPersonaRepre.setCDINR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					if(((org.json.JSONObject)PersonaRepresentante.get(i)).get("CDINR_CODIGO").toString().equals("KEYGEN"))

					{
						objPersonaRepre.setCDINR_CODIGO("KEYGEN");
						objPersonaRepre.setCDINR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_dhu_informacion_representan(objPersonaRepre).insert(con);
					}
					else
					{
						objPersonaRepre.setCDINR_CODIGO(((org.json.JSONObject)PersonaRepresentante.get(i)).get("CDINR_CODIGO").toString());
						res = new com.besixplus.sii.db.Cgg_dhu_informacion_representan(objPersonaRepre).update(con);

					}



				}

			}
			if(res.equals("true")){


				//REGISTRO DE ADJUNTO DE REQUERIMIENTOS DE TRAMITE.
/*				Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
				adjuntoTemporal.setCRATE_CODIGO(("CRATE_CODIGO"));
				adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
			*/
				//////////////////////////////////////
				//Almacenar en la tabla Cgg_dhu_informacion_representan
				com.besixplus.sii.objects.Cgg_dhu_adjunto objAdjuntoBeca = new com.besixplus.sii.objects.Cgg_dhu_adjunto();
				for (int i = 0 ; i < AjuntoBeca.length(); i++){
					if(((org.json.JSONObject)AjuntoBeca.get(i)).get("CDAD_CODIGO").toString().equals("KEYGEN")){
						objAdjuntoBeca.setCDAD_CODIGO("KEYGEN");
						objAdjuntoBeca.setCDBEC_CODIGO(obj.getCDBEC_CODIGO());
						objAdjuntoBeca.setCDAD_DESCRIPCION(((org.json.JSONObject)AjuntoBeca.get(i)).get("CDAD_DESCRIPCION").toString());					
						objAdjuntoBeca.setCDAD_OBSERVACION(((org.json.JSONObject)AjuntoBeca.get(i)).get("CDAD_OBSERVACION").toString());
						objAdjuntoBeca.setCDAD_NOMBRE_ADJUNTO(((org.json.JSONObject)AjuntoBeca.get(i)).get("CDAD_NOMBRE_ADJUNTO").toString());
						

						Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
						adjuntoTemporal.setCRATE_CODIGO(((org.json.JSONObject)AjuntoBeca.get(i)).get("CRATE_DATA").toString());//(("CRATE_CODIGO"));
						adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
						
						
						
						objAdjuntoBeca.setCDAD_ADJUNTO(adjuntoTemporal.getCRATE_ARCHIVO());
						objAdjuntoBeca.setCDAD_TIPO(Integer.valueOf((((org.json.JSONObject)AjuntoBeca.get(i)).get("CDAD_TIPO")).toString()));
						objAdjuntoBeca.setCDAD_DESCRIPCION_CONTENIDO(((org.json.JSONObject)AjuntoBeca.get(i)).get("CDAD_DESCRIPCION_CONTENIDO").toString());
						objAdjuntoBeca.setCDAD_ESTADO(true);
						objAdjuntoBeca.setCDAD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objAdjuntoBeca.setCDAD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_dhu_adjunto(objAdjuntoBeca).insert(con);
						if(!res.equals("true"))
							break;
					}
				}

				if(res.equals("true"))
				{				
					com.besixplus.sii.objects.Cgg_res_adjunto_temporal objTemp = new com.besixplus.sii.objects.Cgg_res_adjunto_temporal();
					for (int i = 0 ; i < AjuntoBeca.length(); i++){
						if(((org.json.JSONObject)AjuntoBeca.get(i)).get("CDAD_CODIGO").toString().equals("KEYGEN")){
							objTemp.setCRATE_CODIGO(((org.json.JSONObject)AjuntoBeca.get(i)).get("CRATE_DATA").toString());					
							res = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(objTemp).deleteAdjuntoTemporal(con);}
						if(!res.equals("true"))
							break;
					}
					if (res.equals("true")){
						for (int i = 0 ; i <AjuntoEliminarBeca.length(); i++){						
							//objAdjuntoBeca.setCDAD_CODIGO(((org.json.JSONObject)AjuntoEliminar.get(i)).get("CDAD_CODIGO").toString());							
							objAdjuntoBeca.setCDAD_CODIGO(AjuntoEliminarBeca.get(i).toString());
							res = new com.besixplus.sii.db.Cgg_dhu_adjunto(objAdjuntoBeca).delete(con);
							if(!res.equals("true"))
								break;
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_dhu_beca EN UNA ESTRUCTURA JSON o XML.
	 * @param inCdbec_codigo cdbec_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCdbec_codigo")String inCdbec_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_beca tmpObj = new com.besixplus.sii.objects.Cgg_dhu_beca();
		tmpObj.setCDBEC_CODIGO(inCdbec_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_dhu_beca(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_dhu_beca>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_dhu_beca.
	 * @param inCdbec_codigo IDENTIFICATIVO UNICO DE REGISTRO DE BECA
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 * @throws IOException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCdbec_codigo")String inCdbec_codigo
	)throws SOAPException, IOException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_dhu_beca tmpObj = new com.besixplus.sii.objects.Cgg_dhu_beca();
		com.besixplus.sii.objects.Cgg_dhu_informacion_representan tmpObjInf = new com.besixplus.sii.objects.Cgg_dhu_informacion_representan();
		tmpObj.setCDBEC_CODIGO(inCdbec_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			outResult = new com.besixplus.sii.db.Cgg_dhu_informacion_representan(tmpObjInf).delete(con);
			if(outResult.equals("true"))
				outResult = new com.besixplus.sii.db.Cgg_dhu_beca(tmpObj).delete(con);
			
			if (outResult.equals("true"))
				con.commit();
			else
				con.rollback();
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (outResult != null)
				return outResult.toString();			
		return null;/*
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
		return new Boolean(outResult).toString();*/
	}


	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona,Cgg_usuario EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectFuncionarioBeca(
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
			tmpCount = com.besixplus.sii.db.Cgg_dhu_beca.selectPersonaFuncionarioCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_beca.selectPersonaFuncionario(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_notificacion EN UNA ESTRUCTRA JSON o XML.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	@WebMethod
	public String numeroBeca(		
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
			numeronot = com.besixplus.sii.db.Cgg_dhu_beca.geneNumBeca(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona EN UNA ESTRUCTRA JSON o XML.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION DE UNA PERSONA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectPersonaRepresetante(
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
			//@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
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
			per = com.besixplus.sii.db.Cgg_dhu_beca.selectPersonaRepresentanteBeca(con,inCrper_num_doc_identific);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona,cgg_dhu_informacion_represntante,cgg_res_residencia EN UNA ESTRUCTRA JSON o XML.
	 * @param inCdbec_codigo IDENTIFICATIVO DE BECA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectRepresetanteBeca(
			@WebParam(name="inCdbec_codigo")String inCdbec_codigo,
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
			per = com.besixplus.sii.db.Cgg_dhu_beca.selectRepresentanteBeca(con,inCdbec_codigo);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_beca EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectPageBeca(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = new ArrayList<HashMap<String,Object>>();
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
			tmpCount = com.besixplus.sii.db.Cgg_dhu_beca.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_beca.selectBeca(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
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
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona EN UNA ESTRUCTRA JSON o XML.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectResidentePermaneteBeca(
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
			//con.setAutoCommit(!ManagerConnection.isDeployed());
			con.setAutoCommit(false);
			per = com.besixplus.sii.db.Cgg_dhu_beca.selectPersonaResidenteBeca(con,inCrper_num_doc_identific);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_dhu_beca EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectBecaPersona(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = new ArrayList<HashMap<String,Object>>();
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
			tmpCount = com.besixplus.sii.db.Cgg_dhu_beca.selectbecapersonaCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_dhu_beca.selectBecaResidentePermanente(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
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
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}


}