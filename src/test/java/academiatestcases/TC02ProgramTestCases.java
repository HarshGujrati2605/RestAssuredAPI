package academiatestcases;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import CommonUtilities.JsonConversionUtilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloadutilitis.PayloadAlumniNews;
import payloadutilitis.PayloadProgramModule;
import pojo.programpojo;
import specbuilder.newsandfeedspecs;
import variableutility.GlobalVariable;

public class TC02ProgramTestCases extends programpojo{
	@Test(testName = "Program creation")
	public void creatNewProgram() {

		RestAssured.basePath = "/rest/program/create";
		RestAssured.useRelaxedHTTPSValidation();
		String response = given().log().all().spec(newsandfeedspecs.academiaspecbuilder()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(PayloadProgramModule.createProgramPayload()).when().post().then().log().all()
				.statusCode(200).extract().response().asString();
		
		setProgramidreceived(response);
		System.out.println(getProgramidreceived());

	}
	
	
	@Test(testName = "Program search and validation" , dependsOnMethods = "creatNewProgram")
	public void programSearch() {

		RestAssured.basePath = "/rest/program/findById";
		RestAssured.useRelaxedHTTPSValidation();
		String response = given().log().all().spec(newsandfeedspecs.academiaspecbuilder()).
				queryParam("_dc", "1747125904944").
				queryParam("id", getProgramidreceived()).
				contentType(ContentType.JSON)
				.accept(ContentType.JSON).when().get().then().log().all()
				.statusCode(200).extract().response().asString();
		
		assertEquals(JsonConversionUtilities.getRawToJsonData(response, "programName"), getProgramename());

	}
	
	
	@Test(testName = "Batch creation", dependsOnMethods = "programSearch")
	public void creatNewProgramBatch() {

		RestAssured.basePath = "/rest/batch/create";
		RestAssured.useRelaxedHTTPSValidation();
		String response = given().log().all().spec(newsandfeedspecs.academiaspecbuilder()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(PayloadProgramModule.createProgramBatchPayload()).when().post().then().log().all()
				.statusCode(200).extract().response().asString();
		 
		setBatchidreceived(response);
	}
	
	
	@Test(testName = "Seat creation", dependsOnMethods = "programSearch")
	public void creatSeatcType() {

		RestAssured.basePath = "/rest/programBatchSeatConfiguration/create";
		RestAssured.useRelaxedHTTPSValidation();
		String response = given().log().all().spec(newsandfeedspecs.academiaspecbuilder()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(PayloadProgramModule.createSeatPayload()).when().post().then().log().all()
				.statusCode(200).extract().response().asString();
			
	}
	
	
	



}
