#Feature: Login page feature
#
#Scenario: Login page title
#Given user is on login page
#When user gets the title of the page
#Then page title should be "Customer Login Magento Commerce"
#
#Scenario: Forgot passowrd link
#Given user is on login page
#Then forgot password link should be displayed
#
#Scenario: Login with correct credentails
#Given user is on login page
#When user enters username "roni_cost@example.com"
#And user enters password "pssword"
#Then user gets the title of the home page
#And page title should be "121212121"

Feature: Login page feature

@Smoke
Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "My Account – Automation Practice Site"

@SkipTest
Scenario: Forgot passowrd link
Given user is on login page
Then forgot password link should be displayed

@Smoke
Scenario: Login with correct credentails
Given user is on login page
When user enters username "roohit.panwar@gmail.com"
And user enters password "Selenium12#45"
And user clicks on login button
Then user gets the title of the page
And page title should be "My Account – Automation Practice Site"
