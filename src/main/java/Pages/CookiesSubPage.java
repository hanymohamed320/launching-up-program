package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

import java.util.NoSuchElementException;

public class CookiesSubPage {

    private final WebDriver driver;
    private final ElementActions actions;

    public CookiesSubPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
    }

    private static final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");

    public void acceptCookiesIfPresent() {
        try {
            if (actions.isElementVisible(ACCEPT_COOKIES_BTN)) {
                actions.click(ACCEPT_COOKIES_BTN);
                System.out.println("✅ Cookies accepted.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("ℹ️ No cookies popup found.");
        }
    }
}