package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "login", "positive"})
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(page);
        loginPage.open(config.get("url"));

        DashboardPage dashboardPage = loginPage.loginAsValidUser(
                config.get("username"),
                config.get("password")
        );
        page.waitForTimeout(5000);

        Assert.assertTrue(
                dashboardPage.isDashboardContentDisplayed(),
                "Dashboard contents should be displayed."
        );
    }

    @Test(groups = {"regression", "login", "negative"})
    public void loginErrorInvalidUsername(){

        LoginPage loginPage = new LoginPage(page);

        loginPage.open(config.get("url"));

        loginPage.logIn(
                config.get("invalidusername"),
                config.get("password")
        );

        page.waitForTimeout(5000);

        Assert.assertTrue(
                loginPage.isInvalidCredentialsDisplayed(),
                "Invalid credentials error message should be displayed."
        );
    }

    @Test(groups = {"regression", "login", "negative"})
    public void loginErrorInvalidPassword(){

        LoginPage loginPage = new LoginPage(page);

        loginPage.open(config.get("url"));

        loginPage.logIn(
                config.get("username"),
                config.get("invalidpassword")
        );

        page.waitForTimeout(5000);

        Assert.assertTrue(
                loginPage.isInvalidCredentialsDisplayed(),
                "Invalid credentials error message should be displayed."
        );
        
    }
}
