Feature: To Validate Login Functionality In Facebook

  Scenario: To Validate Login Invalid Username and Password
    Given User Is In Facebook Login Page
    When Used Invalid Username and Invalid Password
    And User Click Login button
    Then User Should be in invalid credentials page
