package com.besixplus.sii.ws;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

import org.json.JSONException;
import org.json.JSONObject;

import com.besixplus.sii.db.Cgg_extras;
import com.besixplus.sii.db.Cgg_usuario;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.objects.Cgg_res_fase;
import com.besixplus.sii.objects.Cgg_res_fase_hijo;
import com.besixplus.sii.objects.Cgg_res_resolucion;
import com.besixplus.sii.objects.Cgg_res_seguimiento;
import com.besixplus.sii.objects.Cgg_res_sesion_comite;
import com.besixplus.sii.objects.Cgg_res_tramite;
import com.besixplus.sii.objects.ServerResponse;

/**
 * CLASE Cgg_res_voto
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_voto POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_voto implements Serializable{

	private static final long serialVersionUID = 2052171940;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_voto.
	 * @param inLisResolucion JSON CON INFORMACION DE LA TABLA cgg_res_resolucion
	 * @param inCrsmb_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO.
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES.
	 * @param inCrvto_votacion ESTADO QUE DETERMINA LA DECISION APLICADA AL VOTO
	 * APROBADO
	 * NEGADO.
	 * @param inCrvto_observacion OBSERVACION DE LOS MIEMBROS EN LA VOTACION.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(		
			@WebParam(name="inLisResolucion")String inLisResolucion,
			@WebParam(name="inCrvto_votacion")int inCrvto_votacion,
			@WebParam(name="inCrvto_observacion")String inCrvto_observacion
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		Connection con = null;
		com.besixplus.sii.objects.Cgg_res_voto obj = new com.besixplus.sii.objects.Cgg_res_voto();
		com.besixplus.sii.objects.Cgg_usuario tmpUsuario = new com.besixplus.sii.objects.Cgg_usuario();
		int tmpRespuesta = -1;
		String tmpTramite = null;
		String res = "true";
		//String tmpCurrentUserName = "tct11";
		String tmpCurrentUserName = tmpRequest.getUserPrincipal().getName();
		try{
			con = ManagerConnection.getConnection();
			con.setAutoCommit(false);
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpCurrentUserName, 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			org.json.JSONArray lisResolucion = new org.json.JSONArray(inLisResolucion);
			Cgg_res_resolucion tmpResolucion = new Cgg_res_resolucion();
			com.besixplus.sii.db.Cgg_res_resolucion updateResol = new com.besixplus.sii.db.Cgg_res_resolucion(tmpResolucion);
			for (int i=0; i<lisResolucion.length();i++){
				obj.setCRVTO_CODIGO("KEYGEN");
				obj.setCRSMB_CODIGO(((org.json.JSONObject)lisResolucion.get(i)).get("CRSMB_CODIGO").toString());				
				obj.setCRRES_CODIGO(((org.json.JSONObject)lisResolucion.get(i)).get("CRRES_CODIGO").toString());
				obj.setCRVTO_VOTACION(inCrvto_votacion);
				obj.setCRVTO_OBSERVACION(inCrvto_observacion);
				obj.setCRVTO_ESTADO(true);
				obj.setCRVTO_USUARIO_INSERT(tmpCurrentUserName);
				obj.setCRVTO_USUARIO_UPDATE(tmpCurrentUserName);
				res = new com.besixplus.sii.db.Cgg_res_voto(obj).insert(con);
				if(!res.equals("true"))
					break;
				////////////////////////////////////////////////////////////////////////
				//Actualizacion de los votos en Cgg_res_residencia 
				tmpResolucion.setCRRES_CODIGO(((org.json.JSONObject)lisResolucion.get(i)).get("CRRES_CODIGO").toString());
				updateResol.select(con);

				if (tmpResolucion.getCRRES_ESTADO_RESOLUCION() != 0){
					tmpTramite = ((org.json.JSONObject)lisResolucion.get(i)).get("CRTRA_CODIGO").toString();
					tmpRespuesta = tmpResolucion.getCRRES_ESTADO_RESOLUCION() == 1?1:0;

					if(tmpTramite!=null && !tmpTramite.equals("null") && !tmpTramite.trim().isEmpty() && tmpRespuesta >= 0 && res.equals("true") ){
						HashMap<String, String> tmpFaseCodigo = new Cgg_extras().selectFaseComite(con, tmpTramite);
						
						Cgg_res_tramite tmpObjTramite = new Cgg_res_tramite();
						tmpObjTramite.setCRTRA_CODIGO(tmpTramite);
						new com.besixplus.sii.db.Cgg_res_tramite(tmpObjTramite).select(con);
						
						Cgg_res_seguimiento tmpSeguimiento = new Cgg_res_seguimiento();
						tmpSeguimiento.setCRSEG_CODIGO(tmpFaseCodigo.get("CRSEG_CODIGO"));
						new com.besixplus.sii.db.Cgg_res_seguimiento(tmpSeguimiento).select(con);
						
						tmpUsuario.setCUSU_CODIGO(tmpSeguimiento.getCUSU_CODIGO());
						new Cgg_usuario(tmpUsuario).select(con);
						res = transferirSeguimiento(con, tmpTramite, tmpRespuesta, tmpObjTramite.getCISLA_CODIGO(), tmpUsuario.getCUSU_NOMBRE_USUARIO());
					}
				}
			}
			if(res.equals("true") ){
				if(!con.isClosed()){
					con.commit();
					con.setAutoCommit(true);
				}
			}else{
				if(!con.isClosed())
					con.rollback();
			}
			if(!con.isClosed())
				con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			if(con != null)
				try {
					con.rollback();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}

	private String transferirSeguimiento(Connection inConnection, String inCRTRA_CODIGO, int inRespuesta, String inCisla_codigo, String inUserName) {
		if(inCRTRA_CODIGO == null)
			return "false";
		ServerResponse tmpResponse = null;
		String tmpFaseJSON = "";
		com.besixplus.sii.objects.Cgg_res_fase tmpFase = new Cgg_res_fase();
		HashMap<String, String> tmpFaseCodigo = new Cgg_extras().selectFaseComite(inConnection, inCRTRA_CODIGO);
		tmpFase.setCRFAS_CODIGO(tmpFaseCodigo.get("CRFAS_CODIGO"));
		tmpFase.setCRPRO_CODIGO(tmpFaseCodigo.get("CRPRO_CODIGO"));

		Cgg_res_fase tmpFaseFinal = new Cgg_res_fase();
		tmpFaseFinal.setCRPRO_CODIGO(tmpFase.getCRPRO_CODIGO());
		new com.besixplus.sii.db.Cgg_res_fase(tmpFaseFinal).selectFaseFinalizacion(inConnection, inCisla_codigo);
		Cgg_res_fase_hijo tmpFaseHijo = new com.besixplus.sii.db.Cgg_res_fase(tmpFase).selectFaseSiguiente(inConnection, inCisla_codigo);
		tmpFaseHijo.setCUSU_CODIGO(tmpFaseHijo.getCGG_CUSU_CODIGO());
		
		if(!tmpFaseFinal.getCRFAS_CODIGO().equals(tmpFase.getCRFAS_CODIGO())){
			if (tmpFaseHijo.getCUSU_CODIGO() == null || tmpFaseHijo.getCUSU_CODIGO().isEmpty())
				return "No se ha especificado un usuario de la misma localidad para la siguiente fase del seguimiento.";
			tmpFaseJSON = new JSONObject(tmpFaseHijo).toString();
		}

		if(inRespuesta == 1){
			tmpFaseHijo.setCRFAS_SUMILLA(myInfoMessages.getMessage("sii.comite.aprobacion", null));
			tmpResponse = new com.besixplus.sii.ws.Cgg_res_seguimiento().enviarSeguimiento(inConnection, tmpFaseCodigo.get("CRSEG_CODIGO"), 4, "["+tmpFaseJSON+"]", 1, inUserName);
		}else{
			tmpFaseHijo.setCRFAS_SUMILLA(myInfoMessages.getMessage("sii.comite.negacion", null));
			tmpResponse = new com.besixplus.sii.ws.Cgg_res_seguimiento().enviarSeguimiento(inConnection, tmpFaseCodigo.get("CRSEG_CODIGO"), 4, "["+tmpFaseJSON+"]", 0, inUserName);
		}
		return Boolean.toString(tmpResponse.isSuccess());
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_voto EN UNA ESTRUCTRA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_voto> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_voto.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_voto EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_res_voto> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_voto.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_voto.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_voto EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_voto.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_voto.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_voto.
	 * @param inCrvto_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VOTO
	 * @param inCrsmb_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
	 * @param inCrres_codigo IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	 * @param inCrvto_votacion ESTADO QUE DETERMINA LA DECISION APLICADA AL VOTO
APROBADO
NEGADO
	 * @param inCrvto_observacion OBSERVACION DE LOS MIEMBROS EN LA VOTACION
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrvto_codigo")String inCrvto_codigo,
			@WebParam(name="inCrsmb_codigo")String inCrsmb_codigo,
			@WebParam(name="inCrres_codigo")String inCrres_codigo,
			@WebParam(name="inCrvto_votacion")int inCrvto_votacion,
			@WebParam(name="inCrvto_observacion")String inCrvto_observacion
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_voto obj = new com.besixplus.sii.objects.Cgg_res_voto();
		obj.setCRVTO_CODIGO(inCrvto_codigo);
		obj.setCRSMB_CODIGO(inCrsmb_codigo);
		obj.setCRRES_CODIGO(inCrres_codigo);
		obj.setCRVTO_VOTACION(inCrvto_votacion);
		obj.setCRVTO_OBSERVACION(inCrvto_observacion);
		obj.setCRVTO_ESTADO(true);
		obj.setCRVTO_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_voto(obj).update(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_voto EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrvto_codigo crvto_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrvto_codigo")String inCrvto_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_voto tmpObj = new com.besixplus.sii.objects.Cgg_res_voto();
		tmpObj.setCRVTO_CODIGO(inCrvto_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_voto(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_voto> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_voto>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_voto.
	 * @param inCrvto_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VOTO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrvto_codigo")String inCrvto_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_voto tmpObj = new com.besixplus.sii.objects.Cgg_res_voto();
		tmpObj.setCRVTO_CODIGO(inCrvto_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_res_voto(tmpObj).delete(con);
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
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_voto.
	 * @param inMiembros MIEMBROS QUE PARTICIPARON
	 * @param inResolVotos VOTOS DE RESOLUCION
	 * @param inPorTipo 
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insertAdmin(		
			@WebParam(name="inMiembros")String inMiembros,
			@WebParam(name="inResolVotos")String inResolVotos,
			@WebParam(name="inPorTipo")int inPorTipo
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		String res = "true";
		Messages tmpMessages = new Messages(Messages.Types.Info);
		com.besixplus.sii.objects.Cgg_res_voto tmpVoto = new com.besixplus.sii.objects.Cgg_res_voto();
		com.besixplus.sii.objects.Cgg_usuario tmpUsuario = new com.besixplus.sii.objects.Cgg_usuario();
		int tmpvotosMiembros;
		int i;
		int j;
		int tmpRespuesta = -1;
		String numeroResolucion;	
		String tmpCurrentUserName = tmpRequest.getUserPrincipal().getName();
		//String tmpCurrentUserName = "admin";
		try{
			Connection con = ManagerConnection.getConnection();		
			con.setAutoCommit(false);
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpCurrentUserName, 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpUsuario.setCUSU_NOMBRE_USUARIO(tmpCurrentUserName);
			new Cgg_usuario(tmpUsuario).selectByUsername(con);
			Cgg_res_resolucion tmpResolucion = new Cgg_res_resolucion();
			org.json.JSONArray Miembros = new org.json.JSONArray(inMiembros);
			org.json.JSONArray ResolVotos = new org.json.JSONArray(inResolVotos);
			com.besixplus.sii.db.Cgg_res_resolucion updateResol = new com.besixplus.sii.db.Cgg_res_resolucion(tmpResolucion);
			if (inPorTipo == 1){	
				for (i=0; i<ResolVotos.length();i++){
					for (j=0; j<Miembros.length();j++){					

						tmpVoto.setCRVTO_CODIGO("KEYGEN");
						tmpVoto.setCRSMB_CODIGO(((org.json.JSONObject)Miembros.get(j)).get("CRSMB_CODIGO").toString());
						tmpVoto.setCRRES_CODIGO(((org.json.JSONObject)ResolVotos.get(i)).get("CRRES_CODIGO").toString());
						if (((org.json.JSONObject)ResolVotos.get(i)).getInt("TOT_VOTOS")== 0){
							tmpvotosMiembros=0;
						}else{
							if (((org.json.JSONObject)ResolVotos.get(i)).getInt("TOT_VOTOS")== 1){
								tmpvotosMiembros=1;
							}
							else{
								tmpvotosMiembros=2;							
							}
						}
						tmpVoto.setCRVTO_VOTACION(tmpvotosMiembros);								
						tmpVoto.setCRVTO_OBSERVACION(tmpMessages.getMessage("sii.comite.voto.coordinacion", null));
						tmpVoto.setCRVTO_ESTADO(true);
						tmpVoto.setCRVTO_USUARIO_INSERT(tmpCurrentUserName);
						tmpVoto.setCRVTO_USUARIO_UPDATE(tmpCurrentUserName);
						res = new com.besixplus.sii.db.Cgg_res_voto(tmpVoto).insert(con);
					}
					if (res.equals("true")){
						//Actualizacion de los votos en Cgg_res_resolucion 						

						tmpResolucion.setCRRES_CODIGO(((org.json.JSONObject)ResolVotos.get(i)).get("CRRES_CODIGO").toString());
						updateResol.select(con);				

						numeroResolucion=com.besixplus.sii.db.Cgg_res_resolucion.numeroResolucion(con, tmpUsuario.getCISLA_CODIGO(), ResolVotos.getJSONObject(i).getString("CRSSC_CODIGO"));
						tmpResolucion.setCRRES_NUMERO_RESOLUCION(numeroResolucion);

						tmpRespuesta = tmpResolucion.getCRRES_ESTADO_RESOLUCION() == 1?1:0;
						
						Cgg_res_sesion_comite tmpSesionComite = new Cgg_res_sesion_comite();
						tmpSesionComite.setCRSSC_CODIGO(tmpResolucion.getCRSSC_CODIGO());
						if(tmpResolucion.getCRSSC_CODIGO() != null){
							new com.besixplus.sii.db.Cgg_res_sesion_comite(tmpSesionComite).select(con);
							if(tmpSesionComite.getCRSSC_FECHA_FINALIZACION() != null){
								tmpResolucion.setCRRES_FECHA_EMISION(tmpSesionComite.getCRSSC_FECHA_FINALIZACION());
								tmpResolucion.setCRRES_FECHA_EJECUCION(tmpSesionComite.getCRSSC_FECHA_FINALIZACION());
							}else{
								tmpResolucion.setCRRES_FECHA_EMISION(new Date());
								tmpResolucion.setCRRES_FECHA_EJECUCION(new Date());
							}
						}else{
							tmpResolucion.setCRRES_FECHA_EMISION(new Date());
							tmpResolucion.setCRRES_FECHA_EJECUCION(new Date());
						}
						tmpResolucion.setCRRES_USUARIO_UPDATE(tmpCurrentUserName);
						res = updateResol.update(con);
					}
					if(ResolVotos.getJSONObject(i).getString("CRTRA_CODIGO")!=null &&
							!ResolVotos.getJSONObject(i).getString("CRTRA_CODIGO").trim().isEmpty() &&
							!ResolVotos.getJSONObject(i).getString("CRTRA_CODIGO").equals("null") &&
							tmpRespuesta!=-1 && res.equals("true"))
						res = transferirSeguimiento(con, ResolVotos.getJSONObject(i).getString("CRTRA_CODIGO"), tmpRespuesta, tmpUsuario.getCISLA_CODIGO(), tmpCurrentUserName);
					if(!res.equals("true"))
						break;
					else{
						if(con.isClosed()){
							con = ManagerConnection.getConnection();
							con.setAutoCommit(false);
						}
					}
				}
			}else{
				for (i=0; i<ResolVotos.length();i++){
					for (j=0; j<Miembros.length();j++){					

						tmpVoto.setCRVTO_CODIGO("KEYGEN");
						tmpVoto.setCRSMB_CODIGO(((org.json.JSONObject)Miembros.get(j)).get("CRSMB_CODIGO").toString());
						tmpVoto.setCRRES_CODIGO(((org.json.JSONObject)ResolVotos.get(i)).get("CRRES_CODIGO").toString());
						if (((org.json.JSONObject)Miembros.get(j)).getInt("TOT_VOTOS")== 0){
							tmpvotosMiembros=0;
						}else{
							if (((org.json.JSONObject)Miembros.get(j)).getInt("TOT_VOTOS")== 1){
								tmpvotosMiembros=1;
							}
							else{
								tmpvotosMiembros=2;							
							}
						}
						tmpVoto.setCRVTO_VOTACION(tmpvotosMiembros);								
						tmpVoto.setCRVTO_OBSERVACION(tmpMessages.getMessage("sii.comite.voto.coordinacion", null));
						tmpVoto.setCRVTO_ESTADO(true);
						tmpVoto.setCRVTO_USUARIO_INSERT(tmpCurrentUserName);
						tmpVoto.setCRVTO_USUARIO_UPDATE(tmpCurrentUserName);
						res = new com.besixplus.sii.db.Cgg_res_voto(tmpVoto).insert(con);
					}
					if (res.equals("true")){
						//Actualizacion de los votos en Cgg_res_resolucion
						tmpResolucion.setCRRES_CODIGO(((org.json.JSONObject)ResolVotos.get(i)).get("CRRES_CODIGO").toString());
						updateResol.select(con);				
						numeroResolucion=com.besixplus.sii.db.Cgg_res_resolucion.numeroResolucion(con, tmpUsuario.getCISLA_CODIGO(), ResolVotos.getJSONObject(i).getString("CRSSC_CODIGO"));

						tmpResolucion.setCRRES_NUMERO_RESOLUCION(numeroResolucion);
						tmpRespuesta = tmpResolucion.getCRRES_ESTADO_RESOLUCION() == 1?1:0;
						
						Cgg_res_sesion_comite tmpSesionComite = new Cgg_res_sesion_comite();
						tmpSesionComite.setCRSSC_CODIGO(tmpResolucion.getCRSSC_CODIGO());
						if(tmpResolucion.getCRSSC_CODIGO() != null){
							new com.besixplus.sii.db.Cgg_res_sesion_comite(tmpSesionComite).select(con);
							if(tmpSesionComite.getCRSSC_FECHA_FINALIZACION() != null){
								tmpResolucion.setCRRES_FECHA_EMISION(tmpSesionComite.getCRSSC_FECHA_FINALIZACION());
								tmpResolucion.setCRRES_FECHA_EJECUCION(tmpSesionComite.getCRSSC_FECHA_FINALIZACION());
							}else{
								tmpResolucion.setCRRES_FECHA_EMISION(new Date());
								tmpResolucion.setCRRES_FECHA_EJECUCION(new Date());
							}
						}else{
							tmpResolucion.setCRRES_FECHA_EMISION(new Date());
							tmpResolucion.setCRRES_FECHA_EJECUCION(new Date());
						}
						tmpResolucion.setCRRES_USUARIO_UPDATE(tmpCurrentUserName);
						res = updateResol.update(con);
					}
					if(ResolVotos.getJSONObject(i).getString("CRTRA_CODIGO")!=null &&
							!ResolVotos.getJSONObject(i).getString("CRTRA_CODIGO").trim().isEmpty() &&
							!ResolVotos.getJSONObject(i).getString("CRTRA_CODIGO").equals("null") &&
							tmpRespuesta!=-1 && res.equals("true"))
						res = transferirSeguimiento(con, ResolVotos.getJSONObject(i).getString("CRTRA_CODIGO"), tmpRespuesta, tmpUsuario.getCISLA_CODIGO(), tmpCurrentUserName);
					if(!res.equals("true"))
						break;
				}	
			}

			if(res.equals("true")){
				if(!con.isClosed()){
					con.commit();
					con.setAutoCommit(true);
				}
			}else{
				if(!con.isClosed())
					con.rollback();
			}
			if(!con.isClosed())
				con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}


}