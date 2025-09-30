package ca.bcit.comp2522.fantasy;

/**
 * Represents a Creature in the fantasy world with a name, date of birth, and health.
 * Provides methods to manage health, calculate age, and display creature details.
 * Health is capped between MIN_HEALTH and MAX_HEALTH.
 *
 * @author Sukhraj, Arshia, Rodrick, Abdullah
 * @version 1.1
 */
public class Creature {

    /** The name of the creature. */
    private final String name;

    /** The date of birth of the creature. */
    private final Date dateOfBirth;

    /** The current health of the creature. */
    private int health;

    /** The current year used to calculate age. */
    private static final int CURRENT_YEAR = 2025;

    /** Maximum health a creature can have. */
    private static final int MAX_HEALTH = 100;

    /** Minimum health a creature can have. */
    private static final int MIN_HEALTH = 0;

    /**
     * Constructs a Creature with a specified name, date of birth, and initial health.
     *
     * @param name the name of the creature; must not be null or blank
     * @param dateOfBirth the date of birth of the creature
     * @param health the initial health of the creature; must be >= MIN_HEALTH
     * @throws IllegalArgumentException if name is null or blank, or health is negative
     */
    public Creature(final String name, final Date dateOfBirth, final int health) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name can not be empty.");
        }

        if (health < MIN_HEALTH) {
            throw new IllegalArgumentException("health can not be negative.");
        }

        this.name = name;
        this.health = health;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Checks if the creature is alive.
     *
     * @return true if health > MIN_HEALTH, false otherwise
     */
    public boolean isAlive() {
        return health > MIN_HEALTH;
    }

    /**
     * Applies damage to the creature, reducing its health.
     * Health cannot drop below MIN_HEALTH.
     *
     * @param damage the amount of damage to apply; must not be negative
     * @throws DamageException if damage is negative
     */
    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new DamageException("Damage can not be negative");
        }
        health -= damage;
        if (health < MIN_HEALTH) {
            health = MIN_HEALTH;
        }
    }

    /**
     * Heals the creature by a specified amount.
     * Health cannot exceed MAX_HEALTH.
     *
     * @param healAmount the amount to heal; must not be negative
     * @throws HealingException if healAmount is negative
     */
    public void heal(int healAmount) {
        if (healAmount < 0) {
            throw new HealingException("Heal amount can not be negative");
        }

        health += healAmount;

        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }

    /**
     * Returns the age of the creature in years based on CURRENT_YEAR.
     *
     * @return the age in years
     */
    public int getAgeYears() {
        return CURRENT_YEAR - dateOfBirth.getYear();
    }

    /**
     * Prints the details of the creature including name, date of birth, age, and health.
     */
    public void getDetails() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth.getYYYYMMDD());
        System.out.println("Age: " + getAgeYears());
        System.out.println("Health: " + health);
    }
}
