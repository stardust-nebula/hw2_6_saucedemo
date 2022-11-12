package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continuShoppingButton;

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public void clickContinueShoppingButton(){
        continuShoppingButton.click();
    }
}
