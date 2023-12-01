package page;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    String url = "http://gcreddy.com/project/";

    @FindBy(xpath = "//u[text()='login']/parent::a")
    public WebElement loginLinktext;

    @FindBy(xpath = "//u[text()='create an account']/parent::a")
    public WebElement createAnAccountLinktext;

    @FindBy(linkText = "Shopping Cart")
    public WebElement shoppingCartElement;

    @Step("Navigate to http://gcreddy.com/project")
    public void navigateWebsite(){
        navigatePage(url);
    }

    @Step("Verify login link text")
    public void verifyLoginLinkText(){
        Assert.assertTrue(loginLinktext.isDisplayed());
    }

    @Step("Verify create account link text")
    public void verifyCreateAnAccountLinkText(){
        Assert.assertTrue(createAnAccountLinktext.isDisplayed());
    }

    @Step("Verify shopping cart")
    public void verifyShoppingCart(){
        Assert.assertTrue(shoppingCartElement.isDisplayed());
    }
}
