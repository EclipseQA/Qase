package staticdata.uidata.testcaseform;

public enum Type {

    FUNCTIONAL("Functional"),
    SMOKE("Smoke"),
    REGRESSION("Regression");

    private String type;

    private Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}