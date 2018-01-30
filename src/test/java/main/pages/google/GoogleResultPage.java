package main.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;

/**
 * Created by Shelk on 1/30/2018.
 */
public class GoogleResultPage extends HtmlElement {

    public GoogleResultPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    @Name("Заголовок")
    @FindBy(xpath = "//h2[normalize-space(text())='Результаты поиска']")
    private WebElement title;

    @Name("Результаты поиска")
    @FindBy(xpath = "//div[@class='rc']")
    private List<WebElement> results;

    public void chooseLink(String url) {
        title.isDisplayed();
        for (WebElement element : results) {
            WebElement link = element.findElement(By.xpath("./h3/a"));
            WebElement resultUrl = element.findElement(By.xpath("./div[@class='s']//cite"));
            if (url.equals(resultUrl.getText())) {
                link.click();
            }
            return;
        }
    }
}
