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

    /** The firepower of the dragon. */
    private int firePower;

    /** Maximum firepower. */
    private static final int MAX_FIRE_POWER = 100;

    /** Minimum firepower required to breathe fire. */
    private static final int MIN_FIRE_POWER_TO_ATTACK = 10;

    /** Firepower cost per attack. */
    private static final int FIRE_ATTACK_COST = 10;

    /** Damage dealt by fire attack. */
    private static final int FIRE_ATTACK_DAMAGE = 20;

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
        if (firePower < 0 || firePower > MAX_FIRE_POWER) {
            throw new IllegalArgumentException("firePower must be between 0 and " + MAX_FIRE_POWER);
        }
        this.firePower = firePower;
    }

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("Fire Power: " + firePower);
    }

    /**
     * Allows the dragon to breathe fire at a target creature.
     * Reduces the dragon's firepower and deals damage to the target.
     *
     * @param target the creature to attack
     * @throws LowFirePowerException if firepower is below minimum required
     */
    public void breatheFire(Creature target) throws LowFirePowerException {
        if (firePower < MIN_FIRE_POWER_TO_ATTACK) {
            throw new LowFirePowerException("Not enough fire power to breathe fire (need >= "
                    + MIN_FIRE_POWER_TO_ATTACK + ").");
        }
        firePower -= FIRE_ATTACK_COST;
        target.takeDamage(FIRE_ATTACK_DAMAGE);
    }

    /**
     * Restores the dragon's firepower by a specified amount.
     * Firepower cannot exceed MAX_FIRE_POWER.
     *
     * @param amount the amount to restore; must be non-negative
     * @throws IllegalArgumentException if amount is negative
     */
    public void restoreFirePower(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be non-negative");
        }
        firePower = Math.min(MAX_FIRE_POWER, firePower + amount);
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
