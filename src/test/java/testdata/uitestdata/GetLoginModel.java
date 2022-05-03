package testdata.uitestdata;

import models.ui.LoginModel;
import org.testng.annotations.DataProvider;
import utilities.DataFaker;
import utilities.PropertiesManager;

public class GetLoginModel {

    @DataProvider(name = "missingFields")
    public static Object[][] inputDataIntoFields() {
        return new Object[][]{
                {"", DataFaker.getPassword()},
                {DataFaker.getEmail(), ""},
                {"", ""}
        };
    }

    public static LoginModel getLoginModelWithInvalidData() {
        return LoginModel.builder()
                .email(DataFaker.getEmail())
                .password(DataFaker.getPassword())
                .build();
    }

    public static LoginModel getLoginModelWithValidData() {
        PropertiesManager prop = new PropertiesManager();
        return LoginModel.builder()
                .email(prop.get("EMAIL"))
                .password(prop.get("PASSWORD"))
                .build();
    }
}
