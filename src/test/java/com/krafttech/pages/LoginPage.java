package com.krafttech.pages;

import com.krafttech.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
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

    @FindBy(xpath = "//div[.=' Warning: No match for E-Mail Address and/or Password.']")
    public WebElement invalidPassWarn_loc;

    @FindBy(xpath = "//h2[.='New Customer']")
    public WebElement invalidWindowNew_loc;

    @FindBy(xpath = "//h2[.='Returning Customer']")
    public WebElement invalidWindowReturn_loc;


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

    public void verifyNegativeLoginMessage(String expectedMessage ) {

        invalidPassWarn_loc.isDisplayed();
        String actualMessage = invalidPassWarn_loc.getText();
        Assert.assertEquals("negative login",expectedMessage,actualMessage);




    }

    public void invalidEmail(String email) throws InterruptedException {
        userEmail_loc.sendKeys(email);

        loginSubmit_loc.click();
        Thread.sleep(1000);
        String actualMessage=userEmail_loc.getAttribute("validationMessage");
        System.out.println(actualMessage);
        String expectedMessage="Please include an '@' in the email address. 'ali' is missing an '@'.";
        Assert.assertEquals(expectedMessage,actualMessage);

    }




}
