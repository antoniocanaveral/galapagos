package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
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

import com.besixplus.sii.misc.CGGEnumerators.LONGITUDCLAVEPRIMARIA;

/**
 * Clase para el manejo de informacion de la tabla Cgg_jur_seguimiento_criterio. 
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_jur_seguimiento_criterio extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1994219857;
	private String nombreAdjunto = "";
	private byte[] contenidoAdjunto = null;
	
	/**
	 * Constructor publico vacio.
	 */
	public Cgg_jur_seguimiento_criterio() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "false";
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio obj = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
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
						if(item.getFieldName().equals("inCjsgc_codigo")){
							obj.setCJSGC_CODIGO(item.getString());
						}																											
					} else {
						if(item.getFieldName().equals("filCjsgc_archivo_adjunto")){
							nombreAdjunto=item.getName();
							contenidoAdjunto = item.get();
						}
					}
				}
				
				Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				tmpCon.setAutoCommit(false);
				obj = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(obj).select(tmpCon);
				
				if(obj.getCJSGC_CODIGO()!= null &&
						obj.getCJSGC_CODIGO().trim().length() >= LONGITUDCLAVEPRIMARIA.MINIMO.getValue() &&
						obj.getCJSGC_CODIGO().trim().length() <= LONGITUDCLAVEPRIMARIA.MAXIMO.getValue()){
															
					obj.setCJSGC_USUARIO_UPDATE(request.getUserPrincipal().getName());	
					obj.setCJSGC_NOMBRE_ADJUNTO(nombreAdjunto);
					obj.setCJSGC_ADJUNTO(contenidoAdjunto);
					
					outResult = new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(obj).update(tmpCon);
					
					try {
						tmpCon.commit();
						outResult ="true";
					} catch (SQLException e) {
						com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
						outResult = "false";
					}
				}else{
					outResult = "false";
				}				
				tmpCon.setAutoCommit(true);
				tmpCon.close();
				
			}catch(SQLException ex){
				ex.printStackTrace();
				outResult = "false";
			}catch (FileUploadException e) {
				e.printStackTrace();
				outResult = "false";
			}
			
			response.setContentType("text/html");
			response.getWriter().println(outResult);
			
		}else{
			String tmpCodigo = request.getParameter("codigo");
			String tmpColumna = request.getParameter("columna");
			if(tmpCodigo != null){
				com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio obj = null;
				obj = new com.besixplus.sii.objects.Cgg_jur_seguimiento_criterio();
				obj.setCJSGC_CODIGO(tmpCodigo);
				Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				try{
					tmpCon.setAutoCommit(!com.besixplus.sii.db.ManagerConnection.isDeployed());
					new com.besixplus.sii.db.Cgg_jur_seguimiento_criterio(obj).select(tmpCon);
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				}
				ServletOutputStream out = response.getOutputStream();
				if(tmpColumna.toUpperCase().equals("CJSGC_ADJUNTO")){					
					response.setHeader("cache-control", "no-cache");									
					response.setHeader("Content-Disposition", "attachment;filename=\"" + obj.getCJSGC_NOMBRE_ADJUNTO()+ "\"");			
					response.setContentType("application/"+obj.getCJSGC_NOMBRE_ADJUNTO().substring(obj.getCJSGC_NOMBRE_ADJUNTO().lastIndexOf(".")+1));					
					out.write(obj.getCJSGC_ADJUNTO());																												
				}	
				out.flush();
				out.close();
			}
		}
	}
}
