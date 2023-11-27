package com.InterviewDemoProject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    
    @FindBy(css="input#input-email")
	private WebElement email;
	
	@FindBy(css="input#input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMsg;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterEmailId(String uName) {
	email.sendKeys(uName);
	}
	
	public void enterPassword(String pwd) {
		 password.sendKeys(pwd);
	 }
	 
	public AccountPage clickLoginBtn() {
		loginBtn.click();
		return new AccountPage(driver);
	}
	
	
	public AccountPage login(String uName,String pwd) {
		email.sendKeys(uName);
		 password.sendKeys(pwd);
	     loginBtn.click();
			return new AccountPage(driver);
	}
	
	public String warningMessageForInvalidCred() {
		String msg=warningMsg.getText();
		return msg;
	}
	 
}



