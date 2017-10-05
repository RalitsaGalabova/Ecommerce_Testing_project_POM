package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
	
	//Locators
	By pageTitle = 	By.tagName("h2");
	By mobileButton = By.xpath("//*[@id='nav']/ol/li[1]/a");
	By tvButton = By.xpath("//*[@id='nav']/ol/li[2]/a");
	By myAccountButton = By.linkText("MY ACCOUNT");
		
	//Constructor 
	public HomePage(WebDriver driver){
		super(driver);
	}

	//Methods
	public void verifyTitle(String title){
		String titleText = driver.findElement(pageTitle).getText();
		Assert.assertEquals(title, titleText);
	}
	
	public void clickOnMobile(){
		driver.findElement(mobileButton).click();
		
	}
	
	public void goToMyAccount(){
		driver.findElement(myAccountButton).click();
	}
	
	public void clickOnTV(){
		driver.findElement(tvButton).click();
		
	}

}
