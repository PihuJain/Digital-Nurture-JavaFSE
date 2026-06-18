// concrete strategy for credit card payment
public class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        // only showing last 4 digits - never log full card numbers
        String lastFour = cardNumber.substring(cardNumber.length() - 4);
        System.out.println("paid $" + amount + " using credit card ending in " + lastFour);
    }
}
