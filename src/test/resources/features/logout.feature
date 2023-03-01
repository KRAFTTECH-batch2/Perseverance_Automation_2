Feature: Logout Functionality

  Background:
    Given The user should be on the login page
    And The user should be able to login with valid "sgezer@gmail.com" and "12345678"

  Scenario: the user can logout without any problem
    When the user clicks the logout button
    Then the user is navigated to logout page
    And the user should see "Account Logout" title
    And the user see helper text
    And user clicks Continue button

  Scenario:when the user logs out,cannot return to the personal page
    When the user clicks the logout button
    And user clicks Continue button
    And  the user clicks page back button
    Then the user is not able come back his personal page