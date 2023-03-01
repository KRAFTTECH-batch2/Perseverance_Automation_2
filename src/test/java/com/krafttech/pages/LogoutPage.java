package com.krafttech.pages;

import com.krafttech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage {

    public LogoutPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//div[@id='content']/h1")
    public WebElement contentTitleLoc;

    @FindBy(xpath = "//div[@id='content']/p[1]")
    public WebElement helperText1Loc;

    @FindBy(xpath = "//div[@id='content']/p[2]")
    public WebElement helperText2Loc;

    @FindBy(partialLinkText = "CONTINUE")
    public WebElement continueButtonLoc;

}
