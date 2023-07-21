package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import drivers.PageDriver;
import junit.framework.Assert;
import utilities.CommonMethods;
import utilities.GetScreenShot;

public class LoginPage extends CommonMethods {

	/* 1.Page factory initialize
	 * 2.Locators (only of Current page)
	 * 3.Functionality
	 */
	
	//for report eta sob pager er constructor e add krte hbe
	
	ExtentTest test;
	
	
	//Page factory Initialize
	public LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	
	//Set locators
    @FindBys({
    	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]"),
    	@FindBy(xpath = "//input[@name='username']"),
    	@FindBy(xpath = "//input[@placeholder='Username']")
    })
    WebElement userName;
    
    @FindBys({
    	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1] "),
    	@FindBy(xpath = "//input[@placeholder='Password'] "),
    	@FindBy(xpath  = "//input[@name='password'] ")
    })
    WebElement password;
    
    @FindBys({
    	@FindBy(xpath = "//button[@type = 'submit']"),
    	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")
    })
    WebElement loginButton;
    
    
    //Functionality
    public void login() throws InterruptedException, IOException {
    	timeout();
    	
    try {
    		if(userName.isDisplayed()) {
    			userName.sendKeys("Admin");
    			timeout();
    		}
    		
    	}catch(Exception e) {
    		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Username is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "usernameLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "usernameLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(userName.isDisplayed());
			PageDriver.getCurrentDriver().quit();
    	}
    	
    try {
		if(password.isDisplayed()) {
			password.sendKeys("admin123");
			timeout();
		}
		
	}catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Password is not locateable.Please check the error message.</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "passwordLocator");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "passwordLocator.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue(password.isDisplayed());
		PageDriver.getCurrentDriver().quit();
	}
   	   	
   try {
    		if(loginButton.isDisplayed()) {
    			loginButton.click();
    			timeout(5000);
    			test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully logged in.</b></p>");
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "loginPass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "loginPass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());

    		}
    		
    	}catch(Exception e) {
    		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>LoginButton is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "loginButtonLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "loginButtonLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(loginButton.isDisplayed());
			PageDriver.getCurrentDriver().quit();
    	}
    	
    }
}
