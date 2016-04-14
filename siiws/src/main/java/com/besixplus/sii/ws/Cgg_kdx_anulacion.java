package com.besixplus.sii.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
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
import com.besixplus.sii.db.ManagerConnection;

/**
* CLASE Cgg_kdx_anulacion
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_anulacion POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_kdx_anulacion implements Serializable{

	private static final long serialVersionUID = 1201220373;

	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_anulacion.
	* @param inCkasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION.
	* @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA.
	* @param inCkanl_numero_anulacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION.
	* @param inCkanl_fecha_anulacion FECHA DE RECEPCION DE LAS ESPECIES.
	* @param inCkanl_cantidad CANTIDAD DE ESPECIES.
	* @param inCkanl_precio_unitario PRECIO DE VENTA DE LA ESPECIE.
	* @param inCkanl_precio_total VALOR TOTAL DE LA ANULACION.
	* @param inCkanl_serie_inicio SERIE DE INICIO DE LAS ESPECIES.
	* @param inCkanl_serie_fin SERIE DE FIN DE LAS ESPECIES.
	* @param inCkanl_observacion COMENTARIO AFIN A LA ASIGNACION.
	* @param inCkanl_justificacion DESCRIPCION DE LA JUSTIFICACION QUE MOTIVO LA ANULACION.
	* @param inCkanl_tipo_anulacion TIPO DE ANULACION:
0.- DEFECTO FABRICA
1.- OTRAS.
	* @param inCkanl_estado_anulacion ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONFIRMADA.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCkasg_codigo")String inCkasg_codigo,
		@WebParam(name="inCkupv_codigo")String inCkupv_codigo,
		@WebParam(name="inCkanl_numero_anulacion")String inCkanl_numero_anulacion,
		@WebParam(name="inCkanl_fecha_anulacion")java.util.Date inCkanl_fecha_anulacion,
		@WebParam(name="inCkanl_cantidad")int inCkanl_cantidad,
		@WebParam(name="inCkanl_precio_unitario")java.math.BigDecimal inCkanl_precio_unitario,
		@WebParam(name="inCkanl_precio_total")java.math.BigDecimal inCkanl_precio_total,
		@WebParam(name="inCkanl_serie_inicio")int inCkanl_serie_inicio,
		@WebParam(name="inCkanl_serie_fin")int inCkanl_serie_fin,
		@WebParam(name="inCkanl_observacion")String inCkanl_observacion,
		@WebParam(name="inCkanl_justificacion")String inCkanl_justificacion,
		@WebParam(name="inCkanl_tipo_anulacion")int inCkanl_tipo_anulacion,
		@WebParam(name="inCkanl_estado_anulacion")int inCkanl_estado_anulacion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_anulacion obj = new com.besixplus.sii.objects.Cgg_kdx_anulacion();
		obj.setCKANL_CODIGO("KEYGEN");
		obj.setCKASG_CODIGO(inCkasg_codigo);
		obj.setCKUPV_CODIGO(inCkupv_codigo);
		obj.setCKANL_NUMERO_ANULACION(inCkanl_numero_anulacion);
		obj.setCKANL_FECHA_ANULACION(inCkanl_fecha_anulacion);
		obj.setCKANL_CANTIDAD(inCkanl_cantidad);
		obj.setCKANL_PRECIO_UNITARIO(inCkanl_precio_unitario);
		obj.setCKANL_PRECIO_TOTAL(inCkanl_precio_total);
		obj.setCKANL_SERIE_INICIO(inCkanl_serie_inicio);
		obj.setCKANL_SERIE_FIN(inCkanl_serie_fin);
		obj.setCKANL_OBSERVACION(inCkanl_observacion);
		obj.setCKANL_JUSTIFICACION(inCkanl_justificacion);
		obj.setCKANL_TIPO_ANULACION(inCkanl_tipo_anulacion);
		obj.setCKANL_ESTADO_ANULACION(inCkanl_estado_anulacion);
		obj.setCKANL_ESTADO(true);
		obj.setCKANL_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCKANL_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_kdx_anulacion(obj).insert(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_anulacion EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_anulacion.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_anulacion EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_kdx_anulacion.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_anulacion.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_anulacion EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_kdx_anulacion.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_anulacion.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_kdx_anulacion.
	* @param inCkanl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE UNA ANULACION
	* @param inCkasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	* @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @param inCkanl_numero_anulacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	* @param inCkanl_fecha_anulacion FECHA DE RECEPCION DE LAS ESPECIES
	* @param inCkanl_cantidad CANTIDAD DE ESPECIES
	* @param inCkanl_precio_unitario PRECIO DE VENTA DE LA ESPECIE
	* @param inCkanl_precio_total VALOR TOTAL DE LA ANULACION
	* @param inCkanl_serie_inicio SERIE DE INICIO DE LAS ESPECIES
	* @param inCkanl_serie_fin SERIE DE FIN DE LAS ESPECIES
	* @param inCkanl_observacion COMENTARIO AFIN A LA ASIGNACION
	* @param inCkanl_justificacion DESCRIPCION DE LA JUSTIFICACION QUE MOTIVO LA ANULACION
	* @param inCkanl_tipo_anulacion TIPO DE ANULACION:
0.- DEFECTO FABRICA
1.- OTRAS
	* @param inCkanl_estado_anulacion ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONFIRMADA
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCkanl_codigo")String inCkanl_codigo,
		@WebParam(name="inCkasg_codigo")String inCkasg_codigo,
		@WebParam(name="inCkupv_codigo")String inCkupv_codigo,
		@WebParam(name="inCkanl_numero_anulacion")String inCkanl_numero_anulacion,
		@WebParam(name="inCkanl_fecha_anulacion")java.util.Date inCkanl_fecha_anulacion,
		@WebParam(name="inCkanl_cantidad")int inCkanl_cantidad,
		@WebParam(name="inCkanl_precio_unitario")java.math.BigDecimal inCkanl_precio_unitario,
		@WebParam(name="inCkanl_precio_total")java.math.BigDecimal inCkanl_precio_total,
		@WebParam(name="inCkanl_serie_inicio")int inCkanl_serie_inicio,
		@WebParam(name="inCkanl_serie_fin")int inCkanl_serie_fin,
		@WebParam(name="inCkanl_observacion")String inCkanl_observacion,
		@WebParam(name="inCkanl_justificacion")String inCkanl_justificacion,
		@WebParam(name="inCkanl_tipo_anulacion")int inCkanl_tipo_anulacion,
		@WebParam(name="inCkanl_estado_anulacion")int inCkanl_estado_anulacion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_anulacion obj = new com.besixplus.sii.objects.Cgg_kdx_anulacion();
		obj.setCKANL_CODIGO(inCkanl_codigo);
		obj.setCKASG_CODIGO(inCkasg_codigo);
		obj.setCKUPV_CODIGO(inCkupv_codigo);
		obj.setCKANL_NUMERO_ANULACION(inCkanl_numero_anulacion);
		obj.setCKANL_FECHA_ANULACION(inCkanl_fecha_anulacion);
		obj.setCKANL_CANTIDAD(inCkanl_cantidad);
		obj.setCKANL_PRECIO_UNITARIO(inCkanl_precio_unitario);
		obj.setCKANL_PRECIO_TOTAL(inCkanl_precio_total);
		obj.setCKANL_SERIE_INICIO(inCkanl_serie_inicio);
		obj.setCKANL_SERIE_FIN(inCkanl_serie_fin);
		obj.setCKANL_OBSERVACION(inCkanl_observacion);
		obj.setCKANL_JUSTIFICACION(inCkanl_justificacion);
		obj.setCKANL_TIPO_ANULACION(inCkanl_tipo_anulacion);
		obj.setCKANL_ESTADO_ANULACION(inCkanl_estado_anulacion);
		obj.setCKANL_ESTADO(true);
		obj.setCKANL_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_kdx_anulacion(obj).update(con);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_kdx_anulacion EN UNA ESTRUCTURA JSON o XML.
	* @param inCkanl_codigo ckanl_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCkanl_codigo")String inCkanl_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_anulacion tmpObj = new com.besixplus.sii.objects.Cgg_kdx_anulacion();
		tmpObj.setCKANL_CODIGO(inCkanl_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_kdx_anulacion(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_anulacion>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_kdx_anulacion.
	* @param inCkanl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE UNA ANULACION
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
 * @throws SOAPException 
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCkanl_codigo")String inCkanl_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_anulacion tmpObj = new com.besixplus.sii.objects.Cgg_kdx_anulacion();
		tmpObj.setCKANL_CODIGO(inCkanl_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_kdx_anulacion(tmpObj).delete(con);
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
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_anulacion.
	* @param inCkasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION.
	* @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA.
	* @param inCkanl_numero_anulacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION.
	* @param inCkanl_fecha_anulacion FECHA DE RECEPCION DE LAS ESPECIES.
	* @param inCkanl_cantidad CANTIDAD DE ESPECIES.
	* @param inCkanl_precio_unitario PRECIO DE VENTA DE LA ESPECIE.
	* @param inCkanl_precio_total VALOR TOTAL DE LA ANULACION.
	* @param inCkanl_serie_inicio SERIE DE INICIO DE LAS ESPECIES.
	* @param inCkanl_serie_fin SERIE DE FIN DE LAS ESPECIES.
	* @param inCkanl_observacion COMENTARIO AFIN A LA ASIGNACION.
	* @param inCkanl_justificacion DESCRIPCION DE LA JUSTIFICACION QUE MOTIVO LA ANULACION.
	* @param inCkanl_tipo_anulacion TIPO DE ANULACION:
0.- DEFECTO FABRICA
1.- OTRAS.
	* @param inCkanl_estado_anulacion ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  CONFIRMADA.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String insert1(
		@WebParam(name="inCkasg_codigo")String inCkasg_codigo,
		@WebParam(name="inCkupv_codigo")String inCkupv_codigo,
		@WebParam(name="inCkanl_numero_anulacion")String inCkanl_numero_anulacion,
		@WebParam(name="inCkanl_fecha_anulacion")java.util.Date inCkanl_fecha_anulacion,
		@WebParam(name="inCkanl_cantidad")int inCkanl_cantidad,
		@WebParam(name="inCkanl_precio_unitario")java.math.BigDecimal inCkanl_precio_unitario,
		@WebParam(name="inCkanl_precio_total")java.math.BigDecimal inCkanl_precio_total,
		@WebParam(name="inCkanl_serie_inicio")int inCkanl_serie_inicio,
		@WebParam(name="inCkanl_serie_fin")int inCkanl_serie_fin,
		@WebParam(name="inCkanl_observacion")String inCkanl_observacion,
		@WebParam(name="inCkanl_justificacion")String inCkanl_justificacion,
		@WebParam(name="inCkanl_tipo_anulacion")int inCkanl_tipo_anulacion,
		@WebParam(name="inCkanl_estado_anulacion")int inCkanl_estado_anulacion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_anulacion obj = new com.besixplus.sii.objects.Cgg_kdx_anulacion();
		obj.setCKANL_CODIGO("KEYGEN");
		obj.setCKASG_CODIGO(inCkasg_codigo);
		obj.setCKUPV_CODIGO(inCkupv_codigo);
		obj.setCKANL_NUMERO_ANULACION(inCkanl_numero_anulacion);
		obj.setCKANL_FECHA_ANULACION(inCkanl_fecha_anulacion);
		obj.setCKANL_CANTIDAD(inCkanl_cantidad);
		obj.setCKANL_PRECIO_UNITARIO(inCkanl_precio_unitario);
		obj.setCKANL_PRECIO_TOTAL(inCkanl_precio_total);
		obj.setCKANL_SERIE_INICIO(inCkanl_serie_inicio);
		obj.setCKANL_SERIE_FIN(inCkanl_serie_fin);
		obj.setCKANL_OBSERVACION(inCkanl_observacion);
		obj.setCKANL_JUSTIFICACION(inCkanl_justificacion);
		obj.setCKANL_TIPO_ANULACION(inCkanl_tipo_anulacion);
		obj.setCKANL_ESTADO_ANULACION(inCkanl_estado_anulacion);
		obj.setCKANL_ESTADO(true);
		obj.setCKANL_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCKANL_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_kdx_anulacion(obj).insert1(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_notificacion EN UNA ESTRUCTRA JSON o XML.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */

	@WebMethod
	public String numeroAnulacion(		
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		String outNumeroAnulacion = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			outNumeroAnulacion = com.besixplus.sii.db.Cgg_kdx_anulacion.numeroAnulacion(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (outNumeroAnulacion != null)
			return outNumeroAnulacion;
		return null;
	}
	
}