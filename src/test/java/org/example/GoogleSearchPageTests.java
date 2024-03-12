package org.example;

import org.example.pom.GoogleSearchPage;
import org.example.pom.GoogleSearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GoogleSearchPageTests extends BaseTest {

    @Test
    public void verifySearchResultPage(){
//        Actions actions= new Actions(driver);
//
//
//driver.get("https://google.com");
//        By inputSearchField=By.cssSelector("[title=\"Search\"]");
//        driver.get("https://google.com");
//actions.enterData(searchField, ExcelUtils.getExcelData(2,1));
        //actions.enterData(inputSearchField, "sample");
       // driver.findElement(inputSearchField).sendKeys(Keys.ENTER);

     //   ArrayList<String> result= actions.  getMultipleElementsText(By.xpath("//cite[@class=\"qLRx3b tjvcx GvPZzd cHaqb\"]"));
        GoogleSearchPage googleSearchPage=new GoogleSearchPage(driver);
googleSearchPage.getGoogleWebsite();
        googleSearchPage.enterDateInGoogleSearchInputField("sample");

        GoogleSearchResultsPage googleSearchResultsPage=new GoogleSearchResultsPage(driver);
        ArrayList<String> result=  googleSearchResultsPage.getGoogleSearchResultsWebsiteLinks();
        int maxResultCounter=1;
        int maxResultCountToCheckResult=2;
        for(int i=0;i<result.size();i++) {
              System.out.println("result is ---------"+(result.get(i)));
            if ((result.get(i).contains("sample"))) {

           String[]   splitResult=    result.get(i).split("›");
          driver.get( splitResult[0]);
          break;

//           for (String singleResult:splitResult){
//               System.out.println(singleResult);
//           }
//driver.get(result.get(i));
              // break;


            }
        }}}
