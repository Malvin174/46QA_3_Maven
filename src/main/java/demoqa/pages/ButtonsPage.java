package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;

    public ButtonsPage doubleClick() {
        new Actions(driver).doubleClick(doubleClickBtn).perform();
        return this;
    }
@FindBy(id = "doubleClickMessage")
WebElement doubleClickMessage;

    public ButtonsPage verifyDoubleClickMessage(String textToFind) {
       shouldHaveText(doubleClickMessage, textToFind,2000);
        assert  doubleClickMessage.getText().equalsIgnoreCase(textToFind);
        return this;
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    public ButtonsPage rightClickButton() throws InterruptedException {
        Thread.sleep(3000);
        scrollTo(300);
        new Actions(driver).contextClick(rightClickBtn).perform();
        return this;
    }

    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    public ButtonsPage verifyRightClickMessage(String textToFind) {
        assert rightClickMessage.getText().equalsIgnoreCase(textToFind);
        return this;
    }
    @FindBy(xpath = "//button[.='Click Me']")
    WebElement clickButtonDynamic;

    public ButtonsPage dynamicClickButton() {
        click(clickButtonDynamic);
        return this;
    }

    @FindBy(id = "dynamicClickMessage")
    WebElement dynamicClickMessage;

    public ButtonsPage verifyDynamicClickMessage(String textToFind) {
        assert dynamicClickMessage.getText().equalsIgnoreCase(textToFind);
        return this;
    }
}