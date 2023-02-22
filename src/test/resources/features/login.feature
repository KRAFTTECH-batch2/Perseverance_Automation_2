
Feature: Login Functionality

  Background:
    Given The user should be on the login page

  @wip_metin
  Scenario: As a user, I should be able to log in with valid credentials
    When The user should be able to login with valid "sgezer@gmail.com" and "12345678"
    Then The user should be able to see logout button
