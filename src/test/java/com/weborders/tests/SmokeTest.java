package com.weborders.tests;

import com.weborders.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTest extends TestBase {
    @Test(dataProvider = "smokeTestData")
    public void smokeTest(String component , String expectedPageSubtitle){
        extentTest = reports.createTest("verify "+component);

    LoginPage loginPage = new LoginPage();
    loginPage.login();
    loginPage.navigateTo(component);
    Assert.assertEquals(loginPage.getPageSubtitleText(),expectedPageSubtitle);

    extentTest.pass("verified "+component);
    }
    @DataProvider
    public Object[][] smokeTestData(){
        return new Object[][]{
                {"View all products","List of Products"},
                {"View all orders","List of All Orders"},
                {"Order","Order"}
        };
    }


    }



