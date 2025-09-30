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

    /** Amount rage increases per berserk. */
    private static final int RAGE_INCREASE = 5;

    /** Rage threshold that causes self-damage. */
    private static final int MAX_SAFE_RAGE = 20;

    /** Self-damage when rage exceeds threshold. */
    private static final int SELF_DAMAGE = 30;

    /** Minimum rage required to berserk. */
    private static final int MIN_RAGE = 5;

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

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("Rage: " + rage);
    }

    /**
     * Increases the Orc's rage by a fixed amount. If rage exceeds MAX_SAFE_RAGE,
     * the Orc takes SELF_DAMAGE. Throws an exception if rage is below MIN_RAGE.
     *
     * @throws LowRageException if rage is below MIN_RAGE
     */
    public void berserk() {
        rage += RAGE_INCREASE;
        if (rage > MAX_SAFE_RAGE) {
            super.takeDamage(SELF_DAMAGE);
        } else if (rage < MIN_RAGE) {
            throw new LowRageException("Rage cannot be below " + MIN_RAGE);
        }
    }
}
