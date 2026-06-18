// same idea as PayPalAdapter but for stripe
// stripe's own library calls the method executeCharge so thats what gets delegated to here
public class StripeAdapter implements PaymentProcessor {

    private StripeGateway gateway;

    public StripeAdapter(StripeGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        gateway.executeCharge(amount);
    }
}
