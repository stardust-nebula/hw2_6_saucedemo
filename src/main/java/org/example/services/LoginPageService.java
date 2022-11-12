package org.example.services;

import org.example.model.User;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;

public class LoginPageService {

    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    protected LoginPage loginPage = new LoginPage();

    public InventoryPage login(User user){
        loginPage.openPage(LOGIN_PAGE_URL)
                .fillInUsername(user.getLogin())
                .fillInPassword(user.getPassword())
                .clickLoginButton();
        return new InventoryPage();
    }



}
