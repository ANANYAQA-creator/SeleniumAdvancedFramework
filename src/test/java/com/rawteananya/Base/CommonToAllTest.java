package com.rawteananya.Base;


import com.rawteananya.Driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    public WebDriver driver;

    @BeforeMethod
    public void Setup_Start_Browser(){
        DriverManager.init();
    }

    @AfterMethod
    public void TearDown_Clsoe_Browser(){
        DriverManager.down();

    }
}