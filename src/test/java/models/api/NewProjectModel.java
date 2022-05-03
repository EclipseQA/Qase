package models.api;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class NewProjectModel {

    private String title;
    private String code;
    private String description;
    private String access;
}
