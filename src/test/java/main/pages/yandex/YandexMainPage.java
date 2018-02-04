package main.pages.yandex;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;

/**
 * Created by Shelk on 1/30/2018.
 */

public class YandexMainPage extends HtmlElement {

    public YandexMainPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    @Name("Поисковая строка")
    @FindBy(xpath = "//input[@id='text']")
    private TextInput search;

    @Name("Найти")
    @FindBy(xpath = "//input[@name='btnK']")
    private Button submit;

    @Name("Ресурсы")
    @FindBy(xpath = "//div[@class='home-tabs stream-control i-bem dropdown-menu home-tabs_js_inited']/a")
    private List<Link> links;

    @Step("Клик по ссылке \"{0}\"")
    public void clickOnLink(String linkName) {
        for (Link link : links) {
            if (linkName.equals(link.getText())) {
                link.click();
                return;
            }
        }
        Assert.fail("Не найдено ссылки \"" + linkName + "\"");
    }

}
