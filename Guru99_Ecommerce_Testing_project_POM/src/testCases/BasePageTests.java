package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePageTests {
	WebDriver driver;
	
	@Before
    public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "F:\\RalimiR\\Eclipse Projects\\Selenium Files\\Browsers Drivers\\Chrome drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://live.guru99.com/");
        driver.manage().window().maximize();
    }
	
	@After
	public void terDown(){
		driver.quit();
	}

}
