// anything that wants to receive stock price updates implements this
public interface Observer {
    void update(String stockSymbol, double price);
}
