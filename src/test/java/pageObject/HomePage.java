package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	/// constructor

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement linkMyaccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement linkregister;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;
	// action Method

	public void clickmyAccount() {
		linkMyaccount.click();
	}

	public void clickRegister() {
		linkregister.click();
	}

	public void clickLogin() //// step6
	{
		lnkLogin.click();

	}

}
