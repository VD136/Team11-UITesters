Feature: Batch page validation
Background: Admin is logged on LMS portal

  @tag1
  Scenario: Validate landing in Batch page
    Given Admin is on dashboard page after Login for batch module
    When Admin clicks "Batch" from navigation bar for batch module
    Then Admin should see the "Manage Batch" in the URL for batch module

  @tag2
  Scenario: Validate header in the Batch Page
    Given Admin is on dashboard page after Login for batch module
    When Admin clicks "Batch" from navigation bar for batch module
    Then Admin should see the "Manage Batch" in the header for batch module

  Scenario: Validate pagination in the Batch Page
    Given Admin is on dashboard page after Login for batch module
    When Admin clicks "Batch" from navigation bar for batch module
    Then Admin should see the pagination controls under the data table for batch module
    
  #Scenario: Validate data table headers in the Batch Page
    #Given Admin is on dashboard page after Login for batch module
    #When Admin clicks "Batch" from navigation bar for batch module
    #Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete for batch module
    #
  #Scenario: Validate Delete button in Batch Page
    #Given Admin is on dashboard page after Login for batch module
    #When Admin clicks "Batch" from navigation bar for batch module
    #Then Admin should be able to see the "Delete" icon button that is disabled for batch module 
    #
  #Scenario: Validate "+ A New batch" in Batch Page
    #Given Admin is on dashboard page after Login for batch module
    #When Admin clicks "Batch" from navigation bar for batch module
    #Then Admin should be able to see the "+ A New batch" button for batch module
    #
  #Scenario: Validate data rows in Batch Page
    #Given Admin is on dashboard page after Login for batch module
    #When Admin clicks "Batch" from navigation bar for batch module
    #Then Each row in the data table should have a checkbox for batch module
   #
  #Scenario: Validate data rows in Batch Page
    #Given Admin is on dashboard page after Login for batch module
    #When Admin clicks "Batch" from navigation bar for batch module
    #Then Each row in the data table should have a edit icon that is enabled for batch module
    #
  #Scenario: Validate data rows in Batch Page
    #Given Admin is on dashboard page after Login for batch module
    #When Admin clicks "Batch" from navigation bar for batch module
    #Then Each row in the data table should have a delete icon that is enabled for batch module
    
  Scenario: Validate pop up for adding batch
    Given Admin is on dashboard page after Login for batch module
    When Admin clicks "+ A New Batch" button for batch module
    Then A new pop up with Batch details appears for batch module
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    