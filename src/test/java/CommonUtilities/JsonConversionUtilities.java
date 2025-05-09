package CommonUtilities;

import io.restassured.path.json.JsonPath;

public class JsonConversionUtilities {

	public static String getRawToJsonData(String response, String jsonvaribale) {

		JsonPath jspath = new JsonPath(response);
		String data = jspath.getString(jsonvaribale);
		return data;
	}

	public static String getArrayRawToJsonData(String response, String variable) {

		JsonPath jspath = new JsonPath(response);
		String data = jspath.getString("[0]." + variable);
		return data;
	}

}
