package com.besixplus.sii.ws;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;

/**
* CLASE Cgg_veh_vehiculo
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_veh_vehiculo POR MEDIO DE SERVICIOS WEB.
*
* @author BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_veh_vehiculo implements Serializable{

	private static final long serialVersionUID = 636312222;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_veh_vehiculo.
	* @param inCvmrc_codigo IDENTIFICADOR UNICO DE REGISTRO DE MARCA.
	* @param inCvclr_codigo IDENTIFICADOR UNICO DE REGISTRO COLOR 1.
	* @param inCvctg_codigo IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA..
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO.
	* @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR.
	* @param inCgg_cvclr_codigo IDENTIFICADOR UNICO DE REGISTRO COLOR 2.
	* @param inCvveh_nombre NOMBRE DE LA EMBARCACION (APLICA SOLO A VEHICULOS MARITIMOS).
	* @param inCvveh_modelo NOMBRE DEL MODELO DEL VEHICULO.
	* @param inCvveh_tipo TIPO DE VEHICULO
0 - TERRESTRE
1 - MARITIMO
2 - AEREO.
	* @param inCvveh_anio_produccion ANIO DE FABRICACION DEL VEHICULO.
	* @param inCvveh_chasis SERIE DEL CHASIS DEL VEHICULO.
	* @param inCvveh_placa PLACA DEL VEHICULO.
	* @param inCvveh_foto FOTO DEL VEHICULO.
	* @param inCvveh_eslora INFORMACION DE VEHICULOS MARITIMOS (METROS).
	* @param inCvveh_manga INFORMACION DE VEHICULOS MARITIMOS (METROS).
	* @param inCvveh_puntal INFORMACION DE VEHICULOS MARITIMOS (METROS).
	* @param inCvveh_material MATERIAL DE CONSTRUCCION PARA VEHICULOS MARITIMOS.
	* @param inCvveh_ingreso IDENTIFICA SI EL VEHICULO ESTA DENTRO DE LA PROVINCIA.
	* @param inCvveh_fecha_ingreso FECHA CUANDO EL VEHICULO INGRESO A LA PROVINCIA..
	* @param inCvveh_tipo_ingreso MODALIDAD DE INGRESO DE VEHICULO
0 - PERMANENTE
1 - TEMPORAL.
	* @param inCvveh_tiempo_estadia PERIODO DE TIEMPO EN DIAS DE PERMANENCIA DEL VEHICULO DENTRO DE LA PROVINCIA.
	* @param inCvveh_salio SI EL VALIO NO ESTA DENTRO DE LA PROVINCIA.
	* @param inCvveh_fecha_salida FECHA CUANDO EL VEHICULO SALIO.
	* @param inCvveh_observacion INFORMACION ADICIONAL.
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCvmrc_codigo")String inCvmrc_codigo,
		@WebParam(name="inCvclr_codigo")String inCvclr_codigo,
		@WebParam(name="inCvctg_codigo")String inCvctg_codigo,
		@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
		@WebParam(name="inCvsct_codigo")String inCvsct_codigo,
		@WebParam(name="inCgg_cvclr_codigo")String inCgg_cvclr_codigo,
		@WebParam(name="inCvveh_nombre")String inCvveh_nombre,
		@WebParam(name="inCvveh_modelo")String inCvveh_modelo,
		@WebParam(name="inCvveh_tipo")int inCvveh_tipo,
		@WebParam(name="inCvveh_anio_produccion")int inCvveh_anio_produccion,
		@WebParam(name="inCvveh_chasis")String inCvveh_chasis,
		@WebParam(name="inCvveh_placa")String inCvveh_placa,
		@WebParam(name="inCvveh_foto")String inCvveh_foto,
		@WebParam(name="inCvveh_eslora")java.math.BigDecimal inCvveh_eslora,
		@WebParam(name="inCvveh_manga")java.math.BigDecimal inCvveh_manga,
		@WebParam(name="inCvveh_puntal")java.math.BigDecimal inCvveh_puntal,
		@WebParam(name="inCvveh_material")String inCvveh_material,
		@WebParam(name="inCvveh_ingreso")boolean inCvveh_ingreso,
		@WebParam(name="inCvveh_fecha_ingreso")java.util.Date inCvveh_fecha_ingreso,
		@WebParam(name="inCvveh_tipo_ingreso")int inCvveh_tipo_ingreso,
		@WebParam(name="inCvveh_tiempo_estadia")int inCvveh_tiempo_estadia,
		@WebParam(name="inCvveh_salio")boolean inCvveh_salio,
		@WebParam(name="inCvveh_fecha_salida")java.util.Date inCvveh_fecha_salida,
		@WebParam(name="inCvveh_observacion")String inCvveh_observacion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_vehiculo obj = new com.besixplus.sii.objects.Cgg_veh_vehiculo();
		obj.setCVVEH_CODIGO("KEYGEN");
		obj.setCVMRC_CODIGO(inCvmrc_codigo);
		obj.setCVCLR_CODIGO(inCvclr_codigo);
		obj.setCVCTG_CODIGO(inCvctg_codigo);
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCVSCT_CODIGO(inCvsct_codigo);
		obj.setCGG_CVCLR_CODIGO(inCgg_cvclr_codigo);
		obj.setCVVEH_NOMBRE(inCvveh_nombre);
		obj.setCVVEH_MODELO(inCvveh_modelo);
		obj.setCVVEH_TIPO(inCvveh_tipo);
		obj.setCVVEH_ANIO_PRODUCCION(inCvveh_anio_produccion);
		obj.setCVVEH_CHASIS(inCvveh_chasis);
		obj.setCVVEH_PLACA(inCvveh_placa);
		obj.setCVVEH_FOTO(com.besixplus.sii.mail.Base64.decode(inCvveh_foto));
		obj.setCVVEH_ESLORA(inCvveh_eslora);
		obj.setCVVEH_MANGA(inCvveh_manga);
		obj.setCVVEH_PUNTAL(inCvveh_puntal);
		obj.setCVVEH_MATERIAL(inCvveh_material);
		obj.setCVVEH_INGRESO(inCvveh_ingreso);
		obj.setCVVEH_FECHA_INGRESO(inCvveh_fecha_ingreso);
		obj.setCVVEH_TIPO_INGRESO(inCvveh_tipo_ingreso);
		obj.setCVVEH_TIEMPO_ESTADIA(inCvveh_tiempo_estadia);
		obj.setCVVEH_SALIO(inCvveh_salio);
		obj.setCVVEH_FECHA_SALIDA(inCvveh_fecha_salida);
		obj.setCVVEH_OBSERVACION(inCvveh_observacion);
		obj.setCVVEH_ESTADO(true);
		obj.setCVVEH_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCVVEH_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_veh_vehiculo(obj).insert(con);
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
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo EN UNA ESTRUCTRA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	*/
	@WebMethod
	public String selectAll(
		@WebParam(name="format")String format
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_veh_vehiculo.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	* OBTIENE LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo EN UNA ESTRUCTRA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	* @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	* @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	* @param keyword CRITERIO DE BUSQUEDA.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	* @param inSW VALIDAR O NO EL CONJUNTO DE DATOS.
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
			tmpCount = com.besixplus.sii.db.Cgg_veh_vehiculo.selectCount(con, keyword, inSW);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_veh_vehiculo.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inSW);
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
	* ACTUALIZA UN REGISTRO EN LA TABLA Cgg_veh_vehiculo.
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @param inCvmrc_codigo IDENTIFICADOR UNICO DE REGISTRO DE MARCA
	* @param inCvclr_codigo IDENTIFICADOR UNICO DE REGISTRO COLOR 1
	* @param inCvctg_codigo IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	* @param inCsctp_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	* @param inCvsct_codigo IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	* @param inCgg_cvclr_codigo IDENTIFICADOR UNICO DE REGISTRO COLOR 2
	* @param inCvveh_nombre NOMBRE DE LA EMBARCACION (APLICA SOLO A VEHICULOS MARITIMOS)
	* @param inCvveh_modelo NOMBRE DEL MODELO DEL VEHICULO
	* @param inCvveh_tipo TIPO DE VEHICULO
