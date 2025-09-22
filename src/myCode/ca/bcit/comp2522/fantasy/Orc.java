package ca.bcit.comp2522.fantasy;

public class Orc extends Creature
{
    private int rage;
    public Orc (final String name, final Date dateOfBirth, final int health, int rage)
    {
        super (name, dateOfBirth, health);
        if (rage < 0)
        {
            throw new IllegalArgumentException("Rage cannot be negative");
        }
        this.rage = rage;
    }

    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Rage: " + rage);
    }

    public void bersek() {
        rage += 5;
        if (rage > 20)
        {
            super.takeDamage(30);
        }
        else if (rage < 5)
        {
            throw new LowRageException("Rage cannot be below 5");
        }
    }


}
