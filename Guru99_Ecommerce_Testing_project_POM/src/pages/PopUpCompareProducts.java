package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PopUpCompareProducts extends BasePage {
	
	//Constructor
	public PopUpCompareProducts(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	By popUpTite = By.tagName("h1");
	By firstProduct = By.xpath("//*[@id='product_comparison']/tbody[1]/tr[1]/td[1]/h2/a");
	By secondProduct = By.xpath("//*[@id='product_comparison']/tbody[1]/tr[1]/td[2]/h2/a");
	
	//Assert
	public void verifyPopUpTitle(String popUpTitle){
		String title = driver.findElement(popUpTite).getText();
		Assert.assertEquals(popUpTitle, title);
		
	}
	
	public void verifyComparedProducts(String productOne, String productTwo){
		
		String first = driver.findElement(firstProduct).getText();
		String second = driver.findElement(secondProduct).getText();
		Assert.assertEquals(productOne, first);
		Assert.assertEquals(productTwo, second);
		
		
	}
}
