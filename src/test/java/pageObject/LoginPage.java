package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Find WebElements through @findby annotaion for login page*************

	@FindBy(name = "email")
	WebElement txtemail;

	@FindBy(name = "password")
	WebElement txtpassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnlogin;

	///// Action Method

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setPassword(String password) {
		txtpassword.sendKeys(password);
	}

	public void clickLogin() {
		btnlogin.click();
	}

}
