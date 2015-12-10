package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
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

import com.besixplus.sii.db.Cgg_configuracion;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.ServerResponse;

public class Cgg_res_adjunto extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 667237620;

	public Cgg_res_adjunto() {
		super();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpRequest = "none";
		ServerResponse appResponser = new ServerResponse();
		boolean isEdit = false;
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_res_adjunto obj = new com.besixplus.sii.objects.Cgg_res_adjunto();
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
						if(item.getFieldName().equals("inCradj_codigo"))
							obj.setCRADJ_CODIGO(item.getString());
						if(item.getFieldName().equals("crper_codigo"))
							obj.setCRPER_CODIGO(item.getString());
						if(item.getFieldName().equals("txtCradj_observacion"))
							obj.setCRADJ_OBSERVACION(item.getString());																		
						if(item.getFieldName().equals("inCrrqt_codigo"))
							obj.setCRRQT_CODIGO(item.getString());
						if(item.getFieldName().equals("inCrseg_codigo"))
							obj.setCRSEG_CODIGO(item.getString());
						if(item.getFieldName().equals("inCrinf_codigo"))
							obj.setCRINF_CODIGO(item.getString());
					} else {
						if(item.getFieldName().equals("filCradj_archivo_adjunto")&& item.get().length > 0){
							obj.setCRADJ_NOMBRE_ADJUNTO(item.getName());
							obj.setCRADJ_ARCHIVO_ADJUNTO(item.get());
							obj.setCRADJ_CONTENIDO("application/octet-stream");
							isEdit =  true;
						}						
					}
				}
				
				tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				if(obj.getCRADJ_CODIGO().trim().toUpperCase().equals("KEYGEN")){
					obj.setCRADJ_ESTADO(true);
					obj.setCRADJ_FECHA_REGISTRO(new Date());
					obj.setCRADJ_USUARIO_INSERT(request.getUserPrincipal().getName());
					obj.setCRADJ_USUARIO_UPDATE(request.getUserPrincipal().getName());
					
					outResult = new com.besixplus.sii.db.Cgg_res_adjunto(obj).insert(tmpCon);
					appResponser.setSuccess(true);
					
				}else{
					if(isEdit)
					{
						obj.setCRADJ_USUARIO_UPDATE(request.getUserPrincipal().getName());
						obj.setCRADJ_FECHA_REGISTRO(new Date());
						outResult = new com.besixplus.sii.db.Cgg_res_adjunto(obj).update(tmpCon);									
						appResponser.setSuccess(false);
					}
				}
				
				try {
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					//response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
					outResult = e.getMessage();
					appResponser.setSuccess(false);
				}	
				appResponser.setMsg(outResult);
				
			} catch (FileUploadException e) {
				//response.sendError(HttpServletResponse.SC_LENGTH_REQUIRED, e.getLocalizedMessage());
				outResult = e.getMessage();
				appResponser.setSuccess(false);
				appResponser.setMsg(outResult);
			}
			appResponser.setSuccess(true);
			response.setContentType("text/html");
			
			response.getWriter().println(new JSONObject(appResponser).toString());
		}
	}
}
