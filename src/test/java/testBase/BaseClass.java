package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;

	public Logger logger;

	public ResourceBundle rb;

	@BeforeClass
	@Parameters("browser")
	public void Setup(String br) // getting browser parameter from testng.xml
	{

		rb = ResourceBundle.getBundle("config"); // Load config.properties file
		logger = LogManager.getLogger(this.getClass()); // logging

		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("AppUrl"));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String rendomString() // return randome string
	{
		String genetratedstring = RandomStringUtils.randomAlphabetic(5);
		return (genetratedstring);
	}

	public String randomnumeric() {
		String randomnumber = RandomStringUtils.randomNumeric(9);
		return (randomnumber);
	}

	public String rendomalpha() // return randome string
	{
		String genetratealph = RandomStringUtils.randomAlphanumeric(5);
		return (genetratealph + "#");
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
