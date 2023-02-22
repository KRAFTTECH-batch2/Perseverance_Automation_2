package com.krafttech.step_definitions;

import com.krafttech.pages.AlternativeSearchButtonPage;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


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
}