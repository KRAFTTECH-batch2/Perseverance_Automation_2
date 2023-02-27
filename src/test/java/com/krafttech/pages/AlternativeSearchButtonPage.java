package com.krafttech.pages;

import com.krafttech.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlternativeSearchButtonPage extends BasePage {

    @FindBy(xpath = "(//i[@class='fa fa-search'])[3]")
    public WebElement alternativeSearchButt_Loc;

    @FindBy(xpath = "(//span[text()='Search'])[1]")
    public WebElement alternativeSearchButtText_Loc;

    @FindBy(xpath = "//button[@class='popup-close']")
    public WebElement firstPopUpCloseBtn_loc;

    @FindBy(xpath = "(//span[text()='Search'])[2]")
    public WebElement popUpSearchWindow;

    @FindBy(id = "button-search")
    public WebElement searchButton_Loc;

    @FindBy(xpath = "(//a[@class='popup-close'])[4]")
    public WebElement xButton_Loc;

    @FindBy(xpath = "(//img[@class='lazyautosizes lazyloaded'])[1]")
    public WebElement marketHomeButt_Loc;

    public void markethomeButton_met() {
        BrowserUtils.waitFor(1);
        marketHomeButt_Loc.click();
        BrowserUtils.waitFor(2);
        Assert.assertTrue(firstPopUpCloseBtn_loc.isDisplayed());
    }


    public void verifyRightSearchButton() {
        firstPopUpCloseBtn_loc.click();
        Assert.assertTrue(alternativeSearchButt_Loc.isDisplayed());
    }

    public void searchWindow() {
        alternativeSearchButt_Loc.click();
        String actualHeader = popUpSearchWindow.getText();
        String expectedHeader = "SEARCH";
        Assert.assertEquals(expectedHeader, actualHeader);
    }
}
