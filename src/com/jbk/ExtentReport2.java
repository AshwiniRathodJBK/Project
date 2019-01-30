package com.jbk;

import java.io.IOException;

import org.jsoup.select.Evaluator.ContainsOwnText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport2 {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	 ExtentReports extent;
	 ExtentTest Logger;
	
	
	@BeforeMethod
	public void setup()
	{
		// initialize the HtmlReporter
				 // ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Reports/Taskk.html");
				  htmlReporter = new ExtentHtmlReporter("extent.html");
				  htmlReporter.setAppendExisting(true);
				  htmlReporter.config().setChartVisibilityOnOpen(true);
				  htmlReporter.config().setDocumentTitle("Ashwini - ExtentReports");
				  htmlReporter.config().setTheme(Theme.DARK);
					
				  
				// initialize ExtentXReporter (deprecated)
				 // ExtentXReporter extentxReporter = new ExtentXReporter();

				// initialize E xtentReports and attach the HtmlReporter
				  extent = new ExtentReports();
			  

				// attach only HtmlReporter
				  extent.attachReporter(htmlReporter);
				  

				//
				  
				 Logger= extent.createTest("LOginTEST");
				 Logger.log(Status.INFO, "Testcase Started");

		
	}
	
	
	@AfterMethod

   public void tearDown(ITestResult result) throws IOException
   {
		if(result.getStatus() == ITestResult.FAILURE){
		String temp=Utility.getScreenshot(driver);	
		Logger.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			
		}
		extent.flush();
		
 
   }
	 @Test
	  public void LoginTest() throws Exception{
		 System.setProperty("webdriver.chrome.driver", "C:/Resource/chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://www.google.com/");
		  System.out.println("title is :"+driver.getTitle());
          Assert.assertTrue(driver.getTitle().contains("mukesh"));
		 
	 }


}
