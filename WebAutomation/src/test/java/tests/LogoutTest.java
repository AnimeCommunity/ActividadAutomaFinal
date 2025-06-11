package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        HomePage home = new HomePage(driver);
        home.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"), "Did not redirect to login");
    }
}
