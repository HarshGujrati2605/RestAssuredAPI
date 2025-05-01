package librarytestcases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloadutilitis.PayloadLibrary;
import variableutility.GlobalVariable;

import static org.hamcrest.Matchers.*;

public class GetBookAPIValidations {

	@Test
	public void getCreatedLibraryBookValidation() {
		
		RestAssured.basePath = "https://rahulshettyacademy.com";
	    
		for(String id : GlobalVariable.book_idlist) {
			
			
			
		}
		
		
		
	}
	
}
