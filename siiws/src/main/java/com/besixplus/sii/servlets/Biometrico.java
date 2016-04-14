package com.besixplus.sii.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

//import com.besixplus.biometric.types.FingerDevice;
//import com.besixplus.enbsp.win.Lector;
import com.besixplus.sii.db.Cgg_res_persona;
import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.mail.Base64;
import com.besixplus.sii.objects.ServerResponse;

/**
 * Servlet implementation class Biometrico
 */
public class Biometrico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private FingerDevice myLector = null;
	private ArrayList<HashMap<String,Object>> myHuellas = new ArrayList<HashMap<String,Object>>();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Biometrico() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		/*if(System.getProperty("os.name").contains("Windows"))
			myLector = new Lector();
		else
			myLector = new com.besixplus.enbsp.unix.Lector();*/
		loadData();
	}

	private void loadData() {
		Connection tmpCon = ManagerConnection.getConnection();
		try {
			tmpCon.setAutoCommit(false);
			myHuellas = Cgg_res_persona.selectHuellas(tmpCon);
			tmpCon.close();
		} catch (SQLException e) {
			e.printStackTrace();
			if(tmpCon!= null)
				try {
					tmpCon.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tmpOp = request.getParameter("op").trim().toUpperCase();
		String tmpData = request.getParameter("data").trim();
		String tmpID = null;
		ServerResponse appResponse = new ServerResponse();
		if(tmpOp.equals("IDENTIFY")){
			for(HashMap<String, Object> tmpPersona : myHuellas ){
				/*if(myLector.verify(tmpData, tmpPersona.get("CRPER_HUELLA_DACTILAR").toString())){
					appResponse.setMsg(tmpPersona.get("IDENTIFICADOR").toString());
					appResponse.setSuccess(true);
					break;
				}*/
			}
		}else if(tmpOp.equals("VERIFY")){
			tmpID = request.getParameter("id").trim();
			Connection tmpCon = ManagerConnection.getConnection();
			try {
				tmpCon.setAutoCommit(false);
				boolean tmpVerify = false;
				ArrayList<HashMap<String,Object>> myHuella = Cgg_res_persona.selectHuellas(tmpCon, tmpID);
				if (!myHuella.isEmpty())
				{
					for(HashMap<String, Object> tmpPersona : myHuella ){
						/*if(myLector.verify(tmpData, tmpPersona.get("CRPER_HUELLA_DACTILAR").toString())){
							tmpVerify = true;
							appResponse.setMsg(tmpID);
							appResponse.setSuccess(true);
							break;
						}*/
					}
					if (tmpVerify  == false)
						appResponse.setMsg("La informaci\u00f3n registrada no es coincidente con la suministrada.");
				}
				else
					appResponse.setMsg("No existe informaci\u00f3n dactilar asociada a la persona.");
				tmpCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(tmpOp.equals("UPDATE")){
			Connection tmpCon = ManagerConnection.getConnection();
			com.besixplus.sii.objects.Cgg_res_persona tmpPersona = new com.besixplus.sii.objects.Cgg_res_persona();
			try {
				//byte[] tmpImg = myLector.getImage(myLector.getExportAuditData(tmpData));
				String res = "true";
				//tmpCon.setAutoCommit(false);
				String tmpDataAudit = request.getParameter("dataAudit").trim();
				tmpID = request.getParameter("id").trim();
				tmpPersona.setCRPER_CODIGO(tmpID);
				tmpPersona.setCRPER_HUELLA_DACTILAR(tmpDataAudit);
				tmpPersona.setCRPER_HUELLA_CADENA(tmpData);
				//tmpPersona.setCRPER_HUELLA_IMAGEN(tmpImg);

				res = new Cgg_res_persona(tmpPersona).updateHuellaImagen(tmpCon);
				tmpCon.close();
				if (res.equals("true") )
				{
					appResponse.setSuccess(Boolean.valueOf(res));
					//appResponse.setMsg(Base64.encodeBytes(tmpImg));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(tmpOp.equals("RELOAD")){
			loadData();
		}else if(tmpOp.equals("PHOTO")){
			//byte[] tmpImg = myLector.getImage(myLector.getExportAuditData(tmpData));
			appResponse.setSuccess(true);
			//appResponse.setMsg(Base64.encodeBytes(tmpImg));
		}
		response.setContentType("text/html");
		response.getWriter().println(new JSONObject(appResponse).toString());
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//myLector.terminate();
		super.destroy();
	}
}
