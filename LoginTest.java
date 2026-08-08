package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginTest extends BaseTest {

    @Test
    public void testInvalidLoginShowsError() {
        driver.get("https://demoqa.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nonexistent_user_xyz", "wrongPassword123");

        Assert.assertTrue(loginPage.isLoginErrorDisplayed(), "Expected invalid login error message");
    }

    @Test
    public void testDuplicateRegistrationShowsError() {
        String username = "dupuser" + System.currentTimeMillis();
        String password = "Test@1234";

        driver.get("https://demoqa.com/register");
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.register("Aswin", "Raj", username, password);
        Assert.assertTrue(registerPage.isRegistrationSuccessful(), "First registration should succeed");

        driver.get("https://demoqa.com/register");
        registerPage.register("Aswin", "Raj", username, password);
        Assert.assertTrue(registerPage.isUserAlreadyExistsError(),
                "Expected 'User already exists' error on duplicate registration");
    }
}
