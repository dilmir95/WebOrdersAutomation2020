package com.weborders.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.weborders.utils.BrowserUtils;
import com.weborders.utils.ConfigurationReader;
import com.weborders.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class TestBase {

    protected WebDriver driver;
    protected static ExtentReports reports;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentTest;


    @BeforeTest
    public void beforeTest(){

        reports =  new ExtentReports();
        String reportPath = "";
        reportPath = System.getProperty("user.dir")+"/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(reportPath);
        reports.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("WebOrders Automation");

    }

    @AfterTest
    public void afterTest(){
        reports.flush();

    }

    @BeforeMethod
    public void setup(){

        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(ITestResult testResult){
        if(testResult.getStatus() == ITestResult.FAILURE){
            String screenshotLocation = BrowserUtils.getScreenshot(testResult.getName());
            try{
                extentTest.fail(testResult.getName());
                extentTest.fail(testResult.getThrowable());
                extentTest.addScreenCaptureFromPath(screenshotLocation);
            }catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException("Failed to attach screenshot");
            }


        }else if(testResult.getStatus() == ITestResult.SUCCESS){
            extentTest.pass(testResult.getName());
        }else if(testResult.getStatus() == ITestResult.SKIP){
            extentTest.skip(testResult.getName());
        }
        BrowserUtils.wait(2);
        Driver.closeDriver();
    }
}
