package main.pages.yandex;

import main.Constants;
import main.core.Initializer;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


/**
 * Created by Shelk on 1/30/2018.
 */
public class ProductPage extends HtmlElement {

    public ProductPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    @Name("Название товара")
    @FindBy(xpath = "//h1[@class='title title_size_28 title_bold_yes']")
    private WebElement title;

    public void checkProductTitle() {
        Assert.assertEquals("Не соответствует название родукта", Initializer.getStash(Constants.PRODUCT_NAME), title.getText());
    }
}
