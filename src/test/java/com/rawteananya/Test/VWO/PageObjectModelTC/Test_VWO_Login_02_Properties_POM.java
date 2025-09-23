package com.rawteananya.Test.VWO.PageObjectModelTC;

import com.rawteananya.Base.CommonToAllTest;
import com.rawteananya.Driver.DriverManager;
import com.rawteananya.Pages.PageObjectModel.VWO.Dashboard_Page;
import com.rawteananya.Pages.PageObjectModel.VWO.LoginPage;
import com.rawteananya.Utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_VWO_Login_02_Properties_POM extends CommonToAllTest {

    // D  - Driver
    // L - Locator
    // V -  Validation


    @Owner("Ananya-QA")
    @Description("TC_1 Verify that with invalid email and password, error message is displayed on the app.vwo.com")
    @Test()
    public void test_VWO_Login_Negative(){

        //Driver

        // Page class code (POM code) = 2   //L

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
     //   String error_msg = loginPage.VWO_Login_Invalid_Cred("usser12","123");

        String error_msg = loginPage.VWO_Login_Invalid_Cred(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        // Assertions = 3   //V
        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank();
        //Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));



    }

    @Description("TC_2 Verify that with valid email and password, able to login on the app.vwo.com")
    @Test

    public void test_VWO_Login_Positive(){

        //Page class code(POM Code) =2 //L

        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        //loginPage_VWO.VWO_Login_Valid_Cred("ananya@cts.com","Shivam@19");

        loginPage_VWO.VWO_Login_Valid_Cred(PropertiesReader.readKey("valid_username"),PropertiesReader.readKey("valid_password"));
        Dashboard_Page dashboardPage = new Dashboard_Page(DriverManager.getDriver());

        String username_loggedin = dashboardPage.loggedin_username();

        assertThat(username_loggedin).isNotBlank().isNotEmpty().isNotNull();
      //  Assert.assertEquals(username_loggedin,"Cts");
Assert.assertEquals(username_loggedin,PropertiesReader.readKey("expected_result"));

    }
}
