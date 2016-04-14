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
import org.json.JSONObject;

import com.besixplus.sii.db.Cgg_configuracion;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.ServerResponse;

public class Cgg_gem_preregistroEmpresa_actualizarAdjunto extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1429495450;

	public Cgg_gem_preregistroEmpresa_actualizarAdjunto() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpRequest = null;
		ServerResponse appResponse= new ServerResponse();
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_gem_preregistro_empresa obj = new com.besixplus.sii.objects.Cgg_gem_preregistro_empresa();
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
			
			//upload.setSizeMax(10485760);
			List items;
			try {
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						if(item.getFieldName().equals("request"))
							tmpRequest = item.getString();
						if(item.getFieldName().equals("cgpre_codigo") )
							obj.setCGPRE_CODIGO(item.getString());						
						if(item.getFieldName().equals("cgpre_tipo_adjunto") )
							obj.setCGPRE_TIPO_ADJUNTO(item.getString());
						if(item.getFieldName().equals("cgpre_nombre_adjunto") )
							obj.setCGPRE_NOMBRE_ADJUNTO(item.getString());
					} else {
						if(item.getFieldName().equals("cgpre_adjunto"))
							obj.setCGPRE_ADJUNTO(item.get());
					}
				}
				obj.setCGPRE_ESTADO(true);				
				tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				if(tmpRequest.trim().toUpperCase().equals("INSERT")){
					obj.setCGPRE_CODIGO("KEYGEN");
					if (request.getUserPrincipal()!=null)
						obj.setCGPRE_USUARIO_INSERT(request.getUserPrincipal().getName());
					else
						obj.setCGPRE_USUARIO_INSERT("");
					outResult = new com.besixplus.sii.db.Cgg_gem_preregistro_empresa(obj).insert(tmpCon);
				}else{
					if (request.getUserPrincipal()!=null)
						obj.setCGPRE_USUARIO_UPDATE(request.getUserPrincipal().getName());
					else
						obj.setCGPRE_USUARIO_UPDATE("");
					outResult = new com.besixplus.sii.db.Cgg_gem_preregistro_empresa(obj).updateAdjunto(tmpCon);
				}
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
			//response.getWriter().println(outResult);
			appResponse.setSuccess(Boolean.parseBoolean(outResult));
			appResponse.setMsg(outResult);
			response.setContentType("text/html");
			response.getWriter().println(new JSONObject(appResponse).toString());
		}else{
			String tmpCodigo = request.getParameter("codigo");
			String tmpColumna = request.getParameter("columna");
			if(tmpCodigo != null){
				com.besixplus.sii.objects.Cgg_gem_preregistro_empresa obj = null;
				obj = new com.besixplus.sii.objects.Cgg_gem_preregistro_empresa();
				obj.setCGPRE_CODIGO(tmpCodigo);
				Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				try{
					tmpCon.setAutoCommit(!com.besixplus.sii.db.ManagerConnection.isDeployed());
					new com.besixplus.sii.db.Cgg_gem_preregistro_empresa(obj).select(tmpCon);
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				}
				ServletOutputStream out = response.getOutputStream();
				if(tmpColumna.toUpperCase().equals("CGPRE_ADJUNTO")){
					out.write(obj.getCGPRE_ADJUNTO());
				}
				response.setHeader("Content-Disposition","inline; filename="+obj.getCGPRE_NOMBRE_ADJUNTO()+";");
				response.setContentType("application/"+obj.getCGPRE_NOMBRE_ADJUNTO().substring(obj.getCGPRE_NOMBRE_ADJUNTO().lastIndexOf(".")+1));
				out.flush();
				out.close();
			}
		}
	}
}
