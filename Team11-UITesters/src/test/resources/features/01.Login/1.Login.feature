Feature: loginpage
 	 Scenario: Navigate to appUrl
     Given user is on appUrl
     When user gets title of the page
   ##  Then appUrl Page Title should be "LMS"
   Then login using uname password
