package ca.bcit.comp2522.fantasy;


public class Creature
{
    private final String name;
    private final Date dateOfBirth;
    private int health;
    private final static int CURRENT_YEAR = 2025;

    public Creature (final String name, final Date dateOfBirth, final int health)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name can not be empty.");
        }

        if (health < 0)
        {
            throw new IllegalArgumentException("health can not be negative.");
        }

        this.name = name;
        this.health = health;
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isAlive()
    {
        return health > 0;
    }

    public void takDamage(int damage)
    {
        if (damage < 0)
        {
            throw new DamageException("Damage can not be negative");
        }
        health -= damage;
        if (health < 0)
        {
            health = 0;
        }
    }

    public void heal(int healAmount)
    {
        if (healAmount < 0)
        {
            throw new HealingException("Heal amount can not be negative");
        }

        health += healAmount;

        if (health > 100)
        {
            health = 100;
        }
    }

    public int getAgeYears()
    {
        final int age;
        age = CURRENT_YEAR - dateOfBirth.getYear();

        return age;
    }

    public void getDetails()
    {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth.getYYYYMMDD());
        System.out.println("Age: " + getAgeYears());
        System.out.println("Health: " + health);
    }
}
