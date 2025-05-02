package dataproviderutility;

import org.testng.annotations.DataProvider;

public class BookData {


	@DataProvider(name = "Book Data")
	public Object[][] bookDataProvider() {
		 
		
		return new Object[][] {{"1236", "aidip"} ,{"7896", "aidpq"}};
	}
}
