package ca.bcit.comp2522.fantasy;

/**
 * Represents an Orc, which is a type of Creature with a rage attribute.
 * An Orc can enter berserk mode, increasing rage and potentially causing self-damage.
 *
 * @author Sukhraj, Arshia, Rodrick, Abdullah
 * @version 1.0
 */
public class Orc extends Creature {

    /** The rage level of the Orc. */
    private int rage;

    /**
     * Constructs an Orc with a name, date of birth, health, and initial rage.
     *
     * @param name the name of the Orc
     * @param dateOfBirth the date of birth of the Orc
     * @param health the initial health of the Orc
     * @param rage the initial rage level; must be >= 0
     * @throws IllegalArgumentException if rage is negative
     */
    public Orc(final String name, final Date dateOfBirth, final int health, int rage) {
        super(name, dateOfBirth, health);
        if (rage < 0) {
            throw new IllegalArgumentException("Rage cannot be negative");
        }
        this.rage = rage;
    }

    /**
     * Prints the details of the Orc, including inherited creature details and rage.
     */
    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("Rage: " + rage);
    }

    /**
     * Increases the Orc's rage by 5. If rage exceeds 20, the Orc takes 30 damage.
     * Throws an exception if rage is below 5.
     *
     * @throws LowRageException if rage is below 5
     */
    public void berserk() {
        rage += 5;
        if (rage > 20) {
            super.takeDamage(30);
        } else if (rage < 5) {
            throw new LowRageException("Rage cannot be below 5");
        }
    }
}
