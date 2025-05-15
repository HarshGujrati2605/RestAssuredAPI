package pojo;

import variableutility.GlobalVariable;

public class AdmissionPojo extends GlobalVariable{
	
	
	private static  String admissionstatus;
	
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
	public String getAdmissionstatus() {
		return admissionstatus;
	}
	public void setAdmissionstatus(String admissionstatus) {
		AdmissionPojo.admissionstatus = admissionstatus;
	}

}
