package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {

	@Test
	public void test_account_registration() {

		logger.debug("Application logs ");
		logger.info("**** starting TC_001_AccountRegistration ****");

		try {
			HomePage hp = new HomePage(driver);
			// access action methods from homepage class
			hp.clickmyAccount();
			logger.info("Clciked on my account link");

			hp.clickRegister();
			logger.info("Clicked onregister link");
			AccountRegistrationPage regp = new AccountRegistrationPage(driver);

			// access action method for AccountRegistrationPage class
			logger.info("****providing data to registreation form ****");
			regp.setFirstName(rendomString().toUpperCase());

			regp.setLastName(rendomString().toUpperCase());
			regp.setEmail(rendomString() + "@gmail.com"); /// Random generated email...
			regp.setTelephone(randomnumeric());
			// create password
			String password = rendomalpha();
			regp.setpassword(password);
			regp.setConfirmPassword(password);
			logger.info("Clicked on privacy policy");
			regp.setPrivacypolicy();
			logger.info("Clicked on countinue button ");
			regp.Clickcountinue();
			logger.info("Validate expected message");
			String actualmsg = regp.getConfirmationMsg();
			Assert.assertEquals(actualmsg, "Your Account Has Been Created!");

		}

		catch (Exception e) {

			logger.error("test failed");
			Assert.fail();
		}
		logger.info("****Test Completed*****");
	}
}