package com.virtualassistance.pagerepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {

    public WebDriver driver;

    public WelcomePage (WebDriver driver)
    {
        this.driver=driver;
    }

    By welcomePageTitle = By.xpath("//h1[@id='va-welcome-header']");
    By welcomePageHeader = By.xpath("//p[@id='va-welcome-cta']");
    By nameInput = By.xpath("//input[@id='va-welcome-input']");
    By startChatButton= By.xpath("//button[@id='va-welcome-send-button']");

    public WebElement welcomePageTitle(WebDriver driver)

    {
        return driver.findElement(welcomePageTitle);
    }

    public WebElement welcomePageHeader(WebDriver driver)
    {
        return driver.findElement(welcomePageHeader);

    }
    public WebElement nameInput(WebDriver driver)

    {
        return driver.findElement(nameInput);
    }

    public WebElement startChatButton(WebDriver driver)
    {
        return driver.findElement(startChatButton);
    }



}
