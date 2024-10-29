// AdminPage.java
package web_srcdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Updated locators
    private By sidebarAdminMenu = By.xpath("//span[text()='Admin']");
    private By btnAddUser = By.xpath("//button[contains(text(), 'Add')]");
    private By dropdownUserRole = By.xpath("//label[text()='User Role']/following-sibling::div//div[contains(@class, 'oxd-select-text')]");
    private By dropdownStatus = By.xpath("//label[text()='Status']/following-sibling::div//div[contains(@class, 'oxd-select-text')]");
    private By txtEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private By txtUsername = By.xpath("//label[text()='Username']/following-sibling::div//input");
    private By txtPassword = By.xpath("//label[text()='Password']/following-sibling::div//input");
    private By txtConfirmPassword = By.xpath("//label[text()='Confirm Password']/following-sibling::div//input");
    private By btnSave = By.xpath("//button[contains(text(), 'Save')]");

    // Constructor
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set a 10-second wait
    }

    // Navigate to the Admin sidebar menu
    public void navigateToAdminMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(sidebarAdminMenu)).click();
    }

    // Click the Add User button
    public void clickAddUser() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAddUser)).click();
    }

    // Select an option from a dropdown based on visible text
    private void selectDropdownOption(By dropdown, String optionText) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + optionText + "']")));
        option.click();
    }

    // Method to add a new user
    public void addUser(String role, String employeeName, String username, String status, String password) {
        // Select User Role from dropdown
        selectDropdownOption(dropdownUserRole, role);

        // Enter Employee Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtEmployeeName)).sendKeys(employeeName);

        // Enter Username
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsername)).sendKeys(username);

        // Select Status from dropdown
        selectDropdownOption(dropdownStatus, status);

        // Enter Password and Confirm Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtConfirmPassword)).sendKeys(password);

        // Click Save button to add user
        wait.until(ExpectedConditions.elementToBeClickable(btnSave)).click();
    }
}
