package specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class mapspecbuilder {
	
public static RequestSpecification mapspecbuilder() {
		
		RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Content-Type", "application/json").addQueryParam("key", "qaclick123").build();
		return req;
		
		
	}

}
