package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public WebDriver driver;
 
    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
    }
    
    //Methods
    
    public void switchWindows(){
    	for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	} 	
    }

}
