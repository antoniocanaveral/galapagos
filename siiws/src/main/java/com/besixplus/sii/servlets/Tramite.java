package com.besixplus.sii.servlets;

import com.besixplus.sii.db.Cgg_configuracion;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_res_adjunto;
import com.besixplus.sii.objects.ServerResponse;
import com.besixplus.sii.ws.Cgg_res_tramite;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Clase. Clase de servlet para manejo de informacion para registro de tramite.
 * 
 */
public class Tramite extends HttpServlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor publico. Inicializa la clase tramite.
	 */
	public Tramite() {
		super();		
	}

	/**
	 * Metodo publico. Manipula el envio de informacion binaria para el registro de un tramite.
	 * @param request Objeto http.
	 * @param response Objeto http.
	 * @throws ServletException Excepcion.
	 * @throws IOException Excepcion.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		com.besixplus.sii.objects.Cgg_res_tramite objTramite = new com.besixplus.sii.objects.Cgg_res_tramite();
		String inCrfas_codigo = null;
		String inTramiteRequisitos = null;		
		String inNuevoBeneficiario = null;	
		String inCrgts_aplica = null;
		Date inCrtra_fecha_salida = null;
		JSONObject tmpTipoGarantia = null;
		String inOperacion = "registar";
		ArrayList<com.besixplus.sii.objects.Cgg_res_adjunto> objColeccionAdjunto = new ArrayList<Cgg_res_adjunto>();
		ServerResponse appResponse = new ServerResponse();
		String tmpNewVehiculo = null;
		//String log = "Inicio";
		if(tmpIsMultipart){
			new com.besixplus.sii.objects.Cgg_res_adjunto();
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
					if (item.isFormField()) {						
						if(item.getFieldName().equals("inCrtra_codigo"))
							objTramite.setCRTRA_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim());
						if(item.getFieldName().equals("inCrper_codigo"))
							objTramite.setCRPER_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim()); 
						if(item.getFieldName().equals("inCrpjr_codigo"))							
							objTramite.setCRPJR_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim()); 
						if(item.getFieldName().equals("inCgg_crper_codigo"))
							objTramite.setCGG_CRPER_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim()); 
						if(item.getFieldName().equals("inCrpro_codigo"))
							objTramite.setCRPRO_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim()); 
						if(item.getFieldName().equals("inCvveh_codigo"))
							objTramite.setCVVEH_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim()); 
						if(item.getFieldName().equals("inCrett_codigo"))
							objTramite.setCRETT_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim()); 
						if(item.getFieldName().equals("inCisla_codigo"))
							objTramite.setCISLA_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim()); 
						if(item.getFieldName().equals("inCrdpt_codigo") && !item.getString().trim().isEmpty())
							tmpTipoGarantia = new JSONObject(item.getString());
						if(item.getFieldName().equals("inCvmtr_codigo"))
							objTramite.setCVMTR_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim());		
						if(item.getFieldName().equals("inCgg_cvmtr_codigo"))
							objTramite.setCGG_CVMTR_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim());
						if(item.getFieldName().equals("inCgg_cvveh_codigo"))
							objTramite.setCGG_CVVEH_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim());
						if(item.getFieldName().equals("inCrtra_actividad_residencia"))
							objTramite.setCRTRA_ACTIVIDAD_RESIDENCIA((item.getString().trim().length() == 0)?null:item.getString().trim());
						if(item.getFieldName().equals("inCrtra_observacion"))
							objTramite.setCRTRA_OBSERVACION((item.getString().trim().length() == 0)?null:item.getString().trim());
						if(item.getFieldName().equals("inCrtra_dias_permanencia"))
							objTramite.setCRTRA_DIAS_PERMANENCIA(Integer.parseInt(item.getString()));
						if(item.getFieldName().equals("inCrtra_atencion_cliente") && inOperacion.equalsIgnoreCase("registrar")==true)
							objTramite.setCRTRA_ATENCION_CLIENTE(Boolean.parseBoolean(item.getString()));
						if(item.getFieldName().equals("inCrtra_comunicado_radial"))
							objTramite.setCRTRA_COMUNICADO_RADIAL((item.getString().trim().length() == 0)?null:item.getString().trim());
						if(item.getFieldName().equals("inCrtst_codigo"))
							objTramite.setCRTST_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim()); 
						if(item.getFieldName().equals("inCrtra_motivo"))
							objTramite.setCRTRA_MOTIVO((item.getString().trim().length() == 0)?null:item.getString().trim()); 
						if(item.getFieldName().equals("inCrtra_folio"))
							objTramite.setCRTRA_FOLIO(new BigDecimal(item.getString()));
						if(item.getFieldName().equals("inRep_crper_codigo"))
							objTramite.setREP_CRPER_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim());
						if(item.getFieldName().equals("inChange_crtst_codigo"))
							objTramite.setCHANGE_CRTST_CODIGO((item.getString().trim().length() == 0)?null:item.getString().trim());
						if(item.getFieldName().equals("inTramiteRequisitos"))
							inTramiteRequisitos=item.getString();
						if(item.getFieldName().equals("inCrfas_codigo"))							
							inCrfas_codigo=(item.getString().trim().length() == 0)?null:item.getString().trim();
						if(item.getFieldName().equals("inNuevoBeneficiario"))
							inNuevoBeneficiario=(item.getString().trim().length() == 0)?null:item.getString().trim();						
						if(item.getFieldName().equals("inCrgts_aplica"))
							inCrgts_aplica=(item.getString().trim().length() == 0)?null:item.getString().trim();
						if(item.getFieldName().equals("inVehiculo"))
							tmpNewVehiculo = (item.getString().trim().length() == 0)?null:item.getString().trim();
						if(item.getFieldName().equals("inOperacion"))
							inOperacion=item.getString().trim();
						if(item.getFieldName().equals("inCrtra_fecha_salida")){
							if(item.getString()!=null && item.getString().trim().length() >=1){								
								DateFormat df = new SimpleDateFormat("dd/MM/yyyy");								
								try{
									inCrtra_fecha_salida = df.parse(item.getString());						           						            
								} catch (ParseException e){
									e.printStackTrace();
									inCrtra_fecha_salida = null;
								}								
							}else{
								inCrtra_fecha_salida = null;
							}
						}						
					} else {
						if(item.getFieldName().equals("inAdjuntos")){
							com.besixplus.sii.objects.Cgg_res_adjunto objAdjunto = new com.besixplus.sii.objects.Cgg_res_adjunto();
							objAdjunto.setCRADJ_CODIGO("KEYGEN");
							objAdjunto.setCRADJ_NOMBRE_ADJUNTO(item.getName());
							objAdjunto.setCRADJ_ARCHIVO_ADJUNTO(item.get());
							objAdjunto.setCRADJ_CONTENIDO("application/octet-stream");
							objAdjunto.setCRADJ_ESTADO(true);
							objAdjunto.setCRADJ_FECHA_REGISTRO(new Date());
							objAdjunto.setCRADJ_USUARIO_INSERT(request.getUserPrincipal().getName());
							objAdjunto.setCRADJ_USUARIO_UPDATE(request.getUserPrincipal().getName());
							objColeccionAdjunto.add(objAdjunto);
						}						
					}					
				}

				if(inOperacion.equalsIgnoreCase("registrar")==true){
					//log +="==2 Registro de tramite";

					//log +="==2.28.1 antes del registro";
					outResult = new Cgg_res_tramite().registrarTramite(
							objTramite.getCRPER_CODIGO(), 					
							objTramite.getCRPJR_CODIGO(), 
							objTramite.getCGG_CRPER_CODIGO(), 
							objTramite.getCRPRO_CODIGO(), 
							objTramite.getCRTST_CODIGO(), 
							objTramite.getCVVEH_CODIGO(), 
							objTramite.getCISLA_CODIGO(),  
							objTramite.getCVMTR_CODIGO(),
							objTramite.getCGG_CVMTR_CODIGO(),
							objTramite.getCGG_CVVEH_CODIGO(),
							objTramite.getCRTRA_ACTIVIDAD_RESIDENCIA(), 
							objTramite.getCRTRA_OBSERVACION(), 
							objTramite.getCRTRA_DIAS_PERMANENCIA(), 
							objTramite.getCRTRA_ATENCION_CLIENTE(), 
							objTramite.getCRTRA_COMUNICADO_RADIAL(), 
							objTramite.getCRTRA_MOTIVO(), 
							objTramite.getCRTRA_FOLIO(),
							objTramite.getREP_CRPER_CODIGO(),
							objTramite.getCHANGE_CRTST_CODIGO(),
							inTramiteRequisitos,
							inNuevoBeneficiario,
							inCrfas_codigo, 
							inCrgts_aplica,
							objColeccionAdjunto,
							inCrtra_fecha_salida,
							tmpNewVehiculo,
							tmpTipoGarantia,
							request,
							response
					);
					//log +="==2.28 Despues de registro resultado:"+outResult;


				}else if(inOperacion.equalsIgnoreCase("actualizar")==true){
					//log +="==3 Actualizacion de tramite";
					objTramite.setCRTRA_ATENCION_CLIENTE(true);
					outResult = new Cgg_res_tramite().actualizarTramite(
							objTramite.getCRTRA_CODIGO(),
							objTramite.getCRPER_CODIGO(), 
							objTramite.getCRPJR_CODIGO(), 
							objTramite.getCGG_CRPER_CODIGO(), 
							objTramite.getCRPRO_CODIGO(), 
							objTramite.getCRTST_CODIGO(), 
							objTramite.getCVVEH_CODIGO(), 
							objTramite.getCISLA_CODIGO(), 
							objTramite.getCVMTR_CODIGO(), 
							objTramite.getCGG_CVMTR_CODIGO(),
							objTramite.getCGG_CVVEH_CODIGO(),
							objTramite.getCRTRA_ACTIVIDAD_RESIDENCIA(), 
							objTramite.getCRTRA_OBSERVACION(), 
							objTramite.getCRTRA_DIAS_PERMANENCIA(), 
							objTramite.getCRTRA_ATENCION_CLIENTE(), 
							objTramite.getCRTRA_COMUNICADO_RADIAL(), 
							objTramite.getCRTRA_MOTIVO(), 
							objTramite.getCRTRA_FOLIO(),
							objTramite.getREP_CRPER_CODIGO(),
							objTramite.getCHANGE_CRTST_CODIGO(),
							inNuevoBeneficiario, 
							inCrfas_codigo, 
							inTramiteRequisitos, 						
							inCrgts_aplica, 
							objColeccionAdjunto,
							inCrtra_fecha_salida,
							tmpNewVehiculo,
							tmpTipoGarantia,
							request,
							response
					);
				}

				appResponse.setSuccess(true);
				appResponse.setMsg(outResult);

			} catch (FileUploadException e) {
				appResponse.setSuccess(false);								
				appResponse.setMsg(e.toString()+":"+e.getMessage());								
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			} catch(Exception ex){
				appResponse.setSuccess(false);				
				appResponse.setMsg(ex.toString()+":"+ex.getMessage());
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(ex);
			}			
			response.setContentType("text/html");
			response.getWriter().println(new JSONObject(appResponse).toString());
		}
	}

}
