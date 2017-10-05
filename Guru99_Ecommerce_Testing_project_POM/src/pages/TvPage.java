package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TvPage extends BasePage {
	
	//Constructor
	public TvPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	By addToWishListlLGTV = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/ul/li[1]/a");
	
	//Methods
	
	public void addLGToWishList(){
		driver.findElement(addToWishListlLGTV).click();
	}
}
