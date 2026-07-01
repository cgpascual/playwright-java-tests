package pages;

import base.BasePage;
import com.microsoft.playwright.Page;

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


}


