package Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is used to handle the exception and display the level of logger er
 * @author krish
 */

public class LMSLogger {
    //Instance variables.
    private static LMSLogger instance; // instance of itself to make it singleton.
    private final Logger logger;

    // Private constructor to restrict instantiation
    private LMSLogger() {
        logger = Logger.getLogger(LMSLogger.class.getName());
    }

    
    /**
     * Method to get the single instance of the class
     * @return instance
     */
    public static synchronized LMSLogger getInstance() {
        if (instance == null) {
            instance = new LMSLogger();
        }
        return instance;
    }

    /**
     *  Method to log messages
     * @param level
     * @param message 
     */
    public void log(LogLevel level, String message) {
        switch (level) {
            case TRACE:
                logger.log(Level.FINEST, message);
                break;
            case DEBUG:
                logger.log(Level.FINE, message);
                break;
            case INFO:
                logger.log(Level.INFO, message);
                break;
            case WARN:
                logger.log(Level.WARNING, message);
                break;
            case ERROR: 
                logger.log(Level.SEVERE, message);
                break;
        }
    }
    



    /**
     * Method to log exceptions
     * @param e 
     */
    public void logException(Exception e) {
        logger.log(Level.SEVERE, e.getMessage(), e);
    }
    
}
