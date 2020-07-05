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
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTests {

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
	@Test(enabled = false)
	public void validRegisterTest() {
		String firstName = "Deepa", lastName="Banakar";
		registerPOM.clickSignUp();
		registerPOM.sendFirstName(firstName);
		registerPOM.sendLastName(lastName);
		registerPOM.sendEmail("deepa@123.com");
		registerPOM.sendUserName("deepa26");
		registerPOM.sendPassWord("abc12345");
		registerPOM.sendConfirmPassword("abc12345");
		registerPOM.sendPhoneNumber("0000000000");
		registerPOM.selectLanguage("Galego");
		registerPOM.selectLanguage("English");
		registerPOM.selectProfile("Student");
		screenShot.captureScreenShot("Before Registarion");
		registerPOM.clickRegisterButton(); 
		if(driver.getPageSource().contains("Your personal settings have been registered.")) {
			String expectedMessage = "Dear "+firstName+" "+lastName+",\n\n"
					+ "Your personal settings have been registered.\n"
					+ "An e-mail has been sent to remind you of your login and password.\n"
					+ "You can now select, in the list, the course you want access to.";	
			Assert.assertEquals(registerPOM.actualResult(),expectedMessage);
		} else {
			System.out.println(registerPOM.getFailureMessage()+"s are missing, Registration failed.");
		}
		screenShot.captureScreenShot("After Success_Registration");
	}
	
	@Test(enabled = false)
	public void invalidRegisterTest() {
		String firstName = "Deepa", lastName="Banakar";
		registerPOM.clickSignUp();
		registerPOM.sendFirstName(firstName);
		registerPOM.sendLastName(lastName);
		registerPOM.sendEmail("deepa@123.com");
		registerPOM.sendUserName("deepa26");
		//registerPOM.sendPassWord("abc12345");
		registerPOM.sendConfirmPassword("abc12345");
		registerPOM.sendPhoneNumber("0000000000");
		registerPOM.selectLanguage("Galego");
		registerPOM.selectLanguage("English");
		registerPOM.selectProfile("student");
		screenShot.captureScreenShot("Before Registarion");
		registerPOM.clickRegisterButton(); 
		if(driver.getPageSource().contains("Your personal settings have been registered.")) {
			String expectedMessage = "Dear "+firstName+" "+lastName+",\n\n"
					+ "Your personal settings have been registered.\n"
					+ "An e-mail has been sent to remind you of your login and password.\n"
					+ "You can now select, in the list, the course you want access to.";	
			Assert.assertEquals(registerPOM.actualResult(),expectedMessage);
		} else {
			System.out.println(registerPOM.getFailureMessage()+"s are missing, Registration failed.");
		}
		screenShot.captureScreenShot("After Failed_Registration");
	}
	
	@Test
	public void validRegisterTestTeacher() {
		String firstName = "Deepa", lastName="Banakar";
		registerPOM.clickSignUp();
		registerPOM.sendFirstName(firstName);
		registerPOM.sendLastName(lastName);
		registerPOM.sendEmail("deepa@123.com");
		registerPOM.sendUserName("deepa103");
		registerPOM.sendPassWord("abc12345");
		registerPOM.sendConfirmPassword("abc12345");
		registerPOM.sendPhoneNumber("0000000000");
		registerPOM.selectLanguage("Galego");
		registerPOM.selectLanguage("English");
		registerPOM.selectProfile("Teacher");
		screenShot.captureScreenShot("Before Registration");
		registerPOM.clickRegisterButton(); 
		if(driver.getPageSource().contains("Your personal settings have been registered.")) {
			String expectedMessage = "Dear "+firstName+" "+lastName+",\n\n"
					+ "Your personal settings have been registered.\n"
					+ "An e-mail has been sent to remind you of your login and password.\n" + 
					"  Next";	
			Assert.assertEquals(registerPOM.actualResult(),expectedMessage);
		} else {
			System.out.println(registerPOM.getFailureMessage()+"s are missing, Registration failed.");
		}
		screenShot.captureScreenShot("After Success_Registration");
	}
	
}
