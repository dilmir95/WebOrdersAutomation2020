package com.weborders.tests;

import com.weborders.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void login(){
        extentTest = reports.createTest("verify page logo");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(loginPage.getPageLogoText(),"Web Orders");

        extentTest.pass("logo verified");
    }
}
