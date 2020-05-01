package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DriverHelper {

    private static WebDriver driver = null;
    // The Gecko Driver locations under the resource folder
    private static String MAC_GECKO_DRIVER = "src/main/java/drivers/geckodriver";
    private static String WINDOWS_GECKO_DRIVER = "src/main/java/drivers/geckodriver.exe";

    public WebDriver setupFirefoxDriver() {
        // OS type
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.gecko.driver", MAC_GECKO_DRIVER);

            // Now checking for existence of Chrome executable.'
            if (!new File("/Applications/Firefox.app/Contents/MacOS/Firefox").exists()) {
                throw new RuntimeException("Cannot find Gecko Driver file. Please download and copy to drivers folder in current project");
            }
        } else {
            // Make sure Firefox is installed on the default location on your machine.
            System.setProperty("webdriver.gecko.driver", WINDOWS_GECKO_DRIVER);
        }

        driver = new FirefoxDriver();
        return driver;
    }
}
