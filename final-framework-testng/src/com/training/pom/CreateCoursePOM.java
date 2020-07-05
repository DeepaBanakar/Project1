package com.training.pom;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCoursePOM {
	
private WebDriver driver; 
	
	public CreateCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Create a course")
	private WebElement createCourseLink;
	
	@FindBy(id = "title")
	private WebElement courseNameTextBox;
	
	@FindBy(id = "advanced_params")
	private WebElement advancedSettingsButton;
	
	@FindBy(xpath = "//button[@data-id='add_course_category_code']")
	private WebElement categoryListBox;
	
	@FindBy(xpath = "//div[@class='dropdown bootstrap-select form-control dropup open']//div[@class='bs-searchbox']//input[@role='textbox']")
	private WebElement categorySearchTextBox;
	
	@FindBy(id = "add_course_wanted_code")
	private WebElement courseCodeTextBox;
	
	@FindBy(xpath = "//button[@data-id='add_course_course_language']")
	private WebElement languageDropDown;
	
	@FindBy(xpath = "//div[@class='dropdown bootstrap-select form-control dropup open']//div[@class='bs-searchbox']//input[@role='textbox']")
	private WebElement languageSearchBox;
	
	@FindBy(id = "add_course_submit")
	private WebElement createCourseButton;
	
	@FindBy(xpath = "//a[@title='Add an introduction text']")
	private WebElement addAnInstructionIcon;
	
	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement introductionTextbox;
	
	@FindBy(id = "introduction_text_intro_cmdUpdate")
	private WebElement saveIntroButton;
	
	@FindBy(xpath = "//img[@title='Course description']")
	private WebElement courseDescriptionIcon;
	
	@FindBy(xpath = "//img[@title='Description']")
	private WebElement descriptionIcon;
	
	@FindBy(id ="course_description_title")
	private WebElement descriptionTitle;
	
	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement descriptionContentBox;
	
	@FindBy(id ="course_description_submit")
	private WebElement descriptionSubmitButton;
	
	@FindBy(xpath = "//img[@title='Objectives']")
	private WebElement objectivesIcon;
	
	@FindBy(id ="course_description_title")
	private WebElement objectivesTitle;
	
	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement objectivesContentBox;
	
	@FindBy(id ="course_description_submit")
	private WebElement objectivesSubmitButton;
	
	@FindBy(xpath = "//img[@title='Topics']")
	private WebElement topicsIcon;
	
	@FindBy(id ="course_description_title")
	private WebElement topicsTitle;
	
	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement topicsContentBox;
	
	@FindBy(id ="course_description_submit")
	private WebElement topicsSubmitButton;
	
	@FindBy(xpath = "//div[@class='alert alert-info']")
	private WebElement successMessage;
	
	public int getRandomNumber() {
		//Random number generation
		Random random = new Random();
		return random.nextInt(1000);
	}
	
	public void clickCreateCourseLink() {
		this.createCourseLink.click();
	}
	public void sendCourseName(String courseName) {
		this.courseNameTextBox.sendKeys(courseName);
	}
	public void clickAdvanceSettingsButton() {
		this.advancedSettingsButton.click();
	}
	public void selectCategory(String category) {
		this.categoryListBox.click();
		this.categorySearchTextBox.sendKeys(category,Keys.ENTER);
	}
	public void selectCourseCode(String courseCode) {
		this.courseCodeTextBox.sendKeys(courseCode);
	}
	public void selectLanguage(String language) throws InterruptedException {
		this.languageDropDown.click();
		this.languageSearchBox.sendKeys(language,Keys.ENTER);
	}
	public void clickCreateCourseButton() {
		this.createCourseButton.click();
	}
	public void clickAddInstructionIcon() {
		this.addAnInstructionIcon.click();
	}
	public void sendIntroduction(String introductionText) throws InterruptedException {
		Thread.sleep(5000);
		//Switch to Frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		this.introductionTextbox.sendKeys(introductionText);
		//back to default window
		driver.switchTo().defaultContent();
	}
	public void clickSaveIntroButton() {
		this.saveIntroButton.click();
	}
	public void clickCourseDescriptionIcon() {
		this.courseDescriptionIcon.click();
	}
	public void clickDescriptionIcon() {
		this.descriptionIcon.click();
	}
	public void sendDecriptionTitle(String descriptionTitle) {
		this.descriptionTitle.sendKeys(descriptionTitle);
	}
	public void sendDecriptionContent(String descriptionContent) throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		this.descriptionContentBox.sendKeys(descriptionContent);
		driver.switchTo().defaultContent();
	}
	public void clickDescriptionSaveButton() {
		this.descriptionSubmitButton.click();
	}
	public void clickObjectivesIcon() {
		this.objectivesIcon.click();
	}
	public void sendObjectivesTitle(String objectivesTitle) {
		this.objectivesTitle.sendKeys(objectivesTitle);
	}
	public void sendObjectivesContent(String objectivesContent) throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		this.objectivesContentBox.sendKeys(objectivesContent);
		driver.switchTo().defaultContent();
	}
	public void clickObjectivesSaveButton() {
		this.objectivesSubmitButton.click();
	}
	public void clickTopicsIcon() {
		this.topicsIcon.click();
	}
	public void sendTopicsTitle(String topicsTitle) {
		this.topicsTitle.sendKeys(topicsTitle);
	}
	public void sendTopicsContent(String topicsContent) throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		this.topicsContentBox.sendKeys(topicsContent);
		driver.switchTo().defaultContent();
	}
	public void clickTopicsSaveButton() {
		this.topicsSubmitButton.click();
	}
}
