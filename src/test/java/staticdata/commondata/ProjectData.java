package staticdata.commondata;

import models.ui.CreateCaseModel;
import testdata.uitestdata.GetCreateCaseModel;
import utilities.DataFaker;

public class ProjectData {

    public static String PROJECT_NAME = DataFaker.getProjectName();
    public static String TEST_CASE_NAME = DataFaker.getTestCaseName();
    public static CreateCaseModel EXPECTED_CASE_MODEL = GetCreateCaseModel.getCreateCaseModel();
    public static int NUMBER_OF_PROJECT = 0;
}
