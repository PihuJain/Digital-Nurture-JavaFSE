// concrete strategy for paypal payment
public class PayPalPayment implements PaymentStrategy {

    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("paid $" + amount + " via paypal account: " + email);
    }
}
