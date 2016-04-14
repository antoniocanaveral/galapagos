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

import com.besixplus.sii.db.Cgg_extras;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;

/**
* CLASE Cgg_res_carnet
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_carnet POR MEDIO DE SERVICIOS WEB.
*
* @autor BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_carnet implements Serializable{

	private static final long serialVersionUID = 717062381;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_carnet.
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO.
	* @param inCradj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO.
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESIDENCIA.
	* @param inCrcpj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA EN LA QUE SE REALIZO EL DEPOSITO.
	* @param inCrcnt_serie CODIGO IDENTIFICATIVO DE SEGUIMIENTO DE ESPECIE.
	* @param inCrcnt_motivo MOTIVO POR LA QUE SE EMITIO UNA NUEVA ESPECIE.
0 - NUEVO
1 - RENOVACION
2 - DETERIORO
3 - PERDIDA.
	* @param inCrcnt_fecha_emision FECHA DE EMISION DEL CARNET.
	* @param inCrcnt_fecha_aprobacion FECHA DE APROBACION DE LA RESIDENCIA O RENOVACION.
	* @param inCrcnt_fecha_caducidad FECHA DE CADUCIDAD DE LA ESPECIE.
	* @param inCrcnt_fecha_deposito FECHA DE REALIZACION DE DEPOSITO POR EL VALOR DE LA ESPECIE.
	* @param inCrcnt_carnet_impreso SI EL CARNET YA FUE IMPRESO.
	* @param inCrcnt_numero_comp NUMERO O SERIE DEL COMPROBANTE DE DEPOSITO.
	* @param inCrcnt_valor VALOR DEPOSITADO.
	* @param inCrcnt_observacion INFORMACION ADICIONAL.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCrcom_codigo")String inCrcom_codigo,
		@WebParam(name="inCradj_codigo")String inCradj_codigo,
		@WebParam(name="inCrrsd_codigo")String inCrrsd_codigo,
		@WebParam(name="inCrcpj_codigo")String inCrcpj_codigo,
		@WebParam(name="inCrcnt_serie")String inCrcnt_serie,
		@WebParam(name="inCrcnt_motivo")int inCrcnt_motivo,
		@WebParam(name="inCrcnt_fecha_emision")java.util.Date inCrcnt_fecha_emision,
		@WebParam(name="inCrcnt_fecha_aprobacion")java.util.Date inCrcnt_fecha_aprobacion,
		@WebParam(name="inCrcnt_fecha_caducidad")java.util.Date inCrcnt_fecha_caducidad,
		@WebParam(name="inCrcnt_fecha_deposito")java.util.Date inCrcnt_fecha_deposito,
		@WebParam(name="inCrcnt_carnet_impreso")boolean inCrcnt_carnet_impreso,
		@WebParam(name="inCrcnt_numero_comp")String inCrcnt_numero_comp,
		@WebParam(name="inCrcnt_valor")java.math.BigDecimal inCrcnt_valor,
		@WebParam(name="inCrcnt_observacion")String inCrcnt_observacion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_carnet obj = new com.besixplus.sii.objects.Cgg_res_carnet();
		obj.setCRCNT_CODIGO("KEYGEN");
		obj.setCRCOM_CODIGO(inCrcom_codigo);
		obj.setCRADJ_CODIGO(inCradj_codigo);
		obj.setCRRSD_CODIGO(inCrrsd_codigo);
		obj.setCRCPJ_CODIGO(inCrcpj_codigo);
		obj.setCRCNT_SERIE(inCrcnt_serie);
		obj.setCRCNT_MOTIVO(inCrcnt_motivo);
		obj.setCRCNT_FECHA_EMISION(inCrcnt_fecha_emision);
		obj.setCRCNT_FECHA_APROBACION(inCrcnt_fecha_aprobacion);
		obj.setCRCNT_FECHA_CADUCIDAD(inCrcnt_fecha_caducidad);
		obj.setCRCNT_FECHA_DEPOSITO(inCrcnt_fecha_deposito);
		obj.setCRCNT_CARNET_IMPRESO(inCrcnt_carnet_impreso);
		obj.setCRCNT_NUMERO_COMP(inCrcnt_numero_comp);
		obj.setCRCNT_VALOR(inCrcnt_valor);
		obj.setCRCNT_OBSERVACION(inCrcnt_observacion);
		obj.setCRCNT_ESTADO(true);
		obj.setCRCNT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRCNT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_carnet(obj).insert(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_carnet EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_carnet.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_carnet EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	* @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	* @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	* @param keyword CRITERIO DE BUSQUEDA.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE RESIDENCIA.
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
		@WebParam(name="inCrrsd_codigo")String inCrrsd_codigo
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
			tmpCount = com.besixplus.sii.db.Cgg_res_carnet.selectCount(con, keyword, inCrrsd_codigo);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_carnet.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inCrrsd_codigo);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_carnet.
	* @param inCrcnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	* @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
	* @param inCradj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESIDENCIA
	* @param inCrcpj_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA EN LA QUE SE REALIZO EL DEPOSITO
	* @param inCrcnt_serie CODIGO IDENTIFICATIVO DE SEGUIMIENTO DE ESPECIE
	* @param inCrcnt_motivo MOTIVO POR LA QUE SE EMITIO UNA NUEVA ESPECIE.
0 - NUEVO
1 - RENOVACION
2 - DETERIORO
3 - PERDIDA
	* @param inCrcnt_fecha_emision FECHA DE EMISION DEL CARNET
	* @param inCrcnt_fecha_aprobacion FECHA DE APROBACION DE LA RESIDENCIA O RENOVACION
	* @param inCrcnt_fecha_caducidad FECHA DE CADUCIDAD DE LA ESPECIE
	* @param inCrcnt_fecha_deposito FECHA DE REALIZACION DE DEPOSITO POR EL VALOR DE LA ESPECIE
	* @param inCrcnt_carnet_impreso SI EL CARNET YA FUE IMPRESO
	* @param inCrcnt_numero_comp NUMERO O SERIE DEL COMPROBANTE DE DEPOSITO
	* @param inCrcnt_valor VALOR DEPOSITADO
	* @param inCrcnt_observacion INFORMACION ADICIONAL
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCrcnt_codigo")String inCrcnt_codigo,
		@WebParam(name="inCrcom_codigo")String inCrcom_codigo,
		@WebParam(name="inCradj_codigo")String inCradj_codigo,
		@WebParam(name="inCrrsd_codigo")String inCrrsd_codigo,
		@WebParam(name="inCrcpj_codigo")String inCrcpj_codigo,
		@WebParam(name="inCrcnt_serie")String inCrcnt_serie,
		@WebParam(name="inCrcnt_motivo")int inCrcnt_motivo,
		@WebParam(name="inCrcnt_fecha_emision")java.util.Date inCrcnt_fecha_emision,
		@WebParam(name="inCrcnt_fecha_aprobacion")java.util.Date inCrcnt_fecha_aprobacion,
		@WebParam(name="inCrcnt_fecha_caducidad")java.util.Date inCrcnt_fecha_caducidad,
		@WebParam(name="inCrcnt_fecha_deposito")java.util.Date inCrcnt_fecha_deposito,
		@WebParam(name="inCrcnt_carnet_impreso")boolean inCrcnt_carnet_impreso,
		@WebParam(name="inCrcnt_numero_comp")String inCrcnt_numero_comp,
		@WebParam(name="inCrcnt_valor")java.math.BigDecimal inCrcnt_valor,
		@WebParam(name="inCrcnt_observacion")String inCrcnt_observacion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_carnet obj = new com.besixplus.sii.objects.Cgg_res_carnet();
		obj.setCRCNT_CODIGO(inCrcnt_codigo);
		obj.setCRCOM_CODIGO(inCrcom_codigo);
		obj.setCRADJ_CODIGO(inCradj_codigo);
		obj.setCRRSD_CODIGO(inCrrsd_codigo);
		obj.setCRCPJ_CODIGO(inCrcpj_codigo);
		obj.setCRCNT_SERIE(inCrcnt_serie);
		obj.setCRCNT_MOTIVO(inCrcnt_motivo);
		obj.setCRCNT_FECHA_EMISION(inCrcnt_fecha_emision);
		obj.setCRCNT_FECHA_APROBACION(inCrcnt_fecha_aprobacion);
		obj.setCRCNT_FECHA_CADUCIDAD(inCrcnt_fecha_caducidad);
		obj.setCRCNT_FECHA_DEPOSITO(inCrcnt_fecha_deposito);
		obj.setCRCNT_CARNET_IMPRESO(inCrcnt_carnet_impreso);
		obj.setCRCNT_NUMERO_COMP(inCrcnt_numero_comp);
		obj.setCRCNT_VALOR(inCrcnt_valor);
		obj.setCRCNT_OBSERVACION(inCrcnt_observacion);
		obj.setCRCNT_ESTADO(true);
		obj.setCRCNT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_carnet(obj).update(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}


	/**
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_carnet EN UNA ESTRUCTURA JSON o XML.
	* @param inCrcnt_codigo IDENTIFICATIVO UNICO DE CARNET.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCrcnt_codigo")String inCrcnt_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_carnet tmpObj = new com.besixplus.sii.objects.Cgg_res_carnet();
		tmpObj.setCRCNT_CODIGO(inCrcnt_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_carnet(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_carnet> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_carnet>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_res_carnet.
	* @param inCrcnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException  
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCrcnt_codigo")String inCrcnt_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_carnet tmpObj = new com.besixplus.sii.objects.Cgg_res_carnet();
		tmpObj.setCRCNT_CODIGO(inCrcnt_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_carnet(tmpObj).delete(con);
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
	 * SELECCIONA LA RESIDENCIA VIGENTE DE UNA PERSONA.
	 * @param inCrper_codigo CODIGO DE LA PERSONA
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return COLECCION DE INFORMACION.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectResidencia(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		HashMap<String, Object> tmpResidencia = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			tmpResidencia = new Cgg_extras().selectResidencia(con, inCrper_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpResidencia);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpResidencia != null)
			return tmpFormat.getData().toString();
		return null;
	}
	
	/**
	 * SELECCIONA EL ULTIMO CARNET DE UNA PERSONA.
	 * @param inCrrsd_codigo IDENTIFICATIVO UNICO DE RESIDENCIA.
	 * @param inCrper_codigo CODIGO DE LA PERSONA
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return COLECCION DE INFORMACION.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectCarnet(
			@WebParam(name="inCrrsd_codigo")String inCrrsd_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.objects.Cgg_res_carnet tmpCarnet = null; 
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			tmpCarnet = new Cgg_extras().selectCarnet(con, inCrrsd_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpCarnet);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpCarnet != null)
			return tmpFormat.getData().toString();
		return null;
	}

}