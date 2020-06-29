package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		driver.quit();
	}
	@Test
	public void validRegisterTest() {
		String firstName = "Deepa", lastName="Banakar";
		registerPOM.clickSignUp();
		registerPOM.sendFirstName(firstName);
		registerPOM.sendLastName(lastName);
		registerPOM.sendEmail("deepa@123.com");
		registerPOM.sendUserName("deepa25");
		registerPOM.sendPassWord("abc12345");
		registerPOM.sendConfirmPassword("abc12345");
		registerPOM.sendPhoneNumber("0000000000");
		registerPOM.selectLanguage("Galego");
		registerPOM.selectLanguage("English");
		registerPOM.selectStudentProfile();
		screenShot.captureScreenShot("Before Registarion");
		registerPOM.clickRegisterButton(); 
		registerPOM.validateRegisterMessage(firstName,lastName);
		screenShot.captureScreenShot("After Success_Registration");
	}
	
	@Test
	public void invalidRegisterTest() {
		String firstName = "Deepa", lastName="Banakar";
		registerPOM.clickSignUp();
		registerPOM.sendFirstName(firstName);
		registerPOM.sendLastName(lastName);
		registerPOM.sendEmail("deepa@123.com");
		registerPOM.sendUserName("deepa25");
		//registerPOM.sendPassWord("abc12345");
		registerPOM.sendConfirmPassword("abc12345");
		registerPOM.sendPhoneNumber("0000000000");
		registerPOM.selectLanguage("Galego");
		registerPOM.selectLanguage("English");
		registerPOM.selectStudentProfile();
		screenShot.captureScreenShot("Before Registarion");
		registerPOM.clickRegisterButton(); 
		registerPOM.validateRegisterMessage(firstName,lastName);
		screenShot.captureScreenShot("After Failed_Registration");
	}
	
}
