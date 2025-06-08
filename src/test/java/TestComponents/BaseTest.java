package TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public String URL;
    public String browserName;
    public String ProductName;

    public WebDriver IntDriver() throws IOException {


//        Properties prop = new Properties();
//        //FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "src\\test\\java\\TestComponents\\GlobalData.properties");
//       // FileInputStream fis = new FileInputStream("D:\\Automation Practice\\NEW_PRAC\\Demo_2\\src\\test\\java\\TestComponents\\GlobalData.properties");
//        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/TestComponents/GlobalData.properties");
//        prop.load(fis);
//
//         browserName = prop.getProperty("browser");
//         URL = prop.getProperty("website");
       LoadData();

        if (browserName.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;


    }

    public void launchApp() throws IOException {
        LoadData();
        driver = IntDriver();
        driver.get(URL);
        //driver.get("https://rahulshettyacademy.com/client/");
        System.out.println(browserName);


    }
    public void LoadData() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/TestComponents/GlobalData.properties");
        prop.load(fis);
        browserName = prop.getProperty("browser");
        URL = prop.getProperty("website");
        ProductName = prop.getProperty("ProductName");
    }
}
