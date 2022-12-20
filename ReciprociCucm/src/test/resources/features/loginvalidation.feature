Feature:- Admin Login functionality.

Scenario: In order to verify success login message for valid credentials.

Given Browser is opened and enter URL
When Entered correct username and password
And Click on login button
Then Success message alert will be displayed.


Scenario: In order to verify error message for invalid credentials.

Given Browser is opened and enter URL
When Entered invalid username and password
And Click on login button
Then Error alert message will be displayed.