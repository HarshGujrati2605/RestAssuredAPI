package StringUtilities;



import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	

	public static String getName() {

		String name = RandomStringUtils.randomAlphabetic(6);
		return "AutomationName " +name;
	}
	
	
	public static String getEmail() {

		String name = RandomStringUtils.randomAlphabetic(10);
		return name+"@testautomation.com";
	}
	
	
	
	
	
	
	

}
