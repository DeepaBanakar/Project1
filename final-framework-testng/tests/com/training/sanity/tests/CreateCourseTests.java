package com.training.sanity.tests;

/*To verify whether application allows teacher to create a course, add description, objective & Topics
1. Login As Teacher
2. Create a Course
3. Add Introduction, Description, Objectives and Topics.*/

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
import com.training.pom.CreateCoursePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreateCourseTests {
  
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CreateCoursePOM createCoursePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	  @BeforeMethod public void setUp() throws Exception {
		  driver = DriverFactory.getDriver(DriverNames.CHROME);
		  createCoursePOM = new CreateCoursePOM(driver);
			loginPOM = new LoginPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
	  }
	 
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//Close the browser
		driver.quit();
	}
	@Test
	public void validCreateCourseTest() throws InterruptedException {
		//Login as Teacher
		loginPOM.sendUserName("deepa100");
		loginPOM.sendPassword("abc12345");
		loginPOM.clickLoginBtn(); 
		//Start Creating course
		createCoursePOM.clickCreateCourseLink();
		//Get Random Number
		int i = createCoursePOM.getRandomNumber();
		createCoursePOM.sendCourseName("selenium"+i);
		createCoursePOM.clickAdvanceSettingsButton();
		//Validate category, Course Code and Language attributes appeared on screen
		Assert.assertTrue(driver.getPageSource().contains("Category"),"Category Not Present");
		Assert.assertTrue(driver.getPageSource().contains("Course code"),"Course Code Not Present");
		Assert.assertTrue(driver.getPageSource().contains("Language"),"Language Not Present");
		createCoursePOM.selectCategory("Projects");
		createCoursePOM.selectCourseCode("sel"+i);
		createCoursePOM.selectLanguage("English");
		createCoursePOM.clickCreateCourseButton();
		//Validate Course is successfully created
		Assert.assertTrue(driver.getTitle().equals("My Organization - My education - selenium"+i),"Course Creation failed");
		//Add Introduction
		createCoursePOM.clickAddInstructionIcon();	
		createCoursePOM.sendIntroduction("this is an selenium course123");
		createCoursePOM.clickSaveIntroButton();
		//Validate Introduction has been updated
		Assert.assertTrue(driver.getPageSource().contains("Intro was updated"),"Intro save message not available");
		Assert.assertTrue(driver.getPageSource().contains("this is an selenium course123"),"Intro save message not available");
		//Add Description
		createCoursePOM.clickCourseDescriptionIcon();
		createCoursePOM.clickDescriptionIcon();
		createCoursePOM.sendDecriptionTitle("selenium course for beginners1");
		createCoursePOM.sendDecriptionContent("selenium course for beginners2");
		createCoursePOM.clickDescriptionSaveButton();
		//Validate Description has been updated
		Assert.assertTrue(driver.getPageSource().contains("The description has been updated"),"Update message not displayed");
		Assert.assertTrue(driver.getPageSource().contains("selenium course for beginners2"),"Update message not displayed");
		//Add Objectives
		createCoursePOM.clickObjectivesIcon();
		createCoursePOM.sendObjectivesTitle("selenium course for beginners3");
		createCoursePOM.sendObjectivesContent("selenium course for beginners4");
		createCoursePOM.clickObjectivesSaveButton();
		//Validate Objectives has been updated
		Assert.assertTrue(driver.getPageSource().contains("The description has been updated"),"Update message not displayed");
		Assert.assertTrue(driver.getPageSource().contains("selenium course for beginners4"),"Update message not displayed");
		//Add Topics
		createCoursePOM.clickTopicsIcon();
		createCoursePOM.sendTopicsTitle("selenium course for beginners5");
		createCoursePOM.sendTopicsContent("selenium course for beginners6");
		createCoursePOM.clickTopicsSaveButton();
		//validate Topics has been updated
		Assert.assertTrue(driver.getPageSource().contains("The description has been updated"),"Update message not displayed");
		Assert.assertTrue(driver.getPageSource().contains("selenium course for beginners6"),"Update message not displayed");
		screenShot.captureScreenShot("After_Course_Creation");
	}
	
}
