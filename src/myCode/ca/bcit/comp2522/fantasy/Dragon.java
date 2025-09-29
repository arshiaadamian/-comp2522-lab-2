package ca.bcit.comp2522.fantasy;

/**
 * Represents a Dragon, which is a type of Creature with additional firepower.
 * A Dragon can breathe fire at other creatures and restore its firepower.
 * Firepower is capped between 0 and 100.
 *
 * @author Sukhraj, Arshia, Rodrick, Abdullah
 * @version 1.0
 */
public class Dragon extends Creature {

    /** The firepower of the dragon (0 - 100). */
    private int firePower;

    /**
     * Constructs a Dragon with a name, date of birth, health, and firepower.
     *
     * @param name the name of the dragon
     * @param dateOfBirth the date of birth of the dragon
     * @param health the initial health of the dragon
     * @param firePower the initial firepower; must be between 0 and 100
     * @throws IllegalArgumentException if firePower is out of bounds
     */
    public Dragon(String name, Date dateOfBirth, int health, int firePower) {
        super(name, dateOfBirth, health);
        if (firePower < 0 || firePower > 100) {
            throw new IllegalArgumentException("firePower must be between 0 and 100");
        }
        this.firePower = firePower;
    }

    /**
     * Prints the details of the dragon, including inherited creature details
     * and firepower.
     */
    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("Fire Power: " + firePower);
    }

    /**
     * Allows the dragon to breathe fire at a target creature.
     * Reduces the dragon's firepower by 10 and deals 20 damage to the target.
     *
     * @param target the creature to attack
     * @throws LowFirePowerException if firepower is less than 10
     */
    public void breatheFire(Creature target) throws LowFirePowerException {
        if (firePower < 10) {
            throw new LowFirePowerException("Not enough fire power to breathe fire (need >= 10).");
        }
        firePower -= 10;
        target.takeDamage(20);
    }

    /**
     * Restores the dragon's firepower by a specified amount.
     * Firepower cannot exceed 100.
     *
     * @param amount the amount to restore; must be non-negative
     * @throws IllegalArgumentException if amount is negative
     */
    public void restoreFirePower(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be non-negative");
        }
        firePower = Math.min(100, firePower + amount);
    }

    /**
     * Returns the current firepower of the dragon.
     *
     * @return the firepower as an int
     */
    public int getFirePower() {
        return firePower;
    }
}
