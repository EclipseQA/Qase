package staticdata.apidata.projectform;

public enum Access {

    ADD_ALL("all"),
    GROUP("group"),
    NONE("none");

    private String accessType;

    private Access(String accessType) {
        this.accessType = accessType;
    }

    public String getAccessType() {
        return accessType;
    }
}
