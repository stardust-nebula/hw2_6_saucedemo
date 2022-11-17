package org.example.service;

import org.example.page.InventoryPage;
import org.example.page.YourCartPage;

public class InventoryPageService {

    protected InventoryPage inventoryPage = new InventoryPage();

    public InventoryPage addToCart(String productName) {
        inventoryPage.clickAddToCartButton(productName);
        return inventoryPage;
    }

    public YourCartPage goToShoppingCart(){
        inventoryPage.clickShoppingCartIcon();
        return new YourCartPage();
    }

}
