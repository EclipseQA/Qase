package testdata.apitestdata;

import models.api.NewProjectModel;
import staticdata.commondata.ProjectData;
import staticdata.apidata.projectform.Access;
import utilities.DataFaker;

public class GetNewProjectModel {

    public static NewProjectModel getProjectModelWithAllFields() {
        return NewProjectModel.builder()
                .title(ProjectData.PROJECT_NAME)
                .code(ProjectData.PROJECT_NAME.toUpperCase())
                .description(DataFaker.getDescription())
                .access(Access.NONE.getAccessType())
                .build();
    }
}