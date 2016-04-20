package com.besixplus.sii.misc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CLASE Utils
 * 
 * CONTIENE METODOS CON FUNCIONES DE AMBITO GENERAL.
 * @author roberth
 *
 */
public class Utils {
	/**
	 * CREA UN ArrayList A PARTIR DE RESULTSET CON VARIOS REGISTROS.
	 * @param inResultSet RESULTSET QUE CONTIENE LOS DATOS.
	 * @return ArrayList<HashMap<String, Object>>
	 */
	public ArrayList<HashMap<String, Object>> toArrayList(ResultSet inResultSet){
		int tmpColumnCount;
		ArrayList<HashMap<String, Object>> outArray = new ArrayList<HashMap<String,Object>>();
		try {
			tmpColumnCount = inResultSet.getMetaData().getColumnCount();
			while (inResultSet.next()) {
				HashMap<String,Object> tmpObj = new HashMap<String,Object>();
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(inResultSet.getObject(i) != null)
						tmpObj.put(inResultSet.getMetaData().getColumnName(i).toUpperCase(), inResultSet.getObject(i));
				outArray.add(tmpObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outArray;
	}
	/**
	 * CREA UN ArrayList A PARTIR DE RESULTSET CON UN REGISTRO.
	 * @param inResultSet RESULTSET QUE CONTIENE LOS DATOS.
	 * @return ArrayList<HashMap<String, Object>>
	 */
	public HashMap<String, Object> toHashMap(ResultSet inResultSet){
		int tmpColumnCount;
		HashMap<String, Object> outObj = new HashMap<String,Object>();
		try {
			tmpColumnCount = inResultSet.getMetaData().getColumnCount();
			while (inResultSet.next()) {
				for (int i = 1 ; i <= tmpColumnCount; i++)
					if(inResultSet.getObject(i) != null)
						outObj.put(inResultSet.getMetaData().getColumnName(i).toUpperCase(), inResultSet.getObject(i));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outObj;
	}
}
