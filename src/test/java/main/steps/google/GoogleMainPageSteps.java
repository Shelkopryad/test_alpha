package main.steps.google;

import cucumber.api.java.en.When;
import main.Initializer;
import org.openqa.selenium.WebDriver;
import main.pages.google.GoogleMainPage;

public class GoogleMainPageSteps {

    private WebDriver driver = Initializer.getDriver();
    private GoogleMainPage googleMainPage = new GoogleMainPage(driver);

    @When("^user search \"(.*?)\"$")
    public void search(String request) {
        googleMainPage.search(request);
    }
}
