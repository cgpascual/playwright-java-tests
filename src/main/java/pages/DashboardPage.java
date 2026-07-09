package pages;

import base.BasePage;
import com.microsoft.playwright.Page;

public class DashboardPage extends BasePage {
    public DashboardPage(Page page) {
        super(page);
    }

    public boolean isDashboardContentDisplayed() {

        String appContent = page.locator("#app").textContent();
        String headerText = page.locator("h6").textContent();

        return appContent != null
                && headerText != null
                && headerText.contains("Dashboard")
                && appContent.contains("Time at Work")
                && appContent.contains("My Actions")
                && appContent.contains("Quick Launch")
                && appContent.contains("Buzz Latest Posts")
                && appContent.contains("Employees on Leave Today")
                && appContent.contains("Employee Distribution by Sub Unit")
                && appContent.contains("Employee Distribution by Location");
    }
}
