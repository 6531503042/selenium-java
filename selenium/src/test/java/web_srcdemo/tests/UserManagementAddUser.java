//package web_srcdemo.tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import web_srcdemo.pages.UserManagementPage;
//
//
//public class UserManagementAddUser extends BaseTest {
//
//    @DataProvider(name = "userData")
//    public Object[][] userData() {
//        return new Object[][] {
//                {"Admin", "Ranga Akunuri", "username1", "Enabled", "Password123"},
//                {"User", "Kunal Vivek Tasare", "username2", "Disabled", "Password123"}
//                // Add more test data as needed
//        };
//    }
//
//    @Test(priority = 1, dataProvider = "userData")
//    public void addUser(String userRole, String employeeName, String username, String status, String password) {
//        // Navigate to the User Management page
//        UserManagementPage userManagementPage = new UserManagementPage(driver);
//        userManagementPage.navigateTo("your/application/url"); // Replace with actual URL
//
//        // Click the Add button
//        userManagementPage.clickAddButton();
//
//        // Select user role
//        Select ddlUserRole = new Select(driver.findElement(By.id("systemUser_userType")));
//        ddlUserRole.selectByVisibleText(userRole);
//
//        // Enter employee name and select from hints
//        driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(employeeName);
//        driver.findElement(By.xpath("//*///ul/li[@class='ac_even ac_over']")).click(); // Select from hints
//
//        // Fill in the remaining user details
//        driver.findElement(By.id("systemUser_userName")).sendKeys(username);
//
//        // Select user status
//        Select userStatus = new Select(driver.findElement(By.id("systemUser_status")));
//        userStatus.selectByVisibleText(status);
//
//        // Set password
//        driver.findElement(By.id("systemUser_password")).sendKeys(password);
//        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(password);
//
//        // Save the user
//        driver.findElement(By.id("btnSave")).click();
//
//        // Verify the success message
//        String expectedMessage = "Successfully Saved"; // Adjust this message as necessary
//        String actualMessage = userManagementPage.getSuccessMessage(); // You should have a method to get this
//        Assert.assertEquals(actualMessage, expectedMessage);
//    }
//
//    // Additional test methods can be added here if necessary
//}