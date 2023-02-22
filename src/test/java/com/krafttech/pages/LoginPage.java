package com.krafttech.pages;

import com.krafttech.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    @FindBy(id = "email")
    public WebElement userEmail_loc;

    @FindBy(id = "pass")
    public WebElement userPassword_loc;

    @FindBy(id = "send2")
    public WebElement loginSubmit_loc;

    @FindBy(partialLinkText = "Logout")
    public WebElement logoutBtn_loc;

    public void login_mtd(String email,String password){
        userEmail_loc.sendKeys(email);
        userPassword_loc.sendKeys(password);
        loginSubmit_loc.click();
    }

    public void verifyLogin(){
        logoutBtn_loc.isDisplayed();
        String expectedText = "Logout";
        String actualText = logoutBtn_loc.getText();
        Assert.assertTrue("Fail", actualText.contains(expectedText));

    }
}
