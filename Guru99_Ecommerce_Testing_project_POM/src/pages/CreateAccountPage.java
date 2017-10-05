package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage {
	
	//Constructor
	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	By firstName = By.id("firstname");
	By midName = By.id("middlename");
	By lastName = By.id("lastname");
	By email = By.id("email_address");
	By pass = By.id("password");
	By confirmPass = By.id("confirmation");
	By newsLetterOption = By.id("is_subscribed");
	By registerButton = By.xpath("//*[@id='form-validate']/div[2]/button");
	By wellcomMessage = By.xpath("//*[@id='top']/body/div/div/div[1]/div/p");
	
	//Methods
	
	public void fillForm(String userFirstName, String userMiddleName, String userLastName,
						String emailAddres, String password, String confirmPassword, boolean newsLetterSignUp){
		
		driver.findElement(firstName).sendKeys(userFirstName);
		driver.findElement(midName).sendKeys(userMiddleName);
		driver.findElement(lastName).sendKeys(userLastName);
		driver.findElement(email).sendKeys(emailAddres);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(confirmPass).sendKeys(confirmPassword);
		if(newsLetterSignUp == true){
			driver.findElement(newsLetterOption).click();
		}
		driver.findElement(registerButton).click();
		
		
	}
	
	//Asserts
	
	public void verifyRegistrationIsSuccessful(String headerMessage){
		String actualMessage = driver.findElement(wellcomMessage).getText();
		System.out.println(actualMessage);
		Assert.assertEquals(headerMessage, actualMessage);
	}

}
