package pojo;

import variableutility.GlobalVariable;

public class programpojo extends GlobalVariable{
	
	public static String getProgramename() {
		return programename;
	}

	public static void setProgramename(String programename) {
		GlobalVariable.programename = programename;
	}

	public static String getProgramcode() {
		return programcode;
	}

	public static void setProgramcode(String programcode) {
		GlobalVariable.programcode = programcode;
	}
	
	public static String getAccessToken() {
		return accessToken;
	}

	public static void setAccessToken(String accessToken) {
		GlobalVariable.accessToken = accessToken;
	}

}
