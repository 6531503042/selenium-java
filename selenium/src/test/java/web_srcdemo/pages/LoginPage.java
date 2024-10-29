package web_srcdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final String ERR_LOCKED = "Sorry, this account is locked. Please contact your administrator.";

    By txtUsername = By.name("username");
    By txtPassword = By.name("password");
    By btnLogin = By.xpath("//button[@type='submit']");
    By lblErrorMessage = By.className("error-message-container");

    //Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return driver.findElement(txtUsername).isDisplayed();
    }

    public boolean isUserLocked() {
        String error = driver.findElement(lblErrorMessage).getText();
        return error.equals(ERR_LOCKED);
    }

    public void login(String username, String password) {
        driver.findElement(txtUsername).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
    }
}
