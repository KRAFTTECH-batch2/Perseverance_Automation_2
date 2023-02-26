package com.krafttech.pages;

import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.Driver;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends BasePage {

    @FindBy(id = "input-payment-firstname")
    public WebElement firstName_loc;

    @FindBy(id = "input-payment-country")
    public WebElement country_loc;

    @FindBy(id = "input-payment-zone")
    public WebElement regionAndState_loc;

    @FindBy(id = "button-payment-address")
    public WebElement paymentContinueBtn_loc;

    @FindBy(css = "input[value='existing']")
    public WebElement existingAdress_loc;

    @FindBy(xpath = "(//input[@value='existing'])[2]")
    public WebElement existingAdress2_loc;

    @FindBy(id = "button-shipping-address")
    public WebElement shippingContinueBtn_loc;

    @FindBy(xpath = "//input[@name='shipping_method']")
    public WebElement shippingMethod_loc;

    @FindBy(xpath = "(//textarea)[1]")
    public WebElement shippingTextarea_loc;

    @FindBy(id = "button-shipping-method")
    public WebElement shippingMethodContinueBtn_loc;

    @FindBy(xpath = "//input[@name='payment_method']")
    public WebElement paymentMethod_loc;

    @FindBy(xpath = "(//textarea)[2]")
    public WebElement paymentTextarea_loc;

    @FindBy(css = "input[name='agree']")
    public WebElement termsAndConditionsCheckbox;

    @FindBy(id = "button-payment-method")
    public WebElement paymentMethodContinueBtn_loc;

    @FindBy(xpath = "//thead")
    public WebElement orderTableHeaders_loc;

    @FindBy(xpath = "//td[.='Sub-Total:']")
    public WebElement subTotal_loc;

    @FindBy(xpath = "//td[.='Flat Shipping Rate:']")
    public WebElement flat_Shipping_Rate_loc;

    @FindBy(xpath = "//td[.='Total:']")
    public WebElement total_loc;

    @FindBy(id = "button-confirm")
    public WebElement confirmBtn_loc;

    @FindBy(id = "content")
    public WebElement successMessages_loc;

    @FindBy(xpath = "//h1[text()='Your order has been placed!']")
    public WebElement successPageFirstMessage_loc;

    @FindBy(xpath = "//a[.='track your order']")
    public WebElement trackYourOrderLink_loc;

    public void fillTheBillingDetailsForm() {
        BrowserUtils.waitForVisibility(existingAdress_loc, 10);
        if (existingAdress_loc.isDisplayed()) {
            paymentContinueBtn_loc.click();
        } else {
            Actions actions = new Actions(Driver.get());
            actions.click(firstName_loc)
                    .sendKeys("Ahmet" + Keys.TAB)
                    .sendKeys("Büker" + Keys.TAB)
                    .sendKeys("KraftTech" + Keys.TAB)
                    .sendKeys("Yalıkavak Mah. Özge Sok. No:15/5" + Keys.TAB)
                    .sendKeys("Soğanlı/Bahçelievler" + Keys.TAB)
                    .sendKeys("İstanbul" + Keys.TAB)
                    .sendKeys("34251" + Keys.TAB).perform();
            Select select = new Select(country_loc);
            select.selectByVisibleText("Turkey");
            Select select1 = new Select(regionAndState_loc);
            select1.selectByVisibleText("İstanbul");
            paymentContinueBtn_loc.click();
        }
    }

    public void fiilDeliveryDetails() {
        if (existingAdress2_loc.isSelected()) {
            shippingContinueBtn_loc.click();
        }
    }

    public void fiilDeliveryMethod() {
        if (shippingMethod_loc.isSelected()) {
            shippingTextarea_loc.sendKeys("If the door would not open leave the materials to the left neighbour");
            shippingMethodContinueBtn_loc.click();
        }
    }

    public void fiilPaymentMethod() {
        if (paymentMethod_loc.isSelected()) {
            paymentTextarea_loc.sendKeys("Please make a gift box with red paper");
            termsAndConditionsCheckbox.click();
            paymentMethodContinueBtn_loc.click();
        }
    }

    public void isOrdersArrangedTrueAndClick() {
        Assert.assertTrue(orderTableHeaders_loc.getText().contains("Product Name"));
        Assert.assertTrue(orderTableHeaders_loc.getText().contains("Model"));
        Assert.assertTrue(orderTableHeaders_loc.getText().contains("Quantity"));
        Assert.assertTrue(orderTableHeaders_loc.getText().contains("Unit Price"));
        Assert.assertTrue(orderTableHeaders_loc.getText().contains("Total"));
        Assert.assertTrue(subTotal_loc.getText().contains("Sub-Total:"));
        Assert.assertTrue(flat_Shipping_Rate_loc.getText().contains("Flat Shipping Rate:"));
        Assert.assertTrue(total_loc.getText().contains("Total:"));
        confirmBtn_loc.click();
    }

    public void assertSuccessOrder(List<String> successMessages) {
        BrowserUtils.waitForVisibility(successPageFirstMessage_loc, 10);
        for (int i = 0; i < successMessages.size(); i++) {
            Assert.assertTrue(successMessages_loc.getText().contains(successMessages.get(i)));
        }
    }
    public void assertTrackYourOrder() {
        Driver.get().manage().window().setSize(new Dimension(2480, 900));
        BrowserUtils.waitForVisibility(trackYourOrderLink_loc, 10);
        Assert.assertTrue(trackYourOrderLink_loc.isDisplayed());
    }
}
