// concrete subject - holds the observer list and notifies everyone when price changes
import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private String stockSymbol;
    private double price;

    public StockMarket(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public void setPrice(double price) {
        this.price = price;
        // price changed so everyone watching needs to know
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, price);
        }
    }
}
