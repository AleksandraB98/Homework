package Project7.Base;

import Project7.Pages.HomePage;
import Project7.Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public HomePage homePage;
    public ProfilePage profilePage;

    public ExcelReader excelReader;

    public String homeurl;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);
        excelReader = new ExcelReader("src\\test\\java\\Project7\\Book7.xlsx");
        homeurl = excelReader.getStringData("Sheet1", 1, 0);
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
