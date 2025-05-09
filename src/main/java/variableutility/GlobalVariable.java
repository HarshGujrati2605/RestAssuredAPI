package variableutility;

import java.util.ArrayList;
import java.util.List;

import pojo.Api;

public class GlobalVariable {

	public static String place_id;

	public static String book_id;

	public static List<String> book_idlist = new ArrayList<String>();
	
	public static List<String> isbnlist = new ArrayList<String>();
	
   public String accessToken;
   
   public List<Api> apiCourses;
   
   public String[] courseTitles = { "Selenium Webdriver Java", "Cypress", "Protractor" };

}
