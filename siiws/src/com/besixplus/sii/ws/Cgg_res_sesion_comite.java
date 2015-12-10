package com.besixplus.sii.ws;

import java.util.ArrayList;
import java.util.HashMap;
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
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;

/**
 * CLASE Cgg_res_sesion_comite
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_sesion_comite POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_sesion_comite implements Serializable{

	private static final long serialVersionUID = 759103213;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_sesion_comite.
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA.
	 * @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	 * @param inCrssc_fecha_reunion FECHA DE REALIZACION DE LA SESION.
	 * @param inCrssc_fecha_finalizacion FECHA DE FINALIZACION DE SESION  .
	 * @param inCrssc_numero_sesion NUMERO IDENTIFICATIVO DE LA SESION.
	 * @param inCrssc_extracto RESUMEN DEL CONTENIDO DE LA SESION.
	 * @param inCrssc_observacion OBSERVACIONES DE LA SESION.
	 * @param inCrssc_fecha_convocatoria FECHA DE REALIZACION DE LA CONVOCATORIA PARA LA SESION.
	 * @param inCrssc_motivo_convocatoria RESUMEN DE LOS TEMAS A TRATARSE EN LA SESION.
	 * @param inCrssc_descripcion_adjunto DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS A LA SESION.
	 * @param inCrssc_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO.
	 * @param inCrssc_adjunto ARCHIVO DIGITAL ANEXO A LA SESION.
	 * @param inCrssc_estado_convocatoria ESTADO DE LA CONVOCATORIA
0 - REGISTRADA
1 - APROBADA
2 - ANULADA
3 - EN PROCESO
4- SUSPENDIDA.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name="inCrcom_codigo")String inCrcom_codigo,
			@WebParam(name="inCrssc_fecha_reunion")java.util.Date inCrssc_fecha_reunion,
			@WebParam(name="inCrssc_fecha_finalizacion")java.util.Date inCrssc_fecha_finalizacion,
			@WebParam(name="inCrssc_numero_sesion")String inCrssc_numero_sesion,
			@WebParam(name="inCrssc_extracto")String inCrssc_extracto,
			@WebParam(name="inCrssc_observacion")String inCrssc_observacion,
			@WebParam(name="inCrssc_fecha_convocatoria")java.util.Date inCrssc_fecha_convocatoria,
			@WebParam(name="inCrssc_motivo_convocatoria")String inCrssc_motivo_convocatoria,
			@WebParam(name="inCrssc_descripcion_adjunto")String inCrssc_descripcion_adjunto,
			@WebParam(name="inCrssc_nombre_adjunto")String inCrssc_nombre_adjunto,
			@WebParam(name="inCrssc_adjunto")String inCrssc_adjunto,
			@WebParam(name="inCrssc_estado_convocatoria")int inCrssc_estado_convocatoria		
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_sesion_comite obj = new com.besixplus.sii.objects.Cgg_res_sesion_comite();
		obj.setCRSSC_CODIGO("KEYGEN");
		obj.setCISLA_CODIGO(inCisla_codigo);
		obj.setCRCOM_CODIGO(inCrcom_codigo);
		obj.setCRSSC_FECHA_REUNION(inCrssc_fecha_reunion);
		obj.setCRSSC_FECHA_FINALIZACION(inCrssc_fecha_finalizacion);
		obj.setCRSSC_NUMERO_SESION(inCrssc_numero_sesion);
		obj.setCRSSC_EXTRACTO(inCrssc_extracto);
		obj.setCRSSC_OBSERVACION(inCrssc_observacion);
		obj.setCRSSC_FECHA_CONVOCATORIA(inCrssc_fecha_convocatoria);
		obj.setCRSSC_MOTIVO_CONVOCATORIA(inCrssc_motivo_convocatoria);
		obj.setCRSSC_DESCRIPCION_ADJUNTO(inCrssc_descripcion_adjunto);
		obj.setCRSSC_NOMBRE_ADJUNTO(inCrssc_nombre_adjunto);
		obj.setCRSSC_ADJUNTO(org.jboss.util.Base64.decode(inCrssc_adjunto));
		obj.setCRSSC_ESTADO_CONVOCATORIA(inCrssc_estado_convocatoria);
		obj.setCRSSC_ESTADO(true);
		obj.setCRSSC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRSSC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_sesion_comite(obj).insert(con);			
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite EN UNA ESTRUCTRA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_sesion_comite.selectAll(con, tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (obj != null)
			return outCadena.toString();
		return null;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_sesion_comite.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_sesion_comite.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_sesion_comite.
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	 * @param inCisla_codigo IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
	 * @param inCrcom_codigo IDENTIFICATIVO UNICO DE REGISTRO
	 * @param inCrssc_fecha_reunion FECHA DE REALIZACION DE LA SESION
	 * @param inCrssc_fecha_finalizacion FECHA DE FINALIZACION DE SESION  
	 * @param inCrssc_numero_sesion NUMERO IDENTIFICATIVO DE LA SESION
	 * @param inCrssc_extracto RESUMEN DEL CONTENIDO DE LA SESION
	 * @param inCrssc_observacion OBSERVACIONES DE LA SESION
	 * @param inCrssc_fecha_convocatoria FECHA DE REALIZACION DE LA CONVOCATORIA PARA LA SESION
	 * @param inCrssc_motivo_convocatoria RESUMEN DE LOS TEMAS A TRATARSE EN LA SESION
	 * @param inCrssc_descripcion_adjunto DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS A LA SESION
	 * @param inCrssc_nombre_adjunto NOMBRE DEL DOCUMENTO ADJUNTO
	 * @param inCrssc_adjunto ARCHIVO DIGITAL ANEXO A LA SESION
	 * @param inCrssc_estado_convocatoria ESTADO DE LA CONVOCATORIA
0 - REGISTRADA
1 - APROBADA
2 - ANULADA
3 - EN PROCESO
4- SUSPENDIDA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrssc_codigo")String inCrssc_codigo,
			@WebParam(name="inCisla_codigo")String inCisla_codigo,
			@WebParam(name="inCrcom_codigo")String inCrcom_codigo,
			@WebParam(name="inCrssc_fecha_reunion")java.util.Date inCrssc_fecha_reunion,
			@WebParam(name="inCrssc_fecha_finalizacion")java.util.Date inCrssc_fecha_finalizacion,
			@WebParam(name="inCrssc_numero_sesion")String inCrssc_numero_sesion,
			@WebParam(name="inCrssc_extracto")String inCrssc_extracto,
			@WebParam(name="inCrssc_observacion")String inCrssc_observacion,
			@WebParam(name="inCrssc_fecha_convocatoria")java.util.Date inCrssc_fecha_convocatoria,
			@WebParam(name="inCrssc_motivo_convocatoria")String inCrssc_motivo_convocatoria,
			@WebParam(name="inCrssc_descripcion_adjunto")String inCrssc_descripcion_adjunto,
			@WebParam(name="inCrssc_nombre_adjunto")String inCrssc_nombre_adjunto,
			@WebParam(name="inCrssc_adjunto")String inCrssc_adjunto,
			@WebParam(name="inCrssc_estado_convocatoria")int inCrssc_estado_convocatoria
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_sesion_comite obj = new com.besixplus.sii.objects.Cgg_res_sesion_comite();
		obj.setCRSSC_CODIGO(inCrssc_codigo);
		obj.setCISLA_CODIGO(inCisla_codigo);
		obj.setCRCOM_CODIGO(inCrcom_codigo);
		obj.setCRSSC_FECHA_REUNION(inCrssc_fecha_reunion);
		obj.setCRSSC_FECHA_FINALIZACION(inCrssc_fecha_finalizacion);
		obj.setCRSSC_NUMERO_SESION(inCrssc_numero_sesion);
		obj.setCRSSC_EXTRACTO(inCrssc_extracto);
		obj.setCRSSC_OBSERVACION(inCrssc_observacion);
		obj.setCRSSC_FECHA_CONVOCATORIA(inCrssc_fecha_convocatoria);
		obj.setCRSSC_MOTIVO_CONVOCATORIA(inCrssc_motivo_convocatoria);
		obj.setCRSSC_DESCRIPCION_ADJUNTO(inCrssc_descripcion_adjunto);
		obj.setCRSSC_NOMBRE_ADJUNTO(inCrssc_nombre_adjunto);
		obj.setCRSSC_ADJUNTO(org.jboss.util.Base64.decode(inCrssc_adjunto));
		obj.setCRSSC_ESTADO_CONVOCATORIA(inCrssc_estado_convocatoria);
		obj.setCRSSC_ESTADO(true);
		obj.setCRSSC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_sesion_comite(obj).update(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_sesion_comite EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrssc_codigo crssc_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrssc_codigo")String inCrssc_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_sesion_comite tmpObj = new com.besixplus.sii.objects.Cgg_res_sesion_comite();
		tmpObj.setCRSSC_CODIGO(inCrssc_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_sesion_comite(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}


	/**
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_sesion_comite.
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrssc_codigo")String inCrssc_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_sesion_comite tmpObj = new com.besixplus.sii.objects.Cgg_res_sesion_comite();
		tmpObj.setCRSSC_CODIGO(inCrssc_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_res_sesion_comite(tmpObj).delete(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return new Boolean(outResult).toString();
	}
	
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * LISTADO DE RESOLUCIONES EN ESPERA DE VOTACION UTILIZADO PARA LA SELECCION.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @param inCrssc_codigo 
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String tramiteSelect(	
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCrssc_codigo")String inCrssc_codigo
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
			new com.besixplus.sii.db.Cgg_res_sesion_comite();
			tmpCount = com.besixplus.sii.db.Cgg_res_sesion_comite.tramitesSesionCount(con, inCrssc_codigo, keyword);
			obj = com.besixplus.sii.db.Cgg_res_sesion_comite.tramitesSesion(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword,inCrssc_codigo);			
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_tipo_solicitud EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * SELECCIONA LOS TRAMITES ASIGNADOS A UN SESION DE COMITE.
	 * @param inCrssc_codigo INDENTIFICATIVO UNICO DE REGISTRO DE SESION DE COMITE
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectTramite(
			@WebParam(name="inCrssc_codigo")String inCrssc_codigo,
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
			com.besixplus.sii.objects.Cgg_res_sesion_comite tmpC = new com.besixplus.sii.objects.Cgg_res_sesion_comite();
			tmpC.setTRAMITE(inCrssc_codigo);	

			obj = new com.besixplus.sii.db.Cgg_res_sesion_comite(tmpC).selectCGG_RES_SESION_TRAMITE(con,inCrssc_codigo);			
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPageAprobada(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_sesion_comite> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_sesion_comite.selectCountAprobado(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());   
			obj = com.besixplus.sii.db.Cgg_res_sesion_comite.selectAllAprobado(con,tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_sesion_comite EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION DE COMITE
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
	public String selectSesionAdjunto(
			@WebParam(name="inCrssc_codigo")String inCrssc_codigo,
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
			obj = com.besixplus.sii.db.Cgg_res_sesion_comite.selectAllSesionAdjunto(con, inCrssc_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return "{\"dataSet\":"+outCadena.toString()+"}";
			else
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}
	
	/**
	 * OBTIENE LOS VOTOS DE LAS RESOLUCIONES TRATADAS EN UNA SESION
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param inCrssc_codigo CODIGO DE SESION DE COMITE
	 * @param inTramites <code>true</code> OBTIENE LOS VOTOS DE RESOLUCIONES ASOCIADAS A UNA SESION
	 * @param format FORMATO DE SALIDA DE LA INFORMACION JSON o XML
	 * @return
	 * @throws SOAPException
	 */
	@WebMethod
	public String selectTramiteVotos(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCrssc_codigo")String inCrssc_codigo,
			@WebParam(name="inTramites")boolean inTramites
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
			com.besixplus.sii.objects.Cgg_res_sesion_comite tmpC = new com.besixplus.sii.objects.Cgg_res_sesion_comite();
			tmpC.setCRSSC_CODIGO(inCrssc_codigo);	
			tmpCount = new com.besixplus.sii.db.Cgg_res_sesion_comite(tmpC).selectVotosCount(con, keyword, inTramites);
			obj = new com.besixplus.sii.db.Cgg_res_sesion_comite(tmpC).selectVotos(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inTramites);			
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