package org.example.service;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.page.InventoryPage;
import org.example.page.YourCartPage;

@Log4j2
public class InventoryPageService {

    protected InventoryPage inventoryPage = new InventoryPage();
    @Step("Adding to Cart product")
    public InventoryPage addToCart(String productName) {
        log.info("Add to Cart product: " + productName);
        inventoryPage.clickAddToCartButton(productName);
        return inventoryPage;
    }
    @Step("Go to Shopping Cart page")
    public YourCartPage goToShoppingCart(){
        log.info("Go to Shopping Cart page");
        inventoryPage.clickShoppingCartIcon();
        return new YourCartPage();
    }

}
