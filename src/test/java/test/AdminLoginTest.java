package test;

import core.BaseTest;
import core.DataProviderTestCase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import page.AdminLogin;
import page.HomePage;
import page.IndexPage;


public class AdminLoginTest extends BaseTest {

    //2.
    @Test(testName = "TC_02", description = "Verify title admin login page!")
    @Description("Verify title is match with osCommerce Online Merchant Administration Tool")
    @Epic("Test admin login")
    public void TC_02() {
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.navigateWebsite();
        adminLogin.verifyTitle("osCommerce Online Merchant Administration Tool 2");
    }

    @Test(testName = "TC_03")
    @Epic("Test admin login")
    public void TC_03() {
        HomePage homePage = new HomePage();
        homePage.navigateWebsite();
        homePage.verifyLoginLinkText();
        homePage.verifyCreateAnAccountLinkText();
        homePage.verifyShoppingCart();
    }

    //4.
    @Test
    public void TC_04() {
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.navigateWebsite();
        adminLogin.clickOnlineCatalog();
        adminLogin.verifyCurrentUrl("http://gcreddy.com/project/");
    }

    //5.
    @Test(dataProvider = "test-data-for-tc05", dataProviderClass = DataProviderTestCase.class)
    public void TC_05(String username, String password) {
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.navigateWebsite();
        adminLogin.inputUserName(username);
        adminLogin.inputPassword(password);
        adminLogin.clickButtonLogin();
        IndexPage indexPage = new IndexPage();
        indexPage.verifyLogoffLink();
    }

    //6.
    @Test(dataProvider = "test-data-for-tc06", dataProviderClass = DataProviderTestCase.class)
    public void TC_06(String username, String password) {
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.navigateWebsite();
        adminLogin.inputUserName(username);
        adminLogin.inputPassword(password);
        adminLogin.clickButtonLogin();
        adminLogin.verifyMessageError();
    }

    @Test
    public void TC_07() {
//        Object[][] testData = TextUtils.readDataFromFileText();
//        AdminLogin adminLogin = new AdminLogin();
//        for (int i = 0; i < testData.length; i++) {
//            adminLogin.navigateWebsite();
//            adminLogin.inputUserName((String) testData[i][0]);
//            adminLogin.inputPassword((String) testData[i][1]);
//            adminLogin.clickButtonLogin();
//            if (i != 3) {
//                adminLogin.verifyMessageError();
//            } else {
//                adminLogin.verifyMessageBlock();
//            }
//        }
    }
}
