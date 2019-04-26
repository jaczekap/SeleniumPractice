package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.google.GoogleMainPage;

public class GooglePageTest {
	
	GoogleMainPage googlePage;
	WebDriver driver;
	ExtentReports extent;
	
	@BeforeSuite
	public void setUpSuite() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("tests_report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

	}
	
	@BeforeMethod
	public void setUpMathod() throws InterruptedException {
		googlePage = new GoogleMainPage();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		PageFactory.initElements(driver, googlePage);
		driver.get(googlePage.getUrl());
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(googlePage.getAllElements()));
	}
	
	@Test
	public void verifyAllElementsAvailableTest() {
		ExtentTest test = extent.createTest("verifyAllElementsAvailable", "Tests if all web elements are displayed");
		try {
			test.info("check if Gmail button available");
			assertTrue(googlePage.getGmailButton().isDisplayed());
			test.log(Status.INFO, "Gmail button found");
			test.info("check if login to Google account button available");
			assertTrue(googlePage.getLoginButton().isDisplayed());
			test.log(Status.INFO, "Google account login button found");
			test.info("check if lucky find button available");
			assertTrue(googlePage.getLuckyFindButton().isDisplayed());
			test.log(Status.INFO, "Lucky find button found");
			test.info("check if search button available");
			assertTrue(googlePage.getSearchButton().isDisplayed());
			test.log(Status.INFO, "search button found");
			test.info("check if search textfield available");
			assertTrue(googlePage.getSearchField().isDisplayed());
			test.log(Status.INFO, "Search textfield found");
		} catch (Exception e) {
			test.log(Status.FAIL, "At least one web element was not present");
		}
		test.log(Status.PASS, "All elements are present and ready to test");
	}
	

	
	@AfterMethod
	public void tearDownMethod() {
		driver.close();
		driver.quit();
	}

	@AfterSuite
	public void tearDownSuite() {
		extent.flush();
	}
	
	
}
