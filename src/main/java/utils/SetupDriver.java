package utils;

import org.apache.commons.io.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupDriver {

    private static WebDriver driver;

    public static WebDriver getDriver(){
            if (driver == null){
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }


        return driver;
     }

     public static void quitDriver(){
            driver.quit();

     }


}
