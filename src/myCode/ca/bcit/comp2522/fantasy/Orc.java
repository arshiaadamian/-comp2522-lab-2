package ca.bcit.comp2522.fantasy;

public class Orc extends Creature
{
    public Orc (final String name, final Date dateOfBirth, final int health, int rage)
    {
        super (name, dateOfBirth, health);
        if (rage < 0)
        {
            throw new IllegalArgumentException("Rage cannot be negative");
        }

        @Override;
    }
}
