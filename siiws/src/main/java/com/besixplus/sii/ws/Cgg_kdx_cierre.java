package com.besixplus.sii.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.soap.SOAPFaultException;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.objects.ServerResponse;

/**
 * CLASE Cgg_kdx_cierre
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_cierre POR MEDIO DE SERVICIOS WEB.
 *
 * @autor BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_kdx_cierre implements Serializable{

	private static final long serialVersionUID = 1937217366;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_cierre.
	 * @param inCkpvt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA.
	 * @param inCkvnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VENTA.
	 * @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA.
	 * @param inCkcrr_fecha_cierre FECHA DE REALIZACION DEL CIERRE.
	 * @param inCkcrr_numero_cierre NUMERO SECUENCIAL IDENTIFICATIVO.
	 * @param inCkcrr_total_venta VALOR TOTAL REGISTRADO EN LA VENTA.
	 * @param inCkcrr_total VALOR TOTAL CONTABILIZADO EN EL CIERRE.
	 * @param inCkcrr_observacion INFORMACION ADICIONAL.
	 * @param inCkcrr_diferencia VALOR DE DIFERENCIA.
	 * @param inCkcrr_estado_cierre ESTADO DEL REGISTRO DE CIERRE PARA CONTROL DE INFORMACION
0.- REGISTRADA
1.- CONFIRMADA.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCkpvt_codigo")String inCkpvt_codigo,
			@WebParam(name="inCkupv_codigo")String inCkupv_codigo,
			@WebParam(name="inCkcrr_fecha_cierre")java.util.Date inCkcrr_fecha_cierre,
			@WebParam(name="inCkcrr_numero_cierre")String inCkcrr_numero_cierre,
			@WebParam(name="inCkcrr_total_venta")java.math.BigDecimal inCkcrr_total_venta,
			@WebParam(name="inCkcrr_total")java.math.BigDecimal inCkcrr_total,
			@WebParam(name="inCkcrr_observacion")String inCkcrr_observacion,
			@WebParam(name="inCkcrr_diferencia")java.math.BigDecimal inCkcrr_diferencia,
			@WebParam(name="inCkcrr_estado_cierre")int inCkcrr_estado_cierre
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_cierre obj = new com.besixplus.sii.objects.Cgg_kdx_cierre();
		obj.setCKCRR_CODIGO("KEYGEN");
		obj.setCKPVT_CODIGO(inCkpvt_codigo);
		obj.setCKUPV_CODIGO(inCkupv_codigo);
		obj.setCKCRR_FECHA_CIERRE(inCkcrr_fecha_cierre);
		obj.setCKCRR_NUMERO_CIERRE(inCkcrr_numero_cierre);
		obj.setCKCRR_TOTAL_VENTA(inCkcrr_total_venta);
		obj.setCKCRR_TOTAL(inCkcrr_total);
		obj.setCKCRR_OBSERVACION(inCkcrr_observacion);
		obj.setCKCRR_DIFERENCIA(inCkcrr_diferencia);
		obj.setCKCRR_ESTADO_CIERRE(inCkcrr_estado_cierre);
		obj.setCKCRR_ESTADO(true);
		obj.setCKCRR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCKCRR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_kdx_cierre(obj).insert(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_cierre EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_cierre.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_cierre EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_kdx_cierre.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_cierre.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_cierre EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
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
			tmpCount = com.besixplus.sii.db.Cgg_kdx_cierre.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_cierre.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_kdx_cierre.
	 * @param inCkcrr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
	 * @param inCkpvt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA
	 * @param inCkvnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VENTA
	 * @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	 * @param inCkcrr_fecha_cierre FECHA DE REALIZACION DEL CIERRE
	 * @param inCkcrr_numero_cierre NUMERO SECUENCIAL IDENTIFICATIVO
	 * @param inCkcrr_total_venta VALOR TOTAL REGISTRADO EN LA VENTA
	 * @param inCkcrr_total VALOR TOTAL CONTABILIZADO EN EL CIERRE
	 * @param inCkcrr_observacion INFORMACION ADICIONAL
	 * @param inCkcrr_diferencia VALOR DE DIFERENCIA
	 * @param inCkcrr_estado_cierre ESTADO DEL REGISTRO DE CIERRE PARA CONTROL DE INFORMACION
0.- REGISTRADA
1.- CONFIRMADA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCkcrr_codigo")String inCkcrr_codigo,
			@WebParam(name="inCkpvt_codigo")String inCkpvt_codigo,
		
			@WebParam(name="inCkupv_codigo")String inCkupv_codigo,
			@WebParam(name="inCkcrr_fecha_cierre")java.util.Date inCkcrr_fecha_cierre,
			@WebParam(name="inCkcrr_numero_cierre")String inCkcrr_numero_cierre,
			@WebParam(name="inCkcrr_total_venta")java.math.BigDecimal inCkcrr_total_venta,
			@WebParam(name="inCkcrr_total")java.math.BigDecimal inCkcrr_total,
			@WebParam(name="inCkcrr_observacion")String inCkcrr_observacion,
			@WebParam(name="inCkcrr_diferencia")java.math.BigDecimal inCkcrr_diferencia,
			@WebParam(name="inCkcrr_estado_cierre")int inCkcrr_estado_cierre
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_cierre obj = new com.besixplus.sii.objects.Cgg_kdx_cierre();
		obj.setCKCRR_CODIGO(inCkcrr_codigo);
		obj.setCKPVT_CODIGO(inCkpvt_codigo);
		obj.setCKUPV_CODIGO(inCkupv_codigo);
		obj.setCKCRR_FECHA_CIERRE(inCkcrr_fecha_cierre);
		obj.setCKCRR_NUMERO_CIERRE(inCkcrr_numero_cierre);
		obj.setCKCRR_TOTAL_VENTA(inCkcrr_total_venta);
		obj.setCKCRR_TOTAL(inCkcrr_total);
		obj.setCKCRR_OBSERVACION(inCkcrr_observacion);
		obj.setCKCRR_DIFERENCIA(inCkcrr_diferencia);
		obj.setCKCRR_ESTADO_CIERRE(inCkcrr_estado_cierre);
		obj.setCKCRR_ESTADO(true);
		obj.setCKCRR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_kdx_cierre(obj).update(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_kdx_cierre EN UNA ESTRUCTURA JSON o XML.
	 * @param inCkcrr_codigo ckcrr_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @throws SOAPException 
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCkcrr_codigo")String inCkcrr_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_cierre tmpObj = new com.besixplus.sii.objects.Cgg_kdx_cierre();
		tmpObj.setCKCRR_CODIGO(inCkcrr_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_kdx_cierre(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_cierre>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_kdx_cierre.
	 * @param inCkcrr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CIERRE DE CAJA
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCkcrr_codigo")String inCkcrr_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_cierre tmpObj = new com.besixplus.sii.objects.Cgg_kdx_cierre();
		tmpObj.setCKCRR_CODIGO(inCkcrr_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_kdx_cierre(tmpObj).delete(con);
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
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_cierre.
	 * @param inCkpvt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PUNTO DE VENTA.
	 * @param inCkvnt_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VENTA.
	 * @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA.
	 * @param inCkcrr_fecha_cierre FECHA DE REALIZACION DEL CIERRE.
	 * @param inCkcrr_numero_cierre NUMERO SECUENCIAL IDENTIFICATIVO.
	 * @param inCkcrr_total_venta VALOR TOTAL REGISTRADO EN LA VENTA.
	 * @param inCkcrr_total VALOR TOTAL CONTABILIZADO EN EL CIERRE.
	 * @param inCkcrr_observacion INFORMACION ADICIONAL.
	 * @param inCkcrr_diferencia VALOR DE DIFERENCIA.
	 * @param inCkcrr_estado_cierre ESTADO DEL REGISTRO DE CIERRE PARA CONTROL DE INFORMACION
0.- REGISTRADA
1.- CONFIRMADA.
	 * @param inCierreDetalle_JSON CADENA JSON QUE IDENTIFICA A CIERRE DETALLE
	 * @param inVentaCierre_JSON CADENA JSON QUE IDENTIFICA A VENTA CIERRE.

	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert1(
			@WebParam(name="inCkpvt_codigo")String inCkpvt_codigo,
			@WebParam(name="inCkupv_codigo")String inCkupv_codigo,
			@WebParam(name="inCkcrr_fecha_cierre")java.util.Date inCkcrr_fecha_cierre,
			@WebParam(name="inCkcrr_numero_cierre")String inCkcrr_numero_cierre,
			@WebParam(name="inCkcrr_total_venta")java.math.BigDecimal inCkcrr_total_venta,
			@WebParam(name="inCkcrr_total")java.math.BigDecimal inCkcrr_total,
			@WebParam(name="inCkcrr_observacion")String inCkcrr_observacion,
			@WebParam(name="inCkcrr_diferencia")java.math.BigDecimal inCkcrr_diferencia,
			@WebParam(name="inCkcrr_estado_cierre")int inCkcrr_estado_cierre,
			@WebParam(name="inCierreDetalle_JSON")String inCierreDetalle_JSON,
			@WebParam(name="inVentaCierre_JSON")String inVentaCierre_JSON
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_cierre obj = new com.besixplus.sii.objects.Cgg_kdx_cierre();
		com.besixplus.sii.objects.Cgg_kdx_cierre_detalle objCierreDetalle = null;
		com.besixplus.sii.objects.Cgg_kdx_venta_cierre objVentaCierre = null;
		ServerResponse appResponser = new ServerResponse(false, "", null);
		org.json.JSONArray arrayJSON = null;
		org.json.JSONArray arrayVentaCierreJSON = null;
		JSONObject objJSON =  null;
		JSONObject objVentaCierreJSON =  null;
		obj.setCKCRR_CODIGO("KEYGEN");
		obj.setCKPVT_CODIGO(inCkpvt_codigo);
		obj.setCKUPV_CODIGO(inCkupv_codigo);
		obj.setCKCRR_FECHA_CIERRE(new Date());
		obj.setCKCRR_NUMERO_CIERRE(inCkcrr_numero_cierre);
		obj.setCKCRR_TOTAL_VENTA(inCkcrr_total_venta);
		obj.setCKCRR_TOTAL(inCkcrr_total);
		obj.setCKCRR_OBSERVACION(inCkcrr_observacion);
		obj.setCKCRR_DIFERENCIA(inCkcrr_diferencia);
		obj.setCKCRR_ESTADO_CIERRE(inCkcrr_estado_cierre);
		obj.setCKCRR_ESTADO(true);
		obj.setCKCRR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCKCRR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_kdx_cierre(obj).insert(con);
			if (res.equals("true"))
			{
				arrayJSON = new org.json.JSONArray(inCierreDetalle_JSON);
				for (int i = 0 ; i < arrayJSON.length(); i++){
					objJSON = arrayJSON.getJSONObject(i);
					objCierreDetalle = new com.besixplus.sii.objects.Cgg_kdx_cierre_detalle();
					objCierreDetalle.setCKCDT_CODIGO("KEYGEN");
					objCierreDetalle.setCKDNM_CODIGO(objJSON.getString("CKDNM_CODIGO"));
					objCierreDetalle.setCKCRR_CODIGO(obj.getCKCRR_CODIGO());
					objCierreDetalle.setCKCDT_CANTIDAD(objJSON.getInt("CKCDT_CANTIDAD"));
					objCierreDetalle.setCKCDT_VALOR(new BigDecimal(objJSON.getDouble("CKCDT_VALOR")));
					objCierreDetalle.setCKCDT_TOTAL(new BigDecimal(objJSON.getDouble("CKCDT_TOTAL")));
					objCierreDetalle.setCKCDT_OBSERVACION(objJSON.getString("CKCDT_OBSERVACION"));
					objCierreDetalle.setCKCDT_ESTADO(true);
					objCierreDetalle.setCKCDT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objCierreDetalle.setCKCDT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_kdx_cierre_detalle(objCierreDetalle).insert(con);
					if (!res.equals("true"))
						break;
				}
				if (res.equals("true"))
				{
					arrayVentaCierreJSON = new org.json.JSONArray(inVentaCierre_JSON);
					for (int i = 0 ; i < arrayVentaCierreJSON.length(); i++){
						objVentaCierreJSON = arrayVentaCierreJSON.getJSONObject(i);
						objVentaCierre = new com.besixplus.sii.objects.Cgg_kdx_venta_cierre();
						objVentaCierre.setCKVTC_CODIGO("KEYGEN");
						objVentaCierre.setCKVNT_CODIGO(objVentaCierreJSON.getString("CKVNT_CODIGO"));
						objVentaCierre.setCKCRR_CODIGO(obj.getCKCRR_CODIGO());
						objVentaCierre.setCKVTC_ESTADO(true);
						objVentaCierre.setCKVTC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objVentaCierre.setCKVTC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_kdx_venta_cierre(objVentaCierre).insert1(con);
						if (!res.equals("true"))
							break;
					}

				}

			}

			if(!res.equals("true"))
			{
				con.rollback();
				appResponser.setSuccess(false);
				appResponser.setMsg("No se pudo completar la operacion satisfactoriamente.");
				//throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			else
			{
				con.commit();
				appResponser.setSuccess(true);
				appResponser.setMsg("Cierre efectuado correctamente");
				appResponser.setObjData(obj);
			}
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			appResponser.setSuccess(false);
			appResponser.setMsg(inException.getMessage());
			//throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			//throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			appResponser.setSuccess(false);
			appResponser.setMsg(inException.getMessage());			
		}
		return new JSONObject(appResponser).toString();
	}
	
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_notificacion EN UNA ESTRUCTURA JSON o XML.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	@WebMethod
	public String numeroCierre(		
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		String outNumeroTransferencia = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			outNumeroTransferencia = com.besixplus.sii.db.Cgg_kdx_cierre.numeroCierre(con,tmpRequest.getUserPrincipal().getName());
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (outNumeroTransferencia != null)
			return outNumeroTransferencia;
		return null;
	}
	
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_cierre EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPageDirect1(
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
			tmpCount = com.besixplus.sii.db.Cgg_kdx_cierre.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_cierre.selectAllDirect1(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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

}