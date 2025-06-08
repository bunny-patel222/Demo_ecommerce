package PageObject;

import AbstractConstructor.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.List;

public class AddProductPage extends AbstractComponent {

    public WebDriver driver;
    Actions a;
    public AddProductPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        // Initialize elements with PageFactory
        PageFactory.initElements(driver, this);
        a = new Actions(this.driver);
    }

    // Add your WebElement locators and methods for the Add Product page here

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    By productsBy = By.cssSelector(".mb-3");

    public List<WebElement> getProductList() {

        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String ProductName) throws Exception {
        WebElement prod = getProductList().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
        return prod;

    }

    public void addToCart(String ProductName) throws Exception {
        WebElement prod = getProductByName(ProductName);
        prod.findElement(By.cssSelector(".mb-3 button:last-of-type")).click();
        waitForElementToAppear(By.cssSelector("#toast-container"));
        waitForElementToDisappear(By.cssSelector(".ng-animating"));
    }


    public void getCartProducts(String ProductName) throws Exception {
        waitForElementToAppear(By.cssSelector(".infoWrap h3"));
      String  CartProducts =  driver.findElement(By.cssSelector(".infoWrap h3")).getText();
        System.out.println("Products available" + CartProducts);



    }

    }

