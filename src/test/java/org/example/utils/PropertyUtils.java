package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
static Logger logger= LogManager.getLogger(PropertyUtils.class);
    public  static String getProperty(String key)  {
        FileInputStream inputStream = null;
        try {
            inputStream  =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\PageElements.properties");

        }catch (Exception e){
            logger.error("Unable to locate PageElemensts.properties file please look");
        }
        Properties properties=new Properties();
        try {
            properties.load(inputStream);
        }catch (Exception e){
            logger.error("Error in loading initialize stream"+ e.getMessage());
        }

        if(properties.getProperty(key)==null){
            try {
                throw  new Exception("Property " +key+" not found please check");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
       return properties.getProperty(key);

    }

    public static void main(String[] args) throws Exception {
      String result=  getProperty("GoogleSearchPage.inputSearchField");
        System.out.println(result);
    }
}
