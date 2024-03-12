package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoggerExample {
  static   Logger logger= LogManager.getLogger(LoggerExample.class);


  public static void debugData(){


      logger.debug("debug message");
System.out.println("printing classname ----------"+new LoggerExample().getClass());
  }

  public static void  errorMessage(){
      int a=0;
      try {
          a=1/0;
      }catch ( Exception e){
          logger.error("error message" +e.getMessage());

      }
      System.out.println("printing a "+a);
      logger.info("reached up to printing a variable data");

logger.warn("warning messages");

logger.fatal("driver initialization failed");


  }

    public static void main(String[] args) {

        debugData();
        errorMessage();



    }
}
