package main.steps.yandex;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.Constants;
import main.Initializer;
import main.pages.yandex.MarketMainPage;
import main.pages.yandex.YandexMainPage;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @After
    public void close() {
        driver.close();
    }
}
