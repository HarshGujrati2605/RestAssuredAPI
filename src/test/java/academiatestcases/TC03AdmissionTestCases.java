package academiatestcases;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@Test(testName = "DirectAdmission Add Program Admission Details", dependsOnMethods = "DirectAdmission_creatNewApplication")
	public void DirectAdmission_AddProgramInAdmissionDetails() throws Exception {
		
		RestAssured.basePath = "/rest/applicationAdmissionDetails/create";
		RestAssured.useRelaxedHTTPSValidation();
		String response = given().log().all().spec(newsandfeedspecs.academiaspecbuilder()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(DirectAdmissionPayLoad.Automation_AddAdmissionDetails_AddProgram()).log().all().when().post()
				.then().log().all().statusCode(200).extract().response().asString();
		System.out.println("Application Id : " + response.trim());

		GlobalVariable.AdmissionDetailsIdrecived = Integer.parseInt(response);

	}
	
	@Test(testName ="Direct Admission Application Approve",dependsOnMethods = "DirectAdmission_AddProgramInAdmissionDetails")
	public void DirectAdmission_Application_Approve() throws Exception {		
		RestAssured.basePath = "/rest/applicationAdmissionDetails/admissionsToApprove";
		RestAssured.useRelaxedHTTPSValidation();
		String response = given().log().all().spec(newsandfeedspecs.ApplicationApproveacademiaspecbuilder()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).log().all().when().get()
				.then().log().all().statusCode(200).extract().response().asString();
		System.out.println("Application Id : " + response.trim());

		String status = JsonConversionUtilities.getArrayRawToJsonData(response, "status");
		System.out.println("Admission Status Before confirmed : "+status);
		assertEquals(status, "ADMISSION_IN_PROGRESS");
		
		String time = JsonConversionUtilities.getArrayRawToJsonData(response, "admissionDate");
		long timestamp = Long.parseLong(time);

        // Create Date object
        Date date = new Date(timestamp);

        // Format as DD-MM-YYYY
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
        GlobalVariable.admissiondate = formatter1.format(date);
        System.out.println("Admission Date (DD-MM-YYYY): " + admissiondate);


	}
	
	@Test(testName ="Direct Admission Admission Approve", dependsOnMethods = "DirectAdmission_Application_Approve")
	public void DirectAdmission_Admission_Approve() throws Exception {		
		RestAssured.basePath = "/rest/applicationAdmissionDetails/approveAdmission";
		RestAssured.useRelaxedHTTPSValidation();
		String response = given().log().all().spec(newsandfeedspecs.Admission_Approve_academiaspecbuilder()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).log().all().when().get()
				.then().log().all().statusCode(204).extract().response().asString();
		System.out.println("Application Id : " + response.trim());
		
		System.out.println(response);
		
	}
	
	@Test(testName ="After Admission Approve details", dependsOnMethods = "DirectAdmission_Admission_Approve")
	public void After_Approve_GetAdmission_Details() throws Exception {		
		RestAssured.basePath = "/rest/applicationAdmissionDetails/findByApplicationId";
		RestAssured.useRelaxedHTTPSValidation();
		String response = given().log().all().spec(newsandfeedspecs.After_Approve_Admission_Details_academiaspecbuilder()).contentType(ContentType.JSON)
				.accept(ContentType.JSON).log().all().when().get()
				.then().log().all().statusCode(200).extract().response().asString();
		System.out.println("Application Id : " + response.trim());

		String status = JsonConversionUtilities.getArrayRawToJsonData(response, "status");
		System.out.println("Admission Status Afetr confirmed : "+status);
		assertEquals(status, "ADMISSION_CONFIRMED");
		
		System.out.println("Applicant Name : "+GlobalVariable.applicantName);
	}

}
