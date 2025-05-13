package academiatestcases;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import CommonUtilities.JsonConversionUtilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javautilities.BaseClass;
import payloadutilitis.PayloadAlumniNews;
import payloadutilitis.PayloadProgramModule;
import pojo.programpojo;
import specbuilder.newsandfeedspecs;
import variableutility.GlobalVariable;

public class TC02ProgramTestCases extends programpojo{
	@Test(testName = "Program creation")
	public void creatNewProgram() throws Exception {
		setAccessToken(BaseClass.getAccessToken());
		RestAssured.basePath = "/rest/program/create";
		RestAssured.useRelaxedHTTPSValidation();
		String response = given().log().all().spec(newsandfeedspecs.academiaspecbuilder()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(PayloadProgramModule.createProgramPayload()).when().post().then().log().all()
				.statusCode(200).extract().response().asString();

	}
	
	
	@Test(testName = "Program search" , dependsOnMethods = "creatNewProgram")
	public void programSearch() throws Exception {

		RestAssured.basePath = "/rest/program/create";
		RestAssured.useRelaxedHTTPSValidation();
		String response = given().log().all().spec(newsandfeedspecs.academiaspecbuilder()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(PayloadProgramModule.createProgramPayload()).when().post().then().log().all()
				.statusCode(200).extract().response().asString();

	}
	
	
//	
//	@Test(testName = "Batch creation")
//	public void creatNewProgramBatch() {
//
//		RestAssured.basePath = "/rest/batch/create";
//		RestAssured.useRelaxedHTTPSValidation();
//		String response = given().log().all().spec(newsandfeedspecs.academiaspecbuilder()).contentType(ContentType.JSON)
//				.accept(ContentType.JSON).body(PayloadProgramModule.createProgramBatchPayload()).when().post().then().log().all()
//				.statusCode(200).extract().response().asString();
//
//	}



}
