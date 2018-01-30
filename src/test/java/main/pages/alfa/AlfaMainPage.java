package main.pages.alfa;

import main.Initializer;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;

/**
 * Created by Shelk on 1/30/2018.
 */
public class AlfaMainPage extends HtmlElement {

    public AlfaMainPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    @Name("Заголовок")
    @FindBy(xpath = "//div[@class='header header_type_home header_initially-hidden header_transition_fix header_visible']")
    private WebElement header;

    @Name("Футер")
    @FindBy(xpath = "//div[@class='footer__navigation']//a")
    private List<Link> footerLinks;

    public void chooseFooterLink(String value) {
        for (Link link : footerLinks) {
            System.out.println(link.getText());
            if (value.equals(link.getText())) {
                link.click();
                return;
            }
        }
        Assert.fail("Не найдено ссылки \"" + value + "\"");
    }

}
