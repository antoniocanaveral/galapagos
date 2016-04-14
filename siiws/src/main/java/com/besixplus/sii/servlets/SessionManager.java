package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.besixplus.sii.db.Cgg_sec_sesion;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_res_persona;
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

		if(tmpSession.getCUSU_CODIGO() == null){
			Cgg_usuario tmpUsuario = new Cgg_usuario();
			Connection tmpCon = ManagerConnection.getConnection();

			try {
				tmpCon.setAutoCommit(false);
				tmpUsuario.setCUSU_NOMBRE_USUARIO(request.getUserPrincipal().getName());
				new com.besixplus.sii.db.Cgg_usuario(tmpUsuario).selectByUsername(tmpCon);


				String ipAddress = request.getHeader("x-forwarded-for");
				if (ipAddress == null) {
					ipAddress = request.getHeader("X_FORWARDED_FOR");
					if (ipAddress == null){
						ipAddress = request.getRemoteAddr();
					}
				}
				String tmpZona = request.getParameter("timezone");
				tmpSession.setCSSSN_IP(ipAddress);
				tmpSession.setCUSU_CODIGO(tmpUsuario.getCUSU_CODIGO());
				tmpSession.setCUSU_NOMBRE_USUARIO(tmpUsuario.getCUSU_NOMBRE_USUARIO());
				tmpSession.setCSSSN_ZONA_TIEMPO(tmpZona);
				tmpSession.setCSSSN_ACTIVO(true);
				
				new Cgg_sec_sesion(tmpSession).insert(tmpCon);
				
				tmpCon.commit();
				tmpCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		if(request.getParameter("request") != null && request.getParameter("request").equals("username")){
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println(request.getUserPrincipal().getName());
			out.close();
			return;
		}else if(request.getParameter("request") != null && request.getParameter("request").equals("sessionid")){
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println(request.getSession().getId());
			out.close();
			return;
		}else if(request.getParameter("request") != null && request.getParameter("request").equals("userip")){
			String ipAddress = request.getHeader("x-forwarded-for");
			if (ipAddress == null) {
				ipAddress = request.getHeader("X_FORWARDED_FOR");
				if (ipAddress == null){
					ipAddress = request.getRemoteAddr();
				}
			}
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(ipAddress);
			out.close();
			return;
		}else if(request.getParameter("request") != null && request.getParameter("request").equals("userso")){
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println(request.getLocalName());
			out.close();
			return;
		}else if(request.getParameter("request") != null && request.getParameter("request").equals("userid")){
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			try {
				Connection tmpCon = ManagerConnection.getConnection();
				tmpCon.setAutoCommit(false);
				Cgg_usuario tmpUsuario = new Cgg_usuario();
				tmpUsuario = com.besixplus.sii.db.Cgg_usuario.selectAll(tmpCon, request.getUserPrincipal().getName()).get(0);				
				out.println("la respuesta es:"+tmpUsuario.getCUSU_CODIGO());
				out.close();
				tmpCon.close();		    		
			} catch (SQLException e) {
				e.printStackTrace();
				out.println(e.getMessage());				
			}			
		}else if(request.getParameter("request") != null && request.getParameter("request").equals("userobject")){
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
				tmpUsuarioPersona.put("CRPER_APELLIDO_MATERNO", persona.getCRPER_APELLIDO_MATERNO());
				tmpUsuarioPersona.put("CRPER_NUM_DOC_IDENTIFIC", persona.getCRPER_NUM_DOC_IDENTIFIC());

				out.println(new JSONObject(tmpUsuarioPersona).toString());
				out.close();
				tmpCon.close();		    		
			} catch (SQLException e) {
				e.printStackTrace();
				out.println(e.getMessage());				
			}			
		}else if(request.getParameter("request").equals("login")){

			try {
				Connection tmpCon = ManagerConnection.getConnection();
				tmpCon.setAutoCommit(false);
				
				com.besixplus.sii.db.ManagerConnection.setAppUserName(request.getUserPrincipal().getName());
				com.besixplus.sii.objects.Cgg_configuracion objConfig = new com.besixplus.sii.objects.Cgg_configuracion();
				objConfig.setCGCNF_CODIGO("CONF15");				
				String val = new com.besixplus.sii.db.Cgg_configuracion(objConfig).select(tmpCon).getCGCNF_VALOR_CADENA();
				PrintWriter out = response.getWriter();
				out.println(val);

				tmpCon.setAutoCommit(true);
				tmpCon.close();

				response.sendRedirect(response.encodeRedirectURL(val));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(tmpSession != null && !tmpSession.getCSSSN_ACTIVO() ||
				request.getParameter("request") != null && request.getParameter("request").equals("logout")){
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath());
		}


	}

}
