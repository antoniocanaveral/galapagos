package com.besixplus.sii.servlets;

import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;
import org.json.JSONObject;

import com.besixplus.sii.db.Cgg_operacion_validacion;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_regla_validacion;
import com.besixplus.sii.objects.Cgg_regla_validacion_metadatos;
import com.besixplus.sii.objects.Cgg_res_adjunto;
import com.besixplus.sii.objects.OperacionValidacion;

public class Cgg_res_notificacion_csv extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 910421694;

	public Cgg_res_notificacion_csv() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);		
		String outResult = "true";
		String tmpRequest = null;
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_tct_adjunto_csv obj = new com.besixplus.sii.objects.Cgg_tct_adjunto_csv();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(10485760);
			List items;
			try {
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				FileItem item=null;
				FileItem itemTmp=null;
				while (iter.hasNext()) {
					item = (FileItem) iter.next();
					if (item.isFormField()) {
						if(item.getFieldName().equals("request"))
							tmpRequest = item.getString();
								
					} else {
						if(item.getFieldName().equals("filCrnot_adjunto")){
							//obj.setCTADC_ADJUNTO(item.get());
							itemTmp=item;
						}
					}					
				}
				 if(tmpRequest.trim().toUpperCase().equals("VALIDAR_FILE")){
					/**
					 * Lee el archivo csv y separa en formato json
					 */
					String strCompleto = "[";
					try
					{
						BufferedReader br = new BufferedReader(new InputStreamReader(itemTmp.getInputStream()));
						BufferedReader tmpBr = new BufferedReader(new InputStreamReader(itemTmp.getInputStream()));
						String strLine = "";
						StringTokenizer st = null;
						String[] strHeader = {"CRTNT_CODIGO","CRPER_CODIGO","CCTN_CODIGO","CROSG_CODIGO","CRNOT_NUMERO_NOTIFICACION","CRNOT_FECHA_NOTIFICACION","CRNOT_ESTADO_NOTIFICACION"}; 
						int x=0;
						if ((strLine = tmpBr.readLine()) != null){		
							st = new StringTokenizer(strLine, ";");			            	
							while (st.hasMoreTokens()){
								x++;
								System.out.println( st.nextToken().trim());
							}
						}
						boolean sw=true;
						System.out.println( x);
						if(x==7)
						{
							
							while ((strLine = br.readLine()) != null){
								//OperacionValidacion objOperacionValidacion = new OperacionValidacion(request.getUserPrincipal().getName());
								
								st = new StringTokenizer(strLine, ";");
								if (st.hasMoreTokens()){ 		                
									x=1;
									strCompleto += (sw)?"":",";
									sw=false;
									strCompleto += "{\""+strHeader[0]+"\":\""+st.nextToken().trim()+"\"";	                	
									while (st.hasMoreTokens()){
										String tmpValue = st.nextToken().trim();								
										strCompleto += ",\""+strHeader[x]+"\":\""+tmpValue+"\"";
										x++;
												                    		                    
									}

									strCompleto += "}";
								}
							}
						
						
							outResult=strCompleto+"]";						
							outResult="{\"success\":true,\"msg\":\"Insertado\",\"data\":"+outResult+"}";
						}else
							outResult="{\"success\":false,\"msg\":\"El archivo no contiene un formato correcto.\"}";
					}
					catch (Exception e){
						System.out.println("Exception while reading csv file: " + e);
						outResult="{\"success\":false,\"msg\":\"El archivo no contiene un formato correcto\"}";
					}
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
				outResult = "false";
			}
			response.setContentType("text/html; UTF-8");			
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(outResult);
		}else{
			String tmpCodigo = request.getParameter("codigo");
			String tmpColumna = request.getParameter("columna");
			if(tmpCodigo != null){
				com.besixplus.sii.objects.Cgg_tct_adjunto_csv obj = null;
				obj = new com.besixplus.sii.objects.Cgg_tct_adjunto_csv();
				obj.setCTADC_CODIGO(tmpCodigo);
				Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				try{
					tmpCon.setAutoCommit(!com.besixplus.sii.db.ManagerConnection.isDeployed());
					new com.besixplus.sii.db.Cgg_tct_adjunto_csv(obj).select(tmpCon);
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				}
				ServletOutputStream out = response.getOutputStream();
				if(tmpColumna.toUpperCase().equals("CTADC_ADJUNTO")){
					out.write(obj.getCTADC_ADJUNTO());
				}
				response.setHeader("Content-Disposition","inline; filename="+obj.getCTADC_NOMBRE_ADJUNTO()+";");
				response.setContentType("application/"+obj.getCTADC_NOMBRE_ADJUNTO().substring(obj.getCTADC_NOMBRE_ADJUNTO().lastIndexOf(".")+1));
				out.flush();
				out.close();
			}
		}
	}
}
