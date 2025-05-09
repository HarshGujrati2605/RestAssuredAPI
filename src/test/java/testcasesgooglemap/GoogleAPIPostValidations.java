package testcasesgooglemap;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import CommonUtilities.JsonConversionUtilities;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloadutilitis.PayloadAddLocation;
import specbuilder.mapspecbuilder;
import variableutility.GlobalVariable;

import static org.hamcrest.Matchers.*;


public class GoogleAPIPostValidations {
	
	@Test(priority = 1)
	public void validateAPITestOne() {
		
		RestAssured.basePath = "maps/api/place/add/json";
	Response response	= given().spec(mapspecbuilder.mapspecbuilder()).header( "Content-Type" , "application/json").body(PayloadAddLocation.getAddLocationPayload())
			.when().post()
			.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", equalTo("Apache/2.4.52 (Ubuntu)")).extract().response();
//		
//		 String responsebody = response.body().asString();
//		 JsonPath jsonpath = response.jsonPath();
//		 GlobalVariable.place_id  = jsonpath.getString("place_id"); // parsing json and retreive place_id
	
	    GlobalVariable.place_id = JsonConversionUtilities.getRawToJsonData(response.asString(), "place_id");
		 System.out.println(GlobalVariable.place_id  + "************");
		 
		 
	}
	
	
	
	
	

}
