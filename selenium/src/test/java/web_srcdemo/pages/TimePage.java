// TimePage.java
package web_srcdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TimePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By sidebarTimeMenu = By.xpath("//span[text()='Time']");
    private By txtEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private By employeeHint = By.xpath("//div[contains(@class, 'oxd-autocomplete-option')]"); // Adjust class if needed
    private By btnView = By.xpath("//button[contains(text(), 'View')]");
    private By timesheetViewButton = By.xpath("//tr[1]//td[last()]//button[text()='View']");
    private By btnCreateTimesheet = By.xpath("//button[contains(text(), 'Create Timesheet')]");

    // Constructor
    public TimePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set a 10-second wait
    }

    // Navigate to the Time sidebar menu
    public void navigateToTimeMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(sidebarTimeMenu)).click();
    }

    // Enter partial Employee Name, select hint from dropdown, and click View
    public void selectEmployeeHintAndViewTimesheet(String partialEmployeeName) {
        // Type partial Employee Name
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(txtEmployeeName));
        nameField.sendKeys(partialEmployeeName);

        // Wait for the hint dropdown to appear and click the first hint
        WebElement hintOption = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeHint));
        hintOption.click();

        // Click the View button to search timesheets for the selected employee
        wait.until(ExpectedConditions.elementToBeClickable(btnView)).click();

        // Click the first 'View' button in the timesheet results list
        wait.until(ExpectedConditions.elementToBeClickable(timesheetViewButton)).click();
    }

    // Click Create Timesheet if it exists on the timesheet page
    public void createTimesheetIfAvailable() {
        wait.until(ExpectedConditions.elementToBeClickable(btnCreateTimesheet)).click();
    }
}
