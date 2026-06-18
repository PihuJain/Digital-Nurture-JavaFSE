// observer pattern - exercise 7
// multiple clients need to hear about every stock price change
// without this the subject would hardcode calls to each client directly
// adding a new listener type would mean touching the subject class which is wrong
public interface Stock {
    void register(Observer observer);
    void deregister(Observer observer);
    void notifyObservers();
}
