package utilities;

import com.github.javafaker.Faker;

public class DataFaker {

    private static Faker faker = new Faker();

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getPassword() {
        return faker.internet().password();
    }

    public static String getProjectName() {
        return faker.letterify("?????????");
    }

    public static String getDescription() {
        return faker.harryPotter().quote();
    }

    public static String getPostConditionals() {
        return faker.internet().slug();
    }

    public static String getTestCaseName() {
        return faker.leagueOfLegends().champion();
    }
}