package com.testng.proj.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonParser;

public class ReadJsonFile {

	public static JSONObject getJsonObj(String filePath) {
		try {
		FileReader reader;
		reader = new FileReader(filePath);
		JSONParser jsonParser = new JSONParser();
		return (JSONObject)jsonParser.parse(reader);
		} catch (Exception ex) {
			System.out.println(ex);
		} 
		return null;
	}
}
