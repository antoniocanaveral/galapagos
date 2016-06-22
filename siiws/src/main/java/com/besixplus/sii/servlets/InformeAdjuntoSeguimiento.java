package com.besixplus.sii.servlets;

import com.besixplus.sii.db.Cgg_configuracion;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.db.SQLErrorHandler;
import com.besixplus.sii.objects.Cgg_res_adjunto;
import com.besixplus.sii.objects.Cgg_res_informe_seguimiento;
import com.besixplus.sii.objects.ServerResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author BESIXPLUS CIA. LTDA.
 *
 */
public class InformeAdjuntoSeguimiento extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Inicializa la clase de InformeAdjuntoSeguimiento.
	 */
	public InformeAdjuntoSeguimiento() {}

	/**
	 * Servicio de llamada para servlet.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResultInforme = "true";
		String outResultAdjunto = "true";
		String tmpRequest = "none";		
		String operacion = null;
		String outResult = "true";
		ServerResponse appResponse= new ServerResponse();
		Cgg_res_adjunto objAdjunto = new Cgg_res_adjunto();
		Cgg_res_informe_seguimiento objInforme = new Cgg_res_informe_seguimiento();

		if(tmpIsMultipart){			
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
			appResponse.setSuccess(Boolean.parseBoolean(outResult));
			try {
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						if(item.getString().trim().length()>0){
							if(item.getFieldName().equals("inCrseg_codigo")){
								String codigoSeguimiento=item.getString(); 
								objInforme.setCRSEG_CODIGO(codigoSeguimiento);
							}													
							if(item.getFieldName().equals("inCrise_numero_informe")){								
								objInforme.setCRISE_NUMERO_INFORME(item.getString());
							}							
							if(item.getFieldName().equals("inCrise_fecha_informe")){
								DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
								Date fechaInforme = null;
								try{
									fechaInforme = df.parse(item.getString());						           						            
								} catch (ParseException e){
									e.printStackTrace();
									fechaInforme = new Date();
								}
								objInforme.setCRISE_FECHA_INFORME(fechaInforme);
							}							
							if(item.getFieldName().equals("inCrise_asunto_informe")){								
								objInforme.setCRISE_ASUNTO_INFORME(item.getString());
							}
							if(item.getFieldName().equals("inCrise_extracto_informe")){								
								objInforme.setCRISE_EXTRACTO_INFORME(item.getString());
							}						
							if(item.getFieldName().equals("inCrise_descripcion_adjunto") && item.getString()!=null){								
								String descripcionAdjunto = item.getString();
								objInforme.setCRISE_DESCRIPCION_ADJUNTO(descripcionAdjunto);
								objAdjunto.setCRADJ_OBSERVACION(descripcionAdjunto);
							}
							if(item.getFieldName().equals("inOperacion")){								
								operacion = item.getString();
							}
						}						
					} else {
						if(item.getFieldName().equals("filCradj_archivo_adjunto")){
							if(item.get().length ==0 || item.get()==null){
								objAdjunto = null;
							}else{								
								objAdjunto.setCRADJ_CODIGO("KEYGEN");							
								objAdjunto.setCRADJ_ESTADO(true);
								objAdjunto.setCRADJ_FECHA_REGISTRO(new Date());
								objAdjunto.setCRADJ_USUARIO_INSERT(request.getUserPrincipal().getName());
								objAdjunto.setCRADJ_USUARIO_UPDATE(request.getUserPrincipal().getName());														
								objAdjunto.setCRADJ_CONTENIDO("application/octet-stream");							
								objAdjunto.setCRADJ_NOMBRE_ADJUNTO(item.getName());														
								objAdjunto.setCRADJ_ARCHIVO_ADJUNTO(item.get());	
							}
						}
					}
				}
				if(objAdjunto.getCRADJ_CODIGO()==null){//Esto vino por Entrada de Alfresco
					objAdjunto.setCRADJ_CODIGO("KEYGEN");
					objAdjunto.setCRADJ_ESTADO(true);
					objAdjunto.setCRADJ_FECHA_REGISTRO(new Date());
					objAdjunto.setCRADJ_USUARIO_INSERT(request.getUserPrincipal().getName());
					objAdjunto.setCRADJ_USUARIO_UPDATE(request.getUserPrincipal().getName());
					objAdjunto.setCRADJ_CONTENIDO("alfresco/container");
				}
				tmpCon = ManagerConnection.getConnection();
				tmpCon.setAutoCommit(false);
				if(operacion.equalsIgnoreCase("insert")==true){	
					objInforme.setCRISE_CODIGO("KEYGEN");
					objInforme.setCRISE_ESTADO(true);
					objInforme.setCRISE_USUARIO_INSERT(request.getUserPrincipal().getName());
					objInforme.setCRISE_USUARIO_UPDATE(request.getUserPrincipal().getName());
					
					outResultInforme = new com.besixplus.sii.db.Cgg_res_informe_seguimiento(objInforme).insert(tmpCon);					
					if(objAdjunto != null){	
						objAdjunto.setCRSEG_CODIGO(objInforme.getCRSEG_CODIGO());
						outResultAdjunto = new com.besixplus.sii.db.Cgg_res_adjunto(objAdjunto).insert(tmpCon);
					}else{
						outResultAdjunto = "true";
					}

					if(outResultInforme.equalsIgnoreCase("true")==true && outResultAdjunto.equalsIgnoreCase("true")==true){
						tmpCon.commit();
						//Devolvemos el codigo para que se pueda gestionar en el adjunto
						outResult = "true,"+objInforme.getCRISE_CODIGO();
						appResponse.setSuccess(true);
					}else{
						tmpCon.rollback();
						outResult = "false";
						appResponse.setSuccess(false);
					}				
				}

				tmpCon.setAutoCommit(true);	
				tmpCon.close();
			} catch (FileUploadException e) {	
				SQLErrorHandler.errorHandler(e);
				outResult = e.getMessage();
			} catch (SQLException eq) {			
				SQLErrorHandler.errorHandler(eq);
				outResult = eq.getMessage();
			}catch (Exception ex) {		
				SQLErrorHandler.errorHandler(ex);
				outResult = ex.getMessage();
			}
			appResponse.setMsg(outResult);
			response.setContentType("text/html");
			response.getWriter().println(new JSONObject(appResponse).toString());
		}
	}

}
