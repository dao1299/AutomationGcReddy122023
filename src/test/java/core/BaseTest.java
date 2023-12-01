package core;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
//    private static final ThreadLocal<WebDriver> driver = new ThreadLocal();
//
//    private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal();
//
//    @Parameters({"browser"})
//    @BeforeMethod
//    public void setup(@Optional("chrome") String browserName) {
////        if (browserName.equalsIgnoreCase("chrome")) {
//////            System.setProperty("webdriver.chrome.driver","D:\\FresherAutomationTest\\AutoWeb\\AssignmentProject2\\src\\browserDriver\\chromedriver.exe");
////            setDriver(new ChromeDriver());
////        } else {
//////            System.setProperty("webdriver.firefox.driver","D:\\FresherAutomationTest\\AutoWeb\\AssignmentProject2\\src\\browserDriver\\geckodriver.exe");
////            setDriver(new FirefoxDriver());
////        }
//        setDriver(new ChromeDriver());
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        getDriver().manage().window().maximize();
//    }
//
//    public static WebDriver getDriver() {
//        return remoteWebDriver.get();
//    }
//
//    public static void setDriver(WebDriver setDriver) {
//        driver.set(setDriver);
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void close(ITestResult iTestResult, ITestContext iTestContext) throws IOException {
//        System.out.println("Test result: "+iTestResult);
//        System.out.println("Test context: "+iTestContext);
////        ExcelUtils.writeAppendExcelFile(iTestContext.getName(),iTestResult.getName(),(iTestResult.getStatus()==1?"Pass":"Fail"));
//    }
//
//    @AfterTest
//    public void afterTest(){
//        try {
////            ExcelUtils.writeAppendExcelFile(" "," "," ");
//
//            System.out.println("After test");
//            getDriver().close();
//            getDriver().quit();
//        } catch (Exception ignored) {
//
//        }
//    }
//
//    @BeforeTest
//    @Parameters({"platform", "browser"})
//    public void parallelTest(@Optional("win10")String platform,@Optional("firefox") String browser) throws MalformedURLException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//
//        if (platform.equalsIgnoreCase("Win10")) {
//            desiredCapabilities.setPlatform(Platform.WIN10);
//        }
//        if (platform.equalsIgnoreCase("WINDOWS")) {
//            desiredCapabilities.setPlatform(Platform.WINDOWS);
//        }
//        if (platform.equalsIgnoreCase("MAC")) {
//            desiredCapabilities.setPlatform(Platform.MAC);
//
//        }
//
//        if (browser.equalsIgnoreCase("Chrome")) {
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/browserDriver/chromedriver.exe");
//            desiredCapabilities.setBrowserName("chrome");
////            System.out.println("chrome systemout:   " + desiredCapabilities.getBrowserName() + " " + desiredCapabilities.getBrowserVersion() + " " + desiredCapabilities.getPlatformName());
//            remoteWebDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities));
//        }
//
//        if (browser.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "src/browserDriver/geckodriver.exe");
//            desiredCapabilities.setBrowserName("firefox");
////            System.out.println("firefox systemout:   " + desiredCapabilities.getBrowserName() + " " + desiredCapabilities.getBrowserVersion() + " " + desiredCapabilities.getPlatformName());
//            remoteWebDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities));
//        }
////        try {
//////            ExcelUtils.writeHeadingExcelFile();
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
//    }
    static WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/browserDriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
