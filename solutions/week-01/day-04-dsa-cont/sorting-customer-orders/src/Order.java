// order for the sorting exercise
// totalPrice is the field we sort by in both algorithms

public class Order {

    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return orderId + " | " + customerName + " | " + totalPrice;
    }
}
