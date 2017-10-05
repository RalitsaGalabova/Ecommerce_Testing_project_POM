package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckOutPage extends BasePage {
	
	
	    //Constructor 
		public CheckOutPage(WebDriver driver){
			super(driver);
		}
		
		//Locators
		
		//---Form info---
		By billingFirstName = By.id("billing:firstname");
		By billingMiddName = By.id("billing:middlename");
		By billingLastName = By.id("billing:lastname");
		By billingCompany = By.id("billing:company");
		By billingEmail = By.id("billing:email");
		By billingAddress = By.id("billing:street1");
		By billingAddress2 = By.id("billing:street2");
		By billingCity = By.id("billing:city");
		By billingState = By.id("billing:region_id");
		By billingZipCode = By.id("billing:postcode");
		By billingCountry = By.id("billing:country_id");
		By billlingPhone = By.id("billing:telephone");
		By billlingFax = By.id("billing:fax");
		
		
		By flatRate = By.xpath("//*[@id='checkout-shipping-method-load']/dl/dd/ul/li/label/span");
		By continueButton = By.xpath("//*[@id='billing-buttons-container']/button");
		By shippingMethodContinueButton = By.xpath("//*[@id='shipping-method-buttons-container']/button");
		By moneyOrderRadioButton = By.id("p_method_checkmo");
		By placeOrderButton = By.xpath("//*[@id='review-buttons-container']/button");
		By successfulOrderMess = By.tagName("h1");
		By orderNumber = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/p[1]/a");
		By shipToSameAdressButton = By.id("billing:use_for_shipping_yes");
		//By BillinInfoContinueButton = By.xpath("//*[@id='billing-buttons-container']/button");
		
		//Methods
		public void enterBillingInfo(String firstName, String middName, String lastName,
				String company, String address, String address2, String city, String state, String zip, 
				String country, String telephone, String fax){
			
			driver.findElement(billingFirstName).sendKeys(firstName);
			driver.findElement(billingMiddName).sendKeys(middName);
			driver.findElement(billingLastName).sendKeys(lastName);
			driver.findElement(billingCompany).sendKeys(company);
			driver.findElement(billingAddress).sendKeys(address);
			driver.findElement(billingAddress2).sendKeys(address2);
			driver.findElement(billingCity).sendKeys(city);
			Select selectBillState = new Select(driver.findElement(billingState));
			selectBillState.selectByVisibleText(state);
			driver.findElement(billingZipCode).sendKeys(zip);
			Select selectBillCountry = new Select(driver.findElement(billingCountry));
			selectBillCountry.selectByVisibleText(country);
			driver.findElement(billlingPhone).sendKeys(telephone);
			driver.findElement(billlingFax).sendKeys(fax);
			
			driver.findElement(continueButton).click();
			
		}
		
		public void clickContinue(){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinueButton));
			driver.findElement(shippingMethodContinueButton).click();
		}
		
		public void selectMoneyOrderMethod(){
			driver.findElement(moneyOrderRadioButton).click();
			driver.findElement(By.xpath("//*[@id='payment-buttons-container']/button")).click();
		}
		
		public void clickPlaceOrderButton(){
			driver.findElement(placeOrderButton).click();
		}
		
		public void useSameAdres(){
			if(driver.findElement(shipToSameAdressButton).isSelected() == true)
			{
			driver.findElement(continueButton).click();
			}
			else
			{
				driver.findElement(shipToSameAdressButton).click();
				driver.findElement(continueButton).click();
			}
		}
		
		//Asserts
		public void verifyOrder(){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(orderNumber));
			String message = driver.findElement(successfulOrderMess).getText();
			Assert.assertEquals("YOUR ORDER HAS BEEN RECEIVED.", message);
		}
		
		
		

}
