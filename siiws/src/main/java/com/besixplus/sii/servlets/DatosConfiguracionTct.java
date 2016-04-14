package com.besixplus.sii.servlets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_usuario;
import com.besixplus.sii.objects.InfoConfiguracion;
import com.google.gson.Gson;

public class DatosConfiguracionTct extends HttpServlet {

	ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie> datoEspecie = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_especie>();
	ArrayList<com.besixplus.sii.objects.Cgg_pais> datoPais = new ArrayList<com.besixplus.sii.objects.Cgg_pais>();
	ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> datoAeropuerto = new ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto>();
	ArrayList<com.besixplus.sii.objects.Cgg_res_aerolinea> datoAerolinea = new ArrayList<com.besixplus.sii.objects.Cgg_res_aerolinea>();
	ArrayList<com.besixplus.sii.objects.Cgg_res_documento_identificacio> datoTipoDocumento = new ArrayList<com.besixplus.sii.objects.Cgg_res_documento_identificacio>();	
	ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_hospedaje> datoTipoHospedaje = new ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_hospedaje>();
	ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> datoTipoActividad = new ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad>();
	ArrayList<com.besixplus.sii.objects.Cgg_nacionalidad> datoNacionalidad = new ArrayList<com.besixplus.sii.objects.Cgg_nacionalidad>();
	ArrayList<com.besixplus.sii.objects.Cgg_configuracion> infoConfiguracion = new ArrayList<com.besixplus.sii.objects.Cgg_configuracion>();
	ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta_usuario> pvUsuario = new ArrayList<com.besixplus.sii.objects.Cgg_kdx_punto_venta_usuario>();
	ArrayList<com.besixplus.sii.objects.Cgg_canton> datoCanton = new ArrayList<com.besixplus.sii.objects.Cgg_canton>();

	ArrayList<HashMap<String,Object>> notificado = new ArrayList<HashMap<String,Object>>();
	ArrayList<HashMap<String,Object>> transeunte = new ArrayList<HashMap<String,Object>>();
	ArrayList<HashMap<String,Object>> excedido =  new ArrayList<HashMap<String,Object>>();

	ArrayList<HashMap<String,Object>> grupoTuristaRegistro = new ArrayList<HashMap<String,Object>>();

	com.besixplus.sii.objects.Historico1 historico1 = new com.besixplus.sii.objects.Historico1();	

	String exp1 = "",exp2 = "",expFinal ="";

