package stepdefinitions;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BatchPageValidation;
import utilities.Log;

public class BatchPageValidationSD {

	TestContext testContext;
	BatchPageValidation batchPageValidation;
	
	public BatchPageValidationSD(TestContext context)
	{
		testContext = context;
		batchPageValidation = testContext.getPageObjectManager().getBatchPageValidation();
		
	}	
	
	
	@Given("Admin is on dashboard page after Login for batch module")
	public void admin_is_on_dashboard_page_after_login_for_batch_module() {
		//batchPageValidation.dashboardtitile();
		String Title = batchPageValidation.dashboardtitile();
		Assert.assertEquals(Title, "LMS", "Title do not match");
		Log.info("Title of current page is ***** " + Title + " ****");
	}

	@When("Admin clicks {string} from navigation bar for batch module")
	public void admin_clicks_from_navigation_bar_for_batch_module(String string) {
		batchPageValidation.selectbatchbtn();
	}

	@Then("Admin should see the {string} in the URL for batch module")
	public void admin_should_see_the_in_the_url_for_batch_module(String ExpectedbatchURL) {
		Assert.assertTrue(batchPageValidation.ValidatebatchUrl().contains(ExpectedbatchURL));
		Log.info("Url of current page is ***** " + batchPageValidation.ValidatebatchUrl() + " ****");
	    
	}

	@Then("Admin should see the {string} in the header for batch module")
	public void admin_should_see_the_in_the_header_for_batch_module(String ExpectedHeader) {
	    Assert.assertEquals(batchPageValidation.Validatebatchheader(),ExpectedHeader );
	    Log.info("Header of current page is ***** " + batchPageValidation.Validatebatchheader() + " ****");
	}

	@Then("Admin should see the pagination controls under the data table for batch module")
	public void admin_should_see_the_pagination_controls_under_the_data_table_for_batch_module() {
		Assert.assertTrue(batchPageValidation.Validatepaginationtext().isDisplayed(), "pagination controls are present" );
	    Log.info("Pagination control text ***** " + batchPageValidation.Validatepaginationtext() + " ****");
	}
	
	@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete for batch module")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete_for_batch_module() {
		String ExpectedHeader = "Batch Name Batch Description Batch Status No Of Classes Program Name Edit / Delete";
		Assert.assertEquals(batchPageValidation.ValidatetableHead(),ExpectedHeader);
	}

	@Then("Admin should be able to see the {string} icon button that is disabled for batch module")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled_for_batch_module(String string) {
		Assert.assertTrue(batchPageValidation.ValidateDeletebutton().isDisplayed(), "Delete button is not displayed");
        Assert.assertFalse(batchPageValidation.ValidateDeletebutton().isEnabled(), "Delete button is enabled");
	}

	@Then("Admin should be able to see the {string} button for batch module")
	public void admin_should_be_able_to_see_the_button_for_batch_module(String string) {
		Assert.assertTrue(batchPageValidation.ValidateNewbatchbutton().isDisplayed(), "New batch button is not displayed");
	
	}

	@Then("Each row in the data table should have a checkbox for batch module")
	public void each_row_in_the_data_table_should_have_a_checkbox_for_batch_module() {
		 boolean allCheckboxesDisplayed = batchPageValidation.ValidateCheckboxes();
	        Assert.assertTrue(allCheckboxesDisplayed, "Not all checkboxes are displayed");
		
	}
	@Then("Each row in the data table should have a edit icon that is enabled for batch module")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled_for_batch_module() {
		boolean allEditIconsEnabled = batchPageValidation.ValidateEditIconsEnabled();
        Assert.assertTrue(allEditIconsEnabled, "Not all edit icons are enabled");
	}

	@Then("Each row in the data table should have a delete icon that is enabled for batch module")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled_for_batch_module() {
		 boolean allDeleteIconsEnabled = batchPageValidation.ValidateDeleteIconsEnabled();
	        Assert.assertTrue(allDeleteIconsEnabled, "Not all delete icons are enabled");
	}

	@When("Admin clicks {string} button for batch module")
	public void admin_clicks_button_for_batch_module(String string) {
		batchPageValidation.Addnewbatchbtnclick();
	}

	@Then("A new pop up with Batch details appears for batch module")
	public void a_new_pop_up_with_batch_details_appears_for_batch_module() {
		String ExpectedPopTitle = "Batch Details";
		Assert.assertEquals(batchPageValidation.ValidateNewbatchPopup(),ExpectedPopTitle);
	}
}
