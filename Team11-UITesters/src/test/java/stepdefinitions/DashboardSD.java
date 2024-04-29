package stepdefinitions;



import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.*;
import pages.DashBoardPage;
import pages.HomePage;
import pages.SignInPage;
import utilities.HandleExceptions;

import utilities.Log;


public class DashboardSD {
	
TestContext testContext;
	
	HomePage homePage;
	SignInPage signInPage;
	DashBoardPage dashBoardSD;
	

	public DashboardSD(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		signInPage = testContext.getPageObjectManager().getSignInPage();
		dashBoardSD=testContext.getPageObjectManager().getDashBoardage();
		
	}

	
	@Given("Admin is in Home Page")
	public void admin_is_in_Home_page() {
		
			
			homePage.GoToHomePage();
			String titleOfThePage=testContext.getHelper().getTitleOfThePage();
			Assert.assertEquals(titleOfThePage, "LMS");
			System.out.println("LMS : " + titleOfThePage);
		
	
		
	}
	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		
		try {
			Log.startTestCase();
			signInPage.getSignInPage();
			signInPage.SignIn();
			String titleOfThePage=testContext.getHelper().getTitleOfThePage();
			Assert.assertEquals(titleOfThePage, "LMS");
			System.out.println("LMS : " + titleOfThePage);
			
		} catch (Exception ex) {
			HandleExceptions.Handle(ex);
		}
			
		
	}

		
		@Then("Admin should see {string} as header")
		public void admin_should_see_manage_program_as_header(String expManageProgramHeader) {
		
			try {
				   String actualManageProgramHeader=dashBoardSD.isManageProgramHeaderDisplayed();
				   Assert.assertEquals(actualManageProgramHeader, expManageProgramHeader);
					Log.info("Manage Program header is displayed!");
		            System.out.println(actualManageProgramHeader);
		      		    
			} catch (Exception ex) {
				HandleExceptions.Handle(ex);
			}
			 
		}

		@Then("Maximum navigation time in milliseconds, defaults to {int} seconds in dashboard page")
		public void maximum_navigation_time_in_milliseconds_defaults_to_seconds_in_dashboard_page(Integer int1) {
			
			
			try {
				Log.startTestCase();
				long actualTime=dashBoardSD.navigationTime(); 
				Log.info("Actual Navigation Time"+actualTime+"milliseconds");
				System.out.println("Actual Navigation Time"+actualTime+"milliseconds");
				 Log.info("******Max navigation time *********");
				
			} catch (Exception ex) {
				HandleExceptions.Handle(ex);
			}
			
		}

		 @Then ("HTTP response >={int}.The link boken in dashboard page")
		   public void http_response_the_link_broken_in_dashboard_page(Integer int1) {
			 try {
					Log.startTestCase();
					
					dashBoardSD.verifyBrokenLink();
					
					Log.info("LMS -Learning management system");
				} catch (Exception ex) {
					HandleExceptions.Handle(ex);
				}
				
		   }
		

		@Then("Admin should see {string} Learning management system  as title in dashboard page")
		public void admin_should_see_learning_management_system_as_title_in_dashboard_page(String expectedPageTitle) {

			try {
				Log.startTestCase();
				
				String actualTitleDashBoard=dashBoardSD.verifyDashboardPageTitle();
				Assert.assertEquals(actualTitleDashBoard,expectedPageTitle);
				Log.info("LMS -Learning management system"+actualTitleDashBoard);
				
			} catch (Exception ex) {
				HandleExceptions.Handle(ex);
			}
		
		}

		@Then("LMS title should be on the top left corner of page in dashboard page")
		public void lms_title_should_be_on_the_top_left_corner_of_page_in_dashboard_page() {
			
			try {
				Log.startTestCase();
				
				boolean isLmsTitleTopLeft=dashBoardSD.isTitleAtTopLeftCorner();		
				Assert.assertTrue(isLmsTitleTopLeft,"Title is not at the top-left corner of the page.");
			} catch (AssertionError assertionError)
			{ Log.error("Assertion failed: " + assertionError.getMessage());
		    throw assertionError; // Rethrow AssertionError to fail the test
			} catch (Exception ex) {
			    Log.error("An unexpected error occurred: " + ex.getMessage());
			    HandleExceptions.Handle(ex); // Handle other exceptions if necessary
			}
			
			}
		
		@Then("Admin should see correct spelling in navigation bar text in dashboard page")
		public void admin_should_see_correct_spelling_in_navigation_bar_text_in_dashboard_page() {
				dashBoardSD.correctSpellingNavigationTexts();
				Log.info("****correct spelling in navigation bar tex***");
		}

		@Then("Admin should see correct spelling and space in LMS title in dashboard page")
		public void admin_should_see_correct_spelling_and_space_in_lms_title_in_dashboard_page() {
			dashBoardSD.spellSpaceCheck();
			Log.info("****Spelling in LMS title in dashboard page***");
			
		}

		@Then("Admin should see the navigation bar text on the top right side in dashboard page")
		public void admin_should_see_the_navigation_bar_text_on_the_top_right_side_in_dashboard_page() {
			
			dashBoardSD.navigationBarRightTopSide();
			Log.info("****navigation bar text on the top right side ***");
		}
		

@Then("Admin should see 1st Program,2nd Batch ,3rd User and 4th Logout")
public void admin_should_see_1st_program_2nd_batch_3rd_user_and_4th_logout() {
	List<String> expectedModules = Arrays.asList("Program","Batch","User","Logout");
	   dashBoardSD.validateModuleOrder(expectedModules);
		Log.info("****navigation bar text on the top right side ***");
}

		@When("Admin click Logout button on navigation bar")
		public void admin_click_logout_button_on_navigation_bar() {
			
			dashBoardSD.clickLogout();
			
			Log.info("****Admin Clicks Logout***");
		}
		
		@Then("Admin should land on login in page")
		public void admin_should_land_on_login_in_page() {
			try {
				Log.startTestCase();
				
				String titleOfThePage=testContext.getHelper().getTitleOfThePage();
				Assert.assertEquals(titleOfThePage, "LMS");
				String loginText=dashBoardSD.loginLMSAppText();
				Assert.assertEquals(loginText, "Please login to LMS application");
				
			} catch (Exception ex) {
				HandleExceptions.Handle(ex);
			}
		}

		@Given("Admin is in dashboard page")
		public void admin_is_in_dashboard_page() {
			try {
				Log.startTestCase();
				
				String titleOfThePage=testContext.getHelper().getTitleOfThePage();
				Assert.assertEquals(titleOfThePage, "LMS");
				Log.info("****Admin Clicks Logout***");
				
			} catch (Exception ex) {
				HandleExceptions.Handle(ex);
			}
		}


		

	}

		
		
		
		



	
	
	
	


