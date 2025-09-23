package com.rawteananya.Pages.PageObjectModel.VWO;

import com.rawteananya.Utils.PropertiesReader;
import com.rawteananya.Utils.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    WebDriver driver;

    // Page class

    // Step 0 :- Parameterised Constructor

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    // Step1 :-  Page Locators

    private By username = By.id("login-username");
    private By passowrd = By.id("login-password");
    private By Signin_button = By.id("js-login-btn");
    private By error_msg = By.xpath("//div[text()=\"Your email, password, IP address or location did not match\"]");



    // Step2 :- Page Actions

    public String VWO_Login_Invalid_Cred (String user,String password){
        //driver.get("https://app.vwo.com/#/login");
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(passowrd).sendKeys(password);
        driver.findElement(Signin_button).click();
        waitHelpers.checkVisibility(driver,error_msg);

        String error_msg_text = driver.findElement(error_msg).getText();
        System.out.println(error_msg_text);
        return error_msg_text;

    }

    public void VWO_Login_Valid_Cred (String user,String password){

        driver.get("https://app.vwo.com/#/login");
        driver.findElement(username).sendKeys(user);
        driver.findElement(passowrd).sendKeys(password);
        driver.findElement(Signin_button).click();

        // wait = thread.sleep

        waitHelpers.waitJVM(5000);

    }
}
