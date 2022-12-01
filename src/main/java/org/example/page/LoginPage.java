package org.example.page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.utils.AllureUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    // Можно было и через void. Возвращает текущий объект данной страницы, понадобится в сервисном классе.
    @Step("Open Login page")
    public LoginPage openPage(String url) {
        log.info("Open Login page by link: " + url);
        driver.get(url);
        waitVisibilityOfElement(loginButton);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Enter username in the 'username' field")
    public LoginPage fillInUsername(String username) {
        waitVisibilityOfElement(usernameField).clear();
        log.info("Fill in username field with username: " + username);
        usernameField.sendKeys(username);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Enter password in the 'password' field")
    public LoginPage fillInPassword(String password) {
        waitVisibilityOfElement(passwordField).clear();
        log.info("Fill in password field");
        passwordField.sendKeys(password);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Click on the 'Login' button")
    public void clickLoginButton() {
        log.info("Click on 'Login' button");
        waitElementToBeClickable(loginButton).click();
        AllureUtils.takeScreenshot(driver);
    }

}
