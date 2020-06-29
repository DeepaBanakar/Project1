package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPOM {
	
private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),' Sign up! ')]")
	private WebElement signUp;
	
	@FindBy(id="registration_firstname")
	private WebElement firstName; 
	
	@FindBy(id="registration_lastname")
	private WebElement lastName;
	
	@FindBy(id="registration_email")
	private WebElement email; 
	
	@FindBy(id="username")
	private WebElement userName; 
	
	@FindBy(id="pass1")
	private WebElement passWord;
	
	@FindBy(id="pass2")
	private WebElement confirmPassword; 
	
	@FindBy(id="registration_phone")
	private WebElement phoneNumber; 
	
	@FindBy(xpath="//div[@class='filter-option-inner-inner']")
	private WebElement language;
	
	@FindBy(xpath="//input[@role='textbox']")
	private WebElement languageText;
	
	@FindBy(xpath="//p[contains(text(),'Follow courses')]")
	private WebElement studentRadioButton; 

	@FindBy(id="registration_submit")
	private WebElement resgitser; 
	
	@FindBy(xpath="//section[@id='cm-content']//div[@class='row']")
	private WebElement resgitserMessage;
	
	@FindBy(xpath="//div[@class='alert alert-warning']")
	private WebElement failureMessage;
	

	public void clickSignUp() {
		this.signUp.click();
	}
	public void sendFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
	public void sendLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	public void sendPassWord(String passWord) {
		this.passWord.clear();
		this.passWord.sendKeys(passWord);
	}
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);
	}
	public void sendPhoneNumber(String phoneNumber) {
		this.phoneNumber.clear(); 
		this.phoneNumber.sendKeys(phoneNumber); 
	}
	public void selectLanguage(String language) {
		this.language.click();
		this.languageText.sendKeys(language);
		this.languageText.sendKeys(Keys.ENTER);		
	}
	public void selectStudentProfile() {
		this.studentRadioButton.click(); 
	}
	public void clickRegisterButton() {
		this.resgitser.click(); 
	}
	public void validateRegisterMessage(String firstName, String lastName) {	
		if(driver.getPageSource().contains("Your personal settings have been registered.")) {
			String expectedMassage = "Dear "+firstName+" "+lastName+",\n\n"
					+ "Your personal settings have been registered.\n"
					+ "An e-mail has been sent to remind you of your login and password.\n"
					+ "You can now select, in the list, the course you want access to.";
			String actualMassage = this.resgitserMessage.getText();	
			Assert.assertEquals(actualMassage, expectedMassage);
		} else {
			System.out.println(this.failureMessage.getText()+"s are missing, Registration failed.");
		}
	}

}
