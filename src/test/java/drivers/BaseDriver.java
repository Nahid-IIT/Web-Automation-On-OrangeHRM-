package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	
	public static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	WebDriver driver = null;
	
   @BeforeClass
	public void start() {
		String browser = System.getProperty("browser", "chrome");
		
		if(browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
            
		//	To use your local Chrome session  
			
		//	ChromeOptions options = new ChromeOptions();
	    //    options.addArguments("user-data-dir=C:\\Users\\YOUR_USERNAME\\AppData\\Local\\Google\\Chrome\\User Data");
	    //    driver = new ChromeDriver(options);

			driver = new ChromeDriver();
		}else if(browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		PageDriver.getInstance().setDriver(driver);
	}
	
	@AfterClass
	public void close() {
		PageDriver.getCurrentDriver().quit();
	}

}
