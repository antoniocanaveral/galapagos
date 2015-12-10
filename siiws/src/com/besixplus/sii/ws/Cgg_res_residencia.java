package com.besixplus.sii.ws;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

import com.besixplus.sii.db.ManagerConnection;

/**
* CLASE Cgg_res_residencia
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_residencia POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_residencia implements Serializable{

	private static final long serialVersionUID = 103658688;

	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_residencia.
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO DE SOLICITUD DE RESIDENCIA.
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE.
	* @param inCgg_crtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE DE LA REVOCATORIA DE LA RESIDENCIA.
	* @param inCrrsd_numero NUMERO DE RESIDENCIA.
	* @param inCrrsd_modalidad ESTADO MIGRATORIO AUTORIZADO PARA LA PERSONA
0 - PERMANENTE
1 - TEMPORAL.
	* @param inCrrsd_fecha_inicio FECHA DE INICIO DEL PERMISO DE PERMANENCIA.
	* @param inCrrsd_fecha_caducidad FECHA DE CADUCIDAD DEL PERMISO DE PERMANENCIA.
	* @param inCrrsd_revocada SI LA RESIDENCIA ESTA REVOCADA.
	* @param inCrrsd_fecha_revocatoria FECHA DE REVOCATORIA DEL PERMISO DE RESIDENCIA.
	* @param inCrrsd_motivo_revocatoria DESCRIPCION DEL MOTIVO QUE GENERO UNA REVOCATORIA DE PERMISO DE RESIDENCIA.
	* @param inCrrsd_vigente DETERMINA EL ESTADO ACTIVO DE LA RESIDENCIA.
	* @param inCrrsd_tramite_pendiente ESTADO QUE DETERMINA SI LA RESIDENCIA AUN TIENE UN TRAMITE POR CONCLUIR
SI
NO.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCrper_codigo")String inCrper_codigo,
		@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
		@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
		@WebParam(name="inCgg_crtra_codigo")String inCgg_crtra_codigo,
		@WebParam(name="inCrrsd_numero")int inCrrsd_numero,
		@WebParam(name="inCrrsd_modalidad")int inCrrsd_modalidad,
		@WebParam(name="inCrrsd_fecha_inicio")java.util.Date inCrrsd_fecha_inicio,
		@WebParam(name="inCrrsd_fecha_caducidad")java.util.Date inCrrsd_fecha_caducidad,
		@WebParam(name="inCrrsd_revocada")boolean inCrrsd_revocada,
		@WebParam(name="inCrrsd_fecha_revocatoria")java.util.Date inCrrsd_fecha_revocatoria,
		@WebParam(name="inCrrsd_motivo_revocatoria")String inCrrsd_motivo_revocatoria,
		@WebParam(name="inCrrsd_vigente")boolean inCrrsd_vigente,
		@WebParam(name="inCrrsd_tramite_pendiente")boolean inCrrsd_tramite_pendiente
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_residencia obj = new com.besixplus.sii.objects.Cgg_res_residencia();
		obj.setCRRSD_CODIGO("KEYGEN");
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRTST_CODIGO(inCrtst_codigo);
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCGG_CRTRA_CODIGO(inCgg_crtra_codigo);
		obj.setCRRSD_NUMERO(inCrrsd_numero);
		obj.setCRRSD_MODALIDAD(inCrrsd_modalidad);
		obj.setCRRSD_FECHA_INICIO(inCrrsd_fecha_inicio);
		obj.setCRRSD_FECHA_CADUCIDAD(inCrrsd_fecha_caducidad);
		obj.setCRRSD_REVOCADA(inCrrsd_revocada);
		obj.setCRRSD_FECHA_REVOCATORIA(inCrrsd_fecha_revocatoria);
		obj.setCRRSD_MOTIVO_REVOCATORIA(inCrrsd_motivo_revocatoria);
		obj.setCRRSD_VIGENTE(inCrrsd_vigente);
		obj.setCRRSD_TRAMITE_PENDIENTE(inCrrsd_tramite_pendiente);
		obj.setCRRSD_ESTADO(true);
		obj.setCRRSD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRRSD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_residencia(obj).insert(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_residencia EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_residencia.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_residencia EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_residencia.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_residencia.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_residencia EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_residencia.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_residencia.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_residencia.
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO DE SOLICITUD DE RESIDENCIA
	* @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	* @param inCgg_crtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE DE LA REVOCATORIA DE LA RESIDENCIA
	* @param inCrrsd_numero NUMERO DE RESIDENCIA
	* @param inCrrsd_modalidad ESTADO MIGRATORIO AUTORIZADO PARA LA PERSONA
0 - PERMANENTE
1 - TEMPORAL
	* @param inCrrsd_fecha_inicio FECHA DE INICIO DEL PERMISO DE PERMANENCIA
	* @param inCrrsd_fecha_caducidad FECHA DE CADUCIDAD DEL PERMISO DE PERMANENCIA
	* @param inCrrsd_revocada SI LA RESIDENCIA ESTA REVOCADA
	* @param inCrrsd_fecha_revocatoria FECHA DE REVOCATORIA DEL PERMISO DE RESIDENCIA
	* @param inCrrsd_motivo_revocatoria DESCRIPCION DEL MOTIVO QUE GENERO UNA REVOCATORIA DE PERMISO DE RESIDENCIA
	* @param inCrrsd_vigente DETERMINA EL ESTADO ACTIVO DE LA RESIDENCIA
	* @param inCrrsd_tramite_pendiente ESTADO QUE DETERMINA SI LA RESIDENCIA AUN TIENE UN TRAMITE POR CONCLUIR
SI
NO
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCrrsd_codigo")String inCrrsd_codigo,
		@WebParam(name="inCrper_codigo")String inCrper_codigo,
		@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
		@WebParam(name="inCrtra_codigo")String inCrtra_codigo,
		@WebParam(name="inCgg_crtra_codigo")String inCgg_crtra_codigo,
		@WebParam(name="inCrrsd_numero")int inCrrsd_numero,
		@WebParam(name="inCrrsd_modalidad")int inCrrsd_modalidad,
		@WebParam(name="inCrrsd_fecha_inicio")java.util.Date inCrrsd_fecha_inicio,
		@WebParam(name="inCrrsd_fecha_caducidad")java.util.Date inCrrsd_fecha_caducidad,
		@WebParam(name="inCrrsd_revocada")boolean inCrrsd_revocada,
		@WebParam(name="inCrrsd_fecha_revocatoria")java.util.Date inCrrsd_fecha_revocatoria,
		@WebParam(name="inCrrsd_motivo_revocatoria")String inCrrsd_motivo_revocatoria,
		@WebParam(name="inCrrsd_vigente")boolean inCrrsd_vigente,
		@WebParam(name="inCrrsd_tramite_pendiente")boolean inCrrsd_tramite_pendiente
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_residencia obj = new com.besixplus.sii.objects.Cgg_res_residencia();
		obj.setCRRSD_CODIGO(inCrrsd_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRTST_CODIGO(inCrtst_codigo);
		obj.setCRTRA_CODIGO(inCrtra_codigo);
		obj.setCGG_CRTRA_CODIGO(inCgg_crtra_codigo);
		obj.setCRRSD_NUMERO(inCrrsd_numero);
		obj.setCRRSD_MODALIDAD(inCrrsd_modalidad);
		obj.setCRRSD_FECHA_INICIO(inCrrsd_fecha_inicio);
		obj.setCRRSD_FECHA_CADUCIDAD(inCrrsd_fecha_caducidad);
		obj.setCRRSD_REVOCADA(inCrrsd_revocada);
		obj.setCRRSD_FECHA_REVOCATORIA(inCrrsd_fecha_revocatoria);
		obj.setCRRSD_MOTIVO_REVOCATORIA(inCrrsd_motivo_revocatoria);
		obj.setCRRSD_VIGENTE(inCrrsd_vigente);
		obj.setCRRSD_TRAMITE_PENDIENTE(inCrrsd_tramite_pendiente);
		obj.setCRRSD_ESTADO(true);
		obj.setCRRSD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_residencia(obj).update(con);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_residencia EN UNA ESTRUCTURA JSON o XML.
	* @param inCrrsd_codigo crrsd_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCrrsd_codigo")String inCrrsd_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_residencia tmpObj = new com.besixplus.sii.objects.Cgg_res_residencia();
		tmpObj.setCRRSD_CODIGO(inCrrsd_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_residencia(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_residencia> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_residencia>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_res_residencia.
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCrrsd_codigo")String inCrrsd_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_residencia tmpObj = new com.besixplus.sii.objects.Cgg_res_residencia();
		tmpObj.setCRRSD_CODIGO(inCrrsd_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_residencia(tmpObj).delete(con);
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
	 * Devuelve una cadena de datos con informacion de los residentes transeunte con su tramite. 
	 * @param start Indice de inicio de la consulta.
	 * @param limit Limite de registros de la consulta.
	 * @param sort Campo de ordenamiento. 
	 * @param dir Direccion del ordenamiento.
	 * @param keyword Criterio de busqueda.
	 * @param format Formato de salida.
	 * @return Cadena de datos en formato especificado.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectTranseunteDirect(
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
		BigDecimal tmpCount;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_residencia.selectTranseunteCount(con, keyword);
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_res_residencia.selectTranseunteDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* VERIFICA QUE EXISTA UN TRAMITE DE TRANSEUNTE AUTORIZADO PARA EL USUARIO ACTUAL..
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectResidenciaTranseunteTramite(
		@WebParam(name="format")String format
	) throws SOAPException
	{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_residencia.selectResidenciaTranseunteTramite(con, tmpRequest.getUserPrincipal().getName());
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
		if (outCadena != null)
			return outCadena.toString();
		return null;
	}


	/**
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_residencia.
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @param inCrrsd_fecha_inicio FECHA DE INICIO DEL PERMISO DE PERMANENCIA
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String updateFechaInicio(
		@WebParam(name="inCrrsd_codigo")String inCrrsd_codigo,
		@WebParam(name="inCrrsd_fecha_inicio")java.util.Date inCrrsd_fecha_inicio	
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_residencia obj = new com.besixplus.sii.objects.Cgg_res_residencia();
		obj.setCRRSD_CODIGO(inCrrsd_codigo);
		obj.setCRRSD_FECHA_INICIO(inCrrsd_fecha_inicio);
		obj.setCRRSD_ESTADO(true);
		obj.setCRRSD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_residencia(obj).updateFechaInicio(con);
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_res_residencia.
	* @param inCrrsd_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE RESIDENCIA
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	public String selectExportable(
		int inTipoResidencia
	) {
		String outResult = null;				
		try{
			Connection con = ManagerConnection.getConnection();			
			outResult = new com.besixplus.sii.db.Cgg_res_residencia().selectExportable(con,inTipoResidencia);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);			
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);			
		}
		return outResult;
	}
}