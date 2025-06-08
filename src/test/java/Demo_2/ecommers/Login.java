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

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://rahulshettyacademy.com/client");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();

          launchApp();

        // driver.findElement(By.className("btn-primary")).click();
//        driver.findElement(By.cssSelector("input[formcontrolname='userEmail']")).sendKeys("testng17@gmail.com");
//        driver.findElement(By.cssSelector("input[formcontrolname='userPassword']")).sendKeys("Test@123");
//        driver.findElement(By.id("login")).click();
//
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginIn("testng17@gmail.com","Test@123");

        String title = driver.getTitle();


        Assert.assertEquals(title, "Let's Shop", "Title does not match");
        System.out.println(title);
        driver.quit();

    }


}
