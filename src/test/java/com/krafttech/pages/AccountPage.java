package com.krafttech.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
    @FindBy(css = ".sticky-myaccount")
    public WebElement myAccountBtn_loc;

    @FindBy(css = ".fa.fa-history")
    public WebElement historyBtn_loc;

    @FindBy(xpath = "(//tbody//tr//td)[4]")
    public WebElement pendingText_loc;

    public void verifyShoppingWithAccountHistory(String shoppingStatus) {
        myAccountBtn_loc.click();
        historyBtn_loc.click();
        Assert.assertEquals(shoppingStatus, pendingText_loc.getText());

    }
}
