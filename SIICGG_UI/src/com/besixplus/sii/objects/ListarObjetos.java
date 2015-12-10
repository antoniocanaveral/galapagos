package com.besixplus.sii.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.besixplus.sii.db.ManagerConnection;

public class ListarObjetos {
	private Pattern pattId = Pattern.compile("(id)\\s*:\\s*'\\w+'");
	private Pattern pattText = Pattern.compile("((text)|(fieldLabel))+\\s*:\\s*'[\\w\\s]+'");
	private Pattern pattIconCls = Pattern.compile("(iconCls)\\s*:\\s*'\\w+'");
	//private Pattern pattWindow = Pattern.compile("((new Ext.Window)|(inDesktop.createWindow))\\s*\\(\\{\\s*((\\w+:\\s*('\\w*')*|\\w*)+\\,*\\s*)*");    
	//private Pattern pattTitulo = Pattern.compile("(titulo)+\\w+\\s*=\\s*'[\\s\\w(\\\\u)]+'");
	private Pattern pattButton = Pattern.compile("(new Ext.Button)\\s*\\(\\{\\s*((\\w+\\s*:\\s*('[\\w\\s]+'|[\\w]+))\\,*\\s*)*");
	private Pattern pattSplitButton = Pattern.compile("(new Ext.Toolbar.SplitButton)\\s*\\(\\{\\s*((\\w+\\s*:\\s*('[\\w\\s\\\\\\.\\-]+'|[\\w]+))\\,*\\s*)*");
	private Pattern pattAction = Pattern.compile("(new Ext.Action)\\s*\\(\\{\\s*((\\w+\\s*:\\s*('[\\w\\s]+'|[\\w]+))\\,*\\s*)*");
	private Pattern pattDateField = Pattern.compile("(DateField)+\\s*\\(\\s*\\{\\s*(([\\w]+\\s*:\\s*(\\\"*'*[\\/\\w\\s\\\\\\%\\.]+\\\"*'*))+(,)*\\s*)+");
	private String parentPath = null;
	private String myRealPath = null;
	private Connection myConnection = null;  
	
	public ListarObjetos(String inRealPath){
		this.myRealPath = inRealPath;
		myConnection = ManagerConnection.getConnection();
	}
	
	private String getObjectsFrom(File inFile, Pattern inPattern){
		String tmpContentFile = getContentFile(inFile);
		Matcher matchButton = inPattern.matcher(tmpContentFile);
		StringBuilder sbButtons = new StringBuilder("[");
		while(matchButton.find()){         
			String tmpBtnId = null;
			String tmpBtnText = null;
			String tmpBtnIconCls = null;
			String tmpButtonDef = matchButton.group();
			Matcher matchId = pattId.matcher(tmpButtonDef);
			if(matchId.find()){
				tmpBtnId = matchId.group();
				tmpBtnId = tmpBtnId.substring(tmpBtnId.indexOf("'")+1, tmpBtnId.length()-1);
			}
			Matcher matchText = pattText.matcher(tmpButtonDef);
			if(matchText.find()){
				tmpBtnText = matchText.group();
				tmpBtnText = tmpBtnText.substring(tmpBtnText.indexOf("'")+1, tmpBtnText.length()-1);
			}
			Matcher matchIconCls = pattIconCls.matcher(tmpButtonDef);
			if(matchIconCls.find()){
				tmpBtnIconCls = matchIconCls.group();
				tmpBtnIconCls = tmpBtnIconCls.substring(tmpBtnIconCls.indexOf(":")+1);
			}
			sbButtons.append("{");
			if(tmpBtnId != null)
				sbButtons.append("\"id\":\""+tmpBtnId+"\",");
			else
				sbButtons.append("\"id\":\"\",");
			sbButtons.append("\"text\":\""+(tmpBtnText!=null?tmpBtnText:"")+"\",");
			sbButtons.append("checked:false,leaf:true,");
			if(tmpBtnIconCls != null)
				sbButtons.append("\"iconCls\":"+tmpBtnIconCls+",");
			//sbButtons.append("\"uiProvider\":'colTree',");
			if(tmpBtnId != null){
				sbButtons.append("\"objectId\":\""+tmpBtnId+"\",");
			}
			sbButtons.append("\"path\":\""+parentPath+"\",");
			if(tmpBtnText != null){
				sbButtons.append("\"objectText\":\""+tmpBtnText+"\"},");
			}else
				sbButtons.append("\"objectText\":\"\"},");


		}
		if(sbButtons.length() > 1)
			sbButtons.deleteCharAt(sbButtons.length()-1);
		sbButtons.append("]");
		return sbButtons.toString();
	}

