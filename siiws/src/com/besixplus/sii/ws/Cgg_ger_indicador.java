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

/**
* CLASE Cgg_ger_indicador
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_ger_indicador POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_ger_indicador implements Serializable{

	private static final long serialVersionUID = 732358928;

	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_ger_indicador.
	* @param inCggit_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	* @param inCggin_nombre NOMBRE DEL INDICADOR.
	* @param inCggin_descripcion DESCRIPCION DEL INDICADOR.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCggit_codigo")String inCggit_codigo,
		/*@WebParam(name="inCusu_codigo")String inCusu_codigo,
		@WebParam(name="inCctn_codigo")String inCctn_codigo,*/
		@WebParam(name="inCggin_nombre")String inCggin_nombre,
		@WebParam(name="inCggin_descripcion")String inCggin_descripcion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_ger_indicador obj = new com.besixplus.sii.objects.Cgg_ger_indicador();
		obj.setCGGIN_CODIGO("KEYGEN");
		obj.setCGGIT_CODIGO(inCggit_codigo);
		/*obj.setCUSU_CODIGO(inCusu_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);*/
		obj.setCGGIN_NOMBRE(inCggin_nombre);
		obj.setCGGIN_DESCRIPCION(inCggin_descripcion);
		obj.setCGGIN_ESTADO(true);
		obj.setCGGIN_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCGGIN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_ger_indicador(obj).insert(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_ger_indicador EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_ger_indicador.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_ger_indicador EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_ger_indicador.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_ger_indicador.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_ger_indicador EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_ger_indicador.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_ger_indicador.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_ger_indicador.
	* @param inCggin_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCggit_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @param inCggin_nombre NOMBRE DEL INDICADOR
	* @param inCggin_descripcion DESCRIPCION DEL INDICADOR
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCggin_codigo")String inCggin_codigo,
		@WebParam(name="inCggit_codigo")String inCggit_codigo,		
		/*@WebParam(name="inCusu_codigo")String inCusu_codigo,
		@WebParam(name="inCctn_codigo")String inCctn_codigo,*/
		@WebParam(name="inCggin_nombre")String inCggin_nombre,
		@WebParam(name="inCggin_descripcion")String inCggin_descripcion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_ger_indicador obj = new com.besixplus.sii.objects.Cgg_ger_indicador();
		obj.setCGGIN_CODIGO(inCggin_codigo);
		obj.setCGGIT_CODIGO(inCggit_codigo);
		/*obj.setCUSU_CODIGO(inCusu_codigo);
		obj.setCUSU_CODIGO(inCusu_codigo);*/
		obj.setCGGIN_NOMBRE(inCggin_nombre);
		obj.setCGGIN_DESCRIPCION(inCggin_descripcion);
		obj.setCGGIN_ESTADO(true);
		obj.setCGGIN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_ger_indicador(obj).update(con);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_ger_indicador EN UNA ESTRUCTURA JSON o XML.
	* @param inCggin_codigo cggin_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCggin_codigo")String inCggin_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_ger_indicador tmpObj = new com.besixplus.sii.objects.Cgg_ger_indicador();
		tmpObj.setCGGIN_CODIGO(inCggin_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_ger_indicador(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_ger_indicador>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_ger_indicador.
	* @param inCggin_codigo IDENTIFICATIVO UNICO DE REGISTRO
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCggin_codigo")String inCggin_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_ger_indicador tmpObj = new com.besixplus.sii.objects.Cgg_ger_indicador();
		tmpObj.setCGGIN_CODIGO(inCggin_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_ger_indicador(tmpObj).delete(con);
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

}