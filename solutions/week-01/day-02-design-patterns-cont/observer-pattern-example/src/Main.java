// registers two observers then deregisters one mid-run
// third price update should only print for the mobile app to confirm removal worked
public class Main {

    public static void main(String[] args) {
        StockMarket market = new StockMarket("AAPL");

        Observer mobileApp = new MobileApp("StockWatch");
        Observer webApp = new WebApp("finance-tracker.com");

        market.register(mobileApp);
        market.register(webApp);

        System.out.println("price update 1:");
        market.setPrice(189.50);

        System.out.println("\nprice update 2:");
        market.setPrice(192.30);

        // deregister web app - should stop receiving updates from here
        System.out.println("\nderegistering web app...");
        market.deregister(webApp);

        System.out.println("\nprice update 3 (only mobile should see this):");
        market.setPrice(195.00);
    }
}
