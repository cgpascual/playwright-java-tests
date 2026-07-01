package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(page);
        loginPage.open(config.get("url"));

        DashboardPage dashboardPage = loginPage.logIn(config.get("username"), config.get("password"));

        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is displayed");
    }
}
