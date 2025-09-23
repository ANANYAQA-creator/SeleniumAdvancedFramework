package com.rawteananya.Driver;

import com.rawteananya.Utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;

    }

    public static void setDriver(WebDriver driver){
        DriverManager.driver = driver ;
    }

    // When we want to start the browser[initalisation of Browser]

    public static void init(){

        String Browser = PropertiesReader.readKey("browser");
        Browser = Browser.toLowerCase();

        switch (Browser) {

            //EdgeBrowser
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                driver= new EdgeDriver(edgeOptions);
                break;

            //ChromeBrowser
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--guest");
                driver= new ChromeDriver(chromeOptions);
                break;

                // Firefox Browser
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--guest");
                driver= new FirefoxDriver(firefoxOptions);
                break;


            default:
                System.out.println("No Browser Supported");
        }

    }

    // When we want to close the browser

    public static void down(){

        if (getDriver() != null){
            driver.quit();
            driver = null;
        }
    }
}
