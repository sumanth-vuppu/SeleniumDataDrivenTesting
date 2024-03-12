package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.example.pom.GoogleSearchPage;
import org.example.pom.GoogleSearchResultsPage;
import org.example.utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class SampleTest extends BaseTest{
//text file
    //xml
    //json
    //csv
    //excel
 Logger logger= LogManager.getLogger(this.getClass());

@Test
public void verifyGoogleSearchResults() throws IOException, InvalidFormatException {

    GoogleSearchPage googleSearchPage=new GoogleSearchPage(driver);
    googleSearchPage.getGoogleWebsite();
    googleSearchPage.enterDateInGoogleSearchInputField("sample");

    GoogleSearchResultsPage googleSearchResultsPage=new GoogleSearchResultsPage(driver);
    ArrayList<String> result=  googleSearchResultsPage.getGoogleSearchResultsTitles();

//actions.enterData(searchField, ExcelUtils.getExcelData(2,1));



int maxResultCounter=1;
int maxResultCountToCheckResult=2;
    for(int i=0;i<result.size();i++){
      //  System.out.println("result is ---------"+(result.get(i)));
        if((result.get(i).contains("sample"))){
if(maxResultCounter==2){
    break;
}
maxResultCounter++;
        }else {
          Assert.assertTrue(false,"Unable to verify sample");
        }
    }

}
@Test(enabled = false)
    public void trim(){
    String trimText="  hello  ";
    System.out.println(trimText);
    System.out.println(trimText.trim());
}


    }