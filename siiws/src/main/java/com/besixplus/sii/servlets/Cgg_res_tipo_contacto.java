package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.besixplus.sii.db.Cgg_configuracion;
import com.besixplus.sii.db.ManagerConnection;

public class Cgg_res_tipo_contacto extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 161780208;

	public Cgg_res_tipo_contacto() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_res_tipo_contacto obj = new com.besixplus.sii.objects.Cgg_res_tipo_contacto();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			//
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
			//
			List items;
			String tmpRequest = "none";
			try {
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						if(item.getFieldName().equals("txtCrtco_nombre")){
							obj.setCRTCO_NOMBRE(item.getString());
						}
						if(item.getFieldName().equals("txtCrtco_nombre_imagen")){
							obj.setCRTCO_NOMBRE_IMAGEN(item.getString());
						}
						
						if(item.getFieldName().equals("request"))
							tmpRequest = item.getString();
						
						if(item.getFieldName().equals("txtCrtco_codigo"))
						{
							obj.setCRTCO_CODIGO(item.getString());
						}
					} else {
						if(item.getFieldName().equals("filCrtco_imagen")){
							//obj.setCRTCO_NOMBRE_IMAGEN(item.getName());
							obj.setCRTCO_IMAGEN(item.get());
						}
					}
				}
			
				obj.setCRTCO_ESTADO(true);
				obj.setCRTCO_USUARIO_INSERT(request.getUserPrincipal().getName());
				obj.setCRTCO_USUARIO_UPDATE(request.getUserPrincipal().getName());
				tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				if(tmpRequest.trim().toUpperCase().equals("INSERT")){
					obj.setCRTCO_CODIGO("KEYGEN");
					outResult = new com.besixplus.sii.db.Cgg_res_tipo_contacto(obj).insert(tmpCon);
				}else
					outResult = new com.besixplus.sii.db.Cgg_res_tipo_contacto(obj).update(tmpCon);
				try {
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					outResult = "false";
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
				//outResult = "false";
				outResult = e.getMessage();
				response.sendError(HttpServletResponse.SC_LENGTH_REQUIRED,"El archivo a almacenar es demasiado grande");
				return ;
			}
			response.getWriter().println(outResult);
		}else{
			String tmpCodigo = request.getParameter("codigo");
			String tmpColumna = request.getParameter("columna");
			if(tmpCodigo != null){
				com.besixplus.sii.objects.Cgg_res_tipo_contacto obj = null;
				obj = new com.besixplus.sii.objects.Cgg_res_tipo_contacto();
				obj.setCRTCO_CODIGO(tmpCodigo);
				Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				try{
					tmpCon.setAutoCommit(!com.besixplus.sii.db.ManagerConnection.isDeployed());
					new com.besixplus.sii.db.Cgg_res_tipo_contacto(obj).select(tmpCon);
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				}
				ServletOutputStream out = response.getOutputStream();
				if(tmpColumna.toUpperCase().equals("CRTCO_IMAGEN")){
					out.write(obj.getCRTCO_IMAGEN());
				}
				out.flush();
				out.close();
			}
		}
	}
}
