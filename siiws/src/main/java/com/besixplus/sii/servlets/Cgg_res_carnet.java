package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import org.json.JSONObject;

//import com.besixplus.biometric.types.FingerDevice;
//import com.besixplus.enbsp.win.Lector;
import com.besixplus.sii.db.Cgg_configuracion;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.mail.Base64;
import com.besixplus.sii.objects.Cgg_res_adjunto;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.besixplus.sii.objects.Cgg_res_residencia;
import com.besixplus.sii.objects.ServerResponse;

public class Cgg_res_carnet extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1340778175;
	//private FingerDevice myLector = null;

	public Cgg_res_carnet() {
		super();
		 
		/*if(System.getProperty("os.name").contains("Windows"))
			myLector = new Lector();
		else
			myLector = new com.besixplus.enbsp.unix.Lector();*/
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		byte[] tmpComprobante = null;
		String tmpFileName = null;
		ServerResponse tmpServerResponse = new ServerResponse();
		Cgg_res_residencia tmpResidencia = new Cgg_res_residencia();
		String tmpRequest = null;
		String tmpFirText = null;
		String tmpFirAuditText = null;
		String tmpRes = null;
		String tmpFoto = null;
		String tmpFirma = null;

		tmpServerResponse.setSuccess(true);

		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_res_carnet obj = new com.besixplus.sii.objects.Cgg_res_carnet();
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
				e1.printStackTrace();
			}
			upload.setSizeMax(tmpConf.getCGCNF_VALOR_NUMERICO()*1024*1024);
			List items;
			try {
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField() && !item.getString().trim().isEmpty()) {
						if(item.getFieldName().equals("request"))
							tmpRequest = item.getString().toUpperCase();
						if(item.getFieldName().equals("txtCrcnt_codigo"))
							obj.setCRCNT_CODIGO(item.getString());
						if(item.getFieldName().equals("crcom_codigo"))
							obj.setCRCOM_CODIGO(item.getString());
						if(item.getFieldName().equals("crrsd_codigo"))
							obj.setCRRSD_CODIGO(item.getString());
						if(item.getFieldName().equals("txtCrcnt_serie"))
							obj.setCRCNT_SERIE(item.getString());
						if(item.getFieldName().equals("crcpj_codigo"))
							obj.setCRCPJ_CODIGO(item.getString());
						if(item.getFieldName().equals("crcnt_motivo"))
							obj.setCRCNT_MOTIVO(Integer.valueOf(item.getString()));
						if(item.getFieldName().equals("crcnt_fecha_aprobacion"))
							obj.setCRCNT_FECHA_APROBACION(Timestamp.valueOf(item.getString()));
						if(item.getFieldName().equals("crcnt_fecha_caducidad"))
							obj.setCRCNT_FECHA_CADUCIDAD(Timestamp.valueOf(item.getString()));
						if(item.getFieldName().equals("crcnt_fecha_deposito"))
							obj.setCRCNT_FECHA_DEPOSITO(Timestamp.valueOf(item.getString()));
						if(item.getFieldName().equals("txtCrcnt_numero_comp"))
							obj.setCRCNT_NUMERO_COMP(item.getString());
						if(item.getFieldName().equals("numCrcnt_valor"))
							obj.setCRCNT_VALOR(java.math.BigDecimal.valueOf(Double.valueOf(item.getString())));
						if(item.getFieldName().equals("chkCrcnt_carnet_impreso"))
							obj.setCRCNT_CARNET_IMPRESO(Boolean.valueOf(item.getString()));
						if(item.getFieldName().equals("txtCrcnt_observacion"))
							obj.setCRCNT_OBSERVACION(item.getString());
						if(item.getFieldName().equals("firma"))
							tmpFirma = item.getString();
						if(item.getFieldName().equals("foto"))
							tmpFoto = item.getString();
						if(item.getFieldName().equals("fir"))
							tmpFirText = item.getString();
						if(item.getFieldName().equals("firAudit"))
							tmpFirAuditText = item.getString();
					}else{
						if(item.getFieldName().equals("comp")){
							tmpComprobante = item.get();
							tmpFileName = item.getName();
						}
					}
				}
				/*if( tmpFirAuditText== null || tmpFirText == null){
					tmpServerResponse.setMsg("Falta informaci\u00f3n de la huella dactilar.");
					tmpServerResponse.setSuccess(false);
				}else*/ if(tmpFoto == null){
					tmpServerResponse.setMsg("Falta la fotograf\u00eda de la persona carnetizada.");
					tmpServerResponse.setSuccess(false);
				}else if(tmpFirma == null){
					tmpServerResponse.setMsg("Falta la firma de la persona carnetizada.");
					tmpServerResponse.setSuccess(false);
				}
				if(tmpServerResponse.isSuccess()){
					obj.setCRCNT_ESTADO(true);
					obj.setCRCNT_USUARIO_INSERT(request.getUserPrincipal().getName());
					try {
						tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
						tmpCon.setAutoCommit(false);

						Cgg_res_adjunto tmpAdjunto = new Cgg_res_adjunto();
						tmpAdjunto.setCRADJ_CODIGO("KEYGEN");
						tmpAdjunto.setCRADJ_ARCHIVO_ADJUNTO(tmpComprobante);
						tmpAdjunto.setCRADJ_NOMBRE_ADJUNTO(tmpFileName);
						tmpAdjunto.setCRADJ_FECHA_REGISTRO(new Date());
						tmpAdjunto.setCRADJ_ESTADO(true);
						tmpAdjunto.setCRADJ_USUARIO_INSERT(request.getUserPrincipal().getName());
						tmpAdjunto.setCRADJ_USUARIO_UPDATE(request.getUserPrincipal().getName());

						new com.besixplus.sii.db.Cgg_res_adjunto(tmpAdjunto).insert(tmpCon);
						if(!tmpAdjunto.getCRADJ_CODIGO().equals("KEYGEN")){
							obj.setCRADJ_CODIGO(tmpAdjunto.getCRADJ_CODIGO());
							if(tmpRequest.equals("INSERT")){
								obj.setCRCNT_FECHA_EMISION(new Date());
								obj.setCRCNT_CODIGO("KEYGEN");
								tmpRes = new com.besixplus.sii.db.Cgg_res_carnet(obj).insert(tmpCon);
							}else{
								obj.setCRCNT_USUARIO_UPDATE(request.getUserPrincipal().getName());
								tmpRes = new com.besixplus.sii.db.Cgg_res_carnet(obj).update(tmpCon);
							}
							if(tmpRes.equals("true")){

								tmpResidencia.setCRRSD_CODIGO(obj.getCRRSD_CODIGO());
								new com.besixplus.sii.db.Cgg_res_residencia(tmpResidencia).select(tmpCon);

								Cgg_res_persona tmpPersona = new Cgg_res_persona();
								tmpPersona.setCRPER_CODIGO(tmpResidencia.getCRPER_CODIGO());
								tmpPersona.setCRPER_FOTO(Base64.decode(tmpFoto));
								tmpPersona.setCRPER_FIRMA(Base64.decode(tmpFirma));
								tmpPersona.setCRPER_HUELLA_DACTILAR(tmpFirText!=null?tmpFirText:null);
								tmpPersona.setCRPER_HUELLA_CADENA(tmpFirAuditText!=null?tmpFirAuditText:null);
								//tmpPersona.setCRPER_HUELLA_IMAGEN(tmpFirAuditText!=null?myLector.getImage(myLector.getExportAuditData(tmpFirAuditText)):null);
								//tmpPersona.setCRPER_HUELLA_IMAGEN(null);
								if(tmpFoto != null)
									tmpRes = new com.besixplus.sii.db.Cgg_res_persona(tmpPersona).updateFoto(tmpCon);
								if(tmpFirma != null)
									tmpRes = new com.besixplus.sii.db.Cgg_res_persona(tmpPersona).updateFirma(tmpCon);
								if(tmpFirText != null)
									tmpRes = new com.besixplus.sii.db.Cgg_res_persona(tmpPersona).updateHuellaImagen(tmpCon);
							}
						}
						if(tmpRes.equals("true")){
							if(!tmpCon.isClosed()){
								tmpCon.commit();
								tmpCon.setAutoCommit(true);
							}
						}else{
							if(!tmpCon.isClosed())
								tmpCon.rollback();
							tmpServerResponse.setMsg(tmpRes);
							tmpServerResponse.setSuccess(false);
						}
						if(!tmpCon.isClosed())
							tmpCon.close();
					} catch (SQLException e) {
						com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
						tmpServerResponse.setSuccess(false);
					}	
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
				tmpServerResponse.setSuccess(false);
			}
			response.setContentType("text/html");
			response.getWriter().write(new JSONObject(tmpServerResponse).toString());
		}
	}

	@Override
	public void destroy() {
		//myLector.terminate();
		super.destroy();
	}
}
