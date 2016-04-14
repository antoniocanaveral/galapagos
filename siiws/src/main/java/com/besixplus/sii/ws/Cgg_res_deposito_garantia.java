package com.besixplus.sii.ws;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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

import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.objects.ServerResponse;

/**
 * CLASE Cgg_res_deposito_garantia
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_deposito_garantia POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_deposito_garantia implements Serializable{

	private static final long serialVersionUID = 2109177145;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_deposito_garantia.
	 * @param inCrcpj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA .
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA NATURAL QUE REALIZO EL DEPOSITO.
	 * @param inCgg_crpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA QUE REALIZO EL DEPOSITO.
	 * @param inCrdpt_numero NUMERO ALFANUMERICO SECUENCIAL GENERADO CON FINES DE INDICAR A QUE REFERENCIA HACE UN TRAMITE AL MOMENTO DE SU CREACION..
	 * @param inCrdpt_numero_documento NUMERO DE DOCUMENTO DE DEPOSITO.
	 * @param inCrdpt_caduca SI LA GARANTIA CADUCA.
	 * @param inCrdpt_tipo TIPO DE GARANTIA
0 - DEPOSITO
1 - CHEQUE
2 - POLIZA
3 - OTROS.
	 * @param inCrdpt_valor_deposito VALOR DEPOSITADO POR GARANTIA.
	 * @param inCrdpt_fecha_deposito FECHA DE REALIZACION DE DEPOSITO.
	 * @param inCrdpt_fecha_entrega FECHA DE ENTREGA DE COMPROBANTE DE DEPOSITO.
	 * @param inCrdpt_fecha_caducidad FECHA DE CADUCIDAD DEL DEPOSITO DE GARANTIA.
	 * @param inCrdpt_fecha_contabilizacion FECHA DE INGRESO A CUSTODIA DEL DEPARTAMENTO FINANCIERO.
	 * @param inCrdpt_fecha_solic_devolucion FECHA DE SOLICITUD DE DEVOLUCION DE GARANTIA.
	 * @param inCrdpt_fecha_devolucion_definiti FECHA DE DEVOLUCION DE LA GARANTIA AL TITULAR.
	 * @param inCrdpt_devuelto ESTADO QUE DETERMINA SI UNA GARANTIA ESTA AUN ACTIVA 
SI
NO.
	 * @param inCrdpt_estado_deposito ESTADO DE CONTROL DEL DEPOSITO 
0 - REGISTRADO
1 - CONTABILIZADO
2 - AUTORIZADO LA DEVOLUCION
3 - DEVUELTO
4 - TEMPORAL CREADA EN TRAMITE
.
	 * @param inCrdpt_observacion OBSERVACION DEL DEPOSITO DE GARANTIA.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrcpj_codigo")String inCrcpj_codigo,
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCgg_crpjr_codigo")String inCgg_crpjr_codigo,
			@WebParam(name="inCrdpt_numero")String inCrdpt_numero,
			@WebParam(name="inCrdpt_numero_documento")String inCrdpt_numero_documento,
			@WebParam(name="inCrdpt_caduca")boolean inCrdpt_caduca,
			@WebParam(name="inCrdpt_tipo")int inCrdpt_tipo,
			@WebParam(name="inCrdpt_valor_deposito")java.math.BigDecimal inCrdpt_valor_deposito,
			@WebParam(name="inCrdpt_fecha_deposito")java.util.Date inCrdpt_fecha_deposito,
			@WebParam(name="inCrdpt_fecha_entrega")java.util.Date inCrdpt_fecha_entrega,
			@WebParam(name="inCrdpt_fecha_caducidad")java.util.Date inCrdpt_fecha_caducidad,
			@WebParam(name="inCrdpt_fecha_contabilizacion")java.util.Date inCrdpt_fecha_contabilizacion,
			@WebParam(name="inCrdpt_fecha_solic_devolucion")java.util.Date inCrdpt_fecha_solic_devolucion,
			@WebParam(name="inCrdpt_fecha_devolucion_definiti")java.util.Date inCrdpt_fecha_devolucion_definiti,
			@WebParam(name="inCrdpt_devuelto")boolean inCrdpt_devuelto,
			@WebParam(name="inCrdpt_estado_deposito")int inCrdpt_estado_deposito,
			@WebParam(name="inCrdpt_observacion")String inCrdpt_observacion
	) throws SOAPException{
		String res = "true";
		ServerResponse responser = new ServerResponse(false, "garantia no guardada", null);
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_deposito_garantia obj = new com.besixplus.sii.objects.Cgg_res_deposito_garantia();
		obj.setCRDPT_CODIGO("KEYGEN");
		obj.setCRCPJ_CODIGO(inCrcpj_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCGG_CRPJR_CODIGO(inCgg_crpjr_codigo);
		obj.setCRDPT_NUMERO(inCrdpt_numero);
		obj.setCRDPT_NUMERO_DOCUMENTO(inCrdpt_numero_documento);
		obj.setCRDPT_CADUCA(inCrdpt_caduca);
		obj.setCRDPT_TIPO(inCrdpt_tipo);
		obj.setCRDPT_VALOR_DEPOSITO(inCrdpt_valor_deposito);
		obj.setCRDPT_FECHA_DEPOSITO(inCrdpt_fecha_deposito);
		obj.setCRDPT_FECHA_ENTREGA(inCrdpt_fecha_entrega);
		obj.setCRDPT_FECHA_CADUCIDAD(inCrdpt_fecha_caducidad);
		obj.setCRDPT_FECHA_CONTABILIZACION(inCrdpt_fecha_contabilizacion);
		obj.setCRDPT_FECHA_SOLIC_DEVOLUCION(inCrdpt_fecha_solic_devolucion);
		obj.setCRDPT_FECHA_DEVOLUCION_DEFINITI(inCrdpt_fecha_devolucion_definiti);
		obj.setCRDPT_DEVUELTO(inCrdpt_devuelto);
		obj.setCRDPT_ESTADO_DEPOSITO(inCrdpt_estado_deposito);
		obj.setCRDPT_OBSERVACION(inCrdpt_observacion);
		obj.setCRDPT_ESTADO(true);
		obj.setCRDPT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRDPT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_res_deposito_garantia(obj).insert(con);										
			if(!res.equalsIgnoreCase("true")){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}else{				
				con.commit();
				obj = new com.besixplus.sii.db.Cgg_res_deposito_garantia(obj).select(con);													
				responser.setSuccess(true);
				responser.setMsg(obj.getCRDPT_CODIGO());
				responser.setObjData(obj);
				con.setAutoCommit(true);
				con.close();
			}			
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new JSONObject(responser).toString();
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_deposito_garantia EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_deposito_garantia.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_deposito_garantia EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inDisponibles IDENTIFICATIVO DE DISPONIBILIDAD.
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
			@WebParam(name="inDisponibles")boolean inDisponibles
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
			tmpCount = com.besixplus.sii.db.Cgg_res_deposito_garantia.selectCount(con, keyword,inDisponibles);
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_res_deposito_garantia.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword,inDisponibles);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_deposito_garantia EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inCrdpt_codigo CODIGO DE DEPOSITO DE GARANTIA.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectTramites(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCrdpt_codigo")String inCrdpt_codigo
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
			com.besixplus.sii.objects.Cgg_res_deposito_garantia tmpDeposito = new com.besixplus.sii.objects.Cgg_res_deposito_garantia();
			tmpDeposito.setCRDPT_CODIGO(inCrdpt_codigo);
			tmpCount = new com.besixplus.sii.db.Cgg_res_deposito_garantia(tmpDeposito).selectCountCGG_RES_DEPOSITO_GARANTIA(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = new com.besixplus.sii.db.Cgg_res_deposito_garantia(tmpDeposito).selectCGG_RES_DEPOSITO_GARANTIA(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_deposito_garantia.
	 * @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	 * @param inCrcpj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA
	 * @param inCrpjr_codigo IDENTIFICATIVO UNICO DE PERSONA JURIDICA.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA NATURAL QUE REALIZO EL DEPOSITO
	 * @param inCgg_crpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA QUE REALIZO EL DEPOSITO 
	 * @param inCrdpt_numero NUMERO ALFANUMERICO SECUENCIAL GENERADO CON FINES DE INDICAR A QUE REFERENCIA HACE UN TRAMITE AL MOMENTO DE SU CREACION.
	 * @param inCrdpt_numero_documento NUMERO DE DOCUMENTO DE DEPOSITO
	 * @param inCrdpt_caduca SI LA GARANTIA CADUCA
	 * @param inCrdpt_tipo TIPO DE GARANTIA
0 - DEPOSITO
1 - CHEQUE
2 - POLIZA
3 - OTROS
	 * @param inCrdpt_valor_deposito VALOR DEPOSITADO POR GARANTIA
	 * @param inCrdpt_fecha_deposito FECHA DE REALIZACION DE DEPOSITO
	 * @param inCrdpt_fecha_entrega FECHA DE ENTREGA DE COMPROBANTE DE DEPOSITO
	 * @param inCrdpt_fecha_caducidad FECHA DE CADUCIDAD DEL DEPOSITO DE GARANTIA
	 * @param inCrdpt_fecha_contabilizacion FECHA DE INGRESO A CUSTODIA DEL DEPARTAMENTO FINANCIERO
	 * @param inCrdpt_fecha_solic_devolucion FECHA DE SOLICITUD DE DEVOLUCION DE GARANTIA
	 * @param inCrdpt_fecha_devolucion_definiti FECHA DE DEVOLUCION DE LA GARANTIA AL TITULAR
	 * @param inCrdpt_devuelto ESTADO QUE DETERMINA SI UNA GARANTIA ESTA AUN ACTIVA 
SI
NO
	 * @param inCrdpt_estado_deposito ESTADO DE CONTROL DEL DEPOSITO 
0 - REGISTRADO
1 - CONTABILIZADO
2 - AUTORIZADO LA DEVOLUCION
3 - DEVUELTO
4 - TEMPORAL CREADA EN TRAMITE

	 * @param inCrdpt_observacion OBSERVACION DEL DEPOSITO DE GARANTIA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrdpt_codigo")String inCrdpt_codigo,
			@WebParam(name="inCrcpj_codigo")String inCrcpj_codigo,
			@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCgg_crpjr_codigo")String inCgg_crpjr_codigo,
			@WebParam(name="inCrdpt_numero")String inCrdpt_numero,
			@WebParam(name="inCrdpt_numero_documento")String inCrdpt_numero_documento,
			@WebParam(name="inCrdpt_caduca")boolean inCrdpt_caduca,
			@WebParam(name="inCrdpt_tipo")int inCrdpt_tipo,
			@WebParam(name="inCrdpt_valor_deposito")java.math.BigDecimal inCrdpt_valor_deposito,
			@WebParam(name="inCrdpt_fecha_deposito")java.util.Date inCrdpt_fecha_deposito,
			@WebParam(name="inCrdpt_fecha_entrega")java.util.Date inCrdpt_fecha_entrega,
			@WebParam(name="inCrdpt_fecha_caducidad")java.util.Date inCrdpt_fecha_caducidad,
			@WebParam(name="inCrdpt_fecha_contabilizacion")java.util.Date inCrdpt_fecha_contabilizacion,
			@WebParam(name="inCrdpt_fecha_solic_devolucion")java.util.Date inCrdpt_fecha_solic_devolucion,
			@WebParam(name="inCrdpt_fecha_devolucion_definiti")java.util.Date inCrdpt_fecha_devolucion_definiti,
			@WebParam(name="inCrdpt_devuelto")boolean inCrdpt_devuelto,
			@WebParam(name="inCrdpt_estado_deposito")int inCrdpt_estado_deposito,
			@WebParam(name="inCrdpt_observacion")String inCrdpt_observacion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_deposito_garantia obj = new com.besixplus.sii.objects.Cgg_res_deposito_garantia();
		obj.setCRDPT_CODIGO(inCrdpt_codigo);
		obj.setCRCPJ_CODIGO(inCrcpj_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCGG_CRPJR_CODIGO(inCgg_crpjr_codigo);
		obj.setCRDPT_NUMERO(inCrdpt_numero);
		obj.setCRDPT_NUMERO_DOCUMENTO(inCrdpt_numero_documento);
		obj.setCRDPT_CADUCA(inCrdpt_caduca);
		obj.setCRDPT_TIPO(inCrdpt_tipo);
		obj.setCRDPT_VALOR_DEPOSITO(inCrdpt_valor_deposito);
		obj.setCRDPT_FECHA_DEPOSITO(inCrdpt_fecha_deposito);
		obj.setCRDPT_FECHA_ENTREGA(inCrdpt_fecha_entrega);
		obj.setCRDPT_FECHA_CADUCIDAD(inCrdpt_fecha_caducidad);
		obj.setCRDPT_FECHA_CONTABILIZACION(inCrdpt_fecha_contabilizacion);
		obj.setCRDPT_FECHA_SOLIC_DEVOLUCION(inCrdpt_fecha_solic_devolucion);
		obj.setCRDPT_FECHA_DEVOLUCION_DEFINITI(inCrdpt_fecha_devolucion_definiti);
		obj.setCRDPT_DEVUELTO(inCrdpt_devuelto);
		obj.setCRDPT_ESTADO_DEPOSITO(inCrdpt_estado_deposito);
		obj.setCRDPT_OBSERVACION(inCrdpt_observacion);
		obj.setCRDPT_ESTADO(true);
		obj.setCRDPT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_deposito_garantia(obj).update(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(res).toString();
	}


	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_deposito_garantia EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrdpt_codigo IDENTIFICACION DEL DEPOSITO GARANTIA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrdpt_codigo")String inCrdpt_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_deposito_garantia tmpObj = new com.besixplus.sii.objects.Cgg_res_deposito_garantia();
		tmpObj.setCRDPT_CODIGO(inCrdpt_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_deposito_garantia(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_deposito_garantia>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_deposito_garantia.
	 * @param inCrdpt_codigo CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrdpt_codigo")String inCrdpt_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_deposito_garantia tmpObj = new com.besixplus.sii.objects.Cgg_res_deposito_garantia();
		tmpObj.setCRDPT_CODIGO(inCrdpt_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_deposito_garantia(tmpObj).delete(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}

	/**
	 * VERIFICA SI SE AUTORIZA LA DEVOLUCION DE UNA GARANTIA DE UN TRAMITE 
	 * @param inCrtra_codigo CODIGO DEL TRAMITE
	 * @param inTodo SI SE REALIZA LA DEVOLUCION TOTAL DE LA GARANTIA
	 * @param inVerificar VERIFICACION DE LA DEVOLUCION.
	 * @param format FORMATO DE SALIDA DE LA INFORMACION JSON o XML
	 * @return <code>true</code> AUTORIZADO
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectDevolucionGarantia(
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
			@WebParam(name="inTodo")boolean inTodo,
			@WebParam(name="inVerificar")boolean inVerificar,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			ArrayList<String> tmpArray = new com.besixplus.sii.db.Cgg_res_deposito_garantia().selectDevolucionGarantia(con, tmpRequest.getUserPrincipal().getName(), inCrtra_codigo, inTodo, inVerificar);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return tmpFormat.getData().toString();
	}
	
	/**
	 * ACTUALIZA UN REGISTRO DE DEPOSITO DE GARANTIA COMO DEVUELTO  
	 * @param inCrdpt_codigo CODIGO DE DEPOSITO DE GARANTIA
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE TRAMITE.
	 * @return COLECCION DE INFORMACION.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String updateDevolucionGarantia(
			@WebParam(name="inCrdpt_codigo")String inCrdpt_codigo,
			@WebParam(name="inCrtra_codigo")String inCrtra_codigo
			) throws SOAPException{
		String outRes = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		Connection con = ManagerConnection.getConnection();
		try {
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();			
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			com.besixplus.sii.objects.Cgg_res_tramite_garantia tmpObj = new com.besixplus.sii.objects.Cgg_res_tramite_garantia();
			tmpObj.setCRDPT_CODIGO(inCrdpt_codigo);
			tmpObj.setCRTRA_CODIGO(inCrtra_codigo);
			outRes = new com.besixplus.sii.db.Cgg_res_tramite_garantia(tmpObj).updateDevolucionGarantia(con, tmpRequest.getUserPrincipal().getName());
			con.close();
			if(!outRes.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(outRes, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return outRes;
	}
}