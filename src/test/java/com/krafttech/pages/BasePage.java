package com.krafttech.pages;

import com.krafttech.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
     public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

}
