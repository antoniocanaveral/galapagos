package com.besixplus.sii.db;

import com.besixplus.sii.util.InitParameters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * CLASE PUBLICA 
 * CENTRALIZA EL MANEJO DE LA CONEXION A LA BASE DE DATOS.
 * @author BESIXPLUS CIA. LTDA.
 */
public class ManagerConnection {
	private static String USER_NAME = null;
	private static String PASSWORD = null;
	private static String myAppUserName = null;
	private static DataSource DATA_SOURCE = null;
	private static boolean IS_DEPLOYED = false;
	private static Session MAIL_SESSION = null;
	private static String USER_NAME_DB = "";
	private static  String PASS_DB = "";
	private static String IP_DB = "";
	private static String DATABASE_NAME = "";
	private InitParameters initParameters= new InitParameters();
	private static final String APP_NAME = "siiws";

	/**
	 * CONSTRUCTOR DE ManagerConecction
	 */
	public ManagerConnection(){
		initParameters = new InitParameters();
		DATABASE_NAME = initParameters.getNombreBDD();
		IP_DB = initParameters.getIpBDD();
		USER_NAME_DB = initParameters.getUserBdd();
		PASS_DB= initParameters.getPasswordBDD();
	}

	/** ESTABLECE LA CONEXION.
	 * @return CONEXION.
	 */
	public synchronized static Connection getConnection(){

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
					ManagerConnection.setUserName(USER_NAME_DB);
					ManagerConnection.setPassword(PASS_DB);
					prop.put("user", ManagerConnection.getUserName());
					prop.put("password", ManagerConnection.getPassword());
					//jdbc:postgresql://localhost:5435/MyDB?ApplicationName=MyApp
					prop.put("ApplicationName",APP_NAME);
					return DriverManager.getConnection("jdbc:postgresql://"+IP_DB+"/"+DATABASE_NAME, prop);
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

	/**OBTIENE LA SESION ESTABLECIDA A LA BASE DE DATOS
	 * @return SESION
	 */
	public synchronized static Session getMailSession(){
		if(MAIL_SESSION == null)
			try {
				MAIL_SESSION = (Session) new InitialContext().lookup("java:/Mail");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		return MAIL_SESSION;
	}

	/**OBTIENE EL NOMBRE DE USUARIO DE LA CONEXION
	 * @return NOMBRE DE USUARIO.
	 */
	public static String getUserName() {
		return ManagerConnection.USER_NAME;
	}
	/**ESTABLECE EL NOMBRE DE USUARIO DE LA CONEXION A LA BASE DE DATOS
	 * @param myUserName NOMBRE DE USUARIO 
	 */
	public static void setUserName(String myUserName) {
		ManagerConnection.USER_NAME = myUserName;
	}

	/**OBTIENE EL PASSWORD DEL USUARIO QUE SE CONECTO A LA BASE DE DATOS.
	 * @return PASSWORD
	 */
	public static String getPassword() {
		return ManagerConnection.PASSWORD;
	}
	/**ESTABLECE EL PASSWORD DEL USUARIO QUE SE CONECTO A LA BASE DE DATOS.
	 * @param myPassword IDENTFICATIVO DE PASSWORD
	 */
	public static void setPassword(String myPassword) {
		ManagerConnection.PASSWORD = myPassword;
	}

	/** ESTABLECE EL NOMBRE DE USUARIO DE LA CONEXION A LA BASE DE DATOS.
	 * @param myAppUserName NOMBRE DE USUARIO.
	 */
	public static void setAppUserName(String myAppUserName) {
		ManagerConnection.myAppUserName = myAppUserName;
	}
	/**OBTIENE EL NOMBRE DE USUARIO DE LA CONEXION A LA BASE DE DATOS.
	 * @return
	 */
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
