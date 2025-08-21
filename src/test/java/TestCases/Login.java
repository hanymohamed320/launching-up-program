package TestCases;

import HooksHandler.Hooks;
import Pages.CookiesSubPage;
import Pages.Home_Page;
import Pages.Landing_page;
import Pages.Login_Page;
import org.testng.annotations.Test;
import utilities.JsonFileManager;

public class Login extends Hooks {

    @Test(description = "Test case for login functionality with properties file")
    public void LoginTestCase() {
        new Home_Page(driver).ClickOnPersonalIcon()
                .ClickOnLoginButton();
        new Login_Page(driver).AssertOnLoginPage()
                .EnterMobileNumber(jsonFileManager.getTestData("Mobile_Number"))
                .EnterPassword(jsonFileManager.getTestData("Password"))
                .ClickOnSubmitButton();
        new Landing_page(driver).AssertOnLandingPage(jsonFileManager.getTestData("Mobile_Number"));
    }
}
