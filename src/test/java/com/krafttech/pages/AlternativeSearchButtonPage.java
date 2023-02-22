package com.krafttech.pages;

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
