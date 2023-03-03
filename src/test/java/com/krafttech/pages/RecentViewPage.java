package com.krafttech.pages;

import com.krafttech.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecentViewPage extends BasePage {


LoginPage loginPage=new LoginPage();
    @FindBy (xpath = "//a[@class='sticky-recent']")
    public WebElement recentViewRight_loc;



    @FindBy(xpath ="(//h4/a[contains(text(),'Noerden')])[1]" )
    public WebElement NoerdenScala_loc;


    @FindBy(xpath ="(//h4/a[contains(text(),'Remington Style')])[1]" )
    public WebElement remingtonStyl_loc;

    @FindBy(xpath = "//div//*[text()='Recent View Products']")
    public WebElement recentViewPopUp_loc;

    @FindBy(xpath = " (//*[@id='popup-recent']//h4[@class='font-ct'])[1]")//bakılan son ürün
    public WebElement lastItems_loc;

    @FindBy(xpath = "//a[@data-popup-close='#popup-recent']")
    public WebElement closeRecentViewPopUp_loc;


    @FindBy(xpath = "(//ul[@class='breadcrumb']//a)[2]")// ürüne tıklandıgında detay sayfası
    public WebElement detailsItem_loc;

    public void selectItemGoDetails(){
        BrowserUtils.scrollToElement(NoerdenScala_loc);
        String  noerdenScalaLocText=NoerdenScala_loc.getText();
        NoerdenScala_loc.click();
        String actual=detailsItem_loc.getText();
        Assert.assertEquals(noerdenScalaLocText,actual);

    }
    public void hoverRecent(String recentView){
        String recentViewRightText=recentViewRight_loc.getText();
        Assert.assertEquals(recentView,recentViewRightText);
    }

    public void lastViewedProducts(){
        String recentPopUpText= recentViewPopUp_loc.getText();
        System.out.println("recentPopUpText = " + recentPopUpText);
        String expected="RECENT VIEW PRODUCTS";
        Assert.assertEquals(expected,recentPopUpText);
    }
    public void lastTopOn() throws InterruptedException {
        String actualLast=lastItems_loc.getText();
        System.out.println("actualLast = " + actualLast);
        String expectedLast=NoerdenScala_loc.getText();
        System.out.println("expectedLast = " + expectedLast);
        Assert.assertEquals(expectedLast,actualLast);
        Thread.sleep(1);
        closeRecentViewPopUp_loc.click();
    }
    public void goHome(){
        loginPage.homePageButton_loc.click();
        if (loginPage.firstPopUpCloseBtn_loc.isDisplayed()){
            loginPage.firstPopUpCloseBtn_loc.click();}
    }

}
