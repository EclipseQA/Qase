package driver;

public class DriverFactory {

    public DriverManager getDriverManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case REMOTE:
                driverManager = new RemoteDriverManager();
                break;
            case MOZILLA:
                driverManager = new MozillaDriverManager();
                break;
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected driver type : " + type);
        }
        return driverManager;
    }
}