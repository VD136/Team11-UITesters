package stepdefinitions;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import context.TestContext;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;

public class Hooks {

	TestContext testContext;
	static WebDriver driver;

	public Hooks(TestContext context) 
	{
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
	}

	@BeforeMethod
	public void BeforeSteps() 
	{
		
	}

	@AfterMethod
	public void AfterSteps() 
	{
		
	}
	
//	@After
//    public static void tearDown(Scenario scenario) {
// 
//        if(scenario.isFailed()) {
//            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName()); 
//        }  
//    }

}
