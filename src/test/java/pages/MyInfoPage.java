package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import drivers.PageDriver;
import junit.framework.Assert;
import utilities.CommonMethods;
import utilities.GetScreenShot;

public class MyInfoPage extends CommonMethods{

	ExtentTest test;
	public MyInfoPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(),this);
		this.test = test;	
	}
	
	

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")
	WebElement firstName;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[6]/a[1]/span[1]")
	WebElement myInfo;
	
	public void myInfoPageTest() throws IOException {
		
		try{
			if(myInfo.isDisplayed()) {
				myInfo.click();
				timeout();
				if(firstName.isDisplayed()) {
					firstName.clear();
					System.out.println("Clear Name ");
				//	WebEelement name   = PageDriver.getCurrentDriver().findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")).clear();
					firstName.sendKeys("Nahidul");
					timeout();
					test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>Form fill Up Success.</b></p>");
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "firstNamePass");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "firstNamePass.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());

				}
			}
		}catch(Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>First name is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "firstNameLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "firstNameLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(myInfo.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
		
	}
	
}
