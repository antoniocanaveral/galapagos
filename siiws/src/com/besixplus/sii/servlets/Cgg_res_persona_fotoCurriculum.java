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

public class Cgg_res_persona_fotoCurriculum extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 481057369;

	public Cgg_res_persona_fotoCurriculum() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpRequest = null;
		ServerResponse appResponse= new ServerResponse();
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_res_persona obj = new com.besixplus.sii.objects.Cgg_res_persona();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
					
			com.besixplus.sii.objects.Cgg_configuracion tmpConf = new com.besixplus.sii.objects.Cgg_configuracion();
			tmpConf.setCGCNF_CODIGO("CONF39");
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
			
			
			//10485760
			//upload.setSizeMax(2621440);
			List items;
			String valorMsg = "";
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
						if(item.getFieldName().equals("cprr_codigo") )
							obj.setCPRR_CODIGO(item.getString());
						if(item.getFieldName().equals("cctn_codigo") )
							obj.setCCTN_CODIGO(item.getString());
						if(item.getFieldName().equals("cgg_cpais_codigo") )
							obj.setCGG_CPAIS_CODIGO(item.getString());
						if(item.getFieldName().equals("crper_empleado") )
							obj.setCRPER_EMPLEADO(Boolean.valueOf(item.getString()));
						
					} else {
						if(item.getFieldName().equals("crper_foto_curriculum") && item.get().length > 0)
							obj.setCRPER_FOTO_CURRICULUM(item.get());
					}
				}
				obj.setCRPER_ESTADO(true);
				
				tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				if(tmpRequest.trim().toUpperCase().equals("INSERT")){
					obj.setCRPER_CODIGO("KEYGEN");
					obj.setCRPER_USUARIO_INSERT(request.getUserPrincipal().getName());
					outResult = new com.besixplus.sii.db.Cgg_res_persona(obj).insert(tmpCon);
				}else{
					obj.setCRPER_USUARIO_UPDATE(request.getUserPrincipal().getName());
					outResult = new com.besixplus.sii.db.Cgg_res_persona(obj).updateFotoCurriculum(tmpCon);
				}
				try {
					tmpCon.close();
					valorMsg = "Los datos fueron almacenado correctamente";
				} catch (SQLException e) {
					outResult = "false";
					valorMsg = "No se pudo almacenar los datos correctamente";
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					//response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());					
				}	
			} catch (FileUploadException e) {
				
				e.printStackTrace();	
				outResult = "false";
				valorMsg = "El adjunto a sobrepasado el limite de tamanio permitido de "+tmpConf.getCGCNF_VALOR_NUMERICO()+"Mb";			
				//response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());				
			}
			appResponse.setSuccess(Boolean.parseBoolean(outResult));
			appResponse.setMsg(valorMsg);
			response.setContentType("text/html");
			response.getWriter().println(new JSONObject(appResponse).toString());
			/*if (outResult == "true"){
				response.getWriter().println("<a href='https://localhost:8443/siicgg_web/hojaVida.jsp'>Atras</a>");
			}*/
			//response.getWriter().println(outResult);
		}
	}
}
