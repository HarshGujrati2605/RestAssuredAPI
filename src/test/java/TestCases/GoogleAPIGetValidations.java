package TestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import variables.GlobalVariable;

import static io.restassured.RestAssured.given;

public class GoogleAPIGetValidations {
	
	@Test(testName = "Get API Validation")
	public void getapivalidations() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.basePath = "maps/api/place/get/json&place_id="+GlobalVariable.place_id+"";
		System.out.println(GlobalVariable.place_id + " in get validation method");
		
		given().queryParam("key", "qaclick123").header( "Content-Type" , "application/json")
		.when().get().then().assertThat().statusCode(200).log().all();
		
		
		
	}

}
