package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        @BeforeMethod
        public void setUp() {
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false);
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--incognito");

            if (Boolean.getBoolean("headless")) {
                options.addArguments("--headless=new", "--no-sandbox",
                        "--disable-dev-shm-usage", "--window-size=1920,1080");
            }

            driver = new ChromeDriver(options);
            if (!Boolean.getBoolean("headless")) {
                driver.manage().window().maximize();
            }
            driver.get("https://www.saucedemo.com");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}