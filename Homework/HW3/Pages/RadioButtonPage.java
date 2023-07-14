package Project8.Pages;

import Project8.Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage extends BaseTest {
    public RadioButtonPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "yesRadio")
    public WebElement yesRadioButton;

    @FindBy (id = "impressiveRadio")
    public WebElement impressiveRadioButton;

    @FindBy (id = "noRadio")
    public WebElement noRadioButton;

    @FindBy (xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p")
    public WebElement yesMessage;

    @FindBy (xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p")
    public WebElement impressiveMessage;

    public void clickYesRadioButton(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }
}
