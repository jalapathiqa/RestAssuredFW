package apiTesting;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreatingJsonRunTime {
	public static void main(String[] args) {
		
		
		JSONObject json = new JSONObject();
		json.put(null, false);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(0, jsonArray);
		
	}

}
