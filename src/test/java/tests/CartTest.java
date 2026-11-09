package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTest extends BaseTest {
    @Test
    public void TC04_addProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();

        Assert.assertEquals(inventory.getCartCount(), "1");
    }
}
