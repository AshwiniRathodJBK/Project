package com.jbk;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	 ExtentHtmlReporter htmlReporter;
	 ExtentReports extent;
	 ExtentTest Logger;
	

	
	 @Test
	  public void VerifyHomelink() throws Exception{
		  
		  
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
		  
		 Logger= extent.createTest("Check_Home");
		 Logger.log(Status.INFO, "HomeTEst");
		 extent.flush();
		 
	 }

}
