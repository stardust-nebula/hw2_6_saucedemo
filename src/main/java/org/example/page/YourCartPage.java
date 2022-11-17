package org.example.page;

import io.qameta.allure.Step;
import org.example.utils.AllureUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage{

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitleSection;

    @Step("Take page title text")
    public String getTextOfPageTitleSection() {
        AllureUtils.takeScreenshot(driver);
        return pageTitleSection.getText();
    }

}
