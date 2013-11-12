package ghostester.core;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	private static final int DEFAULT_TIMEOUT_SECONDS = 20;
	
	protected String BASE_URL = "http://www.yoursiteurl.com/";
	protected WebDriver driver = null;
	protected JavascriptExecutor jsExecutor = null;
	protected boolean acceptNextAlert = true;
	protected boolean closeWhenFinish = true;

	@Rule public TestName testName = new TestName();
	
	@Before
	public void init(){
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
		driver.get(BASE_URL);
		
		printTestName();
	}

	@After
	public void deinit(){
		if(closeWhenFinish) driver.close();
	}
	
	private void printTestName() {
		System.out.println("-- Executing test: " + testName.getMethodName() + "...");
	}
}
