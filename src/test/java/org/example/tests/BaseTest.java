package org.example.tests;

import org.example.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        DriverSingleton.closeDriver();
    }

}
