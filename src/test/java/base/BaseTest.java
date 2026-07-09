package base;

import com.microsoft.playwright.Page;
import org.testng.annotations.*;
import utils.ConfigReader;

public class BaseTest {

    protected Page page;
    protected ConfigReader config;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        System.out.println("========== SETUP START ==========");

        config = new ConfigReader();

        boolean headless = Boolean.parseBoolean(
            System.getProperty("headless", config.get("headless"))
        );

        page = PlaywrightFactory.initBrowser(headless);

        System.out.println("===== BASE TEST SETUP END =====");
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        PlaywrightFactory.tearDown();
    }

}