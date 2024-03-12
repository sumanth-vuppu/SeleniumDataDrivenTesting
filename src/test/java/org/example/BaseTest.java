package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
static WebDriver driver;
    @BeforeMethod
    public void initializeDriver(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
    ChromeOptions chromeOptions=new ChromeOptions();
  //  chromeOptions.addArguments("--headless=new");
        driver=new ChromeDriver(chromeOptions);

    }

    @AfterMethod(enabled = false)
    public void quitDriver(){
        if(driver!=null){
            driver.quit();
        }
    }
}
