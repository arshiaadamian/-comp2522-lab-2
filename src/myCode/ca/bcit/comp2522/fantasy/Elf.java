package ca.bcit.comp2522.fantasy;

public class Elf extends Creature
{
    private int mana;
    private String name;
    private Date dateOfBirth;
    private int health;

    public Elf (String name, Date dateOfBirth, int health, int mana)
    {
        super(name, dateOfBirth, health);
        if (mana > 50 || mana < 0)
        {
            throw new IllegalArgumentException("mana must be between 0 and 50");
        }
        this.mana = mana;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
    }

    @Override
    public void getDetails()
    {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth.getYYYYMMDD());
        System.out.println("Age: " + getAgeYears());
        System.out.println("Health: " + health);
        System.out.println("Mana: " + mana);
    }

    public void castSpell(Creature that) throws LowManaException {
        if (mana < 5)
        {
            throw new LowManaException("mana is less than 5");
        }
        mana -= 5;
        that.takeDamage(10);
    }

    public void restoreMana (int amount)
    {
        mana += amount;
        if (mana < 50)
        {
            mana = 50;
        }
    }
}
