package org.epam.fsa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingDropdownsExample {

    WebDriver driver;
    WebElement element;

    @Test
    public void test() throws Exception {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://omayo.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        element = driver.findElement(By.id("myDropdown"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        FluentWait wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
        List<WebElement> dropdownValues = driver.findElements(By.xpath("//div[@id='myDropdown']/a"));
        for (WebElement value : dropdownValues) {
            Thread.sleep(10000);
            //wait.until(ExpectedConditions.visibilityOf(value));
            if (value.getText().equals("Flipkart"))
                value.click();
        }
        //By using select Class
        Select select = new Select(element);
        select.selectByIndex(1);
        select.selectByValue("");
        select.selectByVisibleText("");
        System.out.println("Window Title::" + driver.getTitle());
        driver.navigate().back();
        System.out.println("Window Home Page Title::" + driver.getTitle());

    }


}
