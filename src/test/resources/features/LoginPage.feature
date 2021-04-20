Feature: Login Page feature    # in Login page we r testing 3 Scenarios

  Scenario:Login page title
    Given User is on login page
    When User gets the title of the page
    Then page title should be "Account Login"

  Scenario: Forgot password link
    Given User is on login page
    Then forgot password link should be displayed


  Scenario: Login with correct credentials
    Given User is on login page
    When User enters username "aprincilin@gmail.com"
    And User enters password "automation123"
    And User clicks on login button
    Then User gets the title of the home page
    And Page title of Account page should be "My account - My Store"
