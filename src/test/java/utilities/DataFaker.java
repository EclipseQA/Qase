package utilities;

import com.github.javafaker.Faker;

public class DataFaker {

    public static String getEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getPassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }

    public static String getProjectName() {
        Faker faker = new Faker();
        return faker.app().name();
    }

    public static String getTitleName(){
        Faker faker = new Faker();
        return faker.harryPotter().spell();
    }

    public static String getDescription(){
        Faker faker = new Faker();
        return faker.harryPotter().quote();
    }

    public static String getPostConditionals(){
        Faker faker = new Faker();
        return faker.internet().slug();
    }
}