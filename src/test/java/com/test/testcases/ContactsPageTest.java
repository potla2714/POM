package com.test.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.helper.TestHelper;
import com.test.pages.ContactsPage;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestHelper testHelper;
	ContactsPage contactsPage;
	String sheetName ="contacts";

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testHelper = new TestHelper();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test (priority =1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing");
	}
	
	@Test (priority =2)
	public void selectContactsByName() {		
		contactsPage.selectContactsByName("Demo 123");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestHelper.getTestData(sheetName);
		return data;
	}
	//working
	@Test (priority =3, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstname, String lastname) {
		contactsPage.clickOnNewContactsLink();
		//contactsPage.createNewContact("test1", "t");
		contactsPage.createNewContact(firstname, lastname);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
