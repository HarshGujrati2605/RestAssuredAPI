package mapsapitestcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import variableutility.GlobalVariable;

import static io.restassured.RestAssured.given;

public class GoogleAPIGetValidations {
	
	@Test(testName = "Get API Validation")
	public void getapivalidations() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.basePath = "maps/api/place/get/json";
		System.out.println(GlobalVariable.place_id + " in get validation method");
		Response response =
		given().queryParam("key", "qaclick123").queryParam("place_id", GlobalVariable.place_id).log().all()
		.when().get().then().assertThat().statusCode(200).log().all().extract().response();
		
		JsonPath json = new JsonPath(response.asString());
		String actualaddress = json.getString("address");
		System.out.println(actualaddress+"********************");
		
		
		
	}

}
