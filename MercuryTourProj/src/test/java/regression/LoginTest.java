package regression;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest {

    LoginPage loginPage = new LoginPage();

    @BeforeTest
    public void Setup(){
        loginPage.setUpEnvironment();
    }

    @Test
    public void VerifyUserCanLogIntoMercuryTours() {
        loginPage.navigateToMercuryToursHome();
        loginPage.Login("shopeetest", "Shopee@2020");
        Assert.assertEquals(loginPage.getPageTitle(), "Find a Flight: Mercury Tours:");
    }

    @AfterTest
    public void cleanUp(){
        loginPage.quitPage();
    }
}
