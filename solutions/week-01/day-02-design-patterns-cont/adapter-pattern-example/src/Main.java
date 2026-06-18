// the calling code only ever sees PaymentProcessor
// PayPalGateway and StripeGateway are never referenced here directly
// swapping adapters changes the payment method with no other changes needed
public class Main {

    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());

        System.out.println("checkout with paypal:");
        paypal.processPayment(149.99);

        System.out.println("\ncheckout with stripe:");
        stripe.processPayment(149.99);
    }
}
