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

import org.json.JSONException;
import org.json.JSONObject;

import com.besixplus.sii.db.Cgg_tct_grupo_turista;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.i18n.Messages;
import com.besixplus.sii.misc.CGGEnumerators.TipoAmbitoEspecie;
import com.besixplus.sii.objects.ServerResponse;

/**
 * CLASE Cgg_tct_atractivos_actividades
 * CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_tct_atractivos_actividades POR MEDIO DE SERVICIOS WEB.
 *
 * @author BMLAURUS LTDA.
 */
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_tct_atractivos_actividades implements Serializable{

	private static final long serialVersionUID = 2027721331;
	@Resource WebServiceContext wctx;

	/**
	 * INSERTA UN REGISTRO EN LA TABLA Cgg_tct_atractivos_actividades.
	 */
	@WebMethod
	public String insert(
			@WebParam(name="in_Ctgtr_codigo")String in_Ctgtr_codigo,
			@WebParam(name="in_Ctata_vida_marina")String in_Ctata_vida_marina,
			@WebParam(name="in_Ctata_sol_playa")String in_Ctata_sol_playa,
			@WebParam(name="in_Ctata_vida_terrestre")String in_Ctata_vida_terrestre,
			@WebParam(name="in_Ctata_paisaje")String in_Ctata_paisaje,		
			@WebParam(name="in_Ctata_crucero ")String in_Ctata_crucero,
			@WebParam(name="in_Ctata_buceo")String in_Ctata_buceo,
			@WebParam(name="in_Ctata_snorkel")String in_Ctata_snorkel,
			@WebParam(name="in_Ctata_kayak")String in_Ctata_kayak,
			@WebParam(name="in_Ctata_surf")String in_Ctata_surf,
			@WebParam(name="in_Ctata_senderismo")String in_Ctata_senderismo,
			@WebParam(name="in_Ctata_observacion")String in_Ctata_observacion,
			@WebParam(name="in_Ctata_fotografia")String in_Ctata_fotografia,
			@WebParam(name="in_Ctata_pesca_vivencial")String in_Ctata_pesca_vivencial
	) throws SOAPException{
		System.out.println(" GRUPO "+ in_Ctgtr_codigo);
		System.out.println(" VIDA MARINA "+ in_Ctata_vida_marina);
		System.out.println(" SOL Y PAYA "+ in_Ctata_sol_playa);  
		System.out.println(" VIDA TERRESTRE "+ in_Ctata_vida_terrestre);
		System.out.println(" PAISAJE "+ in_Ctata_paisaje);
		System.out.println(" CRUCERO "+ in_Ctata_crucero); 
		System.out.println(" BUCEO "+ in_Ctata_buceo);
		System.out.println(" SNORKEL "+ in_Ctata_snorkel);
		System.out.println(" KAYAK "+ in_Ctata_kayak);
		System.out.println(" SURF "+ in_Ctata_surf);
		System.out.println(" SENDERISMO "+ in_Ctata_senderismo);
		System.out.println(" OBSERVACION "+ in_Ctata_observacion);
		System.out.println(" FOTOGRAFIA "+ in_Ctata_fotografia);
		System.out.println(" PESCA VIVENCIAL "+ in_Ctata_pesca_vivencial);

		String res = "true";
		ServerResponse tmpServerResponse = new ServerResponse();
		try{
			System.out.println("22222222222222");
			Connection con = ManagerConnection.getConnection();
			
			System.out.println("3333333333333");
			con.setAutoCommit(false);

			com.besixplus.sii.objects.Cgg_tct_atractivos_actividades objAtractivos = new com.besixplus.sii.objects.Cgg_tct_atractivos_actividades();
			objAtractivos.setCTATA_CODIGO("KEYGEN");
			objAtractivos.setCTGTR_CODIGO(in_Ctgtr_codigo);
			objAtractivos.setCTATA_VIDA_MARINA(in_Ctata_vida_marina);
			objAtractivos.setCTATA_SOL_PLAYA(in_Ctata_sol_playa);
			objAtractivos.setCTATA_VIDA_TERRESTRE(in_Ctata_vida_terrestre);
			objAtractivos.setCTATA_PAISAJE(in_Ctata_paisaje);
			objAtractivos.setCTATA_CRUCERO(in_Ctata_crucero);
			objAtractivos.setCTATA_BUCEO(in_Ctata_buceo);
			objAtractivos.setCTATA_SNORKEL(in_Ctata_snorkel);
			objAtractivos.setCTATA_KAYAK(in_Ctata_kayak);
			objAtractivos.setCTATA_SURF(in_Ctata_surf);
			objAtractivos.setCTATA_SENDERISMO(in_Ctata_senderismo);
			objAtractivos.setCTATA_OBSERVACION(in_Ctata_observacion);
			objAtractivos.setCTATA_FOTOGRAFIA(in_Ctata_fotografia);
			objAtractivos.setCTATA_PESCA_VIVENCIAL(in_Ctata_pesca_vivencial);
			
			res = new com.besixplus.sii.db.Cgg_tct_atractivos_actividades(objAtractivos).insert(con);
			System.out.println("5555555555555->"+res);
			
			if(res.equals("true")){
				System.out.println("18-18--18-18.18.81.81.81");
				con.commit();
				tmpServerResponse.setSuccess(true);
			}else{	
				con.rollback();
				tmpServerResponse.setMsg(res);
			}
			con.setAutoCommit(true);
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			tmpServerResponse.setMsg(inException.getMessage());
		} catch (JSONException e) {
			e.printStackTrace();
			tmpServerResponse.setMsg(e.getMessage());
		}
		return new JSONObject(tmpServerResponse).toString();
	}

	
}