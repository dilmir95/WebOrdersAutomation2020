package com.weborders.pages;

import com.weborders.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,10);


    public PageBase(){
        PageFactory.initElements(Driver.getDriver(),this);
    }





}
