// pretend this is an existing 3rd party paypal library we cant change
// it has its own method name that doesnt match our PaymentProcessor interface
public class PayPalGateway {

    public void makePayment(double amount) {
        System.out.println("paypal: processing payment of $" + amount);
    }
}
