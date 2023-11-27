package com.InterviewDemoProject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	WebDriver driver;
    
    @FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountSuccessMsg;

    
    public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}


  public String checkAccountsussMessage() {
	 String msg1=accountSuccessMsg.getText();
	 return msg1;
  }
	
	
	
}
