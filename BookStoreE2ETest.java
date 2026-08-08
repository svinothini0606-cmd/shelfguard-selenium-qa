package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

/**
 * ShelfGuard — End-to-End Flow: Register -> Login -> Search Book -> Add to Collection -> Profile (confirmation)
 */
public class BookStoreE2ETest extends BaseTest {

    @Test
    public void testEndToEndRegisterLoginAddBookToCollection() {
        String username = "qauser" + System.currentTimeMillis();
        String password = "Test@1234";

        driver.get("https://demoqa.com/register");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Aswin", "Raj", username, password);
        Assert.assertTrue(registerPage.isRegistrationSuccessful(), "Registration was not successful");

        driver.get("https://demoqa.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        BookStorePage bookStorePage = new BookStorePage(driver);
        bookStorePage.navigateToBookStore();
        bookStorePage.searchBook("Git");
        Assert.assertTrue(bookStorePage.isBookResultDisplayed(), "No book results displayed for search");

        String bookTitle = bookStorePage.openFirstBook();
        bookStorePage.addBookToCollection();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.navigateToProfile();
        Assert.assertTrue(profilePage.isBookInCollection(bookTitle),
                "Added book was not found in user's collection on Profile page");
    }
}
