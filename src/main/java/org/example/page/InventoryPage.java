package org.example.page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.utils.AllureUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class InventoryPage extends BasePage {

    private static String addToCartBtn = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button[contains(@id,'add-to-cart')]";
    private static String removeBtn = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button[contains(@id,'remove')]";

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitleSection;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartIcon;

    @Step("Take page title text")
    public String getTextOfPageTitleSection() {
        AllureUtils.takeScreenshot(driver);
        return pageTitleSection.getText();
    }

    @Step("Click on 'Add to Cart' button to add '{productName}'")
    public InventoryPage clickAddToCartButton(String productName) {
        log.info("Click on 'Add to Cart' button to add" + productName);
        By addToCartLocator = By.xpath(String.format(addToCartBtn, productName));
        driver.findElement(addToCartLocator).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Click on the 'Shopping Cart' icon")
    public void clickShoppingCartIcon() {
        log.info("Click on 'Shopping Cart' icon");
        shoppingCartIcon.click();
        AllureUtils.takeScreenshot(driver);
    }

    private By getRemoveBtn(String productName) {
        return By.xpath(String.format(removeBtn, productName));
    }

    @Step("Read name of the button")
    public String getRemoveBtnName(String productName) {
        AllureUtils.takeScreenshot(driver);
        return driver.findElement(getRemoveBtn(productName)).getText();
    }

}
