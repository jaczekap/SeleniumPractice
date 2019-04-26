package pageobjects.toledorocket;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToledorocketFileUploadPage {
	
	private String url = "http://www.toledorocket.com/perftest/uploadtest/fileselect.asp";
	
	@FindBy(name = "FILE1")
	private WebElement selectFileButton;
	@FindBy(xpath = "//input[@value='Upload!']")
	private WebElement uploadButton;
	
	
	public String getUrl() {
		return url;
	}
	public WebElement getSelectFileButton() {
		return selectFileButton;
	}
	public WebElement getUploadButton() {
		return uploadButton;
	}
	
	

}
