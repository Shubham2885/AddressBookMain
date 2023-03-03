package com.bz.addressbook.test;

import org.json.JSONArray;
import org.json.JSONObject;

public class Demo {

	public static void main(String[] args) {
		String jsonData = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Shubham\",\r\n" + 
				"    \"lastName\": \"Chavan\",\r\n" + 
				"    \"zip\": 0,\r\n" + 
				"    \"phoneNumber\": \"8989898989\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Anom\",\r\n" + 
				"    \"lastName\": \"CHavan\",\r\n" + 
				"    \"zip\": 0,\r\n" + 
				"    \"phoneNumber\": \"7878787878\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Durga\",\r\n" + 
				"    \"lastName\": \"Prasad\",\r\n" + 
				"    \"zip\": 0,\r\n" + 
				"    \"phoneNumber\": \"7676767676\"\r\n" + 
				"  }\r\n" + 
				"]";
		
		JSONArray array = new JSONArray(jsonData);
		JSONObject jsonObject = (JSONObject) array.get(2);
		System.out.println(jsonObject.get("phoneNumber"));
	}
}
