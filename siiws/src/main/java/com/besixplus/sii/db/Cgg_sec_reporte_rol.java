package com.besixplus.sii.db;

/*import java.util.ArrayList;
import java.util.HashMap;*/
import java.io.Serializable;
import java.sql.CallableStatement;
/*import java.sql.ResultSet;
import java.sql.Savepoint;*/
import java.sql.SQLException;
/*import java.sql.Types;*/

/**
* CLASE Cgg_sec_reporte_rol
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_sec_reporte_rol.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_sec_reporte_rol implements Serializable{
	private static final long serialVersionUID = 1672837959;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_sec_reporte_rol.
	*/
	private com.besixplus.sii.objects.Cgg_sec_reporte_rol myCgg_sec_reporte_rol = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_reporte_rol.
	*/
	public Cgg_sec_reporte_rol(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_sec_reporte_rol.
	* @param inCgg_sec_reporte_rol OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_sec_reporte_rol.
	*/
	public Cgg_sec_reporte_rol(
		com.besixplus.sii.objects.Cgg_sec_reporte_rol inCgg_sec_reporte_rol
	){
		this.setCgg_sec_reporte_rol(inCgg_sec_reporte_rol);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_sec_reporte_rol.
	* @param inCgg_sec_reporte_rol OBJETO Cgg_sec_reporte_rol.
	* @return void
	*/
	public void setCgg_sec_reporte_rol(com.besixplus.sii.objects.Cgg_sec_reporte_rol inCgg_sec_reporte_rol){
		this.myCgg_sec_reporte_rol = inCgg_sec_reporte_rol;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_sec_reporte_rol.
	* @return Cgg_sec_reporte_rol OBJETO Cgg_sec_reporte_rol.
	*/
	public com.besixplus.sii.objects.Cgg_sec_reporte_rol getCgg_sec_reporte_rol(){
		return this.myCgg_sec_reporte_rol;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_sec_reporte_rol.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_SEC_REPORTE_ROL_INSERT_DELETE(?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_sec_reporte_rol().getCSRPR_CODIGO());
			stmInsert.setString(3, this.getCgg_sec_reporte_rol().getCSROL_CODIGO());
			stmInsert.setString(4, this.getCgg_sec_reporte_rol().getCSRPT_CODIGO());
			stmInsert.setBoolean(5, this.getCgg_sec_reporte_rol().getCSRPR_ESTADO());
			stmInsert.setString(6, this.getCgg_sec_reporte_rol().getCSRPR_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_sec_reporte_rol().setCSRPR_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
}