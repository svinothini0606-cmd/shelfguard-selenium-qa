package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By userNameField = By.id("userName");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login");
    private By loginError = By.id("name");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoginErrorDisplayed() {
        List<org.openqa.selenium.WebElement> error = driver.findElements(loginError);
        return !error.isEmpty() && error.get(0).getText().toLowerCase().contains("invalid");
    }
}
