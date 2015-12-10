package com.besixplus.sii.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.io.Serializable;
/*import java.math.BigDecimal;*/
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

import org.json.JSONException;

import com.besixplus.sii.db.ManagerConnection;

/**
 * CLASE Cgg_gem_vacante
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_vacante POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_gem_vacante implements Serializable{

	private static final long serialVersionUID = 1375632177;

	@Resource WebServiceContext wctx;

	/**
	 * 
	 * @param inCusu_codigo Codigo del usuario que registra la oferta
	 * @param inCsctp_codigo Codigo del sector productivo
	 * @param inCgtcn_codigo Codigo del tipo de contrat
	 * @param inCgtsa_codigo Codigo del tipo de salario
	 * @param inCgcrg_codigo Codigo del cargo de la oferta
	 * @param inCgtpr_codigo Identificativo unico de titulo profesional.
	 * @param inCgvcn_estado_oferta Estado en la que se encuentra la oferta
	 * @param inCgvcn_titulo Titulo de la oferta
	 * @param inCgvcn_descripcion Descripcion-lugar de trabajo de la oferta
	 * @param inCgvcn_salario Salario para la oferta
	 * @param inCgvcn_direccion Direccion del empreo Islas
	 * @param inCgvcn_fecha_ingreso fecha de ingres de la oferta
	 * @param inCgvcn_numero_vacantes numero de vacantes abiertas para la ofera
	 * @param inCgvcn_duracion tiempo de duracion del empleo
	 * @param inCgvcn_duracion_tiempo tipo de duracion de empleo
	 * @param inCgvcn_experiencia Experiencia minima requerida
	 * @param inJSONIslaEmpleo Islas en las que se desarrollara el empleo
	 * @param inJSONRequisitos Requisitos a cumplir para los candidatos de la oferta
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 * @throws JSONException 
	 */

	@WebMethod
	public String insert(
			@WebParam(name="inCusu_codigo")String inCusu_codigo,	
			@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
			@WebParam(name="inCgtcn_codigo")String inCgtcn_codigo,
			@WebParam(name="inCgtsa_codigo")String inCgtsa_codigo,
			@WebParam(name="inCgcrg_codigo")String inCgcrg_codigo,
			@WebParam(name="inCgtpr_codigo")String inCgtpr_codigo,
			@WebParam(name="inCgvcn_estado_oferta")int inCgvcn_estado_oferta,
			@WebParam(name="inCgvcn_titulo")String inCgvcn_titulo,
			@WebParam(name="inCgvcn_descripcion")String inCgvcn_descripcion,
			@WebParam(name="inCgvcn_salario")java.math.BigDecimal inCgvcn_salario,
			@WebParam(name="inCgvcn_direccion")String inCgvcn_direccion,
			@WebParam(name="inCgvcn_fecha_ingreso")java.util.Date inCgvcn_fecha_ingreso,
			@WebParam(name="inCgvcn_numero_vacantes")int inCgvcn_numero_vacantes,
			@WebParam(name="inCgvcn_duracion")int inCgvcn_duracion,
			@WebParam(name="inCgvcn_duracion_tiempo")java.math.BigDecimal inCgvcn_duracion_tiempo,
			@WebParam(name="inCgvcn_experiencia")String inCgvcn_experiencia,
			@WebParam(name="inJSONIslaEmpleo")String inJSONIslaEmpleo,
			@WebParam(name="inJSONRequisitos")String inJSONRequisitos		
	) throws SOAPException, JSONException{
		String res = "false";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_gem_vacante obj = new com.besixplus.sii.objects.Cgg_gem_vacante();
		obj.setCGVCN_CODIGO("KEYGEN");
		obj.setCUSU_CODIGO(inCusu_codigo);		
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCGTCN_CODIGO(inCgtcn_codigo);
		obj.setCGTSA_CODIGO(inCgtsa_codigo);
		obj.setCGCRG_CODIGO(inCgcrg_codigo);
		obj.setCGTPR_CODIGO(inCgtpr_codigo);
		obj.setCGVCN_ESTADO_OFERTA(inCgvcn_estado_oferta);
		obj.setCGVCN_TITULO(inCgvcn_titulo);
		obj.setCGVCN_DESCRIPCION(inCgvcn_descripcion);
		obj.setCGVCN_SALARIO(inCgvcn_salario);
		obj.setCGVCN_DIRECCION(inCgvcn_direccion);
		obj.setCGVCN_FECHA_INGRESO(inCgvcn_fecha_ingreso);
		obj.setCGVCN_NUMERO_VACANTES(inCgvcn_numero_vacantes);
		obj.setCGVCN_DURACION(inCgvcn_duracion);
		obj.setCGVCN_DURACION_TIEMPO(inCgvcn_duracion_tiempo);
		obj.setCGVCN_EXPERIENCIA(inCgvcn_experiencia);
		obj.setCGVCN_ESTADO(true);
		obj.setCGVCN_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCGVCN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		Connection con = ManagerConnection.getConnection();
		try{	
			org.json.JSONObject JSONVacante = null;
			con.setAutoCommit(false);
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));				
			}
			res = new com.besixplus.sii.db.Cgg_gem_vacante(obj).insertUsers(con);
			if (!res.equals("false")){
				JSONVacante = new org.json.JSONObject(res);
				/**
				 * Permite insertar los requisitos de una oferta
				 */			
				org.json.JSONArray JSONRequisitos = new org.json.JSONArray(inJSONRequisitos);
				for (int i = 0 ; i < JSONRequisitos.length(); i++){
					org.json.JSONObject JSONRequisito = (org.json.JSONObject)JSONRequisitos.get(i);
					com.besixplus.sii.objects.Cgg_gem_requisito_vacante objReq = new com.besixplus.sii.objects.Cgg_gem_requisito_vacante();
					objReq.setCGRVC_CODIGO("KEYGEN");
					objReq.setCGVCN_CODIGO(JSONVacante.get("CGVCN_CODIGO").toString());
					objReq.setCGRVC_REQUISITO(JSONRequisito.get("CGRVC_REQUISITO").toString());
					objReq.setCGRVC_OBLIGATORIO(JSONRequisito.getBoolean("CGRVC_OBLIGATORIO"));
					objReq.setCGRVC_ESTADO(true);
					objReq.setCGRVC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objReq.setCGRVC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());					
					res =new com.besixplus.sii.db.Cgg_gem_requisito_vacante(objReq).insert(con);
					if (res.equals("false"))
						break;
				}
			}
			if (!res.equals("false")){
				/**
				 * Permite insertar las islas de empleo
				 */			
				org.json.JSONArray JSONIslasEmpleo = new org.json.JSONArray(inJSONIslaEmpleo);
				for (int i = 0 ; i < JSONIslasEmpleo.length(); i++){
					org.json.JSONObject JSONIslaEmpleo = (org.json.JSONObject)JSONIslasEmpleo.get(i);
					com.besixplus.sii.objects.Cgg_gem_isla_empleo objIsl = new com.besixplus.sii.objects.Cgg_gem_isla_empleo();
					objIsl.setCGISE_CODIGO("KEYGEN");
					objIsl.setCISLA_CODIGO(JSONIslaEmpleo.get("CISLA_CODIGO").toString());
					objIsl.setCGISE_DIRECCION("");
					objIsl.setCGVCN_CODIGO(JSONVacante.get("CGVCN_CODIGO").toString());
					objIsl.setCGISE_ESTADO(true);
					objIsl.setCGISE_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objIsl.setCGISE_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res =new com.besixplus.sii.db.Cgg_gem_isla_empleo(objIsl).insert(con);
					if (res.equals("false"))
						break;										
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
			res=JSONVacante.get("CGVCN_NUMERO").toString();			
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				try {
					con.rollback();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}

			return inException.getMessage();
		}
		return res;
	}

	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_gem_vacante EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param rol IDENTIFICADOR DE ROL.
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectByRolPage(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="rol")String rol
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
			tmpCount = com.besixplus.sii.db.Cgg_gem_vacante.selectCount(con,tmpRequest.getUserPrincipal().getName(), keyword,rol);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_gem_vacante.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword,rol);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_gem_vacante.
	 * @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	 * @param inJSONIslaEmpleo CADENA JSON DE LA ISLA DE EMPLEO.
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	 * @param inCpjis_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA ISLA
	 * @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO SECTOR PRODUCTIVO
	 * @param inCgtcn_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
	 * @param inCgtsa_codigo IDENTIFICATIVO UNICO DE REGISTRO TIPO SALARIO
	 * @param inCgcrg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
	 * @param inCgtpr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	 * @param inCgvcn_numero NUMERO SECUENCIAL UNICO DE LA VACANTE
	 * @param inCgvcn_titulo NOMBRE IDENTIFICATIVO DE LA VACANTE
	 * @param inCgvcn_descripcion DESCRIPCION DE LA VACANTE
	 * @param inCgvcn_salario MONTO OFERTADO COMO RECONOCIMIENTO POR EL TRABAJO REALIZADO
	 * @param inCgvcn_direccion DIRECCION DE TRABAJO DE LA OFERTA LABORAL
	 * @param inCgvcn_fecha_ingreso FECHA DE INGRESO DE LA OFERTA
	 * @param inCgvcn_fecha_publicacion FECHA DE PUBLICACION DE LA OFERTA
	 * @param inCgvcn_duracion_oferta TIEMPO DEFINIDO DE VIGENCIA PARA LA OFERTA (DIAS)
	 * @param inCgvcn_fecha_expiracion FECHA EXPIRACION DE LA PUBLICACION
	 * @param inCgvcn_estado_oferta ESTADO EN EL QUE SE HALLA LA PUBLICACION DE LA VACANTE
