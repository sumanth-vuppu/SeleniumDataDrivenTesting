package org.example.pom;

import org.example.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class GoogleSearchResultsPage {
    WebDriver driver;
    Actions actions;

    public GoogleSearchResultsPage(WebDriver driver){
        this.driver=driver;
        actions=new Actions(driver);

    }


    public ArrayList<String> getGoogleSearchResultsTitles(){
      return   actions.  getMultipleElementsText(By.xpath("//h3[@class=\"LC20lb MBeuO DKV0Md\"]"));
    }

    public ArrayList<String> getGoogleSearchResultsWebsiteLinks(){
        return   actions.  getMultipleElementsText(By.xpath("//cite[@class=\"qLRx3b tjvcx GvPZzd cHaqb\"]"));
    }
}
