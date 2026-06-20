// financial forecasting - exercise 7 from Algorithms_Data Structures.docx
// predicts future investment value using a recursive algorithm

public class Main {

    public static void main(String[] args) {
        double principal = 10000.0;
        double rate = 0.08;

        System.out.println("principal: " + principal);
        System.out.println("annual growth rate: 8%");
        System.out.println();

        for (int year = 1; year <= 5; year++) {
            double value = ForecastCalculator.calculateFutureValue(principal, rate, year);
            System.out.println("year " + year + " -> " + value);
        }
    }
}
