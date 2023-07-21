package tests;



import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.LoginPage;
import pages.MyInfoPage;
import utilities.ExtentFactory;

public class MyInfoPageTest extends BaseDriver {
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	

	@BeforeClass
	public void openUrl() throws InterruptedException{
		PageDriver.getCurrentDriver().manage().window().maximize();
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(3000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>My Info Page</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}
	
	@Test
	public void myInfoPageTest() throws InterruptedException, IOException {
	    childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b> My Info Form</b></p>");
		MyInfoPage myInfoPage = new MyInfoPage(childTest);
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.login();
		myInfoPage.myInfoPageTest();
		Thread.sleep(3000);	
	}
	
	@AfterClass
	public void afterClass() {
		report.flush();
	}
}
