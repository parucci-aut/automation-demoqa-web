package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



import static utils.SetupDriver.getDriver;


public class Screenshot {

    public static void takeScreenshot(String nome) throws IOException{

        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File destFile = new File("src/test/resources/screenshot/ " +  "_" + timestamp + "_" + nome + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }


}


