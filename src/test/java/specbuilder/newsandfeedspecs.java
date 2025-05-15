package specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import javautilities.BaseClass;
import pojo.AdmissionPojo;
import pojo.AlumniPojo;
import variableutility.GlobalVariable;

public class newsandfeedspecs extends AdmissionPojo {
	
	public static String token = getAccessToken();

	public static RequestSpecification academiaspecbuilder() throws Exception {

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(BaseClass.getUrl())
				.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + token + "")
				.build();
		return req;
	}

	public static RequestSpecification academiaspecbuildertexttype() throws Exception {

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(BaseClass.getUrl())
				.addHeader("Content-Type", "text/plain")
				.addHeader("Authorization", "Bearer "+token+"").build();
		return req;
	}
	
	public static RequestSpecification ApplicationApproveacademiaspecbuilder() throws Exception {

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(BaseClass.getUrl())
				.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + token + "")
				.addQueryParam("_dc", "1747216146508")
				.addQueryParam("applicationId", GlobalVariable.applicationIDrecived)
				.addQueryParam("page", "1")
				.addQueryParam("start", "0")
				.addQueryParam("limit", "5")
				.build();
		return req;
	}
	
	public static RequestSpecification Admission_Approve_academiaspecbuilder() throws Exception {

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(BaseClass.getUrl())
				.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + token + "")
				.addQueryParam("_dc", "1747218010965")
				.addQueryParam("id", GlobalVariable.AdmissionDetailsIdrecived)
				.addQueryParam("allSectionsVerified", "false")
				.addQueryParam("allDocumentsVerified", "false")
				.addQueryParam("admissionApprovedOn", GlobalVariable.admissiondate)
				.build();
		return req;
	}
	
	public static RequestSpecification After_Approve_Admission_Details_academiaspecbuilder() throws Exception {

		RequestSpecification req = new RequestSpecBuilder().setBaseUri(BaseClass.getUrl())
				.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + token + "")
				.addQueryParam("_dc", "1747217081877")
				.addQueryParam("applicationId", GlobalVariable.applicationIDrecived)
				.addQueryParam("wheatherOnlyAdmitted", "true")
				.build();
		return req;
	}
	
	
}
