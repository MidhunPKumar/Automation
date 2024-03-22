package testng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG1 {
	
	ChromeOptions op = new ChromeOptions();
	public ChromeDriver driver;
	
	public TestNG1() {
		op.addArguments("headless");
		driver = new ChromeDriver(op);
	}
	
	@Test
	public void testCase1() {
		System.out.println("Test 1 Done");
		driver.get("https://www.google.com");
	}
	
	@Test
	public void testCase2() {
		System.out.println("Test 2 Done");
		driver.get("https://www.yahoo.com");
		Assert.assertTrue(false);
		driver.quit();
	}
}
