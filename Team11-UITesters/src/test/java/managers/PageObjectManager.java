package managers;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageObjectManager {
	
	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signinPage;
	private DashBoardPage dashBoardPage;
	//private UserPageV2 userPageV2;

	
	public PageObjectManager(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	

	public HomePage getHomePage()
	{
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	
	
	public SignInPage getSignInPage()
	{
		return (signinPage == null) ? signinPage = new SignInPage(driver) : signinPage;
	}
	
	public DashBoardPage getDashBoardage()
	{
		return (dashBoardPage == null) ? dashBoardPage = new DashBoardPage(driver) : dashBoardPage;
	}
	/*public UserPageV2 getUserPageV2()
	{
		return (userPageV2 == null) ? userPageV2 = new UserPageV2(driver) : userPageV2;
	}*/
	
	
}