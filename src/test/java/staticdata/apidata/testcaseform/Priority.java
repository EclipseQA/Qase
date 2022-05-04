package staticdata.apidata.testcaseform;

public enum Priority {

    NOT_SET(4),
    HIGH(1),
    MEDIUM(2),
    LOW(3);

    private Integer priority;

    private Priority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }
}