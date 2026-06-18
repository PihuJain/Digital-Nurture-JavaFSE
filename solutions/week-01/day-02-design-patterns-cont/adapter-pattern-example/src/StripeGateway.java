// stripe's library calls it executeCharge not processPayment
// again pretending we cant change this class
public class StripeGateway {

    public void executeCharge(double amount) {
        System.out.println("stripe: charging $" + amount + " to card");
    }
}
