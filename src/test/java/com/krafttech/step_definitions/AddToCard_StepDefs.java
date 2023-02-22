package com.krafttech.step_definitions;

import com.krafttech.pages.HomePage;
import com.krafttech.pages.LoginPage;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddToCard_StepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    BrowserUtils browserUtils =new BrowserUtils();

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

}
