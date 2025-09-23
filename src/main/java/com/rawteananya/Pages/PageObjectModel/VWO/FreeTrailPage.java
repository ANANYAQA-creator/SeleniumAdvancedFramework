package com.rawteananya.Pages.PageObjectModel.VWO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FreeTrailPage {

    WebDriver driver;

    //Step0 = Parameterised COnstructor

    public FreeTrailPage (WebDriver driver){
        this.driver = driver;
    }

    // Step1 = PageLocators

    private By Free_trail_Page_Email = By.id("page-v1-step1-email");
    private By check_box = By.id("page-free-trial-step1-cu-gdpr-consent-checkbox");
    private By submit_button = By.xpath("//button[text()=\"Create a Free Trial Account\"]");
    private By Error_msg = By.xpath("//div[contains(@class,\"invalid-reason\")]");

    //Step2 = Page Actions
    public String EnterDetails_InvalidTC (String Email){

        driver.get("https://vwo.com/free-trial");
        driver.findElement(Free_trail_Page_Email).sendKeys(Email);
        driver.findElement(check_box).click();
        driver.findElement(submit_button).click();
        String error_msg = driver.findElement(Error_msg).getText();
        return error_msg;

    }

}
