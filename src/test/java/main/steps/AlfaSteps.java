package main.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.Constants;
import main.Initializer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Shelk on 1/29/2018.
 */
public class AlfaSteps {

    private static WebDriver driver;

    @Before
    public static void loadDriver() {
        if (driver == null) {
            driver = Initializer.getDriver();
        }
    }

    @Given("^user goes to page \"(.*?)\"$")
    public void userGoesToPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();

    }

    @When("^user click on link \"(.*?)\"$")
    public void clickOn(String elementName) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10).withMessage("Element was not found");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[normalize-space(text())='" + elementName + "']"))));
        WebElement link = driver.findElement(By.xpath("//a[normalize-space(text())='" + elementName + "']"));
        link.click();
    }

    @When("search \"(.*?)\"")
    public void search(String value) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10).withMessage("Element was not found");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='q']"))));
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        searchField.sendKeys(value);
        WebElement submit = driver.findElement(By.xpath("//input[@name='btnK']"));
        submit.click();
    }

//    @When("^set checkbox filter \"(.*?)\"$")
//    public void setFilter(String filterName) {
//        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
//                By.xpath("//div[contains(@class,'exp-filters-new-design')]//label[normalize-space(text())='" + filterName + "']"))));
//        WebElement checkBox = driver.findElement(
//                By.xpath("//div[contains(@class,'exp-filters-new-design')]//label[normalize-space(text())='" + filterName + "']"));
//        if (!checkBox.isSelected()) {
//            checkBox.click();
//        }
//
//        waitForPageIsLoad(wait);
//    }
//
//    @When("set (.*?) amount \"(.*?)\"")
//    public void setAmount (String minOrMax, String amount) throws Exception {
//        Wait<WebDriver> wait = new WebDriverWait(driver, 10).withMessage("Element was not found");
//        WebElement input;
//        switch (minOrMax) {
//            case "min":
//                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='glf-pricefrom-var']"))));
//                input = driver.findElement(By.xpath("//input[@name='glf-pricefrom-var']"));
//                break;
//            case "max":
//                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='glf-priceto-var']"))));
//                input = driver.findElement(By.xpath("//input[@name='glf-priceto-var']"));
//                break;
//            default:
//                throw new Exception("Неизвестное значение \"" + minOrMax + "\"");
//        }
//
//        input.sendKeys(amount);
//        waitForPageIsLoad(wait);
//    }
//
//    @When("opens first product and remembers the name")
//    public void getFirstProduct() {
//        Wait<WebDriver> wait = new WebDriverWait(driver, 10).withMessage("Element was not found");
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
//                By.xpath("//div[contains(@class,'n-snippet-list')][1]/div[contains(@class,'n-snippet-cell2_type_product b-spy-visible_js_inited')][1]/div[@class='n-snippet-cell2__header']/div[@class='n-snippet-cell2__title']/a"))));
//        WebElement nameLink = driver.findElement(
//                By.xpath("//div[contains(@class,'n-snippet-list')][1]/div[contains(@class,'n-snippet-cell2_type_product b-spy-visible_js_inited')][1]/div[@class='n-snippet-cell2__header']/div[@class='n-snippet-cell2__title']/a"));
//        Initializer.setSTASH(Constants.PRODUCT_NAME, nameLink.getText());
//        nameLink.click();
//    }
//
//    @Then("check product title")
//    public void checkProductTitle() {
//        Wait<WebDriver> wait = new WebDriverWait(driver, 10).withMessage("Element was not found");
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
//                By.xpath("//h1[@class='title title_size_28 title_bold_yes']"))));
//        WebElement title = driver.findElement(
//                By.xpath("//h1[@class='title title_size_28 title_bold_yes']"));
//
//        Assert.assertEquals("Не соответствует название родукта", Initializer.getSTASH(Constants.PRODUCT_NAME), title.getText());
//    }



    @After
    public static void close() {
        driver.close();
    }

    private void waitForPageIsLoad(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.attributeContains(By.xpath("//div[contains(@class,'n-filter-panel-counter_hidden_')]"), "style", "display: block"));
        wait.until(ExpectedConditions.attributeContains(By.xpath("//div[contains(@class,'n-filter-panel-counter_hidden_')]"), "style", "display: none"));
    }
}
