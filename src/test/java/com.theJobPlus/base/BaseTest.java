package com.theJobPlus.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop;

    private void loadProperties() {
        prop = new Properties();
        try {
            FileInputStream fin = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
            try {
                prop.load(fin);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public WebDriver initialization() {
        loadProperties();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        WebDriverManager.chromedriver().setup();
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("books.ecommerce.url"));
        System.out.println("From Base Test");
        return driver;
    }

    public void tearDown() {
        driver.close();
    }
}