package com.krafttech.pages;

import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[normalize-space()='Trending items']")
    public WebElement trendingItems_loc;

    @FindBy(xpath = "//a[contains(@title,'Noerden Minimi Smart Body Scale')]//img[1]")
    public WebElement NoerdenMinimiSmartBody_loc;

    @FindBy(xpath = "(//button[@title='Add to cart'])[3]")
    public WebElement shoppingOptions_loc;

    @FindBy(xpath = "(//i[@class='fa fa-heart'])[3]")
    public WebElement heartOptions_loc;

    @FindBy(xpath = "(//button[@class='compare btn-button'])[3]")
    public WebElement compareOptions_loc;

    @FindBy(xpath = "(//a[@class='visible-lg btn-button quickview quickview_handler'])[28]")
    public WebElement quickOptions_loc;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successlyMessage_loc;

    @FindBy(xpath = "//span[@class='items_cart']")
    public WebElement cardItems_loc;

    @FindBy(xpath = "(//i[@class='fa fa-shopping-cart'])[1]")
    public WebElement middleAddToCardIcon_loc;

    @FindBy(xpath = "//span[normalize-space()='New items']")
    public WebElement newItemsButton_loc;

    @FindBy(xpath = "//a[contains(@title,'Revlon RVST2165UK Perfect Straight 230 Digital Sty..')]//img[1]")
    public WebElement revlon_loc;

    @FindBy(xpath = "(//button[@title='Add to cart'])[15]")
    public WebElement revlonAddToCard_loc;
    //(//button[@class='addToCart btn-button'])[15]

    @FindBy(linkText = "Noerden Minimi Smart Body Scale")
    public WebElement noerdenMinimiInCard_loc;

    @FindBy(linkText = "Revlon RVST2165UK Perfect Straight 230 Digital Styler")
    public WebElement revlonInCard_loc;

    @FindBy(xpath = "//a[@data-popup-close='#popup-mycart']")
    public WebElement closeMyCard_loc;

    @FindBy(xpath = "//input[@class='form-control'][@type='text']")
    public WebElement noerdenMinimiInput_loc;

    @FindBy(css = "#button-cart")
    public WebElement noerdenMinimiAddToCardButton_loc;

    @FindBy(xpath = "//div[@class='modal-header']//button[@class='close']")
    public WebElement whatIsNextExit_loc;

    @FindBy(xpath = "//strong[normalize-space()='View Cart']")
    public WebElement middleCardViewCard_loc;

    @FindBy(xpath = "(//tr)[5]//td[4]//input")
    public WebElement quantityInCard_loc;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    public WebElement notStockAlert_loc;

    @FindBy(xpath = "(//button[@class='close'])[1]")
    public WebElement successExit_loc;

    @FindBy(xpath = "(//tr)[5]//td[4]//span//button[@type='submit']")
    public WebElement updateButton_loc;

    @FindBy(xpath = "//p[contains(text(),'My cart')]")
    public WebElement myCart_loc;

    @FindBy(linkText = "Checkout")
    public WebElement checkOutBtn_loc;

    @FindBy(xpath = "//button[@class='popup-close']")
    public WebElement popClsBtn_loc;


    public void hoverAndAssert() {
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

    public void assertSuccessMessage() {
        shoppingOptions_loc.click();
        BrowserUtils.waitForVisibility(homePageButton_loc, 2);
        Assert.assertTrue(successlyMessage_loc.isDisplayed());
    }

    public void cardIconAndAddedProduct() {
        BrowserUtils.scrollToElement(trendingItems_loc);
        BrowserUtils.hover(NoerdenMinimiSmartBody_loc);
        shoppingOptions_loc.click();
        BrowserUtils.waitFor(2);
        BrowserUtils.scrollToElement(newItemsButton_loc);
        BrowserUtils.waitFor(2);
        BrowserUtils.hover(revlon_loc);
        revlonAddToCard_loc.click();

        BrowserUtils.waitForVisibility(homePageButton_loc, 2);
        middleAddToCardIcon_loc.click();
        Assert.assertTrue(noerdenMinimiInCard_loc.isDisplayed());
        Assert.assertTrue(revlonInCard_loc.isDisplayed());
        closeMyCard_loc.click();
    }

    public void stockControl() {
        BrowserUtils.waitFor(1);
        successExit_loc.click();
        BrowserUtils.scrollToElement(trendingItems_loc);
        BrowserUtils.hover(noerdenMinimiInCard_loc);
        quickOptions_loc.click();
        WebElement iframe = Driver.get().findElement(By.tagName("iframe"));
        Driver.get().switchTo().frame(iframe);
        BrowserUtils.clickWithJS(noerdenMinimiAddToCardButton_loc);
        Driver.get().switchTo().defaultContent();
        BrowserUtils.clickWithJS(whatIsNextExit_loc);
        middleAddToCardIcon_loc.click();
        middleCardViewCard_loc.click();
        quantityInCard_loc.clear();
        quantityInCard_loc.sendKeys("22260");
        updateButton_loc.click();
        Assert.assertTrue(notStockAlert_loc.isDisplayed());
    }

    public void addToCart(String productName) {
        WebElement element = Driver.get().findElement(By.linkText(productName));
        //  popClsBtn_loc.click();
        BrowserUtils.scrollToElement(element);
        element.click();
        Driver.get().findElement(By.id("button-cart")).click();
    }

    public void navigateToCheckOut() {
        BrowserUtils.waitForClickablility(checkOutBtn_loc, 10);
        checkOutBtn_loc.click();
    }

}
