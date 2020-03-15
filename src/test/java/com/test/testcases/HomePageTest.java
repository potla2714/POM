package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.helper.TestHelper;
import com.test.pages.ContactsPage;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestHelper testHelper;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated orr -- independent each other
	//before each test case  -- launch the browser
	//@test -- execute test case
	//after each test case -- close the browser
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testHelper = new TestHelper();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test (priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched");
	}

	@Test (priority=2)
	public void verifyuserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test (priority=3)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
