package core;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayInputStream;

public class ReportListener extends TestListenerAdapter {

//
//    @Override
//    public void onTestFailure(ITestResult result) {
//
//        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES)));
//
//        System.out.println("Test Failure");
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        Allure.addAttachment("Test case " + result.getTestName() + " success", new ByteArrayInputStream(((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES)));
//        ITestListener.super.onTestSuccess(result);
//    }


    @Override
    public void onTestFailure(ITestResult tr) {
//        System.out.println("============================");
//        System.out.println("TEST CASE FAIL");
//        System.out.println("Info: "+tr.getTestName()+"\n"+BaseTest.getDriver());
//        System.out.println("============================");

        Allure.addAttachment(tr.getName(), new ByteArrayInputStream(((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
//        System.out.println("============================");
//        System.out.println("TEST CASE PASS");
//        System.out.println("Info: "+tr.getName()+"\n"+BaseTest.getDriver());
//        System.out.println("============================");
//        Allure.addAttachment(tr.getName(), new ByteArrayInputStream(((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

}
