package ca.bcit.comp2522.fantasy;

/**
 * Exception thrown when an invalid healing value is applied to a Creature.
 * Healing amount cannot be negative.
 *
 * @author Sukhraj, Arshia, Rodrick, Abdullah
 * @version 1.0
 */
public class HealingException extends RuntimeException {

    /**
     * Constructs a HealingException with the specified detail message.
     *
     * @param message the detail message explaining the exception
     */
    public HealingException(String message) {
        super(message);
    }
}
