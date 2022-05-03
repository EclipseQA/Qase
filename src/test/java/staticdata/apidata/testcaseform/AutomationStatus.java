package staticdata.apidata.testcaseform;

public enum AutomationStatus {

    NOT_AUTOMATED(0),
    TO_BE_AUTOMATED(1),
    AUTOMATED(2);

    private Integer automationStatus;

    private AutomationStatus(Integer automationStatus) {
        this.automationStatus = automationStatus;
    }

    public Integer getAutomationStatus() {
        return automationStatus;
    }
}