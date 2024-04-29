package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

//import com.qa.util.Loggerload;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.HomePage;
///import pages.RegisterPage;
import pages.SignInPage;
import utilities.HandleExceptions;
import utilities.Log;

public class SignInSD {
	private static String title;
	TestContext testContext;
	
	HomePage homePage;
	SignInPage signinPage;
	//RegisterPage registerPage;
	
	static String username;
	static String password;
	
	public SignInSD(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		signinPage = testContext.getPageObjectManager().getSignInPage();
		//registerPage = testContext.getPageObjectManager().getRegistrationPage();
	}	
	
	@Given("user is on appUrl")
	public void user_is_on_app_url() {
		homePage.GoToHomePage();
	}

	@When("user gets title of the page")
	public void user_gets_title_of_the_page() {
		homePage.GoToHomePage();
	}
 
/*	@Then("appUrl Page Title should be {string}")
	public void app_url_page_title_should_be(String string) {
		String Title = homePage.Logindetails();
		//Loggerload.info("Title of current page is ***** " + Title + " ****");
		Assert.assertEquals(Title, "LMS", "Title do not match");
	}*/
	@Then("login using uname password")
	public void login_using_uname_password() {
	    // Write code here that turns the phrase above into concrete actions
	    homePage.Logindetails();
	}
	
}