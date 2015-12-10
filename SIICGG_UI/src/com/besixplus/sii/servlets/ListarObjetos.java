package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.besixplus.sii.objects.ServerResponse;

public class ListarObjetos extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 3617013655726283946L;

	private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
	private String realServletPath = null;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	/**Process the HTTP service request.
	 */
	public void service(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
		ServerResponse outResponse = new ServerResponse();
		if(request.getParameter("request")!= null && request.getParameter("request").equals("fill")){
			realServletPath = request.getSession().getServletContext().getRealPath("/")+"forms";
			String tmpRes = new com.besixplus.sii.objects.ListarObjetos(realServletPath).fillObjetcs();
			if(tmpRes.equals("true"))
				outResponse.setSuccess(true);
			else{
				outResponse.setSuccess(false);
				outResponse.setMsg(tmpRes);
			}
		}
		response.setContentType("text/html");
		response.getWriter().write(new JSONObject(outResponse).toString());
	}

	
}
