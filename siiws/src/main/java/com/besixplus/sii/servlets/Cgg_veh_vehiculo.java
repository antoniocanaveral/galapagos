package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.besixplus.sii.objects.Cgg_veh_vehiculo_estado;
import com.besixplus.sii.objects.Cgg_veh_vehiculo_motor;
import com.besixplus.sii.objects.ServerResponse;

public class Cgg_veh_vehiculo extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1404619514;

	public Cgg_veh_vehiculo() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpRequest = null;
		String tmpEstados = null;
		String tmpMotores = null;
		ServerResponse tmpResponse = new ServerResponse();
		tmpResponse.setSuccess(true);
		ArrayList<Map<String, Object>> tmpAdjuntos = new ArrayList<Map<String,Object>>();
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_veh_vehiculo obj = new com.besixplus.sii.objects.Cgg_veh_vehiculo();
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
							if(item.getFieldName().equals("request"))
								tmpRequest = item.getString();
							if(item.getFieldName().equals("txtCvveh_codigo") )
								obj.setCVVEH_CODIGO(item.getString());
							if(item.getFieldName().equals("cvmrc_codigo") && item.getString().trim().length() > 0)
								obj.setCVMRC_CODIGO(item.getString());
							if(item.getFieldName().equals("cvclr_codigo") && item.getString().trim().length() > 0)
								obj.setCVCLR_CODIGO(item.getString());
							if(item.getFieldName().equals("cvctg_codigo") && item.getString().trim().length() > 0)
								obj.setCVCTG_CODIGO(item.getString());
							if(item.getFieldName().equals("csctp_codigo") && item.getString().trim().length() > 0)
								obj.setCSCTP_CODIGO(item.getString());
							if(item.getFieldName().equals("cvsct_codigo") && item.getString().trim().length() > 0)
								obj.setCVSCT_CODIGO(item.getString());
							if(item.getFieldName().equals("cgg_cvclr_codigo") && item.getString().trim().length() > 0)
								obj.setCGG_CVCLR_CODIGO(item.getString());
							if(item.getFieldName().equals("txtCvveh_nombre") )
								obj.setCVVEH_NOMBRE(item.getString());
							if(item.getFieldName().equals("txtCvveh_modelo") )
								obj.setCVVEH_MODELO(item.getString());
							if(item.getFieldName().equals("cvveh_tipo") )
								obj.setCVVEH_TIPO(Integer.valueOf(item.getString()));
							if(item.getFieldName().equals("numCvveh_anio_produccion") )
								obj.setCVVEH_ANIO_PRODUCCION(Integer.valueOf(item.getString()));
							if(item.getFieldName().equals("txtCvveh_chasis") )
								obj.setCVVEH_CHASIS(item.getString());
							if(item.getFieldName().equals("txtCvveh_placa") )
								obj.setCVVEH_PLACA(item.getString());
							if(item.getFieldName().equals("estados") )
								tmpEstados = item.getString();
							if(item.getFieldName().equals("motores") )
								tmpMotores = item.getString();
							if(item.getFieldName().equals("numCvveh_eslora") && item.getString().trim().length() > 0)
								obj.setCVVEH_ESLORA(java.math.BigDecimal.valueOf(Double.valueOf(item.getString())));
							if(item.getFieldName().equals("numCvveh_manga") && item.getString().trim().length() > 0)
								obj.setCVVEH_MANGA(java.math.BigDecimal.valueOf(Double.valueOf(item.getString())));
							if(item.getFieldName().equals("numCvveh_puntal") && item.getString().trim().length() > 0)
								obj.setCVVEH_PUNTAL(java.math.BigDecimal.valueOf(Double.valueOf(item.getString())));
							if(item.getFieldName().equals("txtCvveh_material") )
								obj.setCVVEH_MATERIAL(item.getString());
							if(item.getFieldName().equals("cvveh_ingreso") )
								obj.setCVVEH_INGRESO(Boolean.valueOf(item.getString()));
							if(item.getFieldName().equals("cvveh_fecha_ingreso") )
								obj.setCVVEH_FECHA_INGRESO(Timestamp.valueOf(item.getString()));
							if(item.getFieldName().equals("cvveh_tipo_ingreso") )
								obj.setCVVEH_TIPO_INGRESO(Integer.valueOf(item.getString()) );
							if(item.getFieldName().equals("numCvveh_tiempo_estadia") && item.getString().trim().length() > 0)
								obj.setCVVEH_TIEMPO_ESTADIA(Integer.valueOf(item.getString()));
							if(item.getFieldName().equals("cvveh_salio") )
								obj.setCVVEH_SALIO(Boolean.valueOf(item.getString()));
							if(item.getFieldName().equals("cvveh_fecha_salida") )
								obj.setCVVEH_FECHA_SALIDA(Timestamp.valueOf(item.getString()));
							if(item.getFieldName().equals("txtCvveh_observacion") )
								obj.setCVVEH_OBSERVACION(item.getString());
						}
					} else {
						if(item.getFieldName().equals("filCvveh_foto"))
							obj.setCVVEH_FOTO(item.get());
						if(item.getFieldName().equals("inVehiculoAdjuntos")){
							Map<String, Object> tmpAdjunto = new HashMap<String, Object>();
							tmpAdjunto.put("NOMBRE", item.getName());
							tmpAdjunto.put("DATA", item.get());
							tmpAdjuntos.add(tmpAdjunto);
						}
					}
				}
				obj.setCVVEH_ESTADO(true);
				
				tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				tmpCon.setAutoCommit(false);
				if(tmpRequest.trim().toUpperCase().equals("INSERT")){
					obj.setCVVEH_CODIGO("KEYGEN");
					obj.setCVVEH_USUARIO_INSERT(request.getUserPrincipal().getName());
					obj.setCVVEH_USUARIO_UPDATE(request.getUserPrincipal().getName());
					outResult = new com.besixplus.sii.db.Cgg_veh_vehiculo(obj).insert(tmpCon);
				}else{
					obj.setCVVEH_USUARIO_UPDATE(request.getUserPrincipal().getName());
					outResult = new com.besixplus.sii.db.Cgg_veh_vehiculo(obj).update(tmpCon);
				}
				try {
					if(outResult.equals("true")){
						JSONArray tmpJSONEstados = new JSONArray(tmpEstados);
						for(int i = 0 ; i < tmpJSONEstados.length(); i++){
							JSONObject tmpEstado = (JSONObject) tmpJSONEstados.get(i);
							com.besixplus.sii.objects.Cgg_veh_vehiculo_estado tmpVehiculoEstado = new Cgg_veh_vehiculo_estado();
							tmpVehiculoEstado.setCVSVH_CODIGO("KEYGEN");
							tmpVehiculoEstado.setCVVEH_CODIGO(obj.getCVVEH_CODIGO());
							tmpVehiculoEstado.setCVSVH_FECHA(Timestamp.valueOf(tmpEstado.getString("CVSVH_FECHA")));
							tmpVehiculoEstado.setCVSVM_CODIGO(tmpEstado.getString("CVSVM_CODIGO"));
							tmpVehiculoEstado.setCVSVH_OBSERVACION(tmpEstado.getString("CVSVH_OBSERVACION"));
							tmpVehiculoEstado.setCVSVH_USUARIO_INSERT(request.getUserPrincipal().getName());
							tmpVehiculoEstado.setCVSVH_USUARIO_UPDATE(request.getUserPrincipal().getName());
							tmpVehiculoEstado.setCVSVH_ESTADO(true);
							outResult = new com.besixplus.sii.db.Cgg_veh_vehiculo_estado(tmpVehiculoEstado).insert(tmpCon);
							if(!outResult.equals("true"))
								break;
						}
					}
					if(outResult.equals("true")){
						JSONArray tmpJSONMotores = new JSONArray(tmpMotores);
						for(int i = 0 ; i < tmpJSONMotores.length(); i++){
							JSONObject tmpMotor = (JSONObject) tmpJSONMotores.get(i);
							com.besixplus.sii.objects.Cgg_veh_vehiculo_motor tmpVehiculoMotor = new Cgg_veh_vehiculo_motor();
							tmpVehiculoMotor.setCVVMT_CODIGO("KEYGEN");
							tmpVehiculoMotor.setCVVEH_CODIGO(obj.getCVVEH_CODIGO());
							tmpVehiculoMotor.setCVMTR_CODIGO(tmpMotor.getString("CVMTR_CODIGO"));
							tmpVehiculoMotor.setCVVMT_FECHA(Timestamp.valueOf(tmpMotor.getString("CVVMT_FECHA")));
							tmpVehiculoMotor.setCVVMT_OBSERVACION(tmpMotor.getString("CVVMT_OBSERVACION"));
							tmpVehiculoMotor.setCVVMT_USUARIO_INSERT(request.getUserPrincipal().getName());
							tmpVehiculoMotor.setCVVMT_USUARIO_UPDATE(request.getUserPrincipal().getName());
							tmpVehiculoMotor.setCVVMT_ESTADO(true);
							outResult = new com.besixplus.sii.db.Cgg_veh_vehiculo_motor(tmpVehiculoMotor).insert(tmpCon);
							if(!outResult.equals("true"))
								break;
						}
					}
					if(outResult.equals("true")){
						for(Map<String, Object> tmpObject : tmpAdjuntos){
							Cgg_res_adjunto tmpAdjunto = new Cgg_res_adjunto();
							tmpAdjunto.setCRADJ_CODIGO("KEYGEN");
							tmpAdjunto.setCVVEH_CODIGO(obj.getCVVEH_CODIGO());
							tmpAdjunto.setCRADJ_NOMBRE_ADJUNTO(tmpObject.get("NOMBRE").toString());
							tmpAdjunto.setCRADJ_ARCHIVO_ADJUNTO((byte[])tmpObject.get("DATA"));
							tmpAdjunto.setCRADJ_FECHA_REGISTRO(new Date());
							tmpAdjunto.setCRADJ_ESTADO(true);
							outResult = new com.besixplus.sii.db.Cgg_res_adjunto(tmpAdjunto).insertCGG_VEH_VEHICULO(tmpCon);
							if(!outResult.equals("true"))
								break;
						}
					}
					if(outResult.equals("true")){
						tmpCon.commit();
						tmpCon.setAutoCommit(true);
					}
					tmpCon.close();
				}catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
					outResult = "false";
					tmpResponse.setSuccess(false);
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
				outResult = "false";
				tmpResponse.setSuccess(false);
			} catch (JSONException e) {
				e.printStackTrace();
				tmpResponse.setSuccess(false);
			} catch (SQLException e) {
				e.printStackTrace();
				tmpResponse.setSuccess(false);
			}
			response.setContentType("text/html");
			response.getWriter().write(new JSONObject(tmpResponse).toString());
		}
	}
}