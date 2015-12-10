package com.besixplus.sii.ws;


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
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import com.besixplus.sii.db.ManagerConnection;

/**
* CLASE Cgg_atc_denuncia_sugerencia
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_denuncia POR MEDIO DE SERVICOS WEB.
*
* @autor BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_atc_denuncia_sugerencia implements Serializable{

	private static final long serialVersionUID = 1315874501;

	@Resource WebServiceContext wctx;

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_res_denuncia.
	* @param inCusu_codigo IDENTIFICATIVO UNICO DE REGISTRO.
	* @param inCrden_anio ANIO DE LA DENUNCIA.
	* @param inCrden_numero NUMERO DE LA DENUNCIA.
	* @param inCrden_fecha_recepcion FECHA DE RECEPCION DE LA  DENUNCIA.
	* @param inCrden_numero_doc_ident NUMERO DE DOCUMENTO DE IDENTIFICACION DEL DENUNCIANTE.
	* @param inCrden_nombres NOMBRES DEL DENUNCIANTE.
	* @param inCrden_apellidos APELLIDOS DEL DENUNCIANTE.
	* @param inCrden_descripcion MOTIVO DE LA DENUNCIA.
	* @param inCrden_contacto PARA CORREO ELECTRONICO O NUMERO TELEFONICO DEL DENUNCIANTE.
	* @param inCrden_tipo TIPO DE DENUNCIA
		RESIDENCIA ->   0
		GESTION EMPLEO ->  1.
	* @param inCrden_denuncia ESTADO QUE DETERMINA EL ORIGEN DE LA INFORMACION DENUNCIA/SUGERENCIA.
	* @param inCrden_seguimiento CAMPO DE REGISTRO DE SEGUIMIENTO DE LA DENUNCIA.
	* @param inCrden_estado_denuncia ESTADO DEL REGISTRO, RECOGE INFORMACION PARA DETERMINAR SI ESTA:
		REGISTRADA
		REVISADA
		DESCARTADA.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	@WebMethod
	public String insert(
		@WebParam(name="inCusu_codigo")String inCusu_codigo,
		@WebParam(name="inCrden_anio")String inCrden_anio,
		@WebParam(name="inCrden_numero")String inCrden_numero,
		@WebParam(name="inCrden_fecha_recepcion")java.util.Date inCrden_fecha_recepcion,
		@WebParam(name="inCrden_numero_doc_ident")String inCrden_numero_doc_ident,
		@WebParam(name="inCrden_nombres")String inCrden_nombres,
		@WebParam(name="inCrden_apellidos")String inCrden_apellidos,
		@WebParam(name="inCrden_descripcion")String inCrden_descripcion,
		@WebParam(name="inCrden_contacto")String inCrden_contacto,
		@WebParam(name="inCrden_tipo")int inCrden_tipo,
		@WebParam(name="inCrden_denuncia")boolean inCrden_denuncia,
		@WebParam(name="inCrden_seguimiento")String inCrden_seguimiento,
		@WebParam(name="inCrden_estado_denuncia")int inCrden_estado_denuncia
	){
		String res = "true";
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);		
		com.besixplus.sii.objects.Cgg_res_denuncia obj = new com.besixplus.sii.objects.Cgg_res_denuncia();
		obj.setCRDEN_CODIGO("KEYGEN");
		obj.setCUSU_CODIGO(inCusu_codigo);
		obj.setCRDEN_ANIO(inCrden_anio);
		obj.setCRDEN_NUMERO(inCrden_numero);
		obj.setCRDEN_FECHA_RECEPCION(inCrden_fecha_recepcion);
		obj.setCRDEN_NUMERO_DOC_IDENT(inCrden_numero_doc_ident);
		obj.setCRDEN_NOMBRES(inCrden_nombres);
		obj.setCRDEN_APELLIDOS(inCrden_apellidos);
		obj.setCRDEN_DESCRIPCION(inCrden_descripcion);
		obj.setCRDEN_CONTACTO(inCrden_contacto);
		obj.setCRDEN_TIPO(inCrden_tipo);
		obj.setCRDEN_DENUNCIA(inCrden_denuncia);
		obj.setCRDEN_SEGUIMIENTO(inCrden_seguimiento);
		obj.setCRDEN_ESTADO_DENUNCIA(inCrden_estado_denuncia);
		obj.setCRDEN_ESTADO(true);
		if (tmpRequest.getUserPrincipal()!=null){
			obj.setCRDEN_USUARIO_INSERT(tmpRequest.getUserPrincipal().getName());
			obj.setCRDEN_USUARIO_UPDATE(tmpRequest.getUserPrincipal().getName());
		}else{
			obj.setCRDEN_USUARIO_INSERT("");
			obj.setCRDEN_USUARIO_UPDATE("");
		}

		try{
			Connection con = ManagerConnection.getConnection();			
			res = new com.besixplus.sii.db.Cgg_res_denuncia(obj).insert(con);
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

	

}