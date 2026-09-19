// File: src/test/java/tests/LoginTestPageFactory.java

package tests;

import org.openqa.selenium.WebDriver;
import pages.LoginPageFactory; // Use the Page Factory version
import base.BasePage;

public class LoginTestPageFactory {

    public static void main(String[] args) throws InterruptedException {
        BasePage basePage = new BasePage();
        WebDriver driver = basePage.driver;

        // Create an instance of our LoginPageFactory
        LoginPageFactory loginPage = new LoginPageFactory(driver);

        try {
            loginPage.navigateToLoginPage();

            // --- Test Case 1: Valid Login ---
            System.out.println("\n--- Running Valid Login Test (Page Factory) ---");
            loginPage.login("Admin", "admin123");
            Thread.sleep(3000); // Wait to see the result
            if (driver.getCurrentUrl().contains("dashboard")) {
                System.out.println("Valid login worked! Current URL: " + driver.getCurrentUrl());
            } else {
                System.out.println("Valid login failed! Current URL: " + driver.getCurrentUrl());
            }

        } finally {
            basePage.quitDriver();
        }
    }
}