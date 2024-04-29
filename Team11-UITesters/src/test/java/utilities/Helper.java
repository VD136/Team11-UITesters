package utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;


public class Helper {
 
	private WebDriver driver;
	Alert alert;
	
	public Helper(WebDriver driver) {
		this.driver=driver;
	}
	
		public void navigateBack() {
			
		driver.navigate().back();
		}

		public void navigateForward() {

		driver.navigate().forward();

		}
		
		public String getTitleOfThePage() 
		{
		return driver.getTitle();
		}
		
		public void clickOnWebelement(WebElement element, long waitTimeSecond) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeSecond));
			element= wait.until(ExpectedConditions.elementToBeClickable(element));
	          element.click();
	 }
		
		
		public static boolean isElementDisplayed(WebElement element) {
	        try {
	            return element.isDisplayed();
	        } catch (NoSuchElementException | StaleElementReferenceException e) {
	            return false;
	        }
		}
		
		
		public void acceptAlert() {
			  
			  		alert = driver.switchTo().alert();
			        String alertMessage= driver.switchTo().alert().getText(); 
			        System.out.println(alertMessage); 
			        alert.accept();
			  }

			public void dismissAlert (){
			  
				alert = driver.switchTo().alert();
			        String alertMessage= driver.switchTo().alert().getText(); 
			        System.out.println(alertMessage); 
			        alert.dismiss();
			  }

			public void ValidateAlertText(){
					alert = driver.switchTo().alert();
			        String alertMessage= driver.switchTo().alert().getText(); 
			        System.out.println(alertMessage); 
			  }


			
			 
			 public static void clickElement(WebElement element) {
			        element.click();
			    }
			 
			
}
