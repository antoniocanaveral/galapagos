package com.besixplus.sii.servlets;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.ws.Cgg_configuracion;
import com.besixplus.sii.ws.Cgg_res_residencia;


/**
 * Clase para exportacion en formato de informacion de residente vigente para aerolineas.
 * @author BESIXPLUS
 *
 */
public class ExportableResidente extends HttpServlet {

	private static final long serialVersionUID = 1L;

	String res = null;
	Cgg_res_residencia residencia = new Cgg_res_residencia();
	Cgg_configuracion configuracion= new Cgg_configuracion();

	/**
	 * Constructor publico.
	 */
	public ExportableResidente(){
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String flag = "true";
		int tipoResidencia = 2;
		String formato  = "CSV";
		String expFinal = "";
		String dirExportable="";
		FileInputStream tmpInputStream =null;
		StringBuffer strContent = new StringBuffer("");

		try{
			tipoResidencia = Integer.parseInt(request.getParameter("TIPO_RESIDENCIA"));
		}catch(Exception ex){
			tipoResidencia = 2;
		}

		com.besixplus.sii.objects.Cgg_configuracion tmpConf = new com.besixplus.sii.objects.Cgg_configuracion();
		tmpConf.setCGCNF_CODIGO("CONF125");
		Connection tmpCon = ManagerConnection.getConnection();
		try {
			tmpCon.setAutoCommit(false);
			new com.besixplus.sii.db.Cgg_configuracion(tmpConf).select(tmpCon);
			tmpCon.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		dirExportable = tmpConf.getCGCNF_VALOR_CADENA();
		String strExportable= residencia.selectExportable(tipoResidencia);
		Connection tmpCon1 = ManagerConnection.getConnection();
		String s = null;
		try {
			s = "COPY ("+strExportable+") TO  '"+dirExportable+"/ExportableResidencia.csv' WITH DELIMITER ','";
			Statement tmpStm = tmpCon1.createStatement();
			tmpStm.execute(s);
			File file = new File(dirExportable+"/ExportableResidencia.csv");
			tmpStm.close();
			int ch;
			tmpInputStream=	new FileInputStream(file);
			tmpInputStream.toString();
			while( (ch = tmpInputStream.read()) != -1)
				strContent.append((char)ch);

			tmpCon1.close();
		} catch (SQLException e) {			
			e.printStackTrace();	
			flag = e.getMessage()+"\n"+s;
		} 

		//response.getWriter().println(s);

		if(flag.equalsIgnoreCase("true")){
			if(request.getParameter("TIPO").equalsIgnoreCase("ARCHIVO")){

				ServletOutputStream out = response.getOutputStream();
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				String zipFileName = "residente";

				//String tmpStringBuffer = expFinal;			
				ZipOutputStream zos = new ZipOutputStream(bout);
				ByteArrayInputStream fis = new ByteArrayInputStream(strContent.toString().getBytes());
				zos.putNextEntry(new ZipEntry("residente.csv"));
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
				response.getWriter().println(strContent);			
			}	
		}else{
			response.getWriter().println("Se presento un problema al momento de generar su informacion.\nError:"+flag);
		}
	}

}
