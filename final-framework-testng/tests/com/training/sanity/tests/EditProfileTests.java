package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.EditProfilePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditProfileTests {
  
	private WebDriver driver;
	private String baseUrl;
	private EditProfilePOM editProfilePOM;
	private LoginPOM loginPOM;
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
		loginPOM = new LoginPOM(driver);
		editProfilePOM = new EditProfilePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validEditProfileTest() {
		
		loginPOM.sendUserName("deepa25");
		loginPOM.sendPassword("abc12345");
		loginPOM.clickLoginBtn();
		editProfilePOM.clickEditProfileLink();
		editProfilePOM.sendCurrentpassword("abc12345");
		editProfilePOM.sendNewPassword("abc1234");
		editProfilePOM.sendConfirmPassword("abc1234");
		editProfilePOM.clickSaveSettingsButton();
		editProfilePOM.validateSaveSuccessMesssage();
		screenShot.captureScreenShot("AfterEditProfile");
	}
	
	@Test
	public void invalidEditProfileTest() {
		
		loginPOM.sendUserName("deepa25");
		loginPOM.sendPassword("abc12345");
		loginPOM.clickLoginBtn();
		editProfilePOM.clickEditProfileLink();
		editProfilePOM.sendCurrentpassword("abc12345555");
		editProfilePOM.sendNewPassword("abc1234");
		editProfilePOM.sendConfirmPassword("abc1234");
		editProfilePOM.clickSaveSettingsButton();
		editProfilePOM.validateSaveSuccessMesssage();
		screenShot.captureScreenShot("AfterEditProfile");
	}
}
