package main.steps.alfa;

import cucumber.api.java.en.When;
import main.Initializer;
import main.pages.alfa.AlfaMainPage;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by Shelk on 1/30/2018.
 */
public class AlfaMainPageSteps extends HtmlElement {

    private WebDriver driver = Initializer.getDriver();
    private AlfaMainPage alfaMainPage = new AlfaMainPage(driver);

    @When("user choose from footer links \"(.*?)\"")
    public void chooseFromFooterLinks(String value) {

        alfaMainPage.chooseFooterLink(value);
    }




}
