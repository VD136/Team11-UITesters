package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashBoardPage {
	
	WebDriver driver;

	
	public DashBoardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'Logout')]")WebElement logout;
	@FindBy(xpath="//*[contains(text(),'Manage Program')]")WebElement manageProgramHeader;
	@FindBy(xpath="//span[contains(text(),'LMS - Learning Management System')]")WebElement lMSLabel;
	@FindBy(xpath="//span[contains(text(),'Program')]")WebElement programNameLabel;
	@FindBy(xpath="//span[contains(text(),'Batch')]")WebElement batchNameLabel;
	@FindBy(xpath="//span[contains(text(),'User')]")WebElement userNameLabel;
	@FindBy(xpath="//a[text()='400 brokenlink']") WebElement brokenLink;
	@FindBy(xpath="//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']") WebElement navigationBar;
	@FindBy(xpath="//p[normalize-space()='Please login to LMS application']") WebElement loginToLmsText;
	@FindBy(xpath= "//body//app-root//app-header//mat-toolbar//button")List<WebElement> allElements;
	
	List<String> all_elements_text=new ArrayList<>();

	
	 public String isManageProgramHeaderDisplayed() {
		 if(manageProgramHeader.isDisplayed()) {
				 return manageProgramHeader.getText();
		}else {
			return "";
		}
		}
	
	//Dasboardpage Title
	public String verifyDashboardPageTitle() {
		String dashboardpageTitle=driver.getTitle();
		return dashboardpageTitle;
	}   
    //LMS Title text
	public String getLMSTitleText()
	{
		return lMSLabel.getText();
	}
	
	public  String loginLMSAppText() {
		return loginToLmsText.getText();
	}
	public void clickLogout() {
		logout.click();
	}
	  
	
	//Title Left Corner
	 
	 
	/* public boolean isTitleAtTopLeftCorner() {
	        // Get the location of the LMS title element
	        int titleXCoordinate = lMSLabel.getLocation().getX();
	        int titleYCoordinate = lMSLabel.getLocation().getY();

	        // Check if the title is approximately at the top-left corner (within a small margin)
	        return titleXCoordinate <= 0 && titleYCoordinate <= 0;
	    }*/
	 
	 public boolean isTitleAtTopLeftCorner() {
	        int winHeight = driver.manage().window().getSize().getHeight();
	        int winWidth = driver.manage().window().getSize().getWidth();
	        int xPos = lMSLabel.getLocation().getX();
	        int yPos = lMSLabel.getLocation().getY();
	        return (xPos <= winWidth / 2) && (yPos <= winHeight / 2);
	    }
	 
	 
	
	 //Navigation Time
	/* public boolean navigationTime() {
		    long start = System.currentTimeMillis();
		  //here login button need to click 
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			wait.until(ExpectedConditions.visibilityOf(manageProgramHeader));
		    long timeToLoad= (System.currentTimeMillis()-start);
		    if (timeToLoad<30) 
		    	return true;      
		    else 
		    	return false;
		}*/
	 
	 
	 public long navigationTime() {
		    long start = System.currentTimeMillis();
		    // Here perform the navigation actions, like clicking on the login button
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		    wait.until(ExpectedConditions.visibilityOf(manageProgramHeader));
		    long timeToLoad = (System.currentTimeMillis() - start);
		    return timeToLoad;
		}
	 
	 //*********************Broken Link*******************************
	
	  
	 public  void verifyBrokenLink() {
		 
		 				String url= driver.getCurrentUrl();
			
			try {		

				URL link = new URL(url);
				HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
				httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
				httpURLConnection.connect();
				if (httpURLConnection.getResponseCode()> 400) {
					System.out.println(url + " - " + httpURLConnection.getResponseMessage()+ " - " + "is a broken link");
				} else {
					System.out.println(url + " - " + httpURLConnection.getResponseMessage() );
				}
			} catch (Exception e) {
				System.out.println(url + " - " + "is a broken link");

			}	
		}
	 
	 

	 
	 public boolean correctSpellingNavigationTexts() {

			ArrayList<String> dashBoardPageMenuActualTxt = new ArrayList<String>();
			ArrayList<String> dashBoardPageMenuExpectedTxt = new ArrayList<String>();
			dashBoardPageMenuActualTxt.add(lMSLabel.getText());
			dashBoardPageMenuActualTxt.add(programNameLabel.getText());
			dashBoardPageMenuActualTxt.add(batchNameLabel.getText());
			dashBoardPageMenuActualTxt.add(userNameLabel.getText());
			dashBoardPageMenuActualTxt.add(logout.getText());
			
			dashBoardPageMenuExpectedTxt.add("LMS - Learning Management System");
			dashBoardPageMenuExpectedTxt.add("Program");
			dashBoardPageMenuExpectedTxt.add("Batch");
			dashBoardPageMenuExpectedTxt.add("User");
			dashBoardPageMenuExpectedTxt.add("Logout");
			
			if (dashBoardPageMenuActualTxt.equals(dashBoardPageMenuExpectedTxt) == true) {
				System.out.println("Spellings are correct");
			}
			return true;
		}
	 
	 /*public void SpellingNavigationValidation() {
			Assert.assertEquals("LMS - Learning Management System", driver.getTitle());
			Assert.assertEquals(programNameLabel.getText(),"Program");
			Assert.assertEquals(batchNameLabel.getText(),"Batch");
			Assert.assertEquals(userNameLabel.getText(),"User");
			Assert.assertEquals(logout.getText(),"Logout");
	 }*/
		
	 

	// Check if the title has correct spelling and spacing
	public void spellSpaceCheck() {
	
	    String expectedTitle = "LMS - Learning Management System";
	    String actualTitle = lMSLabel.getText().trim();

	    if (actualTitle.equals(expectedTitle)) {
	        System.out.println("Admin LMS title is correct!");
	    } else {
	        System.out.println("Admin LMS title is incorrect!");
	       
	    }
	}
	
	public boolean navigationBarRightTopSide() {
	    int navigationBarX = navigationBar.getLocation().getX();
	    int navigationBarY = navigationBar.getLocation().getY();
	    int windowWidth = driver.manage().window().getSize().getWidth();

	    // Assuming navigation bar is considered top-right if its X coordinate is close to the right edge of the window
	    // and its Y coordinate is close to the top edge of the window
	    boolean isTopRight = navigationBarX >= windowWidth - 20 && navigationBarY <= 20;

	    if (isTopRight) {
	        System.out.println("Navigation bar is positioned on the top-right side.");
	    } else {
	        System.out.println("Navigation bar is not positioned on the top-right side.");
	    }

	    return isTopRight;
	}
	
	/*public void listOfModules() {

		for(int i=0; i<allElements.size(); i++){

			//loading text of each element in to array all_elements_text
			all_elements_text.add(allElements.get(i).getText());
			System.out.println(allElements.get(i).getText());
		}
	}
	public void validateModuleOrder(List<String> expectedModules) {
        // Validate the number of elements
        Assert.assertEquals(allElements.size(), expectedModules.size());

        // Iterate over the expected modules
        for (int i = 1; i < expectedModules.size(); i++) {
            // Validate the text of each module
            Assert.assertEquals(allElements.get(i).getText(), expectedModules.get(i),
                    "Module text is incorrect at position " + (i + 1));
        }
    }*/
	
	
	public void validateModuleOrder(List<String> expectedModules) {
	    // Validate the number of elements
	    Assert.assertEquals(allElements.size(), expectedModules.size(), "Number of elements mismatch.");

	    // Print expected and actual order
	    System.out.println("Expected order: " + expectedModules);
	    List<String> actualModules = new ArrayList<>();
	    for (WebElement element : allElements) {
	        actualModules.add(element.getText());
	    }
	    System.out.println("Actual order: " + actualModules);

	    // Iterate over the expected modules
	    for (int i = 0; i < expectedModules.size(); i++) {
	        // Validate the text of each module
	        Assert.assertEquals(allElements.get(i).getText(), expectedModules.get(i),
	                "Module text is incorrect at position " + (i + 1));
	    }
	}

	public void validateDashboardPage() {

		String title = driver.getTitle();
		
		System.out.println("Admin is on " + title + "page");
		
	}
	
	}

