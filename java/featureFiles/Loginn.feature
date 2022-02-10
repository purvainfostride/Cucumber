Feature: Checking Login functionality of application

Scenario Outline:  Checking Login functionality with the invalid login credentials
Given user is on Login page
When user enters "<username>" in the username textfield and "<password>" in password textfield
And user clicks on the Login button
Then user gets invalid credentials message
Examples: 
| username  | password |
| name1     |    5     |
| name2     |    7     | 
| admin     |    ad7   | 


