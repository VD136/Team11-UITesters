Feature: Delete batch feature
Background: Logged on the LMS portal
#Given Admin is on dashboard page after Login
#Then Admin clicks "Batch" from navigation bar


  #@tag1
  #Scenario: Validate row level delete icon
    #Given The delete icon on row level in data table is enabled for batch
    #When Admin clicks the delete icon for batch
    #Then Alert appears with yes and No option for batch
   #
  #@tag2
  #Scenario: Validate accept alert
  ##  Given Admin clicks the delete icon for batch
    #When You click yes option for batch
    #Then Batch deleted alert pops and batch is no more available in data table for batch
    #
   #Scenario: Validate reject alert
    #Given Admin clicks the delete icon for batch module
    #When you click No option for batch
    #Then Batch is still listed in data table for batch

   Scenario: Validate the delete icon below the header 
    Given None of the checkboxes in data table are selected for batch
    Then The delete icon under the "Manage Batch" header should be disabled for batch
    
  #Scenario: Check for single row delete
    #Given One of the checkbox row is selected for batch
    #When Click delete icon below "Manage Batch" header for batch
    #Then The respective row in the data table is deleted for batch 
    
  Scenario: Check for multi row delete
    Given Two or more checkboxes/row is selected for batch
    When Click delete icon below "Manage Batch" header for multiple rows for batch
    Then The respective rows in the data table are deleted for batch   