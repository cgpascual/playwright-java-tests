package base;

import com.microsoft.playwright.Page;
import org.testng.annotations.*;
import utils.ConfigReader;

public class BaseTest {

    protected Page page;
    protected ConfigReader config;

    @BeforeMethod
    public void setup() {

        config = new ConfigReader();

        boolean headless = Boolean.parseBoolean(System.getProperty("headless",config.get("headless")));

        page = PlaywrightFactory.initBrowser(headless);
    }

    @AfterMethod
    public void teardown() {

        PlaywrightFactory.tearDown();

    }

}