	private String getContentFile (File inFile){
		FileReader  tmpFile;
		StringBuilder sbFile = new StringBuilder();
		try {
			tmpFile = new FileReader(inFile);
			BufferedReader brFile = new BufferedReader(tmpFile);
			sbFile = new StringBuilder();
			String str = null; 
			while ((str = brFile.readLine()) != null){ 
				sbFile.append(str);
			} 
			brFile.close();
			tmpFile.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return sbFile.toString();
	}
	
	public String fillObjetcs(){
		String outRes = fillObjetcs(myRealPath);
		try {
			myConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outRes;
	}
	
	private String fillObjetcs(String inPath){
		String tmpRes = "true";
		File tmpFiles[] = new File(inPath).listFiles(new FormsFileFilter());
		for(int i = 0; i < tmpFiles.length; i++){
			if(tmpFiles[i].isDirectory()){
				fillObjetcs(tmpFiles[i].getPath() );
			}else{
				try {
					JSONArray tmpArray = new JSONArray(getObjectsFrom(tmpFiles[i], pattButton));
					for(int j = 0; j < tmpArray.length(); j++){
						JSONObject tmpObject = (JSONObject) tmpArray.get(j);
						com.besixplus.sii.objects.Cgg_sec_objeto tmpAppObject = new com.besixplus.sii.objects.Cgg_sec_objeto();
						tmpAppObject.setCSOBJ_CODIGO("KEYGEN");
						tmpAppObject.setCSOBJ_NOMBRE(tmpObject.getString("id"));
						tmpAppObject.setCSOBJ_DESCRIPCION(tmpObject.getString("text"));
						tmpAppObject.setCSOBJ_RUTA(tmpFiles[i].getPath().replace(this.myRealPath, "").replace("\\", "/"));
						tmpAppObject.setCSOBJ_TIPO(0);
						tmpAppObject.setCSOBJ_ESTADO(true);
						tmpRes = new com.besixplus.sii.db.Cgg_sec_objeto(tmpAppObject).insert(myConnection);
						if(!tmpRes.equals("true"))
							break;
					}
					tmpArray = new JSONArray(getObjectsFrom(tmpFiles[i], pattSplitButton));
					for(int j = 0; j < tmpArray.length(); j++){
						JSONObject tmpObject = (JSONObject) tmpArray.get(j);
						com.besixplus.sii.objects.Cgg_sec_objeto tmpAppObject = new com.besixplus.sii.objects.Cgg_sec_objeto();
						tmpAppObject.setCSOBJ_CODIGO("KEYGEN");
						tmpAppObject.setCSOBJ_NOMBRE(tmpObject.getString("id"));
						tmpAppObject.setCSOBJ_DESCRIPCION(tmpObject.getString("text"));
						tmpAppObject.setCSOBJ_RUTA(tmpFiles[i].getPath().replace(this.myRealPath, "").replace("\\", "/"));
						tmpAppObject.setCSOBJ_TIPO(0);
						tmpAppObject.setCSOBJ_ESTADO(true);
						tmpRes = new com.besixplus.sii.db.Cgg_sec_objeto(tmpAppObject).insert(myConnection);
						if(!tmpRes.equals("true"))
							break;
					}
					tmpArray = new JSONArray(getObjectsFrom(tmpFiles[i], pattAction));
					for(int j = 0; j < tmpArray.length(); j++){
						JSONObject tmpObject = (JSONObject) tmpArray.get(j);
						com.besixplus.sii.objects.Cgg_sec_objeto tmpAppObject = new com.besixplus.sii.objects.Cgg_sec_objeto();
						tmpAppObject.setCSOBJ_CODIGO("KEYGEN");
						tmpAppObject.setCSOBJ_NOMBRE(tmpObject.getString("id"));
						tmpAppObject.setCSOBJ_DESCRIPCION(tmpObject.getString("text"));
						tmpAppObject.setCSOBJ_RUTA(tmpFiles[i].getPath().replace(this.myRealPath, "").replace("\\", "/"));
						tmpAppObject.setCSOBJ_TIPO(0);
						tmpAppObject.setCSOBJ_ESTADO(true);
						tmpRes = new com.besixplus.sii.db.Cgg_sec_objeto(tmpAppObject).insert(myConnection);
						if(!tmpRes.equals("true"))
							break;
					}
					tmpArray = new JSONArray(getObjectsFrom(tmpFiles[i], pattDateField));
					for(int j = 0; j < tmpArray.length(); j++){
						JSONObject tmpObject = (JSONObject) tmpArray.get(j);
						com.besixplus.sii.objects.Cgg_sec_objeto tmpAppObject = new com.besixplus.sii.objects.Cgg_sec_objeto();
						tmpAppObject.setCSOBJ_CODIGO("KEYGEN");
						tmpAppObject.setCSOBJ_NOMBRE(tmpObject.getString("id"));
						tmpAppObject.setCSOBJ_DESCRIPCION(tmpObject.getString("text"));
						tmpAppObject.setCSOBJ_RUTA(tmpFiles[i].getPath().replace(this.myRealPath, "").replace("\\", "/"));
						tmpAppObject.setCSOBJ_TIPO(0);
						tmpAppObject.setCSOBJ_ESTADO(true);
						tmpRes = new com.besixplus.sii.db.Cgg_sec_objeto(tmpAppObject).insert(myConnection);
						if(!tmpRes.equals("true"))
							break;
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			if(!tmpRes.equals("true"))
				break;
		}
		return tmpRes;
	}
}

class FormsFileFilter implements FileFilter{
	public boolean accept(File pathname) {
		return pathname.getName().toUpperCase().startsWith("FRM") || pathname.isDirectory() && !pathname.getName().toUpperCase().startsWith(".");
	}
}