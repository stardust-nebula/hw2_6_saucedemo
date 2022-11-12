package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage{

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitleSection;

    public String getTextOfPageTitleSection() {
        return pageTitleSection.getText();
    }
}
