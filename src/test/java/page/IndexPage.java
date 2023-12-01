package page;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class IndexPage extends BasePage {

    @FindBy(xpath = "//a[text()='Logoff']")
    public WebElement logoffLink;


    @Step("Verify logoff link")
    public void verifyLogoffLink() {
        wait.until(ExpectedConditions.visibilityOf(logoffLink));
        Assert.assertTrue(logoffLink.isDisplayed());
    }

}
