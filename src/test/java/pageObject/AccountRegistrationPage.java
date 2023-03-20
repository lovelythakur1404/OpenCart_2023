package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	// counstruction

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}

	// WebElement

	@FindBy(name = "firstname")
	WebElement txtFirstName;
	@FindBy(name = "lastname")
	WebElement txtLastName;
	@FindBy(name = "email")
	WebElement txtemail;
	@FindBy(name = "telephone")
	WebElement txttelephone;
	@FindBy(name = "password")
	WebElement txtpassword;
	@FindBy(name = "confirm")
	WebElement txtconfirmPassword;
	@FindBy(name = "agree")
	WebElement ChkdPolicy;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnCountinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement MsgConfirmation;

//Action Methods

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setTelephone(String tel) {
		txttelephone.sendKeys(tel);
	}

	public void setpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) {
		txtconfirmPassword.sendKeys(pwd);
	}

	public void setPrivacypolicy() {
		ChkdPolicy.click();
	}

	public void Clickcountinue() {
		btnCountinue.click();
	}

	public String getConfirmationMsg() {
		try {
			return MsgConfirmation.getText();
		}

		catch (Exception e) {
			return e.getMessage();
		}
	}

}
