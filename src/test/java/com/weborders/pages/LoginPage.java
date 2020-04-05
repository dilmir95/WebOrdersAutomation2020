package com.weborders.pages;

import com.weborders.utils.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    @FindBy (id = "ctl00_MainContent_username")
    private WebElement username;

    @FindBy(id = "ctl00_MainContent_password")
    private WebElement password;

    public void login(){
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        this.username.sendKeys(username);
        this.password.sendKeys(password, Keys.ENTER);


    }

    public void login(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass,Keys.ENTER);
    }


}
