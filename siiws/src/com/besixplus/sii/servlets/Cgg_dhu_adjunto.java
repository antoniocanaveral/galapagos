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

import com.besixplus.sii.db.Cgg_configuracion;
import com.besixplus.sii.db.ManagerConnection;

public class Cgg_dhu_adjunto extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1110408022;

	public Cgg_dhu_adjunto() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpRequest = "none";
		//boolean outResult = true;
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_dhu_adjunto obj = new com.besixplus.sii.objects.Cgg_dhu_adjunto();
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
					//System.out.println("Item name: "+item.getFieldName());
					//System.out.println("Item string: "+item.getString());
					if (item.isFormField()) {
						if(item.getFieldName().equals("cdad_codigo"))
							obj.setCDAD_CODIGO(item.getString());
						if(item.getString().trim().length()>0){
						if(item.getFieldName().equals("cdbec_codigo")){
							obj.setCDBEC_CODIGO(item.getString());
						}}
						if(item.getFieldName().equals("cdad_descripcion")){
							obj.setCDAD_DESCRIPCION(item.getString());
						}
						if(item.getFieldName().equals("cdad_observacion")){
							obj.setCDAD_OBSERVACION(item.getString());
						}
						if(item.getFieldName().equals("cdad_nombre_adjunto")){
							obj.setCDAD_NOMBRE_ADJUNTO(item.getString());
						}
						if(item.getFieldName().equals("cdad_descripcion_contenido")){
							obj.setCDAD_DESCRIPCION_CONTENIDO(item.getString());
						}
						if(item.getFieldName().equals("cbxCdhu_tipo_adjuntoH")){
							obj.setCDAD_TIPO(Integer.valueOf(item.getString()));
							
						}if(item.getFieldName().equals("request"))
							tmpRequest = item.getString();
					}else {

						if(item.getFieldName().equals("filCdad_adjunto")){
							obj.setCDAD_NOMBRE_ADJUNTO(item.getName());
							obj.setCDAD_ADJUNTO(item.get());
						}
					}
				}
				obj.setCDAD_ESTADO(true);
				obj.setCDAD_USUARIO_INSERT(request.getUserPrincipal().getName());
				obj.setCDAD_USUARIO_UPDATE(request.getUserPrincipal().getName());
				tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				if(tmpRequest.trim().toUpperCase().equals("INSERT"))
				{
					obj.setCDAD_CODIGO("KEYGEN");
					outResult = new com.besixplus.sii.db.Cgg_dhu_adjunto(obj).insert(tmpCon);
				
				}else{
					outResult = new com.besixplus.sii.db.Cgg_dhu_adjunto(obj).update(tmpCon);
				}
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
		}
	}	
}
