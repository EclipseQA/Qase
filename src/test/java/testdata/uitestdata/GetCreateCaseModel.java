package testdata.uitestdata;

import models.ui.CreateCaseModel;
import staticdata.commondata.ProjectData;
import staticdata.uidata.testcaseform.*;
import utilities.DataFaker;

public class GetCreateCaseModel {

    public static CreateCaseModel getCreateCaseModel() {
        return CreateCaseModel.builder()
                .title(ProjectData.TEST_CASE_NAME)
                .description(DataFaker.getDescription())
                .severity(Severity.MINOR.getSeverity())
                .priority(Priority.MEDIUM.getPriority())
                .type(Type.SMOKE.getType())
                .behavior(Behavior.POSITIVE.getBehavior())
                .automationStatus(AutomationStatus.AUTOMATED.getAutomationStatus())
                .preConditions("Windows 10, Chrome Version 100.0.4896.127")
                .postConditionals(DataFaker.getPostConditionals())
                .build();
    }
}
