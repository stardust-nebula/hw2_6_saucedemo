package org.example.pages;

import org.example.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage { // нам не нужен объект этого класса, поэтому можно сделать его abstract

    protected WebDriver driver = DriverSingleton.getDriver(); //protected - чтобы наследники имели доступ

    protected BasePage() {
        /*protected - чтобы наследники имели доступ и по цепочке в рамках наследования вызывали один за другим конструктор
       // this это ссылка на объект. PageFactory.initElements(driver, this)
        //когда к переменно будем обращаться, тогда в режиме рантайма это поле проинициализируется значением локатаро. и Так каждый раз .
       каждый раз при обращении (laze initialization) будет занова инициалищироваться, всегда будем плоучать веб элемент в актуальном состоянии
        */
        PageFactory.initElements(driver, this);
    }
}
