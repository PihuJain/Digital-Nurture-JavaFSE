// recursive approach to compound growth prediction
// each call applies one period of growth and passes the result forward

public class ForecastCalculator {

    public static double calculateFutureValue(double amount, double growthRate, int years) {
        if (years == 0) {
            return amount;
        }
        double grownAmount = amount * (1 + growthRate);
        return calculateFutureValue(grownAmount, growthRate, years - 1);
    }
}
