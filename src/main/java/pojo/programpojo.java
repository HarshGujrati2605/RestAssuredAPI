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

}
