package librarytestcases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloadutilitis.PayloadLibrary;
import variableutility.GlobalVariable;

import static org.hamcrest.Matchers.*;


public class AddBookPostAPIDynamically {
	
	@Test(testName = "Add new book dynamically" , priority = 1, groups = "Regression")
	public void addbook() {
		
		RestAssured.baseURI="http://216.10.245.166";
//		RestAssured.basePath = "";
		
	Response response =	given().log().all().header( "Content-Type" , "application/json").body(PayloadLibrary.getbooklibrarayjson("adsfs" , "64677")).
			                when().post("/Library/Addbook.php").
			                then().log().all().statusCode(200).extract().response();
	
	JsonPath json = new JsonPath(response.asString());
	
	String id = json.getString("ID");
	System.out.println(id);
	
	
	
	
	
	
	
	
	}
	
	

}
