package com.bmlaurus.alfresco.content;

import java.util.ArrayList;
import java.util.List;

public class AlfrescoFile {

	private String fileName;
	private String uuid;
	private byte[] fileData;
	private String path;
	private List<String> versionDesc;
	private List<String> versionNumber;
	
	
	public AlfrescoFile(){
		versionDesc = new ArrayList<String>();
		versionNumber = new ArrayList<String>();
	}
		
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public List<String> getVersionDesc() {
		return versionDesc;
	}

	public void setVersionDesc(List<String> versionDesc) {
		this.versionDesc = versionDesc;
	}

	public List<String> getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(List<String> versionNumber) {
		this.versionNumber = versionNumber;
	}	
	
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append("[");
		if(fileName!=null)
		{
			buf.append(fileName);
			buf.append(",");
		}
		
		if(uuid!=null)
		{
			buf.append(uuid);
			buf.append(",");
		}
		buf.append("]");
		return buf.toString();
	}
}
