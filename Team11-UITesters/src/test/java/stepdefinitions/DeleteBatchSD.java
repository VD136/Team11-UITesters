package stepdefinitions;

import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.DeleteBatchPage;

public class DeleteBatchSD {

	TestContext testContext;
	DeleteBatchPage deleteBatchPage;
	
	public DeleteBatchSD(TestContext context)
	{
		testContext = context;
		deleteBatchPage = testContext.getPageObjectManager().getDeleteBatchPage();
		
	}	
	
	@Given("The delete icon on row level in data table is enabled for batch")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled_for_batch() {
		 boolean allDeleteIconsEnabled = deleteBatchPage.ValidateDeleteIconsEnabledonDP();
	        Assert.assertTrue(allDeleteIconsEnabled, "Not all delete icons are enabled");
	}

	@When("Admin clicks the delete icon for batch")
	public void admin_clicks_the_delete_icon_for_batch() {
		deleteBatchPage.ClickDelBtn();
	}

	@Then("Alert appears with yes and No option for batch")
	public void alert_appears_with_yes_and_no_option_for_batch() {
		Assert.assertTrue(deleteBatchPage.Deletealert().isDisplayed(), "Delete popoup is not displayed");
		Assert.assertTrue(deleteBatchPage.Deleletehasoptionyes().isDisplayed(), "Delete popoup does not have yes button displayed");
		Assert.assertTrue(deleteBatchPage.Deleletehasoptionno().isDisplayed(), "Delete popoup does not have no button displayed");
	}

	


	@When("You click yes option for batch")
	public void you_click_yes_option_for_batch() {
		deleteBatchPage.ClickDeleteYesBtn();
	}

	@Then("Batch deleted alert pops and batch is no more available in data table for batch")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table_for_batch() {
		deleteBatchPage.BatchdeleteSucessAlert();
	}

	@Given("Admin clicks the delete icon for batch module")
	public void admin_clicks_the_delete_icon_for_batch_module() {
		deleteBatchPage.ClickDelBtn();
	}
	
	@When("you click No option for batch")
	public void you_click_no_option_for_batch() {
	    deleteBatchPage.ClickDeleleteoptionno();
	}

	@Then("Batch is still listed in data table for batch")
	public void batch_is_still_listed_in_data_table_for_batch() {
		deleteBatchPage.Validatenodeletebatch();
	}
	@Given("None of the checkboxes in data table are selected for batch")
	public void none_of_the_checkboxes_in_data_table_are_selected_for_batch() {
		deleteBatchPage.assertNoCheckboxesSelected();
	}

	@Then("The delete icon under the {string} header should be disabled for batch")
	public void the_delete_icon_under_the_header_should_be_disabled_for_batch(String string) {
		Assert.assertFalse(deleteBatchPage.ValidateHeaderDeletebutton().isEnabled(), "Delete button is enabled");
	}

	@Given("One of the checkbox row is selected for batch")
	public void one_of_the_checkbox_row_is_selected_for_batch() {
		deleteBatchPage.selectsecondRowCheckbox();
	}

	@When("Click delete icon below {string} header for batch")
	public void click_delete_icon_below_header_for_batch(String string)  {
		deleteBatchPage.clickheaderdelbtn();
	}

	@Then("The respective row in the data table is deleted for batch")
	public void the_respective_row_in_the_data_table_is_deleted_for_batch() throws InterruptedException  {
		deleteBatchPage.Validaterowisdeleted();
	}

	@Given("Two or more checkboxes\\/row is selected for batch")
	public void two_or_more_checkboxes_row_is_selected_for_batch() {
		deleteBatchPage.SelectMultipleChechbox();
	}
	
	@When("Click delete icon below {string} header for multiple rows for batch")
	public void click_delete_icon_below_header_for_multiple_rows_for_batch(String string)  {
		deleteBatchPage.clickheaderdelbtnformutiplerows();
	}

	@Then("The respective rows in the data table are deleted for batch")
	public void the_respective_rows_in_the_data_table_are_deleted_for_batch() throws InterruptedException {
		deleteBatchPage.Validatemultiplerowsdeleted();
	}
}
