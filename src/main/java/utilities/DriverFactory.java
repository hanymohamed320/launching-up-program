package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static WebDriver driver;

    public static WebDriver initiateDriver(String browserName,boolean maximize,boolean headless) {
        if (browserName.equalsIgnoreCase("chrome")&& headless==true) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            System.out.println("the chrome browser will run in headless");
            driver = new ChromeDriver(options);
        }
        else if (browserName.equalsIgnoreCase("chrome") ) {
            driver=new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        if (maximize) {
            driver.manage().window().maximize();
        }

        return driver;
    }
}