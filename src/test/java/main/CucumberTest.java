package main;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Shelk on 1/29/2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber"},
        features = {"src/test/resources/features/yandex.feature", "src/test/resources/features/alfa.feature"},
        tags = "@1")
public class CucumberTest {
}
