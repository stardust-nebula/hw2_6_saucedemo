package org.example.tests;

import org.example.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass(description = "Opening Browser")
    public void startBrowser(){
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true, description = "Closing Browser")
    public void closeBrowser(){
        DriverSingleton.closeDriver();
    }

}
