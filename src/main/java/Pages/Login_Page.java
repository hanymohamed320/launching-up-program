package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;
import utilities.ElementActions;

public class Login_Page {
    WebDriver driver;
    ElementActions actions;

    public Login_Page(WebDriver driver)
    {
        this.driver=driver;
        actions=new ElementActions(driver);
    }
    //locators
    By MobileNumberField =By.id("username");
    By Password =By.id("password");
    By SubmitButton=By.id("submitBtn");
    By GreetingMessage=By.cssSelector(".lead");

    //actions
    public Login_Page EnterMobileNumber(String MobileNumber)
    {
        actions.type(MobileNumberField,MobileNumber);
        return this;
    }
    public Login_Page EnterPassword(String password)
    {
        actions.type(Password,password);
        return this;
    }
    public Landing_page ClickOnSubmitButton()
    {
        actions.click(SubmitButton);
        return new Landing_page(driver);
    }

    //assertions
    public Login_Page AssertOnLoginPage()
    {
        Assert.assertTrue(actions.getText(GreetingMessage).contains("Hello"));
        return this;

    }







}
