// concrete observer for a web app client
public class WebApp implements Observer {

    private String siteName;

    public WebApp(String siteName) {
        this.siteName = siteName;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[web - " + siteName + "] price update: " + stockSymbol + " -> $" + price);
    }
}
