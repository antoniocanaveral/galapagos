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
import org.json.JSONObject;

import com.besixplus.sii.db.Cgg_configuracion;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.ServerResponse;
import com.google.gson.Gson;

/**
 * Clase para el subido a de archivos a la tabla Cgg_res_adjunto_temporal. 
 * @author BESIXPLUS CIA. LTDA. 
 */
public class Cgg_res_adjunto_temporal extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 667237620;

	/**
	 * Constructor vacio.
	 */
	public Cgg_res_adjunto_temporal() {
		super();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpRequest = "none";
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_res_adjunto_temporal obj = new com.besixplus.sii.objects.Cgg_res_adjunto_temporal();
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
						if(item.getFieldName().equals("inCjsgc_codigo")){
							obj.setCRATE_CODIGO(item.getString());
						}												
					} else {
						if(item.getFieldName().equals("filCrate_archivo")){
							obj.setCRATE_NOMBRE(item.getName());
							obj.setCRATE_ARCHIVO(item.get());
							obj.setCRATE_TIPO_CONTENIDO("application/octet-stream");
						}
					}
				}
				obj.setCRATE_ESTADO(true);
				obj.setCRATE_USUARIO_INSERT(request.getUserPrincipal().getName());
				obj.setCRATE_USUARIO_UPDATE(request.getUserPrincipal().getName());
				tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
								
				outResult = new com.besixplus.sii.db.Cgg_res_adjunto_temporal(obj).insert(tmpCon);
				if(outResult.equalsIgnoreCase("true")){
					outResult = obj.getCRATE_CODIGO();
				}else{
					outResult = "false";
				}
				
				try {
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
					outResult = e.getMessage();
				}	
			} catch (FileUploadException e) {
				response.sendError(HttpServletResponse.SC_LENGTH_REQUIRED, e.getLocalizedMessage());
				outResult = e.getMessage();
			}			
			
			obj.setCRATE_ARCHIVO(null);
			
			ServerResponse objReply = new ServerResponse();
			objReply.setSuccess(true);
			objReply.setMsg(new JSONObject(obj).toString());						
			
			response.setContentType("text/html");
			response.getWriter().println(new Gson().toJson(objReply));
		}
	}
}
