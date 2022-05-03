package staticdata.uidata.testcaseform;

public enum AutomationStatus {

    NOT_AUTOMATED("Not automated"),
    TO_BE_AUTOMATED("To be automated"),
    AUTOMATED("Automated");

    private String automationStatus;

    private AutomationStatus(String automationStatus) {
        this.automationStatus = automationStatus;
    }

    public String getAutomationStatus() {
        return automationStatus;
    }
}