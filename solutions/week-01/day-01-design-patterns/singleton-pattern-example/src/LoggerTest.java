// testing that getInstance() always returns the same object and not a new one each time

public class LoggerTest {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // printing both just to see what they look like before running the actual check
        System.out.println("logger1 = " + logger1);
        System.out.println("logger2 = " + logger2);
        System.out.println();

        System.out.println("=== singleton test ===\n");

        // == checks reference equality - we wanna confirm its the same object in memory
        // .equals() would check value equality which isnt the right test here
        if (logger1 == logger2) {
            System.out.println("pass - both variables point to the same instance");
            System.out.println("hashcode: " + logger1.hashCode());
        } else {
            System.out.println("fail - got two different Logger objects");
        }

        System.out.println("\n=== sample output ===");
        logger1.log("application started");
        logger1.warn("config not found using defaults");
        logger2.error("database timeout");
        logger2.log("retry succeeded");
    }
}
