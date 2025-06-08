package Demo_2.ecommers;

import PageObject.AddProductPage;
import PageObject.CartPage;
import PageObject.LoginPage;
import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddProduct extends BaseTest {

    @Test
    public void AddProductTest() throws Exception {

        String ProductName = "ADIDAS ORIGINAL";
        launchApp();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginIn("testng17@gmail.com", "Test@123");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Let's Shop", "Title does not match");
        System.out.println(title);

        //Add product to cart

        AddProductPage addProductPage = new AddProductPage(driver);
        List<WebElement> Products = addProductPage.getProductList();
        System.out.println(Products);

        addProductPage.addToCart(ProductName);
        addProductPage.goToCart();
        addProductPage.getCartProducts(ProductName);
        addProductPage.goToCart();


        CartPage cartPage = new CartPage(driver);
        boolean match = cartPage.VerifyProductDispay(ProductName);
        Assert.assertTrue(match);
        cartPage.checkout();


    }
}
