Feature: Success Shopping

  Background:
    Given The user should be on the login page
    When The user should be able to login with valid "selo@in.com" and "12345678"
    Then The user should be able to see logout button
    When The user click on your story to go to the home page
    When The user add a "Remington NE3150 Smart" to cart

  @wipihsan
  Scenario: The user should be able to buy added products after completed all payment process
    When The user opens the checkout page
    When The user should fill the Billing Details form
    When The user should fill the Delivery Details form
    When The user should fill the Delivery Method form
    When The user should fill the Payment Method form
    When The user should be able to see order and confirm it
    Then The user should be able to see success order message
      | Your order has been placed!                                                                         |
      | Your order has been successfully processed!                                                         |
      | You can view your order history by going to the my account page and by clicking on history.         |
      | If your purchase has an associated download, you can go to the account downloads page to view them. |
      | Please direct any questions you have to the store owner.                                            |
      | Thanks for shopping with us online!                                                                 |
    Then The user should be able to see Track Your Order link
    When The user click on your story to go to the home page
    When The user should be able to see user's orders at the history page as "Pending"









