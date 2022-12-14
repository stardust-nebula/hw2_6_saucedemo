package org.example.tests;

import org.example.model.User;
import org.example.service.InventoryPageService;
import org.example.service.LoginPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseTest {

    private InventoryPageService inventoryPageService;

    @BeforeClass
    public void setUp() {
        inventoryPageService = new InventoryPageService();
        new LoginPageService().login(new User());
    }

    @Test(description = "Verify redirection to 'Your Cart' page")
    public void verifyRedirectionToYourCartPageTest() {
        String expectedTextTitleOfYourCartPage = "YOUR CART";
        String actualTextTitleOfYourCartPage = inventoryPageService
                .goToShoppingCart()
                .getTextOfPageTitleSection();
        Assert.assertEquals(actualTextTitleOfYourCartPage, expectedTextTitleOfYourCartPage, "The actual text f the page does not match expected!");
    }

    @Test(description = "Verify 'Add to Cart' button changes to 'Remove' on click")
    public void verifyAddToCartChangesToRemoveOnClick() {
        String testProductName = "Sauce Labs Backpack";
        String expectedBtnName = "Remove".toLowerCase();
        String actualBtnName = inventoryPageService
                .addToCart(testProductName)
                .getRemoveBtnName(testProductName).toLowerCase();
        Assert.assertEquals(actualBtnName, expectedBtnName);
    }

}
