package org.example.service;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.model.User;
import org.example.page.InventoryPage;
import org.example.page.LoginPage;

@Log4j2
public class LoginPageService {

    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    protected LoginPage loginPage = new LoginPage();

    @Step("Login")
    public InventoryPage login(User user) {
        log.info("Login as user: " + user.getLogin());
        loginPage.openPage(LOGIN_PAGE_URL)
                .fillInUsername(user.getLogin())
                .fillInPassword(user.getPassword())
                .clickLoginButton();
        return new InventoryPage();
    }

}
