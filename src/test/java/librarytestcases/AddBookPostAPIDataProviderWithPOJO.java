package librarytestcases;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataproviderutility.BookData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloadutilitis.LibraryPojoclass;
import payloadutilitis.PayloadLibrary;
import variableutility.GlobalVariable;

import static org.hamcrest.Matchers.*;

public class AddBookPostAPIDataProviderWithPOJO {

	@Test(testName = "Add new book dynamically", priority = 1, groups = "Regression", dataProviderClass = BookData.class, dataProvider = "Book Data")
	public void addbook(String aisle, String isbn) {

		RestAssured.baseURI = "http://216.10.245.166";
		
		GlobalVariable.isbnlist.add(isbn);  
		
		LibraryPojoclass m = new LibraryPojoclass();
		
		m.setName("Java Automation");
		m.setIsbn(isbn);
		m.setAisle(aisle);
		m.setAuthor("Harry");
         
		Response response = given().log().all().header("Content-Type", "application/json")
				.body(m).when().post("/Library/Addbook.php").then().log()
				.all().statusCode(200).extract().response();

		JsonPath json = new JsonPath(response.asString());

		GlobalVariable.book_idlist.add(json.getString("ID"));

		System.out.println(GlobalVariable.book_idlist.size());

		GlobalVariable.book_idlist.forEach(idname -> System.out.println(idname));

	}

	@Test(testName = "Get created book and validation", priority = 2 , enabled = true)
	public void getCreatedLibraryBookValidation() {

		RestAssured.baseURI = "http://216.10.245.166";

		for (int i=0; i<GlobalVariable.book_idlist.size();i++) {

			RestAssured.basePath = "Library/GetBook.php";
			
			

			String response = given().queryParam("ID", "" + GlobalVariable.book_idlist.get(i) + "").log().all().when().get().then().extract().response().asString();
			
			JsonPath json = new JsonPath(response);
			System.out.println(GlobalVariable.book_idlist.get(i) + "From ISBN List");
			System.out.println(json.getList("isbn").get(0)+ "Actual response isbn");
			assertEquals(json.getList("isbn").get(0), GlobalVariable.isbnlist.get(i));

		}

	}
}
