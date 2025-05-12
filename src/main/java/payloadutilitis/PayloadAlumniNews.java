package payloadutilitis;

import org.apache.commons.lang3.RandomStringUtils;

import StringUtilities.RestStringUtils;
import variableutility.GlobalVariable;

public class PayloadAlumniNews extends GlobalVariable {
	
	
	
	
	public static String alumninewspayload() {
		alumninewsfeedname = RestStringUtils.getName();
		return "{\"title\": \""+alumninewsfeedname+"\",\"imageUrl\":\"Alumni/NewsAndFeed/alumni_Screenshot 2025-01-29 122117_1741342561.png\",\"status\":\"UNPUBLISHED\",\"alumniNewsAndFeedsMapping\":[{\"academyLocation\":{\"id\":1}}]}";
	}
	
	

	public static String alumninewspayloadEdit() {
		GlobalVariable.alumninewsfeednameedit = alumninewsfeedname+"edit";
		return "{\r\n"
				+ "  \"title\": \""+GlobalVariable.alumninewsfeednameedit+"\",\r\n"
				+ "  \"imageUrl\": \"Alumni/NewsAndFeed/alumni_Screenshot 2025-01-29 122117_1741342561.png\",\r\n"
				+ "  \"code\": \""+GlobalVariable.alumninewscode+"\",\r\n"
				+ "  \"id\": \""+GlobalVariable.alumninewsid+"\",\r\n"
				+ "  \"status\": \"UNPUBLISHED\",\r\n"
				+ "  \"alumniNewsAndFeedsMapping\": [\r\n"
				+ "    {\r\n"
				+ "      \"academyLocation\": {\r\n"
				+ "        \"id\": 1\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}

	public static String alumninewspayloadDelete() {
		return "newsIds= "+GlobalVariable.alumninewsid+"";
	}
}
