package com.rawteananya.Pages.PageObjectModel.VWO;

import com.rawteananya.Utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard_Page {

    WebDriver driver;

    //Step0 = Parameterised Constructor

    public Dashboard_Page(WebDriver driver){
        this.driver = driver;
    }

    // Step1 = Page Locator

    private By username_on_Dashoboard = By.xpath("//h6[text()=\"Cts\"]");

    // Step2 = Page Action

    public String loggedin_username (){
        waitHelpers.waitJVM(1000);
        driver.get("https://app.vwo.com/#/dashboard/get-started?accountId=1141095");
        return driver.findElement(username_on_Dashoboard).getText();

    }

}
