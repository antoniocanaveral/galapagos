package com.besixplus.sii.listeners;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.besixplus.sii.db.ManagerConnection;
import com.besixplus.sii.objects.Cgg_sec_sesion;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionListener {
	private HashMap<String, Cgg_sec_sesion> mySessions = null;
    /**
     * Default constructor. 
     */
    public SessionListener() {
    	mySessions = new HashMap<String, Cgg_sec_sesion>();
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public synchronized void sessionCreated(HttpSessionEvent arg0) {
    	Cgg_sec_sesion tmpSesion = new Cgg_sec_sesion();
		tmpSesion.setCSSSN_ACTIVO(false);
		tmpSesion.setCSSSN_CODIGO("KEYGEN");
		tmpSesion.setCSSSN_FECHA_FIN(null);
		tmpSesion.setCSSSN_FECHA_INICIO(new Timestamp(new Date().getTime()));
		tmpSesion.setCSSSN_ID(arg0.getSession().getId());
		tmpSesion.setCSSSN_IP(null);
		tmpSesion.setCUSU_CODIGO(null);
		tmpSesion.setHTTP_SESSION(arg0.getSession());
		tmpSesion.setCSSSN_CONTEXTO(arg0.getSession().getServletContext().getContextPath());
		mySessions.put(arg0.getSession().getId(), tmpSesion);

		arg0.getSession().setAttribute("sessions", mySessions);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public synchronized void sessionDestroyed(HttpSessionEvent arg0) {
    	Cgg_sec_sesion tmpSession = mySessions.get(arg0.getSession().getId());
		if(tmpSession != null){
			tmpSession.setCSSSN_FECHA_FIN( new Date());
			tmpSession.setCSSSN_ACTIVO(false);
			Connection tmpCon = ManagerConnection.getConnection();
			new com.besixplus.sii.db.Cgg_sec_sesion(tmpSession).update(tmpCon);
			mySessions.remove(arg0.getSession().getId());
			try {
				tmpCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }	
}
