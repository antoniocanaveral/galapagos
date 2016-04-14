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

public class Cgg_dhu_sadjunto extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 557459077;

	public Cgg_dhu_sadjunto() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_dhu_sadjunto obj = new com.besixplus.sii.objects.Cgg_dhu_sadjunto();
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
						if(item.getFieldName().equals("cdacd_codigo")){
							obj.setCDACD_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("cdbcr_codigo")){
							obj.setCDBCR_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("cdsad_fecha_registro")){
							obj.setCDSAD_FECHA_REGISTRO(Timestamp.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("cdsad_nombre_adjunto")){
							obj.setCDSAD_NOMBRE_ADJUNTO(item.getString());
						}
						if(item.getFieldName().equals("cdsad_observacion")){
							obj.setCDSAD_OBSERVACION(item.getString());
						}
					} else {
if(item.getFieldName().equals("cdsad_adjunto")){
obj.setCDSAD_NOMBRE_ADJUNTO(item.getName());
obj.setCDSAD_ADJUNTO(item.get());
}
					}
				}
				obj.setCDSAD_CODIGO("KEYGEN");
				obj.setCDSAD_ESTADO(true);
				obj.setCDSAD_USUARIO_INSERT(request.getUserPrincipal().getName());
				obj.setCDSAD_USUARIO_UPDATE(request.getUserPrincipal().getName());
				Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				outResult = new com.besixplus.sii.db.Cgg_dhu_sadjunto(obj).insert(tmpCon);
				try {
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					outResult = "false";
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
				outResult = "false";
			}
			response.getWriter().println(outResult);
		}else{
String tmpCodigo = request.getParameter("codigo");
String tmpColumna = request.getParameter("columna");
if(tmpCodigo != null){
com.besixplus.sii.objects.Cgg_dhu_sadjunto obj = null;
obj = new com.besixplus.sii.objects.Cgg_dhu_sadjunto();
obj.setCDSAD_CODIGO(tmpCodigo);
Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
try{
tmpCon.setAutoCommit(!com.besixplus.sii.db.ManagerConnection.isDeployed());
new com.besixplus.sii.db.Cgg_dhu_sadjunto(obj).select(tmpCon);
tmpCon.close();
} catch (SQLException e) {
com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
}
ServletOutputStream out = response.getOutputStream();
if(tmpColumna.toUpperCase().equals("CDSAD_ADJUNTO")){
out.write(obj.getCDSAD_ADJUNTO());
}
response.setHeader("Content-Disposition","inline; filename="+obj.getCDSAD_NOMBRE_ADJUNTO()+";");
response.setContentType("application/"+obj.getCDSAD_NOMBRE_ADJUNTO().substring(obj.getCDSAD_NOMBRE_ADJUNTO().lastIndexOf(".")+1));
out.flush();
out.close();
}
		}
	}
}
