package payloadutilitis;

public class PayloadLibrary {

	public static String getbooklibrarayjson(String aisle, String isbn) {

		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java Harsh "+isbn+"\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"Harsh Gujrati\"\r\n"
				+ "}\r\n"
				+ "";

	}

}
