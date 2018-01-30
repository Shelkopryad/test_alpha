package main.steps.yandex;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.Constants;
import main.Initializer;
import main.pages.yandex.MarketMainPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Shelk on 1/30/2018.
 */
public class MarketSteps {

    private WebDriver driver = Initializer.getDriver();
    private MarketMainPage marketMainPage = new MarketMainPage(driver);

    @When("^user choose \"(.*?)\" \"(.*?)\"$")
    public void chooseProducts(String where, String filterName) {
        marketMainPage.clickOn(where, filterName);
    }

    @When("^user set checkbox filter \"(.*?)\"$")
    public void setFilter(String value) {
        marketMainPage.setFilter(value);
        waitForPageIsLoad();
    }

    @When("^user set (.*?) amount \"(.*?)\"$")
    public void setAmount (String minOrMax, String amount) {
        marketMainPage.setAmount(minOrMax, amount);
        waitForPageIsLoad();
    }

    @When("opens first product and remembers the name")
    public void getFirstProduct() {
        marketMainPage.chooseFirstProductAndSaveName();
    }

    private void waitForPageIsLoad() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10).withMessage("Element was not found");
        wait.until(ExpectedConditions.attributeContains(By.xpath("//div[contains(@class,'n-filter-panel-counter_hidden_')]"), "style", "display: block"));
        wait.until(ExpectedConditions.attributeContains(By.xpath("//div[contains(@class,'n-filter-panel-counter_hidden_')]"), "style", "display: none"));
    }

}
