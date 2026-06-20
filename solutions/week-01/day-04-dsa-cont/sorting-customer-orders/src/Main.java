// comparing bubble sort and quick sort on customer orders by price
// exercise 3 from Algorithms_Data Structures.docx

public class Main {

    public static void main(String[] args) {

        Order[] orders1 = {
            new Order(3, "alice", 250.00),
            new Order(1, "bob", 89.99),
            new Order(5, "charlie", 540.00),
            new Order(2, "diana", 175.50),
            new Order(4, "evan", 310.75)
        };

        // separate copy so both start from the same unsorted state
        Order[] orders2 = {
            new Order(3, "alice", 250.00),
            new Order(1, "bob", 89.99),
            new Order(5, "charlie", 540.00),
            new Order(2, "diana", 175.50),
            new Order(4, "evan", 310.75)
        };

        System.out.println("original orders:");
        for (int i = 0; i < orders1.length; i++) {
            System.out.println("  " + orders1[i]);
        }

        BubbleSort.sort(orders1);
        System.out.println("\nafter bubble sort (ascending by price):");
        for (int i = 0; i < orders1.length; i++) {
            System.out.println("  " + orders1[i]);
        }

        QuickSort.sort(orders2, 0, orders2.length - 1);
        System.out.println("\nafter quick sort (ascending by price):");
        for (int i = 0; i < orders2.length; i++) {
            System.out.println("  " + orders2[i]);
        }
    }
}
