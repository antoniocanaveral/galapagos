package com.bmlaurus.json;

import com.google.gson.Gson;

public interface GsonEngine {

	/**
	 * @return the gson
	 */
	public abstract Gson getGson();

	public <T> Object fromJsonWithReader(String json,Class t);

}