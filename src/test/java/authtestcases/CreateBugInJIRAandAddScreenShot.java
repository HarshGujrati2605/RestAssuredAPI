package authtestcases;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import CommonUtilities.JsonConversionUtilities;
import io.restassured.RestAssured;
import payloadutilitis.PayLoadData;

public class CreateBugInJIRAandAddScreenShot {
	
	public String id;
	
	@Test
	public void CreateBugInJIRAandAddScreenShottotheBug() {
		
		RestAssured.baseURI = "https://gopikiranvsp.atlassian.net";
		
		String response = given().log().all()
			.header("Content-Type","application/json").header("Accept","*/*").header("Authorization","Basic Z29waWtpcmFudnNwQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBiYjFjNlZhOTZvczFfMm9QTmZzMjBpQUpUb3BJSlFkQ1Z4Q3F3SjFMNDgtYXdhZGRCSzdnRm54c293UVlXR0FfQjRoYmowdEpMT0pKemlFdEV2NFNfcFNlT0lCN0dRbkxBUnpJczdNQjBBd0hkTUpJUFV6SkwwcXJWc3hxcTB5NjBWWUV0QVRhdWtrUE5WRFFBRk1QSjNVdUNZRHNrd0RldmctYURlTTB0dEU9NzkzREM4Qjc=")
			.body(PayLoadData.CreateBuginJira("User Login Failed"))
					
		.when()
			.post("/rest/api/2/issue")
		
		.then().assertThat().statusCode(201).log().all()
		.extract().response().asString();
		
		System.out.println(response);		
		
		id = JsonConversionUtilities.getRawToJsonData(response, "id");
		System.out.println(id);
		
		
		String newresponse = given().log().all()
		.pathParam("bug_id", id)
		.header("Authorization","Basic Z29waWtpcmFudnNwQGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBiYjFjNlZhOTZvczFfMm9QTmZzMjBpQUpUb3BJSlFkQ1Z4Q3F3SjFMNDgtYXdhZGRCSzdnRm54c293UVlXR0FfQjRoYmowdEpMT0pKemlFdEV2NFNfcFNlT0lCN0dRbkxBUnpJczdNQjBBd0hkTUpJUFV6SkwwcXJWc3hxcTB5NjBWWUV0QVRhdWtrUE5WRFFBRk1QSjNVdUNZRHNrd0RldmctYURlTTB0dEU9NzkzREM4Qjc=")
		.header("X-Atlassian-Token","no-check")
		.multiPart("file",new File(".\\src\\test\\resources\\screenshots\\sunflower.jpg"))		
		
		.when()
			.post("/rest/api/2/issue/{bug_id}/attachments") 
		
		.then().assertThat().statusCode(200).log().all()
		.extract().response().asString();
		
		String emailid = JsonConversionUtilities.getArrayRawToJsonData(newresponse, "author.emailAddress");
		System.out.println(emailid);
		
		String attachmentid = JsonConversionUtilities.getArrayRawToJsonData(newresponse, "id");
		System.out.println(attachmentid);
		
		System.out.println(newresponse);
		
	}
	

}
