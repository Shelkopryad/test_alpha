package main.pages.alfa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Shelk on 1/30/2018.
 */
public class AlfaMainPage extends HtmlElement {

    private Robot robot;

    @Name("Text Input")
    @FindBy(xpath = "//input[@name='q']")
    private TextInput search;

    @Name("Submit")
    @FindBy(xpath = "//input[@name='btnK']")
    private ru.yandex.qatools.htmlelements.element.Button submit;

    public AlfaMainPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

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
