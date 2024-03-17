package org.epam.fsa.base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int Count = 0;
    int maxCount = 4;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (Count< maxCount) {
            Count++;
            return true;

        }
        return false;
    }
}
