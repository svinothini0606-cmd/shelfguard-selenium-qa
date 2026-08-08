package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookStorePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchBox = By.id("searchBox");
    private By bookRows = By.cssSelector(".rt-tbody .rt-tr-group");
    private By firstBookTitleLink = By.cssSelector(".rt-tbody .rt-tr-group:first-child a");
    private By addToCollectionButton = By.xpath("//button[contains(text(),'Add To Your Collection')]");

    public BookStorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToBookStore() {
        driver.get("https://demoqa.com/books");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
    }

    public void searchBook(String keyword) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(keyword);
    }

    public boolean isBookResultDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookRows));
        return driver.findElements(bookRows).size() > 0;
    }

    public String openFirstBook() {
        wait.until(ExpectedConditions.elementToBeClickable(firstBookTitleLink));
        String bookTitle = driver.findElement(firstBookTitleLink).getText();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(firstBookTitleLink));
        return bookTitle;
    }

    public void addBookToCollection() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCollectionButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(addToCollectionButton));
    }
}
