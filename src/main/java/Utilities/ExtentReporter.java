package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	 public static ExtentReports getExtentReport() {
	   	 
	   	 String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
	   	 ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
	   	 reporter.config().setReportName("Framework Automation Results");
	   	 reporter.config().setDocumentTitle("Framework Automation Test Results");
	   	 
	   	 ExtentReports extentReport = new ExtentReports();
	   	 extentReport.attachReporter(reporter);
	   	 extentReport.setSystemInfo("Operating System","Windows 11");
	   	 extentReport.setSystemInfo("Executed By","Preethy");
	   
	   	 return extentReport;
	    }

}
