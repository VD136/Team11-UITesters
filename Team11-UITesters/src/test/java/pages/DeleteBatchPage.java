package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DeleteBatchPage {
	
	String footermsg;
	String footermsgforyes;
	String batchName;
	List<String> MulbatchNames;
	@FindBy(xpath = "//table/tbody/tr//button[contains(@icon, 'pi-trash')]") List<WebElement> deleteIconsdelpage;
	@FindBy(xpath = "//button [contains(@class,'p-button-rounded p-button-danger p-button p-component p-button-icon-only')]") WebElement DelBtn;
	@FindBy(xpath = "//div[contains(@class, 'p-dialog-content')]") WebElement deletepopup;
	@FindBy(xpath = "//span[contains(text(),'Yes')]") WebElement yesbtn;
    @FindBy(xpath = "//span[contains(text(),'No')]") WebElement nobtn;
    @FindBy(xpath = "//div[contains(@class, 'p-d-flex p-ai-center p-jc-between ng-star-inserted')]") WebElement footerText;
    @FindBy(xpath = "//p-table//tr//td[1]/p-tablecheckbox") List<WebElement> checkboxes; 
    @FindBy(xpath = "//button[contains(@class,'p-button-danger p-button p-component p-button-icon-only')]") WebElement Headerdeltbtn;
    @FindBy(xpath = "//p-table//tr[2]/td[1]/p-tablecheckbox") WebElement secondRowCheckbox;
    @FindBy(xpath = "//tr[2]//td[2]") WebElement Batchnametodelete;
    //Select check boxes for row 1,3,4
    @FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr[position()=1 or position()=3 or position()=4]//td[1]//div[@role='checkbox']") List<WebElement> Multiplecheckboxes;
    //Batches names of row1,3,4
    @FindBy(xpath = "//tbody[@class='p-datatable-tbody']/tr[position()=1 or position()=3 or position()=4]/td[2]") List<WebElement> MultiplebatchNames;
    @FindBy (id = "filterGlobal") WebElement searchButton;
    @FindBy (xpath = "//span[@class = 'p-paginator-current ng-star-inserted']") WebElement footerPageforsearch;
    @FindBy(xpath="//span[contains(text(),'Batch')]") WebElement Batchbttn;
    
	WebDriver driver;
	public DeleteBatchPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean ValidateDeleteIconsEnabledonDP() {
        boolean allDeleteIconsEnabledDp = true;
        for (WebElement deleteIcondp : deleteIconsdelpage) {
            if (!deleteIcondp.isEnabled()) {
                System.out.println("Delete icon is not enabled: " + deleteIcondp.getText());
                allDeleteIconsEnabledDp = false;
            }
        }
        return allDeleteIconsEnabledDp;
    }
	
	public void ClickDelBtn() {
		DelBtn.click();
	}
	
	public WebElement Deletealert() {
		
	        return deletepopup;
	 
//        try {
//            Alert alert = driver.switchTo().alert();
//            System.out.println(alert.getText() + " Alert is Displayed");
//        } catch (NoAlertPresentException ex) {
//            System.out.println("Alert is NOT Displayed");
//        }
 //}
	}
	
	public WebElement Deleletehasoptionyes() {
		return yesbtn;
		
	}
	public WebElement Deleletehasoptionno() {
		return nobtn;
		
	}
	
	public void ClickDeleteYesBtn() {
		footermsgforyes=footerText.getAttribute("innerText");
		 System.out.println("this is before yes delete  " +footermsgforyes);
		yesbtn.click();
	}
	
	public void BatchdeleteSucessAlert() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert = driver.switchTo().alert();
//      System.out.println(alert.getText() + " Alert is Displayed");
		String footermsgforyes1=footerText.getAttribute("innerText");
		System.out.println("this is after clicking yes to del  " +footermsgforyes1);
		int num1 = Integer.parseInt(footermsgforyes.replaceAll("\\D", ""));
        int num2 = Integer.parseInt(footermsgforyes1.replaceAll("\\D", ""));
//        if (num1 == num2 + 1) {
//            System.out.println("The integer in the first string." +num1 );
//        } else {
//            System.out.println("The integer in the first string is not greater by 1" +num2);
//        }
        Assert.assertEquals(num1, num2 + 1);
    }
	
	
	public void ClickDeleleteoptionno() {
		
	 // footermsg = footerText.getText().toString();
		footermsg=footerText.getAttribute("innerText");
	  System.out.println("this is before del  " +footermsg);
		nobtn.click();
		 
	}
		
	public void Validatenodeletebatch() {	 
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	        
//	        try {
//	            wait.until(ExpectedConditions.alertIsPresent());
//	  	            System.out.println("Alert appeared unexpectedly!");
//	        } catch (Exception e) {
//	  	            System.out.println("No alerts appeared within the specified time frame.");
//	        }
		//String footermsg1 = footerText.getText().toString();
		String footermsg1=footerText.getAttribute("innerText");
		System.out.println("this is after clicking no to del  " +footermsg1);
		Assert.assertEquals(footermsg,footermsg1);
	}
	
	public void assertNoCheckboxesSelected() {
        for (WebElement checkbox : checkboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }
    }
	
	public WebElement ValidateHeaderDeletebutton() {
		return Headerdeltbtn;
		
	}
	
	public void selectsecondRowCheckbox() {
        secondRowCheckbox.click();
    }
	
	public void clickheaderdelbtn()  {
		 batchName = Batchnametodelete.getText();
		 System.out.println("batch name to delete " +batchName);
		 
		Headerdeltbtn.click();
		yesbtn.click();
	}
	
	public void Validaterowisdeleted() throws InterruptedException  {
		
	//	boolean isBatchExists = driver.findElements(By.xpath("//td[contains(text(),'" + batchName + "')]")).size() != 0;
     //   Assert.assertFalse(isBatchExists, "Batch still exists after deletion: " + batchName);
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      //  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[contains(text(),'" + batchName + "')]")));
        searchButton.click();
		searchButton.sendKeys(batchName);
		Thread.sleep(1000);
		String Actual = footerPageforsearch.getText().toString();
		Assert.assertEquals(Actual, "Showing 0 to 0 of 0 entries", "batch deleted");
		driver.navigate().back();
		Batchbttn.click();
	}
	
	 public void SelectMultipleChechbox() {
	       
	        for (WebElement Multiplecheckbox : Multiplecheckboxes) {
	        	Multiplecheckbox.click();
	        }
	 }
	 
	 public void clickheaderdelbtnformutiplerows() {
		 MulbatchNames = new ArrayList<>();
	        for (WebElement MultiplebatchName : MultiplebatchNames) {
	        	MulbatchNames.add(MultiplebatchName.getText());
	        }
	        for (String mbatchName : MulbatchNames) {
	            System.out.println(mbatchName);
	        }
	        Headerdeltbtn.click();
			yesbtn.click();
	 }
	 
	 public void Validatemultiplerowsdeleted() throws InterruptedException  {
			
				for (String mlpbatchName : MulbatchNames) {
		      
					searchButton.click();
					searchButton.sendKeys(mlpbatchName);
					Thread.sleep(1000);
					String Actual = footerPageforsearch.getText().toString();
					Assert.assertEquals(Actual, "Showing 0 to 0 of 0 entries", "batch deleted");
					searchButton.clear();
					}
				driver.navigate().back();
				Batchbttn.click();
			}
}
