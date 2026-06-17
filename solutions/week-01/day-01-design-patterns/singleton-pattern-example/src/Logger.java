// singleton pattern
// only one Logger should exist in the app - multiple loggers means scattered output

public class Logger {

    private static Logger instance;

    // private constructor stops anyone outside calling new Logger()
    // i had this as public initially and the whole pattern broke
    private Logger() {}

    // synchronized so two threads cant both find instance null and each create their own Logger
    public static synchronized Logger getInstance() {
        if (instance == null) {
            Logger obj = new Logger();
            instance = obj;
        }
        return instance;
    }

    // prefix tells you the log level at a glance
    public void log(String message) {
        System.out.println("[LOG]   " + message);
    }

    public void warn(String message) {
        System.out.println("[WARN]  " + message);
    }

    public void error(String message) {
        System.out.println("[ERROR] " + message);
    }
}
