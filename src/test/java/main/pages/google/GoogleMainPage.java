package main.pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GoogleMainPage extends HtmlElement {

    public GoogleMainPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    private Robot robot;

    @Name("Text Input")
    @FindBy(xpath = "//input[@name='q']")
    private TextInput search;

    @Name("Submit")
    @FindBy(xpath = "//input[@name='btnK']")
    private Button submit;

    public void search(String request) {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        search.sendKeys(request);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

}
