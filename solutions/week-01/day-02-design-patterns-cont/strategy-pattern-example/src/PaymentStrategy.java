// strategy pattern - exercise 8
// instead of a big if-else chain deciding which payment method to call
// each method becomes its own class and gets swapped in at runtime
public interface PaymentStrategy {
    void pay(double amount);
}
