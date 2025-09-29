package ca.bcit.comp2522.fantasy;

/**
 * Exception thrown when an Orc's rage falls below the minimum required level
 * to perform certain actions.
 *
 * @author Sukhraj, Arshia, Rodrick, Abdullah
 * @version 1.0
 */
public class LowRageException extends RuntimeException {

    /**
     * Constructs a LowRageException with the specified detail message.
     *
     * @param message the detail message explaining the exception
     */
    public LowRageException(String message) {
        super(message);
    }
}
