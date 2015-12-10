package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
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

public class Cgg_res_info_adjunto extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1110408022;

	public Cgg_res_info_adjunto() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_res_adjunto objAdjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();						
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(10485760);
			List items;
			try {
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						if(item.getFieldName().equals("inCrseg_codigo")){								
							objAdjunto.setCRSEG_CODIGO(item.getString());															
						}							
					} else {
						if(item.getFieldName().equals("inAdjuntoSeguimiento")){
							objAdjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
							objAdjunto.setCRADJ_NOMBRE_ADJUNTO(item.getName());														
							objAdjunto.setCRADJ_ARCHIVO_ADJUNTO(item.get());
						}
					}
				}
				objAdjunto.setCRADJ_CODIGO("KEYGEN");
				objAdjunto.setCRADJ_ESTADO(true);
				
				objAdjunto.setCRADJ_USUARIO_INSERT(request.getUserPrincipal().getName());
				objAdjunto.setCRADJ_USUARIO_UPDATE(request.getUserPrincipal().getName());
				Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();	
				outResult = new com.besixplus.sii.db.Cgg_res_adjunto(objAdjunto).insert(tmpCon);
				if(!outResult.equals("true"))
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, outResult);
				try {
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
					outResult = e.getMessage();
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
				outResult = e.getMessage();
			}
			response.getWriter().println(outResult);
		}else{
			
		}
	}
}
