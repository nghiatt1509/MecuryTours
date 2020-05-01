package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    Properties prop = new Properties();;
    WebDriverWait wait;
    DriverHelper driverHelper = new DriverHelper();

    public BasePage(){
        try {
            prop.load(new FileInputStream("src/main/resources/config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebDriver setUpEnvironment(){
        String strBrowserName = prop.getProperty("browserName").toLowerCase();

        if (strBrowserName.toString().equals("firefox"))
            this.driver = driverHelper.setupFirefoxDriver();

        wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        return driver;
    }

   //Get Url from config file
    public String getMercuryTourUrl() {
        return prop.getProperty("productionUrl");
    }

    //Navigate to Mercury Tours Home Page
    public void navigateToMercuryToursHome(){
        driver.navigate().to(getMercuryTourUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    //Close Browser
    public void quitPage(){
        driver.quit();
    }

    //get Page Title
    public String getPageTitle(){
        return driver.getTitle();
    }
}
