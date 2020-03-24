Feature: OpenCart application
@tc01_Register 
Scenario: 
Given the Opencart application opens in chrome browser
When the user clicks on register
Then the user fills all the details
And the user clicks on submit 
@tc02_Validlogin
Scenario:
Given the application opens in browser
When the user clicks on Login
Then the user gives valid credentials
And clicks on Login button
@tc03_InvalidLogin
Scenario:
Given the application will open in chrome browser
When the user clicks on login
Then the user tries to login with invalid details
And click on login button         
@tc04_MandatoryFields
Scenario:
Given the application opens in chrome browser
When the user clicks on register button
Then the user fills the details by leaving one mandatory field
And clicks on submit button
@tc05_Links
Scenario:
Given the application opens
When the user login to the application
Then the homepage opens
And get all the links in that page