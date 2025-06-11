package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class RemoveItemsTest extends BaseTest {

    @Test
    public void testRemovingItemsFromCart() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        HomePage home = new HomePage(driver);
        home.addMultipleProductsToCart(3);
        home.goToCart();

        CartPage cart = new CartPage(driver);
        cart.removeAllItems();

        Assert.assertEquals(cart.getItemCount(), 0, "Cart is not empty after removing items");
    }
}
