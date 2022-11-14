package org.example.pages;

import org.example.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage { // нам не нужен объект этого класса, поэтому можно сделать его abstract

    private static final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver = DriverSingleton.getDriver(); //protected - чтобы наследники имели доступ

    protected BasePage() {
        /*protected - чтобы наследники имели доступ и по цепочке в рамках наследования вызывали один за другим конструктор
       // this это ссылка на объект. PageFactory.initElements(driver, this)
        //когда к переменно будем обращаться, тогда в режиме рантайма это поле проинициализируется значением локатара. и Так каждый раз .
       каждый раз при обращении (laze initialization) будет занова инициализироваться, всегда будем получать веб элемент в актуальном состоянии
        */
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitVisibilityOfElement(WebElement element){
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitElementToBeClickable(WebElement element){
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.elementToBeClickable(element));
    }

}
