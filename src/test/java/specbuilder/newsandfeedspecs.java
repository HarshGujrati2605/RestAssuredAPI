package specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import javautilities.BaseClass;
import pojo.AlumniPojo;

public class newsandfeedspecs extends AlumniPojo {
	
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
	
	
}
