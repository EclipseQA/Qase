package models.api;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
public class SuccessResponseNewProjectModel {
    public boolean status;
    public Result result;
}

