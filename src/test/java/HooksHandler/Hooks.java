package HooksHandler;

import Pages.CookiesSubPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.BrowserActions;
import utilities.DriverFactory;
import utilities.JsonFileManager;
import utilities.ReadPropertiesFile;

import java.util.Properties;

public class Hooks {
  //variables
    protected WebDriver driver;
    protected static final Properties properties = ReadPropertiesFile.getProperties();
    public JsonFileManager jsonFileManager;

    @BeforeSuite
    public void setUp() {
        jsonFileManager=new JsonFileManager("src/test/resources/configuration/JsonData.json");;
        String browser = properties.getProperty("browser");
        boolean maximize = Boolean.parseBoolean(properties.getProperty("maximize"));
        boolean headless = Boolean.parseBoolean(properties.getProperty("headless"));
        driver = DriverFactory.initiateDriver(browser, maximize, headless);
        BrowserActions.navigate(driver,jsonFileManager.getTestData("website"));
        new CookiesSubPage(driver).acceptCookiesIfPresent();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void CookiesHandler() throws Exception {
        try {
            new CookiesSubPage(driver).acceptCookiesIfPresent();
        } catch (Exception e) {
            throw new Exception("The cookies pop-up did not appear", e);
        }
    }

}
