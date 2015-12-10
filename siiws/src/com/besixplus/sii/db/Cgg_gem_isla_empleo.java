package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
/**import java.sql.Savepoint;*/
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_gem_isla_empleo
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_gem_isla_empleo.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_gem_isla_empleo implements Serializable{
	private static final long serialVersionUID = 1183640267;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_gem_isla_empleo.
	*/
	private com.besixplus.sii.objects.Cgg_gem_isla_empleo myCgg_gem_isla_empleo = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_isla_empleo.
	*/
	public Cgg_gem_isla_empleo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_gem_isla_empleo.
	* @param inCgg_gem_isla_empleo OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_gem_isla_empleo.
	*/
	public Cgg_gem_isla_empleo(
		com.besixplus.sii.objects.Cgg_gem_isla_empleo inCgg_gem_isla_empleo
	){
		this.setCgg_gem_isla_empleo(inCgg_gem_isla_empleo);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_gem_isla_empleo.
	* @param inCgg_gem_isla_empleo OBJETO Cgg_gem_isla_empleo.
	* @return void
	*/
	public void setCgg_gem_isla_empleo(com.besixplus.sii.objects.Cgg_gem_isla_empleo inCgg_gem_isla_empleo){
		this.myCgg_gem_isla_empleo = inCgg_gem_isla_empleo;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_gem_isla_empleo.
	* @return Cgg_gem_isla_empleo OBJETO Cgg_gem_isla_empleo.
	*/
	public com.besixplus.sii.objects.Cgg_gem_isla_empleo getCgg_gem_isla_empleo(){
		return this.myCgg_gem_isla_empleo;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_gem_isla_empleo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_ISLA_EMPLEO_INSERT(?, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_gem_isla_empleo().getCGISE_CODIGO());
			stmInsert.setString(3, this.getCgg_gem_isla_empleo().getCGVCN_CODIGO());
			stmInsert.setString(4, this.getCgg_gem_isla_empleo().getCISLA_CODIGO());
			stmInsert.setString(5, this.getCgg_gem_isla_empleo().getCGISE_DIRECCION());
			stmInsert.setBoolean(6, this.getCgg_gem_isla_empleo().getCGISE_ESTADO());
			stmInsert.setString(7, this.getCgg_gem_isla_empleo().getCGISE_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_gem_isla_empleo().setCGISE_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}
	
	/**
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_gem_isla_empleo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_GEM_ISLA_EMPLEO_UPDATE(?, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_gem_isla_empleo().getCGISE_CODIGO());
			stmUpdate.setString(2, this.getCgg_gem_isla_empleo().getCGVCN_CODIGO());
			stmUpdate.setString(3, this.getCgg_gem_isla_empleo().getCISLA_CODIGO());
			stmUpdate.setString(4, this.getCgg_gem_isla_empleo().getCGISE_DIRECCION());
			stmUpdate.setBoolean(5, this.getCgg_gem_isla_empleo().getCGISE_ESTADO());
			stmUpdate.setString(6, this.getCgg_gem_isla_empleo().getCGISE_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_gem_isla_empleo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inCgvcn_codigo CODIGO FORANEO DE LA TABLA Cgg_gem_vacante
	* @param inCgisla_codigo CODIGO FORANEO DE LA TABLA Cgg_isla	* 
	* @return ArrayList<com.besixplus.sii.objects.Cgg_gem_isla_empleo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllByFkId(
		java.sql.Connection inConnection,
		String inUserName,
		String inCgvcn_codigo		
	){
		ArrayList<HashMap<String,Object>> outCgg_gem_isla_empleo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_GEM_ISLA_EMPLEO_SELECT(?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setString(3, inCgvcn_codigo);			
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_gem_isla_empleo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_gem_isla_empleo;
	}
	
	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_gem_isla_empleo DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean delete(
		java.sql.Connection inConnection
	){
		boolean outResult = true;				
		try{					
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_GEM_ISLA_EMPLEO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_gem_isla_empleo().getCGISE_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}		
		return outResult;
	}
}