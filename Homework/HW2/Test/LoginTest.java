package Project7.Test;

import Project7.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String validUsername;
    String validPassword;
    String invalidUsername;
    String invalidPassword ;

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        validUsername = excelReader.getStringData("Sheet2", 1, 0);
        validPassword = excelReader.getStringData("Sheet2", 1,1);
        invalidUsername = excelReader.getStringData("Sheet2", 1, 2);
        invalidPassword = excelReader.getStringData("Sheet2", 1, 3);
    }

    @Test(priority = 10)
    public void userCanLogIn() {
        homePage.clickOnBasicAuth();
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
        homePage.clickOnBasicAuth();
        String URL = "https://" + invalidUsername + ":" + validPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        String expectedURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 30)
    public void userCannotLogInWithInvalidPassword() {
        homePage.clickOnBasicAuth();
        String URL = "https://" + validUsername + ":" + invalidPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        String expectedURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 40)
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        homePage.clickOnBasicAuth();
        String URL = "https://" + invalidUsername + ":" + invalidPassword + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        String expectedURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
    }
}
