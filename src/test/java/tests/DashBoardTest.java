package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.DashBoardPage;
import pages.LoginPage;
import utilities.ExtentFactory;

public class DashBoardTest extends BaseDriver {

	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void openUrl() throws InterruptedException {
		PageDriver.getCurrentDriver().manage().window().maximize();
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(3000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>DashBoard</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}
	
	@Test(priority=1)
	public void dashBoardTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Dashboar Options </b></p>");
		DashBoardPage dashBoardPage = new DashBoardPage(childTest);
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.login();
		dashBoardPage.checkDashboard();
		dashBoardPage.dashBoardTest();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void afterClass() {
		report.flush();
	}
}
