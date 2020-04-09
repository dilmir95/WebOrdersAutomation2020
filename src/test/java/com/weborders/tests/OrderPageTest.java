package com.weborders.tests;

import com.weborders.pages.LoginPage;
import com.weborders.pages.OrderPage;
import com.weborders.utils.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderPageTest extends TestBase {

    @Test
    public void orderAndVerifyMsg(){
        extentTest = reports.createTest("order and verify confirmation message");

        LoginPage loginPage = new LoginPage();
        OrderPage orderPage = new OrderPage();
        loginPage.login();
        loginPage.navigateTo("Order");

        orderPage.placeAnOrder();
        Assert.assertEquals(orderPage.getConfirmationMsgTxt().trim(),"New order has been successfully added.");


        extentTest.pass("successfully ordered !");
    }
}
