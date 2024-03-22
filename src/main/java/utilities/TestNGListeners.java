package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

public class TestNGListeners extends ExtendReports implements ITestListener {
	
	ExtentReports ex;
	ExtentTest eT;
	ChromeDriver dr;
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("--------------------Test Start--------------------");
		eT = ex.createTest(result.getName());
		ex.setSystemInfo("Tester", "Midhun");
	  }

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("--------------------Test Success--------------------");
		eT.log(Status.PASS, "Test Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		try {
			dr = (ChromeDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
					//getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String filePath = System.getProperty("user.dir")+"//screenshots/file.png";
		System.out.println("--------------------Test Failure--------------------");
		File scr = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scr, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eT.log(Status.FAIL, "Test Failed");
		eT.addScreenCaptureFromPath(filePath, "Test_Fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		System.out.println("#####--------------------Start--------------------#####");
		ex = reportInit();
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		System.out.println("#####--------------------Final--------------------#####");
		ex.flush();
	}
}
