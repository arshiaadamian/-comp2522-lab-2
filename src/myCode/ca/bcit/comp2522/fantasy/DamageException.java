package ca.bcit.comp2522.fantasy;

/**
 * Exception thrown when an invalid damage value is applied to a Creature.
 * Damage cannot be negative.
 *
 * @author Sukhraj, Arshia, Rodrick, Abdullah
 * @version 1.0
 */
public class DamageException extends RuntimeException {

    /**
     * Constructs a DamageException with the specified detail message.
     *
     * @param message the detail message explaining the exception
     */
    public DamageException(String message) {
        super(message);
    }
}
