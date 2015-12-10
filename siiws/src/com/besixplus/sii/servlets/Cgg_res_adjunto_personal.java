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

public class Cgg_res_adjunto_personal extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 183739615;

	public Cgg_res_adjunto_personal() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		boolean outResult = true;
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_res_adjunto_personal obj = new com.besixplus.sii.objects.Cgg_res_adjunto_personal();
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
						if(item.getFieldName().equals("crper_codigo")){
							obj.setCRPER_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("cradp_fecha_registro")){
							obj.setCRADP_FECHA_REGISTRO(Timestamp.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("cradp_descripcion")){
							obj.setCRADP_DESCRIPCION(item.getString());
						}
						if(item.getFieldName().equals("cradp_nombre_adjunto")){
							obj.setCRADP_NOMBRE_ADJUNTO(item.getString());
						}
					} else {
						if(item.getFieldName().equals("cradp_adjunto")){
							obj.setCRADP_NOMBRE_ADJUNTO(item.getName());
							obj.setCRADP_ADJUNTO(item.get());
						}
					}
				}
				obj.setCRADP_CODIGO("KEYGEN");
				obj.setCRADP_ESTADO(true);
				obj.setCRADP_USUARIO_INSERT(request.getUserPrincipal().getName());
				obj.setCRADP_USUARIO_UPDATE(request.getUserPrincipal().getName());
				tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				outResult = new com.besixplus.sii.db.Cgg_res_adjunto_personal(obj).insert(tmpCon);
				try {
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					outResult = false;
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
				outResult = false;
			}
			response.getWriter().println(Boolean.toString(outResult));
		}else{
			String tmpCodigo = request.getParameter("codigo");
			String tmpColumna = request.getParameter("columna");
			if(tmpCodigo != null){
				com.besixplus.sii.objects.Cgg_res_adjunto_personal obj = null;
				obj = new com.besixplus.sii.objects.Cgg_res_adjunto_personal();
				obj.setCRADP_CODIGO(tmpCodigo);
				Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				try{
					tmpCon.setAutoCommit(!com.besixplus.sii.db.ManagerConnection.isDeployed());
					new com.besixplus.sii.db.Cgg_res_adjunto_personal(obj).select(tmpCon);
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				}
				ServletOutputStream out = response.getOutputStream();
				if(tmpColumna.toUpperCase().equals("CRADP_ADJUNTO")){
					out.write(obj.getCRADP_ADJUNTO());
				}
				response.setHeader("Content-Disposition","inline; filename="+obj.getCRADP_NOMBRE_ADJUNTO()+";");
				response.setContentType("application/"+obj.getCRADP_NOMBRE_ADJUNTO().substring(obj.getCRADP_NOMBRE_ADJUNTO().lastIndexOf(".")+1));
				out.flush();
				out.close();
			}
		}
	}
}
