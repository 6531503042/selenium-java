package web_srcdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UserManagementPage extends BasePage {

    public UserManagementPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddButton() {
        driver.findElement(By.id("btnAdd")).click();
    }

    public void enterEmployeeName(String employeeName) {
        driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(employeeName);
        driver.findElement(By.xpath("//ul/li[@class='ac_even ac_over']")).click(); // Adjust this as needed
    }

    public void selectUserRole(String userRole) {
        Select ddlUserRole = new Select(driver.findElement(By.id("systemUser_userType")));
        ddlUserRole.selectByVisibleText(userRole);
    }

    public void fillUserDetails(String username, String status, String password) {
        driver.findElement(By.id("systemUser_userName")).sendKeys(username);
        Select userStatus = new Select(driver.findElement(By.id("systemUser_status")));
        userStatus.selectByVisibleText(status);
        driver.findElement(By.id("systemUser_password")).sendKeys(password);
        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(password);
    }

    public void clickSaveButton() {
        driver.findElement(By.id("btnSave")).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(By.id("successMessage")).getText(); // Adjust as needed
    }
}