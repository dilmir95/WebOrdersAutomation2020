package com.weborders.pages;

import com.weborders.utils.BrowserUtils;
import com.weborders.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,10);

    @FindBy (tagName = "h1")
    protected WebElement pageLogo;

    @FindBy(tagName = "h2")
    protected  WebElement subtitle;

    public String getPageSubtitleText(){
        BrowserUtils.waitForPageToLoad(5);
        return subtitle.getText().trim();
    }

    public String getPageLogoText(){
        return pageLogo.getText().trim();
    }

    public void navigateTo(String component){
        String locator = "//a[text()='"+component+"']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();

    }


    public PageBase(){
        PageFactory.initElements(Driver.getDriver(),this);
    }





}
