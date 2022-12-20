Feature: Successfully Admin Login

@regression @sanity
Scenario Outline: Validate admin login page
Given Open "<browser>"
And launch admin login url
When Enter "<username>" and "<password>"
And Enter LoginButton
Then Admin Dashboard page will open


Examples:
|browser|username|password|
|chrome|admin|test@123|
|firefox|admin|test@123|


@error
Scenario: Validation error message for incorrect username
Given Open browser
And Enter admin url
When Enter invalid username
And Enter valid password
And click on login button
Then Error message will be displayed


@error
Scenario: Validation error message for incorrect password
Given Open browser
And Enter admin url
When Enter invalid username
And Enter valid password
And click on login button
Then Error message will be displayed

