package com.virtualassistance.baseclass.utilities;
import com.virtualassistance.pagerepository.ChatPage;
import com.virtualassistance.pagerepository.WelcomePage;
import org.openqa.selenium.WebDriver;
import java.util.Map;

public class Util {

    CopyDeckMethods copyDeckMethods = new CopyDeckMethods();
    PropertiesFile propertiesFile = new PropertiesFile();


    public WebDriver driver;

    ChatPage chatPage = new ChatPage(driver);
    WelcomePage welcomePage = new WelcomePage(driver);


    public WebDriver sendChatText(WebDriver driver, String chatText)
    {
        chatPage.inputChatMessage(driver).sendKeys(chatText);
        chatPage.sendButton(driver).click();
        return driver;
    }

    public String getJsonData(String uniqueKey) {

        String jsondata;
        try {

            Map<Object, Map<String, String>> data = copyDeckMethods.loadCopyDeck();
            jsondata = data.get(uniqueKey).get(propertiesFile.getFile("Language"));

        }catch (Exception e)
        {
            e.printStackTrace();
            jsondata = "";
        }
        return jsondata;


    }



}
