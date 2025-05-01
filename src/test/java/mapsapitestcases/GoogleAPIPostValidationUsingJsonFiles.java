package mapsapitestcases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloadutilitis.PayloadAddLocation;
import variableutility.GlobalVariable;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class GoogleAPIPostValidationUsingJsonFiles {
	
	@Test(priority = 1)
	public void validateAPITestOne() throws IOException {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.basePath = "maps/api/place/add/json";
	Response response	= given().log().all().queryParam("key", "qaclick123").header( "Content-Type" , "application/json").body(new String(Files.readAllBytes(Paths.get(".\\src\\main\\resources\\jsonfiles\\addplace.json"))))
			.when().post()
			.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", equalTo("Apache/2.4.52 (Ubuntu)")).extract().response();
		
		 String responsebody = response.body().asString();
		 JsonPath jsonpath = response.jsonPath();
		 GlobalVariable.place_id  = jsonpath.getString("place_id"); // parsing json and retreive place_id
		 System.out.println(GlobalVariable.place_id  + "************");
		 
		 
	}
	
	
	
	
	

}
