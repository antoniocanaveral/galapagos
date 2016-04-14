package com.besixplus.sii.misc;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.JSONObject;


public class Formatter implements Serializable{
	private static final long serialVersionUID = 8561977639483801316L;

	public enum Types{XML,JSON,CSV};
	private ArrayList<?> myObjects = null;
	private Object myObject = null;
	private Types myType; 
	
	public Formatter(String inType, ArrayList<?> inObjects){
		this.myType = Types.valueOf(inType.toUpperCase());
		this.myObjects = inObjects;
	}

	public Formatter(String inType, Object inObject){
		this.myType = Types.valueOf(inType.toUpperCase());
		this.myObject = inObject;
	}

	public StringBuilder getData(){
		switch (this.myType) {
		case JSON:
			return this.getJSONFormat();
		case XML:
			return getXMLFormat();
		case CSV:
			return getCSVFormat();
		}
		return null;
	}

	private StringBuilder getJSONFormat(){
		StringBuilder outCadena = null;
		if(myObject == null){
			outCadena = new StringBuilder("[");
			for (int i = 0 ; i < this.myObjects.size(); i++){
				if(i > 0)
					outCadena.append(",");
				if(this.myObjects.get(i).getClass() == LinkedHashMap.class || this.myObjects.get(i).getClass() == HashMap.class){
					HashMap<String, Object> tmpMap = (HashMap<String, Object>) this.myObjects.get(i);
					outCadena.append(new JSONObject(tmpMap).toString());
				}else if(this.myObjects.get(i) instanceof String)
					outCadena.append("\""+this.myObjects.get(i)+"\"");
				else
					outCadena.append(new JSONObject(this.myObjects.get(i)).toString());
			}
			outCadena.append("]");
		}else{
			if(myObject instanceof Map<?, ?>)
				outCadena = new StringBuilder(new JSONObject((Map<?, ?>)myObject).toString());
			else
				outCadena = new StringBuilder(new JSONObject(myObject).toString());
		}
		return outCadena;
	}

	private StringBuilder getXMLFormat(){
		StringWriter tmpBuffer = new StringWriter();
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement( "dataSet" );
		if(myObject == null){
			if(this.myObjects.get(0).getClass() == HashMap.class || this.myObjects.get(0).getClass() == LinkedHashMap.class){
				for (int i = 0; i < this.myObjects.size(); i++){
					HashMap<String, Object> tmpObj = (HashMap<String, Object>) this.myObjects.get(i);
					Element tmpElement = root.addElement("data");
					Set keySet = tmpObj.keySet();
					Iterator<String> tmpIter = keySet.iterator();
					while (tmpIter.hasNext()) {
						Element tmpChild = tmpElement.addElement(tmpIter.next());
						tmpChild.addText(tmpObj.get(tmpIter).toString());
					}
				}
			}else{
				for (int i = 0; i < this.myObjects.size(); i++){
					Element tmpObj = root.addElement( this.myObjects.get(i).getClass().getSimpleName());
					Method[] tmpMethods = this.myObjects.get(i).getClass().getMethods();
					for(int j = 0; j < tmpMethods.length ; j++){
						if(tmpMethods[j].getName().startsWith("get")){
							Element tmpMethod = tmpObj.addElement(tmpMethods[j].getName().substring(3));
							try {
								if(tmpMethods[j].getReturnType() == byte.class)
									tmpMethod.addText( com.besixplus.sii.mail.Base64.encodeBytes((byte[])tmpMethods[j].invoke(this.myObjects.get(i), "")) );
								else{
									Object tmpData = tmpMethods[j].invoke(this.myObjects.get(i), null);
									if(tmpData != null)
										tmpMethod.addAttribute("type", tmpData.getClass().getSimpleName());
									tmpMethod.addText(tmpData!=null?tmpData.toString():"" );
								}
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}else{
			Element tmpObj = root.addElement( this.myObject.getClass().getSimpleName());
			Method[] tmpMethods = this.myObject.getClass().getMethods();
			for(int j = 0; j < tmpMethods.length ; j++){
				if(tmpMethods[j].getName().startsWith("get")){
					Element tmpMethod = tmpObj.addElement(tmpMethods[j].getName().substring(3));
					try {
						if(tmpMethods[j].getReturnType() == byte.class)
							tmpMethod.addText( com.besixplus.sii.mail.Base64.encodeBytes((byte[])tmpMethods[j].invoke(this.myObject, "")) );
						else{
							Object tmpData = tmpMethods[j].invoke(this.myObject, null);
							if(tmpData != null)
								tmpMethod.addAttribute("type", tmpData.getClass().getSimpleName());
							tmpMethod.addText(tmpData!=null?tmpData.toString():"" );
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		try {
			document.write(tmpBuffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new StringBuilder(tmpBuffer.toString());
	}

	private StringBuilder getCSVFormat(){
		String tmpBuffer = "";
		StringBuilder res  = new StringBuilder("");
		if(this.myObjects.get(0).getClass() == HashMap.class || this.myObjects.get(0).getClass() == LinkedHashMap.class){				
			HashMap<String, Object> tmpObj = (HashMap<String, Object>) this.myObjects.get(0);					
			Set keySet = tmpObj.keySet();
			Iterator<String> tmpIter = keySet.iterator();
			while (tmpIter.hasNext()) {
				tmpBuffer += tmpIter.next()+",";
			}	
			
			tmpBuffer = tmpBuffer.substring(0,tmpBuffer.length()-1)+"\n";
			
			for (int i = 0; i < this.myObjects.size(); i++){
				tmpObj = (HashMap<String, Object>) this.myObjects.get(i);								
				Set valSet = tmpObj.keySet();				
				Iterator<String> iVal = valSet.iterator();
				while (iVal.hasNext()) {
					String aux =iVal.next(); 
					if(aux != null){
						try{
							tmpBuffer += tmpObj.get(aux).toString() +",";
						}catch(Exception ex){
							tmpBuffer += ",";
						}
					}else{
						tmpBuffer += ",";
					}
				}
				tmpBuffer = tmpBuffer.substring(0,tmpBuffer.length()-1)+"\n";
			}											
		}							
		res = new StringBuilder(tmpBuffer.toString());
		return res;
	}

}
