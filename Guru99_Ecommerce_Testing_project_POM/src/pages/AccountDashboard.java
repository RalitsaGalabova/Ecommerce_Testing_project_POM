package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDashboard extends BasePage {
	
	//Constructor
	public AccountDashboard(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	By myWishList = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a");
	By myOrderMenu = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a");
	
	//Methods
	public void goToWishList(){
		driver.findElement(myWishList).click();
	}
	
	public void goToMyOrders(){
		driver.findElement(myOrderMenu).click();
	}

}
