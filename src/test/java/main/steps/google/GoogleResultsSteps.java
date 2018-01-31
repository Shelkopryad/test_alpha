package main.steps.google;

import cucumber.api.java.en.When;
import main.core.Initializer;
import main.pages.google.GoogleResultPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Shelk on 1/30/2018.
 */
public class GoogleResultsSteps {

    private WebDriver driver = Initializer.getDriver();
    private GoogleResultPage googleResultPage = new GoogleResultPage(driver);

    @When("^user choose from results where URL \"(.*?)\"$")
    public void chooseResult(String url) {
        googleResultPage.chooseLink(url);
    }
}
