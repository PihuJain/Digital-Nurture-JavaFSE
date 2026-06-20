// bubble sort by totalPrice ascending
// each pass bubbles the largest unsorted element to its correct position
// noticed you can exit early if no swaps happened in a pass but kept it simple for now

public class BubbleSort {

    public static void sort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
}
