package staticdata;

import models.CreateCaseModel;
import testdata.GetCreateCaseModel;
import utilities.DataFaker;

public class ProjectData {

    public static String PROJECT_NAME = DataFaker.getProjectName();
    public static String TEST_CASE_NAME = DataFaker.getTestCaseName();
    public static CreateCaseModel EXPECTED_CASE_MODEL = GetCreateCaseModel.getCreateCaseModel();
}
