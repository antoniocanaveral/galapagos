package com.besixplus.sii.servlets;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.db.SQLErrorHandler;
import com.besixplus.sii.objects.Cgg_configuracion;

/**
 * Servlet implementation class DocViewer
 */
public class DocViewer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String realPath = null; 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DocViewer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		realPath = getServletConfig().getServletContext().getRealPath(String.valueOf(File.separatorChar));
	}
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		String tmpSessionID = request.getUserPrincipal().getName();
		String tmpTableName = request.getParameter("table");
		String tmpFileName = request.getParameter("fn").replace(" ", "_");
		String tmpFileExt = tmpFileName.substring(tmpFileName.lastIndexOf(".")+1).trim().toUpperCase();
		String tmpKeyColumn = request.getParameter("keyc");
		String tmpKeyValue = request.getParameter("keyv");
		String tmpColumn = request.getParameter("column");
		String tmpRelativePath = "tmp"+File.separatorChar+tmpSessionID;
		String tmpRootSessionFolder = realPath+File.separatorChar+tmpRelativePath;
		ManagerConnection.setAppUserName(request.getUserPrincipal().getName());
		String tmpRes = "100";
		String tmpRequest = request.getParameter("request").trim().toLowerCase();

		byte[] tmpContentFile = null ;
		try {
			Connection tmpCon = ManagerConnection.getConnection();
			tmpCon.setAutoCommit(false);
			CallableStatement tmpStm = tmpCon.prepareCall("{ ? = call SII.F_GET_FILE(?,?,?,?) }");
			tmpStm.registerOutParameter(1, Types.OTHER);
			tmpStm.setString(2, tmpTableName);
			tmpStm.setString(3, tmpKeyColumn);
			tmpStm.setString(4, tmpKeyValue);
			tmpStm.setString(5, tmpColumn);
			tmpStm.execute();
			ResultSet res = (ResultSet) tmpStm.getObject(1);
			while(res.next()){
				tmpContentFile = res.getBytes(1);
			}
			res.close();
			Cgg_configuracion tmpConf = new Cgg_configuracion();
			tmpConf.setCGCNF_CODIGO("CONF3");
			new com.besixplus.sii.db.Cgg_configuracion(tmpConf).select(tmpCon);
			tmpRes = String.valueOf(tmpConf.getCGCNF_VALOR_NUMERICO());

			tmpCon.close();
		} catch (SQLException e) {
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}

		if(new File(tmpRootSessionFolder).exists()==false){
			new File(tmpRootSessionFolder).mkdirs();
		}

		FileOutputStream tmpOS;
		try {
			if(tmpContentFile != null){
				tmpOS = new FileOutputStream(tmpRootSessionFolder+File.separatorChar+tmpFileName);
				tmpOS.write(tmpContentFile);
				tmpOS.close();
				if(tmpRequest.equals("view")){
					StringBuilder tmpPag = null;
					if(tmpFileExt.equals("PDF")){				
						new File(tmpRootSessionFolder+File.separatorChar+"img").mkdirs();
						Process p = Runtime.getRuntime().exec("pdfshow "+tmpRootSessionFolder+File.separatorChar+tmpFileName+" pagetree");
						BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
						String tmpPageCount = null; 
						String line;
						while ((line = input.readLine()) != null) {
							if(line.trim().length()>0)
								tmpPageCount = line.split(" ")[1];
						}
						input.close();
						p = Runtime.getRuntime().exec("pdfdraw -r"+tmpRes+" -o "+tmpRootSessionFolder+File.separatorChar+"img"+File.separatorChar+"pag%d.png "+tmpRootSessionFolder+File.separatorChar+tmpFileName);
						try {
							p.waitFor();
						} catch (InterruptedException e) {
							SQLErrorHandler.errorHandler(e);
						}
						tmpPag = new StringBuilder("<html><head></head><link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/bsxStyle.css\"/><script>function loadImage(inId){\r\ntry{\r\nvar tmpImg=document.getElementById(inId);\r\ntmpImg.src=\""+tmpRelativePath+"/img/\"+inId+\".png\";\r\n}catch(inException){\r\nsetTimeout(loadImage(inId), 1000);\r\n}\r\n}</script><body class=\"docViewer\" onload=\"loadImage('pag1')\"><div>");
						for(int i = 0; i < Integer.valueOf(tmpPageCount); i++){
							tmpPag.append("<img id=\"pag"+(i+1)+"\" class=\"docPage\" "+( i!=Integer.valueOf(tmpPageCount)-1?"onload=\"loadImage('pag"+(i+2)+"')\"":"") +"><br><div class=\"docPageNum\">"+"PAG. "+(i+1)+"</div><br>");
						}
						tmpPag.append("</div></body></html>");
						response.setContentType("text/html");
						response.getWriter().write(tmpPag.toString());				
					}else if(tmpFileExt.equals("JPG") || tmpFileExt.equals("JPEG")){
						tmpPag = new StringBuilder("<html><head></head><body><img src=\""+tmpRelativePath+"/"+tmpFileName+"\"></body></html>");
						response.setContentType("text/html");
						response.getWriter().write(tmpPag.toString());
					}else{
						ServletOutputStream out = response.getOutputStream();			
						response.setHeader("cache-control", "no-cache");									
						response.setHeader("Content-Disposition", "attachment;filename=\"" + tmpFileName + "\"");			
						response.setContentType("application/"+tmpFileName.substring(tmpFileName.lastIndexOf(".")+1));					
						out.write(tmpContentFile);			
						out.flush();
						out.close();
					}
				}else if(tmpRequest.equals("download")){
					ServletOutputStream out = response.getOutputStream();			
					response.setHeader("cache-control", "no-cache");									
					response.setHeader("Content-Disposition", "attachment;filename=\"" + tmpFileName + "\"");			
					response.setContentType("application/"+tmpFileName.substring(tmpFileName.lastIndexOf(".")+1));					
					out.write(tmpContentFile);			
					out.flush();
					out.close();
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}