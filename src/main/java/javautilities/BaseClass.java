package javautilities;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass {
	
	public static String getAccessToken() throws Exception {
		 String userDir = System.getProperty("user.dir");
		Properties properties = new Properties();
		FileInputStream configfile = new FileInputStream(userDir+"\\src\\main\\resources\\Poperties\\config.properties");
		properties.load(configfile);
		String token = properties.getProperty("access_token");
		return token;

	}
	
	public static String getUrl() throws Exception {
		 String userDir = System.getProperty("user.dir");
		Properties properties = new Properties();
		FileInputStream configfile = new FileInputStream(userDir+"\\src\\main\\resources\\Poperties\\config.properties");
		properties.load(configfile);
		String url = properties.getProperty("url");
		return url;

	}

}
