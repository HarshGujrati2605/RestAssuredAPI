package specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class testingsommetspecbuilder {
	
	
public static RequestSpecification academiaspecbuilder() {
		
		RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://testing-sommet.academiaerp.com").addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer 42e-acb0-4dfb-b652-47e780d6c218").build();
		return req;	
	}

}
