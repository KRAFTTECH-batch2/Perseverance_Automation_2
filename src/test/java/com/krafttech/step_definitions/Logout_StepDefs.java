package com.krafttech.step_definitions;

import com.krafttech.pages.BasePage;
import com.krafttech.pages.HomePage;
import com.krafttech.pages.LoginPage;
import com.krafttech.pages.LogoutPage;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout_StepDefs {

    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();

    @When("the user clicks the logout button")
    public void the_user_clicks_the_logout_button() {
        BrowserUtils.waitForClickablility(loginPage.logoutBtn_loc,20);
        loginPage.logoutBtn_loc.click();
    }

    @Then("the user is navigated to logout page")
    public void the_user_is_navigated_to_logout_page() {
        Assert.assertTrue(Driver.get().getCurrentUrl().contains("logout"));
    }

    @Then("the user should see {string} title")
    public void the_user_should_see_title(String expectedTitle) {
        String actualTitle = logoutPage.contentTitleLoc.getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("the user see helper text")
    public void the_user_see_helper_text() {
        String expectedText1="You have been logged off your account. It is now safe to leave the computer.";
        String actualText1 = logoutPage.helperText1Loc.getText();
        Assert.assertEquals(expectedText1, actualText1);

        String expectedText2="Your shopping cart has been saved, the items inside " +
                "it will be restored whenever you log back into your account.";
        String actualText2 = logoutPage.helperText2Loc.getText();
        Assert.assertEquals(expectedText2, actualText2);
    }

    @Then("user clicks Continue button")
    public void user_clicks_continue_button(){
        BrowserUtils.waitForClickablility(logoutPage.continueButtonLoc, 20);
        logoutPage.continueButtonLoc.click();
    }

    @When("the user clicks page back button")
    public void the_user_clicks_page_back_button() {
        BrowserUtils.waitForPageToLoad(5);
        Driver.get().navigate().back();
    }

    @Then("the user is not able come back his personal page")
    public void the_user_is_not_able_come_back_his_personal_page() {
        Assert.assertTrue(loginPage.loginBtn_loc.isDisplayed());
    }
}
