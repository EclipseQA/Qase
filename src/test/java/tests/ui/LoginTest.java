package tests.ui;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.WebUrl;
import testdata.GetLoginModel;
import utilities.Retry;

@Epic("Login Test")
public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @Description("User attempts to log in with VALID credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test for log in with VALID credentials")
    public void loginWithValidDataTest() {

        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());
        Assert.assertEquals(loginPage.isUserLoggedIn(), WebUrl.QASE_PROJECTS
                , "Invalid data");
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("User attempts to log in with INVALID credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test for log in with INVALID credentials")
    public void loginWithInvalidDataTest() {

        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithInvalidData());
        Assert.assertEquals(loginPage.isErrorMessageShown(), true
                , "You managed to log in");
    }

    @Test(dataProvider = "missingFields",
            dataProviderClass = GetLoginModel.class,
            retryAnalyzer = Retry.class)
    @Description("User attempts to log in with missing fields")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test for log in with missing fields in credentials")
    public void loginWithMissingFieldsTest(String email, String password) {

        loginPage.openPage()
                .login(email, password);
        Assert.assertEquals(loginPage.isUserLoggedIn(), WebUrl.QASE_LOGIN
                , "You managed to log in");
    }
}