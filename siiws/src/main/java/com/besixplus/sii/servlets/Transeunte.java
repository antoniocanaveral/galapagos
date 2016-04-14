package com.besixplus.sii.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.db.Cgg_configuracion;
import com.besixplus.sii.objects.Cgg_res_adjunto;
import com.besixplus.sii.objects.ServerResponse;

/**
 * Servlet implementation class Transeunte
 */
public class Transeunte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String realPath = null;  
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Transeunte() {
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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		String tmpSessionID = request.getUserPrincipal().getName();
		String inTranseunteIdentificacion = null;
		ArrayList<FileItem> objColeccionAdjunto = new ArrayList<FileItem>();
		ServerResponse appResponse = new ServerResponse();
		
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
			File file= null;
			List items;

			try {
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();

				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {						

						if(item.getFieldName().equals("inTranseunteIdentificacion"))
						{
							inTranseunteIdentificacion=item.getString();

						}
					} else {
						if(item.getFieldName().equals("inBeneficiarioAdjuntos")){
							objColeccionAdjunto.add(item);
							//file=new File(item.getName());
							//item.write(new File(tmpRootSessionFolder,file.getName()));
						}						
					}					
				}
				if(!objColeccionAdjunto.isEmpty()){
					String tmpRelativePath = "tmp"+File.separatorChar+tmpSessionID+File.separatorChar+inTranseunteIdentificacion;
					String tmpRootSessionFolder = realPath+File.separatorChar+tmpRelativePath;
					if(new File(tmpRootSessionFolder).exists()==false){
						new File(tmpRootSessionFolder).mkdirs();
					}
					else
					{
						boolean tmpDelete = deleteDir(new File(tmpRootSessionFolder));
						if(tmpDelete == true)
						{
							new File(tmpRootSessionFolder).mkdirs();
						}
					}
					//System.out.println(inTranseunteIdentificacion + " directorio " + tmpRootSessionFolder);
					for(FileItem tmpFileItem: objColeccionAdjunto){
						file = new File(tmpFileItem.getName());
						tmpFileItem.write(new File(tmpRootSessionFolder,file.getName()));
					}
				}

			} catch (FileUploadException e) {				
				outResult = e.getMessage();
				appResponse.setSuccess(false);
				appResponse.setMsg(outResult);
			} catch(Exception ex){				
				outResult = ex.getMessage();
				appResponse.setSuccess(false);
				appResponse.setMsg(outResult);
			}
			appResponse.setSuccess(true);
			appResponse.setMsg(outResult);	
			
			response.setContentType("text/html");
			response.getWriter().println(new JSONObject(appResponse).toString());
		}
	}
	
	private  boolean deleteDir(File dir) { 
		if (dir.isDirectory()) 
		{ 
			String[] children = dir.list(); 
			for (int i=0; i<children.length; i++) 
			{ 
				boolean success = deleteDir(new File(dir, children[i])); 
				if (!success) { return false; 
				} 
			}
		}  
		return dir.delete(); 
	}

}
