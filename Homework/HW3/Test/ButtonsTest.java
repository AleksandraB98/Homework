package Project8.Test;

import Project8.Base.BaseTest;
import Project8.Pages.ButtonsPage;
import Project8.Pages.ElementsPage;
import Project8.Pages.HomePage;
import Project8.Pages.RadioButtonPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {
    String expectedMessage;
    public HomePage homepagePage;
    public ElementsPage elementsPage;
    public ButtonsPage buttonsPage;
    public RadioButtonPage radioButtonPage;
    JavascriptExecutor js;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomePage();
        elementsPage = new ElementsPage();
        buttonsPage = new ButtonsPage();
        radioButtonPage = new RadioButtonPage();
        driver.manage().window().maximize();
        driver.get(homeURL);
       js = (JavascriptExecutor) driver;
    }

    @Test(priority = 10)
    public void doubleClickButtonTest() throws InterruptedException {
        homepagePage.clickOnElements();
        Thread.sleep(2500);
        js.executeScript("window.scrollBy(0,250)", "");
        elementsPage.clickOnButtonsMenuItem();
        buttonsPage.setMargin(buttonsPage.doubleClickButton);
        Thread.sleep(2000);
        buttonsPage.doubleClick();

        expectedMessage = "You have done a double click";
        wait.until(ExpectedConditions.visibilityOf(buttonsPage.doubleClickMessage));
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(), expectedMessage);
    }

    @Test (priority = 20)
    public void rightClickButtonTest() throws InterruptedException {
        homepagePage.clickOnElements();
        js.executeScript("window.scrollBy(0,250)", "");
        elementsPage.clickOnButtonsMenuItem();
        Thread.sleep(2500);
        buttonsPage.rightClick();
        expectedMessage = "You have done a right click";
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), expectedMessage);
    }

    @Test (priority = 30)
    public void clickMeButtonTest() {
        homepagePage.clickOnElements();
        js.executeScript("window.scrollBy(0,250)", "");
        elementsPage.clickOnButtonsMenuItem();
        buttonsPage.clickMe();
        expectedMessage = "You have done a dynamic click";
        Assert.assertEquals(buttonsPage.clickMeMessage.getText(), expectedMessage);
    }

    @Test (priority = 40)
    public void clickOnYesRadioButton() throws InterruptedException{
        homepagePage.clickOnElements();
        js.executeScript("window.scrollBy(0,250)", "");
        elementsPage.clickOnRadioButtonMenuItem();
        radioButtonPage.clickYesRadioButton(radioButtonPage.yesRadioButton);

        expectedMessage = "You have selected Yes";
        Assert.assertEquals(radioButtonPage.yesMessage.getText(), expectedMessage);
    }

    @Test (priority = 50)
    public void clickOnImpressiveRadioButton() {
        homepagePage.clickOnElements();
        elementsPage.clickOnRadioButtonMenuItem();
        radioButtonPage.clickYesRadioButton(radioButtonPage.impressiveRadioButton);

        expectedMessage = "You have selected Impressive";
        Assert.assertEquals(radioButtonPage.yesMessage.getText(), expectedMessage);
    }

    @Test (priority = 60)
    public void isNoRadioButtonDisabled() {
        homepagePage.clickOnElements();
        elementsPage.clickOnRadioButtonMenuItem();

        Assert.assertFalse(radioButtonPage.noRadioButton.isEnabled());
    }

}
