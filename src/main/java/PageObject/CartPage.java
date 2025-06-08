package PageObject;

import AbstractConstructor.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    public CartPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
    }


    public boolean VerifyProductDispay(String ProductName) throws Exception {
        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".infoWrap h3"));
        boolean Match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(ProductName));
        return Match;
    }

    public void checkout() throws Exception {
        Actions a = new Actions(driver);
        driver.findElement(By.cssSelector(".totalRow .btn")).click();
        a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "Indi").build().perform();
        waitForElementToAppear(By.cssSelector(".ta-item"));
        driver.findElement(By.xpath("//button[contains(@class, 'ta-item')][2]")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();
        String orderSuccess = driver.findElement(By.cssSelector(".hero-primary")).getText().toLowerCase();

        return;
        // Assert.assertTrue(orderSuccess.equalsIgnoreCase("Thankyou for the order."));
    }
}
