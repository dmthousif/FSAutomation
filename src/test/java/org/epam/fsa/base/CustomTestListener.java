package org.epam.fsa.base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        // Executed before the test suite starts
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Executed before each test method starts
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Executed after a test method succeeds
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if(result != null){
            System.out.println("Taking Screenshot of the failed case");
            // Add logic to take a screenshot here
            // For example:
            // WebDriver driver = YourDriverFactory.getDriver(); // Assuming you're using WebDriver
            // TakesScreenshot screenshot = (TakesScreenshot)driver;
            // File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            // File destFile = new File("path/to/save/screenshot.png");
            // try {
            //     FileUtils.copyFile(srcFile, destFile);
            // } catch (IOException e) {
            //     e.printStackTrace();
            // }
        }
    }
}