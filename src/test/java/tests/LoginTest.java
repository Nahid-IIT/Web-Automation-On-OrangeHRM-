package tests;

import java.io.IOException;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.LoginPage;
import utilities.ExtentFactory;

public class LoginTest extends BaseDriver {
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
   
	@BeforeClass
	public void openUrl() throws InterruptedException  {
		PageDriver.getCurrentDriver().manage().window().maximize();
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(3000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>ORANGE HRM</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
		
	}
	
	@Test(priority = 0)
	public void loginTest() throws InterruptedException, IOException  {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN TEST</b></p>");
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.login();
		Thread.sleep(3000);
	
	}
	
	@AfterClass
	public void afterClass() {
		report.flush();
	}

}
