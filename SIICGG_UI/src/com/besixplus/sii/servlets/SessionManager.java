package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_res_persona;
import com.besixplus.sii.objects.Cgg_sec_sesion;
import com.besixplus.sii.objects.Cgg_usuario;


/**
 * Servlet implementation class SessionManager
 */
public class SessionManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionManager() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String,com.besixplus.sii.objects.Cgg_sec_sesion> tmpSessions = (HashMap<String,com.besixplus.sii.objects.Cgg_sec_sesion>) request.getSession().getAttribute("sessions");
		com.besixplus.sii.objects.Cgg_sec_sesion tmpSession = tmpSessions.get(request.getSession().getId());

		if(request.getParameter("request") != null && request.getParameter("request").equals("userobject") && 
				tmpSession != null && tmpSession.getCSSSN_ACTIVO()){
			String tmpZona = request.getParameter("timezone");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			try {
				Connection tmpCon = ManagerConnection.getConnection();
				tmpCon.setAutoCommit(false);
				Cgg_usuario tmpUsuario = new Cgg_usuario();
				Cgg_res_persona persona = new Cgg_res_persona();

				tmpUsuario.setCUSU_NOMBRE_USUARIO(request.getUserPrincipal().getName());
				HashMap<String, Object> tmpUsuarioPersona = new com.besixplus.sii.db.Cgg_usuario(tmpUsuario).selectByUsername(tmpCon);

				persona.setCRPER_CODIGO(tmpUsuario.getCRPER_CODIGO());
				persona = new com.besixplus.sii.db.Cgg_res_persona(persona).select(tmpCon);

				tmpUsuarioPersona.put("CRPER_CODIGO", persona.getCRPER_CODIGO());
				tmpUsuarioPersona.put("CRPER_NOMBRES", persona.getCRPER_NOMBRES());
				tmpUsuarioPersona.put("CRPER_APELLIDO_PATERNO", persona.getCRPER_APELLIDO_PATERNO());
				tmpUsuarioPersona.put("CRPER_APELLIDO_MATERNO", persona.getCRPER_APELLIDO_PATERNO());

				out.println(new JSONObject(tmpUsuarioPersona).toString());
				out.close();
				
				new com.besixplus.sii.db.Cgg_sec_sesion(tmpSession).selectByID(tmpCon);
				tmpSession.setCSSSN_ZONA_TIEMPO(tmpZona);
				new com.besixplus.sii.db.Cgg_sec_sesion(tmpSession).update(tmpCon);
				
				tmpCon.commit();
				tmpCon.close();		    		
			} catch (SQLException e) {
				e.printStackTrace();
				out.println(e.getMessage());				
			}			
		}else if(tmpSession != null && !tmpSession.getCSSSN_ACTIVO() || 
				request.getParameter("request") != null && request.getParameter("request").equals("logout")){
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath());
		}else if(request.getParameter("request") != null && request.getParameter("request").equals("activeSessions") &&
				tmpSession != null && tmpSession.getCSSSN_ACTIVO()){
			Connection tmpCon = ManagerConnection.getConnection();
			try {
				tmpCon.setAutoCommit(false);
				ArrayList<HashMap<String,Object>> tmpSesionesActivas = new com.besixplus.sii.db.Cgg_sec_sesion().selectAllActive(tmpCon);
				for (HashMap<String,Object> cggSecSesion : tmpSesionesActivas) {
					if(!tmpSessions.containsKey(cggSecSesion.get("CSSSN_ID").toString())){
						cggSecSesion.put("CSSSN_ACTIVO",false);
					}
				}
				response.setContentType("text/html");
				response.getWriter().println(new JSONArray(tmpSesionesActivas).toString());
				tmpCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(request.getParameter("request") != null && request.getParameter("request").equals("kill") &&
				tmpSession != null && tmpSession.getCSSSN_ACTIVO()){
			String tmpID = request.getParameter("id"); 
			tmpSession = tmpSessions.get(tmpID);
			if(tmpSession == null){
				Connection tmpCon = ManagerConnection.getConnection();
				try {
					tmpCon.setAutoCommit(false);
					tmpSession = new Cgg_sec_sesion();
					tmpSession.setCSSSN_ID(tmpID);
					new com.besixplus.sii.db.Cgg_sec_sesion(tmpSession).selectByID(tmpCon);
					tmpCon.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(tmpSession.getHTTP_SESSION() != null)
				tmpSession.getHTTP_SESSION().invalidate();
			else{
				try {
					Connection tmpCon = ManagerConnection.getConnection();
					tmpSession.setCSSSN_ACTIVO(false);
					new com.besixplus.sii.db.Cgg_sec_sesion(tmpSession).update(tmpCon);
					tmpSessions.remove(tmpSession.getCSSSN_ID());
					tmpCon.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
