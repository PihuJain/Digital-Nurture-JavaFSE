// adapter pattern - exercise 4
// problem: two payment gateways each have their own method name
// calling code shouldnt have to know which gateway its talking to
public interface PaymentProcessor {
    void processPayment(double amount);
}
