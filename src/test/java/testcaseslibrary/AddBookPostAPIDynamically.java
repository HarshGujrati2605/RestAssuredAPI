package testcaseslibrary;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloadutilitis.PayloadLibrary;
import specbuilder.libraryspecbuilder;

public class AddBookPostAPIDynamically {

	@Test(testName = "Add new book dynamically", priority = 1, groups = "Regression")
	public void addbook() {

		Response response = given().log().all().spec(libraryspecbuilder.librarySpecBuilder())
				.body(PayloadLibrary.getbooklibrarayjson("adsfs", "64977")).when().post("/Library/Addbook.php").then()
				.log().all().statusCode(200).extract().response();

		JsonPath json = new JsonPath(response.asString());

		String id = json.getString("ID");
		System.out.println(id);

	}

}
