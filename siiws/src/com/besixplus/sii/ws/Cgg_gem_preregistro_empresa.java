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
* CLASE Cgg_gem_preregistro_empresa
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_preregistro_empresa POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_gem_preregistro_empresa implements Serializable{

	private static final long serialVersionUID = 1996947463;

	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_preregistro_empresa.
	* @param inCgpre_razon_social DESCRIPCION SOBRE LA RAZON SOCIAL.
	* @param inCgpre_ruc RUC ESPECIFICO DE LA EMPRESA.
	* @param inCgpre_representante REPRESENTANTE DE LA EMPRESA.
	* @param inCgpre_fecha_creacion FECHA DE CREACION DE LA EMPRESA.
	* @param inCgpre_actividad ACTIVIDAD A LA QUE SE DEDICA LA EMPRESA (ACTIVIDAD DEL RUC).
	* @param inCgpre_direccion DIRECCION DE LA EMPRESA.
	* @param inCgpre_sector SECTOR DE LA EMPRESA.
	* @param inCgpre_tipo TIPO DE EMPRESA.
	* @param inCgpre_numero_empleado NUMERO DE EMPLEADOS QUE TIENE LA EMPRESA.
	* @param inCgpre_telefono CONTACTO TELEFONICO DE LA EMPRESA.
	* @param inCgpre_email EMAIL DE LA EMPRESA.
	* @param inCgpre_cedula CEDULA DE LA PERSONA RESPONSABLE DE PUBLICAR LAS OFERTAS.
	* @param inCgpre_adjunto ADJUNTO REFERENTE A LA EMPRESA.
	* @param inCgpre_tipo_adjunto TIPO O EXTENCION DEL ARCHIVO ADJUNTO.
	* @param inCgpre_nombre_adjunto NOMBRE DEL ARCHIVO ADJUNTO.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCgpre_razon_social")String inCgpre_razon_social,
		@WebParam(name="inCgpre_ruc")String inCgpre_ruc,
		@WebParam(name="inCgpre_representante")String inCgpre_representante,
		@WebParam(name="inCgpre_fecha_creacion")java.util.Date inCgpre_fecha_creacion,
		@WebParam(name="inCgpre_actividad")String inCgpre_actividad,
		@WebParam(name="inCgpre_direccion")String inCgpre_direccion,
		@WebParam(name="inCgpre_sector")String inCgpre_sector,
		@WebParam(name="inCgpre_tipo")String inCgpre_tipo,
		@WebParam(name="inCgpre_numero_empleado")int inCgpre_numero_empleado/*,
		@WebParam(name="inCgpre_telefono")String inCgpre_telefono,
		@WebParam(name="inCgpre_email")String inCgpre_email,
		@WebParam(name="inCgpre_cedula")String inCgpre_cedula,
		@WebParam(name="inCgpre_adjunto")String inCgpre_adjunto,
		@WebParam(name="inCgpre_tipo_adjunto")String inCgpre_tipo_adjunto,
		@WebParam(name="inCgpre_nombre_adjunto")String inCgpre_nombre_adjunto*/
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_gem_preregistro_empresa obj = new com.besixplus.sii.objects.Cgg_gem_preregistro_empresa();
		obj.setCGPRE_CODIGO("KEYGEN");
		obj.setCGPRE_RAZON_SOCIAL(inCgpre_razon_social);
		obj.setCGPRE_RUC(inCgpre_ruc);
		obj.setCGPRE_REPRESENTANTE(inCgpre_representante);
		obj.setCGPRE_FECHA_CREACION(inCgpre_fecha_creacion);
		obj.setCGPRE_ACTIVIDAD(inCgpre_actividad);
		obj.setCGPRE_DIRECCION(inCgpre_direccion);
		obj.setCGPRE_SECTOR(inCgpre_sector);
		obj.setCGPRE_TIPO(inCgpre_tipo);
		obj.setCGPRE_NUMERO_EMPLEADO(inCgpre_numero_empleado);
		/*obj.setCGPRE_TELEFONO(inCgpre_telefono);
		obj.setCGPRE_EMAIL(inCgpre_email);
		obj.setCGPRE_CEDULA(inCgpre_cedula);
		obj.setCGPRE_ADJUNTO(org.jboss.util.Base64.decode(inCgpre_adjunto));
		obj.setCGPRE_TIPO_ADJUNTO(inCgpre_tipo_adjunto);
		obj.setCGPRE_NOMBRE_ADJUNTO(inCgpre_nombre_adjunto);*/
		obj.setCGPRE_ESTADO(true);
		if (tmpRequest.getUserPrincipal()!=null)
			obj.setCGPRE_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		else
			obj.setCGPRE_USUARIO_INSERT("");
		if (tmpRequest.getUserPrincipal()!=null)
			obj.setCGPRE_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		else
			obj.setCGPRE_USUARIO_UPDATE("");
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_gem_preregistro_empresa(obj).insert(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_preregistro_empresa EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_gem_preregistro_empresa.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_gem_preregistro_empresa EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_gem_preregistro_empresa.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_gem_preregistro_empresa.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_gem_preregistro_empresa EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_gem_preregistro_empresa.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_gem_preregistro_empresa.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_gem_preregistro_empresa.
	* @param inCgpre_codigo IDENTIFICATIVO UNICO DEL PRE-REGISTRO DE EMPRESAS
	* @param inCgpre_razon_social DESCRIPCION SOBRE LA RAZON SOCIAL
	* @param inCgpre_ruc RUC ESPECIFICO DE LA EMPRESA
	* @param inCgpre_representante REPRESENTANTE DE LA EMPRESA
	* @param inCgpre_fecha_creacion FECHA DE CREACION DE LA EMPRESA
	* @param inCgpre_actividad ACTIVIDAD A LA QUE SE DEDICA LA EMPRESA (ACTIVIDAD DEL RUC)
	* @param inCgpre_direccion DIRECCION DE LA EMPRESA
	* @param inCgpre_sector SECTOR DE LA EMPRESA
	* @param inCgpre_tipo TIPO DE EMPRESA
	* @param inCgpre_numero_empleado NUMERO DE EMPLEADOS QUE TIENE LA EMPRESA
	* @param inCgpre_telefono CONTACTO TELEFONICO DE LA EMPRESA
	* @param inCgpre_email EMAIL DE LA EMPRESA
	* @param inCgpre_cedula CEDULA DE LA PERSONA RESPONSABLE DE PUBLICAR LAS OFERTAS
	* @param inCgpre_adjunto ADJUNTO REFERENTE A LA EMPRESA
	* @param inCgpre_tipo_adjunto TIPO O EXTENCION DEL ARCHIVO ADJUNTO
	* @param inCgpre_nombre_adjunto NOMBRE DEL ARCHIVO ADJUNTO
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCgpre_codigo")String inCgpre_codigo,
		@WebParam(name="inCgpre_razon_social")String inCgpre_razon_social,
		@WebParam(name="inCgpre_ruc")String inCgpre_ruc,
		@WebParam(name="inCgpre_representante")String inCgpre_representante,
		@WebParam(name="inCgpre_fecha_creacion")java.util.Date inCgpre_fecha_creacion,
		@WebParam(name="inCgpre_actividad")String inCgpre_actividad,
		@WebParam(name="inCgpre_direccion")String inCgpre_direccion,
		@WebParam(name="inCgpre_sector")String inCgpre_sector,
		@WebParam(name="inCgpre_tipo")String inCgpre_tipo,
		@WebParam(name="inCgpre_numero_empleado")int inCgpre_numero_empleado,
		@WebParam(name="inCgpre_telefono")String inCgpre_telefono,
		@WebParam(name="inCgpre_email")String inCgpre_email,
		@WebParam(name="inCgpre_cedula")String inCgpre_cedula,
		@WebParam(name="inCgpre_adjunto")String inCgpre_adjunto,
		@WebParam(name="inCgpre_tipo_adjunto")String inCgpre_tipo_adjunto,
		@WebParam(name="inCgpre_nombre_adjunto")String inCgpre_nombre_adjunto
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_gem_preregistro_empresa obj = new com.besixplus.sii.objects.Cgg_gem_preregistro_empresa();
		obj.setCGPRE_CODIGO(inCgpre_codigo);
		obj.setCGPRE_RAZON_SOCIAL(inCgpre_razon_social);
		obj.setCGPRE_RUC(inCgpre_ruc);
		obj.setCGPRE_REPRESENTANTE(inCgpre_representante);
		obj.setCGPRE_FECHA_CREACION(inCgpre_fecha_creacion);
		obj.setCGPRE_ACTIVIDAD(inCgpre_actividad);
		obj.setCGPRE_DIRECCION(inCgpre_direccion);
		obj.setCGPRE_SECTOR(inCgpre_sector);
		obj.setCGPRE_TIPO(inCgpre_tipo);
		obj.setCGPRE_NUMERO_EMPLEADO(inCgpre_numero_empleado);
		obj.setCGPRE_TELEFONO(inCgpre_telefono);
		obj.setCGPRE_EMAIL(inCgpre_email);
		obj.setCGPRE_CEDULA(inCgpre_cedula);
		obj.setCGPRE_ADJUNTO(org.jboss.util.Base64.decode(inCgpre_adjunto));
		obj.setCGPRE_TIPO_ADJUNTO(inCgpre_tipo_adjunto);
		obj.setCGPRE_NOMBRE_ADJUNTO(inCgpre_nombre_adjunto);
		obj.setCGPRE_ESTADO(true);
		obj.setCGPRE_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_gem_preregistro_empresa(obj).update(con);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_gem_preregistro_empresa EN UNA ESTRUCTURA JSON o XML.
	* @param inCgpre_codigo cgpre_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCgpre_codigo")String inCgpre_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_gem_preregistro_empresa tmpObj = new com.besixplus.sii.objects.Cgg_gem_preregistro_empresa();
		tmpObj.setCGPRE_CODIGO(inCgpre_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_gem_preregistro_empresa(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_gem_preregistro_empresa.
	* @param inCgpre_codigo IDENTIFICATIVO UNICO DEL PRE-REGISTRO DE EMPRESAS
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCgpre_codigo")String inCgpre_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_gem_preregistro_empresa tmpObj = new com.besixplus.sii.objects.Cgg_gem_preregistro_empresa();
		tmpObj.setCGPRE_CODIGO(inCgpre_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_gem_preregistro_empresa(tmpObj).delete(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_sector_productivo EN UNA ESTRUCTURA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	@WebMethod
	public String selecSectorAll(
		@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		@SuppressWarnings("unused")
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_sector_productivo> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();							
			con.setAutoCommit(!ManagerConnection.isDeployed());
			if (tmpRequest.getUserPrincipal()!=null)
				obj = com.besixplus.sii.db.Cgg_sector_productivo.selectAll(con, tmpRequest.getUserPrincipal().getName());
			else
				obj = com.besixplus.sii.db.Cgg_sector_productivo.selectAll(con, "");
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			return outCadena.toString();
		return null;
	}
	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_sector EN UNA ESTRUCTRA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	@WebMethod
	public String selectTitoAll(
		@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_veh_sector> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();			
			con.setAutoCommit(!ManagerConnection.isDeployed());
			if(tmpRequest.getUserPrincipal()!=null)
				obj = com.besixplus.sii.db.Cgg_veh_sector.selectAll(con, tmpRequest.getUserPrincipal().getName());
			else
				obj = com.besixplus.sii.db.Cgg_veh_sector.selectAll(con, "");
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_gem_preregistro_empresa EN UNA ESTRUCTURA JSON o XML.
	* @param inCrpjr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA.
	* @param inCgpre_codigo cgpre_codigo
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectCodigoByRUC(
		@WebParam(name="inCrpjr_codigo")String inCrpjr_codigo
	) throws SOAPException{
		//com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//com.besixplus.sii.objects.Cgg_gem_preregistro_empresa tmpObj = new com.besixplus.sii.objects.Cgg_gem_preregistro_empresa();
		//tmpObj.setCGPRE_CODIGO(inCrpjr_codigo);
		String tmpObj = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//new com.besixplus.sii.db.Cgg_gem_preregistro_empresa(tmpObj);
			//tmpCount = com.besixplus.sii.db.Cgg_gem_preregistro_empresa.selectCount(con, keyword);
			tmpObj = com.besixplus.sii.db.Cgg_gem_preregistro_empresa.selectCodigoByRUC(con,inCrpjr_codigo);
			//ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_gem_preregistro_empresa>();
			//tmpArray.add(tmpObj);
			//tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpObj != null)
			return tmpObj;//tmpFormat.getData().toString();
		return null;
	}
}