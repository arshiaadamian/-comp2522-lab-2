package ca.bcit.comp2522.fantasy;

/**
 * Exception thrown when a Dragon does not have enough firepower
 * to perform a fire-breathing action.
 *
 *
 * @author Sukhraj, Arshia, Rodrick, Abdullah
 * @version 1.0
 */
public class LowFirePowerException extends Exception {

    /**
     * Constructs a LowFirePowerException with no detail message.
     */
    public LowFirePowerException() {
        super();
    }

    /**
     * Constructs a LowFirePowerException with the specified detail message.
     *
     * @param message the detail message explaining the exception
     */
    public LowFirePowerException(String message) {
        super(message);
    }
}
