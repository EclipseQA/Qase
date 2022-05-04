package staticdata.apidata;

import models.api.NewTestCaseModel;
import testdata.apitestdata.GetNewTestCaseModel;
import utilities.PropertiesManager;

public class API {

    public static final String TOKEN = new PropertiesManager().get("API_TOKEN");
    public static final String PROJECTS_URL = "https://api.qase.io/v1/project/";
    public static final String SUCCESS_NEW_PROJECT_FILE = "src/test/resources/successResponseNewProject.json";
    public static final String CASE_URL = "https://api.qase.io/v1/case/";
    public static final NewTestCaseModel TEST_CASE_MODEL = GetNewTestCaseModel.getNewTestCaseModelWithAllFields();
}