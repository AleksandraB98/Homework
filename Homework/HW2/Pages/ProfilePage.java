package Project7.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    WebDriver driver;
    WebElement title;
    WebElement message;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getMessage() {
        return driver.findElement(By.tagName("p"));
    }
    public WebElement getTitle() {
        return driver.findElement(By.tagName("h3"));
    }

    public String getTitleText() {
        return getTitle().getText();
    }

    public String getMessageText() {
        return getMessage().getText();
    }
}
