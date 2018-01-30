package main.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.When;
import main.Initializer;
import org.openqa.selenium.WebDriver;

/**
 * Created by Shelk on 1/30/2018.
 */
public class BaseSteps {

    private WebDriver driver = Initializer.getDriver();

    @When("^user goes to page \"(.*?)\"$")
    public void goToPage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void close() {
        driver.close();
    }
}
