package web_srcdemo.tests;

import automation.enums.Browsers;
import automation.selenium.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web_srcdemo.config.EnvironmentVariables;
import web_srcdemo.pages.LoginPage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    private Browsers browser = Browsers.CHROME;
    private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private String expectedDashboardUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    @BeforeMethod
    public void setup() {
        // Launch the browser and navigate to the login page
        driver = BrowserFactory.launch(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvironmentVariables.WAIT_IMPLICIT));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void testLoginWithValidCredentials() {
        // Create an instance of the LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // Perform login with valid credentials
        loginPage.login("Admin", "admin123"); // Use valid credentials

        // Verify the URL to check if the login was successful
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedDashboardUrl, "User should be redirected to the dashboard after a successful login.");
    }
}
