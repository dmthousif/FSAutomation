package org.epam.fsa.tests;

import org.epam.fsa.base.BaseTest;
import org.epam.fsa.base.CustomTestListener;
import org.epam.fsa.base.RetryAnalyzer;
import org.epam.fsa.pages.loginPage;
import org.epam.fsa.utils.CommonToAllPage;
import org.epam.fsa.utils.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

@Listeners(CustomTestListener.class)
public class loginTest extends BaseTest {

    loginPage loginPage;
    static CommonToAllPage common;

    static {
        //
        common = new CommonToAllPage();
    }

    // @Test ------ RUN NNNNNNNNNNNNNNNNNN This
    @Test(enabled = false,retryAnalyzer = RetryAnalyzer.class, groups = "smoke", invocationCount = 1,
            dataProvider = "getData", dataProviderClass = ExcelReader.class)
    public void verifyLogin(LinkedHashMap<String, String> data) throws InterruptedException {
        // Using the driver instance from BaseTest
        loginPage = new loginPage(driver);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        common.waitforVisibilityOfElement(loginPage.getUserName());
        loginPage.attemptLogin(data, prop);
    }

    @Test(groups = "smoke", invocationCount = 1, dataProvider = "getData", dataProviderClass = ExcelReader.class)
    public void verifyWindowsTitle(LinkedHashMap<String, String> data) {
        // Using the driver instance from BaseTest
        loginPage = new loginPage(driver);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        common.waitforVisibilityOfElement(loginPage.getUserName());
        loginPage.attemptLogin(data, prop);
        Assert.assertTrue(driver.getTitle().equals("OrangeHRM"));
    }


    @Test(enabled = false,retryAnalyzer = RetryAnalyzer.class)
    public void retry() {
        Assert.fail("Intentionally failing this test case");
    }


}
