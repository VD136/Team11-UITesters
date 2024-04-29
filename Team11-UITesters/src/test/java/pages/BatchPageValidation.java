package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BatchPageValidation {

	
	@FindBy(xpath="//span[contains(text(),'Batch')]") WebElement Batchbtn;
	@FindBy(xpath="//div[contains(text(), 'Manage Batch')]") WebElement Batchheader;
	@FindBy(xpath = "//p-paginator/div/span[1]") WebElement paginationtext;
	@FindBy(xpath = "//thead[contains(@class, 'p-datatable-thead')]") WebElement tablehead;
	@FindBy(xpath = "//button[contains(@class,'p-button-danger p-button p-component p-button-icon-only')]") WebElement dltbtn;
	//@FindBy(xpath = "//button[@label='A New Batch'] and [@id='pi pi-plus']") WebElement Newbatchbtn;
	@FindBy(xpath = "//span[contains(text(),'A New Batch')]") WebElement Newbatchbtn;
	@FindBy(xpath = "//table/tbody/tr//div[@role='checkbox']") List<WebElement> rows;
	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-pencil')]") List<WebElement> editicons;
	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-trash')]") List<WebElement> deleteIcons;
	@FindBy(xpath = "//div[contains(@role, 'dialog')]") WebElement BatchPopup; 
	@FindBy(xpath = "//span[contains(text(), 'Batch Details')]") WebElement Popuptitle;
			
	WebDriver driver;
	public BatchPageValidation(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String dashboardtitile() {
		return driver.getTitle();
		
	}
	
	public void selectbatchbtn() {
		
		Batchbtn.click();
	}
	
	public String ValidatebatchUrl() {
	
		return driver.getCurrentUrl();
	}
	
	public String Validatebatchheader() {
		
		if (Batchheader.isDisplayed()) {
            return Batchheader.getText();
        } else {
            return "";
        }
		
	}
	
	public WebElement Validatepaginationtext() {
		return paginationtext;
		
	}
	
	public String ValidatetableHead() {
		if (tablehead.isDisplayed()) {
			String thead = tablehead.getText();
			System.out.println("table head text is: " +thead);
            return tablehead.getText();
        } else {
            return "";
        }
    }
	
	public WebElement ValidateDeletebutton() {
		return dltbtn;
		
	}
	
	public WebElement ValidateNewbatchbutton() {
		return Newbatchbtn;
	}
		
	public boolean ValidateCheckboxes() {
		boolean allCheckboxesDisplayed = true;
        for (WebElement row : rows) {
            if (!row.isDisplayed()) {
                System.out.println("Checkbox not present in row: " + row.getText());
                allCheckboxesDisplayed = false;
            }
        }
        return allCheckboxesDisplayed;
    }
	
	public boolean ValidateEditIconsEnabled() {
        boolean allEditIconsEnabled = true;
        for (WebElement editIcon : editicons) {
            if (!editIcon.isEnabled()) {
                System.out.println("Edit icon is not enabled: " + editIcon.getText());
                allEditIconsEnabled = false;
            }
        }
        return allEditIconsEnabled;
    }
    
	public boolean ValidateDeleteIconsEnabled() {
        boolean allDeleteIconsEnabled = true;
        for (WebElement deleteIcon : deleteIcons) {
            if (!deleteIcon.isEnabled()) {
                System.out.println("Delete icon is not enabled: " + deleteIcon.getText());
                allDeleteIconsEnabled = false;
            }
        }
        return allDeleteIconsEnabled;
    }
	
	public void Addnewbatchbtnclick() {
		Newbatchbtn.click();
		
	}
	
	public String ValidateNewbatchPopup() {
	
    if (BatchPopup.isDisplayed()) {
//    	String poptitle = Popuptitle.getText();
//    	System.out.println("popup title text is: " +poptitle);
        return Popuptitle.getText();
    } else {
        return "";
    	}
	}

	
	
}
