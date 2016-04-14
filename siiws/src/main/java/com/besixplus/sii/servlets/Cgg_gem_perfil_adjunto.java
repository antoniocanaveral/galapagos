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

public class Cgg_gem_perfil_adjunto extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 881573782;

	public Cgg_gem_perfil_adjunto() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpRequest = null;
		ServerResponse appResponse= new ServerResponse();
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_gem_perfil_adjunto obj = new com.besixplus.sii.objects.Cgg_gem_perfil_adjunto();
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
			String cadenaMsg = "";
			try {
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						if(item.getFieldName().equals("request"))
							tmpRequest = item.getString();
						if(item.getFieldName().equals("cgpfa_codigo") )
							obj.setCGPFA_CODIGO(item.getString());
						if(item.getFieldName().equals("crper_codigo") && item.getString().trim().length() > 0)
							obj.setCRPER_CODIGO(item.getString());
						if(item.getFieldName().equals("cgpfa_descripcion") )
							obj.setCGPFA_DESCRIPCION(item.getString());
						if(item.getFieldName().equals("cgpfa_nombre_adjunto") )
							obj.setCGPFA_NOMBRE_ADJUNTO(item.getString());
						if(item.getFieldName().equals("cgpfa_tipo_adjunto") )
							obj.setCGPFA_TIPO_ADJUNTO(item.getString());
						if(item.getFieldName().equals("cgpfa_tipo") )
							obj.setCGPFA_TIPO(Integer.valueOf(item.getString()));
					} else {
						if(item.getFieldName().equals("cgpfa_adjunto"))
						obj.setCGPFA_ADJUNTO(item.get());
					}
				}
				obj.setCGPFA_ESTADO(true);
				
				
				tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				if(tmpRequest.trim().toUpperCase().equals("INSERT")){
					obj.setCGPFA_CODIGO("KEYGEN");
					obj.setCGPFA_USUARIO_INSERT(request.getUserPrincipal().getName());
					outResult = new com.besixplus.sii.db.Cgg_gem_perfil_adjunto(obj).insert(tmpCon);
				}else
				{
					obj.setCGPFA_USUARIO_UPDATE(request.getUserPrincipal().getName());
					outResult = new com.besixplus.sii.db.Cgg_gem_perfil_adjunto(obj).update(tmpCon);
				}
				try {
					tmpCon.close();
					cadenaMsg = "Datos almacenados correctamente";
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					//response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
					outResult = "false";
					cadenaMsg = "No se pudo almacenar los datos";					
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
				//response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
				outResult = "false";
				cadenaMsg="El adjunto a sobrepasado el limite de tamanio permitido de 10Mb";
			}
			appResponse.setSuccess(Boolean.parseBoolean(outResult));
			appResponse.setMsg(cadenaMsg);
			response.setContentType("text/html");
			response.getWriter().println(new JSONObject(appResponse).toString());
		}else{
			String tmpCodigo = request.getParameter("codigo");
			String tmpColumna = request.getParameter("columna");
			if(tmpCodigo != null){
				com.besixplus.sii.objects.Cgg_gem_perfil_adjunto obj = null;
				obj = new com.besixplus.sii.objects.Cgg_gem_perfil_adjunto();
				obj.setCGPFA_CODIGO(tmpCodigo);
				Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				try{
					tmpCon.setAutoCommit(!com.besixplus.sii.db.ManagerConnection.isDeployed());
					new com.besixplus.sii.db.Cgg_gem_perfil_adjunto(obj).select(tmpCon);
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				}
				ServletOutputStream out = response.getOutputStream();
				if(tmpColumna.toUpperCase().equals("CGPFA_ADJUNTO")){
					out.write(obj.getCGPFA_ADJUNTO());
				}
				response.setHeader("Content-Disposition","inline; filename="+obj.getCGPFA_NOMBRE_ADJUNTO()+";");
				response.setContentType("application/"+obj.getCGPFA_NOMBRE_ADJUNTO().substring(obj.getCGPFA_NOMBRE_ADJUNTO().lastIndexOf(".")+1));
				out.flush();
				out.close();
			}
		}
	}
}
