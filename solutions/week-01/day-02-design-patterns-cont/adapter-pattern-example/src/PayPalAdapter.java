// wraps PayPalGateway so it looks like a PaymentProcessor to the rest of the app
// the adapter sits in between and translates one interface into the other
public class PayPalAdapter implements PaymentProcessor {

    private PayPalGateway gateway;

    public PayPalAdapter(PayPalGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}
