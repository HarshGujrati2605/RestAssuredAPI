package pojo;

import variableutility.GlobalVariable;

public class AdmissionPojo extends GlobalVariable{
	
	public static String getApplicantName() {
		return applicantName;
	}
	public static void setApplicantName(String applicantName) {
		GlobalVariable.applicantName = applicantName;
	}
	
	public static String getAccessToken() {
		return accessToken;
	}

	public static void setAccessToken(String accessToken) {
		GlobalVariable.accessToken = accessToken;
	}

}
