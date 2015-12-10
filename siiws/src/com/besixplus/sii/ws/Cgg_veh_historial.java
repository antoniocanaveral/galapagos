package com.besixplus.sii.ws;

import java.io.Serializable;
import java.math.BigDecimal;
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

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;

/**
* CLASE Cgg_veh_historial
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_veh_historial POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_veh_historial implements Serializable{

	private static final long serialVersionUID = 391285751;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;
	@SuppressWarnings("unused")
	private int inCvvehTipo;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_veh_historial.
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO.
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA.
	* @param inCvhst_expulsado SI EL VEHICULO HA SIDO ENVIADO POR LA FUERZA DE LA PROVINCIA..
	* @param inCvhst_fecha_traspaso FECHA DE TRASPASO DEL VEHICULO.
	* @param inCvhst_propietario ESTADO QUE DETERMINA SI LA PERSONA ES EL PROPIETARIO ACTUAL DEL VEHICULO.
	* @param inCvhst_concepto JUSTIFICACION DE LA PERMANENCIA DEL VEHICULO.
	* @param inCvhst_tipo_permanencia DETERMINA EL TIPO DE PERMISO ASISTIDO PARA UN VEHICULO
	* 0 -  PERMANENTE
	* 1 - TEMPORAL.
	* @param inCvhst_fecha_ingreso FECHA DE INGRESO DEL VEHICULO A LA PROVINCIA.
	* @param inCvhst_fecha_salida FECHA DE SALIDA DEL VEHICULO.
	* @param inCvhst_tiempo_estadia TIEMPO DE ESTADIA (DIAS).
	* @param inCvhst_observaciones OBSERVACION DEL HISTORIAL DEL VEHICULO  - FORMATO JSON.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCvveh_codigo")String inCvveh_codigo,
		@WebParam(name="inCrper_codigo")String inCrper_codigo,
		@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
		@WebParam(name="inCvhst_expulsado")boolean inCvhst_expulsado,
		@WebParam(name="inCvhst_fecha_traspaso")java.util.Date inCvhst_fecha_traspaso,
		@WebParam(name="inCvhst_propietario")boolean inCvhst_propietario,
		@WebParam(name="inCvhst_concepto")String inCvhst_concepto,
		@WebParam(name="inCvhst_tipo_permanencia")int inCvhst_tipo_permanencia,
		@WebParam(name="inCvhst_fecha_ingreso")java.util.Date inCvhst_fecha_ingreso,
		@WebParam(name="inCvhst_fecha_salida")java.util.Date inCvhst_fecha_salida,
		@WebParam(name="inCvhst_tiempo_estadia")int inCvhst_tiempo_estadia,
		@WebParam(name="inCvhst_observaciones")String inCvhst_observaciones
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_historial obj = new com.besixplus.sii.objects.Cgg_veh_historial();
		obj.setCVHST_CODIGO("KEYGEN");
		obj.setCVVEH_CODIGO(inCvveh_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCVHST_EXPULSADO(inCvhst_expulsado);
		obj.setCVHST_FECHA_TRASPASO(inCvhst_fecha_traspaso);
		obj.setCVHST_PROPIETARIO(inCvhst_propietario);
		obj.setCVHST_CONCEPTO(inCvhst_concepto);
		obj.setCVHST_TIPO_PERMANENCIA(inCvhst_tipo_permanencia);
		obj.setCVHST_FECHA_INGRESO(inCvhst_fecha_ingreso);
		obj.setCVHST_FECHA_SALIDA(inCvhst_fecha_salida);
		obj.setCVHST_TIEMPO_ESTADIA(inCvhst_tiempo_estadia);
		obj.setCVHST_OBSERVACIONES(inCvhst_observaciones);
		obj.setCVHST_ESTADO(true);
		obj.setCVHST_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCVHST_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_veh_historial(obj).insert(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_historial EN UNA ESTRUCTRA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_veh_historial> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_veh_historial.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_veh_historial EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	* @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	* @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	* @param keyword CRITERIO DE BUSQUEDA.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO.
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
		@WebParam(name="inCvveh_codigo")String inCvveh_codigo
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
			tmpCount = com.besixplus.sii.db.Cgg_veh_historial.selectCount(con, keyword, inCvveh_codigo);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_veh_historial.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inCvveh_codigo);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_veh_historial.
	* @param inCvhst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
	* @param inCvhst_expulsado SI EL VEHICULO HA SIDO ENVIADO POR LA FUERZA DE LA PROVINCIA.
	* @param inCvhst_fecha_traspaso FECHA DE TRASPASO DEL VEHICULO
	* @param inCvhst_propietario ESTADO QUE DETERMINA SI LA PERSONA ES EL PROPIETARIO ACTUAL DEL VEHICULO
	* @param inCvhst_concepto JUSTIFICACION DE LA PERMANENCIA DEL VEHICULO
	* @param inCvhst_tipo_permanencia DETERMINA EL TIPO DE PERMISO ASISTIDO PARA UN VEHICULO
0 -  PERMANENTE
1 - TEMPORAL
	* @param inCvhst_fecha_ingreso FECHA DE INGRESO DEL VEHICULO A LA PROVINCIA
	* @param inCvhst_fecha_salida FECHA DE SALIDA DEL VEHICULO
	* @param inCvhst_tiempo_estadia TIEMPO DE ESTADIA (DIAS)
	* @param inCvhst_observaciones OBSERVACION DEL HISTORIAL DEL VEHICULO  - FORMATO JSON
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCvhst_codigo")String inCvhst_codigo,
		@WebParam(name="inCvveh_codigo")String inCvveh_codigo,
		@WebParam(name="inCrper_codigo")String inCrper_codigo,
		@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo,
		@WebParam(name="inCvhst_expulsado")boolean inCvhst_expulsado,
		@WebParam(name="inCvhst_fecha_traspaso")java.util.Date inCvhst_fecha_traspaso,
		@WebParam(name="inCvhst_propietario")boolean inCvhst_propietario,
		@WebParam(name="inCvhst_concepto")String inCvhst_concepto,
		@WebParam(name="inCvhst_tipo_permanencia")int inCvhst_tipo_permanencia,
		@WebParam(name="inCvhst_fecha_ingreso")java.util.Date inCvhst_fecha_ingreso,
		@WebParam(name="inCvhst_fecha_salida")java.util.Date inCvhst_fecha_salida,
		@WebParam(name="inCvhst_tiempo_estadia")int inCvhst_tiempo_estadia,
		@WebParam(name="inCvhst_observaciones")String inCvhst_observaciones
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_historial obj = new com.besixplus.sii.objects.Cgg_veh_historial();
		obj.setCVHST_CODIGO(inCvhst_codigo);
		obj.setCVVEH_CODIGO(inCvveh_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRPJR_CODIGO(inCrpjr_codigo);
		obj.setCVHST_EXPULSADO(inCvhst_expulsado);
		obj.setCVHST_FECHA_TRASPASO(inCvhst_fecha_traspaso);
		obj.setCVHST_PROPIETARIO(inCvhst_propietario);
		obj.setCVHST_CONCEPTO(inCvhst_concepto);
		obj.setCVHST_TIPO_PERMANENCIA(inCvhst_tipo_permanencia);
		obj.setCVHST_FECHA_INGRESO(inCvhst_fecha_ingreso);
		obj.setCVHST_FECHA_SALIDA(inCvhst_fecha_salida);
		obj.setCVHST_TIEMPO_ESTADIA(inCvhst_tiempo_estadia);
		obj.setCVHST_OBSERVACIONES(inCvhst_observaciones);
		obj.setCVHST_ESTADO(true);
		obj.setCVHST_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_veh_historial(obj).update(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}


	/**
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_veh_historial EN UNA ESTRUCTURA JSON o XML.
	* @param inCvhst_codigo cvhst_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCvhst_codigo")String inCvhst_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_historial tmpObj = new com.besixplus.sii.objects.Cgg_veh_historial();
		tmpObj.setCVHST_CODIGO(inCvhst_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_veh_historial(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_veh_historial> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_veh_historial>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_veh_historial.
	* @param inCvhst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE HISTORIAL DE VEHICULO
	* @return String <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCvhst_codigo")String inCvhst_codigo
	) throws SOAPException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_historial tmpObj = new com.besixplus.sii.objects.Cgg_veh_historial();
		tmpObj.setCVHST_CODIGO(inCvhst_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_veh_historial(tmpObj).delete(con);
			con.close();
			if(outResult.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(outResult, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return outResult;
	}
	
	/**
	 * OBTIENE EL VEHICULO ACTUAL DE UNA PERSONA
	 * @param inCrper_codigo CODIGO DE LA PERSONA
	 * @param inCvveh_tipo TIPO DE VEHICULO
		0 - TERRESTRE
		1 - MARITIMO
		2 - AEREO
	 * @param format 
	 * @return INFORMACION DEL VEHICULO
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectVehiculo(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCvveh_tipo")int inCvveh_tipo,
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
			obj = new com.besixplus.sii.db.Cgg_veh_historial().selectVehiculo(con, inCrper_codigo, inCvveh_tipo);
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
	 * OBTIENE EL VEHICULO ACTUAL DE UNA PERSONA
	 * @param inCrper_codigo CODIGO DE LA PERSONA
	 * @param inCvveh_tipo TIPO DE VEHICULO
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return INFORMACION DEL VEHICULO
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAllVehiculo(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCvveh_tipo")int inCvveh_tipo,
			@WebParam(name="format")String format
	) throws SOAPException{
		
		inCvvehTipo = inCvveh_tipo;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		int tmpCount = 0;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = new com.besixplus.sii.db.Cgg_veh_historial().selectVehiculo(con, inCrper_codigo, inCvveh_tipo);
			tmpCount = obj.size();
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
		return null;
	}
	
	/**
	 * Obtiene un listado de vehiculos libres que no tienen duenios creado para legalizar el censo de vehiculos.
	 * @param inCrper_codigo CODIGO DE LA PERSONA
	 * @param inCvveh_tipo TIPO DE VEHICULO
		0 - TERRESTRE
		1 - MARITIMO
		2 - AEREO
	 * @param format 
	 * @return INFORMACION DEL VEHICULO
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectVehiculoLibre(											
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCvveh_tipo")int inCvveh_tipo								
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
			tmpCount = new com.besixplus.sii.db.Cgg_veh_historial().selectVehiculoLibreCount(con,keyword,inCvveh_tipo);
			con.setAutoCommit(false);			
			obj = new com.besixplus.sii.db.Cgg_veh_historial().selectVehiculoLibre(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inCvveh_tipo);
			
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
		return null;
	}
}