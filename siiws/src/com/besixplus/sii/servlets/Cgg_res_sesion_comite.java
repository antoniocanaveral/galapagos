package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import com.besixplus.sii.misc.CGGEnumerators;
import com.besixplus.sii.objects.Cgg_res_adjunto;
import com.besixplus.sii.objects.Cgg_res_resol_tramite;
import com.besixplus.sii.objects.Cgg_res_resolucion;
import com.besixplus.sii.objects.Cgg_res_tipo_solicitud_tramite;
import com.besixplus.sii.objects.Cgg_res_tramite;
import com.besixplus.sii.objects.ServerResponse;

public class Cgg_res_sesion_comite extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1943282453;

	public Cgg_res_sesion_comite() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);

		String outResult = "true";
		String tmpRequest = "none";
		String tmpResoluciones = null;
		String tmpEliResoluciones = null;
		String tmpEliTramites = null;
		ServerResponse appResponse = new ServerResponse();
		appResponse.setSuccess(true);
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> objSesionAdjunto = new ArrayList<Cgg_res_adjunto>();

		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_res_sesion_comite obj = new com.besixplus.sii.objects.Cgg_res_sesion_comite();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			com.besixplus.sii.objects.Cgg_configuracion tmpConf = new com.besixplus.sii.objects.Cgg_configuracion();
			tmpConf.setCGCNF_CODIGO("CONF10");
			Connection tmpCon = ManagerConnection.getConnection();
			try{
				tmpCon.setAutoCommit(false);
				new Cgg_configuracion(tmpConf).select(tmpCon);
				tmpCon.close();
			}catch(SQLException er){
				er.printStackTrace();
			}
			upload.setSizeMax(tmpConf.getCGCNF_VALOR_NUMERICO()*1024*1024);
			List items;
			try {
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						if(item.getFieldName().equals("txtCrssc_codigo")){
							obj.setCRSSC_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("txtCrcom_codigo")){
							obj.setCRCOM_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("txtCisla_codigo")){
							obj.setCISLA_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("dtCrssc_fecha_reunion")){
							obj.setCRSSC_FECHA_REUNION(Timestamp.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("dtCrssc_fecha_finalizacion")){							
							obj.setCRSSC_FECHA_FINALIZACION(Timestamp.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("txtCrssc_numero_sesion")){
							obj.setCRSSC_NUMERO_SESION(item.getString());
						}
						if(item.getFieldName().equals("txtCrssc_extracto")){
							obj.setCRSSC_EXTRACTO(item.getString());
						}
						if(item.getFieldName().equals("txtCrssc_observacion")){
							obj.setCRSSC_OBSERVACION(item.getString());
						}
						if(item.getFieldName().equals("dtCrssc_fecha_convocatoria")){
							obj.setCRSSC_FECHA_CONVOCATORIA(Timestamp.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("txtCrssc_motivo_convocatoria")){
							obj.setCRSSC_MOTIVO_CONVOCATORIA(item.getString());
						}
						if(item.getFieldName().equals("txtCrssc_descripcion_adjunto")){
							obj.setCRSSC_DESCRIPCION_ADJUNTO(item.getString());
						}
						if(item.getFieldName().equals("txtCrssc_nombre_adjunto")){
							obj.setCRSSC_NOMBRE_ADJUNTO(item.getString());
						}
						if(item.getFieldName().equals("cbxCrssc_estado_convocatoriaH")){
							obj.setCRSSC_ESTADO_CONVOCATORIA(Integer.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("inpryu_JSON")){
							obj.setTRAMITE(item.getString());
						}
						if(item.getFieldName().equals("inResoluciones"))
							tmpResoluciones = item.getString();

						if(item.getFieldName().equals("inEliResoluciones"))
							tmpEliResoluciones = item.getString();

						if(item.getFieldName().equals("inEliTramites"))
							tmpEliTramites = item.getString();

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
					} else {
						if(item.getFieldName().equals("filCrssc_adjunto")){
							obj.setCRSSC_NOMBRE_ADJUNTO(item.getName());
							obj.setCRSSC_ADJUNTO(item.get());
						}
						if(item.getFieldName().equals("inSesionAdjuntos")){
							com.besixplus.sii.objects.Cgg_res_adjunto objSesAdjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
							objSesAdjunto.setCRADJ_CODIGO("KEYGEN");
							objSesAdjunto.setCRADJ_NOMBRE_ADJUNTO(item.getName());
							objSesAdjunto.setCRADJ_ARCHIVO_ADJUNTO(item.get());
							objSesAdjunto.setCRADJ_CONTENIDO("application/octet-stream");							
							objSesAdjunto.setCRADJ_ESTADO(true);
							objSesAdjunto.setCRADJ_FECHA_REGISTRO(new Date());
							objSesAdjunto.setCRADJ_USUARIO_INSERT(request.getUserPrincipal().getName());
							objSesAdjunto.setCRADJ_USUARIO_UPDATE(request.getUserPrincipal().getName());
							objSesionAdjunto.add(objSesAdjunto);
						}
					}
				}		
				obj.setCRSSC_ESTADO(true);
				tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				tmpCon.setAutoCommit(false);
				if(tmpRequest.trim().toUpperCase().equals("INSERT")){
					obj.setCRSSC_CODIGO("KEYGEN");
					obj.setCRSSC_NUMERO_SESION(com.besixplus.sii.db.Cgg_res_sesion_comite.numeroSesion(tmpCon, obj.getCISLA_CODIGO()));
					obj.setCRSSC_USUARIO_INSERT(request.getUserPrincipal().getName());
					obj.setCRSSC_USUARIO_UPDATE(request.getUserPrincipal().getName());
					outResult = new com.besixplus.sii.db.Cgg_res_sesion_comite(obj).insert(tmpCon);
					if(outResult.equals("true"))
						appResponse.setMsg(obj.getCRSSC_NUMERO_SESION());
				}else{
					obj.setCRSSC_USUARIO_UPDATE(request.getUserPrincipal().getName());
					outResult = new com.besixplus.sii.db.Cgg_res_sesion_comite(obj).update(tmpCon);
					if (outResult.equals("true")){
						org.json.JSONArray pryuJSON = new org.json.JSONArray(obj.getTRAMITE());
						Cgg_res_tramite tmpTramite = new Cgg_res_tramite();
						Cgg_res_tipo_solicitud_tramite tmpTipoSolicitud = new Cgg_res_tipo_solicitud_tramite();
						com.besixplus.sii.objects.Cgg_res_resolucion tmpObjResolucion = new com.besixplus.sii.objects.Cgg_res_resolucion();

						JSONArray tmpJSONEliTramites = new JSONArray(tmpEliTramites);
						Cgg_res_resol_tramite tmpRslTramite = new Cgg_res_resol_tramite();
						for (int j=0;j<tmpJSONEliTramites.length();j++){
							tmpRslTramite.setCRRST_CODIGO(tmpJSONEliTramites.getString(j));
							new com.besixplus.sii.db.Cgg_res_resol_tramite(tmpRslTramite).select(tmpCon);
							outResult = new com.besixplus.sii.db.Cgg_res_resol_tramite(tmpRslTramite).delete(tmpCon,false);

							if(!outResult.equalsIgnoreCase("true"))
								break;

							tmpTramite.setCRTRA_CODIGO(tmpRslTramite.getCRTRA_CODIGO());
							new com.besixplus.sii.db.Cgg_res_tramite(tmpTramite).select(tmpCon);
							tmpTipoSolicitud.setCRTST_CODIGO(tmpTramite.getCRTST_CODIGO());
							new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(tmpTipoSolicitud).select(tmpCon);
							if(tmpTipoSolicitud.getCRRES_CODIGO() == null || tmpTipoSolicitud.getCRRES_CODIGO().trim().isEmpty()){
								tmpObjResolucion.setCRRES_CODIGO(tmpRslTramite.getCRRES_CODIGO());
								if(outResult.equals("true")){
									new com.besixplus.sii.db.Cgg_res_resolucion(tmpObjResolucion).delete(tmpCon, false);
								}else
									break;
							}
						}
						for (int i = 0 ; i < pryuJSON.length(); i++){
							if(pryuJSON.getJSONObject(i).isNull("CRRST_CODIGO") || pryuJSON.getJSONObject(i).getString("CRRST_CODIGO").trim().isEmpty()){
								tmpTramite.setCRTRA_CODIGO(((JSONObject)pryuJSON.get(i)).getString("CRTRA_CODIGO"));
								new com.besixplus.sii.db.Cgg_res_tramite(tmpTramite).select(tmpCon);
								tmpTipoSolicitud.setCRTST_CODIGO(tmpTramite.getCRTST_CODIGO());
								new com.besixplus.sii.db.Cgg_res_tipo_solicitud_tramite(tmpTipoSolicitud).select(tmpCon);
								if(tmpTipoSolicitud.getCRRES_CODIGO() == null || tmpTipoSolicitud.getCRRES_CODIGO().trim().isEmpty()){
									tmpObjResolucion = new com.besixplus.sii.objects.Cgg_res_resolucion();
									tmpObjResolucion.setCRRES_CODIGO("KEYGEN");	
									tmpObjResolucion.setCRSSC_CODIGO(obj.getCRSSC_CODIGO());							
									tmpObjResolucion.setCRRES_ESTADO_RESOLUCION(CGGEnumerators.EstadoResolucion.Esperando_Votacion.getValue());
									tmpObjResolucion.setCRRES_TIPO(CGGEnumerators.TipoResolucion.Aprobacion.getValue());
									tmpObjResolucion.setCRRES_EXTRACTO_RESOLUCION("Tramite No. "+pryuJSON.getJSONObject(i).getString("CRTRA_NUMERO"));
									tmpObjResolucion.setCRRES_ESTADO(true);
									tmpObjResolucion.setCRRES_USUARIO_INSERT(request.getUserPrincipal().getName());
									tmpObjResolucion.setCRRES_USUARIO_UPDATE(request.getUserPrincipal().getName());
									outResult = new com.besixplus.sii.db.Cgg_res_resolucion(tmpObjResolucion).insert(tmpCon);
								}else
									tmpObjResolucion.setCRRES_CODIGO(tmpTipoSolicitud.getCRRES_CODIGO());
								if(outResult.equals("true")){
									Cgg_res_resol_tramite tmpResolTramite = new Cgg_res_resol_tramite();
									tmpResolTramite.setCRRST_CODIGO("KEYGEN");
									tmpResolTramite.setCRRES_CODIGO(tmpObjResolucion.getCRRES_CODIGO());
									tmpResolTramite.setCRRST_ESTADO(true);
									tmpResolTramite.setCRTRA_CODIGO(((JSONObject)pryuJSON.get(i)).getString("CRTRA_CODIGO"));
									tmpResolTramite.setCRRST_USUARIO_INSERT(request.getUserPrincipal().getName());
									tmpResolTramite.setCRRST_USUARIO_UPDATE(request.getUserPrincipal().getName());
									outResult = new com.besixplus.sii.db.Cgg_res_resol_tramite(tmpResolTramite).insert(tmpCon);
									if(!outResult.equals("true"))
										break;
								}
							}
						}
						if(outResult.equals("true")){
							Cgg_res_resolucion tmpResoluncion = new Cgg_res_resolucion();
							JSONArray tmpJSONResoluciones = new JSONArray(tmpEliResoluciones);
							for(int i=0;i<tmpJSONResoluciones.length();i++){
								tmpResoluncion.setCRRES_CODIGO(tmpJSONResoluciones.getString(i));
								new com.besixplus.sii.db.Cgg_res_resolucion(tmpResoluncion).select(tmpCon);
								tmpResoluncion.setCRSSC_CODIGO(null);
								new com.besixplus.sii.db.Cgg_res_resolucion(tmpResoluncion).update(tmpCon);
							}
							tmpJSONResoluciones = new JSONArray(tmpResoluciones);
							for(int i=0;i<tmpJSONResoluciones.length();i++){
								JSONObject tmpJSONResol = tmpJSONResoluciones.getJSONObject(i);
								tmpResoluncion.setCRRES_CODIGO(tmpJSONResol.getString("CRRES_CODIGO"));
								new com.besixplus.sii.db.Cgg_res_resolucion(tmpResoluncion).select(tmpCon);
								tmpResoluncion.setCRSSC_CODIGO(obj.getCRSSC_CODIGO());
								new com.besixplus.sii.db.Cgg_res_resolucion(tmpResoluncion).update(tmpCon);
							}
						}
					}					
					if(objSesionAdjunto != null){
						for(Cgg_res_adjunto obj_adj : objSesionAdjunto){
							obj_adj.setCRSSC_CODIGO(obj.getCRSSC_CODIGO());					
							outResult= new com.besixplus.sii.db.Cgg_res_adjunto(obj_adj).insertAdjuntoSesion(tmpCon);
						}
					}	
				}
				try {
					if(outResult.equals("true")){
						tmpCon.commit();
						tmpCon.setAutoCommit(true);
					}else{
						appResponse.setMsg(outResult);
						appResponse.setSuccess(false);
					}
					tmpCon.close();
				} catch (SQLException e) {
					appResponse.setSuccess(false);
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					outResult = e.getMessage();
					try {
						tmpCon.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
				appResponse.setMsg(e.getMessage());
				appResponse.setSuccess(false);

			}
			catch (JSONException e) {
				appResponse.setMsg(e.getMessage());
				appResponse.setSuccess(false);
				e.printStackTrace();
			} catch (SQLException e) {
				appResponse.setSuccess(false);
				appResponse.setMsg(e.getMessage());
				e.printStackTrace();
			}
			response.setContentType("text/html");
			response.getWriter().println(new JSONObject(appResponse).toString());
		}
	}
}
