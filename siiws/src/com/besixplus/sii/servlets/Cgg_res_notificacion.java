package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jboss.util.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.besixplus.sii.db.Cgg_configuracion;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.besixplus.sii.objects.ServerResponse;

public class Cgg_res_notificacion extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 239652184;

	public Cgg_res_notificacion() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpRequest = "none";

		String inNuevoBeneficiario = null;
		String cggCrperCodigo = null;
		String inCgg_crper_codigo = null;
		Cgg_res_persona objNuevoBeneficiario = null,
		objTmpBeneficiario = null;
		JSONObject objTmpPersona = null;
		boolean tmpIsDenuncia = false;
		ServerResponse tmpResponse = new ServerResponse();
		tmpResponse.setSuccess(false);
		tmpResponse.setMsg("test");

		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_res_notificacion obj = new com.besixplus.sii.objects.Cgg_res_notificacion();
			com.besixplus.sii.objects.Cgg_res_persona objPersona = new Cgg_res_persona(); 
			DiskFileItemFactory factory = new DiskFileItemFactory();			
			ServletFileUpload upload = new ServletFileUpload(factory);
			com.besixplus.sii.objects.Cgg_configuracion tmpConf = new com.besixplus.sii.objects.Cgg_configuracion();
			tmpConf.setCGCNF_CODIGO("CONF10");
			Connection tmpCon = ManagerConnection.getConnection();
			try {
				tmpCon.setAutoCommit(false);
				new Cgg_configuracion(tmpConf).select(tmpCon);
				tmpCon.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			upload.setSizeMax(tmpConf.getCGCNF_VALOR_NUMERICO()*1024*1024);
			List items;

			try {
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();

					if (item.isFormField()) 
					{
						if(item.getFieldName().equals("crnot_codigo"))
							obj.setCRNOT_CODIGO(item.getString());
						if(item.getString().trim().length()>0){

							if(item.getFieldName().equals("crtnt_codigo")){
								obj.setCRTNT_CODIGO(item.getString());
							}
							if(item.getFieldName().equals("crper_codigo")){
								obj.setCRPER_CODIGO(item.getString());

							}
							if(item.getFieldName().equals("inNuevoBeneficiario")){
								inNuevoBeneficiario = item.getString();
							}

							if(item.getFieldName().equals("cusu_codigo")){
								obj.setCUSU_CODIGO(item.getString());
							}

							if(item.getFieldName().equals("cgg_cusu_codigo")){
								obj.setCGG_CUSU_CODIGO(item.getString());
							}
							if(item.getFieldName().equals("crres_codigo")){
								obj.setCRRES_CODIGO(item.getString());
							}
							if(item.getFieldName().equals("crden_codigo")){
								obj.setCRDEN_CODIGO(item.getString());
								tmpIsDenuncia = true;

							}

							if(item.getFieldName().equals("crosg_codigo")){
								obj.setCROSG_CODIGO(item.getString());

							}
							if(item.getFieldName().equals("cgg_crosg_codigo")){
								obj.setCGG_CROSG_CODIGO(item.getString());
							}
							if(item.getFieldName().equals("dtCrnot_fecha_audiencia") ){
								try{
									obj.setCRNOT_FECHA_AUDIENCIA(new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(item.getString()).getTime()));
								} catch (ParseException e) {
									e.printStackTrace();
								}
							}
							if(item.getFieldName().equals("dtCrnot_fecha_salida_volunt") ){
								try {

									obj.setCRNOT_FECHA_SALIDA_VOLUNT(new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(item.getString()).getTime()));

								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							if(item.getFieldName().equals("dtCrnot_fecha_expulsion") ){							
								try {
									obj.setCRNOT_FECHA_EXPULSION(new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(item.getString()).getTime()));

								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						if(item.getFieldName().equals("cbxCantonH")){
							obj.setCCTN_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("txtCrnot_numero_notificacion")){
							obj.setCRNOT_NUMERO_NOTIFICACION(item.getString());
						}
						if(item.getFieldName().equals("dtCrnot_fecha_notificacion")){
							try {
								obj.setCRNOT_FECHA_NOTIFICACION(new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(item.getString()).getTime()));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}

						if(item.getFieldName().equals("txtCrnot_lugar_notificacion")){
							obj.setCRNOT_LUGAR_NOTIFICACION(item.getString());
						}
						if(item.getFieldName().equals("txtCrnot_referencia")){
							obj.setCRNOT_REFERENCIA(item.getString());
						}
						if(item.getFieldName().equals("txtCrnot_observacion")){
							obj.setCRNOT_OBSERVACION(item.getString());
						}
						if(item.getFieldName().equals("chkCrnot_estado")){
							obj.setCRNOT_ESTADO_NOTIFICACION(Integer.parseInt(item.getString()));
						}
						if(item.getFieldName().equals("cbxCrnot_estatusH")){
							obj.setCRNOT_REGULARIZACION(item.getString());
						}

						if(item.getFieldName().equals("txtCrnot_extracto_audiencia")){
							obj.setCRNOT_EXTRACTO_AUDIENCIA(item.getString());
						}
						if(item.getFieldName().equals("txtCrnot_observacion_audiencia")){
							obj.setCRNOT_OBSERVACION_AUDIENCIA(item.getString());
						}
						if(item.getFieldName().equals("chkCrnot_procede_notificacion")){
							obj.setCRNOT_PROCEDE_NOTIFICACION(Boolean.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("txtCrnot_descripcion_adjunto_aud")){
							obj.setCRNOT_DESCRIPCION_ADJUNTO_AUD(item.getString());
						}
						if(item.getFieldName().equals("txtCrnot_nombre_adjunto_audiencia")){
							obj.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(item.getString());
						}


						if(item.getFieldName().equals("crper_huella_dactilar")){
							objPersona.setCRPER_HUELLA_DACTILAR(item.getString());
						}
						if(item.getFieldName().equals("crper_huella_imagen") && item.getString().trim().length() > 0){
							objPersona.setCRPER_HUELLA_IMAGEN(Base64.decode(item.getString()));
						}
						if(item.getFieldName().equals("crper_huella_cadena")){
							objPersona.setCRPER_HUELLA_CADENA(item.getString());
						}


						if(item.getFieldName().equals("request"))
							tmpRequest = item.getString();
					}else {

						if(item.getFieldName().equals("filCrnot_adjunto_audiencia")){
							obj.setCRNOT_NOMBRE_ADJUNTO_AUDIENCIA(item.getName());
							obj.setCRNOT_ADJUNTO_AUDIENCIA(item.get());
						}
					}

				}
				obj.setCRNOT_ESTADO(true);
				obj.setCRNOT_USUARIO_INSERT(request.getUserPrincipal().getName());
				obj.setCRNOT_USUARIO_UPDATE(request.getUserPrincipal().getName());

				try {
					tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
					tmpCon.setAutoCommit(false);

					if(obj.getCRPER_CODIGO().equals("KEYGEN")){
						//REGISTRO DEL BENEFICIARIO					
						objTmpPersona = new JSONObject(inNuevoBeneficiario);
						objTmpBeneficiario = new Cgg_res_persona();			
						objNuevoBeneficiario = new Cgg_res_persona();
						objNuevoBeneficiario.setCRPER_CODIGO("KEYGEN");
						objNuevoBeneficiario.setCRECV_CODIGO(objTmpPersona.getString("CRECV_CODIGO"));
						objNuevoBeneficiario.setCRDID_CODIGO(objTmpPersona.getString("CRDID_CODIGO"));
						objNuevoBeneficiario.setCRPER_NOMBRES(objTmpPersona.getString("CRPER_NOMBRES"));
						objNuevoBeneficiario.setCRPER_APELLIDO_PATERNO(objTmpPersona.getString("CRPER_APELLIDO_PATERNO"));
						objNuevoBeneficiario.setCRPER_APELLIDO_MATERNO(objTmpPersona.getString("CRPER_APELLIDO_MATERNO"));
						objNuevoBeneficiario.setCRPER_NUM_DOC_IDENTIFIC(objTmpPersona.getString("CRPER_NUM_DOC_IDENTIFIC"));
						objNuevoBeneficiario.setCRPER_GENERO(objTmpPersona.getInt("CRPER_GENERO"));

						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaNacimiento = null;
						try{
							fechaNacimiento = df.parse(objTmpPersona.getString("CRPER_FECHA_NACIMIENTO"));
						} catch (ParseException e){
							e.printStackTrace();
							fechaNacimiento = new Date();
						}
						objNuevoBeneficiario.setCRPER_FECHA_NACIMIENTO( fechaNacimiento );
						objNuevoBeneficiario.setCRPER_ESTADO(true);
						objNuevoBeneficiario.setCRPER_USUARIO_INSERT(request.getUserPrincipal().getName());
						objNuevoBeneficiario.setCRPER_USUARIO_UPDATE(request.getUserPrincipal().getName());									
						cggCrperCodigo = new com.besixplus.sii.db.Cgg_res_persona(objNuevoBeneficiario).insert(tmpCon);
						obj.setCRPER_CODIGO(objNuevoBeneficiario.getCRPER_CODIGO());
					}

					if(tmpRequest.trim().toUpperCase().equals("INSERT"))
					{
						obj.setCRNOT_CODIGO("KEYGEN");

						outResult = new com.besixplus.sii.db.Cgg_res_notificacion(obj).insert(tmpCon);
						if(outResult=="true"){
							if(tmpIsDenuncia == true)
							{
								com.besixplus.sii.objects.Cgg_res_denuncia objden = new com.besixplus.sii.objects.Cgg_res_denuncia();
								objden.setCRDEN_CODIGO(obj.getCRDEN_CODIGO());
								objden.setCRDEN_ESTADO_DENUNCIA(1);
								objden.setCRDEN_USUARIO_UPDATE(request.getUserPrincipal().getName());
								outResult= new com.besixplus.sii.db.Cgg_res_denuncia(objden).updateDenunciaNot(tmpCon);

							}
							if (!objPersona.getCRPER_HUELLA_CADENA().trim().isEmpty())
							{
								objPersona.setCRPER_CODIGO(obj.getCRPER_CODIGO());
								outResult = new com.besixplus.sii.db.Cgg_res_persona(objPersona).updateHuellaImagen(tmpCon);
							}
						}

					}else{
						outResult = new com.besixplus.sii.db.Cgg_res_notificacion(obj).update(tmpCon);
					}
					if(outResult.equals("true")){
						tmpResponse.setSuccess(true);
						tmpCon.commit();
						tmpCon.setAutoCommit(true);
					}else{
						tmpResponse.setSuccess(false);
						tmpResponse.setMsg(outResult);
					}
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					tmpResponse.setSuccess(false);
					tmpResponse.setMsg(e.getMessage());
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
				tmpResponse.setSuccess(false);
//				tmpResponse.setMsg(e.getMessage());
			} catch (JSONException e) {
				e.printStackTrace();
				tmpResponse.setSuccess(false);
				tmpResponse.setMsg(e.getMessage());
			}
			
		}
		response.setContentType("text/html");
		response.getWriter().println(new JSONObject(tmpResponse).toString());
	}	
}
