package staticdata.apidata.testcaseform;

public enum Severity {

    NOT_SET(7),
    BlOCKER(1),
    CRITICAL(2),
    MAJOR(3),
    NORMAL(4),
    MINOR(5),
    TRIVIAL(6);

    private Integer severity;

    private Severity(Integer severity) {
        this.severity = severity;
    }

    public Integer getSeverity() {
        return severity;
    }
}