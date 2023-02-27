package com.krafttech.step_definitions;

import com.krafttech.pages.AlternativeSearchButtonPage;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class AlternativeSearchButt_StepDefs {
    AlternativeSearchButtonPage alternativeSearchButtonPage = new AlternativeSearchButtonPage();


    @When("There is an alternative button for search functionality at the middle-right.")
    public void there_is_an_alternative_button_for_search_functionality_at_the_middle_right() {
        BrowserUtils.waitFor(2);
        alternativeSearchButtonPage.verifyRightSearchButton();
    }


    @Given("The user go to web page")
    public void theUserShouldBeOnTheLoginPage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @And("Search bar that user can enter any product name,")
    public void searchBarThatUserCanEnterAnyProductName() {
        alternativeSearchButtonPage.searchWindow();
    }

    @And("Search button that navigates the user to the page that is having product-related items,")
    public void searchButtonThatNavigatesTheUserToThePageThatIsHavingProductRelatedItems() {
        Assert.assertTrue(alternativeSearchButtonPage.searchButton_Loc.isDisplayed());
    }

    @And("x button at the top-right that that returns user the home page.")
    public void xButtonAtTheTopRightThatThatReturnsUserTheHomePage() {
        Assert.assertTrue(alternativeSearchButtonPage.xButton_Loc.isDisplayed());
        alternativeSearchButtonPage.xButton_Loc.click();
        alternativeSearchButtonPage.markethomeButton_met();
    }
}