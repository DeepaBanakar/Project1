package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateTestPOM {
	
private WebDriver driver; 
	
	public CreateTestPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "My courses")
	private WebElement myCoursesLink;
	
	@FindBy (xpath = "//img[@title='Tests']")
	private WebElement testsIcon;
	
	@FindBy(xpath = "//img[@title='Create a new test']")
	private WebElement createNewTestButton;
	
	@FindBy(id = "exercise_title")
	private WebElement testNameTextbox;
	
	@FindBy(id = "advanced_params")
	private WebElement advancedSettingsIcon;
	
	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement giveContextTextbox;
	
	@FindBy(id = "start_time_alt_text")
	private WebElement startTimeText;
	
	@FindBy(className = "ui-datepicker-month")
	private WebElement monthPicker;
	
	@FindBy(className = "ui-datepicker-year")
	private WebElement yearPicker;
	
	@FindBy(//css = ".ui_tpicker_hour_slider")
			xpath = "//div[@class='ui_tpicker_hour_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']/span[@class='ui-slider-handle ui-state-default ui-corner-all']")
	private WebElement hourSlider;
	
	@FindBy(//css = ".ui_tpicker_minute_slider")
			xpath = "//div[@class='ui_tpicker_minute_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']/span[@class='ui-slider-handle ui-state-default ui-corner-all']")
	private WebElement minuteSlider;
	
	@FindBy (xpath = "//button[contains(text(),'Done')]")
	private WebElement doneButton;
	
	@FindBy (id = "pass_percentage")
	private WebElement passPercentage;
	
	@FindBy(id = "exercise_admin_submitExercise")
	private WebElement proceedToQuetions;
	
	@FindBy(xpath = "//img[@title='Multiple choice']")
	private WebElement multipleChoiceIcon;
	
	@FindBy(id = "question_admin_form_questionName")
	private WebElement questionTextbox;
	
	@FindBy(css = ".cke_editable")
	private WebElement answerTextbox;
	
	@FindBy (id = "submit-question")
	private WebElement addThisQuestionButton;
	
	@FindBy (xpath = "//img[@title='Preview']")
	private WebElement previewIcon;
	
	@FindBy(xpath = "//a[contains(text(),'Start test')]")
	private WebElement startTestButton;
	
	@FindBy (xpath = "//button[contains(text(),'Next question')]")
	private WebElement nextQuestionButton;
	
	@FindBy (xpath = "//button[contains(text(),'End test')]")
	private WebElement endTestButton;
	
	public void clickMyCourses(){
		this.myCoursesLink.click();
	}
	public void selectCourseName(String courseName) {
		driver.findElement(By.partialLinkText(courseName)).click();
	}
	public void clickTestsIcon() {
		this.testsIcon.click();
	}
	public void clickCreateNewTestButton() {
		this.createNewTestButton.click();
	}
	public void sendTestName(String testName) {
		this.testNameTextbox.sendKeys(testName);
	}
	public void clickAdvanceSettings() {
		this.advancedSettingsIcon.click();
	}
	public void sendGiveContext(String giveContext) throws InterruptedException {
		Thread.sleep(1000);
		//Switch to Frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, exerciseDescription']")));
		this.giveContextTextbox.sendKeys(giveContext);
		//Back to default window
		driver.switchTo().defaultContent();
	}
	public void selectFeedback(String feedbackType) {
		//To select Feed back type based on user input
		driver.findElement(By.xpath("//label[contains(text(),'"+feedbackType+"')]")).click();
	}
	public void checkEnableStartTime(String timeType) {
		//To select Time type based on user input
		driver.findElement(By.xpath("//label[contains(text(),'"+timeType+"')]")).click();
	}
	public void selectStartTime(String month, String year, String date1, String hour, String minute) throws InterruptedException {
		this.startTimeText.click();
		//Select Month
		Select select = new Select(this.monthPicker);
		select.selectByVisibleText(month);
		//Select Year
		select = new Select(this.yearPicker);
		select.selectByValue(year);
		//Select Date
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a[contains(text(),'"+date1+"')]")).click();
		//Set Time
		/* Using Java script 
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].setAttribute('style', 'left: 30%;')",this.hourSlider);
		 * js.executeScript("arguments[0].setAttribute('style', 'left: 30%;')",this.minuteSlider);
		 */
		
		 /* Using Actions
		  * Actions moveSlider = new Actions(driver); 
		  * Action action = moveSlider.dragAndDropBy(this.hourSlider, -100, 0).build(); action.perform();
		 * int x = (int) ((Double.parseDouble(hour)/12)*100) - 100;
		 * System.out.println(x); 
		 * int y = (int)((Double.parseDouble(minute)/60)*100);
		 * System.out.println(y); 
		 * action = moveSlider.dragAndDropBy(this.hourSlider, x, 0).build(); action.perform(); 
		 * action = moveSlider.dragAndDropBy(this.minuteSlider, y, 0).build(); action.perform();
		 */
		this.doneButton.click();
	}
	public void sendPassPercentage(String passPercentage) {
		this.passPercentage.sendKeys(passPercentage);
	}
	public void clickProceedToQuetions() {
		this.proceedToQuetions.click();
	}
	public void clickMultipleChoiceIcon() {
		this.multipleChoiceIcon.click();
	}
	public void sendQuestion(String question) {
		this.questionTextbox.sendKeys(question);
	}
	public void sendOption(int optionNumber, String option) {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, answer["+optionNumber+"]']")));
		this.answerTextbox.sendKeys(option);
		driver.switchTo().defaultContent();
	}
	public void selectCorrectAnswer(int correctAnswer) {
		driver.findElement(By.xpath("//input[@type='radio' and @value='"+correctAnswer+"']")).click();
	}
	public void clickAddThisQuestionButton() {
		this.addThisQuestionButton.click();
	}
	public void clickPreviewIcon() {
		this.previewIcon.click();
	}
	public void clickStartTestButton() {
		this.startTestButton.click();
	}
	public void selectAnswer(int answer) {
		driver.findElement(By.xpath("//div[@class='question_options']/label["+answer+"]/input[@type='radio']")).click();
	}
	public void clickNextQuestionButton() {
		this.nextQuestionButton.click();
	}
	public void clickEndTestButton() {
		this.endTestButton.click();
	}
}
