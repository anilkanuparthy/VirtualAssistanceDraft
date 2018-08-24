package com.virtualassistance.baseclass.utilities;

import com.relevantcodes.extentreports.LogStatus;
import com.virtualassistance.baseclass.Testsuites.WelcomeScreen;
import com.virtualassistance.baseclass.utilities.ExtentReports.ExtentManager;
import com.virtualassistance.baseclass.utilities.ExtentReports.ExtentTestManager;
import com.virtualassistance.baseclass.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;


public class ListernerClass implements ITestListener{
    ScreenShot screenShot = new ScreenShot();
    DriverManager dm = new DriverManager();
    private static final String TAG = "ListernerClass";

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("TestCase" + getTestMethodName(result) + " start");
        ExtentTestManager.startTest(result.getMethod().getMethodName(),"TestCase Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TestCase" + getTestMethodName(result) + " success");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver;
        Logs.error(TAG,"TestCase "+getTestMethodName(result)+"has failed");

        Logs.info(TAG, "Capturing the Screenshot");
        driver = ((WelcomeScreen)result.getInstance()).driver;
        try {
            String imagePath = screenShot.takeScreenShot(driver, getTestMethodName(result));
            //ExtentTestManager.getTest().addScreenCapture(imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.info(TAG,"TestCase" + getTestMethodName(result)+ "has skipped");
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
   ExtentTestManager.getTest();

    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
}