package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditProfilePOM {
	
private WebDriver driver; 
	
	public EditProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Edit profile")
	private WebElement editProfileLink; 
	
	@FindBy(id="profile_password0")
	private WebElement currentPassWord;
	
	@FindBy(id="password1")
	private WebElement newPassword;
	
	@FindBy(id="profile_password2")
	private WebElement confirmPassword;
	
	@FindBy(id="profile_apply_change")
	private WebElement saveSettingsButton;
	
	@FindBy(xpath="//section[@id='cm-content']/div/div[@class='row']/div[1]/div[1]")
	private WebElement saveSuccessMessage;
	
	
	public void clickEditProfileLink() {
		this.editProfileLink.click();
	}
	
	public void sendCurrentpassword(String currentPassword) {
		this.currentPassWord.clear();
		this.currentPassWord.sendKeys(currentPassword);
	}
	
	public void sendNewPassword(String newPassWord) {
		this.newPassword.clear(); 
		this.newPassword.sendKeys(newPassWord); 
	}
	
	public void sendConfirmPassword(String confirmPassWord) {
		this.confirmPassword.clear(); 
		this.confirmPassword.sendKeys(confirmPassWord); 
	}
	
	public void clickSaveSettingsButton() {
		this.saveSettingsButton.click(); 
	}
	
	public void validateSaveSuccessMesssage() {
		String expectedReslt = "Your new profile has been saved";
		String actualResult = this.saveSuccessMessage.getText();
		if(expectedReslt.equals(actualResult)) {
			Assert.assertEquals(actualResult, expectedReslt);
		} else {
			System.out.println(actualResult);
		}
	}

}
