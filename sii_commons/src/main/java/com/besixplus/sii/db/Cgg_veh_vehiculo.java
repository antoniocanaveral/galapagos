package com.besixplus.sii.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.SQLException;
import java.sql.Types;

/**
* CLASE Cgg_veh_vehiculo
* ESTA CLASE CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_veh_vehiculo.
* @author BESIXPLUS CIA. LTDA.
*/
public class Cgg_veh_vehiculo implements Serializable{
	private static final long serialVersionUID = 1147791903;
	/**
	* VARIABLE QUE ALMACENA UNA INSTANCIA DE LA CLASE com.besixplus.sii.objects.Cgg_veh_vehiculo.
	*/
	private com.besixplus.sii.objects.Cgg_veh_vehiculo myCgg_veh_vehiculo = null;

	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_vehiculo.
	*/
	public Cgg_veh_vehiculo(){}
	/**
	* CONSTRUCTOR DE LA CLASE Cgg_veh_vehiculo.
	* @param inCgg_veh_vehiculo OBJETO QUE CONTIENE TODA LA INFORMACION NECESARIA PARA INSERTAR EN LA TABLA Cgg_veh_vehiculo.
	*/
	public Cgg_veh_vehiculo(
		com.besixplus.sii.objects.Cgg_veh_vehiculo inCgg_veh_vehiculo
	){
		this.setCgg_veh_vehiculo(inCgg_veh_vehiculo);
	}

	/**
	* ESTABLECE LA INSTANCIA DEL OBJETO Cgg_veh_vehiculo.
	* @param inCgg_veh_vehiculo OBJETO Cgg_veh_vehiculo.
	* @return void
	*/
	public void setCgg_veh_vehiculo(com.besixplus.sii.objects.Cgg_veh_vehiculo inCgg_veh_vehiculo){
		this.myCgg_veh_vehiculo = inCgg_veh_vehiculo;
	}
	/**
	* OBTIENE LA INSTANCIA DEL OBJETO Cgg_veh_vehiculo.
	* @return Cgg_veh_vehiculo OBJETO Cgg_veh_vehiculo.
	*/
	public com.besixplus.sii.objects.Cgg_veh_vehiculo getCgg_veh_vehiculo(){
		return this.myCgg_veh_vehiculo;
	}

