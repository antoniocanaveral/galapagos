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

import com.besixplus.sii.db.Cgg_canton;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.misc.CGGEnumerators;
import com.besixplus.sii.objects.InfoConfigNotificacion;
import com.google.gson.Gson;

public class DatosConfigNotificacion extends HttpServlet {


	ArrayList<com.besixplus.sii.objects.Cgg_canton> datoCanton = new ArrayList<com.besixplus.sii.objects.Cgg_canton>();
	ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion> datoTipoNotificacion = new ArrayList<com.besixplus.sii.objects.Cgg_res_tipo_notificacion>();

	ArrayList<HashMap<String,Object>> persona_notificacion = new ArrayList<HashMap<String,Object>>();
	ArrayList<HashMap<String,Object>> oficial_notificacion = new ArrayList<HashMap<String,Object>>();


	ArrayList<HashMap<String,Object>> notificado = new ArrayList<HashMap<String,Object>>();
	String movilidad_residente =  null;

	String exp1 = "",exp2 = "",expFinal ="";

	public DatosConfigNotificacion(){
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InfoConfigNotificacion datoConfigNotificacion = null;
		Connection con = null;
		String userName = "";//arg0.getUserPrincipal().getName();	
		
		con = ManagerConnection.getConnection();		

		try {
			con.setAutoCommit(false);
			datoCanton = com.besixplus.sii.db.Cgg_canton.selectAll(con, userName);						
			datoTipoNotificacion = com.besixplus.sii.db.Cgg_res_tipo_notificacion.selectAll(con, userName);
			oficial_notificacion = com.besixplus.sii.db.Cgg_res_notificacion.selectOficialSelectoff(con, userName);
			notificado = com.besixplus.sii.db.Cgg_tct_registro.selectNotificadoOffline(con);

			movilidad_residente = new com.besixplus.sii.db.Cgg_res_movilidad().selectResidenteFormato(con,userName,CGGEnumerators.TIPOFORMATO.JSON.getValue());			

			//persona_notificacion = com.besixplus.sii.db.Cgg_res_notificacion.selectPersonaSelectoff(con, userName , in_Canton);

			datoConfigNotificacion = new InfoConfigNotificacion();
			datoConfigNotificacion.setCgg_canton(datoCanton);
			datoConfigNotificacion.setCgg_tipo_notificacion(datoTipoNotificacion);
			datoConfigNotificacion.setOficial_seguimiento(oficial_notificacion);
			datoConfigNotificacion.setNotificado(notificado);

			exp1 = new JSONObject(datoConfigNotificacion).toString();

			expFinal ="["+exp1+","+movilidad_residente+"]"; 
			con.setAutoCommit(true);
			con.close();					

		}  catch (SQLException e) {			
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
			String zipFileName = "not";

			String tmpStringBuffer = expFinal;			
			ZipOutputStream zos = new ZipOutputStream(bout);
			ByteArrayInputStream fis = new ByteArrayInputStream(tmpStringBuffer.getBytes());
			zos.putNextEntry(new ZipEntry("not.data"));
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
		}			
	}			
}
