package academiatestcases;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloadutilitis.PayloadAlumniNews;
import specbuilder.testingsommetspecbuilder;

public class TC01AlumniNewsFeedValidation {
	
	
	
	@Test(testName = "Alumni news feed creation")
	public void postalumninewsandfeeds() {
		
		RestAssured.basePath = "/rest/alumniNewsFeeds/saveNewsAndFeeds";
		RestAssured.useRelaxedHTTPSValidation();
		Response response =given().log().all().spec(testingsommetspecbuilder.academiaspecbuilder()).contentType(ContentType.JSON)
			    .accept(ContentType.JSON).body(PayloadAlumniNews.alumninewspayload())
		.when().post()
		.then().assertThat().statusCode(200).extract().response();
		
		
		
	}
	

}
