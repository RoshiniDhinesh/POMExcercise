// File: src/main/java/base/BasePage.java

package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;

    public BasePage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}