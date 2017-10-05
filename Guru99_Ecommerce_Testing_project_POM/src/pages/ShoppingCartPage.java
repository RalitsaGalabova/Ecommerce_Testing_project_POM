package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;



public class ShoppingCartPage extends BasePage{
	
	//Constructor
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	By productQuantity = By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input");
	By updateButton = By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/button");
	By errorMessage = By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[2]/p");
	By productPrice = By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[3]/span/span");
	By proceedToCheckOutButtonTop = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/div/div[1]/ul/li/button");
	By shippingCountry = By.id("country");
	By shippingState = By.id("region_id");
	By shippingZip = By.id("postcode");
	By estimate = By.xpath("//*[@id='shipping-zip-form']/div/button");
	By flatRateLabel = By.xpath("//*[@id='co-shipping-method-form']/dl/dd/ul/li/label/span");
	By flatRateRadioButton = By.id("s_method_flatrate_flatrate");
	By updateTotalButton = By.xpath("//*[@id='co-shipping-method-form']/div/button");
	By grandTotalPrice = By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span");
	By proceedToCheckOutButtonBottom = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button");
	
	//Methods
	
	public void changeProductQuantity(String quantity){
		driver.findElement(productQuantity).clear();
		driver.findElement(productQuantity).sendKeys(quantity);
	}
	
	public void updateCart(){
		driver.findElement(updateButton).click();
	}
	
	public void estimateShoping(String country, String state, String zip){
		
		Select selectCountry = new Select(driver.findElement(shippingCountry));
		selectCountry.selectByVisibleText(country);
		Select selectState = new Select(driver.findElement(shippingState));
		selectState.selectByVisibleText(state);
		driver.findElement(shippingZip).sendKeys(zip);
		driver.findElement(estimate).click();
		
	}
	
	public void selectFlatRate(){
		driver.findElement(flatRateRadioButton).click();
	}
	
	public void updatePrice(){
		driver.findElement(updateTotalButton).click();
	}
	
	public void proceedToCheckOut(){
		driver.findElement(proceedToCheckOutButtonBottom).click();
	}
	
	//Asserts
	public void verifyErrorMessage(String message){
		driver.findElement(errorMessage).getText();
		String errMessage = driver.findElement(errorMessage).getText();
		Assert.assertEquals(message, errMessage);
	}
	
	public void verifyFlatRateisGenerated(String value){
		
		String rate = driver.findElement(flatRateLabel).getText();
		Assert.assertEquals(value, rate);
	}
	
	public void verifyTotalPrice(){
		
		String quantity = driver.findElement(productQuantity).getAttribute("value");
		int productQuantity = Integer.parseInt(quantity);
		
		String rate = driver.findElement(flatRateLabel).getText();
		String flatRateText = rate.replaceAll("[^0-9]", "");
		int flatRateValue = Integer.parseInt(flatRateText);
		
		String total = driver.findElement(productPrice).getText();
		String productPriceText = total.replaceAll("[^0-9]", "");
		int productPrice = Integer.parseInt(productPriceText);
		
		int productTotalPrice = (productPrice * productQuantity);
		
		String grandTotal = driver.findElement(grandTotalPrice).getText();
		String grandTotalText = grandTotal.replaceAll("[^0-9]", "");
		int totalPrice = Integer.parseInt(grandTotalText);
		
		int expectedTotal = flatRateValue + productTotalPrice;
		Assert.assertEquals(expectedTotal, totalPrice );
		
	}
	
	public void verifyGrandTotalIsUpdated(){
		
		String total = driver.findElement(productPrice).getText();
		String productPriceText = total.replaceAll("[^0-9]", "");
		int productPrice = Integer.parseInt(productPriceText);
		
		String grandTotal = driver.findElement(grandTotalPrice).getText();
		String grandTotalText = grandTotal.replaceAll("[^0-9]", "");
		int totalPrice = Integer.parseInt(grandTotalText);
		
		Assert.assertTrue(totalPrice > productPrice);
	}
}
