package models;

import lombok.Builder;
import lombok.Data;

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

}

