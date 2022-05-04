package staticdata.uidata.testcaseform;

public enum Priority {

    NOT_SET("Not set"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private String priority;

    private Priority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}