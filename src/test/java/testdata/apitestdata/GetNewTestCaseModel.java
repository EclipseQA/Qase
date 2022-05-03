package testdata.apitestdata;

import models.api.NewTestCaseModel;
import models.api.Step;
import staticdata.apidata.testcaseform.*;
import staticdata.commondata.ProjectData;
import utilities.DataFaker;

import java.util.ArrayList;

public class GetNewTestCaseModel {

    public static NewTestCaseModel getNewTestCaseModelWithAllFields() {
        return NewTestCaseModel.builder()
                .title(ProjectData.TEST_CASE_NAME)
                .description(DataFaker.getDescription())
                .preconditions("Windows 10, Chrome Version 100.0.4896.127")
                .postconditions(DataFaker.getPostConditionals())
                .severity(Severity.BlOCKER.getSeverity())
                .priority(Priority.MEDIUM.getPriority())
                .behavior(Behavior.POSITIVE.getBehavior())
                .automation(AutomationStatus.AUTOMATED.getAutomationStatus())
                .type(Type.FUNCTIONAL.getType())
                .steps(getSteps())
                .build();
    }

    private static ArrayList<Step> getSteps() {
        Step step1 = new Step("first", "test", "privet", 1);
        Step step2 = new Step("second", "test", "privet", 2);
        ArrayList<Step> someStep = new ArrayList<>();
        someStep.add(step1);
        someStep.add(step2);
        return someStep;
    }
}