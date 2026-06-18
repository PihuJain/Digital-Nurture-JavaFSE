// shows switching strategy at runtime without changing any code in PaymentContext
public class Main {

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment("1234567890123456"));

        System.out.println("first order - paying by card:");
        context.executePayment(59.99);

        // switch to paypal at runtime - context doesnt need to change at all
        context.setStrategy(new PayPalPayment("user@email.com"));
        System.out.println("\nsecond order - switched to paypal:");
        context.executePayment(120.00);
    }
}
