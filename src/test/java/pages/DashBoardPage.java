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

public class DashBoardPage extends CommonMethods {
	
	ExtentTest test;
	public DashBoardPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(),this);
		this.test = test;
	}
	
	@FindBys({
		@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]/span[1]")
	})
	WebElement adminOption;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]/span[1]")WebElement pimOption;
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]/span[1]")WebElement leaveOption;
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[4]/a[1]/span[1]")WebElement timeOption;
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[5]/a[1]/span[1]")WebElement requirementOption;
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[6]/a[1]/span[1]")WebElement myInfoOption;
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[7]/a[1]/span[1]")WebElement performanceOption;
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[9]/a[1]/span[1]")WebElement directoryOption;
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[10]/a[1]")WebElement maintennanceOption;
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[11]/a[1]/span[1]")WebElement claimOption;
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[12]/a[1]/span[1]")WebElement buzzOption;
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/input[1]")WebElement maintennancePassword;
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/form[1]/div[4]/button[2]")WebElement maintennanceConfirmButton;
	

	@FindBys({
		@FindBy(xpath = "//header/div[1]/div[1]/span[1]/h6[1]")
	})
	WebElement dashboardText;
	
	
	public void checkDashboard() throws IOException {
//		String expectedText = "Dashboard";
//		String actualText = dashboardText.getText();
//		Assert.assertEquals(actualText, expectedText);
		try {
			if(dashboardText.isDisplayed()) {
				Assert.assertEquals(dashboardText.getText(), "Dashboard");
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>Dashboard is displayed successfully.</b></p>");
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "dashBoardPass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "dashBoardPass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());

			}
		} catch (Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b> Dashboard  is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "dashBoardLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "dashBoardLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(dashboardText.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
		
	}
	
	public void dashBoardTest() throws IOException {
		
		//Admin Option Test
		try {
			if(adminOption.isDisplayed()) {
				adminOption.click();
				timeout();
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>Admin Option is displayed successfully.</b></p>");
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "adminOptionPass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "adminOptionPass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
		
	}catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b> Admin Option  is not locateable.Please check the error message.</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "adminLocator");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "adminLocator.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue(adminOption.isDisplayed());
		PageDriver.getCurrentDriver().quit();
	}
		
	//PIM Option Test
	try {
			if(pimOption.isDisplayed()) {
				pimOption.click();
				timeout();
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>PIM Option is displayed successfully.</b></p>");
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "pimOptionPass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "pimOptionPass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
			
		}catch(Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b> PIM Option  is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "pimOptionLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "pimOptionLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(pimOption.isDisplayed());
			PageDriver.getCurrentDriver().quit();
			
		}
	
	//Leave Option Test
		try {
				if(leaveOption.isDisplayed()) {
					leaveOption.click();
					timeout();
					test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>Leave Option  is displayed successfully.</b></p>");
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "leaveOptionPass");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "leaveOptionPass.png";
					test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				}
				
			}catch(Exception e) {
				test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Leave Option  is not locateable.Please check the error message.</b></p>");
				Throwable t = new InterruptedException("Exception");
				test.fail(t);
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "leaveOptionLocator");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "leaveOptionLocator.png";
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
				Assert.assertTrue(leaveOption.isDisplayed());
				PageDriver.getCurrentDriver().quit();
				
			}
   // Time Option 
		try {
			if(timeOption.isDisplayed()) {
				timeOption.click();
				timeout();
				test.pass("<p style=\"color:#85BC63; font-size:13px\"><b> Time  Option is displayed successfully.</b></p>");
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "timeOptionPass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "timeOptionPass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
			
		}catch(Exception e) {
			test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Time Option  is not locateable.Please check the error message.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "timeOptionLocator");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "timeOptionLocator.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(timeOption.isDisplayed());
			PageDriver.getCurrentDriver().quit();
			
		}
		
		   // Requirement Option 
				try {
					if(requirementOption.isDisplayed()) {
						requirementOption.click();
						timeout();
						test.pass("<p style=\"color:#85BC63; font-size:13px\"><b> Requirement  Option is displayed successfully.</b></p>");
						String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "requirementOptionPass");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "requirementOptionPass.png";
						test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					}
					
				}catch(Exception e) {
					test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Requirement  Option  is not locateable.Please check the error message.</b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "requirementOptionLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "requirementOptionLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(requirementOption.isDisplayed());
					PageDriver.getCurrentDriver().quit();
					
				}
		//myInfoOption
				try {
					if(myInfoOption.isDisplayed()) {
						myInfoOption.click();
						timeout();
						test.pass("<p style=\"color:#85BC63; font-size:13px\"><b> MyInfo Option  is displayed successfully.</b></p>");
						String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "myInfoOptionPass");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "myInfoOptionPass.png";
						test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					}
					
				}catch(Exception e) {
					test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>My Info Option is not locateable.Please check the error message.</b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "myInfoOptionOptionLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "myInfoOptionOptionLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(myInfoOption.isDisplayed());
					PageDriver.getCurrentDriver().quit();
					
				}
		//performanceOption		
				try {
					if(performanceOption.isDisplayed()) {
						performanceOption.click();
						timeout();
						test.pass("<p style=\"color:#85BC63; font-size:13px\"><b> Performance Option is displayed successfully.</b></p>");
						String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "performanceOptionPass");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "performanceOptionPass.png";
						test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					}
					
				}catch(Exception e) {
					test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Performance Option  is not locateable.Please check the error message.</b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "performanceOptionLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "performanceOptionLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(performanceOption.isDisplayed());
					PageDriver.getCurrentDriver().quit();
                                                               }
    
	 //directoryOption
	
				try {
					if(directoryOption.isDisplayed()) {
						directoryOption.click();
						timeout();
						test.pass("<p style=\"color:#85BC63; font-size:13px\"><b> Directory Option is displayed successfully.</b></p>");
						String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "directoryOptionPass");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "directoryOptionPass.png";
						test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					}
					
				}catch(Exception e) {
					test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Directory Option  is not locateable.Please check the error message.</b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "directoryOptionLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "directoryOptionLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(directoryOption.isDisplayed());
					PageDriver.getCurrentDriver().quit();
                }
				
		//maintennanceOption
				
				try {
					if(maintennanceOption.isDisplayed()) {
						maintennanceOption.click();
						timeout();
						test.pass("<p style=\"color:#85BC63; font-size:13px\"><b> Maintennance Option is displayed successfully.</b></p>");
						String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "maintennanceOptionPass");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "maintennanceOptionPass.png";
						test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					}
					
				}catch(Exception e) {
					test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Maintennance Option  is not locateable.Please check the error message.</b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "MaintennanceOptionLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "maintennanceOptionLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(maintennanceOption.isDisplayed());
					PageDriver.getCurrentDriver().quit();
                }
				
		//maintennancePassword
				
				try {
					if(maintennancePassword.isDisplayed()) {
						maintennancePassword.sendKeys("admin123");
						timeout();
						test.pass("<p style=\"color:#85BC63; font-size:13px\"><b> Maintennance Password Option is displayed successfully.</b></p>");
						String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "maintennancePasswordOptionPass");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "maintennancePaswordOptionPass.png";
						test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					}
					
				}catch(Exception e) {
					test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Maintennance password  Option  is not locateable.Please check the error message.</b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "maintennancePasswordOptionLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "maintennancePasswordOptionLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(maintennanceOption.isDisplayed());
					PageDriver.getCurrentDriver().quit();
                }
				
		//maintennanceConfirmButton
				
				try {
					if(maintennanceConfirmButton.isDisplayed()) {
						maintennanceConfirmButton.click();
						timeout();
						test.pass("<p style=\"color:#85BC63; font-size:13px\"><b> Maintennance login is  successfully.</b></p>");
						String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "maintennanceConfirmButtonPass");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "maintennanceConfirmButtonPass.png";
						test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					}
					
				}catch(Exception e) {
					test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Maintennance Confirm Button  Option  is not locateable.Please check the error message.</b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "maintennanceConfirmButtonLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "maintennanceConfirmButtonOptionLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(maintennanceConfirmButton.isDisplayed());
					PageDriver.getCurrentDriver().quit();
                }
				 
		//claimOption
				try {
					if(claimOption.isDisplayed()) {
						claimOption.click();
						timeout();
						test.pass("<p style=\"color:#85BC63; font-size:13px\"><b> Claim Option is displayed successfully.</b></p>");
						String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "claimOptionPass");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "claimOptionPass.png";
						test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					}
					
				}catch(Exception e) {
					test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Claim Option  is not locateable.Please check the error message.</b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "claimOptionLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "claimOptionLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(claimOption.isDisplayed());
					PageDriver.getCurrentDriver().quit();
                }
				
		//buzzOption
				
				try {
					if(buzzOption.isDisplayed()) {
						buzzOption.click();
						timeout();
						test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>Buzz Option is displayed successfully.</b></p>");
						String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "buzzOptionPass");
						String dest = System.getProperty("user.dir") + "\\screenshots\\" + "claimOptionPass.png";
						test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					}
					
				}catch(Exception e) {
					test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Buzz Option  is not locateable.Please check the error message.</b></p>");
					Throwable t = new InterruptedException("Exception");
					test.fail(t);
					@SuppressWarnings("unused")
					String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "buzzOptionLocator");
					String dest = System.getProperty("user.dir") + "\\screenshots\\" + "buzzOptionLocator.png";
					test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
					Assert.assertTrue(buzzOption.isDisplayed());
					PageDriver.getCurrentDriver().quit();
                }
				
    
	}	
}
