package pages;

import base.BasePage;
import com.microsoft.playwright.Page;

public class DashboardPage extends BasePage {
    public DashboardPage(Page page) {
        super(page);
    }

    public boolean isDashboardDisplayed() {
        return page.locator("h6").textContent().contains("Dashboard");
    }
}
