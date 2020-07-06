package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAssementsPOM {
	
private WebDriver driver; 
	
	public AddAssementsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Assessments']")
	private WebElement assessmentsIcon;
	
	@FindBy(xpath = "//img[@title='Add online activity']")
	private WebElement addOnlineActivityIcon;
	
	@FindBy(id = "create_link_select_link")
	private WebElement typeOfActivityDropdown;
	
	@FindBy (id = "add_link_select_link")
	private WebElement activityDropdown;
	
	@FindBy(id= "add_link_submit")
	private WebElement addLearningActivityButton;
	
	@FindBy (xpath = "//table[@id='gradebook_list']//img[@title='Edit']")
	private WebElement editIcon;
	
	@FindBy(id = "weight_mask")
	private WebElement weightTextbox;
	
	@FindBy(name = "visible")
	private WebElement visibleCheckbox;
	
	@FindBy (id = "edit_link_form_submit")
	private WebElement editLinkButton;
	
	@FindBy(xpath = "//img[@title='Attach certificate']")
	private WebElement addCertificateIcon;
	
	public void clickAssessmentsIcon() {
		this.assessmentsIcon.click();
	}
	public void clickAddOnlineActivityIcon() {
		this.addOnlineActivityIcon.click();
	}
	public void selectTypeOfActivity(String typeOfActivity) {
		Select select = new Select(this.typeOfActivityDropdown);
		select.selectByVisibleText(typeOfActivity);
	}
	public void selectActivity() {
		Select select = new Select(this.activityDropdown);
		select.selectByIndex(2);
	}
	public void clickAddLearningActivityButton() {
		this.addLearningActivityButton.click();
	}
	public void clickEditIcon() {
		this.editIcon.click();
	}
	public void sendWeight(String weight) {
		this.weightTextbox.clear();
		this.weightTextbox.sendKeys(weight);
	}
	public boolean verifyVisibleTextbox() {
		return this.visibleCheckbox.isSelected();
	}
	public void clickEditLinkButton() {
		this.editLinkButton.click();
	}
	public void clickAddCertificateIcon() {
		this.addCertificateIcon.click();
	}

}
