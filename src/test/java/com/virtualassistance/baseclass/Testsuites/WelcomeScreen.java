package com.virtualassistance.baseclass.Testsuites;

import com.virtualassistance.baseclass.DriverManager;
import com.virtualassistance.baseclass.utilities.*;
import com.virtualassistance.pagerepository.ChatPage;
import com.virtualassistance.pagerepository.WelcomePage;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class WelcomeScreen {


    private static Logger Log = Logger.getLogger(Logs.class.getName());
    public WebDriver driver;
    public List<HashMap<String, String>> datamap;
    Util util = new Util();
    ChatPage chatPage = new ChatPage(driver);
    WelcomePage welcomePage = new WelcomePage(driver);
    DriverManager dm = new DriverManager();
    PropertiesFile prop = new PropertiesFile();
    private static final String TAG = "WelcomeScreen";



    // File filepath = new File("").getAbsolutePath()+File.separator+"DataSource"+File.separator+"TestData.xlsx";
    // Extra information:
    // 1) @BeforeTest we declared driver and wait variables
    // 2) We send these driver and wait variables to the page class with below declaration


    @BeforeTest
    @Parameters ({ "browser"})
    public void setBrowser(String browser) throws IOException {

        DOMConfigurator.configure("log4j2.xml");
        Logs.info(TAG,"Log4j successfully configured");

        this.driver = dm.browserInvoke(prop.getFile("url"), browser);
        Logs.info(TAG,"Browser Invoked");

    }

    @Test(enabled =true)
    public void test1_AC1_EnterNameOnWelcomeScreen() throws IOException {

        Logs.startTestCase(TAG,"Starting welcomeObjectsDisplayed_Testcase");

        String title= welcomePage.welcomePageTitle(driver).getText();
        System.out.println("Welcome screen Header : " + title);
        Logs.info(TAG,"Verifying Welcome page title");
        Assert.assertEquals(title,"Welcome","Text is not as expected");

        String titleHeader = welcomePage.welcomePageHeader(driver).getText();
        System.out.println("Welcome screen Header : " + titleHeader);
        Logs.info(TAG,"Verifying Welcome page header");
        Assert.assertEquals(titleHeader,"To get started, please enter your name below:","Text is not as expected");

        welcomePage.nameInput(driver).sendKeys("Anil");
        Logs.info(TAG,"Entering the text in the chat box");

        String button = welcomePage.startChatButton(driver).getText();
        welcomePage.startChatButton(driver).click();
        Logs.info(TAG,"Verifying the Start chat button");
        Assert.assertEquals(button,"Start chat","Text is not as expected");

        Logs.endTestCase(TAG,"Ending welcomeObjectsDisplayed_testcase");
    }

    @Test(enabled = true)
    public void test2_Ac2_WelcomeScreen()

        {
            Logs.startTestCase(TAG,"Starting welcomeObjectsDisplayed_testcase");

            String bubble0 = chatPage.bubble0_text(driver).getText();
            System.out.println("Bubble0 text: " + bubble0);
            Logs.info(TAG,"Verifying Bubble0 is displayed");
            Assert.assertTrue(chatPage.bubble0_text(driver).isDisplayed());

            String bubble1 = chatPage.bubble1_text(driver).getText();
            System.out.println("Bubble1 text: : " + bubble1);
            Logs.info(TAG,"Verifying Bubble1 is displayed");
            Assert.assertTrue(chatPage.bubble1_text(driver).isDisplayed());

            Logs.info(TAG,"Initiating chat");
            Logs.info(TAG,"Sending text to the chat box");
            util.sendChatText(driver,"Hello Can I please get my Billing Cycle Start date?");

            String bubble3 = chatPage.bubble3_text(driver).getText();
            System.out.println("Bubble3 text: " + bubble3);
            Logs.info(TAG,"Verifying Bubble3 is displayed");
            Assert.assertTrue(chatPage.bubble3_text(driver).isDisplayed());

            String bubble4 = chatPage.bubble4_text(driver).getText();
            System.out.println("Bubble4 text: " + bubble4);
            Logs.info(TAG,"Verifying Bubble4 is displayed");
            Assert.assertTrue(chatPage.bubble4_text(driver).isDisplayed());
            Assert.assertTrue(chatPage.bubble4_response1(driver).isDisplayed());

            Logs.endTestCase(TAG,"End of test case Test2_Ac2");
        }


   @Test
    public void  jsondata() throws IOException {

        String bubble2_rep3= util.getJsonData("Start Chat_VA_Chat_Bubble2_Response3");
        Logs.info(TAG,"Verifying 'Start Chat_VA_Chat_Bubble2_Response3' text ");
        Assert.assertEquals("Accounts & Balances", bubble2_rep3);

        String data1 = util.getJsonData("Start Chat_VA_Chat_Bubble2_Response4");
        Logs.info(TAG,"Verifying 'Start Chat_VA_Chat_Bubble2_Response4' text ");
        Assert.assertEquals("Manage Plan & Usage", data1);

        String data = util.getJsonData("Start_Chat_VA_Chat_Bubble2_Response1");
        Logs.info(TAG,"Verifying 'Start Chat_VA_Chat_Bubble2_Response1' text ");
        Assert.assertEquals("Ok, you have a question about billing or your account. There are a few options to choose from:", data);

   }


    @AfterTest
    public void teardown()
    {
        Logs.info(TAG, "Tear down");
        driver.close();
        Logs.info(TAG,"Driver closed");
    }

}
