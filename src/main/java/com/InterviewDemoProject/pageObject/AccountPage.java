package com.InterviewDemoProject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	 WebDriver driver;
	    
	    @FindBy(partialLinkText="Edit your account")
		private WebElement editYourAccountoption;
	
	    
	    public AccountPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	
	
	  public Boolean checkAccountPage() {
		 Boolean sts= editYourAccountoption.isDisplayed();
		 return sts;
	  }
	
}
