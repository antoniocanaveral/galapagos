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

import org.json.JSONException;
import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.misc.CGGEnumerators.TIPOMOVIMIENTOKARDEX;
import com.besixplus.sii.misc.CGGEnumerators.TIPOOPERACIONKARDEX;

/**
* CLASE Cgg_kdx_compra
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_compra POR MEDIO DE SERVICIOS WEB.
*
* @autor BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_kdx_compra implements Serializable{

	private static final long serialVersionUID = 1499731791;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_compra.
	* @param inCkcmp_lote LOTE AL QUE CORRESPONDE LA COMPRA.
	* @param inCkcmp_fecha_ingreso FECHA DE INGRESO DE LAS ESPECIES.
	* @param inCkcmp_serie SERIE DEL LOTE DE ESPECIES.
	* @param inCkcmp_procedencia NOMBRE DE PROCEDENCIA DE LAS ESPECIES.
	* @param inCkcmp_cantidad TOTAL DE ESPECIES DE LA FACTURA.
	* @param inCkcmp_factura NUMERO DE FACTURA DE LA COMPRA..
	* @param inCkcmp_total TOTAL DE LA FACTURA.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCkcmp_lote")int inCkcmp_lote,
		@WebParam(name="inCkcmp_fecha_ingreso")java.util.Date inCkcmp_fecha_ingreso,
		@WebParam(name="inCkcmp_serie")String inCkcmp_serie,
		@WebParam(name="inCkcmp_procedencia")String inCkcmp_procedencia,
		@WebParam(name="inCkcmp_cantidad")int inCkcmp_cantidad,
		@WebParam(name="inCkcmp_factura")String inCkcmp_factura,
		@WebParam(name="inCkcmp_total")String inCkcmp_total
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_compra obj = new com.besixplus.sii.objects.Cgg_kdx_compra();
		obj.setCKCMP_CODIGO("KEYGEN");
		obj.setCKCMP_LOTE(inCkcmp_lote);
		obj.setCKCMP_FECHA_INGRESO(inCkcmp_fecha_ingreso);
		obj.setCKCMP_SERIE(inCkcmp_serie);
		obj.setCKCMP_PROCEDENCIA(inCkcmp_procedencia);
		obj.setCKCMP_CANTIDAD(inCkcmp_cantidad);
		obj.setCKCMP_FACTURA(inCkcmp_factura);
		obj.setCKCMP_TOTAL(inCkcmp_total);
		obj.setCKCMP_ESTADO(true);
		obj.setCKCMP_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCKCMP_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_kdx_compra(obj).insert(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_compra EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_compra.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_compra EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_kdx_compra.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_compra.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_compra EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_kdx_compra.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_compra.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_kdx_compra.
	* @param inCkcmp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
	* @param inCkcmp_lote LOTE AL QUE CORRESPONDE LA COMPRA
	* @param inCkcmp_fecha_ingreso FECHA DE INGRESO DE LAS ESPECIES
	* @param inCkcmp_serie SERIE DEL LOTE DE ESPECIES
	* @param inCkcmp_procedencia NOMBRE DE PROCEDENCIA DE LAS ESPECIES
	* @param inCkcmp_cantidad TOTAL DE ESPECIES DE LA FACTURA
	* @param inCkcmp_factura NUMERO DE FACTURA DE LA COMPRA.
	* @param inCkcmp_total TOTAL DE LA FACTURA
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCkcmp_codigo")String inCkcmp_codigo,
		@WebParam(name="inCkcmp_lote")int inCkcmp_lote,
		@WebParam(name="inCkcmp_fecha_ingreso")java.util.Date inCkcmp_fecha_ingreso,
		@WebParam(name="inCkcmp_serie")String inCkcmp_serie,
		@WebParam(name="inCkcmp_procedencia")String inCkcmp_procedencia,
		@WebParam(name="inCkcmp_cantidad")int inCkcmp_cantidad,
		@WebParam(name="inCkcmp_factura")String inCkcmp_factura,
		@WebParam(name="inCkcmp_total")String inCkcmp_total
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_compra obj = new com.besixplus.sii.objects.Cgg_kdx_compra();
		obj.setCKCMP_CODIGO(inCkcmp_codigo);
		obj.setCKCMP_LOTE(inCkcmp_lote);
		obj.setCKCMP_FECHA_INGRESO(inCkcmp_fecha_ingreso);
		obj.setCKCMP_SERIE(inCkcmp_serie);
		obj.setCKCMP_PROCEDENCIA(inCkcmp_procedencia);
		obj.setCKCMP_CANTIDAD(inCkcmp_cantidad);
		obj.setCKCMP_FACTURA(inCkcmp_factura);
		obj.setCKCMP_TOTAL(inCkcmp_total);
		obj.setCKCMP_ESTADO(true);
		obj.setCKCMP_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_kdx_compra(obj).update(con);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_kdx_compra EN UNA ESTRUCTURA JSON o XML.
	* @param inCkcmp_codigo IDENTIFICATIVO UNICO DE COMPRA
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCkcmp_codigo")String inCkcmp_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_compra tmpObj = new com.besixplus.sii.objects.Cgg_kdx_compra();
		tmpObj.setCKCMP_CODIGO(inCkcmp_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_kdx_compra(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_compra>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_kdx_compra.
	* @param inCkcmp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCkcmp_codigo")String inCkcmp_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_compra tmpObj = new com.besixplus.sii.objects.Cgg_kdx_compra();
		tmpObj.setCKCMP_CODIGO(inCkcmp_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_kdx_compra(tmpObj).delete(con);
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
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_compra.
	* @param inCkcmp_lote LOTE AL QUE CORRESPONDE LA COMPRA.
	* @param inCkcmp_fecha_ingreso FECHA DE INGRESO DE LAS ESPECIES.
	* @param inCkcmp_serie SERIE DEL LOTE DE ESPECIES.
	* @param inCkcmp_procedencia NOMBRE DE PROCEDENCIA DE LAS ESPECIES.
	* @param inCkcmp_cantidad TOTAL DE ESPECIES DE LA FACTURA.
	* @param inCkcmp_factura NUMERO DE FACTURA DE LA COMPRA..
	* @param inCkcmp_total TOTAL DE LA FACTURA.
	* @param inCompraDetalle_JSON CADENA EN FORMATO JSON QUE CONTIENE EL DETALLE DE LAS COMPRAS
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
 * @throws SOAPException 
	*/
	@WebMethod
	public String insert1(
		@WebParam(name="inCkcmp_lote")int inCkcmp_lote,
		@WebParam(name="inCkcmp_fecha_ingreso")java.util.Date inCkcmp_fecha_ingreso,
		@WebParam(name="inCkcmp_serie")String inCkcmp_serie,
		@WebParam(name="inCkcmp_procedencia")String inCkcmp_procedencia,
		@WebParam(name="inCkcmp_cantidad")int inCkcmp_cantidad,
		@WebParam(name="inCkcmp_factura")String inCkcmp_factura,
		@WebParam(name="inCkcmp_total")String inCkcmp_total,
		@WebParam(name="inCompraDetalle_JSON")String inCompraDetalle_JSON
	) throws SOAPException{
		String res = "true";
		org.json.JSONArray arrayJSON = null;
		JSONObject objJSON =  null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_compra obj = new com.besixplus.sii.objects.Cgg_kdx_compra();
		com.besixplus.sii.objects.Cgg_kdx_compra_detalle objCompraDetalle = null;
		com.besixplus.sii.objects.Cgg_kdx_kardex objKardex = null;
		obj.setCKCMP_CODIGO("KEYGEN");
		obj.setCKCMP_LOTE(inCkcmp_lote);
		obj.setCKCMP_FECHA_INGRESO(inCkcmp_fecha_ingreso);
		obj.setCKCMP_SERIE(inCkcmp_serie);
		obj.setCKCMP_PROCEDENCIA(inCkcmp_procedencia);
		obj.setCKCMP_CANTIDAD(inCkcmp_cantidad);
		obj.setCKCMP_FACTURA(inCkcmp_factura);
		obj.setCKCMP_TOTAL(inCkcmp_total);
		obj.setCKCMP_ESTADO(true);
		obj.setCKCMP_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCKCMP_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_kdx_compra(obj).insert(con);
			if (obj.getCKCMP_CODIGO() != "KEYGEN" && res.equals("true"))
			{
				//Insert Compra detalle
				arrayJSON = new org.json.JSONArray(inCompraDetalle_JSON);
				for (int i = 0 ; i < arrayJSON.length(); i++){
					
					objJSON = arrayJSON.getJSONObject(i);
					objCompraDetalle = new com.besixplus.sii.objects.Cgg_kdx_compra_detalle();
					objCompraDetalle.setCKCMD_CODIGO("KEYGEN");
					objCompraDetalle.setCKCMP_CODIGO(obj.getCKCMP_CODIGO());		
					objCompraDetalle.setCKESP_CODIGO(objJSON.getString("CKESP_CODIGO"));
					objCompraDetalle.setCKCMD_SERIE_INICIO(objJSON.getInt("CKCMD_SERIE_INICIO"));
					objCompraDetalle.setCKCMD_SERIE_FIN(objJSON.getInt("CKCMD_SERIE_FIN"));
					objCompraDetalle.setCKCMD_CANTIDAD(Integer.valueOf(objJSON.getString("CKCMD_CANTIDAD")));
					objCompraDetalle.setCKCMD_PRECIO_UNITARIO(new BigDecimal(objJSON.getDouble("CKCMD_PRECIO_UNITARIO")));
					objCompraDetalle.setCKCMD_TOTAL(new BigDecimal(objJSON.getDouble("CKCMD_TOTAL")));
					objCompraDetalle.setCKCMD_ESTADO(true);	
					objCompraDetalle.setCKCMD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objCompraDetalle.setCKCMD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_kdx_compra_detalle(objCompraDetalle).insert(con);
				}
				if (res.equals("true")){
					objKardex = new com.besixplus.sii.objects.Cgg_kdx_kardex();
					objKardex.setCKKRD_CODIGO("KEYGEN");
					objKardex.setCKESP_CODIGO(objCompraDetalle.getCKESP_CODIGO());
					objKardex.setCKKRD_DETALLE("COMPRA ESPECIE SERIE:" + obj.getCKCMP_SERIE() + " S/F No:" + obj.getCKCMP_FACTURA());
					objKardex.setCKKRD_TIPO_MOVIMIENTO(TIPOMOVIMIENTOKARDEX.INGRESO.getValue());
					objKardex.setCKKRD_TIPO_OPERACION(TIPOOPERACIONKARDEX.COMPRA.getValue());
					objKardex.setCKKRD_INGRESO_CANTIDAD(objCompraDetalle.getCKCMD_CANTIDAD());
					objKardex.setCKKRD_INGRESO_PU(objCompraDetalle.getCKCMD_PRECIO_UNITARIO());
					objKardex.setCKKRD_INGRESO_TOTAL(objCompraDetalle.getCKCMD_TOTAL());
					objKardex.setCKKRD_ESTADO(true);
					objKardex.setCKKRD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objKardex.setCKKRD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res =  new com.besixplus.sii.db.Cgg_kdx_kardex(objKardex).ejecutarOperacion(con);					
					
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_kdx_compra.
	* @param inCkcmp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
	* @param inCkcmp_lote LOTE AL QUE CORRESPONDE LA COMPRA.
	* @param inCkcmp_fecha_ingreso FECHA DE INGRESO DE LAS ESPECIES.
	* @param inCkcmp_serie SERIE DEL LOTE DE ESPECIES.
	* @param inCkcmp_procedencia NOMBRE DE PROCEDENCIA DE LAS ESPECIES.
	* @param inCkcmp_cantidad TOTAL DE ESPECIES DE LA FACTURA.
	* @param inCkcmp_factura NUMERO DE FACTURA DE LA COMPRA..
	* @param inCkcmp_total TOTAL DE LA FACTURA.
	* @param inCompraDetalle_JSON CADENA EN FORMATO JSON QUE CONTIENE EL DETALLE DE LAS COMPRAS
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String update1(
		@WebParam(name="inCkcmp_codigo")String inCkcmp_codigo,
		@WebParam(name="inCkcmp_lote")int inCkcmp_lote,
		@WebParam(name="inCkcmp_fecha_ingreso")java.util.Date inCkcmp_fecha_ingreso,
		@WebParam(name="inCkcmp_serie")String inCkcmp_serie,
		@WebParam(name="inCkcmp_procedencia")String inCkcmp_procedencia,
		@WebParam(name="inCkcmp_cantidad")int inCkcmp_cantidad,
		@WebParam(name="inCkcmp_factura")String inCkcmp_factura,
		@WebParam(name="inCkcmp_total")String inCkcmp_total,
		@WebParam(name="inCompraDetalle_JSON")String inCompraDetalle_JSON
	) throws SOAPException{
		String res = "true";
		org.json.JSONArray arrayJSON = null;
		JSONObject objJSON =  null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_compra obj = new com.besixplus.sii.objects.Cgg_kdx_compra();
		obj.setCKCMP_CODIGO(inCkcmp_codigo);
		obj.setCKCMP_LOTE(inCkcmp_lote);
		obj.setCKCMP_FECHA_INGRESO(inCkcmp_fecha_ingreso);
		obj.setCKCMP_SERIE(inCkcmp_serie);
		obj.setCKCMP_PROCEDENCIA(inCkcmp_procedencia);
		obj.setCKCMP_CANTIDAD(inCkcmp_cantidad);
		obj.setCKCMP_FACTURA(inCkcmp_factura);
		obj.setCKCMP_TOTAL(inCkcmp_total);
		obj.setCKCMP_ESTADO(true);
		obj.setCKCMP_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_kdx_compra(obj).update(con);
			if (obj.getCKCMP_CODIGO() != "KEYGEN" && res.equals("true"))
			{
				//Insert Compra detalle
				arrayJSON = new org.json.JSONArray(inCompraDetalle_JSON);
				for (int i = 0 ; i < arrayJSON.length(); i++){
					objJSON = arrayJSON.getJSONObject(i);
					com.besixplus.sii.objects.Cgg_kdx_compra_detalle objCompraDetalle = new com.besixplus.sii.objects.Cgg_kdx_compra_detalle();		
					objCompraDetalle.setCKCMP_CODIGO(obj.getCKCMP_CODIGO());		
					objCompraDetalle.setCKESP_CODIGO(objJSON.getString("CKESP_CODIGO"));
					objCompraDetalle.setCKCMD_CANTIDAD(objJSON.getInt("CKCMD_CANTIDAD"));
					objCompraDetalle.setCKCMD_PRECIO_UNITARIO(new BigDecimal(objJSON.getDouble("CKCMD_PRECIO_UNITARIO")));
					objCompraDetalle.setCKCMD_TOTAL(new BigDecimal(objJSON.getDouble("CKCMD_TOTAL")));
					objCompraDetalle.setCKCMD_ESTADO(true);	
					objCompraDetalle.setCKCMD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_kdx_compra_detalle(objCompraDetalle).insert(con);
					if(objJSON.getString("CKUPV_CODIGO").equals("KEYGEN"))
					{
						objCompraDetalle.setCKCMD_CODIGO("KEYGEN");
						objCompraDetalle.setCKCMD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_kdx_compra_detalle(objCompraDetalle).insert(con);
					}
					else
					{
						objCompraDetalle.setCKCMD_CODIGO(objJSON.getString("CKCMD_CODIGO"));
						res = new com.besixplus.sii.db.Cgg_kdx_compra_detalle(objCompraDetalle).update(con);
					}
					
				}
				if (res.equals("true"))
				{
					con.commit();
					
				}
				else
				{
					con.rollback();
				}
			}
			con.setAutoCommit(true);
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_compra EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPageWithEspecie(
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
			tmpCount = com.besixplus.sii.db.Cgg_kdx_compra.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_compra.selectAllWithEspecie(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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