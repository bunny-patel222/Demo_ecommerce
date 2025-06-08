package PageObject;

import AbstractConstructor.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class LoginPage extends AbstractComponent {

    WebDriver driver;
    //public WebDriver driver;

    public LoginPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        // Initialize elements with PageFactory
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "input[formcontrolname='userEmail']")
    WebElement userEmail;

    @FindBy(css = "input[formcontrolname='userPassword']")
    WebElement password;

    @FindBy(id = "login")
    WebElement submitLogin;

    public void loginIn(String Email, String Password) {

        userEmail.sendKeys(Email);
        password.sendKeys(Password);
        submitLogin.click();


        //changes for testing branch

    }

}
