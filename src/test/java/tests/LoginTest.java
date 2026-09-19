// File: src/test/java/tests/LoginTest.java

package tests;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import base.BasePage; // To use its quitDriver method

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver using our BasePage
        BasePage basePage = new BasePage();
        WebDriver driver = basePage.driver;

        // Create an instance of our LoginPage
        LoginPage loginPage = new LoginPage(driver);

        try {
            loginPage.navigateToLoginPage();

            // --- Test Case 1: Valid Login ---
            System.out.println("Trying a valid login...");
            loginPage.login("Admin", "admin123"); // Use the login method
            Thread.sleep(5000); // Wait to see the result
            if (driver.getCurrentUrl().contains("dashboard")) {
                System.out.println("Valid login worked! Current URL: " + driver.getCurrentUrl());
            } else {
                System.out.println("Valid login failed! Current URL: " + driver.getCurrentUrl());
            }

        } finally {
            // Always close the browser
            basePage.quitDriver();
        }
    }
}