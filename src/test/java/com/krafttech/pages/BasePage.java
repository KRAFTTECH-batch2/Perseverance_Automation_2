package com.krafttech.pages;

import com.krafttech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
     public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[@class='popup-close']")
    public WebElement firstPopUpCloseBtn_loc;

    @FindBy (partialLinkText = "Login")
    public WebElement  loginBtn_loc;





}
