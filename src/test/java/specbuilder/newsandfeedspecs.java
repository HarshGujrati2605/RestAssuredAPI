package specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class newsandfeedspecs {
	
	
public static RequestSpecification academiaspecbuilder() {
		
		RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://testing-sommet.academiaerp.com").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer d0dc58fa-8c5e-4452-9058-f49a6e1c779a").build();
		return req;	
	}

public static RequestSpecification academiaspecbuildertexttype() {
	
	RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://testing-sommet.academiaerp.com").addHeader("Content-Type","text/plain").addHeader("Authorization", "Bearer d0dc58fa-8c5e-4452-9058-f49a6e1c779a").build();
	return req;	
}

}
