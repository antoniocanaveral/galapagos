package com.besixplus.sii.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ManagerConnection {
	private static String USER_NAME = null;
	private static String PASSWORD = null;
	private static String myAppUserName = null;
	private static DataSource DATA_SOURCE = null;
	private static boolean IS_DEPLOYED = false;

	public ManagerConnection(){
	}

	public static Connection getConnection(){

		try {
			if(ManagerConnection.DATA_SOURCE == null){
				try{
					ManagerConnection.DATA_SOURCE = (DataSource)new InitialContext().lookup("java:jdbc/sii");
					ManagerConnection.IS_DEPLOYED= true;
				} catch (NamingException e) {
					e.printStackTrace();
					ManagerConnection.IS_DEPLOYED= false;						
				} 				
			}
			if(!ManagerConnection.IS_DEPLOYED){
				try {
					DriverManager.registerDriver(new org.postgresql.Driver());
					Properties prop = new Properties();
					ManagerConnection.setUserName("sii");
					ManagerConnection.setPassword("sii2011test");
					prop.put("user", ManagerConnection.getUserName());
					prop.put("password", ManagerConnection.getPassword());
					return DriverManager.getConnection("jdbc:postgresql://190.95.187.82/cgg", prop);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else
				return ManagerConnection.DATA_SOURCE.getConnection();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}

	public static String getUserName() {
		return ManagerConnection.USER_NAME;
	}
	public static void setUserName(String myUserName) {
		ManagerConnection.USER_NAME = myUserName;
	}

	public static String getPassword() {
		return ManagerConnection.PASSWORD;
	}
	public static void setPassword(String myPassword) {
		ManagerConnection.PASSWORD = myPassword;
	}

	public static void setAppUserName(String myAppUserName) {
		ManagerConnection.myAppUserName = myAppUserName;
	}
	public static String getAppUserName() {
		return myAppUserName;
	}
	/**
	 * SI LA CONEXION DE BASE DE DATOS ES ADMINISTRADA POR EL SERVIDOR DE APLICACIONES
	 * @return
	 */
	public static boolean isDeployed(){
		return ManagerConnection.IS_DEPLOYED;
	}
}
