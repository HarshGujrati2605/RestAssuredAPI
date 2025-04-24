package TestCases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import PayloadUtilities.PayloadAddLocation;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import variables.GlobalVariable;

public class GoogleAPIUpdateValidations {


	@Test(priority = 1)
	public void validateAPITestOne() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.basePath = "maps/api/place/update/json";
		Response response	= given().queryParam("key", "qaclick123").header( "Content-Type" , "application/json").body("{\r\n"
				+ "\"place_id\":"+GlobalVariable.place_id+",\r\n"
				+ "\"address\":\"70 Summer walk, USA Harsh new  harsh\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().post().then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", equalTo("Apache/2.4.52 (Ubuntu)")).extract().response();
		
		 String responsebody = response.body().asString();
		 JsonPath jsonpath = response.jsonPath();
		 GlobalVariable.place_id  = jsonpath.getString("place_id"); // parsing json and retreive place_id
		 System.out.println(GlobalVariable.place_id  + "************");
		 
		 
	}

}
