package specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class newsandfeedspecs {
	
	
public static RequestSpecification academiaspecbuilder() {
		
		RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://testing-sommet.academiaerp.com").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer  bc56ccec-c42d-460d-8a94-d597093dfe33").build();
		return req;	
	}

public static RequestSpecification academiaspecbuildertexttype() {
	
	RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://testing-sommet.academiaerp.com").addHeader("Content-Type","text/plain").addHeader("Authorization", "Bearer  bc56ccec-c42d-460d-8a94-d597093dfe33").build();
	return req;	
}

}
