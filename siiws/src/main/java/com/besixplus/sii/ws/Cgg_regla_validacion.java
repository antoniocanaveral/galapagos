package com.besixplus.sii.ws;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.besixplus.sii.util.Env;
import com.bmlaurus.exception.EnvironmentVariableNotDefinedException;
import com.bmlaurus.rule.RuleClass;
import com.bmlaurus.rule.RuleData;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*import javax.servlet.http.HttpServletResponse;*/

/**
 * CLASE Cgg_regla_validacion
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_regla_validacion POR MEDIO DE SERVICIOS WEB.
 *
 * @autor BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_regla_validacion implements Serializable{

	private static final long serialVersionUID = 1472428513;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_regla_validacion.
	 * @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARAMETRO DE CONFIGURACION.
	 * @param inCrval_nombre NOMBRE DE LA REGLA DE VALIDACION.
	 * @param inCrval_descripcion CADENA DE TEXTO DE DESCRIPCION DE LA REGLA DE VALIDACION..
	 * @param inCrval_funcion_validacion CADENA QUE IDENTIFICA LA FUNCION O UNION DE FUNCIONES A EJECUTARSE PARA OBTENER UN RESULTADO A COMPARSER CON EL RESULTADO ESTABLECIDO DE LA REGLA DE VALIDACION..
	 * @param inCrval_operador_comparador CADENA QUE IDENTIFICA EL OPERADOR COMPARADOR CON EL CUAL SE VA A EVALUAR LOS VALORES OBTENIDOS DE LS FUNCION DE VALIDACION..
	 * @param inCrval_valor_libre CADENA DE TEXTO CON UN VALOR LIBRE SOBRE EL CUAL LA REGLA SE VALIDA, USAR ESTE CAMPO SOLO PARA REGLAS CUYO VALOR NO SE DESEE MANEJAR A TRAVEZ DE UN PARAMETRO DE CONFIGURACION.
	 * @param inCrval_resultado_aceptacion CADENA DE TEXTO QUE IDENTIFICA EL VALOR POR EL CUAL SE COMPARA LA REGLA Y SE DA POR ACEPTADO..
	 * @param inCrval_sugerencia CADENA DE TEXTO DE SUGERENCIA DEL PORQUE UNA REGLA FUE INVALIDA Y POSIBLE SOLUCIONES PARA ACEPCION DE LA REGLA.
	 * @param inCrval_tipo TIPO DE REGLA DE VALIDACION
0 - TEMPORAL
1 - INDEFINIDA.
	 * @param inCrvar_fecha_inicio FECHA DE INICIO DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION..
	 * @param inCrvar_fecha_fin FECHA DE FIN DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION..
	 * @param inCrval_valor_1 CADENA DE TEXTO DE VALOR ADICIONAL EN CASO DE ADECUACIONES A LAS REGLAS DE VALIDACION.
	 * @param inCrval_valor_2 NO ESPECIFICADO.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCgcnf_codigo")String inCgcnf_codigo,
			@WebParam(name="inCrval_nombre")String inCrval_nombre,
			@WebParam(name="inCrval_descripcion")String inCrval_descripcion,
			@WebParam(name="inCrval_funcion_validacion")String inCrval_funcion_validacion,
			@WebParam(name="inCrval_operador_comparador")String inCrval_operador_comparador,
			@WebParam(name="inCrval_valor_libre")String inCrval_valor_libre,
			@WebParam(name="inCrval_resultado_aceptacion")String inCrval_resultado_aceptacion,
			@WebParam(name="inCrval_sugerencia")String inCrval_sugerencia,
			@WebParam(name="inCrval_tipo")int inCrval_tipo,
			@WebParam(name="inCrvar_fecha_inicio")java.util.Date inCrvar_fecha_inicio,
			@WebParam(name="inCrvar_fecha_fin")java.util.Date inCrvar_fecha_fin,
			@WebParam(name="inCrval_valor_1")String inCrval_valor_1,
			@WebParam(name="inCrval_valor_2")String inCrval_valor_2
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);

		com.besixplus.sii.objects.Cgg_regla_validacion obj = new com.besixplus.sii.objects.Cgg_regla_validacion();
		obj.setCRVAL_CODIGO("KEYGEN");
		obj.setCGCNF_CODIGO(inCgcnf_codigo);
		obj.setCRVAL_NOMBRE(inCrval_nombre);
		obj.setCRVAL_DESCRIPCION(inCrval_descripcion);
		obj.setCRVAL_FUNCION_VALIDACION(inCrval_funcion_validacion);
		obj.setCRVAL_OPERADOR_COMPARADOR(inCrval_operador_comparador);
		obj.setCRVAL_VALOR_LIBRE(inCrval_valor_libre);
		obj.setCRVAL_RESULTADO_ACEPTACION(inCrval_resultado_aceptacion);
		obj.setCRVAL_SUGERENCIA(inCrval_sugerencia);
		obj.setCRVAL_TIPO(inCrval_tipo);
		obj.setCRVAR_FECHA_INICIO(inCrvar_fecha_inicio);
		obj.setCRVAR_FECHA_FIN(inCrvar_fecha_fin);
		obj.setCRVAL_VALOR_1(inCrval_valor_1);
		obj.setCRVAL_VALOR_2(inCrval_valor_2);
		obj.setCRVAL_ESTADO(true);
		obj.setCRVAL_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRVAL_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_regla_validacion(obj).insert(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_regla_validacion EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_regla_validacion.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_regla_validacion EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA
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
		ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_regla_validacion.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_regla_validacion.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_regla_validacion EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_regla_validacion.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_regla_validacion.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_regla_validacion.
	 * @param inCrval_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	 * @param inCgcnf_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARAMETRO DE CONFIGURACION
	 * @param inCrval_nombre NOMBRE DE LA REGLA DE VALIDACION
	 * @param inCrval_descripcion CADENA DE TEXTO DE DESCRIPCION DE LA REGLA DE VALIDACION.
	 * @param inCrval_funcion_validacion CADENA QUE IDENTIFICA LA FUNCION O UNION DE FUNCIONES A EJECUTARSE PARA OBTENER UN RESULTADO A COMPARSER CON EL RESULTADO ESTABLECIDO DE LA REGLA DE VALIDACION.
	 * @param inCrval_operador_comparador CADENA QUE IDENTIFICA EL OPERADOR COMPARADOR CON EL CUAL SE VA A EVALUAR LOS VALORES OBTENIDOS DE LS FUNCION DE VALIDACION.
	 * @param inCrval_valor_libre CADENA DE TEXTO CON UN VALOR LIBRE SOBRE EL CUAL LA REGLA SE VALIDA, USAR ESTE CAMPO SOLO PARA REGLAS CUYO VALOR NO SE DESEE MANEJAR A TRAVEZ DE UN PARAMETRO DE CONFIGURACION
	 * @param inCrval_resultado_aceptacion CADENA DE TEXTO QUE IDENTIFICA EL VALOR POR EL CUAL SE COMPARA LA REGLA Y SE DA POR ACEPTADO.
	 * @param inCrval_sugerencia CADENA DE TEXTO DE SUGERENCIA DEL PORQUE UNA REGLA FUE INVALIDA Y POSIBLE SOLUCIONES PARA ACEPCION DE LA REGLA
	 * @param inCrval_tipo TIPO DE REGLA DE VALIDACION
0 - TEMPORAL
1 - INDEFINIDA
	 * @param inCrvar_fecha_inicio FECHA DE INICIO DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	 * @param inCrvar_fecha_fin FECHA DE FIN DEL PERIODO DE VIGENCIA DE LA REGLA DE VALIDACION.
	 * @param inCrval_valor_1 CADENA DE TEXTO DE VALOR ADICIONAL EN CASO DE ADECUACIONES A LAS REGLAS DE VALIDACION
	 * @param inCrval_valor_2 NO ESPECIFICADO
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrval_codigo")String inCrval_codigo,
			@WebParam(name="inCgcnf_codigo")String inCgcnf_codigo,
			@WebParam(name="inCrval_nombre")String inCrval_nombre,
			@WebParam(name="inCrval_descripcion")String inCrval_descripcion,
			@WebParam(name="inCrval_funcion_validacion")String inCrval_funcion_validacion,
			@WebParam(name="inCrval_operador_comparador")String inCrval_operador_comparador,
			@WebParam(name="inCrval_valor_libre")String inCrval_valor_libre,
			@WebParam(name="inCrval_resultado_aceptacion")String inCrval_resultado_aceptacion,
			@WebParam(name="inCrval_sugerencia")String inCrval_sugerencia,
			@WebParam(name="inCrval_tipo")int inCrval_tipo,
			@WebParam(name="inCrvar_fecha_inicio")java.util.Date inCrvar_fecha_inicio,
			@WebParam(name="inCrvar_fecha_fin")java.util.Date inCrvar_fecha_fin,
			@WebParam(name="inCrval_valor_1")String inCrval_valor_1,
			@WebParam(name="inCrval_valor_2")String inCrval_valor_2
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_regla_validacion obj = new com.besixplus.sii.objects.Cgg_regla_validacion();
		obj.setCRVAL_CODIGO(inCrval_codigo);
		obj.setCGCNF_CODIGO(inCgcnf_codigo);
		obj.setCRVAL_NOMBRE(inCrval_nombre);
		obj.setCRVAL_DESCRIPCION(inCrval_descripcion);
		obj.setCRVAL_FUNCION_VALIDACION(inCrval_funcion_validacion);
		obj.setCRVAL_OPERADOR_COMPARADOR(inCrval_operador_comparador);
		obj.setCRVAL_VALOR_LIBRE(inCrval_valor_libre);
		obj.setCRVAL_RESULTADO_ACEPTACION(inCrval_resultado_aceptacion);
		obj.setCRVAL_SUGERENCIA(inCrval_sugerencia);
		obj.setCRVAL_TIPO(inCrval_tipo);
		obj.setCRVAR_FECHA_INICIO(inCrvar_fecha_inicio);
		obj.setCRVAR_FECHA_FIN(inCrvar_fecha_fin);
		obj.setCRVAL_VALOR_1(inCrval_valor_1);
		obj.setCRVAL_VALOR_2(inCrval_valor_2);
		obj.setCRVAL_ESTADO(true);
		obj.setCRVAL_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_regla_validacion(obj).update(con);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_regla_validacion EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrval_codigo IDENTIFICATIVO UNICO DE REGLA DE VALIDACION.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrval_codigo")String inCrval_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_regla_validacion tmpObj = new com.besixplus.sii.objects.Cgg_regla_validacion();
		tmpObj.setCRVAL_CODIGO(inCrval_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			tmpObj = new com.besixplus.sii.db.Cgg_regla_validacion(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_regla_validacion>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_regla_validacion.
	 * @param inCrval_codigo IDENTIFICATIVO UNICO DE REGISTRO DE REGLA DE VALIDACION
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrval_codigo")String inCrval_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_regla_validacion tmpObj = new com.besixplus.sii.objects.Cgg_regla_validacion();
		tmpObj.setCRVAL_CODIGO(inCrval_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_regla_validacion(tmpObj).delete(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}

	/**
	 * Selecciona todas las funciones plsql del esquema SII para establicimiento de la funcion PL/SQL que validara el valor de la funcion.
	 * @param start INDICE DE INICIO
	 * @param limit TOTAL DE REGISTROS QUE SON CONSIDERADOS.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format Cadena de formato de salida JSON/XML.
	 * @return Cadena de datos en formato especificado con informacion de las funciones pl/sql disponibles para las reglas de validacion.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectFuncionPlSql(
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
			tmpCount = new com.besixplus.sii.db.Cgg_regla_validacion().selectCountFuncionPlSql(con, keyword);
			con.setAutoCommit(false);
			obj = new com.besixplus.sii.db.Cgg_regla_validacion().seleccionFuncionPlSql(con, start, limit, sort, dir, keyword);
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
	 * SELECCIONA VARIOS REGISTROS DE LA TABLA Cgg_regla_validacion DE ACUERDO AL TIPO DE SOLICITUD DE TRAMITE .
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE SOLICITUD DE TRAMITE
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return com.besixplus.sii.objects.Cgg_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectReglaTipoSolicitud(		
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;

		//int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}

			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = new com.besixplus.sii.db.Cgg_regla_validacion().selectReglaTipoSolicitud(con,inCrtst_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return outCadena.toString();
			else
				return outCadena.toString();
		return null;
	}

	/**
	 * SELECCIONA VARIOS REGISTROS DE LA TABLA Cgg_regla_validacion JUNTO CON LOS DATOS DE LOS PARAMETOS DE LA FUNCION PLSQL QUE EJECUTARA .Cadena de formato de salida de la informacion.
	 * @param format Cadena de formato de salida de la informacion.
	 * @return Cadena de datos en formato especificado.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectReglaLiteParametros(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			obj = new com.besixplus.sii.db.Cgg_regla_validacion().selectReglaLiteParametros(con,tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return outCadena.toString();
			else
				return outCadena.toString();
		return null;
	}

	/**
	 * SELECCIONA VARIOS REGISTROS DE LA TABLA Cgg_regla_validacion DE ACUERDO AL TIPO DE OPERACION DE VALIDACION .
	 * @param inCopvl_formulario IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE SOLICITUD DE TRAMITE
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return com.besixplus.sii.objects.Cgg_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectOperacionValidacionByForm(		
			@WebParam(name="inCopvl_formulario")String inCopvl_formulario,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();

			if(tmpRequest.getUserPrincipal()!=null){

				if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
					con.close();
					throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
				}
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = new com.besixplus.sii.db.Cgg_regla_validacion().selectReglaOperacionValidacionByForm(con,inCopvl_formulario);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return outCadena.toString();
			else
				return outCadena.toString();
		return null;
	}

	/**
	 * SELECCIONA VARIOS REGISTROS DE LA TABLA Cgg_regla_validacion DE ACUERDO AL TIPO DE OPERACION DE VALIDACION .
	 * @param inCopvl_codigo IDENTIFICATIVO UNICO DE REGISTRO DE OPERACION VALIDACION
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return com.besixplus.sii.objects.Cgg_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectOperacionValidacion(		
			@WebParam(name="inCopvl_codigo")String inCopvl_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}

			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = new com.besixplus.sii.db.Cgg_regla_validacion().selectReglaOperacionValidacion(con,inCopvl_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return outCadena.toString();
			else
				return outCadena.toString();
		return null;
	}

	/**
	 * Ejecuta una regla de validacion y devuelve su evaluacion.\
	 * @param inJSON_reglas_validacion Cadena de datos en formato JSON de la regla de validacion a ejecutar.
	 * @param jsonData  jsonData es un arreglo de Datos de los Beneficiarios
	 * @return Cadena de datos de la evaluacion.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String ejecutarReglaTranseuntesTipoSolicitud(
			@WebParam(name="inJSON_reglas_validacion")String inJSON_reglas_validacion,
			@WebParam(name="jsonData")String jsonData
	) throws SOAPException{
		List result = new ArrayList();
		List data = new Gson().fromJson(jsonData,ArrayList.class);
		for(int i=0;i<data.size();i++){
			String oneData = new Gson().toJson(data.get(i));
			result.add(ejecutarReglaTipoSolicitudLocal(inJSON_reglas_validacion, oneData));
		}
		return new Gson().toJson(result);
	}

	/**
	 * Ejecuta una regla de validacion y devuelve su evaluacion.\
	 * @param inJSON_reglas_validacion Cadena de datos en formato JSON de la regla de validacion a ejecutar.
	 * @return Cadena de datos de la evaluacion.
	 * @throws SOAPException
	 */
	@WebMethod
	public String ejecutarReglaTipoSolicitud(
			@WebParam(name="inJSON_reglas_validacion")String inJSON_reglas_validacion,
			@WebParam(name="jsonData")String jsonData
	) throws SOAPException{
		return ejecutarReglaTipoSolicitudLocal(inJSON_reglas_validacion, jsonData);
	}

	/** ESTABLECE LAS REGLAS DE VALIDACIONES.
	 * @param inRulesNames NOMBRE DE LAS REGLAS
	 * @param inParams NOMBRE DE LOS PARAMETROS.
	 * @return VALIDACION.
	 */
	@WebMethod
	public String validar(
			@WebParam(name="inRulesNames")String inRulesNames,
			@WebParam(name="inParams")String inParams
	){		
		String[] tmpRules = inRulesNames.split(",");
		Connection tmpCon = ManagerConnection.getConnection();
		JSONArray outResult = new JSONArray();
		String tmpRes = "";
		try {
			for(int i = 0; i < tmpRules.length; i++){
				tmpRes = new com.besixplus.sii.db.Cgg_regla_validacion().validar(tmpCon, tmpRules[i], new JSONArray(inParams) );
				if(!tmpRes.equalsIgnoreCase("true"))
					outResult.put(tmpRes);
			}
			tmpCon.close();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outResult.toString();
	}
	
	/**
	 * SELECCIONA VARIOS REGISTROS DE LA TABLA Cgg_regla_validacion DE ACUERDO AL TIPO DE OPERACION DE VALIDACION .
	 * @param inCopvl_formulario IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE SOLICITUD DE TRAMITE
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return com.besixplus.sii.objects.Cgg_regla_validacion OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	 * @throws SOAPException 
	 */
	
	public String selectOperacionValidacionLocal(		
			String inCopvl_formulario,
			String format
	) throws SOAPException{
		ArrayList<HashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = new com.besixplus.sii.db.Cgg_regla_validacion().selectReglaOperacionValidacionByForm(con,inCopvl_formulario);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return outCadena.toString();
			else
				return outCadena.toString();
		return null;
	}
	
	/**
	 * Ejecuta una regla de validacion y devuelve su evaluacion.\
	 * @param inJSON_reglas_validacion Cadena de datos en formato JSON de la regla de validacion a ejecutar.
	 * @return Cadena de datos de la evaluacion.
	 * @throws SOAPException 
	 */
	public String ejecutarReglaTipoSolicitudLocal(		
			String inJSON_reglas_validacion,
			String jsonData
	) throws SOAPException{
		
		JSONArray arrayJSONRegla = null;
		JSONObject objJSONRegla = null;
		boolean outResultadoValidacion =  true; 
		String tmpResultado;
		String [] outResult = null;
		try{
			Connection con = ManagerConnection.getConnection();
			con.setAutoCommit(false);

			arrayJSONRegla = new JSONArray(inJSON_reglas_validacion);
			for(int i=0;i< arrayJSONRegla.length();i++)
			{
				objJSONRegla = arrayJSONRegla.getJSONObject(i);
				com.besixplus.sii.objects.Cgg_regla_validacion objRegla = new com.besixplus.sii.objects.Cgg_regla_validacion();
				objRegla.setCRVAL_FUNCION_VALIDACION(objJSONRegla.getString("CRVAL_FUNCION_VALIDACION"));
				Cgg_regla_validacion_metadatos objReglaMetadatos =  new Cgg_regla_validacion_metadatos();
				objReglaMetadatos = new com.besixplus.sii.db.Cgg_regla_validacion(objRegla).selectReglaMetadatos(con);
				RuleData jsonRecord = null;
				try{
					if(jsonData!=null){
						Gson parser = new Gson();
						jsonRecord = parser.fromJson(jsonData,RuleData.class);
					}
				}catch (Exception e){
					e.printStackTrace();
				}

				if(objRegla.getCRVAL_FUNCION_VALIDACION().contains("com.bmlaurus.rule")){//es una regla de java
					String className = objRegla.getCRVAL_FUNCION_VALIDACION();
					URLClassLoader externalClassLoader = new URLClassLoader (Env.resolveClassPath("rules"), this.getClass().getClassLoader());
					Class clazz = Class.forName(className,true,externalClassLoader);
					RuleClass rule = (RuleClass) clazz.newInstance();
					tmpResultado = rule.executeRule(objReglaMetadatos, objJSONRegla, jsonRecord);
				}else
					tmpResultado = 	new com.besixplus.sii.db.Cgg_regla_validacion().reglaStatement(con,objReglaMetadatos,objJSONRegla);

				outResult = tmpResultado.split(",");
				if( Boolean.parseBoolean(outResult[0]) != objJSONRegla.getBoolean("CRVAL_RESULTADO_ACEPTACION") )
				{
					arrayJSONRegla.getJSONObject(i).put("CRVAL_APROBADO", "FALSE");
					outResultadoValidacion = false;
				}
				else
				{
					arrayJSONRegla.getJSONObject(i).put("CRVAL_APROBADO", "TRUE");
				}
				if (outResult.length>1)
				{
					arrayJSONRegla.getJSONObject(i).put("CRVAL_SUGERENCIA",outResult[1]);
				}
			}
			con.commit();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (EnvironmentVariableNotDefinedException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return "{\"resultadoValidacion\":\""+outResultadoValidacion+"\",\"dataSet\":"+arrayJSONRegla.toString()+"}";
		//return arrayJSONRegla.toString();
	}
	
}