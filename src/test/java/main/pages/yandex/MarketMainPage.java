package main.pages.yandex;

import main.Constants;
import main.Initializer;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;

/**
 * Created by Shelk on 1/30/2018.
 */
public class MarketMainPage extends HtmlElement {

    public MarketMainPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    @Name("Категории товаров")
    @FindBy(xpath = "//ul[@class='topmenu__list']//a")
    private List<Link> menuLinks;

    @Name("Категории левое меню")
    @FindBy(xpath = "//div[@class='layout-grid__col layout-grid__col_width_2']//div[@class='catalog-menu__list']/a")
    private List<Link> leftMenuLinks;

    @Name("Фильтр")
    @FindBy(xpath = "//div[contains(@class,'exp-filters-new-design')]//label")
    private List<Link> filterValues;

    @Name("Минимальная сумма")
    @FindBy(xpath = "//input[@name='glf-pricefrom-var']")
    private TextInput minAmount;

    @Name("Максимальная сумма")
    @FindBy(xpath = "//input[@name='glf-priceto-var']")
    private TextInput maxAmount;

    @Name("Выборка товаров")
    @FindBy(xpath = "//div[@class='n-snippet-cell2__header']/div[@class='n-snippet-cell2__title']/a")
    private List<Link> resultsProducts;

    public void clickOn(String where, String linkName) {
        List<Link> list = null;
        switch (where) {
            case "from categories":
                list = menuLinks;
                break;
            case "from left menu":
                list = leftMenuLinks;
                break;
            default:
                Assert.fail("Неверное значение в feature \"" + where + "\"");
        }
        for (Link link : list) {
            if (linkName.equals(link.getText())) {
                link.click();
                return;
            }
        }
        Assert.fail("Не найдено ссылки \"" + linkName + "\"");
    }

    public void setFilter(String value) {
        for (Link link : filterValues) {
            if (value.equals(link.getText())) {
                link.click();
                return;
            }
        }
        Assert.fail("Не найдено строки фильтра \"" + value + "\"");
    }

    public void setAmount(String field, String amount) {
        TextInput input = null;
        switch (field) {
            case "min":
                input = minAmount;
                break;
            case "max":
                input = maxAmount;
                break;
            default:
                Assert.fail("Не найдено поля \"" + field + "\"");
        }
        input.sendKeys(amount);
    }

    public void chooseFirstProductAndSaveName() {
        Initializer.setSTASH(Constants.PRODUCT_NAME, resultsProducts.get(0).getText());
        resultsProducts.get(0).click();
    }

}
