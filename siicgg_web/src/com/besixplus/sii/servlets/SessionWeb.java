package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;

/**
 * Servlet implementation class SessionManager
 */
public class SessionWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionWeb() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			Connection tmpCon = ManagerConnection.getConnection();
			tmpCon.setAutoCommit(false);
			com.besixplus.sii.db.ManagerConnection.setAppUserName(request.getUserPrincipal().getName());
			com.besixplus.sii.objects.Cgg_configuracion objConfig = new com.besixplus.sii.objects.Cgg_configuracion();
			objConfig.setCGCNF_CODIGO("CONF28");				
			String val = new com.besixplus.sii.db.Cgg_configuracion(objConfig).select(tmpCon).getCGCNF_VALOR_CADENA();
			PrintWriter out = response.getWriter();
			out.println(true);
			tmpCon.setAutoCommit(true);
			tmpCon.close();
			if(request.getParameter("request") != null && request.getParameter("request").equals("logout")){
				request.getSession().invalidate();
				response.sendRedirect(response.encodeRedirectURL("/"+val));
			}
			response.setContentType("text/html");
			response.getWriter().println("{\"success\":\"true\",\"msg\":\"true\"");
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
	}
}
