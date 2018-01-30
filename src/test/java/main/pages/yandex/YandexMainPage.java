package main.pages.yandex;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import javax.swing.text.html.HTML;
import java.awt.*;
import java.util.List;

/**
 * Created by Shelk on 1/30/2018.
 */
public class YandexMainPage extends HtmlElement {

    public YandexMainPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    private Robot robot;

    @Name("Поисковая строка")
    @FindBy(xpath = "//input[@id='text']")
    private TextInput search;

    @Name("Найти")
    @FindBy(xpath = "//input[@name='btnK']")
    private Button submit;

    @Name("Ресурсы")
    @FindBy(xpath = "//div[@class='home-tabs stream-control i-bem dropdown-menu home-tabs_js_inited']/a")
    private List<Link> links;

    public void clickOnLink(String linkName) {
        for (Link link : links) {
            if (linkName.equals(link.getText())) {
                link.click();
                return;
            }
        }
        Assert.fail("Не найдено ссылки \"" + linkName + "\"");
    }

//    public void search(String request) {
//        try {
//            robot = new Robot();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//        search.sendKeys(request);
//        robot.keyPress(KeyEvent.VK_ENTER);
//    }

}
