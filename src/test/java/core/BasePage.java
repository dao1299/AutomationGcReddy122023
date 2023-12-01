package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final int TIMEOUT = 10;
    private static final int POLLING = 100;
    protected WebDriver driver;
    protected WebDriverWait wait;
    JavascriptExecutor jsExecutor;

    public BasePage() {
        driver = BaseTest.getDriver();
        jsExecutor = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(POLLING));
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return BaseTest.getDriver();
    }

    public void navigatePage(String url) {
        driver.get(url);
    }
}
