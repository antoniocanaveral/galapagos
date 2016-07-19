package com.besixplus.sii.ws;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.mail.Base64;
import com.besixplus.sii.objects.Cgg_res_adjunto_temporal;
import com.bmlaurus.attachment.CreateCNEAttachment;
import com.bmlaurus.attachment.CreateRCAttachment;
import com.bmlaurus.ws.dinardap.CNE;
import com.bmlaurus.ws.dinardap.RegistroCivil;
import com.bmlaurus.ws.dinardap.Utils;
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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * CLASE Cgg_res_persona
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_persona POR MEDIO DE SERVICIOS WEB.
 *
 * @author BESIXPLUS CIA. LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_res_persona implements Serializable{

	private static final long serialVersionUID = 1603460589;
	private Messages myInfoMessages = new Messages(Messages.Types.Info);
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_persona.
	 * @param inCrecv_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL.
	 * @param inCrdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION.
	 * @param inCrtsg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO.
	 * @param inCgncn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD.
	 * @param inCprr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA.
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON.
	 * @param inCgg_cctn_codigo CIUDAD DE ORIGEN EN EL ECUADOR CONTINENTAL DE UN RESIDENTE.
	 * @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE NACIMIENTO.
	 * @param inCgg_cpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE RESIDENCIA.
	 * @param inCrper_nombres NOMBRES DE LA PERSONA.
	 * @param inCrper_apellido_paterno APELLIDO PATERNO.
	 * @param inCrper_apellido_materno APELLIDO MATERNO.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION.
	 * @param inCrper_fecha_nacimiento FECHA DE NACIMIENTO.
	 * @param inCrper_lugar_nacimiento LUGAR DE NACIMIENTO.
	 * @param inCrper_genero GENERO DE LA PERSONA
0 - MASCULINO
1 - FEMENINO.
	 * @param inCrper_observaciones OBSERVACIONES O COMENTARIOS PARA CON LA PERSONA
.
	 * @param inCrper_numero_residencia NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA.
	 * @param inCrper_foto FOTOGRAFIA DE LA PERSONA.
	 * @param inCrper_foto_curriculum FOTOGRAFIA DE LA PERSONA PARA PUBLICACION EN EL CURRICULUM.
	 * @param inCrper_huella_dactilar INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADAS. ESTA INFORMACION ES PROCESADA POR LA LIBRERIA. ESTA INFORMACION DEBE SER CONSIDERADA PARA VERIFICACIONES..
	 * @param inCrper_huella_imagen IMAGEN EN FORMATO JPG DE LAS HUELLAS DACTILARES DE LA PERSONA. LAS IMAGENES ESTAN ORDENADAS CONFORME A UNA MATRIZ DE 5X2. SUPERIOR: MANO DERECHA, INFERIOR: MANO IZQUIERDA; DE IZQUIERDA A DERECHA DESDE PULGAR A MENIQUE; RESOLUCION: 248x292 PXL CADA IMAGEN..
	 * @param inCrper_huella_cadena INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADA. ESTA INFORMACION NO ES PROCESADA POR LA LIBRERIA, CON LA FINALIDAD DE OBTENER IMAGENES INDIVIDUALES DE LA HUELLAS. ESTA INFORMACION NO PUEDE SER CONSIDERADA PARA VERIFICACIONES..
	 * @param inCrper_firma FIRMA DIGITAL DE LA PERSONA.
	 * @param inCrper_autorizado ESTADO DEL REGISTRO QUE DEFINE SI UNA PERSONA TIENE AUTORIZADO SU INGRESO A LA PROVINCIA.
	 * @param inCrper_numero_expediente NUMERO DE EXPEDIENTE UNICO.
	 * @param inCrper_fecha_archivo FECHA DE ARCHIVO DE LA DOCUMENTACION DE LA PERSONA.
	 * @param inCrper_empleado ESTADO LABORAL DE LA PERSONA.
	 * @param inCrper_fecha_ultimo_empleo FECHA DE INICIO DEL ULTIMO EMPLEO.
	 * @param inCrper_aspiracion_salarial SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO.
	 * @param inCrper_cupo_vehicular SI TIENE DISPONIBLE UN CUPO VEHICULAR.
	 * @param inCrper_tipo_persona CAMPO QUE IDENTIFICA EL TIPO DE PERSONA
0 - CAPACIDADES ESPECIALES
1 - DISCAPACIDAD FISICA
2 - NORMAL.
	 * @param inCrper_estado_interfecto CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA
.
	 * @param inCrper_fecha_defuncion FECHA DE DEFUNCION.
	 * @param inCrper_numero_acta NUMERO DE ACTA DE DEFUNCION.
	 * @param inCrper_adjunto_acta DIGITALIZACION DEL ACTA DE DEFUNCION.
	 * @param inCrper_nombre_adjunto_acta NOMBRE DEL ARCHIVO ADJUNTO DEL ACTA..
	 * @param inCrper_tipo ALMACENA INFORMACION QUE PERMITE DEFINIR EL ESTATUS DE LA PERSONA.
0 - IRREGULAR
1 - REGULAR.
	 * @param inCrper_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE.
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insert(
			@WebParam(name="inCrecv_codigo")String inCrecv_codigo,
			@WebParam(name="inCrdid_codigo")String inCrdid_codigo,
			@WebParam(name="inCrtsg_codigo")String inCrtsg_codigo,
			@WebParam(name="inCgncn_codigo")String inCgncn_codigo,
			@WebParam(name="inCprr_codigo")String inCprr_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCgg_cctn_codigo")String inCgg_cctn_codigo,
			@WebParam(name="inCpais_codigo")String inCpais_codigo,
			@WebParam(name="inCgg_cpais_codigo")String inCgg_cpais_codigo,
			@WebParam(name="inCrper_nombres")String inCrper_nombres,
			@WebParam(name="inCrper_apellido_paterno")String inCrper_apellido_paterno,
			@WebParam(name="inCrper_apellido_materno")String inCrper_apellido_materno,
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
			@WebParam(name="inCrper_fecha_nacimiento")java.util.Date inCrper_fecha_nacimiento,
			@WebParam(name="inCrper_lugar_nacimiento")String inCrper_lugar_nacimiento,
			@WebParam(name="inCrper_genero")int inCrper_genero,
			@WebParam(name="inCrper_observaciones")String inCrper_observaciones,
			@WebParam(name="inCrper_numero_residencia")String inCrper_numero_residencia,
			@WebParam(name="inCrper_foto")String inCrper_foto,
			@WebParam(name="inCrper_foto_curriculum")String inCrper_foto_curriculum,
			@WebParam(name="inCrper_huella_dactilar")String inCrper_huella_dactilar,
			@WebParam(name="inCrper_huella_imagen")String inCrper_huella_imagen,
			@WebParam(name="inCrper_huella_cadena")String inCrper_huella_cadena,
			@WebParam(name="inCrper_firma")String inCrper_firma,
			@WebParam(name="inCrper_autorizado")boolean inCrper_autorizado,
			@WebParam(name="inCrper_numero_expediente")String inCrper_numero_expediente,
			@WebParam(name="inCrper_fecha_archivo")java.util.Date inCrper_fecha_archivo,
			@WebParam(name="inCrper_empleado")boolean inCrper_empleado,
			@WebParam(name="inCrper_fecha_ultimo_empleo")java.util.Date inCrper_fecha_ultimo_empleo,
			@WebParam(name="inCrper_aspiracion_salarial")java.math.BigDecimal inCrper_aspiracion_salarial,
			@WebParam(name="inCrper_cupo_vehicular")boolean inCrper_cupo_vehicular,
			@WebParam(name="inCrper_tipo_persona")int inCrper_tipo_persona,
			@WebParam(name="inCrper_estado_interfecto")boolean inCrper_estado_interfecto,
			@WebParam(name="inCrper_fecha_defuncion")java.util.Date inCrper_fecha_defuncion,
			@WebParam(name="inCrper_numero_acta")String inCrper_numero_acta,
			@WebParam(name="inCrper_adjunto_acta")String inCrper_adjunto_acta,
			@WebParam(name="inCrper_nombre_adjunto_acta")String inCrper_nombre_adjunto_acta,
			@WebParam(name="inCrper_tipo")int inCrper_tipo,
			@WebParam(name="inCrper_atencion_cliente")boolean inCrper_atencion_cliente
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona obj = new com.besixplus.sii.objects.Cgg_res_persona();
		obj.setCRPER_CODIGO("KEYGEN");
		obj.setCRECV_CODIGO(inCrecv_codigo);
		obj.setCRDID_CODIGO(inCrdid_codigo);
		obj.setCRTSG_CODIGO(inCrtsg_codigo);
		obj.setCGNCN_CODIGO(inCgncn_codigo);
		obj.setCPRR_CODIGO(inCprr_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);
		obj.setCGG_CCTN_CODIGO(inCgg_cctn_codigo);
		obj.setCPAIS_CODIGO(inCpais_codigo);
		obj.setCGG_CPAIS_CODIGO(inCgg_cpais_codigo);
		obj.setCRPER_NOMBRES(inCrper_nombres);
		obj.setCRPER_APELLIDO_PATERNO(inCrper_apellido_paterno);
		obj.setCRPER_APELLIDO_MATERNO(inCrper_apellido_materno);
		obj.setCRPER_NUM_DOC_IDENTIFIC(inCrper_num_doc_identific);
		obj.setCRPER_FECHA_NACIMIENTO(inCrper_fecha_nacimiento);
		obj.setCRPER_LUGAR_NACIMIENTO(inCrper_lugar_nacimiento);
		obj.setCRPER_GENERO(inCrper_genero);
		obj.setCRPER_OBSERVACIONES(inCrper_observaciones);
		obj.setCRPER_NUMERO_RESIDENCIA(inCrper_numero_residencia);
		obj.setCRPER_FOTO(com.besixplus.sii.mail.Base64.decode(inCrper_foto));
		obj.setCRPER_FOTO_CURRICULUM(com.besixplus.sii.mail.Base64.decode(inCrper_foto_curriculum));
		obj.setCRPER_HUELLA_DACTILAR(inCrper_huella_dactilar);
		obj.setCRPER_HUELLA_IMAGEN(com.besixplus.sii.mail.Base64.decode(inCrper_huella_imagen));
		obj.setCRPER_HUELLA_CADENA(inCrper_huella_cadena);
		obj.setCRPER_FIRMA(com.besixplus.sii.mail.Base64.decode(inCrper_firma));
		obj.setCRPER_AUTORIZADO(inCrper_autorizado);
		obj.setCRPER_NUMERO_EXPEDIENTE(inCrper_numero_expediente);
		obj.setCRPER_FECHA_ARCHIVO(inCrper_fecha_archivo);
		obj.setCRPER_EMPLEADO(inCrper_empleado);
		obj.setCRPER_FECHA_ULTIMO_EMPLEO(inCrper_fecha_ultimo_empleo);
		obj.setCRPER_ASPIRACION_SALARIAL(inCrper_aspiracion_salarial);
		obj.setCRPER_CUPO_VEHICULAR(inCrper_cupo_vehicular);
		obj.setCRPER_TIPO_PERSONA(inCrper_tipo_persona);
		obj.setCRPER_ESTADO_INTERFECTO(inCrper_estado_interfecto);
		obj.setCRPER_FECHA_DEFUNCION(inCrper_fecha_defuncion);
		obj.setCRPER_NUMERO_ACTA(inCrper_numero_acta);
		obj.setCRPER_ADJUNTO_ACTA(com.besixplus.sii.mail.Base64.decode(inCrper_adjunto_acta));
		obj.setCRPER_NOMBRE_ADJUNTO_ACTA(inCrper_nombre_adjunto_acta);
		obj.setCRPER_TIPO(inCrper_tipo);
		obj.setCRPER_ATENCION_CLIENTE(inCrper_atencion_cliente);
		obj.setCRPER_ESTADO(true);
		obj.setCRPER_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_persona(obj).insert(con);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectAll(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectAll(con, tmpRequest.getUserPrincipal().getName());
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_persona.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectAll(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
			tmpCount = com.besixplus.sii.db.Cgg_res_persona.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectAllDirect(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_codigo crper_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String select(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
		tmpObj.setCRPER_CODIGO(inCrper_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_persona(tmpObj).select(con);
			ArrayList<com.besixplus.sii.objects.Cgg_res_persona> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
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
	 * ELIMINA UN REGISTRO EN LA TABLA Cgg_res_persona.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	 * @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String delete(
			@WebParam(name="inCrper_codigo")String inCrper_codigo
	) throws SOAPException{
		boolean outResult = true;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
		tmpObj.setCRPER_CODIGO(inCrper_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			outResult = new com.besixplus.sii.db.Cgg_res_persona(tmpObj).delete(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return new Boolean(outResult).toString();
	}
	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_res_persona.
	 * @param inCrecv_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL.
	 * @param inCrdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION.
	 * @param inCrtsg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO.
	 * @param inCgncn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD.
	 * @param inCprr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA.
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON.
	 * @param inCgg_cctn_codigo CIUDAD DE ORIGEN EN EL ECUADOR CONTINENTAL DE UN RESIDENTE.
	 * @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	 * @param inCgg_cpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	 * @param inCrper_nombres NOMBRES DE LA PERSONA.
	 * @param inCrper_apellido_paterno APELLIDO PATERNO.
	 * @param inCrper_apellido_materno APELLIDO MATERNO.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUEMNTO DE IDENTIFICACION.
	 * @param inCrper_fecha_nacimiento FECHA DE NACIMIENTO.
	 * @param inCrper_lugar_nacimiento LUGAR DE NACIMIENTO.
	 * @param inCrper_genero GENERO DE LA PERSONA
0 - MASCULINO
1 - FEMENINO.
	 * @param inCrper_observaciones OBSERVACIONES O COMENTARIOS PARA CON LA PERSONA
.
	 * @param inCrper_numero_residencia NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA.
	 * @param inCrper_huella_dactilar HUELLA DACTILAR DE LA PERSONA.
	 * @param inCrper_huella_imagen IMAGEN DE LA HUELLA DE LA PERSONA
	 * @param inCrper_huella_cadena HUELLA DE LA PERSONA
	 * @param inCrper_firma FIRMA DIGITAL DE LA PERSONA.
	 * @param inCrper_autorizado ESTADO DEL REGISTRO QUE DEFINE SI UNA PERSONA TIENE AUTORIZADO SU INGRESO A LA PROVINCIA.
	 * @param inCrper_numero_expediente NUMERO DE EXPEDIENTE UNICO.
	 * @param inCrper_fecha_archivo FECHA DE ARCHIVO DE LA DOCUMENTACION DE LA PERSONA.
	 * @param inCrper_empleado ESTADO LABORAL DE LA PERSONA.
	 * @param inCrper_fecha_ultimo_empleo FECHA DE INICIO DEL ULTIMO EMPLEO.
	 * @param inCrper_aspiracion_salarial SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO.
	 * @param inCrper_cupo_vehicular SI TIENE DISPONIBLE UN CUPO VEHICULAR.
	 * @param inCrper_tipo_persona CAMPO QUE IDENTIPFICA EL TIPO DE PERSONA
0 - CAPACIDADES ESPECIALES
1 - DISCAPACIDAD FISICA
2 - NORMAL.
	 * @param inCrper_estado_interfecto CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA
.
	 * @param inCrper_fecha_defuncion FECHA DE DEFUNCION.
	 * @param inCrper_numero_acta NUMERO DE ACTA DE DEFUNCION.
	 * @param inCrper_adjunto_acta DIGITALIZACION DEL ACTA DE DEFUNCION
	 * @param inCrper_nombre_adjunto_acta NOMBRE DEL ADJUNTO DEL ACTA DE DEFUNCION
	 * @param inCrper_tipo ALMACENA INFORMACION QUE PERMITE DEFINIR SI LA PERSONA ESTA REGISTRADA COMO PARTE DE LA ADMINSITRACION DE RESIDENCIA
0 - REGULAR
1 - IRREGULAR.
	 * @param inCrper_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE.
	 * @param inPersonaContacto_JSON CADENA EN FORMATO JSON QUE CONTIENE LAS FORMAS DE CONTACTO DE UNA PERSONA
	 * @param inPersonaPerfil_JSON CADENA EN FORMATO JSON QUE CONTIENE LOS DATOS DE FORMACION ACADEMICA DE UNA PERSONA
	 * @param inPersonaOcupacion_JSON CADENA EN FORMATO JSON QUE CONTIENE LOS DATOS DE OCUPACION LABORAL DE UNA PERSONA 
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String insertAll(
			@WebParam(name="inCrecv_codigo")String inCrecv_codigo,
			@WebParam(name="inCrdid_codigo")String inCrdid_codigo,
			@WebParam(name="inCrtsg_codigo")String inCrtsg_codigo,
			@WebParam(name="inCgncn_codigo")String inCgncn_codigo,
			@WebParam(name="inCprr_codigo")String inCprr_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCgg_cctn_codigo")String inCgg_cctn_codigo,
			@WebParam(name="inCpais_codigo")String inCpais_codigo,
			@WebParam(name="inCgg_cpais_codigo")String inCgg_cpais_codigo,
			@WebParam(name="inCrper_nombres")String inCrper_nombres,
			@WebParam(name="inCrper_apellido_paterno")String inCrper_apellido_paterno,
			@WebParam(name="inCrper_apellido_materno")String inCrper_apellido_materno,
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
			@WebParam(name="inCrper_fecha_nacimiento")java.util.Date inCrper_fecha_nacimiento,
			@WebParam(name="inCrper_lugar_nacimiento")String inCrper_lugar_nacimiento,
			@WebParam(name="inCrper_genero")int inCrper_genero,
			@WebParam(name="inCrper_observaciones")String inCrper_observaciones,
			@WebParam(name="inCrper_numero_residencia")String inCrper_numero_residencia,
			/*@WebParam(name="inCrper_foto")String inCrper_foto,
		@WebParam(name="inCrper_foto_curriculum")String inCrper_foto_curriculum,*/
			@WebParam(name="inCrper_huella_dactilar")String inCrper_huella_dactilar,
			@WebParam(name="inCrper_huella_imagen")String inCrper_huella_imagen,
			@WebParam(name="inCrper_huella_cadena")String inCrper_huella_cadena,
			@WebParam(name="inCrper_firma")String inCrper_firma,
			@WebParam(name="inCrper_autorizado")boolean inCrper_autorizado,
			@WebParam(name="inCrper_numero_expediente")String inCrper_numero_expediente,
			@WebParam(name="inCrper_fecha_archivo")java.util.Date inCrper_fecha_archivo,
			@WebParam(name="inCrper_empleado")boolean inCrper_empleado,
			@WebParam(name="inCrper_fecha_ultimo_empleo")java.util.Date inCrper_fecha_ultimo_empleo,
			@WebParam(name="inCrper_aspiracion_salarial")java.math.BigDecimal inCrper_aspiracion_salarial,
			@WebParam(name="inCrper_cupo_vehicular")boolean inCrper_cupo_vehicular,
			@WebParam(name="inCrper_tipo_persona")int inCrper_tipo_persona,
			@WebParam(name="inCrper_estado_interfecto")boolean inCrper_estado_interfecto,
			@WebParam(name="inCrper_fecha_defuncion")java.util.Date inCrper_fecha_defuncion,
			@WebParam(name="inCrper_numero_acta")String inCrper_numero_acta,
			@WebParam(name="inCrper_adjunto_acta")String inCrper_adjunto_acta,
			@WebParam(name="inCrper_nombre_adjunto_acta")String inCrper_nombre_adjunto_acta,
			@WebParam(name="inCrper_tipo")int inCrper_tipo,
			@WebParam(name="inCrper_atencion_cliente")boolean inCrper_atencion_cliente,
			@WebParam(name="inPersonaContacto_JSON")String inPersonaContacto_JSON,
			@WebParam(name="inPersonaPerfil_JSON")String inPersonaPerfil_JSON,
			@WebParam(name="inPersonaOcupacion_JSON")String inPersonaOcupacion_JSON
	) throws SOAPException{
		//System.out.println("Llamada a WS");
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);

		com.besixplus.sii.objects.Cgg_res_persona obj = new com.besixplus.sii.objects.Cgg_res_persona();
		obj.setCRPER_CODIGO("KEYGEN");
		obj.setCRECV_CODIGO(inCrecv_codigo);
		obj.setCRDID_CODIGO(inCrdid_codigo);
		obj.setCRTSG_CODIGO(inCrtsg_codigo);
		obj.setCGNCN_CODIGO(inCgncn_codigo);
		obj.setCPRR_CODIGO(inCprr_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);
		obj.setCGG_CCTN_CODIGO(inCgg_cctn_codigo);
		obj.setCPAIS_CODIGO(inCpais_codigo);
		obj.setCGG_CPAIS_CODIGO(inCgg_cpais_codigo);
		obj.setCRPER_NOMBRES(inCrper_nombres);
		obj.setCRPER_APELLIDO_PATERNO(inCrper_apellido_paterno);
		obj.setCRPER_APELLIDO_MATERNO(inCrper_apellido_materno);
		obj.setCRPER_NUM_DOC_IDENTIFIC(inCrper_num_doc_identific.toUpperCase());
		obj.setCRPER_FECHA_NACIMIENTO(inCrper_fecha_nacimiento);
		obj.setCRPER_LUGAR_NACIMIENTO(inCrper_lugar_nacimiento);
		obj.setCRPER_GENERO(inCrper_genero);
		obj.setCRPER_OBSERVACIONES(inCrper_observaciones);
		obj.setCRPER_NUMERO_RESIDENCIA(inCrper_numero_residencia);
		//obj.setCRPER_FOTO(com.besixplus.sii.mail.Base64.decode(inCrper_foto));
		//obj.setCRPER_FOTO_CURRICULUM(com.besixplus.sii.mail.Base64.decode(inCrper_foto_curriculum));
		obj.setCRPER_HUELLA_DACTILAR(inCrper_huella_dactilar);//procesada fireText 
		if (inCrper_huella_imagen!= null && !inCrper_huella_imagen.trim().isEmpty())
			obj.setCRPER_HUELLA_IMAGEN(Base64.decode(inCrper_huella_imagen));
		obj.setCRPER_HUELLA_CADENA(inCrper_huella_cadena); //sin procesar fireAuditText
		if (inCrper_firma != null && !inCrper_firma.trim().isEmpty())
			obj.setCRPER_FIRMA(Base64.decode(inCrper_firma));//Firma
		obj.setCRPER_AUTORIZADO(inCrper_autorizado);
		obj.setCRPER_NUMERO_EXPEDIENTE(inCrper_numero_expediente);
		obj.setCRPER_FECHA_ARCHIVO(inCrper_fecha_archivo);
		obj.setCRPER_EMPLEADO(inCrper_empleado);
		obj.setCRPER_FECHA_ULTIMO_EMPLEO(inCrper_fecha_ultimo_empleo);
		obj.setCRPER_ASPIRACION_SALARIAL(inCrper_aspiracion_salarial);
		obj.setCRPER_CUPO_VEHICULAR(inCrper_cupo_vehicular);
		obj.setCRPER_TIPO_PERSONA(inCrper_tipo_persona);
		obj.setCRPER_ESTADO_INTERFECTO(inCrper_estado_interfecto);
		obj.setCRPER_FECHA_DEFUNCION(inCrper_fecha_defuncion);
		obj.setCRPER_NUMERO_ACTA(inCrper_numero_acta);
		//obj.setCRPER_ADJUNTO_ACTA(com.besixplus.sii.mail.Base64.decode(inCrper_adjunto_acta));
		obj.setCRPER_NOMBRE_ADJUNTO_ACTA(inCrper_nombre_adjunto_acta);
		obj.setCRPER_TIPO(inCrper_tipo);
		obj.setCRPER_ATENCION_CLIENTE(inCrper_atencion_cliente);
		obj.setCRPER_ESTADO(true);
		obj.setCRPER_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
		obj.setCRPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}

			con.setAutoCommit(false);
			//Seleccion del archivo adjunto
			Cgg_res_adjunto_temporal adjuntoTemporal = new Cgg_res_adjunto_temporal();
			adjuntoTemporal.setCRATE_CODIGO(inCrper_adjunto_acta);
			adjuntoTemporal = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(adjuntoTemporal).select(con);
			obj.setCRPER_ADJUNTO_ACTA(adjuntoTemporal.getCRATE_ARCHIVO());
			res = new com.besixplus.sii.db.Cgg_res_persona(obj).insert(con);
			if(obj.getCRPER_CODIGO() != "KEYGEN" && res.equals("true"))
			{
				//Insert Persona Contacto
				org.json.JSONArray objContactoJSON = new org.json.JSONArray(inPersonaContacto_JSON);
				for (int i = 0 ; i < objContactoJSON.length(); i++){			
					com.besixplus.sii.objects.Cgg_res_persona_contacto objPersonaContacto = new com.besixplus.sii.objects.Cgg_res_persona_contacto();
					objPersonaContacto.setCRPRC_CODIGO("KEYGEN");
					objPersonaContacto.setCRPER_CODIGO(obj.getCRPER_CODIGO());
					objPersonaContacto.setCRTCO_CODIGO(((org.json.JSONObject)objContactoJSON.get(i)).get("CRTCO_CODIGO").toString());
					objPersonaContacto.setCRPRC_DESCRIPCION(((org.json.JSONObject)objContactoJSON.get(i)).get("CRPRC_DESCRIPCION").toString());
					objPersonaContacto.setCRPRC_CONTACTO(((org.json.JSONObject)objContactoJSON.get(i)).get("CRPRC_CONTACTO").toString());
					objPersonaContacto.setCRPRC_ESTADO(true);
					objPersonaContacto.setCRPRC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
					objPersonaContacto.setCRPRC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
					res = new com.besixplus.sii.db.Cgg_res_persona_contacto(objPersonaContacto).insert(con);
				}
				//Insert Persona Perfil
				if (res.equals("true"))
				{
					org.json.JSONArray objPerfilJSON = new org.json.JSONArray(inPersonaPerfil_JSON);
					for (int i = 0 ; i < objPerfilJSON.length(); i++){						
						com.besixplus.sii.objects.Cgg_gem_perfil_prof objPersonaPerfil = new com.besixplus.sii.objects.Cgg_gem_perfil_prof();
						objPersonaPerfil.setCGPPR_CODIGO("KEYGEN");
						if(!((org.json.JSONObject)objPerfilJSON.get(i)).get("CGESP_CODIGO").toString().trim().isEmpty())
							objPersonaPerfil.setCGESP_CODIGO(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGESP_CODIGO").toString());
						if(!((org.json.JSONObject)objPerfilJSON.get(i)).get("CGTPR_CODIGO").toString().trim().isEmpty())
							objPersonaPerfil.setCGTPR_CODIGO(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGTPR_CODIGO").toString());
						if(!((org.json.JSONObject)objPerfilJSON.get(i)).get("CGIEN_CODIGO").toString().trim().isEmpty())
							//objPersonaPerfil.setCGIED_CODIGO(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGIED_CODIGO").toString());
							objPersonaPerfil.setCGIEN_CODIGO(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGIEN_CODIGO").toString());
						objPersonaPerfil.setCGMDC_CODIGO(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGMDC_CODIGO").toString());
						//objPersonaPerfil.setCGNES_CODIGO(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGNES_CODIGO").toString());
						objPersonaPerfil.setCRPER_CODIGO(obj.getCRPER_CODIGO());
						objPersonaPerfil.setCGPPR_NIVEL_APROBADO(Integer.parseInt(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_NIVEL_APROBADO").toString()));
						objPersonaPerfil.setCGPPR_CONFIRMADO(Boolean.parseBoolean(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_CONFIRMADO").toString()));
						objPersonaPerfil.setCGPPR_FECHA_INICIO(new SimpleDateFormat("yyyy-MM-dd").parse(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_FECHA_INICIO").toString()));
						objPersonaPerfil.setCGPPR_FECHA_FIN(new SimpleDateFormat("yyyy-MM-dd").parse(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_FECHA_FIN").toString()));
						objPersonaPerfil.setCGPPR_FECHA_CONFIRMACION(new Timestamp(new Date().getTime()));
						//objPersonaPerfil.setCGPPR_FECHA_CONFIRMACION(Date.valueOf(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_FECHA_CONFIRMACION").toString()));				
						objPersonaPerfil.setCGPPR_PREDETERMINADO(Boolean.parseBoolean(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_PREDETERMINADO").toString()));
						objPersonaPerfil.setCGPPR_ESTADO(true);
						objPersonaPerfil.setCGPPR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						objPersonaPerfil.setCGPPR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_gem_perfil_prof(objPersonaPerfil).insert(con);
					}
					
					if (res.equals("true"))
					{
						
						org.json.JSONArray arrayOcupacionJSON = new org.json.JSONArray(inPersonaOcupacion_JSON);
						JSONObject objOcupacionJSON = null;
						for (int i = 0 ; i < arrayOcupacionJSON.length(); i++){
							objOcupacionJSON = arrayOcupacionJSON.getJSONObject(i);
							com.besixplus.sii.objects.Cgg_res_ocupacion_laboral objOcupacion = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
							objOcupacion.setCROCL_CODIGO("KEYGEN");
							objOcupacion.setCRPER_CODIGO(obj.getCRPER_CODIGO());
							if(!objOcupacionJSON.getString("CGG_CRPER_CODIGO").trim().isEmpty())
								objOcupacion.setCGG_CRPER_CODIGO(objOcupacionJSON.getString("CGG_CRPER_CODIGO"));
							objOcupacion.setCGCRG_CODIGO(objOcupacionJSON.getString("CGCRG_CODIGO"));
							objOcupacion.setCSCTP_CODIGO(objOcupacionJSON.getString("CSCTP_CODIGO"));
							if(!objOcupacionJSON.getString("CRPJR_CODIGO").trim().isEmpty())
								objOcupacion.setCRPJR_CODIGO(objOcupacionJSON.getString("CRPJR_CODIGO"));
							objOcupacion.setCROCL_TIPO(objOcupacionJSON.getInt("CROCL_TIPO"));
							objOcupacion.setCROCL_ESTADO(true);
							objOcupacion.setCROCL_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							objOcupacion.setCROCL_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_res_ocupacion_laboral(objOcupacion).insert(con);
						}
						if (res.equals("true"))
						{
							
							con.commit();
							con.setAutoCommit(true);
							con.close();
						}
					}
				}

			}
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS JSON O XML.
	 * @param inCrtst_codigo CODIGO DE TIPO DE SOLICITUD DE TRAMITE.
	 * @param inCarnet OBTENER SOLO LAS PERSONAS QUE TIENE UN TRAMITE PARA CARNETIZACION.
	 * @param inIdentificacion IDENTIFICACION
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectPageLite(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCrtst_codigo")String inCrtst_codigo,
			@WebParam(name="inCarnet")boolean inCarnet,
			@WebParam(name="inIdentificacion")String inIdentificacion
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<LinkedHashMap<String,Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		BigDecimal tmpCount = new BigDecimal(0);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_persona.selectCountLite(con, keyword, inCrtst_codigo, inCarnet, inIdentificacion);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectAllLite(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inCrtst_codigo, inCarnet, inIdentificacion);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_persona.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	 * @param inCrecv_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	 * @param inCrdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	 * @param inCrtsg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	 * @param inCgncn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	 * @param inCprr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	 * @param inCgg_cctn_codigo CIUDAD DE ORIGEN EN EL ECUADOR CONTINENTAL DE UN RESIDENTE
	 * @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE NACIMIENTO
	 * @param inCgg_cpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE RESIDENCIA
	 * @param inCrper_nombres NOMBRES DE LA PERSONA
	 * @param inCrper_apellido_paterno APELLIDO PATERNO
	 * @param inCrper_apellido_materno APELLIDO MATERNO
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO DE IDENTIFICACION
	 * @param inCrper_fecha_nacimiento FECHA DE NACIMIENTO
	 * @param inCrper_lugar_nacimiento LUGAR DE NACIMIENTO
	 * @param inCrper_genero GENERO DE LA PERSONA
0 - MASCULINO
1 - FEMENINO
	 * @param inCrper_observaciones OBSERVACIONES O COMENTARIOS PARA CON LA PERSONA

	 * @param inCrper_numero_residencia NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA
	 * @param inCrper_foto FOTOGRAFIA DE LA PERSONA
	 * @param inCrper_foto_curriculum FOTOGRAFIA DE LA PERSONA PARA PUBLICACION EN EL CURRICULUM
	 * @param inCrper_huella_dactilar INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADAS. ESTA INFORMACION ES PROCESADA POR LA LIBRERIA. ESTA INFORMACION DEBE SER CONSIDERADA PARA VERIFICACIONES.
	 * @param inCrper_huella_imagen IMAGEN EN FORMATO JPG DE LAS HUELLAS DACTILARES DE LA PERSONA. LAS IMAGENES ESTAN ORDENADAS CONFORME A UNA MATRIZ DE 5X2. SUPERIOR: MANO DERECHA, INFERIOR: MANO IZQUIERDA; DE IZQUIERDA A DERECHA DESDE PULGAR A MENIQUE; RESOLUCION: 248x292 PXL CADA IMAGEN.
	 * @param inCrper_huella_cadena INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADA. ESTA INFORMACION NO ES PROCESADA POR LA LIBRERIA, CON LA FINALIDAD DE OBTENER IMAGENES INDIVIDUALES DE LA HUELLAS. ESTA INFORMACION NO PUEDE SER CONSIDERADA PARA VERIFICACIONES.
	 * @param inCrper_firma FIRMA DIGITAL DE LA PERSONA
	 * @param inCrper_autorizado ESTADO DEL REGISTRO QUE DEFINE SI UNA PERSONA TIENE AUTORIZADO SU INGRESO A LA PROVINCIA
	 * @param inCrper_numero_expediente NUMERO DE EXPEDIENTE UNICO
	 * @param inCrper_fecha_archivo FECHA DE ARCHIVO DE LA DOCUMENTACION DE LA PERSONA
	 * @param inCrper_empleado ESTADO LABORAL DE LA PERSONA
	 * @param inCrper_fecha_ultimo_empleo FECHA DE INICIO DEL ULTIMO EMPLEO
	 * @param inCrper_aspiracion_salarial SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
	 * @param inCrper_cupo_vehicular SI TIENE DISPONIBLE UN CUPO VEHICULAR
	 * @param inCrper_tipo_persona CAMPO QUE IDENTIFICA EL TIPO DE PERSONA
0 - CAPACIDADES ESPECIALES
1 - DISCAPACIDAD FISICA
2 - NORMAL
	 * @param inCrper_estado_interfecto CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA

	 * @param inCrper_fecha_defuncion FECHA DE DEFUNCION
	 * @param inCrper_numero_acta NUMERO DE ACTA DE DEFUNCION
	 * @param inCrper_adjunto_acta DIGITALIZACION DEL ACTA DE DEFUNCION
	 * @param inCrper_nombre_adjunto_acta NOMBRE DEL ARCHIVO ADJUNTO DEL ACTA.
	 * @param inCrper_tipo ALMACENA INFORMACION QUE PERMITE DEFINIR EL ESTATUS DE LA PERSONA.
0 - IRREGULAR
1 - REGULAR
	 * @param inCrper_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String update(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCrecv_codigo")String inCrecv_codigo,
			@WebParam(name="inCrdid_codigo")String inCrdid_codigo,
			@WebParam(name="inCrtsg_codigo")String inCrtsg_codigo,
			@WebParam(name="inCgncn_codigo")String inCgncn_codigo,
			@WebParam(name="inCprr_codigo")String inCprr_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCgg_cctn_codigo")String inCgg_cctn_codigo,
			@WebParam(name="inCpais_codigo")String inCpais_codigo,
			@WebParam(name="inCgg_cpais_codigo")String inCgg_cpais_codigo,
			@WebParam(name="inCrper_nombres")String inCrper_nombres,
			@WebParam(name="inCrper_apellido_paterno")String inCrper_apellido_paterno,
			@WebParam(name="inCrper_apellido_materno")String inCrper_apellido_materno,
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
			@WebParam(name="inCrper_fecha_nacimiento")java.util.Date inCrper_fecha_nacimiento,
			@WebParam(name="inCrper_lugar_nacimiento")String inCrper_lugar_nacimiento,
			@WebParam(name="inCrper_genero")int inCrper_genero,
			@WebParam(name="inCrper_observaciones")String inCrper_observaciones,
			@WebParam(name="inCrper_numero_residencia")String inCrper_numero_residencia,
			@WebParam(name="inCrper_foto")String inCrper_foto,
			@WebParam(name="inCrper_foto_curriculum")String inCrper_foto_curriculum,
			@WebParam(name="inCrper_huella_dactilar")String inCrper_huella_dactilar,
			@WebParam(name="inCrper_huella_imagen")String inCrper_huella_imagen,
			@WebParam(name="inCrper_huella_cadena")String inCrper_huella_cadena,
			@WebParam(name="inCrper_firma")String inCrper_firma,
			@WebParam(name="inCrper_autorizado")boolean inCrper_autorizado,
			@WebParam(name="inCrper_numero_expediente")String inCrper_numero_expediente,
			@WebParam(name="inCrper_fecha_archivo")java.util.Date inCrper_fecha_archivo,
			@WebParam(name="inCrper_empleado")boolean inCrper_empleado,
			@WebParam(name="inCrper_fecha_ultimo_empleo")java.util.Date inCrper_fecha_ultimo_empleo,
			@WebParam(name="inCrper_aspiracion_salarial")java.math.BigDecimal inCrper_aspiracion_salarial,
			@WebParam(name="inCrper_cupo_vehicular")boolean inCrper_cupo_vehicular,
			@WebParam(name="inCrper_tipo_persona")int inCrper_tipo_persona,
			@WebParam(name="inCrper_estado_interfecto")boolean inCrper_estado_interfecto,
			@WebParam(name="inCrper_fecha_defuncion")java.util.Date inCrper_fecha_defuncion,
			@WebParam(name="inCrper_numero_acta")String inCrper_numero_acta,
			@WebParam(name="inCrper_adjunto_acta")String inCrper_adjunto_acta,
			@WebParam(name="inCrper_nombre_adjunto_acta")String inCrper_nombre_adjunto_acta,
			@WebParam(name="inCrper_tipo")int inCrper_tipo,
			@WebParam(name="inCrper_atencion_cliente")boolean inCrper_atencion_cliente
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona obj = new com.besixplus.sii.objects.Cgg_res_persona();
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRECV_CODIGO(inCrecv_codigo);
		obj.setCRDID_CODIGO(inCrdid_codigo);
		obj.setCRTSG_CODIGO(inCrtsg_codigo);
		obj.setCGNCN_CODIGO(inCgncn_codigo);
		obj.setCPRR_CODIGO(inCprr_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);
		obj.setCGG_CCTN_CODIGO(inCgg_cctn_codigo);
		obj.setCPAIS_CODIGO(inCpais_codigo);
		obj.setCGG_CPAIS_CODIGO(inCgg_cpais_codigo);
		obj.setCRPER_NOMBRES(inCrper_nombres);
		obj.setCRPER_APELLIDO_PATERNO(inCrper_apellido_paterno);
		obj.setCRPER_APELLIDO_MATERNO(inCrper_apellido_materno);
		obj.setCRPER_NUM_DOC_IDENTIFIC(inCrper_num_doc_identific);
		obj.setCRPER_FECHA_NACIMIENTO(inCrper_fecha_nacimiento);
		obj.setCRPER_LUGAR_NACIMIENTO(inCrper_lugar_nacimiento);
		obj.setCRPER_GENERO(inCrper_genero);
		obj.setCRPER_OBSERVACIONES(inCrper_observaciones);
		obj.setCRPER_NUMERO_RESIDENCIA(inCrper_numero_residencia);
		obj.setCRPER_FOTO(com.besixplus.sii.mail.Base64.decode(inCrper_foto));
		obj.setCRPER_FOTO_CURRICULUM(com.besixplus.sii.mail.Base64.decode(inCrper_foto_curriculum));
		obj.setCRPER_HUELLA_DACTILAR(inCrper_huella_dactilar);
		obj.setCRPER_HUELLA_IMAGEN(com.besixplus.sii.mail.Base64.decode(inCrper_huella_imagen));
		obj.setCRPER_HUELLA_CADENA(inCrper_huella_cadena);
		obj.setCRPER_FIRMA(com.besixplus.sii.mail.Base64.decode(inCrper_firma));
		obj.setCRPER_AUTORIZADO(inCrper_autorizado);
		obj.setCRPER_NUMERO_EXPEDIENTE(inCrper_numero_expediente);
		obj.setCRPER_FECHA_ARCHIVO(inCrper_fecha_archivo);
		obj.setCRPER_EMPLEADO(inCrper_empleado);
		obj.setCRPER_FECHA_ULTIMO_EMPLEO(inCrper_fecha_ultimo_empleo);
		obj.setCRPER_ASPIRACION_SALARIAL(inCrper_aspiracion_salarial);
		obj.setCRPER_CUPO_VEHICULAR(inCrper_cupo_vehicular);
		obj.setCRPER_TIPO_PERSONA(inCrper_tipo_persona);
		obj.setCRPER_ESTADO_INTERFECTO(inCrper_estado_interfecto);
		obj.setCRPER_FECHA_DEFUNCION(inCrper_fecha_defuncion);
		obj.setCRPER_NUMERO_ACTA(inCrper_numero_acta);
		obj.setCRPER_ADJUNTO_ACTA(com.besixplus.sii.mail.Base64.decode(inCrper_adjunto_acta));
		obj.setCRPER_NOMBRE_ADJUNTO_ACTA(inCrper_nombre_adjunto_acta);
		obj.setCRPER_TIPO(inCrper_tipo);
		obj.setCRPER_ATENCION_CLIENTE(inCrper_atencion_cliente);
		obj.setCRPER_ESTADO(true);
		obj.setCRPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			res = new com.besixplus.sii.db.Cgg_res_persona(obj).update(con);
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
	 * ACTUALIZA UN REGISTRO EN LA TABLA Cgg_res_persona.
	 * @param inCrper_codigo CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
	 * @param inCrecv_codigo IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
	 * @param inCrdid_codigo IDENTIFICATIVO UNICO DE REGISTRO DE DOCUMENTO DE IDENTIFICACION
	 * @param inCrtsg_codigo IDENTIFICATIVO UNICO DE REGISTRO DE TIPO SANQUINEO
	 * @param inCgncn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
	 * @param inCprr_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
	 * @param inCctn_codigo IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	 * @param inCgg_cctn_codigo CIUDAD DE ORIGEN EN EL ECUADOR CONTINENTAL DE UN RESIDENTE
	 * @param inCpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	 * @param inCgg_cpais_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	 * @param inCrper_nombres NOMBRES DE LA PERSONA
	 * @param inCrper_apellido_paterno APELLIDO PATERNO
	 * @param inCrper_apellido_materno APELLIDO MATERNO
	 * @param inCrper_num_doc_identific NUMERO DE DOCUEMNTO DE IDENTIFICACION
	 * @param inCrper_fecha_nacimiento FECHA DE NACIMIENTO
	 * @param inCrper_lugar_nacimiento LUGAR DE NACIMIENTO
	 * @param inCrper_genero GENERO DE LA PERSONA
0 - MASCULINO
1 - FEMENINO
	 * @param inCrper_observaciones OBSERVACIONES O COMENTARIOS PARA CON LA PERSONA

	 * @param inCrper_numero_residencia NUMERO UNICO DE IDENTIFICACION DE RESIDENCIA
	 * @param inCrper_autorizado ESTADO DEL REGISTRO QUE DEFINE SI UNA PERSONA TIENE AUTORIZADO SU INGRESO A LA PROVINCIA
	 * @param inCrper_numero_expediente NUMERO DE EXPEDIENTE UNICO
	 * @param inCrper_fecha_archivo FECHA DE ARCHIVO DE LA DOCUMENTACION DE LA PERSONA
	 * @param inCrper_empleado ESTADO LABORAL DE LA PERSONA
	 * @param inCrper_fecha_ultimo_empleo FECHA DE INICIO DEL ULTIMO EMPLEO
	 * @param inCrper_aspiracion_salarial SALARIO ESPERADO POR CUMPLIR CON UN DETERMINADO TRABAJO
	 * @param inCrper_cupo_vehicular SI TIENE DISPONIBLE UN CUPO VEHICULAR
	 * @param inCrper_tipo_persona CAMPO QUE IDENTIPFICA EL TIPO DE PERSONA
0 - CAPACIDADES ESPECIALES
1 - DISCAPACIDAD FISICA
2 - NORMAL
	 * @param inCrper_estado_interfecto CAMPO QUE VERIFICA EL ESTADO INTERFECTO DE LA PERSONA

	 * @param inCrper_fecha_defuncion FECHA DE DEFUNCION
	 * @param inCrper_numero_acta NUMERO DE ACTA DE DEFUNCION
	 * @param inCrper_tipo ALMACENA INFORMACION QUE PERMITE DEFINIR SI LA PERSONA ESTA REGISTRADA COMO PARTE DE LA ADMINSITRACION DE RESIDENCIA
0 - REGULAR
1 - IRREGULAR
	 * @param inCrper_atencion_cliente SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
	 * @param inPersonaContacto_JSON  PERSONA CONTACTO
	 * @param inPersonaPerfil_JSON PERFIL DE LA PERSONA
	 * @param inPersonaOcupacion_JSON OCUPACION DE LA PERSONA
	 * @return String <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String updateAll(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCrecv_codigo")String inCrecv_codigo,
			@WebParam(name="inCrdid_codigo")String inCrdid_codigo,
			@WebParam(name="inCrtsg_codigo")String inCrtsg_codigo,
			@WebParam(name="inCgncn_codigo")String inCgncn_codigo,
			@WebParam(name="inCprr_codigo")String inCprr_codigo,
			@WebParam(name="inCctn_codigo")String inCctn_codigo,
			@WebParam(name="inCgg_cctn_codigo")String inCgg_cctn_codigo,
			@WebParam(name="inCpais_codigo")String inCpais_codigo,
			@WebParam(name="inCgg_cpais_codigo")String inCgg_cpais_codigo,
			@WebParam(name="inCrper_nombres")String inCrper_nombres,
			@WebParam(name="inCrper_apellido_paterno")String inCrper_apellido_paterno,
			@WebParam(name="inCrper_apellido_materno")String inCrper_apellido_materno,
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
			@WebParam(name="inCrper_fecha_nacimiento")java.util.Date inCrper_fecha_nacimiento,
			@WebParam(name="inCrper_lugar_nacimiento")String inCrper_lugar_nacimiento,
			@WebParam(name="inCrper_genero")int inCrper_genero,
			@WebParam(name="inCrper_observaciones")String inCrper_observaciones,
			@WebParam(name="inCrper_numero_residencia")String inCrper_numero_residencia,			
			@WebParam(name="inCrper_autorizado")boolean inCrper_autorizado,
			@WebParam(name="inCrper_numero_expediente")String inCrper_numero_expediente,
			@WebParam(name="inCrper_fecha_archivo")java.util.Date inCrper_fecha_archivo,
			@WebParam(name="inCrper_empleado")boolean inCrper_empleado,
			@WebParam(name="inCrper_fecha_ultimo_empleo")java.util.Date inCrper_fecha_ultimo_empleo,
			@WebParam(name="inCrper_aspiracion_salarial")java.math.BigDecimal inCrper_aspiracion_salarial,
			@WebParam(name="inCrper_cupo_vehicular")boolean inCrper_cupo_vehicular,
			@WebParam(name="inCrper_tipo_persona")int inCrper_tipo_persona,
			@WebParam(name="inCrper_estado_interfecto")boolean inCrper_estado_interfecto,
			@WebParam(name="inCrper_fecha_defuncion")java.util.Date inCrper_fecha_defuncion,
			@WebParam(name="inCrper_numero_acta")String inCrper_numero_acta,		
			@WebParam(name="inCrper_tipo")int inCrper_tipo,
			@WebParam(name="inCrper_atencion_cliente")boolean inCrper_atencion_cliente,
			@WebParam(name="inPersonaContacto_JSON")String inPersonaContacto_JSON,
			@WebParam(name="inPersonaPerfil_JSON")String inPersonaPerfil_JSON,
			@WebParam(name="inPersonaOcupacion_JSON")String inPersonaOcupacion_JSON
	) throws SOAPException{
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona obj = new com.besixplus.sii.objects.Cgg_res_persona();
		obj.setCRPER_CODIGO(inCrper_codigo);
		obj.setCRECV_CODIGO(inCrecv_codigo);
		obj.setCRDID_CODIGO(inCrdid_codigo);
		obj.setCRTSG_CODIGO(inCrtsg_codigo);
		obj.setCGNCN_CODIGO(inCgncn_codigo);
		obj.setCPRR_CODIGO(inCprr_codigo);
		obj.setCCTN_CODIGO(inCctn_codigo);
		obj.setCGG_CCTN_CODIGO(inCgg_cctn_codigo);
		obj.setCPAIS_CODIGO(inCpais_codigo);
		obj.setCGG_CPAIS_CODIGO(inCgg_cpais_codigo);
		obj.setCRPER_NOMBRES(inCrper_nombres);
		obj.setCRPER_APELLIDO_PATERNO(inCrper_apellido_paterno);
		obj.setCRPER_APELLIDO_MATERNO(inCrper_apellido_materno);
		obj.setCRPER_NUM_DOC_IDENTIFIC(inCrper_num_doc_identific);
		obj.setCRPER_FECHA_NACIMIENTO(inCrper_fecha_nacimiento);
		obj.setCRPER_LUGAR_NACIMIENTO(inCrper_lugar_nacimiento);
		obj.setCRPER_GENERO(inCrper_genero);
		obj.setCRPER_OBSERVACIONES(inCrper_observaciones);
		obj.setCRPER_NUMERO_RESIDENCIA(inCrper_numero_residencia);
	
		obj.setCRPER_AUTORIZADO(inCrper_autorizado);
		obj.setCRPER_NUMERO_EXPEDIENTE(inCrper_numero_expediente);
		obj.setCRPER_FECHA_ARCHIVO(inCrper_fecha_archivo);
		obj.setCRPER_EMPLEADO(inCrper_empleado);
		obj.setCRPER_FECHA_ULTIMO_EMPLEO(inCrper_fecha_ultimo_empleo);
		obj.setCRPER_ASPIRACION_SALARIAL(inCrper_aspiracion_salarial);
		obj.setCRPER_CUPO_VEHICULAR(inCrper_cupo_vehicular);
		obj.setCRPER_TIPO_PERSONA(inCrper_tipo_persona);
		obj.setCRPER_ESTADO_INTERFECTO(inCrper_estado_interfecto);
		obj.setCRPER_FECHA_DEFUNCION(inCrper_fecha_defuncion);
		obj.setCRPER_NUMERO_ACTA(inCrper_numero_acta);
				
		obj.setCRPER_TIPO(inCrper_tipo);
		obj.setCRPER_ATENCION_CLIENTE(inCrper_atencion_cliente);
		obj.setCRPER_ESTADO(true);
		obj.setCRPER_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
					
			res = new com.besixplus.sii.db.Cgg_res_persona(obj).update1(con);
			if (obj.getCRPER_CODIGO() != "KEYGEN" && res.equals("true"))
			{

				//Insert Persona Contacto
				org.json.JSONArray objContactoJSON = new org.json.JSONArray(inPersonaContacto_JSON);				
				for (int i = 0 ; i < objContactoJSON.length(); i++){			
					com.besixplus.sii.objects.Cgg_res_persona_contacto objPersonaContacto = new com.besixplus.sii.objects.Cgg_res_persona_contacto();			
					objPersonaContacto.setCRPER_CODIGO(obj.getCRPER_CODIGO());
					objPersonaContacto.setCRTCO_CODIGO(((org.json.JSONObject)objContactoJSON.get(i)).get("CRTCO_CODIGO").toString());
					objPersonaContacto.setCRPRC_DESCRIPCION(((org.json.JSONObject)objContactoJSON.get(i)).get("CRPRC_DESCRIPCION").toString());
					objPersonaContacto.setCRPRC_CONTACTO(((org.json.JSONObject)objContactoJSON.get(i)).get("CRPRC_CONTACTO").toString());
					objPersonaContacto.setCRPRC_ESTADO(true);
					objPersonaContacto.setCRPRC_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());				
					if(((org.json.JSONObject)objContactoJSON.get(i)).get("CRPRC_CODIGO").toString().equals("KEYGEN"))
					{
						objPersonaContacto.setCRPRC_CODIGO("KEYGEN");
						objPersonaContacto.setCRPRC_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
						res = new com.besixplus.sii.db.Cgg_res_persona_contacto(objPersonaContacto).insert(con);
					}
					else
					{
						objPersonaContacto.setCRPRC_CODIGO(((org.json.JSONObject)objContactoJSON.get(i)).get("CRPRC_CODIGO").toString());
						res = new com.besixplus.sii.db.Cgg_res_persona_contacto(objPersonaContacto).update(con);
					}


				}
				//Insert Persona Perfil
				if (res.equals("true"))
				{
					org.json.JSONArray objPerfilJSON = new org.json.JSONArray(inPersonaPerfil_JSON);
					for (int i = 0 ; i < objPerfilJSON.length(); i++){						
						com.besixplus.sii.objects.Cgg_gem_perfil_prof objPersonaPerfil = new com.besixplus.sii.objects.Cgg_gem_perfil_prof();

						if(!((org.json.JSONObject)objPerfilJSON.get(i)).get("CGESP_CODIGO").toString().trim().isEmpty())
							objPersonaPerfil.setCGESP_CODIGO(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGESP_CODIGO").toString());
						if(!((org.json.JSONObject)objPerfilJSON.get(i)).get("CGTPR_CODIGO").toString().trim().isEmpty())
							objPersonaPerfil.setCGTPR_CODIGO(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGTPR_CODIGO").toString());
						if(!((org.json.JSONObject)objPerfilJSON.get(i)).get("CGIEN_CODIGO").toString().trim().isEmpty())
							objPersonaPerfil.setCGIEN_CODIGO(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGIEN_CODIGO").toString());
						objPersonaPerfil.setCGMDC_CODIGO(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGMDC_CODIGO").toString());
						objPersonaPerfil.setCRPER_CODIGO(obj.getCRPER_CODIGO());
						objPersonaPerfil.setCGPPR_NIVEL_APROBADO(Integer.parseInt(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_NIVEL_APROBADO").toString()));
						if (objPerfilJSON.getJSONObject(i).getString("CGPPR_FECHA_INICIO").trim().isEmpty())
							objPersonaPerfil.setCGPPR_FECHA_INICIO(null);
						else
							objPersonaPerfil.setCGPPR_FECHA_INICIO(new SimpleDateFormat("yyyy-MM-dd").parse(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_FECHA_INICIO").toString()));
						
						if (objPerfilJSON.getJSONObject(i).getString("CGPPR_FECHA_FIN").trim().isEmpty())
							objPersonaPerfil.setCGPPR_FECHA_FIN(null);
						else
							objPersonaPerfil.setCGPPR_FECHA_FIN(new SimpleDateFormat("yyyy-MM-dd").parse(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_FECHA_FIN").toString()));
							
						objPersonaPerfil.setCGPPR_CONFIRMADO(Boolean.parseBoolean(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_CONFIRMADO").toString()));
						objPersonaPerfil.setCGPPR_FECHA_CONFIRMACION(new Timestamp(new Date().getTime()));
						objPersonaPerfil.setCGPPR_PREDETERMINADO(Boolean.parseBoolean(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_PREDETERMINADO").toString()));
						objPersonaPerfil.setCGPPR_ESTADO(true);

						objPersonaPerfil.setCGPPR_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());

						if(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_CODIGO").toString().equals("KEYGEN"))
						{
							objPersonaPerfil.setCGPPR_CODIGO("KEYGEN");
							objPersonaPerfil.setCGPPR_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
							res = new com.besixplus.sii.db.Cgg_gem_perfil_prof(objPersonaPerfil).insert(con);
						}
						else
						{
							objPersonaPerfil.setCGPPR_CODIGO(((org.json.JSONObject)objPerfilJSON.get(i)).get("CGPPR_CODIGO").toString());
							res = new com.besixplus.sii.db.Cgg_gem_perfil_prof(objPersonaPerfil).update(con);
						}
					}
					if (res.equals("true"))
					{						
						org.json.JSONArray arrayOcupacionJSON = new org.json.JSONArray(inPersonaOcupacion_JSON);
						JSONObject objOcupacionJSON = null;
						for (int i = 0 ; i < arrayOcupacionJSON.length(); i++){
							objOcupacionJSON = arrayOcupacionJSON.getJSONObject(i);
							com.besixplus.sii.objects.Cgg_res_ocupacion_laboral objOcupacion = new com.besixplus.sii.objects.Cgg_res_ocupacion_laboral();
							
							objOcupacion.setCRPER_CODIGO(obj.getCRPER_CODIGO());
							if(!objOcupacionJSON.getString("CGG_CRPER_CODIGO").trim().isEmpty())
								objOcupacion.setCGG_CRPER_CODIGO(objOcupacionJSON.getString("CGG_CRPER_CODIGO"));
							objOcupacion.setCGCRG_CODIGO(objOcupacionJSON.getString("CGCRG_CODIGO"));
							objOcupacion.setCSCTP_CODIGO(objOcupacionJSON.getString("CSCTP_CODIGO"));
							if(!objOcupacionJSON.getString("CRPJR_CODIGO").trim().isEmpty())
								objOcupacion.setCRPJR_CODIGO(objOcupacionJSON.getString("CRPJR_CODIGO"));
							objOcupacion.setCROCL_TIPO(objOcupacionJSON.getInt("CROCL_TIPO"));
							objOcupacion.setCROCL_ESTADO(true);
							
							objOcupacion.setCROCL_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
							
							if(objOcupacionJSON.getString("CROCL_CODIGO").equals("KEYGEN"))
							{
								objOcupacion.setCROCL_CODIGO("KEYGEN");
								objOcupacion.setCROCL_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
								res = new com.besixplus.sii.db.Cgg_res_ocupacion_laboral(objOcupacion).insert(con);
							}
							else
							{
								objOcupacion.setCROCL_CODIGO(objOcupacionJSON.getString("CROCL_CODIGO"));
								res = new com.besixplus.sii.db.Cgg_res_ocupacion_laboral(objOcupacion).update(con);
							}						
						}
						if (res.equals("true"))
						{							
							con.commit();
							con.setAutoCommit(true);
							con.close();
						}
					}		
				}
			}
			con.close();
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(e.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}
	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_codigo crper_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectPersonaContacto(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
		//tmpObj.setCRPER_CODIGO(inCrper_codigo);
		ArrayList<HashMap<String,Object>> per = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			per = com.besixplus.sii.db.Cgg_res_persona.selectPersonaContactoNotificacion(con,inCrper_codigo);
			//ArrayList<com.besixplus.sii.objects.Cgg_res_persona> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
			//tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, per);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (per!= null)
			return tmpFormat.getData().toString();
		return null;
	}
		
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_matrimonio EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPrestamoExpediente(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_persona.selectCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectPrestamoExpediente(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_matrimonio EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectExpedientePersona(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<com.besixplus.sii.objects.Cgg_res_persona> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_persona.selectPrestamoCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectPrestamoExpediente(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_num_doc_identific Crper_num_doc_identific
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectNumDoc(	
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
		tmpObj.setCRPER_NUM_DOC_IDENTIFIC(inCrper_num_doc_identific);
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_persona(tmpObj).selectNumDoc(con);

			boolean needService = true;
			/*if(tmpObj.getCRPER_CODIGO()==null || tmpObj.getCRPER_CODIGO().equals("KEYGEN"))
				needService = true;
			else{
				Date reference = tmpObj.getCRPER_FECHA_DINARDAP();
				int dias = 5;//FIXME: Obtener este valor de un parámetro de la base
				Date maxDate = new Date(reference.getTime()+dias * 24 * 60 * 60 * 1000);
				Date hoy = new Date();
				if(maxDate.before(hoy))
					needService=true;
			}*/
			//MO
			if(needService) {
				try {
					RegistroCivil registroCivil = new RegistroCivil(tmpObj.getCRPER_NUM_DOC_IDENTIFIC());//cedula del beneficiario
					if (registroCivil.callServiceAsObject().equals(RegistroCivil.CALL_OK)) {
						if (registroCivil.getCedula() != null && !registroCivil.getCedula().trim().isEmpty()) {
							List<String> apellidos = Utils.buildNombresApellidos(registroCivil.getNombre(), registroCivil.getNombrePadre(), registroCivil.getNombreMadre());
							if (apellidos != null && apellidos.size() == 3) {
								if(apellidos.get(0).length()>0)
									tmpObj.setCRPER_APELLIDO_PATERNO(apellidos.get(0));
								if(apellidos.get(1).length()>0)
									tmpObj.setCRPER_APELLIDO_MATERNO(apellidos.get(1));
								if(apellidos.get(2).length()>0)
									tmpObj.setCRPER_NOMBRES(apellidos.get(2));
							}
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							tmpObj.setCRPER_FECHA_NACIMIENTO(sdf.parse(registroCivil.getFechaNacimiento()));
							if (registroCivil.getFechaMatrimonio() != null && registroCivil.getFechaMatrimonio().length() > 0)
								tmpObj.setCRPER_FECHA_MATRIMONIO(sdf.parse(registroCivil.getFechaMatrimonio()));
							if (registroCivil.getCedulaConyuge() != null && registroCivil.getCedulaConyuge().length() > 0)
								tmpObj.setCRPER_CONYUGE(registroCivil.getCedulaConyuge());

							if (registroCivil.getNacionalidad().equals("ECUATORIANA")) {
								tmpObj.setCPAIS_CODIGO("61");
							}
							if (registroCivil.getGenero().equals("FEMENINO")) {
								tmpObj.setCRPER_GENERO(1);
							} else {
								tmpObj.setCRPER_GENERO(0);
							}

					/*
					* Creamos la cedula en BG
					* */
							final String crper_codigo = tmpObj.getCRPER_CODIGO();
							Thread t = new Thread() {
								public void run() {
									CreateRCAttachment attachment = new CreateRCAttachment(registroCivil, crper_codigo);
									try {
										attachment.attachReport();
									} catch (SQLException e) {
										e.printStackTrace();
									}
								}
							};
							t.start();
						}
					}

					CNE cne = new CNE(tmpObj.getCRPER_NUM_DOC_IDENTIFIC());
					if (cne.callServiceAsObject().equals(CNE.CALL_OK)) {
						final String crper_codigo = tmpObj.getCRPER_CODIGO();
						Thread t = new Thread() {
							public void run() {
								CreateCNEAttachment attachment = new CreateCNEAttachment(cne, crper_codigo);
								try {
									attachment.attachReport();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						};
						t.start();
					}
					//
				} catch (Exception ex) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(ex);
				}
			}
			ArrayList<com.besixplus.sii.objects.Cgg_res_persona> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectPageObservado(
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
			tmpCount = com.besixplus.sii.db.Cgg_res_persona.selectObservadoCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectObservado(con, tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword);
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
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
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
	public String selectConsultaPersonaGeneral(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inIdentificacion")String inIdentificacion
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String, Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_persona.selectPersonaHistorialCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectConsultaGeneralPersona(con,tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword, inIdentificacion);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_observado EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectHistorialObservado(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectPersonaHistorialObservado(con,inCrper_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format,obj);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_notificacion EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectHistorialNotificacion(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> obj = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			
			con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_res_persona.selectPersonaHistorialNotificacion(con,inCrper_codigo);
			//ArrayList<com.besixplus.sii.objects.Cgg_res_persona> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
			//tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format,obj);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE LOS REGISTROS DE LA TABLA Cgg_res_movilidad EN UNA ESTRUCTURA JSON o XML QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML).
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectHistorialMovilidad(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCrper_codigo")String inCrper_codigo
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String, Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_persona.selectMovilidadGeneralCount(con, keyword, inCrper_codigo);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectPersonaHistorialMovilidadGeneral(con,tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword,inCrper_codigo);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad_interna EN UNA ESTRUCTURA JSON o XML.
	 * @param start INDICE DE INICIO DE LOS REGISTROS DE LA TABLA.
	 * @param limit TOTAL DE REGISTRO QUE SON SELECCIONADOS POR PAGINA.
	 * @param sort NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	 * @param dir DIRECCION DEL ORDENAMIENTO DE LOS REGISTROS.
	 * @param keyword CRITERIO DE BUSQUEDA.
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectHistorialMovilidadInterna(
			@WebParam(name="start")int start,
			@WebParam(name="limit")int limit,
			@WebParam(name="sort")String sort,
			@WebParam(name="dir")String dir,
			@WebParam(name="keyword")String keyword,
			@WebParam(name="format")String format,
			@WebParam(name="inCrper_codigo")String inCrper_codigo
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String, Object>> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		int tmpCount = 0;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			tmpCount = com.besixplus.sii.db.Cgg_res_persona.selectMovilidadInternaCount(con, keyword);
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectPersonaHistorialMovilidadInterna(con,tmpRequest.getUserPrincipal().getName(), start, limit, sort, dir, keyword,inCrper_codigo);
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
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_expulsion EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectHistorialExpulsion(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
		//tmpObj.setCRPER_CODIGO(inCrper_codigo);
		ArrayList<HashMap<String,Object>> obj = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			//con.setAutoCommit(false);
			obj = com.besixplus.sii.db.Cgg_res_persona.selectPersonaHistorialExpulsion(con,inCrper_codigo);
			//ArrayList<com.besixplus.sii.objects.Cgg_res_persona> tmpArray = new ArrayList<com.besixplus.sii.objects.Cgg_res_persona>();
			//tmpArray.add(tmpObj);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format,obj);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (obj!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectPersonaTiempoEstadia(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> per = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			per = com.besixplus.sii.db.Cgg_res_persona.selectPersonaEstadia(con,inCrper_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, per);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (per!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	
	/**
	 * SELECCIONA TODOS LOS EMAILS DE UNA PERSONA
	 * @param inCrper_codigo CODIGO DE LA PERSONA
	 * @param inSW MODO DE CONSULTA, <code>0</code> SE BASA EN EL CODIGO DE LA PERSONA, <code>1</code> EN EL CODIGO DEL USUARIO
	 * @param format FORMATO DE SALIDA DE LA INFORMACION
	 * @return
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectEmails(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inSW")int inSW,
			@WebParam(name="format")String format) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String, String>> tmpEmails = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(false);
			tmpEmails = new com.besixplus.sii.db.Cgg_res_persona().selectEmails(con, inCrper_codigo, inSW);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, tmpEmails);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpEmails != null)
			return tmpFormat.getData().toString();
		return null;
	}
	
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_residencia EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_codigo IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectHistorialResidencia(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> per = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			per = com.besixplus.sii.db.Cgg_res_persona.selectPersonaResidenciaHistorial(con,inCrper_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, per);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (per!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_res_movilidad EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_num_doc_identific NUMERO DE DOCUMENTO IDENTIFICATIVO DE LA PERSONA
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)
	 * @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	 * @throws SOAPException 
	 */
	@WebMethod
	public String selectPersonaTiempoEstadiaHistorial(
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific,
			@WebParam(name="format")String format
	) throws SOAPException{
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		ArrayList<HashMap<String,Object>> per = new ArrayList<HashMap<String,Object>>();
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			per = com.besixplus.sii.db.Cgg_res_persona.selectPersonaEstadiaHistorial(con,inCrper_num_doc_identific);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, per);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (per!= null)
			return tmpFormat.getData().toString();
		return null;
	}
	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_codigo crper_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */	
	@WebMethod
	public String selectDatosPersonalesById(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
		ArrayList<HashMap<String,Object>> obj = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectDatosPersonalesById(con,inCrper_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
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
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_codigo crper_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */	
	@WebMethod
	public String selectFotoCurriculumById(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
		ArrayList<HashMap<String,Object>> obj = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_res_persona.selectFotoCurriculumById(con,inCrper_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
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
	 * ACTUALIZA LA IMAGEN DE LAS HUELLAS DACTILARES DE UNA PERSONA.
	 * NOTA: LAS IMAGENES ESTAN ORDENADAS CONFORME A UNA MATRIZ DE 5X2. SUPERIOR: MANO DERECHA, INFERIOR: MANO IZQUIERDA; DE IZQUIERDA A DERECHA DESDE PULGAR A MENIQUE; RESOLUCION: 248x292 PXL.
	 * @param inCrper_codigo crper_codigo
	 * @param inCrper_huella_dactilar INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADAS. ESTA INFORMACION ES PROCESADA POR LA LIBRERIA. ESTA INFORMACION DEBE SER CONSIDERADA PARA VERIFICACIONES..
	 * @param inCrper_huella_imagen IMAGEN EN FORMATO JPG DE LAS HUELLAS DACTILARES DE LA PERSONA. LAS IMAGENES ESTAN ORDENADAS CONFORME A UNA MATRIZ DE 5X2. SUPERIOR: MANO DERECHA, INFERIOR: MANO IZQUIERDA; DE IZQUIERDA A DERECHA DESDE PULGAR A MENIQUE; RESOLUCION: 248x292 PXL CADA IMAGEN..
	 * @param inCrper_huella_cadena INFORMACION EN BASE64 QUE REPRESENTA LAS HUELLAS CAPTURADA. ESTA INFORMACION NO ES PROCESADA POR LA LIBRERIA, CON LA FINALIDAD DE OBTENER IMAGENES INDIVIDUALES DE LA HUELLAS. ESTA INFORMACION NO PUEDE SER CONSIDERADA PARA VERIFICACIONES..
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */	
	@WebMethod
	public String updateHuellaImagen(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCrper_huella_dactilar")String inCrper_huella_dactilar,
			@WebParam(name="inCrper_huella_imagen")String inCrper_huella_imagen,
			@WebParam(name="inCrper_huella_cadena")String inCrper_huella_cadena
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		String res = "true";
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			com.besixplus.sii.objects.Cgg_res_persona tmpPersona = new com.besixplus.sii.objects.Cgg_res_persona();
			tmpPersona.setCRPER_CODIGO(inCrper_codigo);
			tmpPersona.setCRPER_HUELLA_DACTILAR(inCrper_huella_dactilar);
			tmpPersona.setCRPER_HUELLA_IMAGEN(com.besixplus.sii.mail.Base64.decode(inCrper_huella_imagen));
			tmpPersona.setCRPER_HUELLA_CADENA(inCrper_huella_cadena);
			res = new com.besixplus.sii.db.Cgg_res_persona(tmpPersona).updateHuellaImagen(con);
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}
	/**
	 * ACTUALIZA LA IMAGEN DE LA FIRMA DIGITAL DE UNA PERSONA.
	 * NOTA: LAS IMAGENES ESTAN ORDENADAS CONFORME A UNA MATRIZ DE 5X2. SUPERIOR: MANO DERECHA, INFERIOR: MANO IZQUIERDA; DE IZQUIERDA A DERECHA DESDE PULGAR A MENIQUE; RESOLUCION: 248x292 PXL.
	 * @param inCrper_codigo crper_codigo
 	 * @param inCrper_firma FIRMA DIGITAL DE LA PERSONA.
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */	
	@WebMethod
	public String updateFirma(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="inCrper_firma")String inCrper_firma
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		String res = "true";
		try{
			Connection con = ManagerConnection.getConnection();
			if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}
			com.besixplus.sii.objects.Cgg_res_persona tmpPersona = new com.besixplus.sii.objects.Cgg_res_persona();
			tmpPersona.setCRPER_CODIGO(inCrper_codigo);
			tmpPersona.setCRPER_FIRMA(com.besixplus.sii.mail.Base64.decode(inCrper_firma));
			res = new com.besixplus.sii.db.Cgg_res_persona(tmpPersona).updateFirma(con);
			if(!res.equals("true"))
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(res, new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		return res;
	}
	/**
	 * SELECCIONA LOS CAMPOS DE FOTOGRAFIA,HUELLAS Y FIRMA  EN LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_codigo crper_codigo
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */	
	@WebMethod
	public String selectAdjuntosIdentificacionById(
			@WebParam(name="inCrper_codigo")String inCrper_codigo,
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
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
			obj = com.besixplus.sii.db.Cgg_res_persona.selectAdjuntosIdentificacionById(con,inCrper_codigo);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpObj != null)
			return outCadena.toString();
		return null;
	}
	
	/**
	 * SELECCIONA LOS DATOS DE LA PERSONA DE ACUERDO A SU NOMBRE DE USUARIO 
	 * @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML)
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */	
	@WebMethod
	public String selectDatosAuspiciante(
			@WebParam(name="format")String format
	) throws SOAPException{
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
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
			obj = com.besixplus.sii.db.Cgg_res_persona.selectDatosAuspiciante(con,tmpRequest.getUserPrincipal().getName());
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpObj != null)
			return outCadena.toString();
		return null;
	}
	
	/**
	 * SELECCIONA UN REGISTRO EN LA TABLA Cgg_res_persona EN UNA ESTRUCTURA JSON o XML.
	 * @param inCrper_num_doc_identific Crper_num_doc_identific
	 * @return String REGISTRO SELECCIONADO.
	 * @throws SOAPException 
	 */
	
	public String selectNumeroIdentificacion(	
			String inCrper_num_doc_identific
	) {
		com.besixplus.sii.objects.Cgg_res_persona tmpObj = new com.besixplus.sii.objects.Cgg_res_persona();
		tmpObj.setCRPER_NUM_DOC_IDENTIFIC(inCrper_num_doc_identific);
		try{
			Connection con = ManagerConnection.getConnection();
			con.setAutoCommit(!ManagerConnection.isDeployed());
			tmpObj = new com.besixplus.sii.db.Cgg_res_persona(tmpObj).selectNumDoc(con);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			//throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		catch(Exception inException){
			inException.printStackTrace();
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			//throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		if (tmpObj != null)
			return tmpObj.getCRPER_CODIGO() == null?"false":tmpObj.getCRPER_CODIGO();;
		return null;
	}
}