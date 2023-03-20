package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']") ///// myaccount page heading
	WebElement msgHeading;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") ///// myaccount page heading
	WebElement linkLogout;
	// action Method

	public boolean isMyAccountPageExists() // MyAccount Page heading display status
	{

		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);

		}

	}

	public void Clicklogout() {
		linkLogout.click();
	}

}
