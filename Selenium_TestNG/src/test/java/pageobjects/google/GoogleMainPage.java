package pageobjects.google;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleMainPage {
	

private WebDriver driver;
private String url = "http://google.com";

@FindBy(name = "q")
private WebElement searchField;
@FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")
private WebElement searchButton;
@FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[2]")
private WebElement luckyFindButton;
@FindBy(id = "gb_70")
private WebElement loginButton;
@FindBy(className = "gb_d")
private WebElement gmailButton;

public GoogleMainPage() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	PageFactory.initElements(driver, this);
	driver.get(url);
}

public WebDriver getDriver() {
	return driver;
}

public WebElement getSearchField() {
	return searchField;
}

public WebElement getSearchButton() {
	return searchButton;
}

public WebElement getLuckyFindButton() {
	return luckyFindButton;
}

public WebElement getLoginButton() {
	return loginButton;
}

public WebElement getGmailButton() {
	return gmailButton;
}

public List<WebElement> getAllElements() {
	return new ArrayList<WebElement>(){
			{add(getSearchButton());
			add(getSearchField());
			add(getGmailButton());
			add(getLoginButton());
			add(getLuckyFindButton());
			add(getSearchField());
			}
		};
}

}
