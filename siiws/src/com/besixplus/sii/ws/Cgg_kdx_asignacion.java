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
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.misc.CGGEnumerators.TIPOESTADOASIGNACION;

/**
 * CLASE Cgg_kdx_asignacion
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_asignacion POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_kdx_asignacion implements Serializable{

	private static final long serialVersionUID = 1266069256;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_asignacion.
	* @param inCktrn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA.
	* @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA.
	* @param inCgg_ckupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA.
	* @param inCgg_ckasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION ANTERIOR.
	* @param inCkasg_numero_asignacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION.
	* @param inCkasg_fecha_recepcion FECHA DE RECEPCION DE LAS ESPECIES.
	* @param inCkasg_cantidad CANTIDAD DE ESPECIES.
	* @param inCkasg_precio_unitario PRECIO DE VENTA DE LA ESPECIE.
	* @param inCkasg_serie_inicio SERIE DE INICIO DE LAS ESPECIES.
	* @param inCkasg_serie_fin SERIE DE FIN DE LAS ESPECIES.
	* @param inCkasg_observacion COMENTARIO AFIN A LA ASIGNACION.
	* @param inCkasg_cantidad_disponible CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES.
	* @param inCkasg_estado_asignacion ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  REASIGNADA
2.-  FINALIZADA.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
		@WebParam(name="inCktrn_codigo")String inCktrn_codigo,
		@WebParam(name="inCkupv_codigo")String inCkupv_codigo,
		@WebParam(name="inCgg_ckupv_codigo")String inCgg_ckupv_codigo,
		@WebParam(name="inCgg_ckasg_codigo")String inCgg_ckasg_codigo,
		@WebParam(name="inCkasg_numero_asignacion")String inCkasg_numero_asignacion,
		@WebParam(name="inCkasg_fecha_recepcion")java.util.Date inCkasg_fecha_recepcion,
		@WebParam(name="inCkasg_cantidad")int inCkasg_cantidad,
		@WebParam(name="inCkasg_precio_unitario")java.math.BigDecimal inCkasg_precio_unitario,
		@WebParam(name="inCkasg_serie_inicio")int inCkasg_serie_inicio,
		@WebParam(name="inCkasg_serie_fin")int inCkasg_serie_fin,
		@WebParam(name="inCkasg_observacion")String inCkasg_observacion,
		@WebParam(name="inCkasg_cantidad_disponible")int inCkasg_cantidad_disponible,
		@WebParam(name="inCkasg_estado_asignacion")int inCkasg_estado_asignacion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_asignacion obj = new com.besixplus.sii.objects.Cgg_kdx_asignacion();
		obj.setCKASG_CODIGO("KEYGEN");
		obj.setCKTRN_CODIGO(inCktrn_codigo);
		obj.setCKUPV_CODIGO(inCkupv_codigo);
		obj.setCGG_CKUPV_CODIGO(inCgg_ckupv_codigo);
		obj.setCGG_CKASG_CODIGO(inCgg_ckasg_codigo);
		obj.setCKASG_NUMERO_ASIGNACION(inCkasg_numero_asignacion);
		obj.setCKASG_FECHA_RECEPCION(inCkasg_fecha_recepcion);
		obj.setCKASG_CANTIDAD(inCkasg_cantidad);
		obj.setCKASG_PRECIO_UNITARIO(inCkasg_precio_unitario);
		obj.setCKASG_SERIE_INICIO(inCkasg_serie_inicio);
		obj.setCKASG_SERIE_FIN(inCkasg_serie_fin);
		obj.setCKASG_OBSERVACION(inCkasg_observacion);
		obj.setCKASG_CANTIDAD_DISPONIBLE(inCkasg_cantidad_disponible);
		obj.setCKASG_ESTADO_ASIGNACION(inCkasg_estado_asignacion);
		obj.setCKASG_ESTADO(true);
		obj.setCKASG_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCKASG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_kdx_asignacion(obj).insert(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_asignacion.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_kdx_asignacion.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_asignacion.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_kdx_asignacion.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_asignacion.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_kdx_asignacion.
	* @param inCkasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	* @param inCktrn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA
	* @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @param inCgg_ckupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA
	* @param inCgg_ckasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION ANTERIOR
	* @param inCkasg_numero_asignacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION
	* @param inCkasg_fecha_recepcion FECHA DE RECEPCION DE LAS ESPECIES
	* @param inCkasg_cantidad CANTIDAD DE ESPECIES
	* @param inCkasg_precio_unitario PRECIO DE VENTA DE LA ESPECIE
	* @param inCkasg_serie_inicio SERIE DE INICIO DE LAS ESPECIES
	* @param inCkasg_serie_fin SERIE DE FIN DE LAS ESPECIES
	* @param inCkasg_observacion COMENTARIO AFIN A LA ASIGNACION
	* @param inCkasg_cantidad_disponible CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES
	* @param inCkasg_estado_asignacion ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
0.-  REGISTRADA
1.-  REASIGNADA
2.-  FINALIZADA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
		@WebParam(name="inCkasg_codigo")String inCkasg_codigo,
		@WebParam(name="inCktrn_codigo")String inCktrn_codigo,
		@WebParam(name="inCkupv_codigo")String inCkupv_codigo,
		@WebParam(name="inCgg_ckupv_codigo")String inCgg_ckupv_codigo,
		@WebParam(name="inCgg_ckasg_codigo")String inCgg_ckasg_codigo,
		@WebParam(name="inCkasg_numero_asignacion")String inCkasg_numero_asignacion,
		@WebParam(name="inCkasg_fecha_recepcion")java.util.Date inCkasg_fecha_recepcion,
		@WebParam(name="inCkasg_cantidad")int inCkasg_cantidad,
		@WebParam(name="inCkasg_precio_unitario")java.math.BigDecimal inCkasg_precio_unitario,
		@WebParam(name="inCkasg_serie_inicio")int inCkasg_serie_inicio,
		@WebParam(name="inCkasg_serie_fin")int inCkasg_serie_fin,
		@WebParam(name="inCkasg_observacion")String inCkasg_observacion,
		@WebParam(name="inCkasg_cantidad_disponible")int inCkasg_cantidad_disponible,
		@WebParam(name="inCkasg_estado_asignacion")int inCkasg_estado_asignacion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_asignacion obj = new com.besixplus.sii.objects.Cgg_kdx_asignacion();
		obj.setCKASG_CODIGO(inCkasg_codigo);
		obj.setCKTRN_CODIGO(inCktrn_codigo);
		obj.setCKUPV_CODIGO(inCkupv_codigo);
		obj.setCGG_CKUPV_CODIGO(inCgg_ckupv_codigo);
		obj.setCGG_CKASG_CODIGO(inCgg_ckasg_codigo);
		obj.setCKASG_NUMERO_ASIGNACION(inCkasg_numero_asignacion);
		obj.setCKASG_FECHA_RECEPCION(inCkasg_fecha_recepcion);
		obj.setCKASG_CANTIDAD(inCkasg_cantidad);
		obj.setCKASG_PRECIO_UNITARIO(inCkasg_precio_unitario);
		obj.setCKASG_SERIE_INICIO(inCkasg_serie_inicio);
		obj.setCKASG_SERIE_FIN(inCkasg_serie_fin);
		obj.setCKASG_OBSERVACION(inCkasg_observacion);
		obj.setCKASG_CANTIDAD_DISPONIBLE(inCkasg_cantidad_disponible);
		obj.setCKASG_ESTADO_ASIGNACION(inCkasg_estado_asignacion);
		obj.setCKASG_ESTADO(true);
		obj.setCKASG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_kdx_asignacion(obj).update(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_kdx_asignacion EN UNA ESTRUCTURA JSON o XML.
	 * @param inCkasg_codigo ckasg_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCkasg_codigo")String inCkasg_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_asignacion tmpObj = new com.besixplus.sii.objects.Cgg_kdx_asignacion();
		tmpObj.setCKASG_CODIGO(inCkasg_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_kdx_asignacion(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_asignacion>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_kdx_asignacion.
	 * @param inCkasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCkasg_codigo")String inCkasg_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_asignacion tmpObj = new com.besixplus.sii.objects.Cgg_kdx_asignacion();
		tmpObj.setCKASG_CODIGO(inCkasg_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_kdx_asignacion(tmpObj).delete(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_notificacion EN UNA ESTRUCTURA JSON o XML.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */

	@WebMethod
	public String numeroAsignacion(		
	)throws SOAPException{		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		String outNumeroTransferencia = null;
		try{
			Connection con = ManagerConnection.getConnection();
			com.besixplus.sii.objects.Cgg_kdx_asignacion tmpObjAsignacion =  new com.besixplus.sii.objects.Cgg_kdx_asignacion();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));

			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObjAsignacion.setCKASG_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
			outNumeroTransferencia = new com.besixplus.sii.db.Cgg_kdx_asignacion(tmpObjAsignacion).numeroAsignacion(con);
			con.close();
		}catch(SQLException inException){
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (outNumeroTransferencia != null)
			return outNumeroTransferencia;
		return null;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_notificacion EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */

	@WebMethod
	public String selectUsuarioPuntoVenta(
			@WebParam(name="format")String format
	)throws SOAPException{		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> outCgg_kdx_asignacion = new ArrayList<HashMap<String,Object>>();
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();

			com.besixplus.sii.objects.Cgg_kdx_asignacion tmpObjAsignacion =  new com.besixplus.sii.objects.Cgg_kdx_asignacion();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObjAsignacion.setCKASG_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
			outCgg_kdx_asignacion = com.besixplus.sii.db.Cgg_kdx_asignacion.selectUsuarioPuntoVenta(con, tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, outCgg_kdx_asignacion);
			con.close();
		}catch(SQLException inException){
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (outCgg_kdx_asignacion != null)
			return tmpFormat.getData().toString() ;
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_asignacion EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_kdx_asignacion.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_asignacion.selectAllDirect1(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inCgg_Ckupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO DE PUNTO DE VENTA
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectPageUsuarioRecibePV(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCgg_Ckupv_codigo")String inCgg_Ckupv_codigo		
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj =null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_kdx_asignacion.selectCountUsuarioRecibePV(con, keyword,inCgg_Ckupv_codigo);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_asignacion.selectUsuarioRecibePV(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword,inCgg_Ckupv_codigo);
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
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_asignacion.
	 * @param inCktrn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA TRANSFERENCIA.
	 * @param inCkupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA.
	 * @param inCgg_ckupv_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO PUNTO DE VENTA.
	 * @param inCgg_ckasg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION ANTERIOR.
	 * @param inCkasg_numero_asignacion NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA ASIGNACION.
	 * @param inCkasg_fecha_recepcion FECHA DE RECEPCION DE LAS ESPECIES.
	 * @param inCkasg_cantidad CANTIDAD DE ESPECIES.
	 * @param inCkasg_precio_unitario PRECIO DE VENTA DE LA ESPECIE.
	 * @param inCkasg_serie_inicio SERIE DE INICIO DE LAS ESPECIES.
	 * @param inCkasg_serie_fin SERIE DE FIN DE LAS ESPECIES.
	 * @param inCkasg_observacion COMENTARIO AFIN A LA ASIGNACION.
	 * @param inCkasg_cantidad_disponible CANTIDAD DE ESPECIES DISPONIBLES PARA ASIGNACIONES.
	 * 0.-  REGISTRADA
	 * 1.-  REASIGNADA
	 * 2.-  FINALIZADA.
	 * @param inCkasg_estado_asignacion ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
		0.-  REGISTRADA
		1.-  REASIGNADA
		2.-  FINALIZADA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert1(
			@WebParam(name="inCktrn_codigo")String inCktrn_codigo,
			@WebParam(name="inCkupv_codigo")String inCkupv_codigo,
			@WebParam(name="inCgg_ckupv_codigo")String inCgg_ckupv_codigo,
			@WebParam(name="inCgg_ckasg_codigo")String inCgg_ckasg_codigo,
			@WebParam(name="inCkasg_numero_asignacion")String inCkasg_numero_asignacion,
			@WebParam(name="inCkasg_fecha_recepcion")java.util.Date inCkasg_fecha_recepcion,
			@WebParam(name="inCkasg_cantidad")int inCkasg_cantidad,
			@WebParam(name="inCkasg_precio_unitario")java.math.BigDecimal inCkasg_precio_unitario,
			@WebParam(name="inCkasg_serie_inicio")int inCkasg_serie_inicio,
			@WebParam(name="inCkasg_serie_fin")int inCkasg_serie_fin,
			@WebParam(name="inCkasg_observacion")String inCkasg_observacion,
			@WebParam(name="inCkasg_cantidad_disponible")int inCkasg_cantidad_disponible,
			@WebParam(name="inCkasg_estado_asignacion")int inCkasg_estado_asignacion
	) throws SOAPException{
		String res = "true";
		String outCkasg_codigo = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_asignacion obj = new com.besixplus.sii.objects.Cgg_kdx_asignacion();
		obj.setCKASG_CODIGO("KEYGEN");
		obj.setCKTRN_CODIGO(inCktrn_codigo);
		obj.setCKUPV_CODIGO(inCkupv_codigo);
		obj.setCGG_CKUPV_CODIGO(inCgg_ckupv_codigo);
		obj.setCGG_CKASG_CODIGO(inCgg_ckasg_codigo);
		obj.setCKASG_NUMERO_ASIGNACION(inCkasg_numero_asignacion);
		obj.setCKASG_FECHA_RECEPCION(inCkasg_fecha_recepcion);
		obj.setCKASG_CANTIDAD(inCkasg_cantidad);
		obj.setCKASG_PRECIO_UNITARIO(inCkasg_precio_unitario);
		obj.setCKASG_SERIE_INICIO(inCkasg_serie_inicio);
		obj.setCKASG_SERIE_FIN(inCkasg_serie_fin);
		obj.setCKASG_OBSERVACION(inCkasg_observacion);
		obj.setCKASG_CANTIDAD_DISPONIBLE(inCkasg_cantidad_disponible);
		obj.setCKASG_ESTADO_ASIGNACION(inCkasg_estado_asignacion);
		obj.setCKASG_ESTADO(true);
		obj.setCKASG_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCKASG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			res = new com.besixplus.sii.db.Cgg_kdx_asignacion(obj).insert(con);
			outCkasg_codigo = obj.getCKASG_CODIGO();
			if (res.equals("true"))
			{ 
				//TODO inCkupv_codigo Verifica que la asignacion venga desde el punto de venta//
				if (inCgg_ckasg_codigo == null || inCgg_ckasg_codigo.trim().isEmpty() || inCgg_ckasg_codigo.trim().equals("null") )
				{
					com.besixplus.sii.objects.Cgg_kdx_transferencia objTransferencia = new com.besixplus.sii.objects.Cgg_kdx_transferencia();
					objTransferencia.setCKTRN_CODIGO(obj.getCKTRN_CODIGO());
					objTransferencia.setCKTRN_CANTIDAD(obj.getCKASG_CANTIDAD());
					objTransferencia.setCKTRN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_kdx_transferencia(objTransferencia).updateStock(con);
					if (res.equals("true"))
					{
						con.commit();
					}
					else
					{
						con.rollback();
					}
				}
				else
				{	
					obj = new com.besixplus.sii.objects.Cgg_kdx_asignacion();
					obj.setCKASG_CODIGO(inCgg_ckasg_codigo);
					obj.setCKASG_ESTADO_ASIGNACION(TIPOESTADOASIGNACION.REASIGNADA.getValue());
					obj.setCKASG_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_kdx_asignacion(obj).updateEstado(con);
					if (res.equals("true"))
					{
						con.commit();
					}
					else
					{
						con.rollback();
					}
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
		return outCkasg_codigo;
	}
	
	
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPageAsignacionPV(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format		
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj =null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_kdx_asignacion.selectCountAsignacionPV(con, keyword,tmpRequest.getUserPrincipal().getName());
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_asignacion.selectAsignacionPV(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_transferencia EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectStockPV(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format		
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj =null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_kdx_asignacion.selectCountStockPV(con, keyword,tmpRequest.getUserPrincipal().getName());
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_asignacion.selectStockPV(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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