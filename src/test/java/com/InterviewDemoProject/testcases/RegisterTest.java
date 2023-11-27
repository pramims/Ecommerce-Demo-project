package com.InterviewDemoProject.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.InterviewDemoProject.base.Base;
import com.InterviewDemoProject.pageObject.AccountSuccessPage;
import com.InterviewDemoProject.pageObject.RegisterPage;
import com.InterviewDemoProject.utilities.utilities;

public class RegisterTest extends Base {
	public WebDriver driver;

	/*
	 * public Register() { super(); }
	 */
	
	
	@BeforeMethod()
	public void setup() {
		readProperties();
		driver=intializebrowserAndopenUrl(prop.getProperty("browser"));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	@Test()
	public void registerWithMandatoryField() {
		RegisterPage rp=new RegisterPage(driver);
		rp.enterFirstName(dataProp.getProperty("firstName"));
		rp.enterLastName(dataProp.getProperty("lastName"));
		rp.enterEmailId(utilities.timeStamp());
		rp.entertelephoneNum(dataProp.getProperty("telephoneNum"));
		rp.enterPassword(dataProp.getProperty("password"));
		rp.enterConfirmPwd(dataProp.getProperty("password"));
		rp.selectNewsletterSubscription();
		rp.selectPrivacyPolicyCheckBox();
		AccountSuccessPage asp=rp.clickonContinueBtn();
		String expectedMessage=dataProp.getProperty("assertionValidationMsgRegistration");
		String actualMessage= asp.checkAccountsussMessage();
		Assert.assertEquals(actualMessage, expectedMessage,"wrong page");
			
	}
}
