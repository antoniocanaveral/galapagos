package com.besixplus.sii.ws;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

import com.bmlaurus.db.EncuestaData;
import com.bmlaurus.db.TctHospedajeData;
import com.bmlaurus.db.TctTransporteData;
import com.bmlaurus.objects.PreguntaEncuesta;
import com.bmlaurus.objects.TctHospedaje;
import com.bmlaurus.objects.TctTransporte;
import com.bmlaurus.util.Characters;
import com.bmlaurus.ws.dinardap.RegistroCivil;
import com.bmlaurus.ws.dinardap.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;
import org.json.JSONObject;

import com.besixplus.sii.db.Cgg_tct_grupo_turista;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.misc.CGGEnumerators.TipoAmbitoEspecie;
import com.besixplus.sii.objects.ServerResponse;

/**
 * CLASE Cgg_tct_registro
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_registro POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_tct_registro implements Serializable{

	private static final long serialVersionUID = 2027721331;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;



	@WebMethod
	public String insertLite(
			@WebParam(name="inCarpt_codigo")String inCarpt_codigo,
			@WebParam(name="inCgg_carpt_codigo")String inCgg_carpt_codigo,
			@WebParam(name="inCraln_codigo")String inCraln_codigo,
			@WebParam(name="inCtreg_numero")String inCtreg_numero,
			@WebParam(name="inCtreg_fecha_preregistro")java.util.Date inCtreg_fecha_preregistro,
			@WebParam(name="inCtreg_fecha_ingreso")java.util.Date inCtreg_fecha_ingreso,
			@WebParam(name="inCtreg_codigo_barras")String inCtreg_codigo_barras,
			@WebParam(name="inCtreg_fecha_salida")java.util.Date inCtreg_fecha_salida,
			@WebParam(name="inCtreg_categoria")String inCtreg_categoria,
			@WebParam(name="inCtreg_tipo_registro")String inCtreg_tipo_registro,
			@WebParam(name="inCtreg_vuelo")String inCtreg_vuelo,
			@WebParam(name="inCtreg_viaje_acompanante")String inCtreg_viaje_acompanante,
			@WebParam(name="inCtreg_viaje_miembros")String inCtreg_viaje_miembros,
			@WebParam(name="inPersona_JSON")String inPersona_JSON,
			@WebParam(name="inHospedaje_JSON")String inHospedaje_JSON,
			@WebParam(name="inEncuesta_JSON")String inEncuesta_JSON
	)throws SOAPException {
		String res = "true";
		String numRegistro;
		String numGrupoTurista;
		String codigoGrupTurisUsu;
		String codigoRegisUsu;
		ServerResponse tmpServerResponse = new ServerResponse();
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		try{
			Connection con = ManagerConnection.getConnection();
			String usuarioName="";
			if(tmpRequest.getUserPrincipal()!=null){
				usuarioName = tmpRequest.getUserPrincipal().getName();
				if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
					con.close();
					throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				}
			}
			con.setAutoCommit(false);
			//org.json.JSONArray actividadJson = new org.json.JSONArray(inActividad_JSON);
			org.json.JSONArray personaJson = new org.json.JSONArray(inPersona_JSON);
			//org.json.JSONArray hospedajeJson = new org.json.JSONArray(inHospedaje_JSON);
			///////////////////////////////////////
			//Almacenar en la tabla Cgg_tct_grupo_turista
			numGrupoTurista= com.besixplus.sii.db.Cgg_tct_grupo_turista.numeroGrupoTct(con);
			codigoGrupTurisUsu= com.besixplus.sii.db.Cgg_tct_grupo_turista.selecUsuario(con,usuarioName);
			com.besixplus.sii.objects.Cgg_tct_grupo_turista objGrupTuris = new com.besixplus.sii.objects.Cgg_tct_grupo_turista();
			objGrupTuris.setCTGTR_CODIGO("KEYGEN");
			objGrupTuris.setCUSU_CODIGO(codigoGrupTurisUsu);
			objGrupTuris.setCTADC_CODIGO(null);
			objGrupTuris.setCTGTR_NUMERO(Integer.valueOf(numGrupoTurista));
			objGrupTuris.setCTGTR_FECHA_RESERVA(inCtreg_fecha_preregistro);
			objGrupTuris.setCTGTR_FECHA_INGRESO(inCtreg_fecha_ingreso);
			objGrupTuris.setCTGTR_FECHA_SALIDA(inCtreg_fecha_salida);
			objGrupTuris.setCTGTR_ESTADO(true);//tmpRequest.getUserPrincipal().getName()
			objGrupTuris.setCTGTR_USUARIO_INSERT(usuarioName);
			objGrupTuris.setCTGTR_USUARIO_UPDATE(usuarioName);
			res = new com.besixplus.sii.db.Cgg_tct_grupo_turista(objGrupTuris).insert(con);

			if(res.equals("true")){
				//////////////////////////////////////
				//Almacenar en la tabla Cgg_tct_registro y persona
				com.besixplus.sii.objects.Cgg_res_persona objPer = new com.besixplus.sii.objects.Cgg_res_persona();
				com.besixplus.sii.objects.Cgg_tct_registro obj = new com.besixplus.sii.objects.Cgg_tct_registro();
				codigoRegisUsu = com.besixplus.sii.db.Cgg_tct_registro.selecUsuario(con, usuarioName);
				for (int i = 0 ; i < personaJson.length(); i++){
					numRegistro=com.besixplus.sii.db.Cgg_tct_registro.numeroRegistroTct(con);
					obj.setCTREG_CODIGO("KEYGEN");
					//////////////////////////////////////////////////////////
					//Almacenar personas y nuevas personas
					objPer.setCRDID_CODIGO(personaJson.getJSONObject(i).getString("CRDID_CODIGO"));
					objPer.setCGNCN_CODIGO(personaJson.getJSONObject(i).getString("CGNCN_CODIGO"));
					objPer.setCRPER_NOMBRES(personaJson.getJSONObject(i).getString("CRPER_NOMBRES"));
					objPer.setCRPER_APELLIDO_PATERNO(personaJson.getJSONObject(i).getString("CRPER_APELLIDO_PATERNO"));
					objPer.setCRPER_NUM_DOC_IDENTIFIC(personaJson.getJSONObject(i).getString("CRPER_NUM_DOC_IDENTIFIC"));
					objPer.setCRPER_FECHA_NACIMIENTO(Timestamp.valueOf(personaJson.getJSONObject(i).getString("CRPER_FECHA_NACIMIENTO").replace("T", " ")));
					objPer.setCRPER_GENERO(personaJson.getJSONObject(i).getInt("CRPER_GENERO"));
					objPer.setCGG_CPAIS_CODIGO(personaJson.getJSONObject(i).getString("CGG_CPAIS_CODIGO"));
					objPer.setCRPER_ESTADO(true);
					objPer.setCRPER_USUARIO_UPDATE(usuarioName);
					if(((org.json.JSONObject)personaJson.get(i)).getString("CRPER_CODIGO").trim().isEmpty()){
						objPer.setCRPER_CODIGO("KEYGEN");
						objPer.setCRPER_USUARIO_INSERT(usuarioName);
						res = new com.besixplus.sii.db.Cgg_res_persona(objPer).insertTctPersona(con);
						obj.setCRPER_CODIGO(objPer.getCRPER_CODIGO());
					}else{
						obj.setCRPER_CODIGO(personaJson.getJSONObject(i).getString("CRPER_CODIGO"));
						objPer.setCRPER_CODIGO(obj.getCRPER_CODIGO());
						res = new com.besixplus.sii.db.Cgg_res_persona(objPer).updateTctPersona(con);
					}
					//Hay que verificar e ingresar el correo.

					if (res.equals("true")){
						obj.setCTGTR_CODIGO(objGrupTuris.getCTGTR_CODIGO());
						obj.setCUSU_CODIGO(codigoRegisUsu);
						obj.setCGG_CUSU_CODIGO(null);
						obj.setCARPT_CODIGO(inCarpt_codigo);
						obj.setCGG_CARPT_CODIGO(inCgg_carpt_codigo);
						obj.setCRALN_CODIGO(inCraln_codigo);
						obj.setCRTRA_CODIGO((personaJson.getJSONObject(i).getString("CRTRA_CODIGO").trim().length())!=0?personaJson.getJSONObject(i).getString("CRTRA_CODIGO"):null);
						obj.setCTREG_NUMERO(Integer.valueOf(numRegistro));
						obj.setCTREG_FECHA_PREREGISTRO(inCtreg_fecha_preregistro);
						obj.setCTREG_FECHA_INGRESO(inCtreg_fecha_ingreso);
						obj.setCTREG_CODIGO_BARRAS(numGrupoTurista+numRegistro);
						obj.setCTREG_FECHA_SALIDA(inCtreg_fecha_salida);
						obj.setCTREG_ESTADO_REGISTRO(0);
						obj.setCTREG_OBSERVACION(personaJson.getJSONObject(i).getString("CTREG_OBSERVACION"));
						obj.setCTREG_ESTADO(true);
						obj.setCTREG_USUARIO_INSERT(usuarioName);
						obj.setCTREG_USUARIO_UPDATE(usuarioName);
						obj.setCTREG_CATEGORIA(inCtreg_categoria);
						obj.setCTREG_TIPO_REGISTRO(inCtreg_tipo_registro);
						obj.setCTREG_NUMERO_VUELO(inCtreg_vuelo);
						obj.setCTREG_VIAJE_ACOMPANANTE(inCtreg_viaje_acompanante);
						obj.setCTREG_VIAJE_NUM_MIEMBROS(inCtreg_viaje_miembros);

						res = new com.besixplus.sii.db.Cgg_tct_registro(obj).insert(con);

						//Antes de controlar el stock debemos ingresar los hospedajes.
						if (res.equals("true")) {
							if (inHospedaje_JSON != null) {
								Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
								Type listHospedaje = new TypeToken<List<TctHospedaje>>() {}.getType();
								List<TctHospedaje> hospedajes = gson.fromJson(inHospedaje_JSON, listHospedaje);
								for (TctHospedaje hospedaje : hospedajes) {
									hospedaje.setCodigoPreregistro(obj.getCTREG_CODIGO());
									hospedaje.setUsuarioInsert(usuarioName);
									hospedaje.setUsuarioUpdate(usuarioName);

									res = TctHospedajeData.insert(con, hospedaje);
									if (res.equals("false"))
										break;
								}


							} else
								res = "false";
						}
						//Metemos la encuesta
						if (res.equals("true")) {
							if (inEncuesta_JSON != null) {

							}
						}


						if (res.equals("true")){
							com.besixplus.sii.objects.Cgg_kdx_venta_detalle objKdx = new com.besixplus.sii.objects.Cgg_kdx_venta_detalle();
							objKdx.setCKVDT_CODIGO("KEYGEN");
							objKdx.setCKESP_CODIGO(personaJson.getJSONObject(i).getString("CKESP_CODIGO"));
							objKdx.setCTREG_CODIGO(obj.getCTREG_CODIGO());
							objKdx.setCKVDT_ESTADO(true);
							objKdx.setCKVDT_USUARIO_INSERT(usuarioName);
							objKdx.setCKVDT_USUARIO_UPDATE(usuarioName);
							res = new com.besixplus.sii.db.Cgg_kdx_venta_detalle(objKdx).insert(con);
						}

					}
				}
			}
			if(res.equals("true")){
				con.commit();
				tmpServerResponse.setSuccess(true);
				tmpServerResponse.setMsg(numGrupoTurista);
			}else{
				con.rollback();
				tmpServerResponse.setMsg(res);
			}
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			tmpServerResponse.setMsg(inException.getMessage());
		} catch (JSONException e) {
			e.printStackTrace();
			tmpServerResponse.setMsg(e.getMessage());
		}
		return new JSONObject(tmpServerResponse).toString();
	}


	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_tct_registro.
	 * @param inCarpt_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	 * @param inCgg_carpt_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	 * @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	 * @param inCtreg_numero NUMERO SECUENCIAL UNICO DEL REGISTRO DE TCT.
	 * @param inCtreg_fecha_preregistro FECHA DE RESERVA DEL TCT.
	 * @param inCtreg_fecha_ingreso FECHA DE INGRESO  A LA PROVINCIA.
	 * @param inCtreg_codigo_barras CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT.
	 * @param inCtreg_fecha_salida FECHA DE SALIDA DE LA PROVINCIA.
	 * @param inHospedaje_JSON HOSPEDAJE	
	 * @param inActividad_JSON ACTIVIDAD
	 * @param inPersona_JSON PERSONA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCarpt_codigo")String inCarpt_codigo,
			@WebParam(name="inCgg_carpt_codigo")String inCgg_carpt_codigo,
			@WebParam(name="inCraln_codigo")String inCraln_codigo,
			@WebParam(name="inCtreg_numero")String inCtreg_numero,
			@WebParam(name="inCtreg_fecha_preregistro")java.util.Date inCtreg_fecha_preregistro,
			@WebParam(name="inCtreg_fecha_ingreso")java.util.Date inCtreg_fecha_ingreso,		
			@WebParam(name="inCtreg_codigo_barras")String inCtreg_codigo_barras,
			@WebParam(name="inCtreg_fecha_salida")java.util.Date inCtreg_fecha_salida,
			@WebParam(name="inCtreg_categoria")String inCtreg_categoria,
			@WebParam(name="inCtreg_tipo_registro")String inCtreg_tipo_registro,
			@WebParam(name="inCtreg_vuelo")String inCtreg_vuelo,
			@WebParam(name="inCtreg_tipo_hospedaje")String inCtreg_tipo_hospedaje,
			@WebParam(name="inCtreg_isla_hospedaje")String inCtreg_isla_hospedaje,
			@WebParam(name="inCtreg_nombre_crucero")String inCtreg_nombre_crucero,
			@WebParam(name="inCtreg_nombre_hotel")String inCtreg_nombre_hotel,
			@WebParam(name="inCtreg_lugar_hospedaje")String inCtreg_lugar_hospedaje,
			@WebParam(name="inCtreg_viaje_acompanante")String inCtreg_viaje_acompanante,
			@WebParam(name="inCtreg_viaje_motivo")String inCtreg_viaje_motivo,
			@WebParam(name="inCtreg_viaje_actividades")String inCtreg_viaje_actividades,
			@WebParam(name="inCtreg_viaje_miembros")String inCtreg_viaje_miembros,
			@WebParam(name="inCtreg_viaje_tour")String inCtreg_viaje_tour,
			@WebParam(name="inCtreg_viaje_cual")String inCtreg_viaje_cual,
			@WebParam(name="inAtractivos_JSON")String inAtractivos_JSON,
			@WebParam(name="inPersona_JSON")String inPersona_JSON
	) throws SOAPException{
		String res = "true";
		String numRegistro;		
		String numGrupoTurista;
		String codigoGrupTurisUsu;
		String codigoRegisUsu;
		ServerResponse tmpServerResponse = new ServerResponse();
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		try{
			Connection con = ManagerConnection.getConnection();
			String usuarioName="";
			if(tmpRequest.getUserPrincipal()!=null){
				usuarioName = tmpRequest.getUserPrincipal().getName();
				if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
					con.close();
					throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				}
			}
			con.setAutoCommit(false);
			//org.json.JSONArray actividadJson = new org.json.JSONArray(inActividad_JSON);
			org.json.JSONArray personaJson = new org.json.JSONArray(inPersona_JSON);
			//org.json.JSONArray hospedajeJson = new org.json.JSONArray(inHospedaje_JSON);
			///////////////////////////////////////
			//Almacenar en la tabla Cgg_tct_grupo_turista
			numGrupoTurista= com.besixplus.sii.db.Cgg_tct_grupo_turista.numeroGrupoTct(con);
			codigoGrupTurisUsu= com.besixplus.sii.db.Cgg_tct_grupo_turista.selecUsuario(con,usuarioName);
			com.besixplus.sii.objects.Cgg_tct_grupo_turista objGrupTuris = new com.besixplus.sii.objects.Cgg_tct_grupo_turista();
			objGrupTuris.setCTGTR_CODIGO("KEYGEN");
			objGrupTuris.setCUSU_CODIGO(codigoGrupTurisUsu);
			objGrupTuris.setCTADC_CODIGO(null);
			objGrupTuris.setCTGTR_NUMERO(Integer.valueOf(numGrupoTurista));
			objGrupTuris.setCTGTR_FECHA_RESERVA(inCtreg_fecha_preregistro);
			objGrupTuris.setCTGTR_FECHA_INGRESO(inCtreg_fecha_ingreso);
			objGrupTuris.setCTGTR_FECHA_SALIDA(inCtreg_fecha_salida);
			objGrupTuris.setCTGTR_ESTADO(true);//tmpRequest.getUserPrincipal().getName()
			objGrupTuris.setCTGTR_USUARIO_INSERT(usuarioName);
			objGrupTuris.setCTGTR_USUARIO_UPDATE(usuarioName);
			res = new com.besixplus.sii.db.Cgg_tct_grupo_turista(objGrupTuris).insert(con);
			
			if(res.equals("true")){
				//////////////////////////////////////
				//Almacenar en la tabla Cgg_tct_registro y persona
				com.besixplus.sii.objects.Cgg_res_persona objPer = new com.besixplus.sii.objects.Cgg_res_persona();
				com.besixplus.sii.objects.Cgg_tct_registro obj = new com.besixplus.sii.objects.Cgg_tct_registro();
				codigoRegisUsu = com.besixplus.sii.db.Cgg_tct_registro.selecUsuario(con, usuarioName);
				for (int i = 0 ; i < personaJson.length(); i++){
					numRegistro=com.besixplus.sii.db.Cgg_tct_registro.numeroRegistroTct(con);
					obj.setCTREG_CODIGO("KEYGEN");
					//////////////////////////////////////////////////////////
					//Almacenar personas y nuevas personas
					objPer.setCRDID_CODIGO(personaJson.getJSONObject(i).getString("CRDID_CODIGO"));
					objPer.setCGNCN_CODIGO(personaJson.getJSONObject(i).getString("CGNCN_CODIGO"));
					objPer.setCRPER_NOMBRES(personaJson.getJSONObject(i).getString("CRPER_NOMBRES"));
					objPer.setCRPER_APELLIDO_PATERNO(personaJson.getJSONObject(i).getString("CRPER_APELLIDO_PATERNO"));
					objPer.setCRPER_NUM_DOC_IDENTIFIC(personaJson.getJSONObject(i).getString("CRPER_NUM_DOC_IDENTIFIC"));
					objPer.setCRPER_FECHA_NACIMIENTO(Timestamp.valueOf(personaJson.getJSONObject(i).getString("CRPER_FECHA_NACIMIENTO").replace("T", " ")));
					objPer.setCRPER_GENERO(personaJson.getJSONObject(i).getInt("CRPER_GENERO"));
					objPer.setCGG_CPAIS_CODIGO(personaJson.getJSONObject(i).getString("CGG_CPAIS_CODIGO"));
					objPer.setCRPER_ESTADO(true);					
					objPer.setCRPER_USUARIO_UPDATE(usuarioName);					
					if(((org.json.JSONObject)personaJson.get(i)).getString("CRPER_CODIGO").trim().isEmpty()){
						objPer.setCRPER_CODIGO("KEYGEN");
						objPer.setCRPER_USUARIO_INSERT(usuarioName);
						res = new com.besixplus.sii.db.Cgg_res_persona(objPer).insertTctPersona(con);
						obj.setCRPER_CODIGO(objPer.getCRPER_CODIGO());
					}else{
						obj.setCRPER_CODIGO(personaJson.getJSONObject(i).getString("CRPER_CODIGO"));
						objPer.setCRPER_CODIGO(obj.getCRPER_CODIGO());
						res = new com.besixplus.sii.db.Cgg_res_persona(objPer).updateTctPersona(con);
					}
					if (res.equals("true")){
						obj.setCTGTR_CODIGO(objGrupTuris.getCTGTR_CODIGO());						
						obj.setCUSU_CODIGO(codigoRegisUsu);						
						obj.setCGG_CUSU_CODIGO(null);
						obj.setCARPT_CODIGO(inCarpt_codigo);
						obj.setCGG_CARPT_CODIGO(inCgg_carpt_codigo);
						obj.setCRALN_CODIGO(inCraln_codigo);
						obj.setCRTRA_CODIGO((personaJson.getJSONObject(i).getString("CRTRA_CODIGO").trim().length())!=0?personaJson.getJSONObject(i).getString("CRTRA_CODIGO"):null);
						obj.setCTREG_NUMERO(Integer.valueOf(numRegistro));
						obj.setCTREG_FECHA_PREREGISTRO(inCtreg_fecha_preregistro);
						obj.setCTREG_FECHA_INGRESO(inCtreg_fecha_ingreso);			  
						obj.setCTREG_CODIGO_BARRAS(numGrupoTurista+numRegistro);			
						obj.setCTREG_FECHA_SALIDA(inCtreg_fecha_salida);
						obj.setCTREG_ESTADO_REGISTRO(0);
						obj.setCTREG_OBSERVACION(personaJson.getJSONObject(i).getString("CTREG_OBSERVACION"));
						obj.setCTREG_ESTADO(true);
						obj.setCTREG_USUARIO_INSERT(usuarioName);
						obj.setCTREG_USUARIO_UPDATE(usuarioName);
						obj.setCTREG_CATEGORIA(inCtreg_categoria); 
						obj.setCTREG_TIPO_REGISTRO(inCtreg_tipo_registro);
						obj.setCTREG_NUMERO_VUELO(inCtreg_vuelo);
						obj.setCTREG_TIPO_HOSPEDAJE(inCtreg_tipo_hospedaje);
						obj.setCTREG_ISLA_HOSPEDAJE(inCtreg_isla_hospedaje);
						obj.setCTREG_NOMBRE_HOSPEDAJE_CRUCERO(inCtreg_nombre_crucero); 
						obj.setCTREG_NOMBRE_HOSPEDAJE_HOTEL(inCtreg_nombre_hotel); 
						obj.setCTREG_LUGAR_HOSPEDAJE(inCtreg_lugar_hospedaje);
						obj.setCTREG_VIAJE_ACOMPANANTE(inCtreg_viaje_acompanante);
						obj.setCTREG_VIAJE_MOTIVO(inCtreg_viaje_motivo); 
						obj.setCTREG_VIAJE_ACTIVIDADES(inCtreg_viaje_actividades); 
						obj.setCTREG_VIAJE_NUM_MIEMBROS(inCtreg_viaje_miembros);
						obj.setCTREG_VIAJE_TOUR(inCtreg_viaje_tour); 
						obj.setCTREG_VIAJE_CUAL(inCtreg_viaje_cual);
						
						res = new com.besixplus.sii.db.Cgg_tct_registro(obj).insert(con);
						if (res.equals("true")){
							com.besixplus.sii.objects.Cgg_kdx_venta_detalle objKdx = new com.besixplus.sii.objects.Cgg_kdx_venta_detalle();
							objKdx.setCKVDT_CODIGO("KEYGEN");
							objKdx.setCKESP_CODIGO(personaJson.getJSONObject(i).getString("CKESP_CODIGO"));
							objKdx.setCTREG_CODIGO(obj.getCTREG_CODIGO());
							objKdx.setCKVDT_ESTADO(true);
							objKdx.setCKVDT_USUARIO_INSERT(usuarioName);
							objKdx.setCKVDT_USUARIO_UPDATE(usuarioName);
							res = new com.besixplus.sii.db.Cgg_kdx_venta_detalle(objKdx).insert(con);
						}
					}
				}

				//Almacena los atractivos y actividades del registro tct en la tabla Cgg_tct_atractivos_actividades
				if(res.equals("true")){
					org.json.JSONArray atractivosJson = new org.json.JSONArray(inAtractivos_JSON);
					com.besixplus.sii.objects.Cgg_tct_atractivos_actividades objAtractivos = new com.besixplus.sii.objects.Cgg_tct_atractivos_actividades();
					objAtractivos.setCTATA_CODIGO("KEYGEN");
					objAtractivos.setCTGTR_CODIGO(objGrupTuris.getCTGTR_CODIGO());
					objAtractivos.setCTATA_VIDA_MARINA(atractivosJson.getJSONObject(0).getString("VALOR1"));
					objAtractivos.setCTATA_SOL_PLAYA(atractivosJson.getJSONObject(0).getString("VALOR2"));
					objAtractivos.setCTATA_VIDA_TERRESTRE(atractivosJson.getJSONObject(0).getString("VALOR3"));
					objAtractivos.setCTATA_PAISAJE(atractivosJson.getJSONObject(0).getString("VALOR4"));
					objAtractivos.setCTATA_CRUCERO(atractivosJson.getJSONObject(0).getString("VALOR5"));
					objAtractivos.setCTATA_BUCEO(atractivosJson.getJSONObject(0).getString("VALOR6"));
					objAtractivos.setCTATA_SNORKEL(atractivosJson.getJSONObject(0).getString("VALOR7"));
					objAtractivos.setCTATA_KAYAK(atractivosJson.getJSONObject(0).getString("VALOR8"));
					objAtractivos.setCTATA_SURF(atractivosJson.getJSONObject(0).getString("VALOR9"));
					objAtractivos.setCTATA_SENDERISMO(atractivosJson.getJSONObject(0).getString("VALOR10"));
					objAtractivos.setCTATA_OBSERVACION(atractivosJson.getJSONObject(0).getString("VALOR11"));
					objAtractivos.setCTATA_FOTOGRAFIA(atractivosJson.getJSONObject(0).getString("VALOR12"));
					objAtractivos.setCTATA_PESCA_VIVENCIAL(atractivosJson.getJSONObject(0).getString("VALOR13"));
					res = new com.besixplus.sii.db.Cgg_tct_atractivos_actividades(objAtractivos).insert(con);
				}
				
			}			
			if(res.equals("true")){
				con.commit();
				tmpServerResponse.setSuccess(true);
				tmpServerResponse.setMsg(numGrupoTurista);
			}else{	
				con.rollback();
				tmpServerResponse.setMsg(res);
			}
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			tmpServerResponse.setMsg(inException.getMessage());
		} catch (JSONException e) {
			e.printStackTrace();
			tmpServerResponse.setMsg(e.getMessage());
		}
		return new JSONObject(tmpServerResponse).toString();
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA insertOffline.
	 * @param inCarpt_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	 * @param inCgg_carpt_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	 * @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	 * @param inCtreg_numero NUMERO SECUENCIAL UNICO DEL REGISTRO DE TCT.
	 * @param inCtreg_fecha_preregistro FECHA DE RESERVA DEL TCT.
	 * @param inCtreg_fecha_ingreso FECHA DE INGRESO  A LA PROVINCIA.
	 * @param inCtreg_codigo_barras CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT.
	 * @param inCtreg_fecha_salida FECHA DE SALIDA DE LA PROVINCIA.
	 * @param inHospedaje_JSON HOSPEDAJE	
	 * @param inActividad_JSON ACTIVIDAD
	 * @param inPersona_JSON PERSONA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insertOffline(
			@WebParam(name="inRegistroOffline_JSON")String inPersona_JSON,
			@WebParam(name="inAdicional_JSON")String inActividad_JSON
	) throws SOAPException{
		String res = "true";
		ServerResponse tmpServerResponse = new ServerResponse();
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		try{
			Connection con = ManagerConnection.getConnection();
			String usuarioName="";
			if(tmpRequest.getUserPrincipal()!=null){
				usuarioName = tmpRequest.getUserPrincipal().getName();
				if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
					con.close();
					throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				}
			}
			con.setAutoCommit(false);
			org.json.JSONArray objRegistroOffline_JSON = new org.json.JSONArray(inPersona_JSON);
			
			for (int i = 0 ; i < objRegistroOffline_JSON.length(); i++){
				String tmpCodigoUsuario = objRegistroOffline_JSON.getJSONObject(i).getString("CODIGO_USUARIO");
				String tmpNombres = objRegistroOffline_JSON.getJSONObject(i).getString("NOMBRES");
				String tmpApellidos = objRegistroOffline_JSON.getJSONObject(i).getString("APELLIDOS");
				String tmpNumPass = objRegistroOffline_JSON.getJSONObject(i).getString("NUMPASS");
				String tmpNacionalidad = objRegistroOffline_JSON.getJSONObject(i).getString("NACIONALIDAD");
				String tmpPais = objRegistroOffline_JSON.getJSONObject(i).getString("PAIS");
				String tmpSexo = objRegistroOffline_JSON.getJSONObject(i).getString("SEXO");
				String tmpFNacimiento = objRegistroOffline_JSON.getJSONObject(i).getString("FNACIMIENTO");
				String tmpFIngreso = objRegistroOffline_JSON.getJSONObject(i).getString("FINGRESO");
				String tmpFSalida = objRegistroOffline_JSON.getJSONObject(i).getString("FSALIDA");
				String tmpAerolinea = objRegistroOffline_JSON.getJSONObject(i).getString("AEROLINEA");
				String tmpAOrigen = objRegistroOffline_JSON.getJSONObject(i).getString("AORIGEN");
				String tmpAeroArribo = objRegistroOffline_JSON.getJSONObject(i).getString("AEROARRIBO");
				String tmpHospedaje = objRegistroOffline_JSON.getJSONObject(i).getString("HOSPEDAJE");
				org.json.JSONArray  arrTmpHospedaje = new org.json.JSONArray(tmpHospedaje);
				String tmpActividad = objRegistroOffline_JSON.getJSONObject(i).getString("ACTIVIDAD");
				org.json.JSONArray  arrTmpActividad = new org.json.JSONArray(tmpActividad);
				String tmpTipoDocumento = objRegistroOffline_JSON.getJSONObject(i).getString("TIPO_DOCUMENTO");
				String tmpNumeroRegistro = objRegistroOffline_JSON.getJSONObject(i).getString("NUMERO_REGISTRO");
				String tmpObservacion = objRegistroOffline_JSON.getJSONObject(i).getString("OBSERVACION");
				String tmpCodigoTramite = objRegistroOffline_JSON.getJSONObject(i).getString("CODIGO_TRAMITE");
				String tmpFRegistro = objRegistroOffline_JSON.getJSONObject(i).getString("FREGISTRO");
				String tmpEstado = objRegistroOffline_JSON.getJSONObject(i).getString("ESTDO");
				String tmpFImpresion = objRegistroOffline_JSON.getJSONObject(i).getString("FIMPRESION");
				String tmpTipoEspecie = objRegistroOffline_JSON.getJSONObject(i).getString("TIPO_ESPECIE");
				String tmpCodigoBarras = objRegistroOffline_JSON.getJSONObject(i).getString("CODIGO_BARRAS");

				//FALTA OBTENER LOS DATOS
				String tmpNumGrupoTurista = tmpCodigoBarras;
				com.besixplus.sii.objects.Cgg_tct_grupo_turista objGrupTuris = new com.besixplus.sii.objects.Cgg_tct_grupo_turista();				
				objGrupTuris.setCTGTR_CODIGO("KEYGEN");
				objGrupTuris.setCUSU_CODIGO(tmpCodigoUsuario);
				objGrupTuris.setCTADC_CODIGO(null);
				objGrupTuris.setCTGTR_NUMERO(Integer.valueOf(tmpNumGrupoTurista));
				objGrupTuris.setCTGTR_FECHA_RESERVA(Timestamp.valueOf(tmpFRegistro));
				objGrupTuris.setCTGTR_FECHA_INGRESO(Timestamp.valueOf(tmpFIngreso));
				objGrupTuris.setCTGTR_FECHA_SALIDA(Timestamp.valueOf(tmpFSalida));
				objGrupTuris.setCTGTR_ESTADO(true);
				objGrupTuris.setCTGTR_USUARIO_INSERT(usuarioName);
				objGrupTuris.setCTGTR_USUARIO_UPDATE(usuarioName);
				res = new com.besixplus.sii.db.Cgg_tct_grupo_turista(objGrupTuris).insert(con);

				//Almacenar en la tabla persona
				com.besixplus.sii.objects.Cgg_res_persona objPer = new com.besixplus.sii.objects.Cgg_res_persona();
				objPer.setCRPER_CODIGO("KEYGEN");
				objPer.setCRDID_CODIGO(tmpTipoDocumento);
				objPer.setCGNCN_CODIGO(tmpNacionalidad);
				objPer.setCRPER_NOMBRES(tmpNombres);
				objPer.setCRPER_APELLIDO_PATERNO(tmpApellidos);
				objPer.setCRPER_NUM_DOC_IDENTIFIC(tmpNumPass);
				objPer.setCRPER_FECHA_NACIMIENTO(Timestamp.valueOf(tmpFNacimiento.replace("T", " ")));
				objPer.setCRPER_GENERO( Integer.valueOf(tmpSexo));
				objPer.setCGG_CPAIS_CODIGO(tmpPais);
				objPer.setCRPER_ESTADO(true);					
				objPer.setCRPER_USUARIO_INSERT(usuarioName);
				objPer.setCRPER_USUARIO_UPDATE(usuarioName);				

				//Alamacenar en la tabla Cgg_tct_registro
				com.besixplus.sii.objects.Cgg_tct_registro obj = new com.besixplus.sii.objects.Cgg_tct_registro();
				obj.setCTREG_CODIGO("KEYGEN");
				obj.setCTGTR_CODIGO(objGrupTuris.getCTGTR_CODIGO());						
				obj.setCUSU_CODIGO(tmpCodigoUsuario);						
				obj.setCGG_CUSU_CODIGO(null);
				obj.setCARPT_CODIGO(tmpAOrigen);
				obj.setCGG_CARPT_CODIGO(tmpAeroArribo);
				obj.setCRALN_CODIGO(tmpAerolinea);
				obj.setCRTRA_CODIGO(tmpCodigoTramite.length()!=0?tmpCodigoTramite:null);
				obj.setCTREG_NUMERO(Integer.valueOf(tmpNumeroRegistro));
				obj.setCTREG_FECHA_PREREGISTRO(Timestamp.valueOf(tmpFRegistro.replace("T", " ")));
				obj.setCTREG_FECHA_INGRESO(Timestamp.valueOf(tmpFIngreso.replace("T", " ")));
				obj.setCTREG_CODIGO_BARRAS(tmpCodigoBarras);		
				obj.setCTREG_FECHA_SALIDA(Timestamp.valueOf(tmpFSalida.replace("T", " ")));
				obj.setCTREG_ESTADO_REGISTRO(Integer.valueOf(tmpEstado.replace("T", " ")));
				obj.setCTREG_OBSERVACION(tmpObservacion);
				obj.setCTREG_ESTADO(true);
				obj.setCTREG_USUARIO_INSERT(usuarioName);
				obj.setCTREG_USUARIO_UPDATE(usuarioName);
				res = new com.besixplus.sii.db.Cgg_tct_registro(obj).insert(con);

				com.besixplus.sii.objects.Cgg_kdx_venta_detalle objKdx = new com.besixplus.sii.objects.Cgg_kdx_venta_detalle();
				objKdx.setCKVDT_CODIGO("KEYGEN");
				objKdx.setCKESP_CODIGO(tmpTipoEspecie);
				objKdx.setCTREG_CODIGO(obj.getCTREG_CODIGO());
				objKdx.setCKVDT_ESTADO(true);
				objKdx.setCKVDT_USUARIO_INSERT(usuarioName);
				objKdx.setCKVDT_USUARIO_UPDATE(usuarioName);
				res = new com.besixplus.sii.db.Cgg_kdx_venta_detalle(objKdx).insert(con);

				//Almacenar en la tabla Cgg_tct_grupo_actividad
				com.besixplus.sii.objects.Cgg_tct_grupo_actividad objGrupAct = new com.besixplus.sii.objects.Cgg_tct_grupo_actividad();
				for (int j = 0 ; j < arrTmpActividad.length(); j++){
					objGrupAct.setCTGAC_CODIGO("KEYGEN");
					objGrupAct.setCTGTR_CODIGO(objGrupTuris.getCTGTR_CODIGO());
					objGrupAct.setCTACT_CODIGO(((org.json.JSONObject)arrTmpActividad.get(j)).get("CTACT_CODIGO").toString());
					objGrupAct.setCTGAC_ESTADO(true);
					objGrupAct.setCTGAC_USUARIO_INSERT(usuarioName);
					objGrupAct.setCTGAC_USUARIO_UPDATE(usuarioName);
					res = new com.besixplus.sii.db.Cgg_tct_grupo_actividad(objGrupAct).insert(con);
				}

				//Almacenar en la tabla Cgg_tct_grupo_hospedaje			
				com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje objGrupHosp = new com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje();
				for (int l = 0 ; l < arrTmpHospedaje.length(); l++){
					objGrupHosp.setCTGHJ_CODIGO("KEYGEN");
					objGrupHosp.setCTGTR_CODIGO(objGrupTuris.getCTGTR_CODIGO());
					objGrupHosp.setCTTHJ_CODIGO(((org.json.JSONObject)arrTmpHospedaje.get(l)).get("CTTHJ_CODIGO").toString());
					objGrupHosp.setCTGHJ_ESTADO(true);
					objGrupHosp.setCTGHJ_USUARIO_INSERT(usuarioName);
					objGrupHosp.setCTGHJ_USUARIO_UPDATE(usuarioName);
					res = new com.besixplus.sii.db.Cgg_tct_grupo_hospedaje(objGrupHosp).insert(con);				
				}
				
				if(res.equals("true")){
					con.commit();
					tmpServerResponse.setSuccess(true);
					tmpServerResponse.setMsg("");
				}else{	
					con.rollback();
					tmpServerResponse.setMsg(res);
				}
			}			
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			tmpServerResponse.setMsg(inException.getMessage());
		} catch (JSONException e) {
			e.printStackTrace();
			tmpServerResponse.setMsg(e.getMessage());
		}
		return new JSONObject(tmpServerResponse).toString();
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_tct_registro EN UNA ESTRUCTRA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_tct_registro.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_tct_registro EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_tct_registro.selectCount(con, tmpRequest.getUserPrincipal().getName(), keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_tct_registro.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_tct_registro.
	 * @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	 * @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE GRUPO DE TURISTAS
	 * @param inCarpt_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCgg_carpt_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCtreg_numero NUMERO SECUENCIAL UNICO DEL REGISTRO DE TCT
	 * @param inCtreg_fecha_preregistro FECHA DE RESERVA DEL TCT
	 * @param inCtreg_fecha_ingreso FECHA DE INGRESO  A LA PROVINCIA
	 * @param inCtreg_codigo_barras CODIGO DE BARRAS GENERADO PARA EL REGISTRO DE TCT
	 * @param inCtreg_fecha_salida FECHA DE SALIDA DE LA PROVINCIA
	 * @param inHospedaje_JSON HOSPEDAJE
	 * @param inActividad_JSON ACTIVIDAD	
	 * @param inPersona_JSON PERSONA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(			
			@WebParam(name="inCtgtr_codigo")String inCtgtr_codigo,
			@WebParam(name="inCarpt_codigo")String inCarpt_codigo,
			@WebParam(name="inCgg_carpt_codigo")String inCgg_carpt_codigo,
			@WebParam(name="inCraln_codigo")String inCraln_codigo,
			@WebParam(name="inCtreg_numero")String inCtreg_numero,
			@WebParam(name="inCtreg_fecha_preregistro")java.util.Date inCtreg_fecha_preregistro,
			@WebParam(name="inCtreg_fecha_ingreso")java.util.Date inCtreg_fecha_ingreso,		
			@WebParam(name="inCtreg_codigo_barras")String inCtreg_codigo_barras,
			@WebParam(name="inCtreg_fecha_salida")java.util.Date inCtreg_fecha_salida,
			@WebParam(name="inHospedaje_JSON")String inHospedaje_JSON,
			@WebParam(name="inActividad_JSON")String inActividad_JSON,
			@WebParam(name="inPersona_JSON")String inPersona_JSON
	) throws SOAPException{
		String res = "true";
		String numeroGrupo ;
		String numRegistro;
		String codigoRegisUsu;
		ServerResponse tmpServerResponse = new ServerResponse();
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		try{
			Connection con = ManagerConnection.getConnection();			
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}

			con.setAutoCommit(false);
			org.json.JSONArray actividadJson = new org.json.JSONArray(inActividad_JSON);
			org.json.JSONArray personaJson = new org.json.JSONArray(inPersona_JSON);
			org.json.JSONArray hospedajeJson = new org.json.JSONArray(inHospedaje_JSON);
			com.besixplus.sii.objects.Cgg_res_persona objPer = new com.besixplus.sii.objects.Cgg_res_persona();
			com.besixplus.sii.objects.Cgg_tct_grupo_actividad objGrupAct = new com.besixplus.sii.objects.Cgg_tct_grupo_actividad();
			objGrupAct.setCTGTR_CODIGO(inCtgtr_codigo);
			com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje objGrupHosp = new com.besixplus.sii.objects.Cgg_tct_grupo_hospedaje();
			objGrupHosp.setCTGTR_CODIGO(inCtgtr_codigo);		
			com.besixplus.sii.objects.Cgg_tct_registro obj = new com.besixplus.sii.objects.Cgg_tct_registro();
			obj.setCTGTR_CODIGO(inCtgtr_codigo);
			com.besixplus.sii.objects.Cgg_kdx_venta_detalle objkdx = new com.besixplus.sii.objects.Cgg_kdx_venta_detalle();

			// ELIMINAR REGISTRO ASOCIONADOS A Cgg_tct_registro,Cgg_tct_grupo_actividad, Cgg_tct_grupo_hospedaje
			if(res.equals("true"))
				res = new com.besixplus.sii.db.Cgg_tct_grupo_actividad(objGrupAct).deleteCGG_TCT_GRUPO_TURISTA(con);
			if(res.equals("true"))
				res = new com.besixplus.sii.db.Cgg_tct_grupo_hospedaje(objGrupHosp).deleteCGG_TCT_GRUPO_TURISTA(con);
			for (int i = 0 ; i < personaJson.length(); i++){
				objkdx.setCTREG_CODIGO(((org.json.JSONObject)personaJson.get(i)).get("CTREG_CODIGO").toString());
				res = new com.besixplus.sii.db.Cgg_kdx_venta_detalle(objkdx).deleteCGG_TCT_REGISTRO1(con);
			}			
			res = new com.besixplus.sii.db.Cgg_tct_registro(obj).deleteCGG_TCT_GRUPO_TURISTA(con);

			com.besixplus.sii.objects.Cgg_tct_grupo_turista tmpGrupoTurista = new com.besixplus.sii.objects.Cgg_tct_grupo_turista();
			tmpGrupoTurista.setCTGTR_CODIGO(inCtgtr_codigo);
			new com.besixplus.sii.db.Cgg_tct_grupo_turista(tmpGrupoTurista).select(con);
			tmpGrupoTurista.setCTGTR_FECHA_RESERVA(inCtreg_fecha_preregistro);
			tmpGrupoTurista.setCTGTR_FECHA_INGRESO(inCtreg_fecha_ingreso);
			tmpGrupoTurista.setCTGTR_FECHA_SALIDA(inCtreg_fecha_salida);
			numeroGrupo= Cgg_tct_grupo_turista.selectNumero(con, inCtgtr_codigo);

			if(res.equals("true")){
				res = new com.besixplus.sii.db.Cgg_tct_grupo_turista(tmpGrupoTurista).update(con);
			}

			if(res.equals("true")){			

				//////////////////////////////////////
				//Almacenar en la tabla Cgg_tct_registro

				//tmpRequest.getUserPrincipal().getName()
				codigoRegisUsu = com.besixplus.sii.db.Cgg_tct_registro.selecUsuario(con,tmpRequest.getUserPrincipal().getName());
				for (int i = 0 ; i < personaJson.length(); i++){

					numRegistro=com.besixplus.sii.db.Cgg_tct_registro.numeroRegistroTct(con);
					obj.setCTREG_CODIGO("KEYGEN");
					/////////////////////////////////////////////////////////
					//Almacenar personas y nuevas personas
					objPer.setCRDID_CODIGO(personaJson.getJSONObject(i).getString("CRDID_CODIGO"));
					objPer.setCRPER_NOMBRES(personaJson.getJSONObject(i).getString("CRPER_NOMBRES"));
					objPer.setCRPER_NUM_DOC_IDENTIFIC(personaJson.getJSONObject(i).getString("CRPER_NUM_DOC_IDENTIFIC"));
					objPer.setCRPER_APELLIDO_PATERNO(personaJson.getJSONObject(i).getString("CRPER_APELLIDO_PATERNO"));
					objPer.setCRPER_GENERO(personaJson.getJSONObject(i).getInt("CRPER_GENERO"));
					objPer.setCGNCN_CODIGO(personaJson.getJSONObject(i).getString("CGNCN_CODIGO"));
					objPer.setCRPER_FECHA_NACIMIENTO(Timestamp.valueOf(personaJson.getJSONObject(i).getString("CRPER_FECHA_NACIMIENTO").replace("T", " ")));
					objPer.setCGG_CPAIS_CODIGO(personaJson.getJSONObject(i).getString("CGG_CPAIS_CODIGO"));
					objPer.setCRPER_ESTADO(true);					
					objPer.setCRPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					if(((org.json.JSONObject)personaJson.get(i)).get("CRPER_CODIGO").toString().trim().length()==0){

						objPer.setCRPER_CODIGO("KEYGEN");							
						objPer.setCRPER_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_res_persona(objPer).insertTctPersona(con);							
						obj.setCRPER_CODIGO(objPer.getCRPER_CODIGO());
					}else
					{
						obj.setCRPER_CODIGO(personaJson.getJSONObject(i).getString("CRPER_CODIGO"));
						objPer.setCRPER_CODIGO(obj.getCRPER_CODIGO());
						res = new com.besixplus.sii.db.Cgg_res_persona(objPer).updateTctPersona(con);
					}
					if (res.equals("true")){
						obj.setCTGTR_CODIGO(inCtgtr_codigo);					
						obj.setCUSU_CODIGO(codigoRegisUsu);						
						obj.setCGG_CUSU_CODIGO(null);				
						obj.setCARPT_CODIGO(inCarpt_codigo);
						obj.setCGG_CARPT_CODIGO(inCgg_carpt_codigo);
						obj.setCRALN_CODIGO(inCraln_codigo);
						obj.setCRTRA_CODIGO((personaJson.getJSONObject(i).getString("CRTRA_CODIGO").trim().length())!=0?(((org.json.JSONObject)personaJson.get(i)).get("CRTRA_CODIGO").toString()):null);	
						obj.setCTREG_NUMERO(Integer.valueOf(numRegistro));
						obj.setCTREG_FECHA_PREREGISTRO(inCtreg_fecha_preregistro);
						obj.setCTREG_FECHA_INGRESO(inCtreg_fecha_ingreso);
						obj.setCTREG_CODIGO_BARRAS(numeroGrupo+numRegistro);			
						obj.setCTREG_FECHA_SALIDA(inCtreg_fecha_salida);
						obj.setCTREG_ESTADO_REGISTRO(0);
						obj.setCTREG_OBSERVACION(personaJson.getJSONObject(i).getString("CTREG_OBSERVACION"));
						obj.setCTREG_ESTADO(true);
						obj.setCTREG_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						obj.setCTREG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_tct_registro(obj).insert(con);
						if (res.equals("true")){
							com.besixplus.sii.objects.Cgg_kdx_venta_detalle objKdx = new com.besixplus.sii.objects.Cgg_kdx_venta_detalle();
							objKdx.setCKVDT_CODIGO("KEYGEN");
							objKdx.setCKESP_CODIGO(((org.json.JSONObject)personaJson.get(i)).get("CKESP_CODIGO").toString());
							objKdx.setCTREG_CODIGO(obj.getCTREG_CODIGO());
							objKdx.setCKVDT_ESTADO(true);
							objKdx.setCKVDT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							objKdx.setCKVDT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_kdx_venta_detalle(objKdx).insert(con);
						}	
					}
				}

				//System.out.println("Hola1 "+obj.getCTREG_CODIGO().toString());

				if(res.equals("true")){
					//////////////////////////////////////
					//Almacenar en la tabla Cgg_tct_grupo_actividad

					for (int j = 0 ; j < actividadJson.length(); j++){
						objGrupAct.setCTGAC_CODIGO("KEYGEN");
						objGrupAct.setCTGTR_CODIGO(inCtgtr_codigo);
						objGrupAct.setCTACT_CODIGO(((org.json.JSONObject)actividadJson.get(j)).get("CTACT_CODIGO").toString());
						objGrupAct.setCTGAC_ESTADO(true);
						objGrupAct.setCTGAC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objGrupAct.setCTGAC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_tct_grupo_actividad(objGrupAct).insert(con);
					}

					if(res.equals("true")){
						//////////////////////////////////////
						//Almacenar en la tabla Cgg_tct_grupo_hospedaje			

						for (int l = 0 ; l < hospedajeJson.length(); l++){
							objGrupHosp.setCTGHJ_CODIGO("KEYGEN");
							objGrupHosp.setCTGTR_CODIGO(inCtgtr_codigo);
							objGrupHosp.setCTTHJ_CODIGO(((org.json.JSONObject)hospedajeJson.get(l)).get("CTTHJ_CODIGO").toString());
							objGrupHosp.setCTGHJ_ESTADO(true);
							objGrupHosp.setCTGHJ_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							objGrupHosp.setCTGHJ_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_tct_grupo_hospedaje(objGrupHosp).insert(con);
						}
					}
				}
			}
			if (res.equals("true")){
				con.commit();
				tmpServerResponse.setSuccess(true);				
			}else{							
				con.rollback();
				tmpServerResponse.setMsg(res);
			}
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			tmpServerResponse.setMsg(inException.getMessage());
		} catch (JSONException e) {
			e.printStackTrace();
			tmpServerResponse.setMsg(e.getMessage());
		}
		return new JSONObject(tmpServerResponse).toString();
	}


	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_tct_registro EN UNA ESTRUCTURA JSON o XML.
	 * @param inCtreg_codigo ctreg_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCtreg_codigo")String inCtreg_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_tct_registro tmpObj = new com.besixplus.sii.objects.Cgg_tct_registro();
		tmpObj.setCTREG_CODIGO(inCtreg_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_tct_registro(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_tct_registro> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_tct_registro>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_tct_registro.
	 * @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCtreg_codigo")String inCtreg_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_tct_registro tmpObj = new com.besixplus.sii.objects.Cgg_tct_registro();
		tmpObj.setCTREG_CODIGO(inCtreg_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_tct_registro(tmpObj).delete(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}

	@WebMethod
	public String cargarEncuesta() throws SOAPException{
		List<PreguntaEncuesta> preguntas =null;
		Gson gson = new Gson();
		try {
			Connection con = ManagerConnection.getConnection();
			preguntas = EncuestaData.getAllPreguntas(con,"ENCUESTA_TCT");
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return gson.toJson(preguntas);
	}

	@WebMethod
	public String getTctTransporte() throws SOAPException{
		List<TctTransporte> transportes =null;
		Gson gson = new Gson();
		try {
			Connection con = ManagerConnection.getConnection();
			transportes = TctTransporteData.getAllTransportes(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return gson.toJson(transportes);
	}


	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_tct_registro EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inCrdid_codigo CODIGO DEL TIPO DE DOCUMENTO DE IDENTIFICACION
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION
	 * @param inCtreg_fecha_ingreso FECHA DE INGRESO TENTATIVO A LA PROVINCIA
	 * @param format FORMATO DE SALIDA DE LOS DATOS JSON o XML
	 * @return String FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectPersonaTct(
			@WebParam(name="inCrdid_codigo")String inCrdid_codigo,
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
			@WebParam(name="inCtreg_fecha_ingreso")java.util.Date inCtreg_fecha_ingreso,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;		
		try{
			Connection con = ManagerConnection.getConnection();

			if(tmpRequest.getUserPrincipal()!=null){
				if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
					con.close();
					throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				}	
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_tct_registro.selectPersona(con, inCrdid_codigo, inCrper_num_doc_identific,inCtreg_fecha_ingreso);
			con.close();
			//--> AC --> Conexion con Dinardap cuando no existen Datos.
			if(inCrdid_codigo.equals("1") && obj.size()==0){
				RegistroCivil registroCivil = new RegistroCivil(inCrper_num_doc_identific);
				if (registroCivil.callServiceAsObject().equals(RegistroCivil.CALL_OK)) {
					if (registroCivil.getCedula() != null && !registroCivil.getCedula().trim().isEmpty()) {
						HashMap<String,Object> valueMap = new HashMap<>();
						List<String> apellidos = Utils.buildNombresApellidos(registroCivil.getNombre(), registroCivil.getNombrePadre(), registroCivil.getNombreMadre());
						if (apellidos != null && apellidos.size() == 3) {
							if (apellidos.get(0).length() > 0) {
								valueMap.put("CRPER_APELLIDO_PATERNO", Characters.WHITESPACE.leftTrim(apellidos.get(0)));
							}
							if (apellidos.get(1).length() > 0) {
								valueMap.put("CRPER_APELLIDO_MATERNO", Characters.WHITESPACE.leftTrim(apellidos.get(1)));
							}
							if (apellidos.get(2).length() > 0) {
								valueMap.put("CRPER_NOMBRES", Characters.WHITESPACE.leftTrim(apellidos.get(2)));
							}
						}
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						try {
							Date parsedDate = sdf.parse(registroCivil.getFechaNacimiento());
							sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							valueMap.put("CRPER_FECHA_NACIMIENTO", sdf.format(parsedDate));
						} catch (ParseException e) {
							e.printStackTrace();
						}

						if (registroCivil.getNacionalidad().equals("ECUATORIANA")) {
							valueMap.put("CGNCN_CODIGO", "61");
							valueMap.put("NACIONALIDAD", "Ecuador");
						}
						if (registroCivil.getGenero().equals("MUJER")) {
							valueMap.put("CRPER_GENERO", "1");
						} else {
							valueMap.put("CRPER_GENERO", "0");
						}
						obj.add(valueMap);
					}
				}
			}
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			return tmpFormat.getData().toString();

		return null;
	}
	/**
	 * OBTIENE EL NUMERO DE REGISTRO DE TCT	 
	 * @return numRegistro DE TIPO STRING
	 * @throws SOAPException 
	 */
	@WebMethod
	public String numeroRegistro(

	) throws SOAPException{		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_tct_registro tmpObj = new com.besixplus.sii.objects.Cgg_tct_registro();
		String numRegistro;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());			
			numRegistro = com.besixplus.sii.db.Cgg_tct_registro.numeroRegistroTct(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpObj != null)
			return numRegistro;
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_tct_actividad EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA. 
	 * @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @param inCtreg_codigo CODIGO DE LA TABLA Cgg_tct_registro
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectActividadTct(
			@WebParam(name="inCtgtr_codigo")String inCtgtr_codigo,
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
			obj = com.besixplus.sii.db.Cgg_tct_registro.selectActividad(con, inCtgtr_codigo);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_tct_actividad EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA. 
	 * @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @param inCtreg_codigo CODIGO DE LA TABLA Cgg_tct_registro
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectHospedajeTct(
			@WebParam(name="inCtgtr_codigo")String inCtgtr_codigo,
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
			obj = com.besixplus.sii.db.Cgg_tct_registro.selectHospedaje(con, inCtgtr_codigo);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_tct_actividad EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA. 
	 * @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCtreg_estado_registro ESTADO DE REGISTRO DE TRAMITE
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @param inCtreg_codigo CODIGO DE LA TABLA Cgg_tct_registro
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectTctPersonaTct(
			@WebParam(name="inCtgtr_codigo")String inCtgtr_codigo,
			@WebParam(name="inCtreg_estado_registro")String inCtreg_estado_registro,
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
			obj = com.besixplus.sii.db.Cgg_tct_registro.selectTctPersona(con, inCtgtr_codigo, inCtreg_estado_registro);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}if (obj != null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_tct_registro.
	 * @param inCtgtr_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String deleteGrupo(
			@WebParam(name="inCtgtr_codigo")String inCtgtr_codigo
	) throws SOAPException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_tct_registro tmpObj = new com.besixplus.sii.objects.Cgg_tct_registro();
		tmpObj.setCTGTR_CODIGO(inCtgtr_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_tct_registro(tmpObj).deleteCGG_TCT_GRUPO_TURISTA(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}

	/**
	 * OBTIENE LOS REGISTROS DE VARIAS TABLAS EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA. 
	 * @param inCtgtr_numero numero DE LA TABLA Cgg_tct_grupo_turista
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectRegistroCodigoBarras(
			@WebParam(name="inCtgtr_numero")String inCtgtr_numero,
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
			obj = com.besixplus.sii.db.Cgg_tct_registro.selectRegistroCodigo(con,inCtgtr_numero);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_tct_registro.
	 * @param inPersona_JSON JSON QUE CONTIENE LOS REGISTRO A SER ACTUALIZADO
	 * @param inCtreg_estado_registro ESTADO DEL PROCESO DE REGISTRO DE TCT
		1 - IMPRESA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String updateEstadoImpresa(
			@WebParam(name="inPersona_JSON")String inPersona_JSON,			
			@WebParam(name="inCtreg_estado_registro")int inCtreg_estado_registro
	) throws SOAPException{
		String res = "true";
		String codigoRegisUsu;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_tct_registro obj = new com.besixplus.sii.objects.Cgg_tct_registro();	

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			codigoRegisUsu = com.besixplus.sii.db.Cgg_tct_registro.selecUsuario(con, tmpRequest.getUserPrincipal().getName());			
			org.json.JSONArray personaJson = new org.json.JSONArray(inPersona_JSON);
			com.besixplus.sii.objects.Cgg_kdx_venta_detalle objKdx = null;

			for (int i = 0 ; i < personaJson.length(); i++){
				obj.setCTREG_CODIGO(((org.json.JSONObject)personaJson.get(i)).get("CTREG_CODIGO").toString());
				obj.setCGG_CUSU_CODIGO(codigoRegisUsu);
				obj.setCTREG_IMPRESION_ESPECIE(new Date());
				obj.setCTREG_ESTADO_REGISTRO(inCtreg_estado_registro);		
				obj.setCTREG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
				res = new com.besixplus.sii.db.Cgg_tct_registro(obj).updateEstado(con);

				///// Cgg_kdx_venta_detalle				
				objKdx = new com.besixplus.sii.objects.Cgg_kdx_venta_detalle();
				objKdx.setCKESP_CODIGO(((org.json.JSONObject)personaJson.get(i)).get("CKESP_CODIGO").toString());
				objKdx.setCTREG_CODIGO(((org.json.JSONObject)personaJson.get(i)).get("CTREG_CODIGO").toString());
				res = new com.besixplus.sii.db.Cgg_kdx_venta_detalle(objKdx).ventaRegistro(con, tmpRequest.getUserPrincipal().getName(), TipoAmbitoEspecie.TCT.getValue());
				if(!res.equals("true")){
					break;
				}
			}
			if(!res.equals("true") )
				con.rollback();
			else
				con.commit();	
			con.setAutoCommit(true);
			con.close();
			if(!res.equals("true") )
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_tct_registro.
	 * @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	 * @param inPersona_JSON JSON QUE CONTIENE LOS REGISTRO A SER ACTUALIZADO
	 * @param inCtreg_estado_registro ESTADO DEL PROCESO DE REGISTRO DE TCT
		1 - IMPRESA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String updateEstadoAnulada(
			@WebParam(name="inCtreg_codigo")String inCtreg_codigo,			
			@WebParam(name="inCtreg_estado_registro")int inCtreg_estado_registro
	) throws SOAPException{
		String res = "true";
		String codigoRegisUsu;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_tct_registro obj = new com.besixplus.sii.objects.Cgg_tct_registro();	

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			codigoRegisUsu = com.besixplus.sii.db.Cgg_tct_registro.selecUsuario(con, tmpRequest.getUserPrincipal().getName());
			obj.setCTREG_CODIGO(inCtreg_codigo);
			obj.setCGG_CUSU_CODIGO(codigoRegisUsu);			
			obj.setCTREG_ESTADO_REGISTRO(inCtreg_estado_registro);		//tmpRequest.getUserPrincipal().getName()
			obj.setCTREG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());			
			res = new com.besixplus.sii.db.Cgg_tct_registro(obj).updateEstadoAnulado(con);

			if(!res.equals("true"))
				con.rollback();
			else
				con.commit();	
			con.setAutoCommit(true);
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
	 * Obtiene una cadena de datos de todos los certificados de transeunte con tramite y persona relacionado que estan activos.
	 * @param format Formato de salida JSON|XML
	 * @return Datos en formato especificado.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectTranseunteOffline(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}			
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_tct_registro.selectTranseunteOffline(con);
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
	 * Obtiene una cadena de datos de las personas notificadas para verificacion de tct offline.
	 * @param format Formato de salida JSON|XML
	 * @return Datos en formato especificado.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectNotificadoOffline(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}			
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_tct_registro.selectNotificadoOffline(con);
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
	 * Obtiene una cadena de datos con informacion las personas impedidas de ingreso por al restriccion de 90 dias anuales para verificacion de tct offline.
	 * @param format Formato de salida JSON|XML
	 * @return Datos en formato especificado.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectDiaPermanenciaOffline(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}			
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_tct_registro.selectExcedidoDiasOffline(con);
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
	 * Obtiene informacion de las especies impresas asociadas un registro de TCT. 
	 * @param inCtreg_codigo Codigo de registro de TCT.
	 * @param format Formato de salida de la informacion JSON o XML.
	 * @return
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectEspeciesImpresas(
			@WebParam(name="inCtreg_codigo")String inCtreg_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}			
			con.setAutoCommit(false);
			com.besixplus.sii.objects.Cgg_tct_registro tmpObject = new com.besixplus.sii.objects.Cgg_tct_registro();
			tmpObject.setCTREG_CODIGO(inCtreg_codigo);
			obj = new com.besixplus.sii.db.Cgg_tct_registro(tmpObject).selectEspeciesImpresas(con, tmpRequest.getUserPrincipal().getName());
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
	 * Valida la informacion de personas para exportar a offline en caso de caracteres invalidado.
	 * @param format Formato de salida JSON/XML
	 * @return Cadena de datos con numero de identificacion de personal con info. invalida.
	 * @throws SOAPException
	 */
	@WebMethod
	public String validarInformacionOffline(
				@WebParam(name="format")String format
			) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}			
			con.setAutoCommit(false);
			
			obj = new com.besixplus.sii.db.Cgg_tct_registro().validarInformacionOffline(con);
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
}