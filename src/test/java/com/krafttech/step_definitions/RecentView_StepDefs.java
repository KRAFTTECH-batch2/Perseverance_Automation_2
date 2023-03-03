package com.krafttech.step_definitions;

import com.krafttech.pages.LoginPage;
import com.krafttech.pages.RecentViewPage;
import com.krafttech.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RecentView_StepDefs {


RecentViewPage recentViewPage=new RecentViewPage();


    @Given("User selects any item clicks on it navigates to the page that has details of the item")
    public void user_selects_any_item_clicks_on_it_navigates_to_the_page_that_has_details_of_the_item() {
       recentViewPage.selectItemGoDetails();
    }


    @Then("reviews the product, and returns to the home page")
    public void reviews_the_product_and_returns_to_the_home_page() {
        recentViewPage.goHome();
    }
    @Given("Once the mouse hovers over the button")
    public void once_the_mouse_hovers_over_the_button() {

        BrowserUtils.hover(recentViewPage.recentViewRight_loc);

    }
    @Then("a small box appears next to it with the text {string}")
    public void a_small_box_appears_next_to_it_with_the_text(String recentView) {
        recentViewPage.hoverRecent(recentView);

    }

    @Given("the user clicks on the Recent View button")
    public void the_user_clicks_on_the_recent_view_button() {
        recentViewPage.recentViewRight_loc.click();
    }

    @When("a new screen is opened has the items that have just been examined")
    public void a_new_screen_is_opened_has_the_items_that_have_just_been_examined() {
        recentViewPage.lastViewedProducts();
    }
    @Then("The last viewed item is at the top of the list")
    public void the_last_viewed_item_is_at_the_top_of_the_list() throws InterruptedException {
        recentViewPage.lastTopOn();



    }

}
