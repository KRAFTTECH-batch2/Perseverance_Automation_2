Feature: Login Functionality

  Background:
    Given The user should be on the login page


  Scenario: As a user, I should be able to log in with valid credentials
    When The user should be able to login with valid "sgezer@gmail.com" and "12345678"
    Then The user should be able to see logout button

  @negativescenario
  Scenario Outline: : Negative Scenario-User should NOT be able to login with invalid credentials
    When The user enters "<invalidUsername>" and "<invalidPassword>" and click login button
    Then verify that invalid "<message>"
    Then The user should see New Customer and Returning Customer tables on the appearing window

    Examples:
      | invalidUsername | invalidPassword | message                                               |
      | asd9@gmail.com  | 1234            | Warning: No match for E-Mail Address and/or Password. |
      | asdl1@gmail.com |                 | Warning: No match for E-Mail Address and/or Password. |
      |                 | 12              | Warning: No match for E-Mail Address and/or Password. |
      | sgez@gmail.com  |                 | Warning: No match for E-Mail Address and/or Password. |

  @negativescenario
  Scenario: User cannot login unless "@" sign is entered in the email field
    When The user enters "ali" and click login button