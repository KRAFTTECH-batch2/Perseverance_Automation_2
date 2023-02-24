package com.krafttech.step_definitions;

import com.krafttech.pages.HomePage;
import com.krafttech.pages.LoginPage;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class AddToCard_StepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    BrowserUtils browserUtils =new BrowserUtils();

    // Scenario_1
    @When("The user click on your story to go to the home page")
    public void the_user_click_on_your_story_to_go_to_the_home_page() {
        loginPage.homePageButton_loc.click();
        if (loginPage.firstPopUpCloseBtn_loc.isDisplayed()){
            loginPage.firstPopUpCloseBtn_loc.click();
        }
    }

    @Then("The user scrolls down and sees trending items")
    public void the_user_scrolls_down_and_sees_trending_items() {
        BrowserUtils.scrollToElement(homePage.trendingItems_loc);
        Assert.assertTrue(homePage.trendingItems_loc.isDisplayed());
    }


    // Scenario_2
    @When("The user hovers mause over any product and see four options and click add to card icon")
    public void the_user_hovers_mause_over_any_product_and_see_four_options_and_click_add_to_card_icon() throws InterruptedException {
        loginPage.homePageButton_loc.click();
        if (loginPage.firstPopUpCloseBtn_loc.isDisplayed()){
            loginPage.firstPopUpCloseBtn_loc.click();
        }
        homePage.hoverAndAssert();
    }

    @When("The page will automatically scroll all the way up, a success message will appear")
    public void the_page_will_automatically_scroll_all_the_way_up_a_success_message_will_appear() {
       homePage.assertSuccessMessage();
    }

    @Then("Then the user click on the add to card icon and the product appears in the basket in the upper right corner")
    public void then_the_user_click_on_the_add_to_card_icon_and_the_product_appears_in_the_basket_in_the_upper_right_corner() {
        String expectedItemNumber="1";
        Assert.assertEquals(homePage.cardItems_loc.getText(),expectedItemNumber);
    }


    // Scenario_3
    @When("The user click the card icon in the middle right middle and sees products added")
    public void the_user_click_the_card_icon_in_the_middle_right_middle_and_sees_products_added() {
        loginPage.homePageButton_loc.click();
        if (loginPage.firstPopUpCloseBtn_loc.isDisplayed()){
            loginPage.firstPopUpCloseBtn_loc.click();
        }
        homePage.cardIconAndAddedProduct();

    }
    @Then("The user adds all the product stock on the screen to the basket, and then he refers to the page and sees that the new product is not allowed to be added")
    public void the_user_adds_all_the_product_stock_on_the_screen_to_the_basket_and_then_he_refers_to_the_page_and_sees_that_the_new_product_is_not_allowed_to_be_added() {
        homePage.stockControl();
    }


}
