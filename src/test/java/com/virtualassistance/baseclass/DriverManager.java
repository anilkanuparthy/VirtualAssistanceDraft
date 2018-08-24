package com.virtualassistance.baseclass;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

public WebDriver driver;


public WebDriver browserInvoke(String url, String browser) throws MalformedURLException {

    if(browser.equalsIgnoreCase("Chrome"))
    {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath()+File.separator+"DriverSource"+ File.separator+"chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    else if (browser.equalsIgnoreCase("Firefox"))
    {
        System.setProperty("webdriver.gecko.driver", new File("").getAbsolutePath()+File.separator+"DriverSource"+File.separator+"geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    else if (browser.equalsIgnoreCase("IE"))
    {

        //DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

        // TODO : Lookup for the updated capabilities for the IE

        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
        //capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        //capabilities.setCapability("allow-blocked-content", true);
        //capabilities.setCapability("allowBlockedContent", true);
        System.setProperty("webdriver.ie.driver", new File("").getAbsolutePath()+File.separator+"DriverSource"+File.separator+"IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver(capabilities);
        //WebDriver driver = new InternetExplorerDriver(InternetExplorerOptions)
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }


    else if (browser.equalsIgnoreCase("Server"))

    {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.SIERRA);
        driver = new RemoteWebDriver(new URL("http://192.168.2.139:4444/wd/hub"), capability);
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    return driver;
}


}




