package testcaseslibrary;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataproviderutility.BookData;
import excelutility.ExcelDataSupplier;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloadutilitis.PayloadLibrary;
import specbuilder.libraryspecbuilder;
import variableutility.GlobalVariable;

import static org.hamcrest.Matchers.*;

public class AddBookPostAPIDataProviderUsingExcel {

	@Test(testName = "Add new book dynamically", priority = 1, groups = "Regression", dataProviderClass = ExcelDataSupplier.class, dataProvider = "BookDataFromExcel")
	public void addbook(String aisle, String isbn) {

		GlobalVariable.isbnlist.add(isbn);
		Response response = given().log().all().spec(libraryspecbuilder.librarySpecBuilder())
				.body(PayloadLibrary.getbooklibrarayjson(aisle, isbn)).when().post("/Library/Addbook.php").then().log()
				.all().statusCode(200).extract().response();

		JsonPath json = new JsonPath(response.asString());

		GlobalVariable.book_idlist.add(json.getString("ID"));

		System.out.println(GlobalVariable.book_idlist.size());

		GlobalVariable.book_idlist.forEach(idname -> System.out.println(idname));

	}

}
