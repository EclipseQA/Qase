package staticdata.apidata.testcaseform;

public enum Behavior {

    NOT_SET(1),
    POSITIVE(2),
    NEGATIVE(3),
    DESTRUCTIVE(4);

    private Integer behavior;

    private Behavior(Integer behavior) {
        this.behavior = behavior;
    }

    public Integer getBehavior() {
        return behavior;
    }
}