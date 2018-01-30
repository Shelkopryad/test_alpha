package main.pages.alfa;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by Shelk on 1/30/2018.
 */
public class JobAlfaPage extends HtmlElement {

    public JobAlfaPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }


}
