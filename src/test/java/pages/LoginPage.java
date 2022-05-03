package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import models.LoginModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebUrl;

@Log4j
public class LoginPage extends BasePage {

    private By EMAIL_INPUT = By.id("inputEmail");
    private By PASSWORD_INPUT = By.id("inputPassword");
    private By LOGIN_BUTTON = By.id("btnLogin");
    private By CREDENTIAL_MESSAGE = By.className("form-control-feedback");

    @Step("User is on the Login Page")
    public LoginPage openPage() {
        log.info("Open Login Page");
        driver.get(WebUrl.QASE_LOGIN);
        return this;
    }

    @Step("Inputs {0} into Email field")
    public LoginPage inputEmail(String value) {
        log.info("Input Email field");
        driver.findElement(EMAIL_INPUT).sendKeys(value);
        return this;
    }

    @Step("Inputs {0} into Password field")
    public LoginPage inputPassword(String value) {
        log.info("Input Password field");
        driver.findElement(PASSWORD_INPUT).sendKeys(value);
        return this;
    }

    @Step("Click Login button")
    public void clickLogin() {
        log.info("Click 'Login' button");
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void login(LoginModel model) {
        inputEmail(model.getEmail());
        inputPassword(model.getPassword());
        clickLogin();
    }

    public void login(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickLogin();
    }

    @Step("Verify that 'These credentials do not match our records.' message is displayed")
    public boolean isErrorMessageShown() {
        log.info("Check if the message 'Wrong credentials' is displayed");
        return driver.findElement(CREDENTIAL_MESSAGE).isDisplayed();
    }

    @Step("Verify that User has logged in")
    public String isUserLoggedIn() {
        log.info("Check if page url changed");
        return driver.getCurrentUrl();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}