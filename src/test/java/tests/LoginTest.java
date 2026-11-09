package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;

public class LoginTest extends BaseTest {
    @Test
    public void TC01_LoginSuccess(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        Assert.assertEquals(inventory.getTitle(),"Products");
    }

    @Test
    public void TC02_LoginFail(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","wrong_password");

        Assert.assertTrue(loginPage.getErrorMessage().contains("do not match"));
    }

    @Test
    public void TC03_LoginwithLockedOutAccount(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user","secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage().contains("locked out"));
    }
}
