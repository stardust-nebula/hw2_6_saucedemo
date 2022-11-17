package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitleSection;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartIcon;

    private static String addToCartBtn = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button[contains(@id,'add-to-cart')]";
    private static String removeBtn = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button[contains(@id,'remove')]";

    @Step("Take page title text")
    public String getTextOfPageTitleSection() {
        return pageTitleSection.getText();
    }

    @Step("Click on 'Add to Cart' button to add '{productName}'")
    public InventoryPage clickAddToCartButton(String productName) {
        By addToCartLocator = By.xpath(String.format(addToCartBtn, productName));
        driver.findElement(addToCartLocator).click();
        return this;
    }

    @Step("Click on the 'Shopping Cart' icon")
    public void clickShoppingCartIcon() {
        shoppingCartIcon.click();
    }

    private By getRemoveBtn(String productName) {
        return By.xpath(String.format(removeBtn, productName));
    }

    @Step("Read name of the button")
    public String getRemoveBtnName(String productName) {
        return driver.findElement(getRemoveBtn(productName)).getText();
    }

}
