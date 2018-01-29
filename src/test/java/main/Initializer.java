package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.yecht.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Shelk on 1/6/2018.
 */
public class Initializer {

    private static final String PROPERTIES_PATH = "src/test/resources/properties/app.properties";
    private static WebDriver driver;
    private static Properties props;
    public static Map<String, String> STASH = new HashMap<>();

    static {
        props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(PROPERTIES_PATH);
            props.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setProperty("webdriver.chrome.driver", props.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
    }

    public static Properties getProps() {
        return props;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getSTASH(String key) {
        return STASH.get(key);
    }

    public static void setSTASH(String key, String value) {
        STASH.put(key, value);
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}
