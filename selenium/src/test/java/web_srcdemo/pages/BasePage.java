package web_srcdemo.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Common methods for all pages can go here
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Add other common methods as needed
}
