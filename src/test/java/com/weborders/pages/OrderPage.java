package com.weborders.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrderPage extends  PageBase{

    @FindBy(css = "*[name='ctl00$MainContent$fmwOrder$ddlProduct']")
    private WebElement productSelect;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    private WebElement unitPrice;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    private WebElement discount;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    private WebElement total   ;

    @FindBy (css = "*[value='Calculate']")
    private WebElement calculateBtn;

    @FindBy(xpath = "//label[text()='Customer name:']/following-sibling::input")
    private WebElement costumerName;

    @FindBy(xpath = "//label[text()='Street:']/following-sibling::input")
    private WebElement street;

    @FindBy(xpath = "//label[text()='City:']/following-sibling::input")
    private WebElement city;

    @FindBy(xpath = "//label[text()='State:']/following-sibling::input")
    private WebElement state;

    @FindBy(xpath = "//label[text()='Zip:']/following-sibling::input")
    private WebElement zipCode;

    @FindBy (css = "[name='ctl00$MainContent$fmwOrder$cardList']")
    private List<WebElement> cardTypeRadioBtns;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")
    private WebElement cardNum;

    @FindBy(css = "[name='ctl00$MainContent$fmwOrder$TextBox1']")
    private WebElement expirationDate;

    @FindBy(linkText = "Process")
    private WebElement process;

    @FindBy(css = "[value='Reset']")
    private WebElement reset;

    @FindBy(xpath = "//strong")
    private WebElement confirmationMsg;




    public void placeAnOrder(){
        Select proSelect = new Select(productSelect);
        proSelect.selectByVisibleText("ScreenSaver");
        quantity.sendKeys("100");
        costumerName.sendKeys("Dimka");
        street.sendKeys("Ludington");
        city.sendKeys("Chicago");
        street.sendKeys("Illinois");
        zipCode.sendKeys("33454");
        cardNum.sendKeys("1234432132344412");
        cardTypeRadioBtns.get(0).click();
        expirationDate.sendKeys("12/20");
        process.click();

    }

    public String getConfirmationMsgTxt(){
        return confirmationMsg.getText();
    }

}
