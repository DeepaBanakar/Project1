package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement passWord;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='normal-message']/p[1]")
	private WebElement welcomeMessage;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String passWord) {
		this.passWord.clear(); 
		this.passWord.sendKeys(passWord); 
	}
	
	public void clickLoginBtn() {
		this.loginButton.click(); 
	}
	
	public String actualResult() {
			String actualResult = this.welcomeMessage.getText();
			return actualResult;
	}
}
