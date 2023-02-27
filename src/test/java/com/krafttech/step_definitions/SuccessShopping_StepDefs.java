package com.krafttech.step_definitions;

import com.krafttech.pages.AccountPage;
import com.krafttech.pages.CheckoutPage;
import com.krafttech.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class SuccessShopping_StepDefs {
    HomePage homePage = new HomePage();
    CheckoutPage checkoutPage = new CheckoutPage();
    AccountPage accountPage=new AccountPage();

    @When("The user add a {string} to cart")
    public void the_user_add_a_to_cart(String productName) {
        homePage.addToCart(productName);
    }


    @When("The user opens the checkout page")
    public void the_user_opens_the_checkout_page() {
        homePage.navigateToCheckOut();

    }

    @When("The user should fill the Billing Details form")
    public void the_user_should_fill_the_billing_details_form()  {
        checkoutPage.fillTheBillingDetailsForm();
    }

    @When("The user should fill the Delivery Details form")
    public void the_user_should_fill_the_delivery_details_form() {
        checkoutPage.fiilDeliveryDetails();
    }

    @When("The user should fill the Delivery Method form")
    public void the_user_should_fill_the_delivery_method_form() {
        checkoutPage.fiilDeliveryMethod();
    }

    @When("The user should fill the Payment Method form")
    public void the_user_should_fill_the_payment_method_form() {
        checkoutPage.fiilPaymentMethod();
    }

    @When("The user should be able to see order and confirm it")
    public void the_user_should_be_able_to_see_order_and_confirm_it() {
        checkoutPage.isOrdersArrangedTrueAndClick();
    }

    @Then("The user should be able to see success order message")
    public void the_user_should_be_able_to_see_success_order_message(List<String> successMessages) {
       checkoutPage.assertSuccessOrder(successMessages);
    }

    @Then("The user should be able to see Track Your Order link")
    public void the_user_should_be_able_to_see_track_your_order_link() {
        //checkoutPage.assertTrackYourOrder();
    }
    @When("The user should be able to see user's orders at the history page as {string}")
    public void the_user_should_be_able_to_see_user_s_orders_at_the_history_page_as(String shoppingStatus) {
        accountPage.verifyShoppingWithAccountHistory(shoppingStatus);
    }

}
