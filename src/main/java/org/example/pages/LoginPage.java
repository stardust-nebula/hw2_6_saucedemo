package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    // Можно было и через void. Возвращает текущий объект данной страницы, понадобится в сервисном классе.
    public LoginPage openPage(String url){
        driver.get(url);
        waitVisibilityOfElement(loginButton);
        return this;
    }

    public LoginPage fillInUsername(String username){
        waitVisibilityOfElement(usernameField).clear();
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage fillInPassword(String password){
        waitVisibilityOfElement(passwordField).clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickLoginButton(){
        waitElementToBeClickable(loginButton)
                .click();
    }

}
