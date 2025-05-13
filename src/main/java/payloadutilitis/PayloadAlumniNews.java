package payloadutilitis;


import StringUtilities.StringUtils;
import javautilities.BaseClass;
import pojo.AlumniPojo;
import variableutility.GlobalVariable;

public class PayloadAlumniNews extends AlumniPojo {
	
	
	
	public static String alumninewspayload(){
		setAlumninewsfeedname(StringUtils.getName());
		return "{\"title\": \""+getAlumninewsfeedname()+"\",\"imageUrl\":\"Alumni/NewsAndFeed/alumni_Screenshot 2025-01-29 122117_1741342561.png\",\"status\":\"UNPUBLISHED\",\"alumniNewsAndFeedsMapping\":[{\"academyLocation\":{\"id\":1}}]}";
	}
	
	

	public static String alumninewspayloadEdit() {
		setAlumninewsfeednameedit(alumninewsfeedname+"edit");
		return "{\r\n"
				+ "  \"title\": \""+getAlumninewsfeednameedit()+"\",\r\n"
				+ "  \"imageUrl\": \"Alumni/NewsAndFeed/alumni_Screenshot 2025-01-29 122117_1741342561.png\",\r\n"
				+ "  \"code\": \""+getAlumninewscode()+"\",\r\n"
				+ "  \"id\": \""+getAlumninewsid()+"\",\r\n"
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
		return "newsIds= "+getAlumninewsid()+"";
	}
}
