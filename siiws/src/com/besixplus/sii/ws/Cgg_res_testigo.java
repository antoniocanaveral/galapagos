package com.besixplus.sii.ws;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.besixplus.sii.db.ManagerConnection;

/**
 * CLASE Cgg_res_testigo
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_testigo POR MEDIO DE SERVICOS WEB.
 *
 * @autor BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_testigo implements Serializable{

	private static final long serialVersionUID = 490480009;

	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_testigo.
	 * @param inCrint_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA.
	 * @param inCrtst_testimonio TESTIMONIO DE UN PERSONA.
	 * @param inCrtst_observacion INFORMACION ADICIONAL.
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrint_codigo")String inCrint_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCrtst_testimonio")String inCrtst_testimonio,
			@WebParam(name="inCrtst_observacion")String inCrtst_observacion
	){
		boolean res = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_testigo obj = new com.besixplus.sii.objects.Cgg_res_testigo();
		obj.setCRTST_CODIGO("KEYGEN");
		obj.setCRINT_CODIGO(inCrint_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRTST_TESTIMONIO(inCrtst_testimonio);
		obj.setCRTST_OBSERVACION(inCrtst_observacion);
		obj.setCRTST_ESTADO(true);
		obj.setCRTST_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRTST_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_testigo(obj).insert(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return new Boolean(res).toString();
	}

	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_testigo EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_testigo> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_testigo.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_testigo EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param inTestigo TESTIGO
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 */
	@WebMethod
	public String selectPage(

			@WebParam(name="inTestigo")String inTestigo,
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	){
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_res_testigo> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			//tmpCount = com.besixplus.sii.db.Cgg_res_testigo.selectCount(con, keyword);
			con.setAutoCommit(false);

			com.besixplus.sii.objects.Cgg_res_testigo tmpObj = new com.besixplus.sii.objects.Cgg_res_testigo();
			tmpObj.setTESTIGO(inTestigo);
			obj = com.besixplus.sii.db.Cgg_res_testigo.selectAll(con, tmpRequest.getUserPrincipal().getName(),inTestigo, start, limit, sort, dir, keyword);


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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_testigo.
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TESTIGO
	 * @param inCrint_codigo IDENTIFICATIVO UNICO DE REGISTRO DE INFORME TESTIGO
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	 * @param inCrtst_testimonio TESTIMONIO DE UN PERSONA
	 * @param inCrtst_observacion INFORMACION ADICIONAL
	 * @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="inCrint_codigo")String inCrint_codigo,
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCrtst_testimonio")String inCrtst_testimonio,
			@WebParam(name="inCrtst_observacion")String inCrtst_observacion
	){
		boolean res = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_testigo obj = new com.besixplus.sii.objects.Cgg_res_testigo();
		obj.setCRTST_CODIGO(inCrtst_codigo);
		obj.setCRINT_CODIGO(inCrint_codigo);
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRTST_TESTIMONIO(inCrtst_testimonio);
		obj.setCRTST_OBSERVACION(inCrtst_observacion);
		obj.setCRTST_ESTADO(true);
		obj.setCRTST_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			res = new com.besixplus.sii.db.Cgg_res_testigo(obj).update(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		return new Boolean(res).toString();
	}


	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_testigo EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrtst_codigo crtst_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	 * @return String REGISTRO SELECCIONADO.
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="format")String format
	){
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_testigo tmpObj = new com.besixplus.sii.objects.Cgg_res_testigo();
		tmpObj.setCRTST_CODIGO(inCrtst_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_testigo(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_testigo> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_testigo>();
			tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpArray);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			return inException.getMessage();
		}
		if (tmpObj != null)
			return tmpFormat.getData().toString();
		return null;
	}


	/**
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_testigo.
	 * @param inCrtst_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TESTIGO
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo
	){
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		com.besixplus.sii.objects.Cgg_res_testigo tmpObj = new com.besixplus.sii.objects.Cgg_res_testigo();
		tmpObj.setCRTST_CODIGO(inCrtst_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
				return null;
			}
			outResult = new com.besixplus.sii.db.Cgg_res_testigo(tmpObj).delete(con);
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

}