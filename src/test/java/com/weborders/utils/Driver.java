package com.weborders.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private static ThreadLocal<WebDriver>  driverPool = new ThreadLocal<>();

    private Driver(){

    }
    public synchronized static WebDriver getDriver(){

        if(driverPool.get()==null){
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set( new ChromeDriver(chromeOptions));
                    break;
                case "chromeHeadless":
                    WebDriverManager.chromedriver().version("79").setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "safari":
                    driverPool.set( new SafariDriver());
                    break;
                default:
                    throw new RuntimeException("Wrong browser name");
            }
        }
        return driverPool.get();
    }
    public static void closeDriver(){
        if(driverPool.get()!=null){
            driverPool.get().quit();
            driverPool=null;
        }
    }
}
