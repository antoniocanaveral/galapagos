package com.besixplus.sii.ws;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javax.xml.ws.WebFault;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import org.jboss.security.Base64Encoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.misc.Formatter;
import com.besixplus.sii.objects.Cgg_buzon_correo;
import com.besixplus.sii.objects.Cgg_configuracion;
import com.besixplus.sii.objects.Cgg_sec_usuario_contacto;
import com.besixplus.sii.objects.Cgg_sec_usuario_rol;
import com.besixplus.sii.objects.Cgg_usuario_persona;

/**
 * CLASE Cgg_usuario
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_usuario POR MEDIO DE SERVICOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
@WebFault()
public class Cgg_usuario implements Serializable{

	private static final long serialVersionUID = 1938093129;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;
	
	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_usuario.
	 * @param inCrcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA.
	 * @param inCtagv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA DE VIAJES.
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON.
	 * @param inCisla_codigo 	 
	 * @param inCusu_nombre_usuario IDENTIFICATIVO VALIDO PARA INGRESO AL SISTEMA.
	 * @param inCusu_clave_acceso CLAVE DE ACCESO.
	 * @param inCusu_usuario_interno TIPO DE USUARIO DEFINIDO PARA ACCESO AL SISTEMA
INTERNO
EXTERNO.
	 * @param inCusu_caduca_clave SI LA CLAVE DEL USUARIO CADUCA.
	 * @param inCusu_fecha_clave_act 
	 * @param inCusu_activo SI ESTA AUTORIZO EL ACCESO AL SISTEMA O ESTA SUSPENDIDO.
	 * @param inCusu_cambiar_clave SI EL USUARIO DEBE CAMBIAR LA CLAVE EN EL SIGUIENTE INGRESO.
	 * @param inPersona INFORMACION DE LA PERSONA NUEVA EN FORMATO JSON
	 * @param inContactos CONTACTOS DEL USUARIO
	 * @param inContactosEliminados CONTACTOS ELIMINADOS DEL USUARIO
	 * @param inPerfiles ROLES ASIGNADOS AL USUARIO
	 * @param inPerfilesEliminados ROLES QUE HAN RETIRADOS DEL USUARIO
	 * @param inNotificaciones CORREOS ELECTRONICOS AL QUE DEBE ENVIAR LA NOTIFICACION DEL NUEVO USUARIO 
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPFaultException 
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrcrg_codigo")String inCrcrg_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name="inCusu_nombre_usuario")String inCusu_nombre_usuario,
			@WebParam(name="inCusu_clave_acceso")String inCusu_clave_acceso,
			@WebParam(name="inCusu_usuario_interno")boolean inCusu_usuario_interno,
			@WebParam(name="inCusu_caduca_clave")boolean inCusu_caduca_clave,
			@WebParam(name="inCusu_activo")boolean inCusu_activo,
			@WebParam(name="inCusu_cambiar_clave")boolean inCusu_cambiar_clave,
			@WebParam(name="inContactos")String inContactos,
			@WebParam(name="inContactosEliminados")String inContactosEliminados,
			@WebParam(name="inPersona")String inPersona,
			@WebParam(name="inPerfiles")String inPerfiles,
			@WebParam(name="inPerfilesEliminados")String inPerfilesEliminados,
			@WebParam(name="inNotificaciones")String inNotificaciones
	)throws SOAPException{
		String res = "true";
		String tmpBckClave = inCusu_clave_acceso;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_usuario obj = new com.besixplus.sii.objects.Cgg_usuario();
		obj.setCUSU_CODIGO("KEYGEN");
		obj.setCRCRG_CODIGO(inCrcrg_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);
		obj.setCISLA_CODIGO(inCisla_codigo);
		obj.setCUSU_NOMBRE_USUARIO(inCusu_nombre_usuario.toLowerCase());
		obj.setCUSU_CLAVE_ACCESO(inCusu_clave_acceso);
		obj.setCUSU_USUARIO_INTERNO(inCusu_usuario_interno);
		obj.setCUSU_CADUCA_CLAVE(inCusu_caduca_clave);
		obj.setCUSU_FECHA_CLAVE_ACT(new Date());
		obj.setCUSU_ACTIVO(inCusu_activo);
		obj.setCUSU_CAMBIAR_CLAVE(inCusu_cambiar_clave);
		obj.setCUSU_ESTADO(true);
		obj.setCUSU_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCUSU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			String tmpMessage = null;
			if((tmpMessage = checkKeyConstraint(obj, con, tmpMessage)) != null)
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(tmpMessage, new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));

			con.setAutoCommit(false);
			com.besixplus.sii.objects.Cgg_res_persona tmpPer = null;
			if(inCrper_codigo == null){
				try {
					JSONObject tmpPersona = new JSONObject(inPersona);
					tmpPer = new com.besixplus.sii.objects.Cgg_res_persona();
					tmpPer.setCRPER_CODIGO("KEYGEN");
					tmpPer.setCRPER_NOMBRES(tmpPersona.getString("CRPER_NOMBRES"));
					tmpPer.setCRPER_APELLIDO_PATERNO(tmpPersona.getString("CRPER_APELLIDO_PATERNO"));
					tmpPer.setCRPER_APELLIDO_MATERNO(tmpPersona.getString("CRPER_APELLIDO_MATERNO"));
					tmpPer.setCRDID_CODIGO(tmpPersona.getString("CRDID_CODIGO"));
					tmpPer.setCRPER_FECHA_NACIMIENTO(new SimpleDateFormat("dd/MM/yyyy").parse(tmpPersona.getString("CRPER_FECHA_NACIMIENTO")));
					tmpPer.setCRPER_NUM_DOC_IDENTIFIC(tmpPersona.getString("CRPER_NUM_DOC_IDENTIFIC"));
					tmpPer.setCRPER_ESTADO(true);
					tmpPer.setCRPER_ESTADO_INTERFECTO(false);
					tmpPer.setCRECV_CODIGO(tmpPersona.getString("CRECV_CODIGO"));
					tmpPer.setCRPER_GENERO(tmpPersona.getInt("CRPER_GENERO"));
				} catch (JSONException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if(tmpPer != null){
				if(new com.besixplus.sii.db.Cgg_res_persona(tmpPer).insert(con).equals("true"));
				obj.setCRPER_CODIGO(tmpPer.getCRPER_CODIGO());
			}
			res = new com.besixplus.sii.db.Cgg_usuario(obj).insert(con);
			
			Cgg_sec_usuario_contacto tmpUC = new Cgg_sec_usuario_contacto();
			if(res.equals("true")){
				JSONArray tmpContactoEliminados = new JSONArray(inContactosEliminados);
				for(int i = 0; i < tmpContactoEliminados.length(); i++){
					String tmpCodigo = tmpContactoEliminados.getString(i);
					tmpUC.setCSUCT_CODIGO(tmpCodigo);
					res = new com.besixplus.sii.db.Cgg_sec_usuario_contacto(tmpUC).delete(con, false);
					if(!res.equals("true"))
						break;
				}
			}
			if(res.equals("true")){
				JSONArray tmpContactos = new JSONArray(inContactos);
				for(int i=0; i<tmpContactos.length(); i++){
					JSONObject tmpContacto = tmpContactos.getJSONObject(i);
					if(tmpContacto.getString("CSUCT_CODIGO").equals("KEYGEN")){
						tmpUC.setCSUCT_CODIGO("KEYGEN");
						tmpUC.setCUSU_CODIGO(obj.getCUSU_CODIGO());
						tmpUC.setCRTCO_CODIGO(tmpContacto.getString("CRTCO_CODIGO"));
						tmpUC.setCSUCT_CONTACTO(tmpContacto.getString("CSUCT_CONTACTO"));
						tmpUC.setCSUCT_OBSERVACION(tmpContacto.getString("CSUCT_OBSERVACION"));
						tmpUC.setCSUCT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						tmpUC.setCSUCT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						tmpUC.setCSUCT_ESTADO(true);
						res = new com.besixplus.sii.db.Cgg_sec_usuario_contacto(tmpUC).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
			}
			Cgg_sec_usuario_rol tmpUR = new Cgg_sec_usuario_rol();
			if(res.equals("true")){
				JSONArray tmpPerfilesEliminados = new JSONArray(inPerfilesEliminados);
				for(int i = 0; i < tmpPerfilesEliminados.length(); i++){
					String tmpPerfil = tmpPerfilesEliminados.getString(i);
					tmpUR.setCSPER_CODIGO(tmpPerfil);
					res = new com.besixplus.sii.db.Cgg_sec_usuario_rol(tmpUR).delete(con);
					if(!res.equals("true"))
						break;
				}
			}
			if(res.equals("true")){
				JSONArray tmpPerfiles = new JSONArray(inPerfiles);
				for(int i = 0; i < tmpPerfiles.length(); i++){
					JSONObject tmpPerfil = tmpPerfiles.getJSONObject(i);
					if(tmpPerfil.getString("CSPER_CODIGO").equals("KEYGEN")){
						tmpUR.setCSPER_CODIGO("KEYGEN");
						tmpUR.setCSPER_ESTADO(true);
						tmpUR.setCSROL_CODIGO(tmpPerfil.getString("CSROL_CODIGO"));
						tmpUR.setCUSU_CODIGO(obj.getCUSU_CODIGO());
						tmpUR.setCSPER_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						tmpUR.setCSPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						tmpUR.setCSPER_ESTADO(true);
						res = new com.besixplus.sii.db.Cgg_sec_usuario_rol(tmpUR).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
			}
			Cgg_configuracion tmpConfiguracion = new Cgg_configuracion();
			tmpConfiguracion.setCGCNF_CODIGO("CONF40");
			new com.besixplus.sii.db.Cgg_configuracion(tmpConfiguracion).select(con);
			
			if(res.equals("true")){
				JSONArray tmpJsonEmail = new JSONArray(inNotificaciones);
				for(int i = 0; i < tmpJsonEmail.length(); i++){
					JSONObject tmpCorreo = tmpJsonEmail.getJSONObject(i);
					Cgg_buzon_correo tmpBuzon = new Cgg_buzon_correo();
					tmpBuzon.setCBZC_CODIGO("KEYGEN");
					tmpBuzon.setCBZC_ASUNTO("Control de acceso");
					tmpBuzon.setCBZC_DESTINATARIO(tmpCorreo.getString("email"));
					tmpBuzon.setCBZC_TIPO_CONTENIDO("text/plain");
					tmpBuzon.setCBZC_MENSAJE(myInfoMessages.getMessage("sii.seguridad.notificacion.contenido", new String[]{obj.getCUSU_NOMBRE_USUARIO(), tmpBckClave, tmpConfiguracion.getCGCNF_VALOR_CADENA()}));
					tmpBuzon.setCBZC_ESTADO(true);
					tmpBuzon.setCBZC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					tmpBuzon.setCBZC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_buzon_correo(tmpBuzon).insert(con);
					if(!res.equals("true"))
						break;
				}
			}
			if(res.equals("true"))
				con.commit();
			else
				con.rollback();
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
	 * ACTUALIZA LA CLAVE DE UN USUARIO.
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	 * @param inCusu_clave_acceso_anterior CLAVE DE ACCESO ACTUAL DEL USUARIO PARA ACCEDER AL SISTEMA
	 * @param inCusu_clave_acceso CLAVE DE ACCESO NUEVA.
	 * @param inCusu_cambiar_clave SI EL USUARIO DEBE CAMBIAR LA CLAVE AL SIGUIENTE ACCESO AL SISTEMA
	 * @param inNotificaciones NOTIFICACIONES
	 * @param inEnviarNotificacion SI SE ENVIA UNA NOTIFICACION AL CORREO ELECTRONICO DE LA PERSONA 
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPFaultException 
	 * @throws SOAPException 
	 */
	@WebMethod
	public String updateClave(
			@WebParam(name="inCusu_codigo")String inCusu_codigo,
			@WebParam(name="inCusu_clave_acceso_anterior")String inCusu_clave_acceso_anterior,
			@WebParam(name="inCusu_clave_acceso")String inCusu_clave_acceso,			
			@WebParam(name="inCusu_cambiar_clave")boolean inCusu_cambiar_clave,
			@WebParam(name="inNotificaciones")String inNotificaciones
	)throws SOAPFaultException, SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_usuario obj = new com.besixplus.sii.objects.Cgg_usuario();
		obj.setCUSU_CODIGO(inCusu_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			String tmpMessage = null;

			obj = new com.besixplus.sii.db.Cgg_usuario(obj).select(con);
			obj.setCUSU_CLAVE_ACCESO(inCusu_clave_acceso_anterior);			

			obj.setCUSU_CAMBIAR_CLAVE(inCusu_cambiar_clave);
			obj.setCUSU_FECHA_CLAVE_ACT(new Date());
			obj.setCUSU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
			res = new com.besixplus.sii.db.Cgg_usuario(obj).verificarContraseniaByUsuario(con);			
			if(res.equals("true") || inCusu_clave_acceso_anterior == null){
				obj.setCUSU_CLAVE_ACCESO(inCusu_clave_acceso);	
				if((tmpMessage = checkKeyConstraint(obj, con, tmpMessage)) != null)
					throw new SOAPFaultException(SOAPFactory.newInstance().createFault(tmpMessage, new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				res = new com.besixplus.sii.db.Cgg_usuario(obj).update(con);
			}
			if(res.equals("true")){
				JSONArray tmpJsonEmail = new JSONArray(inNotificaciones);
				for(int i = 0; i < tmpJsonEmail.length(); i++){
					JSONObject tmpCorreo = tmpJsonEmail.getJSONObject(i);
					Cgg_buzon_correo tmpBuzon = new Cgg_buzon_correo();
					tmpBuzon.setCBZC_CODIGO("KEYGEN");
					tmpBuzon.setCBZC_ASUNTO("Control de acceso");
					tmpBuzon.setCBZC_DESTINATARIO(tmpCorreo.getString("email"));
					tmpBuzon.setCBZC_TIPO_CONTENIDO("text/plain");
					tmpBuzon.setCBZC_MENSAJE(myInfoMessages.getMessage("sii.seguridad.notificacion.restablecer", new String[]{obj.getCUSU_NOMBRE_USUARIO(), inCusu_clave_acceso}));
					tmpBuzon.setCBZC_ESTADO(true);
					tmpBuzon.setCBZC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					tmpBuzon.setCBZC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_buzon_correo(tmpBuzon).insert(con);
					if(!res.equals("true"))
						break;
				}
			}
			
			con.commit();
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_usuario EN UNA ESTRUCTRA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_usuario> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_usuario.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_usuario EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LA INFORMACION JSON o XML
	 * @param inCusu_usuario_interno DISCRIMINANTE DE TIPO DE USUARIOS -1 TODOS, 0 = EXTERNOS, 1 = INTERNOS
	 * @param inCrper_codigo CODIGO DE PERSONA, PARA OBTENER LOS USUARIO DE UNA PERSONA  
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
			@WebParam(name="format")String format,
			@WebParam(name="inCusu_usuario_interno")String inCusu_usuario_interno,
			@WebParam(name="inCrper_codigo")String inCrper_codigo
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
			tmpCount = com.besixplus.sii.db.Cgg_usuario.selectCount(con, keyword,inCusu_usuario_interno,inCrper_codigo);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_usuario.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inCusu_usuario_interno, inCrper_codigo);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_usuario.
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	 * @param inCrcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	 * @param inCtagv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE AGENCIA DE VIAJES
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON	 
	 * @param inCisla_codigo CODIGO DE ISLA.
	 * @param inCusu_nombre_usuario IDENTIFICATIVO VALIDO PARA INGRESO AL SISTEMA
	 * @param inCusu_clave_acceso CLAVE DE ACCESO	
	 * @param inCusu_usuario_interno TIPO DE USUARIO DEFINIDO PARA ACCESO AL SISTEMA
INTERNO
EXTERNO
	 * @param inCusu_caduca_clave SI LA CLAVE DEL USUARIO CADUCA
	 * @param inCusu_fecha_clave_act 
	 * @param inCusu_activo SI ESTA AUTORIZO EL ACCESO AL SISTEMA O ESTA SUSPENDIDO.
	 * @param inCusu_cambiar_clave SI EL USUARIO DEBE CAMBIAR LA CLAVE EN EL SIGUIENTE INGRESO.
	 * @param inContactos CONTACTOS
	 * @param inContactosEliminados CONTACTOS ELIMINADOS
	 * @param inPerfiles PERFILES
	 * @param inPerfilesEliminados PERFILES ELIMINADOS
	 * @param inNotificaciones NOTIFICACIONES
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCusu_codigo")String inCusu_codigo,
			@WebParam(name="inCrcrg_codigo")String inCrcrg_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name="inCusu_nombre_usuario")String inCusu_nombre_usuario,
			@WebParam(name="inCusu_clave_acceso")String inCusu_clave_acceso,
			@WebParam(name="inCusu_usuario_interno")boolean inCusu_usuario_interno,
			@WebParam(name="inCusu_caduca_clave")boolean inCusu_caduca_clave,
			@WebParam(name="inCusu_activo")boolean inCusu_activo,
			@WebParam(name="inCusu_cambiar_clave")boolean inCusu_cambiar_clave,
			@WebParam(name="inContactos")String inContactos,
			@WebParam(name="inContactosEliminados")String inContactosEliminados,
			@WebParam(name="inPerfiles")String inPerfiles,
			@WebParam(name="inPerfilesEliminados")String inPerfilesEliminados,
			@WebParam(name="inNotificaciones")String inNotificaciones
	) throws SOAPException{
		String res = "true";
		Connection con = ManagerConnection.getConnection();
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		try{
			con.setAutoCommit(false);
			com.besixplus.sii.objects.Cgg_usuario obj = new com.besixplus.sii.objects.Cgg_usuario();
			obj.setCUSU_CODIGO(inCusu_codigo);
			new com.besixplus.sii.db.Cgg_usuario(obj).select(con);
			
			obj.setCRCRG_CODIGO(inCrcrg_codigo);
			obj.setCRPER_CODIGO(inCrper_codigo);
			obj.setCRPJR_CODIGO(inCrpjr_codigo);
			obj.setCCTN_CODIGO(inCctn_codigo);
			obj.setCISLA_CODIGO(inCisla_codigo);
			obj.setCUSU_NOMBRE_USUARIO(inCusu_nombre_usuario);
			obj.setCUSU_CLAVE_ACCESO(inCusu_clave_acceso);
			obj.setCUSU_USUARIO_INTERNO(inCusu_usuario_interno);
			obj.setCUSU_CADUCA_CLAVE(inCusu_caduca_clave);
			obj.setCUSU_ACTIVO(inCusu_activo);
			obj.setCUSU_CAMBIAR_CLAVE(inCusu_cambiar_clave);
			obj.setCUSU_ESTADO(true);
			obj.setCUSU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_usuario(obj).update(con);
			Cgg_sec_usuario_contacto tmpUC = new Cgg_sec_usuario_contacto();
			if(res.equals("true")){
				JSONArray tmpContactoEliminados = new JSONArray(inContactosEliminados);
				for(int i = 0; i < tmpContactoEliminados.length(); i++){
					String tmpCodigo = tmpContactoEliminados.getString(i);
					tmpUC.setCSUCT_CODIGO(tmpCodigo);
					res = new com.besixplus.sii.db.Cgg_sec_usuario_contacto(tmpUC).delete(con, false);
					if(!res.equals("true"))
						break;
				}
			}
			if(res.equals("true")){
				JSONArray tmpContactos = new JSONArray(inContactos);
				for(int i=0; i<tmpContactos.length(); i++){
					JSONObject tmpContacto = tmpContactos.getJSONObject(i);
					if(tmpContacto.getString("CSUCT_CODIGO").equals("KEYGEN")){
						tmpUC.setCSUCT_CODIGO("KEYGEN");
						tmpUC.setCUSU_CODIGO(obj.getCUSU_CODIGO());
						tmpUC.setCRTCO_CODIGO(tmpContacto.getString("CRTCO_CODIGO"));
						tmpUC.setCSUCT_CONTACTO(tmpContacto.getString("CSUCT_CONTACTO"));
						tmpUC.setCSUCT_OBSERVACION(tmpContacto.getString("CSUCT_OBSERVACION"));
						tmpUC.setCSUCT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						tmpUC.setCSUCT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						tmpUC.setCSUCT_ESTADO(true);
						res = new com.besixplus.sii.db.Cgg_sec_usuario_contacto(tmpUC).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
			}
			Cgg_sec_usuario_rol tmpUR = new Cgg_sec_usuario_rol();
			if(res.equals("true")){
				JSONArray tmpPerfilesEliminados = new JSONArray(inPerfilesEliminados);
				for(int i = 0; i < tmpPerfilesEliminados.length(); i++){
					String tmpPerfil = tmpPerfilesEliminados.getString(i);
					tmpUR.setCSPER_CODIGO(tmpPerfil);
					res = new com.besixplus.sii.db.Cgg_sec_usuario_rol(tmpUR).delete(con);
					if(!res.equals("true"))
						break;
				}
			}
			if(res.equals("true")){
				JSONArray tmpPerfiles = new JSONArray(inPerfiles);
				for(int i = 0; i < tmpPerfiles.length(); i++){
					JSONObject tmpPerfil = tmpPerfiles.getJSONObject(i);
					if(tmpPerfil.getString("CSPER_CODIGO").equals("KEYGEN")){
						tmpUR.setCSPER_CODIGO("KEYGEN");
						tmpUR.setCSPER_ESTADO(true);
						tmpUR.setCSROL_CODIGO(tmpPerfil.getString("CSROL_CODIGO"));
						tmpUR.setCUSU_CODIGO(obj.getCUSU_CODIGO());
						tmpUR.setCSPER_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						tmpUR.setCSPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						tmpUR.setCSPER_ESTADO(true);
						res = new com.besixplus.sii.db.Cgg_sec_usuario_rol(tmpUR).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
			}
			if(res.equals("true"))
				con.commit();
			else
				con.rollback();
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_usuario EN UNA ESTRUCTURA JSON o XML.
	 * @param inCusu_codigo cusu_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCusu_codigo")String inCusu_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_usuario tmpObj = new com.besixplus.sii.objects.Cgg_usuario();
		tmpObj.setCUSU_CODIGO(inCusu_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_usuario(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_usuario> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_usuario>();
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
	 * OBTIENE LA INFORMACION DEL USUARIO QUE SE CONECTANDO A LA APLICACION. 
	 * @return
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectByUsername() throws SOAPException{
		String outUserInfo = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		try {
			Connection tmpCon = ManagerConnection.getConnection();
			tmpCon.setAutoCommit(!ManagerConnection.isDeployed());
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(tmpCon, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				tmpCon.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			com.besixplus.sii.objects.Cgg_usuario tmpUsuario = new com.besixplus.sii.objects.Cgg_usuario();
			tmpUsuario.setCUSU_NOMBRE_USUARIO(tmpRequest.getUserPrincipal().getName());
			new com.besixplus.sii.db.Cgg_usuario(tmpUsuario).selectByUsername(tmpCon);
			ArrayList<com.besixplus.sii.objects.Cgg_usuario> tmpObject = new ArrayList<com.besixplus.sii.objects.Cgg_usuario>();
			tmpObject.add(tmpUsuario);
			Formatter tmpFormat = new Formatter("JSON", tmpObject);
			outUserInfo = tmpFormat.getData().toString();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return outUserInfo;
	}
	/**
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_usuario.
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCusu_codigo")String inCusu_codigo
	) throws SOAPException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_usuario tmpObj = new com.besixplus.sii.objects.Cgg_usuario();
		tmpObj.setCUSU_CODIGO(inCusu_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_usuario(tmpObj).delete(con, true);
			con.close();
			if(!outResult.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(outResult, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}

	/**
	 * ELIMINADO PERMANENTE DE UN REGISTRO EN LA TABLA Cgg_usuario.
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String deleteHard(
			@WebParam(name="inCusu_codigo")String inCusu_codigo
	) throws SOAPException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_usuario tmpObj = new com.besixplus.sii.objects.Cgg_usuario();
		tmpObj.setCUSU_CODIGO(inCusu_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_usuario(tmpObj).delete(con, false);
			con.close();
			if(!outResult.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(outResult, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}

	/**
	 * VERIFICA LAS VALIDACIONES DE LAS CLAVES DEL USUARIO
	 * @param inObject
	 * @param inConnection
	 * @param inMessage
	 * @return
	 */
	public String checkKeyConstraint(com.besixplus.sii.objects.Cgg_usuario inObject, Connection inConnection, String inMessage){
		try {
			inConnection.setAutoCommit(false);
			Cgg_configuracion tmpConf = new Cgg_configuracion();
			tmpConf.setCGCNF_CODIGO("CONF4");
			new com.besixplus.sii.db.Cgg_configuracion(tmpConf).select(inConnection);
			if(inObject.getCUSU_CLAVE_ACCESO().trim().length()< tmpConf.getCGCNF_VALOR_NUMERICO()){
				inConnection.close();
				return "La clave de usuario no cumple con la longitud m\u00ednima.";
			}
			tmpConf.setCGCNF_CODIGO("CONF5");
			new com.besixplus.sii.db.Cgg_configuracion(tmpConf).select(inConnection);
			if(tmpConf.getCGCNF_VALOR_CADENA().trim().toUpperCase().equals("SI")){
				tmpConf.setCGCNF_CODIGO("CONF6");
				new com.besixplus.sii.db.Cgg_configuracion(tmpConf).select(inConnection);
				Pattern tmpPat = Pattern.compile(tmpConf.getCGCNF_VALOR_CADENA());
				Matcher tmpMat = tmpPat.matcher(inObject.getCUSU_CLAVE_ACCESO());				
				if(!tmpMat.matches()){
					inConnection.close();
					return "La clave no cumple con el nivel de complejidad indicado.";
				}
			}

			byte[] hash = java.security.MessageDigest.getInstance("MD5").digest(inObject.getCUSU_CLAVE_ACCESO().getBytes());
			inObject.setCUSU_CLAVE_ACCESO(Base64Encoder.encode(hash));			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}	
		return null;
	}

	/**Selecciona un registro de la tabla de usuario junto con informacion de persona.
	 * @param inCusu_codigo Codigo de usuario.
	 * @param format Cadena de formato de salida JSON/XML.
	 * @return Cadena de datos en formato especificado.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectUsuarioPersona(
			@WebParam(name="inCusu_codigo")String inCusu_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_usuario tmpObj = new com.besixplus.sii.objects.Cgg_usuario();
		tmpObj.setCUSU_CODIGO(inCusu_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			Cgg_usuario_persona tmpUsuarioPersona = new com.besixplus.sii.db.Cgg_usuario(tmpObj).select1(con);
			ArrayList<Cgg_usuario_persona> tmpArray = new ArrayList<Cgg_usuario_persona>();
			tmpArray.add(tmpUsuarioPersona);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**Selecciona el codigo del usuario de acuerdo el nombre del usuario
	 * @param inCusu_nombre_usuario Nombre de usuario.
	 * @param format Cadena de formato de salida JSON/XML.
	 * @return Cadena de datos en formato especificado.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectCodigoUsuarioByIdUsuario(
			@WebParam(name="inCusu_nombre_usuario")String inCusu_nombre_usuario,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_usuario tmpObj = new com.besixplus.sii.objects.Cgg_usuario();
		tmpObj.setCUSU_NOMBRE_USUARIO(inCusu_nombre_usuario);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			Cgg_usuario_persona tmpUsuarioPersona = new com.besixplus.sii.db.Cgg_usuario(tmpObj).selectCodigoUsuarioByIdUsuario(con);
			ArrayList<Cgg_usuario_persona> tmpArray = new ArrayList<Cgg_usuario_persona>();
			tmpArray.add(tmpUsuarioPersona);
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
	* Verifica si la contrasenia es o no valida segun el usuario
	* @param inCusu_codigo CODIGO DEL USUARIO
	* @param inCusu_clave_acceso CLAVE DE ACCESO DE USUARIO
	* @return Boolean
	* @throws SOAPException 
	*/
	@WebMethod
	public String verificarContraseniaByUsuario(
		@WebParam(name="inCusu_codigo")String inCusu_codigo,
		@WebParam(name="inCusu_clave_acceso")String inCusu_clave_acceso
	) throws SOAPException{
		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);		
		String tmpObj = "false";
		com.besixplus.sii.objects.Cgg_usuario obj = new com.besixplus.sii.objects.Cgg_usuario();
		obj.setCUSU_CODIGO(inCusu_codigo);		
		obj.setCUSU_CLAVE_ACCESO(inCusu_clave_acceso);
		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			/*String tmpMessage = null;
			
			if((tmpMessage = checkKeyConstraint(obj, con, tmpMessage)) != null)
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(tmpMessage, new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));*/
			con.setAutoCommit(!ManagerConnection.isDeployed());			
			tmpObj = new com.besixplus.sii.db.Cgg_usuario(obj).verificarContraseniaByUsuario(con); //com.besixplus.sii.db.Cgg_usuario.verificarContraseniaByUsuario(con);			
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpObj != null)
			return tmpObj;
		return null;
	}
}