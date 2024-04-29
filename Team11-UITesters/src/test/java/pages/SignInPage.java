package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import managers.FileReaderManager;
import utilities.Log;

public class SignInPage {

	WebDriver driver;
	//String loginurl = FileReaderManager.getInstance().getConfigReader().getSignInPageURL();
		
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(xpath = "//button[@id='login']") WebElement loginButton;
		
	public SignInPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SignIn()
	{
		
		username.sendKeys("sdetorganizers@gmail.com");
		password.sendKeys("UIHackathon@02");
		loginButton.click();
		//username.sendKeys(FileReaderManager.getInstance().getConfigReader().getUserEmail());
		//password.sendKeys(FileReaderManager.getInstance().getConfigReader().getPassword());
		//loginButton.click();
		//Log.info("User logged in to the application. Username - " 
			//	+ FileReaderManager.getInstance().getConfigReader().getUserEmail());
	}
	
	public void getSignInPage()
	{
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getSignInPageURL());
		Log.info("User is in Sign In Page");
	}
	
	public String VerifySignInPageURL()
	{
		Assert.assertEquals(driver.getCurrentUrl(), FileReaderManager.getInstance().getConfigReader().getSignInPageURL());
		Log.info("Verifies that user is on Home Page");
		return null;
	}
	public void ClickOnLogin()
	{
		loginButton.click();
		Log.info("User clicked on Sign in button on Sign in page");
	}
	
	
	
	
	
	/*public void SignIn(String userName, String passWord)
	{
		Log.info("User is inside sign in for " + userName + ", " + passWord );
		username.sendKeys(userName);
		password.sendKeys(passWord);
		loginButton.click();
		Log.info("User logged in to the application. Username - " + userName);
	}
	
	
	
	
	public void EnterUserName(String userName)
	{
		username.sendKeys(userName);
		Log.info("User enterd the username on Sign in page");
	}
	
	public void EnterPassword(String passWord)
	{
		password.sendKeys(passWord);
		Log.info("User enterd the password on Sign in page");
	}*/
	
	
}