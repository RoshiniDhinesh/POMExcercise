// File: src/main/java/pages/LoginPage.java

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class LoginPage {

    private WebDriver driver;

    // These are our locators for elements on the login page
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[@role='alert']"); // For error message if login fails

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // A method to perform the entire login action
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    // A method to get an error message (for checking results)
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}