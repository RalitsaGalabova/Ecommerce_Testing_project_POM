package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyOrdersPage extends BasePage {
	
	//Constructor
	public MyOrdersPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	By viewOrderLink = By.xpath("//*[@id='my-orders-table']/tbody/tr/td[6]/span/a[1]");
	By reorderLink = By.xpath("//*[@id='my-orders-table']/tbody/tr/td[6]/span/a[2]");
	
	//Methods
	public void reorderProduct(){
		driver.findElement(reorderLink).click();
	}
}
