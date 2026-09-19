// File: src/main/java/pages/LoginPageFactory.java

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

public class LoginPageFactory {

    private WebDriver driver;

    // Using @FindBy to find elements easily
    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']") // For error message if login fails
    WebElement errorMessage;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        // Initialize WebElements declared with @FindBy annotations
        // PageFactory initializes these elements.
        // Lazy loading means these elements are not found on the page until they are actually used.
        PageFactory.initElements(driver, this);
        System.out.println("LoginPageFactory set up.");
    }

    public void navigateToLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void enterUsername(String username) {
        System.out.println("Trying to enter username. 'usernameField' will be found now if it hasn't been already.");
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        System.out.println("Trying to enter password. 'passwordField' will be found now if it hasn't been already.");
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        System.out.println("Trying to click login button. 'loginButton' will be found now if it hasn't been already.");
        loginButton.click();
    }

    // Method to perform the login action
    public void login(String username, String password) throws InterruptedException {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        Thread.sleep(2000);
    }

    // Method to get error message (for checking results)
    public String getErrorMessage() {
        System.out.println("Trying to get error message. 'errorMessage' will be found now if it hasn't been already.");
        return errorMessage.getText();
    }
}