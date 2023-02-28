package com.krafttech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecentViewPage extends BasePage {

    @FindBy(xpath = "//a[@class='sticky-categories']")
    public WebElement categoriesRight_loc;

    @FindBy(xpath = "//a[@class='sticky-mycart']")
    public WebElement cartRight_loc;

    @FindBy(xpath="//a[@class='sticky-myaccount']")
    public WebElement accountRight_loc;

    @FindBy(xpath = "//a[@class='sticky-mysearch']")
    public WebElement searchRight_loc;

    @FindBy (xpath = "//a[@class='sticky-recent']")
    public WebElement recentViewRight_loc;

    @FindBy (xpath = "//a[@class='sticky-backtop']")
    public WebElement goToTopRight_loc;
//**************

    @FindBy(xpath ="(//h4/a[contains(text(),'WAHL')])[1]" )
    public WebElement wahlMens_loc;


    @FindBy(xpath ="(//h4/a[contains(text(),'Remington Style')])[1]" )
    public WebElement remingtonStyl_loc;



    @FindBy(xpath = " (//*[@id='popup-recent']//h4[@class='font-ct'])[1]")
    public WebElement lastItems_loc;

    @FindBy(xpath = "(//a[@class='popup-close' ])[1]")
    public WebElement closeRecentPop_loc;


    @FindBy(xpath = "(//ul[@class='breadcrumb']//a)[2]")
    public WebElement detailsItem_loc;

}
