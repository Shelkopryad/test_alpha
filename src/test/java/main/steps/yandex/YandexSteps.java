package main.steps.yandex;

import cucumber.api.java.en.When;
import main.core.Initializer;
import main.pages.yandex.YandexMainPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Shelk on 1/29/2018.
 */
public class YandexSteps {

    private WebDriver driver = Initializer.getDriver();
    private YandexMainPage yandexMainPage = new YandexMainPage(driver);

    @When("^user choose service \"(.*?)\"$")
    public void clickOn(String elementName) {
        yandexMainPage.clickOnLink(elementName);
    }

}
