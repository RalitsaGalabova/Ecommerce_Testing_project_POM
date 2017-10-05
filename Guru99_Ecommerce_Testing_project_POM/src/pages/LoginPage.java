package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	By createAccont = By.xpath("//*[@id='login-form']/div/div[1]/div[2]/a");
	By email = By.id("email");
	By pass = By.id("pass");
	By loginButton = By.id("send2");
	
	
	//Methods
	
	public void clickCreateAccont(){
		driver.findElement(createAccont).click();
	}
	
	public void logIn(String userMail, String userPass){
		
		driver.findElement(email).sendKeys(userMail);
		driver.findElement(pass).sendKeys(userPass);
		driver.findElement(loginButton).click();
		
	}
	
	

}
