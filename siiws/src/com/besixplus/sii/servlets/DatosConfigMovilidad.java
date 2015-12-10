package com.besixplus.sii.servlets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import com.besixplus.sii.misc.CGGEnumerators;
import com.besixplus.sii.objects.InfoConfigMovilidad;
import com.google.gson.Gson;

public class DatosConfigMovilidad extends HttpServlet {


	ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> datoAeropuerto = new ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto>();
	ArrayList<com.besixplus.sii.objects.Cgg_res_aerolinea> datoAerolinea = new ArrayList<com.besixplus.sii.objects.Cgg_res_aerolinea>();
	ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_hospedaje> datoTipoHospedaje = new ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_hospedaje>();
	ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> datoTipoActividad = new ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad>();
	
	ArrayList<com.besixplus.sii.objects.Cgg_pais> datoPais = new ArrayList<com.besixplus.sii.objects.Cgg_pais>();
	ArrayList<com.besixplus.sii.objects.Cgg_res_documento_identificacio> datoTipoDocumento = new ArrayList<com.besixplus.sii.objects.Cgg_res_documento_identificacio>();
	ArrayList<com.besixplus.sii.objects.Cgg_nacionalidad> datoNacionalidad = new ArrayList<com.besixplus.sii.objects.Cgg_nacionalidad>();
	
	ArrayList<HashMap<String,Object>> movilidad_ingreso = new ArrayList<HashMap<String,Object>>();
	ArrayList<HashMap<String,Object>> movilidad_salida = new ArrayList<HashMap<String,Object>>();
	String movilidad_residente =  null;
	//ArrayList<HashMap<String,Object>> grupo_actividad =  new ArrayList<HashMap<String,Object>>();
	//ArrayList<HashMap<String,Object>> grupo_hospedaje =  new ArrayList<HashMap<String,Object>>();


	com.besixplus.sii.objects.HistoricoMovi historicomovi = new com.besixplus.sii.objects.HistoricoMovi();
	String exp1 = "",exp2 = "",expFinal ="";

	public DatosConfigMovilidad(){
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		InfoConfigMovilidad datoConfigMovilidad = null;
		Connection con = null;
		String userName = request.getUserPrincipal().getName();		

		con = ManagerConnection.getConnection();		

		try {
			con.setAutoCommit(false);			

			datoAeropuerto = com.besixplus.sii.db.Cgg_res_aeropuerto.selectAll(con, userName);						
			datoAerolinea = com.besixplus.sii.db.Cgg_res_aerolinea.selectAll(con, userName);								
			datoTipoHospedaje = com.besixplus.sii.db.Cgg_tct_tipo_hospedaje.selectAll(con, userName);			
			datoTipoActividad = com.besixplus.sii.db.Cgg_tct_actividad.selectAll(con, userName);
			
			datoPais = com.besixplus.sii.db.Cgg_pais.selectAll(con, userName);
			datoTipoDocumento = com.besixplus.sii.db.Cgg_res_documento_identificacio.selectAll(con, userName);
			datoNacionalidad = com.besixplus.sii.db.Cgg_nacionalidad.selectAll(con, userName);

			movilidad_ingreso = com.besixplus.sii.db.Cgg_res_movilidad.selectMovilidadIngresoOffLine(con,userName);
			movilidad_salida = com.besixplus.sii.db.Cgg_res_movilidad.selectMovilidadSalidaOffLine(con,userName);
			movilidad_residente = new com.besixplus.sii.db.Cgg_res_movilidad().selectResidenteFormato(con,userName,CGGEnumerators.TIPOFORMATO.JSON.getValue());					
			
			//grupo_hospedaje = com.besixplus.sii.db.Cgg_tct_grupo_hospedaje.selectGrupohospedajeoff(con,userName);	
			//grupo_actividad = com.besixplus.sii.db.Cgg_tct_grupo_actividad.selectGrupoActividadoff(con,userName);			

			datoConfigMovilidad = new InfoConfigMovilidad();
			datoConfigMovilidad.setCgg_res_aeropuerto(datoAeropuerto);
			datoConfigMovilidad.setCgg_res_aerolinea(datoAerolinea);
			datoConfigMovilidad.setCgg_tct_tipo_hospedaje(datoTipoHospedaje);
			datoConfigMovilidad.setCgg_tct_actividad(datoTipoActividad);
			
			datoConfigMovilidad.setCgg_pais(datoPais);
			datoConfigMovilidad.setCgg_nacionalidad(datoNacionalidad);
			datoConfigMovilidad.setCgg_res_documento_identificacio(datoTipoDocumento);

			exp1 = new Gson().toJson(datoConfigMovilidad);

			historicomovi.setMovilidad_ingreso(movilidad_ingreso);
			historicomovi.setMovilidad_salida(movilidad_salida);
			//historicomovi.setMovilidad_residente(movilidad_residente);
			
			//historicomovi.setGrupo_hospedaje(grupo_hospedaje);
			//historicomovi.setGrupo_actividad(grupo_actividad);

			exp2 = new JSONObject(historicomovi).toString();
			expFinal ="["+exp1+","+exp2+","+movilidad_residente+"]"; 

			con.setAutoCommit(true);
			con.close();					

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
			String zipFileName = "mov";

			String tmpStringBuffer = expFinal;			
			ZipOutputStream zos = new ZipOutputStream(bout);
			ByteArrayInputStream fis = new ByteArrayInputStream(tmpStringBuffer.getBytes());
			zos.putNextEntry(new ZipEntry("mov.data"));
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
			response.setContentType("text/plain");
			response.getWriter().println(expFinal);
			System.out.println(expFinal);
		}					
	}

}
