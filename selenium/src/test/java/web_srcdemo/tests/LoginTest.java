//package web_srcdemo.tests;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import org.openqa.selenium.By;
//import web_srcdemo.pages.LoginPage;
//
//public class LoginTest extends BaseTest {
//
//    @Test(priority = 1)
//    public void testValidLogin() {
//        // Navigate to the login page
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Replace with your actual login URL
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        // Verify that we are on the login page
//        Assert.assertTrue(loginPage.isAt(), "Login page should be displayed.");
//
//        // Perform login with valid credentials
//        loginPage.login("validUsername", "validPassword"); // Replace with valid username and password
//
//        // Check for successful login (replace this with a relevant check for your app)
//        boolean isLoggedIn = driver.findElement(By.id("welcome")).isDisplayed(); // Replace with actual element on the homepage
//        Assert.assertTrue(isLoggedIn, "User should be logged in successfully.");
//    }
//}
