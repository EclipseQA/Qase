package pages;

import models.LoginModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebUrl;

public class LoginPage extends BasePage {

    private By EMAIL_INPUT = By.id("inputEmail");
    private By PASSWORD_INPUT = By.id("inputPassword");
    private By LOGIN_BUTTON = By.id("btnLogin");
    private By CREDENTIAL_MESSAGE = By.className("form-control-feedback");

    public LoginPage openPage() {
        driver.get(WebUrl.QASE_LOGIN);
        return this;
    }

    public LoginPage inputEmail(String value) {
        driver.findElement(EMAIL_INPUT).sendKeys(value);
        return this;
    }

    public LoginPage inputPassword(String value) {
        driver.findElement(PASSWORD_INPUT).sendKeys(value);
        return this;
    }

    public void clickLogin() {
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

    public boolean isErrorMessageShown() {
        return driver.findElement(CREDENTIAL_MESSAGE).isDisplayed();
    }

    public String isUserLoggedIn() {
        return driver.getCurrentUrl();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}