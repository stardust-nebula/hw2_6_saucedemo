package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage{

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitleSection;

    @Step("Take page title text")
    public String getTextOfPageTitleSection() {
        return pageTitleSection.getText();
    }

}
