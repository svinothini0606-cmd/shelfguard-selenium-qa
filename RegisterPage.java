package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By userNameField = By.id("userName");
    private By passwordField = By.id("password");
    private By registerButton = By.id("register");
    private By successMessage = By.xpath("//*[contains(text(),'successfully registered')]");
    private By existingUserError = By.xpath("//p[contains(text(),'User already exists')]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void register(String firstName, String lastName, String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);

        // DemoQA sometimes shows an ad banner overlapping the button — JS click avoids that
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(registerButton));
    }

    public boolean isRegistrationSuccessful() {
        List<org.openqa.selenium.WebElement> success = driver.findElements(successMessage);
        return !success.isEmpty();
    }

    public boolean isUserAlreadyExistsError() {
        List<org.openqa.selenium.WebElement> error = driver.findElements(existingUserError);
        return !error.isEmpty();
    }
}
