package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

    //Delcare WebElement
    public By txtUserName = By.xpath("//input[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'username']");
    public By txtPassword = By.xpath("//input[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'password']");
    public By btnSignIn = By.xpath("//input[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'login']");

    public void Login(String userName, String password){
        System.out.println("Log in with username: '" + userName + "' and password: '" + password + "'");
        driver.findElement(txtUserName).sendKeys(userName);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnSignIn).click();
    }
}
