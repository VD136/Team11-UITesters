Feature: Add new batch
Background: Logged on the LMS portal
 #Given Admin is on dashboard page after Login
 #When Admin clicks "Batch" from navigation bar
 #Then Admin clicks "+ A New Batch" button
  
  @tag1
  Scenario: Check if the fields exist in pop up of add batch
    Given A new pop up with Batch details appears for add batch
   ## When 
    Then The pop up should include the fields Name, Number of classes and Description as text box, Program Name as drop down, Status as radio button,Number of classes as text box for add batch

  #Scenario Outline: Check if description is optional field 
    #Given A new pop up with Batch details appears for add batch 
    #When Fill in all the fields except description with valid values and click save from "<Sheetname>" and <RowNumber> for add batch
    #Then The newly added batch should be present in the data table in Manage Batch page Add batch for optional
   #
    #Examples: 
      #| Sheetname  | RowNumber | 
      #| Batch      |     0     | 
      
  @tag2
  Scenario Outline: Check if the program details are added in data table
    Given A new pop up with Batch details appears for add batch1 
    When Fill in all the fields with valid values and click save from "<Sheetname>" and <RowNumber> for add batch
    Then The newly added batch should be present in the data table in Manage Batch page Add batch
    
    Examples: 
      | Sheetname  | RowNumber | 
      | Batch      |     1     | 
    
    
  Scenario Outline: Check for error messages for invalid fields
    Given A new pop up with Batch details appears for add batch2 
    When Fill any of the fields with invalid values from "<Sheetname>" and <RowNumber> for add batch
    Then Error message should appear for add batch
    
   Examples: 
      | Sheetname  | RowNumber | 
      | Batch      |     2     | 
      
  #
   #Scenario Outline: Check for error messages for mandatory fields
    #Given A new pop up with Batch details appears for add batch 
    #When Batch name of the mandatory fields is blank from "<Sheetname>" and <RowNumber> for add batch
    #Then Error message should appear for add batch
    #
   #Examples: 
      #| Sheetname  | RowNumber | 
      #| Batch      |     3     |     
   