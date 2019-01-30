package com.jbk;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentScreenShot {
	 
	
	 @Test
	public void LoginTest() throws IOException
	{
		System.out.println("Login to amezon");
		ExtentHtmlReporter  htmlReporter = new ExtentHtmlReporter("Learn_Automation.html");
		  htmlReporter.setAppendExisting(true);
		  htmlReporter.config().setChartVisibilityOnOpen(true);
		  htmlReporter.config().setDocumentTitle("Ashwini Rathod- ExtentReports");
		  htmlReporter.config().setTheme(Theme.DARK);
		  
		  ExtentReports extent = new ExtentReports();
		  

			// attach only HtmlReporter
		 extent.attachReporter(htmlReporter);
			  
			  

			 
			  
		 ExtentTest Logger1 = extent.createTest("Login Test");
		 Logger1.log(Status.INFO, "Login to amezon");
		 
		 Logger1.log(Status.PASS, "title verified");

		 extent.flush();
		 
		 ExtentTest Logger2 = extent.createTest("LogOff Test");

		 Logger2.log(Status.FAIL, "Title verified");
		 Logger2.addScreenCaptureFromPath("screenshot55.png");
		 
			
		extent.flush();
	}

}
