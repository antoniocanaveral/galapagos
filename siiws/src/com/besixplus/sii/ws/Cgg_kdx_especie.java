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

/**
* CLASE Cgg_kdx_especie
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_kdx_especie POR MEDIO DE SERVICIOS WEB.
*
* @autor BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_kdx_especie implements Serializable{

	private static final long serialVersionUID = 1882682286;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_kdx_especie.
	* @param inCkesp_nombre NOMBRE DEL TIPO DE ESPECIE.
	* @param inCkesp_precio VALOR DE VENTA DE LA ESPECIE.
	* @param inCkesp_cantidad CANTIDAD DISPONIBLE DE LA ESPECIE.
	* @param inCkesp_disponible_min CANTIDAD MINIMA DE DISPONIBILIDAD.
	* @param inCkesp_disponible_max CANTIDAD MAXIMA DE DISPONIBILIDAD.
	* @param inCkesp_tipo TIPO DE ESPECIE
0 - RESIDENCIA
1 - TCT
2 - OTROS.
	* @param inCkesp_indice INDICE DE LA ESPECIE DENTRO DE LA CATEGORIA.
	* @param inCkesp_reporte NOMBRE DEL REPORTE QUE SE APLICA A ESTA ESPECIE.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCkesp_nombre")String inCkesp_nombre,
		@WebParam(name="inCkesp_precio")java.math.BigDecimal inCkesp_precio,
		@WebParam(name="inCkesp_cantidad")int inCkesp_cantidad,
		@WebParam(name="inCkesp_disponible_min")int inCkesp_disponible_min,
		@WebParam(name="inCkesp_disponible_max")int inCkesp_disponible_max,
		@WebParam(name="inCkesp_tipo")int inCkesp_tipo,
		@WebParam(name="inCkesp_indice")int inCkesp_indice,
		@WebParam(name="inCkesp_reporte")String inCkesp_reporte
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_especie obj = new com.besixplus.sii.objects.Cgg_kdx_especie();
		obj.setCKESP_CODIGO("KEYGEN");
		obj.setCKESP_NOMBRE(inCkesp_nombre);
		obj.setCKESP_PRECIO(inCkesp_precio);
		obj.setCKESP_CANTIDAD(inCkesp_cantidad);
		obj.setCKESP_DISPONIBLE_MIN(inCkesp_disponible_min);
		obj.setCKESP_DISPONIBLE_MAX(inCkesp_disponible_max);
		obj.setCKESP_TIPO(inCkesp_tipo);
		obj.setCKESP_INDICE(inCkesp_indice);
		obj.setCKESP_REPORTE(inCkesp_reporte);
		obj.setCKESP_ESTADO(true);
		obj.setCKESP_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCKESP_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_kdx_especie(obj).insert(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_kdx_especie EN UNA ESTRUCTURA JSON o XML.
	* @param inCkesp_tipo TIPO DE ESPECIES QUE SE QUIERE OBTENER.
	* @param format FORMATO DE SALIDA DE LA INFORMACION.
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectAll(
			@WebParam(name="inCkesp_tipo")int inCkesp_tipo,
		@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_especie.selectAll(con, tmpRequest.getUserPrincipal().getName(), inCkesp_tipo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			return outCadena.toString();
		return null;
	}

	/**
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_especie EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_kdx_especie.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_especie.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}


	/**
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_kdx_especie.
	* @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	* @param inCkesp_nombre NOMBRE DEL TIPO DE ESPECIE
	* @param inCkesp_precio VALOR DE VENTA DE LA ESPECIE
	* @param inCkesp_cantidad CANTIDAD DISPONIBLE DE LA ESPECIE
	* @param inCkesp_disponible_min CANTIDAD MINIMA DE DISPONIBILIDAD
	* @param inCkesp_disponible_max CANTIDAD MAXIMA DE DISPONIBILIDAD
	* @param inCkesp_tipo TIPO DE ESPECIE
0 - RESIDENCIA
1 - TCT
2 - OTROS
	* @param inCkesp_indice INDICE DE LA ESPECIE DENTRO DE LA CATEGORIA
	* @param inCkesp_reporte NOMBRE DEL REPORTE QUE SE APLICA A ESTA ESPECIE
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCkesp_codigo")String inCkesp_codigo,
		@WebParam(name="inCkesp_nombre")String inCkesp_nombre,
		@WebParam(name="inCkesp_precio")java.math.BigDecimal inCkesp_precio,
		@WebParam(name="inCkesp_cantidad")int inCkesp_cantidad,
		@WebParam(name="inCkesp_disponible_min")int inCkesp_disponible_min,
		@WebParam(name="inCkesp_disponible_max")int inCkesp_disponible_max,
		@WebParam(name="inCkesp_tipo")int inCkesp_tipo,
		@WebParam(name="inCkesp_indice")int inCkesp_indice,
		@WebParam(name="inCkesp_reporte")String inCkesp_reporte
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_especie obj = new com.besixplus.sii.objects.Cgg_kdx_especie();
		obj.setCKESP_CODIGO(inCkesp_codigo);
		obj.setCKESP_NOMBRE(inCkesp_nombre);
		obj.setCKESP_PRECIO(inCkesp_precio);
		obj.setCKESP_CANTIDAD(inCkesp_cantidad);
		obj.setCKESP_DISPONIBLE_MIN(inCkesp_disponible_min);
		obj.setCKESP_DISPONIBLE_MAX(inCkesp_disponible_max);
		obj.setCKESP_TIPO(inCkesp_tipo);
		obj.setCKESP_INDICE(inCkesp_indice);
		obj.setCKESP_REPORTE(inCkesp_reporte);
		obj.setCKESP_ESTADO(true);
		obj.setCKESP_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_kdx_especie(obj).update(con);
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}return res;
	}


	/**
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_kdx_especie EN UNA ESTRUCTURA JSON o XML.
	* @param inCkesp_codigo ckesp_codigo
	* @param format 
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCkesp_codigo")String inCkesp_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_especie tmpObj = new com.besixplus.sii.objects.Cgg_kdx_especie();
		tmpObj.setCKESP_CODIGO(inCkesp_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_kdx_especie(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}


	/**
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_kdx_especie.
	* @param inCkesp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCkesp_codigo")String inCkesp_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_kdx_especie tmpObj = new com.besixplus.sii.objects.Cgg_kdx_especie();
		tmpObj.setCKESP_CODIGO(inCkesp_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_kdx_especie(tmpObj).delete(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}
	/**
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_kdx_especie EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	* @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	* @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	* @param keyword CRITERIO DE BUSQUEDA.
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectTipoEspecieTCT(	
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
			
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_kdx_especie.selectTipoEspecie(con);
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

}