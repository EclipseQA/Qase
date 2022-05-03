package models.ui;

import lombok.*;

@Builder
@Data
public class CreateCaseModel {

    private String title;
    private String description;
    private String severity;
    private String priority;
    private String type;
    private String behavior;
    private String automationStatus;
    private String preConditions;
    private String postConditionals;
}

