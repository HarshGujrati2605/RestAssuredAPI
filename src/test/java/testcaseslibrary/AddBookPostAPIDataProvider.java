package testcaseslibrary;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtilities.JsonConversionUtilities;
import dataproviderutility.BookData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloadutilitis.PayloadLibrary;
import specbuilder.libraryspecbuilder;
import variableutility.GlobalVariable;

import static org.hamcrest.Matchers.*;

public class AddBookPostAPIDataProvider {

	@Test(testName = "Add new book dynamically", priority = 1, groups = "Regression", dataProviderClass = BookData.class, dataProvider = "Book Data")
	public void addbook(String aisle, String isbn) {

		//RestAssured.baseURI = "http://216.10.245.166";  //Given in spec builder
		
		GlobalVariable.isbnlist.add(isbn);           
         
		Response response = given().log().all().spec(libraryspecbuilder.librarySpecBuilder())
				.body(PayloadLibrary.getbooklibrarayjson(aisle , isbn)).when().post("/Library/Addbook.php").then().log()
				.all().statusCode(200).extract().response();

//		JsonPath json = new JsonPath(response.asString());
		
	    String book_id=JsonConversionUtilities.getRawToJsonData(response.asString(), "ID");

		GlobalVariable.book_idlist.add(book_id);

		System.out.println(GlobalVariable.book_idlist.size());

		GlobalVariable.book_idlist.forEach(idname -> System.out.println(idname));

	}

	@Test(testName = "Get created book and validation", priority = 2 , enabled = true)
	public void getCreatedLibraryBookValidation() {

		//RestAssured.baseURI = "http://216.10.245.166"; gave in spec builder

		for (int i=0; i<GlobalVariable.book_idlist.size();i++) {

			RestAssured.basePath = "Library/GetBook.php";
			
			

			String response = given().spec(libraryspecbuilder.librarySpecBuilder()).queryParam("ID", "" + GlobalVariable.book_idlist.get(i) + "").log().all().when().get().then().extract().response().asString();
			
			JsonPath json = new JsonPath(response);
			System.out.println(GlobalVariable.book_idlist.get(i) + "From ISBN List");
			System.out.println(json.getList("isbn").get(0)+ "Actual response isbn");
			assertEquals(json.getList("isbn").get(0), GlobalVariable.isbnlist.get(i));

		}

	}
}
