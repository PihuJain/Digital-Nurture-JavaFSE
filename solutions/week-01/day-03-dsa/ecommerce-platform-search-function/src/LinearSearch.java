// linear search by product name
// no sorting needed - checks each element from the start until it finds a match

public class LinearSearch {

    public static Product searchByName(Product[] products, String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(name)) {
                Product match = products[i];
                return match;
            }
        }
        return null;
    }
}
