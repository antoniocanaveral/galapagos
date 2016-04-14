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

public class Cgg_tct_ingreso_salida_csv extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 910421694;

	public Cgg_tct_ingreso_salida_csv() {
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
						if(item.getFieldName().equals("filCrmov_adjunto")){
							//obj.setCTADC_ADJUNTO(item.get());
							itemTmp=item;
						}
					}					
				}
				if(tmpRequest.trim().toUpperCase().equals("SALIDA")){

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
						String[] strHeader = {"CODIGO_BARRAS","AEROLINEA","VUELO"}; 
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
						if(x==3)
						{
							String tmpReglaValidacion = new com.besixplus.sii.ws.Cgg_regla_validacion().selectOperacionValidacionLocal("FrmCgg_res_movilidad_salida", "JSON");
							while ((strLine = br.readLine()) != null){
								OperacionValidacion objOperacionValidacion = new OperacionValidacion();
								JSONArray arrayJSONRegla = null;
								JSONObject objJSONRegla = null;
								JSONArray arrayJSONParams = null;
								JSONObject objJSONParams = null;
								String resultRegla =  null;
								st = new StringTokenizer(strLine, ";");
								if (st.hasMoreTokens()){ 		                
									x=1;
									strCompleto += (sw)?"":",";
									sw=false;
									String tmpValue = st.nextToken().trim();
									System.out.println(tmpValue);
									strCompleto += "{\""+strHeader[0]+"\":\""+tmpValue+"\"";
									objOperacionValidacion.setCodigoBarras(tmpValue);
									while (st.hasMoreTokens()){
										System.out.println(tmpValue);
										tmpValue = st.nextToken().trim();								
										if (tmpValue.equals("S") || tmpValue.equals("N") )
										{
											if (tmpValue.equals("S"))
												tmpValue = new Boolean(true).toString();
											else
												tmpValue = new Boolean(false).toString();
										}
										strCompleto += ",\""+strHeader[x]+"\":\""+tmpValue+"\"";
										x++;		                    		                    
									}

									arrayJSONRegla = new JSONArray(tmpReglaValidacion);
									try
									{
										for(int i=0;i< arrayJSONRegla.length();i++)
										{
											objJSONRegla = arrayJSONRegla.getJSONObject(i);
											arrayJSONParams = new JSONArray(objJSONRegla.getString("CRTSE_CAMPO_EVALUACION"));
											objJSONParams = arrayJSONParams.getJSONObject(0);
											String [] iNameParams = JSONObject.getNames(objJSONParams);
											for (int l = 0; l < iNameParams.length; l++) {
												String tmpNameParam = iNameParams[l];
												String tmpResult = objOperacionValidacion.obtenerValores(objJSONParams.getString(tmpNameParam));
												arrayJSONParams.getJSONObject(0).put(tmpNameParam,tmpResult);
											}

											arrayJSONRegla.getJSONObject(i).put("CRTSE_CAMPO_EVALUACION",arrayJSONParams.toString());
										}
										resultRegla = new com.besixplus.sii.ws.Cgg_regla_validacion().ejecutarReglaTipoSolicitudLocal(arrayJSONRegla.toString());
										
									}
									catch (Exception e) {
										e.printStackTrace();
										resultRegla = arrayJSONRegla.toString();									
									}

									strCompleto += ",\"validacion\":"+resultRegla;
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
				
					
				}else if(tmpRequest.trim().toUpperCase().equals("INGRESO")){
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
						String[] strHeader = {"CODIGO_BARRAS","AEROPUERTO_ORIGEN","AEROLINEA","VUELO","FILTRO_NACIONAL"}; 
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
						if(x==5)
						{
							String tmpReglaValidacion = new com.besixplus.sii.ws.Cgg_regla_validacion().selectOperacionValidacionLocal("FrmCgg_res_movilidad", "JSON");
							while ((strLine = br.readLine()) != null){
								OperacionValidacion objOperacionValidacion = new OperacionValidacion();
								JSONArray arrayJSONRegla = null;
								JSONObject objJSONRegla = null;
								JSONArray arrayJSONParams = null;
								JSONObject objJSONParams = null;
								String resultRegla =  null;
								st = new StringTokenizer(strLine, ";");
								if (st.hasMoreTokens()){ 		                
									x=1;
									strCompleto += (sw)?"":",";
									sw=false;
									String tmpValue = st.nextToken().trim();
									System.out.println(tmpValue);
									strCompleto += "{\""+strHeader[0]+"\":\""+tmpValue+"\"";
									objOperacionValidacion.setCodigoBarras(tmpValue);
									while (st.hasMoreTokens()){
										System.out.println(tmpValue);
										tmpValue = st.nextToken().trim();								
										if (tmpValue.equals("S") || tmpValue.equals("N") )
										{
											if (tmpValue.equals("S"))
												tmpValue = new Boolean(true).toString();
											else
												tmpValue = new Boolean(false).toString();
										}
										strCompleto += ",\""+strHeader[x]+"\":\""+tmpValue+"\"";
										x++;		                    		                    
									}

									arrayJSONRegla = new JSONArray(tmpReglaValidacion);
									try
									{
										for(int i=0;i< arrayJSONRegla.length();i++)
										{
											objJSONRegla = arrayJSONRegla.getJSONObject(i);
											arrayJSONParams = new JSONArray(objJSONRegla.getString("CRTSE_CAMPO_EVALUACION"));
											objJSONParams = arrayJSONParams.getJSONObject(0);
											String [] iNameParams = JSONObject.getNames(objJSONParams);
											for (int l = 0; l < iNameParams.length; l++) {
												String tmpNameParam = iNameParams[l];
												String tmpResult = objOperacionValidacion.obtenerValores(objJSONParams.getString(tmpNameParam));
												arrayJSONParams.getJSONObject(0).put(tmpNameParam,tmpResult);
											}

											arrayJSONRegla.getJSONObject(i).put("CRTSE_CAMPO_EVALUACION",arrayJSONParams.toString());
										}
										resultRegla = new com.besixplus.sii.ws.Cgg_regla_validacion().ejecutarReglaTipoSolicitudLocal(arrayJSONRegla.toString());
										
									}
									catch (Exception e) {
										e.printStackTrace();
										resultRegla = arrayJSONRegla.toString();									
									}

									strCompleto += ",\"validacion\":"+resultRegla;
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
