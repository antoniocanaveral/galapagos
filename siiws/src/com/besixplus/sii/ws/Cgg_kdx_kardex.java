package com.besixplus.sii.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import com.besixplus.sii.db.ManagerConnection;

/**
 * CLASE Cgg_kdx_kardex
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_kardex POR MEDIO DE SERVICIOS WEB.
 *
 * @autor BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_kdx_kardex implements Serializable{

	private static final long serialVersionUID = 353097128;

	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_kardex.
	 * @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE.
	 * @param inCkkrd_numero NUMERO DEL MOVIMIENTO.
	 * @param inCkkrd_detalle DETALLE DEL MOVIMIENTO.
	 * @param inCkkrd_fecha_registro FECHA DE REGISTRO DE MOVIMIENTO.
	 * @param inCkkrd_tipo_movimiento TIPO DE MOVIMIENTO:
0 .- INVENTARIO INICIAL
1.-  INGRESO
2.-  SALIDA
.
	 * @param inCkkrd_tipo_operacion TIPO DE OPERACION:
0.- COMPRA
1.- VENTA
2.- ANULACION
3.- DEVOLUCION
4.- OTRAS.
	 * @param inCkkrd_ingreso_cantidad CANTIDAD DE ESPECIES QUE INGRESARON.
	 * @param inCkkrd_ingreso_pu PRECIO UNITARIO DE COMPRA.
	 * @param inCkkrd_ingreso_total TOTAL CONTABLE DE INGRESO.
	 * @param inCkkrd_salida_cantidad CANTIDAD DE ESPECIES ENTREGADAS.
	 * @param inCkkrd_salida_pu PRECIO UNITARIO DE VENTA.
	 * @param inCkkrd_salida_total TOTAL CONTABLE DE VENTA.
	 * @param inCkkrd_total_cantidad CANTIDAD TOTAL.
	 * @param inCkkrd_total_pu PRECIO UNITARIO.
	 * @param inCkkrd_total_total TOTAL CONTABLE.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCkesp_codigo")String inCkesp_codigo,
			@WebParam(name="inCkkrd_numero")int inCkkrd_numero,
			@WebParam(name="inCkkrd_detalle")String inCkkrd_detalle,
			@WebParam(name="inCkkrd_fecha_registro")java.util.Date inCkkrd_fecha_registro,
			@WebParam(name="inCkkrd_tipo_movimiento")int inCkkrd_tipo_movimiento,
			@WebParam(name="inCkkrd_tipo_operacion")int inCkkrd_tipo_operacion,
			@WebParam(name="inCkkrd_ingreso_cantidad")int inCkkrd_ingreso_cantidad,
			@WebParam(name="inCkkrd_ingreso_pu")java.math.BigDecimal inCkkrd_ingreso_pu,
			@WebParam(name="inCkkrd_ingreso_total")java.math.BigDecimal inCkkrd_ingreso_total,
			@WebParam(name="inCkkrd_salida_cantidad")int inCkkrd_salida_cantidad,
			@WebParam(name="inCkkrd_salida_pu")java.math.BigDecimal inCkkrd_salida_pu,
			@WebParam(name="inCkkrd_salida_total")java.math.BigDecimal inCkkrd_salida_total,
			@WebParam(name="inCkkrd_total_cantidad")int inCkkrd_total_cantidad,
			@WebParam(name="inCkkrd_total_pu")java.math.BigDecimal inCkkrd_total_pu,
			@WebParam(name="inCkkrd_total_total")java.math.BigDecimal inCkkrd_total_total
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_kdx_kardex obj = new com.besixplus.sii.objects.Cgg_kdx_kardex();
		obj.setCKKRD_CODIGO("KEYGEN");
		obj.setCKESP_CODIGO(inCkesp_codigo);
		obj.setCKKRD_NUMERO(inCkkrd_numero);
		obj.setCKKRD_DETALLE(inCkkrd_detalle);
		obj.setCKKRD_FECHA_REGISTRO(inCkkrd_fecha_registro);
		obj.setCKKRD_TIPO_MOVIMIENTO(inCkkrd_tipo_movimiento);
		obj.setCKKRD_TIPO_OPERACION(inCkkrd_tipo_operacion);
		obj.setCKKRD_INGRESO_CANTIDAD(inCkkrd_ingreso_cantidad);
		obj.setCKKRD_INGRESO_PU(inCkkrd_ingreso_pu);
		obj.setCKKRD_INGRESO_TOTAL(inCkkrd_ingreso_total);
		obj.setCKKRD_SALIDA_CANTIDAD(inCkkrd_salida_cantidad);
		obj.setCKKRD_SALIDA_PU(inCkkrd_salida_pu);
		obj.setCKKRD_SALIDA_TOTAL(inCkkrd_salida_total);
		obj.setCKKRD_TOTAL_CANTIDAD(inCkkrd_total_cantidad);
		obj.setCKKRD_TOTAL_PU(inCkkrd_total_pu);
		obj.setCKKRD_TOTAL_TOTAL(inCkkrd_total_total);
		obj.setCKKRD_ESTADO(true);
		obj.setCKKRD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCKKRD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_kdx_kardex(obj).insert(con);
			if(!res.equals("true"))
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		return res;
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_kardex EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_kardex.selectAll(con, tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		if (obj != null)
			return outCadena.toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_kardex EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectPage(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			tmpCount = com.besixplus.sii.db.Cgg_kdx_kardex.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_kardex.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_kardex EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectPageDirect(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			tmpCount = com.besixplus.sii.db.Cgg_kdx_kardex.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_kardex.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}


	/**
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_kdx_kardex.
	 * @param inCkkrd_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
	 * @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
	 * @param inCkkrd_numero NUMERO DEL MOVIMIENTO
	 * @param inCkkrd_detalle DETALLE DEL MOVIMIENTO
	 * @param inCkkrd_fecha_registro FECHA DE REGISTRO DE MOVIMIENTO
	 * @param inCkkrd_tipo_movimiento TIPO DE MOVIMIENTO:
0 .- INVENTARIO INICIAL
1.-  INGRESO
2.-  SALIDA

	 * @param inCkkrd_tipo_operacion TIPO DE OPERACION:
0.- COMPRA
1.- VENTA
2.- ANULACION
3.- DEVOLUCION
4.- OTRAS
	 * @param inCkkrd_ingreso_cantidad CANTIDAD DE ESPECIES QUE INGRESARON
	 * @param inCkkrd_ingreso_pu PRECIO UNITARIO DE COMPRA
	 * @param inCkkrd_ingreso_total TOTAL CONTABLE DE INGRESO
	 * @param inCkkrd_salida_cantidad CANTIDAD DE ESPECIES ENTREGADAS
	 * @param inCkkrd_salida_pu PRECIO UNITARIO DE VENTA
	 * @param inCkkrd_salida_total TOTAL CONTABLE DE VENTA
	 * @param inCkkrd_total_cantidad CANTIDAD TOTAL
	 * @param inCkkrd_total_pu PRECIO UNITARIO
	 * @param inCkkrd_total_total TOTAL CONTABLE
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCkkrd_codigo")String inCkkrd_codigo,
			@WebParam(name="inCkesp_codigo")String inCkesp_codigo,
			@WebParam(name="inCkkrd_numero")int inCkkrd_numero,
			@WebParam(name="inCkkrd_detalle")String inCkkrd_detalle,
			@WebParam(name="inCkkrd_fecha_registro")java.util.Date inCkkrd_fecha_registro,
			@WebParam(name="inCkkrd_tipo_movimiento")int inCkkrd_tipo_movimiento,
			@WebParam(name="inCkkrd_tipo_operacion")int inCkkrd_tipo_operacion,
			@WebParam(name="inCkkrd_ingreso_cantidad")int inCkkrd_ingreso_cantidad,
			@WebParam(name="inCkkrd_ingreso_pu")java.math.BigDecimal inCkkrd_ingreso_pu,
			@WebParam(name="inCkkrd_ingreso_total")java.math.BigDecimal inCkkrd_ingreso_total,
			@WebParam(name="inCkkrd_salida_cantidad")int inCkkrd_salida_cantidad,
			@WebParam(name="inCkkrd_salida_pu")java.math.BigDecimal inCkkrd_salida_pu,
			@WebParam(name="inCkkrd_salida_total")java.math.BigDecimal inCkkrd_salida_total,
			@WebParam(name="inCkkrd_total_cantidad")int inCkkrd_total_cantidad,
			@WebParam(name="inCkkrd_total_pu")java.math.BigDecimal inCkkrd_total_pu,
			@WebParam(name="inCkkrd_total_total")java.math.BigDecimal inCkkrd_total_total
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_kdx_kardex obj = new com.besixplus.sii.objects.Cgg_kdx_kardex();
		obj.setCKKRD_CODIGO(inCkkrd_codigo);
		obj.setCKESP_CODIGO(inCkesp_codigo);
		obj.setCKKRD_NUMERO(inCkkrd_numero);
		obj.setCKKRD_DETALLE(inCkkrd_detalle);
		obj.setCKKRD_FECHA_REGISTRO(inCkkrd_fecha_registro);
		obj.setCKKRD_TIPO_MOVIMIENTO(inCkkrd_tipo_movimiento);
		obj.setCKKRD_TIPO_OPERACION(inCkkrd_tipo_operacion);
		obj.setCKKRD_INGRESO_CANTIDAD(inCkkrd_ingreso_cantidad);
		obj.setCKKRD_INGRESO_PU(inCkkrd_ingreso_pu);
		obj.setCKKRD_INGRESO_TOTAL(inCkkrd_ingreso_total);
		obj.setCKKRD_SALIDA_CANTIDAD(inCkkrd_salida_cantidad);
		obj.setCKKRD_SALIDA_PU(inCkkrd_salida_pu);
		obj.setCKKRD_SALIDA_TOTAL(inCkkrd_salida_total);
		obj.setCKKRD_TOTAL_CANTIDAD(inCkkrd_total_cantidad);
		obj.setCKKRD_TOTAL_PU(inCkkrd_total_pu);
		obj.setCKKRD_TOTAL_TOTAL(inCkkrd_total_total);
		obj.setCKKRD_ESTADO(true);
		obj.setCKKRD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_kdx_kardex(obj).update(con);
			if(!res.equals("true"))
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		return res;
	}


	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_kdx_kardex EN UNA ESTRUCTURA JSON o XML.
	 * @param inCkkrd_codigo IDENTIFICATIVO UNICO DE KARDEX
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)..
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCkkrd_codigo")String inCkkrd_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_kdx_kardex tmpObj = new com.besixplus.sii.objects.Cgg_kdx_kardex();
		tmpObj.setCKKRD_CODIGO(inCkkrd_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_kdx_kardex(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_kardex>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}


	/**
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_kdx_kardex.
	 * @param inCkkrd_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCkkrd_codigo")String inCkkrd_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_kdx_kardex tmpObj = new com.besixplus.sii.objects.Cgg_kdx_kardex();
		tmpObj.setCKKRD_CODIGO(inCkkrd_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_kdx_kardex(tmpObj).delete(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		return new Boolean(outResult).toString();
	}


	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_kardex.
	 * @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE.
	 * @param inCkkrd_detalle DETALLE DEL MOVIMIENTO.
	 * @param inCkkrd_tipo_movimiento TIPO DE MOVIMIENTO:
			0 .- INVENTARIO INICIAL
			1.-  INGRESO
			2.-  SALIDA.
	 * @param inCkkrd_tipo_operacion TIPO DE OPERACION:
			0.- COMPRA
			1.- VENTA
			2.- ANULACION
			3.- DEVOLUCION
			4.- OTRAS.
	 * @param inCkkrd_ingreso_cantidad CANTIDAD DE ESPECIES QUE INGRESARON.
	 * @param inCkkrd_ingreso_pu PRECIO UNITARIO DE COMPRA.
	 * @param inCkkrd_ingreso_total TOTAL CONTABLE DE INGRESO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String ejecutarCalculo(
			@WebParam(name="inCkesp_codigo")String inCkesp_codigo,
			@WebParam(name="inCkkrd_detalle")String inCkkrd_detalle,
			@WebParam(name="inCkkrd_tipo_movimiento")int inCkkrd_tipo_movimiento,
			@WebParam(name="inCkkrd_tipo_operacion")int inCkkrd_tipo_operacion,
			@WebParam(name="inCkkrd_ingreso_cantidad")int inCkkrd_ingreso_cantidad,
			@WebParam(name="inCkkrd_ingreso_pu")java.math.BigDecimal inCkkrd_ingreso_pu,
			@WebParam(name="inCkkrd_ingreso_total")java.math.BigDecimal inCkkrd_ingreso_total
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_kdx_kardex obj = new com.besixplus.sii.objects.Cgg_kdx_kardex();
		obj.setCKKRD_CODIGO("KEYGEN");
		obj.setCKESP_CODIGO(inCkesp_codigo);
		obj.setCKKRD_DETALLE(inCkkrd_detalle);
		obj.setCKKRD_TIPO_MOVIMIENTO(inCkkrd_tipo_movimiento);
		obj.setCKKRD_TIPO_OPERACION(inCkkrd_tipo_operacion);
		obj.setCKKRD_INGRESO_CANTIDAD(inCkkrd_ingreso_cantidad);
		obj.setCKKRD_INGRESO_PU(inCkkrd_ingreso_pu);
		obj.setCKKRD_INGRESO_TOTAL(inCkkrd_ingreso_total);
		obj.setCKKRD_ESTADO(true);
		obj.setCKKRD_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCKKRD_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_kdx_kardex(obj).ejecutarOperacion(con);
			if(!res.equals("true"))
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		return res;
	}
	
	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_kardex.
	 * @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE.
	 * @param inCkkrd_detalle DETALLE DEL MOVIMIENTO.
	 * @param inCkkrd_tipo_movimiento TIPO DE MOVIMIENTO:
			0 .- INVENTARIO INICIAL
			1.-  INGRESO
			2.-  SALIDA.
	 * @param inCkkrd_tipo_operacion TIPO DE OPERACION:
			0.- COMPRA
			1.- VENTA
			2.- ANULACION
			3.- DEVOLUCION
			4.- OTRAS.
	 * @param inCkkrd_ingreso_cantidad CANTIDAD DE ESPECIES QUE INGRESARON.
	 * @param inCkkrd_ingreso_pu PRECIO UNITARIO DE COMPRA.
	 * @param inCkkrd_ingreso_total TOTAL CONTABLE DE INGRESO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String controlStock(
			@WebParam(name="inCkesp_codigo")String inCkesp_codigo
	){
		String res = "false";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_kdx_kardex obj = new com.besixplus.sii.objects.Cgg_kdx_kardex();
		obj.setCKESP_CODIGO(inCkesp_codigo);
	
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_kdx_kardex(obj).controlStock(con);
			if(!res.equals("true"))
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		return res;
	}

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_kardex.
	 * @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE.
	 * @param inCkkrd_detalle DETALLE DEL MOVIMIENTO.
	 * @param inCkkrd_tipo_movimiento TIPO DE MOVIMIENTO:
			0 .- INVENTARIO INICIAL
			1.-  INGRESO
			2.-  SALIDA.
	 * @param inCkkrd_tipo_operacion TIPO DE OPERACION:
			0.- COMPRA
			1.- VENTA
			2.- ANULACION
			3.- DEVOLUCION
			4.- OTRAS.
	 * @param inCkkrd_ingreso_cantidad CANTIDAD DE ESPECIES QUE INGRESARON.
	 * @param inCkkrd_ingreso_pu PRECIO UNITARIO DE COMPRA.
	 * @param inCkkrd_ingreso_total TOTAL CONTABLE DE INGRESO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String verificaInventarioInicial(
			@WebParam(name="inCkesp_codigo")String inCkesp_codigo
	){
		String res = "false";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_kdx_kardex obj = new com.besixplus.sii.objects.Cgg_kdx_kardex();
		obj.setCKESP_CODIGO(inCkesp_codigo);
	
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_kdx_kardex(obj).verificaInventarioInicial(con);
			if(!res.equals("true"))
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		return res;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_kardex EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inCkesp_codigo CODIGO UNICO DE LA ESPECIE.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectStockActual(
			@WebParam(name="inCkesp_codigo")String inCkesp_codigo,
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(false);
			com.besixplus.sii.objects.Cgg_kdx_kardex objKardex = new com.besixplus.sii.objects.Cgg_kdx_kardex();
			objKardex.setCKESP_CODIGO(inCkesp_codigo);
			obj = new com.besixplus.sii.db.Cgg_kdx_kardex(objKardex).selectStockActual(con);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return outCadena.toString();
			else
				return outCadena.toString();
		return null;
	}
}