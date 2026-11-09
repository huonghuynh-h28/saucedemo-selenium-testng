package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {
    @Test
    public void TC05_checkoutSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.openCartAndCheckout();
        checkout.fillInfo("John", "Doe", "70000");
        checkout.finish();

        Assert.assertEquals(checkout.getConfirmation(), "Thank you for your order!");
    }

    @Test
    public void TC06_checkoutMissingFirstName() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.openCartAndCheckout();
        checkout.fillInfo("", "Doe", "70000");

        Assert.assertEquals(checkout.getError(), "Error: First Name is required");
    }
}
