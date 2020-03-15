package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}


	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTittle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void crmLogoImgTest() {
		boolean flag = loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
