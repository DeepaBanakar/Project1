package com.training.sanity.tests;

/*TO verify whether application allows multiple users to get registered as Student using Excel sheet as Data provider
*/
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTests_ExcelTest {

	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPOM = new RegisterPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void validRegisterTest(String firstName, String lastName, String email, String userName, String password, String confirmPassword, String phone, String language) throws InterruptedException {
		registerPOM.clickSignUp();
		registerPOM.sendFirstName(firstName);
		registerPOM.sendLastName(lastName);
		registerPOM.sendEmail(email);
		registerPOM.sendUserName(userName);
		registerPOM.sendPassWord(password);
		registerPOM.sendConfirmPassword(confirmPassword);
		registerPOM.sendPhoneNumber(phone);
		registerPOM.selectLanguage(language);
		registerPOM.selectProfile("Student");
		screenShot.captureScreenShot("Before Registration_Excel");
		Thread.sleep(2000);
		registerPOM.clickRegisterButton();
		//Verify successful registration
		if(driver.getPageSource().contains("Your personal settings have been registered.")) {
			String expectedMessage = "Dear "+firstName+" "+lastName+",\n\n"
					+ "Your personal settings have been registered.\n"
					+ "An e-mail has been sent to remind you of your login and password.\n"
					+ "You can now select, in the list, the course you want access to.";	
			Assert.assertEquals(registerPOM.actualResult(),expectedMessage);
		} else if(registerPOM.getFailureMessage().equals("Required field")){
			System.out.println(registerPOM.getFailureMessage()+"s are missing, Registration failed.");
		} else {
			System.out.println(registerPOM.getFailureMessage());
		}
		screenShot.captureScreenShot("After Success_Registration_Excel");
	}	
}
