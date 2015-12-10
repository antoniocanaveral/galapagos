package com.besixplus.sii.servlets;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_sec_objeto;

public class ListarObjetos extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 3617013655726283946L;

	private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**Process the HTTP service request.
	 */
	public void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
			if(request.getParameter("request")!= null && request.getParameter("request").equals("fill")){
				SAXReader tmpXMLReader = new SAXReader();
				String tmpConfigPath = System.getProperty("jboss.server.config.url");
				Connection tmpCon = ManagerConnection.getConnection();
				try {
					Document tmpDocument = tmpXMLReader.read(tmpConfigPath+File.separatorChar+"sii-classes.xml");
					List<Element> list = tmpDocument.selectNodes( "/com/besixplus/sii/ws/class");
					Method[] tmpBaseMethods = Object.class.getMethods();
					Set<String> tmpBaseMethodNames = new HashSet<String>();
					for(int i = 0; i < tmpBaseMethods.length; i++){
						tmpBaseMethodNames.add(tmpBaseMethods[i].getName());
					}
					
					for(int j = 0; j < list.size(); j++){
						String tmpPath = list.get(j).getPath().replace("/", ".").substring(1);
						tmpPath = tmpPath.substring(0, tmpPath.lastIndexOf("."))+"."+list.get(j).attributeValue("name");
						try {
							
							Method[] tmpMethods = Class.forName(tmpPath).getMethods();
							for (int i = 0; i < tmpMethods.length; i++){
								if(!tmpBaseMethodNames.contains(tmpMethods[i].getName())){
									Cgg_sec_objeto tmpAppObject = new Cgg_sec_objeto();
									tmpAppObject.setCSOBJ_CODIGO("KEYGEN");
									tmpAppObject.setCSOBJ_ESTADO(true);
									tmpAppObject.setCSOBJ_NOMBRE(tmpMethods[i].getName());
									tmpAppObject.setCSOBJ_RUTA(tmpPath);
									tmpAppObject.setCSOBJ_TIPO(1);
									tmpAppObject.setCSOBJ_USUARIO_INSERT(request.getUserPrincipal().getName());
									tmpAppObject.setCSOBJ_USUARIO_UPDATE(request.getUserPrincipal().getName());
									new com.besixplus.sii.db.Cgg_sec_objeto(tmpAppObject).insert(tmpCon);
								}
							}
						} catch (SecurityException e) {
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
					tmpCon.close();
				} catch (DocumentException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}
