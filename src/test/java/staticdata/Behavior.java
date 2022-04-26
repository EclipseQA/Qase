package staticdata;

public enum Behavior {

    NOT_SET("Not set"),
    POSITIVE("Positive"),
    NEGATIVE("Negative"),
    DESTRUCTIVE("Destructive");

    private String behavior;

    private Behavior(String behavior) {
        this.behavior = behavior;
    }

    public String getBehavior() {
        return behavior;
    }
}
