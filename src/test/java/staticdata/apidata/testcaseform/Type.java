package staticdata.apidata.testcaseform;

public enum Type {

    OTHER(1),
    FUNCTIONAL(2),
    SMOKE(3),
    REGRESSION(4);

    private Integer type;

    private Type(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}