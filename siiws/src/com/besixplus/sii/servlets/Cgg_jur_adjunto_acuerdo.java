package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Cgg_jur_adjunto_acuerdo extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1395225470;

	public Cgg_jur_adjunto_acuerdo() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpRequest = null;
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo obj = new com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo();
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
						if(item.getFieldName().equals("cjada_codigo") )
							obj.setCJADA_CODIGO(item.getString());
						if(item.getFieldName().equals("cjacu_codigo") && item.getString().trim().length() > 0)
							obj.setCJACU_CODIGO(item.getString());
						if(item.getFieldName().equals("cjada_descripcion") )
							obj.setCJADA_DESCRIPCION(item.getString());
						if(item.getFieldName().equals("cjada_nombre_adjunto") )
							obj.setCJADA_NOMBRE_ADJUNTO(item.getString());
					} else {
if(item.getFieldName().equals("cjada_adjunto"))
obj.setCJADA_ADJUNTO(item.get());
					}
				}
				obj.setCJADA_ESTADO(true);
				obj.setCJADA_USUARIO_INSERT(request.getUserPrincipal().getName());
				obj.setCJADA_USUARIO_UPDATE(request.getUserPrincipal().getName());
				Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				if(tmpRequest.trim().toUpperCase().equals("INSERT")){
					obj.setCJADA_CODIGO("KEYGEN");
					outResult = new com.besixplus.sii.db.Cgg_jur_adjunto_acuerdo(obj).insert(tmpCon);
				}else
					outResult = new com.besixplus.sii.db.Cgg_jur_adjunto_acuerdo(obj).update(tmpCon);
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
		}else{
String tmpCodigo = request.getParameter("codigo");
String tmpColumna = request.getParameter("columna");
if(tmpCodigo != null){
com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo obj = null;
obj = new com.besixplus.sii.objects.Cgg_jur_adjunto_acuerdo();
obj.setCJADA_CODIGO(tmpCodigo);
Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
try{
tmpCon.setAutoCommit(!com.besixplus.sii.db.ManagerConnection.isDeployed());
new com.besixplus.sii.db.Cgg_jur_adjunto_acuerdo(obj).select(tmpCon);
tmpCon.close();
} catch (SQLException e) {
com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
}
ServletOutputStream out = response.getOutputStream();
if(tmpColumna.toUpperCase().equals("CJADA_ADJUNTO")){
out.write(obj.getCJADA_ADJUNTO());
}
response.setHeader("Content-Disposition","inline; filename="+obj.getCJADA_NOMBRE_ADJUNTO()+";");
response.setContentType("application/"+obj.getCJADA_NOMBRE_ADJUNTO().substring(obj.getCJADA_NOMBRE_ADJUNTO().lastIndexOf(".")+1));
out.flush();
out.close();
}
		}
	}
}
