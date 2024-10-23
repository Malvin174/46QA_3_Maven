package demoqa.pages;

import demoqa.core.BasePage;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;


public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submitButton;


    public TextBoxPage enterPersonalData(String fullName, String email, String currentAddress) {
        type(userName, fullName);
        type(userEmail, email);
        type(this.currentAddress, currentAddress);
        return this;
    }

    /*public TextBoxPage keyboardEvent() {
        try {
            // Копируем текст из поля "Current Address"
            click(currentAddress);
            Robot robot = new Robot();
            //robot.select(currentAddress);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Вставляем текст в поле "Permanent Address"
            click(permanentAddress);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Нажимаем кнопку Submit
            submitButton.click();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return this;
    }*/
    public TextBoxPage keyboardEvent() throws AWTException {
        Robot robot = new Robot();
        click(currentAddress);
        //Ctrl + A
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //Ctrl + C
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //Tab
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        //Ctrl + V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //Tab
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        //Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        return this;
    }

    @FindBy(css = "p#currentAddress")
    WebElement currentAddressResult;

    @FindBy(css = "p#permanentAddress")
    WebElement permanentAddressResult;

    public TextBoxPage verifyCopyPasteAddress2(){

        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");
        System.out.println();
        Assert.assertEquals(current[1], permanent[1]);
        return this;
    }

    public TextBoxPage verifyCopyPasteAddress() {
        String currentAddressValue = currentAddress.getAttribute("value");
        String permanentAddressValue = permanentAddress.getAttribute("value");
        assert currentAddressValue.equals(permanentAddressValue) : "Addresses do not match!";
        return this;
    }

}

