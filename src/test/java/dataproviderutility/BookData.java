package dataproviderutility;

import org.testng.annotations.DataProvider;

public class BookData {


	@DataProvider(name = "Book Data")
	public Object[][] bookDataProvider() {
		 
		
		return new Object[][] {{"adiojh", "1256599"} ,{"asdkofjj", "4215618666"}};
	}
}
