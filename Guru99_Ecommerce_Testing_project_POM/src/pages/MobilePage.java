package pages;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Ordering;

public class MobilePage extends BasePage {

	//Locators
	By pageTitle = By.tagName("h1");
	By sortByDropDown = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select");
	By productName = By.className("product-name");
	By sonyXperiaValue = By.xpath("//*[@id='product-price-1']/span");
	By productSonyXperia = By.id("product-collection-image-1");
	By addToCartSonyExperia = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button");
	By addToCompareSonyX = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a");
	By addToCompareIphone = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a");
	By compareButton = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button");
	
	//Constructor 
	public MobilePage(WebDriver driver){
		super(driver);
	}
	
	
	//Methods
	
	public void selectDropDownBy(String selector){
		Select dropDown = new Select(driver.findElement(sortByDropDown));
		dropDown.selectByVisibleText(selector);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void selectXperia(){
		driver.findElement(productSonyXperia).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public String getXperiaValue(){
		String result = driver.findElement(sonyXperiaValue).getText();
		return result;
	}
	
	public void addToCartSonyExperia(){
		driver.findElement(addToCartSonyExperia).click();
	}
	
	public void addToCompareSonyX(){
		driver.findElement(addToCompareSonyX).click();
	}
	
	public void addToCompareIphone(){
		driver.findElement(addToCompareIphone).click();
	}
	
	public void compareProducts(){
		driver.findElement(compareButton).click();
	}
	
	
	//Assert
	
	public void verifyTitle(String title){
		String titleText = driver.findElement(pageTitle).getText();
		Assert.assertEquals(title, titleText);
	}
	
	public void assertIsSortedByName(){
		
		List <WebElement> productList = driver.findElements(productName);
		List <String> nameList = new ArrayList<String>();
		
		for (WebElement e : productList){
			nameList.add(e.getText());
		}
		
		boolean isSorted = Ordering.natural().isOrdered(nameList);
		Assert.assertEquals(true, isSorted);
		
	}
	
}
