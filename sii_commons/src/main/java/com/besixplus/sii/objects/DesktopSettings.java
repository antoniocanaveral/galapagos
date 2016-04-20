package com.besixplus.sii.objects;

import com.besixplus.sii.db.ManagerConnection;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DesktopSettings {
	private Map<String, String> uniCodes = new HashMap<String, String>();
	private Pattern pattOptMenu = Pattern.compile("(optMenu)\\s*=\\s*'[\\-0-9\\\\/a-zA-Z\\s]*';");
	private Pattern pattIconCls = Pattern.compile("(iconCls)\\s*:\\s*'\\w+'");
	private Pattern pattWindow = Pattern.compile("((new Ext.Window)|(inDesktop.createWindow))\\s*\\(\\{\\s*((\\w+:\\s*('\\w*')*|\\w*)+\\,*\\s*)*");
	private String realServletPath = "L:\\home\\roberth\\Programas\\jboss-5.1.0.GA\\server\\default\\deploy\\SIICGG_UI.war\\forms";
	private Map<String, String> titles = new HashMap<String, String>();

	public DesktopSettings(String inRealPath, String inUserName){
		uniCodes.put("\\u00e1", "a");
		uniCodes.put("\\u00E1", "a");
		uniCodes.put("\\u00e9", "e");
		uniCodes.put("\\u00E9", "e");
		uniCodes.put("\\u00ed", "i");
		uniCodes.put("\\u00ED", "i");
		uniCodes.put("\\u00f3", "o");
		uniCodes.put("\\u00F3", "o");
		uniCodes.put("\\u00fa", "u");
		uniCodes.put("\\u00FA", "u");
		uniCodes.put("\\u00f1", "n");
		uniCodes.put("\\u00F1", "n");
		Connection tmpCon = ManagerConnection.getConnection();
		try {
			tmpCon.setAutoCommit(false);
			ArrayList<String> tmpObjects = new com.besixplus.sii.db.Cgg_sec_objeto().getObjectsFor(tmpCon, inUserName, false);
			HashMap<String, Item> tmpAppMenu = new HashMap<String, Item>();
			realServletPath = inRealPath;
			for(int i = 0; i < tmpObjects.size(); i+=2){
				String tmpObject = tmpObjects.get(i);
				String tmpFileName = realServletPath+"forms"+tmpObject;
				if(new File(tmpFileName).exists()){
					String tmpBuffer = getContentFile(new File(tmpFileName)).toString();
					String tmpDefIconCls = null;
					Matcher mtchOptMenu = pattOptMenu.matcher(tmpBuffer);
					Matcher mtchWindows = pattWindow.matcher(tmpBuffer);
					Matcher mtchIconCls = null;
					while(mtchWindows.find()){
						mtchIconCls = pattIconCls.matcher(mtchWindows.group());
						while(mtchIconCls.find()){
							tmpDefIconCls = mtchIconCls.group();
							tmpDefIconCls = tmpDefIconCls.substring(tmpDefIconCls.indexOf("'")+1, tmpDefIconCls.lastIndexOf("'"));
						}
					}
					while(mtchOptMenu.find()){
						String tmpMenu = mtchOptMenu.group();
						tmpMenu = tmpMenu.substring(tmpMenu.indexOf("'")+1, tmpMenu.lastIndexOf("'"));
						Item tmpRootItem = null;
						if(tmpAppMenu.containsKey(replaceUnicodes(tmpMenu.split("/")[0].replace(" ", "")))){
							tmpRootItem = tmpAppMenu.get(replaceUnicodes(tmpMenu.split("/")[0].replace(" ", "")));
						}else{
							tmpRootItem = new Item();
							tmpAppMenu.put(replaceUnicodes(tmpMenu.split("/")[0].replace(" ", "")), tmpRootItem);
						}
						setItem(tmpMenu, tmpRootItem, tmpFileName.substring(tmpFileName.lastIndexOf("/")+1, tmpFileName.lastIndexOf(".")), tmpDefIconCls);    				
					}
				}else{
					System.out.println("El archivo "+tmpFileName+" no existe o se reubico.");
				}
			}
			tmpCon.close();
			Set<String> tmpKeys = tmpAppMenu.keySet();
			StringBuilder tmpMenuEntries = new StringBuilder();
			StringBuilder tmpMenus = new StringBuilder();
			for (String string : tmpKeys) {
				string = replaceUnicodes(string);
				tmpMenus.append("MyDesktop.mn"+string+"=Ext.extend(MyDesktop.StartMenuItem,{init:function(){this.launcher="+tmpAppMenu.get(string).toString()+"}});");
				if(tmpMenuEntries.length() > 0)
					tmpMenuEntries.append(",");
				tmpMenuEntries.append("new MyDesktop.mn"+string+"()");
			}
			StringBuilder tmpBuffer = getContentFile(new InputStreamReader(this.getClass().getResourceAsStream("/com/besixplus/sii/resources/templates/desk.js")));
			tmpBuffer.replace(tmpBuffer.indexOf("{MENU_ENTRIES}"), tmpBuffer.indexOf("{MENU_ENTRIES}")+14, tmpMenuEntries.toString());
			tmpBuffer.append(tmpMenus);
			FileOutputStream tmpDeskUserFile = new FileOutputStream(realServletPath+"desktop/desk"+inUserName+".js");
			tmpDeskUserFile.write(tmpBuffer.toString().getBytes());
			tmpDeskUserFile.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public DesktopSettings(HttpServletRequest inRequest) {
		this(inRequest.getSession().getServletContext().getRealPath("/"), inRequest.getUserPrincipal().getName());
	}

	private Item setItem(String inPath, Item inItem, String inFileName, String inFormIcon){
		if(inPath.split("/").length > 1){
			Item tmpItem = null; 
			boolean tmpSW = false;
			if(inItem.getText() != null && inItem.getText().equals(inPath.split("/")[0])){
				for(int i = 0; i < inItem.getMenu().size(); i++){
					if(inItem.getMenu().get(i).getText().equals(inPath.split("/")[1])){
						tmpItem = inItem.getMenu().get(i);
						tmpSW = true;
					}
				}
			}
			if(!tmpSW)
				tmpItem = new Item();
			setItem(inPath.substring(inPath.indexOf("/")+1), tmpItem, inFileName, inFormIcon);
			inItem.setText(inPath.split("/")[0]);
			String tmpIconCls = inPath.split("/")[0].replace(" ", "");
			tmpIconCls = replaceUnicodes(tmpIconCls);
			inItem.setIconCls("icon"+tmpIconCls);
			inItem.setHandler("function(){return false;}");
			if(!tmpSW)
				inItem.addSubItem(tmpItem);
		}else{
			inItem.setText(inPath);
			inItem.setIconCls(inFormIcon);
			inItem.setHandler("this.createWindow");
			inItem.setScope("this");
			inItem.setWindowId(inFileName);
			titles.put(inFileName, inPath);
		}
		return inItem;
	}

	private String replaceUnicodes(String inString){
		for(String tmpKey:uniCodes.keySet()){
			inString = inString.replace(tmpKey, uniCodes.get(tmpKey));
		}
		return inString;
	}

	private StringBuilder getContentFile (File inFile){
		try {
			FileReader tmpFile = new FileReader(inFile);
			return getContentFile(tmpFile);
		} catch (FileNotFoundException e) {
		}
		return null;
	}

	private StringBuilder getContentFile (Reader inReader){
		StringBuilder sbFile = new StringBuilder();
		BufferedReader brFile = new BufferedReader(inReader);
		String str = null; 
		try {
			while ((str = brFile.readLine()) != null){ 
				sbFile.append(str);
			}
			brFile.close();
			inReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return sbFile;
	}

	public Map<String, String> getTitles() {
		return titles;
	}
}