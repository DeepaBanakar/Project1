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
import com.training.pom.AddAssementsPOM;
import com.training.pom.CreateTestPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddAssessmentsTests {
  
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CreateTestPOM createTestPOM;
	private AddAssementsPOM addAssessmentsPOM;
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
		  addAssessmentsPOM = new AddAssementsPOM(driver);
			loginPOM = new LoginPOM(driver); 
			createTestPOM = new CreateTestPOM(driver);
			addAssessmentsPOM = new AddAssementsPOM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
	  }
	 
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//Close the browser
		//driver.quit();
	}
	@Test
	public void validAddAssessementTest() throws InterruptedException {
		//Login as Teacher
		loginPOM.sendUserName("deepa100");
		loginPOM.sendPassword("abc12345");
		loginPOM.clickLoginBtn(); 
		//Navigate to course
		createTestPOM.clickMyCourses();
		createTestPOM.selectCourseName("selenium359");
		//Add Assessment
		addAssessmentsPOM.clickAssessmentsIcon();
		addAssessmentsPOM.clickAddOnlineActivityIcon();
		addAssessmentsPOM.selectTypeOfActivity("Tests");
		addAssessmentsPOM.selectActivity();
		addAssessmentsPOM.clickAddLearningActivityButton();
		//Validate Assessment is successfully created
		Assert.assertTrue(driver.getPageSource().contains("The link has been added."),"Assessment Not added");
		//Edit Assessment
		addAssessmentsPOM.clickEditIcon();
		addAssessmentsPOM.sendWeight("30");
		//Verify Visible check box is checked
		Assert.assertTrue(addAssessmentsPOM.verifyVisibleTextbox(),"Visible check box is not checked");
		addAssessmentsPOM.clickEditLinkButton();
		//Verify Default Certificate is present on Certificates page
		addAssessmentsPOM.clickAddCertificateIcon();
		Assert.assertTrue(driver.getPageSource().contains("Default certificate"),"Default Certifucate Not found");
		screenShot.captureScreenShot("After_Assessments_Creation");
	}
}
