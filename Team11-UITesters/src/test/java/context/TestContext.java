package context;


import managers.*;
import utilities.Helper;

public class TestContext 
{
	private DriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private Helper helper;
	
	public TestContext()
	{
		webDriverManager = new DriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		helper = new Helper(webDriverManager.getDriver());
	
	}
	
	public DriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public Helper getHelper() {
		return helper;
	}

}