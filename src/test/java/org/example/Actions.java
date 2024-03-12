package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Actions extends BaseTest{
    WebDriver driver;
    WebDriverWait driverWait;
public Actions(WebDriver driver){
    this.driver=driver;
    driverWait =new WebDriverWait(driver, Duration.ofSeconds(15));
}


    public void clickElement(By locator){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        driverWait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }


    public void enterData(By locator,String data){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        driverWait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(data);

    }

    public ArrayList<String> getMultipleElementsText(By locator){
        ArrayList<String> data=new ArrayList<>();
driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,1));
for(WebElement element: driver.findElements(locator)){
   // System.out.println("getMultipleElementsText--------"+element.getText());
String text= element.getText().trim();
if(text.length()>0) {
    data.add(element.getText().toLowerCase());
}
}

return data;
    }
}
