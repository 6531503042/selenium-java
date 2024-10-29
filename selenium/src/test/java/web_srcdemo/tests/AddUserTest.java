//package web_srcdemo.tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import com.maven.testng.DataDriver;
//import com.maven.testng.VerifyLoginTest;
//import com.maven.testng.function.AddUser;
//
//public class AddUserTest extends BaseTest {
//
//    @Test(priority = 1, dataProvider = "userData", dataProviderClass = DataDriver.class)
//    public void addUser(String userRole, String employeeName, String username, String status, String password) {
//        // Click on the Add button to start adding a user
//        driver.findElement(By.id("btnAdd")).click();
//
//        // Select user role from dropdown
//        Select ddlUserRole = new Select(driver.findElement(By.id("systemUser_userType")));
//        ddlUserRole.selectByVisibleText(userRole);
//
//        // Enter employee name and select from autocomplete suggestions
//        driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(employeeName);
//        driver.findElement(By.xpath("//ul/li[@class='ac_even ac_over']")).click(); // Adjust this locator as needed
//
//        // Fill in username
//        driver.findElement(By.id("systemUser_userName")).sendKeys(username);
//
//        // Select user status
//        Select userStatus = new Select(driver.findElement(By.id("systemUser_status")));
//        userStatus.selectByVisibleText(status);
//
//        // Fill in password fields
//        driver.findElement(By.id("systemUser_password")).sendKeys(password);
//        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(password);
//
//        // Click Save button to submit the form
//        driver.findElement(By.id("btnSave")).click();
//
//        // Verify success message
//        String expectedMessage = "Successfully Saved"; // Adjust as necessary
//        Assert.assertEquals(getActualSavedSuccessMessage(), expectedMessage);
//    }
//
//    @Test(priority = 2)
//    public void testAddNewAdminUser() {
//        SoftAssert softAssert = new SoftAssert();
//        VerifyLoginTest login = new VerifyLoginTest();
//        login.verifyLoginWithCorrectCredentials();
//
//        // Navigate to User Management (ensure the method exists)
//        navigateToUserManagement();
//
//        // Use AddUser utility class to add a new user
//        AddUser.clickOnAddButton();
//        AddUser.createUser("Admin", "Alice", "Username113", "Enabled", "Password123");
//
//        // Verify success message
//        softAssert.assertEquals(AddUser.getSaveSuccessMessage(), "Successfully Saved");
//        softAssert.assertAll(); // Ensure all assertions are executed
//    }
//
//    // Optional: Add a teardown method to delete test data if necessary
//}