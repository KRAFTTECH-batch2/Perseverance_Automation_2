package com.krafttech.step_definitions;

import com.krafttech.pages.LoginPage;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefs {
    LoginPage loginPage=new LoginPage();

    @Given("The user should be on the login page")
    public void the_user_should_be_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.firstPopUpCloseBtn_loc.click();
        loginPage.loginBtn_loc.click();

   }

    @When("The user should be able to login with valid {string} and {string}")
    public void the_user_should_be_able_to_login_with_valid_and(String email, String password) {
        loginPage.login_mtd(email, password);

    }

    @Then("The user should be able to see logout button")
    public void the_user_should_be_able_to_see_logout_button()  {
        loginPage.verifyLogin();

    }

}
