package com.besixplus.sii.servlets;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_sec_objeto;
import org.reflections.Reflections;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListarObjetos extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 3617013655726283946L;

	//private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

	private static List<String> classNames;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		classNames = new ArrayList<>();
	}

	/**Process the HTTP service request.
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//response.setContentType(CONTENT_TYPE);
			if(request.getParameter("request")!= null && request.getParameter("request").equals("fill")){
				if(classNames==null || classNames.size()==0){
					Reflections reflections = new Reflections("com.besixplus.sii.ws");
					Set<Class<? extends Serializable>> allClasses = reflections.getSubTypesOf(Serializable.class);
					for(Class c:allClasses){
						classNames.add(c.getCanonicalName());
					}
				}
				try {
					Connection tmpCon = ManagerConnection.getConnection();
					Method[] tmpBaseMethods = Object.class.getMethods();
					Set<String> tmpBaseMethodNames = new HashSet<String>();
					for(int i = 0; i < tmpBaseMethods.length; i++){
						tmpBaseMethodNames.add(tmpBaseMethods[i].getName());
					}
					
					for(int j = 0; j < classNames.size(); j++){
						String tmpPath = classNames.get(j);
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
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}
