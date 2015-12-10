package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.besixplus.sii.db.Cgg_configuracion;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_res_adjunto;
import com.besixplus.sii.objects.ServerResponse;

public class Cgg_res_resolucion extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 239652184;

	public Cgg_res_resolucion() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpRequest = "none";
		ServerResponse tmpResponse = new ServerResponse();
		tmpResponse.setSuccess(true);
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> objResolucionAdjunto = new ArrayList<Cgg_res_adjunto>();

		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_res_resolucion obj = new com.besixplus.sii.objects.Cgg_res_resolucion();
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
				e1.printStackTrace();
			}
			upload.setSizeMax(tmpConf.getCGCNF_VALOR_NUMERICO()*1024*1024);
			List items;

			try {
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						if(!item.getString().trim().isEmpty()){
							if(item.getFieldName().equals("txtCrres_codigo"))
								obj.setCRRES_CODIGO(item.getString());
							if(item.getFieldName().equals("txtCrssc_codigo"))
								obj.setCRSSC_CODIGO(item.getString());
							if(item.getFieldName().equals("txtCrres_numero_resolucion"))
								obj.setCRRES_NUMERO_RESOLUCION(item.getString());
							if(item.getFieldName().equals("crres_tipo_resolucion"))
								obj.setCRRES_TIPO(Integer.valueOf(item.getString()));
							if(item.getFieldName().equals("txtCrres_observaciones"))
								obj.setCRRES_OBSERVACIONES(item.getString());
							if(item.getFieldName().equals("txtCrres_extracto_resolucion"))
								obj.setCRRES_EXTRACTO_RESOLUCION(item.getString());
							if(item.getFieldName().equals("numCrres_votos_aprobacion")){
								obj.setCRRES_VOTOS_APROBACION(Integer.valueOf(item.getString()));
							}						
							if(item.getFieldName().equals("numCrres_votos_negacion")){
								obj.setCRRES_VOTOS_NEGACION(Integer.valueOf(item.getString()));
							}
							if(item.getFieldName().equals("numCrres_votos_abstencion")){
								obj.setCRRES_VOTOS_ABSTENCION(Integer.valueOf(item.getString()));
							}
							if(item.getFieldName().equals("dtCrres_fecha_emision")){							
								try {
									obj.setCRRES_FECHA_EMISION(new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(item.getString()).getTime()));
								} catch (ParseException e) {								
									e.printStackTrace();
								}
							}
							if(item.getFieldName().equals("dtCrres_fecha_ejecucion")){
								try {
									obj.setCRRES_FECHA_EJECUCION(new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(item.getString()).getTime()));
								} catch (ParseException e) {						
									e.printStackTrace();
								}
							}
							if(item.getFieldName().equals("dtCrres_fecha_anulacion")){
								try {
									obj.setCRRES_FECHA_ANULACION(new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(item.getString()).getTime()));
								} catch (ParseException e) {								
									e.printStackTrace();
								}
							}
							if(item.getFieldName().equals("txtCrres_resolucion_reemplaza")){
								obj.setCRRES_RESOLUCION_REEMPLAZA(item.getString());
							}
							if(item.getFieldName().equals("txtCrres_nombre_adjunto_resol")){
								obj.setCRRES_NOMBRE_ADJUNTO_RESOL(item.getString());
							}
							if(item.getFieldName().equals("txtCrres_descripcion_adjunto")){
								obj.setCRRES_DESCRIPCION_ADJUNTO(item.getString());
							}
							if(item.getFieldName().equals("dtCrres_fecha_apelacion")){
								try {
									obj.setCRRES_FECHA_APELACION(new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(item.getString()).getTime()));								
								} catch (ParseException e) {								
									e.printStackTrace();
								}
							}
							if(item.getFieldName().equals("txtCrres_extracto_apelacion")){
								obj.setCRRES_EXTRACTO_APELACION(item.getString());
							}
							if(item.getFieldName().equals("txtCrres_numero_apelacion")){
								obj.setCRRES_NUMERO_APELACION(item.getString());
							}
							if(item.getFieldName().equals("txtCrres_nombre_adjunto_apelac")){
								obj.setCRRES_NOMBRE_ADJUNTO_APELAC(item.getString());
							}
							if(item.getFieldName().equals("crres_estado_resolucion")){
								obj.setCRRES_ESTADO_RESOLUCION(Integer.valueOf(item.getString()));
							}
							if(item.getFieldName().equals("inEliCradj_codigo")){
								tmpCon = ManagerConnection.getConnection();
								com.besixplus.sii.objects.Cgg_res_adjunto objEliAdjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
								JSONArray tmpArray = new JSONArray(item.getString());
								for (int i=0;i<tmpArray.length();i++){
									objEliAdjunto.setCRADJ_CODIGO(tmpArray.get(i).toString());
									new com.besixplus.sii.db.Cgg_res_adjunto(objEliAdjunto).deleteAdjunto(tmpCon);
								}
								try {
									tmpCon.close();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}

							if(item.getFieldName().equals("request"))
								tmpRequest = item.getString();
						}
					} else {

						if(item.getFieldName().equals("filCrres_adjunto_resolucion")){
							obj.setCRRES_NOMBRE_ADJUNTO_RESOL(item.getName());
							obj.setCRRES_ADJUNTO_RESOLUCION(item.get());
						}
						if(item.getFieldName().equals("filCrres_adjunto_apelacion")){
							obj.setCRRES_NOMBRE_ADJUNTO_APELAC(item.getName());
							obj.setCRRES_ADJUNTO_APELACION(item.get());
						}
						if(item.getFieldName().equals("inResolucionAdjuntos")){
							com.besixplus.sii.objects.Cgg_res_adjunto objResAdjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
							objResAdjunto.setCRADJ_CODIGO("KEYGEN");
							objResAdjunto.setCRADJ_NOMBRE_ADJUNTO(item.getName());
							objResAdjunto.setCRADJ_ARCHIVO_ADJUNTO(item.get());
							objResAdjunto.setCRADJ_CONTENIDO("application/octet-stream");
							objResAdjunto.setCRADJ_ESTADO(true);
							objResAdjunto.setCRADJ_FECHA_REGISTRO(new Date());
							objResAdjunto.setCRADJ_USUARIO_INSERT(request.getUserPrincipal().getName());
							objResAdjunto.setCRADJ_USUARIO_UPDATE(request.getUserPrincipal().getName());
							objResolucionAdjunto.add(objResAdjunto);
						}			
					}
				}
				obj.setCRRES_ESTADO(true);
				tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				tmpCon.setAutoCommit(false);
				if(tmpRequest.trim().toUpperCase().equals("INSERT")){
					obj.setCRRES_CODIGO("KEYGEN");
					obj.setCRRES_USUARIO_INSERT(request.getUserPrincipal().getName());
					obj.setCRRES_USUARIO_UPDATE(request.getUserPrincipal().getName());
					outResult = new com.besixplus.sii.db.Cgg_res_resolucion(obj).insert(tmpCon);
				}else{
					obj.setCRRES_USUARIO_UPDATE(request.getUserPrincipal().getName());
					outResult = new com.besixplus.sii.db.Cgg_res_resolucion(obj).update(tmpCon);
				}
				if(outResult.equals("true") && objResolucionAdjunto != null){
					for(Cgg_res_adjunto obj_adj : objResolucionAdjunto){
						obj_adj.setCRRES_CODIGO(obj.getCRRES_CODIGO());					
						outResult = new com.besixplus.sii.db.Cgg_res_adjunto(obj_adj).insertAdjuntoSesion(tmpCon);
						if(!outResult.equals("true"))
							break;
					}
				}	
				if(outResult.equals("true"))
					tmpCon.commit();
				else{
					tmpCon.rollback();
					tmpResponse.setSuccess(false);
					tmpResponse.setMsg(outResult);
				}
				try {
					tmpCon.setAutoCommit(true);
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					tmpResponse.setSuccess(false);
					tmpResponse.setMsg(e.getMessage());
					try {
						tmpCon.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
				tmpResponse.setSuccess(false);
				tmpResponse.setMsg(e.getMessage());
			} catch (JSONException e) {
				e.printStackTrace();
				tmpResponse.setSuccess(false);
				tmpResponse.setMsg(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				tmpResponse.setSuccess(false);
				tmpResponse.setMsg(e.getMessage());
			}

			response.setContentType("text/html");
			response.getWriter().write(new JSONObject(tmpResponse).toString());
		}
	}
}
