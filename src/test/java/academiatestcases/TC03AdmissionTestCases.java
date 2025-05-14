package academiatestcases;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import CommonUtilities.JsonConversionUtilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javautilities.BaseClass;
import payloadutilitis.DirectAdmissionPayLoad;
import payloadutilitis.PayloadAlumniNews;
import payloadutilitis.PayloadProgramModule;
import pojo.AdmissionPojo;
import pojo.programpojo;
import specbuilder.newsandfeedspecs;
import variableutility.GlobalVariable;

public class TC03AdmissionTestCases extends AdmissionPojo {
	
	@Test(testName = "Create Direct Admission")
	public void DirectAdmission_creatNewApplication() throws Exception {
		setAccessToken(BaseClass.getAccessToken());
		RestAssured.basePath = "/rest/application/saveAndGenerateApplicationId";
		RestAssured.useRelaxedHTTPSValidation();
		String response = given().log().all().spec(newsandfeedspecs.academiaspecbuilder()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(DirectAdmissionPayLoad.Automation_CreateDirectAdmission()).log().all().when().post()
				.then().log().all().statusCode(200).extract().response().asString();
		System.out.println("Application Id : " + response.trim());

		GlobalVariable.applicationIDrecived = Integer.parseInt(response);

	}
	
	@Test(dependsOnMethods = "DirectAdmission_creatNewApplication")
	public void DirectAdmission_AddProgramInAdmissionDetails() throws Exception {
		setAccessToken(BaseClass.getAccessToken());
		RestAssured.basePath = "/rest/applicationAdmissionDetails/create";
		RestAssured.useRelaxedHTTPSValidation();
		String response = given().log().all().spec(newsandfeedspecs.academiaspecbuilder()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(DirectAdmissionPayLoad.Automation_AddAdmissionDetails_AddProgram()).log().all().when().post()
				.then().log().all().statusCode(200).extract().response().asString();
		System.out.println("Application Id : " + response.trim());

		GlobalVariable.applicationIDrecived = Integer.parseInt(response);

	}

}
