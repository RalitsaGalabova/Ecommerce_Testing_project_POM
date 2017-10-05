package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyWishListPage extends BasePage {

	public MyWishListPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	By shareWishListButton = By.xpath("//*[@id='wishlist-view-form']/div/div/button[1]");
	By emails = By.id("email_address");
	By message = By.id("message");
	By shareWishlist = By.xpath("//*[@id='form-validate']/div[2]/button");
	By shareSuccessfulMessage = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span");
	By addToCartButton = By.xpath("//button[@title='Add to Cart']");
	//Methods
	
	public void clickShareWishlistButton(){
		driver.findElement(shareWishListButton).click();
	}
	
	public void enterEmail(String mails){
		driver.findElement(emails).sendKeys(mails);
		
	}
	
	public void enterMessage(String text){
		driver.findElement(message).sendKeys(text);
		
	}
	
	public void shareWishlist(){
		driver.findElement(shareWishlist).click();
	}
	
	public void addToCart(){
		driver.findElement(addToCartButton).click();
	}
	
	
	//Assert
	
	public void verifyShareIsSuccessful(){
		
		String actualMessage = driver.findElement(shareSuccessfulMessage).getText();
		Assert.assertEquals("Your Wishlist has been shared.", actualMessage);
		
	}
	

}
