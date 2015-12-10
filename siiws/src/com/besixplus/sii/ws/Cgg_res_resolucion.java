package com.besixplus.sii.ws;

import java.io.Serializable;
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
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import com.besixplus.sii.db.Cgg_res_resol_tramite;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;

/**
* CLASE Cgg_res_resolucion
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_resolucion POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_resolucion implements Serializable{

	private static final long serialVersionUID = 1988742181;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_resolucion.
	* @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION.
	* @param inCrres_numero_resolucion NUMERO IDENTIFICATIVO DE LA RESOLUCION.
	* @param inCrres_tipo TIPO DE RESOLUCION
0 - NORMATIVA
1 - APROBACION.
	 * @param inCrres_observaciones OBSERVACIONES CONSIDERADAS PARA LA RESOLUCION.
	 * @param inCrres_extracto_resolucion RESUMEN DEL CONTENIDO DE LA RESOLUCION.
	 * @param inCrres_votos_aprobacion NUMERO DE VOTOS A FAVOR DE LA RESOLUCION.
	 * @param inCrres_votos_negacion NUMERO DE VOTOS EN CONTRA DE LA RESOLUCION.
	 * @param inCrres_votos_abstencion NUMERO DE VOTOS DE ABSTENCION.
	 * @param inCrres_fecha_emision FECHA DE EMISION DE RESULTADO DE LA RESOLUCION.
	 * @param inCrres_fecha_ejecucion FECHA DE EJECUCION O LLEVADA A LA PRACTICA.
	 * @param inCrres_fecha_anulacion FECHA DE ANULACION O PERDIDA DE LA VIGENCIA.
	 * @param inCrres_fecha_confirmacion FECHA DE CONFIRMACION DE LA RESOLUCION EN LA QUE EL ADMINISTRADOR FINALMENTE CONFIRMO UNA RESIDENCIA..
	 * @param inCrres_resolucion_reemplaza RESOLUCION POR LA QUE PUDO SER REEMPLAZA LA ACTUAL.
	 * @param inCrres_nombre_adjunto_resol NOMBRE DEL DOCUMENTO ADJUNTO.
	 * @param inCrres_adjunto_resolucion ARCHIVO DIGITAL ANEXO A LA RESOLUCION.
	 * @param inCrres_descripcion_adjunto DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS.
	 * @param inCrres_fecha_apelacion FECHA DE APELACION A LA RESOLUCION.
	 * @param inCrres_extracto_apelacion EXTRACTO DE LA APELACION.
	 * @param inCrres_numero_apelacion NUMERO DE DOCUMENTO DE APELACION.
	 * @param inCrres_nombre_adjunto_apelac NOMBRE DEL DOCUMENTO ADJUNTO.
	 * @param inCrres_adjunto_apelacion ARCHIVO ADJUNTO A LA APELACION.
	 * @param inCrres_estado_resolucion ESTADO DE LA RESOLUCION:
0 - ESPERANDO VOTACION
1 - APROBADA
2 - NEGADA
3 - EJECUTADA
4 - ANULADA.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrssc_codigo")String inCrssc_codigo,
			@WebParam(name="inCrres_numero_resolucion")String inCrres_numero_resolucion,
			@WebParam(name="inCrres_tipo")int inCrres_tipo,
			@WebParam(name="inCrres_observaciones")String inCrres_observaciones,
			@WebParam(name="inCrres_extracto_resolucion")String inCrres_extracto_resolucion,
			@WebParam(name="inCrres_votos_aprobacion")int inCrres_votos_aprobacion,
			@WebParam(name="inCrres_votos_negacion")int inCrres_votos_negacion,
			@WebParam(name="inCrres_votos_abstencion")int inCrres_votos_abstencion,
			@WebParam(name="inCrres_fecha_emision")java.util.Date inCrres_fecha_emision,
			@WebParam(name="inCrres_fecha_ejecucion")java.util.Date inCrres_fecha_ejecucion,
			@WebParam(name="inCrres_fecha_anulacion")java.util.Date inCrres_fecha_anulacion,
			@WebParam(name="inCrres_fecha_confirmacion")java.util.Date inCrres_fecha_confirmacion,
			@WebParam(name="inCrres_resolucion_reemplaza")String inCrres_resolucion_reemplaza,
			@WebParam(name="inCrres_nombre_adjunto_resol")String inCrres_nombre_adjunto_resol,
			@WebParam(name="inCrres_adjunto_resolucion")String inCrres_adjunto_resolucion,
			@WebParam(name="inCrres_descripcion_adjunto")String inCrres_descripcion_adjunto,
			@WebParam(name="inCrres_fecha_apelacion")java.util.Date inCrres_fecha_apelacion,
			@WebParam(name="inCrres_extracto_apelacion")String inCrres_extracto_apelacion,
			@WebParam(name="inCrres_numero_apelacion")String inCrres_numero_apelacion,
			@WebParam(name="inCrres_nombre_adjunto_apelac")String inCrres_nombre_adjunto_apelac,
			@WebParam(name="inCrres_adjunto_apelacion")String inCrres_adjunto_apelacion,
			@WebParam(name="inCrres_estado_resolucion")int inCrres_estado_resolucion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_resolucion obj = new com.besixplus.sii.objects.Cgg_res_resolucion();
		obj.setCRRES_CODIGO("KEYGEN");
		obj.setCRSSC_CODIGO(inCrssc_codigo);
		obj.setCRRES_NUMERO_RESOLUCION(inCrres_numero_resolucion);
		obj.setCRRES_TIPO(inCrres_tipo);
		obj.setCRRES_OBSERVACIONES(inCrres_observaciones);
		obj.setCRRES_EXTRACTO_RESOLUCION(inCrres_extracto_resolucion);
		obj.setCRRES_VOTOS_APROBACION(inCrres_votos_aprobacion);
		obj.setCRRES_VOTOS_NEGACION(inCrres_votos_negacion);
		obj.setCRRES_VOTOS_ABSTENCION(inCrres_votos_abstencion);
		obj.setCRRES_FECHA_EMISION(inCrres_fecha_emision);
		obj.setCRRES_FECHA_EJECUCION(inCrres_fecha_ejecucion);
		obj.setCRRES_FECHA_ANULACION(inCrres_fecha_anulacion);
		obj.setCRRES_FECHA_CONFIRMACION(inCrres_fecha_confirmacion);
		obj.setCRRES_RESOLUCION_REEMPLAZA(inCrres_resolucion_reemplaza);
		obj.setCRRES_NOMBRE_ADJUNTO_RESOL(inCrres_nombre_adjunto_resol);
		obj.setCRRES_ADJUNTO_RESOLUCION(org.jboss.util.Base64.decode(inCrres_adjunto_resolucion));
		obj.setCRRES_DESCRIPCION_ADJUNTO(inCrres_descripcion_adjunto);
		obj.setCRRES_FECHA_APELACION(inCrres_fecha_apelacion);
		obj.setCRRES_EXTRACTO_APELACION(inCrres_extracto_apelacion);
		obj.setCRRES_NUMERO_APELACION(inCrres_numero_apelacion);
		obj.setCRRES_NOMBRE_ADJUNTO_APELAC(inCrres_nombre_adjunto_apelac);
		obj.setCRRES_ADJUNTO_APELACION(org.jboss.util.Base64.decode(inCrres_adjunto_apelacion));
		obj.setCRRES_ESTADO_RESOLUCION(inCrres_estado_resolucion);
		obj.setCRRES_ESTADO(true);
		obj.setCRRES_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRRES_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_resolucion(obj).insert(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_resolucion EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_resolucion> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_resolucion.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_resolucion EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inCrres_estado_resolucion ESTADO DE RESOLUCION.
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESSION COMITE
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
			@WebParam(name="inCrres_estado_resolucion")int inCrres_estado_resolucion,
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
			tmpCount = com.besixplus.sii.db.Cgg_res_resolucion.selectCount(con, keyword, inCrres_estado_resolucion, inCrssc_codigo);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_resolucion.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inCrres_estado_resolucion, inCrssc_codigo);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_resolucion.
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	 * @param inCrtra_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TRAMITE
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	 * @param inCrres_numero_resolucion NUMERO IDENTIFICATIVO DE LA RESOLUCION
	 * @param inCrres_tipo TIPO DE RESOLUCION
0 - NORMATIVA
1 - APROBACION
	 * @param inCrres_observaciones OBSERVACIONES CONSIDERADAS PARA LA RESOLUCION
	 * @param inCrres_extracto_resolucion RESUMEN DEL CONTENIDO DE LA RESOLUCION
	 * @param inCrres_votos_aprobacion NUMERO DE VOTOS A FAVOR DE LA RESOLUCION
	 * @param inCrres_votos_negacion NUMERO DE VOTOS EN CONTRA DE LA RESOLUCION
	 * @param inCrres_votos_abstencion NUMERO DE VOTOS DE ABSTENCION
	 * @param inCrres_fecha_emision FECHA DE EMISION DE RESULTADO DE LA RESOLUCION
	 * @param inCrres_fecha_ejecucion FECHA DE EJECUCION O LLEVADA A LA PRACTICA
	 * @param inCrres_fecha_anulacion FECHA DE ANULACION O PERDIDA DE LA VIGENCIA
	 * @param inCrres_fecha_confirmacion FECHA DE CONFIRMACION DE LA RESOLUCION EN LA QUE EL ADMINISTRADOR FINALMENTE CONFIRMO UNA RESIDENCIA..
	 * @param inCrres_resolucion_reemplaza RESOLUCION POR LA QUE PUDO SER REEMPLAZA LA ACTUAL
	 * @param inCrres_nombre_adjunto_resol NOMBRE DEL DOCUMENTO ADJUNTO
	 * @param inCrres_adjunto_resolucion ARCHIVO DIGITAL ANEXO A LA RESOLUCION
	 * @param inCrres_descripcion_adjunto DESCRIPCION DE LOS DOCUMENTOS ADJUNTOS
	 * @param inCrres_fecha_apelacion FECHA DE APELACION A LA RESOLUCION
	 * @param inCrres_extracto_apelacion EXTRACTO DE LA APELACION
	 * @param inCrres_numero_apelacion NUMERO DE DOCUMENTO DE APELACION
	 * @param inCrres_nombre_adjunto_apelac NOMBRE DEL DOCUMENTO ADJUNTO
	 * @param inCrres_adjunto_apelacion ARCHIVO ADJUNTO A LA APELACION
	 * @param inCrres_estado_resolucion ESTADO DE LA RESOLUCION:
0 - ESPERANDO VOTACION
1 - APROBADA
2 - NEGADA
3 - EJECUTADA
4 - ANULADA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrres_codigo")String inCrres_codigo,
			@WebParam(name="inCrssc_codigo")String inCrssc_codigo,
			@WebParam(name="inCrres_numero_resolucion")String inCrres_numero_resolucion,
			@WebParam(name="inCrres_tipo")int inCrres_tipo,
			@WebParam(name="inCrres_observaciones")String inCrres_observaciones,
			@WebParam(name="inCrres_extracto_resolucion")String inCrres_extracto_resolucion,
			@WebParam(name="inCrres_votos_aprobacion")int inCrres_votos_aprobacion,
			@WebParam(name="inCrres_votos_negacion")int inCrres_votos_negacion,
			@WebParam(name="inCrres_votos_abstencion")int inCrres_votos_abstencion,
			@WebParam(name="inCrres_fecha_emision")java.util.Date inCrres_fecha_emision,
			@WebParam(name="inCrres_fecha_ejecucion")java.util.Date inCrres_fecha_ejecucion,
			@WebParam(name="inCrres_fecha_anulacion")java.util.Date inCrres_fecha_anulacion,
			@WebParam(name="inCrres_fecha_confirmacion")java.util.Date inCrres_fecha_confirmacion,
			@WebParam(name="inCrres_resolucion_reemplaza")String inCrres_resolucion_reemplaza,
			@WebParam(name="inCrres_nombre_adjunto_resol")String inCrres_nombre_adjunto_resol,
			@WebParam(name="inCrres_adjunto_resolucion")String inCrres_adjunto_resolucion,
			@WebParam(name="inCrres_descripcion_adjunto")String inCrres_descripcion_adjunto,
			@WebParam(name="inCrres_fecha_apelacion")java.util.Date inCrres_fecha_apelacion,
			@WebParam(name="inCrres_extracto_apelacion")String inCrres_extracto_apelacion,
			@WebParam(name="inCrres_numero_apelacion")String inCrres_numero_apelacion,
			@WebParam(name="inCrres_nombre_adjunto_apelac")String inCrres_nombre_adjunto_apelac,
			@WebParam(name="inCrres_adjunto_apelacion")String inCrres_adjunto_apelacion,
			@WebParam(name="inCrres_estado_resolucion")int inCrres_estado_resolucion
	){

		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_resolucion obj = new com.besixplus.sii.objects.Cgg_res_resolucion();
		obj.setCRRES_CODIGO(inCrres_codigo);
		obj.setCRSSC_CODIGO(inCrssc_codigo);
		obj.setCRRES_NUMERO_RESOLUCION(inCrres_numero_resolucion);
		obj.setCRRES_TIPO(inCrres_tipo);
		obj.setCRRES_OBSERVACIONES(inCrres_observaciones);
		obj.setCRRES_EXTRACTO_RESOLUCION(inCrres_extracto_resolucion);
		obj.setCRRES_VOTOS_APROBACION(inCrres_votos_aprobacion);
		obj.setCRRES_VOTOS_NEGACION(inCrres_votos_negacion);
		obj.setCRRES_VOTOS_ABSTENCION(inCrres_votos_abstencion);
		obj.setCRRES_FECHA_EMISION(inCrres_fecha_emision);
		obj.setCRRES_FECHA_EJECUCION(inCrres_fecha_ejecucion);
		obj.setCRRES_FECHA_ANULACION(inCrres_fecha_anulacion);
		obj.setCRRES_FECHA_CONFIRMACION(inCrres_fecha_confirmacion);
		obj.setCRRES_RESOLUCION_REEMPLAZA(inCrres_resolucion_reemplaza);
		obj.setCRRES_NOMBRE_ADJUNTO_RESOL(inCrres_nombre_adjunto_resol);
		obj.setCRRES_ADJUNTO_RESOLUCION(org.jboss.util.Base64.decode(inCrres_adjunto_resolucion));
		obj.setCRRES_DESCRIPCION_ADJUNTO(inCrres_descripcion_adjunto);
		obj.setCRRES_FECHA_APELACION(inCrres_fecha_apelacion);
		obj.setCRRES_EXTRACTO_APELACION(inCrres_extracto_apelacion);
		obj.setCRRES_NUMERO_APELACION(inCrres_numero_apelacion);
		obj.setCRRES_NOMBRE_ADJUNTO_APELAC(inCrres_nombre_adjunto_apelac);
		obj.setCRRES_ADJUNTO_APELACION(org.jboss.util.Base64.decode(inCrres_adjunto_apelacion));
		obj.setCRRES_ESTADO_RESOLUCION(inCrres_estado_resolucion);
		obj.setCRRES_ESTADO(true);
		obj.setCRRES_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_resolucion(obj).update(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return res;
	}


	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_resolucion EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrres_codigo crres_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrres_codigo")String inCrres_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_resolucion tmpObj = new com.besixplus.sii.objects.Cgg_res_resolucion();
		tmpObj.setCRRES_CODIGO(inCrres_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_resolucion(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_resolucion> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_resolucion>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_resolucion.
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrres_codigo")String inCrres_codigo
	) throws SOAPException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_resolucion tmpObj = new com.besixplus.sii.objects.Cgg_res_resolucion();
		tmpObj.setCRRES_CODIGO(inCrres_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_resolucion(tmpObj).delete(con);
			con.close();
			if(!outResult.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(outResult, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return outResult;
	}
	
	/**
	 * ELIMINA UNA RESOLUCION TEMPORAL QUE FUE CREADA PARA EL REGISTRO DE VOTOS
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String deleteTmpResolucion(
			@WebParam(name="inCrres_codigo")String inCrres_codigo
	) throws SOAPException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_resolucion tmpObj = new com.besixplus.sii.objects.Cgg_res_resolucion();
		tmpObj.setCRRES_CODIGO(inCrres_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			con.setAutoCommit(false);
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			com.besixplus.sii.objects.Cgg_res_resol_tramite tmpRst = new com.besixplus.sii.objects.Cgg_res_resol_tramite();
			tmpRst.setCRRES_CODIGO(inCrres_codigo);
			outResult = new Cgg_res_resol_tramite(tmpRst).deleteCGG_RES_RESOLUCION(con);
			if(outResult.equals("true")){
				outResult = new com.besixplus.sii.db.Cgg_res_resolucion(tmpObj).delete(con, false);
			}
			if(outResult.equals("true"))
				con.commit();
			else
				con.rollback();
			con.setAutoCommit(true);
			con.close();
			if(!outResult.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(outResult, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return outResult;
	}
	
	/**
	 * MARCA UNA RESOLUCION COMO ANULADA.
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String anular(
			@WebParam(name="inCrres_codigo")String inCrres_codigo
	) throws SOAPException{
		String outResult = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_resolucion tmpObj = new com.besixplus.sii.objects.Cgg_res_resolucion();
		tmpObj.setCRRES_CODIGO(inCrres_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_resolucion(tmpObj).anular(con, tmpRequest.getUserPrincipal().getName());
			con.close();
			if(!outResult.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(outResult, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return outResult;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res oficial_seguimiento y Cgg_usuario EN UNA ESTRUCTURA JSON QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS JSON o XML.
	 * @param inSW OBTENER SOLO LAS RESOLUCIONES ASOCIADAS A UN TRAMITE.
	 * @return VECTOR JSON EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectVoto(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inSW")boolean inSW
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
			tmpCount = com.besixplus.sii.db.Cgg_res_resolucion.selectCountVotar(con, tmpRequest.getUserPrincipal().getName(),keyword, inSW);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_resolucion.selectVotar(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inSW);
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
	 * GENERAL EL NUMERO DE RESOLUCION
	 * @param inCisla_codigo CODIGO DE LA ISLA DONDE SE GENERA LA RESOLUCION.
	 * @return NUMERO DE RESOLUCION
	 * @throws SOAPException 
	 */
	@WebMethod
	public String numeroResolucion(
			@WebParam(name="inCisla_codigo")String inCisla_codigo
	) throws SOAPException{		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_resolucion tmpObj = new com.besixplus.sii.objects.Cgg_res_resolucion();
		String numeroResol;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			numeroResol = com.besixplus.sii.db.Cgg_res_resolucion.numeroResolucion(con, inCisla_codigo, null);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}if (tmpObj != null)
			return numeroResol;
		return null;
	}
	/**
	 * OBTIENE EL NUMERO DE APELACION GENERADO 
	 * @return numeroApelacion
	 */

	@WebMethod
	public String numeroApelacion(		
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_resolucion tmpObj = new com.besixplus.sii.objects.Cgg_res_resolucion();
		String numeroApela;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			numeroApela = com.besixplus.sii.db.Cgg_res_resolucion.numeroApelacion(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return numeroApela;
		return null;
	}
	/**
	 * OBTIENEEL TOTAL DE VOTOS APROBANDO LA RESOLUCION 
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	 * @return numeroAprobados
	 */

	@WebMethod
	public int numeroAprobados(	
			@WebParam(name="inCrres_codigo")String inCrres_codigo	
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_resolucion tmpObj = new com.besixplus.sii.objects.Cgg_res_resolucion();
		int numeroApro;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return 0;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			numeroApro = com.besixplus.sii.db.Cgg_res_resolucion.votosAprobados(con,inCrres_codigo);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getErrorCode();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.hashCode();
		}
		if (tmpObj != null)
			return numeroApro;
		return 0;
	}
	/**
	 * OBTIENE EL TOTAL DE VOTOS REPROBANDO LA RESOLUCION 
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCION
	 * @return numeroReprobados
	 */

	@WebMethod
	public int numeroReprobados(	
			@WebParam(name="inCrres_codigo")String inCrres_codigo
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_resolucion tmpObj = new com.besixplus.sii.objects.Cgg_res_resolucion();
		int numeroRepro;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return 0;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			numeroRepro = com.besixplus.sii.db.Cgg_res_resolucion.votosReprobados(con, inCrres_codigo);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getErrorCode();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.hashCode();
		}
		if (tmpObj != null)
			return numeroRepro;
		return 0;
	}
	/**
	 * OBTIENE EL TOTAL DE VOTOS CON ABSTENCION A LA RESOLUCION 
	 * @param inCrres_codigo identificativo unico de registro de resolucion
	 * @return numeroAbstenciones
	 */

	@WebMethod
	public int numeroAbstenciones(	
			@WebParam(name="inCrres_codigo")String inCrres_codigo
	){		
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_resolucion tmpObj = new com.besixplus.sii.objects.Cgg_res_resolucion();
		int numeroAbst;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return 0;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			numeroAbst = com.besixplus.sii.db.Cgg_res_resolucion.votosAbstenciones(con, inCrres_codigo);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getErrorCode();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.hashCode();
		}
		if (tmpObj != null)
			return numeroAbst;
		return 0;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res oficial_seguimiento y Cgg_usuario EN UNA ESTRUCTURA JSON QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESSION COMITE
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @return VECTOR JSON EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */

	@WebMethod
	public String selectMiembroSesion(
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
			obj = com.besixplus.sii.db.Cgg_res_resolucion.selectMiembrosComite(con, inCrssc_codigo);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res oficial_seguimiento y Cgg_usuario EN UNA ESTRUCTURA JSON QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * LISTADO DE TRAMITES PARA VOTO POR UNANIMIDAD REGISTRADOR POR COORDINACION
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LA INFORMACION JSON o XML
	 * @param inCrssc_codigo CODIGO DE LA SESION QUE SE QUIERE CONSULTAR LOS TRAMITES
	 * @return VECTOR JSON EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */

	@WebMethod
	public String selectVotoAdmin(			
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
			tmpCount = com.besixplus.sii.db.Cgg_res_resolucion.selectCountVotarAdmin(con, tmpRequest.getUserPrincipal().getName(), inCrssc_codigo, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());			
			obj = com.besixplus.sii.db.Cgg_res_resolucion.selectVotarAdmin(con,tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword,inCrssc_codigo);
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
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCION
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
	public String selectResolucionAdjunto(
			@WebParam(name="inCrres_codigo")String inCrres_codigo,
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
			obj = com.besixplus.sii.db.Cgg_res_resolucion.selectAllResolucionAdjunto(con, inCrres_codigo);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res oficial_seguimiento y Cgg_usuario EN UNA ESTRUCTURA JSON QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inCrssc_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION COMITE
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @return VECTOR JSON EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */

	@WebMethod
	public String selectVotoAdmin1(
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
			obj = com.besixplus.sii.db.Cgg_res_resolucion.selectVotarAdmin1(con, tmpRequest.getUserPrincipal().getName(), inCrssc_codigo);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res oficial_seguimiento y Cgg_usuario EN UNA ESTRUCTURA JSON QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * LISTADO DE LOS MIEMBROS DE UNA SESION QUE NO REGISTRARON VOTOS SOBRE UNA RESOLUCION
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LA INFORMACION.
	 * @param inCrssc_codigo CODIGO DE LA SESION QUE DESEA CONSULTAR
	 * @param inCrres_codigo CODIGO DE RESOLUCION
	 * @return VECTOR JSON EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */

	@WebMethod
	public String selectMiembroSesion1(			
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCrssc_codigo")String inCrssc_codigo,
			@WebParam(name="inCrres_codigo")String inCrres_codigo
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
			tmpCount = com.besixplus.sii.db.Cgg_res_resolucion.selectCountVotaMiembrosComite(con,keyword,inCrssc_codigo,inCrres_codigo);
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_res_resolucion.selectMiembrosComite1(con,tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword,inCrssc_codigo, inCrres_codigo);
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