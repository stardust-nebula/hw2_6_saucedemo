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

    // Можно было и через void. В озвращает текущий объект данной страницы, понадобится в сервисном классе.
    public LoginPage openPage(String url){
        driver.get(url);
        return this;
    }

    public LoginPage fillInUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage fillInPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickLoginButton(){
        loginButton.click();
    }

}
