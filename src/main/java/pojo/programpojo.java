package pojo;

import variableutility.GlobalVariable;

public class programpojo extends GlobalVariable {

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
	public static String getCoursecode() {
		return coursecode;
	}
	public static void setCoursecode(String coursecode) {
		GlobalVariable.coursecode = coursecode;
	}
	public static String getCoursename() {
		return coursename;
	}
	public static void setCoursename(String coursename) {
		GlobalVariable.coursename = coursename;
	}

	public static String getProgramidreceived() {
		return programidreceived;
	}

	public static void setProgramidreceived(String programidreceived) {
		GlobalVariable.programidreceived = programidreceived;
	}
	
	public static String getBatchidreceived() {
		return batchidreceived;
	}

	public static void setBatchidreceived(String batchidreceived) {
		GlobalVariable.batchidreceived = batchidreceived;
	}

}
