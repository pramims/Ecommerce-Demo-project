package com.InterviewDemoProject.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.InterviewDemoProject.base.Base;
import com.InterviewDemoProject.pageObject.AccountPage;
import com.InterviewDemoProject.pageObject.HomePage;
import com.InterviewDemoProject.pageObject.LoginPage;
import com.InterviewDemoProject.utilities.utilities;

public class LoginTest extends Base {
	public WebDriver driver;
	LoginPage lp;

	// public Login() {
	// super();
	// }

	@BeforeMethod()
	public void setup() {
		readProperties();
		driver = intializebrowserAndopenUrl(prop.getProperty("browser"));
		HomePage hp = new HomePage(driver);
        lp=hp.navigateToLoginPage();
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = -1, dataProvider = "datas")
	public void verifyLoginWithValidId(String uName, String pwd) {
		AccountPage accountPage=lp.login(uName, pwd);
		Assert.assertTrue(accountPage.checkAccountPage(), "Test case failed");
	}

	@DataProvider(name = "datas")
	public Object[][] data() {
		Object[][] data1 = utilities.getdataFromExcel("Login");
		return data1;
	}

	@Test(priority = 0)
	public void LoginWithInvalidCred() {
		lp.login(utilities.timeStamp(),dataProp.getProperty("invalidPassword"));
		String actual = lp.warningMessageForInvalidCred();
		String expected = dataProp.getProperty("errorMessageForInvalidCred");
		Assert.assertTrue(actual.equals(expected));

	}

	@Test(priority = 1)
	public void ValidUserNameWithInvalidPassword() {
		lp.login(prop.getProperty("validUserName"),dataProp.getProperty("invalidPassword"));
		String actual = lp.warningMessageForInvalidCred();
		String expected = dataProp.getProperty("errorMessageForInvalidCred");
		Assert.assertTrue(actual.equals(expected));

	}

	@Test(priority = 2)
	public void InvalidUsernameWithValidPwd() {
		lp.login(utilities.timeStamp(),prop.getProperty("ValidPassword"));
		String actual = lp.warningMessageForInvalidCred();
		String expected = dataProp.getProperty("errorMessageForInvalidCred");
		Assert.assertTrue(actual.equals(expected));


	}

}
