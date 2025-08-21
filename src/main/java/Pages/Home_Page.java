package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class Home_Page {
    WebDriver driver;
    ElementActions actions;

  //constructor
    public Home_Page(WebDriver driver) {
        this.driver=driver;
        actions=new ElementActions(driver);
    }
//locators
    By PersonalIcon =By.id("loginIcon");
    By Login_button=By.id("InnerloginBtn");

    //actions
    public Home_Page ClickOnPersonalIcon()
    {
        //driver.findElement(PersonalIcon).click();
        new ElementActions(driver).click(PersonalIcon);
        return new Home_Page(driver);
    }

    public Login_Page ClickOnLoginButton()
    {
        new ElementActions(driver).click(Login_button);
        return new Login_Page(driver);
    }

    //assertion




}
