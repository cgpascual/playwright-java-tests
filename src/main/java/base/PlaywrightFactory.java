package base;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static Page initBrowser(boolean headless) {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));

        context = browser.newContext();

        page = context.newPage();

        return page;
    }

    public static void tearDown() {
        browser.close();
        playwright.close();
    }
}
