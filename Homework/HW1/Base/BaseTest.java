package Project6.Base;

import Project6.Pages.HomePage;
import Project6.Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public HomePage homePage;
    public ProfilePage profilePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);
    }


    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
