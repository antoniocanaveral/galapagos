package com.besixplus.sii.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.besixplus.sii.objects.OperacionValidacion;

public class Cgg_tct_adjunto_csv extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 910421694;

	public Cgg_tct_adjunto_csv() {
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
						if(item.getFieldName().equals("txtCtadc_codigo") )
							obj.setCTADC_CODIGO(item.getString());
						if(item.getFieldName().equals("txtCtadc_nombre_adjunto") )
							obj.setCTADC_NOMBRE_ADJUNTO(item.getString());
						if(item.getFieldName().equals("txtCtadc_descripcion_adjunto") )
							obj.setCTADC_DESCRIPCION_ADJUNTO(item.getString());
						if(item.getFieldName().equals("dtCtadc_fecha_registro") ){
							try {
								obj.setCTADC_FECHA_REGISTRO(new Timestamp(new SimpleDateFormat("dd-MM-yyyy").parse(item.getString()).getTime()));
							} catch (ParseException e) {
								e.printStackTrace();
							}
						}							
					} else {
						if(item.getFieldName().equals("filCtadc_adjunto")){
							obj.setCTADC_ADJUNTO(item.get());
							itemTmp=item;
						}
					}					
				}
				if(tmpRequest.trim().toUpperCase().equals("INSERT")){
					obj.setCTADC_ESTADO(true);
					obj.setCTADC_USUARIO_INSERT(request.getUserPrincipal().getName());
					obj.setCTADC_USUARIO_UPDATE(request.getUserPrincipal().getName());
					Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();				
					obj.setCTADC_CODIGO("KEYGEN");
					outResult = new com.besixplus.sii.db.Cgg_tct_adjunto_csv(obj).insert(tmpCon);
					try {
						tmpCon.close();

					} catch (SQLException e) {
						com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
						response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
						outResult = "false";
					}	
				}else if(tmpRequest.trim().toUpperCase().equals("VALIDAR_FILE")){
					/**
					 * Lee el archivo csv y separa en formato json
					 */
					ArrayList<String> arrPassport = new ArrayList<String>();
					Integer pos =0;
					String strCompleto = "[";
					try
					{
						BufferedReader br = new BufferedReader(new InputStreamReader(itemTmp.getInputStream()));
						String strLine = "";
						StringTokenizer st = null;
						String[] strHeader = {"","","","","","","","","","","","","","","","","","","","",""}; 
						int x=0;
						if ((strLine = br.readLine()) != null){		
							st = new StringTokenizer(strLine, ";");			            	
							while (st.hasMoreTokens()){
								strHeader[x] = st.nextToken().toUpperCase().trim();
								x++;		                    		                    
							}
						}
						boolean sw=true;
						if(
								strHeader[0].equals("CODIGO_USUARIO") &&  
								strHeader[1].equals("NOMBRES") &&
								strHeader[2].equals("APELLIDOS") &&
								strHeader[3].equals("NUMPASS") &&
								strHeader[4].equals("NACIONALIDAD") &&
								strHeader[5].equals("PAIS") &&
								strHeader[6].equals("SEXO") &&
								strHeader[7].equals("FNACIMIENTO") &&
								strHeader[8].equals("FINGRESO") &&
								strHeader[9].equals("FSALIDA") &&
								strHeader[10].equals("AEROLINEA") &&
								strHeader[11].equals("AORIGEN") &&
								strHeader[12].equals("AEROARRIBO") &&
								strHeader[13].equals("HOSPEDAJE") &&
								strHeader[14].equals("ACTIVIDAD")			            	
						){
							String tmpReglaValidacion = new com.besixplus.sii.ws.Cgg_regla_validacion().selectOperacionValidacionLocal("FrmCgg_tct_registro", "JSON");
							
							while ((strLine = br.readLine()) != null){
								OperacionValidacion objOperacionValidacion = new OperacionValidacion(request.getUserPrincipal().getName());
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
									strCompleto += "{\""+strHeader[0]+"\":\""+st.nextToken().trim()+"\"";	                	
									while (st.hasMoreTokens()){
										String tmpValue = st.nextToken().trim();								
										strCompleto += ",\""+strHeader[x]+"\":\""+tmpValue+"\"";
										switch (x) {
										case 3:
											objOperacionValidacion.setDocumentoIdentificacion(tmpValue);
											pos = arrPassport.indexOf(tmpValue);
											arrPassport.add(tmpValue);
											break;
										case 8:
											objOperacionValidacion.setFechaIngreso(tmpValue);
											break;
										case 11:
											objOperacionValidacion.setAeropuertoOrigen(tmpValue);
											break;
										case 12:
											objOperacionValidacion.setAeropuertoDestino(tmpValue);
											break;
										default:
											break;
										}																		
										x++;		                    		                    
									}

									arrayJSONRegla = new JSONArray(tmpReglaValidacion);
									try
									{
										if (pos>=0)
											resultRegla = "{\"resultadoValidacion\":\"false\",\"dataSet\":[{\"CRVAL_APROBADO\":\"FALSE\",\"CRVAL_SUGERENCIA\":\"Registro repetido\"}]}";
										else{	
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
											if (!objOperacionValidacion.getPersona().equals("false"))
											{
												resultRegla = new com.besixplus.sii.ws.Cgg_regla_validacion().ejecutarReglaTipoSolicitudLocal(arrayJSONRegla.toString());
											}
											else
											{
												resultRegla = "{\"resultadoValidacion\":\"true\",\"dataSet\":[]}";
											}
										}
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