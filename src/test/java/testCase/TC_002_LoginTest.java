package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test
	public void Test_login()

	{
		try {
			logger.info("*** starting TC_002_LoginTest ****** ");
			HomePage hp = new HomePage(driver);
			hp.clickmyAccount();
			logger.info("Clicked in Login Btn");
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(rb.getString("email")); /// get it from config file
			lp.setPassword(rb.getString("password")); /// get it from config file
			lp.clickLogin();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();
			Assert.assertEquals(targetpage, true, "Invalid data provided");
			logger.info("Clicked in LogOut Btn");
			macc.Clicklogout();
		}

		catch (Exception e) {
			Assert.fail();
		}

		logger.info("*** Complete TC_002_LoginTest ******");
	}

}
