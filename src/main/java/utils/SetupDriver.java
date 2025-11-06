package utils;

import org.apache.commons.io.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupDriver {

    private static WebDriver driver;
    private static String navegadorPrincipal;

    public static WebDriver getDriver(){
            if (driver == null){
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }

        return driver;
     }

     public static void quitDriver(){
            if (driver != null){
                driver.quit();
                driver = null;

            }
     }

    public static void setNavegadorPrincipal(String handle) {
        navegadorPrincipal = handle;
    }

    public static String getNavegadorPrincipal() {
        return navegadorPrincipal;
    }


}
