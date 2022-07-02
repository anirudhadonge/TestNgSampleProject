package com.testng.proj.utilities;

import org.json.simple.JSONObject;

public class Environment {
	JSONObject envObject;
	String url;

	public String getUrl() {
		return url;
	}

	public Environment() {
		String environmentFile = System.getProperty("user.dir")+"\\Environment\\Environment.json";
		envObject = (JSONObject) ReadJsonFile.getJsonObj(environmentFile).get(System.getProperty("Env"));
		url = (String)envObject.get("url");
	}
	
	
}
