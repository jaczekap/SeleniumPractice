package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelUtils;

public class TestWithDataProvider {


	@Test(dataProvider = "data")
	public void dataProviderTest(String a, String b, String c) {
		System.out.println(a + ", " + b + ", " + c);
	}
	
	
	
	
	@DataProvider(name = "data")
	private Object[][] dataProvider() {
			return new ExcelUtils("src/test/resources/testSheet.xlsx", 0, true).dataProvider();
	}
}
