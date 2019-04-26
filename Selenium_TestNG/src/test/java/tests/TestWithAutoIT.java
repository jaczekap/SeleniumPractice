package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.toledorocket.ToledorocketFileUploadPage;

public class TestWithAutoIT {
	
	private WebDriver driver;
	private ToledorocketFileUploadPage page;
	
	@BeforeMethod
	public void setUp() {
		page = new ToledorocketFileUploadPage();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		PageFactory.initElements(driver, page);
		driver.get(page.getUrl());
	}
	
	@Test
	public void uploadFileTest() throws IOException {
		String filePath = "M:\\Git_Repos\\SeleniumPractice\\Selenium_TestNG\\src\\test\\resources\\testSheet.xlsx";
		page.getSelectFileButton().click();
		Runtime.getRuntime().exec(new String[] {"src/test/resources/upload_file_on_page_script.exe", filePath});
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}