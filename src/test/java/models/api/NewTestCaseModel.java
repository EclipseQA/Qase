package models.api;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Data
@Jacksonized
public class NewTestCaseModel {

    private String title;
    private String description;
    private String preconditions;
    private String postconditions;
    private Integer severity;
    private Integer priority;
    private Integer behavior;
    private Integer type;
    private Integer automation;
    private List<Step> steps;
}