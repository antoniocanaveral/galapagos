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

public class Cgg_res_persona extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 481057369;

	public Cgg_res_persona() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpRequest = null;
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_res_persona obj = new com.besixplus.sii.objects.Cgg_res_persona();
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
						if(item.getFieldName().equals("request"))
							tmpRequest = item.getString();
						if(item.getFieldName().equals("crper_codigo") )
							obj.setCRPER_CODIGO(item.getString());
					} else {
						if(item.getFieldName().equals("crper_foto") && item.get().length > 0)
							obj.setCRPER_FOTO(item.get());
						if(item.getFieldName().equals("crper_foto_curriculum") && item.get().length > 0)
							obj.setCRPER_FOTO_CURRICULUM(item.get());
						if(item.getFieldName().equals("crper_huella_dactilar") && item.get().length > 0)
							obj.setCRPER_HUELLA_DACTILAR(item.getString());
						if(item.getFieldName().equals("crper_firma") && item.get().length > 0)
							obj.setCRPER_FIRMA(item.get());
					}
				}
				obj.setCRPER_ESTADO(true);
				obj.setCRPER_USUARIO_INSERT(request.getUserPrincipal().getName());
				Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				if(tmpRequest.trim().toUpperCase().equals("INSERT")){
					obj.setCRPER_CODIGO("KEYGEN");
					outResult = new com.besixplus.sii.db.Cgg_res_persona(obj).insert(tmpCon);
				}else
					obj.setCRPER_USUARIO_UPDATE(request.getUserPrincipal().getName());
					outResult = new com.besixplus.sii.db.Cgg_res_persona(obj).update(tmpCon);
				try {
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
					outResult = "false";
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
				outResult = "false";
			}
			response.getWriter().println(outResult);
		}
	}
}
