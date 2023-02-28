
@wiptt
Feature:As a user, I should be able to go through the recent items that I have just looked by using the "recent view" button.


  Background:
    Given The user should be on the login page
    When The user should be able to login with valid "sgezer@gmail.com" and "12345678"

  Scenario:Select and reviews the product
    Given User selects any item clicks on it
    When navigates to the page that has details of the item
    Then reviews the product, and returns to the home page


  Scenario:Recent Items box

    Given Once the mouse hovers over the button
    Then a small box appears next to it with the text "Recent View"

  Scenario:List of Recent Items box

    Given the user clicks on the "Recent View" button
    When a new screen is opened has the items that have just been examined
    Then The last viewed item is at the top of the list