REGISTRADA
APROBADA
VENCIDA
FINALIZADA
	 * @param inCgvcn_numero_vacantes CANTIDAD DE VACANTES DISPONIBLES 
	 * @param inCgvcn_duracion  DURACION DEL TRABAJO VALORES:
0 -  HORA
1 - DIA
2 - MES
3 - ANIO
	 * @param inCgvcn_duracion_tiempo TIEMPO DE DURACION NUMERICAMENTE
	 * @param inCgvcn_experiencia EXPERIENCIA MINIMA SOLICITADA 
	 * @param inCgvcn_existencia_manobra EXISTENCIA DE MANO DE OBRA EN LA PROVINCIA
0 - NO EXISTE MANO DE OBRA 
1 - EXISTENCIA DE MANO DE OBRA
	 * @param inCgvcn_numero_manobra NUMERO DE CERTIFICADO DE MANO DE OBRA
	 * @param inCgvcn_anio ANIO DEL COMUNICADO RADIAL
	 * @param inCgvcn_numero_comunicado NUMERO DE COMUNICADO RADIAL
	 * @param inCgvcn_oferta_aprobada CAMPO QUE IDENTIFICA SI SE APROBO UNA OFERTA
0 - NO APROBADOS
1 - APROBADOS Y GENERADO COMUNICADO RADIAL
2 - OTROS
	 * @param inCgvcn_cubierta ESTADO DE CONTRATACION DE LA VACANTE
	 * @param inCgvcn_justificacion_no_contrat DETALLE DE JUSTIFICACION DE LA NO CONTRATACION DE PERSONAL PARA ESA VACANTE
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */	
	@WebMethod
	public String update(
			@WebParam(name="inCgvcn_codigo")String inCgvcn_codigo,		
			@WebParam(name="inJSONIslaEmpleo")String inJSONIslaEmpleo,
			@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
			@WebParam(name="inCgtcn_codigo")String inCgtcn_codigo,
			@WebParam(name="inCgtsa_codigo")String inCgtsa_codigo,
			@WebParam(name="inCgcrg_codigo")String inCgcrg_codigo,
			@WebParam(name="inCgtpr_codigo")String inCgtpr_codigo,
			@WebParam(name="inCgvcn_titulo")String inCgvcn_titulo,
			@WebParam(name="inCgvcn_estado_oferta")int inCgvcn_estado_oferta,
			@WebParam(name="inCgvcn_descripcion")String inCgvcn_descripcion,
			@WebParam(name="inCgvcn_salario")java.math.BigDecimal inCgvcn_salario,
			@WebParam(name="inCgvcn_direccion")String inCgvcn_direccion,
			@WebParam(name="inCgvcn_numero_vacantes")int inCgvcn_numero_vacantes,
			@WebParam(name="inCgvcn_duracion")int inCgvcn_duracion,
			@WebParam(name="inCgvcn_duracion_tiempo")java.math.BigDecimal inCgvcn_duracion_tiempo,
			@WebParam(name="inCgvcn_experiencia")String inCgvcn_experiencia
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_gem_vacante obj = new com.besixplus.sii.objects.Cgg_gem_vacante();
		obj.setCGVCN_CODIGO(inCgvcn_codigo);		
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCGTCN_CODIGO(inCgtcn_codigo);
		obj.setCGTSA_CODIGO(inCgtsa_codigo);
		obj.setCGCRG_CODIGO(inCgcrg_codigo);
		obj.setCGTPR_CODIGO(inCgtpr_codigo);
		obj.setCGVCN_TITULO(inCgvcn_titulo);
		obj.setCGVCN_ESTADO_OFERTA(inCgvcn_estado_oferta);
		obj.setCGVCN_DESCRIPCION(inCgvcn_descripcion);
		obj.setCGVCN_SALARIO(inCgvcn_salario);
		obj.setCGVCN_DIRECCION(inCgvcn_direccion);
		obj.setCGVCN_NUMERO_VACANTES(inCgvcn_numero_vacantes);
		obj.setCGVCN_DURACION(inCgvcn_duracion);
		obj.setCGVCN_DURACION_TIEMPO(inCgvcn_duracion_tiempo);
		obj.setCGVCN_EXPERIENCIA(inCgvcn_experiencia);
		obj.setCGVCN_ESTADO(true);
		obj.setCGVCN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_gem_vacante(obj).updateUsers(con);
			if(!res.equals("true"))
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
			else{
				org.json.JSONArray JSONIslasEmpleo = new org.json.JSONArray(inJSONIslaEmpleo);
				org.json.JSONObject JSONTmpIslaEmpleo= (org.json.JSONObject)JSONIslasEmpleo.get(0);

				org.json.JSONArray JSONIslasEmpleoNew = JSONTmpIslaEmpleo.getJSONArray("objNew");
				org.json.JSONArray JSONIslasEmpleoDel = JSONTmpIslaEmpleo.getJSONArray("objDel");

				for (int i = 0 ; i < JSONIslasEmpleoNew.length(); i++){
					org.json.JSONObject JSONIslaEmpleoNew = (org.json.JSONObject)JSONIslasEmpleoNew.get(i);
					com.besixplus.sii.objects.Cgg_gem_isla_empleo objVac = new com.besixplus.sii.objects.Cgg_gem_isla_empleo();
					objVac.setCGISE_CODIGO("KEYGEN");
					objVac.setCGVCN_CODIGO(inCgvcn_codigo);
					objVac.setCISLA_CODIGO(JSONIslaEmpleoNew.get("CISLA_CODIGO").toString());
					objVac.setCGISE_DIRECCION("");
					objVac.setCGISE_ESTADO(true);					
					objVac.setCGISE_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objVac.setCGISE_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_gem_isla_empleo(objVac).insert(con);
				}
				for (int i = 0 ; i < JSONIslasEmpleoDel.length(); i++){
					org.json.JSONObject JSONIslaEmpleoDel = (org.json.JSONObject)JSONIslasEmpleoDel.get(i);
					com.besixplus.sii.objects.Cgg_gem_isla_empleo objVac = new com.besixplus.sii.objects.Cgg_gem_isla_empleo();
					objVac.setCGISE_CODIGO(JSONIslaEmpleoDel.get("CGISE_CODIGO").toString());					
					new com.besixplus.sii.db.Cgg_gem_isla_empleo(objVac).delete(con);
				}
			}

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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_gem_vacante EN UNA ESTRUCTURA JSON o XML.
	 * @param inCgvcn_codigo cgvcn_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCgvcn_codigo")String inCgvcn_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		HashMap<String,Object>  tmpObj = new HashMap<String,Object>();		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_gem_vacante().select(con,inCgvcn_codigo);
			ArrayList<HashMap<String, Object>> tmpArray = new ArrayList<HashMap<String, Object>> ();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_gem_vacante.
	 * @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCgvcn_codigo")String inCgvcn_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_gem_vacante tmpObj = new com.besixplus.sii.objects.Cgg_gem_vacante();
		tmpObj.setCGVCN_CODIGO(inCgvcn_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_gem_vacante(tmpObj).delete(con);
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

	/** APROBACIOND EL AOFERTA VACANTE.
	 * @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE LA VACANTE.
	 * @param inCgvcn_fecha_publicacion FECHA DE PUBLICACION DE LA VACANTE.
	 * @param inCgvcn_duracion_oferta DURACION DE LA OFERTA.
	 * @param inCgvcn_fecha_expiracion FECHA DE EXPIRACION DE LA VACANTE.
	 * @return APROBACION.
	 */
	@WebMethod
	public String aprobarOfertaVacante(
			@WebParam(name="inCgvcn_codigo")String inCgvcn_codigo,
			@WebParam(name="inCgvcn_fecha_publicacion")java.util.Date inCgvcn_fecha_publicacion,
			@WebParam(name="inCgvcn_duracion_oferta")int inCgvcn_duracion_oferta,
			@WebParam(name="inCgvcn_fecha_expiracion")java.util.Date inCgvcn_fecha_expiracion			
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_gem_vacante obj = new com.besixplus.sii.objects.Cgg_gem_vacante();
		obj.setCGVCN_CODIGO(inCgvcn_codigo);
		obj.setCGVCN_FECHA_PUBLICACION(inCgvcn_fecha_publicacion);
		obj.setCGVCN_DURACION_OFERTA(inCgvcn_duracion_oferta);
		obj.setCGVCN_FECHA_EXPIRACION(inCgvcn_fecha_expiracion);		
		obj.setCGVCN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_gem_vacante(obj).aprobarOfertaVacante(con);
			/*if(!res.equals("true"))
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);*/
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
	 * Obtiene el rol del usuario logineado
	 * @return rol NOMBRE DEL ROL.
	 */
	@WebMethod
	public String getRolUsuario(
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_gem_vacante().getRolUsuario(con,tmpRequest.getUserPrincipal().getName());
			if(res.equals("false"))
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

	/** GENERA LA EXISTENCIA DE MANO DE OBRA
	 * @param inCgvcn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VACANTE.
	 * @param inCgvcn_existencia_manobra EXISTENCIA DE MANO DE OBRA EN LA PROVINCIA
			0 - NO EXISTE MANO DE OBRA 
			1 - EXISTENCIA DE MANO DE OBRA
	 * @param inCgvcn_justificacion_no_contrat
	 * @return EXISTENCIA DE MANO DE OBRA.
	 */
	@WebMethod
	public String generarExistenciaManoObra(
			@WebParam(name="inCgvcn_codigo")String inCgvcn_codigo,		
			@WebParam(name="inCgvcn_existencia_manobra")int inCgvcn_existencia_manobra,		
			@WebParam(name="inCgvcn_justificacion_no_contrat")String inCgvcn_justificacion_no_contrat
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_gem_vacante obj = new com.besixplus.sii.objects.Cgg_gem_vacante();
		obj.setCGVCN_CODIGO(inCgvcn_codigo);	
		obj.setCGVCN_EXISTENCIA_MANOBRA(inCgvcn_existencia_manobra);
		obj.setCGVCN_JUSTIFICACION_NO_CONTRAT(inCgvcn_justificacion_no_contrat);
		obj.setCGVCN_ESTADO(true);
		obj.setCGVCN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_gem_vacante(obj).generarExistenciaManoObra(con);
			if(res.equals("false"))
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
	 * Actualiza el estado de la oferta
	 * @param inCgvcn_codigo Codigo de la oferta vacante
	 * @param inCgvcn_estado_oferta Estado de la oferta a ser actualizada
	 * @return ESTADO DE OFERTA.
	 */
	@WebMethod
	public String actualizarEstadoOferta(
			@WebParam(name="inCgvcn_codigo")String inCgvcn_codigo,		
			@WebParam(name="inCgvcn_estado_oferta")int inCgvcn_estado_oferta		
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_gem_vacante obj = new com.besixplus.sii.objects.Cgg_gem_vacante();
		obj.setCGVCN_CODIGO(inCgvcn_codigo);	
		obj.setCGVCN_ESTADO_OFERTA(inCgvcn_estado_oferta);
		obj.setCGVCN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_gem_vacante(obj).actualizarEstadoOferta(con);
			if(res.equals("false"))
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
	 * SELECCIONA LA INFORMACION ESCENCIAL DE UN USUARIO
	 * @param inCusu_codigo Codigo del usuario
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return COLECCION DE INFORMACION.
	 */
	@WebMethod
	public String selectInformacionUsuario(
			@WebParam(name="inCusu_codigo")String inCusu_codigo,
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
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = new com.besixplus.sii.db.Cgg_gem_vacante().selectInformacionUsuario(con, inCusu_codigo);
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
				return outCadena.insert(outCadena.indexOf("<dataSet>")+9,"<totalCount>"+tmpCount+"</totalCount>").toString();
		return null;
	}

	/** ESTABLECE LA FINALIZACION DE LOS PROCESOS.
	 * @param inCgvcn_codigo IDENTIFICATIVO UNICO DE VACANTE.
	 * @param inCgvcn_estado_oferta ESTADO EN EL QUE SE HALLA LA PUBLICACION DE LA VACANTE
		1 - REGISTRADA
		0 - POR APROBACION
		1 - APROBADA Y GENERADO EL COMUNICADO RADIAL
		2 - RECHAZADA FINALIZADA
		3 - VENCIDA FECHA DE PUBLICACION
		4 - GENERADO LA CERTIFICACION DE NO EXISTENCIA DE MANO DE OBRA Y FINALIZADA
		5 - GENERADO LA CERTIFICACION DE EXISTENCIA DE MANO DE OBRA E INICIO DE ENTREVISTA
		6 - FINALIZADA SIN OCUPAR TODAS LAS VACANTES
		7 - FINALIZADA EXITOSAMENTE
		8 - FINALIZADA POR OTROS MOTIVOS
	 * @param inCgvcn_justificacion_no_contrat DETALLE DE JUSTIFICACION DE LA NO CONTRATACION DE PERSONAL PARA ESA VACANTE
	 * @return FINALIZACION.
	 */
	@WebMethod
	public String finalizarProceso(
			@WebParam(name="inCgvcn_codigo")String inCgvcn_codigo,		
			@WebParam(name="inCgvcn_estado_oferta")int inCgvcn_estado_oferta,		
			@WebParam(name="inCgvcn_justificacion_no_contrat")String inCgvcn_justificacion_no_contrat
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_gem_vacante obj = new com.besixplus.sii.objects.Cgg_gem_vacante();
		obj.setCGVCN_CODIGO(inCgvcn_codigo);	
		obj.setCGVCN_ESTADO_OFERTA(inCgvcn_estado_oferta);
		obj.setCGVCN_JUSTIFICACION_NO_CONTRAT(inCgvcn_justificacion_no_contrat);
		obj.setCGVCN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_gem_vacante(obj).finalizarProceso(con);
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
	 * Verifica si un comunicado radial es valido para ser utilizado para un residencia.
	 * Al ser valido significa q el comunicado no esta expirado, ni se ha seleccionado algun personal para su vacante o si no se ha presentado personal se rige por la fecha de expiracion.
	 * @param inCgvcn_numero_comunicado Numero de comunicado radial. 
	 * @return 0 - invalido / 1 - valido.
	 */
	@WebMethod
	public String verificarComunicado(
			@WebParam(name="inCgvcn_numero_comunicado")String inCgvcn_numero_comunicado
	){
		String outResult = "0";
		//		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_gem_vacante tmpObj = new com.besixplus.sii.objects.Cgg_gem_vacante();
		tmpObj.setCGVCN_NUMERO_COMUNICADO(inCgvcn_numero_comunicado);
		try{
			Connection con = ManagerConnection.getConnection();
			//			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
			//				con.close();
			//				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
			//				return null;
			//			}
			outResult = new com.besixplus.sii.db.Cgg_gem_vacante(tmpObj).verificarComunicado(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			//			try {
			//				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			//			} catch (IOException e) {
			//				e.printStackTrace();
			//			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			//			try {
			//				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			//			} catch (IOException e) {
			//				e.printStackTrace();
			//			}
			return inException.getMessage();
		}
		return outResult;
	}	
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_gem_perfil_prof EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO XML O JSON
	 * @param inCusu_codigo CODIGO DEL USUARIO A LISTAR LAS OFERTAS
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectOfertasByUsuarios(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCusu_codigo")String inCusu_codigo		

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
			tmpCount = com.besixplus.sii.db.Cgg_gem_vacante.countOfertasByUsuario(con, keyword,inCusu_codigo);
			con.setAutoCommit(!ManagerConnection.isDeployed());			
			obj = com.besixplus.sii.db.Cgg_gem_vacante.selectOfertasByUsuario(con,tmpRequest.getUserPrincipal().getName(),start,limit,sort,dir,keyword,inCusu_codigo);			
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
			//if( format.toUpperCase().equals("JSON"))
			return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
		else
			return null;
	}
	/**
	 * Actualiza el estado de la oferta
	 * @param inCgvcn_codigo Codigo de la oferta vacante
	 * @param inCgvcn_estado_oferta Estado de la oferta a ser actualizada
	 * @param inMsgRevision MENSAJE DE REVISION 
	 * @return
	 */
	@WebMethod
	public String enviarParaRevision(
			@WebParam(name="inCgvcn_codigo")String inCgvcn_codigo,		
			@WebParam(name="inCgvcn_estado_oferta")int inCgvcn_estado_oferta,
			@WebParam(name="inMsgRevision")String inMsgRevision
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_gem_vacante obj = new com.besixplus.sii.objects.Cgg_gem_vacante();
		obj.setCGVCN_CODIGO(inCgvcn_codigo);	
		obj.setCGVCN_ESTADO_OFERTA(inCgvcn_estado_oferta);
		obj.setCGVCN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_gem_vacante(obj).enviarParaRevision(con, inMsgRevision);
			if(res.equals("false"))
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
	 * Selecciona un  listado de los usuarios responsables de publicar ofertas de una empresa
	 * @param start INDICE DE INICIO 
	 * @param limit TOTAL DE REGISTROS QUE SON CONSIDERADOS
	 * @param sort NOMBRE DE LA COLUMNA DEL ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inCusu_codigo IDENTIFICATIVO UNICO DE USUARIO.
	 * @return
	 */
	@WebMethod	
	public String selectUsuarioEmpresa(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword
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
			tmpCount = new com.besixplus.sii.db.Cgg_gem_vacante().selectUsuarioEmpresaCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());			
			obj = com.besixplus.sii.db.Cgg_gem_vacante.selectUsuarioEmpresa(con,tmpRequest.getUserPrincipal().getName(),start,limit,sort,dir,keyword);			
			tmpFormat = new com.besixplus.sii.misc.Formatter("JSON", obj);
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
			//if( format.toUpperCase().equals("JSON"))
			return "{\"totalCount\":\""+tmpCount+"\",\"dataSet\":"+outCadena.toString()+"}";
		else
			return null;
	}
}