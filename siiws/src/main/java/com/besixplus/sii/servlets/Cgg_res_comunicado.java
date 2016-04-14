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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONException;
import org.json.JSONObject;

import com.besixplus.sii.db.Cgg_configuracion;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.besixplus.sii.objects.ServerResponse;

public class Cgg_res_comunicado extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1787722628;

	public Cgg_res_comunicado() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpRequest = null;
		ServerResponse appResponse= new ServerResponse();

		String inNuevoBeneficiario = null;
		Cgg_res_persona objNuevoBeneficiario = null,
		objTmpBeneficiario = null;
		JSONObject objTmpPersona = null;
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_res_comunicado obj = new com.besixplus.sii.objects.Cgg_res_comunicado();
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
					if (item.isFormField()) {
						if(item.getFieldName().equals("request"))
							tmpRequest = item.getString();
						if(item.getFieldName().equals("txtCrcom_codigo"))
							obj.setCRCOM_CODIGO(item.getString());
						if(item.getFieldName().equals("crres_codigo") && item.getString().trim().length() > 0)
							obj.setCRRES_CODIGO(item.getString());
						if(item.getFieldName().equals("crper_codigo") && item.getString().trim().length() > 0)
							obj.setCRPER_CODIGO(item.getString());
						if(item.getFieldName().equals("inNuevoBeneficiario")){
							inNuevoBeneficiario = item.getString();
						}
						if(item.getFieldName().equals("cgg_crper_codigo") && item.getString().trim().length() > 0)
							obj.setCGG_CRPER_CODIGO(item.getString());
						if(item.getFieldName().equals("crpjr_codigo") && item.getString().trim().length() > 0)
							obj.setCRPJR_CODIGO(item.getString());
						if(item.getFieldName().equals("txtCrcom_destinatario"))
							obj.setCRCOM_DESTINATARIO(item.getString());
						if(item.getFieldName().equals("txtCrcom_asunto"))
							obj.setCRCOM_ASUNTO(item.getString());
						if(item.getFieldName().equals("dtCrcom_fecha_recepcion"))
							obj.setCRCOM_FECHA_RECEPCION(Timestamp.valueOf(item.getString()));
						if(item.getFieldName().equals("dtCrcom_fecha_revision"))
							obj.setCRCOM_FECHA_REVISION(Timestamp.valueOf(item.getString()));
						if(item.getFieldName().equals("txtCrcom_numero_documento"))
							obj.setCRCOM_NUMERO_DOCUMENTO(item.getString());
						if(item.getFieldName().equals("txtCrcom_descripcion"))
							obj.setCRCOM_DESCRIPCION(item.getString());
						if(item.getFieldName().equals("txtCrcom_observacion"))
							obj.setCRCOM_OBSERVACION(item.getString());
						if(item.getFieldName().equals("txtCrcom_descripcion_adjunto"))
							obj.setCRCOM_DESCRIPCION_ADJUNTO(item.getString());
						if(item.getFieldName().equals("txtCrcom_nombre_adjunto"))
							obj.setCRCOM_NOMBRE_ADJUNTO(item.getString());
						if(item.getFieldName().equals("txtCrcom_remitente"))
							obj.setCRCOM_REMITENTE(item.getString());
						if(item.getFieldName().equals("crcom_estado_comunicado"))
							obj.setCRCOM_ESTADO_COMUNICADO(Integer.valueOf(item.getString()));
					} else {
						if(item.getFieldName().equals("filCrcom_adjunto")){
							if(item.get().length > 0){
								obj.setCRCOM_ADJUNTO(item.get());
								obj.setCRCOM_NOMBRE_ADJUNTO(item.getName());
							}
						}
					}
				}
				obj.setCRCOM_ESTADO(true);
				obj.setCRCOM_USUARIO_UPDATE(request.getUserPrincipal().getName());
				try {
					tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
					tmpCon.setAutoCommit(false);
					if (inNuevoBeneficiario != null && obj.getCRPER_CODIGO() != null){
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
							outResult = new com.besixplus.sii.db.Cgg_res_persona(objNuevoBeneficiario).insert(tmpCon);
							obj.setCRPER_CODIGO(objNuevoBeneficiario.getCRPER_CODIGO());
						}
					}
					if(outResult.equals("true")){
						if(tmpRequest.trim().toUpperCase().equals("INSERT")){
							obj.setCRCOM_CODIGO("KEYGEN");
							obj.setCRCOM_USUARIO_INSERT(request.getUserPrincipal().getName());
							outResult = new com.besixplus.sii.db.Cgg_res_comunicado(obj).insert(tmpCon);
						}else{
							com.besixplus.sii.objects.Cgg_res_comunicado tmpCom = new com.besixplus.sii.objects.Cgg_res_comunicado();
							tmpCom.setCRCOM_CODIGO(obj.getCRCOM_CODIGO());
							new com.besixplus.sii.db.Cgg_res_comunicado(tmpCom).select(tmpCon);
							if(obj.getCRCOM_ADJUNTO() == null || obj.getCRCOM_ADJUNTO().length == 0){
								obj.setCRCOM_ADJUNTO(tmpCom.getCRCOM_ADJUNTO());
								obj.setCRCOM_NOMBRE_ADJUNTO(tmpCom.getCRCOM_NOMBRE_ADJUNTO());
							}
							outResult = new com.besixplus.sii.db.Cgg_res_comunicado(obj).update(tmpCon);
						}
					}
					if(outResult.equals("true")){
						tmpCon.commit();
						appResponse.setSuccess(true);
					}else{
						tmpCon.rollback();
						appResponse.setSuccess(false);
						appResponse.setMsg(outResult);
					}
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					appResponse.setSuccess(false);
					appResponse.setMsg(e.getMessage());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
				appResponse.setSuccess(false);
				appResponse.setMsg(e.getMessage());
			}

			response.setContentType("text/html");
			response.getWriter().println(new JSONObject(appResponse).toString());			
		}
	}
}
