package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By bookRowsInProfile = By.cssSelector(".rt-tbody .rt-tr-group");
    private By bookTitleCells = By.cssSelector(".rt-tbody .rt-tr-group a");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToProfile() {
        driver.get("https://demoqa.com/profile");
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookRowsInProfile));
    }

    public boolean isBookInCollection(String bookTitle) {
        List<org.openqa.selenium.WebElement> titles = driver.findElements(bookTitleCells);
        for (org.openqa.selenium.WebElement title : titles) {
            if (title.getText().trim().equalsIgnoreCase(bookTitle.trim())) {
                return true;
            }
        }
        return false;
    }
}
