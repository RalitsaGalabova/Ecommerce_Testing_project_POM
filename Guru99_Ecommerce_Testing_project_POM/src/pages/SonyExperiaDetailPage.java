package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SonyExperiaDetailPage extends BasePage {
	
	//Constructor
	public SonyExperiaDetailPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	By sonyXperiaPrice = By.xpath("//*[@id='product-price-1']/span");
	By addToCartButton = By.xpath("//*[@id='product_addtocart_form']/div[4]/div/div/div[2]/button");
	
	
	//Methods
	
	public String getXperiaDetailPagePrice(){
		
		String result = driver.findElement(sonyXperiaPrice).getText();
		return result;
	}
	
	public void addToCart(){
		driver.findElement(addToCartButton).click();
	}

}
