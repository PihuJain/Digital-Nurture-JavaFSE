// concrete observer for a mobile app client
// receives price updates and formats them like a mobile push notification
public class MobileApp implements Observer {

    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[mobile - " + appName + "] " + stockSymbol + " is now $" + price);
    }
}
