package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterCoursePOM {

private WebDriver driver; 
	
	public RegisterCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='caret']")
	private WebElement logoutDropdown;
	
	@FindBy (id = "logout_button")
	private WebElement logoutButton;
	
	@FindBy(linkText = "Course catalog")
	private WebElement courseCatalogLink;
	
	@FindBy(name = "search_term")
	private WebElement courseSearchBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[@title='Subscribe']")
	private WebElement subscribeButton;
	
	@FindBy(linkText = "My courses")
	private WebElement myCoursesTab;
	
	@FindBy(linkText = "Reporting")
	private WebElement reportingTab;
	
	@FindBy(linkText = "Followed students")
	private WebElement followedStudents;
	
	@FindBy (id = "search_user_keyword")
	private WebElement keywordTextBox;
	
	@FindBy (id = "search_user_submit")
	private WebElement searchStudentButton;
	
	public void clickCourseCatalogLink() {
		this.courseCatalogLink.click();
	}
	public void sendCourseName(String courseName) {
		this.courseSearchBox.sendKeys(courseName);
	}
	public void clickSearchButton() {
		this.searchButton.click();
	}
	public void clickSubscribeButton() {
		this.subscribeButton.click();
	}
	public void clickLogout() {
		this.logoutDropdown.click();
		this.logoutButton.click();
	}
	public void clickMyCoursesTab() {
		this.myCoursesTab.click();
	}
	public void clickCourseLink(String courseName) {
		driver.findElement(By.linkText(courseName)).click();
	}
	public void clickReportingTab() {
		this.reportingTab.click();
	}
	public void clickFollowedStudents() {
		this.followedStudents.click();
	}
	public void sendKeyword(String keyword) {
		this.keywordTextBox.clear();
		this.keywordTextBox.sendKeys(keyword);
	}
	public void clickSearchStudentButton() {
		this.searchStudentButton.click();
	}
	public void clickStudentIcon(String userName) {
		driver.findElement(By.xpath("//img[@title='Details "+userName+"']")).click();
	}
	public void clickCourseDetailsIcon(String courseCode) {
		//To select Course Details icon based on Course Code
		driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[7]/table/tbody/tr/td/a[contains(@href,'"+courseCode.toUpperCase()+"')]/img")).click();
	}
}
