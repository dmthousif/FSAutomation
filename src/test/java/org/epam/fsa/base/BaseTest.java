package org.epam.fsa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;

    public Properties prop;

    @BeforeMethod
    public void launchDriver() throws IOException {
        // Load properties before launching the driver
        loadPropertiesFile();
        if (prop.getProperty("browser").equalsIgnoreCase("Edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--guest");
            options.addArguments("--remote-allow-origins=*");
            driver = new EdgeDriver(options);
        } else if (prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--guest");
            options.addArguments("--remote-allow-origins=*");
            driver = new EdgeDriver(options);
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    @BeforeSuite
    public void loadPropertiesFile() throws IOException {  // Load properties before any tests
        prop = new Properties();
        try {
            // Load properties from a file
            prop.load(new FileInputStream("src/test/java/org/epam/fsa/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }


    public Properties getProp() {
        return prop;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
