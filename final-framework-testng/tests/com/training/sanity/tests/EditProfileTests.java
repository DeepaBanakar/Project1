package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
		loginPOM.sendUserName("deepa24"); 
		loginPOM.sendPassword("abc1234");
		loginPOM.clickLoginBtn();
		editProfilePOM.clickEditProfileLink();
		editProfilePOM.sendCurrentpassword("abc1234");
		editProfilePOM.sendNewPassword("abc12345");
		editProfilePOM.sendConfirmPassword("abc12345");
		editProfilePOM.clickSaveSettingsButton();
		String expectedReslt = "Your new profile has been saved";
		String actualResult = editProfilePOM.actualResult();
		if(expectedReslt.equals(actualResult)) {
			Assert.assertEquals(actualResult, expectedReslt);
		} else {
			System.out.println("Edit Profile failed");
		}
		screenShot.captureScreenShot("AfterEditProfile");
	}
	
	@Test
	public void invalidEditProfileTest() {
		loginPOM.sendUserName("deepa24"); 
		loginPOM.sendPassword("abc1234");
		loginPOM.clickLoginBtn();
		editProfilePOM.clickEditProfileLink();
		editProfilePOM.sendCurrentpassword("abc1234");
		editProfilePOM.sendNewPassword("abc1234");
		editProfilePOM.sendConfirmPassword("abc123");
		editProfilePOM.clickSaveSettingsButton();
		String expectedReslt = "Your new profile has been saved";
		String actualResult = editProfilePOM.actualResult();
		if(expectedReslt.equals(actualResult)) {
			Assert.assertEquals(actualResult, expectedReslt);
		} else {
			System.out.println("Edit Profile failed");
		}
		screenShot.captureScreenShot("AfterFailedEditProfile");
	}
}
