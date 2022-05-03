package staticdata;

public enum Severity {

    NOT_SET("Not set"),
    BlOCKER("Blocker"),
    CRITICAL("Critical"),
    MAJOR("Major"),
    NORMAL("Normal"),
    MINOR("Minor"),
    TRIVIAL("TRIVIAL");

    private String severity;

    private Severity(String severity) {
        this.severity = severity;
    }

    public String getSeverity() {
        return severity;
    }
}

