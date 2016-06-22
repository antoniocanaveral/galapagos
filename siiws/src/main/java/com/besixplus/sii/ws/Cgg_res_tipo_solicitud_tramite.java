package com.besixplus.sii.ws;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.misc.CGGEnumerators;
import com.besixplus.sii.objects.Cgg_res_garantia_solicitud;
import com.besixplus.sii.objects.Cgg_res_solicitud_requisito;
import com.besixplus.sii.objects.Cgg_res_tipo_solicitud_regla;
import com.besixplus.sii.objects.Cgg_res_tst_aplica;
import com.bmlaurus.alfresco.db.SiiDataSaver;
import com.bmlaurus.alfresco.model.SiiModelFile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * CLASE Cgg_res_tipo_solicitud_tramite
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_tipo_solicitud_tramite POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_tipo_solicitud_tramite implements Serializable{

	private static final long serialVersionUID = 603509307;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_tipo_solicitud_tramite.
	 * @param inCgg_crtst_codigo IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD RECURSIVO.
	 * @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE.
	 * @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO.
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES.
	 * @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES.
	 * @param inCrtst_descripcion DESCRIPCION DEL TIPO DE RESIDENCIA.
	 * @param inCrtst_observacion NO ESPECIFICADO.
	 * @param inCrtst_aplica_garantia ESTADO DE CONTROL PARA DESPOSITO DE GARANTIA.
EN ESTE CASO SE RELACIONA CON UNA O VARIAS GARANTIAS, LAS CUALES DEBEN SER CREADAS..
	 * @param inCrtst_aplica_tramite ESTADO DE CONTROL PARA DETERMINAR SI SE CONSIDERA COMO INICIO DE DE UN TRAMITE, EN OTRAS PALABRAS ESTABLECE SI ESTE TRAMITE ES UN TRAMITE DE TRABAJO O SOLO DE AGRUPAMIENTO
SI
NO.
	 * @param inCrtst_aplica_grupo SI EL TRAMITE PUEDE TENER VARIOS BENEFICIARIOS O ES UN TRAMITE QUE APLICA PARA VARIAS PERSONAS..
	 * @param inCrtst_atencion_cliente SI EL TRAMITE ESTA DISPONIBLE PARA UN PRE REGISTRO POR MEDIO DE ATENCION AL CLIENTE.
	 * @param inCrtst_restringido SI SE APLICA UN CONTROL ESPECIFICO PARA PODER INICIAR UN TRAMITE.
	 * @param inCrtst_comunicado_radial SI EL TRAMITE NECESITA DE UN COMUNICADO RADIAL PARA SU INICIO.
	 * @param inCrtst_numero_dias NUMERO DE DIAS MAXIMO PERMITIDO PARA LA RESIDENCIA O MOVILIDAD.
	 * @param inCrtst_vehiculo ALMACENA INFORMACION DEL VEHICULO.
	 * @param inCrtst_unanimidad CONTEO APLICADO AL TRAMITE.
	 * @param inCrtst_aplica_otro CAMPO PARA VALIDACION DE OTRO VALOR QUE SE PUEDIERA MANEJAR ADICIONALMENTE PARA EL TIPO DE SOLICITUD DE TRAMITE.
	 * @param inCrtst_aplica_beneficiario SI EL TIPO DE SOLICITUD REQUIERE DE UN BENEFICIARIO
	 * @param inCrtst_indice INDICE NUMERICO UTIL PARA LA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET PARA RESIDENCIA.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCgg_crtst_codigo")String inCgg_crtst_codigo,
			@WebParam(name="inCrtpt_codigo")String inCrtpt_codigo,
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="inCrres_codigo")String inCrres_codigo,
			@WebParam(name="inCkesp_codigo")String inCkesp_codigo,
			@WebParam(name="inCrtst_descripcion")String inCrtst_descripcion,
			@WebParam(name="inCrtst_observacion")String inCrtst_observacion,
			@WebParam(name="inCrtst_aplica_garantia")boolean inCrtst_aplica_garantia,
			@WebParam(name="inCrtst_aplica_tramite")boolean inCrtst_aplica_tramite,
			@WebParam(name="inCrtst_aplica_grupo")boolean inCrtst_aplica_grupo,
			@WebParam(name="inCrtst_atencion_cliente")boolean inCrtst_atencion_cliente,
			@WebParam(name="inCrtst_restringido")boolean inCrtst_restringido,
			@WebParam(name="inCrtst_comunicado_radial")boolean inCrtst_comunicado_radial,
			@WebParam(name="inCrtst_numero_dias")int inCrtst_numero_dias,
			@WebParam(name="inCrtst_vehiculo")boolean inCrtst_vehiculo,
			@WebParam(name="inCrtst_unanimidad")boolean inCrtst_unanimidad,
			@WebParam(name="inCrtst_aplica_otro")boolean inCrtst_aplica_otro,
			@WebParam(name="inCrtst_aplica_beneficiario")boolean inCrtst_aplica_beneficiario,
			@WebParam(name="inCrtst_indice")int inCrtst_indice
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite obj = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
		obj.setCRTST_CODIGO("KEYGEN");
		obj.setCGG_CRTST_CODIGO(inCgg_crtst_codigo);
		obj.setCRTPT_CODIGO(inCrtpt_codigo);
		obj.setCRPRO_CODIGO(inCrpro_codigo);
		obj.setCRRES_CODIGO(inCrres_codigo);
		obj.setCKESP_CODIGO(inCkesp_codigo);
		obj.setCRTST_DESCRIPCION(inCrtst_descripcion);
		obj.setCRTST_OBSERVACION(inCrtst_observacion);
		obj.setCRTST_APLICA_GARANTIA(inCrtst_aplica_garantia);
		obj.setCRTST_APLICA_TRAMITE(inCrtst_aplica_tramite);
		obj.setCRTST_APLICA_GRUPO(inCrtst_aplica_grupo);
		obj.setCRTST_ATENCION_CLIENTE(inCrtst_atencion_cliente);
		obj.setCRTST_RESTRINGIDO(inCrtst_restringido);
		obj.setCRTST_COMUNICADO_RADIAL(inCrtst_comunicado_radial);
		obj.setCRTST_NUMERO_DIAS(inCrtst_numero_dias);
		obj.setCRTST_VEHICULO(inCrtst_vehiculo);
		obj.setCRTST_UNANIMIDAD(inCrtst_unanimidad);
		obj.setCRTST_APLICA_OTRO(inCrtst_aplica_otro);
		obj.setCRTST_APLICA_BENEFICIARIO(inCrtst_aplica_beneficiario);
		obj.setCRTST_INDICE(new BigDecimal(inCrtst_indice));
		obj.setCRTST_ESTADO(true);
		obj.setCRTST_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRTST_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(obj).insert(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite EN UNA ESTRUCTRA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON o XML).
	 * @param inSW SI VISUALIZA TODAS LAS SOLICITUDES O SOLO LAS QUE GENERAN TRAMITE
	 * @param inCrtst_codigo TIPO DE SOLICITUD DE TRAMITE PADRE.
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
			@WebParam(name="inSW")boolean inSW,
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo
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
			tmpCount = com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite.selectCount(con, keyword, inSW, inCrtst_codigo);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inSW, inCrtst_codigo);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_tipo_solicitud_tramite.
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	 * @param inCgg_crtst_codigo IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD RECURSIVO
	 * @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	 * @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	 * @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	 * @param inCrtst_descripcion DESCRIPCION DEL TIPO DE RESIDENCIA
	 * @param inCrtst_observacion NO ESPECIFICADO
	 * @param inCrtst_aplica_garantia ESTADO DE CONTROL PARA DESPOSITO DE GARANTIA.
