package com.virtualassistance.pagerepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChatPage {

    public WebDriver driver;

    public ChatPage (WebDriver driver)
    {
        this.driver=driver;
    }

    By bubble0_text = By.xpath("//div[@id='va-chat-bubble-text-0']");
    By bubble1_text = By.xpath("//div[@id='va-chat-bubble-text-1']");
    By bubble2_text = By.xpath("//div[@id='va-chat-bubble-text-2']");
    By bubble3_text = By.xpath("//div[@id='va-chat-bubble-text-3']");
    By bubble4_text = By.xpath("//div[@id='va-chat-bubble-text-4']");
    By bubble4_response1 = By.xpath("//div[@id='va-chat-bubble-link-container-4']");
    By sendButton = By.xpath("//button[@id='sendButton']");
    By inputChatMessage = By.xpath("//input[@id='chatMessage']");



    public WebElement bubble0_text(WebDriver driver)

    {
        return driver.findElement(bubble0_text);
    }

    public WebElement bubble1_text(WebDriver driver)
    {
        return driver.findElement(bubble1_text);

    }
    public WebElement bubble2_text(WebDriver driver)

    {
        return driver.findElement(bubble2_text);
    }

    public WebElement bubble3_text(WebDriver driver)
    {
        return driver.findElement(bubble3_text);
    }

    public WebElement bubble4_text(WebDriver driver)
    {
        return driver.findElement(bubble4_text);
    }

    public WebElement bubble4_response1(WebDriver driver)
    {
        return driver.findElement(bubble4_response1);
    }

    public WebElement inputChatMessage(WebDriver driver)
    {
        return driver.findElement(inputChatMessage);
    }

    public WebElement sendButton(WebDriver driver)
    {
        return driver.findElement(sendButton);
    }




}