	/**
	* INSERTA UN REGISTRO EN LA TABLA Cgg_veh_vehiculo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE INGRESO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String insert(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmInsert = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?, ?, ?, ?) }");
			stmInsert.registerOutParameter(1, java.sql.Types.VARCHAR);
			stmInsert.setString(2, this.getCgg_veh_vehiculo().getCVVEH_CODIGO());
			stmInsert.setString(3, this.getCgg_veh_vehiculo().getCVMRC_CODIGO());
			stmInsert.setString(4, this.getCgg_veh_vehiculo().getCVCLR_CODIGO());
			stmInsert.setString(5, this.getCgg_veh_vehiculo().getCVCTG_CODIGO());
			stmInsert.setString(6, this.getCgg_veh_vehiculo().getCSCTP_CODIGO());
			stmInsert.setString(7, this.getCgg_veh_vehiculo().getCVSCT_CODIGO());
			stmInsert.setString(8, this.getCgg_veh_vehiculo().getCGG_CVCLR_CODIGO());
			stmInsert.setString(9, this.getCgg_veh_vehiculo().getCVVEH_NOMBRE());
			stmInsert.setString(10, this.getCgg_veh_vehiculo().getCVVEH_MODELO());
			stmInsert.setInt(11, this.getCgg_veh_vehiculo().getCVVEH_TIPO());
			stmInsert.setInt(12, this.getCgg_veh_vehiculo().getCVVEH_ANIO_PRODUCCION());
			stmInsert.setString(13, this.getCgg_veh_vehiculo().getCVVEH_CHASIS());
			stmInsert.setString(14, this.getCgg_veh_vehiculo().getCVVEH_PLACA());
			stmInsert.setBytes(15, this.getCgg_veh_vehiculo().getCVVEH_FOTO());
			stmInsert.setBigDecimal(16, this.getCgg_veh_vehiculo().getCVVEH_ESLORA());
			stmInsert.setBigDecimal(17, this.getCgg_veh_vehiculo().getCVVEH_MANGA());
			stmInsert.setBigDecimal(18, this.getCgg_veh_vehiculo().getCVVEH_PUNTAL());
			stmInsert.setString(19, this.getCgg_veh_vehiculo().getCVVEH_MATERIAL());
			stmInsert.setBoolean(20, this.getCgg_veh_vehiculo().getCVVEH_INGRESO());
			stmInsert.setTimestamp(21, this.getCgg_veh_vehiculo().getCVVEH_FECHA_INGRESO()!=null?new java.sql.Timestamp(this.getCgg_veh_vehiculo().getCVVEH_FECHA_INGRESO().getTime()):null);
			stmInsert.setInt(22, this.getCgg_veh_vehiculo().getCVVEH_TIPO_INGRESO());
			stmInsert.setInt(23, this.getCgg_veh_vehiculo().getCVVEH_TIEMPO_ESTADIA());
			stmInsert.setBoolean(24, this.getCgg_veh_vehiculo().getCVVEH_SALIO());
			stmInsert.setTimestamp(25, this.getCgg_veh_vehiculo().getCVVEH_FECHA_SALIDA()!=null?new java.sql.Timestamp(this.getCgg_veh_vehiculo().getCVVEH_FECHA_SALIDA().getTime()):null);
			stmInsert.setString(26, this.getCgg_veh_vehiculo().getCVVEH_OBSERVACION());
			stmInsert.setBoolean(27, this.getCgg_veh_vehiculo().getCVVEH_ESTADO());
			stmInsert.setString(28, this.getCgg_veh_vehiculo().getCVVEH_USUARIO_INSERT());
			stmInsert.execute();
			this.getCgg_veh_vehiculo().setCVVEH_CODIGO(stmInsert.getString(1));
			stmInsert.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> selectAll(
		java.sql.Connection inConnection,
		String inUserName
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> outCgg_veh_vehiculo = new ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_SELECT_AS(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_vehiculo tmpCgg_veh_vehiculo = new com.besixplus.sii.objects.Cgg_veh_vehiculo();
				tmpCgg_veh_vehiculo.setCVVEH_CODIGO(results.getString(1));
				tmpCgg_veh_vehiculo.setCVMRC_CODIGO(results.getString(2));
				tmpCgg_veh_vehiculo.setCVCLR_CODIGO(results.getString(3));
				tmpCgg_veh_vehiculo.setCVCTG_CODIGO(results.getString(4));
				tmpCgg_veh_vehiculo.setCSCTP_CODIGO(results.getString(5));
				tmpCgg_veh_vehiculo.setCVSCT_CODIGO(results.getString(6));
				tmpCgg_veh_vehiculo.setCGG_CVCLR_CODIGO(results.getString(7));
				tmpCgg_veh_vehiculo.setCVVEH_NOMBRE(results.getString(8));
				tmpCgg_veh_vehiculo.setCVVEH_MODELO(results.getString(9));
				tmpCgg_veh_vehiculo.setCVVEH_TIPO(results.getInt(10));
				tmpCgg_veh_vehiculo.setCVVEH_ANIO_PRODUCCION(results.getInt(11));
				tmpCgg_veh_vehiculo.setCVVEH_CHASIS(results.getString(12));
				tmpCgg_veh_vehiculo.setCVVEH_PLACA(results.getString(13));
				tmpCgg_veh_vehiculo.setCVVEH_FOTO(results.getBytes(14));
				tmpCgg_veh_vehiculo.setCVVEH_ESLORA(results.getBigDecimal(15));
				tmpCgg_veh_vehiculo.setCVVEH_MANGA(results.getBigDecimal(16));
				tmpCgg_veh_vehiculo.setCVVEH_PUNTAL(results.getBigDecimal(17));
				tmpCgg_veh_vehiculo.setCVVEH_MATERIAL(results.getString(18));
				tmpCgg_veh_vehiculo.setCVVEH_INGRESO(results.getBoolean(19));
				tmpCgg_veh_vehiculo.setCVVEH_FECHA_INGRESO(results.getTimestamp(20));
				tmpCgg_veh_vehiculo.setCVVEH_TIPO_INGRESO(results.getInt(21));
				tmpCgg_veh_vehiculo.setCVVEH_TIEMPO_ESTADIA(results.getInt(22));
				tmpCgg_veh_vehiculo.setCVVEH_SALIO(results.getBoolean(23));
				tmpCgg_veh_vehiculo.setCVVEH_FECHA_SALIDA(results.getTimestamp(24));
				tmpCgg_veh_vehiculo.setCVVEH_OBSERVACION(results.getString(25));
				tmpCgg_veh_vehiculo.setCVVEH_ESTADO(results.getBoolean(26));
				outCgg_veh_vehiculo.add(tmpCgg_veh_vehiculo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo;
	}

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo QUE CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inUserName NOMBRE DEL USUARIO DEL SERVIDOR DE APLICACIONES.
	* @param inStart INDICE DE INICIO.
	* @param inLimit TOTAL DE REGISTRO QUE SON CONSIDERADOS.
	* @param inSortFieldName NOMBRE DE LA COLUMNA DE ORDENAMIENTO.
	* @param inDirection DIRECCION DEL ORDENAMIENTO (<code>ASC|DESC</code>).
	* @param inKeyword CRITERIO DE BUSQUEDA
	* @param inSW VISUALIZAR LOS VEHICULOS QUE TIENEN TRAMITE CONCLUIDOS.
	* @return ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> VECTOR DE OBJETOS EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	*/
	public static ArrayList<HashMap<String,Object>> selectAllDirect(
		java.sql.Connection inConnection,
		String inUserName,
		int inStart,
		int inLimit,
		String inSortFieldName,
		String inDirection,
		String inKeyword,
		boolean inSW
	){
		ArrayList<HashMap<String,Object>> outCgg_veh_vehiculo = new ArrayList<HashMap<String,Object>>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_SELECT(?,?,?,?,?,?,?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2, inUserName);
			stmSelect.setInt(3, inStart);
			stmSelect.setInt(4, inLimit);
			stmSelect.setString(5, inSortFieldName);
			stmSelect.setString(6, inDirection);
			stmSelect.setString(7, inKeyword);
			stmSelect.setBoolean(8, inSW);
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				outCgg_veh_vehiculo.add(tmpObj);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS EXISTEN EN LA TABLA Cgg_veh_vehiculo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return int TOTAL DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_COUNT() }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	* CONTABILIZA CUANTOS REGISTROS CUMPLEN CON EL CRITERIO DE BUSQUEDA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @param inKeyword CRITERIO DE BUSQUEDA.
	* @param inSW VISUALIZAR LOS VEHICULOS QUE TIENEN TRAMITE CONCLUIDOS.
	* @return int NUMERO DE REGISTROS.
	*/
	public static int selectCount(
		java.sql.Connection inConnection,
		String inKeyword,
		boolean inSW
	){
		int outCount = 0;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_COUNT(?,?) }");
			stmSelect.registerOutParameter(1, Types.INTEGER);
			stmSelect.setString(2, inKeyword);
			stmSelect.setBoolean(3, inSW);
			stmSelect.execute();
			outCount = stmSelect.getInt(1);
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCount;
	}

	/**
	* ACTUALIZA UN REGISTRO DE LA TABLA Cgg_veh_vehiculo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String <code>true</code> SI SE ACTUALIZO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public String update(
		java.sql.Connection inConnection
	){
		String outResult = "true";
		try{
			CallableStatement stmUpdate = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_UPDATE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::smallint, ?::smallint, ?, ?, ?, ?, ?) }");
			stmUpdate.setString(1, this.getCgg_veh_vehiculo().getCVVEH_CODIGO());
			stmUpdate.setString(2, this.getCgg_veh_vehiculo().getCVMRC_CODIGO());
			stmUpdate.setString(3, this.getCgg_veh_vehiculo().getCVCLR_CODIGO());
			stmUpdate.setString(4, this.getCgg_veh_vehiculo().getCVCTG_CODIGO());
			stmUpdate.setString(5, this.getCgg_veh_vehiculo().getCSCTP_CODIGO());
			stmUpdate.setString(6, this.getCgg_veh_vehiculo().getCVSCT_CODIGO());
			stmUpdate.setString(7, this.getCgg_veh_vehiculo().getCGG_CVCLR_CODIGO());
			stmUpdate.setString(8, this.getCgg_veh_vehiculo().getCVVEH_NOMBRE());
			stmUpdate.setString(9, this.getCgg_veh_vehiculo().getCVVEH_MODELO());
			stmUpdate.setInt(10, this.getCgg_veh_vehiculo().getCVVEH_TIPO());
			stmUpdate.setInt(11, this.getCgg_veh_vehiculo().getCVVEH_ANIO_PRODUCCION());
			stmUpdate.setString(12, this.getCgg_veh_vehiculo().getCVVEH_CHASIS());
			stmUpdate.setString(13, this.getCgg_veh_vehiculo().getCVVEH_PLACA());
			stmUpdate.setBytes(14, this.getCgg_veh_vehiculo().getCVVEH_FOTO());
			stmUpdate.setBigDecimal(15, this.getCgg_veh_vehiculo().getCVVEH_ESLORA());
			stmUpdate.setBigDecimal(16, this.getCgg_veh_vehiculo().getCVVEH_MANGA());
			stmUpdate.setBigDecimal(17, this.getCgg_veh_vehiculo().getCVVEH_PUNTAL());
			stmUpdate.setString(18, this.getCgg_veh_vehiculo().getCVVEH_MATERIAL());
			stmUpdate.setBoolean(19, this.getCgg_veh_vehiculo().getCVVEH_INGRESO());
			stmUpdate.setTimestamp(20, this.getCgg_veh_vehiculo().getCVVEH_FECHA_INGRESO()!=null?new java.sql.Timestamp(this.getCgg_veh_vehiculo().getCVVEH_FECHA_INGRESO().getTime()):null);
			stmUpdate.setInt(21, this.getCgg_veh_vehiculo().getCVVEH_TIPO_INGRESO());
			stmUpdate.setInt(22, this.getCgg_veh_vehiculo().getCVVEH_TIEMPO_ESTADIA());
			stmUpdate.setBoolean(23, this.getCgg_veh_vehiculo().getCVVEH_SALIO());
			stmUpdate.setTimestamp(24, this.getCgg_veh_vehiculo().getCVVEH_FECHA_SALIDA()!=null?new java.sql.Timestamp(this.getCgg_veh_vehiculo().getCVVEH_FECHA_SALIDA().getTime()):null);
			stmUpdate.setString(25, this.getCgg_veh_vehiculo().getCVVEH_OBSERVACION());
			stmUpdate.setBoolean(26, this.getCgg_veh_vehiculo().getCVVEH_ESTADO());
			stmUpdate.setString(27, this.getCgg_veh_vehiculo().getCVVEH_USUARIO_UPDATE());
			stmUpdate.executeUpdate();
			stmUpdate.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = e.getMessage();
		}
		return outResult;
	}

	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_veh_vehiculo DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_vehiculo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public LinkedHashMap<String, Object> select(
		java.sql.Connection inConnection
	){
		LinkedHashMap<String, Object> outVehiculo = new LinkedHashMap<String, Object>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_SELECT(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo().getCVVEH_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			int tmpColumnCount = results.getMetaData().getColumnCount();
			while (results.next()) {
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(results.getObject(i) != null)
						outVehiculo.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
				this.getCgg_veh_vehiculo().setCVVEH_CODIGO(results.getString(1));
				this.getCgg_veh_vehiculo().setCVMRC_CODIGO(results.getString(2));
				this.getCgg_veh_vehiculo().setCVCLR_CODIGO(results.getString(3));
				this.getCgg_veh_vehiculo().setCVCTG_CODIGO(results.getString(4));
				this.getCgg_veh_vehiculo().setCSCTP_CODIGO(results.getString(5));
				this.getCgg_veh_vehiculo().setCVSCT_CODIGO(results.getString(6));
				this.getCgg_veh_vehiculo().setCGG_CVCLR_CODIGO(results.getString(7));
				this.getCgg_veh_vehiculo().setCVVEH_NOMBRE(results.getString(8));
				this.getCgg_veh_vehiculo().setCVVEH_MODELO(results.getString(9));
				this.getCgg_veh_vehiculo().setCVVEH_TIPO(results.getInt(10));
				this.getCgg_veh_vehiculo().setCVVEH_ANIO_PRODUCCION(results.getInt(11));
				this.getCgg_veh_vehiculo().setCVVEH_CHASIS(results.getString(12));
				this.getCgg_veh_vehiculo().setCVVEH_PLACA(results.getString(13));
				this.getCgg_veh_vehiculo().setCVVEH_FOTO(results.getBytes(14));
				this.getCgg_veh_vehiculo().setCVVEH_ESLORA(results.getBigDecimal(15));
				this.getCgg_veh_vehiculo().setCVVEH_MANGA(results.getBigDecimal(16));
				this.getCgg_veh_vehiculo().setCVVEH_PUNTAL(results.getBigDecimal(17));
				this.getCgg_veh_vehiculo().setCVVEH_MATERIAL(results.getString(18));
				this.getCgg_veh_vehiculo().setCVVEH_INGRESO(results.getBoolean(19));
				this.getCgg_veh_vehiculo().setCVVEH_FECHA_INGRESO(results.getTimestamp(20));
				this.getCgg_veh_vehiculo().setCVVEH_TIPO_INGRESO(results.getInt(21));
				this.getCgg_veh_vehiculo().setCVVEH_TIEMPO_ESTADIA(results.getInt(22));
				this.getCgg_veh_vehiculo().setCVVEH_SALIO(results.getBoolean(23));
				this.getCgg_veh_vehiculo().setCVVEH_FECHA_SALIDA(results.getTimestamp(24));
				this.getCgg_veh_vehiculo().setCVVEH_OBSERVACION(results.getString(25));
				this.getCgg_veh_vehiculo().setCVVEH_ESTADO(results.getBoolean(26));
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outVehiculo;
	}

	/**
	* ELIMINA UN REGISTRO DE LA TABLA Cgg_veh_vehiculo DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINO EL REGISTRO, CASO CONTRARIO <code>false</code>.
	*/
	public boolean delete(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_DELETE(?) }");
			stmDelete.setString(1, this.getCgg_veh_vehiculo().getCVVEH_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		if(outResult){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_DELETE_SOFT(?) }");
				stmDelete.setString(1, this.getCgg_veh_vehiculo().getCVVEH_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_marca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_vehiculo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> selectCGG_VEH_MARCA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> outCgg_veh_vehiculo = new ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_S_CGG_VEH_MARCA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo().getCVMRC_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_vehiculo tmpCgg_veh_vehiculo = new com.besixplus.sii.objects.Cgg_veh_vehiculo();
				tmpCgg_veh_vehiculo.setCVVEH_CODIGO(results.getString(1));
				tmpCgg_veh_vehiculo.setCVMRC_CODIGO(results.getString(2));
				tmpCgg_veh_vehiculo.setCVCLR_CODIGO(results.getString(3));
				tmpCgg_veh_vehiculo.setCVCTG_CODIGO(results.getString(4));
				tmpCgg_veh_vehiculo.setCSCTP_CODIGO(results.getString(5));
				tmpCgg_veh_vehiculo.setCVSCT_CODIGO(results.getString(6));
				tmpCgg_veh_vehiculo.setCGG_CVCLR_CODIGO(results.getString(7));
				tmpCgg_veh_vehiculo.setCVVEH_NOMBRE(results.getString(8));
				tmpCgg_veh_vehiculo.setCVVEH_MODELO(results.getString(9));
				tmpCgg_veh_vehiculo.setCVVEH_TIPO(results.getInt(10));
				tmpCgg_veh_vehiculo.setCVVEH_ANIO_PRODUCCION(results.getInt(11));
				tmpCgg_veh_vehiculo.setCVVEH_CHASIS(results.getString(12));
				tmpCgg_veh_vehiculo.setCVVEH_PLACA(results.getString(13));
				tmpCgg_veh_vehiculo.setCVVEH_FOTO(results.getBytes(14));
				tmpCgg_veh_vehiculo.setCVVEH_ESLORA(results.getBigDecimal(15));
				tmpCgg_veh_vehiculo.setCVVEH_MANGA(results.getBigDecimal(16));
				tmpCgg_veh_vehiculo.setCVVEH_PUNTAL(results.getBigDecimal(17));
				tmpCgg_veh_vehiculo.setCVVEH_MATERIAL(results.getString(18));
				tmpCgg_veh_vehiculo.setCVVEH_INGRESO(results.getBoolean(19));
				tmpCgg_veh_vehiculo.setCVVEH_FECHA_INGRESO(results.getTimestamp(20));
				tmpCgg_veh_vehiculo.setCVVEH_TIPO_INGRESO(results.getInt(21));
				tmpCgg_veh_vehiculo.setCVVEH_TIEMPO_ESTADIA(results.getInt(22));
				tmpCgg_veh_vehiculo.setCVVEH_SALIO(results.getBoolean(23));
				tmpCgg_veh_vehiculo.setCVVEH_FECHA_SALIDA(results.getTimestamp(24));
				tmpCgg_veh_vehiculo.setCVVEH_OBSERVACION(results.getString(25));
				tmpCgg_veh_vehiculo.setCVVEH_ESTADO(results.getBoolean(26));
				outCgg_veh_vehiculo.add(tmpCgg_veh_vehiculo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_marca.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_VEH_MARCA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_D_CGG_VEH_MARCA(?) }");
			stmDelete.setString(1, this.getCgg_veh_vehiculo().getCVMRC_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		if(outResult){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_DS_CGG_VEH_MARCA(?) }");
				stmDelete.setString(1, this.getCgg_veh_vehiculo().getCVMRC_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_color.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_vehiculo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> selectCGG_VEH_COLOR(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> outCgg_veh_vehiculo = new ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_S_CGG_VEH_COLOR(?, ?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo().getCVCLR_CODIGO());
			stmSelect.setString(3,this.getCgg_veh_vehiculo().getCGG_CVCLR_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_vehiculo tmpCgg_veh_vehiculo = new com.besixplus.sii.objects.Cgg_veh_vehiculo();
				tmpCgg_veh_vehiculo.setCVVEH_CODIGO(results.getString(1));
				tmpCgg_veh_vehiculo.setCVMRC_CODIGO(results.getString(2));
				tmpCgg_veh_vehiculo.setCVCLR_CODIGO(results.getString(3));
				tmpCgg_veh_vehiculo.setCVCTG_CODIGO(results.getString(4));
				tmpCgg_veh_vehiculo.setCSCTP_CODIGO(results.getString(5));
				tmpCgg_veh_vehiculo.setCVSCT_CODIGO(results.getString(6));
				tmpCgg_veh_vehiculo.setCGG_CVCLR_CODIGO(results.getString(7));
				tmpCgg_veh_vehiculo.setCVVEH_NOMBRE(results.getString(8));
				tmpCgg_veh_vehiculo.setCVVEH_MODELO(results.getString(9));
				tmpCgg_veh_vehiculo.setCVVEH_TIPO(results.getInt(10));
				tmpCgg_veh_vehiculo.setCVVEH_ANIO_PRODUCCION(results.getInt(11));
				tmpCgg_veh_vehiculo.setCVVEH_CHASIS(results.getString(12));
				tmpCgg_veh_vehiculo.setCVVEH_PLACA(results.getString(13));
				tmpCgg_veh_vehiculo.setCVVEH_FOTO(results.getBytes(14));
				tmpCgg_veh_vehiculo.setCVVEH_ESLORA(results.getBigDecimal(15));
				tmpCgg_veh_vehiculo.setCVVEH_MANGA(results.getBigDecimal(16));
				tmpCgg_veh_vehiculo.setCVVEH_PUNTAL(results.getBigDecimal(17));
				tmpCgg_veh_vehiculo.setCVVEH_MATERIAL(results.getString(18));
				tmpCgg_veh_vehiculo.setCVVEH_INGRESO(results.getBoolean(19));
				tmpCgg_veh_vehiculo.setCVVEH_FECHA_INGRESO(results.getTimestamp(20));
				tmpCgg_veh_vehiculo.setCVVEH_TIPO_INGRESO(results.getInt(21));
				tmpCgg_veh_vehiculo.setCVVEH_TIEMPO_ESTADIA(results.getInt(22));
				tmpCgg_veh_vehiculo.setCVVEH_SALIO(results.getBoolean(23));
				tmpCgg_veh_vehiculo.setCVVEH_FECHA_SALIDA(results.getTimestamp(24));
				tmpCgg_veh_vehiculo.setCVVEH_OBSERVACION(results.getString(25));
				tmpCgg_veh_vehiculo.setCVVEH_ESTADO(results.getBoolean(26));
				outCgg_veh_vehiculo.add(tmpCgg_veh_vehiculo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_color.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_VEH_COLOR(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_D_CGG_VEH_COLOR(?, ?) }");
			stmDelete.setString(1, this.getCgg_veh_vehiculo().getCVCLR_CODIGO());
			stmDelete.setString(2, this.getCgg_veh_vehiculo().getCGG_CVCLR_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		if(outResult){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_DS_CGG_VEH_COLOR(?, ?) }");
				stmDelete.setString(1, this.getCgg_veh_vehiculo().getCVCLR_CODIGO());
				stmDelete.setString(2, this.getCgg_veh_vehiculo().getCGG_CVCLR_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_categoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_vehiculo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> selectCGG_VEH_CATEGORIA(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> outCgg_veh_vehiculo = new ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_S_CGG_VEH_CATEGORIA(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo().getCVCTG_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_vehiculo tmpCgg_veh_vehiculo = new com.besixplus.sii.objects.Cgg_veh_vehiculo();
				tmpCgg_veh_vehiculo.setCVVEH_CODIGO(results.getString(1));
				tmpCgg_veh_vehiculo.setCVMRC_CODIGO(results.getString(2));
				tmpCgg_veh_vehiculo.setCVCLR_CODIGO(results.getString(3));
				tmpCgg_veh_vehiculo.setCVCTG_CODIGO(results.getString(4));
				tmpCgg_veh_vehiculo.setCSCTP_CODIGO(results.getString(5));
				tmpCgg_veh_vehiculo.setCVSCT_CODIGO(results.getString(6));
				tmpCgg_veh_vehiculo.setCGG_CVCLR_CODIGO(results.getString(7));
				tmpCgg_veh_vehiculo.setCVVEH_NOMBRE(results.getString(8));
				tmpCgg_veh_vehiculo.setCVVEH_MODELO(results.getString(9));
				tmpCgg_veh_vehiculo.setCVVEH_TIPO(results.getInt(10));
				tmpCgg_veh_vehiculo.setCVVEH_ANIO_PRODUCCION(results.getInt(11));
				tmpCgg_veh_vehiculo.setCVVEH_CHASIS(results.getString(12));
				tmpCgg_veh_vehiculo.setCVVEH_PLACA(results.getString(13));
				tmpCgg_veh_vehiculo.setCVVEH_FOTO(results.getBytes(14));
				tmpCgg_veh_vehiculo.setCVVEH_ESLORA(results.getBigDecimal(15));
				tmpCgg_veh_vehiculo.setCVVEH_MANGA(results.getBigDecimal(16));
				tmpCgg_veh_vehiculo.setCVVEH_PUNTAL(results.getBigDecimal(17));
				tmpCgg_veh_vehiculo.setCVVEH_MATERIAL(results.getString(18));
				tmpCgg_veh_vehiculo.setCVVEH_INGRESO(results.getBoolean(19));
				tmpCgg_veh_vehiculo.setCVVEH_FECHA_INGRESO(results.getTimestamp(20));
				tmpCgg_veh_vehiculo.setCVVEH_TIPO_INGRESO(results.getInt(21));
				tmpCgg_veh_vehiculo.setCVVEH_TIEMPO_ESTADIA(results.getInt(22));
				tmpCgg_veh_vehiculo.setCVVEH_SALIO(results.getBoolean(23));
				tmpCgg_veh_vehiculo.setCVVEH_FECHA_SALIDA(results.getTimestamp(24));
				tmpCgg_veh_vehiculo.setCVVEH_OBSERVACION(results.getString(25));
				tmpCgg_veh_vehiculo.setCVVEH_ESTADO(results.getBoolean(26));
				outCgg_veh_vehiculo.add(tmpCgg_veh_vehiculo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_categoria.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_VEH_CATEGORIA(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_D_CGG_VEH_CATEGORIA(?) }");
			stmDelete.setString(1, this.getCgg_veh_vehiculo().getCVCTG_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		if(outResult){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_DS_CGG_VEH_CATEGORIA(?) }");
				stmDelete.setString(1, this.getCgg_veh_vehiculo().getCVCTG_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_sector.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_vehiculo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> selectCGG_VEH_SECTOR(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> outCgg_veh_vehiculo = new ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_S_CGG_VEH_SECTOR(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo().getCVSCT_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_vehiculo tmpCgg_veh_vehiculo = new com.besixplus.sii.objects.Cgg_veh_vehiculo();
				tmpCgg_veh_vehiculo.setCVVEH_CODIGO(results.getString(1));
				tmpCgg_veh_vehiculo.setCVMRC_CODIGO(results.getString(2));
				tmpCgg_veh_vehiculo.setCVCLR_CODIGO(results.getString(3));
				tmpCgg_veh_vehiculo.setCVCTG_CODIGO(results.getString(4));
				tmpCgg_veh_vehiculo.setCSCTP_CODIGO(results.getString(5));
				tmpCgg_veh_vehiculo.setCVSCT_CODIGO(results.getString(6));
				tmpCgg_veh_vehiculo.setCGG_CVCLR_CODIGO(results.getString(7));
				tmpCgg_veh_vehiculo.setCVVEH_NOMBRE(results.getString(8));
				tmpCgg_veh_vehiculo.setCVVEH_MODELO(results.getString(9));
				tmpCgg_veh_vehiculo.setCVVEH_TIPO(results.getInt(10));
				tmpCgg_veh_vehiculo.setCVVEH_ANIO_PRODUCCION(results.getInt(11));
				tmpCgg_veh_vehiculo.setCVVEH_CHASIS(results.getString(12));
				tmpCgg_veh_vehiculo.setCVVEH_PLACA(results.getString(13));
				tmpCgg_veh_vehiculo.setCVVEH_FOTO(results.getBytes(14));
				tmpCgg_veh_vehiculo.setCVVEH_ESLORA(results.getBigDecimal(15));
				tmpCgg_veh_vehiculo.setCVVEH_MANGA(results.getBigDecimal(16));
				tmpCgg_veh_vehiculo.setCVVEH_PUNTAL(results.getBigDecimal(17));
				tmpCgg_veh_vehiculo.setCVVEH_MATERIAL(results.getString(18));
				tmpCgg_veh_vehiculo.setCVVEH_INGRESO(results.getBoolean(19));
				tmpCgg_veh_vehiculo.setCVVEH_FECHA_INGRESO(results.getTimestamp(20));
				tmpCgg_veh_vehiculo.setCVVEH_TIPO_INGRESO(results.getInt(21));
				tmpCgg_veh_vehiculo.setCVVEH_TIEMPO_ESTADIA(results.getInt(22));
				tmpCgg_veh_vehiculo.setCVVEH_SALIO(results.getBoolean(23));
				tmpCgg_veh_vehiculo.setCVVEH_FECHA_SALIDA(results.getTimestamp(24));
				tmpCgg_veh_vehiculo.setCVVEH_OBSERVACION(results.getString(25));
				tmpCgg_veh_vehiculo.setCVVEH_ESTADO(results.getBoolean(26));
				outCgg_veh_vehiculo.add(tmpCgg_veh_vehiculo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_veh_sector.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_VEH_SECTOR(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_D_CGG_VEH_SECTOR(?) }");
			stmDelete.setString(1, this.getCgg_veh_vehiculo().getCVSCT_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		if(outResult){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_DS_CGG_VEH_SECTOR(?) }");
				stmDelete.setString(1, this.getCgg_veh_vehiculo().getCVSCT_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}

	/**
	* SELECCIONA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo DE ACUERDO
	* A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return com.besixplus.sii.objects.Cgg_veh_vehiculo OBJETO EQUIVALENTE AL REGISTRO DE LA TABLA.
	*/
	public ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> selectCGG_SECTOR_PRODUCTIVO(
		java.sql.Connection inConnection
	){
		ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo> outCgg_veh_vehiculo = new ArrayList<com.besixplus.sii.objects.Cgg_veh_vehiculo>();
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_S_CGG_SECTOR_PRODUCTIVO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo().getCSCTP_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				com.besixplus.sii.objects.Cgg_veh_vehiculo tmpCgg_veh_vehiculo = new com.besixplus.sii.objects.Cgg_veh_vehiculo();
				tmpCgg_veh_vehiculo.setCVVEH_CODIGO(results.getString(1));
				tmpCgg_veh_vehiculo.setCVMRC_CODIGO(results.getString(2));
				tmpCgg_veh_vehiculo.setCVCLR_CODIGO(results.getString(3));
				tmpCgg_veh_vehiculo.setCVCTG_CODIGO(results.getString(4));
				tmpCgg_veh_vehiculo.setCSCTP_CODIGO(results.getString(5));
				tmpCgg_veh_vehiculo.setCVSCT_CODIGO(results.getString(6));
				tmpCgg_veh_vehiculo.setCGG_CVCLR_CODIGO(results.getString(7));
				tmpCgg_veh_vehiculo.setCVVEH_NOMBRE(results.getString(8));
				tmpCgg_veh_vehiculo.setCVVEH_MODELO(results.getString(9));
				tmpCgg_veh_vehiculo.setCVVEH_TIPO(results.getInt(10));
				tmpCgg_veh_vehiculo.setCVVEH_ANIO_PRODUCCION(results.getInt(11));
				tmpCgg_veh_vehiculo.setCVVEH_CHASIS(results.getString(12));
				tmpCgg_veh_vehiculo.setCVVEH_PLACA(results.getString(13));
				tmpCgg_veh_vehiculo.setCVVEH_FOTO(results.getBytes(14));
				tmpCgg_veh_vehiculo.setCVVEH_ESLORA(results.getBigDecimal(15));
				tmpCgg_veh_vehiculo.setCVVEH_MANGA(results.getBigDecimal(16));
				tmpCgg_veh_vehiculo.setCVVEH_PUNTAL(results.getBigDecimal(17));
				tmpCgg_veh_vehiculo.setCVVEH_MATERIAL(results.getString(18));
				tmpCgg_veh_vehiculo.setCVVEH_INGRESO(results.getBoolean(19));
				tmpCgg_veh_vehiculo.setCVVEH_FECHA_INGRESO(results.getTimestamp(20));
				tmpCgg_veh_vehiculo.setCVVEH_TIPO_INGRESO(results.getInt(21));
				tmpCgg_veh_vehiculo.setCVVEH_TIEMPO_ESTADIA(results.getInt(22));
				tmpCgg_veh_vehiculo.setCVVEH_SALIO(results.getBoolean(23));
				tmpCgg_veh_vehiculo.setCVVEH_FECHA_SALIDA(results.getTimestamp(24));
				tmpCgg_veh_vehiculo.setCVVEH_OBSERVACION(results.getString(25));
				tmpCgg_veh_vehiculo.setCVVEH_ESTADO(results.getBoolean(26));
				outCgg_veh_vehiculo.add(tmpCgg_veh_vehiculo);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outCgg_veh_vehiculo;
	}

	/**
	* ELIMINA LOS REGISTROS DE LA TABLA Cgg_veh_vehiculo DE ACUERDO A LA CLAVE PRIMARIA DE LA TABLA Cgg_sector_productivo.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return bool <code>true</code> SI SE ELIMINARON LOS REGISTROS, CASO CONTRARIO <code>false</code>.
	*/
	public boolean deleteCGG_SECTOR_PRODUCTIVO(
		java.sql.Connection inConnection
	){
		boolean outResult = true;
		boolean tmpAutoCommit = false;
		Savepoint tmpSP = null;
		try{
			tmpAutoCommit = inConnection.getAutoCommit();
			inConnection.setAutoCommit(false);
			tmpSP = inConnection.setSavepoint();
			CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_D_CGG_SECTOR_PRODUCTIVO(?) }");
			stmDelete.setString(1, this.getCgg_veh_vehiculo().getCSCTP_CODIGO());
			stmDelete.execute();
			stmDelete.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			outResult = false;
		}
		if(outResult){
			try{
				inConnection.rollback(tmpSP);
				inConnection.setAutoCommit(tmpAutoCommit);
				CallableStatement stmDelete = inConnection.prepareCall("{ call sii.F_CGG_VEH_VEHICULO_DS_CGG_SECTOR_PRODUCTIVO(?) }");
				stmDelete.setString(1, this.getCgg_veh_vehiculo().getCSCTP_CODIGO());
				stmDelete.execute();
				stmDelete.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
				outResult = false;
			}
		}
		return outResult;
	}
	
	/**
	* SELECCIONA UN REGISTRO DE LA TABLA Cgg_veh_vehiculo DE ACUERDO A LA CLAVE PRIMARIA.
	* @param inConnection CONEXION A LA BASE DE DATOS.
	* @return String DATOS DE LA FOTO EN BASE64
	*/
	public String selectFoto(
		java.sql.Connection inConnection
	){
		String outFoto = null;
		try{
			CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_SELECT_FOTO(?) }");
			stmSelect.registerOutParameter(1, Types.OTHER);
			stmSelect.setString(2,this.getCgg_veh_vehiculo().getCVVEH_CODIGO());
			stmSelect.execute();
			ResultSet results = (ResultSet) stmSelect.getObject(1);
			while (results.next()) {
				outFoto = results.getString(1);
			}
			results.close();
			stmSelect.close();
		}catch(SQLException e){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
		}
		return outFoto;
	}
	
	/**
	 * Selecciona un vehiculo por su codigo.
	 * @param inConnection Conexion de datos.
	 * @param inCvveh_codigo Codigo de vehiculo.
	 * @return Vehiculo.
	 */
	public ArrayList<HashMap<String,Object>> select1(			
			java.sql.Connection inConnection,
			String inCvveh_codigo
		){
			ArrayList<HashMap<String,Object>> outCgg_veh_vehiculo = new ArrayList<HashMap<String,Object>>();
			try{
				CallableStatement stmSelect = inConnection.prepareCall("{ ? = call sii.F_CGG_VEH_VEHICULO_SELECT1(?) }");
				stmSelect.registerOutParameter(1, Types.OTHER);
				stmSelect.setString(2,inCvveh_codigo);
				stmSelect.execute();
				ResultSet results = (ResultSet) stmSelect.getObject(1);
				int tmpColumnCount = results.getMetaData().getColumnCount();
				while (results.next()) {
					HashMap<String,Object> tmpObj = new HashMap<String,Object>();
					for (int i = 1 ; i <= tmpColumnCount; i++)						
							tmpObj.put(results.getMetaData().getColumnName(i).toUpperCase(), results.getObject(i));
					outCgg_veh_vehiculo.add(tmpObj);
				}
				results.close();
				stmSelect.close();
			}catch(SQLException e){
				com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
			}
			return outCgg_veh_vehiculo;
		}

}