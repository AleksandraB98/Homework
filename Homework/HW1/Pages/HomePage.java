package Project6.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver;

    WebElement basicAuthLink;

    public WebElement getBasicAuthLink() {
        return driver.findElement(By.linkText("Basic Auth"));
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnBaseAuth() {
        getBasicAuthLink().click();
    }
}
