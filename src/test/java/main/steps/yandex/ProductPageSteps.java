package main.steps.yandex;

import cucumber.api.java.en.Then;
import main.core.Initializer;
import main.pages.yandex.ProductPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Shelk on 1/30/2018.
 */
public class ProductPageSteps {

    private WebDriver driver = Initializer.getDriver();
    ProductPage productPage = new ProductPage(driver);

    @Then("check product title")
    public void checkProductTitle() {
        productPage.checkProductTitle();
    }
}
