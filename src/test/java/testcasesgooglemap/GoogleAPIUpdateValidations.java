package testcasesgooglemap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;
import variableutility.GlobalVariable;

public class GoogleAPIUpdateValidations {


	@Test(priority = 1)
	public void validateAPITestOne() {
		System.out.println(GlobalVariable.place_id + " in update");
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.basePath = "maps/api/place/update/json";
		given().log().all().queryParam("key", "qaclick123").header( "Content-Type" , "application/json").body("{\r\n"
				+ "\"place_id\":\""+GlobalVariable.place_id+"\",\r\n"
				+ "\"address\":\"70 Summer walk, USA Harsh new  harsh\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put().then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		 
		 
	}

}
