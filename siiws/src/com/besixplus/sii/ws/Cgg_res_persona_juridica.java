package com.besixplus.sii.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.WebParam;
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
import com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica;

/**
 * CLASE Cgg_res_persona_juridica
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_persona_juridica POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_persona_juridica implements Serializable{

	private static final long serialVersionUID = 1877365271;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_persona_juridica.
	 * @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO.
	 * @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO SECTOR.
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON.
	 * @param inCrpjr_razon_social NOMBRE COMERCIAL DE LA PERSONA JURIDICA.
	 * @param inCrpjr_numero_identificacion NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA.
	 * @param inCrpjr_fecha_constitucion FECHA DE CONSTITUCION DE LA EMPRESA.
	 * @param inCrpjr_direccion DIRECCION DE LA PERSONA JURIDICA.
	 * @param inCrpjr_actividad DESCRIPCION DE LA ACTIVIDAD A LA QUE SE DIDICA LA EMPRESA.
	 * @param inCrpjr_numero_empleados NUMERO DE EMPLEADOS QUE CONFORMAN LA EMPRESA.
	 * @param inCrpjr_tipo INFORMACION QUE DETERMINA EL AMBITO INTERNA/EXTERNA A LA PROVINCIA.
	 * @param inCrpjr_observacion INFORMACION ADICIONAL.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
			@WebParam(name="inCvsct_codigo")String inCvsct_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCrpjr_razon_social")String inCrpjr_razon_social,
			@WebParam(name="inCrpjr_numero_identificacion")String inCrpjr_numero_identificacion,
			@WebParam(name="inCrpjr_fecha_constitucion")java.util.Date inCrpjr_fecha_constitucion,
			@WebParam(name="inCrpjr_direccion")String inCrpjr_direccion,
			@WebParam(name="inCrpjr_actividad")String inCrpjr_actividad,
			@WebParam(name="inCrpjr_numero_empleados")java.math.BigDecimal inCrpjr_numero_empleados,
			@WebParam(name="inCrpjr_tipo")int inCrpjr_tipo,
			@WebParam(name="inCrpjr_observacion")String inCrpjr_observacion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona_juridica obj = new com.besixplus.sii.objects.Cgg_res_persona_juridica();
		obj.setCRPJR_CODIGO("KEYGEN");
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCVSCT_CODIGO(inCvsct_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);
		obj.setCRPJR_RAZON_SOCIAL(inCrpjr_razon_social);
		obj.setCRPJR_NUMERO_IDENTIFICACION(inCrpjr_numero_identificacion);
		obj.setCRPJR_FECHA_CONSTITUCION(inCrpjr_fecha_constitucion);
		obj.setCRPJR_DIRECCION(inCrpjr_direccion);
		obj.setCRPJR_ACTIVIDAD(inCrpjr_actividad);
		obj.setCRPJR_NUMERO_EMPLEADOS(inCrpjr_numero_empleados);
		obj.setCRPJR_TIPO(inCrpjr_tipo);
		obj.setCRPJR_OBSERVACION(inCrpjr_observacion);
		obj.setCRPJR_ESTADO(true);
		obj.setCRPJR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRPJR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_persona_juridica(obj).insert(con);
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
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_persona_juridica.
	 * @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO.
	 * @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO SECTOR.
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON.
	 * @param inCrpjr_razon_social NOMBRE COMERCIAL DE LA PERSONA JURIDICA.
	 * @param inCrpjr_numero_identificacion NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA.
	 * @param inCrpjr_fecha_constitucion FECHA DE CONSTITUCION DE LA EMPRESA.
	 * @param inCrpjr_direccion DIRECCION DE LA PERSONA JURIDICA.
	 * @param inCrpjr_actividad DESCRIPCION DE LA ACTIVIDAD A LA QUE SE DIDICA LA EMPRESA.
	 * @param inCrpjr_numero_empleados NUMERO DE EMPLEADOS QUE CONFORMAN LA EMPRESA.
	 * @param inCrpjr_tipo INFORMACION QUE DETERMINA EL AMBITO INTERNA/EXTERNA A LA PROVINCIA.
	 * @param inCrpjr_observacion INFORMACION ADICIONAL.
	 * @param inPJuridicaRepresentante_JSON INFORMACION DEL REPRESENTANTE LEGAL
	 * @param inPJuridicaContacto_JSON CONTACTOS DE LOCALIZACION DE LA PERSONA JURIDICA
	 * @param inPJuridicaCuentas_JSON CUENTA BANCARIAS DE LA PERSONA JURIDICA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insertAll(
			@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
			@WebParam(name="inCvsct_codigo")String inCvsct_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCrpjr_razon_social")String inCrpjr_razon_social,
			@WebParam(name="inCrpjr_numero_identificacion")String inCrpjr_numero_identificacion,
			@WebParam(name="inCrpjr_fecha_constitucion")java.util.Date inCrpjr_fecha_constitucion,
			@WebParam(name="inCrpjr_direccion")String inCrpjr_direccion,
			@WebParam(name="inCrpjr_actividad")String inCrpjr_actividad,
			@WebParam(name="inCrpjr_numero_empleados")java.math.BigDecimal inCrpjr_numero_empleados,
			@WebParam(name="inCrpjr_tipo")int inCrpjr_tipo,
			@WebParam(name="inCrpjr_observacion")String inCrpjr_observacion,
			@WebParam(name="inPJuridicaRepresentante_JSON")String inPJuridicaRepresentante_JSON,
			@WebParam(name="inPJuridicaContacto_JSON")String inPJuridicaContacto_JSON,
			@WebParam(name="inPJuridicaCuentas_JSON")String inPJuridicaCuentas_JSON
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona_juridica obj = new com.besixplus.sii.objects.Cgg_res_persona_juridica();
		obj.setCRPJR_CODIGO("KEYGEN");
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCVSCT_CODIGO(inCvsct_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);
		obj.setCRPJR_RAZON_SOCIAL(inCrpjr_razon_social);
		obj.setCRPJR_NUMERO_IDENTIFICACION(inCrpjr_numero_identificacion);
		obj.setCRPJR_FECHA_CONSTITUCION(inCrpjr_fecha_constitucion);
		obj.setCRPJR_DIRECCION(inCrpjr_direccion);
		obj.setCRPJR_ACTIVIDAD(inCrpjr_actividad);
		obj.setCRPJR_NUMERO_EMPLEADOS(inCrpjr_numero_empleados);
		obj.setCRPJR_TIPO(inCrpjr_tipo);
		obj.setCRPJR_OBSERVACION(inCrpjr_observacion);
		obj.setCRPJR_ESTADO(true);
		obj.setCRPJR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRPJR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_res_persona_juridica(obj).insert(con);
			if (obj.getCRPJR_CODIGO() != "KEYGEN" && res.equalsIgnoreCase("true"))
			{
				//Insert Representante Legal
				org.json.JSONArray arrayRepresentanteJSON = new org.json.JSONArray(inPJuridicaRepresentante_JSON);
				org.json.JSONObject objRepresentanteJSON = null;
				com.besixplus.sii.objects.Cgg_res_representante_legal objRepresentante = null;
				for (int i = 0 ; i < arrayRepresentanteJSON.length(); i++){			
					objRepresentanteJSON = (org.json.JSONObject)arrayRepresentanteJSON.get(i);
					objRepresentante = new com.besixplus.sii.objects.Cgg_res_representante_legal();
					if(!objRepresentanteJSON.getString("CRPER_CODIGO").trim().isEmpty())
					{
						objRepresentante.setCRRPT_CODIGO("KEYGEN");
						objRepresentante.setCRPER_CODIGO(objRepresentanteJSON.getString("CRPER_CODIGO"));
						objRepresentante.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());
						objRepresentante.setCRRPT_FECHA_REGISTRO(new Timestamp(new Date().getTime()));
						objRepresentante.setCRRPT_ACTIVO(objRepresentanteJSON.getBoolean("CRRPT_ACTIVO"));
						objRepresentante.setCRRPT_ESTADO(true);
						objRepresentante.setCRRPT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objRepresentante.setCRRPT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_res_representante_legal(objRepresentante).insert(con);
					}
				}
				//Insert Persona Juridica Contactos
				if (res.equalsIgnoreCase("true")){
					org.json.JSONArray arrayContactoJSON = new org.json.JSONArray(inPJuridicaContacto_JSON);
					org.json.JSONObject objContactoJSON = null;
					com.besixplus.sii.objects.Cgg_res_pjuridica_contacto objPJuridicaContacto = null;
					for (int i = 0 ; i < arrayContactoJSON.length(); i++){		
						objContactoJSON = (org.json.JSONObject)arrayContactoJSON.get(i);
						objPJuridicaContacto = new com.besixplus.sii.objects.Cgg_res_pjuridica_contacto();
						objPJuridicaContacto.setCRPJC_CODIGO("KEYGEN");
						objPJuridicaContacto.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());
						objPJuridicaContacto.setCRTCO_CODIGO(objContactoJSON.getString("CRTCO_CODIGO"));
						objPJuridicaContacto.setCRPJC_DESCRIPCION(objContactoJSON.getString("CRPJC_DESCRIPCION"));
						objPJuridicaContacto.setCRPJC_CONTACTO(objContactoJSON.getString("CRPJC_CONTACTO"));
						objPJuridicaContacto.setCRPJC_PRINCIPAL(objContactoJSON.getBoolean("CRPJC_PRINCIPAL"));
						objPJuridicaContacto.setCRPJC_ESTADO(true);
						objPJuridicaContacto.setCRPJC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objPJuridicaContacto.setCRPJC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_res_pjuridica_contacto(objPJuridicaContacto).insert(con);
						if(!res.equals("true"))
							break;
					}

				}
				if(res.equals("true")){
					JSONArray tmpCuentas = new JSONArray(inPJuridicaCuentas_JSON);
					for(int i = 0; i < tmpCuentas.length(); i++){
						JSONObject tmpCuenta = tmpCuentas.getJSONObject(i);
						Cgg_res_cuenta_personajuridica tmpPJCuenta = new Cgg_res_cuenta_personajuridica();
						tmpPJCuenta.setCRCPJ_CODIGO("KEYGEN");
						tmpPJCuenta.setCRPER_CODIGO(tmpCuenta.getString("CRPER_CODIGO"));
						tmpPJCuenta.setCGG_CRPJR_CODIGO(tmpCuenta.getString("CGG_CRPJR_CODIGO"));
						tmpPJCuenta.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());
						tmpPJCuenta.setCRCPJ_DESCRIPCION(tmpCuenta.getString("CRCPJ_DESCRIPCION"));
						tmpPJCuenta.setCRCPJ_ESTADO(true);
						tmpPJCuenta.setCRCPJ_NUMERO_CUENTA(tmpCuenta.getString("CRCPJ_NUMERO_CUENTA"));
						tmpPJCuenta.setCRCPJ_TIPO_CUENTA(tmpCuenta.getInt("CRCPJ_TIPO_CUENTA"));
						tmpPJCuenta.setCRCPJ_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						tmpPJCuenta.setCRCPJ_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_res_cuenta_personajuridica(tmpPJCuenta).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
			}
			if (res.equalsIgnoreCase("true"))
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
		return new Boolean(res).toString();
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona_juridica.selectAll(con, tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			return outCadena.toString();
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_persona_juridica.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona_juridica.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_persona_juridica.
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	 * @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO
	 * @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO SECTOR
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON.
	 * @param inCrpjr_razon_social NOMBRE COMERCIAL DE LA PERSONA JURIDICA
	 * @param inCrpjr_numero_identificacion NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA
	 * @param inCrpjr_fecha_constitucion FECHA DE CONSTITUCION DE LA EMPRESA
	 * @param inCrpjr_direccion DIRECCION DE LA PERSONA JURIDICA
	 * @param inCrpjr_actividad DESCRIPCION DE LA ACTIVIDAD A LA QUE SE DIDICA LA EMPRESA
	 * @param inCrpjr_numero_empleados NUMERO DE EMPLEADOS QUE CONFORMAN LA EMPRESA
	 * @param inCrpjr_tipo INFORMACION QUE DETERMINA EL AMBITO INTERNA/EXTERNA A LA PROVINCIA
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
			@WebParam(name="inCvsct_codigo")String inCvsct_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCrpjr_razon_social")String inCrpjr_razon_social,
			@WebParam(name="inCrpjr_numero_identificacion")String inCrpjr_numero_identificacion,
			@WebParam(name="inCrpjr_fecha_constitucion")java.util.Date inCrpjr_fecha_constitucion,
			@WebParam(name="inCrpjr_direccion")String inCrpjr_direccion,
			@WebParam(name="inCrpjr_actividad")String inCrpjr_actividad,
			@WebParam(name="inCrpjr_numero_empleados")java.math.BigDecimal inCrpjr_numero_empleados,
			@WebParam(name="inCrpjr_tipo")int inCrpjr_tipo
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona_juridica obj = new com.besixplus.sii.objects.Cgg_res_persona_juridica();
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCVSCT_CODIGO(inCvsct_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);
		obj.setCRPJR_RAZON_SOCIAL(inCrpjr_razon_social);
		obj.setCRPJR_NUMERO_IDENTIFICACION(inCrpjr_numero_identificacion);
		obj.setCRPJR_FECHA_CONSTITUCION(inCrpjr_fecha_constitucion);
		obj.setCRPJR_DIRECCION(inCrpjr_direccion);
		obj.setCRPJR_ACTIVIDAD(inCrpjr_actividad);
		obj.setCRPJR_NUMERO_EMPLEADOS(inCrpjr_numero_empleados);
		obj.setCRPJR_TIPO(inCrpjr_tipo);
		obj.setCRPJR_ESTADO(true);
		obj.setCRPJR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_persona_juridica(obj).update(con);
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
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_persona_juridica.
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	 * @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO.
	 * @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO SECTOR.
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON.
	 * @param inCrpjr_razon_social NOMBRE COMERCIAL DE LA PERSONA JURIDICA.
	 * @param inCrpjr_numero_identificacion NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA.
	 * @param inCrpjr_fecha_constitucion FECHA DE CONSTITUCION DE LA EMPRESA.
	 * @param inCrpjr_direccion DIRECCION DE LA PERSONA JURIDICA.
	 * @param inCrpjr_actividad DESCRIPCION DE LA ACTIVIDAD A LA QUE SE DIDICA LA EMPRESA.
	 * @param inCrpjr_numero_empleados NUMERO DE EMPLEADOS QUE CONFORMAN LA EMPRESA.
	 * @param inCrpjr_tipo INFORMACION QUE DETERMINA EL AMBITO INTERNA/EXTERNA A LA PROVINCIA.
	 * @param inCrpjr_observacion INFORMACION ADICIONAL
	 * @param inPJuridicaRepresentante_JSON DATOS DEL REPRESENTANTE LEGAL
	 * @param inPJuridicaContacto_JSON CONTACTOS DE LOCALIZACION
	 * @param inPJuridicaCuentas_JSON CUENTAS BANCARIAS
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String updateAll(
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
			@WebParam(name="inCvsct_codigo")String inCvsct_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCrpjr_razon_social")String inCrpjr_razon_social,
			@WebParam(name="inCrpjr_numero_identificacion")String inCrpjr_numero_identificacion,
			@WebParam(name="inCrpjr_fecha_constitucion")java.util.Date inCrpjr_fecha_constitucion,
			@WebParam(name="inCrpjr_direccion")String inCrpjr_direccion,
			@WebParam(name="inCrpjr_actividad")String inCrpjr_actividad,
			@WebParam(name="inCrpjr_numero_empleados")java.math.BigDecimal inCrpjr_numero_empleados,
			@WebParam(name="inCrpjr_tipo")int inCrpjr_tipo,
			@WebParam(name="inCrpjr_observacion")String inCrpjr_observacion,
			@WebParam(name="inPJuridicaRepresentante_JSON")String inPJuridicaRepresentante_JSON,
			@WebParam(name="inPJuridicaContacto_JSON")String inPJuridicaContacto_JSON,
			@WebParam(name="inPJuridicaCuentas_JSON")String inPJuridicaCuentas_JSON
	) throws SOAPException{
		String res = "true";
		String strRepresentanteLegal = "";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona_juridica obj = new com.besixplus.sii.objects.Cgg_res_persona_juridica();
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCVSCT_CODIGO(inCvsct_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);
		obj.setCRPJR_RAZON_SOCIAL(inCrpjr_razon_social);
		obj.setCRPJR_NUMERO_IDENTIFICACION(inCrpjr_numero_identificacion);
		obj.setCRPJR_FECHA_CONSTITUCION(inCrpjr_fecha_constitucion);
		obj.setCRPJR_DIRECCION(inCrpjr_direccion);
		obj.setCRPJR_ACTIVIDAD(inCrpjr_actividad);
		obj.setCRPJR_NUMERO_EMPLEADOS(inCrpjr_numero_empleados);
		obj.setCRPJR_TIPO(inCrpjr_tipo);
		obj.setCRPJR_ESTADO(true);
		obj.setCRPJR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_res_persona_juridica(obj).update(con);
			if (res.equalsIgnoreCase("true"))
			{
				//Insert Representante Legal
				org.json.JSONArray arrayRepresentanteJSON = new org.json.JSONArray(inPJuridicaRepresentante_JSON);
				org.json.JSONObject objRepresentanteJSON = null;
				com.besixplus.sii.objects.Cgg_res_representante_legal objRepresentante = null;
				for (int i = 0 ; i < arrayRepresentanteJSON.length(); i++){			
					objRepresentanteJSON = (org.json.JSONObject)arrayRepresentanteJSON.get(i);
					strRepresentanteLegal = objRepresentanteJSON.getString("CRPER_CODIGO");
					if(!objRepresentanteJSON.getString("CRPER_CODIGO").equals(objRepresentanteJSON.getString("CRPER_CODIGO_ANTERIOR"))){
						objRepresentante = new com.besixplus.sii.objects.Cgg_res_representante_legal();
						objRepresentante.setCRRPT_CODIGO(objRepresentanteJSON.getString("CRRPT_CODIGO"));
						objRepresentante.setCRPER_CODIGO(objRepresentanteJSON.getString("CRPER_CODIGO_ANTERIOR"));
						objRepresentante.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());
						objRepresentante.setCRRPT_ACTIVO(!objRepresentanteJSON.getBoolean("CRRPT_ACTIVO"));
						objRepresentante.setCRRPT_FECHA_REGISTRO(Timestamp.valueOf(objRepresentanteJSON.getString("CRRPT_FECHA_REGISTRO")));
						objRepresentante.setCRRPT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_res_representante_legal(objRepresentante).update(con);
						if (res.equalsIgnoreCase("true")){
							objRepresentante = new com.besixplus.sii.objects.Cgg_res_representante_legal();	
							objRepresentante.setCRRPT_CODIGO("KEYGEN");
							objRepresentante.setCRPER_CODIGO(objRepresentanteJSON.getString("CRPER_CODIGO"));
							objRepresentante.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());
							objRepresentante.setCRRPT_FECHA_REGISTRO(new Timestamp(new Date().getTime()));
							objRepresentante.setCRRPT_ACTIVO(objRepresentanteJSON.getBoolean("CRRPT_ACTIVO"));
							objRepresentante.setCRRPT_ESTADO(true);
							objRepresentante.setCRRPT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							objRepresentante.setCRRPT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_res_representante_legal(objRepresentante).insert(con);
						}
					}
				}
				//Insert Persona Juridica Contactos
				if (res.equalsIgnoreCase("true")){
					org.json.JSONArray arrayContactoJSON = new org.json.JSONArray(inPJuridicaContacto_JSON);
					org.json.JSONObject objContactoJSON = null;
					com.besixplus.sii.objects.Cgg_res_pjuridica_contacto objPJuridicaContacto = null;
					for (int i = 0 ; i < arrayContactoJSON.length(); i++){		
						objContactoJSON = (org.json.JSONObject)arrayContactoJSON.get(i);
						objPJuridicaContacto = new com.besixplus.sii.objects.Cgg_res_pjuridica_contacto();
						objPJuridicaContacto.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());
						objPJuridicaContacto.setCRTCO_CODIGO(objContactoJSON.getString("CRTCO_CODIGO"));
						objPJuridicaContacto.setCRPJC_DESCRIPCION(objContactoJSON.getString("CRPJC_DESCRIPCION"));
						objPJuridicaContacto.setCRPJC_CONTACTO(objContactoJSON.getString("CRPJC_CONTACTO"));
						objPJuridicaContacto.setCRPJC_PRINCIPAL(objContactoJSON.getBoolean("CRPJC_PRINCIPAL"));
						objPJuridicaContacto.setCRPJC_ESTADO(true);
						if(objContactoJSON.getString("CRPJC_CODIGO").equals("KEYGEN")){
							objPJuridicaContacto.setCRPJC_CODIGO("KEYGEN");
							objPJuridicaContacto.setCRPJC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							objPJuridicaContacto.setCRPJC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_res_pjuridica_contacto(objPJuridicaContacto).insert(con);
						}
						else{
							objPJuridicaContacto.setCRPJC_CODIGO(objContactoJSON.getString("CRPJC_CODIGO"));
							objPJuridicaContacto.setCRPJC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_res_pjuridica_contacto(objPJuridicaContacto).update(con);

						}
						if(!res.equals("true"))
							break;
					}
				}
				if(res.equals("true")){
					ArrayList<com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica> objCuentas=null;
					JSONArray tmpArrayCuentas = new JSONArray(inPJuridicaCuentas_JSON);					
					Cgg_res_cuenta_personajuridica tmpCuenta = new Cgg_res_cuenta_personajuridica();
					com.besixplus.sii.db.Cgg_res_cuenta_personajuridica tmpCuentaDelete = new com.besixplus.sii.db.Cgg_res_cuenta_personajuridica();
					com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica tmpPJCuentas = new com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica();
					JSONObject tmpJSONCuenta = null;
					
					
					tmpCuenta.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());						
					objCuentas = new com.besixplus.sii.db.Cgg_res_cuenta_personajuridica(tmpCuenta).selectCGG_RES_PERSONA_JURIDICA(con);
					
					for(int k=0;k<objCuentas.size();k++){
						tmpPJCuentas = (com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica) objCuentas.get(k);
						String CuentaObjID = tmpPJCuentas.getCRCPJ_CODIGO(); 
						Boolean sw=false;
						for(int j=0;j<tmpArrayCuentas.length();j++){
							tmpJSONCuenta = tmpArrayCuentas.getJSONObject(j);
							String CuentaJSONID = tmpJSONCuenta.getString("CRCPJ_CODIGO");
							if(CuentaObjID.equals(CuentaJSONID)) sw=true;
						}
						if (!sw){
							if(res.equals("true"))
								res = tmpCuentaDelete.delete(con,CuentaObjID);							
						}
					}
					
					if(res.equals("true")){
						JSONArray tmpCuentas = new JSONArray(inPJuridicaCuentas_JSON);
						for(int i = 0; i < tmpCuentas.length(); i++){
							tmpJSONCuenta = tmpCuentas.getJSONObject(i);
							Cgg_res_cuenta_personajuridica tmpPJCuenta = new Cgg_res_cuenta_personajuridica();
							tmpPJCuenta.setCRCPJ_CODIGO(tmpJSONCuenta.getString("CRCPJ_CODIGO"));
							tmpPJCuenta.setCRPER_CODIGO(strRepresentanteLegal);
							tmpPJCuenta.setCGG_CRPJR_CODIGO(tmpJSONCuenta.getString("CGG_CRPJR_CODIGO"));
							tmpPJCuenta.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());
							tmpPJCuenta.setCRCPJ_DESCRIPCION(tmpJSONCuenta.getString("CRCPJ_DESCRIPCION"));
							tmpPJCuenta.setCRCPJ_ESTADO(true);
							tmpPJCuenta.setCRCPJ_NUMERO_CUENTA(tmpJSONCuenta.getString("CRCPJ_NUMERO_CUENTA"));
							tmpPJCuenta.setCRCPJ_TIPO_CUENTA(tmpJSONCuenta.getInt("CRCPJ_TIPO_CUENTA"));
							tmpPJCuenta.setCRCPJ_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							tmpPJCuenta.setCRCPJ_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_res_cuenta_personajuridica(tmpPJCuenta).update(con);
							if(!res.equals("true"))
								break;
						}
					}
					if(res.equals("true")){
						for(int j=0;j<tmpArrayCuentas.length();j++){
							tmpJSONCuenta = tmpArrayCuentas.getJSONObject(j);
							String CuentaJSONID = tmpJSONCuenta.getString("CRCPJ_CODIGO");
							
							Boolean sw=false;
							for(int k=0;k<objCuentas.size();k++){
								tmpPJCuentas = (com.besixplus.sii.objects.Cgg_res_cuenta_personajuridica) objCuentas.get(k);
								String CuentaObjID = tmpPJCuentas.getCRCPJ_CODIGO(); 
								
								if(CuentaObjID.equals(CuentaJSONID)) sw=true;
							}
							if (!sw){
								if(res.equals("true")){
									Cgg_res_cuenta_personajuridica tmpPJCuenta = new Cgg_res_cuenta_personajuridica();
									tmpPJCuenta.setCRCPJ_CODIGO("KEYGEN");
									tmpPJCuenta.setCRPER_CODIGO(strRepresentanteLegal);
									tmpPJCuenta.setCGG_CRPJR_CODIGO(tmpJSONCuenta.getString("CGG_CRPJR_CODIGO"));
									tmpPJCuenta.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());
									tmpPJCuenta.setCRCPJ_DESCRIPCION(tmpJSONCuenta.getString("CRCPJ_DESCRIPCION"));
									tmpPJCuenta.setCRCPJ_ESTADO(true);
									tmpPJCuenta.setCRCPJ_NUMERO_CUENTA(tmpJSONCuenta.getString("CRCPJ_NUMERO_CUENTA"));
									tmpPJCuenta.setCRCPJ_TIPO_CUENTA(tmpJSONCuenta.getInt("CRCPJ_TIPO_CUENTA"));
									tmpPJCuenta.setCRCPJ_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
									tmpPJCuenta.setCRCPJ_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
									res = new com.besixplus.sii.db.Cgg_res_cuenta_personajuridica(tmpPJCuenta).insert(con);
									if(!res.equals("true"))
										break;
								}
							}
						}
					}
				}
			}
			if (res.equalsIgnoreCase("true")==true){
				con.commit();
				con.setAutoCommit(true);
				con.close();
			}else
				con.rollback();
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new Boolean(res).toString();
	}

	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_persona_juridica EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrpjr_codigo crpjr_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona_juridica tmpObj = new com.besixplus.sii.objects.Cgg_res_persona_juridica();
		tmpObj.setCRPJR_CODIGO(inCrpjr_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_persona_juridica(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona_juridica>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_persona_juridica.
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona_juridica tmpObj = new com.besixplus.sii.objects.Cgg_res_persona_juridica();
		tmpObj.setCRPJR_CODIGO(inCrpjr_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_persona_juridica(tmpObj).delete(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)
	 * @format FORMATO DE SALIDA JSON o XML.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectPageByRol(
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
			tmpCount = com.besixplus.sii.db.Cgg_res_persona_juridica.selectCountByRol(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona_juridica.selectPageByRol(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona_juridica EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inCrpjr_numero_identificacion NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectCodigoByNumIdentific(
			@WebParam(name="inCrpjr_numero_identificacion")String inCrpjr_numero_identificacion,		
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
			obj = com.besixplus.sii.db.Cgg_res_persona_juridica.selectCodigoByNumIdentific(con,inCrpjr_numero_identificacion );			
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			return outCadena.toString();
		else
			return null;
	}
	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_persona_juridica.
	 * @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO.
	 * @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO SECTOR.
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON.
	 * @param inCrpjr_razon_social NOMBRE COMERCIAL DE LA PERSONA JURIDICA.
	 * @param inCrpjr_numero_identificacion NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA.
	 * @param inCrpjr_fecha_constitucion FECHA DE CONSTITUCION DE LA EMPRESA.
	 * @param inCrpjr_direccion DIRECCION DE LA PERSONA JURIDICA.
	 * @param inCrpjr_actividad DESCRIPCION DE LA ACTIVIDAD A LA QUE SE DIDICA LA EMPRESA.
	 * @param inCrpjr_numero_empleados NUMERO DE EMPLEADOS QUE CONFORMAN LA EMPRESA.
	 * @param inCrpjr_tipo INFORMACION QUE DETERMINA EL AMBITO INTERNA/EXTERNA A LA PROVINCIA.
	 * @param inCrpjr_observacion INFORMACION ADICIONAL.
	 * @param inPJuridicaRepresentante_JSON INFORMACION DEL REPRESENTANTE LEGAL
	 * @param inPJuridicaContacto_JSON CONTACTOS DE LOCALIZACION DE LA PERSONA JURIDICA
	 * @param inPJuridicaCuentas_JSON CUENTA BANCARIAS DE LA PERSONA JURIDICA
	 * @param inCgpre_codigo IDENTIFICATIVO UNICO DEL PRE-REGISTRO DE EMPRESAS
	 * @param inCgpre_cisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA ISLA DEL PRE-REGISTRO
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insertAllGestionEmpleo(
			@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
			@WebParam(name="inCvsct_codigo")String inCvsct_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCrpjr_razon_social")String inCrpjr_razon_social,			
			@WebParam(name="inCrpjr_numero_identificacion")String inCrpjr_numero_identificacion,
			@WebParam(name="inCrpjr_fecha_constitucion")java.util.Date inCrpjr_fecha_constitucion,
			@WebParam(name="inCrpjr_direccion")String inCrpjr_direccion,
			@WebParam(name="inCrpjr_actividad")String inCrpjr_actividad,
			@WebParam(name="inCrpjr_numero_empleados")java.math.BigDecimal inCrpjr_numero_empleados,
			@WebParam(name="inCrpjr_tipo")int inCrpjr_tipo,
			@WebParam(name="inCrpjr_observacion")String inCrpjr_observacion,
			@WebParam(name="inPJuridicaRepresentante_JSON")String inPJuridicaRepresentante_JSON,
			@WebParam(name="inPJuridicaContacto_JSON")String inPJuridicaContacto_JSON,
			@WebParam(name="inPJuridicaCuentas_JSON")String inPJuridicaCuentas_JSON,
			@WebParam(name="inCgpre_codigo")String inCgpre_codigo,
			@WebParam(name="inCgpre_cisla_codigo")String inCgpre_cisla_codigo

	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona_juridica obj = new com.besixplus.sii.objects.Cgg_res_persona_juridica();
		obj.setCRPJR_CODIGO("KEYGEN");
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCVSCT_CODIGO(inCvsct_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);
		obj.setCRPJR_RAZON_SOCIAL(inCrpjr_razon_social);
		obj.setCRPJR_NUMERO_IDENTIFICACION(inCrpjr_numero_identificacion);
		obj.setCRPJR_FECHA_CONSTITUCION(inCrpjr_fecha_constitucion);
		obj.setCRPJR_DIRECCION(inCrpjr_direccion);
		obj.setCRPJR_ACTIVIDAD(inCrpjr_actividad);
		obj.setCRPJR_NUMERO_EMPLEADOS(inCrpjr_numero_empleados);
		obj.setCRPJR_TIPO(inCrpjr_tipo);
		obj.setCRPJR_OBSERVACION(inCrpjr_observacion);
		obj.setCRPJR_ESTADO(true);
		obj.setCRPJR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRPJR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_res_persona_juridica(obj).insert(con);
			if (obj.getCRPJR_CODIGO() != "KEYGEN" && res.equalsIgnoreCase("true"))
			{
				//Insert Representante Legal
				org.json.JSONArray arrayRepresentanteJSON = new org.json.JSONArray(inPJuridicaRepresentante_JSON);
				org.json.JSONObject objRepresentanteJSON = null;
				com.besixplus.sii.objects.Cgg_res_representante_legal objRepresentante = null;
				for (int i = 0 ; i < arrayRepresentanteJSON.length(); i++){			
					objRepresentanteJSON = (org.json.JSONObject)arrayRepresentanteJSON.get(i);
					objRepresentante = new com.besixplus.sii.objects.Cgg_res_representante_legal();
					if(!objRepresentanteJSON.getString("CRPER_CODIGO").trim().isEmpty())
					{
						objRepresentante.setCRRPT_CODIGO("KEYGEN");
						objRepresentante.setCRPER_CODIGO(objRepresentanteJSON.getString("CRPER_CODIGO"));
						objRepresentante.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());
						objRepresentante.setCRRPT_FECHA_REGISTRO(new Timestamp(new Date().getTime()));
						objRepresentante.setCRRPT_ACTIVO(objRepresentanteJSON.getBoolean("CRRPT_ACTIVO"));
						objRepresentante.setCRRPT_ESTADO(true);
						objRepresentante.setCRRPT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objRepresentante.setCRRPT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_res_representante_legal(objRepresentante).insert(con);
					}
				}
				//Insert Persona Juridica Contactos
				if (res.equalsIgnoreCase("true")){
					org.json.JSONArray arrayContactoJSON = new org.json.JSONArray(inPJuridicaContacto_JSON);
					org.json.JSONObject objContactoJSON = null;
					com.besixplus.sii.objects.Cgg_res_pjuridica_contacto objPJuridicaContacto = null;
					for (int i = 0 ; i < arrayContactoJSON.length(); i++){		
						objContactoJSON = (org.json.JSONObject)arrayContactoJSON.get(i);
						if (objContactoJSON.getString("CRTCO_CODIGO").equals("CRTCO1")){
							com.besixplus.sii.objects.Cgg_buzon_correo objBuzonCorreo = new com.besixplus.sii.objects.Cgg_buzon_correo();
							objBuzonCorreo.setCBZC_CODIGO("KEYGEN");
							objBuzonCorreo.setCBZC_ASUNTO("Registro de empresa satisfactorio");
							objBuzonCorreo.setCBZC_DESTINATARIO(objContactoJSON.getString("CRPJC_CONTACTO"));
							objBuzonCorreo.setCBZC_ENVIADO(false);
							objBuzonCorreo.setCBZC_ESTADO(true);
							String msgEmpresa = "Su empresa fu&eacute; registrada correctamente en el sistema de Gesti&oacute;n de empleo<br/>." +
							"Desde este momento usted puede registrar ofertas de empleo para la comunidad.<br>"+
							"Los datos necesario para acceder al portal son:<br/>"+
							"<br/>Nombre de usuario: "+inCrpjr_numero_identificacion+
							"<br/>Clave de acceso:"+inCrpjr_numero_identificacion+
							"<br/><br/><i>Cualquier duda o comentario por favor no dude en consultarnos</i>";
							objBuzonCorreo.setCBZC_MENSAJE(msgEmpresa);
							objBuzonCorreo.setCBZC_NUMERO_INTENTOS(new BigDecimal(0));
							objBuzonCorreo.setCBZC_TIPO_CONTENIDO("text/html");
							objBuzonCorreo.setCBZC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							objBuzonCorreo.setCBZC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_buzon_correo(objBuzonCorreo).insert(con);
						}
						objPJuridicaContacto = new com.besixplus.sii.objects.Cgg_res_pjuridica_contacto();
						objPJuridicaContacto.setCRPJC_CODIGO("KEYGEN");
						objPJuridicaContacto.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());
						objPJuridicaContacto.setCRTCO_CODIGO(objContactoJSON.getString("CRTCO_CODIGO"));
						objPJuridicaContacto.setCRPJC_DESCRIPCION(objContactoJSON.getString("CRPJC_DESCRIPCION"));
						objPJuridicaContacto.setCRPJC_CONTACTO(objContactoJSON.getString("CRPJC_CONTACTO"));
						objPJuridicaContacto.setCRPJC_PRINCIPAL(objContactoJSON.getBoolean("CRPJC_PRINCIPAL"));
						objPJuridicaContacto.setCRPJC_ESTADO(true);
						objPJuridicaContacto.setCRPJC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objPJuridicaContacto.setCRPJC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_res_pjuridica_contacto(objPJuridicaContacto).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
				if(res.equals("true")){
					JSONArray tmpCuentas = new JSONArray(inPJuridicaCuentas_JSON);
					for(int i = 0; i < tmpCuentas.length(); i++){
						JSONObject tmpCuenta = tmpCuentas.getJSONObject(i);
						Cgg_res_cuenta_personajuridica tmpPJCuenta = new Cgg_res_cuenta_personajuridica();
						tmpPJCuenta.setCRCPJ_CODIGO("KEYGEN");
						tmpPJCuenta.setCRPER_CODIGO(tmpCuenta.getString("CRPER_CODIGO"));
						tmpPJCuenta.setCGG_CRPJR_CODIGO(tmpCuenta.getString("CGG_CRPJR_CODIGO"));
						tmpPJCuenta.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());
						tmpPJCuenta.setCRCPJ_DESCRIPCION(tmpCuenta.getString("CRCPJ_DESCRIPCION"));
						tmpPJCuenta.setCRCPJ_ESTADO(true);
						tmpPJCuenta.setCRCPJ_NUMERO_CUENTA(tmpCuenta.getString("CRCPJ_NUMERO_CUENTA"));
						tmpPJCuenta.setCRCPJ_TIPO_CUENTA(tmpCuenta.getInt("CRCPJ_TIPO_CUENTA"));
						tmpPJCuenta.setCRCPJ_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						tmpPJCuenta.setCRCPJ_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_res_cuenta_personajuridica(tmpPJCuenta).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
				if(res.equals("true")){
					Boolean resp1=false;
					com.besixplus.sii.objects.Cgg_gem_preregistro_empresa tmpObj = new com.besixplus.sii.objects.Cgg_gem_preregistro_empresa();
					tmpObj.setCGPRE_CODIGO(inCgpre_codigo);
					resp1 = new com.besixplus.sii.db.Cgg_gem_preregistro_empresa(tmpObj).delete(con);
					res = resp1.toString();					
				}
				if(res.equals("true")){	

					org.json.JSONArray arrayRepresentanteJSON1 = new org.json.JSONArray(inPJuridicaRepresentante_JSON);
					org.json.JSONObject objRepresentanteJSON1 = null;

					String codigoRepresentante = null;
					for (int i = 0 ; i < arrayRepresentanteJSON1.length(); i++){			
						objRepresentanteJSON1 = (org.json.JSONObject)arrayRepresentanteJSON1.get(i);
						if(!objRepresentanteJSON1.getString("CRPER_CODIGO").trim().isEmpty())
						{							
							codigoRepresentante = objRepresentanteJSON1.getString("CRPER_CODIGO");							
						}
					}				
					com.besixplus.sii.objects.Cgg_usuario tmpDatosUsuario = new com.besixplus.sii.objects.Cgg_usuario();
					tmpDatosUsuario.setCUSU_CODIGO("KEYGEN");
					tmpDatosUsuario.setCRPER_CODIGO(codigoRepresentante);						
					tmpDatosUsuario.setCRPJR_CODIGO(obj.getCRPJR_CODIGO());
					tmpDatosUsuario.setCCTN_CODIGO(inCctn_codigo);
					tmpDatosUsuario.setCISLA_CODIGO(inCgpre_cisla_codigo);
					tmpDatosUsuario.setCUSU_NOMBRE_USUARIO(inCrpjr_numero_identificacion);
					tmpDatosUsuario.setCUSU_CLAVE_ACCESO(inCrpjr_numero_identificacion);
					tmpDatosUsuario.setCUSU_USUARIO_INTERNO(false);
					tmpDatosUsuario.setCUSU_CADUCA_CLAVE(true);
					tmpDatosUsuario.setCUSU_FECHA_CLAVE_ACT(new Date());
					tmpDatosUsuario.setCUSU_ACTIVO(true);
					tmpDatosUsuario.setCUSU_CAMBIAR_CLAVE(true);
					tmpDatosUsuario.setCUSU_ESTADO(true);
					tmpDatosUsuario.setCUSU_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					tmpDatosUsuario.setCUSU_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					String tmpMessage = null;
					//checkKeyConstraint(inObject, inConnection, inMessage)
					if((tmpMessage =new com.besixplus.sii.ws.Cgg_usuario().checkKeyConstraint(tmpDatosUsuario, con, tmpMessage)) != null)
						throw new SOAPFaultException(SOAPFactory.newInstance().createFault(tmpMessage, new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));

					res = new com.besixplus.sii.db.Cgg_usuario(tmpDatosUsuario).insert(con);

					if(res.equals("true")){						
						//com.besixplus.sii.objects.Cgg_usuario tmpGetUsuario = new com.besixplus.sii.objects.Cgg_usuario();
						com.besixplus.sii.objects.Cgg_sec_usuario_rol objUsuRol = new com.besixplus.sii.objects.Cgg_sec_usuario_rol();

						objUsuRol.setCSPER_CODIGO("KEYGEN");
						objUsuRol.setCSROL_CODIGO("CSROL_GEEMP");
						objUsuRol.setCUSU_CODIGO(tmpDatosUsuario.getCUSU_CODIGO());
						objUsuRol.setCSPER_ESTADO(true);
						objUsuRol.setCSPER_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objUsuRol.setCSPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_sec_usuario_rol(objUsuRol).insert(con);
						
						if(res.equals("true")){
							objUsuRol.setCSPER_CODIGO("KEYGEN");
							objUsuRol.setCSROL_CODIGO("2");
							objUsuRol.setCUSU_CODIGO(tmpDatosUsuario.getCUSU_CODIGO());
							objUsuRol.setCSPER_ESTADO(true);
							objUsuRol.setCSPER_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							objUsuRol.setCSPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_sec_usuario_rol(objUsuRol).insert(con);
						}
						
						if(res.equals("true")){
							objUsuRol.setCSPER_CODIGO("KEYGEN");
							objUsuRol.setCSROL_CODIGO("CSROL42");
							objUsuRol.setCUSU_CODIGO(tmpDatosUsuario.getCUSU_CODIGO());
							objUsuRol.setCSPER_ESTADO(true);
							objUsuRol.setCSPER_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							objUsuRol.setCSPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_sec_usuario_rol(objUsuRol).insert(con);
						}
					}

				}				
			}
			if (res.equalsIgnoreCase("true"))
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
		return new Boolean(res).toString();
	}

}