package com.training.sanity.tests;

/*To verify whether application allows teacher to create a Test
1. Login as Teacher
2. Select Course to create Test
3. Add questions and Answers
4. Preview Test*/

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
import com.training.pom.CreateTestPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreateTestTests {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CreateTestPOM createTestPOM;
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
		  createTestPOM = new CreateTestPOM(driver);
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
	public void validCreateTestTest() throws InterruptedException {
		//Login as Teacher
		loginPOM.sendUserName("deepa100");
		loginPOM.sendPassword("abc12345");
		loginPOM.clickLoginBtn(); 
		//Navigate to course
		createTestPOM.clickMyCourses();
		createTestPOM.selectCourseName("selenium359");
		//Start creating Test
		createTestPOM.clickTestsIcon();
		createTestPOM.clickCreateNewTestButton();
		createTestPOM.sendTestName("Online quiz");
		createTestPOM.clickAdvanceSettings();
		createTestPOM.sendGiveContext("quiz");
		createTestPOM.selectFeedback("end of test");
		//createTestPOM.selectFeedback("immediate");
		//createTestPOM.selectFeedback("no feedback");
		createTestPOM.checkEnableStartTime("start time");
		//createTestPOM.checkEnableStartTime("end time");
		createTestPOM.selectStartTime("Nov", "2022", "3", "3", "55");
		createTestPOM.sendPassPercentage("50");
		createTestPOM.clickProceedToQuetions();
		Assert.assertTrue(driver.getPageSource().contains("Exercise added"),"Exercise creation failed");
		//Start adding Multiple choice questions
		//First Question
		createTestPOM.clickMultipleChoiceIcon();
		Assert.assertTrue(driver.getPageSource().contains("Add this question to the test: Multiple choice"),"Add question page not dispalyed");
		createTestPOM.sendQuestion("which course you are learning?");
		createTestPOM.sendOption(1,"Java");
		createTestPOM.sendOption(2, "Selenium");
		createTestPOM.sendOption(3, "C");
		createTestPOM.sendOption(4, "C#");
		createTestPOM.selectCorrectAnswer(2);
		createTestPOM.clickAddThisQuestionButton();
		Assert.assertTrue(driver.getPageSource().contains("1 questions, for a total score (all questions) of 0."),"Question not added");
		//Second question
		createTestPOM.clickMultipleChoiceIcon();
		Assert.assertTrue(driver.getPageSource().contains("Add this question to the test: Multiple choice"),"Add question page not dispalyed");
		createTestPOM.sendQuestion("which course you have completed?");
		createTestPOM.sendOption(1,"Selenium");
		createTestPOM.sendOption(2, "C");
		createTestPOM.sendOption(3, "Java");
		createTestPOM.sendOption(4, "C#");
		createTestPOM.selectCorrectAnswer(3);
		createTestPOM.clickAddThisQuestionButton();
		Assert.assertTrue(driver.getPageSource().contains("2 questions, for a total score (all questions) of 0."),"Question not added");
		createTestPOM.clickPreviewIcon();
		//Start Test
		createTestPOM.clickStartTestButton();
		createTestPOM.selectAnswer(2);
		createTestPOM.clickNextQuestionButton();
		createTestPOM.selectAnswer(4);
		createTestPOM.clickEndTestButton();
		//Validate Test results
		Assert.assertTrue(driver.getPageSource().contains("Saved."),"Quiz not saved");
		Assert.assertTrue(driver.getPageSource().contains("Score for the test:"),"Score is not displayed");
		screenShot.captureScreenShot("After_Test_Creation");
	}
}

