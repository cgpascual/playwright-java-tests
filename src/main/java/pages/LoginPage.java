package pages;

import base.BasePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage extends BasePage {
    protected String username = "input[name='username']";
    protected String password = "input[name='password']";
    protected String loginButton = "button[type='submit']";

    public LoginPage(Page page) {
        super(page);
    }

    public void open(String url) {
        page.navigate(url);
    }

    public DashboardPage logIn(String user, String pass) {
        page.locator(username).fill(user);
        page.locator(password).fill(pass);
        page.locator(loginButton).click();

        return new DashboardPage(page);
    }

    public DashboardPage loginAsValidUser(String user, String pass) {

        logIn(user, pass);

        return new DashboardPage(page);
    }

    public boolean isInvalidCredentialsDisplayed() {

        String alertMessage = page.getByRole(AriaRole.ALERT).textContent();

        return page.getByRole(AriaRole.ALERT).isVisible()
                && alertMessage.contains("Invalid credentials");
    }


}