0 - TERRESTRE
1 - MARITIMO
2 - AEREO
	* @param inCvveh_anio_produccion ANIO DE FABRICACION DEL VEHICULO
	* @param inCvveh_chasis SERIE DEL CHASIS DEL VEHICULO
	* @param inCvveh_placa PLACA DEL VEHICULO
	* @param inCvveh_foto FOTO DEL VEHICULO
	* @param inCvveh_eslora INFORMACION DE VEHICULOS MARITIMOS (METROS)
	* @param inCvveh_manga INFORMACION DE VEHICULOS MARITIMOS (METROS)
	* @param inCvveh_puntal INFORMACION DE VEHICULOS MARITIMOS (METROS)
	* @param inCvveh_material MATERIAL DE CONSTRUCCION PARA VEHICULOS MARITIMOS
	* @param inCvveh_ingreso IDENTIFICA SI EL VEHICULO ESTA DENTRO DE LA PROVINCIA
	* @param inCvveh_fecha_ingreso FECHA CUANDO EL VEHICULO INGRESO A LA PROVINCIA.
	* @param inCvveh_tipo_ingreso MODALIDAD DE INGRESO DE VEHICULO
0 - PERMANENTE
1 - TEMPORAL
	* @param inCvveh_tiempo_estadia PERIODO DE TIEMPO EN DIAS DE PERMANENCIA DEL VEHICULO DENTRO DE LA PROVINCIA
	* @param inCvveh_salio SI EL VALIO NO ESTA DENTRO DE LA PROVINCIA
	* @param inCvveh_fecha_salida FECHA CUANDO EL VEHICULO SALIO
	* @param inCvveh_observacion INFORMACION ADICIONAL
	* @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String update(
		@WebParam(name="inCvveh_codigo")String inCvveh_codigo,
		@WebParam(name="inCvmrc_codigo")String inCvmrc_codigo,
		@WebParam(name="inCvclr_codigo")String inCvclr_codigo,
		@WebParam(name="inCvctg_codigo")String inCvctg_codigo,
		@WebParam(name="inCsctp_codigo")String inCsctp_codigo,
		@WebParam(name="inCvsct_codigo")String inCvsct_codigo,
		@WebParam(name="inCgg_cvclr_codigo")String inCgg_cvclr_codigo,
		@WebParam(name="inCvveh_nombre")String inCvveh_nombre,
		@WebParam(name="inCvveh_modelo")String inCvveh_modelo,
		@WebParam(name="inCvveh_tipo")int inCvveh_tipo,
		@WebParam(name="inCvveh_anio_produccion")int inCvveh_anio_produccion,
		@WebParam(name="inCvveh_chasis")String inCvveh_chasis,
		@WebParam(name="inCvveh_placa")String inCvveh_placa,
		@WebParam(name="inCvveh_foto")String inCvveh_foto,
		@WebParam(name="inCvveh_eslora")java.math.BigDecimal inCvveh_eslora,
		@WebParam(name="inCvveh_manga")java.math.BigDecimal inCvveh_manga,
		@WebParam(name="inCvveh_puntal")java.math.BigDecimal inCvveh_puntal,
		@WebParam(name="inCvveh_material")String inCvveh_material,
		@WebParam(name="inCvveh_ingreso")boolean inCvveh_ingreso,
		@WebParam(name="inCvveh_fecha_ingreso")java.util.Date inCvveh_fecha_ingreso,
		@WebParam(name="inCvveh_tipo_ingreso")int inCvveh_tipo_ingreso,
		@WebParam(name="inCvveh_tiempo_estadia")int inCvveh_tiempo_estadia,
		@WebParam(name="inCvveh_salio")boolean inCvveh_salio,
		@WebParam(name="inCvveh_fecha_salida")java.util.Date inCvveh_fecha_salida,
		@WebParam(name="inCvveh_observacion")String inCvveh_observacion
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_vehiculo obj = new com.besixplus.sii.objects.Cgg_veh_vehiculo();
		obj.setCVVEH_CODIGO(inCvveh_codigo);
		obj.setCVMRC_CODIGO(inCvmrc_codigo);
		obj.setCVCLR_CODIGO(inCvclr_codigo);
		obj.setCVCTG_CODIGO(inCvctg_codigo);
		obj.setCSCTP_CODIGO(inCsctp_codigo);
		obj.setCVSCT_CODIGO(inCvsct_codigo);
		obj.setCGG_CVCLR_CODIGO(inCgg_cvclr_codigo);
		obj.setCVVEH_NOMBRE(inCvveh_nombre);
		obj.setCVVEH_MODELO(inCvveh_modelo);
		obj.setCVVEH_TIPO(inCvveh_tipo);
		obj.setCVVEH_ANIO_PRODUCCION(inCvveh_anio_produccion);
		obj.setCVVEH_CHASIS(inCvveh_chasis);
		obj.setCVVEH_PLACA(inCvveh_placa);
		obj.setCVVEH_FOTO(com.besixplus.sii.mail.Base64.decode(inCvveh_foto));
		obj.setCVVEH_ESLORA(inCvveh_eslora);
		obj.setCVVEH_MANGA(inCvveh_manga);
		obj.setCVVEH_PUNTAL(inCvveh_puntal);
		obj.setCVVEH_MATERIAL(inCvveh_material);
		obj.setCVVEH_INGRESO(inCvveh_ingreso);
		obj.setCVVEH_FECHA_INGRESO(inCvveh_fecha_ingreso);
		obj.setCVVEH_TIPO_INGRESO(inCvveh_tipo_ingreso);
		obj.setCVVEH_TIEMPO_ESTADIA(inCvveh_tiempo_estadia);
		obj.setCVVEH_SALIO(inCvveh_salio);
		obj.setCVVEH_FECHA_SALIDA(inCvveh_fecha_salida);
		obj.setCVVEH_OBSERVACION(inCvveh_observacion);
		obj.setCVVEH_ESTADO(true);
		obj.setCVVEH_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_veh_vehiculo(obj).update(con);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_veh_vehiculo EN UNA ESTRUCTURA JSON o XML.
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String select(
		@WebParam(name="inCvveh_codigo")String inCvveh_codigo,
		@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_vehiculo tmpObj = new com.besixplus.sii.objects.Cgg_veh_vehiculo();
		tmpObj.setCVVEH_CODIGO(inCvveh_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			LinkedHashMap<String, Object> tmpVehiculo = new com.besixplus.sii.db.Cgg_veh_vehiculo(tmpObj).select(con);
			ArrayList<LinkedHashMap<String, Object>> tmpArray = new ArrayList<LinkedHashMap<String,Object>>();
			tmpArray.add(tmpVehiculo);
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
	* SELECCIONA UN REGISTRO EN LA TABLA Cgg_veh_vehiculo PARA OBTENER LA FOTO DEL VEHICULO EN FORMATO BASE64.
	* @param inCvveh_codigo cvveh_codigo
	* @return String REGISTRO SELECCIONADO.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectFoto(
		@WebParam(name="inCvveh_codigo")String inCvveh_codigo
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_vehiculo tmpObj = new com.besixplus.sii.objects.Cgg_veh_vehiculo();
		tmpObj.setCVVEH_CODIGO(inCvveh_codigo);
		String outFoto = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			outFoto = new com.besixplus.sii.db.Cgg_veh_vehiculo(tmpObj).selectFoto(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return outFoto;
	}

	/**
	* ELIMINA UN REGISTRO EN LA TABLA Cgg_veh_vehiculo.
	* @param inCvveh_codigo IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	* @throws SOAPException 
	*/
	@WebMethod
	public String delete(
		@WebParam(name="inCvveh_codigo")String inCvveh_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_veh_vehiculo tmpObj = new com.besixplus.sii.objects.Cgg_veh_vehiculo();
		tmpObj.setCVVEH_CODIGO(inCvveh_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_veh_vehiculo(tmpObj).delete(con);
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
	 * Seleccion un vehiculo por su codigo.
	 * @param inCvveh_codigo Codigo de vehiculo.
	 * @param format Formato de salida.
	 * @return Cadena en formato especificado.
	 * @throws SOAPException
	 */
	@WebMethod
	public String select1(
		@WebParam(name="inCvveh_codigo")String inCvveh_codigo,
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
			obj = new com.besixplus.sii.db.Cgg_veh_vehiculo().select1(con, inCvveh_codigo);
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

}