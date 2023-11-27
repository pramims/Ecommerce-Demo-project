package com.InterviewDemoProject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	@FindBy(id="input-firstname")
	private WebElement firstName;
	
	@FindBy(id="input-lastname")
	private WebElement lasttName;
	
	@FindBy(id="input-email")
	private WebElement emailId;
	
	@FindBy(id="input-telephone")
	private WebElement phoneNum;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//label[text()='Yes']")
	private WebElement newsletterSubscribeYes;
	
	@FindBy(xpath="//label[text()='No']")
	private WebElement newsletterSubscribeNo;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continueButton;
	
	
	public RegisterPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}
	
	public void enterLastName(String enterlastname) {
		lasttName.sendKeys(enterlastname);
	}
	
	public void enterEmailId(String enterId) {
		emailId.sendKeys(enterId);
	}
	
	public void entertelephoneNum(String enterNumber) {
		phoneNum.sendKeys(enterNumber);
		
	}
	
	public void enterPassword(String enterpwd) {
		password.sendKeys(enterpwd);
	}
	
	public void enterConfirmPwd(String confirmpwd) {
		confirmPassword.sendKeys(confirmpwd);
	}
	
	public void selectNewsletterSubscription() {
		newsletterSubscribeYes.click();
	}
	
	public void unAcceptNewsletterSubscription() {
		newsletterSubscribeNo.click();
	}
	
	
	public void selectPrivacyPolicyCheckBox() {
		privacyPolicy.click();
	}
	
	public AccountSuccessPage clickonContinueBtn() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
}
