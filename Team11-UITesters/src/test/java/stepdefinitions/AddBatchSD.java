package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddBatchPage;
import readers.ExcelReader;

public class AddBatchSD {
	
	TestContext testContext;
	AddBatchPage addBatchPage;
	String actualerr;
	ExcelReader reader = new ExcelReader();
	
	public AddBatchSD(TestContext context)
	{
		testContext = context;
		addBatchPage = testContext.getPageObjectManager().getAddBatchPage();
		
	}	
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	@Given("A new pop up with Batch details appears for add batch")
	public void a_new_pop_up_with_batch_details_appears_for_add_batch() {
		String ExpectedABPopTitle = "Batch Details";
		Assert.assertEquals(addBatchPage.ValidateAddNewbatchPopup(),ExpectedABPopTitle);
	}

	@Then("The pop up should include the fields Name, Number of classes and Description as text box, Program Name as drop down, Status as radio button,Number of classes as text box for add batch")
	public void the_pop_up_should_include_the_fields_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button_number_of_classes_as_text_box_for_add_batch() {
		addBatchPage.ValidateAddBtachFields();
		boolean result = addBatchPage.isPopupDisplayingProgramNameDropdown();
		Assert.assertTrue(result, "The pop-up does not display Program Name as a dropdown");
		boolean statusfieldradio = addBatchPage.isStatusFieldRadioButton();
		Assert.assertTrue(statusfieldradio,"Status field should be displayed and contain radio buttons" );
	}

	@When("Fill in all the fields except description with valid values and click save from {string} and {int} for add batch")
	public void fill_in_all_the_fields_except_description_with_valid_values_and_click_save_from_and_for_add_batch(String sheetname, Integer rowNumber) 
			throws InterruptedException {
		addBatchPage.checkDescriptionFieldOptional();
		addBatchPage.clickSavebatchButton();
	}
	
	@Then("The newly added batch should be present in the data table in Manage Batch page Add batch for optional")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page_add_batch_for_optional() {
		addBatchPage.checkAddedBatchexistsforoptional();
	}
	
	@Given("A new pop up with Batch details appears for add batch1")
	public void a_new_pop_up_with_batch_details_appears_for_add_batch1() {
		addBatchPage.clickaddbatch();
	}
	
	@When("Fill in all the fields with valid values and click save from {string} and {int} for add batch")
	public void fill_in_all_the_fields_with_valid_values_and_click_save_from_and_for_add_batch(String sheetname, Integer rowNumber) 
			throws InvalidFormatException, IOException, InterruptedException {
		addBatchPage.fillValidBatchDetails(sheetname,rowNumber);
		addBatchPage.clickSavebatchButton();
	}

	@Then("The newly added batch should be present in the data table in Manage Batch page Add batch")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page_add_batch() {
		addBatchPage.checkAddedBatchexists();
	}

	@Given("A new pop up with Batch details appears for add batch2")
	public void a_new_pop_up_with_batch_details_appears_for_add_batch2() {
		addBatchPage.clickaddbatch1();
	}
	
	@When("Fill any of the fields with invalid values from {string} and {int} for add batch")
	public void fill_any_of_the_fields_with_invalid_values_from_and_for_add_batch(String sheetname, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException{
		actualerr = addBatchPage.fillInValidBatchDetails(sheetname,rowNumber);
		System.out.println("actual err msg " +actualerr);
	}

	@Then("Error message should appear for add batch")
	public void error_message_should_appear_for_add_batch() {
		Assert.assertFalse(actualerr.isEmpty(), "Error message is empty");
	}
	
	@When("Batch name of the mandatory fields is blank from {string} and {int} for add batch")
	public void batch_name_of_the_mandatory_fields_is_blank_from_and_for_add_batch(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
