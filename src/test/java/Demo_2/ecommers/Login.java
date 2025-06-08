package Demo_2.ecommers;

import PageObject.LoginPage;
import TestComponents.BaseTest;
//import junit.framework.Assert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login extends BaseTest {

    @Test
    public void LoginTest() throws IOException {



          launchApp();


        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginIn("testng17@gmail.com","Test@123");

        String title = driver.getTitle();


        Assert.assertEquals(title, "Let's Shop", "Title does not match");
        System.out.println(title);
        driver.quit();

    }


}
