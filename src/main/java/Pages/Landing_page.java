package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ElementActions;

public class Landing_page {

    WebDriver driver;
    ElementActions actions;

    public Landing_page(WebDriver driver)
    {
        this.driver=driver;
        actions=new ElementActions(driver);
    }

    //locators
    By Mynumber=By.id("account-switch-number");

    //validation
    public Landing_page AssertOnLandingPage(String username)
    {
        Assert.assertTrue(actions.getText(Mynumber).contains(username));
        return this;
    }

}
