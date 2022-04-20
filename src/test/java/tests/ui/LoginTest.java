package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import staticdata.WebUrl;
import testdata.GetLoginModel;


public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidDataTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());
        Assert.assertEquals(loginPage.isUserLoggedIn(), WebUrl.QASE_PROJECTS
                , "Invalid data");
    }

    @Test
    public void loginWithInvalidDataTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithInvalidData());
        Assert.assertEquals(loginPage.isErrorMessageShown(), true
                , "You managed to log in");
    }

    @Test(dataProvider = "missingFields", dataProviderClass = GetLoginModel.class)
    public void loginWithMissingFieldsTest(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openPage()
                .login(email, password);
        Assert.assertEquals(loginPage.isUserLoggedIn(), WebUrl.QASE_LOGIN
                , "You managed to log in");
    }
}