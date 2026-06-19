// binary search by productId
// array must be sorted by id before calling this or results will be silently wrong

public class BinarySearch {

    public static Product searchById(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            // left + (right - left) / 2 gives the same midpoint as (left + right) / 2
            // but avoids overflow if both values are near the int limit
            int mid = left + (right - left) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}
