Feature: Dashboard Page feature

Background:
Given user has already logged in to application
|username|password|
|roohit.panwar@gmail.com|Selenium12#45|

@E2E
Scenario: Dashboard page title
Given user is on Dashboard page
When user gets the title of the page
Then page title should be "My Account – Automation Practice Site"

@Smoke
Scenario: Dashboard section count
Given user is on Dashboard page
Then user gets dashboard section
|Dashboard|
|Orders|
|Downloads|
|Addresses|
|Account Details|
|Logout|
And dashboard section could should be 6