	public DatosConfiguracionTct(){
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		InfoConfiguracion datoConfiguracion = null;
		Connection con = null;
		
		String cusuCodigo = request.getParameter("CUSU_CODIGO");
		String userName = "";		
		String numeroUsuario = "";
		

		con = ManagerConnection.getConnection();		

		try {
			con.setAutoCommit(false);
			
			numeroUsuario = this.getOnlyNumerics(cusuCodigo);
						
			datoEspecie = com.besixplus.sii.db.Cgg_kdx_especie.selectAll(con, userName, 1);					
			datoPais = com.besixplus.sii.db.Cgg_pais.selectAll(con, userName);						
			datoAeropuerto = com.besixplus.sii.db.Cgg_res_aeropuerto.selectAll(con, userName);						
			datoAerolinea = com.besixplus.sii.db.Cgg_res_aerolinea.selectAll(con, userName);						
			datoTipoDocumento = com.besixplus.sii.db.Cgg_res_documento_identificacio.selectAll(con, userName);			
			datoTipoHospedaje = com.besixplus.sii.db.Cgg_tct_tipo_hospedaje.selectAll(con, userName);			
			datoTipoActividad = com.besixplus.sii.db.Cgg_tct_actividad.selectAll(con, userName);			
			datoNacionalidad = com.besixplus.sii.db.Cgg_nacionalidad.selectAll(con, userName);
			infoConfiguracion = com.besixplus.sii.db.Cgg_configuracion.selectAll(con, userName);
			pvUsuario = com.besixplus.sii.db.Cgg_kdx_punto_venta.selectPuntoUsuario(con, userName,"");
			datoCanton = com.besixplus.sii.db.Cgg_canton.selectAll(con, userName);

			notificado = com.besixplus.sii.db.Cgg_tct_registro.selectNotificadoOffline(con);
			transeunte = com.besixplus.sii.db.Cgg_tct_registro.selectTranseunteOffline(con);
			excedido = com.besixplus.sii.db.Cgg_tct_registro.selectExcedidoDiasOffline(con);
			grupoTuristaRegistro = com.besixplus.sii.db.Cgg_tct_registro.selectGrupoTuristaRegistroOffline(con);

			datoConfiguracion = new InfoConfiguracion();
			datoConfiguracion.setCgg_kdx_especie(datoEspecie);
			datoConfiguracion.setCgg_pais(datoPais);
			datoConfiguracion.setCgg_res_aeropuerto(datoAeropuerto);
			datoConfiguracion.setCgg_res_aerolinea(datoAerolinea);
			datoConfiguracion.setCgg_res_documento_identificacio(datoTipoDocumento);
			datoConfiguracion.setCgg_tct_tipo_hospedaje(datoTipoHospedaje);
			datoConfiguracion.setCgg_tct_actividad(datoTipoActividad);
			datoConfiguracion.setCgg_nacionalidad(datoNacionalidad);
			datoConfiguracion.setCgg_configuracion(infoConfiguracion);
			datoConfiguracion.setCgg_kdx_punto_venta_usuario(pvUsuario);
			datoConfiguracion.setCgg_canton(datoCanton);
			datoConfiguracion.setCgg_offline_numeracion_grupo(com.besixplus.sii.db.Cgg_tct_registro.getNumeracionGrupoOffline(numeroUsuario, con));
			datoConfiguracion.setCgg_offline_numeracion_registro(com.besixplus.sii.db.Cgg_tct_registro.getNumeracionRegistroOffline(numeroUsuario, con));

			exp1 = new Gson().toJson(datoConfiguracion);									

			historico1.setNotificado(notificado);
			historico1.setExcedido(excedido);
			historico1.setTranseunte(transeunte);		
			historico1.setGrupoTuristaRegistro(grupoTuristaRegistro);

			exp2 = new JSONObject(historico1).toString();	

			expFinal ="["+exp1+","+exp2+"]"; 

		} catch (SQLException e) {			
			response.getWriter().println(e.getMessage());			
		}	

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		if(request.getParameter("tipo").equalsIgnoreCase("file")){
			
			ServletOutputStream out = response.getOutputStream();
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			String zipFileName = "tct";

			String tmpStringBuffer = expFinal;			
			ZipOutputStream zos = new ZipOutputStream(bout);
			ByteArrayInputStream fis = new ByteArrayInputStream(tmpStringBuffer.getBytes());
			zos.putNextEntry(new ZipEntry("tct.data"));
			int size = 0;
			byte[] buffer = new byte[1024];

			while ((size = fis.read(buffer, 0, buffer.length)) > 0) {
				zos.write(buffer, 0, size);
			}
			zos.closeEntry();
			fis.close();
			zos.close();

			response.setHeader("cache-control", "no-cache");	
			response.setHeader("Content-Disposition","attachment; filename="+zipFileName+".zip;");
			response.setContentType("application/zip");

			out.write(bout.toByteArray());
			out.flush();
			out.close();
			bout.close();																							
															
		}else{				
			response.setContentType("text/html;charset=utf-8");								
			response.getWriter().println(expFinal);
		}						
	}
	
	public String getOnlyNumerics(String str) {
	    
	    if (str == null) {
	        return null;
	    }

	    StringBuffer strBuff = new StringBuffer();
	    char c;
	    
	    for (int i = 0; i < str.length() ; i++) {
	        c = str.charAt(i);
	        
	        if (Character.isDigit(c)) {
	            strBuff.append(c);
	        }
	    }
	    return strBuff.toString();
	}
}
