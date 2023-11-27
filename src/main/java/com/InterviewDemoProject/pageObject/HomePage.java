package com.InterviewDemoProject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	 WebDriver driver;
	    
	    @FindBy(xpath="//span[text()='My Account']")
		private WebElement myAccountdropDown;
	
	    @FindBy(linkText="Login")
	  		private WebElement loginOption;
	    
	    public HomePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	
	    public void clickMyAccountdropDown() {
		myAccountdropDown.click();
	    }
	
	   public LoginPage clickOnloginOpt() {
		   loginOption.click();
		   return new LoginPage(driver);
		
	}
	   
	   public LoginPage navigateToLoginPage() {
		   myAccountdropDown.click();
		   loginOption.click();
		   return new LoginPage(driver);
	   }
}



