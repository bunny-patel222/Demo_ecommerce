package AbstractConstructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AbstractComponent {
    WebDriver driver;

    public AbstractComponent(WebDriver driver) throws FileNotFoundException {
        this.driver = driver;
    }

    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToDisappear(By findBy) throws InterruptedException {

      Thread.sleep(1000);
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    public String LoadData(String DataVariable) throws IOException {
        Properties prop = new Properties();
        //FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "src\\test\\java\\TestComponents\\GlobalData.properties");
        // FileInputStream fis = new FileInputStream("D:\\Automation Practice\\NEW_PRAC\\Demo_2\\src\\test\\java\\TestComponents\\GlobalData.properties");
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/TestComponents/GlobalData.properties");
        prop.load(fis);

        return prop.getProperty(DataVariable);


    }

    public void goToCart() {
        driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
        waitForElementToAppear(By.cssSelector(".cartSection"));
    }
}


