package org.example.pom;

import org.example.Actions;
import org.example.utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GoogleSearchPage {
    WebDriver driver;
    Actions actions;

    public GoogleSearchPage (WebDriver driver){
        this.driver=driver;
        actions=new Actions(driver);
     //   PageFactory.initElements(driver,this);
    }

//@FindBy(id = "[title=\"Search\"]")
//    WebElement inputSearchField;

    //WebElement inputSearchField1=driver.findElement(By.cssSelector("[title=\"Search\"]"));


    By inputSearchField=By.cssSelector(PropertyUtils.getProperty("GoogleSearchPage.inputSearchField"));


    public void getGoogleWebsite (){
        driver.get(PropertyUtils.getProperty("GoogleSearchPage.GoogleWebsiteUrl"));
    }

    public void enterDateInGoogleSearchInputField(String searchWord){
    actions.enterData(inputSearchField, searchWord);
      driver.findElement(inputSearchField).sendKeys(Keys.ENTER);
    //    inputSearchField.sendKeys(Keys.ENTER);

    }
}
