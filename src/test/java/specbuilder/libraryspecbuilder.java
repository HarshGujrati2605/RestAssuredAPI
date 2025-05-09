package specbuilder;

import org.apache.http.client.methods.RequestBuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class libraryspecbuilder {
	
	public static RequestSpecification librarySpecBuilder() {
		
		RequestSpecification req =  new RequestSpecBuilder().setBaseUri("http://216.10.245.166").addHeader("Content-Type", "application/json").build();
		return req;
		
		
	}

}