EN ESTE CASO SE RELACIONA CON UNA O VARIAS GARANTIAS, LAS CUALES DEBEN SER CREADAS.
	 * @param inCrtst_aplica_tramite ESTADO DE CONTROL PARA DETERMINAR SI SE CONSIDERA COMO INICIO DE DE UN TRAMITE, EN OTRAS PALABRAS ESTABLECE SI ESTE TRAMITE ES UN TRAMITE DE TRABAJO O SOLO DE AGRUPAMIENTO
SI
NO
	 * @param inCrtst_aplica_grupo SI EL TRAMITE PUEDE TENER VARIOS BENEFICIARIOS O ES UN TRAMITE QUE APLICA PARA VARIAS PERSONAS.
	 * @param inCrtst_atencion_cliente SI EL TRAMITE ESTA DISPONIBLE PARA UN PRE REGISTRO POR MEDIO DE ATENCION AL CLIENTE
	 * @param inCrtst_restringido SI SE APLICA UN CONTROL ESPECIFICO PARA PODER INICIAR UN TRAMITE
	 * @param inCrtst_comunicado_radial SI EL TRAMITE NECESITA DE UN COMUNICADO RADIAL PARA SU INICIO
	 * @param inCrtst_numero_dias NUMERO DE DIAS MAXIMO PERMITIDO PARA LA RESIDENCIA O MOVILIDAD
	 * @param inCrtst_vehiculo ALMACENA INFORMACION DEL VEHICULO
	 * @param inCrtst_unanimidad CONTEO APLICADO AL TRAMITE
	 * @param inCrtst_aplica_otro CAMPO PARA VALIDACION DE OTRO VALOR QUE SE PUEDIERA MANEJAR ADICIONALMENTE PARA EL TIPO DE SOLICITUD DE TRAMITE
	 * @param inCrtst_aplica_beneficiario SI EL TIPO DE SOLICITUD REQUIERE DE UN BENEFICIARIO
	 * @param inCrtst_indice INDICE NUMERICO UTIL PARA LA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET PARA RESIDENCIA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="inCgg_crtst_codigo")String inCgg_crtst_codigo,
			@WebParam(name="inCrtpt_codigo")String inCrtpt_codigo,
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="inCrres_codigo")String inCrres_codigo,
			@WebParam(name="inCkesp_codigo")String inCkesp_codigo,
			@WebParam(name="inCrtst_descripcion")String inCrtst_descripcion,
			@WebParam(name="inCrtst_observacion")String inCrtst_observacion,
			@WebParam(name="inCrtst_aplica_garantia")boolean inCrtst_aplica_garantia,
			@WebParam(name="inCrtst_aplica_tramite")boolean inCrtst_aplica_tramite,
			@WebParam(name="inCrtst_aplica_grupo")boolean inCrtst_aplica_grupo,
			@WebParam(name="inCrtst_atencion_cliente")boolean inCrtst_atencion_cliente,
			@WebParam(name="inCrtst_restringido")boolean inCrtst_restringido,
			@WebParam(name="inCrtst_comunicado_radial")boolean inCrtst_comunicado_radial,
			@WebParam(name="inCrtst_numero_dias")int inCrtst_numero_dias,
			@WebParam(name="inCrtst_vehiculo")boolean inCrtst_vehiculo,
			@WebParam(name="inCrtst_unanimidad")boolean inCrtst_unanimidad,
			@WebParam(name="inCrtst_aplica_otro")boolean inCrtst_aplica_otro,
			@WebParam(name="inCrtst_aplica_beneficiario")boolean inCrtst_aplica_beneficiario,
			@WebParam(name="inCrtst_indice")int inCrtst_indice
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite obj = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
		obj.setCRTST_CODIGO(inCrtst_codigo);
		obj.setCGG_CRTST_CODIGO(inCgg_crtst_codigo);
		obj.setCRTPT_CODIGO(inCrtpt_codigo);
		obj.setCRPRO_CODIGO(inCrpro_codigo);
		obj.setCRRES_CODIGO(inCrres_codigo);
		obj.setCKESP_CODIGO(inCkesp_codigo);
		obj.setCRTST_DESCRIPCION(inCrtst_descripcion);
		obj.setCRTST_OBSERVACION(inCrtst_observacion);
		obj.setCRTST_APLICA_GARANTIA(inCrtst_aplica_garantia);
		obj.setCRTST_APLICA_TRAMITE(inCrtst_aplica_tramite);
		obj.setCRTST_APLICA_GRUPO(inCrtst_aplica_grupo);
		obj.setCRTST_ATENCION_CLIENTE(inCrtst_atencion_cliente);
		obj.setCRTST_RESTRINGIDO(inCrtst_restringido);
		obj.setCRTST_COMUNICADO_RADIAL(inCrtst_comunicado_radial);
		obj.setCRTST_NUMERO_DIAS(inCrtst_numero_dias);
		obj.setCRTST_VEHICULO(inCrtst_vehiculo);
		obj.setCRTST_UNANIMIDAD(inCrtst_unanimidad);
		obj.setCRTST_APLICA_OTRO(inCrtst_aplica_otro);
		obj.setCRTST_APLICA_BENEFICIARIO(inCrtst_aplica_beneficiario);
		obj.setCRTST_INDICE(new BigDecimal(inCrtst_indice));
		obj.setCRTST_ESTADO(true);
		obj.setCRTST_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(obj).update(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_tipo_solicitud_tramite EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrtst_codigo crtst_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite tmpObj = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
		tmpObj.setCRTST_CODIGO(inCrtst_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_tipo_solicitud_tramite.
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo
	) throws SOAPException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite tmpObj = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
		tmpObj.setCRTST_CODIGO(inCrtst_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(tmpObj).delete(con);
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
	 * Inserta un tipo de solicitud de tramite al igual que su informacion de requerimientos y garantias.
	 * @param inCgg_crtst_codigo IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD RECURSIVO.
	 * @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE.
	 * @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO.
	 * @param inCrres_codigo CODIGO DE REGISTRO DE RESOLUCION.
	 * @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES.
	 * @param inCrtst_descripcion DESCRIPCION DEL TIPO DE RESIDENCIA.
	 * @param inCrtst_observacion NO ESPECIFICADO.
	 * @param inCrtst_aplica_garantia ESTADO DE CONTROL PARA DESPOSITO DE GARANTIA.
EN ESTE CASO SE RELACIONA CON UNA O VARIAS GARANTIAS, LAS CUALES DEBEN SER CREADAS..
	 * @param inCrtst_aplica_tramite ESTADO DE CONTROL PARA DETERMINAR SI SE CONSIDERA COMO INICIO DE DE UN TRAMITE, EN OTRAS PALABRAS ESTABLECE SI ESTE TRAMITE ES UN TRAMITE DE TRABAJO O SOLO DE AGRUPAMIENTO
SI
NO.
	 * @param inCrtst_aplica_grupo SI EL TRAMITE PUEDE TENER VARIOS BENEFICIARIOS O ES UN TRAMITE QUE APLICA PARA VARIAS PERSONAS..
	 * @param inCrtst_atencion_cliente SI EL TRAMITE ESTA DISPONIBLE PARA UN PRE REGISTRO POR MEDIO DE ATENCION AL CLIENTE.
	 * @param inCrtst_restringido SI SE APLICA UN CONTROL ESPECIFICO PARA PODER INICIAR UN TRAMITE.
	 * @param inCrtst_comunicado_radial SI EL TRAMITE NECESITA DE UN COMUNICADO RADIAL PARA SU INICIO.
	 * @param inCrtst_numero_dias NUMERO DE DIAS MAXIMO PERMITIDO PARA LA RESIDENCIA O MOVILIDAD.
	 * @param inCrtst_vehiculo ALMACENA INFORMACION DEL VEHICULO.
	 * @param inCrtst_unanimidad CONTEO APLICADO AL TRAMITE.
	 * @param inCrtst_aplica_otro CAMPO PARA VALIDACION DE OTRO VALOR QUE SE PUEDIERA MANEJAR ADICIONALMENTE PARA EL TIPO DE SOLICITUD DE TRAMITE.
	 * @param inCrtst_aplica_beneficiario SI EL TIPO DE SOLICITUD REQUIERE DE UN BENEFICIARIO
	 * @param inCrtst_indice INDICE NUMERICO UTIL PARA LA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET PARA RESIDENCIA.
	 * @param inCrtst_requisito Cadena de datos en formato json de los requisitos a ser cumplidos por el tipo de solicitud de tramite.
	 * @param inCrtst_adjunto Cadena de datos en formato json de los adjuntos a ser subidos a Alfresco.
	 * @param inCrtst_garantia Cadena de datos en formato json de los garantias que deben ser cumplidas por el tramite.
	 * @param inCrtst_regla Cadena de datos en formato json de las reglas de validacion que deben ser cumplidas por el tramite.
	 * @param inCrtst_opcion Opciones que aplica el tipo de solicitud.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insertTipoSolicitudTramite(
			@WebParam(name="inCgg_crtst_codigo")String inCgg_crtst_codigo,
			@WebParam(name="inCrtpt_codigo")String inCrtpt_codigo,
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name="inCrres_codigo")String inCrres_codigo,
			@WebParam(name="inCkesp_codigo")String inCkesp_codigo,
			@WebParam(name="inCrtst_descripcion")String inCrtst_descripcion,
			@WebParam(name="inCrtst_observacion")String inCrtst_observacion,
			@WebParam(name="inCrtst_aplica_garantia")boolean inCrtst_aplica_garantia,
			@WebParam(name="inCrtst_aplica_tramite")boolean inCrtst_aplica_tramite,
			@WebParam(name="inCrtst_aplica_grupo")boolean inCrtst_aplica_grupo,
			@WebParam(name="inCrtst_atencion_cliente")boolean inCrtst_atencion_cliente,
			@WebParam(name="inCrtst_restringido")boolean inCrtst_restringido,
			@WebParam(name="inCrtst_comunicado_radial")boolean inCrtst_comunicado_radial,
			@WebParam(name="inCrtst_numero_dias")int inCrtst_numero_dias,
			@WebParam(name="inCrtst_vehiculo")boolean inCrtst_vehiculo,
			@WebParam(name="inCrtst_unanimidad")boolean inCrtst_unanimidad,
			@WebParam(name="inCrtst_aplica_otro")boolean inCrtst_aplica_otro,
			@WebParam(name="inCrtst_aplica_beneficiario")boolean inCrtst_aplica_beneficiario,
			@WebParam(name="inCrtst_indice")int inCrtst_indice,
			@WebParam(name="inCrtst_requisito")String inCrtst_requisito,
			@WebParam(name="inCrtst_adjunto")String inCrtst_adjunto,
			@WebParam(name="inCrtst_garantia")String inCrtst_garantia,
			@WebParam(name="inCrtst_regla")String inCrtst_regla,
			@WebParam(name="inCrtst_opcion")String inCrtst_opcion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);

		com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite obj = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
		obj.setCRTST_CODIGO("KEYGEN");
		obj.setCGG_CRTST_CODIGO(inCgg_crtst_codigo);
		obj.setCRPRO_CODIGO(inCrpro_codigo);
		obj.setCRRES_CODIGO(inCrres_codigo);
		obj.setCKESP_CODIGO(inCkesp_codigo);
		obj.setCRTPT_CODIGO(inCrtpt_codigo);
		obj.setCRTST_DESCRIPCION(inCrtst_descripcion);
		obj.setCRTST_OBSERVACION(inCrtst_observacion);
		obj.setCRTST_APLICA_GARANTIA(inCrtst_aplica_garantia);
		obj.setCRTST_APLICA_TRAMITE(inCrtst_aplica_tramite);
		obj.setCRTST_APLICA_GRUPO(inCrtst_aplica_grupo);
		obj.setCRTST_ATENCION_CLIENTE(inCrtst_atencion_cliente);
		obj.setCRTST_RESTRINGIDO(inCrtst_restringido);
		obj.setCRTST_COMUNICADO_RADIAL(inCrtst_comunicado_radial);
		obj.setCRTST_NUMERO_DIAS(inCrtst_numero_dias);
		obj.setCRTST_VEHICULO(inCrtst_vehiculo);
		obj.setCRTST_UNANIMIDAD(inCrtst_unanimidad);
		obj.setCRTST_APLICA_OTRO(inCrtst_aplica_otro);
		obj.setCRTST_APLICA_BENEFICIARIO(inCrtst_aplica_beneficiario);
		obj.setCRTST_INDICE(new BigDecimal(inCrtst_indice));
		obj.setCRTST_ESTADO(true);
		obj.setCRTST_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());		
		obj.setCRTST_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			con.setAutoCommit(false);
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(obj).insert(con);


			if(obj.getCRTST_CODIGO() != null && obj.getCRTST_CODIGO().equalsIgnoreCase("keygen")==false 
					&& obj.getCRTST_CODIGO().length()>=CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() 
					&& obj.getCRTST_CODIGO().length()<=CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){


				//Almacenamos o Modificamos los adjuntos
				SiiDataSaver attachmentSaver = null;
				if(inCrtst_adjunto!=null && inCrtst_adjunto.length()>0) {
					Type filesListType = new TypeToken<ArrayList<SiiModelFile>>() {}.getType();
					List<SiiModelFile> files = (List<SiiModelFile>) new Gson().fromJson(inCrtst_adjunto,filesListType);
					attachmentSaver = new SiiDataSaver(con,tmpRequest.getUserPrincipal().getName(),"Cgg_res_tramite","crtst_codigo='"+obj.getCRTST_CODIGO()+"'",files);

				}

				org.json.JSONArray jaRequisitos = new org.json.JSONArray(inCrtst_requisito);			
				for(int i = 0 ; i < jaRequisitos.length(); i++){
					Cgg_res_solicitud_requisito objRequisito = new Cgg_res_solicitud_requisito();
					objRequisito.setCRREQ_CODIGO(jaRequisitos.getJSONObject(i).getString("CRREQ_CODIGO"));
					objRequisito.setCRSRQ_CODIGO("KEYGEN");
					objRequisito.setCRSRQ_DESCRIPCION(jaRequisitos.getJSONObject(i).getString("CRSRQ_DESCRIPCION"));
					objRequisito.setCRSRQ_REQUERIDO(jaRequisitos.getJSONObject(i).getBoolean("CRSRQ_REQUERIDO"));
					objRequisito.setCRSRQ_ESTADO(true);
					objRequisito.setCRSRQ_PARTICIPANTE(jaRequisitos.getJSONObject(i).getInt("CRSRQ_PARTICIPANTE"));
					objRequisito.setCRTST_CODIGO(obj.getCRTST_CODIGO());					
					objRequisito.setCRSRQ_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objRequisito.setCRSRQ_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_res_solicitud_requisito(objRequisito).insert(con);
					if(!res.equals("true")){
						break;
					}
				}
				org.json.JSONArray jaGarantia = new org.json.JSONArray(inCrtst_garantia);			
				for(int j = 0 ; j< jaGarantia.length(); j++){
					Cgg_res_garantia_solicitud objGarantiaSolicitud = new Cgg_res_garantia_solicitud();

					objGarantiaSolicitud.setCRGTS_CODIGO("KEYGEN");
					objGarantiaSolicitud.setCRTST_CODIGO(obj.getCRTST_CODIGO());
					objGarantiaSolicitud.setCRGRT_CODIGO(jaGarantia.getJSONObject(j).getString("CRGRT_CODIGO"));
					objGarantiaSolicitud.setCRGTS_ESTADO(true);
					objGarantiaSolicitud.setCRGTS_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objGarantiaSolicitud.setCRGTS_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_res_garantia_solicitud(objGarantiaSolicitud).insert(con);
					if(!res.equals("true")){
						break;
					}
				}
				JSONArray jaRegla = new JSONArray(inCrtst_regla);
				for(int k =0;k<jaRegla.length();k++){
					Cgg_res_tipo_solicitud_regla objSolicitudRegla = new Cgg_res_tipo_solicitud_regla();
					objSolicitudRegla.setCRTSE_CODIGO("KEYGEN");
					objSolicitudRegla.setCRTST_CODIGO(obj.getCRTST_CODIGO());
					objSolicitudRegla.setCRVAL_CODIGO(jaRegla.getJSONObject(k).getString("CRVAL_CODIGO"));
					objSolicitudRegla.setCRTSE_CAMPO_EVALUACION(jaRegla.getJSONObject(k).getString("CRTSE_CAMPO_EVALUACION"));
					objSolicitudRegla.setCRTSE_ESTADO(true);
					objSolicitudRegla.setCRTSE_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objSolicitudRegla.setCRTSE_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_regla(objSolicitudRegla).insert(con);
					if(!res.equalsIgnoreCase("true")){
						break;
					}					
				}
				JSONArray tmpOpciones = new JSONArray(inCrtst_opcion);
				Cgg_res_tst_aplica tmpAplica = new Cgg_res_tst_aplica();
				tmpAplica.setCRTAO_CODIGO("KEYGEN");
				tmpAplica.setCRTST_CODIGO(obj.getCRTST_CODIGO());
				tmpAplica.setCRTAO_ESTADO(true);
				tmpAplica.setCRTAO_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
				tmpAplica.setCRTAO_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
				for (int k = 0; k < tmpOpciones.length(); k++){
					JSONObject tmpOpcion = tmpOpciones.getJSONObject(k);
					if(tmpOpcion.getBoolean("APLICA")){
						tmpAplica.setCRTSO_CODIGO(tmpOpcion.getString("CRTSO_CODIGO"));
						res = new com.besixplus.sii.db.Cgg_res_tst_aplica(tmpAplica).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
				if(res.equalsIgnoreCase("true")){
					if(attachmentSaver!=null)
						attachmentSaver.save();
					con.commit();
				}else{
					con.rollback();
					obj.setCRTST_CODIGO("false");
				}
			}else{
				con.rollback();
				obj.setCRTST_CODIGO("false");
			}			
			con.setAutoCommit(true);
			con.close();
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
	 * Actualiza un tipo de solicitud de tramite al igual que su informacion de requerimientos y garantias. Este metodo se encuentra actualmente precario debido a que no responde a la logica de programacion.
	 * El principal problema que tiene este servicio es el hecho de que cuando uno de los requerimientos esta ya enlazado a un tramite estos no pueden ser borrados y siempre resultara en errores que no permitan la actualizacion de la solicitud de tramite.
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	 * @param inCgg_crtst_codigo IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD RECURSIVO
	 * @param inCrtpt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	 * @param inCrpro_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
	 * @param inCrres_codigo CODIGO DE RESOLUCION.
	 * @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES.
	 * @param inCrtst_descripcion DESCRIPCION DEL TIPO DE RESIDENCIA
	 * @param inCrtst_observacion NO ESPECIFICADO
	 * @param inCrtst_aplica_garantia ESTADO DE CONTROL PARA DESPOSITO DE GARANTIA.
EN ESTE CASO SE RELACIONA CON UNA O VARIAS GARANTIAS, LAS CUALES DEBEN SER CREADAS.
	 * @param inCrtst_aplica_tramite ESTADO DE CONTROL PARA DETERMINAR SI SE CONSIDERA COMO INICIO DE DE UN TRAMITE, EN OTRAS PALABRAS ESTABLECE SI ESTE TRAMITE ES UN TRAMITE DE TRABAJO O SOLO DE AGRUPAMIENTO
SI
NO
	 * @param inCrtst_aplica_grupo SI EL TRAMITE PUEDE TENER VARIOS BENEFICIARIOS O ES UN TRAMITE QUE APLICA PARA VARIAS PERSONAS.
	 * @param inCrtst_atencion_cliente SI EL TRAMITE ESTA DISPONIBLE PARA UN PRE REGISTRO POR MEDIO DE ATENCION AL CLIENTE
	 * @param inCrtst_restringido SI SE APLICA UN CONTROL ESPECIFICO PARA PODER INICIAR UN TRAMITE
	 * @param inCrtst_comunicado_radial SI EL TRAMITE NECESITA DE UN COMUNICADO RADIAL PARA SU INICIO
	 * @param inCrtst_numero_dias NUMERO DE DIAS MAXIMO PERMITIDO PARA LA RESIDENCIA O MOVILIDAD
	 * @param inCrtst_vehiculo ALMACENA INFORMACION DEL VEHICULO
	 * @param inCrtst_unanimidad CONTEO APLICADO AL TRAMITE
	 * @param inCrtst_aplica_otro CAMPO PARA VALIDACION DE OTRO VALOR QUE SE PUEDIERA MANEJAR ADICIONALMENTE PARA EL TIPO DE SOLICITUD DE TRAMITE.
	 * @param inCrtst_aplica_beneficiario SI EL TIPO DE SOLICITUD REQUIERE DE UN BENEFICIARIO
	 * @param inCrtst_indice INDICE NUMERICO UTIL PARA LA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET PARA RESIDENCIA.
	 * @param inCrtst_requisito Cadena de datos en formato json de los requisitos a ser cumplidos por el tipo de solicitud de tramite.
	 * @param inCrtst_adjunto Cadena de datos en formato json de los adjuntos a ser subidos en Alfresco.
	 * @param inCrtst_garantia Cadena de datos en formato json de los garantias que deben ser cumplidas por el tramite.
	 * @param inCrtst_regla Cadena de datos en formato json de las reglas que son aplicadas al tipo de solicitud de tramite.
	 * @param inCrtst_opcion Opciones que aplica el tipo de solicitud.
	 * @return String True/false/Error en la ejecucion del medoto.
	 * @throws SOAPException 
	 */
	@WebMethod	
	public String updateTipoSolicitudTramite(
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="inCgg_crtst_codigo")String inCgg_crtst_codigo,
			@WebParam(name="inCrtpt_codigo")String inCrtpt_codigo,
			@WebParam(name="inCrpro_codigo")String inCrpro_codigo,
			@WebParam(name = "inCrres_codigo", partName = "inCrres_codigo") String inCrres_codigo,
			@WebParam(name="inCkesp_codigo")String inCkesp_codigo,
			@WebParam(name="inCrtst_descripcion")String inCrtst_descripcion,
			@WebParam(name="inCrtst_observacion")String inCrtst_observacion,
			@WebParam(name="inCrtst_aplica_garantia")boolean inCrtst_aplica_garantia,
			@WebParam(name="inCrtst_aplica_tramite")boolean inCrtst_aplica_tramite,
			@WebParam(name="inCrtst_aplica_grupo")boolean inCrtst_aplica_grupo,
			@WebParam(name="inCrtst_atencion_cliente")boolean inCrtst_atencion_cliente,
			@WebParam(name="inCrtst_restringido")boolean inCrtst_restringido,
			@WebParam(name="inCrtst_comunicado_radial")boolean inCrtst_comunicado_radial,
			@WebParam(name="inCrtst_numero_dias")int inCrtst_numero_dias,
			@WebParam(name="inCrtst_vehiculo")boolean inCrtst_vehiculo,
			@WebParam(name="inCrtst_unanimidad")boolean inCrtst_unanimidad,
			@WebParam(name="inCrtst_aplica_otro")boolean inCrtst_aplica_otro,
			@WebParam(name="inCrtst_aplica_beneficiario")boolean inCrtst_aplica_beneficiario,
			@WebParam(name="inCrtst_indice")int inCrtst_indice,
			@WebParam(name="inCrtst_requisito")String inCrtst_requisito,
			@WebParam(name="inCrtst_adjunto")String inCrtst_adjunto,
			@WebParam(name="inCrtst_garantia")String inCrtst_garantia,
			@WebParam(name="inCrtst_regla")String inCrtst_regla,
			@WebParam(name="inCrtst_opcion")String inCrtst_opcion
	) throws SOAPException{		
		String res = "true";
		boolean flagUpdateRequisito = true;
		String flagInsertRegla = "true",flagUpdateRegla = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite obj = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();

		obj.setCRTST_CODIGO(inCrtst_codigo);
		obj.setCGG_CRTST_CODIGO(inCgg_crtst_codigo);		
		obj.setCRPRO_CODIGO(inCrpro_codigo);
		obj.setCRRES_CODIGO(inCrres_codigo);
		obj.setCKESP_CODIGO(inCkesp_codigo);
		obj.setCRTPT_CODIGO(inCrtpt_codigo);
		obj.setCRTST_DESCRIPCION(inCrtst_descripcion);
		obj.setCRTST_OBSERVACION(inCrtst_observacion);
		obj.setCRTST_APLICA_GARANTIA(inCrtst_aplica_garantia);
		obj.setCRTST_APLICA_TRAMITE(inCrtst_aplica_tramite);
		obj.setCRTST_APLICA_GRUPO(inCrtst_aplica_grupo);
		obj.setCRTST_ATENCION_CLIENTE(inCrtst_atencion_cliente);
		obj.setCRTST_RESTRINGIDO(inCrtst_restringido);
		obj.setCRTST_COMUNICADO_RADIAL(inCrtst_comunicado_radial);
		obj.setCRTST_NUMERO_DIAS(inCrtst_numero_dias);
		obj.setCRTST_VEHICULO(inCrtst_vehiculo);
		obj.setCRTST_UNANIMIDAD(inCrtst_unanimidad);
		obj.setCRTST_UNANIMIDAD(inCrtst_unanimidad);
		obj.setCRTST_APLICA_OTRO(inCrtst_aplica_otro);
		obj.setCRTST_APLICA_BENEFICIARIO(inCrtst_aplica_beneficiario);
		obj.setCRTST_INDICE(new BigDecimal(inCrtst_indice));
		obj.setCRTST_ESTADO(true);
		obj.setCRTST_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			con.setAutoCommit(false);
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(obj).update(con);


			//Almacenamos o Modificamos los adjuntos
			SiiDataSaver attachmentSaver = null;
			if(inCrtst_adjunto!=null && inCrtst_adjunto.length()>0) {
				Type filesListType = new TypeToken<ArrayList<SiiModelFile>>() {}.getType();
				List<SiiModelFile> files = (List<SiiModelFile>) new Gson().fromJson(inCrtst_adjunto,filesListType);
				attachmentSaver = new SiiDataSaver(con,tmpRequest.getUserPrincipal().getName(),"Cgg_res_tramite","crtst_codigo='"+inCrtst_codigo+"'",files);

			}

			if(res.equalsIgnoreCase("true") && obj.getCRTST_CODIGO() != null 
					&& obj.getCRTST_CODIGO().length()>=CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() 
					&& obj.getCRTST_CODIGO().length()<=CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){										
				con.commit();
				com.besixplus.sii.objects.Cgg_res_solicitud_requisito tmpSolicitudRequisito= new com.besixplus.sii.objects.Cgg_res_solicitud_requisito();
				tmpSolicitudRequisito.setCRTST_CODIGO(inCrtst_codigo);

				//ACTUALIZACION Y ELIMINACION DE REQUISITOS DE SOLICITUD EXISTENTES.
				ArrayList<com.besixplus.sii.objects.Cgg_res_solicitud_requisito> colSolicitudRequisito = new com.besixplus.sii.db.Cgg_res_solicitud_requisito(tmpSolicitudRequisito).selectCGG_RES_TIPO_SOLICITUD_TRAMITE(con);
				org.json.JSONArray jaRequisitos = new org.json.JSONArray(inCrtst_requisito);

				for(java.util.Iterator<Cgg_res_solicitud_requisito> iSolicitudRequisito = colSolicitudRequisito.iterator();iSolicitudRequisito.hasNext();){
					Cgg_res_solicitud_requisito tmpSolicitudRequisito1 = iSolicitudRequisito.next();
					boolean flagEliminarRequisito = false;
					for(int i = 0 ; i < jaRequisitos.length(); i++){
						JSONObject tmpJsonSolicitudRequisito =jaRequisitos.getJSONObject(i); 

						if(tmpSolicitudRequisito1.getCRSRQ_CODIGO().equalsIgnoreCase(tmpJsonSolicitudRequisito.getString("CRSRQ_CODIGO"))==true){

							tmpSolicitudRequisito1.setCRREQ_CODIGO(tmpJsonSolicitudRequisito.getString("CRREQ_CODIGO"));							
							tmpSolicitudRequisito1.setCRSRQ_DESCRIPCION(tmpJsonSolicitudRequisito.getString("CRSRQ_DESCRIPCION"));
							tmpSolicitudRequisito1.setCRSRQ_REQUERIDO(tmpJsonSolicitudRequisito.getBoolean("CRSRQ_REQUERIDO"));							
							tmpSolicitudRequisito1.setCRSRQ_PARTICIPANTE(jaRequisitos.getJSONObject(i).getInt("CRSRQ_PARTICIPANTE"));
							tmpSolicitudRequisito1.setCRTST_CODIGO(obj.getCRTST_CODIGO());							
							tmpSolicitudRequisito1.setCRSRQ_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_res_solicitud_requisito(tmpSolicitudRequisito1).update(con);
							if(!res.equals("true")){
								break;
							}
							flagEliminarRequisito = true;
						}												
					}
					if(flagUpdateRequisito == false){
						break;
					}

					if(flagEliminarRequisito == false){
						res = new com.besixplus.sii.db.Cgg_res_solicitud_requisito(tmpSolicitudRequisito1).delete(con);
					}
				}

				//REGISTRO DE REQUISITOS NUEVOS PARA LA SOLICITUD
				for(int i = 0 ; i < jaRequisitos.length(); i++){
					JSONObject tmpJsonSolicitudRequisito =jaRequisitos.getJSONObject(i);															
					if(tmpJsonSolicitudRequisito.getString("CRSRQ_CODIGO")!=null && tmpJsonSolicitudRequisito.getString("CRSRQ_CODIGO").equalsIgnoreCase("KEYGEN") == true){
						Cgg_res_solicitud_requisito objRequisito = new Cgg_res_solicitud_requisito();
						objRequisito.setCRREQ_CODIGO(tmpJsonSolicitudRequisito.getString("CRREQ_CODIGO"));
						objRequisito.setCRSRQ_CODIGO("KEYGEN");
						objRequisito.setCRSRQ_DESCRIPCION(tmpJsonSolicitudRequisito.getString("CRSRQ_DESCRIPCION"));
						objRequisito.setCRSRQ_REQUERIDO(tmpJsonSolicitudRequisito.getBoolean("CRSRQ_REQUERIDO"));
						objRequisito.setCRSRQ_ESTADO(true);
						objRequisito.setCRSRQ_PARTICIPANTE(tmpJsonSolicitudRequisito.getInt("CRSRQ_PARTICIPANTE"));
						objRequisito.setCRTST_CODIGO(obj.getCRTST_CODIGO());					
						objRequisito.setCRSRQ_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objRequisito.setCRSRQ_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_res_solicitud_requisito(objRequisito).insert(con);
						if(!res.equals("true")){
							break;
						}																						
					}
				}

				//ACTUALIZACION Y ELIMINACION DE GARANTIA DE SOLICITUD EXISTENTES.
				Cgg_res_garantia_solicitud tmpGarantia = new Cgg_res_garantia_solicitud();
				tmpGarantia.setCRTST_CODIGO(inCrtst_codigo);
				ArrayList<Cgg_res_garantia_solicitud> colGarantiaSolicitud = new com.besixplus.sii.db.Cgg_res_garantia_solicitud(tmpGarantia).selectCGG_RES_TIPO_SOLICITUD_TRAMITE(con);
				org.json.JSONArray jaGarantia = new org.json.JSONArray(inCrtst_garantia);	

				for(java.util.Iterator<Cgg_res_garantia_solicitud> iGarantiaSolicitud = colGarantiaSolicitud.iterator();iGarantiaSolicitud.hasNext();){
					tmpGarantia = iGarantiaSolicitud.next();
					boolean flagEliminarGarantia = true;						
					for(int j = 0 ; j< jaGarantia.length(); j++){
						JSONObject tmpJsonGarantia = jaGarantia.getJSONObject(j); 
						if(tmpGarantia.getCRGRT_CODIGO().equalsIgnoreCase(tmpJsonGarantia.getString("CRGRT_CODIGO"))){

							tmpGarantia.setCRGRT_CODIGO(tmpJsonGarantia.getString("CRGRT_CODIGO"));
							tmpGarantia.setCRGTS_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_res_garantia_solicitud(tmpGarantia).update(con);
							if(!res.equals("true")){
								break;
							}
							flagEliminarGarantia = false;
						}
					}
					if(flagEliminarGarantia == true){
						new com.besixplus.sii.db.Cgg_res_garantia_solicitud(tmpGarantia).delete(con);
					}
				}

				//REGISTRO DE REQUISITOS NUEVOS PARA LA SOLICITUD
				for(int j = 0 ; j< jaGarantia.length(); j++){
					JSONObject tmpJsonGarantia = jaGarantia.getJSONObject(j); 
					if(tmpJsonGarantia.getString("CRGTS_CODIGO").equalsIgnoreCase("KEYGEN")==true){
						Cgg_res_garantia_solicitud garantiaSolicitud = new Cgg_res_garantia_solicitud();
						garantiaSolicitud.setCRGTS_CODIGO("KEYGEN");
						garantiaSolicitud.setCRTST_CODIGO(obj.getCRTST_CODIGO());
						garantiaSolicitud.setCRGRT_CODIGO(jaGarantia.getJSONObject(j).getString("CRGRT_CODIGO"));
						garantiaSolicitud.setCRGTS_ESTADO(true);
						garantiaSolicitud.setCRGRT_CODIGO(tmpJsonGarantia.getString("CRGRT_CODIGO"));
						garantiaSolicitud.setCRGTS_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						garantiaSolicitud.setCRGTS_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_res_garantia_solicitud(garantiaSolicitud).insert(con);
						if(!res.equals("true")){
							break;
						}
					}
				}

				//ACTUALIZACION Y ELIMINACION DE REGLAS DE SOLICITUD EXISTENTES.
				Cgg_res_tipo_solicitud_regla reglaSolicitud = new Cgg_res_tipo_solicitud_regla();
				reglaSolicitud.setCRTST_CODIGO(inCrtst_codigo);
				ArrayList<Cgg_res_tipo_solicitud_regla> colReglaSolicitud = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_regla(reglaSolicitud).selectCGG_RES_TIPO_SOLICITUD_TRAMITE(con);
				JSONArray jaRegla = new JSONArray(inCrtst_regla);

				for(java.util.Iterator<Cgg_res_tipo_solicitud_regla> iReglaSolicitud = colReglaSolicitud.iterator();iReglaSolicitud.hasNext();){
					reglaSolicitud = iReglaSolicitud.next();
					boolean flagEliminarRegla = true;
					for(int k =0;k<jaRegla.length();k++){
						JSONObject tmpJsonRegla = jaRegla.getJSONObject(k);

						if(reglaSolicitud.getCRTSE_CODIGO().equalsIgnoreCase(tmpJsonRegla.getString("CRTSE_CODIGO"))==true){

							reglaSolicitud.setCRVAL_CODIGO(tmpJsonRegla.getString("CRVAL_CODIGO"));
							reglaSolicitud.setCRTSE_CAMPO_EVALUACION(tmpJsonRegla.getString("CRTSE_CAMPO_EVALUACION"));							
							reglaSolicitud.setCRTSE_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							flagInsertRegla = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_regla(reglaSolicitud).update(con);
							if(flagInsertRegla.equalsIgnoreCase("true")==false){
								break;
							}																
							flagEliminarRegla = false;
						}											
					}
					if(flagEliminarRegla==true){
						new com.besixplus.sii.db.Cgg_res_tipo_solicitud_regla(reglaSolicitud).delete(con);
					}
				}
				//REGISTRO DE REGLAS NUEVAS PARA LA SOLICITUD
				for(int k =0;k<jaRegla.length();k++){
					JSONObject tmpJsonRegla = jaRegla.getJSONObject(k);

					if(tmpJsonRegla.getString("CRTSE_CODIGO").equalsIgnoreCase("KEYGEN")==true){
						Cgg_res_tipo_solicitud_regla objSolicitudRegla = new Cgg_res_tipo_solicitud_regla();
						objSolicitudRegla.setCRTSE_CODIGO("KEYGEN");
						objSolicitudRegla.setCRTST_CODIGO(obj.getCRTST_CODIGO());
						objSolicitudRegla.setCRVAL_CODIGO(tmpJsonRegla.getString("CRVAL_CODIGO"));
						objSolicitudRegla.setCRTSE_CAMPO_EVALUACION(tmpJsonRegla.getString("CRTSE_CAMPO_EVALUACION"));
						objSolicitudRegla.setCRTSE_ESTADO(true);
						objSolicitudRegla.setCRTSE_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objSolicitudRegla.setCRTSE_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						flagUpdateRegla = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_regla(objSolicitudRegla).insert(con);
						if(flagUpdateRegla.equalsIgnoreCase("true")==false){
							break;
						}
					}									
				}

				JSONArray tmpOpciones = new JSONArray(inCrtst_opcion);
				Cgg_res_tst_aplica tmpAplica = new Cgg_res_tst_aplica();
				tmpAplica.setCRTST_CODIGO(obj.getCRTST_CODIGO());
				tmpAplica.setCRTAO_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
				tmpAplica.setCRTAO_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

				new com.besixplus.sii.db.Cgg_res_tst_aplica(tmpAplica).deleteCGG_RES_TIPO_SOLICITUD_TRAMITE(con, false);
				for (int k = 0; k < tmpOpciones.length(); k++){
					JSONObject tmpOpcion = tmpOpciones.getJSONObject(k);
					if(tmpOpcion.getBoolean("APLICA")){
						tmpAplica.setCRTAO_CODIGO("KEYGEN");
						tmpAplica.setCRTSO_CODIGO(tmpOpcion.getString("CRTSO_CODIGO"));
						tmpAplica.setCRTAO_ESTADO(true);
						res = new com.besixplus.sii.db.Cgg_res_tst_aplica(tmpAplica).insert(con);
						if(!res.equals("true"))
							break;
					}
				}
			}
			if(res.equals("true")) {
				if(attachmentSaver!=null)
					attachmentSaver.save();
				con.commit();
			}else {
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_tipo_solicitud_tramite junto con sus dependencias en las tablas de garantia solicitud y requisito solicitud de manera transaccional.
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String eliminarTipoSolicitudTramite(
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo
	) throws SOAPException{
		String outResult = "true";
		String flagRequisito = "true";
		String flagGarantia = "true";
		com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite tmpSolicitud = null;
		ArrayList<Cgg_res_solicitud_requisito> coleccionRequisito = null;
		ArrayList<Cgg_res_garantia_solicitud> coleccionGarantia = null;

		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);

			tmpSolicitud = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
			tmpSolicitud.setCRTST_CODIGO(inCrtst_codigo);			
			tmpSolicitud = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(tmpSolicitud).select(con);

			if(tmpSolicitud.getCRTST_CODIGO()!=null &&
					tmpSolicitud.getCRTST_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
					tmpSolicitud.getCRTST_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()
			){
				Cgg_res_solicitud_requisito tmpRequisito = new Cgg_res_solicitud_requisito();
				tmpRequisito.setCRTST_CODIGO(inCrtst_codigo);			

				coleccionRequisito = new com.besixplus.sii.db.Cgg_res_solicitud_requisito(tmpRequisito).selectCGG_RES_TIPO_SOLICITUD_TRAMITE(con);
				for(Cgg_res_solicitud_requisito tmpRequisito1 : coleccionRequisito){
					flagRequisito = new com.besixplus.sii.db.Cgg_res_solicitud_requisito(tmpRequisito1).delete(con);
					if(!flagRequisito.equals("true")){
						break;
					}
				}

				Cgg_res_garantia_solicitud tmpGarantia = new Cgg_res_garantia_solicitud();
				tmpGarantia.setCRTST_CODIGO(inCrtst_codigo);
				coleccionGarantia = new com.besixplus.sii.db.Cgg_res_garantia_solicitud(tmpGarantia).selectCGG_RES_TIPO_SOLICITUD_TRAMITE(con);
				for(Cgg_res_garantia_solicitud tmpGarantia1 : coleccionGarantia){
					flagGarantia = new com.besixplus.sii.db.Cgg_res_garantia_solicitud(tmpGarantia1).delete1(con);
					if(!flagGarantia.equals("true")){
						break;
					}
				}

				if(flagGarantia.equals("true") && flagRequisito.equals("true")){
					outResult = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(tmpSolicitud).delete(con);
					if(outResult.equals("true")){
						con.commit();
					}else{
						con.rollback();
					}
				}else{
					con.rollback();
				}
			}else{
			}
			con.setAutoCommit(true);
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
	 * Verifica si un usuario puede o no iniciar un tipo de solicitud de tramite.
	 * @param inCrtst_codigo Codigo de tipo de solicitud.
	 * @param inCusu_codigo Codigo de usuario.
	 * @return 1-Inicia / 0 - No inicia / otro - error.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String iniciaTipoSolicitudTramite(
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="inCusu_codigo")String inCusu_codigo		
	) throws SOAPException{
		String outResult = "0";		
		com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite tmpSolicitud = null;		

		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);

			tmpSolicitud = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();
			tmpSolicitud.setCRTST_CODIGO(inCrtst_codigo);			
			tmpSolicitud = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(tmpSolicitud).select(con);

			if(tmpSolicitud.getCRTST_CODIGO()!=null &&
					tmpSolicitud.getCRTST_CODIGO().trim().length() >= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
					tmpSolicitud.getCRTST_CODIGO().trim().length() <= CGGEnumerators.LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()
			){
				outResult = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(tmpSolicitud).iniciaTipoSolicitudTramite(con, inCusu_codigo);							
			}else{
				outResult = "0";
			}
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return outResult;
	}	

	/**
	 * OBTIENE LOS REGISTROS PADRES CORRESPONDIENTES AL TIPO DE SOLICITUD PATA ATENCION AL CLIENTE.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON o XML).
	 * @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectTipoPadreATC(
			@WebParam(name="format")String format,
			@WebParam(name="inCgcnf_codigo")String inCgcnf_codigo
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
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite.selectTipoPadreATC(con,inCgcnf_codigo);
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
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS PADRES CORRESPONDIENTES AL TIPO DE SOLICITUD PATA ATENCION AL CLIENTE.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON o XML).
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE SOLICITUD DE TRAMITE 
	 * @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectTipoAtencionCliente(
			@WebParam(name="format")String format,
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="inCgcnf_codigo")String inCgcnf_codigo
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
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite.selectTipoAtencionCliente(con,inCrtst_codigo,inCgcnf_codigo);
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
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS PADRES CORRESPONDIENTES AL TIPO DE SOLICITUD PATA ATENCION AL CLIENTE.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON o XML).
	 * @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAllTipoSolicitudATC(
			@WebParam(name="format")String format,
			@WebParam(name="inCgcnf_codigo")String inCgcnf_codigo
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(tmpRequest.getUserPrincipal()!=null){
				if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
					con.close();
					throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				}
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite.selectAllTipoSolicitudATC(con,inCgcnf_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "[{ MENU:"+outCadena.toString()+"}]";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}


	/**
	 * Selecciona la solicitud padre de un tipo de solicitud especificado.
	 * @param inCrtst_codigo Codio de solicitud.
	 * @param format Formato de salida.
	 * @return	Informacion de tipo solicitud.
	 * @throws SOAPException
	 */
	@WebMethod
	public String selectCGG_RES_TIPO_SOLICITUD_PADRE(
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="format")String format			
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite> obj = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite>();
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite solicitud = new com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite();		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			solicitud.setCRTST_CODIGO(inCrtst_codigo);
			con.setAutoCommit(false);						
			solicitud = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(solicitud).selectCGG_RES_TIPO_SOLICITUD_PADRE(inCrtst_codigo,con);
			obj.add(solicitud);

			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);

			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}		
		return outCadena.toString();
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud_tramite EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON o XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */	@WebMethod 
	public String selectPageDirectConPadre(
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
			tmpCount = com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite.selectCountConPadre(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite.selectPageDirectConPadre(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* SELECCIONA LOS REGISTRO EN LA TABLA Cgg_res_tipo_solicitud_tramite EN FORMA DE ARBOL.
	* @param inCgg_crtst_codigo IDENTIFICADOR UNICO DE REGISTRO  DE TIPO DE SOLICITUD RELACIONADO..
	* @return String.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectTipoSolicitudTree(
		@WebParam(name="inCgg_crtst_codigo")String inCgg_crtst_codigo
   	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
	
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite().selectTipoSolicitudTree(con,inCgg_crtst_codigo);
			con.close();
			if(res.equals("false"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}
	
}