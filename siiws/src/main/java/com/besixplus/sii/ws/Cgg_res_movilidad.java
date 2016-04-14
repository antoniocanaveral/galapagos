package com.besixplus.sii.ws;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.besixplus.sii.objects.Cgg_tct_movilidad_actividad;
import com.besixplus.sii.objects.Cgg_tct_movilidad_hospedaje;
import com.besixplus.sii.objects.ServerResponse;

/**
 * CLASE Cgg_res_movilidad
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_movilidad POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_movilidad implements Serializable{

	private static final long serialVersionUID = 1791586514;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_movilidad.
	 * @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	 * @param inCarpt_codigo IDENTIFICATIVO AEROPUERTO DE PARTIDA.
	 * @param inCgg_carpt_codigo IDENTIFICATIVO AEROPUERTO DE ARRIVO.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO.
	 * @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT.
	 * @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA.
	 * @param inCrmov_fecha_viaje FECHA DE VIAJE.
	 * @param inCrmov_tipo_operacion TIPO DE OPERACION: 0 - ENTRADA, 1 - SALIDA
	 * @param inCrmov_numero_vuelo NUMERO DE VUELO.
	 * @param inCrmov_observacion DESCRIPCION CORTA DE LA OPERACION.
	 * @param inCrmov_tipo_salida TIPO DE SALIDA DE LA PROVINCIA: 0 -  NORMAL, 1 - ESPECIAL.
	 * @param inCrmov_filtro_interno IDENTIFICAR SI LA PERSONA PASO POR EL CONTROL DE NACIONAL O EXTRANJERO.
	 * @param inPersonaJSON INFORMACION DE LA PERSONA QUE SE REGISTRA LA MOVILIDAD
	 * @param inActividadesJSON INFORMACION DE LAS ACTIVIDADES QUE REALIZA LA PERSONA
	 * @param inHospedajesJSON HOSPEDAJE DE LA PERSONA 
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCraln_codigo")String inCraln_codigo,
			@WebParam(name="inCarpt_codigo")String inCarpt_codigo,
			@WebParam(name="inCgg_carpt_codigo")String inCgg_carpt_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCtreg_codigo")String inCtreg_codigo,
			@WebParam(name="inCrrsd_codigo")String inCrrsd_codigo,
			@WebParam(name="inCrmov_fecha_viaje")String inCrmov_fecha_viaje,
			@WebParam(name="inCrmov_tipo_operacion")int inCrmov_tipo_operacion,
			@WebParam(name="inCrmov_numero_vuelo")String inCrmov_numero_vuelo,
			@WebParam(name="inCrmov_observacion")String inCrmov_observacion,
			@WebParam(name="inCrmov_tipo_salida")int inCrmov_tipo_salida,
			@WebParam(name="inCrmov_filtro_interno")boolean inCrmov_filtro_interno,
			@WebParam(name="inPersonaJSON")String inPersonaJSON,
			@WebParam(name="inActividadesJSON")String inActividadesJSON,
			@WebParam(name="inHospedajesJSON")String inHospedajesJSON
	) throws SOAPException{
		String res = "true";
		Calendar tmpCalendar = Calendar.getInstance();
		tmpCalendar.set(Calendar.YEAR, Integer.valueOf(inCrmov_fecha_viaje.split("-")[0]));
		tmpCalendar.set(Calendar.MONTH, Integer.valueOf(inCrmov_fecha_viaje.split("-")[1])-1);
		tmpCalendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(inCrmov_fecha_viaje.split("-")[2]));
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_movilidad obj = new com.besixplus.sii.objects.Cgg_res_movilidad();
		obj.setCRMOV_CODIGO("KEYGEN");
		obj.setCRALN_CODIGO(inCraln_codigo.trim().isEmpty()?null:inCraln_codigo);
		obj.setCARPT_CODIGO(inCarpt_codigo);
		obj.setCGG_CARPT_CODIGO(inCgg_carpt_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCTREG_CODIGO(inCtreg_codigo);
		obj.setCRRSD_CODIGO(inCrrsd_codigo);
		obj.setCRMOV_FECHA_VIAJE(tmpCalendar.getTime());
		obj.setCRMOV_TIPO_OPERACION(inCrmov_tipo_operacion);
		obj.setCRMOV_NUMERO_VUELO(inCrmov_numero_vuelo);
		obj.setCRMOV_OBSERVACION(inCrmov_observacion);
		obj.setCRMOV_SOPORTE(false);
		obj.setCRMOV_ESTADO(true);
		obj.setCRMOV_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRMOV_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		obj.setCRMOV_TIPO_SALIDA(inCrmov_tipo_salida);
		obj.setCRMOV_FILTRO_INTERNO(inCrmov_filtro_interno);;

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_res_movilidad(obj).insert(con);
			
			if(res.equals("true") && inPersonaJSON != null){
				JSONObject tmpPersonaJSON = new JSONObject(inPersonaJSON);
				Cgg_res_persona tmpPersona = new Cgg_res_persona();
				tmpPersona.setCRPER_CODIGO(tmpPersonaJSON.getString("CRPER_CODIGO"));
				new com.besixplus.sii.db.Cgg_res_persona(tmpPersona).select(con);
				String tmpApellidos = tmpPersonaJSON.getString("CRPER_APELLIDOS");
				if(!tmpApellidos.trim().isEmpty()){
					tmpPersona.setCRPER_APELLIDO_PATERNO(tmpApellidos.split(" ")[0]);
					if(tmpApellidos.split(" ").length > 1)
						tmpPersona.setCRPER_APELLIDO_MATERNO(tmpApellidos.split(" ")[1]);
				}
				tmpPersona.setCRPER_NOMBRES(tmpPersonaJSON.getString("CRPER_NOMBRES"));
				tmpPersona.setCGNCN_CODIGO(tmpPersonaJSON.getString("CGNCN_CODIGO"));
				tmpPersona.setCRPER_GENERO(tmpPersonaJSON.getInt("CRPER_GENERO"));
				tmpPersona.setCRPER_FECHA_NACIMIENTO(Timestamp.valueOf(tmpPersonaJSON.getString("CRPER_FECHA_NACIMIENTO")));
				tmpPersona.setCRDID_CODIGO(tmpPersonaJSON.getString("CRDID_CODIGO"));
				tmpPersona.setCGG_CPAIS_CODIGO(tmpPersonaJSON.getString("CGG_CPAIS_CODIGO"));
				tmpPersona.setCRPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());//cambio aqui
				res = new com.besixplus.sii.db.Cgg_res_persona(tmpPersona).update(con);
			}
			if(res.equalsIgnoreCase("true") && inActividadesJSON != null && inCrmov_tipo_operacion == 0){
				JSONArray tmpActividades = new JSONArray(inActividadesJSON);
				for(int i = 0; i < tmpActividades.length(); i++){
					Cgg_tct_movilidad_actividad tmpMovAct = new Cgg_tct_movilidad_actividad();
					tmpMovAct.setCTMVC_CODIGO("KEYGEN");
					tmpMovAct.setCRMOV_CODIGO(obj.getCRMOV_CODIGO());
					tmpMovAct.setCTACT_CODIGO(tmpActividades.getJSONObject(i).getString("CTACT_CODIGO"));
					tmpMovAct.setCTMVC_ESTADO(true);
					tmpMovAct.setCTMVC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					tmpMovAct.setCTMVC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_tct_movilidad_actividad(tmpMovAct).insert(con);
					if(!res.equalsIgnoreCase("true"))
						break;
				}
			}
			if(res.equalsIgnoreCase("true") && inHospedajesJSON != null && inCrmov_tipo_operacion == 0){
				JSONArray tmpHospedajes = new JSONArray(inHospedajesJSON);
				for(int i = 0; i < tmpHospedajes.length(); i++){
					Cgg_tct_movilidad_hospedaje tmpMovHos = new Cgg_tct_movilidad_hospedaje();
					tmpMovHos.setCTMVH_CODIGO("KEYGEN");
					tmpMovHos.setCRMOV_CODIGO(obj.getCRMOV_CODIGO());
					tmpMovHos.setCTTHJ_CODIGO(tmpHospedajes.getJSONObject(i).getString("CTTHJ_CODIGO"));
					tmpMovHos.setCTMVH_ESTADO(true);
					tmpMovHos.setCTMVH_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					tmpMovHos.setCTMVH_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_tct_movilidad_hospedaje(tmpMovHos).insert(con);
					if(!res.equalsIgnoreCase("true"))
						break;
				}
			}
			if(res.equals("true")){
				com.besixplus.sii.objects.Cgg_res_residencia objpersonaActualizar = new com.besixplus.sii.objects.Cgg_res_residencia();
				objpersonaActualizar.setCRPER_CODIGO(inCrper_codigo);
				objpersonaActualizar.setCRRSD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
				res = new com.besixplus.sii.db.Cgg_res_residencia(objpersonaActualizar).updateEstadoResidencia(con, obj.getCRMOV_CODIGO());
			}
			if(res.equalsIgnoreCase("true"))
				con.commit();
			else
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_movilidad.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_tct_registro EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_movilidad.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_movilidad.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_movilidad.
	 * @param inCrmov_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCarpt_codigo IDENTIFICATIVO AEROPUERTO DE PARTIDA
	 * @param inCgg_carpt_codigo IDENTIFICATIVO AEROPUERTO DE ARRIVO
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO
	 * @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT
	 * @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA	
	 * @param inCrmov_fecha_viaje FECHA DE VIAJE
	 * @param inCrmov_tipo_operacion TIPO DE OPERACION
		0 - ENTRADA
		1 - SALIDA    
	 * @param inCrmov_numero_vuelo NUMERO DE VUELO
	 * @param inCrmov_observacion DESCRIPCION CORTA DE LA OPERACION
	 * @param inCrmov_tipo_salida TIPO DE SALIDA DE LA PROVINCIA
		0.-  NORMAL
		1.- ESPECIAL
	 * @param inTmpTipoResidencia TIPO DE RESIDENCIA
	 * @param inCrmov_filtro_interno IDENTIFICAR SI LA PERSONA PASO POR EL CONTROL DE NACIONAL O EXTRANJERO
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrmov_codigo")String inCrmov_codigo,
			@WebParam(name="inCraln_codigo")String inCraln_codigo,
			@WebParam(name="inCarpt_codigo")String inCarpt_codigo,
			@WebParam(name="inCgg_carpt_codigo")String inCgg_carpt_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCtreg_codigo")String inCtreg_codigo,
			@WebParam(name="inCrrsd_codigo")String inCrrsd_codigo,
			@WebParam(name="inCrmov_fecha_viaje")java.util.Date inCrmov_fecha_viaje,
			@WebParam(name="inCrmov_tipo_operacion")int inCrmov_tipo_operacion,
			@WebParam(name="inCrmov_numero_vuelo")String inCrmov_numero_vuelo,
			@WebParam(name="inCrmov_observacion")String inCrmov_observacion,
			@WebParam(name="inCrmov_tipo_salida")int inCrmov_tipo_salida,
			@WebParam(name="inTmpTipoResidencia")String inTmpTipoResidencia,
			@WebParam(name="inCrmov_filtro_interno")boolean inCrmov_filtro_interno
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_movilidad obj = new com.besixplus.sii.objects.Cgg_res_movilidad();
		obj.setCRMOV_CODIGO(inCrmov_codigo);
		obj.setCRALN_CODIGO(inCraln_codigo.trim().isEmpty()?null:inCraln_codigo);
		obj.setCARPT_CODIGO(inCarpt_codigo.trim().isEmpty()?null:inCarpt_codigo);
		obj.setCGG_CARPT_CODIGO(inCgg_carpt_codigo.trim().isEmpty()?null:inCgg_carpt_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCTREG_CODIGO(inCtreg_codigo);
		obj.setCRRSD_CODIGO(inCrrsd_codigo);
		obj.setCRMOV_FECHA_VIAJE(inCrmov_fecha_viaje);
		obj.setCRMOV_TIPO_OPERACION(inCrmov_tipo_operacion);
		obj.setCRMOV_NUMERO_VUELO(inCrmov_numero_vuelo);
		obj.setCRMOV_OBSERVACION(inCrmov_observacion);
		obj.setCRMOV_SOPORTE(false);
		obj.setCRMOV_ESTADO(true);
		obj.setCRMOV_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		obj.setCRMOV_TIPO_SALIDA(inCrmov_tipo_salida);
		obj.setCRMOV_FILTRO_INTERNO(inCrmov_filtro_interno);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_movilidad(obj).update(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_movilidad EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrmov_codigo crmov_codigo
	 * @param format 
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrmov_codigo")String inCrmov_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_movilidad tmpObj = new com.besixplus.sii.objects.Cgg_res_movilidad();
		tmpObj.setCRMOV_CODIGO(inCrmov_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_movilidad(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_movilidad>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}


	/**
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_movilidad.
	 * @param inCrmov_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrmov_codigo")String inCrmov_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_movilidad tmpObj = new com.besixplus.sii.objects.Cgg_res_movilidad();
		tmpObj.setCRMOV_CODIGO(inCrmov_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_movilidad(tmpObj).delete(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}return new Boolean(outResult).toString();
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_tct_registro EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPageIngreso(
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
			tmpCount = com.besixplus.sii.db.Cgg_res_movilidad.selectIngresoCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_movilidad.selectAllIngreso(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE VARIAS TABLAS EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA. 
	 * @param inCrper_numero_residencia NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inCtgtr_numero numero DE LA TABLA Cgg_tct_grupo_turista
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectMovilidadNumeroResidenteIngreso(
			@WebParam(name="inCrper_numero_residencia")String inCrper_numero_residencia,
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
			obj = com.besixplus.sii.db.Cgg_res_movilidad.selectMovilidadIngresoResidentesCodigo(con, inCrper_numero_residencia);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}if (obj != null)
			return tmpFormat.getData().toString();
		return null;
	}



	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_tct_registro EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPageResidentesIngreso(
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
			tmpCount = com.besixplus.sii.db.Cgg_res_movilidad.selectIngresoResidentesCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_movilidad.selectAllIngresoResidentes(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_tct_registro EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * ESTE SERVICIO ES LLAMADO DESDE EL DIALOGO DE SELECCION DE INGRESO DE PERSONA POR TCT.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inIdentificacion IDENTIFICACION DE PERSONA
	 * @param inMovimiento MOVIMIENTO
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA. 
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectPagePersonasBuscarTCT(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inIdentificacion")String inIdentificacion,
			@WebParam(name="inMovimiento")int inMovimiento
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
			tmpCount = com.besixplus.sii.db.Cgg_res_movilidad.selectBuscarPersonasCount(con, keyword, inIdentificacion, inMovimiento);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_movilidad.selectAllBuscarPersonas(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inIdentificacion, inMovimiento);
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
	 * OBTIENE LOS REGISTROS DE VARIAS TABLAS EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA. 
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inCrper_numero_identific numero DE LA TABLA Cgg_tct_grupo_turista
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectMovilidadPersonasNumIdentific(
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
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
			obj = com.besixplus.sii.db.Cgg_res_movilidad.selectMovilidadPerNumIdentific(con,inCrper_num_doc_identific);
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
	 * OBTIENE LOS REGISTROS DE VARIAS TABLAS EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA. 
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inCrper_numero_identific numero DE LA TABLA Cgg_tct_grupo_turista
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectMovilidadSalidaPersonasNumIdentific(
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
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
			obj = com.besixplus.sii.db.Cgg_res_movilidad.selectMovilidadSalidaPerNumIdentific(con,inCrper_num_doc_identific);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}if (obj != null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_tct_registro EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inIdentificacion IDENTIFICACION
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA. 
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectPageResidentes(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inIdentificacion")String inIdentificacion
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
			tmpCount = com.besixplus.sii.db.Cgg_res_movilidad.selectResidentesCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_movilidad.selectAllResidentes(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inIdentificacion);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_tct_registro EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * ESTE SERVICIO ES LLAMADO DESDE EL DIALOGO DE SELECCION DE INGRESO DE PERSONA POR TCT.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inIdentificacion IDENTIFICACION
	 * @param inMovimiento MOVIMIENTO
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA. 
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectPersonasBuscarTCT_offline(			
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
			
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_movilidad.selectMovilidadIngresoOffLine(con,tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();			
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return outCadena.toString();
			
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * ESTE SERVICIO ES LLAMADO DESDE EL DIALOGO DE SELECCION DE INGRESO DE PERSONA POR TCT.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inIdentificacion IDENTIFICACION
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA. 
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectResidentes_offline(			
			@WebParam(name="format")String format,
			@WebParam(name="in_Canton")String in_Canton
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
			
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_movilidad.selectResidenteOffLine(con,tmpRequest.getUserPrincipal().getName(),in_Canton);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();			
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return outCadena.toString();
			
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_tct_registro EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * ESTE SERVICIO ES LLAMADO DESDE EL DIALOGO DE SELECCION DE INGRESO DE PERSONA POR TCT.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inIdentificacion IDENTIFICACION
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA. 
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectSalidaPersona_offline(			
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
			
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_movilidad.selectMovilidadSalidaOffLine(con,tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();			
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return outCadena.toString();
			
		return null;
	}
	
	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_movilidad.
	 * @param inCraln_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	 * @param inCarpt_codigo IDENTIFICATIVO AEROPUERTO DE PARTIDA.
	 * @param inCgg_carpt_codigo IDENTIFICATIVO AEROPUERTO DE ARRIVO.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO.
	 * @param inCtreg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TCT.
	 * @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA.
	 * @param inCrmov_fecha_viaje FECHA DE VIAJE.
	 * @param inCrmov_tipo_operacion TIPO DE OPERACION: 0 - ENTRADA, 1 - SALIDA
	 * @param inCrmov_numero_vuelo NUMERO DE VUELO.
	 * @param inCrmov_observacion DESCRIPCION CORTA DE LA OPERACION.
	 * @param inCrmov_tipo_salida TIPO DE SALIDA DE LA PROVINCIA: 0 -  NORMAL, 1 - ESPECIAL.
	 * @param inCrmov_filtro_interno IDENTIFICAR SI LA PERSONA PASO POR EL CONTROL DE NACIONAL O EXTRANJERO.
	 * @param inPersonaJSON INFORMACION DE LA PERSONA QUE SE REGISTRA LA MOVILIDAD
	 * @param inActividadesJSON INFORMACION DE LAS ACTIVIDADES QUE REALIZA LA PERSONA
	 * @param inHospedajesJSON HOSPEDAJE DE LA PERSONA 
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insertCsv(
			@WebParam(name="inCarpt_codigo")String inCarpt_codigo,
			@WebParam(name="inCrmov_fecha_viaje")java.util.Date  inCrmov_fecha_viaje,
			@WebParam(name="inCrmov_tipo_operacion")int inCrmov_tipo_operacion,
			@WebParam(name="inPersonaJSON")String inPersonaJSON			
	) throws SOAPException{
		String res = "true";
		String tmpCodigoBarras;
		JSONObject tmpPersonaJSON;
		JSONObject tmpValidacion;
		int tmpContador = 0;
		ServerResponse responser = new ServerResponse(false,"Movilidad no ingresada",null);
		/*Calendar tmpCalendar = Calendar.getInstance();
		tmpCalendar.set(Calendar.YEAR, Integer.valueOf(inCrmov_fecha_viaje.split("-")[0]));
		tmpCalendar.set(Calendar.MONTH, Integer.valueOf(inCrmov_fecha_viaje.split("-")[1])-1);
		tmpCalendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(inCrmov_fecha_viaje.split("-")[2]));*/
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_movilidad obj = new com.besixplus.sii.objects.Cgg_res_movilidad();
		obj.setCRMOV_CODIGO("KEYGEN");
		if (inCrmov_tipo_operacion == 0)
			obj.setCGG_CARPT_CODIGO(inCarpt_codigo);
		else
			obj.setCARPT_CODIGO(inCarpt_codigo);
		obj.setCRMOV_FECHA_VIAJE(inCrmov_fecha_viaje);
		obj.setCRMOV_TIPO_OPERACION(inCrmov_tipo_operacion);
		obj.setCRMOV_SOPORTE(false);
		obj.setCRMOV_ESTADO(true);
		obj.setCRMOV_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRMOV_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		/*obj.setCRALN_CODIGO(inCraln_codigo.trim().isEmpty()?null:inCraln_codigo);
		obj.setCGG_CARPT_CODIGO(inCgg_carpt_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCTREG_CODIGO(inCtreg_codigo);
		obj.setCRRSD_CODIGO(inCrrsd_codigo);
		obj.setCRMOV_NUMERO_VUELO(inCrmov_numero_vuelo);
		obj.setCRMOV_OBSERVACION(inCrmov_observacion);
		obj.setCRMOV_TIPO_SALIDA(inCrmov_tipo_salida);
		obj.setCRMOV_FILTRO_INTERNO(inCrmov_filtro_interno);*/

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			//res = new com.besixplus.sii.db.Cgg_res_movilidad(obj).insert(con);
			if(inPersonaJSON != null){
				JSONArray tmpArrayPersona = new JSONArray(inPersonaJSON);
				for(int i = 0; i < tmpArrayPersona.length(); i++){
				tmpPersonaJSON = tmpArrayPersona.getJSONObject(i);
				tmpValidacion = new JSONObject(tmpPersonaJSON.getString("validacion"));
				if (tmpValidacion.getString("resultadoValidacion").trim().equalsIgnoreCase("true"))
				{
					tmpCodigoBarras = tmpPersonaJSON.getString("CODIGO_BARRAS");
					obj.setCRALN_CODIGO(tmpPersonaJSON.getString("AEROLINEA"));
					if (inCrmov_tipo_operacion == 0)
					{
						obj.setCARPT_CODIGO(tmpPersonaJSON.getString("AEROPUERTO_ORIGEN"));
						obj.setCRMOV_FILTRO_INTERNO(new Boolean(tmpPersonaJSON.getString("FILTRO_NACIONAL")));
					}			
				//	obj.setCRPER_CODIGO(inCrper_codigo);
				//	obj.setCTREG_CODIGO(inCtreg_codigo);
				//	obj.setCRRSD_CODIGO(inCrrsd_codigo);
					obj.setCRMOV_NUMERO_VUELO(tmpPersonaJSON.getString("VUELO"));
				//	obj.setCRMOV_OBSERVACION(inCrmov_observacion);
				//	obj.setCRMOV_TIPO_SALIDA(inCrmov_tipo_salida);
					
					res = new com.besixplus.sii.db.Cgg_res_movilidad(obj).insert1(con,tmpCodigoBarras);
					if(res.equalsIgnoreCase("true")){
						tmpContador++;
					}
					else
					{
						break;
					}
					/*if(res.equals("true")){
						com.besixplus.sii.objects.Cgg_res_residencia objpersonaActualizar = new com.besixplus.sii.objects.Cgg_res_residencia();
						objpersonaActualizar.setCRPER_CODIGO(obj.getCRMOV_CODIGO());
						objpersonaActualizar.setCRRSD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_res_residencia(objpersonaActualizar).updateEstadoResidencia(con, obj.getCRMOV_CODIGO());
					}*/
					}
				}
				
			}
			if(res.equalsIgnoreCase("true"))
			{
				con.commit();
				responser.setSuccess(true);
				responser.setMsg(String.valueOf(tmpContador));
			}
			else
			{	
				con.rollback();
				responser.setMsg(res);
			}
			con.setAutoCommit(true);
			con.close();
			//if(!res.equals("true"))
			//	throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			//throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			responser.setMsg(inException.getMessage());
		} catch (JSONException e) {
			e.printStackTrace();
			responser.setMsg(e.getMessage());
			//throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		 return new JSONObject(responser).toString();
	}
}