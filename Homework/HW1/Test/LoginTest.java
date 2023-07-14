package Project6.Test;

import Project6.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String validUsername = "admin";
    String validPassword = "admin";
    String invalidUsername = "user";
    String invalidPassword = "pass";

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 10)
    public void userCanLogIn() {
        homePage.clickOnBaseAuth();
        String URL = "https://" + validUsername + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        String expectedURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        String expectedTitle = "Basic Auth";
        Assert.assertEquals(profilePage.getTitleText(), expectedTitle);

        String expectedMessage = "Congratulations! You must have the proper credentials.";
        Assert.assertEquals(profilePage.getMessageText(), expectedMessage);
    }

    @Test (priority = 20)
    public void userCannotLogInWithInvalidUsername() {
        homePage.clickOnBaseAuth();
        String URL = "https://" + invalidUsername + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        String expectedURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 30)
    public void userCannotLogInWithInvalidPassword() {
        homePage.clickOnBaseAuth();
        String URL = "https://" + validUsername + ":" + invalidPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        String expectedURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 40)
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        homePage.clickOnBaseAuth();
        String URL = "https://" + invalidUsername + ":" + invalidPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        String expectedURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
    }
}
