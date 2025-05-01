package librarytestcases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataproviderutility.BookData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payloadutilitis.PayloadLibrary;
import variableutility.GlobalVariable;

import static org.hamcrest.Matchers.*;


public class AddBookPostAPIDataProvider {
	
	
	@Test(testName = "Add new book dynamically" , priority = 1, groups = "Regression" , dataProviderClass = BookData.class , dataProvider = "Book Data")
	public void addbook(String isbn , String aisle) {
		
		RestAssured.baseURI="http://216.10.245.166";
//		RestAssured.basePath = "";
		
	Response response =	given().log().all().header( "Content-Type" , "application/json").body(PayloadLibrary.getbooklibrarayjson(isbn , aisle)).
			                when().post("/Library/Addbook.php").
			                then().log().all().statusCode(200).extract().response();
	
	JsonPath json = new JsonPath(response.asString());
	
	GlobalVariable.book_idlist.add(json.getString("ID"));
	
	System.out.println(GlobalVariable.book_idlist.size());
	
	GlobalVariable.book_idlist.forEach(idname-> System.out.println(idname));
	
	}
	
	
	
	

}
