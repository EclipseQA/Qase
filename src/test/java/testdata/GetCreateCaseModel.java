package testdata;

import models.CreateCaseModel;
import staticdata.*;
import utilities.DataFaker;

public class GetCreateCaseModel {

    public static CreateCaseModel getCreateCaseModel() {
        return CreateCaseModel.builder()
                .title(DataFaker.getTitleName())
                .description(DataFaker.getDescription())
                .severity(Severity.MINOR.getSeverity())
                .priority(Priority.MEDIUM.getPriority())
                .type(Type.SMOKE.getType())
                .behavior(Behavior.POSITIVE.getBehavior())
                .automationStatus(AutomationStatus.AUTOMATED.getAutomationStatus())
                .build();
    }
}
