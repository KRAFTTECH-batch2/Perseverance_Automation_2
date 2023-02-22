package com.krafttech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[.='Trending items']")
    public WebElement trendingItems_loc;
}
