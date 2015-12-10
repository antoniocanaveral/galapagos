package com.besixplus.sii.ws;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.objects.Cgg_veh_vehiculo_motor;

/**
* CLASE Cgg_veh_motor
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_veh_motor POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_veh_motor implements Serializable{

	private static final long serialVersionUID = 1963591352;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_veh_motor.
	* @param inCvcln_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE.
	* @param inCvmrc_codigo IDENTIFICADOR UNICO DE REGISTRO DE MARCA.
	* @param inCvcmb_codigo IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE.
	* @param inCvmtr_serie SERIE DE FABRICA DEL MOTOR.
	* @param inCvmtr_anio_fabricacion ANIO DE FABRICACION DEL MOTOR..
	* @param inCvmtr_estado_funcional ESTADO DE FUNCIONAMIENTO DEL MOTOR.
	* @param inCvmtr_tonelaje CAPACIDAD DE CARGA.
	* @param inCvmtr_ingreso INDICA SI EL MOTOR ESTA DENTRO DE LA PROVINCIA.
	* @param inCvmtr_fecha_ingreso FECHA DE INGRESO DEL MOTOR A LA PROVINCIA.
	* @param inCvmtr_salio INDICA SI EL MOTOR ESTA DENTRO DE LA PRONVINCIA.
	* @param inCvmtr_fecha_salida FECHA DE SALIDA DEL MOTOR DE LA PROVINCIA.
	* @param inCvmtr_observacion INFORMACION ADICIONAL.
	* @param inCvveh_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO
	* @param inEstados ESTADO
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCvcln_codigo")String inCvcln_codigo,
		@WebParam(name="inCvmrc_codigo")String inCvmrc_codigo,
		@WebParam(name="inCvcmb_codigo")String inCvcmb_codigo,
		@WebParam(name="inCvmtr_serie")String inCvmtr_serie,
		@WebParam(name="inCvmtr_anio_fabricacion")int inCvmtr_anio_fabricacion,
		@WebParam(name="inCvmtr_estado_funcional")boolean inCvmtr_estado_funcional,
		@WebParam(name="inCvmtr_tonelaje")int inCvmtr_tonelaje,
		@WebParam(name="inCvmtr_ingreso")boolean inCvmtr_ingreso,
		@WebParam(name="inCvmtr_fecha_ingreso")java.util.Date inCvmtr_fecha_ingreso,
		@WebParam(name="inCvmtr_salio")boolean inCvmtr_salio,
		@WebParam(name="inCvmtr_fecha_salida")java.util.Date inCvmtr_fecha_salida,
		@WebParam(name="inCvmtr_observacion")String inCvmtr_observacion,
		@WebParam(name="inCvveh_codigo")String inCvveh_codigo,
		@WebParam(name="inEstados")String inEstados
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_motor obj = new com.besixplus.sii.objects.Cgg_veh_motor();
		obj.setCVMTR_CODIGO("KEYGEN");
		obj.setCVCLN_CODIGO(inCvcln_codigo);
		obj.setCVMRC_CODIGO(inCvmrc_codigo);
		obj.setCVCMB_CODIGO(inCvcmb_codigo);
		obj.setCVMTR_SERIE(inCvmtr_serie);
		obj.setCVMTR_ANIO_FABRICACION(inCvmtr_anio_fabricacion);
		obj.setCVMTR_ESTADO_FUNCIONAL(inCvmtr_estado_funcional);
		obj.setCVMTR_TONELAJE(inCvmtr_tonelaje);
		obj.setCVMTR_INGRESO(inCvmtr_ingreso);
		obj.setCVMTR_FECHA_INGRESO(inCvmtr_fecha_ingreso);
		obj.setCVMTR_SALIO(inCvmtr_salio);
		obj.setCVMTR_FECHA_SALIDA(inCvmtr_fecha_salida);
		obj.setCVMTR_OBSERVACION(inCvmtr_observacion);
		obj.setCVMTR_ESTADO(true);
		obj.setCVMTR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCVMTR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			con.setAutoCommit(false);
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_veh_motor(obj).insert(con);
			if(res.equals("true")){
				JSONArray tmpEstados = new JSONArray(inEstados);
				for(int i = 0 ; i < tmpEstados.length(); i++){
					JSONObject tmpEstado = (JSONObject) tmpEstados.get(i);
					com.besixplus.sii.objects.Cgg_veh_motor_estado tmpMotorEstado = new com.besixplus.sii.objects.Cgg_veh_motor_estado();
					tmpMotorEstado.setCVSMT_CODIGO("KEYGEN");
					tmpMotorEstado.setCVMTR_CODIGO(obj.getCVMTR_CODIGO());
					tmpMotorEstado.setCVSMT_FECHA(Timestamp.valueOf(tmpEstado.getString("CVSMT_FECHA")));
					tmpMotorEstado.setCVSVM_CODIGO(tmpEstado.getString("CVSVM_CODIGO"));
					tmpMotorEstado.setCVSMT_OBSERVACION(tmpEstado.getString("CVSMT_OBSERVACION"));
					tmpMotorEstado.setCVSMT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					tmpMotorEstado.setCVSMT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					tmpMotorEstado.setCVSMT_ESTADO(true);
					res = new com.besixplus.sii.db.Cgg_veh_motor_estado(tmpMotorEstado).insert(con);
					if(!res.equals("true"))
						break;
				}
			}
			if(res.equals("true") && inCvveh_codigo != null && !inCvveh_codigo.trim().isEmpty()){
				com.besixplus.sii.objects.Cgg_veh_vehiculo_motor tmpVmt = new Cgg_veh_vehiculo_motor();
				tmpVmt.setCVVMT_CODIGO("KEYGEN");
				tmpVmt.setCVMTR_CODIGO(obj.getCVMTR_CODIGO());
				tmpVmt.setCVVEH_CODIGO(inCvveh_codigo);
				tmpVmt.setCVVMT_ESTADO(true);
				tmpVmt.setCVVMT_FECHA(new Date());
				tmpVmt.setCVVMT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
				tmpVmt.setCVVMT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
				res = new com.besixplus.sii.db.Cgg_veh_vehiculo_motor(tmpVmt).insert(con);
			}
			if(res.equals("true")){
				con.commit();
				con.setAutoCommit(true);
			}
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_motor EN UNA ESTRUCTRA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
 * @throws SOAPException 
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_veh_motor.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_veh_motor EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	* @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	* @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	* @param keyword CRITERIO DE BUSQUEDA.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @param inCvveh_codigo IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO.
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
		@WebParam(name="inCvveh_codigo")String inCvveh_codigo
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
			tmpCount = com.besixplus.sii.db.Cgg_veh_motor.selectCount(con, keyword, inCvveh_codigo);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_veh_motor.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inCvveh_codigo);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_veh_motor.
	* @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	* @param inCvcln_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
	* @param inCvmrc_codigo IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	* @param inCvcmb_codigo IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	* @param inCvmtr_serie SERIE DE FABRICA DEL MOTOR
	* @param inCvmtr_anio_fabricacion ANIO DE FABRICACION DEL MOTOR.
	* @param inCvmtr_estado_funcional ESTADO DE FUNCIONAMIENTO DEL MOTOR
	* @param inCvmtr_tonelaje CAPACIDAD DE CARGA
	* @param inCvmtr_ingreso INDICA SI EL MOTOR ESTA DENTRO DE LA PROVINCIA
	* @param inCvmtr_fecha_ingreso FECHA DE INGRESO DEL MOTOR A LA PROVINCIA
	* @param inCvmtr_salio INDICA SI EL MOTOR ESTA DENTRO DE LA PRONVINCIA
	* @param inCvmtr_fecha_salida FECHA DE SALIDA DEL MOTOR DE LA PROVINCIA
	* @param inCvmtr_observacion INFORMACION ADICIONAL
	* @param inEstados ESTADOS 
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCvmtr_codigo")String inCvmtr_codigo,
		@WebParam(name="inCvcln_codigo")String inCvcln_codigo,
		@WebParam(name="inCvmrc_codigo")String inCvmrc_codigo,
		@WebParam(name="inCvcmb_codigo")String inCvcmb_codigo,
		@WebParam(name="inCvmtr_serie")String inCvmtr_serie,
		@WebParam(name="inCvmtr_anio_fabricacion")int inCvmtr_anio_fabricacion,
		@WebParam(name="inCvmtr_estado_funcional")boolean inCvmtr_estado_funcional,
		@WebParam(name="inCvmtr_tonelaje")int inCvmtr_tonelaje,
		@WebParam(name="inCvmtr_ingreso")boolean inCvmtr_ingreso,
		@WebParam(name="inCvmtr_fecha_ingreso")java.util.Date inCvmtr_fecha_ingreso,
		@WebParam(name="inCvmtr_salio")boolean inCvmtr_salio,
		@WebParam(name="inCvmtr_fecha_salida")java.util.Date inCvmtr_fecha_salida,
		@WebParam(name="inCvmtr_observacion")String inCvmtr_observacion,
		@WebParam(name="inEstados")String inEstados
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_motor obj = new com.besixplus.sii.objects.Cgg_veh_motor();
		obj.setCVMTR_CODIGO(inCvmtr_codigo);
		obj.setCVCLN_CODIGO(inCvcln_codigo);
		obj.setCVMRC_CODIGO(inCvmrc_codigo);
		obj.setCVCMB_CODIGO(inCvcmb_codigo);
		obj.setCVMTR_SERIE(inCvmtr_serie);
		obj.setCVMTR_ANIO_FABRICACION(inCvmtr_anio_fabricacion);
		obj.setCVMTR_ESTADO_FUNCIONAL(inCvmtr_estado_funcional);
		obj.setCVMTR_TONELAJE(inCvmtr_tonelaje);
		obj.setCVMTR_INGRESO(inCvmtr_ingreso);
		obj.setCVMTR_FECHA_INGRESO(inCvmtr_fecha_ingreso);
		obj.setCVMTR_SALIO(inCvmtr_salio);
		obj.setCVMTR_FECHA_SALIDA(inCvmtr_fecha_salida);
		obj.setCVMTR_OBSERVACION(inCvmtr_observacion);
		obj.setCVMTR_ESTADO(true);
		obj.setCVMTR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			con.setAutoCommit(false);
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_veh_motor(obj).update(con);
			if(res.equals("true")){
				JSONArray tmpEstados = new JSONArray(inEstados);
				for(int i = 0 ; i < tmpEstados.length(); i++){
					JSONObject tmpEstado = (JSONObject) tmpEstados.get(i);
					com.besixplus.sii.objects.Cgg_veh_motor_estado tmpMotorEstado = new com.besixplus.sii.objects.Cgg_veh_motor_estado();
					tmpMotorEstado.setCVSMT_CODIGO("KEYGEN");
					tmpMotorEstado.setCVMTR_CODIGO(inCvmtr_codigo);
					tmpMotorEstado.setCVSMT_FECHA(Timestamp.valueOf(tmpEstado.getString("CVSMT_FECHA")));
					tmpMotorEstado.setCVSVM_CODIGO(tmpEstado.getString("CVSVM_CODIGO"));
					tmpMotorEstado.setCVSMT_OBSERVACION(tmpEstado.getString("CVSMT_OBSERVACION"));
					tmpMotorEstado.setCVSMT_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					tmpMotorEstado.setCVSMT_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					tmpMotorEstado.setCVSMT_ESTADO(true);
					res = new com.besixplus.sii.db.Cgg_veh_motor_estado(tmpMotorEstado).insert(con);
					if(!res.equals("true"))
						break;
				}
			}
			if(res.equals("true")){
				con.commit();
				con.setAutoCommit(true);
			}
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_veh_motor EN UNA ESTRUCTURA JSON o XML.
	* @param inCvmtr_codigo cvmtr_codigo
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCvmtr_codigo")String inCvmtr_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_motor tmpObj = new com.besixplus.sii.objects.Cgg_veh_motor();
		tmpObj.setCVMTR_CODIGO(inCvmtr_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_veh_motor(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_veh_motor> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_veh_motor>();
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
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_veh_motor.
	* @param inCvmtr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE MOTOR
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCvmtr_codigo")String inCvmtr_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_motor tmpObj = new com.besixplus.sii.objects.Cgg_veh_motor();
		tmpObj.setCVMTR_CODIGO(inCvmtr_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_veh_motor(tmpObj).delete(con);
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