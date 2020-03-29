package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.TestBase;

public class ContactsPage extends TestBase{
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newContactsBtn;
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name ="last_name")
	WebElement lastName;
	
	@FindBy(xpath = "//div[@class='visible menu transition']//div[@role='option']//span")
	WebElement socialChannelsSelection;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;
			
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//td[text()='"+name+"']//parent::td//preceding-sibling::td//div[@class='ui fitted read-only checkbox']")).click();
	}
	
	public void clickOnNewContactsLink() {
		newContactsBtn.click();
	}
	
	public void createNewContact(String fName, String lName) {		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		//Actions act = new Actions(driver);
		//WebElement el11 = driver.findElement(By.xpath("//div[@class='three fields']//div[@name='channel_type']"));
		//act.click(el11);
		//WebElement el2 = driver.findElement(By.xpath("//div[@class='visible menu transition']//div[@role='option']//span[text()='"+sChannel+"']"));
		//WebElement el2 = driver.findElement(By.cssSelector("span.text"));
	   //  Select s = new Select(el2);
		// s.selectByVisibleText(sChannel);
		saveBtn.click();	
		//el2.click();
	}

}
