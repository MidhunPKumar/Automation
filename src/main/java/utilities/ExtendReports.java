package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReports {
	public ExtentReports reportInit() {
		ExtentSparkReporter er = new ExtentSparkReporter(
				new File(System.getProperty("user.dir") + "\\reports\\index.html"));
		er.config().setReportName("Web Automation Results");
		er.config().setDocumentTitle("Test Results");

		ExtentReports ex = new ExtentReports();
		ex.attachReporter(er);
		return ex;
	}
}
