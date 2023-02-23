package com.krafttech.pages;

import com.krafttech.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[.='Trending items']")
    public WebElement trendingItems_loc;

    @FindBy(xpath = "(//img[@alt='Noerden Minimi Smart Body Scale'])[1]")
    public WebElement NoerdenMinimiSmartBody_loc;

    @FindBy(xpath = "(//button[@title='Add to cart'])[3]")
    public WebElement shoppingOptions_loc;

    @FindBy(xpath = "(//i[@class='fa fa-heart'])[3]")
    public WebElement heartOptions_loc;

    @FindBy(xpath = "(//button[@class='compare btn-button'])[3]")
    public WebElement compareOptions_loc;

    @FindBy(xpath = "(//div[@class='button-group so-quickview cartinfo--left']//span[text()='Quick view'])[3]")
    public WebElement quickOptions_loc;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successlyMessage_loc;

    @FindBy(xpath = "//span[@class='items_cart']")
    public WebElement cardItems_loc;

    public void hoverAndAssert(){
        BrowserUtils.scrollToElement(trendingItems_loc);
        BrowserUtils.hover(NoerdenMinimiSmartBody_loc);
        BrowserUtils.hover(shoppingOptions_loc);
        Assert.assertTrue(shoppingOptions_loc.isDisplayed());
        BrowserUtils.waitFor(2);
        BrowserUtils.hover(heartOptions_loc);
        Assert.assertTrue(heartOptions_loc.isDisplayed());
        BrowserUtils.waitFor(2);
        BrowserUtils.hover(compareOptions_loc);
        Assert.assertTrue(compareOptions_loc.isDisplayed());
        BrowserUtils.waitFor(2);
        BrowserUtils.hover(quickOptions_loc);
        Assert.assertTrue(quickOptions_loc.isDisplayed());
    }

    public void assertSuccessMessage(){
        shoppingOptions_loc.click();
        BrowserUtils.waitForVisibility(homePageButton_loc,2);
        Assert.assertTrue(successlyMessage_loc.isDisplayed());
    }
}
