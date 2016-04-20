package com.besixplus.sii.objects;

import java.util.ArrayList;

public class Item {
	private String myText = null;
	private String myIconCls = null;
	private String myHandler = null;
	private String myScope = null;
	private String myWindowId = null;
	private ArrayList<Item> myMenu = new ArrayList<Item>();
	
	public String getText() {
		return myText;
	}
	public void setText(String inText) {
		this.myText = inText;
	}
	
	public String getIconCls() {
		return myIconCls;
	}
	public void setIconCls(String inIconCls) {
		this.myIconCls = inIconCls;
	}
	
	public String getHandler() {
		return myHandler;
	}
	public void setHandler(String inHandler) {
		this.myHandler = inHandler;
	}
	
	public String getScope() {
		return myScope;
	}
	public void setScope(String inScope) {
		this.myScope = inScope;
	}
	public String getWindowId() {
		return myWindowId;
	}
	public void setWindowId(String inWindowId) {
		this.myWindowId = inWindowId;
	}
	
	public ArrayList<Item> getMenu() {
		return myMenu;
	}
	public void addSubItem(Item inMenu) {
		this.myMenu.add(inMenu);
	}
	
	public String toString(){
		StringBuilder outString = new StringBuilder("{");
		outString.append("text:'"+this.getText()+"'");
		if(this.getIconCls()!= null)
			outString.append(",iconCls:'"+this.getIconCls()+"'");
		if(this.getScope()!= null)
			outString.append(",scope:"+this.getScope());
		if(this.getScope()!= null)
			outString.append(",windowId:'"+this.getWindowId()+"'");
		if(this.getHandler()!= null)
			outString.append(",handler:"+this.getHandler());
		if(this.getMenu().size()>0){
			outString.append(",menu:{items:[");
			for(Item tmpItem : this.getMenu()){
				if(!tmpItem.equals(this.getMenu().get(0)))
					outString.append(",");
				outString.append(tmpItem.toString());
			}
			outString.append("]}");
		}
		outString.append("}");
		return outString.toString();
	}
}
