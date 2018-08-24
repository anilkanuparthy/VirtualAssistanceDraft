package com.virtualassistance.baseclass.utilities;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {


    public String takeScreenShot(WebDriver driver, String fileWithPath) throws IOException
    {

           File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
              try {
            String currentDir = System.getProperty("user.dir");
            FileUtils.copyFile(src, new File(new File("").getAbsolutePath()+File.separator+"ScreenShots"+File.separator+ System.currentTimeMillis() +fileWithPath+".png"));

        }

        catch (IOException e)
        {
            System.out.println(e.getMessage());

        }

        return fileWithPath;
    }

}
