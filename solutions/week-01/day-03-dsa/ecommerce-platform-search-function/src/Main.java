// runs linear and binary search against the same product catalog
// exercise 2 from Algorithms_Data Structures.docx

public class Main {

    public static void main(String[] args) {

        // unsorted - order doesnt matter for linear search
        Product[] products = {
            new Product(3, "wireless mouse", "electronics"),
            new Product(1, "gaming keyboard", "electronics"),
            new Product(5, "usb hub", "accessories"),
            new Product(2, "monitor stand", "furniture"),
            new Product(4, "webcam", "electronics")
        };

        // sorted by productId - binary search requires this
        Product[] sortedProducts = {
            new Product(1, "gaming keyboard", "electronics"),
            new Product(2, "monitor stand", "furniture"),
            new Product(3, "wireless mouse", "electronics"),
            new Product(4, "webcam", "electronics"),
            new Product(5, "usb hub", "accessories")
        };

        System.out.println("catalog:");
        for (int i = 0; i < products.length; i++) {
            System.out.println("  " + products[i]);
        }

        System.out.println("\n-- linear search (by name) --");
        Product result = LinearSearch.searchByName(products, "webcam");
        System.out.println("webcam       -> " + (result != null ? result : "not found"));

        result = LinearSearch.searchByName(products, "headphones");
        System.out.println("headphones   -> " + (result != null ? result : "not found"));

        System.out.println("\n-- binary search (by id) --");
        Product byId = BinarySearch.searchById(sortedProducts, 3);
        System.out.println("id 3         -> " + (byId != null ? byId : "not found"));

        byId = BinarySearch.searchById(sortedProducts, 6);
        System.out.println("id 6         -> " + (byId != null ? byId : "not found"));
    }
}
