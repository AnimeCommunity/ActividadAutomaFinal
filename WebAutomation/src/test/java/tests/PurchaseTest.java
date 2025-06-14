package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;



public class PurchaseTest extends BaseTest {

    @Test
    public void testCompletePurchaseFlow() {
        new LoginPage(driver).login("standard_user", "secret_sauce");

        HomePage home = new HomePage(driver);
        home.addRandomProductToCart();
        home.goToCart();

        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        // Validación: estamos en la página de Checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.isOnCheckoutPage(), "No se llegó a la página de Checkout");

        checkoutPage.enterCheckoutInfo("John", "Doe", "12345");

        new CheckoutOverviewPage(driver).clickFinish();

        CheckoutCompletePage complete = new CheckoutCompletePage(driver);
        Assert.assertTrue(complete.isThankYouDisplayed(), "Purchase confirmation failed");
    }
}
