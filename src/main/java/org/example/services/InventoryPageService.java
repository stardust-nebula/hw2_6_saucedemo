package org.example.services;

import org.example.pages.InventoryPage;
import org.example.pages.YourCartPage;

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
