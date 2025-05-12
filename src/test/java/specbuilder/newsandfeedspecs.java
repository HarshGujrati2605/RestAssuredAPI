package specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class newsandfeedspecs {
	
	
public static RequestSpecification academiaspecbuilder() {
		
		RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://testing-sommet.academiaerp.com").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer f082b225-bfe3-4513-9a29-c2d99546c739").build();
		return req;	
	}

public static RequestSpecification academiaspecbuildertexttype() {
	
	RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://testing-sommet.academiaerp.com").addHeader("Content-Type","text/plain").addHeader("Authorization", "Bearer f082b225-bfe3-4513-9a29-c2d99546c739").build();
	return req;	
}

}
