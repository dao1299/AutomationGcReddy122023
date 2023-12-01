package page;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AdminLogin extends BasePage {
    private static final String url = "http://gcreddy.com/project/admin/login.php";

    @FindBy(name = "username")
    private WebElement userNameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "tdb1")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text()='Online Catalog']")
    private WebElement onlineCatalogButton;

    @FindBy(xpath = "//td[@class='messageStackError']")
    private WebElement messageError;

    @Step("Verify title")
    public void verifyTitle(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    public void verifyCurrentUrl(String url) {
        Assert.assertTrue(url.equalsIgnoreCase(driver.getCurrentUrl()));
    }

    @Step("Navigate to website http://gcreddy.com/project/admin/login.php")
    public void navigateWebsite() {
        navigatePage(url);
    }

    @Step("click online Catalog button")
    public void clickOnlineCatalog() {
        onlineCatalogButton.click();
    }

    @Step("Input user input field: {0}")
    public void inputUserName(String username) {
        userNameInput.sendKeys(username);
    }

    @Step("Input password input field: {0}")
    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Click button login")
    public void clickButtonLogin() {
        loginButton.click();
    }

    @Step("Verify message error: Invalid administrator login attempt.")
    public void verifyMessageError() {
        Assert.assertEquals(messageError.getText(), " Error: Invalid administrator login attempt.");
    }

    @Step("Verify message block: The maximum number of login attempts has been reached. Please try again in 5 minutes.")
    public void verifyMessageBlock() {
        Assert.assertEquals(messageError.getText(), " Error: The maximum number of login attempts has been reached. Please try again in 5 minutes.");
    }
}
