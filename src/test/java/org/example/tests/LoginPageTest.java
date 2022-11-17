package org.example.tests;

import org.example.model.User;
import org.example.service.LoginPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService; // его не надо инициализировать тут

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService(); // инициализируем тут
    }

    @Test(description = "Verify successfully authorization with valid credentials")
    public void verifyLoginWithValidCredentialsTest() {
        User user = new User();
        String expectedTextTitleOfInventoryPage = "PRODUCTS";
        String actualTextTitleOfInventoryPage = loginPageService
                .login(user)
                .getTextOfPageTitleSection();
        Assert.assertEquals(actualTextTitleOfInventoryPage, expectedTextTitleOfInventoryPage,
                "The actual text of the page does not match expected!");
    }

}
