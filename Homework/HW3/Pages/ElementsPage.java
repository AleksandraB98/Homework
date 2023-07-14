package Project8.Pages;

import Project8.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BaseTest {
    public ElementsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[3]")
    public WebElement radioButtonMenuItem;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[5]")
    public WebElement buttonsMenuItem;

    public void clickOnRadioButtonMenuItem() {
        radioButtonMenuItem.click();
    }

    public void clickOnButtonsMenuItem() {
        buttonsMenuItem.click();
    }
}
